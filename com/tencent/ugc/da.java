package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/da.class */
public final /* synthetic */ class da implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f26623a;

    private da(UGCMediaListSource uGCMediaListSource) {
        this.f26623a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new da(uGCMediaListSource);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26623a.loadNextVideoFrameInternal(5L);
    }
}
