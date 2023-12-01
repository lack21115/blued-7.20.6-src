package com.blued.android.module.external_sense_library.glutils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/glutils/TextureRotationUtil.class */
public class TextureRotationUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final float[] f11258a = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] b = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: c  reason: collision with root package name */
    public static final float[] f11259c = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
    public static final float[] d = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    public static final float[] e = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    public static final float[] f = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] g = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] h = {1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    private TextureRotationUtil() {
    }

    private static float a(float f2) {
        return f2 == 0.0f ? 1.0f : 0.0f;
    }

    public static float[] a(int i, boolean z, boolean z2) {
        float[] fArr = i != 0 ? i != 90 ? i != 180 ? i != 270 ? d : e : d : f11259c : f11259c;
        float[] fArr2 = fArr;
        if (z) {
            fArr2 = new float[]{a(fArr[0]), fArr[1], a(fArr[2]), fArr[3], a(fArr[4]), fArr[5], a(fArr[6]), fArr[7]};
        }
        float[] fArr3 = fArr2;
        if (z2) {
            fArr3 = new float[]{fArr2[0], a(fArr2[1]), fArr2[2], a(fArr2[3]), fArr2[4], a(fArr2[5]), fArr2[6], a(fArr2[7])};
        }
        return fArr3;
    }

    public static float[] b(int i, boolean z, boolean z2) {
        float[] fArr = i != 90 ? i != 180 ? i != 270 ? f11258a : e : d : f11259c;
        float[] fArr2 = fArr;
        if (z) {
            fArr2 = new float[]{a(fArr[0]), fArr[1], a(fArr[2]), fArr[3], a(fArr[4]), fArr[5], a(fArr[6]), fArr[7]};
        }
        float[] fArr3 = fArr2;
        if (z2) {
            fArr3 = new float[]{fArr2[0], a(fArr2[1]), fArr2[2], a(fArr2[3]), fArr2[4], a(fArr2[5]), fArr2[6], a(fArr2[7])};
        }
        return fArr3;
    }

    public static float[] c(int i, boolean z, boolean z2) {
        float[] fArr = i != 90 ? i != 180 ? i != 270 ? b : e : d : f11259c;
        float[] fArr2 = fArr;
        if (z) {
            fArr2 = new float[]{a(fArr[0]), fArr[1], a(fArr[2]), fArr[3], a(fArr[4]), fArr[5], a(fArr[6]), fArr[7]};
        }
        float[] fArr3 = fArr2;
        if (z2) {
            fArr3 = new float[]{fArr2[0], a(fArr2[1]), fArr2[2], a(fArr2[3]), fArr2[4], a(fArr2[5]), fArr2[6], a(fArr2[7])};
        }
        return fArr3;
    }

    public static float[] d(int i, boolean z, boolean z2) {
        float[] fArr = i != 90 ? i != 180 ? i != 270 ? b : e : d : f11259c;
        float[] fArr2 = fArr;
        if (z) {
            fArr2 = new float[]{a(fArr[0]), fArr[1], a(fArr[2]), fArr[3], a(fArr[4]), fArr[5], a(fArr[6]), fArr[7]};
        }
        float[] fArr3 = fArr2;
        if (z2) {
            fArr3 = new float[]{fArr2[0], a(fArr2[1]), fArr2[2], a(fArr2[3]), fArr2[4], a(fArr2[5]), fArr2[6], a(fArr2[7])};
        }
        return fArr3;
    }
}
