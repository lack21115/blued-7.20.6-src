package com.anythink.rewardvideo.a;

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
import com.anythink.rewardvideo.api.ATRewardVideoExListener;
import com.anythink.rewardvideo.api.ATRewardVideoListener;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/rewardvideo/a/e.class */
public final class e implements CustomRewardedVideoEventListener {
    long b;

    /* renamed from: c  reason: collision with root package name */
    boolean f9185c;
    com.anythink.core.common.e.e d;
    boolean e;
    long f;
    long g;
    private ATRewardVideoListener j;
    private CustomRewardVideoAdapter k;
    private com.anythink.core.common.f.c l;
    private long m;
    private long n;
    int h = 0;

    /* renamed from: a  reason: collision with root package name */
    long f9184a = 0;
    boolean i = true;

    public e(CustomRewardVideoAdapter customRewardVideoAdapter, com.anythink.core.common.f.c cVar, ATRewardVideoListener aTRewardVideoListener) {
        this.j = aTRewardVideoListener;
        this.k = customRewardVideoAdapter;
        this.l = cVar;
    }

    private com.anythink.core.common.e.e a() {
        CustomRewardVideoAdapter customRewardVideoAdapter;
        if (this.d == null && (customRewardVideoAdapter = this.k) != null) {
            com.anythink.core.common.e.e N = customRewardVideoAdapter.getTrackingInfo().N();
            this.d = N;
            N.q = 6;
            this.d.h(g.b(this.d.X(), this.d.x(), System.currentTimeMillis()));
        }
        return this.d;
    }

    private void a(AdError adError, com.anythink.core.common.e.e eVar) {
        g.a(eVar, g.i.f6512c, g.i.g, adError.printStackTrace());
        CustomRewardVideoAdapter customRewardVideoAdapter = this.k;
        com.anythink.core.common.j.c.a(eVar, adError, customRewardVideoAdapter != null ? customRewardVideoAdapter.getNetworkInfoMap() : null);
    }

    private void a(com.anythink.core.common.e.e eVar) {
        String ilrd = this.k.getILRD();
        if (!TextUtils.isEmpty(ilrd)) {
            eVar.a(ilrd);
        }
        if (this.i) {
            com.anythink.core.common.j.a.a(n.a().g()).a(8, eVar);
        }
        com.anythink.core.common.j.a.a(n.a().g()).a(4, eVar, this.k.getUnitGroupInfo());
        com.anythink.core.common.k.g.a(eVar, g.i.f6512c, g.i.f, "");
    }

    private static void a(String str) {
        com.anythink.core.common.e.d d;
        if (TextUtils.isEmpty(str) || (d = v.a().d(str)) == null) {
            return;
        }
        v.a().e(str);
        a.a(n.a().g(), str).d(v.a().a(str, d.a()));
    }

    private static void b(com.anythink.core.common.e.e eVar) {
        com.anythink.core.common.j.a.a(n.a().g()).a(9, eVar);
    }

    private static void c(com.anythink.core.common.e.e eVar) {
        com.anythink.core.common.j.a.a(n.a().g()).a(6, eVar);
        com.anythink.core.common.k.g.a(eVar, g.i.d, g.i.f, "");
    }

