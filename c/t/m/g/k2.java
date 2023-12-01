package c.t.m.g;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/k2.class */
public class k2 {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f3860a = new byte[0];

    public static String a(double[] dArr, int i, boolean z) {
        if (dArr == null) {
            return com.igexin.push.core.b.l;
        }
        int length = dArr.length - 1;
        if (length == -1) {
            return z ? "[]" : "";
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append('[');
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            sb.append(k3.a(dArr[i3], i));
            if (i3 == length) {
                break;
            }
            sb.append(",");
            i2 = i3 + 1;
        }
        if (z) {
            sb.append(']');
        }
        return sb.toString();
    }
}
