import java.io.PrintWriter;

public class QuickCaluculator {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println("There are " + args.length + " command-line arguments.");
    for (int i = 0; i < args.length; i++) {
      pen.printf("%2d: %s\n", i, args[i]);
    } // for
  } // main
}
