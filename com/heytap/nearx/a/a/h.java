package com.heytap.nearx.a.a;

import com.heytap.nearx.a.a.e;
import com.heytap.nearx.a.a.i;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/heytap/nearx/a/a/h.class */
public final class h<E extends i> extends e<E> {
    private final Class<E> r;
    private Method s;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Class<E> cls) {
        super(a.VARINT, cls);
        this.r = cls;
    }

    private Method b() {
        Method method = this.s;
        if (method != null) {
            return method;
        }
        try {
            Method method2 = this.r.getMethod("fromValue", Integer.TYPE);
            this.s = method2;
            return method2;
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    public int a(E e) {
        return g.c(e.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.heytap.nearx.a.a.e
    public /* bridge */ /* synthetic */ int a(Object obj) {
        return a((h<E>) ((i) obj));
    }

    public void a(g gVar, E e) throws IOException {
        gVar.g(e.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.heytap.nearx.a.a.e
    public /* bridge */ /* synthetic */ void a(g gVar, Object obj) throws IOException {
        a(gVar, (g) ((i) obj));
    }

    @Override // com.heytap.nearx.a.a.e
    /* renamed from: b */
    public E a(f fVar) throws IOException {
        int f = fVar.f();
        try {
            E e = (E) b().invoke(null, Integer.valueOf(f));
            if (e != null) {
                return e;
            }
            throw new e.a(f, this.r);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof h) && ((h) obj).r == this.r;
    }

    public int hashCode() {
        return this.r.hashCode();
    }
}
