package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ek.class */
final /* synthetic */ class ek implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFileAudioFrameProvider f26665a;

    private ek(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        this.f26665a = uGCSingleFileAudioFrameProvider;
    }

    public static Runnable a(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        return new ek(uGCSingleFileAudioFrameProvider);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26665a.DecodeOrAppendMuteFrame();
    }
}
