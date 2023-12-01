package com.zego.zegoavkit2;

import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/IZegoMediaPlayerBlockDataCallback.class */
public interface IZegoMediaPlayerBlockDataCallback {
    void OnBlockBegin(String str, int i);

    int OnBlockData(ByteBuffer byteBuffer, int i);
}
