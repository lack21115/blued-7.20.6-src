package com.mcxiaoke.packer.support.walle;

/* loaded from: source-7994992-dex2jar.jar:com/mcxiaoke/packer/support/walle/Pair.class */
final class Pair<A, B> {

    /* renamed from: a  reason: collision with root package name */
    private final A f10331a;
    private final B b;

    private Pair(A a2, B b) {
        this.f10331a = a2;
        this.b = b;
    }

    public static <A, B> Pair<A, B> a(A a2, B b) {
        return new Pair<>(a2, b);
    }

    public A a() {
        return this.f10331a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pair pair = (Pair) obj;
        A a2 = this.f10331a;
        if (a2 != null) {
            if (!a2.equals(pair.f10331a)) {
                return false;
            }
        } else if (pair.f10331a != null) {
            return false;
        }
        B b = this.b;
        B b2 = pair.b;
        return b != null ? b.equals(b2) : b2 == null;
    }

    public int hashCode() {
        A a2 = this.f10331a;
        int i = 0;
        int hashCode = a2 != null ? a2.hashCode() : 0;
        B b = this.b;
        if (b != null) {
            i = b.hashCode();
        }
        return (hashCode * 31) + i;
    }
}
