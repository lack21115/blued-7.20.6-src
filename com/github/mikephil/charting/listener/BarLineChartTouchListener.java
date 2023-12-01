package com.github.mikephil.charting.listener;

import android.graphics.Matrix;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/listener/BarLineChartTouchListener.class */
public class BarLineChartTouchListener extends ChartTouchListener<BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>>> {
    private Matrix f;
    private Matrix g;
    private MPPointF h;
    private MPPointF i;
    private float j;
    private float k;
    private float l;
    private IDataSet m;
    private VelocityTracker n;
    private long o;
    private MPPointF p;
    private MPPointF q;
    private float r;
    private float s;

    public BarLineChartTouchListener(BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> barLineChartBase, Matrix matrix, float f) {
        super(barLineChartBase);
        this.f = new Matrix();
        this.g = new Matrix();
        this.h = MPPointF.a(0.0f, 0.0f);
        this.i = MPPointF.a(0.0f, 0.0f);
        this.j = 1.0f;
        this.k = 1.0f;
        this.l = 1.0f;
        this.o = 0L;
        this.p = MPPointF.a(0.0f, 0.0f);
        this.q = MPPointF.a(0.0f, 0.0f);
        this.f = matrix;
        this.r = Utils.a(f);
        this.s = Utils.a(3.5f);
    }

