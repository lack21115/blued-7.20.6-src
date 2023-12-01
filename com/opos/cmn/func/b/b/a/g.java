package com.opos.cmn.func.b.b.a;

import com.opos.cmn.func.b.b.a.d;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f24853a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final SSLSocketFactory f24854c;
    public final HostnameVerifier d;
    public final X509TrustManager e;
    public final d f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/g$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f24855a = 30000;
        private int b = 30000;

        /* renamed from: c  reason: collision with root package name */
        private SSLSocketFactory f24856c;
        private HostnameVerifier d;
        private d e;
        private X509TrustManager f;

        public a a(SSLSocketFactory sSLSocketFactory) {
            this.f24856c = sSLSocketFactory;
            return this;
        }

        public g a() {
            if (this.e == null) {
                this.e = new d.a().a();
            }
            return new g(this);
        }
    }

    private g(a aVar) {
        this.f24853a = aVar.f24855a;
        this.b = aVar.b;
        this.f24854c = aVar.f24856c;
        this.d = aVar.d;
        this.e = aVar.f;
        this.f = aVar.e;
    }

    public String toString() {
        return "InitParameter{, connectTimeout=" + this.f24853a + ", readTimeout=" + this.b + ", sslSocketFactory=" + this.f24854c + ", hostnameVerifier=" + this.d + ", x509TrustManager=" + this.e + ", httpExtConfig=" + this.f + '}';
    }
}
