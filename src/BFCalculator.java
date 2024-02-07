import java.io.PrintWriter;

public class BFCalculator {

  public BigFraction current;//the current or last value in the calculator
  public String commands;//all commands for the calculator to execute
  public String operation;
  public int instruction;
  public Registers register;

  PrintWriter pen = new PrintWriter(System.out, true);

  public BFCalculator() {
    this.current = new BigFraction(0, 1);
    this.operation = "+";
    this.instruction = 0;
    this.register = new Registers();
  }

  public void parse(){
    int space = commands.indexOf(" ");
    while (space != -1) {
      String next = commands.substring(0, space);
      process(next);
      commands = commands.substring(space + 1, commands.length());
      instruction ++;
      space = commands.indexOf(" ");
    } // while
    if(instruction != -1) {
      process(commands);
    }
    current = current.simplify();
    instruction = 0;
  }


  public void process(String next){
    if (instruction == 0) {
      if (next.equals("STORE")) {
        register.store(commands.charAt(6), current);
        instruction = instruction - 2;
      }
      else {
        clear();
      }
    } // if
    if (instruction % 2 == 1) { // expecting an operation
      if(next.equals("+") || next.equals("-") || next.equals("*") || next.equals("/")) {
        operation = next;
      } // if
      else {
        pen.println("Two numbers in a row");
      } // else
    } // else if
    else if (instruction >= 0) { // expecting a number
      if(next.equals("+") || next.equals("-") || next.equals("*") || next.equals("/")) {
        pen.println("Two operations in a row");
      } // if
      BigFraction n;
      char c = next.charAt(0);
      if(c >= 97 && c <= 122) {
        n = register.get(c);
      }
      else {
        n = new BigFraction(next);
      }
      if (operation.equals("+")) {
        add(n);
      }
      else if (operation.equals("-")) {
        subtract(n);
      }
      else if (operation.equals("*")) {
        multiply(n);
      }
      else if (operation.equals("/")) {
        divide(n);
      }
    } // else
  }

  public void nextCommands(String cms) {
    this.commands = cms;
    parse();
  }

  //gets the last computed value
  public BigFraction get() {
    return current;
  }

  //adds val to the last computed value.
  public void add(BigFraction val) {
    this.current = current.add(val);
  }

  //subtracts val from the last computed value.
  public void subtract(BigFraction val) {
    this.current = current.subtract(val);
  }

  //multiplies the last computed value by val.
  public void multiply(BigFraction val) {
    this.current = current.multiply(val);
  }

  //divides the last computed value by val.
  public void divide(BigFraction val) {
    this.current = current.divide(val);
  }

  //resets the last computed value to 0.
  public void clear() {
    this.current = new BigFraction(0, 1);
  }
}
