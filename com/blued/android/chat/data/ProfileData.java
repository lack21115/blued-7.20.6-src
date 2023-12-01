package com.blued.android.chat.data;

import com.anythink.core.api.ATCustomRuleKeys;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.utils.MsgPackHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/data/ProfileData.class */
public class ProfileData implements Serializable {
    public int age;
    public String avatar;
    public String avatarPendant;
    public String avatarPendantApng;
    public String avatarPendantHalo;
    public String avatarPendantHaloApng;
    public String avatar_badge;
    public String avatar_frame;
    public int avatar_frame_type;
    public int beansMerchantIdentity;
    public String bluedBadgeImage;
    public int channelType;
    public String citySettled;
    public int height;
    public int hideVipLook;
    public int in_fan_club;
    public long invisibleUid;
    public boolean isLiveManager;
    public String liangId;
    public int liangType;
    public int liveViewerRank;
    public String name;
    public int oFaceStatus;
    public int oVipExpLvl;
    public int oVipGroupType;
    public int ohideVipLook;
    public int ovipGrade;
    public int privilege;
    public int richLevel;
    public String role;
    public long uid;
    public int vBadge;
    public int vipAnnual;
    public int vipExpLvl;
    public int vipGrade;
    public int weight;

    public static ProfileData parseProfile(Map<String, Object> map, String str) {
        Map<String, Object> mapValue = MsgPackHelper.getMapValue(map, str);
        if (mapValue != null) {
            ProfileData profileData = new ProfileData();
            profileData.parseMsgPackData(mapValue);
            return profileData;
        }
        return null;
    }

    public static List<ProfileData> parseProfileList(List<Map<String, Object>> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map<String, Object> map : list) {
            ProfileData profileData = new ProfileData();
            profileData.parseMsgPackData(map);
            arrayList.add(profileData);
        }
        return arrayList;
    }

    public void parseMsgPackData(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.in_fan_club = MsgPackHelper.getIntValue(map, "in_fan_club");
        this.uid = MsgPackHelper.getLongValue(map, "uid");
        this.name = MsgPackHelper.getStringValue(map, "name");
        this.avatar = MsgPackHelper.getStringValue(map, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR);
        this.vBadge = MsgPackHelper.getIntValue(map, ReqAckPackage.REQ_RESPONSE_KEY.VBADGE);
        this.bluedBadgeImage = MsgPackHelper.getStringValue(map, ReqAckPackage.REQ_RESPONSE_KEY.BLUED_BADGE_PIC);
        if (ChatManager.clientType == ChatManager.ClientType.CHINA) {
            this.richLevel = MsgPackHelper.getIntValue(map, "rich_level");
        } else if (ChatManager.clientType == ChatManager.ClientType.INTERNATIONAL) {
            this.richLevel = MsgPackHelper.getIntValue(map, "o_rich_level");
        }
        this.vipGrade = MsgPackHelper.getIntValue(map, ReqAckPackage.REQ_RESPONSE_KEY.VIP_GRADE);
        this.vipAnnual = MsgPackHelper.getIntValue(map, ReqAckPackage.REQ_RESPONSE_KEY.VIP_ANNUAL);
        this.vipExpLvl = MsgPackHelper.getIntValue(map, ReqAckPackage.REQ_RESPONSE_KEY.VIP_EXP_LVL);
        this.hideVipLook = MsgPackHelper.getIntValue(map, ReqAckPackage.REQ_RESPONSE_KEY.IS_HIDE_VIP_LOOK);
        this.ovipGrade = MsgPackHelper.getIntValue(map, ReqAckPackage.REQ_RESPONSE_KEY.O_VIP_GRADE);
        this.oVipExpLvl = MsgPackHelper.getIntValue(map, ReqAckPackage.REQ_RESPONSE_KEY.O_VIP_EXP_LVL);
        this.beansMerchantIdentity = MsgPackHelper.getIntValue(map, ReqAckPackage.REQ_RESPONSE_KEY.BEANS_MERCHANT_IDENTITY);
        this.avatar_badge = MsgPackHelper.getStringValue(map, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR_BADGE);
        this.ohideVipLook = MsgPackHelper.getIntValue(map, ReqAckPackage.REQ_RESPONSE_KEY.O_IS_HIDE_VIP_LOOK);
        this.oFaceStatus = MsgPackHelper.getIntValue(map, ReqAckPackage.REQ_RESPONSE_KEY.O_FACE_STATUS);
        this.oVipGroupType = MsgPackHelper.getIntValue(map, ReqAckPackage.REQ_RESPONSE_KEY.O_VIP_GROUP_TYPE);
        this.height = MsgPackHelper.getIntValue(map, "height");
        this.weight = MsgPackHelper.getIntValue(map, "weight");
        this.role = MsgPackHelper.getStringValue(map, "role");
        this.age = MsgPackHelper.getIntValue(map, ATCustomRuleKeys.AGE);
        this.citySettled = MsgPackHelper.getStringValue(map, "city_settled");
        this.isLiveManager = MsgPackHelper.getIntValue(map, "is_manager") == 1;
        this.channelType = MsgPackHelper.getIntValue(map, "channel_type");
        this.avatarPendant = MsgPackHelper.getStringValue(map, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR_PENDANT);
        this.avatarPendantApng = MsgPackHelper.getStringValue(map, "avatar_pendant_apng");
        this.avatarPendantHalo = MsgPackHelper.getStringValue(map, "avatar_pendant_halo");
        this.avatarPendantHaloApng = MsgPackHelper.getStringValue(map, "avatar_pendant_halo_apng");
        if (MsgPackHelper.getIntValue(map, "is_open_privilege", 0) == 1) {
            this.invisibleUid = MsgPackHelper.getLongValue(map, "true_uid");
        }
        this.liangType = MsgPackHelper.getIntValue(map, "liang_type");
        this.liangId = MsgPackHelper.getStringValue(map, "liang_id");
        this.avatar_frame = MsgPackHelper.getStringValue(map, "avatar_frame");
        this.avatar_frame_type = MsgPackHelper.getIntValue(map, "avatar_frame_type");
    }

    public String toString() {
        return "[uid:" + this.uid + ", name:" + this.name + "]";
    }
}
