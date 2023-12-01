package com.blued.android.chat.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/data/LiveChatInitData.class */
public class LiveChatInitData implements Serializable {
    public int admin_type;
    public List<BadgeData> badges;
    public double beansCount;
    public double beansCurrentCount;
    public String bluedBadgePic;
    public long elapseTimeSec = 0;
    public EntranceData entranceData;
    public String icon;
    public String joinLiveConferenceId;
    public String joinLiveToken;
    public String liveDescription;
    public int liveType;
    public String liveUrl;
    public int live_quic;
    public ProfileData liverProfile;
    public int privateFlag;
    public String publish_url;
    public long rank;
    public int screenPattern;
    public long sessionId;
    public short sessionType;
    public String streamUrl;
    public long topCardCount;
    public String topCardUrl;

    public static List<BadgeData> parseBadgeMap(List<Map<String, Object>> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map<String, Object> map : list) {
            BadgeData badgeData = new BadgeData();
            badgeData.parseBadgeData(map);
            arrayList.add(badgeData);
        }
        return arrayList;
    }
}
