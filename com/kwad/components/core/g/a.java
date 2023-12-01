package com.kwad.components.core.g;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.core.n.h;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/g/a.class */
public final class a {
    private static int Jv = 12;
    private static int Jw = 4;
    private static int Jx = 1;

    /* renamed from: com.kwad.components.core.g.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/g/a$a.class */
    public interface InterfaceC0353a {
        void onError(int i, String str);

        void onInnerAdLoad(List<c> list);

        void onRequestResult(int i);
    }

    private static void a(int i, int i2, SceneImpl sceneImpl, final int i3, final InterfaceC0353a interfaceC0353a) {
        SceneImpl m4840clone = sceneImpl.m4840clone();
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        m4840clone.setAdStyle(i);
        m4840clone.setAdNum(i2);
        a(new com.kwad.components.core.n.kwai.b(m4840clone), null, false, true, new h() { // from class: com.kwad.components.core.g.a.1
            @Override // com.kwad.components.core.n.i
            public final void a(final AdResultData adResultData) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.g.a.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            InterfaceC0353a.this.onRequestResult(adResultData.getAdTemplateList().size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                });
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.g.a.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC0353a.this.onInnerAdLoad(a.b(adResultData.getAdTemplateList(), i3));
                        a.a(adResultData, elapsedRealtime);
                    }
                });
            }

            @Override // com.kwad.components.core.n.i
            public final void onError(final int i4, final String str) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.g.a.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.w("RefluxAdLoadManager", "loadInnerAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i4), str));
                        InterfaceC0353a.this.onError(i4, str);
                    }
                });
            }
        }, false);
    }

    private static void a(final com.kwad.components.core.n.kwai.b bVar, List<String> list, boolean z, boolean z2, final h hVar, boolean z3) {
        new com.kwad.components.core.k.a(bVar) { // from class: com.kwad.components.core.g.a.2
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            @Override // com.kwad.components.core.k.a, com.kwad.sdk.core.network.a
            /* renamed from: mc */
            public final com.kwad.components.core.n.a createRequest() {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }
        }.request(new p<com.kwad.components.core.n.a, AdResultData>() { // from class: com.kwad.components.core.g.a.3
            private void b(AdResultData adResultData) {
                if (!adResultData.isAdResultDataEmpty() || r4) {
                    hVar.a(adResultData);
                } else {
                    hVar.onError(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg : adResultData.testErrorMsg);
                }
            }

            private void e(int i, String str) {
                hVar.onError(i, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(g gVar, int i, String str) {
                e(i, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(g gVar, BaseResultData baseResultData) {
                b((AdResultData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdResultData adResultData, long j) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
            return;
        }
        com.kwad.components.core.m.a.pb().c(adTemplate, elapsedRealtime - j);
    }

    public static void a(SceneImpl sceneImpl, InterfaceC0353a interfaceC0353a) {
        a(15, Jw, sceneImpl, e.AGGREGATION, interfaceC0353a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> b(List<AdTemplate> list, int i) {
        ArrayList arrayList = new ArrayList();
        for (AdTemplate adTemplate : list) {
            arrayList.add(new c(adTemplate, i));
        }
        return arrayList;
    }

    public static void b(SceneImpl sceneImpl, InterfaceC0353a interfaceC0353a) {
        a(17, Jx, sceneImpl, e.JH, interfaceC0353a);
    }
}
