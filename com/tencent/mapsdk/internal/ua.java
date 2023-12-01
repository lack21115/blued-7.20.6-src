package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.opengl.GLU;
import android.opengl.Matrix;
import android.text.Spanned;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ua.class */
public class ua {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f38042a = {"北", "东北", "东", "东南", "南", "西南", "西", "西北"};

    public static double a(double d) {
        return (d / 180.0d) * 3.141592653589793d;
    }

    public static double a(double d, double d2, double d3, double d4) {
        double asin = Math.asin((d3 - d) / c(d, d2, d3, d4));
        double d5 = asin;
        if (d4 - d2 < 0.0d) {
            d5 = 3.141592653589793d - asin;
        }
        return (d5 / 3.141592653589793d) * 180.0d;
    }

    public static float a(d6 d6Var, d6 d6Var2) {
        double asin = Math.asin((d6Var2.f37388a - d6Var.f37388a) / b(d6Var, d6Var2));
        double d = asin;
        if (d6Var2.f37389c - d6Var.f37389c < 0.0f) {
            d = 3.141592653589793d - asin;
        }
        return (float) ((d / 3.141592653589793d) * 180.0d);
    }

    public static int a(float f) {
        int i = 1;
        while (true) {
            int i2 = i;
            int i3 = 2 << i2;
            if (i3 >= ((int) Math.ceil(f))) {
                return i3;
            }
            i = i2 + 1;
        }
    }

    public static Bitmap a(GL10 gl10, int i, int i2, int i3, int i4) {
        return a(gl10, i, i2, i3, i4, i3, i4);
    }

