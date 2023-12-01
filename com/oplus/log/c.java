package com.oplus.log;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/c.class */
public class c {
    private a f;
    private com.oplus.log.g.a k;

    /* renamed from: a  reason: collision with root package name */
    private String f10638a = "";
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f10639c = "";
    private String d = "";
    private String g = "";
    private int h = 1;
    private int i = 1;
    private int j = 7;
    private b e = new b() { // from class: com.oplus.log.c.1
        @Override // com.oplus.log.c.b
        public final String a() {
            return "";
        }

        @Override // com.oplus.log.c.b
        public final String b() {
            return "";
        }

        @Override // com.oplus.log.c.b
        public final String c() {
            return "";
        }
    };

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/log/c$a.class */
    public interface a {
        String a();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/log/c$b.class */
    public interface b {
        String a();

        String b();

        String c();
    }

    public a a() {
        return this.f;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    public void a(com.oplus.log.g.a aVar) {
        this.k = aVar;
    }

    public void a(String str) {
        this.g = str;
    }

    public b b() {
        return this.e;
    }

    public void b(int i) {
        this.i = i;
    }

    public void b(String str) {
        this.f10638a = str;
    }

    public String c() {
        return this.g;
    }

    public void c(int i) {
        this.j = i;
    }

    public void c(String str) {
        this.b = str;
    }

    public String d() {
        return this.b;
    }

    public void d(String str) {
        this.f10639c = str;
    }

    public String e() {
        return this.f10638a;
    }

    public void e(String str) {
        this.d = str;
    }

    public String f() {
        return this.f10639c;
    }

    public String g() {
        return this.d;
    }

    public int h() {
        return this.h;
    }

    public int i() {
        return this.i;
    }

    public int j() {
        return this.j;
    }

    public com.oplus.log.g.a k() {
        return this.k;
    }
}
