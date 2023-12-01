package com.opos.cmn.an.g;

import java.util.Arrays;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/g/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final int f24549a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f24550c;
    public final Map<String, String> d;
    public final int e;
    public final int f;
    public final byte[] g;
    public final SSLSocketFactory h;
    public final HostnameVerifier i;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/g/f$a.class */
    public static class a {
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f24552c;
        private Map<String, String> d;
        private byte[] g;
        private SSLSocketFactory h;
        private HostnameVerifier i;

        /* renamed from: a  reason: collision with root package name */
        private int f24551a = 0;
        private int e = 30000;
        private int f = 30000;

        private void b() {
        }

        private boolean d(int i) {
            boolean z = true;
            if (i != 0) {
                z = true;
                if (1 != i) {
                    z = true;
                    if (2 != i) {
                        if (3 == i) {
                            return true;
                        }
                        z = false;
                    }
                }
            }
            return z;
        }

        public a a(int i) {
            this.f24551a = i;
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a a(Map<String, String> map) {
            this.d = map;
            return this;
        }

        public a a(HostnameVerifier hostnameVerifier) {
            this.i = hostnameVerifier;
            return this;
        }

        public a a(SSLSocketFactory sSLSocketFactory) {
            this.h = sSLSocketFactory;
            return this;
        }

        public a a(byte[] bArr) {
            this.g = bArr;
            return this;
        }

        public f a() throws Exception {
            if (com.opos.cmn.an.c.a.a(this.b) || com.opos.cmn.an.c.a.a(this.f24552c)) {
                throw new NullPointerException("httpMethod or url is null.");
            }
            if (d(this.f24551a)) {
                b();
                return new f(this);
            }
            throw new Exception("protocol should be NET_PROTOCOL_HTTP or NET_PROTOCOL_HTTPS or NET_PROTOCOL_HTTP2 or NET_PROTOCOL_SPDY");
        }

        public a b(int i) {
            this.e = i;
            return this;
        }

        public a b(String str) {
            this.f24552c = str;
            return this;
        }

        public a c(int i) {
            this.f = i;
            return this;
        }
    }

    public f(a aVar) {
        this.f24549a = aVar.f24551a;
        this.b = aVar.b;
        this.f24550c = aVar.f24552c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
    }

    public String toString() {
        return "NetRequest{protocol=" + this.f24549a + ", httpMethod='" + this.b + "', url='" + this.f24550c + "', headerMap=" + this.d + ", connectTimeout=" + this.e + ", readTimeout=" + this.f + ", data=" + Arrays.toString(this.g) + ", sslSocketFactory=" + this.h + ", hostnameVerifier=" + this.i + '}';
    }
}
