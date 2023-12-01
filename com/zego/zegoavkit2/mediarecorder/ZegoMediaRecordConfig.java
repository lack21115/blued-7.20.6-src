package com.zego.zegoavkit2.mediarecorder;

import android.net.Uri;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/mediarecorder/ZegoMediaRecordConfig.class */
public class ZegoMediaRecordConfig {
    public ZegoMediaRecordChannelIndex channelIndex = ZegoMediaRecordChannelIndex.MAIN;
    public ZegoMediaRecordType recordType = ZegoMediaRecordType.BOTH;
    public Uri storageUri = null;
    public boolean enableStatusCallback = false;
    public int interval = 3000;
    public ZegoMediaRecordFormat recordFormat = ZegoMediaRecordFormat.FLV;
    public boolean isFragment = false;
    public String config = null;
}
