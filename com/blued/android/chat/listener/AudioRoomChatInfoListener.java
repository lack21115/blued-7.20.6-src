package com.blued.android.chat.listener;

import com.blued.android.chat.data.AudioRoomChatData;
import com.blued.android.chat.model.ChattingModel;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/listener/AudioRoomChatInfoListener.class */
public interface AudioRoomChatInfoListener {
    void onAcceptInviteAnchor(AudioRoomChatData audioRoomChatData);

    void onApplyAnchor(AudioRoomChatData audioRoomChatData);

    void onChangeSeatSuccess(AudioRoomChatData audioRoomChatData);

    void onCloseRoom(AudioRoomChatData audioRoomChatData);

    void onInviteAnchor(AudioRoomChatData audioRoomChatData);

    void onKickedOut(ChattingModel chattingModel);

    void onMemebersDecrease(AudioRoomChatData audioRoomChatData);

    void onMemebersIncrease(AudioRoomChatData audioRoomChatData);

    void onModifyRoomTitle(AudioRoomChatData audioRoomChatData);

    void onOffAnchor(AudioRoomChatData audioRoomChatData);

    void onOnAnchor(AudioRoomChatData audioRoomChatData);

    void onRecvNewMsg(ChattingModel chattingModel);

    void onRefuseAnchor(AudioRoomChatData audioRoomChatData);

    void onRefuseInviteAnchor(AudioRoomChatData audioRoomChatData);

    void onSeatDecrease(AudioRoomChatData audioRoomChatData);

    void onSeatIncrease(AudioRoomChatData audioRoomChatData);

    void onSeatOccupancyNotice(AudioRoomChatData audioRoomChatData);

    void onUpdateRoomNotice(AudioRoomChatData audioRoomChatData);
}
