import java.util.Random;
public class RandomSumAndProduct {
    /**
     * This function simply welcomes the user.
     */
    public static void welcome() {
        System.out.println("************************");
        System.out.println("    RANDMOMNESS V1.0");
        System.out.println("************************");
    }
    /**
     * This function computes the sum of three integers
     * @param a the first of the three numbers
     * @param b the second of the three numbers
     * @param c the third of the three numbers
     * @return the sum of a, b and c
     */
    public static int computeSum(int a, int b, int c) {
        int total = a + b + c;
        return total;
    }
   /**
     * This function computes the product of three integers
     * @param a the first of the three numbers
     * @param b the second of the three numbers
     * @param c the third of the three numbers
     * @return the product of a, b and c
     */
 
    public static int computeProduct(int a , int b, int c) {
        int product = a * b * c;
        return product;
    }
    public static void main(String[] args) {
        welcome();
        Random rnd = new Random();
        int x1, x2, x3;
        x1 = rnd.nextInt(25);
        x2 = rnd.nextInt(25);
        x3 = rnd.nextInt(25);
        int sum = computeSum(x1,x2,x3);
        int prod = computeProduct(x1,x2,x3);
        System.out.printf("The sum of %d, %d and %d is %d.\n", x1,x2,x3,sum);
        System.out.println("Their product is " + prod + ".");
    }
}
