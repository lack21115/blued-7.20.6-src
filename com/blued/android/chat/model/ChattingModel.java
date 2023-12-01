package com.blued.android.chat.model;

import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.PushMsgPackage;
import com.google.gson.Gson;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/model/ChattingModel.class */
public class ChattingModel {
    public PushMsgPackage _pushMsgPackage;
    public int app;
    public String avatarPendant;
    public String avatarPendantApng;
    public String avatarPendantHalo;
    public String avatarPendantHaloApng;
    public String avatar_badge;
    public int beansMerchantIdentity;
    public int dbId;
    public String fromAvatar;
    public String fromDistance;
    public int fromFriend;
    public int fromHideVipLook;
    public long fromId;
    public int fromLiveManager;
    public String fromNickName;
    public int fromOnline;
    public int fromPrivilege;
    public int fromRichLevel;
    public int fromVBadge;
    public int fromVipAnnual;
    public int fromVipExpLvl;
    public int fromVipGrade;
    public int identifyYellow;
    public int isMatchMsg;
    public boolean isShowTime;
    public boolean liveChatListFollowed;
    public long loadName;
    public String msgAt;
    public String msgContent;
    private String msgExtra;
    public long msgId;
    public boolean msgIsDelete;
    public long msgLocalId;
    public Map<String, Object> msgMapExtra;
    public long msgPreviousId;
    public short msgStateCode;
    public String msgTextTranslateContent;
    public int msgTextTranslateIsShow;
    public int msgTextTranslateStatus;
    public long msgTimestamp;
    public short msgType;
    public String msgVideoCoverUrlLocal;
    public int oFromFaceStatus;
    public int oVipGroupType;
    public int ofromHideVipLook;
    public int ofromVipExpLvl;
    public int ofromVipGrade;
    public String promptType;
    public long sessionId;
    public short sessionType;
    public String session_common_status;
    public int status;
    public String status_img;
    public long toId;

    public ChattingModel() {
        this.loadName = ChatManager.userInfo.uid;
    }

    public ChattingModel(ChattingModel chattingModel) {
        this.loadName = ChatManager.userInfo.uid;
        this.loadName = chattingModel.loadName;
        this.app = chattingModel.app;
        this.dbId = chattingModel.dbId;
        this.toId = chattingModel.toId;
        this.fromId = chattingModel.fromId;
        this.fromNickName = chattingModel.fromNickName;
        this.fromAvatar = chattingModel.fromAvatar;
        this.fromDistance = chattingModel.fromDistance;
        this.fromVBadge = chattingModel.fromVBadge;
        this.fromRichLevel = chattingModel.fromRichLevel;
        this.fromVipGrade = chattingModel.fromVipGrade;
        this.fromVipAnnual = chattingModel.fromVipAnnual;
        this.fromVipExpLvl = chattingModel.fromVipExpLvl;
        this.ofromVipGrade = chattingModel.ofromVipGrade;
        this.ofromVipExpLvl = chattingModel.ofromVipExpLvl;
        this.beansMerchantIdentity = chattingModel.beansMerchantIdentity;
        this.avatar_badge = chattingModel.avatar_badge;
        this.ofromHideVipLook = chattingModel.ofromHideVipLook;
        this.oFromFaceStatus = chattingModel.oFromFaceStatus;
        this.fromLiveManager = chattingModel.fromLiveManager;
        this.fromHideVipLook = chattingModel.fromHideVipLook;
        this.fromPrivilege = chattingModel.fromPrivilege;
        this.fromOnline = chattingModel.fromOnline;
        this.fromFriend = chattingModel.fromFriend;
        this.msgExtra = chattingModel.msgExtra;
        this.msgMapExtra = chattingModel.msgMapExtra;
        this.sessionId = chattingModel.sessionId;
        this.sessionType = chattingModel.sessionType;
        this.msgPreviousId = chattingModel.msgPreviousId;
        this.msgIsDelete = chattingModel.msgIsDelete;
        this.msgContent = chattingModel.msgContent;
        this.msgTimestamp = chattingModel.msgTimestamp;
        this.msgLocalId = chattingModel.msgLocalId;
        this.msgId = chattingModel.msgId;
        this.msgType = chattingModel.msgType;
        this.msgStateCode = chattingModel.msgStateCode;
        this.msgVideoCoverUrlLocal = chattingModel.msgVideoCoverUrlLocal;
        this.msgTextTranslateIsShow = chattingModel.msgTextTranslateIsShow;
        this.msgTextTranslateContent = chattingModel.msgTextTranslateContent;
        this.msgTextTranslateStatus = chattingModel.msgTextTranslateStatus;
        this.liveChatListFollowed = chattingModel.liveChatListFollowed;
        this.isShowTime = chattingModel.isShowTime;
        this._pushMsgPackage = chattingModel._pushMsgPackage;
        this.status = chattingModel.status;
        this.msgAt = chattingModel.msgAt;
        this.avatarPendant = chattingModel.avatarPendant;
        this.avatarPendantApng = chattingModel.avatarPendantApng;
        this.avatarPendantHalo = chattingModel.avatarPendantHalo;
        this.avatarPendantHaloApng = chattingModel.avatarPendantHaloApng;
        this.status_img = chattingModel.status_img;
        this.oVipGroupType = chattingModel.oVipGroupType;
        this.promptType = chattingModel.promptType;
        this.session_common_status = chattingModel.session_common_status;
        this.isMatchMsg = chattingModel.isMatchMsg;
        this.identifyYellow = chattingModel.identifyYellow;
    }

    public String getMsgExtra() {
        if (TextUtils.isEmpty(this.msgExtra) && this.msgMapExtra != null) {
            this.msgExtra = new Gson().toJson(this.msgMapExtra);
        }
        return this.msgExtra;
    }

    public boolean isFromSelf() {
        return ChatManager.userInfo.uid == this.fromId;
    }

    public void setMsgExtra(String str) {
        this.msgExtra = str;
    }

    public String toString() {
        return "[sessionId=" + this.sessionId + ", toId=" + this.toId + ", fromId=" + this.fromId + ", isMatchMsg=" + this.isMatchMsg + "]";
    }
}
