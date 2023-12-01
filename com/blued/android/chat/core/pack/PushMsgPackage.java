package com.blued.android.chat.core.pack;

import android.util.Log;
import com.android.internal.util.cm.NavigationRingConstants;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.utils.BytesUtils;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.MsgPackHelper;
import com.google.gson.Gson;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/PushMsgPackage.class */
public class PushMsgPackage {
    private static final String TAG = "Chat_PushMsgPackage";
    public int app;
    public String avatarPendant;
    public String avatarPendantApng;
    public String avatarPendantHalo;
    public String avatarPendantHaloApng;
    public String avatar_badge;
    public int beansMerchantIdentity;
    public long distance;
    public String fromAvatar;
    public int fromHideVipLook;
    public long fromId;
    public int fromLiveManager;
    public String fromName;
    public int fromVipAnnual;
    public int fromVipExpLvl;
    public int fromVipGrade;
    public int isMatchMsg;
    public String msgAt;
    public String msgContent;
    public long msgId;
    public Map<String, Object> msgMapExtra;
    public short msgType;
    public int oFaceStatus;
    public int ofromHideVipLook;
    public int ofromVipExpLvl;
    public int ofromVipGrade;
    public long previousMsgId;
    private String profileMap;
    public String prompt_type;
    public PushBasePackage pushBasePackage;
    public long sessionId;
    public short sessionType;
    public String session_common_status;
    public int status;
    public String status_img;
    public long time;
    public int vip_group_type;
    public int fromVBadge = -1;
    public int fromOnline = -1;
    public int fromFriend = 0;
    public int fromRichLevel = 0;

    public static ChattingModel toMsgData(PushMsgPackage pushMsgPackage) {
        return ChatHelper.getChattingModelFromPushPackage(pushMsgPackage);
    }

