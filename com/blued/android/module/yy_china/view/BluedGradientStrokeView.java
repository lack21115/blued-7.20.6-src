package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/BluedGradientStrokeView.class */
public class BluedGradientStrokeView extends LinearLayout {
    private Paint a;
    private Xfermode b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private int i;
    private RoundRect j;
    private Path k;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/BluedGradientStrokeView$RoundRect.class */
    class RoundRect {
        public float a;
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;

        private RoundRect() {
        }
    }

    public BluedGradientStrokeView(Context context) {
        this(context, null);
    }

    public BluedGradientStrokeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BluedGradientStrokeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.k = new Path();
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BluedGradientStrokeView);
        this.c = obtainStyledAttributes.getDimension(R.styleable.BluedGradientStrokeView_stroke_width, 0.0f);
        this.d = obtainStyledAttributes.getDimension(R.styleable.BluedGradientStrokeView_left_top_radius, 0.0f);
        this.e = obtainStyledAttributes.getDimension(R.styleable.BluedGradientStrokeView_right_top_radius, 0.0f);
        this.f = obtainStyledAttributes.getDimension(R.styleable.BluedGradientStrokeView_bottom_left_radius, 0.0f);
        this.g = obtainStyledAttributes.getDimension(R.styleable.BluedGradientStrokeView_bottom_right_radius, 0.0f);
        this.h = obtainStyledAttributes.getDimension(R.styleable.BluedGradientStrokeView_radius, 0.0f);
        this.i = obtainStyledAttributes.getResourceId(R.styleable.BluedGradientStrokeView_storke_color, R.drawable.shape_raduis_6dp_66ffa3_3e93ff_4e9bff);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.b = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        this.a.setXfermode(this.b);
        RectF rectF = new RectF();
        rectF.set(this.j.a, this.j.b, this.j.c, this.j.d);
        this.k.reset();
        Path path = this.k;
        float f = this.h;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        this.k.setFillType(Path.FillType.WINDING);
        canvas.clipPath(this.k, Region.Op.DIFFERENCE);
        Drawable drawable = getResources().getDrawable(this.i);
        drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        drawable.draw(canvas);
        this.a.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        RoundRect roundRect = new RoundRect();
        this.j = roundRect;
        roundRect.a = this.c;
        this.j.b = this.c;
        this.j.c = getMeasuredWidth() - this.c;
        this.j.d = getMeasuredHeight() - this.c;
        RoundRect roundRect2 = this.j;
        float f = this.d;
        float f2 = f;
        if (f <= 0.0f) {
            f2 = this.h;
        }
        roundRect2.e = f2;
        RoundRect roundRect3 = this.j;
        float f3 = this.e;
        float f4 = f3;
        if (f3 <= 0.0f) {
            f4 = this.h;
        }
        roundRect3.f = f4;
        RoundRect roundRect4 = this.j;
        float f5 = this.f;
        float f6 = f5;
        if (f5 <= 0.0f) {
            f6 = this.h;
        }
        roundRect4.g = f6;
        RoundRect roundRect5 = this.j;
        float f7 = this.g;
        float f8 = f7;
        if (f7 <= 0.0f) {
            f8 = this.h;
        }
        roundRect5.h = f8;
    }
}
