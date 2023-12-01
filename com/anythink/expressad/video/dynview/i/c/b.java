package com.anythink.expressad.video.dynview.i.c;

import android.os.CountDownTimer;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/i/c/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final long f5536a = 1000;
    private long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f5537c;
    private com.anythink.expressad.video.dynview.i.c.a d;
    private a e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/i/c/b$a.class */
    public static final class a extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        private com.anythink.expressad.video.dynview.i.c.a f5538a;

        public a(long j, long j2) {
            super(j, j2);
        }

        final void a(com.anythink.expressad.video.dynview.i.c.a aVar) {
            this.f5538a = aVar;
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            com.anythink.expressad.video.dynview.i.c.a aVar = this.f5538a;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j) {
            com.anythink.expressad.video.dynview.i.c.a aVar = this.f5538a;
            if (aVar != null) {
                aVar.a(j);
            }
        }
    }

    private void d() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.cancel();
            this.e = null;
        }
        if (this.f5537c <= 0) {
            this.f5537c = this.b + 1000;
        }
        a aVar2 = new a(this.b, this.f5537c);
        this.e = aVar2;
        aVar2.a(this.d);
    }

    public final b a() {
        this.f5537c = 1000L;
        return this;
    }

    public final b a(long j) {
        this.b = j;
        return this;
    }

    public final b a(com.anythink.expressad.video.dynview.i.c.a aVar) {
        this.d = aVar;
        return this;
    }

    public final void a(long j, com.anythink.expressad.video.dynview.i.c.a aVar) {
        this.b = j;
        this.d = aVar;
        d();
        a aVar2 = this.e;
        if (aVar2 != null) {
            aVar2.start();
        }
    }

    public final void b() {
        if (this.e == null) {
            d();
        }
        this.e.start();
    }

    public final void c() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.cancel();
            this.e = null;
        }
    }
}
