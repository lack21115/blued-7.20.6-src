package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.blued.android.module.live_china.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/HoleRelativeLayout.class */
public class HoleRelativeLayout extends RelativeLayout {
    private List<RoundRect> a;
    private Paint b;
    private Xfermode c;
    private int d;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/HoleRelativeLayout$RoundRect.class */
    public static class RoundRect {
        public float a;
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;
        public boolean i;

        public float a() {
            return this.c;
        }

        public float b() {
            return this.d;
        }

        public String toString() {
            return "RoundRect{x=" + this.a + ", y=" + this.b + ", width=" + this.c + ", height=" + this.d + ", leftTopRadius=" + this.e + ", rightTopRadius=" + this.f + ", leftBottomRadius=" + this.g + ", rightBottomRadius=" + this.h + '}';
        }
    }

    public HoleRelativeLayout(Context context) {
        this(context, null);
    }

    public HoleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HoleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = -1;
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HoleRelativeLayout);
        this.d = obtainStyledAttributes.getColor(R.styleable.HoleRelativeLayout_bgColor, this.d);
        obtainStyledAttributes.recycle();
        this.a = new ArrayList();
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.c = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }

    private void a(Canvas canvas, RoundRect roundRect) {
        Path path = new Path();
        path.moveTo(roundRect.a + roundRect.e, roundRect.b);
        path.lineTo((roundRect.a + roundRect.c) - roundRect.f, roundRect.b);
        path.addCircle(roundRect.a + (roundRect.a() / 2.0f), roundRect.b + (roundRect.b() / 2.0f), roundRect.a() / 2.0f, Path.Direction.CW);
        path.close();
        canvas.drawPath(path, this.b);
    }

    private void b(Canvas canvas, RoundRect roundRect) {
        Path path = new Path();
        path.moveTo(roundRect.a + roundRect.e, roundRect.b);
        path.lineTo((roundRect.a + roundRect.c) - roundRect.f, roundRect.b);
        path.arcTo(new RectF((roundRect.a + roundRect.c) - (roundRect.f * 2.0f), roundRect.b, roundRect.a + roundRect.c, roundRect.b + (roundRect.f * 2.0f)), 270.0f, 90.0f);
        path.lineTo(roundRect.a + roundRect.c, (roundRect.b + roundRect.d) - roundRect.h);
        path.arcTo(new RectF((roundRect.a + roundRect.c) - (roundRect.h * 2.0f), (roundRect.b + roundRect.d) - (roundRect.h * 2.0f), roundRect.a + roundRect.c, roundRect.b + roundRect.d), 0.0f, 90.0f);
        path.lineTo(roundRect.a + roundRect.g, roundRect.b + roundRect.d);
        path.arcTo(new RectF(roundRect.a, (roundRect.b + roundRect.d) - (roundRect.g * 2.0f), roundRect.a + (roundRect.g * 2.0f), roundRect.b + roundRect.d), 90.0f, 90.0f);
        path.lineTo(roundRect.a, roundRect.b + roundRect.e);
        path.arcTo(new RectF(roundRect.a, roundRect.b, roundRect.a + (roundRect.e * 2.0f), roundRect.b + (roundRect.e * 2.0f)), 180.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.b);
    }

    public void a(RoundRect roundRect) {
        this.a.add(roundRect);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.drawColor(this.d);
        this.b.setXfermode(this.c);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.a.size()) {
                this.b.setXfermode(null);
                canvas.restoreToCount(saveLayer);
                return;
            }
            RoundRect roundRect = this.a.get(i2);
            if (roundRect.i) {
                a(canvas, roundRect);
            } else {
                b(canvas, roundRect);
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.a.size()) {
                return true;
            }
            RoundRect roundRect = this.a.get(i2);
            if (motionEvent.getX() >= roundRect.a && motionEvent.getX() <= roundRect.a + roundRect.c && motionEvent.getY() >= roundRect.b && motionEvent.getY() <= roundRect.b + roundRect.d) {
                return super.onTouchEvent(motionEvent);
            }
            i = i2 + 1;
        }
    }

    public void setBgColor(int i) {
        this.d = i;
        invalidate();
    }
}
