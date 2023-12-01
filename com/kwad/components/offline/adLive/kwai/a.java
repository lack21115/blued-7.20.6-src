package com.kwad.components.offline.adLive.kwai;

import android.content.Context;
import android.util.Log;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.aa;
import com.kwai.sodler.lib.a.f;
import com.kwai.sodler.lib.b.c;
import com.kwai.sodler.lib.c.b;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/adLive/kwai/a.class */
public final class a {
    private static final AtomicBoolean Xk = new AtomicBoolean(false);
    private static final String Xl = aa.format("lib%s.so", "c++_shared");
    private static final String Xm = aa.format("lib%s.so", "kwaiplayer");
    private static final String Xn = aa.format("lib%s.so", "kste");
    private static final String Xo = aa.format("lib%s.so", "hodor");
    private static final String Xp = aa.format("lib%s.so", "aegon");
    private static final AtomicBoolean Xq = new AtomicBoolean(false);

    public static void a(Context context, final SoLoadListener soLoadListener) {
        String str;
        String str2;
        String str3;
        if (Xk.get()) {
            return;
        }
        Xk.set(true);
        HashMap<String, String> hashMap = new HashMap<>();
        if (AbiUtil.isArm64(context)) {
            hashMap.put(Xl, "dcd68cd059cb06a9596ba6839c2e8858");
            hashMap.put(Xm, "f5d9ed20ecd348d291dc742508036c00");
            hashMap.put(Xn, "ebb56fa9c5701350497e281c2446660f");
            hashMap.put(Xo, "d2c9607f3ddbbefe6914f1e94e8c53ff");
            hashMap.put(Xp, "e43929c76e20f091def8fe0579d16adc");
            str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/adLive/3.3.26.1/ks_so-adLiveArm64v8aRelease-3.3.26.1.apk";
            str2 = "adLive-v8a";
            str3 = "310fad205107df839a5026968c232766";
        } else {
            hashMap.put(Xl, "e3fdbf82716c2cb9b666a3880ab94003");
            hashMap.put(Xm, "ec3e4937f3c114dd36ed0cbd10585d22");
            hashMap.put(Xn, "71a9baa45905a6f0e527e5a2e06e8808");
            hashMap.put(Xo, "644a9dacce49b4c3226f5129267c0dad");
            hashMap.put(Xp, "69828b232bd1c06552a81870a5d5e465");
            str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/adLive/3.3.26.1/ks_so-adLiveArmeabiv7aRelease-3.3.26.1.apk";
            str2 = "adLive-v7a";
            str3 = "e0f9628529f23e1928c8d3f61634c8f2";
        }
        b bVar = new b();
        com.kwai.sodler.lib.a.a ar2 = com.kwai.sodler.kwai.a.ar(context, IAdLiveOfflineCompo.PACKAGE_NAME);
        com.kwad.sdk.core.d.b.d("AdLiveSoLoadHelper", "adLiveOfflineCompoPlugin: " + ar2);
        if (ar2 instanceof com.kwai.sodler.lib.kwai.a) {
            bVar.aLc = ((com.kwai.sodler.lib.kwai.a) ar2).Jv();
        }
        bVar.aKU = com.kwad.sdk.core.network.idc.a.wm().ch(str);
        bVar.Ig = true;
        bVar.aKT = str2;
        bVar.version = "3.6";
        bVar.aKZ = hashMap;
        bVar.aKW = str3;
        bVar.aKX = true;
        com.kwai.sodler.kwai.a.a(context, bVar, new b.c() { // from class: com.kwad.components.offline.adLive.kwai.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0595b, com.kwai.sodler.lib.ext.b
            public void a(c cVar) {
                super.a((AnonymousClass1) cVar);
            }

            private void a(PluginError pluginError) {
                SoLoadListener.this.onFailed(pluginError.getCode(), pluginError);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0595b, com.kwai.sodler.lib.ext.b
            /* renamed from: b */
            public void c(c cVar) {
                super.c((AnonymousClass1) cVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0595b, com.kwai.sodler.lib.ext.b
            /* renamed from: c */
            public void b(c cVar) {
                String str4;
                super.b((AnonymousClass1) cVar);
                if (cVar.getState() == 1) {
                    com.kwad.sdk.core.d.b.d("AdLiveSoLoadHelper", "onPostUpdate UPD_SUCCESS");
                    return;
                }
                if (cVar.JC() != null) {
                    Throwable JC = cVar.JC();
                    if (JC instanceof PluginError) {
                        str4 = String.valueOf(((PluginError) JC).getCode());
                        Log.e("AdLiveSoLoadHelper", "onPostUpdate error: " + str4, cVar.JC());
                    }
                }
                str4 = "other";
                Log.e("AdLiveSoLoadHelper", "onPostUpdate error: " + str4, cVar.JC());
            }

            private void rN() {
                SoLoadListener.this.onLoaded();
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
}
