import javax.script.*;

public class CustomSequenceBuilder {

    public static void main(String[] args) throws Exception {

        String formula = "n*n + 2*n"; // user input

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");

        for (int n = 1; n <= 5; n++) {
            engine.put("n", n);
            Object result = engine.eval(formula);
            System.out.print(result + " ");
        }
    }
}
