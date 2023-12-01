package com.opos.cmn.an.e;

import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/e/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private b f24492a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f24493c;
    private volatile long d;
    private volatile long e;
    private InterfaceC0618a f;
    private Object g;

    /* renamed from: com.opos.cmn.an.e.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/e/a$a.class */
    public interface InterfaceC0618a {
        void a();

        void b();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/e/a$b.class */
    public interface b {
        void a(InterfaceC0618a interfaceC0618a);
    }

    public a(b bVar) {
        this(bVar, Integer.MAX_VALUE, 0);
    }

    public a(b bVar, int i, int i2) {
        this.d = -1L;
        this.e = -1L;
        this.g = new Object();
        this.f24492a = bVar;
        this.b = i;
        this.f24493c = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InterfaceC0618a interfaceC0618a, boolean z) {
        if (interfaceC0618a != this.f) {
            return;
        }
        synchronized (this.g) {
            if (this.f == interfaceC0618a) {
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
            if (this.e <= 0 || this.f24493c <= SystemClock.elapsedRealtime() - this.e) {
                synchronized (this.g) {
                    if ((this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) && (this.e <= 0 || this.f24493c <= SystemClock.elapsedRealtime() - this.e)) {
                        this.d = SystemClock.elapsedRealtime();
                        this.e = -1L;
                        InterfaceC0618a interfaceC0618a = new InterfaceC0618a() { // from class: com.opos.cmn.an.e.a.1
                            @Override // com.opos.cmn.an.e.a.InterfaceC0618a
                            public void a() {
                                a.this.a(this, true);
                            }

                            @Override // com.opos.cmn.an.e.a.InterfaceC0618a
                            public void b() {
                                a.this.a(this, false);
                            }
                        };
                        this.f = interfaceC0618a;
                        this.f24492a.a(interfaceC0618a);
                    }
                }
            }
        }
    }
}
