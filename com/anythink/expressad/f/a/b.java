package com.anythink.expressad.f.a;

import android.os.CountDownTimer;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/f/a/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final long f4907a = 1000;
    private long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f4908c;
    private com.anythink.expressad.f.a.a d;
    private a e;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/f/a/b$a.class */
    static final class a extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        private com.anythink.expressad.f.a.a f4909a;

        public a(long j, long j2) {
            super(j, j2);
        }

        final void a(com.anythink.expressad.f.a.a aVar) {
            this.f4909a = aVar;
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j) {
        }
    }

    private b a(long j) {
        long j2 = j;
        if (j < 0) {
            j2 = 1000;
        }
        this.f4908c = j2;
        return this;
    }

    private b a(com.anythink.expressad.f.a.a aVar) {
        this.d = aVar;
        return this;
    }

    private void a() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.cancel();
            this.e = null;
        }
        if (this.f4908c <= 0) {
            this.f4908c = this.b + 1000;
        }
        a aVar2 = new a(this.b, this.f4908c);
        this.e = aVar2;
        aVar2.a(this.d);
    }

    private b b(long j) {
        this.b = j;
        return this;
    }

    private void b() {
        a aVar = this.e;
        if (aVar == null) {
            if (aVar != null) {
                aVar.cancel();
                this.e = null;
            }
            if (this.f4908c <= 0) {
                this.f4908c = this.b + 1000;
            }
            a aVar2 = new a(this.b, this.f4908c);
            this.e = aVar2;
            aVar2.a(this.d);
        }
        this.e.start();
    }

    private void c() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.cancel();
            this.e = null;
        }
    }
}
