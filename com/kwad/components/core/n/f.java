package com.kwad.components.core.n;

import android.content.Context;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.x;
import com.kwad.sdk.utils.y;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/n/f.class */
public final class f {
    private static volatile boolean On = false;
    private static volatile boolean Oo = false;
    private static Context Op;
    private static final List<a> Oq = new CopyOnWriteArrayList();

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/n/f$a.class */
    public interface a {
        void a(SdkConfigData sdkConfigData);

        void nP();
    }

    public static void a(Context context, a aVar) {
        synchronized (f.class) {
            try {
                if (On) {
                    com.kwad.sdk.core.d.b.d("ConfigRequestManager", "config request manager has init-ed");
                    return;
                }
                On = true;
                Op = context;
                Oq.add(aVar);
                Oq.add(new a() { // from class: com.kwad.components.core.n.f.1
                    @Override // com.kwad.components.core.n.f.a
                    public final void a(SdkConfigData sdkConfigData) {
                    }

                    @Override // com.kwad.components.core.n.f.a
                    public final void nP() {
                        try {
                            Map<String, String> parseJSON2MapString = u.parseJSON2MapString(com.kwad.sdk.core.config.c.adN.getValue());
                            for (String str : parseJSON2MapString.keySet()) {
                                GlobalThreadPools.m(str, Integer.parseInt(parseJSON2MapString.get(str)));
                            }
                            GlobalThreadPools.xK();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTrace(th);
                        }
                    }
                });
                com.kwad.sdk.utils.g.execute(new aw() { // from class: com.kwad.components.core.n.f.2
                    @Override // com.kwad.sdk.utils.aw
                    public final void doTask() {
                        y.j(f.Op, y.bR(f.Op) + 1);
                        com.kwad.sdk.core.config.d.aH(f.Op);
                        for (a aVar2 : f.Oq) {
                            if (aVar2 != null) {
                                aVar2.nP();
                            }
                        }
                        f.pg();
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(a aVar) {
        Oq.add(aVar);
        if (isLoaded()) {
            aVar.nP();
        }
        if (Oo) {
            aVar.a(com.kwad.sdk.core.config.d.uu());
        }
    }

    static /* synthetic */ boolean aF(boolean z) {
        Oo = true;
        return true;
    }

    private static boolean isLoaded() {
        return com.kwad.sdk.core.config.d.isLoaded();
    }

    public static void pg() {
        com.kwad.sdk.core.d.b.d("ConfigRequestManager", "load()");
        new m<e, SdkConfigData>() { // from class: com.kwad.components.core.n.f.3
            private static SdkConfigData ay(String str) {
                y.ac(f.Op, str);
                JSONObject jSONObject = new JSONObject(str);
                SdkConfigData sdkConfigData = new SdkConfigData();
                sdkConfigData.parseJson(jSONObject);
                try {
                    com.kwad.sdk.core.config.d.sv();
                    com.kwad.sdk.core.config.d.tZ();
                    return sdkConfigData;
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                    return sdkConfigData;
                }
            }

            private static e pi() {
                return new e();
            }

            @Override // com.kwad.sdk.core.network.a
            public final /* synthetic */ com.kwad.sdk.core.network.g createRequest() {
                return pi();
            }

            @Override // com.kwad.sdk.core.network.m
            public final /* synthetic */ SdkConfigData parseData(String str) {
                return ay(str);
            }
        }.request(new p<e, SdkConfigData>() { // from class: com.kwad.components.core.n.f.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onStartRequest(e eVar) {
                com.kwad.sdk.core.d.b.d("ConfigRequestManager", "onStartRequest request url = " + eVar.getUrl());
                super.onStartRequest(eVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(e eVar, int i, String str) {
                super.onError(eVar, i, str);
                com.kwad.sdk.core.d.b.d("ConfigRequestManager", "onError errorCode=" + i + " errorMsg=" + str);
            }

            private static void b(SdkConfigData sdkConfigData) {
                com.kwad.sdk.core.config.b.aF(f.Op);
                com.kwad.sdk.core.config.d.c(sdkConfigData);
                f.aF(true);
                for (a aVar : f.Oq) {
                    if (aVar != null) {
                        aVar.a(sdkConfigData);
                    }
                }
                if (sdkConfigData != null) {
                    com.kwad.sdk.ip.direct.a.a(sdkConfigData.httpDnsInfo);
                }
                x.Dl();
                x.Df();
                y.j(f.Op, 0);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.g gVar, BaseResultData baseResultData) {
                b((SdkConfigData) baseResultData);
            }
        });
    }
}
