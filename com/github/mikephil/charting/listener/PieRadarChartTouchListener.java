package com.github.mikephil.charting.listener;

import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/listener/PieRadarChartTouchListener.class */
public class PieRadarChartTouchListener extends ChartTouchListener<PieRadarChartBase<?>> {
    private MPPointF f;
    private float g;
    private ArrayList<AngularVelocitySample> h;
    private long i;
    private float j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/listener/PieRadarChartTouchListener$AngularVelocitySample.class */
    public class AngularVelocitySample {

        /* renamed from: a  reason: collision with root package name */
        public long f22163a;
        public float b;

        public AngularVelocitySample(long j, float f) {
            this.f22163a = j;
            this.b = f;
        }
    }

    public PieRadarChartTouchListener(PieRadarChartBase<?> pieRadarChartBase) {
        super(pieRadarChartBase);
        this.f = MPPointF.a(0.0f, 0.0f);
        this.g = 0.0f;
        this.h = new ArrayList<>();
        this.i = 0L;
        this.j = 0.0f;
    }

    private void c() {
        this.h.clear();
    }

    private void c(float f, float f2) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.h.add(new AngularVelocitySample(currentAnimationTimeMillis, ((PieRadarChartBase) this.e).b(f, f2)));
        int size = this.h.size();
        while (true) {
            int i = size;
            if (i - 2 <= 0 || currentAnimationTimeMillis - this.h.get(0).f22163a <= 1000) {
                return;
            }
            this.h.remove(0);
            size = i - 1;
        }
    }

    private float d() {
        if (this.h.isEmpty()) {
            return 0.0f;
        }
        AngularVelocitySample angularVelocitySample = this.h.get(0);
        ArrayList<AngularVelocitySample> arrayList = this.h;
        AngularVelocitySample angularVelocitySample2 = arrayList.get(arrayList.size() - 1);
        AngularVelocitySample angularVelocitySample3 = angularVelocitySample;
        for (int size = this.h.size() - 1; size >= 0; size--) {
            angularVelocitySample3 = this.h.get(size);
            if (angularVelocitySample3.b != angularVelocitySample2.b) {
                break;
            }
        }
        float f = ((float) (angularVelocitySample2.f22163a - angularVelocitySample.f22163a)) / 1000.0f;
        float f2 = f;
        if (f == 0.0f) {
            f2 = 0.1f;
        }
        boolean z = angularVelocitySample2.b >= angularVelocitySample3.b;
        boolean z2 = z;
        if (Math.abs(angularVelocitySample2.b - angularVelocitySample3.b) > 270.0d) {
            z2 = !z;
        }
        if (angularVelocitySample2.b - angularVelocitySample.b > 180.0d) {
            angularVelocitySample.b = (float) (angularVelocitySample.b + 360.0d);
        } else if (angularVelocitySample.b - angularVelocitySample2.b > 180.0d) {
            angularVelocitySample2.b = (float) (angularVelocitySample2.b + 360.0d);
        }
        float abs = Math.abs((angularVelocitySample2.b - angularVelocitySample.b) / f2);
        float f3 = abs;
        if (!z2) {
            f3 = -abs;
        }
        return f3;
    }

    public void a() {
        this.j = 0.0f;
    }

    public void a(float f, float f2) {
        this.g = ((PieRadarChartBase) this.e).b(f, f2) - ((PieRadarChartBase) this.e).getRawRotationAngle();
    }

    public void b() {
        if (this.j == 0.0f) {
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.j *= ((PieRadarChartBase) this.e).getDragDecelerationFrictionCoef();
        ((PieRadarChartBase) this.e).setRotationAngle(((PieRadarChartBase) this.e).getRotationAngle() + (this.j * (((float) (currentAnimationTimeMillis - this.i)) / 1000.0f)));
        this.i = currentAnimationTimeMillis;
        if (Math.abs(this.j) >= 0.001d) {
            Utils.a(this.e);
        } else {
            a();
        }
    }

    public void b(float f, float f2) {
        ((PieRadarChartBase) this.e).setRotationAngle(((PieRadarChartBase) this.e).b(f, f2) - this.g);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.f22159a = ChartTouchListener.ChartGesture.LONG_PRESS;
        OnChartGestureListener onChartGestureListener = ((PieRadarChartBase) this.e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f22159a = ChartTouchListener.ChartGesture.SINGLE_TAP;
        OnChartGestureListener onChartGestureListener = ((PieRadarChartBase) this.e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.c(motionEvent);
        }
        if (((PieRadarChartBase) this.e).w()) {
            a(((PieRadarChartBase) this.e).a(motionEvent.getX(), motionEvent.getY()), motionEvent);
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.d.onTouchEvent(motionEvent) && ((PieRadarChartBase) this.e).k()) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                a(motionEvent);
                a();
                c();
                if (((PieRadarChartBase) this.e).y()) {
                    c(x, y);
                }
                a(x, y);
                this.f.f22204a = x;
                this.f.b = y;
                return true;
            } else if (action == 1) {
                if (((PieRadarChartBase) this.e).y()) {
                    a();
                    c(x, y);
                    float d = d();
                    this.j = d;
                    if (d != 0.0f) {
                        this.i = AnimationUtils.currentAnimationTimeMillis();
                        Utils.a(this.e);
                    }
                }
                ((PieRadarChartBase) this.e).B();
                this.b = 0;
                b(motionEvent);
                return true;
            } else if (action != 2) {
                return true;
            } else {
                if (((PieRadarChartBase) this.e).y()) {
                    c(x, y);
                }
                if (this.b == 0 && a(x, this.f.f22204a, y, this.f.b) > Utils.a(8.0f)) {
                    this.f22159a = ChartTouchListener.ChartGesture.ROTATE;
                    this.b = 6;
                    ((PieRadarChartBase) this.e).A();
                } else if (this.b == 6) {
                    b(x, y);
                    ((PieRadarChartBase) this.e).invalidate();
                }
                b(motionEvent);
                return true;
            }
        }
        return true;
    }
}
