public class Registers {
  BigFraction[] storage;

  public Registers() {
    storage = new BigFraction[26];
  }


  //retrieves the value from the given register.
  public BigFraction get(char register) {
    int index = register - 97;
    return storage[index];
  }


  //stores the given value in the specified register.
  public void store(char register, BigFraction val) {
    int index = register - 97;
    storage[index] = val;
  }
}
