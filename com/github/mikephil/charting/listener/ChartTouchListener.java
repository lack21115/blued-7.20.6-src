package com.github.mikephil.charting.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.highlight.Highlight;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/listener/ChartTouchListener.class */
public abstract class ChartTouchListener<T extends Chart<?>> extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    protected ChartGesture f22159a = ChartGesture.NONE;
    protected int b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected Highlight f22160c;
    protected GestureDetector d;
    protected T e;

    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/listener/ChartTouchListener$ChartGesture.class */
    public enum ChartGesture {
        NONE,
        DRAG,
        X_ZOOM,
        Y_ZOOM,
        PINCH_ZOOM,
        ROTATE,
        SINGLE_TAP,
        DOUBLE_TAP,
        LONG_PRESS,
        FLING
    }

    public ChartTouchListener(T t) {
        this.e = t;
        this.d = new GestureDetector(t.getContext(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static float a(float f, float f2, float f3, float f4) {
        float f5 = f - f2;
        float f6 = f3 - f4;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }

    public void a(MotionEvent motionEvent) {
        OnChartGestureListener onChartGestureListener = this.e.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent, this.f22159a);
        }
    }

    public void a(Highlight highlight) {
        this.f22160c = highlight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Highlight highlight, MotionEvent motionEvent) {
        if (highlight == null || highlight.a(this.f22160c)) {
            this.e.a(null, true);
            this.f22160c = null;
            return;
        }
        this.e.a(highlight, true);
        this.f22160c = highlight;
    }

    public void b(MotionEvent motionEvent) {
        OnChartGestureListener onChartGestureListener = this.e.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.b(motionEvent, this.f22159a);
        }
    }
}
