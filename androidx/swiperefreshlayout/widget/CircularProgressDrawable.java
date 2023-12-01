package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.util.Preconditions;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8756600-dex2jar.jar:androidx/swiperefreshlayout/widget/CircularProgressDrawable.class */
public class CircularProgressDrawable extends Drawable implements Animatable {
    public static final int DEFAULT = 1;
    public static final int LARGE = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final Interpolator f3386c = new LinearInterpolator();
    private static final Interpolator d = new FastOutSlowInInterpolator();
    private static final int[] e = {-16777216};

    /* renamed from: a  reason: collision with root package name */
    float f3387a;
    boolean b;
    private final Ring f;
    private float g;
    private Resources h;
    private Animator i;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/swiperefreshlayout/widget/CircularProgressDrawable$ProgressDrawableSize.class */
    public @interface ProgressDrawableSize {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/swiperefreshlayout/widget/CircularProgressDrawable$Ring.class */
    public static class Ring {
        int[] i;
        int j;
        float k;
        float l;
        float m;
        boolean n;
        Path o;
        float q;
        int r;
        int s;
        int u;

        /* renamed from: a  reason: collision with root package name */
        final RectF f3390a = new RectF();
        final Paint b = new Paint();

        /* renamed from: c  reason: collision with root package name */
        final Paint f3391c = new Paint();
        final Paint d = new Paint();
        float e = 0.0f;
        float f = 0.0f;
        float g = 0.0f;
        float h = 5.0f;
        float p = 1.0f;
        int t = 255;

        Ring() {
            this.b.setStrokeCap(Paint.Cap.SQUARE);
            this.b.setAntiAlias(true);
            this.b.setStyle(Paint.Style.STROKE);
            this.f3391c.setStyle(Paint.Style.FILL);
            this.f3391c.setAntiAlias(true);
            this.d.setColor(0);
        }

        Paint.Cap a() {
            return this.b.getStrokeCap();
        }

        void a(float f) {
            this.h = f;
            this.b.setStrokeWidth(f);
        }

        void a(float f, float f2) {
            this.r = (int) f;
            this.s = (int) f2;
        }

        void a(int i) {
            this.u = i;
        }

