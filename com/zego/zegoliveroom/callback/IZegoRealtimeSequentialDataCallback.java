package com.zego.zegoliveroom.callback;

import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/callback/IZegoRealtimeSequentialDataCallback.class */
public interface IZegoRealtimeSequentialDataCallback {
    void onRecvRealtimeSequentialData(ByteBuffer byteBuffer, String str);

    void onSendRealtimeSequentialData(int i, int i2);
}
