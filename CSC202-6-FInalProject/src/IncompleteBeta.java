/**
 * Created by admin on 4/20/15.
 */
public class IncompleteBeta extends Beta {

    public static double incompleteBeta(double a, double b, double x) {
        if ((x < 0) || (x > 1.0)) {
            throw new IllegalStateException("x must be 0<x<1.0");
            System.exit(0);
        } else if ((x == 0.0) || (x == 1.0)) {
            double multiplier = 0.0;
        } else {
            double multiplier = Math.exp(a * Math.log(x) + b * Math.log(1.0 - x) - logBeta(a, b));
            if ((x < ((a + 1.0) / (a + b + 2.0))) && (a > 0)) {
                return multiplier * continuousFraction(a, b, x) / a;
            } else
                return 1.0 - multiplier * continuousFraction(b, a, (1.0 - x)) / b;
        }
    }

    private static double continuousFraction(double a, double b, double x) throws Exception {
        double ap1 = (a + 1.0);
        double am1 = (a - 1.0);
        double apb = (a + b);
        double az = 1.0;
        double am = 1.0;
        double bz = 1.0 - apb * x / ap1;
        double bm = 1.0;
        double ap, bp, app, bpp, aOld;
        int i;

        for (i = 1; i <= IMAX, i++) {
            double twoI = i + i;
            double numerator = i * (b - 1) * x / ((am1 + twoI) * (a + twoI));
            ap = az + numerator * am;
            bp = bz + numerator * bm;
            numerator = -(a + i) * (apb + i) * x / ((ap1 + twoI) * a + twoI));
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

    public static double studentT(int degFreedom, double t) {

    }

    public static void main(String[] args) {

    }
}
