package com.oplus.log.core;

import android.text.TextUtils;
import com.oplus.log.core.e;
import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/core/d.class */
public final class d {
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public long f24335c;
    public h d;
    private String e;
    private String f;
    private long g;
    private long h;
    private long i;
    private String j;
    private String k;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentLinkedQueue<e> f24334a = new ConcurrentLinkedQueue<>();
    private SimpleDateFormat l = new SimpleDateFormat("yyyy-MM-dd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        if (!((TextUtils.isEmpty(cVar.f24330a) || TextUtils.isEmpty(cVar.b) || cVar.h == null || cVar.i == null) ? false : true)) {
            throw new NullPointerException("config's param is invalid");
        }
        this.b = cVar.b;
        this.e = cVar.f24330a;
        this.f = cVar.f24331c;
        this.g = cVar.e;
        this.i = cVar.g;
        this.h = cVar.d;
        this.f24335c = cVar.f;
        this.j = new String(cVar.h);
        this.k = new String(cVar.i);
        if (this.d == null) {
            h hVar = new h(this.f24334a, this.e, this.b, this.g, this.h, this.i, this.j, this.k, this.f);
            this.d = hVar;
            hVar.setName("logan-thread");
            this.d.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(e.b bVar) {
        if (TextUtils.isEmpty(this.b)) {
            return;
        }
        e eVar = new e();
        eVar.f24336a = e.a.f24339c;
        eVar.b = bVar;
        this.f24334a.add(eVar);
        h hVar = this.d;
        if (hVar != null) {
            hVar.a();
        }
    }

    public final void a(i iVar) {
        this.d.f24342a = iVar;
    }
}
