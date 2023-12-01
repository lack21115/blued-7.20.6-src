package com.opos.mobad.i;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/i/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f12530a;
    public final long b;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/i/b$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f12531a = false;
        private long b = -1;

        public a a(long j) {
            this.b = j;
            return this;
        }

        public a a(boolean z) {
            this.f12531a = z;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public b(a aVar) {
        this.f12530a = aVar.f12531a;
        this.b = aVar.b;
    }

    public String toString() {
        return "DownloadResponse{success=" + this.f12530a + ", contentLength=" + this.b + '}';
    }
}
