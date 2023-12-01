package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fs.class */
public final /* synthetic */ class fs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f26703a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f26704c;

    private fs(UGCVideoProcessor uGCVideoProcessor, int i, int i2) {
        this.f26703a = uGCVideoProcessor;
        this.b = i;
        this.f26704c = i2;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, int i, int i2) {
        return new fs(uGCVideoProcessor, i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCVideoProcessor.lambda$setBeautyFilter$10(this.f26703a, this.b, this.f26704c);
    }
}
