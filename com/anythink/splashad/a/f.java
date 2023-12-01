package com.anythink.splashad.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.j;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.a.f;
import com.anythink.core.common.k.u;
import com.anythink.core.common.v;
import com.anythink.splashad.api.ATSplashAdExtraInfo;
import com.anythink.splashad.api.ATSplashSkipAdListener;
import com.anythink.splashad.api.ATSplashSkipInfo;
import com.anythink.splashad.api.IATSplashEyeAd;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.anythink.splashad.unitgroup.api.CustomSplashEventListener;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/splashad/a/f.class */
public final class f implements CustomSplashEventListener {

    /* renamed from: a  reason: collision with root package name */
    CustomSplashAdapter f9203a;
    a b;

    /* renamed from: c  reason: collision with root package name */
    long f9204c;
    private Timer d;
    private boolean e = false;
    private int f = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.splashad.a.f$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/splashad/a/f$1.class */
    public final class AnonymousClass1 extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f9205a;
        final /* synthetic */ f.b b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ATSplashSkipAdListener f9206c;
        final /* synthetic */ long d;
        final /* synthetic */ long e;

        AnonymousClass1(ViewGroup viewGroup, f.b bVar, ATSplashSkipAdListener aTSplashSkipAdListener, long j, long j2) {
            this.f9205a = viewGroup;
            this.b = bVar;
            this.f9206c = aTSplashSkipAdListener;
            this.d = j;
            this.e = j2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            ViewGroup viewGroup = this.f9205a;
            if (viewGroup == null || u.a(viewGroup, this.b)) {
                n.a().a(new Runnable() { // from class: com.anythink.splashad.a.f.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (f.this.f9204c <= 0) {
                            f.this.a(3);
                            f.this.onSplashAdDismiss();
                        } else if (AnonymousClass1.this.f9206c != null) {
                            AnonymousClass1.this.f9206c.onAdTick(AnonymousClass1.this.d, f.this.f9204c);
                        }
                        f.this.f9204c -= AnonymousClass1.this.e;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.splashad.a.f$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/splashad/a/f$2.class */
    public final class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ATSplashSkipAdListener f9208a;
        final /* synthetic */ long b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f9209c;

        AnonymousClass2(ATSplashSkipAdListener aTSplashSkipAdListener, long j, long j2) {
            this.f9208a = aTSplashSkipAdListener;
            this.b = j;
            this.f9209c = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ATSplashSkipAdListener aTSplashSkipAdListener = this.f9208a;
            if (aTSplashSkipAdListener != null) {
                aTSplashSkipAdListener.onAdTick(this.b, f.this.f9204c);
                f.this.f9204c -= this.f9209c;
            }
        }
    }

    public f(CustomSplashAdapter customSplashAdapter, a aVar) {
        this.f9203a = customSplashAdapter;
        this.b = aVar;
    }

    private void a() {
        Timer timer = this.d;
        if (timer != null) {
            timer.cancel();
            this.d = null;
        }
    }

    private void a(ATSplashSkipInfo aTSplashSkipInfo) {
        if (this.d == null) {
            long callbackInterval = aTSplashSkipInfo.getCallbackInterval();
            long countDownDuration = aTSplashSkipInfo.getCountDownDuration();
            ViewGroup container = aTSplashSkipInfo.getContainer();
            f.b bVar = new f.b();
            ATSplashSkipAdListener aTSplashSkipAdListener = aTSplashSkipInfo.getATSplashSkipAdListener();
            this.f9204c = countDownDuration;
            Timer timer = new Timer();
            this.d = timer;
            timer.schedule(new AnonymousClass1(container, bVar, aTSplashSkipAdListener, countDownDuration, callbackInterval), callbackInterval, callbackInterval);
            n.a().a(new AnonymousClass2(aTSplashSkipAdListener, countDownDuration, callbackInterval));
        }
    }

    private static void a(String str) {
        com.anythink.core.common.e.d d;
        if (TextUtils.isEmpty(str) || (d = v.a().d(str)) == null) {
            return;
        }
        v.a().e(str);
        c.a(n.a().g(), str).d(v.a().a(str, d.a()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        this.f = i;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onDeeplinkCallback(boolean z) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.onDeeplinkCallback(j.a(this.f9203a), z);
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.onDownloadConfirm(context, j.a(this.f9203a), aTNetworkConfirmInfo);
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onSplashAdClicked() {
        CustomSplashAdapter customSplashAdapter = this.f9203a;
        if (customSplashAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customSplashAdapter.getTrackingInfo();
            com.anythink.core.common.j.a.a(n.a().g()).a(6, trackingInfo);
            com.anythink.core.common.k.g.a(trackingInfo, g.i.d, g.i.f, "");
        }
        a aVar = this.b;
        if (aVar != null) {
            aVar.onAdClick(j.a(this.f9203a));
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onSplashAdDismiss() {
        com.anythink.core.common.e.d d;
        Timer timer = this.d;
        if (timer != null) {
            timer.cancel();
        }
        CustomSplashAdapter customSplashAdapter = this.f9203a;
        if (customSplashAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customSplashAdapter.getTrackingInfo();
            int i = this.f;
            if (i != 0) {
                trackingInfo.y(i);
            } else {
                int dismissType = this.f9203a.getDismissType();
                i = dismissType;
                if (dismissType == 0) {
                    i = 1;
                }
                trackingInfo.y(i);
            }
            com.anythink.core.common.j.c.a(trackingInfo, false);
            ATSplashSkipInfo splashSkipInfo = this.f9203a.getSplashSkipInfo();
            IATSplashEyeAd iATSplashEyeAd = null;
            if (splashSkipInfo != null && splashSkipInfo.canUseCustomSkipView()) {
                this.f9203a.startSplashCustomSkipViewClickEye();
                Timer timer2 = this.d;
                if (timer2 != null) {
                    timer2.cancel();
                    this.d = null;
                }
                splashSkipInfo.destroy();
                this.f9203a.setSplashSkipInfo(null);
            }
            com.anythink.core.common.k.g.a(trackingInfo, g.i.e, g.i.f, "");
            String W = trackingInfo.W();
            if (!TextUtils.isEmpty(W) && (d = v.a().d(W)) != null) {
                v.a().e(W);
                c.a(n.a().g(), W).d(v.a().a(W, d.a()));
            }
            CustomSplashAdapter customSplashAdapter2 = this.f9203a;
            if (customSplashAdapter2 instanceof CustomSplashAdapter) {
                iATSplashEyeAd = customSplashAdapter2.getSplashEyeAd();
            }
            a aVar = this.b;
            if (aVar != null && !this.e) {
                this.e = true;
                aVar.onCallbackAdDismiss(j.a(trackingInfo, this.f9203a), new ATSplashAdExtraInfo(i, iATSplashEyeAd));
            }
            if (iATSplashEyeAd == null) {
                CustomSplashAdapter customSplashAdapter3 = this.f9203a;
                if (customSplashAdapter3 != null) {
                    customSplashAdapter3.cleanImpressionListener();
                }
                CustomSplashAdapter customSplashAdapter4 = this.f9203a;
                if (customSplashAdapter4 != null) {
                    customSplashAdapter4.destory();
                }
            }
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onSplashAdShow() {
        j a2 = j.a(this.f9203a);
        CustomSplashAdapter customSplashAdapter = this.f9203a;
        if (customSplashAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customSplashAdapter.getTrackingInfo();
            com.anythink.core.common.j.a.a(n.a().g()).a(4, trackingInfo, this.f9203a.getUnitGroupInfo());
            com.anythink.core.common.k.g.a(trackingInfo, g.i.f6512c, g.i.f, "");
            ATSplashSkipInfo splashSkipInfo = this.f9203a.getSplashSkipInfo();
            if (splashSkipInfo != null && splashSkipInfo.canUseCustomSkipView() && this.f9203a.isSupportCustomSkipView() && this.d == null) {
                long callbackInterval = splashSkipInfo.getCallbackInterval();
                long countDownDuration = splashSkipInfo.getCountDownDuration();
                ViewGroup container = splashSkipInfo.getContainer();
                f.b bVar = new f.b();
                ATSplashSkipAdListener aTSplashSkipAdListener = splashSkipInfo.getATSplashSkipAdListener();
                this.f9204c = countDownDuration;
                Timer timer = new Timer();
                this.d = timer;
                timer.schedule(new AnonymousClass1(container, bVar, aTSplashSkipAdListener, countDownDuration, callbackInterval), callbackInterval, callbackInterval);
                n.a().a(new AnonymousClass2(aTSplashSkipAdListener, countDownDuration, callbackInterval));
            }
            if (trackingInfo != null) {
                v.a().a(trackingInfo.W(), a2);
            }
        }
        a aVar = this.b;
        if (aVar != null) {
            aVar.onAdShow(a2);
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onSplashAdShowFail(AdError adError) {
        CustomSplashAdapter customSplashAdapter = this.f9203a;
        if (customSplashAdapter != null) {
            com.anythink.core.common.j.c.a(customSplashAdapter.getTrackingInfo(), adError, this.f9203a.getNetworkInfoMap());
        }
    }
}
