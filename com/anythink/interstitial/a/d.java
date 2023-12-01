package com.anythink.interstitial.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.j;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.g;
import com.anythink.core.common.v;
import com.anythink.interstitial.api.ATInterstitialExListener;
import com.anythink.interstitial.api.ATInterstitialListener;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/interstitial/a/d.class */
public final class d implements CustomInterstitialEventListener {

    /* renamed from: a  reason: collision with root package name */
    ATInterstitialListener f8823a;
    CustomInterstitialAdapter b;

    /* renamed from: c  reason: collision with root package name */
    long f8824c;
    long d;
    int e = 0;
    boolean f = true;

    public d(CustomInterstitialAdapter customInterstitialAdapter, ATInterstitialListener aTInterstitialListener) {
        this.f8823a = aTInterstitialListener;
        this.b = customInterstitialAdapter;
    }

    private static void a(String str) {
        com.anythink.core.common.e.d d;
        if (TextUtils.isEmpty(str) || (d = v.a().d(str)) == null) {
            return;
        }
        v.a().e(str);
        a.a(n.a().g(), str).d(v.a().a(str, d.a()));
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onDeeplinkCallback(boolean z) {
        ATInterstitialListener aTInterstitialListener = this.f8823a;
        if (aTInterstitialListener == null || !(aTInterstitialListener instanceof ATInterstitialExListener)) {
            return;
        }
        ((ATInterstitialExListener) aTInterstitialListener).onDeeplinkCallback(j.a(this.b), z);
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        ATInterstitialListener aTInterstitialListener = this.f8823a;
        if (aTInterstitialListener == null || !(aTInterstitialListener instanceof ATInterstitialExListener)) {
            return;
        }
        ((ATInterstitialExListener) aTInterstitialListener).onDownloadConfirm(context, j.a(this.b), aTNetworkConfirmInfo);
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdClicked() {
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customInterstitialAdapter.getTrackingInfo();
            g.a(trackingInfo, g.i.d, g.i.f, "");
            com.anythink.core.common.j.a.a(n.a().g()).a(6, trackingInfo);
        }
        ATInterstitialListener aTInterstitialListener = this.f8823a;
        if (aTInterstitialListener != null) {
            aTInterstitialListener.onInterstitialAdClicked(j.a(this.b));
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdClose() {
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customInterstitialAdapter.getTrackingInfo();
            int i = this.e;
            int i2 = i;
            if (i == 0) {
                i2 = this.b.getDismissType();
            }
            int i3 = i2;
            if (i2 == 0) {
                i3 = 1;
            }
            trackingInfo.y(i3);
            com.anythink.core.common.k.g.a(trackingInfo, g.i.e, g.i.f, "");
            long j = this.f8824c;
            if (j != 0) {
                com.anythink.core.common.j.c.a(trackingInfo, false, j, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.d);
            }
            com.anythink.core.common.j.c.a(trackingInfo, false);
            try {
                this.b.clearImpressionListener();
                this.b.destory();
            } catch (Throwable th) {
            }
            ATInterstitialListener aTInterstitialListener = this.f8823a;
            if (aTInterstitialListener != null) {
                aTInterstitialListener.onInterstitialAdClose(j.a(trackingInfo, this.b));
            }
            if (trackingInfo != null) {
                a(trackingInfo.W());
            }
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdShow() {
        this.f8824c = System.currentTimeMillis();
        this.d = SystemClock.elapsedRealtime();
        j a2 = j.a(this.b);
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customInterstitialAdapter.getTrackingInfo();
            String ilrd = this.b.getILRD();
            if (!TextUtils.isEmpty(ilrd)) {
                trackingInfo.a(ilrd);
            }
            String str = "";
            com.anythink.core.common.k.g.a(trackingInfo, g.i.f6512c, g.i.f, "");
            com.anythink.core.common.j.a.a(n.a().g()).a(4, trackingInfo, this.b.getUnitGroupInfo());
            if (trackingInfo != null) {
                str = trackingInfo.W();
                v.a().a(str, a2);
            }
            if (!TextUtils.isEmpty(str)) {
                a a3 = a.a(n.a().E(), str);
                if (a3.a((ATAdStatusInfo) null)) {
                    a3.a(n.a().E(), 6, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
                }
            }
        }
        ATInterstitialListener aTInterstitialListener = this.f8823a;
        if (aTInterstitialListener != null) {
            aTInterstitialListener.onInterstitialAdShow(a2);
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdVideoEnd() {
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null) {
            if (customInterstitialAdapter.getDismissType() == 0) {
                this.e = 3;
            }
            com.anythink.core.common.j.a.a(n.a().g()).a(9, this.b.getTrackingInfo());
            ATInterstitialListener aTInterstitialListener = this.f8823a;
            if (aTInterstitialListener != null) {
                aTInterstitialListener.onInterstitialAdVideoEnd(j.a(this.b));
            }
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdVideoError(String str, String str2) {
        String str3;
        this.e = 99;
        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.adShowError, str, str2);
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customInterstitialAdapter.getTrackingInfo();
            if (trackingInfo.H() == 66) {
                this.f = false;
            }
            com.anythink.core.common.j.c.a(trackingInfo, errorCode, this.b.getNetworkInfoMap());
            if (trackingInfo != null) {
                str3 = trackingInfo.W();
                a(trackingInfo.W());
            } else {
                str3 = "";
            }
            if (!TextUtils.isEmpty(str3)) {
                a a2 = a.a(n.a().E(), str3);
                if (a2.a((ATAdStatusInfo) null)) {
                    a2.a(n.a().E(), 7, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
                }
            }
        }
        ATInterstitialListener aTInterstitialListener = this.f8823a;
        if (aTInterstitialListener != null) {
            aTInterstitialListener.onInterstitialAdVideoError(errorCode);
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdVideoStart() {
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customInterstitialAdapter.getTrackingInfo();
            if (this.f) {
                com.anythink.core.common.j.a.a(n.a().g()).a(8, trackingInfo);
                ATInterstitialListener aTInterstitialListener = this.f8823a;
                if (aTInterstitialListener != null) {
                    aTInterstitialListener.onInterstitialAdVideoStart(j.a(this.b));
                }
            }
        }
    }
}
