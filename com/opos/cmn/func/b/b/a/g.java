package com.opos.cmn.func.b.b.a;

import com.opos.cmn.func.b.b.a.d;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f11165a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final SSLSocketFactory f11166c;
    public final HostnameVerifier d;
    public final X509TrustManager e;
    public final d f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/g$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f11167a = 30000;
        private int b = 30000;

        /* renamed from: c  reason: collision with root package name */
        private SSLSocketFactory f11168c;
        private HostnameVerifier d;
        private d e;
        private X509TrustManager f;

        public a a(SSLSocketFactory sSLSocketFactory) {
            this.f11168c = sSLSocketFactory;
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
        this.f11165a = aVar.f11167a;
        this.b = aVar.b;
        this.f11166c = aVar.f11168c;
        this.d = aVar.d;
        this.e = aVar.f;
        this.f = aVar.e;
    }

    public String toString() {
        return "InitParameter{, connectTimeout=" + this.f11165a + ", readTimeout=" + this.b + ", sslSocketFactory=" + this.f11166c + ", hostnameVerifier=" + this.d + ", x509TrustManager=" + this.e + ", httpExtConfig=" + this.f + '}';
    }
}
