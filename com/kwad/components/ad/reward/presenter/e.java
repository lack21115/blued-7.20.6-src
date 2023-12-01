package com.kwad.components.ad.reward.presenter;

import android.content.Context;
import android.os.SystemClock;
import com.kwad.components.ad.reward.k;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/e.class */
public final class e {
    private static long rW;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/e$a.class */
    public interface a {
        void gt();
    }

    private static boolean W(String str) {
        if (!com.kwad.components.ad.reward.kwai.b.gI()) {
            com.kwad.sdk.core.d.b.e(str, "isEnable false");
            return true;
        }
        int gH = com.kwad.components.ad.reward.kwai.b.gH();
        com.kwad.sdk.core.d.b.d(str, "JumpDirectMaxCount " + gH);
        return gH <= 0 || com.kwad.components.ad.reward.e.a.cO() >= gH;
    }

    private static void a(final com.kwad.components.ad.reward.j jVar, final k.b bVar) {
        String str;
        final AdTemplate adTemplate = jVar.mAdTemplate;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        final JSONObject jSONObject = jVar.mReportExtData;
        long U = com.kwad.sdk.core.response.a.a.U(cb);
        if (U <= 0 || com.kwad.sdk.core.response.a.a.F(cb) <= U) {
            str = "观看完整视频即可获取奖励";
        } else {
            str = "观看视频" + U + "s即可获取奖励";
        }
        final k.c a2 = com.kwad.components.ad.reward.k.a(jVar, str);
        com.kwad.components.ad.reward.j.a(jVar, a2, new k.b() { // from class: com.kwad.components.ad.reward.presenter.e.4
            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void J(boolean z) {
                com.kwad.components.ad.reward.j.this.H(false);
                if (!z) {
                    com.kwad.sdk.core.report.a.q(adTemplate, 151);
                }
                k.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.J(z);
                }
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void fZ() {
                com.kwad.components.ad.reward.j.this.oN.pause();
                com.kwad.components.ad.reward.j.this.H(true);
                if (a2.getStyle() == 0) {
                    com.kwad.sdk.core.report.a.j(adTemplate, jSONObject);
                } else {
                    com.kwad.sdk.core.report.a.b(adTemplate, 149, jSONObject);
                }
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.ad.reward.k.a
            public final void g(int i, int i2) {
                super.g(i, i2);
                com.kwad.components.ad.reward.j jVar2 = com.kwad.components.ad.reward.j.this;
                jVar2.a(1, jVar2.mContext, i, i2);
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.ad.reward.k.a
            public final void gf() {
                super.gf();
                com.kwad.sdk.core.report.a.q(adTemplate, 150);
                com.kwad.components.ad.reward.j jVar2 = com.kwad.components.ad.reward.j.this;
                jVar2.a(1, jVar2.mContext, 156, 1);
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void gg() {
                super.gg();
                com.kwad.components.ad.reward.j.this.H(false);
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void gh() {
                com.kwad.components.ad.reward.j.this.H(false);
                com.kwad.components.ad.reward.j.this.oN.resume();
                if (a2.getStyle() == 1 || a2.getStyle() == 2 || a2.getStyle() == 5 || a2.getStyle() == 8) {
                    com.kwad.sdk.core.report.a.q(adTemplate, 150);
                } else {
                    com.kwad.sdk.core.report.a.k(adTemplate, jSONObject);
                }
            }
        });
    }

    public static void a(com.kwad.components.ad.reward.j jVar, a aVar) {
        AdTemplate adTemplate = jVar.mAdTemplate;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (jVar.pf) {
            int fJ = jVar.fJ();
            boolean z = true;
            if (!o(adTemplate) && !p(adTemplate)) {
                if (com.kwad.sdk.core.response.a.b.bF(jVar.mAdTemplate) && jVar.mAdTemplate.mPlayAgain != null && !jVar.fT() && !jVar.fU() && !jVar.fM() && jVar.fX() && fJ == 2) {
                    if (aVar != null) {
                        aVar.gt();
                        return;
                    }
                    return;
                }
                long X = com.kwad.sdk.core.response.a.a.X(cb);
                boolean z2 = true;
                if (!jVar.pC) {
                    z2 = jVar.pB >= X;
                }
                if (z2) {
                    x(jVar);
                }
                w(jVar);
                jVar.hq();
                return;
            }
            q(jVar);
            if (jVar.fX() || !w(jVar.mAdTemplate) || jVar.pk) {
                z = false;
            }
            if (z) {
                v(jVar);
                return;
            }
        }
        w(jVar);
        jVar.hq();
    }

    public static void a(final com.kwad.components.ad.reward.j jVar, boolean z) {
        AdTemplate adTemplate = jVar.mAdTemplate;
        final AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (!jVar.pf) {
            jVar.mAdOpenInteractionListener.onSkippedVideo();
            if (com.kwad.sdk.core.response.a.a.bE(cb)) {
                jVar.release();
                jVar.hq();
                return;
            } else if (jVar.ph) {
                r(jVar);
                return;
            } else {
                com.kwad.sdk.core.report.a.i(adTemplate, jVar.mReportExtData);
                jVar.oN.release();
                jVar.fH();
                u(jVar);
                return;
            }
        }
        q(jVar);
        boolean z2 = !jVar.fX() && w(jVar.mAdTemplate);
        if (o(adTemplate) || p(adTemplate) || jVar.pB < com.kwad.sdk.core.response.a.a.X(cb)) {
            if (z2) {
                a(jVar, new k.b() { // from class: com.kwad.components.ad.reward.presenter.e.1
                    @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
                    public final void J(boolean z3) {
                        super.J(z3);
                        if (com.kwad.components.ad.reward.kwai.b.l(AdInfo.this)) {
                            jVar.hq();
                        } else if (com.kwad.sdk.core.response.a.a.bF(AdInfo.this)) {
                            jVar.release();
                            jVar.hq();
                        } else {
                            e.r(jVar);
                            com.kwad.components.ad.reward.m.m(jVar);
                        }
                    }
                });
            } else if (com.kwad.sdk.core.response.a.a.bF(cb)) {
                jVar.release();
                jVar.hq();
            } else {
                r(jVar);
                com.kwad.components.ad.reward.m.m(jVar);
            }
        } else if (jVar.pv) {
            jVar.hq();
        } else if (!jVar.pC && jVar.pB < com.kwad.sdk.core.response.a.a.X(cb)) {
            if (z) {
                jVar.hq();
            }
        } else {
            if (jVar.pC) {
                jVar.N(2);
            } else {
                jVar.N(1);
            }
            x(jVar);
            if (com.kwad.sdk.core.response.a.a.bF(cb)) {
                jVar.release();
                jVar.hq();
                return;
            }
            r(jVar);
            com.kwad.components.ad.reward.m.m(jVar);
        }
    }

    private static boolean a(String str, AdTemplate adTemplate, AdInfo adInfo) {
        String str2;
        if (com.kwad.sdk.core.response.a.a.bv(adInfo)) {
            str2 = "is playable return";
        } else if (!com.kwad.sdk.core.response.a.a.ax(adInfo)) {
            str2 = "is not Download type";
        } else if (adTemplate.mPlayAgain != null) {
            str2 = "is playAgain return";
        } else if (com.kwad.sdk.core.response.a.d.g(adTemplate, com.kwad.components.ad.reward.kwai.b.l(adInfo))) {
            str2 = "isRewardLaunchAppTask";
        } else if (!com.kwad.components.ad.reward.j.h(adInfo)) {
            return false;
        } else {
            str2 = "is Aggregation return";
        }
        com.kwad.sdk.core.d.b.i(str, str2);
        return true;
    }

    private static boolean o(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.g(adTemplate, com.kwad.components.ad.reward.kwai.b.l(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
    }

    private static boolean p(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.p(adTemplate);
    }

    private static void q(com.kwad.components.ad.reward.j jVar) {
        int i = 0;
        int i2 = jVar.pA != 0 ? (int) (jVar.pA / 1000) : 0;
        if (jVar.pB != 0) {
            i = (int) (jVar.pB / 1000);
        }
        y.b bVar = new y.b();
        bVar.aki = 69;
        bVar.aky = i2;
        bVar.akz = i;
        com.kwad.sdk.core.report.a.b(jVar.mAdTemplate, 141, bVar, jVar.mReportExtData);
    }

    public static void r(final com.kwad.components.ad.reward.j jVar) {
        int i = jVar.pB != 0 ? (int) (jVar.pB / 1000) : 0;
        jVar.pk = true;
        com.kwad.sdk.core.report.a.d(jVar.mAdTemplate, com.kwad.sdk.core.response.a.a.V(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate)), i);
        if (h.y(jVar)) {
            bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.e.2
                @Override // java.lang.Runnable
                public final void run() {
                    e.s(com.kwad.components.ad.reward.j.this);
                }
            }, 200L);
        } else {
            s(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(com.kwad.components.ad.reward.j jVar) {
        jVar.oN.skipToEnd();
    }

    public static void t(com.kwad.components.ad.reward.j jVar) {
        w(jVar);
        jVar.hq();
    }

    public static void u(com.kwad.components.ad.reward.j jVar) {
        com.kwad.sdk.core.d.b.d("openAppMarket", "tryOpenAppMarket");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - rW < 300) {
            com.kwad.sdk.core.d.b.d("openAppMarket", "连续点击");
            return;
        }
        rW = elapsedRealtime;
        if (W("openAppMarket")) {
            return;
        }
        AdTemplate adTemplate = jVar.mAdTemplate;
        Context context = jVar.mContext;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (a("openAppMarket", adTemplate, cb)) {
            return;
        }
        String cu = com.kwad.sdk.core.response.a.a.cu(cb);
        com.kwad.sdk.core.d.b.i("openAppMarket", "tryOpenMiAppStore url：" + cu);
        com.kwad.sdk.core.report.i bs = new com.kwad.sdk.core.report.i().bj(182).bs(8);
        if (com.kwad.sdk.utils.d.a(context, cu, adTemplate)) {
            com.kwad.sdk.core.report.a.a(adTemplate, bs, (JSONObject) null);
            com.kwad.sdk.core.report.a.c(adTemplate, 1, 8);
            com.kwad.components.ad.reward.e.a.J(context);
        } else if (!com.kwad.sdk.utils.d.f(context, cu, com.kwad.sdk.core.response.a.a.aq(cb))) {
            com.kwad.sdk.core.d.b.i("openAppMarket", "tryOpenMiAppStore failed");
        } else {
            com.kwad.sdk.core.report.a.a(adTemplate, bs, (JSONObject) null);
            com.kwad.sdk.core.report.a.c(adTemplate, 0, 8);
            com.kwad.components.ad.reward.e.a.J(context);
        }
    }

    private static void v(final com.kwad.components.ad.reward.j jVar) {
        final AdTemplate adTemplate = jVar.mAdTemplate;
        com.kwad.components.ad.reward.j.a(jVar, com.kwad.components.ad.reward.k.a(jVar, (String) null), new k.b() { // from class: com.kwad.components.ad.reward.presenter.e.3
            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void J(boolean z) {
                com.kwad.components.ad.reward.j.this.H(false);
                if (!z) {
                    com.kwad.sdk.core.report.a.q(adTemplate, 151);
                }
                e.w(com.kwad.components.ad.reward.j.this);
                com.kwad.components.ad.reward.j.this.hq();
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void fZ() {
                com.kwad.components.ad.reward.j.this.H(true);
                com.kwad.sdk.core.report.a.b(adTemplate, 149, com.kwad.components.ad.reward.j.this.mReportExtData);
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void gh() {
                com.kwad.components.ad.reward.j.this.H(false);
                com.kwad.sdk.core.report.a.q(adTemplate, 150);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(com.kwad.components.ad.reward.j jVar) {
        jVar.mAdOpenInteractionListener.h(false);
    }

    private static boolean w(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.a.ab(com.kwad.sdk.core.response.a.d.cb(adTemplate));
    }

    private static void x(com.kwad.components.ad.reward.j jVar) {
        jVar.mAdOpenInteractionListener.onRewardVerify();
    }
}
