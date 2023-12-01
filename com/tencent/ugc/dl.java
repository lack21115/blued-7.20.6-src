package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/dl.class */
public final /* synthetic */ class dl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f40326a;

    private dl(UGCMediaListSource uGCMediaListSource) {
        this.f40326a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new dl(uGCMediaListSource);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40326a.prePareNextUGCPixelFrameProvider();
    }
}
