package com.anythink.interstitial.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.basead.e.b;
import com.anythink.basead.ui.BaseAdActivity;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.AdError;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.n;
import com.anythink.core.common.h;
import com.anythink.core.common.k.g;
import com.anythink.core.common.k.s;
import com.anythink.core.common.res.b;
import com.anythink.core.common.v;
import com.anythink.expressad.foundation.h.i;
import com.anythink.interstitial.api.ATInterstitialAutoLoadListener;
import com.anythink.interstitial.api.ATInterstitialListener;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/interstitial/a/a.class */
public class a extends com.anythink.core.common.f<e> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8794a = a.class.getSimpleName();
    Runnable n;
    private View o;
    private AtomicBoolean p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.interstitial.a.a$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/interstitial/a/a$2.class */
    public final class AnonymousClass2 implements View.OnTouchListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.interstitial.a.a$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/interstitial/a/a$3.class */
    public final class AnonymousClass3 implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WeakReference f8801a;
        final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8802c;

        AnonymousClass3(WeakReference weakReference, String str, int i) {
            this.f8801a = weakReference;
            this.b = str;
            this.f8802c = i;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
            Log.e(a.f8794a, "load: image load fail:".concat(String.valueOf(str2)));
            ImageView imageView = (ImageView) this.f8801a.get();
            if (!TextUtils.equals(this.b, str) || imageView == null) {
                return;
            }
            imageView.setImageResource(this.f8802c);
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            ImageView imageView = (ImageView) this.f8801a.get();
            if (!TextUtils.equals(this.b, str) || imageView == null) {
                return;
            }
            imageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.interstitial.a.a$5  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/interstitial/a/a$5.class */
    public final class AnonymousClass5 implements b.InterfaceC0079b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f8804a;
        final /* synthetic */ String b;

        AnonymousClass5(d dVar, String str) {
            this.f8804a = dVar;
            this.b = str;
        }

        @Override // com.anythink.basead.e.b.InterfaceC0079b
        public final void a() {
            d dVar = this.f8804a;
            if (dVar != null) {
                dVar.onInterstitialAdShow();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0079b
        public final void a(int i) {
            d dVar = this.f8804a;
            if (dVar != null) {
                dVar.onInterstitialAdClicked();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0079b
        public final void a(com.anythink.basead.c.e eVar) {
            d dVar = this.f8804a;
            if (dVar != null) {
                dVar.onInterstitialAdVideoError(eVar.a(), eVar.b());
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0079b
        public final void a(boolean z) {
        }

        @Override // com.anythink.basead.e.b.InterfaceC0079b
        public final void b() {
            d dVar = this.f8804a;
            if (dVar != null) {
                dVar.onInterstitialAdVideoStart();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0079b
        public final void c() {
            d dVar = this.f8804a;
            if (dVar != null) {
                dVar.onInterstitialAdVideoEnd();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0079b
        public final void d() {
        }

        @Override // com.anythink.basead.e.b.InterfaceC0079b
        public final void e() {
            com.anythink.basead.e.b.a().b(this.b);
            d dVar = this.f8804a;
            if (dVar != null) {
                dVar.onInterstitialAdClose();
            }
        }
    }

    private a(Context context, String str) {
        super(context, str);
        this.p = new AtomicBoolean(false);
        this.n = new Runnable() { // from class: com.anythink.interstitial.a.a.4
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.j()) {
                    a.this.a(n.a().E(), 4, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
                }
            }
        };
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static h a2(e eVar) {
        f fVar = new f(eVar.a());
        fVar.a(eVar.d);
        return fVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if ((r0 instanceof com.anythink.interstitial.a.a) == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.anythink.interstitial.a.a a(android.content.Context r5, java.lang.String r6) {
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
            boolean r0 = r0 instanceof com.anythink.interstitial.a.a
            if (r0 != 0) goto L27
        L15:
            com.anythink.interstitial.a.a r0 = new com.anythink.interstitial.a.a
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
            com.anythink.interstitial.a.a r0 = (com.anythink.interstitial.a.a) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.interstitial.a.a.a(android.content.Context, java.lang.String):com.anythink.interstitial.a.a");
    }

    private void a(Activity activity) {
        if (activity == null) {
            return;
        }
        com.anythink.core.c.a b = com.anythink.core.c.b.a(this.b).b(n.a().p());
        String n = b.n();
        String m = b.m();
        if (this.o == null) {
            this.o = LayoutInflater.from(activity.getApplicationContext()).inflate(com.anythink.core.common.k.h.a(activity, "interstitial_loading_layout", "layout"), (ViewGroup) null);
        }
        this.o.setOnTouchListener(new AnonymousClass2());
        ImageView imageView = (ImageView) this.o.findViewById(com.anythink.core.common.k.h.a(activity, "interstitial_iv_loading", "id"));
        TextView textView = (TextView) this.o.findViewById(com.anythink.core.common.k.h.a(activity, "interstitial_tv_loading", "id"));
        int a2 = com.anythink.core.common.k.h.a(activity, 30.0f);
        imageView.setMinimumWidth(a2);
        imageView.setMinimumHeight(a2);
        int a3 = com.anythink.core.common.k.h.a(activity, 90.0f);
        imageView.setMaxWidth(a3);
        imageView.setMaxHeight(a3);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int a4 = com.anythink.core.common.k.h.a(activity, "interstitial_loading_default", i.f7952c);
        if (TextUtils.isEmpty(n)) {
            imageView.setImageResource(a4);
        } else {
            com.anythink.core.common.res.b.a(activity.getApplicationContext()).a(new com.anythink.core.common.res.e(3, n), new AnonymousClass3(new WeakReference(imageView), n, a4));
        }
        if (TextUtils.isEmpty(m)) {
            textView.setText(com.anythink.core.common.k.h.a(activity, "interstitial_text_loading_default", "string"));
        } else {
            textView.setText(m);
        }
        View view = this.o;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.o.getParent()).removeView(this.o);
        }
        ((ViewGroup) activity.getWindow().getDecorView()).addView(this.o, new FrameLayout.LayoutParams(-1, -1));
    }

    private void a(Activity activity, d dVar, BaseAd baseAd, com.anythink.core.common.e.e eVar, String str) {
        if (baseAd == null || !(baseAd instanceof com.anythink.core.common.e.a.e)) {
            Log.e("anythink", "showThirdPartyNativeSplash fail,AdCache return illegal type adObject");
            if (dVar != null) {
                dVar.onInterstitialAdVideoError("", "showThirdPartyNativeInterstitial fail,AdCache return illegal type adObject");
                return;
            }
            return;
        }
        com.anythink.core.common.e.a.b bVar = new com.anythink.core.common.e.a.b((com.anythink.core.common.e.a.e) baseAd);
        com.anythink.core.common.e.a.c cVar = new com.anythink.core.common.e.a.c((com.anythink.core.common.e.a.a) baseAd, eVar, Integer.parseInt("3"));
        String a2 = a(cVar);
        com.anythink.basead.e.b.a().a(a2, new AnonymousClass5(dVar, a2));
        com.anythink.basead.d.i.a().a(a2, baseAd);
        com.anythink.core.basead.b.a aVar = new com.anythink.core.basead.b.a();
        aVar.f6395c = bVar;
        aVar.d = a2;
        aVar.f6394a = 3;
        aVar.h = cVar;
        aVar.e = com.anythink.core.common.k.d.g(activity);
        aVar.b = str;
        BaseAdActivity.a(activity, aVar);
    }

    static /* synthetic */ void a(a aVar, Activity activity) {
        if (activity != null) {
            com.anythink.core.c.a b = com.anythink.core.c.b.a(aVar.b).b(n.a().p());
            String n = b.n();
            String m = b.m();
            if (aVar.o == null) {
                aVar.o = LayoutInflater.from(activity.getApplicationContext()).inflate(com.anythink.core.common.k.h.a(activity, "interstitial_loading_layout", "layout"), (ViewGroup) null);
            }
            aVar.o.setOnTouchListener(new AnonymousClass2());
            ImageView imageView = (ImageView) aVar.o.findViewById(com.anythink.core.common.k.h.a(activity, "interstitial_iv_loading", "id"));
            TextView textView = (TextView) aVar.o.findViewById(com.anythink.core.common.k.h.a(activity, "interstitial_tv_loading", "id"));
            int a2 = com.anythink.core.common.k.h.a(activity, 30.0f);
            imageView.setMinimumWidth(a2);
            imageView.setMinimumHeight(a2);
            int a3 = com.anythink.core.common.k.h.a(activity, 90.0f);
            imageView.setMaxWidth(a3);
            imageView.setMaxHeight(a3);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int a4 = com.anythink.core.common.k.h.a(activity, "interstitial_loading_default", i.f7952c);
            if (TextUtils.isEmpty(n)) {
                imageView.setImageResource(a4);
            } else {
                com.anythink.core.common.res.b.a(activity.getApplicationContext()).a(new com.anythink.core.common.res.e(3, n), new AnonymousClass3(new WeakReference(imageView), n, a4));
            }
            if (TextUtils.isEmpty(m)) {
                textView.setText(com.anythink.core.common.k.h.a(activity, "interstitial_text_loading_default", "string"));
            } else {
                textView.setText(m);
            }
            View view = aVar.o;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) aVar.o.getParent()).removeView(aVar.o);
            }
            ((ViewGroup) activity.getWindow().getDecorView()).addView(aVar.o, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    static /* synthetic */ void a(a aVar, Activity activity, d dVar, BaseAd baseAd, com.anythink.core.common.e.e eVar, String str) {
        if (baseAd == null || !(baseAd instanceof com.anythink.core.common.e.a.e)) {
            Log.e("anythink", "showThirdPartyNativeSplash fail,AdCache return illegal type adObject");
            dVar.onInterstitialAdVideoError("", "showThirdPartyNativeInterstitial fail,AdCache return illegal type adObject");
            return;
        }
        com.anythink.core.common.e.a.b bVar = new com.anythink.core.common.e.a.b((com.anythink.core.common.e.a.e) baseAd);
        com.anythink.core.common.e.a.c cVar = new com.anythink.core.common.e.a.c((com.anythink.core.common.e.a.a) baseAd, eVar, Integer.parseInt("3"));
        String a2 = a(cVar);
        com.anythink.basead.e.b.a().a(a2, new AnonymousClass5(dVar, a2));
        com.anythink.basead.d.i.a().a(a2, baseAd);
        com.anythink.core.basead.b.a aVar2 = new com.anythink.core.basead.b.a();
        aVar2.f6395c = bVar;
        aVar2.d = a2;
        aVar2.f6394a = 3;
        aVar2.h = cVar;
        aVar2.e = com.anythink.core.common.k.d.g(activity);
        aVar2.b = str;
        BaseAdActivity.a(activity, aVar2);
    }

    private static void m() {
    }

    private static void n() {
    }

    private static void o() {
    }

    private void p() {
        n.a().a(this.n, ((long) Math.pow(2.0d, this.h)) * 1000);
    }

    @Override // com.anythink.core.common.f
    public final ATAdStatusInfo a(Context context, Map<String, Object> map) {
        ATAdStatusInfo a2 = super.a(context, map);
        if (!c() && a(a2)) {
            a(context, 5, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, map);
        }
        return a2;
    }

    @Override // com.anythink.core.common.f
    public final /* synthetic */ h a(e eVar) {
        e eVar2 = eVar;
        f fVar = new f(eVar2.a());
        fVar.a(eVar2.d);
        return fVar;
    }

    @Override // com.anythink.core.common.f
    public final String a() {
        return "3";
    }

    public final void a(final Activity activity, final String str, final ATInterstitialListener aTInterstitialListener, final ATEventInterface aTEventInterface, final Map<String, Object> map) {
        synchronized (this) {
            if (this.p.get()) {
                StringBuilder sb = new StringBuilder("The placementId(");
                sb.append(this.f6687c);
                sb.append(") is already in the process of being delayed.");
                return;
            }
            final com.anythink.core.common.e.b a2 = a((Context) activity, false, true, map);
            if (a2 == null || !(a2.e() instanceof CustomInterstitialAdapter)) {
                if (a((ATAdStatusInfo) null)) {
                    a(n.a().E(), 7, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, map);
                }
                return;
            }
            a(a2);
            f();
            a2.a(a2.d() + 1);
            final int ae = a2.e().getUnitGroupInfo().ae();
            if (ae > 0) {
                this.p.set(true);
            }
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.interstitial.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    final CustomInterstitialAdapter customInterstitialAdapter = (CustomInterstitialAdapter) a2.e();
                    Activity activity2 = activity;
                    if (activity2 != null) {
                        customInterstitialAdapter.refreshActivityContext(activity2);
                    }
                    final com.anythink.core.common.e.e trackingInfo = a2.e().getTrackingInfo();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (trackingInfo != null) {
                        trackingInfo.v = a.this.g;
                        trackingInfo.C = str;
                        trackingInfo.h(g.a(trackingInfo.X(), trackingInfo.x(), currentTimeMillis));
                        s.a(a.this.b, trackingInfo);
                        s.a(map, trackingInfo);
                    }
                    com.anythink.core.common.a.a().a(a.this.b, a2);
                    com.anythink.core.common.j.a.a(a.this.b).a(13, trackingInfo, a2.e().getUnitGroupInfo(), currentTimeMillis);
                    if (ae > 0) {
                        n.a().a(new Runnable() { // from class: com.anythink.interstitial.a.a.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                a.a(a.this, activity);
                            }
                        });
                    }
                    n.a().a(new Runnable() { // from class: com.anythink.interstitial.a.a.1.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            customInterstitialAdapter.setScenario(str);
                            IExHandler b = n.a().b();
                            if (b != null) {
                                CustomInterstitialAdapter customInterstitialAdapter2 = customInterstitialAdapter;
                                customInterstitialAdapter2.setAdDownloadListener(b.createDownloadListener(customInterstitialAdapter2, null, aTEventInterface));
                            }
                            if (customInterstitialAdapter.getMixedFormatAdType() == 0) {
                                a.a(a.this, activity, new d(customInterstitialAdapter, aTInterstitialListener), a2.f(), trackingInfo, str);
                            } else {
                                customInterstitialAdapter.internalShow(activity, new d(customInterstitialAdapter, aTInterstitialListener));
                            }
                            if (ae <= 0 || !a.this.p.get()) {
                                return;
                            }
                            if (a.this.o != null) {
                                ((ViewGroup) a.this.o.getParent()).removeView(a.this.o);
                            }
                            a.this.p.set(false);
                        }
                    }, ae);
                }
            });
        }
    }

    public final void a(Context context, int i, com.anythink.core.common.b.a aVar, com.anythink.core.common.b.b bVar, Map<String, Object> map) {
        e eVar = new e();
        eVar.a(context);
        eVar.d = i;
        eVar.e = bVar;
        eVar.g = map;
        super.a(this.b, "3", this.f6687c, (String) eVar, aVar);
    }

    @Override // com.anythink.core.common.f
    public final void b(AdError adError) {
        super.b(adError);
        if (j()) {
            n.a().a(this.n, ((long) Math.pow(2.0d, this.h)) * 1000);
            ATInterstitialAutoLoadListener aTInterstitialAutoLoadListener = b.a().b;
            if (aTInterstitialAutoLoadListener != null) {
                aTInterstitialAutoLoadListener.onInterstitialAutoLoadFail(this.f6687c, adError);
            }
        }
    }

    @Override // com.anythink.core.common.f
    public final boolean j() {
        return v.a().f(this.f6687c);
    }

    @Override // com.anythink.core.common.f
    public final void k() {
        n.a().c(this.n);
    }

    @Override // com.anythink.core.common.f
    public final void l() {
        ATInterstitialAutoLoadListener aTInterstitialAutoLoadListener;
        super.l();
        if (!j() || (aTInterstitialAutoLoadListener = b.a().b) == null) {
            return;
        }
        aTInterstitialAutoLoadListener.onInterstitialAutoLoaded(this.f6687c);
    }
}
