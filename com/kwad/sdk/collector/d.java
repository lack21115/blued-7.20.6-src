package com.kwad.sdk.collector;

import android.content.Context;
import android.util.Log;
import com.kwad.sdk.utils.AbiUtil;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/collector/d.class */
public final class d {
    private static final AtomicBoolean ISLOADED = new AtomicBoolean(false);

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/collector/d$a.class */
    public interface a {
        void bo(String str);

        void onLoaded();
    }

    public static void a(Context context, final a aVar) {
        String str;
        String str2;
        String str3;
        if (ISLOADED.get()) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (AbiUtil.isArm64(context)) {
            hashMap.put("libkwappstatus.so", "40eb0d1d346cab7ced4d02a3065b7a94");
            str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-appStatusArm64v8aRelease-3.3.14.apk";
            str2 = "kwappstatus-v8a";
            str3 = "c66bf3f78bd997bbd5b6e5038a23dff6";
        } else {
            hashMap.put("libkwappstatus.so", "b60d5c17b0cc4aa03e8180bc5cedaf3d");
            str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-appStatusArmeabiv7aRelease-3.3.14.apk";
            str2 = "kwappstatus-v7a";
            str3 = "b9c0eff152a62bd5062844255107f3e0";
        }
        com.kwai.sodler.lib.c.b bVar = new com.kwai.sodler.lib.c.b();
        bVar.aKU = com.kwad.sdk.core.network.idc.a.wm().ch(str);
        bVar.Ig = true;
        bVar.aKT = str2;
        bVar.version = "3";
        bVar.aKX = false;
        bVar.aKW = str3;
        bVar.aKZ = hashMap;
        com.kwai.sodler.kwai.a.a(context, bVar, new b.c() { // from class: com.kwad.sdk.collector.d.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0425b, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.b.c cVar) {
                super.a((AnonymousClass1) cVar);
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.bo("load canceled");
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0425b, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.b.c cVar, PluginError pluginError) {
                super.a((AnonymousClass1) cVar, pluginError);
                if (a.this != null) {
                    a.this.bo(pluginError == null ? "load error" : pluginError.toString());
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0425b, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.b.c cVar, com.kwai.sodler.lib.h hVar) {
                super.a((AnonymousClass1) cVar, (com.kwai.sodler.lib.b.c) hVar);
                d.a(a.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(a aVar) {
        try {
            System.loadLibrary("kwappstatus");
            ISLOADED.set(true);
            if (aVar != null) {
                aVar.onLoaded();
            }
        } catch (Throwable th) {
            if (aVar != null) {
                aVar.bo(Log.getStackTraceString(th));
            }
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            if (th instanceof UnsatisfiedLinkError) {
                return;
            }
            com.kwad.sdk.service.b.gatherException(th);
        }
    }

    public static boolean tF() {
        return ISLOADED.get();
    }
}
