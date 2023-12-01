package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/dk.class */
public final /* synthetic */ class dk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f26634a;

    private dk(UGCMediaListSource uGCMediaListSource) {
        this.f26634a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new dk(uGCMediaListSource);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26634a.loadNextVideoFrameInternal(5L);
    }
}
