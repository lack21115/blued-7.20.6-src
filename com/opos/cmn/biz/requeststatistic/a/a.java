package com.opos.cmn.biz.requeststatistic.a;

import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/requeststatistic/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private b f24673a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f24674c;
    private volatile long d;
    private volatile long e;
    private InterfaceC0631a f;
    private Object g;

    /* renamed from: com.opos.cmn.biz.requeststatistic.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/requeststatistic/a/a$a.class */
    public interface InterfaceC0631a {
        void a();

        void b();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/requeststatistic/a/a$b.class */
    public interface b {
        void a(InterfaceC0631a interfaceC0631a);
    }

    public a(b bVar) {
        this(bVar, 0);
    }

    public a(b bVar, int i) {
        this.d = -1L;
        this.e = -1L;
        this.g = new Object();
        this.f24673a = bVar;
        this.b = Integer.MAX_VALUE;
        this.f24674c = i;
    }

    static /* synthetic */ void a(a aVar, InterfaceC0631a interfaceC0631a) {
        if (interfaceC0631a == aVar.f) {
            synchronized (aVar.g) {
                if (aVar.f == interfaceC0631a) {
                    aVar.d = -1L;
                    aVar.e = SystemClock.elapsedRealtime();
                    aVar.f = null;
                }
            }
        }
    }

    public final void a() {
        if (this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) {
            if (this.e <= 0 || this.f24674c <= SystemClock.elapsedRealtime() - this.e) {
                synchronized (this.g) {
                    if ((this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) && (this.e <= 0 || this.f24674c <= SystemClock.elapsedRealtime() - this.e)) {
                        this.d = SystemClock.elapsedRealtime();
                        this.e = -1L;
                        InterfaceC0631a interfaceC0631a = new InterfaceC0631a() { // from class: com.opos.cmn.biz.requeststatistic.a.a.1
                            @Override // com.opos.cmn.biz.requeststatistic.a.a.InterfaceC0631a
                            public final void a() {
                                a.a(a.this, this);
                            }

                            @Override // com.opos.cmn.biz.requeststatistic.a.a.InterfaceC0631a
                            public final void b() {
                                a.a(a.this, this);
                            }
                        };
                        this.f = interfaceC0631a;
                        this.f24673a.a(interfaceC0631a);
                    }
                }
            }
        }
    }
}
