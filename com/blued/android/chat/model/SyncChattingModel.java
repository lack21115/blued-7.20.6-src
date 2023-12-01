package com.blued.android.chat.model;

import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.PushBasePackage;
import com.blued.android.chat.data.MsgType;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/model/SyncChattingModel.class */
public class SyncChattingModel {
    public int app;
    public String at;
    public String contents;
    public String contents_en;
    public String contents_hk;
    public String contents_tw;
    public double distance;
    public Map<String, Object> extra;
    public long from;
    public boolean isDeleted;
    public boolean isRead;
    public long msgId;
    SyncChattingProfileModel profile;
    public int sessionId;
    public short sessionType;
    public String session_common_status;
    public int session_status;
    public long timestamp;
    public short type;

    public ChattingModel toChattingModel() {
        ChattingModel chattingModel = new ChattingModel();
        try {
            PushBasePackage defaultInstance = PushBasePackage.getDefaultInstance();
            defaultInstance.msgHeader.isReaded = this.isRead;
            defaultInstance.msgHeader.isDeleted = this.isDeleted;
            chattingModel._pushMsgPackage = defaultInstance.pushMsgPackage;
            chattingModel.fromId = this.from;
            chattingModel.toId = ChatManager.userInfo.uid;
            chattingModel.sessionId = this.sessionId;
            chattingModel.sessionType = this.sessionType;
            chattingModel.msgId = this.msgId;
            chattingModel.msgPreviousId = this.msgId - 1;
            chattingModel.msgTimestamp = this.timestamp * 1000;
            chattingModel.msgType = this.type;
            chattingModel.app = this.app;
            chattingModel.fromDistance = (((float) this.distance) / 1000.0f) + "";
            chattingModel.status = this.session_status;
            chattingModel.session_common_status = this.session_common_status;
            chattingModel.msgIsDelete = this.isDeleted;
            if (MsgType.getClassify(chattingModel.msgType) == 1) {
                chattingModel.msgStateCode = (short) 3;
            } else if (chattingModel.msgType == 216) {
                chattingModel.msgStateCode = (short) 4;
            } else if (this.from != ChatManager.userInfo.uid) {
                chattingModel.msgStateCode = (short) 4;
            } else if (this.isRead) {
                chattingModel.msgStateCode = (short) 3;
            } else {
                chattingModel.msgStateCode = (short) 2;
            }
            if (!TextUtils.isEmpty(ChatManager.language)) {
                String str = ChatManager.language;
                boolean z = true;
                int hashCode = str.hashCode();
                if (hashCode != 3241) {
                    if (hashCode != 3331) {
                        if (hashCode == 3715 && str.equals("tw")) {
                            z = false;
                        }
                    } else if (str.equals("hk")) {
                        z = true;
                    }
                } else if (str.equals("en")) {
                    z = true;
                }
                if (!z) {
                    chattingModel.msgContent = this.contents_tw;
                } else if (z) {
                    chattingModel.msgContent = this.contents_hk;
                } else if (z) {
                    chattingModel.msgContent = this.contents_en;
                }
            }
            if (TextUtils.isEmpty(chattingModel.msgContent)) {
                chattingModel.msgContent = this.contents;
            }
            chattingModel.msgAt = this.at;
            chattingModel.fromNickName = this.profile.name;
            chattingModel.fromAvatar = this.profile.avatar;
            chattingModel.fromVBadge = this.profile.vbadge;
            chattingModel.fromOnline = this.profile.online;
            chattingModel.fromFriend = this.profile.friend;
            chattingModel.fromRichLevel = this.profile.rich_level;
            chattingModel.fromVipGrade = this.profile.vip_grade;
            chattingModel.fromVipAnnual = this.profile.vip_annual;
            chattingModel.fromVipExpLvl = this.profile.vip_exp_lvl;
            chattingModel.fromLiveManager = this.profile.is_manager;
            chattingModel.fromHideVipLook = this.profile.is_hide_vip_look;
            chattingModel.beansMerchantIdentity = this.profile.beans_merchant_identity;
            chattingModel.avatar_badge = this.profile.avatar_badge;
            chattingModel.status_img = this.profile.status_img;
            chattingModel.promptType = this.profile.prompt_type;
            chattingModel.msgMapExtra = this.extra;
            if (this.extra != null) {
                if (TextUtils.isEmpty(chattingModel.msgAt) && this.extra.containsKey("at_uids")) {
                    chattingModel.msgAt = (String) this.extra.get("at_uids");
                }
                if (this.extra.containsKey("is_match_msg")) {
                    try {
                        chattingModel.isMatchMsg = ((Double) this.extra.get("is_match_msg")).intValue();
                        if (chattingModel.isMatchMsg == 0) {
                            chattingModel.isMatchMsg = ((Integer) this.extra.get("is_match_msg")).intValue();
                        }
                    } catch (Exception e) {
                    }
                }
                if (this.extra.containsKey("identify_yellow")) {
                    chattingModel.identifyYellow = ((Boolean) this.extra.get("identify_yellow")).booleanValue() ? 0 : 1;
                }
            }
            if (chattingModel.isMatchMsg == 1 && chattingModel.sessionId > 0) {
                chattingModel.sessionId = -chattingModel.sessionId;
                return chattingModel;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return chattingModel;
    }
}
