package ar.com.hjg.pngj;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/ImageLineHelper.class */
public class ImageLineHelper {

    /* renamed from: a  reason: collision with root package name */
    static int[] f3641a;
    static int[] b;

    /* renamed from: c  reason: collision with root package name */
    static int[] f3642c;
    static int[][] d;

    static {
        a();
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [int[], int[][]] */
    private static void a() {
        f3641a = new int[2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                break;
            }
            f3641a[i2] = i2 * 255;
            i = i2 + 1;
        }
        b = new int[4];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 4) {
                break;
            }
            b[i4] = (i4 * 255) / 3;
            i3 = i4 + 1;
        }
        f3642c = new int[16];
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 16) {
                d = new int[]{0, f3641a, b, 0, f3642c};
                return;
            } else {
                f3642c[i6] = (i6 * 255) / 15;
                i5 = i6 + 1;
            }
        }
    }
}
