package com.kwad.components.core.d.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.webview.a.kwai.k;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/d/b/a.class */
public final class a {
    private static List<WeakReference<k.b>> IH;

    /* renamed from: com.kwad.components.core.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/d/b/a$a.class */
    public static final class C0349a {
        private boolean II;
        private boolean IJ;
        private boolean IK;
        private b IL;
        private c IM;
        private boolean IN;
        private long IO;
        private boolean IP;
        private boolean IQ;
        private y.b IR;
        private JSONObject IS;
        private boolean IT = false;
        private boolean IU;
        private int IV;
        private int IW;
        private int IX;
        private String IY;
        private AdTemplate adTemplate;
        private final Context context;
        private IAdLivePlayModule eV;
        private int jS;
        private int jU;

        public C0349a(Context context) {
            this.context = context;
        }

        public final C0349a I(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final C0349a a(b bVar) {
            this.IL = bVar;
            return this;
        }

        public final C0349a a(y.b bVar) {
            this.IR = bVar;
            return this;
        }

        public final C0349a an(int i) {
            this.IX = i;
            return this;
        }

        public final C0349a ao(int i) {
            this.jU = i;
            return this;
        }

        public final C0349a ao(boolean z) {
            this.IN = z;
            return this;
        }

        public final C0349a ap(int i) {
            this.jS = i;
            return this;
        }

        public final C0349a ap(String str) {
            this.IY = str;
            return this;
        }

        public final C0349a ap(boolean z) {
            this.IP = z;
            return this;
        }

        public final C0349a aq(int i) {
            this.IV = i;
            return this;
        }

        public final C0349a aq(boolean z) {
            this.IQ = z;
            return this;
        }

        public final C0349a ar(int i) {
            this.IW = i;
            return this;
        }

        public final C0349a ar(boolean z) {
            this.IT = z;
            return this;
        }

        public final C0349a as(boolean z) {
            this.IJ = z;
            return this;
        }

        public final C0349a at(boolean z) {
            this.IK = true;
            return this;
        }

        public final C0349a au(boolean z) {
            this.II = z;
            return this;
        }

        public final C0349a av(boolean z) {
            this.IU = z;
            return this;
        }

        public final C0349a b(c cVar) {
            this.IM = cVar;
            return this;
        }

        public final C0349a b(IAdLivePlayModule iAdLivePlayModule) {
            this.eV = iAdLivePlayModule;
            return this;
        }

        public final C0349a d(JSONObject jSONObject) {
            this.IS = jSONObject;
            return this;
        }

        public final int db() {
            return this.jS;
        }

        public final int de() {
            return this.jU;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final y.b getClientParams() {
            return this.IR;
        }

        public final Context getContext() {
            return this.context;
        }

        public final c hb() {
            return this.IM;
        }

        public final JSONObject ho() {
            return this.IS;
        }

        public final IAdLivePlayModule jG() {
            return this.eV;
        }

        public final String mM() {
            return this.IY;
        }

        public final b mN() {
            return this.IL;
        }

        public final int mO() {
            return this.IX;
        }

        public final boolean mP() {
            return this.IN;
        }

        public final long mQ() {
            return this.IO;
        }

        public final boolean mR() {
            return this.IP;
        }

        public final boolean mS() {
            return this.IQ;
        }

        public final boolean mT() {
            return this.IT;
        }

        public final boolean mU() {
            return this.IJ;
        }

        public final boolean mV() {
            return this.IK;
        }

        public final boolean mW() {
            return this.II;
        }

        public final boolean mX() {
            return this.IU;
        }

        public final int mY() {
            return this.IV;
        }

        public final int mZ() {
            return this.IW;
        }

        public final C0349a q(long j) {
            this.IO = j;
            return this;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/d/b/a$b.class */
    public interface b {
        void onAdClicked();
    }

    public static int a(Context context, AdTemplate adTemplate, b bVar, c cVar, boolean z, boolean z2, boolean z3) {
        adTemplate.converted = true;
        d.aw(false);
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
        C0349a I = new C0349a(context).I(adTemplate);
        int ae = com.kwad.sdk.core.response.a.a.ae(cb);
        if (!(z3 || I.mZ() == 2 || I.mZ() == 1) && !TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.aK(cb)) && !I.mV()) {
            if (ae == 1) {
                boolean aZ = com.kwad.sdk.core.response.a.a.aZ(cb);
                bVar.onAdClicked();
                if (aZ) {
                    d(I.getContext(), adTemplate);
                    return 0;
                }
                a(I.getContext(), new AdWebViewActivityProxy.a.C0359a().av(com.kwad.sdk.core.response.a.b.bg(adTemplate)).L(adTemplate).oc());
                return 0;
            } else if (ae == 2) {
                if (a(I, 1) != 1) {
                    boolean aZ2 = com.kwad.sdk.core.response.a.a.aZ(cb);
                    bVar.onAdClicked();
                    if (aZ2) {
                        d(I.getContext(), adTemplate);
                        return 0;
                    }
                    a(I.getContext(), new AdWebViewActivityProxy.a.C0359a().av(com.kwad.sdk.core.response.a.b.bg(adTemplate)).L(adTemplate).oc());
                    return 0;
                }
                d.aw(true);
                bVar.onAdClicked();
                return 0;
            }
        }
        if (a(I, 1) != 1) {
            if (!com.kwad.sdk.core.response.a.a.ax(cb)) {
                bVar.onAdClicked();
                if (com.kwad.sdk.utils.d.f(context, com.kwad.sdk.core.response.a.a.cu(cb), com.kwad.sdk.core.response.a.a.aq(cb))) {
                    com.kwad.sdk.core.report.a.l(adTemplate, 0);
                    return 0;
                }
                a(context, new AdWebViewActivityProxy.a.C0359a().av(com.kwad.sdk.core.response.a.b.bg(adTemplate)).L(adTemplate).oc());
                return 0;
            } else if (cVar != null) {
                int m = cVar.m(new C0349a(context).ao(z).I(adTemplate).ap(z2).ar(false));
                if (cb.status != 2 && cb.status != 3) {
                    bVar.onAdClicked();
                }
                return m;
            } else {
                return 0;
            }
        }
        d.aw(true);
        bVar.onAdClicked();
        return 0;
    }

    public static int a(C0349a c0349a) {
        d.aw(false);
        BusinessType businessType = c0349a.adTemplate != null ? c0349a.adTemplate.getBusinessType() : null;
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(businessType, "adClick").report();
        if (c0349a.mW()) {
            a(c0349a.getContext(), c0349a.getAdTemplate(), c0349a.mN(), c0349a.hb(), c0349a.IN, c0349a.mR(), false);
            return 0;
        } else if (b(c0349a)) {
            return 0;
        } else {
            c0349a.getAdTemplate().converted = true;
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(c0349a.getAdTemplate());
            com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
            int ae = com.kwad.sdk.core.response.a.a.ae(cb);
            if (!(c0349a.mZ() == 2 || c0349a.mZ() == 1) && !TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.aK(cb)) && !c0349a.mV()) {
                if (ae == 1) {
                    boolean aZ = com.kwad.sdk.core.response.a.a.aZ(cb);
                    e(c0349a);
                    if (aZ) {
                        d(c0349a.getContext(), c0349a.getAdTemplate());
                        return 0;
                    }
                    a(c0349a.getContext(), new AdWebViewActivityProxy.a.C0359a().av(com.kwad.sdk.core.response.a.b.bg(c0349a.getAdTemplate())).L(c0349a.getAdTemplate()).oc());
                    return 0;
                } else if (ae == 2) {
                    if (a(c0349a, 1) == 1) {
                        if (com.kwad.sdk.core.response.a.a.cp(cb)) {
                            com.kwad.sdk.core.report.a.n(c0349a.getAdTemplate(), (int) Math.ceil(((float) c0349a.mQ()) / 1000.0f));
                        }
                        d.aw(true);
                        e(c0349a);
                        return 0;
                    }
                    boolean aZ2 = com.kwad.sdk.core.response.a.a.aZ(cb);
                    e(c0349a);
                    if (aZ2) {
                        d(c0349a.getContext(), c0349a.getAdTemplate());
                        return 0;
                    }
                    a(c0349a.getContext(), new AdWebViewActivityProxy.a.C0359a().av(com.kwad.sdk.core.response.a.b.bg(c0349a.getAdTemplate())).L(c0349a.getAdTemplate()).oc());
                    return 0;
                }
            }
            if (a(c0349a, 1) == 1) {
                if (com.kwad.sdk.core.response.a.a.cp(cb) || com.kwad.sdk.core.response.a.a.cq(cb)) {
                    com.kwad.sdk.core.report.a.n(c0349a.getAdTemplate(), (int) Math.ceil(((float) c0349a.mQ()) / 1000.0f));
                }
                d.aw(true);
                e(c0349a);
                return 0;
            } else if (e.f(c0349a.getContext(), c0349a.getAdTemplate()) == 1) {
                e(c0349a);
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(businessType, "smallAppSuccess").report();
                return 0;
            } else if (c0349a.mU() && !com.kwad.sdk.core.response.a.a.ax(cb)) {
                e(c0349a);
                i(c0349a);
                return 0;
            } else if (!com.kwad.sdk.core.response.a.a.ax(cb)) {
                if (c0349a.getAdTemplate().isWebViewDownload) {
                    return h(c0349a);
                }
                boolean f = com.kwad.sdk.utils.d.f(c0349a.getContext(), com.kwad.sdk.core.response.a.a.cu(cb), com.kwad.sdk.core.response.a.a.aq(cb));
                e(c0349a);
                if (f) {
                    com.kwad.sdk.core.report.a.l(c0349a.getAdTemplate(), 0);
                    return 0;
                }
                a(c0349a.getContext(), new AdWebViewActivityProxy.a.C0359a().av(com.kwad.sdk.core.response.a.b.bg(c0349a.getAdTemplate())).L(c0349a.getAdTemplate()).oc());
                return 0;
            } else if (com.kwad.sdk.core.response.a.a.ax(cb)) {
                if (c0349a.mZ() == 2 || c0349a.mZ() == 1) {
                    c0349a.ar(false);
                    e(c0349a);
                } else {
                    e(c0349a);
                    if (c(c0349a)) {
                        return 0;
                    }
                    c0349a.ar(true);
                }
                return h(c0349a);
            } else {
                return 0;
            }
        }
    }

    private static int a(C0349a c0349a, int i) {
        AdTemplate adTemplate = c0349a.getAdTemplate();
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck((adTemplate == null || adTemplate.mAdScene == null) ? null : KSLoggerReporter.bv(adTemplate.mAdScene.getAdStyle()), "dplinkStart").report();
        int b2 = d.b(c0349a, 1);
        String a2 = d.a(c0349a, adTemplate);
        boolean z = true;
        if (!TextUtils.isEmpty(a2)) {
            z = a2.contains(" ");
        }
        if (z) {
            KSLoggerReporter.ReportClient.RESPONE_MONITOR.buildNormalApmReporter().cC("response_biz_error_convert").aF(adTemplate).J("dpLinkError", a2).report();
        }
        return b2;
    }

    private static void a(Context context, AdWebViewActivityProxy.a aVar) {
        AdWebViewActivityProxy.launch(context, aVar);
    }

    public static void a(k.b bVar) {
        if (IH == null) {
            IH = new CopyOnWriteArrayList();
        }
        IH.add(new WeakReference<>(bVar));
    }

    public static void b(k.b bVar) {
        int i;
        if (IH == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= IH.size()) {
                i = -1;
                break;
            }
            WeakReference<k.b> weakReference = IH.get(i);
            if (weakReference != null && weakReference.get() != null && bVar == weakReference.get()) {
                break;
            }
            i2 = i + 1;
        }
        if (i != -1) {
            IH.remove(i);
        }
    }

