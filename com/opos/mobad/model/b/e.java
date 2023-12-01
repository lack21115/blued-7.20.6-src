package com.opos.mobad.model.b;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/b/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private String f12706a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f12707c;

    public String a() {
        return this.f12706a;
    }

    public void a(String str) {
        this.f12706a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.f12707c;
    }

    public void c(String str) {
        this.f12707c = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.f12706a.equals(eVar.a()) && this.b.equals(eVar.b());
        }
        return false;
    }

    public int hashCode() {
        return this.f12706a.hashCode() * this.b.hashCode();
    }

    public String toString() {
        return "FetchMaterialEntity{url='" + this.f12706a + "', md5='" + this.b + "', savePath='" + this.f12707c + "'}";
    }
}
