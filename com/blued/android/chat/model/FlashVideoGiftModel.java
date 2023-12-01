package com.blued.android.chat.model;

import com.blued.android.chat.utils.MsgPackHelper;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/model/FlashVideoGiftModel.class */
public class FlashVideoGiftModel {
    public int addLike;
    public int addTime;
    public String giftIcon;
    public String giftName;
    public String roomId;
    public int totalLike;
    public int totalTime;

    public static FlashVideoGiftModel parseData(Map<String, Object> map) {
        if (map != null) {
            FlashVideoGiftModel flashVideoGiftModel = new FlashVideoGiftModel();
            flashVideoGiftModel.roomId = MsgPackHelper.getStringValue(map, TTLiveConstants.ROOMID_KEY);
            flashVideoGiftModel.addTime = MsgPackHelper.getIntValue(map, "overtime");
            flashVideoGiftModel.addLike = MsgPackHelper.getIntValue(map, "like");
            flashVideoGiftModel.totalTime = MsgPackHelper.getIntValue(map, "total_time");
            flashVideoGiftModel.totalLike = MsgPackHelper.getIntValue(map, "total_like");
            flashVideoGiftModel.giftIcon = MsgPackHelper.getStringValue(map, "gift_icon");
            flashVideoGiftModel.giftName = MsgPackHelper.getStringValue(map, "gift_name");
            return flashVideoGiftModel;
        }
        return null;
    }

    public String toString() {
        return "[roomId:" + this.roomId + ", addTime:" + this.addTime + ", addLike:" + this.addLike + ", totalTime:" + this.totalTime + ", totalLike:" + this.totalLike + ", giftIcon:" + this.giftIcon + ", giftName:" + this.giftName + "]";
    }
}
