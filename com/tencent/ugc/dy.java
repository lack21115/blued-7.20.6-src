package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/dy.class */
final /* synthetic */ class dy implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMultiFileAudioFrameProvider f40339a;
    private final long b;

    private dy(UGCMultiFileAudioFrameProvider uGCMultiFileAudioFrameProvider, long j) {
        this.f40339a = uGCMultiFileAudioFrameProvider;
        this.b = j;
    }

    public static Runnable a(UGCMultiFileAudioFrameProvider uGCMultiFileAudioFrameProvider, long j) {
        return new dy(uGCMultiFileAudioFrameProvider, j);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCMultiFileAudioFrameProvider.lambda$seekTo$2(this.f40339a, this.b);
    }
}
