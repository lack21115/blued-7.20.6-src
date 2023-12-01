package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.ah;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/ap.class */
final /* synthetic */ class ap implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ah.AnonymousClass1 f23187a;

    private ap(ah.AnonymousClass1 anonymousClass1) {
        this.f23187a = anonymousClass1;
    }

    public static Runnable a(ah.AnonymousClass1 anonymousClass1) {
        return new ap(anonymousClass1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ah.this.m.a();
    }
}
