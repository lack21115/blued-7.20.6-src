package com.kwad.sdk.crash.online.monitor;

import android.text.TextUtils;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.crash.online.monitor.block.d;
import com.kwad.sdk.crash.online.monitor.kwai.c;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/online/monitor/a.class */
public final class a {
    private static volatile boolean hasInit = false;

    static /* synthetic */ boolean access$002(boolean z) {
        hasInit = true;
        return true;
    }

    public static void cL(final String str) {
        g.execute(new aw() { // from class: com.kwad.sdk.crash.online.monitor.a.1
            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                if (a.hasInit) {
                    return;
                }
                b.d("perfMonitor.MonitorManager", "configStr:" + str);
                c dE = a.dE(str);
                b.d("perfMonitor.MonitorManager", dE.toJson().toString());
                d.d(dE.ast);
                a.access$002(true);
            }
        });
    }

    public static c dE(String str) {
        if (TextUtils.isEmpty(str)) {
            return zR();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c cVar = new c();
            cVar.parseJson(jSONObject);
            return cVar;
        } catch (Exception e) {
            b.w("perfMonitor.MonitorManager", e);
            return zR();
        }
    }

    private static c zR() {
        c cVar = new c();
        cVar.ast = new com.kwad.sdk.crash.online.monitor.kwai.a();
        cVar.ast.ask = 5;
        return cVar;
    }
}
