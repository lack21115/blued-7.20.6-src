package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/dn.class */
public final /* synthetic */ class dn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f26637a;
    private final int b;

    private dn(UGCMediaListSource uGCMediaListSource, int i) {
        this.f26637a = uGCMediaListSource;
        this.b = i;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, int i) {
        return new dn(uGCMediaListSource, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26637a.mTailWaterMarkDurationMs = this.b * 1000;
    }
}
