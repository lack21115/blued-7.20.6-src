package com.qiniu.pili.droid.streaming;

import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/PLScreenYUVCapturerListener.class */
public interface PLScreenYUVCapturerListener {
    void onError(int i);

    void onFrameAvailable(ByteBuffer byteBuffer, int i, int i2, int i3);

    void onPrepared();

    void onReady();
}
