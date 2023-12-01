package com.tencent.txcopyrightedmedia.impl.utils;

import com.tencent.txcopyrightedmedia.impl.utils.w;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/bb.class */
public abstract class bb implements w.b {
    protected ba k;
    protected HttpURLConnection l;
    public bc m;

    public bb(ba baVar) {
        this.k = baVar;
    }

    @Override // com.tencent.txcopyrightedmedia.impl.utils.w.b
    public final void a(HttpURLConnection httpURLConnection) {
        this.l = httpURLConnection;
    }

    public byte[] a() {
        bc bcVar = this.m;
        if (bcVar != null) {
            return bcVar.f26397a;
        }
        return null;
    }

    public abstract String b();

    public abstract String c();

    public final ba f() {
        return this.k;
    }

    public final e g() {
        ba baVar = this.k;
        if (baVar == null || baVar.f26395a == null) {
            return null;
        }
        return this.k.f26395a.f26393a;
    }

    public final g h() {
        ba baVar = this.k;
        if (baVar == null || baVar.f26395a == null) {
            return null;
        }
        return this.k.f26395a.d;
    }

    public final String i() {
        ba baVar = this.k;
        if (baVar != null) {
            return baVar.f26396c.f26387a;
        }
        return null;
    }

    public final String j() {
        ba baVar = this.k;
        if (baVar != null) {
            return baVar.f26396c.d;
        }
        return null;
    }

    public final String k() {
        ba baVar = this.k;
        if (baVar != null) {
            return baVar.g.f26413a;
        }
        return null;
    }

    public final int l() {
        ba baVar = this.k;
        if (baVar != null) {
            return baVar.g.b;
        }
        return 0;
    }

    public final HttpURLConnection m() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(b()).openConnection();
            this.l = httpURLConnection;
            httpURLConnection.setRequestMethod("GET");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.l;
    }

    public final void n() {
        HttpURLConnection httpURLConnection = this.l;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final bc o() {
        if (this.m == null) {
            this.m = new bc();
        }
        return this.m;
    }
}
