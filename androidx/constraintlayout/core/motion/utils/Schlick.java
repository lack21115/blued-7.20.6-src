package androidx.constraintlayout.core.motion.utils;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/Schlick.class */
public class Schlick extends Easing {

    /* renamed from: c  reason: collision with root package name */
    double f2056c;
    double d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Schlick(String str) {
        this.b = str;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(44, indexOf);
        this.f2056c = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
        int i = indexOf2 + 1;
        this.d = Double.parseDouble(str.substring(i, str.indexOf(44, i)).trim());
    }

    private double a(double d) {
        double d2 = this.d;
        return d < d2 ? (d2 * d) / (d + (this.f2056c * (d2 - d))) : ((1.0d - d2) * (d - 1.0d)) / ((1.0d - d) - (this.f2056c * (d2 - d)));
    }

    private double b(double d) {
        double d2 = this.d;
        if (d < d2) {
            double d3 = this.f2056c;
            return ((d3 * d2) * d2) / ((((d2 - d) * d3) + d) * ((d3 * (d2 - d)) + d));
        }
        double d4 = this.f2056c;
        return (((d2 - 1.0d) * d4) * (d2 - 1.0d)) / (((((-d4) * (d2 - d)) - d) + 1.0d) * ((((-d4) * (d2 - d)) - d) + 1.0d));
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double get(double d) {
        return a(d);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double getDiff(double d) {
        return b(d);
    }
}
