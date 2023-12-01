package com.tencent.ugc;

import com.tencent.ugc.TXVideoJoiner;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cg.class */
final /* synthetic */ class cg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner.AnonymousClass3 f40289a;
    private final float b;

    private cg(TXVideoJoiner.AnonymousClass3 anonymousClass3, float f) {
        this.f40289a = anonymousClass3;
        this.b = f;
    }

    public static Runnable a(TXVideoJoiner.AnonymousClass3 anonymousClass3, float f) {
        return new cg(anonymousClass3, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoJoiner.this.notifyJoinProgress(this.b);
    }
}
