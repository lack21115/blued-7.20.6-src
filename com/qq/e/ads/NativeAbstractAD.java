package com.qq.e.ads;

import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.pi.ADI;
import com.qq.e.comm.util.AdError;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/NativeAbstractAD.class */
public abstract class NativeAbstractAD<T extends ADI> extends AbstractAD<T> {
    private DownAPPConfirmPolicy b;

    /* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/NativeAbstractAD$BasicADListener.class */
    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    public void a(T t) {
        DownAPPConfirmPolicy downAPPConfirmPolicy = this.b;
        if (downAPPConfirmPolicy != null) {
            setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qq.e.ads.AbstractAD
    protected /* bridge */ /* synthetic */ void a(Object obj) {
        a((NativeAbstractAD<T>) ((ADI) obj));
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.b = downAPPConfirmPolicy;
        T t = this.f14163a;
        if (t == 0 || downAPPConfirmPolicy == null) {
            return;
        }
        ((ADI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }
}