    private void d(com.anythink.core.common.e.e eVar) {
        com.anythink.core.common.j.a.a(n.a().g()).a(13, eVar, this.k.getUnitGroupInfo());
        a(eVar);
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onAgainReward() {
        com.anythink.core.common.f.c cVar;
        com.anythink.core.common.e.e a2 = a();
        if (!this.e && (cVar = this.l) != null) {
            cVar.a(this.f, this.g, this.k, a2);
        }
        this.e = true;
        ATRewardVideoListener aTRewardVideoListener = this.j;
        if (aTRewardVideoListener == null || !(aTRewardVideoListener instanceof ATRewardVideoExListener)) {
            return;
        }
        ((ATRewardVideoExListener) aTRewardVideoListener).onAgainReward(j.a(a2, this.k));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onDeeplinkCallback(boolean z) {
        ATRewardVideoListener aTRewardVideoListener = this.j;
        if (aTRewardVideoListener == null || !(aTRewardVideoListener instanceof ATRewardVideoExListener)) {
            return;
        }
        ((ATRewardVideoExListener) aTRewardVideoListener).onDeeplinkCallback(j.a(this.k), z);
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        ATRewardVideoListener aTRewardVideoListener = this.j;
        if (aTRewardVideoListener == null || !(aTRewardVideoListener instanceof ATRewardVideoExListener)) {
            return;
        }
        ((ATRewardVideoExListener) aTRewardVideoListener).onDownloadConfirm(context, j.a(this.k), aTNetworkConfirmInfo);
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onReward() {
        com.anythink.core.common.f.c cVar;
        if (!this.f9185c && (cVar = this.l) != null) {
            long j = this.m;
            long j2 = this.n;
            CustomRewardVideoAdapter customRewardVideoAdapter = this.k;
            cVar.a(j, j2, customRewardVideoAdapter, customRewardVideoAdapter.getTrackingInfo());
        }
        this.f9185c = true;
        ATRewardVideoListener aTRewardVideoListener = this.j;
        if (aTRewardVideoListener != null) {
            aTRewardVideoListener.onReward(j.a(this.k));
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdAgainPlayClicked() {
        com.anythink.core.common.e.e a2 = a();
        if (this.k != null && a2 != null) {
            c(a2);
        }
        ATRewardVideoListener aTRewardVideoListener = this.j;
        if (aTRewardVideoListener == null || !(aTRewardVideoListener instanceof ATRewardVideoExListener)) {
            return;
        }
        ((ATRewardVideoExListener) aTRewardVideoListener).onRewardedVideoAdAgainPlayClicked(j.a(a2, this.k));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdAgainPlayEnd() {
        if (this.g == 0) {
            this.g = SystemClock.elapsedRealtime();
        }
        com.anythink.core.common.e.e a2 = a();
        if (this.k != null && a2 != null) {
            b(a2);
        }
        ATRewardVideoListener aTRewardVideoListener = this.j;
        if (aTRewardVideoListener == null || !(aTRewardVideoListener instanceof ATRewardVideoExListener)) {
            return;
        }
        ((ATRewardVideoExListener) aTRewardVideoListener).onRewardedVideoAdAgainPlayEnd(j.a(a2, this.k));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdAgainPlayFailed(String str, String str2) {
        this.h = 99;
        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.adShowError, str, str2);
        com.anythink.core.common.e.e a2 = a();
        if (this.k != null && a2 != null) {
            a(errorCode, a2);
        }
        ATRewardVideoListener aTRewardVideoListener = this.j;
        if (aTRewardVideoListener == null || !(aTRewardVideoListener instanceof ATRewardVideoExListener)) {
            return;
        }
        ((ATRewardVideoExListener) aTRewardVideoListener).onRewardedVideoAdAgainPlayFailed(errorCode, j.a(a2, this.k));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdAgainPlayStart() {
        this.h = 0;
        if (this.f == 0) {
            this.f = SystemClock.elapsedRealtime();
        }
        this.g = 0L;
        com.anythink.core.common.e.e a2 = a();
        if (this.k != null && a2 != null) {
            com.anythink.core.common.j.a.a(n.a().g()).a(13, a2, this.k.getUnitGroupInfo());
            a(a2);
        }
        ATRewardVideoListener aTRewardVideoListener = this.j;
        if (aTRewardVideoListener == null || !(aTRewardVideoListener instanceof ATRewardVideoExListener)) {
            return;
        }
        ((ATRewardVideoExListener) aTRewardVideoListener).onRewardedVideoAdAgainPlayStart(j.a(a2, this.k));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdClosed() {
        CustomRewardVideoAdapter customRewardVideoAdapter = this.k;
        if (customRewardVideoAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customRewardVideoAdapter.getTrackingInfo();
            int i = this.h;
            int i2 = i;
            if (i == 0) {
                i2 = this.k.getDismissType();
            }
            int i3 = i2;
            if (i2 == 0) {
                i3 = 1;
            }
            trackingInfo.y(i3);
            com.anythink.core.common.k.g.a(trackingInfo, g.i.e, g.i.f, "");
            long j = this.f9184a;
            if (j != 0) {
                com.anythink.core.common.j.c.a(trackingInfo, this.f9185c, j, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.b);
            }
            com.anythink.core.common.j.c.a(trackingInfo, this.f9185c);
            if (this.f9185c) {
                try {
                    this.k.clearImpressionListener();
                    this.k.destory();
                } catch (Throwable th) {
                }
            } else {
                n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.e.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            e.this.k.clearImpressionListener();
                            e.this.k.destory();
                        } catch (Throwable th2) {
                        }
                    }
                }, 5000L);
            }
            if (trackingInfo != null) {
                a(trackingInfo.W());
            }
            ATRewardVideoListener aTRewardVideoListener = this.j;
            if (aTRewardVideoListener != null) {
                aTRewardVideoListener.onRewardedVideoAdClosed(j.a(trackingInfo, this.k));
            }
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdPlayClicked() {
        CustomRewardVideoAdapter customRewardVideoAdapter = this.k;
        if (customRewardVideoAdapter != null) {
            c(customRewardVideoAdapter.getTrackingInfo());
        }
        ATRewardVideoListener aTRewardVideoListener = this.j;
        if (aTRewardVideoListener != null) {
            aTRewardVideoListener.onRewardedVideoAdPlayClicked(j.a(this.k));
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdPlayEnd() {
        if (this.n == 0) {
            this.n = SystemClock.elapsedRealtime();
        }
        CustomRewardVideoAdapter customRewardVideoAdapter = this.k;
        if (customRewardVideoAdapter != null) {
            if (customRewardVideoAdapter.getDismissType() == 0) {
                this.h = 3;
            }
            b(this.k.getTrackingInfo());
        }
        ATRewardVideoListener aTRewardVideoListener = this.j;
        if (aTRewardVideoListener != null) {
            aTRewardVideoListener.onRewardedVideoAdPlayEnd(j.a(this.k));
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdPlayFailed(String str, String str2) {
        this.h = 99;
        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.adShowError, str, str2);
        CustomRewardVideoAdapter customRewardVideoAdapter = this.k;
        if (customRewardVideoAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customRewardVideoAdapter.getTrackingInfo();
            if (trackingInfo.H() == 66) {
                this.i = false;
            }
            String W = trackingInfo.W();
            a(errorCode, trackingInfo);
            if (trackingInfo != null) {
                a(trackingInfo.W());
            }
            if (!TextUtils.isEmpty(W)) {
                a a2 = a.a(n.a().E(), W);
                if (a2.a((ATAdStatusInfo) null)) {
                    a2.a(n.a().E(), 7, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
                }
            }
        }
        ATRewardVideoListener aTRewardVideoListener = this.j;
        if (aTRewardVideoListener != null) {
            aTRewardVideoListener.onRewardedVideoAdPlayFailed(errorCode, j.a(this.k));
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdPlayStart() {
        ATRewardVideoListener aTRewardVideoListener;
        String str;
        this.f9184a = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.b = elapsedRealtime;
        if (this.m == 0) {
            this.m = elapsedRealtime;
        }
        j a2 = j.a(this.k);
        CustomRewardVideoAdapter customRewardVideoAdapter = this.k;
        if (customRewardVideoAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customRewardVideoAdapter.getTrackingInfo();
            a(trackingInfo);
            if (trackingInfo != null) {
                str = trackingInfo.W();
                v.a().a(str, a2);
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                a a3 = a.a(n.a().E(), str);
                if (a3.a((ATAdStatusInfo) null)) {
                    a3.a(n.a().E(), 6, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
                }
            }
        }
        if (!this.i || (aTRewardVideoListener = this.j) == null) {
            return;
        }
        aTRewardVideoListener.onRewardedVideoAdPlayStart(a2);
    }
}
