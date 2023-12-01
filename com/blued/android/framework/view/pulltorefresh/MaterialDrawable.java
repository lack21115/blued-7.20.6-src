package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/MaterialDrawable.class */
class MaterialDrawable extends RefreshDrawable implements Animatable {

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f10217a = new LinearInterpolator();
    private static final Interpolator b = new EndCurveInterpolator();

    /* renamed from: c  reason: collision with root package name */
    private static final Interpolator f10218c = new StartCurveInterpolator();
    private static final Interpolator d = new AccelerateDecelerateInterpolator();
    private final int[] e;
    private final ArrayList<Animation> f;
    private final Ring g;
    private float h;
    private Resources i;
    private View j;
    private Animation k;
    private float l;
    private double m;
    private double n;
    private Animation o;
    private int p;
    private int q;
    private ShapeDrawable r;
    private int s;
    private int t;
    private final Drawable.Callback u;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/MaterialDrawable$EndCurveInterpolator.class */
    static class EndCurveInterpolator extends AccelerateDecelerateInterpolator {
        private EndCurveInterpolator() {
        }

        @Override // android.view.animation.AccelerateDecelerateInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return super.getInterpolation(Math.max(0.0f, (f - 0.5f) * 2.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/MaterialDrawable$OvalShadow.class */
    public class OvalShadow extends OvalShape {
        private RadialGradient b;

        /* renamed from: c  reason: collision with root package name */
        private int f10225c;
        private Paint d = new Paint();
        private int e;

        public OvalShadow(int i, int i2) {
            this.f10225c = i;
            this.e = i2;
            int i3 = this.e;
            RadialGradient radialGradient = new RadialGradient(i3 / 2, i3 / 2, this.f10225c, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.b = radialGradient;
            this.d.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            float centerX = MaterialDrawable.this.getBounds().centerX();
            float centerY = MaterialDrawable.this.getBounds().centerY();
            canvas.drawCircle(centerX, centerY, (this.e / 2) + this.f10225c, this.d);
            canvas.drawCircle(centerX, centerY, this.e / 2, paint);
        }
    }

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/MaterialDrawable$ProgressDrawableSize.class */
    public @interface ProgressDrawableSize {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/MaterialDrawable$Ring.class */
    public static class Ring {
        private final Drawable.Callback d;
        private int[] j;
        private int k;
        private float l;
        private float m;
        private float n;
        private boolean o;
        private float p;
        private double q;
        private int r;
        private int s;
        private int t;
        private int v;

        /* renamed from: a  reason: collision with root package name */
        private final RectF f10226a = new RectF();
        private final Paint b = new Paint();

        /* renamed from: c  reason: collision with root package name */
        private final Paint f10227c = new Paint();
        private float e = 0.0f;
        private float f = 0.0f;
        private float g = 0.0f;
        private float h = 5.0f;
        private float i = 2.5f;
        private final Paint u = new Paint();

        public Ring(Drawable.Callback callback) {
            this.d = callback;
            this.b.setStrokeCap(Paint.Cap.SQUARE);
            this.b.setAntiAlias(true);
            this.b.setStyle(Paint.Style.STROKE);
            this.f10227c.setStyle(Paint.Style.FILL);
            this.f10227c.setAntiAlias(true);
        }

        private void l() {
            this.d.invalidateDrawable(null);
        }

        public void a() {
            this.k = (this.k + 1) % this.j.length;
        }

        public void a(double d) {
            this.q = d;
        }

        public void a(float f) {
            this.h = f;
            this.b.setStrokeWidth(f);
            l();
        }

        public void a(float f, float f2) {
            this.r = (int) f;
            this.s = (int) f2;
        }

        public void a(int i) {
            this.v = i;
        }

        public void a(int i, int i2) {
            float min = Math.min(i, i2);
            double d = this.q;
            this.i = (float) ((d <= 0.0d || min < 0.0f) ? Math.ceil(this.h / 2.0f) : (min / 2.0f) - d);
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f10226a;
            rectF.set(rect);
            float f = this.i;
            rectF.inset(f, f);
            float f2 = this.e;
            float f3 = this.g;
            float f4 = (f2 + f3) * 360.0f;
            float f5 = this.f;
            this.b.setColor(this.j[this.k]);
            canvas.drawArc(rectF, f4, ((f5 + f3) * 360.0f) - f4, false, this.b);
            if (this.t < 255) {
                this.u.setColor(this.v);
                this.u.setAlpha(255 - this.t);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), rect.width() / 2, this.u);
            }
        }

