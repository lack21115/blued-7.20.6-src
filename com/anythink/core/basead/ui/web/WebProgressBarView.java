package com.anythink.core.basead.ui.web;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/basead/ui/web/WebProgressBarView.class */
public class WebProgressBarView extends View {

    /* renamed from: a  reason: collision with root package name */
    int f6406a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    Paint f6407c;

    public WebProgressBarView(Context context) {
        super(context);
        a();
    }

    public WebProgressBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public WebProgressBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.b = -14575885;
        Paint paint = new Paint();
        this.f6407c = paint;
        paint.setColor(this.b);
        this.f6407c.setAntiAlias(true);
        this.f6407c.setDither(true);
        this.f6406a = 0;
        setBackgroundColor(16777215);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.drawRect(0.0f, 0.0f, (getWidth() * this.f6406a) / 100, getHeight(), this.f6407c);
        canvas.restore();
    }

    public void setProgress(int i) {
        this.f6406a = i;
        postInvalidate();
    }
}
