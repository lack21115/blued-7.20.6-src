package com.blued.android.module.common.db;

import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.module.chat.model.SessionSetting;
import com.blued.android.module.common.db.model.ChattingModelDB;
import com.blued.android.module.common.db.model.SessionModelDB;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.user.model.UserInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/db/DataTransform.class */
public class DataTransform {
    public static ChattingModel a(ChattingModelDB chattingModelDB) {
        if (chattingModelDB == null) {
            return null;
        }
        ChattingModel chattingModel = new ChattingModel();
        chattingModel.dbId = chattingModelDB.dbId;
        chattingModel.fromId = chattingModelDB.fromId;
        chattingModel.toId = chattingModelDB.toId;
        chattingModel.fromNickName = chattingModelDB.fromNickName;
        chattingModel.fromAvatar = chattingModelDB.fromAvatar;
        chattingModel.fromDistance = chattingModelDB.fromDistance;
        chattingModel.fromVBadge = chattingModelDB.fromVBadge;
        chattingModel.fromOnline = chattingModelDB.fromOnline;
        chattingModel.fromVipGrade = chattingModelDB.fromVipGrade;
        chattingModel.fromVipAnnual = chattingModelDB.fromVipAnnual;
        chattingModel.fromVipExpLvl = chattingModelDB.fromVipExpLvl;
        chattingModel.fromHideVipLook = chattingModelDB.fromHideVipLook;
        chattingModel.setMsgExtra(chattingModelDB.getMsgExtra());
        chattingModel.sessionId = chattingModelDB.sessionId;
        chattingModel.sessionType = chattingModelDB.sessionType;
        chattingModel.msgPreviousId = chattingModelDB.msgPreviousId;
        chattingModel.msgIsDelete = chattingModelDB.msgIsDelete;
        chattingModel.msgContent = chattingModelDB.msgContent;
        chattingModel.msgTimestamp = chattingModelDB.msgTimestamp;
        chattingModel.msgLocalId = chattingModelDB.msgLocalId;
        chattingModel.msgId = chattingModelDB.msgId;
        chattingModel.msgType = chattingModelDB.msgType;
        chattingModel.app = chattingModelDB.app;
        chattingModel.msgStateCode = chattingModelDB.msgStateCode;
        chattingModel.msgVideoCoverUrlLocal = chattingModelDB.msgVideoCoverUrlLocal;
        chattingModel.msgTextTranslateIsShow = chattingModelDB.msgTextTranslateIsShow;
        chattingModel.msgTextTranslateContent = chattingModelDB.msgTextTranslateContent;
        chattingModel.msgTextTranslateStatus = chattingModelDB.msgTextTranslateStatus;
        chattingModel.promptType = chattingModelDB.promptType;
        chattingModel.isMatchMsg = chattingModelDB.isMatchMsg;
        chattingModel.identifyYellow = chattingModelDB.identifyYellow;
        return chattingModel;
    }

