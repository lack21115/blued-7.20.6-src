package com.opos.cmn.func.dl;

import android.content.Context;
import com.opos.cmn.func.dl.base.DownloadConfig;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.b;
import com.opos.cmn.func.dl.base.c;
import com.opos.cmn.func.dl.base.d;
import com.opos.cmn.func.dl.service.DownloadRemoteManager;
import com.opos.cmn.func.dl.service.DownloadService;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/a.class */
public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24866a = a.class.getSimpleName();
    private c b;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, Class cls) {
        d dVar;
        if (context == null) {
            com.opos.cmn.an.f.a.d(f24866a, "Context should not be null!");
            return;
        }
        try {
            if (cls != null) {
                try {
                    if (DownloadService.class.isAssignableFrom(cls)) {
                        this.b = new DownloadRemoteManager(context.getApplicationContext(), cls);
                    }
                } catch (NoClassDefFoundError e) {
                    com.opos.cmn.an.f.a.d(f24866a, "library service not include!");
                    if (this.b != null) {
                        return;
                    }
                    dVar = new d(context);
                }
            }
            if (this.b == null) {
                dVar = new d(context);
                this.b = dVar;
            }
        } catch (Throwable th) {
            if (this.b == null) {
                this.b = new d(context);
            }
            throw th;
        }
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void a(DownloadConfig downloadConfig) {
        this.b.a(downloadConfig);
        com.opos.cmn.an.f.a.c(f24866a, "DownloadManager init!");
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void a(DownloadRequest downloadRequest) {
        this.b.a(downloadRequest);
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void a(b bVar) {
        this.b.a(bVar);
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void b(DownloadRequest downloadRequest) {
        this.b.b(downloadRequest);
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void b(b bVar) {
        this.b.b(bVar);
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void c(DownloadRequest downloadRequest) {
        this.b.c(downloadRequest);
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void d(DownloadRequest downloadRequest) {
        this.b.d(downloadRequest);
    }
}
