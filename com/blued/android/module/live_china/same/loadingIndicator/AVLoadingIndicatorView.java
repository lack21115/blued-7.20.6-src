package com.blued.android.module.live_china.same.loadingIndicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.same.loadingIndicator.BaseIndicatorController;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/same/loadingIndicator/AVLoadingIndicatorView.class */
public class AVLoadingIndicatorView extends View {

    /* renamed from: a  reason: collision with root package name */
    int f14105a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    Paint f14106c;
    BaseIndicatorController d;
    private boolean e;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/same/loadingIndicator/AVLoadingIndicatorView$Indicator.class */
    public @interface Indicator {
    }

    public AVLoadingIndicatorView(Context context) {
        super(context);
        a((AttributeSet) null, 0);
    }

    public AVLoadingIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, 0);
    }

    public AVLoadingIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet, i);
    }

    public AVLoadingIndicatorView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(attributeSet, i);
    }

    private int a(int i) {
        return ((int) getContext().getResources().getDisplayMetrics().density) * i;
    }

    private int a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        int i3 = i;
        if (mode == Integer.MIN_VALUE) {
            i3 = Math.min(i, size);
        }
        return i3;
    }

    private void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AVLoadingIndicatorView);
        this.f14105a = obtainStyledAttributes.getInt(R.styleable.AVLoadingIndicatorView_indicator, 0);
        this.b = obtainStyledAttributes.getColor(R.styleable.AVLoadingIndicatorView_indicator_color, -1);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f14106c = paint;
        paint.setColor(this.b);
        this.f14106c.setStyle(Paint.Style.FILL);
        this.f14106c.setAntiAlias(true);
        b();
    }

    private void b() {
        switch (this.f14105a) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 19:
            case 20:
            case 21:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
                break;
            case 18:
                this.d = new LineScalePulseOutIndicator();
                break;
            case 22:
                this.d = new BallSpinFadeLoaderIndicator();
                break;
            default:
                this.d = new BallSpinFadeLoaderIndicator();
                break;
        }
        BaseIndicatorController baseIndicatorController = this.d;
        if (baseIndicatorController != null) {
            baseIndicatorController.a(this);
        }
    }

    void a() {
        this.d.f();
    }

    void a(Canvas canvas) {
        this.d.a(canvas, this.f14106c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.e) {
            this.d.a(BaseIndicatorController.AnimStatus.START);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d.a(BaseIndicatorController.AnimStatus.CANCEL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.e) {
            return;
        }
        this.e = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(a(a(45), i), a(a(45), i2));
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
            if (i == 8 || i == 4) {
                this.d.a(BaseIndicatorController.AnimStatus.END);
            } else {
                this.d.a(BaseIndicatorController.AnimStatus.START);
            }
        }
    }
}
