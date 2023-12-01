package com.opos.cmn.func.b.b;

import com.opos.cmn.an.g.h;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final int f11174a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final InputStream f11175c;
    public final long d;
    @Deprecated
    public final Map<String, String> e;
    public final com.opos.cmn.func.b.b.a f;
    private final long g;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/e$a.class */
    public static class a {
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private InputStream f11177c;
        private Map<String, String> e;
        private com.opos.cmn.func.b.b.a f;

        /* renamed from: a  reason: collision with root package name */
        private int f11176a = -1;
        private long d = -1;
        private long g = -1;

        public a a(int i) {
            this.f11176a = i;
            return this;
        }

        public a a(long j) {
            this.d = j;
            return this;
        }

        public a a(com.opos.cmn.func.b.b.a aVar) {
            this.f = aVar;
            return this;
        }

        public a a(InputStream inputStream) {
            this.f11177c = inputStream;
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a a(Map<String, String> map) {
            this.e = map;
            return this;
        }

        public e a() {
            return new e(this);
        }

        public a b(long j) {
            this.g = j;
            return this;
        }
    }

    public e(a aVar) {
        this.f11174a = aVar.f11176a;
        this.b = aVar.b;
        this.f11175c = aVar.f11177c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
    }

    public void a() {
        long j = this.g;
        if (j >= 0) {
            h.a(j);
            return;
        }
        InputStream inputStream = this.f11175c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                com.opos.cmn.an.f.a.b("NetResponse", "close", e);
            }
        }
    }

    public String toString() {
        return "NetResponse{code=" + this.f11174a + ", errMsg='" + this.b + "', inputStream=" + this.f11175c + ", contentLength=" + this.d + ", headerMap=" + this.e + ", headers=" + this.f + '}';
    }
}
