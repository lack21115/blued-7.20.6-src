package com.qq.e.ads.cfg;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/cfg/DownAPPConfirmPolicy.class */
public enum DownAPPConfirmPolicy {
    Default(0),
    NOConfirm(2);
    
    private final int b;

    DownAPPConfirmPolicy(int i) {
        this.b = i;
    }

    public int value() {
        return this.b;
    }
}
