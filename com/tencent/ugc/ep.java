package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ep.class */
final /* synthetic */ class ep implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFileAudioFrameProvider f26670a;
    private final long b;

    private ep(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider, long j) {
        this.f26670a = uGCSingleFileAudioFrameProvider;
        this.b = j;
    }

    public static Runnable a(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider, long j) {
        return new ep(uGCSingleFileAudioFrameProvider, j);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCSingleFileAudioFrameProvider.lambda$seekTo$2(this.f26670a, this.b);
    }
}
