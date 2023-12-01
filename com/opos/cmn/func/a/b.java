package com.opos.cmn.func.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f24807a;
    public final long b;

    /* renamed from: c  reason: collision with root package name */
    public final int f24808c;
    public final long d;
    public final String e;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/a/b$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f24809a = false;
        private long b = -1;

        /* renamed from: c  reason: collision with root package name */
        private int f24810c = -1;
        private long d = -1;
        private String e = "";

        public a a(int i) {
            this.f24810c = i;
            return this;
        }

        public a a(int i, String str) {
            if (this.f24810c == -1) {
                this.f24810c = i;
                this.e = str;
            }
            return this;
        }

        public a a(long j) {
            this.b = j;
            return this;
        }

        public a a(String str) {
            this.e = str;
            return this;
        }

        public a a(boolean z) {
            this.f24809a = z;
            return this;
        }

        public b a() {
            return new b(this);
        }

        public a b(long j) {
            this.d = j;
            return this;
        }
    }

    public b(a aVar) {
        this.f24807a = aVar.f24809a;
        this.b = aVar.b;
        this.f24808c = aVar.f24810c;
        this.d = aVar.d;
        this.e = aVar.e;
    }

    public String toString() {
        return "DownloadResponse{success=" + this.f24807a + ", contentLength=" + this.b + ", errorCode=" + this.f24808c + ", traffic=" + this.d + ", message=" + this.e + '}';
    }
}
