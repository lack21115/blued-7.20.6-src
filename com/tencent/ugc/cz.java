package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cz.class */
public final /* synthetic */ class cz implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f40311a;

    private cz(UGCMediaListSource uGCMediaListSource) {
        this.f40311a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new cz(uGCMediaListSource);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40311a.loadNextAudioFrameInternal(5L);
    }
}
