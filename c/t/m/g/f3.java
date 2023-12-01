package c.t.m.g;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/f3.class */
public class f3 {
    public static double a(double d) {
        return (d * 3.141592653589793d) / 180.0d;
    }

    public static double a(double d, double d2, double d3, double d4) {
        double a2 = a(d);
        double a3 = a(d3);
        return Math.round((((Math.asin(Math.sqrt(Math.pow(Math.sin((a2 - a3) / 2.0d), 2.0d) + ((Math.cos(a2) * Math.cos(a3)) * Math.pow(Math.sin((a(d2) - a(d4)) / 2.0d), 2.0d)))) * 2.0d) * 6378.137d) * 1000.0d) * 1000.0d) / 1000.0d;
    }
}
