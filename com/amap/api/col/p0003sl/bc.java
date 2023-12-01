package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.col.p0003sl.br;
import com.amap.api.col.p0003sl.bx;
import java.io.IOException;

/* renamed from: com.amap.api.col.3sl.bc  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bc.class */
public final class bc extends lc implements br.a {

    /* renamed from: a  reason: collision with root package name */
    private br f4773a;
    private bt b;

    /* renamed from: c  reason: collision with root package name */
    private bw f4774c;
    private Context d;
    private Bundle e;
    private boolean g;

    private bc(bw bwVar, Context context) {
        this.e = new Bundle();
        this.g = false;
        this.f4774c = bwVar;
        this.d = context;
    }

    public bc(bw bwVar, Context context, byte b) {
        this(bwVar, context);
    }

    private String d() {
        return dw.c(this.d);
    }

    private void e() throws IOException {
        br brVar = new br(new bs(this.f4774c.getUrl(), d(), this.f4774c.v(), this.f4774c.w()), this.f4774c.getUrl(), this.d, this.f4774c);
        this.f4773a = brVar;
        brVar.a(this);
        bw bwVar = this.f4774c;
        this.b = new bt(bwVar, bwVar);
        if (this.g) {
            return;
        }
        this.f4773a.a();
    }

    public final void a() {
        this.g = true;
        br brVar = this.f4773a;
        if (brVar != null) {
            brVar.b();
        } else {
            cancelTask();
        }
        bt btVar = this.b;
        if (btVar != null) {
            btVar.a();
        }
    }

    public final void b() {
        Bundle bundle = this.e;
        if (bundle != null) {
            bundle.clear();
            this.e = null;
        }
    }

    @Override // com.amap.api.col.p0003sl.br.a
    public final void c() {
        bt btVar = this.b;
        if (btVar != null) {
            btVar.b();
        }
    }

    @Override // com.amap.api.col.p0003sl.lc
    public final void runTask() {
        if (this.f4774c.u()) {
            this.f4774c.a(bx.a.file_io_exception);
            return;
        }
        try {
            e();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
