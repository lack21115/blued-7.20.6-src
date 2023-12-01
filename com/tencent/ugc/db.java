package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/db.class */
public final /* synthetic */ class db implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f40315a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f40316c;

    private db(UGCMediaListSource uGCMediaListSource, long j, boolean z) {
        this.f40315a = uGCMediaListSource;
        this.b = j;
        this.f40316c = z;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, long j, boolean z) {
        return new db(uGCMediaListSource, j, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40315a.seekToInternal(this.b, this.f40316c);
    }
}
