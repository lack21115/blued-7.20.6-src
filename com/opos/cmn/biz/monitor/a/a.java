package com.opos.cmn.biz.monitor.a;

import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private b f10938a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f10939c;
    private InterfaceC0455a f;
    private volatile long d = -1;
    private volatile long e = -1;
    private Object g = new Object();

    /* renamed from: com.opos.cmn.biz.monitor.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/a/a$a.class */
    public interface InterfaceC0455a {
        void a();

        void b();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/a/a$b.class */
    public interface b {
        void a(InterfaceC0455a interfaceC0455a);
    }

    public a(b bVar, int i, int i2) {
        this.f10938a = bVar;
        this.b = i;
        this.f10939c = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InterfaceC0455a interfaceC0455a) {
        if (interfaceC0455a != this.f) {
            return;
        }
        synchronized (this.g) {
            if (this.f == interfaceC0455a) {
                this.d = -1L;
                this.e = SystemClock.elapsedRealtime();
                this.f = null;
            }
        }
    }

    public void a() {
        if (this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) {
            if (this.e <= 0 || this.f10939c <= SystemClock.elapsedRealtime() - this.e) {
                synchronized (this.g) {
                    if ((this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) && (this.e <= 0 || this.f10939c <= SystemClock.elapsedRealtime() - this.e)) {
                        this.d = SystemClock.elapsedRealtime();
                        this.e = -1L;
                        InterfaceC0455a interfaceC0455a = new InterfaceC0455a() { // from class: com.opos.cmn.biz.monitor.a.a.1
                            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0455a
                            public void a() {
                                a.this.a(this);
                            }

                            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0455a
                            public void b() {
                                a.this.a(this);
                            }
                        };
                        this.f = interfaceC0455a;
                        this.f10938a.a(interfaceC0455a);
                    }
                }
            }
        }
    }
}
