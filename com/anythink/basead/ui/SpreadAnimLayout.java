package com.anythink.basead.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.anythink.core.common.k.h;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/SpreadAnimLayout.class */
public class SpreadAnimLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Paint f6195a;
    private ValueAnimator b;

    /* renamed from: c  reason: collision with root package name */
    private a f6196c;
    private RectF d;
    private RectF e;
    private int f;
    private int g;
    private int h;
    private Paint i;
    private boolean j;
    private boolean k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/SpreadAnimLayout$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        RectF f6199a;
        int b;

        a() {
        }
    }

    public SpreadAnimLayout(Context context) {
        this(context, null, 0);
    }

    public SpreadAnimLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SpreadAnimLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = true;
        setWillNotDraw(false);
        int color = getResources().getColor(h.a(context, "color_spread", "color"));
        this.g = getResources().getDimensionPixelSize(h.a(getContext(), "myoffer_spread_max_distance_normal", "dimen"));
        this.f = h.a(context, 4.0f);
        this.h = 1000;
        Paint paint = new Paint();
        this.f6195a = paint;
        paint.setAntiAlias(true);
        this.f6195a.setAlpha(255);
        this.f6195a.setColor(color);
        Paint paint2 = new Paint(1);
        this.i = paint2;
        paint2.setColor(-1);
        this.i.setStyle(Paint.Style.FILL);
        this.i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void draw(Canvas canvas) {
        if (!this.j || !this.k) {
            super.draw(canvas);
            return;
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        this.f6195a.setAlpha(this.f6196c.b);
        RectF rectF = this.f6196c.f6199a;
        int i = this.f;
        canvas.drawRoundRect(rectF, i, i, this.f6195a);
        RectF rectF2 = this.d;
        int i2 = this.f;
        canvas.drawRoundRect(rectF2, i2, i2, this.i);
        canvas.restoreToCount(saveLayer);
        super.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.g;
        setPadding(i3, i3, i3, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.j) {
            if (i == 0) {
                post(new Runnable() { // from class: com.anythink.basead.ui.SpreadAnimLayout.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpreadAnimLayout.this.startSpreadAnimation();
                    }
                });
                return;
            }
            ValueAnimator valueAnimator = this.b;
            if (valueAnimator != null) {
                valueAnimator.end();
            }
        }
    }

    public void setMaxSpreadDistance(int i) {
        this.g = i;
    }

    public void startSpreadAnimation() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        this.j = true;
        if (!this.k) {
            this.d = new RectF(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            this.e = new RectF(this.d);
            a aVar = new a();
            this.f6196c = aVar;
            aVar.b = 255;
            this.f6196c.f6199a = this.e;
            this.g = Math.min(this.g, Math.min((getWidth() - childAt.getWidth()) / 2, (getHeight() - childAt.getHeight()) / 2));
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.b = ofFloat;
            ofFloat.setDuration(this.h);
            this.b.setRepeatMode(1);
            this.b.setRepeatCount(-1);
            this.b.setInterpolator(new AccelerateDecelerateInterpolator());
            this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.ui.SpreadAnimLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    SpreadAnimLayout.this.f6196c.b = (int) ((1.0f - floatValue) * 255.0f);
                    SpreadAnimLayout.this.f6196c.f6199a.set(SpreadAnimLayout.this.d);
                    float f = -((int) (SpreadAnimLayout.this.g * floatValue));
                    SpreadAnimLayout.this.f6196c.f6199a.inset(f, f);
                    SpreadAnimLayout.this.invalidate();
                }
            });
            this.k = true;
        }
        this.b.start();
    }
}
