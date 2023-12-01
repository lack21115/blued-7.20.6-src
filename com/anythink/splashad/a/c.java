package com.anythink.splashad.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.d.i;
import com.anythink.basead.ui.ThirdPartySplashAdView;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATMediationRequestInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.l;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.j;
import com.anythink.core.common.h;
import com.anythink.core.common.k.s;
import com.anythink.splashad.api.ATSplashSkipAdListener;
import com.anythink.splashad.api.ATSplashSkipInfo;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.bytedance.applog.tracker.Tracker;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/splashad/a/c.class */
public class c extends com.anythink.core.common.f<g> {

    /* renamed from: a  reason: collision with root package name */
    d f6348a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.splashad.a.c$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/splashad/a/c$2.class */
    public final class AnonymousClass2 implements l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean[] f6354a;
        final /* synthetic */ f b;

        AnonymousClass2(boolean[] zArr, f fVar) {
            this.f6354a = zArr;
            this.b = fVar;
        }

        public final void onAdClicked(View view) {
            this.b.onSplashAdClicked();
        }

        public final void onAdDislikeButtonClick() {
        }

        public final void onAdImpressed() {
            boolean[] zArr = this.f6354a;
            if (zArr[0]) {
                return;
            }
            zArr[0] = true;
            this.b.onSplashAdShow();
        }

        public final void onAdVideoEnd() {
        }

        public final void onAdVideoProgress(int i) {
        }

        public final void onAdVideoStart() {
        }

        public final void onDeeplinkCallback(boolean z) {
            this.b.onDeeplinkCallback(z);
        }

