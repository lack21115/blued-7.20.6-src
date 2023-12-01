package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/dc.class */
public final /* synthetic */ class dc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f40317a;

    private dc(UGCMediaListSource uGCMediaListSource) {
        this.f40317a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new dc(uGCMediaListSource);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40317a.resetReadPositionInternal();
    }
}
