package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/du.class */
public final /* synthetic */ class du implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f26644a;
    private final boolean b;

    private du(UGCMediaListSource uGCMediaListSource, boolean z) {
        this.f26644a = uGCMediaListSource;
        this.b = z;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, boolean z) {
        return new du(uGCMediaListSource, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCMediaListSource.lambda$setIsMediaSourceOverlapped$3(this.f26644a, this.b);
    }
}
