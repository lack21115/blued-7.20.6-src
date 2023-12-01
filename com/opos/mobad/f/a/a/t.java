package com.opos.mobad.f.a.a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a/t.class */
public class t<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f12364a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private final List<b<T>> f12365c;
    private Set<Integer> d;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a/t$a.class */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        private List<b<T>> f12366a = new ArrayList();
        private int b = 0;

        public t<T> a() {
            return new t<>(this.f12366a, this.b);
        }

        public void a(T t, int i) {
            if (i <= 0) {
                return;
            }
            this.f12366a.add(new b<>(t, i));
            this.b += i;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a/t$b.class */
    static class b<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f12367a;
        private final T b;

        public b(T t, int i) {
            this.b = t;
            this.f12367a = i;
        }
    }

    private t(List<b<T>> list, int i) {
        this.f12365c = list;
        this.f12364a = i;
        this.b = i;
        this.d = new HashSet(list.size());
    }

    public T a() {
        if (this.b <= 0 || this.f12365c.size() <= 0 || this.d.size() >= this.f12365c.size()) {
            return null;
        }
        int random = (int) (Math.random() * this.b);
        int i = 0;
        for (int i2 = 0; i2 < this.f12365c.size(); i2++) {
            if (!this.d.contains(Integer.valueOf(i2))) {
                b<T> bVar = this.f12365c.get(i2);
                int max = i + Math.max(0, ((b) bVar).f12367a);
                i = max;
                if (random <= max) {
                    T t = (T) ((b) bVar).b;
                    this.d.add(Integer.valueOf(i2));
                    this.b -= ((b) bVar).f12367a;
                    return t;
                }
            }
        }
        return null;
    }

    public void b() {
        this.b = this.f12364a;
        this.d.clear();
    }
}