    private void a(MotionEvent motionEvent, float f, float f2) {
        this.f22159a = ChartTouchListener.ChartGesture.DRAG;
        this.f.set(this.g);
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.e).getOnChartGestureListener();
        float f3 = f;
        float f4 = f2;
        if (c()) {
            if (this.e instanceof HorizontalBarChart) {
                f3 = -f;
                f4 = f2;
            } else {
                f4 = -f2;
                f3 = f;
            }
        }
        this.f.postTranslate(f3, f4);
        if (onChartGestureListener != null) {
            onChartGestureListener.b(motionEvent, f3, f4);
        }
    }

    private static void a(MPPointF mPPointF, MotionEvent motionEvent) {
        float x = motionEvent.getX(0);
        float x2 = motionEvent.getX(1);
        float y = motionEvent.getY(0);
        float y2 = motionEvent.getY(1);
        mPPointF.f22204a = (x + x2) / 2.0f;
        mPPointF.b = (y + y2) / 2.0f;
    }

    private void c(MotionEvent motionEvent) {
        this.g.set(this.f);
        this.h.f22204a = motionEvent.getX();
        this.h.b = motionEvent.getY();
        this.m = ((BarLineChartBase) this.e).b(motionEvent.getX(), motionEvent.getY());
    }

    private boolean c() {
        if (this.m == null && ((BarLineChartBase) this.e).v()) {
            return true;
        }
        return this.m != null && ((BarLineChartBase) this.e).c(this.m.C());
    }

    private void d(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() >= 2) {
            OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.e).getOnChartGestureListener();
            float f = f(motionEvent);
            if (f > this.s) {
                MPPointF a2 = a(this.i.f22204a, this.i.b);
                ViewPortHandler viewPortHandler = ((BarLineChartBase) this.e).getViewPortHandler();
                boolean z = true;
                float f2 = 1.0f;
                if (this.b == 4) {
                    this.f22159a = ChartTouchListener.ChartGesture.PINCH_ZOOM;
                    float f3 = f / this.l;
                    if (f3 >= 1.0f) {
                        z = false;
                    }
                    boolean w = z ? viewPortHandler.w() : viewPortHandler.x();
                    boolean y = z ? viewPortHandler.y() : viewPortHandler.z();
                    float f4 = ((BarLineChartBase) this.e).o() ? f3 : 1.0f;
                    if (((BarLineChartBase) this.e).p()) {
                        f2 = f3;
                    }
                    if (y || w) {
                        this.f.set(this.g);
                        this.f.postScale(f4, f2, a2.f22204a, a2.b);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.a(motionEvent, f4, f2);
                        }
                    }
                } else if (this.b == 2 && ((BarLineChartBase) this.e).o()) {
                    this.f22159a = ChartTouchListener.ChartGesture.X_ZOOM;
                    float g = g(motionEvent) / this.j;
                    if ((g > 1.0f ? 1 : (g == 1.0f ? 0 : -1)) < 0 ? viewPortHandler.w() : viewPortHandler.x()) {
                        this.f.set(this.g);
                        this.f.postScale(g, 1.0f, a2.f22204a, a2.b);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.a(motionEvent, g, 1.0f);
                        }
                    }
                } else if (this.b == 3 && ((BarLineChartBase) this.e).p()) {
                    this.f22159a = ChartTouchListener.ChartGesture.Y_ZOOM;
                    float h = h(motionEvent) / this.k;
                    if ((h > 1.0f ? 1 : (h == 1.0f ? 0 : -1)) < 0 ? viewPortHandler.y() : viewPortHandler.z()) {
                        this.f.set(this.g);
                        this.f.postScale(1.0f, h, a2.f22204a, a2.b);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.a(motionEvent, 1.0f, h);
                        }
                    }
                }
                MPPointF.b(a2);
            }
        }
    }

    private void e(MotionEvent motionEvent) {
        Highlight a2 = ((BarLineChartBase) this.e).a(motionEvent.getX(), motionEvent.getY());
        if (a2 == null || a2.a(this.f22160c)) {
            return;
        }
        this.f22160c = a2;
        ((BarLineChartBase) this.e).a(a2, true);
    }

    private static float f(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    private static float g(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
    }

    private static float h(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
    }

    public MPPointF a(float f, float f2) {
        ViewPortHandler viewPortHandler = ((BarLineChartBase) this.e).getViewPortHandler();
        return MPPointF.a(f - viewPortHandler.a(), c() ? -(f2 - viewPortHandler.c()) : -((((BarLineChartBase) this.e).getMeasuredHeight() - f2) - viewPortHandler.d()));
    }

    public void a() {
        this.q.f22204a = 0.0f;
        this.q.b = 0.0f;
    }

    public void b() {
        float f = 0.0f;
        if (this.q.f22204a == 0.0f && this.q.b == 0.0f) {
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.q.f22204a *= ((BarLineChartBase) this.e).getDragDecelerationFrictionCoef();
        this.q.b *= ((BarLineChartBase) this.e).getDragDecelerationFrictionCoef();
        float f2 = ((float) (currentAnimationTimeMillis - this.o)) / 1000.0f;
        float f3 = this.q.f22204a;
        float f4 = this.q.b;
        this.p.f22204a += f3 * f2;
        this.p.b += f4 * f2;
        MotionEvent obtain = MotionEvent.obtain(currentAnimationTimeMillis, currentAnimationTimeMillis, 2, this.p.f22204a, this.p.b, 0);
        float f5 = ((BarLineChartBase) this.e).m() ? this.p.f22204a - this.h.f22204a : 0.0f;
        if (((BarLineChartBase) this.e).n()) {
            f = this.p.b - this.h.b;
        }
        a(obtain, f5, f);
        obtain.recycle();
        this.f = ((BarLineChartBase) this.e).getViewPortHandler().a(this.f, this.e, false);
        this.o = currentAnimationTimeMillis;
        if (Math.abs(this.q.f22204a) >= 0.01d || Math.abs(this.q.b) >= 0.01d) {
            Utils.a(this.e);
            return;
        }
        ((BarLineChartBase) this.e).j();
        ((BarLineChartBase) this.e).postInvalidate();
        a();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.f22159a = ChartTouchListener.ChartGesture.DOUBLE_TAP;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.b(motionEvent);
        }
        if (((BarLineChartBase) this.e).q() && ((BarLineScatterCandleBubbleData) ((BarLineChartBase) this.e).getData()).j() > 0) {
            MPPointF a2 = a(motionEvent.getX(), motionEvent.getY());
            BarLineChartBase barLineChartBase = (BarLineChartBase) this.e;
            float f = 1.4f;
            float f2 = ((BarLineChartBase) this.e).o() ? 1.4f : 1.0f;
            if (!((BarLineChartBase) this.e).p()) {
                f = 1.0f;
            }
            barLineChartBase.a(f2, f, a2.f22204a, a2.b);
            if (((BarLineChartBase) this.e).z()) {
                Log.i("BarlineChartTouch", "Double-Tap, Zooming In, x: " + a2.f22204a + ", y: " + a2.b);
            }
            MPPointF.b(a2);
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f22159a = ChartTouchListener.ChartGesture.FLING;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent, motionEvent2, f, f2);
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.f22159a = ChartTouchListener.ChartGesture.LONG_PRESS;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f22159a = ChartTouchListener.ChartGesture.SINGLE_TAP;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.c(motionEvent);
        }
        if (((BarLineChartBase) this.e).w()) {
            a(((BarLineChartBase) this.e).a(motionEvent.getX(), motionEvent.getY()), motionEvent);
            return super.onSingleTapUp(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x022b, code lost:
        if (((com.github.mikephil.charting.charts.BarLineChartBase) r6.e).u() == false) goto L96;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 1015
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.listener.BarLineChartTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
