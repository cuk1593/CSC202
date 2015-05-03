/**
 * Created by admin on 4/21/2015.
 */
public class Binomial extends IncompleteBeta {

    public static double combinations(int n, int k) {
        double logCoef;
        double coef;
        if ((k < 0) || (k > n)) {
            System.out.println("Argument out of range");
            System.exit(0);
        } else {
            logCoef = logGamma(n + 1) - logGamma(k + 1) - logGamma(n - k + 1);
            coef = Math.exp(logCoef);
            return Math.round(coef);
        }
        return 0;
    }
/**
    public static double[] coefficients(int n) {
        double[] arrA = new double[n+1];
        for (int i = 0; i < arrA.length; i++) {

        }
    }

    public static double probability(int n, int k, double p) {

    }

    public static double cumulativeProbability(int n, int k, double p) {

    }

    public static void main(String[] args) {

    }
 **/
}
