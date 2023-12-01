package com.airbnb.lottie.model;

import androidx.core.util.Pair;
import com.alipay.sdk.util.i;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/MutablePair.class */
public class MutablePair<T> {

    /* renamed from: a  reason: collision with root package name */
    T f4327a;
    T b;

    private static boolean b(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public void a(T t, T t2) {
        this.f4327a = t;
        this.b = t2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            boolean z = false;
            if (b(pair.first, this.f4327a)) {
                z = false;
                if (b(pair.second, this.b)) {
                    z = true;
                }
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        T t = this.f4327a;
        int i = 0;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.b;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f4327a) + " " + String.valueOf(this.b) + i.d;
    }
}
