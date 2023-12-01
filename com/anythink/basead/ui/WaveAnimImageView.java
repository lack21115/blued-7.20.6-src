package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/WaveAnimImageView.class */
public class WaveAnimImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    int f6206a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f6207c;
    private a d;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/WaveAnimImageView$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        float f6208a;
        float b;

        /* renamed from: c  reason: collision with root package name */
        float f6209c;

        public a(float f, float f2, float f3) {
            this.f6208a = f;
            this.b = f2;
            this.f6209c = f3;
        }
    }

    public WaveAnimImageView(Context context) {
        super(context);
        a();
    }

    public WaveAnimImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public WaveAnimImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f6207c = paint;
        paint.setAntiAlias(true);
        this.f6207c.setStyle(Paint.Style.STROKE);
        this.f6207c.setColor(Color.parseColor("#FFFFFF"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a aVar = this.d;
        if (aVar != null) {
            this.f6207c.setAlpha((int) (aVar.f6209c * 255.0f));
            this.f6207c.setStrokeWidth(this.d.b);
            canvas.drawCircle(this.f6206a, this.b, this.d.f6208a, this.f6207c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f6206a = getWidth() / 2;
        this.b = getHeight() / 2;
    }

    public void setWaveAnimParams(a aVar) {
        this.d = aVar;
        invalidate();
    }
}
