package com.blued.android.chat.data;

import com.blued.android.chat.utils.MsgPackHelper;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/data/EntranceData.class */
public class EntranceData {
    public String entranceAnim;
    public String entranceApng;
    public String entranceColor;
    public String entranceContents;
    public String entranceGif;
    public String entranceImage;
    public String entranceMp4;
    public int entrance_cover;
    public long invisibleUid;
    public String rich_apng;
    public int special_icon;
    public ProfileData userData;

    public static EntranceData parseEntranceData(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        EntranceData entranceData = new EntranceData();
        entranceData.entranceContents = MsgPackHelper.getStringValue(map, "contents");
        entranceData.entranceImage = MsgPackHelper.getStringValue(map, "url");
        entranceData.entranceColor = MsgPackHelper.getStringValue(map, "background_color");
        entranceData.entranceAnim = MsgPackHelper.getStringValue(map, "gift_apng");
        entranceData.entranceGif = MsgPackHelper.getStringValue(map, "entrance_gif");
        entranceData.entranceApng = MsgPackHelper.getStringValue(map, "entrance_apng");
        entranceData.entranceMp4 = MsgPackHelper.getStringValue(map, "entrance_mp4");
        entranceData.invisibleUid = MsgPackHelper.getLongValue(map, "true_uid");
        entranceData.rich_apng = MsgPackHelper.getStringValue(map, "rich_apng");
        entranceData.entrance_cover = MsgPackHelper.getIntValue(map, "entrance_cover");
        entranceData.special_icon = MsgPackHelper.getIntValue(map, "special_icon");
        return entranceData;
    }
}
