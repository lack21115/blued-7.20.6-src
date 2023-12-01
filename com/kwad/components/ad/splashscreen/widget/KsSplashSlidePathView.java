package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/widget/KsSplashSlidePathView.class */
public class KsSplashSlidePathView extends ImageView {
    private Path FD;
    private Paint FE;
    private float FF;
    private float FG;
    private float FH;
    private float FI;
    private int FJ;
    private a FK;
    private GestureDetector FL;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/widget/KsSplashSlidePathView$a.class */
    public interface a {
        void a(float f, float f2, float f3, float f4);

        void lf();
    }

    public KsSplashSlidePathView(Context context) {
        super(context);
        this.FJ = Color.parseColor("#66ffffff");
        init();
    }

    public KsSplashSlidePathView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.FJ = Color.parseColor("#66ffffff");
        init();
    }

    private void b(MotionEvent motionEvent) {
        if (this.FL.onTouchEvent(motionEvent)) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.FD.reset();
            this.FF = motionEvent.getX();
            float y = motionEvent.getY();
            this.FG = y;
            float f = this.FF;
            this.FH = f;
            this.FI = y;
            this.FD.moveTo(f, y);
            invalidate();
            if (this.FK != null) {
            }
        } else if (actionMasked != 1) {
            if (actionMasked != 2) {
                return;
            }
            c(motionEvent.getX(), motionEvent.getY());
            invalidate();
        } else {
            this.FD.reset();
            invalidate();
            a aVar = this.FK;
            if (aVar != null) {
                aVar.a(this.FF, this.FG, motionEvent.getX(), motionEvent.getY());
            }
        }
    }

    private void c(float f, float f2) {
        float abs = Math.abs(f - this.FH);
        float abs2 = Math.abs(f2 - this.FI);
        if (abs >= 3.0f || abs2 >= 3.0f) {
            Path path = this.FD;
            float f3 = this.FH;
            float f4 = this.FI;
            path.quadTo(f3, f4, (f + f3) / 2.0f, (f2 + f4) / 2.0f);
            this.FH = f;
            this.FI = f2;
        }
    }

    private void init() {
        this.FD = new Path();
        Paint paint = new Paint();
        this.FE = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.FE.setStrokeWidth(com.kwad.sdk.c.kwai.a.a(getContext(), 15.0f));
        this.FE.setStyle(Paint.Style.STROKE);
        this.FE.setColor(this.FJ);
        this.FE.setDither(true);
        this.FL = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                if (KsSplashSlidePathView.this.FK != null) {
                    KsSplashSlidePathView.this.FK.lf();
                    return true;
                }
                return false;
            }
        });
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.FD, this.FE);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b(motionEvent);
        return true;
    }

    public void setOnSlideTouchListener(a aVar) {
        this.FK = aVar;
    }
}
