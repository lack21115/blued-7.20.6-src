package com.blued.android.chat.data;

import com.blued.android.chat.utils.MsgPackHelper;
import java.io.Serializable;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/data/BadgeData.class */
public class BadgeData implements Serializable {
    public long id;
    public String url;

    public void parseBadgeData(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.id = MsgPackHelper.getLongValue(map, "id");
        this.url = MsgPackHelper.getStringValue(map, "url");
    }
}
