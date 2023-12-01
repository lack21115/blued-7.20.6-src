package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.n9;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/m9.class */
public interface m9<D extends n9> {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/m9$a.class */
    public interface a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f23950a = -1;

        int a();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/m9$b.class */
    public interface b<T> {
        boolean a(T t);
    }

    long a();

    D a(String str, Class<D> cls);

    void a(String str, D d);

    void clear();

    long f();

    long getCount();

    boolean remove(String str);
}
