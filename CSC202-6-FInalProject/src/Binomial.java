/**
 * Created by admin on 4/21/2015.
 */

//coefficients method is not yet completed.
public class Binomial extends IncompleteBeta {

    public static double answer;
    public static double[] coeff;

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

    public static double[] coefficients(int n) {
        int[] arrA = new int[n+1];
        for (int i = 0; i < arrA.length; i++) {
            int k = arrA[i];
            answer = combinations(n, k);
            coeff[i] = answer;
        }
        return coeff[];
    }

    public static double probability(int n, int k, double p) {
        if (k > n) {
            answer = 0.0;
        } else
            answer = combinations(n, k) * ((Math.pow(p,k)) * (Math.pow((1-p),(n-k))));
        return answer;
    }

    public static double cumulativeProbability(int n, int k, double p) {
        if (k > n)
            answer = 0.0;
        else {
            try {
                answer = incompleteBeta(k, (n - k + 1), p);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
