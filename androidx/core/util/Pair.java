package androidx.core.util;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/util/Pair.class */
public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f, S s) {
        this.first = f;
        this.second = s;
    }

    public static <A, B> Pair<A, B> create(A a2, B b) {
        return new Pair<>(a2, b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            boolean z = false;
            if (ObjectsCompat.equals(pair.first, this.first)) {
                z = false;
                if (ObjectsCompat.equals(pair.second, this.second)) {
                    z = true;
                }
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        F f = this.first;
        int i = 0;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.second;
        if (s != null) {
            i = s.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}
