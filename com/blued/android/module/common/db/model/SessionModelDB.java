package com.blued.android.module.common.db.model;

import android.text.TextUtils;
import com.blued.android.chat.model.ChattingModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.List;
import java.util.Set;

@DatabaseTable(tableName = "SessionModel")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/db/model/SessionModelDB.class */
public class SessionModelDB {
    public List<ChattingModel> _msgList;
    public Set<Long> _unreadedMsgIds;
    @DatabaseField
    public long atMessageId;
    @DatabaseField(columnName = "sessionAvatar")
    public String avatar;
    @DatabaseField(columnName = "id", generatedId = true)
    public int dbId;
    @DatabaseField
    public long evaluationMsgId;
    @DatabaseField
    public long expireTime;
    @DatabaseField
    public int friend;
    @DatabaseField
    public int hasReply;
    @DatabaseField
    public int hideVipLook;
    @DatabaseField(columnName = "draft")
    public String lastDraft;
    @DatabaseField
    public long lastGiftMsgId;
    @DatabaseField
    public String lastMsgContent;
    @DatabaseField
    public String lastMsgExtra;
    @DatabaseField
    public int lastMsgFromApp;
    @DatabaseField
    public String lastMsgFromAvatar;
    @DatabaseField(columnName = "lastMsgDistance")
    public String lastMsgFromDistance;
    @DatabaseField
    public long lastMsgFromId;
    @DatabaseField
    public String lastMsgFromNickname;
    @DatabaseField(columnName = "lastMsgOnline", defaultValue = "1")
    public int lastMsgFromOnline;
    @DatabaseField
    public long lastMsgId;
    @DatabaseField
    public long lastMsgLocalId;
    @DatabaseField
    public short lastMsgStateCode;
    @DatabaseField
    public long lastMsgTime;
    @DatabaseField
    public short lastMsgType;
    @DatabaseField
    public int lieTop;
    @DatabaseField(index = true)
    public long loadName;
    @DatabaseField
    public long maxMsgId;
    @DatabaseField
    public long maxRcvOppMsgId;
    @DatabaseField(columnName = "sessionNickName")
    public String nickName;
    @DatabaseField
    public int noReadRedDot;
    @DatabaseField(defaultValue = "1")
    public int online;
    @DatabaseField
    public int secretLookStatus;
    @DatabaseField(index = true)
    public long sessionId;
    @DatabaseField
    public int sessionStatus;
    @DatabaseField(index = true)
    public short sessionType;
    @DatabaseField
    public int sourceFrom;
    @DatabaseField
    public float totalMoney;
    @DatabaseField
    public int unreadGiftCnt;
    @DatabaseField
    public int vBadge;
    @DatabaseField
    public int viSayHello;
    @DatabaseField
    public int vipAnnual;
    @DatabaseField
    public int vipExpLvl;
    @DatabaseField
    public int vipGrade;
    @DatabaseField
    public int noReadMsgCount = 0;
    @DatabaseField
    public long maxHasReadMsgID = 0;
    public boolean _isRequestingInfo = false;
    public boolean chooseable = true;
    public boolean checked = false;

    public static boolean dataIsFull(SessionModelDB sessionModelDB) {
        if (sessionModelDB != null) {
            return !TextUtils.isEmpty(sessionModelDB.nickName);
        }
        return false;
    }

    public static void removeSessionLastMsg(SessionModelDB sessionModelDB) {
        sessionModelDB.lastMsgContent = "";
        sessionModelDB.lastMsgLocalId = 0L;
        sessionModelDB.lastMsgId = 0L;
        sessionModelDB.lastMsgType = (short) 0;
        sessionModelDB.lastMsgStateCode = (short) 0;
        sessionModelDB.lastMsgFromId = 0L;
        sessionModelDB.lastMsgFromNickname = "";
        sessionModelDB.lastMsgFromAvatar = "";
        sessionModelDB.lastMsgFromDistance = "";
        sessionModelDB.noReadMsgCount = 0;
        sessionModelDB.lastMsgExtra = "";
        sessionModelDB.lastMsgFromApp = 0;
    }

    public static void setSessionForLastMsg(SessionModelDB sessionModelDB, ChattingModel chattingModel) {
        sessionModelDB.lastMsgContent = chattingModel.msgContent;
        sessionModelDB.lastMsgTime = chattingModel.msgTimestamp;
        sessionModelDB.lastMsgLocalId = chattingModel.msgLocalId;
        sessionModelDB.lastMsgId = chattingModel.msgId;
        sessionModelDB.lastMsgType = chattingModel.msgType;
        sessionModelDB.lastMsgFromApp = chattingModel.app;
        sessionModelDB.lastMsgStateCode = chattingModel.msgStateCode;
        sessionModelDB.lastMsgFromId = chattingModel.fromId;
        if (!TextUtils.isEmpty(chattingModel.fromNickName)) {
            sessionModelDB.lastMsgFromNickname = chattingModel.fromNickName;
        }
        if (!TextUtils.isEmpty(chattingModel.fromAvatar)) {
            sessionModelDB.lastMsgFromAvatar = chattingModel.fromAvatar;
        }
        sessionModelDB.lastMsgFromDistance = chattingModel.fromDistance;
        sessionModelDB.lastMsgExtra = chattingModel.getMsgExtra();
        sessionModelDB.lastMsgFromOnline = chattingModel.fromOnline;
        if (chattingModel.msgType == 42) {
            sessionModelDB.sessionStatus = 1;
        } else if (chattingModel.msgType == 43) {
            sessionModelDB.sessionStatus = 0;
        }
    }
}