    public static Bitmap a(GL10 gl10, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i2 + i4;
        int[] iArr = new int[i3 * i7];
        int[] iArr2 = new int[i5 * i6];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        wrap.position(0);
        long currentTimeMillis = System.currentTimeMillis();
        gl10.glReadPixels(i, 0, i3, i7, 6408, 5121, wrap);
        long currentTimeMillis2 = System.currentTimeMillis();
        na.c("readPixels 使用的时间:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
        long currentTimeMillis3 = System.currentTimeMillis();
        float f = ((float) i3) / ((float) i5);
        float f2 = ((float) i4) / ((float) i6);
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i8 >= i6) {
                Bitmap createBitmap = Bitmap.createBitmap(iArr2, i5, i6, Bitmap.Config.RGB_565);
                na.c("buffer 转成位图使用的时间:" + (System.currentTimeMillis() - currentTimeMillis3) + "ms");
                return createBitmap;
            }
            int i11 = 0;
            while (true) {
                int i12 = i11;
                if (i12 < i5) {
                    int i13 = iArr[(((int) Math.ceil((i8 * f2) - 0.5d)) * i3) + ((int) Math.ceil((i12 * f) - 0.5d))];
                    iArr2[(((i6 - i10) - 1) * i5) + i12] = (i13 & Color.GREEN) | ((i13 << 16) & Spanned.SPAN_PRIORITY) | ((i13 >> 16) & 255);
                    i11 = i12 + 1;
                }
            }
            i8++;
            i9 = i10 + 1;
        }
    }

    public static PointF a(d6 d6Var, double d, double d2) {
        return new PointF((float) (d6Var.f37388a + d), (float) ((-d6Var.f37389c) + d2));
    }

    public static c6 a(float f, float f2, float[] fArr, float[] fArr2, int[] iArr) {
        float[] a2 = a(f, f2, 0.0f, fArr, fArr2, iArr);
        float[] a3 = a(f, f2, 1.0f, fArr, fArr2, iArr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return new c6(a3[0] - a2[0], a3[1] - a2[1], a3[2] - a2[2]);
            }
            a2[i2] = a2[i2] / a2[3];
            a3[i2] = a3[i2] / a3[3];
            i = i2 + 1;
        }
    }

    private static c6 a(float[] fArr) {
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float[] fArr2 = {fArr[3] - f, fArr[4] - f2, fArr[5] - f3};
        float[] fArr3 = {fArr[6] - f, fArr[7] - f2, fArr[8] - f3};
        float[] fArr4 = {(fArr2[1] * fArr3[2]) - (fArr2[2] * fArr3[1]), (fArr2[2] * fArr3[0]) - (fArr2[0] * fArr3[2]), (fArr2[0] * fArr3[1]) - (fArr2[1] * fArr3[0])};
        return new c6(fArr4[0], fArr4[1], fArr4[2]);
    }

    public static d6 a(float f, float f2, float f3, float[] fArr, float f4) {
        float[] fArr2 = new float[16];
        Matrix.invertM(fArr2, 0, fArr, 0);
        d6 a2 = new d6(f, f2, f4).a(fArr2);
        float f5 = a2.b;
        float f6 = f5 != 0.0f ? f3 / f5 : 1.0f;
        return new d6(a2.f37388a * f6, f3, a2.f37389c * f6);
    }

    private static boolean a(float[] fArr, float[] fArr2) {
        return new b6(fArr2).a(fArr);
    }

    public static float[] a(float f, float f2, float f3, float[] fArr, float[] fArr2, int[] iArr) {
        float[] fArr3 = new float[4];
        if (GLU.gluUnProject(f, iArr[3] - f2, f3, fArr, 0, fArr2, 0, iArr, 0, fArr3, 0) == 1) {
            return fArr3;
        }
        throw new RuntimeException("unProject fail");
    }

    public static float[] a(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr2[0];
        float f5 = fArr2[1];
        float f6 = fArr2[2];
        float f7 = fArr3[0];
        float f8 = fArr3[1];
        float f9 = fArr3[2];
        float f10 = fArr4[0];
        float f11 = fArr4[1];
        float f12 = fArr4[2];
        float f13 = (f7 * f) + (f8 * f2) + (f9 * f3);
        if (f13 == 0.0f) {
            return null;
        }
        float f14 = ((((f4 - f10) * f) + ((f5 - f11) * f2)) + ((f6 - f12) * f3)) / f13;
        return new float[]{f10 + (f7 * f14), f11 + (f8 * f14), f12 + (f9 * f14)};
    }

    public static double b(double d) {
        double abs = Math.abs(d % 360.0d);
        double d2 = abs;
        if (abs > 270.0d) {
            d2 = 360.0d - abs;
        }
        return d2;
    }

    public static double b(double d, double d2, double d3, double d4) {
        double abs;
        double abs2;
        double d5;
        double d6 = d3 - d;
        double d7 = d4 - d2;
        double atan = Math.atan(d7 / d6);
        double d8 = 1.5707963267948966d;
        int i = (d6 > 0.0d ? 1 : (d6 == 0.0d ? 0 : -1));
        if (i <= 0 || d7 <= 0.0d) {
            if (i < 0 || d7 > 0.0d) {
                d8 = 4.71238898038469d;
                if (d6 > 0.0d || d7 > 0.0d) {
                    abs = Math.abs(atan);
                } else {
                    abs2 = Math.abs(atan);
                }
            } else {
                abs = Math.abs(atan);
            }
            d5 = d8 + abs;
            return (d5 * 180.0d) / 3.141592653589793d;
        }
        abs2 = Math.abs(atan);
        d5 = d8 - abs2;
        return (d5 * 180.0d) / 3.141592653589793d;
    }

    public static double b(d6 d6Var, d6 d6Var2) {
        return Math.sqrt(Math.pow(d6Var.f37388a - d6Var2.f37388a, 2.0d) + Math.pow(d6Var.f37389c - d6Var2.f37389c, 2.0d));
    }

    public static String b(float f) {
        float f2 = f;
        if (f < 0.0f) {
            f2 = f + 360.0f;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            String[] strArr = f38042a;
            if (i2 >= strArr.length) {
                return strArr[0];
            }
            float f3 = (i2 * 45) - 22.0f;
            if (f2 < 45.0f + f3 && f2 >= f3) {
                return strArr[i2];
            }
            i = i2 + 1;
        }
    }

    public static IntBuffer b(GL10 gl10, int i, int i2, int i3, int i4) {
        IntBuffer wrap = IntBuffer.wrap(new int[i3 * i4]);
        wrap.position(0);
        gl10.glReadPixels(i, i2, i3, i4, 6408, 5121, wrap);
        return wrap;
    }

    public static boolean b(float f, float f2, float[] fArr, float[] fArr2, int[] iArr) {
        c6 a2 = a(fArr);
        float[] fArr3 = new float[16];
        Matrix.setIdentityM(fArr3, 0);
        float[] a3 = a(f, f2, 0.0f, fArr3, fArr2, iArr);
        float[] a4 = a(f, f2, 1.0f, fArr3, fArr2, iArr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                break;
            }
            a3[i2] = a3[i2] / a3[3];
            a4[i2] = a4[i2] / a4[3];
            i = i2 + 1;
        }
        c6 c6Var = new c6(a4[0] - a3[0], a4[1] - a3[1], a4[2] - a3[2]);
        float[] a5 = a(a2.a(), new float[]{fArr[0], fArr[1], fArr[2]}, c6Var.a(), new float[]{a3[0], a3[1], a3[2]});
        if (a5 == null) {
            return false;
        }
        return a(a5, fArr);
    }

    public static double c(double d) {
        return (d / 3.141592653589793d) * 180.0d;
    }

    public static double c(double d, double d2, double d3, double d4) {
        return Math.sqrt(Math.pow(d - d3, 2.0d) + Math.pow(d2 - d4, 2.0d));
    }

    public static d6 d(double d, double d2, double d3, double d4) {
        return new d6((float) (d - d3), 0.0f, -((float) (d2 - d4)));
    }
}
