package com.airbnb.lottie.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.os.Build;
import android.provider.Settings;
import com.airbnb.lottie.L;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.blued.das.live.LiveProtos;
import java.io.Closeable;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/utils/Utils.class */
public final class Utils {

    /* renamed from: a  reason: collision with root package name */
    private static final PathMeasure f4416a = new PathMeasure();
    private static final Path b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private static final Path f4417c = new Path();
    private static final float[] d = new float[4];
    private static final float e = (float) Math.sqrt(2.0d);
    private static float f = -1.0f;

    private Utils() {
    }

    public static float a() {
        if (f == -1.0f) {
            f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f;
    }

    public static float a(Context context) {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f) : Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static float a(Matrix matrix) {
        float[] fArr = d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = e;
        fArr[2] = f2;
        fArr[3] = f2;
        matrix.mapPoints(fArr);
        float[] fArr2 = d;
        return ((float) Math.hypot(fArr2[2] - fArr2[0], fArr2[3] - fArr2[1])) / 2.0f;
    }

    public static int a(float f2, float f3, float f4, float f5) {
        int i = f2 != 0.0f ? (int) (((float) LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * f2) : 17;
        int i2 = i;
        if (f3 != 0.0f) {
            i2 = (int) (i * 31 * f3);
        }
        int i3 = i2;
        if (f4 != 0.0f) {
            i3 = (int) (i2 * 31 * f4);
        }
        int i4 = i3;
        if (f5 != 0.0f) {
            i4 = (int) (i3 * 31 * f5);
        }
        return i4;
    }

    public static Path a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
            return path;
        }
        path.cubicTo(pointF3.x + pointF.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        return path;
    }

    public static void a(Path path, float f2, float f3, float f4) {
        L.a("applyTrimPathIfNeeded");
        f4416a.setPath(path, false);
        float length = f4416a.getLength();
        if (f2 == 1.0f && f3 == 0.0f) {
            L.b("applyTrimPathIfNeeded");
        } else if (length < 1.0f || Math.abs((f3 - f2) - 1.0f) < 0.01d) {
            L.b("applyTrimPathIfNeeded");
        } else {
            float f5 = f2 * length;
            float f6 = f3 * length;
            float min = Math.min(f5, f6);
            float max = Math.max(f5, f6);
            float f7 = f4 * length;
            float f8 = min + f7;
            float f9 = max + f7;
            float f10 = f8;
            float f11 = f9;
            if (f8 >= length) {
                f10 = f8;
                f11 = f9;
                if (f9 >= length) {
                    f10 = MiscUtils.a(f8, length);
                    f11 = MiscUtils.a(f9, length);
                }
            }
            float f12 = f10;
            if (f10 < 0.0f) {
                f12 = MiscUtils.a(f10, length);
            }
            float f13 = f11;
            if (f11 < 0.0f) {
                f13 = MiscUtils.a(f11, length);
            }
            int i = (f12 > f13 ? 1 : (f12 == f13 ? 0 : -1));
            if (i == 0) {
                path.reset();
                L.b("applyTrimPathIfNeeded");
                return;
            }
            float f14 = f12;
            if (i >= 0) {
                f14 = f12 - length;
            }
            b.reset();
            f4416a.getSegment(f14, f13, b, true);
            if (f13 > length) {
                f4417c.reset();
                f4416a.getSegment(0.0f, f13 % length, f4417c, true);
                b.addPath(f4417c);
            } else if (f14 < 0.0f) {
                f4417c.reset();
                f4416a.getSegment(f14 + length, length, f4417c, true);
                b.addPath(f4417c);
            }
            path.set(b);
            L.b("applyTrimPathIfNeeded");
        }
    }

    public static void a(Path path, TrimPathContent trimPathContent) {
        if (trimPathContent == null || trimPathContent.f()) {
            return;
        }
        a(path, ((FloatKeyframeAnimation) trimPathContent.c()).i() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.d()).i() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.e()).i() / 360.0f);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    public static boolean a(int i, int i2, int i3, int i4, int i5, int i6) {
        boolean z = false;
        if (i < i4) {
            return false;
        }
        if (i > i4) {
            return true;
        }
        if (i2 < i5) {
            return false;
        }
        if (i2 > i5) {
            return true;
        }
        if (i3 >= i6) {
            z = true;
        }
        return z;
    }

    public static boolean b(Matrix matrix) {
        float[] fArr = d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        float[] fArr2 = d;
        return fArr2[0] == fArr2[2] || fArr2[1] == fArr2[3];
    }
}
