package com.tencent.ugc;

import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXAudioFrame.class */
public class TXAudioFrame {
    private ByteBuffer mByteBuffer;
    private int mLength;

    public ByteBuffer getByteBuffer() {
        return this.mByteBuffer;
    }

    public int getLength() {
        return this.mLength;
    }

    public void setByteBuffer(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
    }

    public void setLength(int i) {
        this.mLength = i;
    }
}
