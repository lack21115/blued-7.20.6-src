package com.opos.cmn.an.f.a.b;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/f/a/b/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f10831a;
    public final Object b;

    /* renamed from: c  reason: collision with root package name */
    public final Throwable f10832c;
    public final int d;
    public final long e;
    public final String f;
    public final long g;
    public final int h;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/f/a/b/d$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f10833a;
        private Object b;

        /* renamed from: c  reason: collision with root package name */
        private Throwable f10834c;
        private int d;
        private long e = 0;
        private String f = "";
        private long g = 0;
        private int h = 1;

        public a a(int i) {
            this.d = i;
            return this;
        }

        public a a(long j) {
            this.e = j;
            return this;
        }

        public a a(Object obj) {
            this.b = obj;
            return this;
        }

        public a a(String str) {
            this.f10833a = str;
            return this;
        }

        public a a(Throwable th) {
            this.f10834c = th;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(int i) {
            this.h = i;
            return this;
        }

        public a b(long j) {
            this.g = j;
            return this;
        }

        public a b(String str) {
            this.f = str;
            return this;
        }
    }

    private d(a aVar) {
        this.f10831a = aVar.f10833a;
        this.b = aVar.b;
        this.f10832c = aVar.f10834c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
    }
}
