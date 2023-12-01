package com.kwad.sdk.core.report;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.bj;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import com.kwai.adclient.kscommerciallogger.model.c;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/KSLoggerReporter.class */
public final class KSLoggerReporter {
    private static float ais = -1.0f;
    private static double ait = -1.0d;
    private static boolean aiu;
    private static volatile boolean aiv;
    private static List<com.kwai.adclient.kscommerciallogger.model.c> aiw;
    private static a aix;
    private static final AtomicBoolean sHasInit = new AtomicBoolean();

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/KSLoggerReporter$ReportClient.class */
    public enum ReportClient {
        CORE_CONVERT(ILoggerReporter.Category.APM_LOG, "ad_convert_method_call"),
        CONVERT_H5WEB(ILoggerReporter.Category.APM_LOG, "ad_h5convert_method"),
        CONVERT_DPLINK(ILoggerReporter.Category.APM_LOG, "ad_dplink_convert_method"),
        RESPONE_MONITOR(new b.a() { // from class: com.kwad.sdk.core.report.KSLoggerReporter.ReportClient.1
            @Override // com.kwad.sdk.core.report.KSLoggerReporter.b.a
            public final void a(b bVar) {
                bVar.cB(ILoggerReporter.Category.ERROR_LOG).cD("response_biz_error");
            }
        });
        
        private String mCategory;
        private String mEventId;
        private b.a mSubIniter;

        ReportClient(b.a aVar) {
            this.mSubIniter = aVar;
        }

        ReportClient(String str, String str2) {
            this.mCategory = str;
            this.mEventId = str2;
        }

        public final b buildMethodCheck(BusinessType businessType, String str) {
            return new b(this.mCategory, this.mEventId, businessType).b("method_name", str);
        }

        public final b buildNormalApmReporter() {
            return new b(this.mSubIniter);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/KSLoggerReporter$a.class */
    public interface a {
        void f(String str, String str2, boolean z);

        boolean sn();

        JSONObject so();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/KSLoggerReporter$b.class */
    public static final class b {
        private BusinessType aiA;
        private a aiB;
        private JSONObject aiz = new JSONObject();
        private String mCategory;
        private String mEventId;
        private String mTag;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/KSLoggerReporter$b$a.class */
        public interface a {
            void a(b bVar);
        }

        b(a aVar) {
            this.aiB = aVar;
        }

        b(String str, String str2, BusinessType businessType) {
            this.aiA = businessType;
            this.mCategory = str;
            this.mEventId = str2;
        }

        public final b J(String str, String str2) {
            b("error_name", str);
            b("error_data", str2);
            return this;
        }

        public final b a(BusinessType businessType) {
            this.aiA = businessType;
            return this;
        }

        public final b aF(AdTemplate adTemplate) {
            long cl = com.kwad.sdk.core.response.a.d.cl(adTemplate);
            long bY = com.kwad.sdk.core.response.a.d.bY(adTemplate);
            if (adTemplate.mAdScene != null) {
                this.aiA = KSLoggerReporter.bv(adTemplate.mAdScene.getAdStyle());
            }
            b(com.anythink.expressad.foundation.d.c.l, Long.valueOf(cl));
            b("llsid", Long.valueOf(bY));
            return this;
        }

        public final b aW(boolean z) {
            return b("is_api_native", Boolean.TRUE);
        }

        public final b b(String str, Object obj) {
            com.kwad.sdk.utils.u.a(this.aiz, str, obj);
            return this;
        }

        public final b bw(int i) {
            return b(com.anythink.expressad.a.g, Integer.valueOf(i));
        }

        public final b cB(String str) {
            this.mCategory = str;
            return this;
        }

        public final b cC(String str) {
            this.mEventId = str;
            return this;
        }

        public final b cD(String str) {
            this.mTag = str;
            return this;
        }

        public final void report() {
            try {
                if (this.aiB != null) {
                    this.aiB.a(this);
                }
                KSLoggerReporter.a(new o.a().cE(this.mCategory).b(this.aiA).cG(this.mTag).a(SubBusinessType.OTHER).a(com.kwai.adclient.kscommerciallogger.model.a.aEg).cF(this.mEventId).A(this.aiz).xa());
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTrace(e);
            }
        }
    }

    private static e a(String str, String str2, JSONObject jSONObject, String str3) {
        e eVar = new e();
        try {
            if (jSONObject.has("ratio")) {
                eVar.aii = jSONObject.getDouble("ratio");
                return eVar;
            } else if (jSONObject.has("ratio_count") && jSONObject.getDouble("ratio_count") > 0.0d) {
                eVar.aii = 1.0d / jSONObject.getDouble("ratio_count");
                return eVar;
            } else {
                JSONObject so = aix.so();
                if (so == null) {
                    if (com.kwad.b.kwai.a.bI.booleanValue()) {
                        throw new Exception("reportConf未初始化 eventId:" + str2);
                    }
                    return eVar;
                }
                JSONObject optJSONObject = so.optJSONObject(cA(str2));
                if (optJSONObject != null) {
                    eVar.a(str, optJSONObject, str3);
                    return eVar;
                } else if (com.kwad.b.kwai.a.bI.booleanValue()) {
                    throw new Exception("EventSamplingKey未包含 eventId " + str2);
                } else {
                    return eVar;
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return eVar;
        }
    }

    private static String a(String str, e eVar) {
        String str2 = str;
        if (str.equals(ILoggerReporter.Category.APM_LOG)) {
            str2 = str;
            if (ait < eVar.aij) {
                str2 = ILoggerReporter.Category.ERROR_LOG;
            }
        }
        return str2;
    }

    private static JSONObject a(JSONObject jSONObject, e eVar) {
        try {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ratio", eVar.aii);
            if (eVar.aii > 0.0d) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "ratio_count", 1.0d / eVar.aii);
            }
            com.kwad.sdk.utils.t.putValue(jSONObject, "debug_mode", com.kwad.b.kwai.a.bI.booleanValue() ? 1 : 0);
            com.kwad.sdk.utils.t.putValue(jSONObject, "convert_ratio", eVar.aij);
            if (eVar.aij > 0.0d) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "convert_ratio_count", 1.0d / eVar.aij);
            }
            return jSONObject;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            return jSONObject;
        }
    }