        public final void onDownloadConfirmCallback(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            this.b.onDownloadConfirm(context, aTNetworkConfirmInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.splashad.a.c$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/splashad/a/c$3.class */
    public final class AnonymousClass3 implements com.anythink.basead.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f6356a;

        AnonymousClass3(f fVar) {
            this.f6356a = fVar;
        }

        public final void onAdClick(int i) {
        }

        public final void onAdClosed() {
            this.f6356a.onSplashAdDismiss();
        }

        public final void onAdShow() {
        }

        public final void onDeeplinkCallback(boolean z) {
        }

        public final void onShowFailed(com.anythink.basead.c.e eVar) {
        }
    }

    private c(Context context, String str) {
        super(context, str);
    }

    private static h a(g gVar) {
        e eVar = new e(gVar.a());
        eVar.T = gVar.h;
        eVar.a(gVar.d);
        return eVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if ((r0 instanceof com.anythink.splashad.a.c) == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.anythink.splashad.a.c a(android.content.Context r5, java.lang.String r6) {
        /*
            com.anythink.core.common.v r0 = com.anythink.core.common.v.a()
            r1 = r6
            com.anythink.core.common.f r0 = r0.b(r1)
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L15
            r0 = r8
            r7 = r0
            r0 = r8
            boolean r0 = r0 instanceof com.anythink.splashad.a.c
            if (r0 != 0) goto L27
        L15:
            com.anythink.splashad.a.c r0 = new com.anythink.splashad.a.c
            r1 = r0
            r2 = r5
            r3 = r6
            r1.<init>(r2, r3)
            r7 = r0
            com.anythink.core.common.v r0 = com.anythink.core.common.v.a()
            r1 = r6
            r2 = r7
            r0.a(r1, r2)
        L27:
            r0 = r7
            com.anythink.splashad.a.c r0 = (com.anythink.splashad.a.c) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.splashad.a.c.a(android.content.Context, java.lang.String):com.anythink.splashad.a.c");
    }

    private void a(Activity activity, ViewGroup viewGroup, f fVar, boolean z, BaseAd baseAd, com.anythink.core.common.e.e eVar) {
        ThirdPartySplashAdView thirdPartySplashAdView;
        if (baseAd == null || !(baseAd instanceof com.anythink.core.common.e.a.e)) {
            Log.e(com.anythink.expressad.d.b.f4297c, "showThirdPartyNativeSplash fail,AdCache return illegal type adObject");
            if (fVar != null) {
                fVar.a(99);
                fVar.onSplashAdShowFail(ErrorCode.getErrorCode("4006", "", "showThirdPartyNativeSplash fail,AdCache return illegal type adObject"));
                fVar.onSplashAdDismiss();
                return;
            }
            return;
        }
        com.anythink.core.common.e.a.b bVar = new com.anythink.core.common.e.a.b((com.anythink.core.common.e.a.e) baseAd);
        com.anythink.core.common.e.a.c cVar = new com.anythink.core.common.e.a.c((com.anythink.core.common.e.a.a) baseAd, eVar, Integer.parseInt("4"));
        String a2 = a((j) cVar);
        baseAd.setNativeEventListener(new AnonymousClass2(new boolean[]{false}, fVar));
        i.a().a(a2, baseAd);
        ThirdPartySplashAdView thirdPartySplashAdView2 = new ThirdPartySplashAdView(activity.getApplicationContext(), cVar, bVar, new AnonymousClass3(fVar), a2);
        thirdPartySplashAdView2.setDontCountDown(z);
        if (baseAd.getCustomAdContainer() != null) {
            thirdPartySplashAdView = baseAd.getCustomAdContainer();
            thirdPartySplashAdView.addView(thirdPartySplashAdView2);
        } else {
            thirdPartySplashAdView = thirdPartySplashAdView2;
        }
        thirdPartySplashAdView2.registerNativeClickListener(viewGroup);
        viewGroup.addView(thirdPartySplashAdView);
    }

    static /* synthetic */ void a(c cVar, Activity activity, ViewGroup viewGroup, f fVar, boolean z, BaseAd baseAd, com.anythink.core.common.e.e eVar) {
        ThirdPartySplashAdView thirdPartySplashAdView;
        if (baseAd == null || !(baseAd instanceof com.anythink.core.common.e.a.e)) {
            Log.e(com.anythink.expressad.d.b.f4297c, "showThirdPartyNativeSplash fail,AdCache return illegal type adObject");
            fVar.a(99);
            fVar.onSplashAdShowFail(ErrorCode.getErrorCode("4006", "", "showThirdPartyNativeSplash fail,AdCache return illegal type adObject"));
            fVar.onSplashAdDismiss();
            return;
        }
        com.anythink.core.common.e.a.b bVar = new com.anythink.core.common.e.a.b((com.anythink.core.common.e.a.e) baseAd);
        com.anythink.core.common.e.a.c cVar2 = new com.anythink.core.common.e.a.c((com.anythink.core.common.e.a.a) baseAd, eVar, Integer.parseInt("4"));
        String a2 = a((j) cVar2);
        baseAd.setNativeEventListener(new AnonymousClass2(new boolean[]{false}, fVar));
        i.a().a(a2, baseAd);
        ThirdPartySplashAdView thirdPartySplashAdView2 = new ThirdPartySplashAdView(activity.getApplicationContext(), cVar2, bVar, new AnonymousClass3(fVar), a2);
        thirdPartySplashAdView2.setDontCountDown(z);
        if (baseAd.getCustomAdContainer() != null) {
            thirdPartySplashAdView = baseAd.getCustomAdContainer();
            thirdPartySplashAdView.addView(thirdPartySplashAdView2);
        } else {
            thirdPartySplashAdView = thirdPartySplashAdView2;
        }
        thirdPartySplashAdView2.registerNativeClickListener(viewGroup);
        viewGroup.addView(thirdPartySplashAdView);
    }

    private boolean a(String str, String str2, g gVar, com.anythink.core.common.b.a aVar) {
        if (aVar == null || !(aVar instanceof b)) {
            return false;
        }
        d dVar = new d(this.b);
        this.f6348a = dVar;
        dVar.a(gVar.a(), str, str2, gVar.b, gVar.c, (b) aVar, gVar.h);
        return true;
    }

    private void e(String str) {
        d dVar = this.f6348a;
        if (dVar != null) {
            com.anythink.core.common.e.e eVar = new com.anythink.core.common.e.e();
            eVar.x(dVar.f);
            eVar.y(dVar.e);
            eVar.z("4");
            eVar.w("0");
            eVar.a(true);
            com.anythink.core.common.j.c.a(eVar, ErrorCode.getErrorCode("2001", "", "Splash FetchAd Timeout."));
            this.f6348a.b = null;
            this.f6348a = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        h hVar = (h) this.d.get(str);
        this.d.remove(str);
        if (hVar != null) {
            if (hVar instanceof e) {
                ((e) hVar).j();
                return;
            }
            return;
        }
        com.anythink.core.common.e.e eVar2 = new com.anythink.core.common.e.e();
        eVar2.x(this.c);
        eVar2.y(str);
        eVar2.z("4");
        eVar2.w("0");
        eVar2.a(true);
        com.anythink.core.common.j.c.a(eVar2, ErrorCode.getErrorCode("2001", "", "Splash FetchAd Timeout."));
    }

    public final com.anythink.core.common.e.b a(Context context, boolean z, boolean z2, Map<String, Object> map) {
        d dVar = this.f6348a;
        com.anythink.core.common.e.b bVar = null;
        if (dVar != null) {
            bVar = null;
            if (dVar.d != null) {
                bVar = null;
                if (dVar.d.d() <= 0) {
                    bVar = dVar.d;
                }
            }
        }
        if (bVar != null) {
            com.anythink.core.common.e.e h = bVar.h();
            if (z) {
                com.anythink.core.common.j.c.a(h, true, -1, 0, h.x(), h.H(), h.u, "", h.X(), h.q == 3, "");
            }
            return bVar;
        }
        return super.a(context, z, z2, map);
    }

    public final /* synthetic */ h a(com.anythink.core.common.j jVar) {
        g gVar = (g) jVar;
        e eVar = new e(gVar.a());
        eVar.T = gVar.h;
        eVar.a(gVar.d);
        return eVar;
    }

    public final String a() {
        return "4";
    }

    public final void a(final Activity activity, final ViewGroup viewGroup, final a aVar, final ATEventInterface aTEventInterface, final ATSplashSkipInfo aTSplashSkipInfo, final String str, final Map<String, Object> map) {
        synchronized (this) {
            final com.anythink.core.common.e.b a2 = a((Context) activity, false, true, map);
            if (a2 == null) {
                Log.e(com.anythink.expressad.d.b.f4297c, "Splash No Cache.");
                return;
            }
            if (a2 != null && (a2.e() instanceof CustomSplashAdapter)) {
                a(a2);
                f();
                a2.a(a2.d() + 1);
                if (this.f6348a != null && this.f6348a.d == a2) {
                    this.f6348a.d = null;
                }
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.splashad.a.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        final CustomSplashAdapter customSplashAdapter = (CustomSplashAdapter) a2.e();
                        Activity activity2 = activity;
                        if (activity2 != null) {
                            customSplashAdapter.refreshActivityContext(activity2);
                        }
                        final com.anythink.core.common.e.e trackingInfo = a2.e().getTrackingInfo();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (trackingInfo != null) {
                            trackingInfo.v = c.this.g;
                            trackingInfo.C = str;
                            trackingInfo.h(com.anythink.core.common.k.g.a(trackingInfo.X(), trackingInfo.x(), currentTimeMillis));
                            s.a(c.this.b, trackingInfo);
                            s.a(map, trackingInfo);
                        }
                        com.anythink.core.common.a.a().a(c.this.b, a2);
                        com.anythink.core.common.j.a.a(c.this.b).a(13, trackingInfo, customSplashAdapter.getUnitGroupInfo(), currentTimeMillis);
                        n.a().a(new Runnable() { // from class: com.anythink.splashad.a.c.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                IExHandler b = n.a().b();
                                if (b != null) {
                                    CustomSplashAdapter customSplashAdapter2 = customSplashAdapter;
                                    customSplashAdapter2.setAdDownloadListener(b.createDownloadListener(customSplashAdapter2, (BaseAd) null, aTEventInterface));
                                }
                                boolean z = aTSplashSkipInfo != null && aTSplashSkipInfo.canUseCustomSkipView();
                                boolean isSupportCustomSkipView = customSplashAdapter.isSupportCustomSkipView();
                                if (z && isSupportCustomSkipView) {
                                    aTSplashSkipInfo.setContainer(viewGroup);
                                    customSplashAdapter.setSplashSkipInfo(aTSplashSkipInfo);
                                }
                                final f fVar = new f(customSplashAdapter, aVar);
                                if (customSplashAdapter.getMixedFormatAdType() == 0) {
                                    c.a(c.this, activity, viewGroup, fVar, z, a2.f(), trackingInfo);
                                } else {
                                    customSplashAdapter.internalShow(activity, viewGroup, fVar);
                                }
                                if (!z) {
                                    if (aTSplashSkipInfo != null) {
                                        Log.e(com.anythink.expressad.d.b.f4297c, "This AdSource does't support 'Custom SkipView' or 'SkipView' is null.");
                                        return;
                                    }
                                    return;
                                }
                                ATSplashSkipAdListener aTSplashSkipAdListener = aTSplashSkipInfo.getATSplashSkipAdListener();
                                if (aTSplashSkipAdListener != null) {
                                    aTSplashSkipAdListener.isSupportCustomSkipView(isSupportCustomSkipView);
                                }
                                if (isSupportCustomSkipView) {
                                    aTSplashSkipInfo.getSkipView().setOnClickListener(new View.OnClickListener() { // from class: com.anythink.splashad.a.c.1.1.1
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) {
                                            Tracker.onClick(view);
                                            f fVar2 = fVar;
                                            if (fVar2 != null) {
                                                fVar2.a(2);
                                                fVar.onSplashAdDismiss();
                                            }
                                        }
                                    });
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    public final void a(Context context, ATMediationRequestInfo aTMediationRequestInfo, String str, b bVar, int i, int i2, com.anythink.core.common.b.b bVar2, Map<String, Object> map) {
        g gVar = new g();
        gVar.a(context);
        gVar.b = aTMediationRequestInfo;
        gVar.c = str;
        gVar.h = i;
        gVar.d = i2;
        gVar.e = bVar2;
        gVar.g = map;
        super.a(this.b, "4", this.c, gVar, bVar);
    }

    public final void a(String str, com.anythink.core.common.b.a aVar) {
        if (aVar == null || !(aVar instanceof b)) {
            return;
        }
        ((b) aVar).setRequestId(str);
    }

    public final /* synthetic */ boolean a(String str, String str2, com.anythink.core.common.j jVar, com.anythink.core.common.b.a aVar) {
        g gVar = (g) jVar;
        if (aVar == null || !(aVar instanceof b)) {
            return false;
        }
        d dVar = new d(this.b);
        this.f6348a = dVar;
        dVar.a(gVar.a(), str, str2, gVar.b, gVar.c, (b) aVar, gVar.h);
        return true;
    }

    public final boolean g() {
        d dVar = this.f6348a;
        return dVar != null && dVar.a();
    }

    public final boolean i() {
        d dVar = this.f6348a;
        return dVar != null ? !TextUtils.isEmpty(dVar.e) : super.i();
    }
}
