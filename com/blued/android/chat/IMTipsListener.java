package com.blued.android.chat;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.android.internal.telephony.SmsConstants;
import com.anythink.core.common.g.c;
import com.blued.android.chat.listener.ChatTipsListener;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.listener.LoadMsgListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.live_china.R;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.biz.Event;
import com.blued.das.message.MessageProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.ChatConstants;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.manager.FollowedUsersNotificationManager;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.customview.GlobalTaskFloatManager;
import com.soft.blued.ui.msg.manager.FlashPhotoManager;
import com.soft.blued.ui.msg.manager.GiftPlayer;
import com.soft.blued.ui.msg.manager.SubscribeNumberManager;
import com.soft.blued.ui.msg.manager.UserPagerGiftManager;
import com.soft.blued.ui.msg.model.FlashNumberModel;
import com.soft.blued.ui.msg.model.MsgExtraGift;
import com.soft.blued.ui.msg.model.ServiceMsgReplyModel;
import com.soft.blued.ui.msg.observer.RecvMsgListenerObserver;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/IMTipsListener.class */
public class IMTipsListener implements ChatTipsListener {
    private static final long MIN_NOTIFY_DIFF_MS = 500;
    private static final String TAG = "IMTipsListener";
    private long lastNotifyTime = 0;
    public final NotifyMsgRecv recvMsgTask = new NotifyMsgRecv();

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/IMTipsListener$NotifyMsgRecv.class */
    class NotifyMsgRecv implements Runnable {
        ChattingModel _msgData;
        SessionModel _sessionModel;

        private NotifyMsgRecv() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatHelperV4.a().a(AppInfo.d(), this._sessionModel, this._msgData);
            RecvMsgListenerObserver.a().a(this._sessionModel, this._msgData);
        }

