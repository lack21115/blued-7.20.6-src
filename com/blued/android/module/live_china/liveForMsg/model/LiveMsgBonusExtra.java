package com.blued.android.module.live_china.liveForMsg.model;

import com.android.internal.util.cm.SpamFilter;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.utils.MsgPackHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/liveForMsg/model/LiveMsgBonusExtra.class */
public class LiveMsgBonusExtra {
    public int count;
    public long id;
    public String image;
    public ProfileData profile;

    public static List<LiveMsgBonusExtra> parseBonusMap(List<Map<String, Object>> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map<String, Object> map : list) {
            LiveMsgBonusExtra liveMsgBonusExtra = new LiveMsgBonusExtra();
            liveMsgBonusExtra.parseMsgPackData(map);
            arrayList.add(liveMsgBonusExtra);
        }
        return arrayList;
    }

    public void parseMsgPackData(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.id = MsgPackHelper.getLongValue(map, "id");
        this.count = MsgPackHelper.getIntValue(map, SpamFilter.SpamContract.NotificationTable.COUNT);
        this.image = MsgPackHelper.getStringValue(map, "image");
        ProfileData profileData = new ProfileData();
        this.profile = profileData;
        profileData.parseMsgPackData(MsgPackHelper.getMapValue(map, "profile"));
    }
}