        void a(Canvas canvas, float f, float f2, RectF rectF) {
            if (this.n) {
                Path path = this.o;
                if (path == null) {
                    Path path2 = new Path();
                    this.o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f3 = (this.r * this.p) / 2.0f;
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo(this.r * this.p, 0.0f);
                Path path3 = this.o;
                float f4 = this.r;
                float f5 = this.p;
                path3.lineTo((f4 * f5) / 2.0f, this.s * f5);
                this.o.offset((min + rectF.centerX()) - f3, rectF.centerY() + (this.h / 2.0f));
                this.o.close();
                this.f3391c.setColor(this.u);
                this.f3391c.setAlpha(this.t);
                canvas.save();
                canvas.rotate(f + f2, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.o, this.f3391c);
                canvas.restore();
            }
        }

        void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f3390a;
            float f = this.q;
            float f2 = (this.h / 2.0f) + f;
            if (f <= 0.0f) {
                f2 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.r * this.p) / 2.0f, this.h / 2.0f);
            }
            rectF.set(rect.centerX() - f2, rect.centerY() - f2, rect.centerX() + f2, rect.centerY() + f2);
            float f3 = this.e;
            float f4 = this.g;
            float f5 = (f3 + f4) * 360.0f;
            float f6 = ((this.f + f4) * 360.0f) - f5;
            this.b.setColor(this.u);
            this.b.setAlpha(this.t);
            float f7 = this.h / 2.0f;
            rectF.inset(f7, f7);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.d);
            float f8 = -f7;
            rectF.inset(f8, f8);
            canvas.drawArc(rectF, f5, f6, false, this.b);
            a(canvas, f5, f6, rectF);
        }

        void a(ColorFilter colorFilter) {
            this.b.setColorFilter(colorFilter);
        }

        void a(Paint.Cap cap) {
            this.b.setStrokeCap(cap);
        }

        void a(boolean z) {
            if (this.n != z) {
                this.n = z;
            }
        }

        void a(int[] iArr) {
            this.i = iArr;
            c(0);
        }

        float b() {
            return this.r;
        }

        void b(float f) {
            this.e = f;
        }

        void b(int i) {
            this.d.setColor(i);
        }

        float c() {
            return this.s;
        }

        void c(float f) {
            this.f = f;
        }

        void c(int i) {
            this.j = i;
            this.u = this.i[i];
        }

        void d(float f) {
            this.g = f;
        }

        void d(int i) {
            this.t = i;
        }

        int[] d() {
            return this.i;
        }

        int e() {
            return this.d.getColor();
        }

        void e(float f) {
            this.q = f;
        }

        int f() {
            return this.i[g()];
        }

        void f(float f) {
            if (f != this.p) {
                this.p = f;
            }
        }

        int g() {
            return (this.j + 1) % this.i.length;
        }

        void h() {
            c(g());
        }

        int i() {
            return this.t;
        }

        float j() {
            return this.h;
        }

        float k() {
            return this.e;
        }

        float l() {
            return this.k;
        }

        float m() {
            return this.l;
        }

        int n() {
            return this.i[this.j];
        }

        float o() {
            return this.f;
        }

        float p() {
            return this.g;
        }

        float q() {
            return this.q;
        }

        boolean r() {
            return this.n;
        }

        float s() {
            return this.p;
        }

        float t() {
            return this.m;
        }

        void u() {
            this.k = this.e;
            this.l = this.f;
            this.m = this.g;
        }

        void v() {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            b(0.0f);
            c(0.0f);
            d(0.0f);
        }
    }

    public CircularProgressDrawable(Context context) {
        this.h = ((Context) Preconditions.checkNotNull(context)).getResources();
        Ring ring = new Ring();
        this.f = ring;
        ring.a(e);
        setStrokeWidth(2.5f);
        a();
    }

    private int a(float f, int i, int i2) {
        int i3 = (i >> 24) & 255;
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = i & 255;
        return ((i3 + ((int) ((((i2 >> 24) & 255) - i3) * f))) << 24) | ((i4 + ((int) ((((i2 >> 16) & 255) - i4) * f))) << 16) | ((i5 + ((int) ((((i2 >> 8) & 255) - i5) * f))) << 8) | (i6 + ((int) (f * ((i2 & 255) - i6))));
    }

    private void a() {
        final Ring ring = this.f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressDrawable.this.a(floatValue, ring);
                CircularProgressDrawable.this.a(floatValue, ring, false);
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f3386c);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                CircularProgressDrawable.this.a(1.0f, ring, true);
                ring.u();
                ring.h();
                if (!CircularProgressDrawable.this.b) {
                    CircularProgressDrawable.this.f3387a += 1.0f;
                    return;
                }
                CircularProgressDrawable.this.b = false;
                animator.cancel();
                animator.setDuration(1332L);
                animator.start();
                ring.a(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                CircularProgressDrawable.this.f3387a = 0.0f;
            }
        });
        this.i = ofFloat;
    }

    private void a(float f) {
        this.g = f;
    }

    private void a(float f, float f2, float f3, float f4) {
        Ring ring = this.f;
        float f5 = this.h.getDisplayMetrics().density;
        ring.a(f2 * f5);
        ring.e(f * f5);
        ring.c(0);
        ring.a(f3 * f5, f4 * f5);
    }

    private void b(float f, Ring ring) {
        a(f, ring);
        ring.b(ring.l() + (((ring.m() - 0.01f) - ring.l()) * f));
        ring.c(ring.m());
        ring.d(ring.t() + ((((float) (Math.floor(ring.t() / 0.8f) + 1.0d)) - ring.t()) * f));
    }

    void a(float f, Ring ring) {
        if (f > 0.75f) {
            ring.a(a((f - 0.75f) / 0.25f, ring.n(), ring.f()));
        } else {
            ring.a(ring.n());
        }
    }

    void a(float f, Ring ring, boolean z) {
        float l;
        float interpolation;
        if (this.b) {
            b(f, ring);
        } else if (f != 1.0f || z) {
            float t = ring.t();
            if (f < 0.5f) {
                interpolation = ring.l();
                l = (d.getInterpolation(f / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                l = ring.l() + 0.79f;
                interpolation = l - (((1.0f - d.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            float f2 = this.f3387a;
            ring.b(interpolation);
            ring.c(l);
            ring.d(t + (0.20999998f * f));
            a((f + f2) * 216.0f);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.g, bounds.exactCenterX(), bounds.exactCenterY());
        this.f.a(canvas, bounds);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f.i();
    }

    public boolean getArrowEnabled() {
        return this.f.r();
    }

    public float getArrowHeight() {
        return this.f.c();
    }

    public float getArrowScale() {
        return this.f.s();
    }

    public float getArrowWidth() {
        return this.f.b();
    }

    public int getBackgroundColor() {
        return this.f.e();
    }

    public float getCenterRadius() {
        return this.f.q();
    }

    public int[] getColorSchemeColors() {
        return this.f.d();
    }

    public float getEndTrim() {
        return this.f.o();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float getProgressRotation() {
        return this.f.p();
    }

    public float getStartTrim() {
        return this.f.k();
    }

    public Paint.Cap getStrokeCap() {
        return this.f.a();
    }

    public float getStrokeWidth() {
        return this.f.j();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.i.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f.d(i);
        invalidateSelf();
    }

    public void setArrowDimensions(float f, float f2) {
        this.f.a(f, f2);
        invalidateSelf();
    }

    public void setArrowEnabled(boolean z) {
        this.f.a(z);
        invalidateSelf();
    }

    public void setArrowScale(float f) {
        this.f.f(f);
        invalidateSelf();
    }

    public void setBackgroundColor(int i) {
        this.f.b(i);
        invalidateSelf();
    }

    public void setCenterRadius(float f) {
        this.f.e(f);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f.a(colorFilter);
        invalidateSelf();
    }

    public void setColorSchemeColors(int... iArr) {
        this.f.a(iArr);
        this.f.c(0);
        invalidateSelf();
    }

    public void setProgressRotation(float f) {
        this.f.d(f);
        invalidateSelf();
    }

    public void setStartEndTrim(float f, float f2) {
        this.f.b(f);
        this.f.c(f2);
        invalidateSelf();
    }

    public void setStrokeCap(Paint.Cap cap) {
        this.f.a(cap);
        invalidateSelf();
    }

    public void setStrokeWidth(float f) {
        this.f.a(f);
        invalidateSelf();
    }

    public void setStyle(int i) {
        if (i == 0) {
            a(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            a(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.i.cancel();
        this.f.u();
        if (this.f.o() != this.f.k()) {
            this.b = true;
            this.i.setDuration(666L);
            this.i.start();
            return;
        }
        this.f.c(0);
        this.f.v();
        this.i.setDuration(1332L);
        this.i.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.i.cancel();
        a(0.0f);
        this.f.a(false);
        this.f.c(0);
        this.f.v();
        invalidateSelf();
    }
}
