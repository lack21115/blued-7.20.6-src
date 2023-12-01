package com.blued.android.chat.listener;

import com.blued.android.chat.data.LiveChatInitData;
import com.blued.android.chat.data.LiveCreateFailedReason;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/listener/LiveChatCreateListener.class */
public interface LiveChatCreateListener {
    void onCreateFailed(LiveCreateFailedReason liveCreateFailedReason, String str);

    void onCreateSuccess(short s, long j, LiveChatInitData liveChatInitData, Map<String, Object> map);
}
