import java.io.PrintWriter;

public class QuickCalculator {

  public static BFCalculator calculator;
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    calculator = new BFCalculator();
    
    for(int i = 0; i < args.length; i++) {
      calculator.nextCommands(args[i]);
      if (!args[i].substring(0, 5).equals("STORE")) {
        pen.println(args[i] + " = " + calculator.get());
      }
    } // for
  } // main
}
