/**
 * Created by admin on 4/21/2015.
 */
import java.util.Scanner;

public class Beta extends Gamma {

    public static double beta(double a, double b) {
        return Math.exp(logBeta(a, b));
    }

    public static double beta(double a, double b, double x) {
        return Math.exp((a - 1) * Math.log(x) + (b - 1.0) * Math.log(1.0 - x) - logBeta(a, b));

    }

    public static double logBeta(double a, double b) {
        return logGamma(a) + logGamma(b) - logGamma(a+b);
    }

    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter value a: ");
        double a = kb.nextDouble();
        System.out.println("Enter value b: ");
        double b = kb.nextDouble();
        System.out.println("2-Perimeter Beta Result: " + beta(a, b));
        System.out.println("Enter value x: ");
        double x = kb.nextDouble();
        System.out.println("3-Perimeter Beta Result: " + beta(a, b, x));
    }

}
