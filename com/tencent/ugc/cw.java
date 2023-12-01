package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cw.class */
public final /* synthetic */ class cw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f26615a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f26616c;

    private cw(UGCMediaListSource uGCMediaListSource, long j, long j2) {
        this.f26615a = uGCMediaListSource;
        this.b = j;
        this.f26616c = j2;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, long j, long j2) {
        return new cw(uGCMediaListSource, j, j2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCMediaListSource.lambda$setVideoSourceRange$4(this.f26615a, this.b, this.f26616c);
    }
}
