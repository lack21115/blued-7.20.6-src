package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fk.class */
public final /* synthetic */ class fk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCThumbnailGenerator f40384a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f40385c;

    private fk(UGCThumbnailGenerator uGCThumbnailGenerator, long j, long j2) {
        this.f40384a = uGCThumbnailGenerator;
        this.b = j;
        this.f40385c = j2;
    }

    public static Runnable a(UGCThumbnailGenerator uGCThumbnailGenerator, long j, long j2) {
        return new fk(uGCThumbnailGenerator, j, j2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40384a.mMediaListSource.setVideoSourceRange(this.b, this.f40385c);
    }
}
