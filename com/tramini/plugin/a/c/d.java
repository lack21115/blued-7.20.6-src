package com.tramini.plugin.a.c;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/c/d.class */
public class d implements Comparable<d> {

    /* renamed from: a  reason: collision with root package name */
    public String f40504a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public long f40505c;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(d dVar) {
        return this.f40505c > dVar.f40505c ? 1 : -1;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof d) && (this == obj || this.f40504a.equals(((d) obj).f40504a))) {
            return true;
        }
        return super.equals(obj);
    }

    public int hashCode() {
        try {
            return Integer.parseInt(this.f40504a);
        } catch (Throwable th) {
            th.printStackTrace();
            return super.hashCode();
        }
    }

    public String toString() {
        return d.class.getSimpleName() + " [ id: " + this.f40504a + ", value: " + this.b + ", timeStamp: " + this.f40505c + " ]";
    }
}
