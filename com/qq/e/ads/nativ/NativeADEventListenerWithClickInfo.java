package com.qq.e.ads.nativ;

import android.view.View;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/nativ/NativeADEventListenerWithClickInfo.class */
public abstract class NativeADEventListenerWithClickInfo implements NativeADEventListener {
    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public final void onADClicked() {
    }

    public abstract void onADClicked(View view);
}
