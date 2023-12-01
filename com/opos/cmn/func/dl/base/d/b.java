package com.opos.cmn.func.dl.base.d;

import android.content.Context;
import android.content.IntentFilter;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.DownloadResponse;
import com.opos.cmn.func.dl.base.d.a;
import com.opos.cmn.func.dl.base.exception.DlException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/d/b.class */
public class b {

    /* renamed from: c  reason: collision with root package name */
    private static final String f11223c = b.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public Context f11224a;
    private com.opos.cmn.func.dl.base.f.a e;
    private List<DownloadRequest> d = new ArrayList();
    public C0472b b = new C0472b();

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/d/b$a.class */
    final class a extends com.opos.cmn.func.dl.base.a {
        a() {
        }

        @Override // com.opos.cmn.func.dl.base.a, com.opos.cmn.func.dl.base.b
        public final void a(DownloadRequest downloadRequest, DownloadResponse downloadResponse, DlException dlException) {
            if (!downloadRequest.g) {
                return;
            }
            int a2 = dlException.a();
            if (a2 != 1003 && a2 != 1013) {
                return;
            }
            String str = b.f11223c;
            com.opos.cmn.an.f.a.b(str, "add retry request:" + downloadRequest.toString());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= b.this.d.size()) {
                    b.this.d.add(downloadRequest);
                    return;
                }
                if (downloadRequest.d > ((DownloadRequest) b.this.d.get(i2)).d) {
                    b.this.d.add(i2, downloadRequest);
                    return;
                }
                i = i2 + 1;
            }
        }

        @Override // com.opos.cmn.func.dl.base.a, com.opos.cmn.func.dl.base.b
        public final void d(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            b.this.a(downloadRequest);
        }
    }

    /* renamed from: com.opos.cmn.func.dl.base.d.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/d/b$b.class */
    final class C0472b implements a.c {
        C0472b() {
        }

        @Override // com.opos.cmn.func.dl.base.d.a.c
        public final void a() {
            synchronized (this) {
                com.opos.cmn.an.f.a.b(b.f11223c, "-----onMoblieAvailable !");
                Iterator it = new ArrayList(b.this.d).iterator();
                while (it.hasNext()) {
                    b.this.e.a((DownloadRequest) it.next(), false);
                }
            }
        }

        @Override // com.opos.cmn.func.dl.base.d.a.c
        public final void b() {
            synchronized (this) {
                com.opos.cmn.an.f.a.b(b.f11223c, "-----onWifiAvailable!");
                Iterator it = new ArrayList(b.this.d).iterator();
                while (it.hasNext()) {
                    b.this.e.a((DownloadRequest) it.next(), false);
                }
            }
        }

        @Override // com.opos.cmn.func.dl.base.d.a.c
        public final void c() {
            synchronized (this) {
                com.opos.cmn.an.f.a.b(b.f11223c, "-----onUnavailable");
            }
        }
    }

    public b(Context context, com.opos.cmn.func.dl.base.f.a aVar) {
        this.f11224a = context;
        this.e = aVar;
        aVar.f11236c.a(new a());
        com.opos.cmn.func.dl.base.d.a a2 = com.opos.cmn.func.dl.base.d.a.a(context);
        C0472b c0472b = this.b;
        if (a2.b == null) {
            a2.b = new a.b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.setPriority(Integer.MAX_VALUE);
            a2.f11219a.registerReceiver(a2.b, intentFilter);
        }
        if (c0472b != null) {
            a2.f11220c.add(c0472b);
        }
    }

    public final void a(DownloadRequest downloadRequest) {
        this.d.remove(downloadRequest);
    }
}
