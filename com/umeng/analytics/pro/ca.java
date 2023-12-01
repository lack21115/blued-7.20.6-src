package com.umeng.analytics.pro;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.ca;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ca.class */
public abstract class ca<T extends ca<?, ?>, F extends bx> implements bq<T, F> {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<? extends cx>, cy> f26987c;

    /* renamed from: a  reason: collision with root package name */
    protected Object f26988a;
    protected F b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ca$a.class */
    public static class a extends cz<ca> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: a */
        public void b(cp cpVar, ca caVar) throws bw {
            caVar.b = null;
            caVar.f26988a = null;
            cpVar.j();
            ck l = cpVar.l();
            caVar.f26988a = caVar.a(cpVar, l);
            if (caVar.f26988a != null) {
                caVar.b = (F) caVar.a(l.f27009c);
            }
            cpVar.m();
            cpVar.l();
            cpVar.k();
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: b */
        public void a(cp cpVar, ca caVar) throws bw {
            if (caVar.a() == null || caVar.b() == null) {
                throw new cq("Cannot write a TUnion with no set value!");
            }
            cpVar.a(caVar.d());
            cpVar.a(caVar.c(caVar.b));
            caVar.a(cpVar);
            cpVar.c();
            cpVar.d();
            cpVar.b();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ca$b.class */
    static class b implements cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ca$c.class */
    public static class c extends da<ca> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: a */
        public void b(cp cpVar, ca caVar) throws bw {
            caVar.b = null;
            caVar.f26988a = null;
            short v = cpVar.v();
            caVar.f26988a = caVar.a(cpVar, v);
            if (caVar.f26988a != null) {
                caVar.b = (F) caVar.a(v);
            }
        }

        @Override // com.umeng.analytics.pro.cx
        /* renamed from: b */
        public void a(cp cpVar, ca caVar) throws bw {
            if (caVar.a() == null || caVar.b() == null) {
                throw new cq("Cannot write a TUnion with no set value!");
            }
            cpVar.a(caVar.b.a());
            caVar.b(cpVar);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ca$d.class */
    static class d implements cy {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f26987c = hashMap;
        hashMap.put(cz.class, new b());
        f26987c.put(da.class, new d());
    }

    protected ca() {
        this.b = null;
        this.f26988a = null;
    }

    protected ca(F f, Object obj) {
        a((ca<T, F>) f, obj);
    }

    protected ca(ca<T, F> caVar) {
        if (!caVar.getClass().equals(getClass())) {
            throw new ClassCastException();
        }
        this.b = caVar.b;
        this.f26988a = a(caVar.f26988a);
    }

    private static Object a(Object obj) {
        if (obj instanceof bq) {
            return ((bq) obj).deepCopy();
        }
        if (obj instanceof ByteBuffer) {
            return br.d((ByteBuffer) obj);
        }
        if (obj instanceof List) {
            return a((List) obj);
        }
        if (obj instanceof Set) {
            return a((Set) obj);
        }
        Map map = obj;
        if (obj instanceof Map) {
            map = a((Map<Object, Object>) obj);
        }
        return map;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Object obj : list) {
            arrayList.add(a(obj));
        }
        return arrayList;
    }

    private static Map a(Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            hashMap.put(a(entry.getKey()), a(entry.getValue()));
        }
        return hashMap;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        for (Object obj : set) {
            hashSet.add(a(obj));
        }
        return hashSet;
    }

    public F a() {
        return this.b;
    }

    protected abstract F a(short s);

    public Object a(int i) {
        return a((ca<T, F>) a((short) i));
    }

    public Object a(F f) {
        if (f == this.b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f + " because union's set field is " + this.b);
    }

    protected abstract Object a(cp cpVar, ck ckVar) throws bw;

    protected abstract Object a(cp cpVar, short s) throws bw;

    public void a(int i, Object obj) {
        a((ca<T, F>) a((short) i), obj);
    }

    public void a(F f, Object obj) {
        b(f, obj);
        this.b = f;
        this.f26988a = obj;
    }

    protected abstract void a(cp cpVar) throws bw;

    public Object b() {
        return this.f26988a;
    }

    protected abstract void b(F f, Object obj) throws ClassCastException;

    protected abstract void b(cp cpVar) throws bw;

    public boolean b(int i) {
        return b((ca<T, F>) a((short) i));
    }

    public boolean b(F f) {
        return this.b == f;
    }

    protected abstract ck c(F f);

    public boolean c() {
        return this.b != null;
    }

    @Override // com.umeng.analytics.pro.bq
    public final void clear() {
        this.b = null;
        this.f26988a = null;
    }

    protected abstract cu d();

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        f26987c.get(cpVar.D()).b().b(cpVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(getClass().getSimpleName());
        sb.append(" ");
        if (a() != null) {
            Object b2 = b();
            sb.append(c(a()).f27008a);
            sb.append(":");
            if (b2 instanceof ByteBuffer) {
                br.a((ByteBuffer) b2, sb);
            } else {
                sb.append(b2.toString());
            }
        }
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        f26987c.get(cpVar.D()).b().a(cpVar, this);
    }
}
