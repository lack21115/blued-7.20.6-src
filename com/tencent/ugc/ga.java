package com.tencent.ugc;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ga.class */
public final /* synthetic */ class ga implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f40406a;
    private final List b;

    /* renamed from: c  reason: collision with root package name */
    private final int f40407c;
    private final int d;

    private ga(UGCVideoProcessor uGCVideoProcessor, List list, int i, int i2) {
        this.f40406a = uGCVideoProcessor;
        this.b = list;
        this.f40407c = i;
        this.d = i2;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, List list, int i, int i2) {
        return new ga(uGCVideoProcessor, list, i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCVideoProcessor.lambda$setSplitScreenList$2(this.f40406a, this.b, this.f40407c, this.d);
    }
}
