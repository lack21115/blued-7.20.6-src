package com.blued.android.chat.listener;

import com.blued.android.chat.data.EntranceData;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.chat.data.LiveChatStatistics;
import com.blued.android.chat.data.LiveCloseReason;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.model.ChattingModel;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/listener/LiveChatInfoListener.class */
public interface LiveChatInfoListener {
    void onClose(LiveCloseReason liveCloseReason, LiveChatStatistics liveChatStatistics);

    void onJoinLive(JoinLiveResult joinLiveResult, String str, String str2, String str3);

    void onRecvNewMsg(ChattingModel chattingModel);

    void onViewerDataChanged(long j, List<ProfileData> list);

    void onViewerEntrance(EntranceData entranceData, long j);
}
