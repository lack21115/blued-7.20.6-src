package com.zego.zegoavkit2;

import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/ZegoMediaPlayerFileReader.class */
public interface ZegoMediaPlayerFileReader {
    void close(int i);

    long getSize(int i);

    int open(String str, int i);

    ByteBuffer read(int i, int i2);

    long seek(long j, int i, int i2);
}
