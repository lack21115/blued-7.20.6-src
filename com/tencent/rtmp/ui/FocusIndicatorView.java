package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.ScaleAnimation;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/ui/FocusIndicatorView.class */
public class FocusIndicatorView extends View {

    /* renamed from: a  reason: collision with root package name */
    final ScaleAnimation f24992a;
    private final Paint b;

    /* renamed from: c  reason: collision with root package name */
    private final int f24993c;
    private final Rect d;

    public FocusIndicatorView(Context context) {
        this(context, null);
    }

    public FocusIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FocusIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new Rect();
        this.f24993c = (int) ((getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        Paint paint = new Paint();
        this.b = paint;
        paint.setColor(-1);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setStrokeWidth(this.f24993c);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.f24992a = scaleAnimation;
        scaleAnimation.setDuration(200L);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i = this.f24993c / 2;
        this.d.left = i;
        this.d.top = i;
        this.d.right = getWidth() - i;
        this.d.bottom = getHeight() - i;
        canvas.drawRect(this.d, this.b);
    }
}
