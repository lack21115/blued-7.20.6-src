package com.tencent.ugc;

import com.tencent.liteav.videobase.common.EncodedVideoFrame;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/VideoDemuxer.class */
public interface VideoDemuxer {
    public static final EncodedVideoFrame END_OF_STREAM = new EncodedVideoFrame();

    void close();

    EncodedVideoFrame getNextEncodeVideoFrame();

    boolean open(String str);

    boolean seek(long j);
}
