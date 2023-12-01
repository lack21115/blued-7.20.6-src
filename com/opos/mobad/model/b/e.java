package com.opos.mobad.model.b;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/b/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private String f26394a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f26395c;

    public String a() {
        return this.f26394a;
    }

    public void a(String str) {
        this.f26394a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.f26395c;
    }

    public void c(String str) {
        this.f26395c = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.f26394a.equals(eVar.a()) && this.b.equals(eVar.b());
        }
        return false;
    }

    public int hashCode() {
        return this.f26394a.hashCode() * this.b.hashCode();
    }

    public String toString() {
        return "FetchMaterialEntity{url='" + this.f26394a + "', md5='" + this.b + "', savePath='" + this.f26395c + "'}";
    }
}
