package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bo.class */
final /* synthetic */ class bo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer.AnonymousClass4 f40266a;

    private bo(TXVideoEditer.AnonymousClass4 anonymousClass4) {
        this.f40266a = anonymousClass4;
    }

    public static Runnable a(TXVideoEditer.AnonymousClass4 anonymousClass4) {
        return new bo(anonymousClass4);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.AnonymousClass4.a(this.f40266a);
    }
}