    public boolean isReaded() {
        PushBasePackage pushBasePackage = this.pushBasePackage;
        if (pushBasePackage == null || pushBasePackage.msgHeader == null) {
            return false;
        }
        return this.pushBasePackage.msgHeader.isReaded;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseSubPackageData(byte[] bArr, int i, int i2) {
        this.sessionType = BytesUtils.byteTo1Number(bArr, i);
        int i3 = i + 1;
        this.sessionId = BytesUtils.bytesTo4Number(bArr, i3);
        int i4 = i3 + 4;
        long byteTo8Number = BytesUtils.byteTo8Number(bArr, i4);
        this.msgId = byteTo8Number;
        this.previousMsgId = byteTo8Number - 1;
        int i5 = i4 + 8;
        this.time = BytesUtils.bytesTo4Number(bArr, i5);
        int i6 = i5 + 4;
        this.distance = BytesUtils.bytesTo4Number(bArr, i6);
        int i7 = i6 + 4;
        if (i2 > i7) {
            Map<String, Object> unpackMap = MsgPackHelper.unpackMap(bArr, i7, i2);
            if (unpackMap != null) {
                this.msgType = MsgPackHelper.getShortValue(unpackMap, "type");
                this.fromId = MsgPackHelper.getLongValue(unpackMap, "from");
                String stringValue = MsgPackHelper.getStringValue(unpackMap, "contents_" + ChatManager.languageDetail);
                String str = stringValue;
                if (stringValue == null) {
                    String stringValue2 = MsgPackHelper.getStringValue(unpackMap, "contents_" + ChatManager.language);
                    str = stringValue2;
                    if (stringValue2 == null) {
                        String stringValue3 = MsgPackHelper.getStringValue(unpackMap, "contents_en");
                        str = stringValue3;
                        if (stringValue3 == null) {
                            str = MsgPackHelper.getStringValue(unpackMap, "contents");
                        }
                    }
                }
                if (str != null) {
                    this.msgContent = str;
                }
                this.status = MsgPackHelper.getIntValue(unpackMap, "session_status");
                this.app = MsgPackHelper.getIntValue(unpackMap, NavigationRingConstants.ACTION_APP);
                this.msgAt = MsgPackHelper.getStringValue(unpackMap, "at");
                Map<String, Object> mapValue = MsgPackHelper.getMapValue(unpackMap, "extra");
                this.msgMapExtra = mapValue;
                if (mapValue != null) {
                    try {
                        int floatValue = (int) MsgPackHelper.getFloatValue(mapValue, "is_match_msg");
                        this.isMatchMsg = floatValue;
                        if (floatValue == 0) {
                            this.isMatchMsg = MsgPackHelper.getIntValue(this.msgMapExtra, "is_match_msg");
                        }
                    } catch (Exception e) {
                    }
                }
                this.session_common_status = MsgPackHelper.getStringValue(unpackMap, "session_common_status");
                Map mapValue2 = MsgPackHelper.getMapValue(unpackMap, "profile");
                if (mapValue2 != null) {
                    if (ChatManager.debug) {
                        this.profileMap = new Gson().toJson(mapValue2);
                    }
                    this.fromName = MsgPackHelper.getStringValue(mapValue2, "name");
                    this.fromAvatar = MsgPackHelper.getStringValue(mapValue2, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR);
                    this.fromVBadge = MsgPackHelper.getIntValue(mapValue2, ReqAckPackage.REQ_RESPONSE_KEY.VBADGE);
                    this.fromOnline = MsgPackHelper.getIntValue(mapValue2, "online");
                    this.fromFriend = MsgPackHelper.getIntValue(mapValue2, "friend");
                    if (ChatManager.clientType == ChatManager.ClientType.CHINA) {
                        this.fromRichLevel = MsgPackHelper.getIntValue(mapValue2, "rich_level");
                    } else if (ChatManager.clientType == ChatManager.ClientType.INTERNATIONAL) {
                        this.fromRichLevel = MsgPackHelper.getIntValue(mapValue2, "o_rich_level");
                    }
                    this.fromVipGrade = MsgPackHelper.getIntValue(mapValue2, ReqAckPackage.REQ_RESPONSE_KEY.VIP_GRADE);
                    this.fromVipAnnual = MsgPackHelper.getIntValue(mapValue2, ReqAckPackage.REQ_RESPONSE_KEY.VIP_ANNUAL);
                    this.fromVipExpLvl = MsgPackHelper.getIntValue(mapValue2, ReqAckPackage.REQ_RESPONSE_KEY.VIP_EXP_LVL);
                    this.fromLiveManager = MsgPackHelper.getIntValue(mapValue2, "is_manager");
                    this.fromHideVipLook = MsgPackHelper.getIntValue(mapValue2, ReqAckPackage.REQ_RESPONSE_KEY.IS_HIDE_VIP_LOOK);
                    this.ofromVipGrade = MsgPackHelper.getIntValue(mapValue2, ReqAckPackage.REQ_RESPONSE_KEY.O_VIP_GRADE);
                    this.ofromVipExpLvl = MsgPackHelper.getIntValue(mapValue2, ReqAckPackage.REQ_RESPONSE_KEY.O_VIP_EXP_LVL);
                    this.beansMerchantIdentity = MsgPackHelper.getIntValue(mapValue2, ReqAckPackage.REQ_RESPONSE_KEY.BEANS_MERCHANT_IDENTITY);
                    this.avatar_badge = MsgPackHelper.getStringValue(mapValue2, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR_BADGE);
                    this.ofromHideVipLook = MsgPackHelper.getIntValue(mapValue2, ReqAckPackage.REQ_RESPONSE_KEY.O_IS_HIDE_VIP_LOOK);
                    this.oFaceStatus = MsgPackHelper.getIntValue(mapValue2, ReqAckPackage.REQ_RESPONSE_KEY.O_FACE_STATUS);
                    this.avatarPendant = MsgPackHelper.getStringValue(mapValue2, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR_PENDANT);
                    this.avatarPendantApng = MsgPackHelper.getStringValue(mapValue2, "avatar_pendant_apng");
                    this.avatarPendantHalo = MsgPackHelper.getStringValue(mapValue2, "avatar_pendant_halo");
                    this.avatarPendantHaloApng = MsgPackHelper.getStringValue(mapValue2, "avatar_pendant_halo_apng");
                    this.status_img = MsgPackHelper.getStringValue(mapValue2, "status_img");
                    this.vip_group_type = MsgPackHelper.getIntValue(mapValue2, ReqAckPackage.REQ_RESPONSE_KEY.O_VIP_GROUP_TYPE);
                    this.prompt_type = MsgPackHelper.getStringValue(mapValue2, "prompt_type");
                    this.session_common_status = MsgPackHelper.getStringValue(mapValue2, "session_common_status");
                }
            }
            if (unpackMap != null) {
                try {
                    if (ChatManager.debug) {
                        Log.i("C_PushMsgPackage", " im_push原始结果-- " + new Gson().toJson(unpackMap));
                    }
                } catch (Exception e2) {
                }
            }
        }
    }

    public String toString() {
        String json = this.msgMapExtra != null ? new Gson().toJson(this.msgMapExtra) : null;
        return "[sessionType:" + ((int) this.sessionType) + ", sessionId:" + this.sessionId + ", msgId:" + this.msgId + ", previousMsgId:" + this.previousMsgId + ", time:" + this.time + ", distance:" + this.distance + ", msgType:" + ((int) this.msgType) + ", fromId:" + this.fromId + ", msgContent:" + this.msgContent + ", MsgAt:" + this.msgAt + ", status:" + this.status + ", app:" + this.app + ", fromName:" + this.fromName + ", fromAvatar:" + this.fromAvatar + ", fromVBadge:" + this.fromVBadge + ", fromOnline:" + this.fromOnline + ", fromFriend:" + this.fromFriend + ", fromRichLevel:" + this.fromRichLevel + ", fromVipGrade:" + this.fromVipGrade + ", fromVipAnnual:" + this.fromVipAnnual + ", fromVipExpLvl:" + this.fromVipExpLvl + ", fromLiveManager:" + this.fromLiveManager + ", ofromVipGrade:" + this.ofromVipGrade + ", ofromVipExpLvl:" + this.ofromVipExpLvl + ", beansMerchantIdentity:" + this.beansMerchantIdentity + ", ofromHideVipLook:" + this.ofromHideVipLook + ", oFaceStatus:" + this.oFaceStatus + ", avatar_badge:" + this.avatar_badge + ", fromHideVipLook:" + this.fromHideVipLook + ", avatarPendant:" + this.avatarPendant + ", avatarPendantApng:" + this.avatarPendantApng + ", avatarPendantHalo:" + this.avatarPendantHalo + ", avatarPendantHaloApng:" + this.avatarPendantHaloApng + ", status_img:" + this.status_img + ", vip_group_type:" + this.vip_group_type + ", msgExtra:" + json + ", profileMap:" + this.profileMap + "]";
    }
}
