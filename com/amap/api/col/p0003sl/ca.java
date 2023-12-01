package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.ca  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ca.class */
public abstract class ca implements ce {

    /* renamed from: a  reason: collision with root package name */
    protected int f4803a;
    protected aw b;

    public ca(int i, aw awVar) {
        this.f4803a = i;
        this.b = awVar;
    }

    public void a() {
        StringBuilder sb = new StringBuilder("Wrong call delete()  State: ");
        sb.append(b());
        sb.append("  ");
        sb.append(getClass());
    }

    public void a(int i) {
        StringBuilder sb = new StringBuilder("Wrong call fail()  State: ");
        sb.append(b());
        sb.append("  ");
        sb.append(getClass());
    }

    public final boolean a(ca caVar) {
        return caVar.b() == b();
    }

    public final int b() {
        return this.f4803a;
    }

    public final void b(ca caVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(b());
        sb.append(" ==> ");
        sb.append(caVar.b());
        sb.append("   ");
        sb.append(getClass());
        sb.append("==>");
        sb.append(caVar.getClass());
    }

    public void c() {
        StringBuilder sb = new StringBuilder("Wrong call start()  State: ");
        sb.append(b());
        sb.append("  ");
        sb.append(getClass());
    }

    public void d() {
        StringBuilder sb = new StringBuilder("Wrong call continueDownload()  State: ");
        sb.append(b());
        sb.append("  ");
        sb.append(getClass());
    }

    public void e() {
        StringBuilder sb = new StringBuilder("Wrong call pause()  State: ");
        sb.append(b());
        sb.append("  ");
        sb.append(getClass());
    }

    public void f() {
        StringBuilder sb = new StringBuilder("Wrong call hasNew()  State: ");
        sb.append(b());
        sb.append("  ");
        sb.append(getClass());
    }

    public void g() {
        StringBuilder sb = new StringBuilder("Wrong call complete()  State: ");
        sb.append(b());
        sb.append("  ");
        sb.append(getClass());
    }
}
