package com.heytap.msp.mobad.api.params;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/params/SplashSkipView.class */
public class SplashSkipView extends FrameLayout {
    private ISplashSkipCountDown mISplashSkipCountDown;

    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/params/SplashSkipView$ISplashSkipCountDown.class */
    public interface ISplashSkipCountDown {
        void onSkipCountDownSecond(int i);
    }

    public SplashSkipView(Context context) {
        super(context);
    }

    public SplashSkipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SplashSkipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onSkipCountDown(int i) {
        ISplashSkipCountDown iSplashSkipCountDown = this.mISplashSkipCountDown;
        if (iSplashSkipCountDown != null) {
            iSplashSkipCountDown.onSkipCountDownSecond(i);
        }
    }

    public void setSkipCountDownCallBack(ISplashSkipCountDown iSplashSkipCountDown) {
        this.mISplashSkipCountDown = iSplashSkipCountDown;
    }
}
