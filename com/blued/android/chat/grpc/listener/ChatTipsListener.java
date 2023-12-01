package com.blued.android.chat.grpc.listener;

import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/grpc/listener/ChatTipsListener.class */
public interface ChatTipsListener extends ConnectListener {
    void onRecvNewMsg(SessionModel sessionModel, ChattingModel chattingModel);

    void onSendMsgFailed(short s, long j, int i);

    void onVideoCallingCancel(long j, int i);
}
