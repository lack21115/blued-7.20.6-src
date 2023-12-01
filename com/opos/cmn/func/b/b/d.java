package com.opos.cmn.func.b.b;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f11170a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f11171c;
    public final byte[] d;
    public final long e;
    public final boolean f;
    public final boolean g;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/d$a.class */
    public static class a {
        private static AtomicLong e = new AtomicLong(0);

        /* renamed from: a  reason: collision with root package name */
        private String f11172a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private Map<String, String> f11173c;
        private byte[] d;
        private long f;
        private boolean g = false;
        private boolean h = false;

        private static long b() {
            return e.getAndIncrement();
        }

        public a a(d dVar) {
            a aVar = new a();
            if (dVar != null) {
                aVar.a(dVar.f11170a);
                aVar.b(dVar.b);
                aVar.a(dVar.f11171c);
                aVar.a(dVar.d);
                aVar.a(dVar.f);
                aVar.b(dVar.g);
            }
            return aVar;
        }

        public a a(String str) {
            this.f11172a = str;
            return this;
        }

        public a a(Map<String, String> map) {
            this.f11173c = map;
            return this;
        }

        public a a(boolean z) {
            this.g = z;
            return this;
        }

        public a a(byte[] bArr) {
            this.d = bArr;
            return this;
        }

        public d a() {
            if (TextUtils.isEmpty(this.f11172a) || TextUtils.isEmpty(this.b)) {
                throw new NullPointerException("httpMethod or url is null.");
            }
            this.f = b();
            if (this.f11173c == null) {
                this.f11173c = new HashMap();
            }
            return new d(this);
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a b(boolean z) {
            this.h = z;
            return this;
        }
    }

    public d(a aVar) {
        this.f11170a = aVar.f11172a;
        this.b = aVar.b;
        this.f11171c = aVar.f11173c;
        this.d = aVar.d;
        this.e = aVar.f;
        this.f = aVar.g;
        this.g = aVar.h;
    }

    public String toString() {
        return "NetRequest{, httpMethod='" + this.f11170a + "', url='" + this.b + "', headerMap=" + this.f11171c + ", data=" + Arrays.toString(this.d) + ", requestId=" + this.e + ", needEnCrypt=" + this.f + ", supportGzipCompress=" + this.g + '}';
    }
}