        public void a(ColorFilter colorFilter) {
            this.b.setColorFilter(colorFilter);
            l();
        }

        public void a(boolean z) {
            if (this.o != z) {
                this.o = z;
                l();
            }
        }

        public void a(int[] iArr) {
            this.j = iArr;
            b(0);
        }

        public int b() {
            return this.t;
        }

        public void b(float f) {
            this.e = f;
            l();
        }

        public void b(int i) {
            this.k = i;
        }

        public float c() {
            return this.h;
        }

        public void c(float f) {
            this.f = f;
            l();
        }

        public void c(int i) {
            this.t = i;
        }

        public float d() {
            return this.e;
        }

        public void d(float f) {
            this.g = f;
            l();
        }

        public float e() {
            return this.l;
        }

        public void e(float f) {
            if (f != this.p) {
                this.p = f;
                l();
            }
        }

        public float f() {
            return this.m;
        }

        public float g() {
            return this.f;
        }

        public double h() {
            return this.q;
        }

        public float i() {
            return this.n;
        }

        public void j() {
            this.l = this.e;
            this.m = this.f;
            this.n = this.g;
        }

        public void k() {
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 0.0f;
            b(0.0f);
            c(0.0f);
            d(0.0f);
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/MaterialDrawable$StartCurveInterpolator.class */
    static class StartCurveInterpolator extends AccelerateDecelerateInterpolator {
        private StartCurveInterpolator() {
        }

        @Override // android.view.animation.AccelerateDecelerateInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return super.getInterpolation(Math.min(1.0f, f * 2.0f));
        }
    }

    public MaterialDrawable(Context context, PullRefreshLayout pullRefreshLayout) {
        super(context, pullRefreshLayout);
        this.e = new int[]{-16777216};
        this.f = new ArrayList<>();
        this.u = new Drawable.Callback() { // from class: com.blued.android.framework.view.pulltorefresh.MaterialDrawable.5
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                MaterialDrawable.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                MaterialDrawable.this.scheduleSelf(runnable, j);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                MaterialDrawable.this.unscheduleSelf(runnable);
            }
        };
        this.j = pullRefreshLayout;
        this.i = context.getResources();
        Ring ring = new Ring(this.u);
        this.g = ring;
        ring.a(this.e);
        a(1);
        e();
        d();
        b(-1);
        int d2 = d(40);
        this.t = d2;
        this.s = (-d2) - ((c().getFinalOffset() - this.t) / 2);
    }

    private void a(double d2, double d3, double d4, double d5, float f, float f2) {
        Ring ring = this.g;
        float f3 = this.i.getDisplayMetrics().density;
        double d6 = f3;
        this.m = d2 * d6;
        this.n = d3 * d6;
        ring.a(((float) d5) * f3);
        ring.a(d4 * d6);
        ring.b(0);
        ring.a(f * f3, f2 * f3);
        ring.a((int) this.m, (int) this.n);
    }

    private int d(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }

    private void d() {
        float f = getContext().getResources().getDisplayMetrics().density;
        int i = (int) (20.0f * f * 2.0f);
        int i2 = (int) (1.75f * f);
        int i3 = (int) (0.0f * f);
        this.p = (int) (f * 3.5f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShadow(this.p, i));
        this.r = shapeDrawable;
        shapeDrawable.getPaint().setShadowLayer(this.p, i3, i2, 503316480);
        this.q = this.p;
        this.r.getPaint().setColor(-1);
    }

