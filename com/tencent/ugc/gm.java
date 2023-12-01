package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/gm.class */
final /* synthetic */ class gm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDemuxerFFmpeg f40423a;

    private gm(VideoDemuxerFFmpeg videoDemuxerFFmpeg) {
        this.f40423a = videoDemuxerFFmpeg;
    }

    public static Runnable a(VideoDemuxerFFmpeg videoDemuxerFFmpeg) {
        return new gm(videoDemuxerFFmpeg);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDemuxerFFmpeg.lambda$close$1(this.f40423a);
    }
}
