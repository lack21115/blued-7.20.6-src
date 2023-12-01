package com.opos.cmn.func.dl.base.f;

import android.text.TextUtils;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.DownloadResponse;
import com.opos.cmn.func.dl.base.a.c;
import com.opos.cmn.func.dl.base.d;
import com.opos.cmn.func.dl.base.exception.DlException;
import com.opos.cmn.func.dl.base.g.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/f/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11235a = a.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public d f11236c;
    public b d;
    private com.opos.cmn.func.dl.base.a.a.d g;
    private com.opos.cmn.func.dl.base.d.b h;
    private Map<Integer, DownloadRequest> f = new ConcurrentHashMap();
    public Map<Integer, c> b = new ConcurrentHashMap();
    public com.opos.cmn.func.dl.base.a.a.b e = new com.opos.cmn.func.dl.base.a.a.b();

    /* renamed from: com.opos.cmn.func.dl.base.f.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/f/a$a.class */
    final class C0473a extends com.opos.cmn.func.dl.base.a {
        C0473a() {
        }

        private void a(int i) {
            a.this.f.remove(Integer.valueOf(i));
            a.this.b.remove(Integer.valueOf(i));
        }

        private void a(c cVar) {
            final com.opos.cmn.func.dl.base.a.b bVar = cVar.f11205a;
            if (TextUtils.isEmpty(bVar.h)) {
                return;
            }
            a.this.f11236c.g().d().execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.f.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.opos.cmn.an.d.b.a.e(bVar.i);
                    com.opos.cmn.an.d.b.a.e(bVar.j);
                }
            });
        }

        @Override // com.opos.cmn.func.dl.base.a, com.opos.cmn.func.dl.base.b
        public final void a(DownloadRequest downloadRequest, DownloadResponse downloadResponse, DlException dlException) {
            String str = a.f11235a;
            com.opos.cmn.an.f.a.b(str, "onError:" + dlException.toString());
            a.this.a().b(downloadRequest.f);
            c cVar = (c) a.this.b.get(Integer.valueOf(downloadRequest.f));
            if (cVar != null && !cVar.f11205a.m) {
                a(cVar);
            }
            if (downloadRequest.g) {
                return;
            }
            a(downloadRequest.f);
        }

        @Override // com.opos.cmn.func.dl.base.a, com.opos.cmn.func.dl.base.b
        public final void d(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            String str = a.f11235a;
            com.opos.cmn.an.f.a.b(str, "onPause:" + downloadRequest.f11181a);
            a.this.a().b(downloadRequest.f);
            c cVar = (c) a.this.b.get(Integer.valueOf(downloadRequest.f));
            if (cVar == null || cVar.f11205a.m) {
                return;
            }
            a(cVar);
        }

        @Override // com.opos.cmn.func.dl.base.a, com.opos.cmn.func.dl.base.b
        public final void e(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            String str = a.f11235a;
            com.opos.cmn.an.f.a.b(str, "onCancle:" + downloadRequest.f11181a);
            a.this.a().b(downloadRequest.f);
            c cVar = (c) a.this.b.get(Integer.valueOf(downloadRequest.f));
            if (cVar != null) {
                a(cVar);
            }
            a(downloadRequest.f);
        }

        @Override // com.opos.cmn.func.dl.base.a, com.opos.cmn.func.dl.base.b
        public final void f(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            String str = a.f11235a;
            com.opos.cmn.an.f.a.b(str, "onComplete:" + downloadRequest.f11181a);
            c cVar = (c) a.this.b.get(Integer.valueOf(downloadRequest.f));
            if (cVar != null) {
                a(cVar);
            }
            a(downloadRequest.f);
        }
    }

    public a(d dVar, b bVar) {
        this.f11236c = dVar;
        this.d = bVar;
        this.h = new com.opos.cmn.func.dl.base.d.b(this.f11236c.f(), this);
        dVar.a(new C0473a());
    }

    public final com.opos.cmn.func.dl.base.a.a.d a() {
        if (this.g == null) {
            this.g = new com.opos.cmn.func.dl.base.a.a.d(this.f11236c.f(), this, this.f11236c.b());
        }
        return this.g;
    }

    public final void a(final DownloadRequest downloadRequest, final boolean z) {
        if (downloadRequest == null) {
            com.opos.cmn.an.f.a.d(f11235a, "Request is null,do nothing");
        } else {
            com.opos.cmn.an.j.b.a(new Runnable() { // from class: com.opos.cmn.func.dl.base.f.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    int i = downloadRequest.f;
                    if (a.this.f.get(Integer.valueOf(i)) == null) {
                        a.this.f.put(Integer.valueOf(i), downloadRequest);
                    }
                    c cVar = (c) a.this.b.get(Integer.valueOf(i));
                    c cVar2 = cVar;
                    if (cVar == null) {
                        cVar2 = new c(downloadRequest, a.this);
                        a.this.b.put(Integer.valueOf(i), cVar2);
                    }
                    a.this.h.a(downloadRequest);
                    cVar2.a(z);
                }
            });
        }
    }
}
