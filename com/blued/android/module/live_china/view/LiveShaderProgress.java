package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveShaderProgress.class */
public class LiveShaderProgress extends View {

    /* renamed from: a  reason: collision with root package name */
    protected OnProgressListener f14923a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f14924c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveShaderProgress$OnProgressListener.class */
    public interface OnProgressListener {
        void a(LiveShaderProgress liveShaderProgress, int i);
    }

    public LiveShaderProgress(Context context) {
        super(context);
        this.b = 0;
        a(context, (AttributeSet) null);
    }

    public LiveShaderProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        a(context, attributeSet);
    }

    public LiveShaderProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
        a(context, attributeSet);
    }

    private Paint a(int i, Paint.Style style, float f) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStyle(style);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(f);
        return paint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        invalidate();
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            setProgressMax(100);
            this.g = -15098;
            this.h = -15098;
            this.i = -789517;
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LiveShaderProgress);
        setProgressMax(obtainStyledAttributes.getInteger(R.styleable.LiveShaderProgress_ls_max_value, 100));
        this.i = obtainStyledAttributes.getColor(R.styleable.LiveShaderProgress_ls_background_color, -1907998);
        this.g = obtainStyledAttributes.getColor(R.styleable.LiveShaderProgress_ls_gradient_start_color, -50518);
        this.h = obtainStyledAttributes.getColor(R.styleable.LiveShaderProgress_ls_gradient_end_color, -7197458);
        obtainStyledAttributes.recycle();
    }

    private void a(Canvas canvas, Paint paint) {
        int i = this.e;
        float f = i / 2;
        float f2 = i / 2;
        canvas.drawLine(f, f2, this.d - (i / 2), f2, paint);
    }

    private void b(Canvas canvas, Paint paint) {
        int i = this.e;
        float f = i / 2;
        float f2 = i / 2;
        float f3 = this.f + f;
        int i2 = this.d;
        if (f3 > i2 - (i / 2)) {
            f3 = i2 - (i / 2);
        }
        if (this.g != this.h) {
            paint.setShader(new LinearGradient(f, f2, f3, f2, this.g, this.h, Shader.TileMode.CLAMP));
        }
        canvas.drawLine(f, f2, f3, f2, paint);
    }

    public int getProgress() {
        return this.b;
    }

    public int getProgressMax() {
        return this.f14924c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f = (int) ((this.d - this.e) * (this.b / this.f14924c));
        a(canvas, a(this.i, Paint.Style.FILL, this.e));
        if (this.b != 0) {
            b(canvas, a(this.g, Paint.Style.FILL, this.e));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.d = i;
        this.e = i2;
        this.f = (int) ((i - i2) * (this.b / this.f14924c));
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveShaderProgress$4HoZxKqaON7edUJf_YIYHcf855k
            @Override // java.lang.Runnable
            public final void run() {
                LiveShaderProgress.this.a();
            }
        });
    }

    public void setProgress(float f) {
        float f2 = f;
        if (f < 0.0f) {
            f2 = 0.0f;
        }
        int i = this.f14924c;
        float f3 = f2;
        if (f2 > i) {
            f3 = i;
        }
        int i2 = (int) f3;
        this.b = i2;
        OnProgressListener onProgressListener = this.f14923a;
        if (onProgressListener != null) {
            onProgressListener.a(this, i2);
        }
        invalidate();
    }

    public void setProgressListener(OnProgressListener onProgressListener) {
        this.f14923a = onProgressListener;
    }

    public void setProgressMax(int i) {
        this.f14924c = i;
    }
}
