package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.framework.R;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/IndicatorLayout.class */
public class IndicatorLayout extends FrameLayout implements Animation.AnimationListener {
    private Animation a;
    private Animation b;
    private ImageView c;
    private final Animation d;
    private final Animation e;

    /* renamed from: com.blued.android.framework.view.pulltorefresh.IndicatorLayout$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/IndicatorLayout$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            a = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public IndicatorLayout(Context context, PullToRefreshBase.Mode mode) {
        super(context);
        int i;
        int i2;
        this.c = new ImageView(context);
        ColorDrawable colorDrawable = new ColorDrawable(0);
        this.c.setImageDrawable(colorDrawable);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.indicator_internal_padding);
        this.c.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        addView(this.c);
        if (AnonymousClass1.a[mode.ordinal()] != 1) {
            i = R.anim.ptr_slide_in_top;
            i2 = R.anim.ptr_slide_out_top;
        } else {
            i = R.anim.ptr_slide_in_bottom;
            i2 = R.anim.ptr_slide_out_bottom;
            setBackgroundResource(R.drawable.indicator_bg_bottom);
            this.c.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.setRotate(180.0f, colorDrawable.getIntrinsicWidth() / 2.0f, colorDrawable.getIntrinsicHeight() / 2.0f);
            this.c.setImageMatrix(matrix);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(context, i);
        this.a = loadAnimation;
        loadAnimation.setAnimationListener(this);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, i2);
        this.b = loadAnimation2;
        loadAnimation2.setAnimationListener(this);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.d = rotateAnimation;
        rotateAnimation.setInterpolator(linearInterpolator);
        this.d.setDuration(150L);
        this.d.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.e = rotateAnimation2;
        rotateAnimation2.setInterpolator(linearInterpolator);
        this.e.setDuration(150L);
        this.e.setFillAfter(true);
    }

    public final boolean a() {
        Animation animation = getAnimation();
        return animation != null ? this.a == animation : getVisibility() == 0;
    }

    public void b() {
        startAnimation(this.b);
    }

    public void c() {
        this.c.clearAnimation();
        startAnimation(this.a);
    }

    public void d() {
        this.c.startAnimation(this.d);
    }

    public void e() {
        this.c.startAnimation(this.e);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (animation == this.b) {
            this.c.clearAnimation();
            setVisibility(8);
        } else if (animation == this.a) {
            setVisibility(0);
        }
        clearAnimation();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        setVisibility(0);
    }
}
