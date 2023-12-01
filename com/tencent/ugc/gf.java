package com.tencent.ugc;

import com.tencent.ugc.UGCVideoProcessor;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/gf.class */
final /* synthetic */ class gf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor.AnonymousClass1 f40414a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f40415c;

    private gf(UGCVideoProcessor.AnonymousClass1 anonymousClass1, int i, int i2) {
        this.f40414a = anonymousClass1;
        this.b = i;
        this.f40415c = i2;
    }

    public static Runnable a(UGCVideoProcessor.AnonymousClass1 anonymousClass1, int i, int i2) {
        return new gf(anonymousClass1, i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCVideoProcessor.AnonymousClass1.a(this.f40414a, this.b, this.f40415c);
    }
}
