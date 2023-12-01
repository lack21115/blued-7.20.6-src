package com.igexin.push.core.g;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/g/a.class */
public abstract class a<T> {
    public final a<T> a(final a<? super T> aVar) {
        return new a<T>() { // from class: com.igexin.push.core.g.a.1
            @Override // com.igexin.push.core.g.a
            public final void a(T t) {
                a.this.a((a) t);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a((a) t);
                }
            }
        };
    }

    public abstract void a(T t);
}
