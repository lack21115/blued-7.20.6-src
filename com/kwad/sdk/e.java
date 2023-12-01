package com.kwad.sdk;

import android.content.Context;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.core.config.item.n;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.v;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.h;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/e.class */
public final class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/e$a.class */
    public static final class a implements com.kwad.sdk.service.kwai.a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.kwad.sdk.service.kwai.a
        public final int g(Context context, String str) {
            return com.kwad.components.core.d.b.d.g(context, str);
        }

        @Override // com.kwad.sdk.service.kwai.a
        public final void h(Context context, AdTemplate adTemplate) {
            com.kwad.components.core.d.b.a.a(new a.C0519a(context).I(adTemplate).aq(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/e$b.class */
    public static final class b implements com.kwad.sdk.core.download.b {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.download.b
        public final void b(int i, AdTemplate adTemplate) {
            if (i != 1) {
                return;
            }
            com.kwad.sdk.core.report.a.e(adTemplate, (JSONObject) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/e$c.class */
    public static final class c implements com.kwad.sdk.service.kwai.e {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final boolean X(AdTemplate adTemplate) {
            com.kwad.components.kwai.kwai.a aVar = (com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
            return aVar != null && aVar.rJ();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final String getApiVersion() {
            return KsAdSDKImpl.get().getApiVersion();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final int getApiVersionCode() {
            return KsAdSDKImpl.get().getApiVersionCode();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final String getAppId() {
            return KsAdSDKImpl.get().getAppId();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final String getAppName() {
            return KsAdSDKImpl.get().getAppName();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final Context getContext() {
            return KsAdSDKImpl.get().getContext();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final boolean getIsExternal() {
            return KsAdSDKImpl.get().getIsExternal();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final String getSDKVersion() {
            return KsAdSDKImpl.get().getSDKVersion();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final boolean hasInitFinish() {
            return KsAdSDKImpl.get().hasInitFinish();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final boolean hasLiveCompoReady() {
            com.kwad.components.core.offline.api.kwai.a aVar = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
            if (aVar != null) {
                return aVar.hasLiveCompoReady();
            }
            return false;
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final boolean isPersonalRecommend() {
            return KsAdSDKImpl.get().isPersonalRecommend();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final boolean isProgrammaticRecommend() {
            return KsAdSDKImpl.get().isProgrammaticRecommend();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final com.kwad.sdk.core.response.a.e rK() {
            com.kwad.components.kwai.kwai.a aVar = (com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
            if (aVar != null) {
                return aVar.rK();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/e$d.class */
    public static final class d implements com.kwad.sdk.service.kwai.f {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean E(long j) {
            return com.kwad.sdk.core.config.d.E(j);
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean aY(String str) {
            return com.kwad.sdk.core.config.a.aY(str);
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final int al(Context context) {
            return com.kwad.sdk.core.config.item.c.aI(context);
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String getAppId() {
            return KsAdSDKImpl.get().getAppId();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String getUserAgent() {
            return com.kwad.sdk.core.config.d.getUserAgent();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sA() {
            return com.kwad.sdk.core.config.d.sA();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String sB() {
            return com.kwad.sdk.core.config.d.sB();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String sC() {
            return com.kwad.sdk.core.config.d.sC();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final List<String> sD() {
            return com.kwad.sdk.core.config.d.sD();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sE() {
            return com.kwad.sdk.core.config.d.sE();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sF() {
            return com.kwad.sdk.core.config.d.sF();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sG() {
            return com.kwad.sdk.core.config.d.uz();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sH() {
            return com.kwad.sdk.core.config.d.sH();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sI() {
            return com.kwad.sdk.core.config.d.sI();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final int sJ() {
            return com.kwad.sdk.core.config.d.sJ();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final int sK() {
            return com.kwad.sdk.core.config.d.sK();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sL() {
            return com.kwad.sdk.core.config.d.sL();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final double sM() {
            return com.kwad.sdk.core.config.d.sM();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sN() {
            return com.kwad.sdk.core.config.d.sN();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sO() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.adP);
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sP() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.adQ);
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sx() {
            return com.kwad.sdk.core.config.d.sx();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sy() {
            return com.kwad.sdk.core.config.d.sy();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sz() {
            return com.kwad.sdk.core.config.d.sz();
        }
    }

    public static void sr() {
        ServiceProvider.put(com.kwad.sdk.service.kwai.e.class, new c((byte) 0));
        ServiceProvider.put(com.kwad.sdk.service.kwai.f.class, new d((byte) 0));
        ServiceProvider.put(com.kwad.sdk.service.kwai.d.class, new com.kwad.sdk.service.kwai.d() { // from class: com.kwad.sdk.e.1
            @Override // com.kwad.sdk.service.kwai.d
            public final void gatherException(Throwable th) {
                com.kwad.components.core.c.a.b(th);
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.kwai.c.class, new com.kwad.sdk.service.kwai.c() { // from class: com.kwad.sdk.e.2
            @Override // com.kwad.sdk.service.kwai.c
            public final void a(boolean z, String str, String str2, String str3) {
                com.kwad.sdk.core.diskcache.a.a.vs().bI(str);
            }

            @Override // com.kwad.sdk.service.kwai.c
            public final File aX(String str) {
                return com.kwad.sdk.core.diskcache.a.a.vs().aX(str);
            }
        });
        ServiceProvider.put(h.class, new h() { // from class: com.kwad.sdk.e.3
            @Override // com.kwad.sdk.service.kwai.h
            public final boolean pn() {
                com.kwad.components.core.o.b.pm();
                return com.kwad.components.core.o.b.pn();
            }

            @Override // com.kwad.sdk.service.kwai.h
            public final int po() {
                com.kwad.components.core.o.b.pm();
                return com.kwad.components.core.o.b.po();
            }

            @Override // com.kwad.sdk.service.kwai.h
            public final int pp() {
                return com.kwad.components.core.o.b.pm().pp();
            }

            @Override // com.kwad.sdk.service.kwai.h
            public final InputStream wrapInputStream(InputStream inputStream) {
                com.kwad.components.core.o.b.pm();
                return com.kwad.components.core.o.b.wrapInputStream(inputStream);
            }
        });
        ServiceProvider.put(l.class, new l() { // from class: com.kwad.sdk.e.4
            @Override // com.kwad.sdk.core.network.l
            public final void a(j jVar) {
                KSLoggerReporter.c(jVar);
            }

            @Override // com.kwad.sdk.core.network.l
            public final void a(k kVar) {
                KSLoggerReporter.c(kVar);
            }

            @Override // com.kwad.sdk.core.network.l
            public final com.kwad.sdk.core.b ss() {
                return com.kwad.components.core.n.kwai.c.pl();
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.kwai.g.class, ImageLoaderProxy.INSTANCE);
        ServiceProvider.put(com.kwad.sdk.service.kwai.b.class, new com.kwad.sdk.service.kwai.b() { // from class: com.kwad.sdk.e.5
            @Override // com.kwad.sdk.service.kwai.b
            public final void W(AdTemplate adTemplate) {
                com.kwad.components.core.m.a.pb().g(adTemplate, 21007);
            }

            @Override // com.kwad.sdk.service.kwai.b
            public final void e(JSONObject jSONObject, int i) {
                com.kwad.components.core.m.a.pb().e(jSONObject, i);
            }

            @Override // com.kwad.sdk.service.kwai.b
            public final void n(String str, String str2) {
                com.kwad.sdk.core.d.b.e("image_load_failed_info", "errorMsg:" + str2 + "\nurl:" + str);
            }

            @Override // com.kwad.sdk.service.kwai.b
            public final void st() {
                com.kwad.components.core.m.a.pb().ag(ServiceProvider.getContext());
            }
        });
        ServiceProvider.put(v.class, new v() { // from class: com.kwad.sdk.e.6
            @Override // com.kwad.sdk.core.report.v
            public final boolean D(long j) {
                n nVar = com.kwad.sdk.core.config.c.acl;
                return n.D(j);
            }

            @Override // com.kwad.sdk.core.report.v
            public final int rH() {
                com.kwad.components.kwai.kwai.a aVar = (com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
                if (aVar != null) {
                    return aVar.rH();
                }
                return 0;
            }

            @Override // com.kwad.sdk.core.report.v
            public final int su() {
                return com.kwad.sdk.core.config.d.su();
            }
        });
        ServiceProvider.put(com.kwad.sdk.core.download.b.class, new b((byte) 0));
        ServiceProvider.put(com.kwad.sdk.core.video.kwai.f.class, new com.kwad.sdk.core.video.kwai.f() { // from class: com.kwad.sdk.e.7
            @Override // com.kwad.sdk.core.video.kwai.f
            public final boolean rI() {
                return ((com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class)).rI();
            }

            @Override // com.kwad.sdk.core.video.kwai.f
            public final boolean sv() {
                return com.kwad.sdk.core.config.d.sv();
            }

            @Override // com.kwad.sdk.core.video.kwai.f
            public final boolean sw() {
                return com.kwad.sdk.core.config.d.sw();
            }
        });
        ServiceProvider.put(com.kwad.sdk.utils.a.b.class, new com.kwad.sdk.utils.a.b() { // from class: com.kwad.sdk.e.8
            @Override // com.kwad.sdk.utils.a.b
            public final void a(com.kwad.sdk.utils.a.a aVar) {
                if (aVar == null) {
                    return;
                }
                KSLoggerReporter.b(aVar);
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.kwai.a.class, new a((byte) 0));
    }
}
