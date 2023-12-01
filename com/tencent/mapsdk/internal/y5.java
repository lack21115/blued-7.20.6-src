package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.y5.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/y5.class */
public class y5<T extends a> {
    private static final int e = 50;
    private static final int f = 40;

    /* renamed from: a  reason: collision with root package name */
    private final o5 f24434a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private Set<T> f24435c;
    private List<y5<T>> d;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/y5$a.class */
    public interface a {
        p5 a();
    }

    public y5(double d, double d2, double d3, double d4) {
        this(new o5(d, d2, d3, d4));
    }

    private y5(double d, double d2, double d3, double d4, int i) {
        this(new o5(d, d2, d3, d4), i);
    }

    public y5(o5 o5Var) {
        this(o5Var, 0);
    }

    private y5(o5 o5Var, int i) {
        this.d = null;
        this.f24434a = o5Var;
        this.b = i;
    }

    private void a(double d, double d2, T t) {
        List<y5<T>> list = this.d;
        if (list == null) {
            if (this.f24435c == null) {
                this.f24435c = new HashSet();
            }
            this.f24435c.add(t);
            if (this.f24435c.size() <= 50 || this.b >= 40) {
                return;
            }
            b();
            return;
        }
        o5 o5Var = this.f24434a;
        if (d2 < o5Var.f) {
            if (d < o5Var.e) {
                list.get(0).a(d, d2, t);
            } else {
                list.get(1).a(d, d2, t);
            }
        } else if (d < o5Var.e) {
            list.get(2).a(d, d2, t);
        } else {
            list.get(3).a(d, d2, t);
        }
    }

    private void a(o5 o5Var, Collection<T> collection) {
        if (this.f24434a.b(o5Var)) {
            List<y5<T>> list = this.d;
            if (list != null) {
                for (y5<T> y5Var : list) {
                    y5Var.a(o5Var, collection);
                }
            } else if (this.f24435c != null) {
                if (o5Var.a(this.f24434a)) {
                    collection.addAll(this.f24435c);
                    return;
                }
                for (T t : this.f24435c) {
                    if (o5Var.a(t.a())) {
                        collection.add(t);
                    }
                }
            }
        }
    }

    private void b() {
        ArrayList arrayList = new ArrayList(4);
        this.d = arrayList;
        o5 o5Var = this.f24434a;
        arrayList.add(new y5(o5Var.f23983a, o5Var.e, o5Var.b, o5Var.f, this.b + 1));
        List<y5<T>> list = this.d;
        o5 o5Var2 = this.f24434a;
        list.add(new y5<>(o5Var2.e, o5Var2.f23984c, o5Var2.b, o5Var2.f, this.b + 1));
        List<y5<T>> list2 = this.d;
        o5 o5Var3 = this.f24434a;
        list2.add(new y5<>(o5Var3.f23983a, o5Var3.e, o5Var3.f, o5Var3.d, this.b + 1));
        List<y5<T>> list3 = this.d;
        o5 o5Var4 = this.f24434a;
        list3.add(new y5<>(o5Var4.e, o5Var4.f23984c, o5Var4.f, o5Var4.d, this.b + 1));
        Set<T> set = this.f24435c;
        this.f24435c = null;
        for (T t : set) {
            a(t.a().b, t.a().f23992c, t);
        }
    }

    private boolean b(double d, double d2, T t) {
        List<y5<T>> list = this.d;
        if (list != null) {
            o5 o5Var = this.f24434a;
            return d2 < o5Var.f ? d < o5Var.e ? list.get(0).b(d, d2, t) : list.get(1).b(d, d2, t) : d < o5Var.e ? list.get(2).b(d, d2, t) : list.get(3).b(d, d2, t);
        }
        Set<T> set = this.f24435c;
        if (set == null) {
            return false;
        }
        return set.remove(t);
    }

    public Collection<T> a(o5 o5Var) {
        ArrayList arrayList = new ArrayList();
        a(o5Var, arrayList);
        return arrayList;
    }

    public void a() {
        this.d = null;
        Set<T> set = this.f24435c;
        if (set != null) {
            set.clear();
        }
    }

    public void a(T t) {
        p5 a2 = t.a();
        if (this.f24434a.a(a2.b, a2.f23992c)) {
            a(a2.b, a2.f23992c, t);
        }
    }

    public boolean b(T t) {
        p5 a2 = t.a();
        if (this.f24434a.a(a2.b, a2.f23992c)) {
            return b(a2.b, a2.f23992c, t);
        }
        return false;
    }
}
