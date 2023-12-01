package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/df.class */
public final /* synthetic */ class df implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f40320a;
    private final boolean b;

    private df(UGCMediaListSource uGCMediaListSource, boolean z) {
        this.f40320a = uGCMediaListSource;
        this.b = z;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, boolean z) {
        return new df(uGCMediaListSource, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCMediaListSource.lambda$setReverse$11(this.f40320a, this.b);
    }
}
