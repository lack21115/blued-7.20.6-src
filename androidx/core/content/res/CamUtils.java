package androidx.core.content.res;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/CamUtils.class */
final class CamUtils {

    /* renamed from: a  reason: collision with root package name */
    static final float[][] f2376a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
    static final float[][] b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: c  reason: collision with root package name */
    static final float[] f2377c = {95.047f, 100.0f, 108.883f};
    static final float[][] d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    private CamUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(int i) {
        return b(b(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(float f) {
        if (f < 1.0f) {
            return -16777216;
        }
        if (f > 99.0f) {
            return -1;
        }
        float f2 = (f + 16.0f) / 116.0f;
        float f3 = (f > 8.0f ? 1 : (f == 8.0f ? 0 : -1)) > 0 ? f2 * f2 * f2 : f / 903.2963f;
        float f4 = f2 * f2 * f2;
        boolean z = f4 > 0.008856452f;
        float f5 = z ? f4 : ((f2 * 116.0f) - 16.0f) / 903.2963f;
        if (!z) {
            f4 = ((f2 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f2377c;
        return ColorUtils.XYZToColor(f5 * fArr[0], f3 * fArr[1], f4 * fArr[2]);
    }

    static float b(float f) {
        float f2 = f / 100.0f;
        return f2 <= 0.008856452f ? f2 * 903.2963f : (((float) Math.cbrt(f2)) * 116.0f) - 16.0f;
    }

    static float b(int i) {
        float d2 = d(Color.red(i));
        float d3 = d(Color.green(i));
        float d4 = d(Color.blue(i));
        float[][] fArr = d;
        return (d2 * fArr[1][0]) + (d3 * fArr[1][1]) + (d4 * fArr[1][2]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float c(float f) {
        return (f > 8.0f ? (float) Math.pow((f + 16.0d) / 116.0d, 3.0d) : f / 903.2963f) * 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float[] c(int i) {
        float d2 = d(Color.red(i));
        float d3 = d(Color.green(i));
        float d4 = d(Color.blue(i));
        float[][] fArr = d;
        return new float[]{(fArr[0][0] * d2) + (fArr[0][1] * d3) + (fArr[0][2] * d4), (fArr[1][0] * d2) + (fArr[1][1] * d3) + (fArr[1][2] * d4), (d2 * fArr[2][0]) + (d3 * fArr[2][1]) + (d4 * fArr[2][2])};
    }

    static float d(int i) {
        float f = i / 255.0f;
        return (f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }
}