        public void setMsgData(SessionModel sessionModel, ChattingModel chattingModel) {
            this._sessionModel = sessionModel;
            this._msgData = chattingModel;
        }
    }

    private void filterServiceMsg(SessionModel sessionModel, ChattingModel chattingModel) {
        if (SubscribeNumberManager.a.a(chattingModel.sessionId, chattingModel.sessionType)) {
            LiveEventBus.get("service_new_msg").post(chattingModel);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v46, types: [int] */
    /* JADX WARN: Type inference failed for: r0v53, types: [int] */
    private void filterUserPagerGiftMsg(SessionModel sessionModel, final ChattingModel chattingModel) {
        byte b;
        byte b2;
        StringBuilder sb = new StringBuilder();
        sb.append("msgMapExtra===");
        sb.append(chattingModel.msgMapExtra);
        Logger.c(TAG, new Object[]{Boolean.valueOf(sb.toString() == null)});
        if (chattingModel.msgType != 164) {
            return;
        }
        Logger.c("filterUserPagerGiftMsg===" + UserPagerGiftManager.a().c(), new Object[0]);
        if (UserPagerGiftManager.a().c() == chattingModel.sessionId) {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.chat.IMTipsListener.2
                @Override // java.lang.Runnable
                public void run() {
                    GiftPlayer b3 = UserPagerGiftManager.a().b();
                    if (b3 != null) {
                        b3.b(chattingModel);
                    }
                }
            });
            return;
        }
        sessionModel.lastGiftMsgId = chattingModel.msgId;
        MsgExtraGift msgExtraGift = (MsgExtraGift) AppInfo.f().fromJson(chattingModel.getMsgExtra(), MsgExtraGift.class);
        if (msgExtraGift != null && msgExtraGift.gift_like != null) {
            byte[] a = UserPagerGiftManager.a(sessionModel.unreadGiftCnt);
            byte b3 = a[0];
            byte b4 = a[1];
            if (msgExtraGift.gift_like.giftTye == 3) {
                b = b4;
                b2 = b3;
                if (b4 < 99) {
                    b = b4 + 1;
                    b2 = b3;
                }
            } else {
                b = b4;
                b2 = b3;
                if (b3 < 99) {
                    b2 = b3 + 1;
                    b = b4;
                }
            }
            sessionModel.unreadGiftCnt = (b << 8) + b2;
        }
        handleTopGift(sessionModel, msgExtraGift);
        ChatManager.getInstance().updateSessionUnreadGiftCnt(sessionModel.sessionType, sessionModel.sessionId, sessionModel.unreadGiftCnt, chattingModel.msgId);
    }

    private void handleTopGift(SessionModel sessionModel, MsgExtraGift msgExtraGift) {
        if (msgExtraGift == null || msgExtraGift.gift_like == null || msgExtraGift.gift_like.giftTye != 2) {
            return;
        }
        if (sessionModel.expireTime != 0 && System.currentTimeMillis() > sessionModel.expireTime) {
            sessionModel.totalMoney = msgExtraGift.gift_like.money;
            sessionModel.expireTime = System.currentTimeMillis() + (msgExtraGift.gift_like.topTime * 1000);
            return;
        }
        sessionModel.totalMoney += msgExtraGift.gift_like.money;
        if (sessionModel.expireTime < System.currentTimeMillis() + (msgExtraGift.gift_like.topTime * 1000)) {
            sessionModel.expireTime = System.currentTimeMillis() + (msgExtraGift.gift_like.topTime * 1000);
        }
    }

    private void insertDisturbNotice(long j) {
        ChatManager.getInstance().getSessionModel((short) 2, j, new FetchDataListener<SessionModel>() { // from class: com.blued.android.chat.IMTipsListener.5
            @Override // com.blued.android.chat.listener.FetchDataListener
            public void onFetchData(SessionModel sessionModel) {
                if (sessionModel == null || sessionModel._msgList == null) {
                    Logger.c(IMTipsListener.TAG, new Object[]{"onFetchData=SessionModel=" + sessionModel});
                    return;
                }
                ChattingModel chattingModel = sessionModel._msgList.get(sessionModel._msgList.size() - 1);
                String string = AppInfo.d().getResources().getString(2131887500);
                ChattingModel chattingModel2 = new ChattingModel(chattingModel);
                chattingModel2.msgLocalId = ChatHelper.getLocalId();
                chattingModel2.msgType = (short) -3;
                chattingModel2.msgContent = string;
                ChatHelperV4.a().h(chattingModel2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReplyServiceMsg(final ChattingModel chattingModel) {
        SubscribeNumberManager subscribeNumberManager = SubscribeNumberManager.a;
        if (subscribeNumberManager.a(chattingModel.sessionId + "", Short.valueOf(chattingModel.sessionType))) {
            String str = chattingModel.msgType == 1 ? chattingModel.msgContent : "";
            BluedUIHttpResponse<BluedEntityA<ServiceMsgReplyModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<ServiceMsgReplyModel>>(null) { // from class: com.blued.android.chat.IMTipsListener.8
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntityA<ServiceMsgReplyModel> bluedEntityA) {
                    if (bluedEntityA == null || bluedEntityA.getSingleData() == null || bluedEntityA.getSingleData().reply_type == 0) {
                        return;
                    }
                    MessageProtos.Event event = MessageProtos.Event.SERVICE_MSG_PAGE_AUTO_REPLY;
                    EventTrackMessage.f(event, chattingModel.sessionId + "", bluedEntityA.getSingleData().reply_type == 1 ? "keyword" : c.Z);
                }
            };
            ChatHttpUtils.a(bluedUIHttpResponse, chattingModel.sessionId + "", 0, 0, 0, str, chattingModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshFlashNumbers(int i, String str, boolean z) {
        if (i == 25 || i == 24) {
            FlashPhotoManager.a().a(new FlashPhotoManager.FlashPhotoModelSuccessListener() { // from class: com.blued.android.chat.IMTipsListener.7
                public void onSuccess(BluedEntityA<FlashNumberModel> bluedEntityA) {
                    LiveEventBus.get("refresh_flash_tip").post(true);
                }
            });
        }
    }

    private void setNoDisturbance(SessionModel sessionModel, ChattingModel chattingModel) {
        if (chattingModel.sessionType != 2 || sessionModel == null) {
            return;
        }
        SessionSettingModel sessionSettingModel = null;
        if (sessionModel.sessionSettingModel != null) {
            sessionSettingModel = (SessionSettingModel) sessionModel.sessionSettingModel;
        }
        if (sessionSettingModel != null) {
            if (sessionSettingModel.getRemindAudio() != chattingModel.status) {
                sessionSettingModel.setRemindAudio(chattingModel.status);
                ChatManager.getInstance().setSessionSetting(chattingModel.sessionType, chattingModel.sessionId, sessionSettingModel);
            }
            if (TextUtils.equals(sessionSettingModel.getSessionCommonStatus(), chattingModel.session_common_status)) {
                return;
            }
            sessionSettingModel.setSessionCommonStatus(chattingModel.session_common_status);
            ChatManager.getInstance().setSessionSetting(chattingModel.sessionType, chattingModel.sessionId, sessionSettingModel);
            return;
        }
        if (chattingModel.status != ChatConstants.b) {
            SessionSettingModel sessionSettingModel2 = new SessionSettingModel();
            sessionSettingModel2.setLoadName(Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue());
            sessionSettingModel2.setSessionId(chattingModel.sessionId);
            sessionSettingModel2.setSessionType((short) 2);
            sessionSettingModel2.setRemindAudio(chattingModel.status);
            ChatManager.getInstance().setSessionSetting(chattingModel.sessionType, chattingModel.sessionId, sessionSettingModel2);
        }
        if (TextUtils.equals(chattingModel.session_common_status, ChatConstants.c)) {
            return;
        }
        SessionSettingModel sessionSettingModel3 = new SessionSettingModel();
        sessionSettingModel3.setLoadName(Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue());
        sessionSettingModel3.setSessionId(chattingModel.sessionId);
        sessionSettingModel3.setSessionType((short) 2);
        sessionSettingModel3.setSessionCommonStatus(chattingModel.session_common_status);
        ChatManager.getInstance().setSessionSetting(chattingModel.sessionType, chattingModel.sessionId, sessionSettingModel3);
    }

    private void updateBurnMsg(short s, long j, int i, long j2, long j3) {
        ChatManager.getInstance().findMessage(s, j, j2, j3, new LoadMsgListener() { // from class: com.blued.android.chat.IMTipsListener.4
            @Override // com.blued.android.chat.listener.LoadMsgListener
            public void onLoadFinish(List<ChattingModel> list) {
                if (list == null || list.size() <= 0) {
                    return;
                }
                ChattingModel chattingModel = list.get(0);
                String msgExtra = chattingModel.getMsgExtra();
                JSONObject parseObject = !TextUtils.isEmpty(msgExtra) ? JSONObject.parseObject(msgExtra) : new JSONObject();
                parseObject.put("illegal", (Object) true);
                chattingModel.setMsgExtra(parseObject.toJSONString());
                ChatManager.getInstance().updateMsgOneData(chattingModel);
            }
        });
    }

    @Override // com.blued.android.chat.listener.ChatTipsListener
    public void onBusyCalling(long j) {
    }

    @Override // com.blued.android.chat.listener.ChatTipsListener
    public void onConnectException(String str) {
        Logger.e(TAG, new Object[]{"onConnectException(), exception:" + str});
    }

    @Override // com.blued.android.chat.listener.ChatTipsListener
    public void onDisconnect(int i, String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            string = AppInfo.d().getResources().getString(2131886266);
            if (i == 3) {
                string = AppInfo.d().getResources().getString(2131886269);
            } else if (i == 4) {
                string = AppInfo.d().getResources().getString(2131886268);
            }
        } else {
            string = str;
        }
        Event c = BluedStatistics.c();
        c.a("IM_KICK_OFF", 0L, i, str + "；" + string);
        UserRelationshipUtils.a(string, new int[]{1});
    }

    @Override // com.blued.android.chat.listener.ChatTipsListener
    public void onReceiveNotification(ChattingModel chattingModel) {
        FollowedUsersNotificationManager.a.a(chattingModel);
    }

    @Override // com.blued.android.chat.listener.ChatTipsListener
    public void onRecvNewMsg(SessionModel sessionModel, ChattingModel chattingModel) {
        if (chattingModel.msgType == 208) {
            if (TextUtils.isEmpty(chattingModel.msgContent)) {
                return;
            }
            Logger.c(TAG, new Object[]{"MT_TASK_PROGRESS: " + chattingModel.msgContent});
            try {
                final GlobalTaskFloatManager.TaskInfo taskInfo = (GlobalTaskFloatManager.TaskInfo) AppInfo.f().fromJson(chattingModel.msgContent, GlobalTaskFloatManager.TaskInfo.class);
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.chat.IMTipsListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GlobalTaskFloatManager.a().a(taskInfo);
                    }
                });
                return;
            } catch (Throwable th) {
                return;
            }
        }
        setNoDisturbance(sessionModel, chattingModel);
        filterUserPagerGiftMsg(sessionModel, chattingModel);
        filterServiceMsg(sessionModel, chattingModel);
        this.recvMsgTask.setMsgData(sessionModel, chattingModel);
        AppInfo.n().removeCallbacks(this.recvMsgTask);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastNotifyTime < MIN_NOTIFY_DIFF_MS) {
            AppInfo.n().postDelayed(this.recvMsgTask, MIN_NOTIFY_DIFF_MS);
            return;
        }
        this.lastNotifyTime = currentTimeMillis;
        AppInfo.n().post(this.recvMsgTask);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.blued.android.chat.listener.ChatTipsListener
    public void onSendMsgFailed(short s, long j, int i, long j2, long j3, int i2) {
        String string;
        boolean z;
        String str;
        if (i2 != -2) {
            if (i2 != 21) {
                switch (i2) {
                    case 3:
                        string = AppInfo.d().getString(2131890918);
                        z = true;
                        break;
                    case 4:
                        string = AppInfo.d().getString(2131890919);
                        z = true;
                        break;
                    case 5:
                        if (s != 3) {
                            string = AppInfo.d().getString(2131890926);
                            z = true;
                            break;
                        } else {
                            string = AppInfo.d().getString(2131888473);
                            z = true;
                            break;
                        }
                    case 6:
                        ChatManager.getInstance().getSessionSettingModel(s, j, new FetchDataListener<SessionSettingBaseModel>() { // from class: com.blued.android.chat.IMTipsListener.3
                            @Override // com.blued.android.chat.listener.FetchDataListener
                            public void onFetchData(SessionSettingBaseModel sessionSettingBaseModel) {
                                if (TextUtils.equals(((SessionSettingModel) sessionSettingBaseModel).getSessionCommonStatus(), "1")) {
                                    AppMethods.d(2131890875);
                                } else {
                                    AppMethods.d(2131890927);
                                }
                            }
                        });
                        string = AppInfo.d().getString(2131890927);
                        z = false;
                        break;
                    case 7:
                        string = AppInfo.d().getString(2131890925);
                        z = true;
                        break;
                    case 8:
                        string = AppInfo.d().getString(2131890931);
                        z = true;
                        break;
                    case 9:
                        string = AppInfo.d().getString(2131890924);
                        z = true;
                        break;
                    case 10:
                        string = AppInfo.d().getString(2131890917);
                        z = true;
                        break;
                    case 11:
                        string = AppInfo.d().getString(2131890923);
                        z = true;
                        break;
                    case 12:
                        string = AppInfo.d().getString(2131890922);
                        z = true;
                        break;
                    case 13:
                        string = AppInfo.d().getString(R.string.liveVideo_livingView_tips_forbidedToSpeak);
                        z = true;
                        break;
                    case 14:
                        string = AppInfo.d().getString(R.string.liveVideo_message_tips_toofrequent);
                        z = true;
                        break;
                    case 15:
                        string = AppInfo.d().getString(2131888474);
                        z = true;
                        break;
                    default:
                        switch (i2) {
                            case 17:
                                string = AppInfo.d().getString(2131890920);
                                z = true;
                                break;
                            case 18:
                                insertDisturbNotice(j);
                                break;
                            case 19:
                                string = AppInfo.d().getString(2131888576);
                                z = true;
                                break;
                        }
                }
            } else {
                updateBurnMsg(s, j, i, j2, j3);
            }
            string = null;
            z = true;
        } else {
            string = AppInfo.d().getString(2131890928);
            z = true;
        }
        refreshFlashNumbers(i, j + "", false);
        if (TextUtils.isEmpty(string)) {
            str = SmsConstants.FORMAT_UNKNOWN;
        } else {
            str = string;
            if (z) {
                AppMethods.a((CharSequence) string);
                str = string;
            }
        }
        EventTrackMessage.d(MessageProtos.Event.MSG_SEND_FAIL, i + "", str);
    }

    @Override // com.blued.android.chat.listener.ChatTipsListener
    public void onSendMsgFailed(short s, long j, String str) {
    }

    @Override // com.blued.android.chat.listener.ChatTipsListener
    public void onSendMsgSucceed(final ChattingModel chattingModel) {
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.chat.IMTipsListener.6
            @Override // java.lang.Runnable
            public void run() {
                if (chattingModel.msgType == 267) {
                    ChatManager.getInstance().deleteOneMessage(chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgId, chattingModel.msgLocalId);
                }
                Logger.c(IMTipsListener.TAG, new Object[]{"onSendMsgSucceed : " + ((int) chattingModel.sessionType) + " | " + chattingModel.sessionId});
                IMTipsListener iMTipsListener = IMTipsListener.this;
                short s = chattingModel.msgType;
                iMTipsListener.refreshFlashNumbers(s, chattingModel.sessionId + "", true);
                IMTipsListener.this.onReplyServiceMsg(chattingModel);
                BluedPreferences.B(chattingModel.msgTimestamp);
                LiveEventBus.get("msg_send_succeed").post(chattingModel);
            }
        });
    }

    @Override // com.blued.android.chat.listener.ChatTipsListener
    public void onVideoCalling(long j, int i) {
    }

    @Override // com.blued.android.chat.listener.ChatTipsListener
    public void onVideoCallingCancel(long j, int i) {
        ChatHelperV4.a().c();
    }
}
