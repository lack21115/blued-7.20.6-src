package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/GroupedLinkedMap.class */
class GroupedLinkedMap<K extends Poolable, V> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedEntry<K, V> f7197a = new LinkedEntry<>();
    private final Map<K, LinkedEntry<K, V>> b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/GroupedLinkedMap$LinkedEntry.class */
    public static class LinkedEntry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f7198a;
        LinkedEntry<K, V> b;

        /* renamed from: c  reason: collision with root package name */
        LinkedEntry<K, V> f7199c;
        private List<V> d;

        LinkedEntry() {
            this(null);
        }

        LinkedEntry(K k) {
            this.f7199c = this;
            this.b = this;
            this.f7198a = k;
        }

        public V a() {
            int b = b();
            if (b > 0) {
                return this.d.remove(b - 1);
            }
            return null;
        }

        public void a(V v) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            this.d.add(v);
        }

        public int b() {
            List<V> list = this.d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    private void a(LinkedEntry<K, V> linkedEntry) {
        d(linkedEntry);
        linkedEntry.f7199c = this.f7197a;
        linkedEntry.b = this.f7197a.b;
        c(linkedEntry);
    }

    private void b(LinkedEntry<K, V> linkedEntry) {
        d(linkedEntry);
        linkedEntry.f7199c = this.f7197a.f7199c;
        linkedEntry.b = this.f7197a;
        c(linkedEntry);
    }

    private static <K, V> void c(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.b.f7199c = linkedEntry;
        linkedEntry.f7199c.b = linkedEntry;
    }

    private static <K, V> void d(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.f7199c.b = linkedEntry.b;
        linkedEntry.b.f7199c = linkedEntry.f7199c;
    }

    public V a() {
        LinkedEntry linkedEntry = this.f7197a.f7199c;
        while (true) {
            LinkedEntry linkedEntry2 = linkedEntry;
            if (linkedEntry2.equals(this.f7197a)) {
                return null;
            }
            V v = (V) linkedEntry2.a();
            if (v != null) {
                return v;
            }
            d(linkedEntry2);
            this.b.remove(linkedEntry2.f7198a);
            ((Poolable) linkedEntry2.f7198a).a();
            linkedEntry = linkedEntry2.f7199c;
        }
    }

    public V a(K k) {
        LinkedEntry<K, V> linkedEntry;
        LinkedEntry<K, V> linkedEntry2 = this.b.get(k);
        if (linkedEntry2 == null) {
            LinkedEntry<K, V> linkedEntry3 = new LinkedEntry<>(k);
            this.b.put(k, linkedEntry3);
            linkedEntry = linkedEntry3;
        } else {
            k.a();
            linkedEntry = linkedEntry2;
        }
        a(linkedEntry);
        return linkedEntry.a();
    }

    public void a(K k, V v) {
        LinkedEntry<K, V> linkedEntry;
        LinkedEntry<K, V> linkedEntry2 = this.b.get(k);
        if (linkedEntry2 == null) {
            LinkedEntry<K, V> linkedEntry3 = new LinkedEntry<>(k);
            b(linkedEntry3);
            this.b.put(k, linkedEntry3);
            linkedEntry = linkedEntry3;
        } else {
            k.a();
            linkedEntry = linkedEntry2;
        }
        linkedEntry.a(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (LinkedEntry<K, V> linkedEntry = this.f7197a.b; !linkedEntry.equals(this.f7197a); linkedEntry = linkedEntry.b) {
            z = true;
            sb.append('{');
            sb.append(linkedEntry.f7198a);
            sb.append(':');
            sb.append(linkedEntry.b());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
