package com.tencent.txcopyrightedmedia.impl.utils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/af.class */
public final class af {

    /* renamed from: a  reason: collision with root package name */
    private int f40044a = 0;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private final Object f40045c = new Object();

    public final void a() {
        synchronized (this.f40045c) {
            while (this.b > 0) {
                new StringBuilder("write wait because mWriteReq: ").append(this.b);
                try {
                    this.f40045c.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            new StringBuilder("add wirteReq: ").append(this.b);
            this.b++;
            while (this.f40044a > 0) {
                new StringBuilder("write wait because readReq: ").append(this.f40044a);
                try {
                    this.f40045c.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void b() {
        synchronized (this.f40045c) {
            int i = this.b - 1;
            this.b = i;
            if (i == 0) {
                this.f40045c.notifyAll();
            }
        }
    }
}
