package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/dm.class */
public final /* synthetic */ class dm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f26636a;

    private dm(UGCMediaListSource uGCMediaListSource) {
        this.f26636a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new dm(uGCMediaListSource);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26636a.prePareNextUGCPixelFrameProvider();
    }
}
