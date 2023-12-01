package com.opos.cmn.i;

import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/i/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private b f24972a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f24973c;
    private volatile long d;
    private volatile long e;
    private InterfaceC0645a f;
    private Object g;

    /* renamed from: com.opos.cmn.i.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/i/a$a.class */
    public interface InterfaceC0645a {
        void a();

        void b();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/i/a$b.class */
    public interface b {
        void a(InterfaceC0645a interfaceC0645a);
    }

    public a(b bVar) {
        this(bVar, Integer.MAX_VALUE, 0);
    }

    public a(b bVar, int i, int i2) {
        this.d = -1L;
        this.e = -1L;
        this.g = new Object();
        this.f24972a = bVar;
        this.b = i;
        this.f24973c = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InterfaceC0645a interfaceC0645a, boolean z) {
        if (interfaceC0645a != this.f) {
            return;
        }
        synchronized (this.g) {
            if (this.f == interfaceC0645a) {
                this.d = -1L;
                if (z) {
                    this.e = SystemClock.elapsedRealtime();
                }
                this.f = null;
            }
        }
    }

    public void a() {
        if (this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) {
            if (this.e <= 0 || this.f24973c <= SystemClock.elapsedRealtime() - this.e) {
                synchronized (this.g) {
                    if ((this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) && (this.e <= 0 || this.f24973c <= SystemClock.elapsedRealtime() - this.e)) {
                        this.d = SystemClock.elapsedRealtime();
                        this.e = -1L;
                        InterfaceC0645a interfaceC0645a = new InterfaceC0645a() { // from class: com.opos.cmn.i.a.1
                            @Override // com.opos.cmn.i.a.InterfaceC0645a
                            public void a() {
                                a.this.a(this, true);
                            }

                            @Override // com.opos.cmn.i.a.InterfaceC0645a
                            public void b() {
                                a.this.a(this, false);
                            }
                        };
                        this.f = interfaceC0645a;
                        this.f24972a.a(interfaceC0645a);
                    }
                }
            }
        }
    }
}
