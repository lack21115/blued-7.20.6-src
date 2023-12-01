package com.qq.e.ads.banner2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/banner2/UnifiedBannerAD.class */
public class UnifiedBannerAD extends LiteAbstractAD<UBVI> implements IReward, NFBI {
    private UnifiedBannerADListener b;

    /* renamed from: c  reason: collision with root package name */
    private DownAPPConfirmPolicy f27859c;
    private AtomicInteger d;
    private int e;
    private LoadAdParams f;
    private UnifiedBannerView g;
    private final ADListenerAdapter h;
    private volatile ServerSideVerificationOptions i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str, str2);
    }

    private UnifiedBannerAD(UnifiedBannerView unifiedBannerView, UnifiedBannerADListener unifiedBannerADListener) {
        this.d = new AtomicInteger(0);
        this.e = 30;
        this.f = null;
        this.b = unifiedBannerADListener;
        this.g = unifiedBannerView;
        this.h = new ADListenerAdapter(unifiedBannerADListener);
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedBannerViewDelegate(this.g, (Activity) context, str, str2, str3, this.h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        T t;
        this.f27859c = downAPPConfirmPolicy;
        if (downAPPConfirmPolicy == null || (t = this.f27851a) == 0) {
            return;
        }
        ((UBVI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LoadAdParams loadAdParams) {
        this.f = loadAdParams;
        T t = this.f27851a;
        if (t != 0) {
            ((UBVI) t).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        UBVI ubvi = (UBVI) obj;
        DownAPPConfirmPolicy downAPPConfirmPolicy = this.f27859c;
        if (downAPPConfirmPolicy != null) {
            this.f27859c = downAPPConfirmPolicy;
            T t = this.f27851a;
            if (t != 0) {
                ((UBVI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
            }
        }
        int i = this.e;
        this.e = i;
        T t2 = this.f27851a;
        if (t2 != 0) {
            ((UBVI) t2).setRefresh(i);
        }
        LoadAdParams loadAdParams = this.f;
        this.f = loadAdParams;
        T t3 = this.f27851a;
        if (t3 != 0) {
            ((UBVI) t3).setLoadAdParams(loadAdParams);
        }
        ubvi.setServerSideVerificationOptions(this.i);
        while (this.d.getAndDecrement() > 0) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        T t = this.f27851a;
        if (t != 0) {
            ((UBVI) t).onWindowFocusChanged(z);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        UnifiedBannerADListener unifiedBannerADListener = this.b;
        if (unifiedBannerADListener != null) {
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (a()) {
            if (!b()) {
                this.d.incrementAndGet();
                return;
            }
            T t = this.f27851a;
            if (t != 0) {
                ((UBVI) t).fetchAd();
            } else {
                a("loadAD");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        this.e = i;
        T t = this.f27851a;
        if (t != 0) {
            ((UBVI) t).setRefresh(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        T t = this.f27851a;
        if (t != 0) {
            ((UBVI) t).destroy();
        } else {
            a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t = this.f27851a;
        if (t != 0) {
            return ((UBVI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.h.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.h.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.i = serverSideVerificationOptions;
        T t = this.f27851a;
        if (t != 0) {
            ((UBVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }
}
