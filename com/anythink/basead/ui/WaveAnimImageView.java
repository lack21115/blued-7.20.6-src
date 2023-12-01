package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/WaveAnimImageView.class */
public class WaveAnimImageView extends ImageView {
    int a;
    int b;
    private Paint c;
    private a d;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/WaveAnimImageView$a.class */
    public static class a {
        float a;
        float b;
        float c;

        public a(float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
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
        this.c = paint;
        paint.setAntiAlias(true);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setColor(Color.parseColor("#FFFFFF"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a aVar = this.d;
        if (aVar != null) {
            this.c.setAlpha((int) (aVar.c * 255.0f));
            this.c.setStrokeWidth(this.d.b);
            canvas.drawCircle(this.a, this.b, this.d.a, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.a = getWidth() / 2;
        this.b = getHeight() / 2;
    }

    public void setWaveAnimParams(a aVar) {
        this.d = aVar;
        invalidate();
    }
}