    private void e() {
        final Ring ring = this.g;
        Animation animation = new Animation() { // from class: com.blued.android.framework.view.pulltorefresh.MaterialDrawable.1
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                float floor = (float) (Math.floor(ring.i() / 0.8f) + 1.0d);
                ring.b(ring.e() + ((ring.f() - ring.e()) * f));
                ring.d(ring.i() + ((floor - ring.i()) * f));
                ring.e(1.0f - f);
            }
        };
        animation.setInterpolator(d);
        animation.setDuration(666L);
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.framework.view.pulltorefresh.MaterialDrawable.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                ring.a();
                ring.j();
                ring.a(false);
                MaterialDrawable.this.j.startAnimation(MaterialDrawable.this.k);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }
        });
        Animation animation2 = new Animation() { // from class: com.blued.android.framework.view.pulltorefresh.MaterialDrawable.3
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                float radians = (float) Math.toRadians(ring.c() / (ring.h() * 6.283185307179586d));
                float f2 = ring.f();
                float e = ring.e();
                float i = ring.i();
                ring.c(f2 + ((0.8f - radians) * MaterialDrawable.f10218c.getInterpolation(f)));
                ring.b(e + (MaterialDrawable.b.getInterpolation(f) * 0.8f));
                ring.d(i + (0.25f * f));
                MaterialDrawable.this.d((f * 144.0f) + ((MaterialDrawable.this.l / 5.0f) * 720.0f));
            }
        };
        animation2.setRepeatCount(-1);
        animation2.setRepeatMode(1);
        animation2.setInterpolator(f10217a);
        animation2.setDuration(1333L);
        animation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.framework.view.pulltorefresh.MaterialDrawable.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation3) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation3) {
                ring.j();
                ring.a();
                Ring ring2 = ring;
                ring2.b(ring2.g());
                MaterialDrawable materialDrawable = MaterialDrawable.this;
                materialDrawable.l = (materialDrawable.l + 1.0f) % 5.0f;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation3) {
                MaterialDrawable.this.l = 0.0f;
            }
        });
        this.o = animation;
        this.k = animation2;
    }

    public void a(float f) {
        this.g.e(f);
    }

    public void a(float f, float f2) {
        this.g.b(f);
        this.g.c(f2);
    }

    public void a(int i) {
        if (i == 0) {
            a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public void a(boolean z) {
        this.g.a(z);
    }

    @Override // com.blued.android.framework.view.pulltorefresh.RefreshDrawable
    public void a(int... iArr) {
        this.g.a(iArr);
        this.g.b(0);
    }

    public void b(float f) {
        this.g.d(f);
    }

    public void b(int i) {
        this.g.a(i);
    }

    @Override // com.blued.android.framework.view.pulltorefresh.RefreshDrawable
    public void c(float f) {
        if (f < 0.4f) {
            return;
        }
        float f2 = (f - 0.4f) / 0.6f;
        setAlpha((int) (255.0f * f2));
        a(true);
        a(0.0f, Math.min(0.8f, f2 * 0.8f));
        a(Math.min(1.0f, f2));
        b((((0.4f * f2) - 0.25f) + (f2 * 2.0f)) * 0.5f);
    }

    @Override // com.blued.android.framework.view.pulltorefresh.RefreshDrawable
    public void c(int i) {
        this.s += i;
        invalidateSelf();
    }

    void d(float f) {
        this.h = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.translate(0.0f, this.s);
        this.r.draw(canvas);
        canvas.rotate(this.h, bounds.exactCenterX(), bounds.exactCenterY());
        this.g.a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.g.b();
    }

    @Override // com.blued.android.framework.view.pulltorefresh.RefreshDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ArrayList<Animation> arrayList = this.f;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            Animation animation = arrayList.get(i2);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
    }

    @Override // com.blued.android.framework.view.pulltorefresh.RefreshDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.g.c(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        int i5 = (i3 - i) / 2;
        int i6 = this.t;
        super.setBounds(i5 - (i6 / 2), i2, i5 + (i6 / 2), i6 + i2);
    }

    @Override // com.blued.android.framework.view.pulltorefresh.RefreshDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.g.a(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.k.reset();
        this.g.j();
        if (this.g.g() != this.g.d()) {
            this.j.startAnimation(this.o);
            return;
        }
        this.g.b(0);
        this.g.k();
        this.j.startAnimation(this.k);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.j.clearAnimation();
        d(0.0f);
        this.g.a(false);
        this.g.b(0);
        this.g.k();
    }
}
