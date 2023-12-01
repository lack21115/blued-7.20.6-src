package com.opos.cmn.biz.requeststatistic.a;

import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/requeststatistic/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private b f10985a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f10986c;
    private volatile long d;
    private volatile long e;
    private InterfaceC0461a f;
    private Object g;

    /* renamed from: com.opos.cmn.biz.requeststatistic.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/requeststatistic/a/a$a.class */
    public interface InterfaceC0461a {
        void a();

        void b();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/requeststatistic/a/a$b.class */
    public interface b {
        void a(InterfaceC0461a interfaceC0461a);
    }

    public a(b bVar) {
        this(bVar, 0);
    }

    public a(b bVar, int i) {
        this.d = -1L;
        this.e = -1L;
        this.g = new Object();
        this.f10985a = bVar;
        this.b = Integer.MAX_VALUE;
        this.f10986c = i;
    }

    static /* synthetic */ void a(a aVar, InterfaceC0461a interfaceC0461a) {
        if (interfaceC0461a == aVar.f) {
            synchronized (aVar.g) {
                if (aVar.f == interfaceC0461a) {
                    aVar.d = -1L;
                    aVar.e = SystemClock.elapsedRealtime();
                    aVar.f = null;
                }
            }
        }
    }

    public final void a() {
        if (this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) {
            if (this.e <= 0 || this.f10986c <= SystemClock.elapsedRealtime() - this.e) {
                synchronized (this.g) {
                    if ((this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) && (this.e <= 0 || this.f10986c <= SystemClock.elapsedRealtime() - this.e)) {
                        this.d = SystemClock.elapsedRealtime();
                        this.e = -1L;
                        InterfaceC0461a interfaceC0461a = new InterfaceC0461a() { // from class: com.opos.cmn.biz.requeststatistic.a.a.1
                            @Override // com.opos.cmn.biz.requeststatistic.a.a.InterfaceC0461a
                            public final void a() {
                                a.a(a.this, this);
                            }

                            @Override // com.opos.cmn.biz.requeststatistic.a.a.InterfaceC0461a
                            public final void b() {
                                a.a(a.this, this);
                            }
                        };
                        this.f = interfaceC0461a;
                        this.f10985a.a(interfaceC0461a);
                    }
                }
            }
        }
    }
}
