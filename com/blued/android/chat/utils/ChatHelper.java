package com.blued.android.chat.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.PushMsgPackage;
import com.blued.android.chat.core.pack.SendMsgPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.data.MsgType;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.MsgReceiveModelChina;
import com.blued.android.chat.model.MsgReceiveModelInter;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/utils/ChatHelper.class */
public class ChatHelper {
    private static final String TAG = ChatHelper.class.getSimpleName();
    private static long localId = System.currentTimeMillis() / 1000;
    private static Gson gson = null;

    private ChatHelper() {
    }

    public static PushMsgPackage checkMsgType(PushMsgPackage pushMsgPackage) {
        if (ChatManager.clientType == ChatManager.ClientType.CHINA) {
            if (pushMsgPackage.msgType == 41 || pushMsgPackage.msgType == 56 || pushMsgPackage.msgType == 57 || pushMsgPackage.msgType == 58 || pushMsgPackage.msgType == 67 || pushMsgPackage.msgType == 75 || pushMsgPackage.msgType == 105 || pushMsgPackage.msgType == 113 || pushMsgPackage.msgType == 124) {
                pushMsgPackage.pushBasePackage.msgHeader.isDeleted = true;
                return pushMsgPackage;
            }
        } else if (ChatManager.clientType == ChatManager.ClientType.INTERNATIONAL && pushMsgPackage.msgType == 205) {
            pushMsgPackage.pushBasePackage.msgHeader.isDeleted = true;
        }
        return pushMsgPackage;
    }

    public static ChattingModel checkMsgType(ChattingModel chattingModel) {
        if (ChatManager.clientType == ChatManager.ClientType.CHINA) {
            if (chattingModel.msgType == 41 || chattingModel.msgType == 56 || chattingModel.msgType == 57 || chattingModel.msgType == 58 || chattingModel.msgType == 67 || chattingModel.msgType == 75 || chattingModel.msgType == 105 || chattingModel.msgType == 113 || chattingModel.msgType == 124) {
                chattingModel.msgIsDelete = true;
                return chattingModel;
            }
        } else if (ChatManager.clientType == ChatManager.ClientType.INTERNATIONAL && chattingModel.msgType == 205) {
            chattingModel.msgIsDelete = true;
        }
        return chattingModel;
    }

    public static void clearSessionLikeNum(SessionModel sessionModel) {
        if (sessionModel != null) {
            sessionModel.likeNumUnread = 0;
        }
    }

    public static SessionModel createEmptySessionModel(short s, long j) {
        SessionModel sessionModel = new SessionModel();
        sessionModel.loadName = ChatManager.userInfo.uid;
        sessionModel.sessionType = s;
        sessionModel.sessionId = j;
        ChatManager.dbOperImpl.saveSession(sessionModel);
        SessionSettingBaseModel sessionSetting = ChatManager.dbOperImpl.getSessionSetting(sessionModel.sessionType, sessionModel.sessionId);
        SessionSettingBaseModel sessionSettingBaseModel = sessionSetting;
        if (sessionSetting == null) {
            sessionSettingBaseModel = ChatManager.dbOperImpl.createSessionSetting(s, j, null);
        }
        sessionModel.sessionSettingModel = sessionSettingBaseModel;
        return sessionModel;
    }

