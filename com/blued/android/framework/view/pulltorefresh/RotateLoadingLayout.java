package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.blued.android.framework.R;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/RotateLoadingLayout.class */
public class RotateLoadingLayout extends LoadingLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Animation f10287a;
    private final Matrix b;

    /* renamed from: c  reason: collision with root package name */
    private float f10288c;
    private float d;
    private final boolean e;

    public RotateLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.e = typedArray.getBoolean(R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling, true);
        this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
        this.b = new Matrix();
        this.mHeaderImage.setImageMatrix(this.b);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.f10287a = rotateAnimation;
        rotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
        if (this.isHeaderStyleEnabled) {
            this.f10287a.setDuration(30L);
        } else {
            this.f10287a.setDuration(1000L);
        }
        this.f10287a.setRepeatCount(-1);
        this.f10287a.setRepeatMode(1);
    }

    private void a() {
        Matrix matrix = this.b;
        if (matrix != null) {
            matrix.reset();
            this.mHeaderImage.setImageMatrix(this.b);
        }
    }

    @Override // com.blued.android.framework.view.pulltorefresh.LoadingLayout
    protected int getDefaultDrawableResId() {
        return this.isHeaderStyleEnabled ? R.drawable.pullrefresh_animation_list : R.drawable.loading_progress;
    }

    @Override // com.blued.android.framework.view.pulltorefresh.LoadingLayout
    public void onLoadingDrawableSet(Drawable drawable) {
        if (drawable != null) {
            this.f10288c = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.d = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.blued.android.framework.view.pulltorefresh.LoadingLayout
    protected void onPullImpl(float f) {
        this.b.setRotate(this.e ? f * 90.0f : Math.max(0.0f, Math.min(180.0f, (f * 360.0f) - 180.0f)), this.f10288c, this.d);
        this.mHeaderImage.setImageMatrix(this.b);
    }

    @Override // com.blued.android.framework.view.pulltorefresh.LoadingLayout
    protected void pullToRefreshImpl() {
    }

    @Override // com.blued.android.framework.view.pulltorefresh.LoadingLayout
    protected void refreshingImpl() {
        this.mHeaderImage.startAnimation(this.f10287a);
    }

    @Override // com.blued.android.framework.view.pulltorefresh.LoadingLayout
    protected void releaseToRefreshImpl() {
    }

    @Override // com.blued.android.framework.view.pulltorefresh.LoadingLayout
    protected void resetImpl() {
        this.mHeaderImage.clearAnimation();
        a();
    }

    @Override // com.blued.android.framework.view.pulltorefresh.LoadingLayout
    public void setHeaderBgImage() {
    }
}
