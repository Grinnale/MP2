import java.io.PrintWriter;
import java.util.Scanner;

public class InteractiveCalculator {

  public static BFCalculator calculator;
  public static void main(String[] args) throws Exception {
    Scanner eyes = new Scanner(System.in);
    PrintWriter pen = new PrintWriter(System.out, true);
    calculator = new BFCalculator();
    String input = eyes.nextLine();
    
    while (!input.equals("QUIT")) {
      calculator.nextCommands(input);
      if (!input.substring(0, 5).equals("STORE")) {
        pen.println(calculator.get());
      }
      input = eyes.nextLine();
    } // while
  }
}