    private static boolean b(C0349a c0349a) {
        return com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(c0349a.getAdTemplate())) ? !c0349a.mX() && c.s(c0349a) == 3 : d(c0349a) == 1;
    }

    private static boolean c(C0349a c0349a) {
        AdTemplate adTemplate = c0349a.getAdTemplate();
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (!c0349a.mU() || !com.kwad.sdk.core.response.a.a.b(cb, com.kwad.sdk.core.config.d.un()) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.aK(cb)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0349a.hb().nh()) {
            return false;
        }
        d(c0349a.getContext(), adTemplate);
        return true;
    }

    private static int d(C0349a c0349a) {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(c0349a.getAdTemplate());
        if (cb.unDownloadConf.unDownloadRegionConf != null) {
            int db = c0349a.db();
            return db != 2 ? db != 3 ? cb.unDownloadConf.unDownloadRegionConf.actionBarType : cb.unDownloadConf.unDownloadRegionConf.materialJumpType : cb.unDownloadConf.unDownloadRegionConf.describeBarType;
        }
        return 0;
    }

    private static void d(Context context, AdTemplate adTemplate) {
        AdWebViewVideoActivityProxy.launch(context, adTemplate);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(adTemplate.mAdScene != null ? KSLoggerReporter.bv(adTemplate.mAdScene.getAdStyle()) : null, "toVideoH5Web").report();
    }

