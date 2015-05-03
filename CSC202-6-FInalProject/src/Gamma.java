/**
 * Created by admin on 4/20/15.
 */
import java.util.Scanner;

/*
    returns the factorial of a real number - overflows easily
 */
public class Gamma {

    public static final int IMAX = 100;
    public static final double ERROR = 1.0e-10;
    public static double[] coef = {76.18009173, -86.50532033, 24.01409822, -1.231739516, 0.120858003e-2, -0.536382e-5};
    public static long[] nHi = new long[21];
    public static double n, temp, sum, var, bar, fact;

    public static double gamma(double a) {
        return Math.exp(logGamma(a));
    }

    public static double gamma(double a, double x) {
        for (int t = 0; t < 9; t++) {
            bar = (Math.pow(x, (a - 1)) * Math.pow(Math.exp(1.0), (-1 * t))) / gamma(a);
        }
        return bar;
    }

    public static double logGamma(double a) {
        if (a < 0) {
            System.exit(0);
        }
        else {
            n = a - 1;
            temp = n + 5.5;
            temp = temp - (n + 0.5) * Math.log(temp);
            sum = 1;
            for (double i : coef) {
                n++;
                sum += i / n;
            }
            var = ((-1) * temp) + Math.log(2.50662827465 * sum);
        }
        return var;
    }

    public static double factorial(double n) {
        int a = 1;
        long comp = 1;

        if (n <= 20) {
            nHi[0] = 1;
            for (int i = 1; i <= n; i++) {
                nHi[i] = nHi[i - 1] * i;
            }
            fact = nHi[(int) n];
        } else if ((n < 0)) {
        throw new java.lang.IllegalArgumentException("Inappropriate argument");
        } else if ((n > 20)) {
            fact = Math.exp(logGamma(n+1));
    }
    return fact;
}

    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter value a: ");
        double a = kb.nextDouble();
        int b = (int) a;
        System.out.println("Gamma(a): " + gamma(a));
        System.out.println("LogGamma(a): " + logGamma(a));
        System.out.println("Factorial(a-1): " + factorial(a));
    }

}


