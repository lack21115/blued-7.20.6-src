package com.qq.e.ads.nativ.widget;

import android.view.MotionEvent;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/nativ/widget/ViewStatusListener.class */
public interface ViewStatusListener {
    void onAttachToWindow();

    void onDetachFromWindow();

    void onDispatchTouchEvent(MotionEvent motionEvent);

    void onWindowFocusChanged(boolean z);

    void onWindowVisibilityChanged(int i);
}
