package com.opos.mobad.model.b;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/b/c.class */
public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private int f26389a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f26390c;
    private int d;
    private int e;
    private int f;
    private String g;
    private int h;
    private int i = -1;
    private String j;

    public String a() {
        return this.g;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(String str) {
        this.g = str;
    }

    public int b() {
        return this.h;
    }

    public void b(int i) {
        this.f26389a = i;
    }

    public void b(String str) {
        this.b = str;
    }

    public int c() {
        return this.f26389a;
    }

    public void c(int i) {
        this.d = i;
    }

    public void c(String str) {
        this.f26390c = str;
    }

    public String d() {
        return this.f26390c;
    }

    public void d(int i) {
        this.e = i;
    }

    public void d(String str) {
        this.j = str;
    }

    public int e() {
        return this.d;
    }

    public void e(int i) {
        this.f = i;
    }

    public int f() {
        return this.e;
    }

    public void f(int i) {
        this.i = i;
    }

    public int g() {
        return this.f;
    }

    public int h() {
        return this.i;
    }

    public String i() {
        return this.j;
    }

    public String toString() {
        return "FetchAdRequest{apiVer=" + this.f26389a + ", appId='" + this.b + "', posId='" + this.f26390c + "', posType=" + this.d + ", posHeight=" + this.e + ", posWidth=" + this.f + ", renderStyle=" + this.h + ", renderOri=" + this.i + '}';
    }
}
