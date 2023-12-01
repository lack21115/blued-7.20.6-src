package com.github.mikephil.charting.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.huawei.hms.framework.common.ExceptionCode;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/utils/Utils.class */
public abstract class Utils {

    /* renamed from: c  reason: collision with root package name */
    private static DisplayMetrics f8603c;
    private static int d = 50;
    private static int e = 8000;

    /* renamed from: a  reason: collision with root package name */
    public static final double f8602a = Double.longBitsToDouble(1);
    public static final float b = Float.intBitsToFloat(1);
    private static Rect f = new Rect();
    private static Paint.FontMetrics g = new Paint.FontMetrics();
    private static Rect h = new Rect();
    private static final int[] i = {1, 10, 100, 1000, 10000, 100000, 1000000, ExceptionCode.CRASH_EXCEPTION, 100000000, 1000000000};
    private static ValueFormatter j = e();
    private static Rect k = new Rect();
    private static Rect l = new Rect();
    private static Paint.FontMetrics m = new Paint.FontMetrics();

    public static float a(double d2) {
        if (Double.isInfinite(d2) || Double.isNaN(d2) || d2 == 0.0d) {
            return 0.0f;
        }
        float pow = (float) Math.pow(10.0d, 1 - ((int) Math.ceil((float) Math.log10(d2 < 0.0d ? -d2 : d2))));
        return ((float) Math.round(d2 * pow)) / pow;
    }

    public static float a(float f2) {
        DisplayMetrics displayMetrics = f8603c;
        if (displayMetrics == null) {
            Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
            return f2;
        }
        return f2 * displayMetrics.density;
    }

    public static float a(Paint paint) {
        return a(paint, g);
    }

    public static float a(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static int a(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static ValueFormatter a() {
        return j;
    }

    public static FSize a(float f2, float f3, float f4) {
        return b(f2, f3, f4 * 0.017453292f);
    }

    public static void a(Context context) {
        if (context == null) {
            d = ViewConfiguration.getMinimumFlingVelocity();
            e = ViewConfiguration.getMaximumFlingVelocity();
            Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
            return;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        d = viewConfiguration.getScaledMinimumFlingVelocity();
        e = viewConfiguration.getScaledMaximumFlingVelocity();
        f8603c = context.getResources().getDisplayMetrics();
    }

    public static void a(Canvas canvas, Drawable drawable, int i2, int i3, int i4, int i5) {
        MPPointF a2 = MPPointF.a();
        a2.f8597a = i2 - (i4 / 2);
        a2.b = i3 - (i5 / 2);
        drawable.copyBounds(k);
        drawable.setBounds(k.left, k.top, k.left + i4, k.top + i4);
        int save = canvas.save();
        canvas.translate(a2.f8597a, a2.b);
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00f2, code lost:
        if (r12.b != 0.0f) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0068, code lost:
        if (r12.b != 0.5f) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.graphics.Canvas r7, java.lang.String r8, float r9, float r10, android.graphics.Paint r11, com.github.mikephil.charting.utils.MPPointF r12, float r13) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.utils.Utils.a(android.graphics.Canvas, java.lang.String, float, float, android.graphics.Paint, com.github.mikephil.charting.utils.MPPointF, float):void");
    }

    public static void a(Paint paint, String str, FSize fSize) {
        Rect rect = h;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        fSize.f8593a = rect.width();
        fSize.b = rect.height();
    }

    public static void a(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(1000, e);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= pointerCount) {
                return;
            }
            if (i3 != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(i3);
                if ((velocityTracker.getXVelocity(pointerId2) * xVelocity) + (velocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                    velocityTracker.clear();
                    return;
                }
            }
            i2 = i3 + 1;
        }
    }

    public static void a(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidateDelayed(10L);
        }
    }

    public static void a(MPPointF mPPointF, float f2, float f3, MPPointF mPPointF2) {
        double d2 = f2;
        double d3 = f3;
        mPPointF2.f8597a = (float) (mPPointF.f8597a + (Math.cos(Math.toRadians(d3)) * d2));
        mPPointF2.b = (float) (mPPointF.b + (d2 * Math.sin(Math.toRadians(d3))));
    }

    public static double b(double d2) {
        if (d2 == Double.POSITIVE_INFINITY) {
            return d2;
        }
        double d3 = d2 + 0.0d;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d3) + (d3 >= 0.0d ? 1L : -1L));
    }

    public static float b(Paint paint) {
        return b(paint, g);
    }

    public static float b(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static int b() {
        return d;
    }

    public static int b(float f2) {
        float a2 = a(f2);
        if (Float.isInfinite(a2)) {
            return 0;
        }
        return ((int) Math.ceil(-Math.log10(a2))) + 2;
    }

    public static int b(Paint paint, String str) {
        Rect rect = f;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static FSize b(float f2, float f3, float f4) {
        double d2 = f4;
        return FSize.a(Math.abs(((float) Math.cos(d2)) * f2) + Math.abs(((float) Math.sin(d2)) * f3), Math.abs(f2 * ((float) Math.sin(d2))) + Math.abs(f3 * ((float) Math.cos(d2))));
    }

    public static float c(float f2) {
        while (f2 < 0.0f) {
            f2 += 360.0f;
        }
        return f2 % 360.0f;
    }

    public static int c() {
        return e;
    }

    public static FSize c(Paint paint, String str) {
        FSize a2 = FSize.a(0.0f, 0.0f);
        a(paint, str, a2);
        return a2;
    }

    public static int d() {
        return Build.VERSION.SDK_INT;
    }

    private static ValueFormatter e() {
        return new DefaultValueFormatter(1);
    }
}
