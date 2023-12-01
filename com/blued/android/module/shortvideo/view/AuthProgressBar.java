package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/AuthProgressBar.class */
public class AuthProgressBar extends View {
    Paint a;
    Paint b;
    long c;
    long d;
    Handler e;
    Runnable f;
    private long g;

    public AuthProgressBar(Context context) {
        this(context, null);
    }

    public AuthProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AuthProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 100L;
        this.d = 0L;
        this.g = 0L;
        this.e = new Handler();
        this.f = new Runnable() { // from class: com.blued.android.module.shortvideo.view.AuthProgressBar.1
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis() - AuthProgressBar.this.g;
                if (currentTimeMillis > 5000) {
                    AuthProgressBar.this.e.removeCallbacks(AuthProgressBar.this.f);
                    return;
                }
                AuthProgressBar.this.setProgress(currentTimeMillis / 50);
                AuthProgressBar.this.e.postDelayed(this, 10L);
            }
        };
        c();
    }

    private void c() {
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setColor(-7829368);
        Paint paint2 = new Paint(1);
        this.b = paint2;
        paint2.setColor(-16776961);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(long j) {
        this.d = j;
        invalidate();
    }

    public void a() {
        Handler handler = this.e;
        if (handler != null) {
            handler.removeCallbacks(this.f);
            this.g = System.currentTimeMillis();
            this.e.postDelayed(this.f, 10L);
        }
    }

    public void b() {
        Handler handler = this.e;
        if (handler != null) {
            handler.removeCallbacks(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float f = width;
        int i = (int) (((((float) this.d) * f) / ((float) this.c)) / 2.0f);
        float f2 = i;
        float f3 = height;
        canvas.drawRect(0.0f, 0.0f, f2, f3, this.a);
        float f4 = width - i;
        canvas.drawRect(f4, 0.0f, f, f3, this.a);
        canvas.drawRect(f2, 0.0f, f4, f3, this.b);
    }

    public void setMaxProgress(long j) {
        this.c = j;
        invalidate();
    }
}
