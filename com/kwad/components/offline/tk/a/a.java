package com.kwad.components.offline.tk.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.aa;
import com.kwai.sodler.lib.a.f;
import com.kwai.sodler.lib.b.c;
import com.kwai.sodler.lib.c.b;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/tk/a/a.class */
public final class a {
    private static long XX;
    private static final AtomicBoolean Xk = new AtomicBoolean(false);
    private static final String XR = aa.format("lib%s.so", "tk_runtime_v0_0_38");
    private static final String XS = aa.format("lib%s.so", "tk_runtime_lite_v0_0_38");
    private static final String XT = aa.format("lib%s.so", "kwai-v8");
    private static final String XU = aa.format("lib%s.so", "kwai-v8-lite");
    private static final String XV = aa.format("lib%s.so", "kwad-fb");
    private static final String XW = aa.format("lib%s.so", "kwad-yoga");
    private static final String Xl = aa.format("lib%s.so", "c++_shared");
    private static Boolean XY = null;

    public static void a(Context context, final SoLoadListener soLoadListener) {
        String ud;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        if (Xk.get()) {
            return;
        }
        Xk.set(true);
        HashMap<String, String> hashMap = new HashMap<>();
        boolean useTkLite = useTkLite();
        if (AbiUtil.isArm64(context)) {
            ud = d.ue();
            if (TextUtils.isEmpty(ud)) {
                ud = useTkLite ? "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.34/ks_so-tachikomaLiteSoArm64v8aRelease-3.3.34.apk" : "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.34/ks_so-tachikomaSoArm64v8aRelease-3.3.34.apk";
            }
            str = useTkLite ? "sotk-v8a-lite" : "sotk-v8a";
            str2 = useTkLite ? "39df505f83794e951720e9c753824d0c" : "2c0fb7069df4a3e6fd55e417229bcb6b";
            if (useTkLite) {
                hashMap.put(XS, "a5009e795307441cc05dbd3e8aeaead3");
                str7 = XU;
                str8 = "77545ba1892c1a1d4a039db37b3249eb";
            } else {
                hashMap.put(XR, "e1478b9b4f377d667c7e510e88ae1bcb");
                str7 = XT;
                str8 = "7316cd8d074b04e6cb21486288d314ce";
            }
            hashMap.put(str7, str8);
            hashMap.put(XV, "31f065607e6da6b741330d1df0b35460");
            hashMap.put(XW, "76308532f64b68fd5a930c42cceec22b");
            str5 = Xl;
            str6 = "6ca7958ee0b0192a7c52c16faffaa8ba";
        } else {
            ud = d.ud();
            if (TextUtils.isEmpty(ud)) {
                ud = useTkLite ? "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.34/ks_so-tachikomaLiteSoArmeabiv7aRelease-3.3.34.apk" : "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.34/ks_so-tachikomaSoArmeabiv7aRelease-3.3.34.apk";
            }
            str = useTkLite ? "sotk-v7a-lite" : "sotk-v7a";
            str2 = useTkLite ? "a46a370ee3a1a61a0d6041b3c69c0ab7" : "f8d270613187202ab45cfec0dca9deee";
            if (useTkLite) {
                hashMap.put(XS, "8ffd76abe9e5fe33f4035b56b9d6e8e3");
                str3 = XU;
                str4 = "2dbd72527a0739740746adaae48ed2e0";
            } else {
                hashMap.put(XR, "55e6b8f6cd2091d8f8412dafcf9f381a");
                str3 = XT;
                str4 = "519ba633e88efafb8fbd536d800da734";
            }
            hashMap.put(str3, str4);
            hashMap.put(XV, "eff11bebb8a3c872fa30b0484b460d12");
            hashMap.put(XW, "2c6f402c6a565d2e6912b0013fa59380");
            str5 = Xl;
            str6 = "7cb16c2840085bbdf4be628e6604bac1";
        }
        hashMap.put(str5, str6);
        b bVar = new b();
        bVar.aKU = com.kwad.sdk.core.network.idc.a.wm().ch(ud);
        bVar.Ig = true;
        bVar.aKT = str;
        bVar.version = useTkLite ? "3.3.34-lite" : "3.3.34";
        bVar.aKX = false;
        bVar.aKW = str2;
        bVar.aKZ = hashMap;
        final com.kwai.sodler.lib.a.a ar2 = com.kwai.sodler.kwai.a.ar(context, ITkOfflineCompo.PACKAGE_NAME);
        com.kwad.sdk.core.d.b.d("TkSoLoadHelper", "tkOfflineCompoPlugin: " + ar2);
        if (ar2 instanceof com.kwai.sodler.lib.kwai.a) {
            bVar.aLc = ((com.kwai.sodler.lib.kwai.a) ar2).Jv();
        }
        com.kwai.sodler.kwai.a.a(context, bVar, new b.c() { // from class: com.kwad.components.offline.tk.a.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0595b, com.kwai.sodler.lib.ext.b
            public void a(c cVar) {
                super.a((AnonymousClass1) cVar);
            }

            private void a(PluginError pluginError) {
                soLoadListener.onFailed(pluginError.getCode(), pluginError);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0595b, com.kwai.sodler.lib.ext.b
            /* renamed from: b */
            public void c(c cVar) {
                super.c((AnonymousClass1) cVar);
                soLoadListener.onPreUpdate();
                long unused = a.XX = SystemClock.elapsedRealtime();
                TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(0).setRetryCount(cVar.JF()).toJson());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0595b, com.kwai.sodler.lib.ext.b
            /* renamed from: c */
            public void b(c cVar) {
                String str9;
                super.b((AnonymousClass1) cVar);
                if (cVar.getState() == 1) {
                    TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setRetryCount(cVar.JF()).setDownloadTime(SystemClock.elapsedRealtime() - a.XX).setDownloadState(1).toJson());
                    return;
                }
                if (cVar.JC() != null) {
                    Throwable JC = cVar.JC();
                    if (JC instanceof PluginError) {
                        str9 = String.valueOf(((PluginError) JC).getCode());
                        TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.ERROR_LOG, new TKDownloadMsg().setRetryCount(cVar.JF()).setErrorReason(str9).setDownloadState(2).toJson());
                    }
                }
                str9 = "other";
                TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.ERROR_LOG, new TKDownloadMsg().setRetryCount(cVar.JF()).setErrorReason(str9).setDownloadState(2).toJson());
            }

            private void rN() {
                soLoadListener.onLoaded();
            }

            @Override // com.kwai.sodler.lib.ext.b.C0595b, com.kwai.sodler.lib.ext.b
            public final /* synthetic */ void a(f fVar, com.kwai.sodler.lib.a.a aVar) {
                rN();
            }

            @Override // com.kwai.sodler.lib.ext.b.C0595b, com.kwai.sodler.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(f fVar, PluginError pluginError) {
                a(pluginError);
            }
        });
    }

    public static boolean useTkLite() {
        if (XY == null) {
            XY = Boolean.valueOf(!d.a(com.kwad.sdk.core.config.c.acc));
        }
        return XY.booleanValue();
    }
}
