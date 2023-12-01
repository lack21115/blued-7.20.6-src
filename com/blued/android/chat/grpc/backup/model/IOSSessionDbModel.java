package com.blued.android.chat.grpc.backup.model;

import com.blued.android.chat.grpc.backup.annotation.DbTableName;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.utils.ChatHelper;

@DbTableName(name = "SessionTable")
/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/grpc/backup/model/IOSSessionDbModel.class */
public class IOSSessionDbModel {
    public int app;
    public long atMessageId;
    public String distance;
    public String draft;
    public long evaluationMsgId;
    public int friend;
    public long fromId;
    public String fromName;
    public int isTop;
    public short is_hide_vip_look;
    public long latestGiftMsgId;
    public int likeCount;
    public long maxHasReadMsgId;
    public long maxMessageId;
    public long maxReceivedOtherMessageId;
    public String messageContent;
    public long messageId;
    public short messageType;
    public String msgExtra;
    public int msgLocalId;
    public short o_is_hide_vip_look;
    public short o_vip_grade;
    public int online;
    public int replied;
    public int secretLookStatus;
    public short sendState;
    public long sendTime;
    public String sessionAvatar;
    public long sessionId;
    public String sessionName;
    public int sessionStatus;
    public short sessionType;
    public int sourceFrom;
    public long topTime;
    public float totalMoney;
    public int unreadGiftCount;
    public int unreadMessageCount;
    public String vbadge;
    public short vip_annual;
    public short vip_exp_lvl;
    public short vip_grade;

    public SessionModel convertToAndroidModel() {
        SessionModel sessionModel = new SessionModel();
        sessionModel.sessionType = this.sessionType;
        sessionModel.sessionId = this.sessionId;
        sessionModel.avatar = this.sessionAvatar;
        sessionModel.nickName = this.sessionName;
        sessionModel.noReadMsgCount = this.unreadMessageCount;
        sessionModel.lastMsgStateCode = ChatHelper.transformIosSendStateToAndroid(this.sendState);
        sessionModel.lastMsgLocalId = this.msgLocalId;
        sessionModel.lastMsgId = this.messageId;
        sessionModel.lastMsgType = this.messageType;
        sessionModel.lastMsgContent = this.messageContent;
        sessionModel.lastMsgTime = this.sendTime * 1000;
        sessionModel.lastMsgFromNickname = this.fromName;
        sessionModel.maxHasReadMsgID = this.maxHasReadMsgId;
        try {
            sessionModel.vBadge = Integer.valueOf(this.vbadge).intValue();
        } catch (Throwable th) {
        }
        sessionModel.vipGrade = this.vip_grade;
        sessionModel.vipAnnual = this.vip_annual;
        sessionModel.vipExpLvl = this.vip_exp_lvl;
        sessionModel.hideVipLook = this.is_hide_vip_look;
        sessionModel.ohideVipLook = this.o_is_hide_vip_look;
        sessionModel.ovipGrade = this.o_vip_grade;
        sessionModel.sourceFrom = this.sourceFrom;
        sessionModel.lieTop = this.isTop;
        sessionModel.lastMsgFromDistance = this.distance;
        sessionModel.lastMsgFromId = this.fromId;
        sessionModel.online = this.online;
        sessionModel.lastDraft = this.draft;
        sessionModel.secretLookStatus = this.secretLookStatus;
        sessionModel.sessionStatus = this.sessionStatus;
        sessionModel.unreadGiftCnt = this.unreadGiftCount;
        sessionModel.lastGiftMsgId = this.latestGiftMsgId;
        sessionModel.expireTime = this.topTime;
        sessionModel.totalMoney = this.totalMoney;
        sessionModel.likeNumUnread = this.likeCount;
        sessionModel.hasReply = this.replied;
        sessionModel.maxMsgId = this.maxMessageId;
        sessionModel.lastMsgExtra = this.msgExtra;
        sessionModel.maxRcvOppMsgId = this.maxReceivedOtherMessageId;
        sessionModel.friend = this.friend;
        sessionModel.atMessageId = this.atMessageId;
        sessionModel.lastMsgFromApp = this.app;
        sessionModel.evaluationMsgId = this.evaluationMsgId;
        return sessionModel;
    }
}