    public static SessionModel a(SessionModelDB sessionModelDB) {
        if (sessionModelDB == null) {
            return null;
        }
        SessionModel sessionModel = new SessionModel();
        sessionModel.dbId = sessionModelDB.dbId;
        sessionModel.sessionId = sessionModelDB.sessionId;
        sessionModel.sessionType = sessionModelDB.sessionType;
        sessionModel.nickName = sessionModelDB.nickName;
        sessionModel.avatar = sessionModelDB.avatar;
        sessionModel.sessionStatus = sessionModelDB.sessionStatus;
        sessionModel.online = sessionModelDB.online;
        sessionModel.vBadge = sessionModelDB.vBadge;
        sessionModel.vipGrade = sessionModelDB.vipGrade;
        sessionModel.vipAnnual = sessionModelDB.vipAnnual;
        sessionModel.vipExpLvl = sessionModelDB.vipExpLvl;
        sessionModel.hideVipLook = sessionModelDB.hideVipLook;
        sessionModel.noReadMsgCount = sessionModelDB.noReadMsgCount;
        sessionModel.maxHasReadMsgID = sessionModelDB.maxHasReadMsgID;
        sessionModel.lastMsgId = sessionModelDB.lastMsgId;
        sessionModel.lastMsgType = sessionModelDB.lastMsgType;
        sessionModel.lastMsgFromApp = sessionModelDB.lastMsgFromApp;
        sessionModel.lastMsgLocalId = sessionModelDB.lastMsgLocalId;
        sessionModel.lastMsgContent = sessionModelDB.lastMsgContent;
        sessionModel.lastMsgExtra = sessionModelDB.lastMsgExtra;
        sessionModel.lastMsgTime = sessionModelDB.lastMsgTime;
        sessionModel.lastMsgStateCode = sessionModelDB.lastMsgStateCode;
        sessionModel.lastMsgFromId = sessionModelDB.lastMsgFromId;
        sessionModel.lastMsgFromNickname = sessionModelDB.lastMsgFromNickname;
        sessionModel.lastMsgFromAvatar = sessionModelDB.lastMsgFromAvatar;
        sessionModel.lastMsgFromDistance = sessionModelDB.lastMsgFromDistance;
        sessionModel.lastMsgFromOnline = sessionModelDB.lastMsgFromOnline;
        sessionModel.maxRcvOppMsgId = sessionModelDB.maxRcvOppMsgId;
        sessionModel.lastDraft = sessionModelDB.lastDraft;
        sessionModel.sourceFrom = sessionModelDB.sourceFrom;
        sessionModel.lieTop = sessionModelDB.lieTop;
        sessionModel.lastGiftMsgId = sessionModelDB.lastGiftMsgId;
        sessionModel.unreadGiftCnt = sessionModelDB.unreadGiftCnt;
        sessionModel.friend = sessionModelDB.friend;
        sessionModel.expireTime = sessionModelDB.expireTime;
        sessionModel.totalMoney = sessionModelDB.totalMoney;
        sessionModel.maxMsgId = sessionModelDB.maxMsgId;
        sessionModel.hasReply = sessionModelDB.hasReply;
        sessionModel.secretLookStatus = sessionModelDB.secretLookStatus;
        sessionModel.atMessageId = sessionModelDB.atMessageId;
        sessionModel.evaluationMsgId = sessionModelDB.evaluationMsgId;
        sessionModel.viSayHello = sessionModelDB.viSayHello;
        sessionModel.noReadRedDot = sessionModelDB.noReadRedDot;
        return sessionModel;
    }

    public static SessionSetting a(SessionSettingBaseModel sessionSettingBaseModel) {
        if (sessionSettingBaseModel == null) {
            return null;
        }
        return a((SessionSettingModel) sessionSettingBaseModel);
    }

    public static SessionSetting a(SessionSettingModel sessionSettingModel) {
        if (sessionSettingModel == null) {
            return null;
        }
        SessionSetting sessionSetting = new SessionSetting();
        sessionSetting.setDBId(sessionSettingModel.getDBId());
        sessionSetting.setId(sessionSettingModel.getId());
        sessionSetting.setSessionId(sessionSettingModel.getSessionId());
        sessionSetting.setSessionType(sessionSettingModel.getSessionType());
        sessionSetting.setLoadName(sessionSettingModel.getLoadName());
        sessionSetting.setRemindAudio(sessionSettingModel.getRemindAudio());
        sessionSetting.setGroupCreateId(sessionSettingModel.getGroupCreateId());
        sessionSetting.setGroupNumberNum(sessionSettingModel.getGroupNumberNum());
        sessionSetting.setGroupAdiminIDs(sessionSettingModel.getGroupAdiminIDs());
        sessionSetting.setLietop(sessionSettingModel.getLietop());
        sessionSetting.setUiStatus(sessionSettingModel.getUiStatus());
        sessionSetting.setChatBgUri(sessionSettingModel.getChatBgUri());
        sessionSetting.setSessinoNote(sessionSettingModel.getSessinoNote());
        sessionSetting.setInitiator(sessionSettingModel.getInitiator());
        sessionSetting.setFollower(sessionSettingModel.getFollower());
        sessionSetting.setNearby(sessionSettingModel.getNearby());
        sessionSetting.setOnline(sessionSettingModel.getOnline());
        sessionSetting.setSessionCommonStatus(sessionSettingModel.getSessionCommonStatus());
        return sessionSetting;
    }

