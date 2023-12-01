package com.opos.cmn.func.b.b;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f24858a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f24859c;
    public final byte[] d;
    public final long e;
    public final boolean f;
    public final boolean g;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/d$a.class */
    public static class a {
        private static AtomicLong e = new AtomicLong(0);

        /* renamed from: a  reason: collision with root package name */
        private String f24860a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private Map<String, String> f24861c;
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
                aVar.a(dVar.f24858a);
                aVar.b(dVar.b);
                aVar.a(dVar.f24859c);
                aVar.a(dVar.d);
                aVar.a(dVar.f);
                aVar.b(dVar.g);
            }
            return aVar;
        }

        public a a(String str) {
            this.f24860a = str;
            return this;
        }

        public a a(Map<String, String> map) {
            this.f24861c = map;
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
            if (TextUtils.isEmpty(this.f24860a) || TextUtils.isEmpty(this.b)) {
                throw new NullPointerException("httpMethod or url is null.");
            }
            this.f = b();
            if (this.f24861c == null) {
                this.f24861c = new HashMap();
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
        this.f24858a = aVar.f24860a;
        this.b = aVar.b;
        this.f24859c = aVar.f24861c;
        this.d = aVar.d;
        this.e = aVar.f;
        this.f = aVar.g;
        this.g = aVar.h;
    }

    public String toString() {
        return "NetRequest{, httpMethod='" + this.f24858a + "', url='" + this.b + "', headerMap=" + this.f24859c + ", data=" + Arrays.toString(this.d) + ", requestId=" + this.e + ", needEnCrypt=" + this.f + ", supportGzipCompress=" + this.g + '}';
    }
}
