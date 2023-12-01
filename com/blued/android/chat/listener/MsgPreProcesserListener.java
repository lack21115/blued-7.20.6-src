package com.blued.android.chat.listener;

import com.blued.android.chat.model.ChattingModel;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/listener/MsgPreProcesserListener.class */
public interface MsgPreProcesserListener {
    void onProcessToSave(ChattingModel chattingModel);

    void onProcessToSend(ChattingModel chattingModel);
}
