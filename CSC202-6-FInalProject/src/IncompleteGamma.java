import java.util.Scanner;

public class IncompleteGamma extends Gamma {

    public static double incompleteGamma(double a, double t) {
        if (a <= 0.0 || t < 0) {
            System.out.println( "Invalid gammaDistribution arguments."); System.exit(0);
        }
        if (t < a + 1) {
            return series(a, t);
        } else {
            return 1.0 - continuousFraction(a, t);
        }
    }

    private static double series(double a, double t) {

        double aPlus = a;
        double term = 1.0/a;
        double sum = term;
        int i;

        for (i = 0; i <= IMAX; i++) {
            aPlus++;
            term = term * t / aPlus;
            sum = sum + term;
        }
        if (Math.abs(term / sum) < ERROR) {

        } else if (IMAX <= i) {
            System.out.println("Not enough iterations");
        }
        return sum * Math.exp(-t + a * Math.log(t) - logGamma(a));
    }

    private static double continuousFraction(double a, double t) {
        double fac = 1.0;
        double a0 = 1.0;
        double b0 = 0.0;
        double a1 = t;
        double b1 = 1.0;
        double gold = 0.0;
        double g = 0.0;
        double ip1ma;
        double ip1;
        int i;

        for (i = 0; i <= IMAX; i++) {
            ip1 = i + 1;
            ip1ma = ip1 - a;
            a0 = (a1 + a0 * ip1ma) * fac;
            b0 = (b1 + b0 * ip1ma) * fac;
            double ip1f = ip1 * fac;
            a1 = t * a0 + ip1f * a1;
            b1 = t * b0 + ip1f * b1;
            if (a1 > 1.0) {         // renormalize
                fac = 1.0 / a1;
                g = b1 * fac;
                if (Math.abs((g - gold) / g) < ERROR) {
                    break;
                } else
                    gold = g;
            }
        }
        if (i >= IMAX) {
            System.out.println("Not enough iterations");
        }
        return g * Math.exp(-t + a * Math.log(t) - logGamma(a));
    }

    public static  double cumulativePoisson(int m, double x) {
        return 1.0 - incompleteGamma(m + 1, x);
    }

    public static double cumulativeNormal(double x) {
        double value = incompleteGamma(0.5, x * x / 2.0);
        if (x > 0) {
            return 0.5 + 0.5 * value;
        } else {
            return 0.5 - 0.5 * value;
        }
    }

    public static double chiSquare(double chiSquared, int degreesFreedom) throws java.lang.IllegalArgumentException {
        if (chiSquared <= 0.0 || degreesFreedom < 1) {
            throw new java.lang.IllegalArgumentException("Inappropriate argument values");
        } else
            return 1.0 - incompleteGamma(0.5 * degreesFreedom, 0.5 * chiSquared);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Select incompleteGamma(1), cumPoisson(2), cumNormal(3), chiSquared(4): ");
        int input = kb.nextInt();

        switch(input) {
            case 1:
                System.out.println("Enter number of sequential random processes: ");
                int a = kb.nextInt();
                System.out.println("Enter normalized time: ");
                int t = kb.nextInt();
                System.out.print("Completion probability = ");
                System.out.println(incompleteGamma(a, t));
                break;
            case 2:
                System.out.println("Enter expected number of events: ");
                int m = kb.nextInt();
                System.out.println("Enter maximum number of events: ");
                int x = kb.nextInt();
                System.out.print("probability of no more than " + x + " events is ");
                System.out.println(cumulativePoisson(m, x));
                break;
            case 3:
                System.out.println("Enter normalized Gaussian argument, x: ");
                x = kb.nextInt();
                System.out.print("Cumulative Normal = " + cumulativeNormal(x));
                break;
            case 4:
                System.out.println("Enter Chi Square value: ");
                m = kb.nextInt();
                System.out.println("Enter degree of freedom: ");
                x = kb.nextInt();
                System.out.print("Chi-Square Probability = " + chiSquare(m, x));
                break;
            default:
                break;
        }
    }

}
