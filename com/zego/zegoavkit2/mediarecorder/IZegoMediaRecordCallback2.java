package com.zego.zegoavkit2.mediarecorder;

import com.zego.zegoavkit2.entities.ZegoPublishStreamQuality;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/mediarecorder/IZegoMediaRecordCallback2.class */
public interface IZegoMediaRecordCallback2 extends IZegoMediaRecordCallbackBase {
    void onRecordStatusUpdate(ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, String str, long j, long j2, ZegoPublishStreamQuality zegoPublishStreamQuality);
}
