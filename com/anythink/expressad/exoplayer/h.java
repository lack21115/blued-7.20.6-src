package com.anythink.expressad.exoplayer;

import android.os.Looper;
import com.anythink.expressad.exoplayer.w;
import com.anythink.expressad.exoplayer.x;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h.class */
public interface h extends w {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final int f4539a = 1;
    @Deprecated
    public static final int b = 2;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final int f4540c = 3;
    @Deprecated
    public static final int d = 4;
    @Deprecated
    public static final int e = 0;
    @Deprecated
    public static final int f = 1;
    @Deprecated
    public static final int g = 2;

    @Deprecated
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h$a.class */
    public interface a extends w.c {
    }

    @Deprecated
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h$b.class */
    public interface b extends x.b {
    }

    @Deprecated
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h$c.class */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final x.b f4596a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f4597c;

        @Deprecated
        private c(x.b bVar, int i, Object obj) {
            this.f4596a = bVar;
            this.b = i;
            this.f4597c = obj;
        }
    }

    Looper a();

    x a(x.b bVar);

    void a(ac acVar);

    void a(com.anythink.expressad.exoplayer.h.s sVar);

    void a(com.anythink.expressad.exoplayer.h.s sVar, boolean z, boolean z2);

    @Deprecated
    void a(c... cVarArr);

    @Deprecated
    void b(c... cVarArr);
}
