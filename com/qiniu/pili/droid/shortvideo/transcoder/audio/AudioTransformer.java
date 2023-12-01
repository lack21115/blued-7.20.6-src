package com.qiniu.pili.droid.shortvideo.transcoder.audio;

import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/transcoder/audio/AudioTransformer.class */
public class AudioTransformer {
    public native void destroy(long j);

    public native long init(int i, int i2, int i3, int i4, int i5, int i6);

    public native int resample(long j, ByteBuffer byteBuffer, int i, int i2, ByteBuffer byteBuffer2, int i3, int i4);
}
