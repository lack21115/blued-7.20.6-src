package com.blued.android.chat.data;

import com.blued.android.chat.utils.MsgPackHelper;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/data/RelationProfileData.class */
public class RelationProfileData extends ProfileData {
    public double distance;
    public int is_followed;

    @Override // com.blued.android.chat.data.ProfileData
    public void parseMsgPackData(Map<String, Object> map) {
        super.parseMsgPackData(map);
        if (map != null) {
            this.is_followed = MsgPackHelper.getIntValue(map, "is_followed");
            this.distance = MsgPackHelper.getDoubleValue(map, "distance");
        }
    }
}