    private static void e(C0349a c0349a) {
        g(c0349a);
        f(c0349a);
        if (c0349a.mN() != null) {
            c0349a.mN().onAdClicked();
        }
    }

    private static void f(C0349a c0349a) {
        if (c0349a.mS()) {
            com.kwad.sdk.core.report.a.a(c0349a.adTemplate, c0349a.IR, c0349a.ho());
        }
    }

    private static void g(C0349a c0349a) {
        k.b bVar;
        List<WeakReference<k.b>> list = IH;
        if (list == null || list.isEmpty() || c0349a.adTemplate == null) {
            return;
        }
        for (WeakReference<k.b> weakReference : IH) {
            if (weakReference != null && (bVar = weakReference.get()) != null) {
                bVar.z(com.kwad.sdk.core.response.a.d.cl(c0349a.adTemplate));
            }
        }
    }

    private static int h(C0349a c0349a) {
        c hb = c0349a.hb();
        c cVar = hb;
        if (hb == null) {
            cVar = new c(c0349a.adTemplate);
            c0349a.b(cVar);
        }
        int m = cVar.m(c0349a);
        AdTemplate adTemplate = c0349a.getAdTemplate();
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(adTemplate.getBusinessType(), "toDownload").report();
        String ce = com.kwad.sdk.core.response.a.d.ce(c0349a.getAdTemplate());
        boolean isEmpty = TextUtils.isEmpty(ce);
        boolean z = isEmpty;
        if (!isEmpty) {
            z = ce.contains(" ");
        }
        boolean z2 = z;
        if (!z) {
            z2 = ce.startsWith("http");
        }
        if (z2) {
            KSLoggerReporter.ReportClient.RESPONE_MONITOR.buildNormalApmReporter().cC("response_biz_error_convert").aF(adTemplate).J("downloadUrlError", ce).report();
        }
        return m;
    }

    private static void i(C0349a c0349a) {
        AdTemplate adTemplate = c0349a.getAdTemplate();
        Context context = c0349a.getContext();
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (com.kwad.sdk.utils.d.f(context, com.kwad.sdk.core.response.a.a.cu(cb), com.kwad.sdk.core.response.a.a.aq(cb))) {
            com.kwad.sdk.core.report.a.l(adTemplate, 0);
        } else if (!com.kwad.sdk.core.response.a.a.b(cb, com.kwad.sdk.core.config.d.un()) || adTemplate.mAdWebVideoPageShowing) {
            a(context, new AdWebViewActivityProxy.a.C0359a().av(com.kwad.sdk.core.response.a.b.bg(c0349a.getAdTemplate())).L(c0349a.getAdTemplate()).oc());
        } else {
            d(context, adTemplate);
        }
    }
}
