package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/gl.class */
final /* synthetic */ class gl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDemuxerFFmpeg f40422a;
    private final String b;

    private gl(VideoDemuxerFFmpeg videoDemuxerFFmpeg, String str) {
        this.f40422a = videoDemuxerFFmpeg;
        this.b = str;
    }

    public static Runnable a(VideoDemuxerFFmpeg videoDemuxerFFmpeg, String str) {
        return new gl(videoDemuxerFFmpeg, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDemuxerFFmpeg.lambda$open$0(this.f40422a, this.b);
    }
}
