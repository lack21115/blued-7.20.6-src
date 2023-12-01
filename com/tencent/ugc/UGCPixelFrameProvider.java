package com.tencent.ugc;

import com.tencent.liteav.videobase.frame.PixelFrame;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCPixelFrameProvider.class */
public interface UGCPixelFrameProvider {
    public static final List<PixelFrame> END_OF_STREAM = new LinkedList();

    UGCFrameQueue<List<PixelFrame>> getFrameQueue();

    void initialize();

    void seekTo(long j, boolean z);

    void setReverse(boolean z);

    void start();

    void stop();

    void uninitialize();
}
