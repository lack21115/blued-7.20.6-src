package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/dj.class */
public final /* synthetic */ class dj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f26633a;

    private dj(UGCMediaListSource uGCMediaListSource) {
        this.f26633a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new dj(uGCMediaListSource);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26633a.loadNextAudioFrameInternal(5L);
    }
}
