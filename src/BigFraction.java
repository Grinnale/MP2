import java.math.BigInteger;

/**
 * A simple implementation of Fractions.
 * 
 * @author Samuel A. Rebelsky
 * @author YOUR NAME HERE
 */
public class BigFraction {
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) Denominators are always positive. Therefore, negative fractions 
   * are represented with a negative numerator. Similarly, if a fraction 
   * has a negative numerator, it is negative.
   * 
   * (2) Fractions are not necessarily stored in simplified form. To 
   * obtain a fraction in simplified form, one must call the `simplify` 
   * method.
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public BigFraction(BigInteger num, BigInteger denom) {
    this.num = num;
    this.denom = denom;
  } // Fraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public BigFraction(int num, int denom) {
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
  } // Fraction(int, int)

  /**
   * Build a new fraction by parsing a string.
   *
   * Warning! Not yet implemented.
   */
  public BigFraction(String str) {
    int bar = str.indexOf('/');
    int length = str.length();
    if (bar == -1) {
      this.num = new BigInteger(str.substring(0, length));
      this.denom = BigInteger.valueOf(1);
    } // if
    else {
      this.num = new BigInteger(str.substring(0, bar));
      this.denom = new BigInteger(str.substring(bar + 1, length));
    } // if
  } // Fraction

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  public BigFraction simplify(){
    BigInteger gcd = this.num.gcd(this.denom);
    BigInteger num = this.num.divide(gcd);
    BigInteger denom = this.denom.divide(gcd);
    return new BigFraction(num, denom);
  }

  public BigFraction fractional() {
    BigInteger remainder = this.num.mod(this.denom);
    return new BigFraction(remainder, this.denom);
  }

  public BigFraction multiply(BigFraction a) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    resultNumerator = this.num.multiply(a.num);
    resultDenominator = this.denom.multiply(a.denom);

    return new BigFraction(resultNumerator, resultDenominator);
  }

  public BigFraction divide(BigFraction a) {
    BigFraction reciprocal = new BigFraction(a.denom, a.num);
    return multiply(reciprocal);
  }

  /**
   * Express this fraction as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()
  public class FractionSum {
  
  }
  
  /**
   * Add the fraction `addMe` to this fraction.
   */
  public BigFraction add(BigFraction addMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the product of this object's 
    // denominator and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator = 
      (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  } // add(Fraction)

  public BigFraction subtract(BigFraction subMe) {
    subMe.num = subMe.num.multiply(BigInteger.valueOf(-1));
    BigFraction negative = new BigFraction(subMe.num, subMe.denom);
    return add(negative);
  }

  /**
   * Get the denominator of this fraction.
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()
  
  /**
   * Get the numerator of this fraction.
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()
  
  /**
   * Convert this fraction to a string for ease of printing.
   */
  public String toString() {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero

    //Special case: Denominator is one
    if (this.denom.equals(BigInteger.ONE)) {
      return this.num.toString();
    }

    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()
} // class Fraction