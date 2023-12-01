package com.blued.android.chat.model;

import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.utils.ChatHelper;
import java.util.List;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/model/SessionModel.class */
public class SessionModel {
    public List<ChattingModel> _msgList;
    public boolean _secretMsgListing;
    public Set<Long> _unreadedMsgIds;
    public long atMessageId;
    public String avatar;
    public String avatar_badge;
    public int beansMerchantIdentity;
    public int dbId;
    public long evaluationMsgId;
    public long expireTime;
    public int friend;
    public int hasReply;
    public int hideVipLook;
    public String lastDraft;
    public long lastGiftMsgId;
    public String lastMsgContent;
    public String lastMsgExtra;
    public int lastMsgFromApp;
    public String lastMsgFromAvatar;
    public String lastMsgFromDistance;
    public long lastMsgFromId;
    public String lastMsgFromNickname;
    public int lastMsgFromOnline;
    public long lastMsgId;
    public long lastMsgLocalId;
    public short lastMsgStateCode;
    public long lastMsgTime;
    public short lastMsgType;
    public int lieTop;
    public int likeNumUnread;
    public long maxMsgId;
    public long maxRcvOppMsgId;
    public String nickName;
    public int noReadRedDot;
    public int oFaceStatus;
    public int oVipGroupType;
    public int ohideVipLook;
    public int online;
    public int ovipExpLvl;
    public int ovipGrade;
    public long sessionId;
    public SessionSettingBaseModel sessionSettingModel;
    public int sessionStatus;
    public short sessionType;
    public String status_img;
    public float totalMoney;
    public int unreadGiftCnt;
    public int vBadge;
    public int viSayHello;
    public int vipAnnual;
    public int vipExpLvl;
    public int vipGrade;
    public long loadName = ChatManager.userInfo.uid;
    public int noReadMsgCount = 0;
    public long maxHasReadMsgID = 0;
    public boolean _isRequestingInfo = false;
    public int onLineState = 0;
    public int sourceFrom = 0;
    public boolean isFromSearch = false;
    public int secretLookStatus = 0;
    public boolean chooseable = true;
    public boolean checked = false;

    public static boolean needRequestSessionInfo(SessionModel sessionModel) {
        if (sessionModel != null) {
            short s = sessionModel.sessionType;
            return (s == 2 || s == 3) && !sessionModel._isRequestingInfo && TextUtils.isEmpty(sessionModel.nickName);
        }
        return false;
    }

    public static void removeSessionLastMsg(SessionModel sessionModel) {
        sessionModel.lastMsgContent = "";
        sessionModel.lastMsgLocalId = 0L;
        sessionModel.lastMsgId = 0L;
        sessionModel.maxMsgId = 0L;
        sessionModel.lastMsgType = (short) 0;
        sessionModel.lastMsgStateCode = (short) 0;
        sessionModel.lastMsgFromId = 0L;
        sessionModel.lastMsgFromNickname = "";
        sessionModel.lastMsgFromAvatar = "";
        sessionModel.lastMsgFromDistance = "";
        sessionModel.noReadMsgCount = 0;
        sessionModel.viSayHello = 0;
        sessionModel.noReadRedDot = 0;
        ChatHelper.clearSessionLikeNum(sessionModel);
        sessionModel.lastMsgExtra = "";
        sessionModel.lastMsgFromApp = 0;
    }

    public static void setSessionForLastMsg(SessionModel sessionModel, ChattingModel chattingModel) {
        sessionModel.maxMsgId = chattingModel.msgId;
        if (ChatHelper.isIgnoreNotifyMsgType(chattingModel) || chattingModel.msgIsDelete) {
            if (ChatManager.debug) {
                Log.v("setSessionForLastMsg", "isIgnoreNoticeMsgType, msgData:" + chattingModel + ", type:" + ((int) chattingModel.msgType));
                return;
            }
            return;
        }
        if (chattingModel.msgType != 169) {
            sessionModel.lastMsgContent = chattingModel.msgContent;
        } else if (chattingModel.msgMapExtra != null) {
            if (chattingModel.isFromSelf() && chattingModel.msgMapExtra.containsKey("sender_tips")) {
                sessionModel.lastMsgContent = (String) chattingModel.msgMapExtra.get("sender_tips");
            } else if (!chattingModel.isFromSelf() && chattingModel.msgMapExtra.containsKey("receiver_tips")) {
                sessionModel.lastMsgContent = (String) chattingModel.msgMapExtra.get("receiver_tips");
            }
        }
        sessionModel.lastMsgTime = chattingModel.msgTimestamp;
        sessionModel.lastMsgLocalId = chattingModel.msgLocalId;
        sessionModel.lastMsgId = chattingModel.msgId;
        sessionModel.lastMsgType = chattingModel.msgType;
        sessionModel.lastMsgFromApp = chattingModel.app;
        sessionModel.lastMsgStateCode = chattingModel.msgStateCode;
        sessionModel.lastMsgFromId = chattingModel.fromId;
        if (!TextUtils.isEmpty(chattingModel.fromNickName)) {
            sessionModel.lastMsgFromNickname = chattingModel.fromNickName;
        }
        if (!TextUtils.isEmpty(chattingModel.fromAvatar)) {
            sessionModel.lastMsgFromAvatar = chattingModel.fromAvatar;
        }
        sessionModel.lastMsgFromDistance = chattingModel.fromDistance;
        sessionModel.lastMsgExtra = chattingModel.getMsgExtra();
        sessionModel.lastMsgFromOnline = chattingModel.fromOnline;
        if (chattingModel.msgType == 42) {
            sessionModel.sessionStatus = 1;
        } else if (chattingModel.msgType == 43) {
            sessionModel.sessionStatus = 0;
        }
        if (chattingModel.isFromSelf()) {
            sessionModel.friend = 1;
            sessionModel.hasReply = 1;
        } else if (chattingModel.fromFriend > 0) {
            sessionModel.friend = 1;
        }
    }
}
