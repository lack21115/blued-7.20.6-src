package com.getui.gtc.f;

import android.text.TextUtils;
import com.getui.gtc.BuildConfig;
import com.getui.gtc.api.SdkInfo;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.f.c;
import com.getui.gtc.server.ServerManager;
import java.io.IOException;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/f/b.class */
public final class b {

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/f/b$a.class */
    public interface a {
        void a(Map<String, String> map);
    }

    public static Map<String, String> a(SdkInfo sdkInfo, final a aVar) {
        return com.getui.gtc.f.a.a(GtcProvider.context(), new c.a().a(TextUtils.isEmpty(sdkInfo.getPsUrl()) ? String.format("%s/api.php?format=json&t=1", ServerManager.getServer("gtc.cs")) : sdkInfo.getPsUrl()).b(sdkInfo.getModuleName()).d(sdkInfo.getCid()).e(sdkInfo.getVersion()).c(sdkInfo.getAppid()).a().a(new d() { // from class: com.getui.gtc.f.b.2
            @Override // com.getui.gtc.f.d
            public final void a(Exception exc) {
            }

            @Override // com.getui.gtc.f.d
            public final void a(String str) {
                com.getui.gtc.i.c.a.b("sdk config failed: ".concat(String.valueOf(str)));
            }

            @Override // com.getui.gtc.f.d
            public final void a(Map<String, String> map, Map<String, String> map2) {
                a aVar2;
                if (map != null || map2 == null || (aVar2 = a.this) == null) {
                    return;
                }
                aVar2.a(map2);
            }
        }).b());
    }

    public static Map<String, String> a(final d dVar) {
        final String server = ServerManager.getServer("gtc.cs");
        return com.getui.gtc.f.a.a(GtcProvider.context(), new c.a().b("GTC").a(String.format("%s/api.php?format=json&t=1", server)).c(com.getui.gtc.c.b.f8313a).d(com.getui.gtc.c.b.d).e(BuildConfig.VERSION_NAME).a().a(new d() { // from class: com.getui.gtc.f.b.1
            @Override // com.getui.gtc.f.d
            public final void a(Exception exc) {
                if ((exc.getCause() instanceof IOException) && ServerManager.switchServer("gtc.cs", server)) {
                    com.getui.gtc.i.c.a.b("gtc config failed with server: " + server + ", try again with: " + ServerManager.getServer("gtc.cs"));
                    b.a(dVar);
                }
            }

            @Override // com.getui.gtc.f.d
            public final void a(String str) {
                com.getui.gtc.i.c.a.b("gtc config failed: ".concat(String.valueOf(str)));
                d dVar2 = dVar;
                if (dVar2 != null) {
                    dVar2.a(str);
                }
            }

            @Override // com.getui.gtc.f.d
            public final void a(Map<String, String> map, Map<String, String> map2) {
                ServerManager.confirmServer("gtc.cs", server);
                d dVar2 = dVar;
                if (dVar2 != null) {
                    dVar2.a(map, map2);
                }
            }
        }).b());
    }
}
