package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fs.class */
public final /* synthetic */ class fs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f40394a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f40395c;

    private fs(UGCVideoProcessor uGCVideoProcessor, int i, int i2) {
        this.f40394a = uGCVideoProcessor;
        this.b = i;
        this.f40395c = i2;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, int i, int i2) {
        return new fs(uGCVideoProcessor, i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCVideoProcessor.lambda$setBeautyFilter$10(this.f40394a, this.b, this.f40395c);
    }
}
