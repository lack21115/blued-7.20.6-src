package com.kwad.components.ad.reward;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/p.class */
public final class p {
    public static void a(int i, int i2, j jVar, com.kwad.components.ad.reward.model.c cVar) {
        if (i == 0) {
            com.kwad.sdk.core.report.a.m(cVar.getAdTemplate(), 1);
        } else if (i == 1) {
            boolean jv = jVar.px.jv();
            if (i2 == 0) {
                if (jv) {
                    com.kwad.sdk.core.report.a.m(cVar.getAdTemplate(), 1);
                }
            } else if (jv) {
                com.kwad.sdk.core.report.a.m(cVar.getAdTemplate(), 5);
            } else {
                com.kwad.sdk.core.report.a.m(cVar.getAdTemplate(), 4);
            }
        } else if (i != 2) {
        } else {
            boolean jv2 = jVar.pw.jv();
            if (i2 == 0) {
                if (jv2) {
                    com.kwad.sdk.core.report.a.m(cVar.getAdTemplate(), 1);
                }
            } else if (jv2) {
                com.kwad.sdk.core.report.a.m(cVar.getAdTemplate(), 3);
            } else {
                com.kwad.sdk.core.report.a.m(cVar.getAdTemplate(), 2);
            }
        }
    }
}
