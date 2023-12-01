package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/dz.class */
final /* synthetic */ class dz implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMultiFileAudioFrameProvider f40340a;

    private dz(UGCMultiFileAudioFrameProvider uGCMultiFileAudioFrameProvider) {
        this.f40340a = uGCMultiFileAudioFrameProvider;
    }

    public static Runnable a(UGCMultiFileAudioFrameProvider uGCMultiFileAudioFrameProvider) {
        return new dz(uGCMultiFileAudioFrameProvider);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40340a.readFrameToQueue();
    }
}
