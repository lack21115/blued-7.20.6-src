package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bn.class */
final /* synthetic */ class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer.AnonymousClass4 f26574a;
    private final float b;

    private bn(TXVideoEditer.AnonymousClass4 anonymousClass4, float f) {
        this.f26574a = anonymousClass4;
        this.b = f;
    }

    public static Runnable a(TXVideoEditer.AnonymousClass4 anonymousClass4, float f) {
        return new bn(anonymousClass4, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.AnonymousClass4.a(this.f26574a, this.b);
    }
}
