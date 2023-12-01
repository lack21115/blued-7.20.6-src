package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cw.class */
public final /* synthetic */ class cw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f40306a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f40307c;

    private cw(UGCMediaListSource uGCMediaListSource, long j, long j2) {
        this.f40306a = uGCMediaListSource;
        this.b = j;
        this.f40307c = j2;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, long j, long j2) {
        return new cw(uGCMediaListSource, j, j2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCMediaListSource.lambda$setVideoSourceRange$4(this.f40306a, this.b, this.f40307c);
    }
}
