package com.qiniu.pili.droid.streaming;

import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/AudioSourceCallback.class */
public interface AudioSourceCallback {
    void onAudioSourceAvailable(ByteBuffer byteBuffer, int i, long j, boolean z);
}
