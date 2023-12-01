package com.tencent.ugc;

import java.util.concurrent.Callable;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/gn.class */
final /* synthetic */ class gn implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDemuxerFFmpeg f40424a;
    private final long b;

    private gn(VideoDemuxerFFmpeg videoDemuxerFFmpeg, long j) {
        this.f40424a = videoDemuxerFFmpeg;
        this.b = j;
    }

    public static Callable a(VideoDemuxerFFmpeg videoDemuxerFFmpeg, long j) {
        return new gn(videoDemuxerFFmpeg, j);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return VideoDemuxerFFmpeg.lambda$seek$2(this.f40424a, this.b);
    }
}
