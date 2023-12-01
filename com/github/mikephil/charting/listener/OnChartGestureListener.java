package com.github.mikephil.charting.listener;

import android.view.MotionEvent;
import com.github.mikephil.charting.listener.ChartTouchListener;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/listener/OnChartGestureListener.class */
public interface OnChartGestureListener {
    void a(MotionEvent motionEvent);

    void a(MotionEvent motionEvent, float f, float f2);

    void a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

    void a(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture);

    void b(MotionEvent motionEvent);

    void b(MotionEvent motionEvent, float f, float f2);

    void b(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture);

    void c(MotionEvent motionEvent);
}
