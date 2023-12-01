package com.blued.android.chat.listener;

import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/listener/ChatTipsListener.class */
public interface ChatTipsListener {
    void onBusyCalling(long j);

    void onConnectException(String str);

    void onDisconnect(int i, String str);

    void onReceiveNotification(ChattingModel chattingModel);

    void onRecvNewMsg(SessionModel sessionModel, ChattingModel chattingModel);

    void onSendMsgFailed(short s, long j, int i, long j2, long j3, int i2);

    void onSendMsgFailed(short s, long j, String str);

    void onSendMsgSucceed(ChattingModel chattingModel);

    void onVideoCalling(long j, int i);

    void onVideoCallingCancel(long j, int i);
}
