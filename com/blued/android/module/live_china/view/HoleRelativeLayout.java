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

    /* renamed from: a  reason: collision with root package name */
    private List<RoundRect> f14303a;
    private Paint b;

    /* renamed from: c  reason: collision with root package name */
    private Xfermode f14304c;
    private int d;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/HoleRelativeLayout$RoundRect.class */
    public static class RoundRect {

        /* renamed from: a  reason: collision with root package name */
        public float f14305a;
        public float b;

        /* renamed from: c  reason: collision with root package name */
        public float f14306c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;
        public boolean i;

        public float a() {
            return this.f14306c;
        }

        public float b() {
            return this.d;
        }

        public String toString() {
            return "RoundRect{x=" + this.f14305a + ", y=" + this.b + ", width=" + this.f14306c + ", height=" + this.d + ", leftTopRadius=" + this.e + ", rightTopRadius=" + this.f + ", leftBottomRadius=" + this.g + ", rightBottomRadius=" + this.h + '}';
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
        this.f14303a = new ArrayList();
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.f14304c = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }

    private void a(Canvas canvas, RoundRect roundRect) {
        Path path = new Path();
        path.moveTo(roundRect.f14305a + roundRect.e, roundRect.b);
        path.lineTo((roundRect.f14305a + roundRect.f14306c) - roundRect.f, roundRect.b);
        path.addCircle(roundRect.f14305a + (roundRect.a() / 2.0f), roundRect.b + (roundRect.b() / 2.0f), roundRect.a() / 2.0f, Path.Direction.CW);
        path.close();
        canvas.drawPath(path, this.b);
    }

    private void b(Canvas canvas, RoundRect roundRect) {
        Path path = new Path();
        path.moveTo(roundRect.f14305a + roundRect.e, roundRect.b);
        path.lineTo((roundRect.f14305a + roundRect.f14306c) - roundRect.f, roundRect.b);
        path.arcTo(new RectF((roundRect.f14305a + roundRect.f14306c) - (roundRect.f * 2.0f), roundRect.b, roundRect.f14305a + roundRect.f14306c, roundRect.b + (roundRect.f * 2.0f)), 270.0f, 90.0f);
        path.lineTo(roundRect.f14305a + roundRect.f14306c, (roundRect.b + roundRect.d) - roundRect.h);
        path.arcTo(new RectF((roundRect.f14305a + roundRect.f14306c) - (roundRect.h * 2.0f), (roundRect.b + roundRect.d) - (roundRect.h * 2.0f), roundRect.f14305a + roundRect.f14306c, roundRect.b + roundRect.d), 0.0f, 90.0f);
        path.lineTo(roundRect.f14305a + roundRect.g, roundRect.b + roundRect.d);
        path.arcTo(new RectF(roundRect.f14305a, (roundRect.b + roundRect.d) - (roundRect.g * 2.0f), roundRect.f14305a + (roundRect.g * 2.0f), roundRect.b + roundRect.d), 90.0f, 90.0f);
        path.lineTo(roundRect.f14305a, roundRect.b + roundRect.e);
        path.arcTo(new RectF(roundRect.f14305a, roundRect.b, roundRect.f14305a + (roundRect.e * 2.0f), roundRect.b + (roundRect.e * 2.0f)), 180.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.b);
    }

    public void a(RoundRect roundRect) {
        this.f14303a.add(roundRect);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.drawColor(this.d);
        this.b.setXfermode(this.f14304c);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f14303a.size()) {
                this.b.setXfermode(null);
                canvas.restoreToCount(saveLayer);
                return;
            }
            RoundRect roundRect = this.f14303a.get(i2);
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
            if (i2 >= this.f14303a.size()) {
                return true;
            }
            RoundRect roundRect = this.f14303a.get(i2);
            if (motionEvent.getX() >= roundRect.f14305a && motionEvent.getX() <= roundRect.f14305a + roundRect.f14306c && motionEvent.getY() >= roundRect.b && motionEvent.getY() <= roundRect.b + roundRect.d) {
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
