package com.zego.zegoliveroom.callback.im;

import com.zego.zegoliveroom.entity.ZegoBigRoomMessage;
import com.zego.zegoliveroom.entity.ZegoRoomMessage;
import com.zego.zegoliveroom.entity.ZegoUserState;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/callback/im/IZegoIMCallback.class */
public interface IZegoIMCallback {
    void onRecvBigRoomMessage(String str, ZegoBigRoomMessage[] zegoBigRoomMessageArr);

    void onRecvRoomMessage(String str, ZegoRoomMessage[] zegoRoomMessageArr);

    void onUpdateOnlineCount(String str, int i);

    void onUserUpdate(ZegoUserState[] zegoUserStateArr, int i, String str);
}
