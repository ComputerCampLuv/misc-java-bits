public class Fraction {

    private int num;
    private int den;

    public Fraction(int num, int den) {

        if (den <= 0) {
            if (den == 0) {
                throw new IllegalArgumentException("Denometor cannot be zero");
            } else {
                Math.abs(den);
                num *= -1;
            }
        }
        this.num = num;
        this.den = den;

    }

    public Fraction(int num) {
        this(num, 1);
    }

    public Fraction(){
        this(0,1);
    }

    //exposes the value of the numerator field to the user
    public int getNumerator(){
        return this.num;
    }

    //exposes the value of the denominator field to the user
    public int getDenominator() {
        return this.den;
    }

    //"numerator/denominator", a String representation of the Fraction
    public String toString() {
        return this.num + "/" + this.den;
    }

    //the result of numerator / denominator
    public double toDouble() {
        return (double) this.num / this.den;
    }

    //returns a new Fraction that is the sum of other and this fractions
    public Fraction add(Fraction other){

        int newDen = this.den * other.den;
        int newNum = (this.num * other.den) + (other.num * this.den);
        Fraction newFrac = new Fraction(newNum, newDen);
        newFrac.toLowestTerms();
        return newFrac;

    }

    //returns a new Fraction that is the difference between the other and this fraction
    public Fraction subtract(Fraction other) {

        int newDen = this.den * other.den;
        int newNum = (this.num * other.den) - (other.num * this.den);
        Fraction newFrac = new Fraction(newNum, newDen);
        newFrac.toLowestTerms();
        return newFrac;

    }

    //returns a new Fraction that is the product of the other and this fraction
    public Fraction multiply(Fraction other) {

        int newDen = this.den * other.den;
        int newNum = (this.num * other.den) * (other.num * this.den);
        Fraction newFrac = new Fraction(newNum, newDen);
        newFrac.toLowestTerms();
        return newFrac;

    }

    //returns a new Fraction that is the division of the other and this fraction, throw an IllegalArgumentException() if the user asks you to divide by 0
    public Fraction divide(Fraction other) {

        int newDen = this.den * other.num;
        int newNum = (this.num * other.num) * (this.den * other.den);
        Fraction newFrac = new Fraction(newNum, newDen);
        newFrac.toLowestTerms();
        return newFrac;

    }

    //must take in an "Object" to properly override the Object class's equals method, but should ultimately check if two fractions are equal
    public boolean equals(Object other) {

        if (!Fraction.class.isAssignableFrom(other.getClass())) {
            return false;
        }
        Fraction otherFrac = (Fraction)other;
        if (otherFrac.toDouble() != this.toDouble()) {
            return false;
        } else {
            return true;
        }

    }

    //converts the current fraction to the lowest terms
    public void toLowestTerms() {

        int gcd = gcd(num, den);
        num /= gcd;
        den /= gcd;

    }

    //takes in two ints and determines the greatest common divisor of the two ints, should be a static method
    public static int gcd(int num, int den) {

        while((num != 0) && (den != 0)) {
            int x = num % den;
            num = den;
            den = x;
        }
        return num;

    }
}
