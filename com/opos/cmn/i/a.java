package com.opos.cmn.i;

import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/i/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private b f11284a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f11285c;
    private volatile long d;
    private volatile long e;
    private InterfaceC0475a f;
    private Object g;

    /* renamed from: com.opos.cmn.i.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/i/a$a.class */
    public interface InterfaceC0475a {
        void a();

        void b();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/i/a$b.class */
    public interface b {
        void a(InterfaceC0475a interfaceC0475a);
    }

    public a(b bVar) {
        this(bVar, Integer.MAX_VALUE, 0);
    }

    public a(b bVar, int i, int i2) {
        this.d = -1L;
        this.e = -1L;
        this.g = new Object();
        this.f11284a = bVar;
        this.b = i;
        this.f11285c = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InterfaceC0475a interfaceC0475a, boolean z) {
        if (interfaceC0475a != this.f) {
            return;
        }
        synchronized (this.g) {
            if (this.f == interfaceC0475a) {
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
            if (this.e <= 0 || this.f11285c <= SystemClock.elapsedRealtime() - this.e) {
                synchronized (this.g) {
                    if ((this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) && (this.e <= 0 || this.f11285c <= SystemClock.elapsedRealtime() - this.e)) {
                        this.d = SystemClock.elapsedRealtime();
                        this.e = -1L;
                        InterfaceC0475a interfaceC0475a = new InterfaceC0475a() { // from class: com.opos.cmn.i.a.1
                            @Override // com.opos.cmn.i.a.InterfaceC0475a
                            public void a() {
                                a.this.a(this, true);
                            }

                            @Override // com.opos.cmn.i.a.InterfaceC0475a
                            public void b() {
                                a.this.a(this, false);
                            }
                        };
                        this.f = interfaceC0475a;
                        this.f11284a.a(interfaceC0475a);
                    }
                }
            }
        }
    }
}
