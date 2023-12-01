package com.anythink.nativead.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.nativead.api.NativeAd;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/nativead/api/ATNativeAdView.class */
public class ATNativeAdView extends FrameLayout {
    private static final String TAG = ATNativeAdView.class.getSimpleName();
    View mAdView;
    NativeAd.ImpressionEventListener mImpressionEventListener;
    boolean mIsInWindow;
    NativeAd mNativeAd;
    int mNativeAdId;

    public ATNativeAdView(Context context) {
        super(context);
    }

    public ATNativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ATNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void callbackImpression() {
        NativeAd.ImpressionEventListener impressionEventListener = this.mImpressionEventListener;
        if (impressionEventListener != null) {
            impressionEventListener.onImpression();
        }
    }

    public void attachNativeAd(NativeAd nativeAd) {
        synchronized (this) {
            this.mNativeAd = nativeAd;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        synchronized (this) {
            if (this.mNativeAd != null) {
                try {
                    this.mNativeAd.clear(this);
                } catch (Throwable th) {
                }
                this.mNativeAd = null;
            }
        }
    }

    public void clearImpressionListener(int i) {
        if (this.mNativeAdId == i) {
            this.mImpressionEventListener = null;
        }
    }

    public void destory() {
        this.mImpressionEventListener = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAttachInWindow() {
        return this.mIsInWindow;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsInWindow = true;
        if (getVisibility() == 0) {
            callbackImpression();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsInWindow = false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0 && getVisibility() == 0) {
            callbackImpression();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void renderView(int i, View view, NativeAd.ImpressionEventListener impressionEventListener) {
        View view2 = this.mAdView;
        if (view2 != null) {
            removeView(view2);
        }
        this.mAdView = view;
        this.mNativeAdId = i;
        this.mImpressionEventListener = impressionEventListener;
        addView(view);
        if (this.mIsInWindow && getVisibility() == 0) {
            callbackImpression();
        }
    }
}
