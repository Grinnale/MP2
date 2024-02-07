import java.io.PrintWriter;

public class Testing {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    /*
    BigFraction f1;
    f1 = new BigFraction(3, 10);
    BigFraction f2;
    f2 = new BigFraction(11, 5);
    pen.println("First fraction: " + f1);
    pen.println("Second fraction: " + f2);
    pen.println("Add: " + (f1.add(f2)));
    pen.println("Multiply: " + (f1.multiply(f2)));
    pen.println("Fractional: " + (f2.fractional()));
    pen.println("Divide: " + (f1.divide(f2)));
    pen.println("Subtract: " + (f1.subtract(f2)));
    */

    BFCalculator c = new BFCalculator();
    c.nextCommands("STORE a");
    c.parse();

  } // main(String[])
}