    public static ChattingModelDB a(ChattingModel chattingModel) {
        if (chattingModel == null) {
            return null;
        }
        ChattingModelDB chattingModelDB = new ChattingModelDB();
        chattingModelDB.dbId = chattingModel.dbId;
        chattingModelDB.loadName = CommonTools.e(UserInfo.getInstance().getLoginUserInfo().getUid());
        chattingModelDB.fromId = chattingModel.fromId;
        chattingModelDB.toId = chattingModel.toId;
        chattingModelDB.fromNickName = chattingModel.fromNickName;
        chattingModelDB.fromAvatar = chattingModel.fromAvatar;
        chattingModelDB.fromDistance = chattingModel.fromDistance;
        chattingModelDB.fromVBadge = chattingModel.fromVBadge;
        chattingModelDB.fromOnline = chattingModel.fromOnline;
        chattingModelDB.fromVipGrade = chattingModel.fromVipGrade;
        chattingModelDB.fromVipAnnual = chattingModel.fromVipAnnual;
        chattingModelDB.fromVipExpLvl = chattingModel.fromVipExpLvl;
        chattingModelDB.fromHideVipLook = chattingModel.fromHideVipLook;
        chattingModelDB.setMsgExtra(chattingModel.getMsgExtra());
        chattingModelDB.sessionId = chattingModel.sessionId;
        chattingModelDB.sessionType = chattingModel.sessionType;
        chattingModelDB.msgPreviousId = chattingModel.msgPreviousId;
        chattingModelDB.msgIsDelete = chattingModel.msgIsDelete;
        chattingModelDB.msgContent = chattingModel.msgContent;
        chattingModelDB.msgTimestamp = chattingModel.msgTimestamp;
        chattingModelDB.msgLocalId = chattingModel.msgLocalId;
        chattingModelDB.msgId = chattingModel.msgId;
        chattingModelDB.msgType = chattingModel.msgType;
        chattingModelDB.app = chattingModel.app;
        chattingModelDB.msgStateCode = chattingModel.msgStateCode;
        chattingModelDB.msgVideoCoverUrlLocal = chattingModel.msgVideoCoverUrlLocal;
        chattingModelDB.msgTextTranslateIsShow = chattingModel.msgTextTranslateIsShow;
        chattingModelDB.msgTextTranslateContent = chattingModel.msgTextTranslateContent;
        chattingModelDB.msgTextTranslateStatus = chattingModel.msgTextTranslateStatus;
        chattingModelDB.promptType = chattingModel.promptType;
        chattingModelDB.isMatchMsg = chattingModel.isMatchMsg;
        chattingModelDB.identifyYellow = chattingModel.identifyYellow;
        return chattingModelDB;
    }