    public static SessionModel createSessionModel(ChattingModel chattingModel, SessionProfileModel sessionProfileModel, boolean z) {
        SessionModel sessionModel = new SessionModel();
        if (z) {
            sessionModel.lastMsgStateCode = (short) 1;
            sessionModel.noReadMsgCount = 0;
            clearSessionLikeNum(sessionModel);
            sessionModel.friend = 1;
            sessionModel.hasReply = 1;
        } else {
            if (chattingModel.sessionType == 2 && sessionModel.loadName != chattingModel.loadName) {
                sessionModel.loadName = chattingModel.loadName;
            }
            sessionModel.lastMsgStateCode = (short) 4;
            sessionModel.noReadMsgCount = 1;
            sessionModel.friend = chattingModel.fromFriend;
            if (AtRegExpUtils.isAtSelf(chattingModel.msgAt)) {
                sessionModel.atMessageId = chattingModel.msgId;
                sessionModel.evaluationMsgId = 0L;
            }
            if (ChatManager.clientType == ChatManager.ClientType.CHINA && chattingModel.msgType == 240) {
                sessionModel.evaluationMsgId = chattingModel.msgId;
                sessionModel.atMessageId = 0L;
            }
            if (chattingModel.sessionType == 3) {
                sessionModel.oVipGroupType = chattingModel.oVipGroupType;
            }
        }
        if (chattingModel.msgType == 42) {
            sessionModel.sessionStatus = 1;
        } else if (chattingModel.msgType == 43) {
            sessionModel.sessionStatus = 0;
        }
        sessionModel.sessionId = chattingModel.sessionId;
        sessionModel.sessionType = chattingModel.sessionType;
        if (sessionProfileModel != null) {
            sessionModel.nickName = sessionProfileModel.nickname;
            sessionModel.avatar = sessionProfileModel.avatar;
            sessionModel.vBadge = sessionProfileModel.vBadge;
            sessionModel.online = sessionProfileModel.online;
            sessionModel.vipAnnual = sessionProfileModel.vipAnnual;
            sessionModel.vipExpLvl = sessionProfileModel.vipExpLvl;
            sessionModel.vipGrade = sessionProfileModel.vipGrade;
            sessionModel.hideVipLook = sessionProfileModel.hideVipLook;
            sessionModel.ovipGrade = sessionProfileModel.ovipGrade;
            sessionModel.ovipExpLvl = sessionProfileModel.ovipExpLvl;
            sessionModel.beansMerchantIdentity = sessionProfileModel.beansMerchantIdentity;
            sessionModel.avatar_badge = sessionProfileModel.avatar_badge;
            sessionModel.ohideVipLook = sessionProfileModel.ohideVipLook;
            sessionModel.oFaceStatus = sessionProfileModel.oFaceStatus;
        } else if (chattingModel.sessionType == 2 && chattingModel.fromId != ChatManager.userInfo.uid) {
            sessionModel.nickName = chattingModel.fromNickName;
            sessionModel.avatar = chattingModel.fromAvatar;
            sessionModel.vBadge = chattingModel.fromVBadge;
            sessionModel.online = chattingModel.fromOnline;
            sessionModel.vipAnnual = chattingModel.fromVipAnnual;
            sessionModel.vipExpLvl = chattingModel.fromVipExpLvl;
            sessionModel.vipGrade = chattingModel.fromVipGrade;
            sessionModel.hideVipLook = chattingModel.fromHideVipLook;
            sessionModel.ovipGrade = chattingModel.ofromVipGrade;
            sessionModel.ovipExpLvl = chattingModel.ofromVipExpLvl;
            sessionModel.beansMerchantIdentity = chattingModel.beansMerchantIdentity;
            sessionModel.avatar_badge = chattingModel.avatar_badge;
            sessionModel.ohideVipLook = chattingModel.ofromHideVipLook;
            sessionModel.oFaceStatus = chattingModel.oFromFaceStatus;
            sessionModel.status_img = chattingModel.status_img;
        }
        if (chattingModel.msgIsDelete) {
            sessionModel.lastMsgTime = chattingModel.msgTimestamp;
        } else {
            SessionModel.setSessionForLastMsg(sessionModel, chattingModel);
        }
        ChatManager.dbOperImpl.saveSession(sessionModel);
        SessionSettingBaseModel sessionSetting = ChatManager.dbOperImpl.getSessionSetting(sessionModel.sessionType, sessionModel.sessionId);
        SessionSettingBaseModel sessionSettingBaseModel = sessionSetting;
        if (sessionSetting == null) {
            sessionSettingBaseModel = ChatManager.dbOperImpl.createSessionSetting(sessionModel.sessionType, sessionModel.sessionId, null);
        }
        SessionSettingBaseModel sessionSettingBaseModel2 = sessionSettingBaseModel;
        if (sessionModel.sessionType == 2) {
            sessionSettingBaseModel2 = sessionSettingBaseModel;
            if (sessionSettingBaseModel != null) {
                sessionSettingBaseModel2 = sessionSettingBaseModel;
                if (!TextUtils.isEmpty(chattingModel.session_common_status)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("sessionCommonStatus", chattingModel.session_common_status);
                    ChatManager.getInstance().updateSessionSetting(sessionModel.sessionType, sessionModel.sessionId, hashMap);
                    sessionSettingBaseModel2 = ChatManager.dbOperImpl.getSessionSetting(sessionModel.sessionType, sessionModel.sessionId);
                }
            }
        }
        SessionSettingBaseModel sessionSettingBaseModel3 = sessionSettingBaseModel2;
        if (sessionModel.sessionType == 2) {
            sessionSettingBaseModel3 = sessionSettingBaseModel2;
            if (sessionSettingBaseModel2 != null) {
                sessionSettingBaseModel3 = sessionSettingBaseModel2;
                if (chattingModel.status != 0) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("remindAudio", Integer.valueOf(chattingModel.status));
                    ChatManager.getInstance().updateSessionSetting(sessionModel.sessionType, sessionModel.sessionId, hashMap2);
                    sessionSettingBaseModel3 = ChatManager.dbOperImpl.getSessionSetting(sessionModel.sessionType, sessionModel.sessionId);
                }
            }
        }
        sessionModel.sessionSettingModel = sessionSettingBaseModel3;
        return sessionModel;
    }

    public static ChattingModel findNotifyMsg(List<ChattingModel> list) {
        int size = list.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return list.get(list.size() - 1);
            }
            if (!isIgnoreNotifyMsgType(list.get(i))) {
                return list.get(i);
            }
            size = i;
        }
    }

    public static ChattingModel getChattingModelForSendmsg(long j, short s, String str, SessionProfileModel sessionProfileModel, String str2, short s2) {
        ChattingModel chattingModel = new ChattingModel();
        chattingModel.fromId = Long.valueOf(ChatManager.userInfo.uid).longValue();
        chattingModel.toId = Long.valueOf(j).longValue();
        if (sessionProfileModel != null) {
            chattingModel.fromNickName = sessionProfileModel.nickname;
            chattingModel.fromAvatar = sessionProfileModel.avatar;
            chattingModel.fromVBadge = sessionProfileModel.vBadge;
        }
        chattingModel.sessionId = Long.valueOf(j).longValue();
        chattingModel.sessionType = s2;
        chattingModel.setMsgExtra(str2);
        chattingModel.msgId = 0L;
        chattingModel.msgPreviousId = 0L;
        chattingModel.msgLocalId = getLocalId();
        chattingModel.msgContent = str;
        chattingModel.msgType = s;
        chattingModel.msgStateCode = (short) 1;
        return chattingModel;
    }

    public static ChattingModel getChattingModelFromPushPackage(PushMsgPackage pushMsgPackage) {
        ChattingModel chattingModel = new ChattingModel();
        chattingModel._pushMsgPackage = pushMsgPackage;
        try {
            chattingModel.fromId = pushMsgPackage.fromId;
            chattingModel.toId = ChatManager.userInfo.uid;
            chattingModel.sessionId = pushMsgPackage.sessionId;
            chattingModel.sessionType = pushMsgPackage.sessionType;
            chattingModel.msgId = pushMsgPackage.msgId;
            chattingModel.msgPreviousId = pushMsgPackage.previousMsgId;
            chattingModel.msgTimestamp = pushMsgPackage.time * 1000;
            chattingModel.msgType = pushMsgPackage.msgType;
            chattingModel.app = pushMsgPackage.app;
            if (MsgType.getClassify(chattingModel.msgType) == 1) {
                chattingModel.msgStateCode = (short) 3;
            } else if (chattingModel.msgType == 216) {
                chattingModel.msgStateCode = (short) 4;
            } else if (pushMsgPackage.fromId != ChatManager.userInfo.uid) {
                chattingModel.msgStateCode = (short) 4;
            } else if (pushMsgPackage.pushBasePackage.msgHeader.isReaded) {
                chattingModel.msgStateCode = (short) 3;
            } else {
                chattingModel.msgStateCode = (short) 2;
            }
            chattingModel.msgContent = pushMsgPackage.msgContent;
            chattingModel.msgAt = pushMsgPackage.msgAt;
            chattingModel.fromNickName = pushMsgPackage.fromName;
            chattingModel.fromAvatar = pushMsgPackage.fromAvatar;
            chattingModel.fromVBadge = pushMsgPackage.fromVBadge;
            chattingModel.fromOnline = pushMsgPackage.fromOnline;
            chattingModel.fromFriend = pushMsgPackage.fromFriend;
            chattingModel.fromRichLevel = pushMsgPackage.fromRichLevel;
            chattingModel.fromVipGrade = pushMsgPackage.fromVipGrade;
            chattingModel.fromVipAnnual = pushMsgPackage.fromVipAnnual;
            chattingModel.fromVipExpLvl = pushMsgPackage.fromVipExpLvl;
            chattingModel.fromLiveManager = pushMsgPackage.fromLiveManager;
            chattingModel.fromHideVipLook = pushMsgPackage.fromHideVipLook;
            chattingModel.ofromVipGrade = pushMsgPackage.ofromVipGrade;
            chattingModel.ofromVipExpLvl = pushMsgPackage.ofromVipExpLvl;
            chattingModel.beansMerchantIdentity = pushMsgPackage.beansMerchantIdentity;
            chattingModel.avatar_badge = pushMsgPackage.avatar_badge;
            chattingModel.ofromHideVipLook = pushMsgPackage.ofromHideVipLook;
            chattingModel.oFromFaceStatus = pushMsgPackage.oFaceStatus;
            chattingModel.msgIsDelete = pushMsgPackage.pushBasePackage.msgHeader.isDeleted;
            chattingModel.fromDistance = (((float) pushMsgPackage.distance) / 1000.0f) + "";
            chattingModel.avatarPendant = pushMsgPackage.avatarPendant;
            chattingModel.avatarPendantApng = pushMsgPackage.avatarPendantApng;
            chattingModel.avatarPendantHalo = pushMsgPackage.avatarPendantHalo;
            chattingModel.avatarPendantHaloApng = pushMsgPackage.avatarPendantHaloApng;
            chattingModel.status = pushMsgPackage.status;
            chattingModel.msgMapExtra = pushMsgPackage.msgMapExtra;
            if (chattingModel.msgMapExtra != null) {
                if (TextUtils.isEmpty(chattingModel.msgAt) && chattingModel.msgMapExtra.containsKey("at_uids")) {
                    chattingModel.msgAt = (String) chattingModel.msgMapExtra.get("at_uids");
                }
                if (chattingModel.msgMapExtra.containsKey("is_match_msg")) {
                    try {
                        pushMsgPackage.isMatchMsg = ((Double) chattingModel.msgMapExtra.get("is_match_msg")).intValue();
                        if (pushMsgPackage.isMatchMsg == 0) {
                            pushMsgPackage.isMatchMsg = ((Integer) chattingModel.msgMapExtra.get("is_match_msg")).intValue();
                        }
                    } catch (Exception e) {
                    }
                }
            }
            chattingModel.status_img = pushMsgPackage.status_img;
            chattingModel.oVipGroupType = pushMsgPackage.vip_group_type;
            chattingModel.promptType = pushMsgPackage.prompt_type;
            chattingModel.session_common_status = pushMsgPackage.session_common_status;
            chattingModel.isMatchMsg = pushMsgPackage.isMatchMsg;
            if (chattingModel.isMatchMsg == 1 && chattingModel.sessionId > 0) {
                chattingModel.sessionId = -chattingModel.sessionId;
                return chattingModel;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return chattingModel;
    }

    public static Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    public static long getLocalId() {
        long j;
        synchronized (ChatHelper.class) {
            try {
                j = localId + 1;
                localId = j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    public static int getMsgReceiveFrom(String str) {
        MsgReceiveModelChina msgReceiveModelChina;
        try {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            JSONObject jSONObject = new JSONObject(str);
            if (ChatManager.clientType != ChatManager.ClientType.INTERNATIONAL || jSONObject.has("msg_receive_from")) {
                if (ChatManager.clientType != ChatManager.ClientType.CHINA || jSONObject.has("msgSource")) {
                    Gson gson2 = new Gson();
                    if (ChatManager.clientType == ChatManager.ClientType.INTERNATIONAL) {
                        MsgReceiveModelInter msgReceiveModelInter = (MsgReceiveModelInter) gson2.fromJson(str, (Class<Object>) MsgReceiveModelInter.class);
                        if (msgReceiveModelInter != null) {
                            return msgReceiveModelInter.msg_receive_from;
                        }
                        return -1;
                    } else if (ChatManager.clientType != ChatManager.ClientType.CHINA || (msgReceiveModelChina = (MsgReceiveModelChina) gson2.fromJson(str, (Class<Object>) MsgReceiveModelChina.class)) == null || msgReceiveModelChina.msgSource == null) {
                        return -1;
                    } else {
                        return msgReceiveModelChina.msgSource.type;
                    }
                }
                return -1;
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static SendMsgPackage getSendMsgPackageFromChattingModel(ChattingModel chattingModel) {
        long j = chattingModel.sessionId;
        long j2 = j;
        if (chattingModel.isMatchMsg == 1) {
            j2 = j;
            if (j < 0) {
                j2 = -j;
            }
        }
        return new SendMsgPackage(chattingModel.sessionType, j2, chattingModel.msgLocalId, chattingModel.msgTimestamp, chattingModel.msgType, chattingModel.msgContent, chattingModel.msgAt, chattingModel.getMsgExtra(), chattingModel.fromId, chattingModel.fromNickName);
    }

    public static Pair<Short, Long> getSessionTypeAndId(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\*");
        Pair<Short, Long> pair = null;
        if (split.length == 2) {
            pair = new Pair<>(Short.valueOf(split[0]), Long.valueOf(split[1]));
        }
        return pair;
    }

    public static boolean isAtSelf(ChattingModel chattingModel) {
        return AtRegExpUtils.isAtSelf(chattingModel.msgAt);
    }

    public static boolean isHasAtValue(ChattingModel chattingModel) {
        return !TextUtils.isEmpty(chattingModel.msgAt);
    }

    public static boolean isIgnoreNotifyMsgType(ChattingModel chattingModel) {
        List listValue;
        if (ChatManager.clientType == ChatManager.ClientType.INTERNATIONAL) {
            if (chattingModel.msgType == 14 || chattingModel.msgType == 12) {
                return true;
            }
            if (chattingModel.msgType == 13) {
                return chattingModel.msgMapExtra == null || (listValue = MsgPackHelper.getListValue(chattingModel.msgMapExtra, "kicked_uid")) == null || !listValue.contains(Long.valueOf(ChatManager.userInfo.uid));
            }
        }
        if (chattingModel.msgType == 287) {
            return true;
        }
        if (chattingModel.msgType != 169) {
            return false;
        }
        if (chattingModel.msgMapExtra == null && !TextUtils.isEmpty(chattingModel.getMsgExtra())) {
            chattingModel.msgMapExtra = (Map) new Gson().fromJson(chattingModel.getMsgExtra(), (Class<Object>) HashMap.class);
        }
        return chattingModel.msgMapExtra == null || MsgPackHelper.getIntValue(chattingModel.msgMapExtra, "notify_flag") != 1;
    }

    public static boolean isLocalViewMsg(short s) {
        return s < 0;
    }

    public static void setLikeStatus(SessionModel sessionModel, ChattingModel chattingModel) {
        if (sessionModel.sessionType == 2 && chattingModel.msgType == 168) {
            if (ChatManager.clientType == ChatManager.ClientType.INTERNATIONAL) {
                sessionModel.friend = 1;
            }
            if (chattingModel.isFromSelf()) {
                return;
            }
            sessionModel.likeNumUnread++;
        }
    }

    public static void setSessionSourceFrom(SessionModel sessionModel, ChattingModel chattingModel) {
        int msgReceiveFrom;
        if (sessionModel.sessionType != 2 || TextUtils.isEmpty(chattingModel.getMsgExtra()) || (msgReceiveFrom = getMsgReceiveFrom(chattingModel.getMsgExtra())) == -1 || msgReceiveFrom == sessionModel.sourceFrom) {
            return;
        }
        sessionModel.sourceFrom = msgReceiveFrom;
        String str = TAG;
        Log.v(str, "sourceFrom:" + msgReceiveFrom);
    }

    public static short transformIosSendStateToAndroid(short s) {
        switch (s) {
            case 1:
                return (short) 1;
            case 2:
            case 6:
                return (short) 6;
            case 3:
                return (short) 2;
            case 4:
                return (short) 3;
            case 5:
                return (short) 7;
            case 7:
                return (short) 5;
            default:
                return (short) 0;
        }
    }
}
