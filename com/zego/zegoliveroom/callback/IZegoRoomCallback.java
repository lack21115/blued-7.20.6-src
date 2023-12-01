package com.zego.zegoliveroom.callback;

import com.zego.zegoliveroom.entity.ZegoRoomInfo;
import com.zego.zegoliveroom.entity.ZegoStreamInfo;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/callback/IZegoRoomCallback.class */
public interface IZegoRoomCallback {
    void onDisconnect(int i, String str);

    void onKickOut(int i, String str, String str2);

    void onNetworkQuality(String str, int i, int i2);

    void onReconnect(int i, String str);

    void onRecvCustomCommand(String str, String str2, String str3, String str4);

    void onRoomInfoUpdated(ZegoRoomInfo zegoRoomInfo, String str);

    void onStreamExtraInfoUpdated(ZegoStreamInfo[] zegoStreamInfoArr, String str);

    void onStreamUpdated(int i, ZegoStreamInfo[] zegoStreamInfoArr, String str);

    void onTempBroken(int i, String str);

    void onTokenWillExpired(String str, int i);
}
