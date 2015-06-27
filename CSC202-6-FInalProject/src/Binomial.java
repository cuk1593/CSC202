/**
 * Created by admin on 4/21/2015.
 */

import java.util.Scanner;

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
        int k;
        double[] coef = new double[n+1];

        for (k = 0; k <= n; k++) {
            coef[k] = combinations(n, k);
        }
        return coef;
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
        Scanner kb = new Scanner(System.in);
        int n, k;
        double[] coefArray;
        double p;
        System.out.println("Select coefficients(1) or probability(2): ");
        int c = kb.nextInt();

        switch (c) {
            case 1:
                System.out.println("Enter order: ");
                n = kb.nextInt();
                coefArray = new double[n+1];
                coefArray = coefficients(n);
                for (k = 0; k <= n; k++) {
                    System.out.println(coefArray[k]);
                }
                break;
            case 2:
                System.out.println("Enter total number of trials: ");
                n = kb.nextInt();
                System.out.print("Enter successes or minimum successes: ");
                k = kb.nextInt();
                System.out.print("Enter single-trial probability: ");
                p = kb.nextDouble();
                System.out.println("Probability of " + k + " successes = " + probability(n, k, p));
                System.out.println("Probability of at least " + k + " successes = " + cumulativeProbability(n, k, p));
                break;
            default:
                System.out.println("Improper selection.");
        }
    }

}
