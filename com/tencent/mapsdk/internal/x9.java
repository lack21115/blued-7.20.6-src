package com.tencent.mapsdk.internal;

import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/x9.class */
public class x9<Key, Value> {

    /* renamed from: a  reason: collision with root package name */
    private int f38105a;
    private x9<Key, Value>.b b;

    /* renamed from: c  reason: collision with root package name */
    private x9<Key, Value>.b f38106c;
    private HashMap<Key, x9<Key, Value>.b> d = new HashMap<>();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/x9$b.class */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        private Key f38107a;
        private Value b;

        /* renamed from: c  reason: collision with root package name */
        private x9<Key, Value>.b f38108c;
        private x9<Key, Value>.b d;

        private b(Key key, Value value) {
            this.f38107a = key;
            this.b = value;
        }
    }

    public x9(int i) {
        this.f38105a = i;
    }

    private void a(x9<Key, Value>.b bVar) {
        if (bVar == null || this.f38106c == bVar) {
            return;
        }
        x9<Key, Value>.b bVar2 = this.b;
        if (bVar2 == bVar) {
            x9<Key, Value>.b bVar3 = ((b) bVar2).d;
            this.b = bVar3;
            ((b) bVar3).f38108c = null;
        } else {
            ((b) bVar).f38108c.d = ((b) bVar).d;
            ((b) bVar).d.f38108c = ((b) bVar).f38108c;
        }
        ((b) this.f38106c).d = bVar;
        ((b) bVar).f38108c = this.f38106c;
        this.f38106c = bVar;
        ((b) bVar).d = null;
    }

    private x9<Key, Value>.b b(Key key) {
        x9<Key, Value>.b bVar = this.b;
        while (true) {
            x9<Key, Value>.b bVar2 = bVar;
            if (bVar2 == null) {
                return null;
            }
            if (((b) bVar2).f38107a.equals(key)) {
                return bVar2;
            }
            bVar = ((b) bVar2).d;
        }
    }

    private boolean d() {
        x9<Key, Value>.b bVar = this.b;
        x9<Key, Value>.b bVar2 = ((b) bVar).d;
        this.b = bVar2;
        ((b) bVar2).f38108c = null;
        Object obj = ((b) bVar).f38107a;
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (this.d.remove(obj) != null) {
            z = true;
        }
        return z;
    }

    public Value a(Key key) {
        x9<Key, Value>.b bVar = this.d.get(key);
        if (bVar == null) {
            return null;
        }
        a((b) bVar);
        return (Value) ((b) bVar).b;
    }

    public void a() {
        this.d.clear();
        this.f38106c = null;
        this.b = null;
    }

    public void a(Key key, Value value) {
        if (this.d.containsKey(key)) {
            x9<Key, Value>.b b2 = b(key);
            if (b2 != null) {
                a((b) b2);
                return;
            }
            return;
        }
        if (this.d.size() >= this.f38105a) {
            d();
        }
        x9<Key, Value>.b bVar = new b(key, value);
        x9<Key, Value>.b bVar2 = this.f38106c;
        if (bVar2 == null) {
            this.f38106c = bVar;
            this.b = bVar;
        } else {
            ((b) bVar2).d = bVar;
            ((b) bVar).f38108c = this.f38106c;
            this.f38106c = bVar;
        }
        this.d.put(key, bVar);
    }

    public boolean b() {
        return this.d.isEmpty();
    }

    public boolean c() {
        return d();
    }

    public boolean c(Key key) {
        return this.d.remove(key) != null;
    }

    public int e() {
        return this.d.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        x9<Key, Value>.b bVar = this.b;
        if (((b) bVar).f38108c != null) {
            System.out.println("header的pre不为NULL!");
        }
        sb.append("header: \n");
        while (bVar != null) {
            sb.append(((b) bVar).f38107a + "->");
            bVar = ((b) bVar).d;
        }
        sb.append("\ntail: \n");
        x9<Key, Value>.b bVar2 = this.f38106c;
        x9<Key, Value>.b bVar3 = bVar2;
        if (((b) bVar2).d != null) {
            System.out.println("tail的next不为NULL!");
            bVar3 = bVar2;
        }
        while (bVar3 != null) {
            sb.append(((b) bVar3).f38107a + "<-");
            bVar3 = ((b) bVar3).f38108c;
        }
        sb.append("\n");
        return sb.toString();
    }
}
