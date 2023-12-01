package com.opos.cmn.func.dl.base.g;

import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.DownloadResponse;
import com.opos.cmn.func.dl.base.b.c;
import com.opos.cmn.func.dl.base.exception.DlException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/g/b.class */
public class b implements com.opos.cmn.func.dl.base.b {
    private static final String b = b.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public List<com.opos.cmn.func.dl.base.b> f11245a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private Executor f11246c;

    public b(boolean z, c cVar) {
        this.f11246c = z ? cVar.a() : cVar.d();
    }

    @Override // com.opos.cmn.func.dl.base.b
    public void a(final DownloadRequest downloadRequest, final DownloadResponse downloadResponse) {
        String str = b;
        com.opos.cmn.an.f.a.b(str, "onQueued:" + downloadRequest.f11181a);
        this.f11246c.execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.1
            @Override // java.lang.Runnable
            public final void run() {
                for (com.opos.cmn.func.dl.base.b bVar : b.this.f11245a) {
                    bVar.a(downloadRequest, downloadResponse);
                }
            }
        });
    }

    @Override // com.opos.cmn.func.dl.base.b
    public void a(final DownloadRequest downloadRequest, final DownloadResponse downloadResponse, final DlException dlException) {
        String str = b;
        com.opos.cmn.an.f.a.b(str, "onError:" + dlException.toString());
        this.f11246c.execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.7
            @Override // java.lang.Runnable
            public final void run() {
                for (com.opos.cmn.func.dl.base.b bVar : b.this.f11245a) {
                    bVar.a(downloadRequest, downloadResponse, dlException);
                }
            }
        });
    }

    @Override // com.opos.cmn.func.dl.base.b
    public void b(final DownloadRequest downloadRequest, final DownloadResponse downloadResponse) {
        String str = b;
        com.opos.cmn.an.f.a.b(str, "onStart:" + downloadRequest.f11181a);
        this.f11246c.execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.2
            @Override // java.lang.Runnable
            public final void run() {
                for (com.opos.cmn.func.dl.base.b bVar : b.this.f11245a) {
                    bVar.b(downloadRequest, downloadResponse);
                }
            }
        });
    }

    @Override // com.opos.cmn.func.dl.base.b
    public void c(final DownloadRequest downloadRequest, final DownloadResponse downloadResponse) {
        this.f11246c.execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.3
            @Override // java.lang.Runnable
            public final void run() {
                for (com.opos.cmn.func.dl.base.b bVar : b.this.f11245a) {
                    bVar.c(downloadRequest, downloadResponse);
                }
            }
        });
    }

    @Override // com.opos.cmn.func.dl.base.b
    public void d(final DownloadRequest downloadRequest, final DownloadResponse downloadResponse) {
        String str = b;
        com.opos.cmn.an.f.a.b(str, "onPause:" + downloadRequest.f11181a);
        this.f11246c.execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.4
            @Override // java.lang.Runnable
            public final void run() {
                for (com.opos.cmn.func.dl.base.b bVar : b.this.f11245a) {
                    bVar.d(downloadRequest, downloadResponse);
                }
            }
        });
    }

    @Override // com.opos.cmn.func.dl.base.b
    public void e(final DownloadRequest downloadRequest, final DownloadResponse downloadResponse) {
        String str = b;
        com.opos.cmn.an.f.a.b(str, "onCancle:" + downloadRequest.f11181a);
        this.f11246c.execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.5
            @Override // java.lang.Runnable
            public final void run() {
                for (com.opos.cmn.func.dl.base.b bVar : b.this.f11245a) {
                    bVar.e(downloadRequest, downloadResponse);
                }
            }
        });
    }

    @Override // com.opos.cmn.func.dl.base.b
    public void f(final DownloadRequest downloadRequest, final DownloadResponse downloadResponse) {
        String str = b;
        com.opos.cmn.an.f.a.b(str, "onComplete:" + downloadRequest.f11181a);
        this.f11246c.execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.6
            @Override // java.lang.Runnable
            public final void run() {
                for (com.opos.cmn.func.dl.base.b bVar : b.this.f11245a) {
                    bVar.f(downloadRequest, downloadResponse);
                }
            }
        });
    }
}
