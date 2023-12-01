package com.kwad.sdk.core.webview.a.a;

import com.kwad.sdk.j.k;
import com.kwai.filedownloader.m;
import com.kwai.filedownloader.r;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/a/a/a.class */
public final class a {

    /* renamed from: com.kwad.sdk.core.webview.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/a/a/a$a.class */
    public interface InterfaceC0568a {
        void c(com.kwad.sdk.f.kwai.b bVar);

        void d(com.kwad.sdk.f.kwai.b bVar);

        void e(com.kwad.sdk.f.kwai.b bVar);
    }

    public static void a(final com.kwad.sdk.f.kwai.b bVar, final InterfaceC0568a interfaceC0568a) {
        com.kwad.sdk.core.d.b.d("HybridDownloader", "reportHybrid: download+++url " + bVar.packageUrl);
        interfaceC0568a.c(bVar);
        bVar.aa(System.currentTimeMillis());
        com.kwad.sdk.core.webview.a.b.b.a(bVar, 1);
        r.ds(k.FP());
        r.Hp();
        r.fm(bVar.packageUrl).k(bVar).fj(bVar.ato).bQ(true).a(new m() { // from class: com.kwad.sdk.core.webview.a.a.a.1
            @Override // com.kwai.filedownloader.m, com.kwai.filedownloader.i
            public final void a(com.kwai.filedownloader.a aVar, Throwable th) {
                super.a(aVar, th);
                com.kwad.sdk.core.webview.a.b.b.a(bVar, 0, 1, th.getMessage());
                InterfaceC0568a.this.e((com.kwad.sdk.f.kwai.b) aVar.getTag());
            }

            @Override // com.kwai.filedownloader.m, com.kwai.filedownloader.i
            public final void c(com.kwai.filedownloader.a aVar) {
                super.c(aVar);
                if (aVar.Gq() == -3) {
                    InterfaceC0568a.this.d(bVar);
                    return;
                }
                InterfaceC0568a.this.e(bVar);
                com.kwad.sdk.f.kwai.b bVar2 = bVar;
                com.kwad.sdk.core.webview.a.b.b.a(bVar2, 0, 1, "task.getStatus()=" + ((int) aVar.Gq()));
            }
        }).start();
    }
}
