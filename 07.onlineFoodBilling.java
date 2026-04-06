import java.util.*;
import java.util.stream.Collectors;
interface fooditem{
    int calc(int p,int q);
}
public class onlineFoodBilling {
    private static List<Map.Entry<String, Integer>> getFilteredAndSortedMenu(Map<String, Integer> menu, String searchText) {
        String normalizedSearch = searchText.toLowerCase(Locale.ROOT);

        return menu.entrySet().stream()
                .filter(entry -> normalizedSearch.isEmpty() || entry.getKey().toLowerCase(Locale.ROOT).contains(normalizedSearch))
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
    }

    private static List<String> buildBillLines(Map<String, Integer> menu, Map<String, Integer> cart) {
        return cart.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> {
                    int itemTotal = menu.get(entry.getKey()) * entry.getValue();
                    return String.format("%s x %d = Rs.%d", entry.getKey(), entry.getValue(), itemTotal);
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<String,Integer> menu=new LinkedHashMap<>();
        menu.put("pizza", 280);
        menu.put("burger", 120);
        menu.put("pasta", 150);
        menu.put("sandwich", 100);
        menu.put("coke", 50);
        System.out.println("Welcome to online food ordering:");

        fooditem bill=(p,q)->p*q;
        Map<String, Integer> cart = new LinkedHashMap<>();

        while(true){
            System.out.println("\nMenu:");
            System.out.print("Search menu items (press Enter for all): ");
            String searchText = sc.nextLine();

            List<Map.Entry<String, Integer>> visibleMenu = getFilteredAndSortedMenu(menu, searchText);

            if (visibleMenu.isEmpty()) {
                System.out.println("No items matched your search.");
            }

            for(Map.Entry<String,Integer> entry:visibleMenu){
                System.out.println(entry.getKey()+":rs."+entry.getValue());
            }
            System.out.print("select food item/ type exit to finish:");
            String item=sc.nextLine();
            if(item.equalsIgnoreCase("exit")){
                break;
            }
            item = item.toLowerCase(Locale.ROOT);
            if(menu.containsKey(item)){
                System.out.print("quantity:");
                int quantity=sc.nextInt();
                sc.nextLine();
                cart.put(item, cart.getOrDefault(item, 0) + quantity);
                int total = cart.entrySet().stream()
                        .mapToInt(entry -> bill.calc(menu.get(entry.getKey()), entry.getValue()))
                        .sum();
                System.out.println(quantity+" "+item+" added to cart, total: Rs." + total);
            }
            else{
                System.out.println("invalid item, please select from menu");
            }
        }

        int subtotal = cart.entrySet().stream()
                .mapToInt(entry -> bill.calc(menu.get(entry.getKey()), entry.getValue()))
                .sum();

        System.out.println("\nBill summary:");
        List<String> billLines = buildBillLines(menu, cart);
        for (String line : billLines) {
            System.out.println(line);
        }

        int total = subtotal;
        if(total<250){
            System.out.println("extra 50rs for delivery charge");
            total=total+50;
        }else{
            System.out.println("extra 30rs for delivery charge");
            total=total+30;
        }
        System.out.println("GST:10%");
        total=total+(total*10/100);
        System.out.println("Your total bill is:Rs."+total);
        sc.close();
    }
}