    public static void a(final a aVar) {
        synchronized (KSLoggerReporter.class) {
            try {
                if (aiu) {
                    return;
                }
                aiu = true;
                aix = aVar;
                com.kwad.sdk.utils.g.execute(new aw() { // from class: com.kwad.sdk.core.report.KSLoggerReporter.1
                    @Override // com.kwad.sdk.utils.aw
                    public final void doTask() {
                        KSLoggerReporter.b(a.this);
                        KSLoggerReporter.sHasInit.set(true);
                        KSLoggerReporter.mt();
                    }
                });
            } finally {
            }
        }
    }

    public static void a(l lVar, String str) {
        a(new o.a().cE(ILoggerReporter.Category.ERROR_LOG).cF("ad_union_error_log").cG(str).A(lVar.toJson()).xa());
    }

    public static void a(o oVar) {
        synchronized (KSLoggerReporter.class) {
            try {
                if (TextUtils.isEmpty(oVar.tag)) {
                    oVar.tag = oVar.eventId;
                }
                a(oVar.category, oVar.biz, oVar.aiC, oVar.aiD, oVar.eventId, oVar.tag, oVar.suffixRatio, oVar.msg);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void a(com.kwai.adclient.kscommerciallogger.model.c cVar) {
        synchronized (KSLoggerReporter.class) {
            try {
                if (aiw == null) {
                    aiw = new CopyOnWriteArrayList();
                }
                aiw.add(cVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(String str, HybridLoadMsg hybridLoadMsg) {
        a(str, BusinessType.WEB_CACHE, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.aEG, "union_web_cache_download_event", hybridLoadMsg.toJson());
    }

    public static void a(String str, WebViewCommercialMsg webViewCommercialMsg) {
        if (webViewCommercialMsg.rate >= 0.0d) {
            com.kwad.sdk.utils.t.putValue(webViewCommercialMsg.msg, "ratio", webViewCommercialMsg.rate);
        }
        a(str, webViewCommercialMsg.biz, webViewCommercialMsg.subBiz, webViewCommercialMsg.type, webViewCommercialMsg.eventId, webViewCommercialMsg.suffixRatio, webViewCommercialMsg.msg);
    }

    public static void a(String str, WebViewLoadMsg webViewLoadMsg) {
        a(str, BusinessType.OTHER, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.aEG, "union_webview_load_event", webViewLoadMsg.toJson());
    }

    @Deprecated
    private static void a(String str, BusinessType businessType, SubBusinessType subBusinessType, com.kwai.adclient.kscommerciallogger.model.d dVar, String str2, String str3, String str4, JSONObject jSONObject) {
        synchronized (KSLoggerReporter.class) {
            try {
                e a2 = a(str, str2, jSONObject, str4);
                if (ais == -1.0f) {
                    ais = new Random().nextFloat();
                }
                if (ait == -1.0d) {
                    ait = new Random().nextFloat();
                }
                if (ais > a2.aii) {
                    return;
                }
                if (bj.aj("3.3.40", a2.aik)) {
                    com.kwai.adclient.kscommerciallogger.model.c Ge = (ILoggerReporter.Category.ERROR_LOG.equals(a(str, a2)) ? c.a.Gc() : c.a.Gd()).c(businessType).b(subBusinessType).ff(str3).b(dVar).fg(str2).P(a(jSONObject, a2)).Ge();
                    if (sHasInit.get()) {
                        b(Ge);
                    } else {
                        a(Ge);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    private static void a(String str, BusinessType businessType, SubBusinessType subBusinessType, com.kwai.adclient.kscommerciallogger.model.d dVar, String str2, String str3, JSONObject jSONObject) {
        synchronized (KSLoggerReporter.class) {
            try {
                a(str, businessType, subBusinessType, dVar, str2, str2, str3, jSONObject);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public static void a(String str, BusinessType businessType, SubBusinessType subBusinessType, com.kwai.adclient.kscommerciallogger.model.d dVar, String str2, JSONObject jSONObject) {
        synchronized (KSLoggerReporter.class) {
            try {
                a(str, businessType, subBusinessType, dVar, str2, "", jSONObject);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(String str, com.kwai.adclient.kscommerciallogger.model.d dVar, JSONObject jSONObject) {
        a(str, BusinessType.AD_SDK_INIT, SubBusinessType.OTHER, dVar, ILoggerReporter.Category.ERROR_LOG.equals(str) ? "ad_sdk_init_error_performance" : "ad_sdk_init_performance", jSONObject);
    }

    public static void a(boolean z, JSONObject jSONObject) {
        a(ILoggerReporter.Category.ERROR_LOG, z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.b.aEt, z ? "ad_sdk_reward_download_error" : "ad_sdk_fullscreen_download_error", jSONObject);
    }

    public static void a(boolean z, JSONObject jSONObject, com.kwai.adclient.kscommerciallogger.model.d dVar) {
        a(ILoggerReporter.Category.APM_LOG, z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN, SubBusinessType.OTHER, dVar, z ? "ad_sdk_reward_load" : "ad_sdk_fullscreen_load", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final a aVar) {
        boolean sn = aVar.sn();
        aiv = sn;
        if (sn) {
            com.kwai.adclient.kscommerciallogger.a.FS().a(new com.kwai.adclient.kscommerciallogger.kwai.a() { // from class: com.kwad.sdk.core.report.KSLoggerReporter.2
                @Override // com.kwai.adclient.kscommerciallogger.kwai.a
                public final void F(String str, String str2) {
                    com.kwad.sdk.core.d.b.w(str, str2);
                }

                @Override // com.kwai.adclient.kscommerciallogger.kwai.a
                public final void G(String str, String str2) {
                    com.kwad.sdk.core.d.b.e(str, str2);
                }
            }, new com.kwai.adclient.kscommerciallogger.kwai.b() { // from class: com.kwad.sdk.core.report.KSLoggerReporter.3
                private void I(String str, String str2) {
                    a.this.f(str, str2, false);
                }

                @Override // com.kwai.adclient.kscommerciallogger.kwai.b
                public final void H(String str, String str2) {
                    I(str, str2);
                }
            }, null, com.kwad.b.kwai.a.bI.booleanValue(), com.kwad.b.kwai.a.bI.booleanValue());
        }
    }

    public static void b(com.kwad.sdk.utils.a.a aVar) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.OTHER, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.aEG, "ad_union_kv_fail_rate", aVar.toJson());
    }

    private static void b(com.kwai.adclient.kscommerciallogger.model.c cVar) {
        if (aiv) {
            com.kwai.adclient.kscommerciallogger.a.FS().c(cVar);
        }
    }

    public static void b(String str, HybridLoadMsg hybridLoadMsg) {
        a(str, BusinessType.WEB_CACHE, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.aEG, "union_web_cache_load_event", hybridLoadMsg.toJson());
    }

    public static void b(boolean z, JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.a.aDW, z ? "ad_sdk_reward_page_show" : "ad_sdk_fullscreen_page_show", jSONObject);
    }

    public static BusinessType bv(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 13) {
                            if (i != 10000) {
                                return null;
                            }
                            return BusinessType.AD_NATIVE;
                        }
                        return BusinessType.AD_INTERSTITIAL;
                    }
                    return BusinessType.AD_SPLASH;
                }
                return BusinessType.AD_FULLSCREEN;
            }
            return BusinessType.AD_REWARD;
        }
        return BusinessType.AD_FEED;
    }

    public static void c(com.kwad.sdk.core.network.j jVar) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.OTHER, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.aEG, "ad_perf_monitor_net_error", jVar.toJson());
    }

    public static void c(com.kwad.sdk.core.network.k kVar) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.OTHER, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.aEG, "ad_perf_monitor_net_success", kVar.toJson());
    }

    public static void c(boolean z, JSONObject jSONObject) {
        a(ILoggerReporter.Category.ERROR_LOG, z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.b.aEz, z ? "ad_sdk_reward_play_error" : "ad_sdk_fullscreen_play_error", jSONObject);
    }

    private static String cA(String str) {
        String str2;
        try {
            String[] split = str.split("_");
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            for (String str3 : split) {
                if (z) {
                    str2 = Character.toUpperCase(str3.charAt(0)) + str3.substring(1);
                } else {
                    str2 = Character.toLowerCase(str3.charAt(0)) + str3.substring(1);
                    z = true;
                }
                sb.append(str2);
            }
            sb.append("ReportRate");
            return new String(sb);
        } catch (Throwable th) {
            return "";
        }
    }

    public static void i(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_REWARD, SubBusinessType.OTHER, new com.kwai.adclient.kscommerciallogger.model.b("RESULT_CHECK_REWARD"), "ad_sdk_reward_check_result", jSONObject);
    }

    public static void j(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_WEBVIEW, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.a.aEg, "ad_sdk_webview_track", jSONObject);
    }

    public static void k(JSONObject jSONObject) {
        a(ILoggerReporter.Category.ERROR_LOG, BusinessType.AD_REWARD, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.b.aEG, "ad_sdk_reward_performance", jSONObject);
    }

    public static void l(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.a.aEg, "ad_sdk_splash_load", jSONObject);
    }

    public static void m(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.a.aEg, "ad_sdk_splash_preload", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mt() {
        synchronized (KSLoggerReporter.class) {
            try {
                if (aiw == null) {
                    return;
                }
                for (com.kwai.adclient.kscommerciallogger.model.c cVar : aiw) {
                    b(cVar);
                }
                aiw.clear();
                aiw = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void n(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.a.aEf, "ad_sdk_splash_single_cache", jSONObject);
    }

    public static void o(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.a.aEf, "ad_sdk_splash_cache", jSONObject);
    }

    public static void p(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.a.aEg, "ad_sdk_splash_show", jSONObject);
    }

    public static void q(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("load_status");
        a(new o.a().cE((optInt == 3 || optInt == 4 || optInt == 7) ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).b(BusinessType.OTHER).a(SubBusinessType.OTHER).a(com.kwai.adclient.kscommerciallogger.model.a.aEg).cF("ad_sdk_dynamic_update").A(jSONObject).xa());
    }

    public static void r(JSONObject jSONObject) {
        a(new o.a().cE(ILoggerReporter.Category.ERROR_LOG).b(BusinessType.OTHER).a(SubBusinessType.OTHER).a(com.kwai.adclient.kscommerciallogger.model.a.aEg).cF("ad_sdk_dynamic_run").A(jSONObject).xa());
    }

    public static void s(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_INTERSTITIAL, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.a.aEg, "ad_sdk_interstitial_load", jSONObject);
    }

    public static void t(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_INTERSTITIAL, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.b.aEt, "ad_sdk_interstitial_download_error", "1", jSONObject);
    }

    public static void u(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_INTERSTITIAL, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.b.aEt, "ad_sdk_interstitial_download_error", jSONObject);
    }

    public static void v(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_INTERSTITIAL, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.b.aEz, "ad_sdk_interstitial_play_error", "1", jSONObject);
    }

    public static void w(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_INTERSTITIAL, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.b.aEz, "ad_sdk_interstitial_play_error", jSONObject);
    }

    public static void x(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.OTHER, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.aEG, "ad_sdk_block_info", jSONObject);
    }

    public static void y(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.OTHER, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.aEG, "ad_image_load_perf", jSONObject);
    }

    public static void z(JSONObject jSONObject) {
        a(new o.a().cE(ILoggerReporter.Category.APM_LOG).b(BusinessType.OTHER).cG("ad_thread_monitor").a(com.kwai.adclient.kscommerciallogger.model.d.aEG).cF("ad_thread_monitor").A(jSONObject).xa());
    }
}