    public static SessionModelDB a(SessionModel sessionModel) {
        if (sessionModel == null) {
            return null;
        }
        SessionModelDB sessionModelDB = new SessionModelDB();
        sessionModelDB.dbId = sessionModel.dbId;
        sessionModelDB.sessionId = sessionModel.sessionId;
        sessionModelDB.sessionType = sessionModel.sessionType;
        sessionModelDB.loadName = CommonTools.e(UserInfo.getInstance().getLoginUserInfo().getUid());
        sessionModelDB.nickName = sessionModel.nickName;
        sessionModelDB.avatar = sessionModel.avatar;
        sessionModelDB.sessionStatus = sessionModel.sessionStatus;
        sessionModelDB.online = sessionModel.online;
        sessionModelDB.vBadge = sessionModel.vBadge;
        sessionModelDB.vipGrade = sessionModel.vipGrade;
        sessionModelDB.vipAnnual = sessionModel.vipAnnual;
        sessionModelDB.vipExpLvl = sessionModel.vipExpLvl;
        sessionModelDB.hideVipLook = sessionModel.hideVipLook;
        sessionModelDB.noReadMsgCount = sessionModel.noReadMsgCount;
        sessionModelDB.maxHasReadMsgID = sessionModel.maxHasReadMsgID;
        sessionModelDB.lastMsgId = sessionModel.lastMsgId;
        sessionModelDB.lastMsgType = sessionModel.lastMsgType;
        sessionModelDB.lastMsgFromApp = sessionModel.lastMsgFromApp;
        sessionModelDB.lastMsgLocalId = sessionModel.lastMsgLocalId;
        sessionModelDB.lastMsgContent = sessionModel.lastMsgContent;
        sessionModelDB.lastMsgExtra = sessionModel.lastMsgExtra;
        sessionModelDB.lastMsgTime = sessionModel.lastMsgTime;
        sessionModelDB.lastMsgStateCode = sessionModel.lastMsgStateCode;
        sessionModelDB.lastMsgFromId = sessionModel.lastMsgFromId;
        sessionModelDB.lastMsgFromNickname = sessionModel.lastMsgFromNickname;
        sessionModelDB.lastMsgFromAvatar = sessionModel.lastMsgFromAvatar;
        sessionModelDB.lastMsgFromDistance = sessionModel.lastMsgFromDistance;
        sessionModelDB.lastMsgFromOnline = sessionModel.lastMsgFromOnline;
        sessionModelDB.maxRcvOppMsgId = sessionModel.maxRcvOppMsgId;
        sessionModelDB.lastDraft = sessionModel.lastDraft;
        sessionModelDB.sourceFrom = sessionModel.sourceFrom;
        sessionModelDB.lieTop = sessionModel.lieTop;
        sessionModelDB.unreadGiftCnt = sessionModel.unreadGiftCnt;
        sessionModelDB.lastGiftMsgId = sessionModel.lastGiftMsgId;
        sessionModelDB.friend = sessionModel.friend;
        sessionModelDB.expireTime = sessionModel.expireTime;
        sessionModelDB.totalMoney = sessionModel.totalMoney;
        sessionModelDB.maxMsgId = sessionModel.maxMsgId;
        sessionModelDB.hasReply = sessionModel.hasReply;
        sessionModelDB.secretLookStatus = sessionModel.secretLookStatus;
        sessionModelDB.atMessageId = sessionModel.atMessageId;
        sessionModelDB.evaluationMsgId = sessionModel.evaluationMsgId;
        sessionModelDB.viSayHello = sessionModel.viSayHello;
        sessionModelDB.noReadRedDot = sessionModel.noReadRedDot;
        return sessionModelDB;
    }

    public static SessionSettingModel a(SessionSetting sessionSetting) {
        if (sessionSetting == null) {
            return null;
        }
        SessionSettingModel sessionSettingModel = new SessionSettingModel();
        sessionSettingModel.setDBId(sessionSetting.getDBId());
        sessionSettingModel.setId(sessionSetting.getId());
        sessionSettingModel.setSessionId(sessionSetting.getSessionId());
        sessionSettingModel.setSessionType(sessionSetting.getSessionType());
        sessionSettingModel.setLoadName(sessionSetting.getLoadName());
        sessionSettingModel.setRemindAudio(sessionSetting.getRemindAudio());
        sessionSettingModel.setGroupCreateId(sessionSetting.getGroupCreateId());
        sessionSettingModel.setGroupNumberNum(sessionSetting.getGroupNumberNum());
        sessionSettingModel.setGroupAdiminIDs(sessionSetting.getGroupAdiminIDs());
        sessionSettingModel.setLietop(sessionSetting.getLietop());
        sessionSettingModel.setUiStatus(sessionSetting.getUiStatus());
        sessionSettingModel.setChatBgUri(sessionSetting.getChatBgUri());
        sessionSettingModel.setSessinoNote(sessionSetting.getSessinoNote());
        sessionSettingModel.setInitiator(sessionSetting.getInitiator());
        sessionSettingModel.setFollower(sessionSetting.getFollower());
        sessionSettingModel.setNearby(sessionSetting.getNearby());
        sessionSettingModel.setOnline(sessionSetting.getOnline());
        sessionSettingModel.setSessionCommonStatus(sessionSetting.getSessionCommonStatus());
        return sessionSettingModel;
    }

    public static List<SessionModel> a(List<SessionModelDB> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (SessionModelDB sessionModelDB : list) {
            arrayList.add(a(sessionModelDB));
        }
        return arrayList;
    }

    public static List<ChattingModel> b(List<ChattingModelDB> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (ChattingModelDB chattingModelDB : list) {
            arrayList.add(a(chattingModelDB));
        }
        return arrayList;
    }
}
