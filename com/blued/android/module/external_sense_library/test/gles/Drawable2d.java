package com.blued.android.module.external_sense_library.test.gles;

import java.nio.FloatBuffer;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/test/gles/Drawable2d.class */
public class Drawable2d {
    private static final float[] a;
    private static final FloatBuffer c;
    private static final float[] e;
    private static final FloatBuffer g;
    private static final float[] i;
    private static final FloatBuffer k;
    private Prefab m;
    private static final float[] b = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final FloatBuffer d = GlUtil.a(b);
    private static final float[] f = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final FloatBuffer h = GlUtil.a(f);
    private static final float[] j = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final FloatBuffer l = GlUtil.a(j);

    /* renamed from: com.blued.android.module.external_sense_library.test.gles.Drawable2d$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/test/gles/Drawable2d$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[Prefab.values().length];
            a = iArr;
            try {
                iArr[Prefab.TRIANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Prefab.RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[Prefab.FULL_RECTANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/test/gles/Drawable2d$Prefab.class */
    public enum Prefab {
        TRIANGLE,
        RECTANGLE,
        FULL_RECTANGLE
    }

    static {
        float[] fArr = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
        a = fArr;
        c = GlUtil.a(fArr);
        float[] fArr2 = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        e = fArr2;
        g = GlUtil.a(fArr2);
        float[] fArr3 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        i = fArr3;
        k = GlUtil.a(fArr3);
    }

    public String toString() {
        if (this.m != null) {
            return "[Drawable2d: " + this.m + "]";
        }
        return "[Drawable2d: ...]";
    }
}
