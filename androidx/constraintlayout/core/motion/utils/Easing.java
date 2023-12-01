package androidx.constraintlayout.core.motion.utils;

import android.net.wifi.WifiEnterpriseConfig;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/Easing.class */
public class Easing {
    String b = WifiEnterpriseConfig.IDENTITY_KEY;

    /* renamed from: a  reason: collision with root package name */
    static Easing f2028a = new Easing();
    public static String[] NAMED_EASING = {"standard", "accelerate", "decelerate", "linear"};

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/Easing$CubicEasing.class */
    static class CubicEasing extends Easing {
        private static double g = 0.01d;
        private static double h = 1.0E-4d;

        /* renamed from: c  reason: collision with root package name */
        double f2029c;
        double d;
        double e;
        double f;

        public CubicEasing(double d, double d2, double d3, double d4) {
            a(d, d2, d3, d4);
        }

        CubicEasing(String str) {
            this.b = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.f2029c = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i);
            this.d = Double.parseDouble(str.substring(i, indexOf3).trim());
            int i2 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i2);
            this.e = Double.parseDouble(str.substring(i2, indexOf4).trim());
            int i3 = indexOf4 + 1;
            this.f = Double.parseDouble(str.substring(i3, str.indexOf(41, i3)).trim());
        }

        private double a(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            return (this.f2029c * d2 * d3 * d) + (this.e * d3 * d * d) + (d * d * d);
        }

        private double b(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            return (this.d * d2 * d3 * d) + (this.f * d3 * d * d) + (d * d * d);
        }

        void a(double d, double d2, double d3, double d4) {
            this.f2029c = d;
            this.d = d2;
            this.e = d3;
            this.f = d4;
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double get(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (true) {
                double d4 = d3;
                if (d2 <= g) {
                    double d5 = d4 - d2;
                    double a2 = a(d5);
                    double d6 = d4 + d2;
                    double a3 = a(d6);
                    double b = b(d5);
                    return (((b(d6) - b) * (d - a2)) / (a3 - a2)) + b;
                }
                d2 *= 0.5d;
                d3 = a(d4) < d ? d4 + d2 : d4 - d2;
            }
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double getDiff(double d) {
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (true) {
                double d4 = d3;
                if (d2 <= h) {
                    double d5 = d4 - d2;
                    double a2 = a(d5);
                    double d6 = d4 + d2;
                    return (b(d6) - b(d5)) / (a(d6) - a2);
                }
                d2 *= 0.5d;
                d3 = a(d4) < d ? d4 + d2 : d4 - d2;
            }
        }
    }

    public static Easing getInterpolator(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        if (str.startsWith("spline")) {
            return new StepCurve(str);
        }
        if (str.startsWith("Schlick")) {
            return new Schlick(str);
        }
        boolean z = true;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals("accelerate")) {
                    z = true;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals("decelerate")) {
                    z = true;
                    break;
                }
                break;
            case -1197605014:
                if (str.equals("anticipate")) {
                    z = true;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    z = true;
                    break;
                }
                break;
            case -749065269:
                if (str.equals("overshoot")) {
                    z = true;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals("standard")) {
                    z = false;
                    break;
                }
                break;
        }
        if (z) {
            if (!z) {
                if (!z) {
                    if (!z) {
                        if (!z) {
                            if (!z) {
                                System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
                                return f2028a;
                            }
                            return new CubicEasing("cubic(0.34, 1.56, 0.64, 1)");
                        }
                        return new CubicEasing("cubic(0.36, 0, 0.66, -0.56)");
                    }
                    return new CubicEasing("cubic(1, 1, 0, 0)");
                }
                return new CubicEasing("cubic(0.0, 0.0, 0.2, 0.95)");
            }
            return new CubicEasing("cubic(0.4, 0.05, 0.8, 0.7)");
        }
        return new CubicEasing("cubic(0.4, 0.0, 0.2, 1)");
    }

    public double get(double d) {
        return d;
    }

    public double getDiff(double d) {
        return 1.0d;
    }

    public String toString() {
        return this.b;
    }
}
