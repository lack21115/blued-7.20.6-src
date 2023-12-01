package com.zego.zegoavkit2;

import com.zego.zegoavkit2.entities.VideoFrame;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/IZegoMediaPlayerVideoPlayWithIndexCallback2.class */
public interface IZegoMediaPlayerVideoPlayWithIndexCallback2 {
    int dequeueInputBuffer(int i, int i2, int[] iArr, int[] iArr2, int i3);

    VideoFrame getInputBuffer(int i, int i2);

    void queueInputBuffer(int i, ZegoVideoDataFormat zegoVideoDataFormat, int i2);
}
