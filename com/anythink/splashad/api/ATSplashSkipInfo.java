package com.anythink.splashad.api;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/splashad/api/ATSplashSkipInfo.class */
public class ATSplashSkipInfo {
    public static final String TAG = ATSplashSkipInfo.class.getSimpleName();
    ATSplashSkipAdListener mATSplashSkipAdListener;
    long mCallbackInterval;
    ViewGroup mContainer;
    long mCountDownDuration;
    View mSkipView;

    public ATSplashSkipInfo(View view, long j, long j2, ATSplashSkipAdListener aTSplashSkipAdListener) {
        this.mSkipView = view;
        this.mCountDownDuration = j;
        this.mCallbackInterval = j2;
        this.mATSplashSkipAdListener = aTSplashSkipAdListener;
        if (j < 2000) {
            Log.e(TAG, "mCountDownDuration is less than or equal to 2000, reset to 2000");
            this.mCountDownDuration = 2000L;
        }
        long j3 = this.mCallbackInterval;
        if (j3 <= 0) {
            Log.e(TAG, "mCallbackInterval is less than or equal to 0, reset to 1000");
            this.mCallbackInterval = 1000L;
        } else if (j3 < 20) {
            Log.e(TAG, "mCallbackInterval is less than 10, reset to 20");
            this.mCallbackInterval = 20L;
        }
    }

    public ATSplashSkipInfo(View view, ATSplashSkipAdListener aTSplashSkipAdListener) {
        this(view, 5000L, 1000L, aTSplashSkipAdListener);
    }

    public boolean canUseCustomSkipView() {
        return this.mSkipView != null;
    }

    public void destroy() {
        View view = this.mSkipView;
        if (view != null) {
            view.setOnClickListener(null);
            this.mSkipView = null;
        }
        this.mATSplashSkipAdListener = null;
    }

    public ATSplashSkipAdListener getATSplashSkipAdListener() {
        return this.mATSplashSkipAdListener;
    }

    public long getCallbackInterval() {
        return this.mCallbackInterval;
    }

    public ViewGroup getContainer() {
        return this.mContainer;
    }

    public long getCountDownDuration() {
        return this.mCountDownDuration;
    }

    public View getSkipView() {
        return this.mSkipView;
    }

    public void setContainer(ViewGroup viewGroup) {
        this.mContainer = viewGroup;
    }
}
