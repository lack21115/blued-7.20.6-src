package com.blued.android.module.live_china.view;

import android.animation.ValueAnimator;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.Choreographer;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/WaveDrawable.class */
public class WaveDrawable extends Drawable implements ValueAnimator.AnimatorUpdateListener, Animatable {
    private static final PorterDuffXfermode p = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    private static ColorFilter q = new ColorMatrixColorFilter(new float[]{0.264f, 0.472f, 0.088f, 0.0f, 0.0f, 0.264f, 0.472f, 0.088f, 0.0f, 0.0f, 0.264f, 0.472f, 0.088f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});

    /* renamed from: a  reason: collision with root package name */
    private Drawable f15299a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f15300c;
    private Paint k;
    private Bitmap l;
    private int d = Integer.MIN_VALUE;
    private int e = Integer.MIN_VALUE;
    private int f = Integer.MIN_VALUE;
    private int g = 0;
    private int h = 0;
    private ValueAnimator i = null;
    private float j = 0.3f;
    private Matrix m = new Matrix();
    private boolean n = false;
    private boolean o = false;
    private ColorFilter r = null;
    private Choreographer.FrameCallback s = new Choreographer.FrameCallback() { // from class: com.blued.android.module.live_china.view.WaveDrawable.1
        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            WaveDrawable.this.invalidateSelf();
            if (WaveDrawable.this.n) {
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    };

    public WaveDrawable(Context context, int i) {
        a(Build.VERSION.SDK_INT >= 21 ? context.getDrawable(i) : context.getResources().getDrawable(i));
    }

    private void a(float f) {
        this.j = f;
        int i = this.f15300c;
        this.h = i - ((int) ((this.d + i) * f));
        invalidateSelf();
    }

    private void a(int i, int i2, int i3) {
        float f;
        if (i <= 0 || i2 <= 0 || i3 <= 0) {
            Log.w(ContentValues.TAG, "updateMask: size must > 0");
            this.l = null;
            return;
        }
        int ceil = (int) Math.ceil((i + i2) / f);
        Bitmap createBitmap = Bitmap.createBitmap(i2 * ceil, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        int i4 = i3 / 2;
        Path path = new Path();
        float f2 = i4;
        path.moveTo(0.0f, f2);
        float f3 = i2 / 4.0f;
        float f4 = -i4;
        float f5 = 0.0f;
        for (int i5 = 0; i5 < ceil * 2; i5++) {
            float f6 = f5 + f3;
            f5 = f6 + f3;
            path.quadTo(f6, f4, f5, f2);
            f4 = createBitmap.getHeight() - f4;
        }
        float width = createBitmap.getWidth();
        float f7 = i3;
        path.lineTo(width, f7);
        path.lineTo(0.0f, f7);
        path.close();
        canvas.drawPath(path, paint);
        this.l = createBitmap;
    }

    private void a(Rect rect) {
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        if (this.b < 0 || this.f15300c < 0) {
            this.b = rect.width();
            int height = rect.height();
            this.f15300c = height;
            if (this.d == Integer.MIN_VALUE) {
                this.d = Math.max(8, (int) (height * 0.2f));
            }
            if (this.e == Integer.MIN_VALUE) {
                this.e = this.b;
            }
            if (this.f == Integer.MIN_VALUE) {
                this.f = Math.max(1, (int) (this.b * 0.02f));
            }
            a(this.b, this.e, this.d);
        }
    }

    private void a(Drawable drawable) {
        this.f15299a = drawable;
        this.m.reset();
        Paint paint = new Paint();
        this.k = paint;
        paint.setFilterBitmap(false);
        this.k.setColor(-16777216);
        this.k.setXfermode(p);
        this.b = this.f15299a.getIntrinsicWidth();
        int intrinsicHeight = this.f15299a.getIntrinsicHeight();
        this.f15300c = intrinsicHeight;
        int i = this.b;
        if (i > 0 && intrinsicHeight > 0) {
            this.e = i;
            this.d = Math.max(8, (int) (intrinsicHeight * 0.2f));
            this.f = Math.max(1, (int) (this.b * 0.02f));
            a(this.b, this.e, this.d);
        }
        a(0.0f);
        start();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f15299a.setColorFilter(q);
        this.f15299a.draw(canvas);
        this.f15299a.setColorFilter(this.r);
        if (this.j <= 0.001f) {
            return;
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, this.b, this.f15300c, null, 31);
        int i = this.h;
        if (i > 0) {
            canvas.clipRect(0, i, this.b, this.f15300c);
        }
        this.f15299a.draw(canvas);
        if (this.j >= 0.999f) {
            return;
        }
        int i2 = this.g + this.f;
        this.g = i2;
        int i3 = this.e;
        if (i2 > i3) {
            this.g = i2 - i3;
        }
        if (this.l != null) {
            this.m.setTranslate(-this.g, this.h);
            canvas.drawBitmap(this.l, this.m, this.k);
        }
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f15300c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.n;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.o) {
            a(valueAnimator.getAnimatedFraction());
            if (this.n) {
                return;
            }
            invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        a(i / 10000.0f);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f15299a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.f15299a.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.r = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.n = true;
        Choreographer.getInstance().postFrameCallback(this.s);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.n = false;
        Choreographer.getInstance().removeFrameCallback(this.s);
    }
}
