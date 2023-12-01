package com.blued.android.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.pulltorefresh.LoadingLayout;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshHelper;
import com.soft.blued.R;
import com.soft.blued.utils.Logger;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/pulltorefresh/WaveLoadingLayout.class */
public class WaveLoadingLayout extends LoadingLayout {
    private final String TAG;
    private Context mContext;
    private LottieAnimationView mLavLoadingWave;
    private TextView mTvRefresh;

    public WaveLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.TAG = WaveLoadingLayout.class.getSimpleName();
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_refresh_wave, (ViewGroup) null);
        ((LinearLayout) this.mInnerLayout.findViewById(2131368177)).setVisibility(8);
        inflate.setBackgroundColor(BluedSkinUtils.a(this.mContext, 2131102388));
        this.mLavLoadingWave = (LottieAnimationView) inflate.findViewById(R.id.lav_loading_wave);
        this.mTvRefresh = (TextView) inflate.findViewById(2131372398);
        this.mInnerLayout.addView(inflate);
        this.mInnerLayout.setBackgroundColor(BluedSkinUtils.a(this.mContext, 2131102388));
        this.mHeaderImage.setVisibility(8);
        this.mHeaderLayout.setBackgroundColor(BluedSkinUtils.a(this.mContext, 2131102388));
        this.mLavLoadingWave.setImageAssetsFolder("images/");
        this.mLavLoadingWave.setAnimation("wave_super_man.json");
    }

    public static void preloadLoadingAnimation(Context context) {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        lottieAnimationView.setImageAssetsFolder("images/");
        lottieAnimationView.setAnimation("wave_super_man.json");
    }

    @Override // com.blued.android.framework.view.pulltorefresh.LoadingLayout
    public int getDefaultDrawableResId() {
        return 2131235754;
    }

    @Override // com.blued.android.framework.view.pulltorefresh.LoadingLayout
    public void onLoadingDrawableSet(Drawable drawable) {
    }

    @Override // com.blued.android.framework.view.pulltorefresh.LoadingLayout
    public void onPullImpl(float f) {
        Logger.a(this.TAG, "onPullImpl");
    }

    @Override // com.blued.android.framework.view.pulltorefresh.LoadingLayout
    public void pullToRefreshImpl() {
        Logger.a(this.TAG, "pullToRefreshImpl");
        LottieAnimationView lottieAnimationView = this.mLavLoadingWave;
        if (lottieAnimationView != null) {
            lottieAnimationView.d();
            this.mTvRefresh.setText(PullToRefreshHelper.a());
        }
    }

    @Override // com.blued.android.framework.view.pulltorefresh.LoadingLayout
    public void refreshingImpl() {
        Logger.a(this.TAG, "refreshingImpl");
        LottieAnimationView lottieAnimationView = this.mLavLoadingWave;
        if (lottieAnimationView != null) {
            lottieAnimationView.a();
            this.mTvRefresh.setText(PullToRefreshHelper.c());
        }
    }

    @Override // com.blued.android.framework.view.pulltorefresh.LoadingLayout
    public void releaseToRefreshImpl() {
        Logger.a(this.TAG, "releaseToRefreshImpl");
        this.mTvRefresh.setText(PullToRefreshHelper.b());
    }

    @Override // com.blued.android.framework.view.pulltorefresh.LoadingLayout
    public void resetImpl() {
        Logger.a(this.TAG, "resetImpl");
        LottieAnimationView lottieAnimationView = this.mLavLoadingWave;
        if (lottieAnimationView != null) {
            lottieAnimationView.d();
            this.mTvRefresh.setText(PullToRefreshHelper.b());
        }
    }

    @Override // com.blued.android.framework.view.pulltorefresh.LoadingLayout
    public void setHeaderBgImage() {
    }
}
