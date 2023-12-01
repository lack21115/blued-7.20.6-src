package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/dk.class */
public final /* synthetic */ class dk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f40325a;

    private dk(UGCMediaListSource uGCMediaListSource) {
        this.f40325a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new dk(uGCMediaListSource);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40325a.loadNextVideoFrameInternal(5L);
    }
}
