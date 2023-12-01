package com.tencent.ugc;

import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCAudioFrameProvider.class */
public interface UGCAudioFrameProvider {
    public static final List<AudioFrame> END_OF_STREAM = new LinkedList();

    UGCFrameQueue<List<AudioFrame>> getFrameQueue();

    void initialize();

    void seekTo(long j);

    void start();

    void stop();

    void uninitialize();
}
