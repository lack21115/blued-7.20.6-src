package com.blued.android.chat.data;

import com.blued.android.chat.utils.MsgPackHelper;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/data/LiveChatStatistics.class */
public class LiveChatStatistics {
    public String audience_message;
    public int currentExperiencePoints;
    public int elapseTimeSec;
    public int lastExperiencePoints;
    public String message;
    public int reason;
    public int stopReason;
    public String title;
    public int topViewerCount;
    public int totalLikedCount;
    public int totalViewerCount;
    public String wish_list;

    public static LiveChatStatistics parseData(Map<String, Object> map) {
        LiveChatStatistics liveChatStatistics = null;
        if (map == null) {
            return null;
        }
        int intValue = MsgPackHelper.getIntValue(map, "elapse_time");
        if (intValue > 0) {
            liveChatStatistics = new LiveChatStatistics();
            liveChatStatistics.elapseTimeSec = intValue;
            liveChatStatistics.topViewerCount = MsgPackHelper.getIntValue(map, "top_count");
            liveChatStatistics.totalViewerCount = MsgPackHelper.getIntValue(map, "watch_count");
            liveChatStatistics.totalLikedCount = MsgPackHelper.getIntValue(map, "liked_count");
            liveChatStatistics.currentExperiencePoints = MsgPackHelper.getIntValue(map, "current_exp");
            liveChatStatistics.lastExperiencePoints = MsgPackHelper.getIntValue(map, "former_exp");
            liveChatStatistics.stopReason = MsgPackHelper.getIntValue(map, "stop_reason");
            Map mapValue = MsgPackHelper.getMapValue(map, "kick_info");
            liveChatStatistics.reason = MsgPackHelper.getIntValue(mapValue, "reason");
            liveChatStatistics.title = MsgPackHelper.getStringValue(mapValue, "title");
            liveChatStatistics.message = MsgPackHelper.getStringValue(mapValue, "message");
            liveChatStatistics.audience_message = MsgPackHelper.getStringValue(mapValue, "audience_message");
            liveChatStatistics.wish_list = MsgPackHelper.getStringValue(map, "wish_list");
        }
        return liveChatStatistics;
    }
}
