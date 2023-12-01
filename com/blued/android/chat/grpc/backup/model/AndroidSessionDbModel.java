package com.blued.android.chat.grpc.backup.model;

import com.blued.android.chat.grpc.backup.annotation.DbTableName;
import com.blued.android.chat.model.SessionModel;

@DbTableName(name = "SessionModel")
/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/grpc/backup/model/AndroidSessionDbModel.class */
public class AndroidSessionDbModel {
    public long atMessageId;
    public String draft;
    public long evaluationMsgId;
    public long expireTime;
    public int friend;
    public int hasReply;
    public int hideVipLook;
    public long lastGiftMsgId;
    public String lastMsgContent;
    public String lastMsgDistance;
    public String lastMsgExtra;
    public int lastMsgFromApp;
    public String lastMsgFromAvatar;
    public long lastMsgFromId;
    public String lastMsgFromNickname;
    public long lastMsgId;
    public long lastMsgLocalId;
    public int lastMsgOnline;
    public short lastMsgStateCode;
    public long lastMsgTime;
    public short lastMsgType;
    public int lieTop;
    public long loadName;
    public long maxMsgId;
    public long maxRcvOppMsgId;
    public int online;
    public int secretLookStatus;
    public String sessionAvatar;
    public long sessionId;
    public String sessionNickName;
    public int sessionStatus;
    public short sessionType;
    public int sourceFrom;
    public float totalMoney;
    public int unreadGiftCnt;
    public int vBadge;
    public int vipAnnual;
    public int vipExpLvl;
    public int vipGrade;
    public int noReadMsgCount = 0;
    public long maxHasReadMsgID = 0;

    public SessionModel convertToSessionModel() {
        SessionModel sessionModel = new SessionModel();
        sessionModel.loadName = this.loadName;
        sessionModel.sessionId = this.sessionId;
        sessionModel.sessionType = this.sessionType;
        sessionModel.nickName = this.sessionNickName;
        sessionModel.avatar = this.sessionAvatar;
        sessionModel.sessionStatus = this.sessionStatus;
        sessionModel.online = this.online;
        sessionModel.vBadge = this.vBadge;
        sessionModel.vipGrade = this.vipGrade;
        sessionModel.vipAnnual = this.vipAnnual;
        sessionModel.vipExpLvl = this.vipExpLvl;
        sessionModel.noReadMsgCount = this.noReadMsgCount;
        sessionModel.maxHasReadMsgID = this.maxHasReadMsgID;
        sessionModel.lastMsgId = this.lastMsgId;
        sessionModel.lastMsgType = this.lastMsgType;
        sessionModel.lastMsgLocalId = this.lastMsgLocalId;
        sessionModel.lastMsgContent = this.lastMsgContent;
        sessionModel.lastMsgExtra = this.lastMsgExtra;
        sessionModel.lastMsgTime = this.lastMsgTime;
        sessionModel.lastMsgStateCode = this.lastMsgStateCode;
        sessionModel.lastMsgFromId = this.lastMsgFromId;
        sessionModel.lastMsgFromNickname = this.lastMsgFromNickname;
        sessionModel.lastMsgFromAvatar = this.lastMsgFromAvatar;
        sessionModel.lastMsgFromDistance = this.lastMsgDistance;
        sessionModel.online = this.lastMsgOnline;
        sessionModel.lastMsgFromApp = this.lastMsgFromApp;
        sessionModel.maxRcvOppMsgId = this.maxRcvOppMsgId;
        sessionModel.lastDraft = this.draft;
        sessionModel.hideVipLook = this.hideVipLook;
        sessionModel.sourceFrom = this.sourceFrom;
        sessionModel.lieTop = this.lieTop;
        sessionModel.unreadGiftCnt = this.unreadGiftCnt;
        sessionModel.lastGiftMsgId = this.lastGiftMsgId;
        sessionModel.friend = this.friend;
        sessionModel.expireTime = this.expireTime;
        sessionModel.totalMoney = this.totalMoney;
        sessionModel.maxMsgId = this.maxMsgId;
        sessionModel.hasReply = this.hasReply;
        sessionModel.secretLookStatus = this.secretLookStatus;
        sessionModel.atMessageId = this.atMessageId;
        sessionModel.evaluationMsgId = this.evaluationMsgId;
        return sessionModel;
    }
}
