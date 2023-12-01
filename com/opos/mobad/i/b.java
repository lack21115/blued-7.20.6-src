package com.opos.mobad.i;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/i/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f26218a;
    public final long b;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/i/b$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f26219a = false;
        private long b = -1;

        public a a(long j) {
            this.b = j;
            return this;
        }

        public a a(boolean z) {
            this.f26219a = z;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public b(a aVar) {
        this.f26218a = aVar.f26219a;
        this.b = aVar.b;
    }

    public String toString() {
        return "DownloadResponse{success=" + this.f26218a + ", contentLength=" + this.b + '}';
    }
}
