package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fh.class */
public final /* synthetic */ class fh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f26690a;

    private fh(UGCMediaListSource uGCMediaListSource) {
        this.f26690a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new fh(uGCMediaListSource);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26690a.initialize();
    }
}
