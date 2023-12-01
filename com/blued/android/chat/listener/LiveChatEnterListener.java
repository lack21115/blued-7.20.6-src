package com.blued.android.chat.listener;

import com.blued.android.chat.data.LiveChatInitData;
import com.blued.android.chat.data.LiveChatStatistics;
import com.blued.android.chat.data.LiveEnterFailedReason;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/listener/LiveChatEnterListener.class */
public interface LiveChatEnterListener {
    void onEnterFailed(LiveEnterFailedReason liveEnterFailedReason, LiveChatStatistics liveChatStatistics);

    void onEnterSuccess(short s, long j, LiveChatInitData liveChatInitData, Map<String, Object> map);
}
