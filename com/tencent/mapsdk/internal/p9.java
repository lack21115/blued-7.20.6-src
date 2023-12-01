package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.k9;
import com.tencent.mapsdk.internal.n9;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/p9.class */
public class p9<D extends n9> extends u9<D> implements k9<D> {
    private ArrayList<m9<D>> b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private boolean f23995c = true;

    private void a(String str, D d, List<m9<D>> list) {
        for (m9<D> m9Var : list) {
            if (m9Var instanceof t9) {
                ((t9) m9Var).g().b(str, (String) d);
            } else {
                m9Var.a(str, (String) d);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.m9, com.tencent.mapsdk.internal.t9
    public long a() {
        Iterator<m9<D>> it = this.b.iterator();
        long j = 0;
        while (it.hasNext()) {
            m9<D> next = it.next();
            if (next != null) {
                j += next instanceof t9 ? ((t9) next).g().a() : next.a();
            }
        }
        return j;
    }

    public m9<D> a(int i) {
        if (i >= this.b.size()) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // com.tencent.mapsdk.internal.m9
    public D a(String str, Class<D> cls) {
        D d;
        ArrayList arrayList = new ArrayList();
        Iterator<m9<D>> it = this.b.iterator();
        D d2 = null;
        while (true) {
            d = d2;
            if (!it.hasNext()) {
                break;
            }
            m9<D> next = it.next();
            if (next != null) {
                d = next instanceof t9 ? ((t9) next).g().b(str, cls) : next.a(str, cls);
                if (d != null && d.a() > 0) {
                    na.c(ma.f, "从[" + next + "]缓存中获取数据成功");
                    break;
                }
                d2 = d;
                if (this.f23995c) {
                    ra.b(ma.o, str, (Object) ("back to fill " + next));
                    arrayList.add(next);
                    d2 = d;
                }
            }
        }
        if (d != null && d.a() > 0 && !arrayList.isEmpty()) {
            a(str, (String) d, (List<m9<String>>) arrayList);
        }
        ra.a(ma.o, str, "get data length", Integer.valueOf(d == null ? 0 : d.a()));
        ra.f(ma.o, str);
        return d;
    }

    @Override // com.tencent.mapsdk.internal.k9
    public void a(k9.a<Long> aVar) {
        Iterator<m9<D>> it = this.b.iterator();
        while (it.hasNext()) {
            m9<D> next = it.next();
            if (next != null) {
                if (next instanceof k9) {
                    ((k9) next).d().a(aVar);
                } else if (next instanceof t9) {
                    t9<D> g = ((t9) next).g();
                    if (aVar != null) {
                        aVar.callback(Long.valueOf(g.a()));
                    }
                } else if (aVar != null) {
                    aVar.callback(Long.valueOf(next.a()));
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.k9
    public void a(String str, k9.a<Boolean> aVar) {
        Iterator<m9<D>> it = this.b.iterator();
        while (it.hasNext()) {
            m9<D> next = it.next();
            if (next != null) {
                if (next instanceof k9) {
                    ((k9) next).d().a(str, aVar);
                } else if (next instanceof t9) {
                    t9<D> g = ((t9) next).g();
                    if (aVar != null) {
                        aVar.callback(Boolean.valueOf(g.a(str)));
                    }
                } else if (aVar != null) {
                    aVar.callback(Boolean.valueOf(next.remove(str)));
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.m9
    public void a(String str, D d) {
        ra.a(ma.o, str, "put to cacheSet");
        ra.a(ma.p, str, "put data length", Integer.valueOf(d == null ? 0 : d.a()));
        Iterator<m9<D>> it = this.b.iterator();
        while (it.hasNext()) {
            m9<D> next = it.next();
            if (next != null) {
                if (next instanceof t9) {
                    ((t9) next).g().b(str, (String) d);
                } else {
                    next.a(str, (String) d);
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.k9
    public void a(String str, D d, k9.a<Boolean> aVar) {
        Iterator<m9<D>> it = this.b.iterator();
        while (it.hasNext()) {
            m9<D> next = it.next();
            if (next != null) {
                if (next instanceof k9) {
                    ((k9) next).d().a(str, (String) d, aVar);
                } else if (next instanceof t9) {
                    ((t9) next).g().b(str, (String) d);
                    if (aVar != null) {
                        aVar.callback(Boolean.TRUE);
                    }
                } else {
                    next.a(str, (String) d);
                    if (aVar != null) {
                        aVar.callback(Boolean.TRUE);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.k9
    public void a(String str, Class<D> cls, k9.a<D> aVar) {
        Iterator<m9<D>> it = this.b.iterator();
        while (it.hasNext()) {
            m9<D> next = it.next();
            if (next != null) {
                if (next instanceof k9) {
                    ((k9) next).d().a(str, cls, aVar);
                } else if (next instanceof t9) {
                    t9<D> g = ((t9) next).g();
                    if (aVar != null) {
                        aVar.callback(g.b(str, cls));
                    }
                } else if (aVar != null) {
                    aVar.callback(next.a(str, cls));
                }
            }
        }
    }

    public void a(boolean z) {
        this.f23995c = z;
    }

    public final void a(m9<D>... m9VarArr) {
        this.b.addAll(Arrays.asList(m9VarArr));
    }

    @Override // com.tencent.mapsdk.internal.k9
    public void b(k9.a<Long> aVar) {
        Iterator<m9<D>> it = this.b.iterator();
        while (it.hasNext()) {
            m9<D> next = it.next();
            if (next != null) {
                if (next instanceof k9) {
                    ((k9) next).d().b(aVar);
                } else if (next instanceof t9) {
                    t9<D> g = ((t9) next).g();
                    if (aVar != null) {
                        aVar.callback(Long.valueOf(g.e()));
                    }
                } else if (aVar != null) {
                    aVar.callback(Long.valueOf(next.f()));
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.k9
    public void c(k9.a<Boolean> aVar) {
        Iterator<m9<D>> it = this.b.iterator();
        while (it.hasNext()) {
            m9<D> next = it.next();
            if (next != null) {
                if (next instanceof k9) {
                    ((k9) next).d().c(aVar);
                } else if (next instanceof t9) {
                    ((t9) next).g().b();
                    if (aVar != null) {
                        aVar.callback(Boolean.TRUE);
                    }
                } else {
                    next.clear();
                    if (aVar != null) {
                        aVar.callback(Boolean.TRUE);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.m9
    public void clear() {
        Iterator<m9<D>> it = this.b.iterator();
        while (it.hasNext()) {
            m9<D> next = it.next();
            if (next != null) {
                if (next instanceof t9) {
                    ((t9) next).g().b();
                } else {
                    next.clear();
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.k9
    public k9<D> d() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.k9
    public void d(k9.a<Long> aVar) {
        Iterator<m9<D>> it = this.b.iterator();
        while (it.hasNext()) {
            m9<D> next = it.next();
            if (next != null) {
                if (next instanceof k9) {
                    ((k9) next).d().d(aVar);
                } else if (next instanceof t9) {
                    t9<D> g = ((t9) next).g();
                    if (aVar != null) {
                        aVar.callback(Long.valueOf(g.c()));
                    }
                } else if (aVar != null) {
                    aVar.callback(Long.valueOf(next.getCount()));
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.m9
    public long f() {
        Iterator<m9<D>> it = this.b.iterator();
        long j = 0;
        while (it.hasNext()) {
            m9<D> next = it.next();
            if (next != null) {
                j += next instanceof t9 ? ((t9) next).g().e() : next.f();
            }
        }
        return j;
    }

    @Override // com.tencent.mapsdk.internal.m9
    public long getCount() {
        Iterator<m9<D>> it = this.b.iterator();
        long j = 0;
        while (it.hasNext()) {
            m9<D> next = it.next();
            if (next != null) {
                j += next instanceof t9 ? ((t9) next).g().c() : next.getCount();
            }
        }
        return j;
    }

    @Override // com.tencent.mapsdk.internal.m9
    public boolean remove(String str) {
        Iterator<m9<D>> it = this.b.iterator();
        boolean z = true;
        while (it.hasNext()) {
            m9<D> next = it.next();
            if (next != null) {
                z = next instanceof t9 ? ((t9) next).g().a(str) : next.remove(str);
            }
        }
        return z;
    }
}
