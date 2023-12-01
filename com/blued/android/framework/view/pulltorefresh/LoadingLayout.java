package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.R;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/LoadingLayout.class */
public abstract class LoadingLayout extends FrameLayout implements ILoadingLayout {
    static final Interpolator ANIMATION_INTERPOLATOR = new LinearInterpolator();
    static final String LOG_TAG = "PullToRefresh-LoadingLayout";
    public boolean isHeaderStyleEnabled;
    public boolean isNeedBackgroudImage;
    protected final ImageView mHeaderImage;
    protected FrameLayout mHeaderLayout;
    protected final ProgressBar mHeaderProgress;
    protected final TextView mHeaderText;
    protected FrameLayout mInnerLayout;
    protected final PullToRefreshBase.Mode mMode;
    private CharSequence mPullLabel;
    private int mRefreshingHeight;
    private CharSequence mRefreshingLabel;
    private CharSequence mReleaseLabel;
    protected final PullToRefreshBase.Orientation mScrollDirection;
    private final TextView mSubHeaderText;
    private boolean mUseIntrinsicAnimation;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.framework.view.pulltorefresh.LoadingLayout$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/LoadingLayout$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10215a;
        static final /* synthetic */ int[] b;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x003f -> B:26:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0043 -> B:6:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0047 -> B:22:0x0033). Please submit an issue!!! */
        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            b = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[PullToRefreshBase.Orientation.values().length];
            f10215a = iArr2;
            try {
                iArr2[PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10215a[PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public LoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        Drawable drawable;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable2;
        this.isNeedBackgroudImage = true;
        this.isHeaderStyleEnabled = true;
        this.mMode = mode;
        this.mScrollDirection = orientation;
        if (AnonymousClass1.f10215a[orientation.ordinal()] != 1) {
            LayoutInflater.from(context).inflate(R.layout.pull_to_refresh_header_vertical, this);
        } else {
            LayoutInflater.from(context).inflate(R.layout.pull_to_refresh_header_horizontal, this);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_inner);
        this.mInnerLayout = frameLayout;
        this.mHeaderLayout = (FrameLayout) frameLayout.findViewById(R.id.fl_header);
        this.mHeaderText = (TextView) this.mInnerLayout.findViewById(R.id.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.mInnerLayout.findViewById(R.id.pull_to_refresh_progress);
        this.mSubHeaderText = (TextView) this.mInnerLayout.findViewById(R.id.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.mInnerLayout.findViewById(R.id.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mInnerLayout.getLayoutParams();
        if (AnonymousClass1.b[mode.ordinal()] != 1) {
            layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
            this.mPullLabel = PullToRefreshHelper.a();
            this.mRefreshingLabel = PullToRefreshHelper.c();
            this.mReleaseLabel = PullToRefreshHelper.b();
        } else {
            layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
            this.mPullLabel = PullToRefreshHelper.a();
            this.mRefreshingLabel = PullToRefreshHelper.c();
            this.mReleaseLabel = PullToRefreshHelper.b();
        }
        if (typedArray.hasValue(R.styleable.PullToRefresh_ptrHeaderBackground) && (drawable2 = typedArray.getDrawable(R.styleable.PullToRefresh_ptrHeaderBackground)) != null) {
            ViewCompat.a(this, drawable2);
        }
        if (typedArray.hasValue(R.styleable.PullToRefresh_ptrHeaderNeedBackgroundImg)) {
            this.isNeedBackgroudImage = typedArray.getBoolean(R.styleable.PullToRefresh_ptrHeaderNeedBackgroundImg, true);
        }
        if (typedArray.hasValue(R.styleable.PullToRefresh_ptrHeaderTextAppearance)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(R.styleable.PullToRefresh_ptrHeaderTextAppearance, typedValue);
            setTextAppearance(typedValue.data);
        }
        if (typedArray.hasValue(R.styleable.PullToRefresh_ptrSubHeaderTextAppearance)) {
            TypedValue typedValue2 = new TypedValue();
            typedArray.getValue(R.styleable.PullToRefresh_ptrSubHeaderTextAppearance, typedValue2);
            setSubTextAppearance(typedValue2.data);
        }
        if (typedArray.hasValue(R.styleable.PullToRefresh_ptrHeaderTextColor) && (colorStateList2 = typedArray.getColorStateList(R.styleable.PullToRefresh_ptrHeaderTextColor)) != null) {
            setTextColor(colorStateList2);
        }
        if (typedArray.hasValue(R.styleable.PullToRefresh_ptrHeaderSubTextColor) && (colorStateList = typedArray.getColorStateList(R.styleable.PullToRefresh_ptrHeaderSubTextColor)) != null) {
            setSubTextColor(colorStateList);
        }
        Drawable drawable3 = typedArray.hasValue(R.styleable.PullToRefresh_ptrDrawable) ? typedArray.getDrawable(R.styleable.PullToRefresh_ptrDrawable) : null;
        if (typedArray.hasValue(R.styleable.PullToRefresh_ptrHeaderStyleEnabled)) {
            this.isHeaderStyleEnabled = typedArray.getBoolean(R.styleable.PullToRefresh_ptrHeaderStyleEnabled, true);
        }
        if (typedArray.hasValue(R.styleable.PullToRefresh_ptrRefreshingHeight)) {
            this.mRefreshingHeight = (int) typedArray.getDimension(R.styleable.PullToRefresh_ptrRefreshingHeight, 0.0f);
        }
        setHeaderBgImage();
        if (AnonymousClass1.b[mode.ordinal()] != 1) {
            if (typedArray.hasValue(R.styleable.PullToRefresh_ptrDrawableStart)) {
                drawable = typedArray.getDrawable(R.styleable.PullToRefresh_ptrDrawableStart);
            } else {
                drawable = drawable3;
                if (typedArray.hasValue(R.styleable.PullToRefresh_ptrDrawableTop)) {
                    Log.w("ptrDrawableTop", "ptrDrawableStart");
                    drawable = typedArray.getDrawable(R.styleable.PullToRefresh_ptrDrawableTop);
                }
            }
        } else if (typedArray.hasValue(R.styleable.PullToRefresh_ptrDrawableEnd)) {
            drawable = typedArray.getDrawable(R.styleable.PullToRefresh_ptrDrawableEnd);
        } else {
            drawable = drawable3;
            if (typedArray.hasValue(R.styleable.PullToRefresh_ptrDrawableBottom)) {
                Log.w("ptrDrawableBottom", "ptrDrawableEnd");
                drawable = typedArray.getDrawable(R.styleable.PullToRefresh_ptrDrawableBottom);
            }
        }
        setLoadingDrawable(drawable == null ? context.getResources().getDrawable(getDefaultDrawableResId()) : drawable);
        reset();
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.mSubHeaderText != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.mSubHeaderText.setVisibility(8);
                return;
            }
            this.mSubHeaderText.setText(charSequence);
            if (8 == this.mSubHeaderText.getVisibility()) {
                this.mSubHeaderText.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        TextView textView = this.mSubHeaderText;
        if (textView != null) {
            textView.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        TextView textView = this.mSubHeaderText;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        TextView textView = this.mHeaderText;
        if (textView != null) {
            textView.setTextAppearance(getContext(), i);
        }
        TextView textView2 = this.mSubHeaderText;
        if (textView2 != null) {
            textView2.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        TextView textView = this.mHeaderText;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
        TextView textView2 = this.mSubHeaderText;
        if (textView2 != null) {
            textView2.setTextColor(colorStateList);
        }
    }

    public final int getContentSize() {
        if (AnonymousClass1.f10215a[this.mScrollDirection.ordinal()] != 1) {
            int i = this.mRefreshingHeight;
            return i != 0 ? i : this.isHeaderStyleEnabled ? "2".equals(AppInfo.e()) ? AppMethods.a(100) : AppMethods.a(65) : "2".equals(AppInfo.e()) ? AppMethods.a(60) : AppMethods.a(50);
        }
        return this.mInnerLayout.getWidth();
    }

    protected abstract int getDefaultDrawableResId();

    public final void hideAllViews() {
        if (this.mHeaderText.getVisibility() == 0) {
            this.mHeaderText.setVisibility(4);
        }
        if (this.mHeaderProgress.getVisibility() == 0) {
            this.mHeaderProgress.setVisibility(4);
        }
        if (this.mHeaderImage.getVisibility() == 0) {
            this.mHeaderImage.setVisibility(4);
        }
        if (this.mSubHeaderText.getVisibility() == 0) {
            this.mSubHeaderText.setVisibility(4);
        }
    }

    protected abstract void onLoadingDrawableSet(Drawable drawable);

    public final void onPull(float f) {
        if (!this.mUseIntrinsicAnimation) {
            onPullImpl(f);
            return;
        }
        AnimationDrawable animationDrawable = this.isHeaderStyleEnabled ? (AnimationDrawable) this.mHeaderImage.getDrawable() : (AnimationDrawable) this.mHeaderImage.getResources().getDrawable(R.drawable.loading_progress);
        if (animationDrawable != null) {
            if (animationDrawable.isRunning()) {
                animationDrawable.stop();
            }
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            if (numberOfFrames <= 1 || f > 1.0f) {
                return;
            }
            animationDrawable.selectDrawable((numberOfFrames - ((int) (f * numberOfFrames))) - 1);
        }
    }

    protected abstract void onPullImpl(float f);

    public final void pullToRefresh() {
        TextView textView = this.mHeaderText;
        if (textView != null && this.isHeaderStyleEnabled) {
            textView.setText(this.mPullLabel);
        }
        if (!this.mUseIntrinsicAnimation) {
            pullToRefreshImpl();
        } else if ("1".equals(AppInfo.e()) && this.isHeaderStyleEnabled) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).selectDrawable(19);
        }
    }

    protected abstract void pullToRefreshImpl();

    protected Drawable readDrawable(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inInputShareable = true;
        Bitmap decodeStream = BitmapFactory.decodeStream(getContext().getResources().openRawResource(i), null, options);
        if (decodeStream != null) {
            return new BitmapDrawable(getResources(), decodeStream);
        }
        return null;
    }

    public final void refreshing() {
        TextView textView = this.mHeaderText;
        if (textView != null && this.isHeaderStyleEnabled) {
            textView.setText(this.mRefreshingLabel);
        }
        if (!this.mUseIntrinsicAnimation) {
            refreshingImpl();
        } else if (this.isHeaderStyleEnabled) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).selectDrawable(0);
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        }
        TextView textView2 = this.mSubHeaderText;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    protected abstract void refreshingImpl();

    public final void releaseToRefresh() {
        TextView textView = this.mHeaderText;
        if (textView != null && this.isHeaderStyleEnabled) {
            textView.setText(this.mReleaseLabel);
        }
        releaseToRefreshImpl();
    }

    protected abstract void releaseToRefreshImpl();

    public final void reset() {
        TextView textView = this.mHeaderText;
        if (textView != null && this.isHeaderStyleEnabled) {
            textView.setText(this.mReleaseLabel);
        }
        if (this.mUseIntrinsicAnimation) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        TextView textView2 = this.mSubHeaderText;
        if (textView2 != null) {
            if (TextUtils.isEmpty(textView2.getText())) {
                this.mSubHeaderText.setVisibility(8);
            } else {
                this.mSubHeaderText.setVisibility(0);
            }
        }
    }

    protected abstract void resetImpl();

    public void setHeaderBgImage() {
        if (this.isHeaderStyleEnabled) {
            if (this.isNeedBackgroudImage) {
                this.mHeaderLayout.setBackgroundDrawable(readDrawable(R.drawable.header_bg_blue));
                this.mHeaderText.setBackgroundDrawable(readDrawable(R.drawable.header_cloud_bg));
                return;
            }
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(0, 20, 0, 0);
        this.mHeaderImage.setLayoutParams(layoutParams);
    }

    public final void setHeight(int i) {
        getLayoutParams().height = i;
        requestLayout();
    }

    @Override // com.blued.android.framework.view.pulltorefresh.ILoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.blued.android.framework.view.pulltorefresh.ILoadingLayout
    public final void setLoadingDrawable(Drawable drawable) {
        this.mHeaderImage.setImageDrawable(drawable);
        this.mUseIntrinsicAnimation = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    @Override // com.blued.android.framework.view.pulltorefresh.ILoadingLayout
    public void setPullLabel(CharSequence charSequence) {
        this.mPullLabel = charSequence;
    }

    @Override // com.blued.android.framework.view.pulltorefresh.ILoadingLayout
    public void setRefreshingLabel(CharSequence charSequence) {
        this.mRefreshingLabel = charSequence;
    }

    @Override // com.blued.android.framework.view.pulltorefresh.ILoadingLayout
    public void setReleaseLabel(CharSequence charSequence) {
        this.mReleaseLabel = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.mHeaderText.setTypeface(typeface);
    }

    public final void setWidth(int i) {
        getLayoutParams().width = i;
        requestLayout();
    }

    public final void showInvisibleViews() {
        if (4 == this.mHeaderText.getVisibility()) {
            this.mHeaderText.setVisibility(0);
        }
        if (4 == this.mHeaderProgress.getVisibility()) {
            this.mHeaderProgress.setVisibility(0);
        }
        if (4 == this.mHeaderImage.getVisibility() && !"1".equals(AppInfo.e())) {
            this.mHeaderImage.setVisibility(0);
        }
        if (4 == this.mSubHeaderText.getVisibility()) {
            this.mSubHeaderText.setVisibility(0);
        }
    }
}
