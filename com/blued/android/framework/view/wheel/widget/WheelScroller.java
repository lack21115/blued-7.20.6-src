package com.blued.android.framework.view.wheel.widget;

import android.content.Context;
import android.media.AudioSystem;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/wheel/widget/WheelScroller.class */
public class WheelScroller {

    /* renamed from: a  reason: collision with root package name */
    private ScrollingListener f10353a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private GestureDetector f10354c;
    private Scroller d;
    private int e;
    private float f;
    private boolean g;
    private GestureDetector.SimpleOnGestureListener h = new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.framework.view.wheel.widget.WheelScroller.1
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            WheelScroller.this.e = 0;
            WheelScroller.this.d.fling(0, WheelScroller.this.e, 0, (int) (-f2), 0, 0, AudioSystem.DEVICE_IN_COMMUNICATION, Integer.MAX_VALUE);
            WheelScroller.this.a(0);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return true;
        }
    };
    private final int i = 0;
    private final int j = 1;
    private Handler k = new Handler() { // from class: com.blued.android.framework.view.wheel.widget.WheelScroller.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WheelScroller.this.d.computeScrollOffset();
            int currY = WheelScroller.this.d.getCurrY();
            int i = WheelScroller.this.e - currY;
            WheelScroller.this.e = currY;
            if (i != 0) {
                WheelScroller.this.f10353a.a(i);
            }
            if (Math.abs(currY - WheelScroller.this.d.getFinalY()) < 1) {
                WheelScroller.this.d.getFinalY();
                WheelScroller.this.d.forceFinished(true);
            }
            if (!WheelScroller.this.d.isFinished()) {
                WheelScroller.this.k.sendEmptyMessage(message.what);
            } else if (message.what == 0) {
                WheelScroller.this.d();
            } else {
                WheelScroller.this.b();
            }
        }
    };

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/wheel/widget/WheelScroller$ScrollingListener.class */
    public interface ScrollingListener {
        void a();

        void a(int i);

        void b();

        void c();
    }

    public WheelScroller(Context context, ScrollingListener scrollingListener) {
        GestureDetector gestureDetector = new GestureDetector(context, this.h);
        this.f10354c = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.d = new Scroller(context);
        this.f10353a = scrollingListener;
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        c();
        this.k.sendEmptyMessage(i);
    }

    private void c() {
        this.k.removeMessages(0);
        this.k.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f10353a.c();
        a(1);
    }

    private void e() {
        if (this.g) {
            return;
        }
        this.g = true;
        this.f10353a.a();
    }

    public void a() {
        this.d.forceFinished(true);
    }

    public void a(int i, int i2) {
        this.d.forceFinished(true);
        this.e = 0;
        Scroller scroller = this.d;
        if (i2 == 0) {
            i2 = 400;
        }
        scroller.startScroll(0, 0, 0, i, i2);
        a(0);
        e();
    }

    public void a(Interpolator interpolator) {
        this.d.forceFinished(true);
        this.d = new Scroller(this.b, interpolator);
    }

    public boolean a(MotionEvent motionEvent) {
        int y;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f = motionEvent.getY();
            this.d.forceFinished(true);
            c();
        } else if (action == 2 && (y = (int) (motionEvent.getY() - this.f)) != 0) {
            e();
            this.f10353a.a(y);
            this.f = motionEvent.getY();
        }
        if (this.f10354c.onTouchEvent(motionEvent) || motionEvent.getAction() != 1) {
            return true;
        }
        d();
        return true;
    }

    void b() {
        if (this.g) {
            this.f10353a.b();
            this.g = false;
        }
    }
}
