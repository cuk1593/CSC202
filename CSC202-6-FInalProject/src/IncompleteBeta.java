/**
 * Created by admin on 4/20/15.
 */

//studentT method is not returning correct value
import java.util.Scanner;

public class IncompleteBeta extends Beta {

    public static double incompleteBeta(double a, double b, double x) throws Exception {
        double z = 0;
        if ((x < 0) || (x > 1.0)) {
            throw new IllegalStateException("x must be 0<x<1.0");
        } else if ((x == 0.0) || (x == 1.0)) {
            double multiplier = 0.0;
        } else {
            double multiplier = Math.exp(a * Math.log(x) + b * Math.log(1.0 - x) - logBeta(a, b));
            if ((x < ((a + 1.0) / (a + b + 2.0))) && (a > 0)) {
                z = multiplier * continuousFraction(a, b, x) / a;
                return z;
            } else
                z = 1.0 - multiplier * continuousFraction(b, a, (1.0 - x)) / b;
                return z;
        }
        return z;
    }

    private static double continuousFraction(double a, double b, double x) throws Exception {
        double di;
        double ap1 = (a + 1.0);
        double am1 = (a - 1.0);
        double apb = (a + b);
        double az = 1.0;
        double am = 1.0;
        double bz = 1.0 - apb * x / ap1;
        double bm = 1.0;
        double ap, bp, app, bpp, aOld;
        int i;

        for (i = 1; i <= IMAX; i++) {
            di = i;
            double twoI = i + i;
            double numerator = di * (b - di) * x / ((am1 + twoI) * (a + twoI));
            ap = az + numerator * am;
            bp = bz + numerator * bm;
            numerator = (-1 * (a+di)) * (apb + di) * x / ((ap1 + twoI) * (a + twoI));
            app = ap + numerator * az;
            bpp = bp + numerator * bz;
            aOld = az;
            am = ap / bpp;
            bm = bp / bpp;
            az = app / bpp;
            bz = 1.0;
            if (Math.abs(az - aOld) < ERROR * Math.abs(az)) {
                break;
            }
        }

        if (i > IMAX) {
            throw new Exception("Excessive error");
        }
        return az;
    }

    public static double studentT(int degFreedom, double t) throws Exception {
        double x = degFreedom / (degFreedom + t * t);
        return incompleteBeta(0.5 * degFreedom, 0.5, x);
    }

    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(System.in);
        System.out.println("Select Incomplete Beta (1) or StudentT(2): ");
        int n = kb.nextInt();
        double j, k, l;
        int m;

        switch(n) {
            case 1:
                System.out.println("Enter value a: ");
                j = kb.nextDouble();
                System.out.println("Enter value b: ");
                k = kb.nextDouble();
                System.out.println("Enter value x: ");
                l = kb.nextDouble();
                System.out.print("incompleteBeta(double " + j + ", double " + k + ", int " + l + "): ");
                System.out.println(incompleteBeta(j, k, l));
                break;
            case 2:
                System.out.println("Enter value a: ");
                m = kb.nextInt();
                System.out.println("Enter value b: ");
                j = kb.nextDouble();
                System.out.print("studentT(int " + m + ", double " + j + "): ");
                System.out.println(studentT(m, j));
                break;
            default:
                break;
        }
    }
}
