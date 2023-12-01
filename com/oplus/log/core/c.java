package com.oplus.log.core;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/core/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    String f10643a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    String f10644c;
    long d;
    long e;
    long f;
    long g;
    byte[] h;
    byte[] i;

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/log/core/c$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f10645a;
        public String b;
        public byte[] e;
        public byte[] f;

        /* renamed from: c  reason: collision with root package name */
        long f10646c = 2097152;
        long d = 604800000;
        long g = 52428800;
        public String h = "";

        public final a a(long j) {
            this.d = j * 86400000;
            return this;
        }

        public final c a() {
            c cVar = new c((byte) 0);
            cVar.f10643a = this.f10645a;
            cVar.b = this.b;
            cVar.d = this.f10646c;
            cVar.g = this.g;
            cVar.e = this.d;
            cVar.h = this.e;
            cVar.i = this.f;
            cVar.f10644c = this.h;
            return cVar;
        }
    }

    private c() {
        this.f10644c = "";
        this.d = 2097152L;
        this.e = 604800000L;
        this.f = 500L;
        this.g = 52428800L;
    }

    /* synthetic */ c(byte b) {
        this();
    }
}
