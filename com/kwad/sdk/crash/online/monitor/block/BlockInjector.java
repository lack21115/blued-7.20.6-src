package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.ranger.RangerInjector;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/online/monitor/block/BlockInjector.class */
public class BlockInjector {
    private static volatile boolean arU;
    private static volatile boolean arV;

    private static String a(com.kwad.sdk.crash.online.monitor.kwai.b bVar) {
        String str = new String(com.kwad.sdk.core.kwai.c.vJ().decode((bVar == null || TextUtils.isEmpty(bVar.aso)) ? "b25SZXBvcnRJc3N1ZQ==" : bVar.aso));
        com.kwad.sdk.core.d.b.d("perfMonitor.Injector", "report methodName:" + str);
        return str;
    }

    private static String b(com.kwad.sdk.crash.online.monitor.kwai.b bVar) {
        String str = new String(com.kwad.sdk.core.kwai.c.vJ().decode((bVar == null || TextUtils.isEmpty(bVar.asn)) ? "Y29tLnRlbmNlbnQubWF0cml4LnBsdWdpbi5QbHVnaW5MaXN0ZW5lcg==" : bVar.asn));
        com.kwad.sdk.core.d.b.d("perfMonitor.Injector", "ListenerName:" + str);
        return str;
    }

    public static void b(com.kwad.sdk.crash.online.monitor.kwai.a aVar) {
        if (arU) {
            return;
        }
        try {
            com.kwad.sdk.crash.online.monitor.kwai.b c2 = c(aVar);
            RangerInjector.a(b(c2), a(c2), new RangerInjector.b() { // from class: com.kwad.sdk.crash.online.monitor.block.BlockInjector.1
                @Override // com.kwad.sdk.ranger.RangerInjector.b
                public final void a(String str, long j, long j2, String str2, String str3) {
                    e.a(str, j, j2, str2, str3, false);
                }

                @Override // com.kwad.sdk.ranger.RangerInjector.b
                public final void onError(String str) {
                    BlockInjector.onError(str);
                }
            });
            arU = true;
        } catch (Exception e) {
            onError(Log.getStackTraceString(e));
        }
    }

    private static com.kwad.sdk.crash.online.monitor.kwai.b c(com.kwad.sdk.crash.online.monitor.kwai.a aVar) {
        f fVar = (f) ServiceProvider.get(f.class);
        String appId = fVar != null ? fVar.getAppId() : "";
        com.kwad.sdk.crash.online.monitor.kwai.b bVar = null;
        if (!TextUtils.isEmpty(appId)) {
            bVar = aVar.dP(appId);
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onError(String str) {
        e.dO(str);
        com.kwad.sdk.core.d.b.w("perfMonitor.Injector", str);
    }

    public static void tryProxyOtherOutput(com.kwad.sdk.crash.online.monitor.kwai.a aVar) {
        if (arV) {
            return;
        }
        try {
            com.kwad.sdk.crash.online.monitor.kwai.b c2 = c(aVar);
            if (c2 == null) {
                return;
            }
            com.kwad.sdk.core.d.b.d("perfMonitor.Injector", "featureConfig:" + c2.toJson().toString());
            RangerInjector.tryProxyOtherOutput(c2.asp, c2.asq, c2.asr, c2.ass, new RangerInjector.a() { // from class: com.kwad.sdk.crash.online.monitor.block.BlockInjector.2
                @Override // com.kwad.sdk.ranger.RangerInjector.a
                public final void dI(String str) {
                    e.d(str, false);
                }
            });
            arV = true;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.w("perfMonitor.Injector", Log.getStackTraceString(th));
        }
    }
}
