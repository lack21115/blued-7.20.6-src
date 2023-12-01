package com.tramini.plugin.a.c;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/c/d.class */
public class d implements Comparable<d> {

    /* renamed from: a  reason: collision with root package name */
    public String f26813a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public long f26814c;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(d dVar) {
        return this.f26814c > dVar.f26814c ? 1 : -1;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof d) && (this == obj || this.f26813a.equals(((d) obj).f26813a))) {
            return true;
        }
        return super.equals(obj);
    }

    public int hashCode() {
        try {
            return Integer.parseInt(this.f26813a);
        } catch (Throwable th) {
            th.printStackTrace();
            return super.hashCode();
        }
    }

    public String toString() {
        return d.class.getSimpleName() + " [ id: " + this.f26813a + ", value: " + this.b + ", timeStamp: " + this.f26814c + " ]";
    }
}
