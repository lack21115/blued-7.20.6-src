package com.opos.cmn.func.dl.base.c;

import android.content.Context;
import com.opos.cmn.func.dl.base.c.d;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.InputStream;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/c/a.class */
public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24899a = a.class.getSimpleName();
    d b;
    private d d;
    private int e = 2;

    /* renamed from: c  reason: collision with root package name */
    public e f24900c = new f();

    public a(d.a aVar) {
        this.d = aVar.a();
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final InputStream a() {
        d dVar = this.b;
        if (dVar == null) {
            dVar = this.d;
        }
        return dVar.a();
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final InputStream a(Context context, String str, b bVar) {
        int i;
        InputStream a2;
        do {
            this.d.a(context, str, bVar);
            this.f24900c.a(context, this, str, bVar);
            if (com.opos.cmn.func.dl.base.h.a.a(d()) && (a2 = a()) != null) {
                return a2;
            }
            i = this.e;
            this.e = i - 1;
        } while (i >= 0);
        return null;
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final String a(String str) {
        d dVar = this.b;
        if (dVar == null) {
            dVar = this.d;
        }
        return dVar.a(str);
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final void a(String str, String str2) {
        this.d.a(str, str2);
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final String b() {
        d dVar = this.b;
        if (dVar == null) {
            dVar = this.d;
        }
        return dVar.b();
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final void c() {
        d dVar = this.b;
        if (dVar == null) {
            dVar = this.d;
        }
        dVar.c();
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final int d() {
        d dVar = this.b;
        if (dVar == null) {
            dVar = this.d;
        }
        return dVar.d();
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final long e() {
        d dVar = this.b;
        if (dVar == null) {
            dVar = this.d;
        }
        long e = dVar.e();
        long j = e;
        if (e == -1) {
            j = com.opos.cmn.func.dl.base.h.a.b(a("Content-Range"));
        }
        if (DownloadUtils.VALUE_CHUNKED.equals(a("Transfer-Encoding"))) {
            com.opos.cmn.an.f.a.c(f24899a, "Transfer-Encoding is chunked !!");
        }
        return j;
    }
}
