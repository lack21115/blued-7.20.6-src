package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/gq.class */
final /* synthetic */ class gq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDemuxerFFmpeg f26736a;

    private gq(VideoDemuxerFFmpeg videoDemuxerFFmpeg) {
        this.f26736a = videoDemuxerFFmpeg;
    }

    public static Runnable a(VideoDemuxerFFmpeg videoDemuxerFFmpeg) {
        return new gq(videoDemuxerFFmpeg);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26736a.getNextEncodeVideoFrameInternal();
    }
}
