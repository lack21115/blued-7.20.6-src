package com.opos.cmn.an.g;

import java.io.InputStream;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/g/g.class */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f10866a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final InputStream f10867c;
    public final long d;
    public final Map<String, String> e;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/g/g$a.class */
    public static class a {
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private InputStream f10869c;
        private Map<String, String> e;

        /* renamed from: a  reason: collision with root package name */
        private int f10868a = -1;
        private long d = -1;

        public a a(int i) {
            this.f10868a = i;
            return this;
        }

        public a a(long j) {
            this.d = j;
            return this;
        }

        public a a(InputStream inputStream) {
            this.f10869c = inputStream;
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

        public g a() {
            return new g(this);
        }
    }

    public g(a aVar) {
        this.f10866a = aVar.f10868a;
        this.b = aVar.b;
        this.f10867c = aVar.f10869c;
        this.d = aVar.d;
        this.e = aVar.e;
    }

    public String toString() {
        return "NetResponse{code=" + this.f10866a + ", errMsg='" + this.b + "', inputStream=" + this.f10867c + ", contentLength=" + this.d + ", headerMap=" + this.e + '}';
    }
}
