package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.live_china.view.shimmer.ShimmerTextView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMsgShimmerTextView.class */
public class LiveMsgShimmerTextView extends ShimmerTextView {
    Path a;
    Path b;
    private LinearGradient c;
    private Paint d;
    private Paint e;
    private int f;
    private int g;
    private int h;
    private int i;

    public LiveMsgShimmerTextView(Context context) {
        super(context);
        this.a = new Path();
        this.b = new Path();
        b();
    }

    public LiveMsgShimmerTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Path();
        this.b = new Path();
        b();
    }

    public LiveMsgShimmerTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Path();
        this.b = new Path();
        b();
    }

    private void b() {
        this.f = DisplayUtil.a(getContext(), 17.0f);
        this.g = DisplayUtil.a(getContext(), 2.0f);
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setDither(true);
        this.e.setColor(Color.parseColor("#66000000"));
        this.e.setStrokeWidth(this.g);
        this.e.setStyle(Paint.Style.FILL);
    }

    private Paint getBorderPaint() {
        if (this.d == null) {
            Paint paint = new Paint();
            this.d = paint;
            paint.setAntiAlias(true);
            this.d.setDither(true);
            this.d.setColor(Color.parseColor("#000000"));
            this.d.setStrokeWidth(this.g);
            this.d.setStyle(Paint.Style.FILL);
        }
        return this.d;
    }

    @Override // com.blued.android.module.live_china.view.shimmer.ShimmerTextView
    public void onDraw(Canvas canvas) {
        int i = this.i;
        if (i > 0) {
            Paint paint = this.e;
            if (paint != null) {
                int i2 = this.g;
                float f = i2;
                float f2 = i2;
                float f3 = this.h;
                float f4 = i;
                int i3 = this.f;
                canvas.drawRoundRect(f, f2, f3, f4, i3, i3, paint);
            }
            this.b.reset();
            Path path = this.b;
            int i4 = this.g;
            float f5 = i4;
            float f6 = i4;
            float f7 = this.h - i4;
            float f8 = this.i - i4;
            int i5 = this.f;
            path.addRoundRect(f5, f6, f7, f8, i5, i5, Path.Direction.CW);
            this.b.close();
            this.a.reset();
            Path path2 = this.a;
            float f9 = this.h;
            float f10 = this.i;
            int i6 = this.f;
            path2.addRoundRect(0.0f, 0.0f, f9, f10, i6, i6, Path.Direction.CW);
            this.a.op(this.b, Path.Op.DIFFERENCE);
            this.a.close();
            canvas.drawPath(this.a, getBorderPaint());
        }
        super.onDraw(canvas);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i3 - i;
        if (i5 <= 0 || i5 == this.h) {
            return;
        }
        this.h = i5;
        this.i = getMeasuredHeight();
        int i6 = this.i;
        this.c = new LinearGradient(0.0f, i6, this.h, i6, new int[]{-8242447, -2775041, -8242447}, (float[]) null, Shader.TileMode.REPEAT);
        getBorderPaint().setShader(this.c);
    }
}
