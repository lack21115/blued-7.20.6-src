package com.soft.blued.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/RippleAnimationView.class */
public class RippleAnimationView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f14802a;
    private Paint b;

    /* renamed from: c  reason: collision with root package name */
    private int f14803c;
    private int d;
    private int e;
    private boolean f;
    private long g;
    private float h;
    private float i;
    private ViewGroup j;
    private OnAnimationEndListener k;
    private Animator.AnimatorListener l;
    private ValueAnimator.AnimatorUpdateListener m;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/RippleAnimationView$OnAnimationEndListener.class */
    public interface OnAnimationEndListener {
        void a();
    }

    private RippleAnimationView(Context context, float f, float f2, int i) {
        super(context);
        this.j = (ViewGroup) a(context).getWindow().getDecorView();
        this.h = f;
        this.i = f2;
        this.d = i;
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        c();
        b();
    }

    private Activity a(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        throw new RuntimeException("Activity not found!");
    }

    public static RippleAnimationView a(View view) {
        Context context = view.getContext();
        int width = view.getWidth() / 2;
        int height = view.getHeight() / 2;
        return new RippleAnimationView(context, c(view) + width, d(view) + height, Math.max(width, height));
    }

    private static Bitmap b(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getLayoutParams().width, 1073741824), View.MeasureSpec.makeMeasureSpec(view.getLayoutParams().height, 1073741824));
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private void b() {
        this.l = new AnimatorListenerAdapter() { // from class: com.soft.blued.customview.RippleAnimationView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (RippleAnimationView.this.k != null) {
                    RippleAnimationView.this.k.a();
                }
                RippleAnimationView.this.f = false;
                RippleAnimationView.this.e();
            }
        };
        this.m = new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.customview.RippleAnimationView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleAnimationView.this.e = ((int) ((Float) valueAnimator.getAnimatedValue()).floatValue()) + RippleAnimationView.this.d;
                RippleAnimationView.this.postInvalidate();
            }
        };
    }

    private static float c(View view) {
        float x = view.getX();
        ViewParent parent = view.getParent();
        float f = x;
        if (parent instanceof View) {
            f = x + c((View) parent);
        }
        return f;
    }

    private void c() {
        float f = this.h;
        int i = this.d;
        RectF rectF = new RectF(0.0f, 0.0f, f + i, this.i + i);
        RectF rectF2 = new RectF(rectF.right, 0.0f, this.j.getRight(), rectF.bottom);
        RectF rectF3 = new RectF(0.0f, rectF.bottom, rectF.right, this.j.getBottom());
        RectF rectF4 = new RectF(rectF3.right, rectF.bottom, this.j.getRight(), rectF3.bottom);
        this.f14803c = (int) Math.max(Math.max(Math.sqrt(Math.pow(rectF.width(), 2.0d) + Math.pow(rectF.height(), 2.0d)), Math.sqrt(Math.pow(rectF2.width(), 2.0d) + Math.pow(rectF2.height(), 2.0d))), Math.max(Math.sqrt(Math.pow(rectF3.width(), 2.0d) + Math.pow(rectF3.height(), 2.0d)), Math.sqrt(Math.pow(rectF4.width(), 2.0d) + Math.pow(rectF4.height(), 2.0d))));
    }

    private static float d(View view) {
        float y = view.getY();
        ViewParent parent = view.getParent();
        float f = y;
        if (parent instanceof View) {
            f = y + d((View) parent);
        }
        return f;
    }

    private void d() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.j.addView(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ViewGroup viewGroup = this.j;
        if (viewGroup != null) {
            viewGroup.removeView(this);
            this.j = null;
        }
        Bitmap bitmap = this.f14802a;
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                this.f14802a.recycle();
            }
            this.f14802a = null;
        }
        if (this.b != null) {
            this.b = null;
        }
    }

    private void f() {
        Bitmap bitmap = this.f14802a;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f14802a.recycle();
        }
        this.f14802a = b(this.j);
    }

    private ValueAnimator getAnimator() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, this.f14803c).setDuration(this.g);
        duration.addUpdateListener(this.m);
        duration.addListener(this.l);
        return duration;
    }

    public RippleAnimationView a(long j) {
        this.g = j;
        return this;
    }

    public void a() {
        if (this.f) {
            return;
        }
        this.f = true;
        f();
        d();
        getAnimator().start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int saveLayer = Build.VERSION.SDK_INT >= 21 ? canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null) : canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.drawBitmap(this.f14802a, 0.0f, 0.0f, (Paint) null);
        canvas.drawCircle(this.h, this.i, this.e, this.b);
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
