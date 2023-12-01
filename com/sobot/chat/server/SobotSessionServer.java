package com.sobot.chat.server;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.sobot.chat.ZCSobotApi;
import com.sobot.chat.api.apiUtils.ZhiChiConstants;
import com.sobot.chat.api.enumtype.CustomerState;
import com.sobot.chat.api.enumtype.SobotChatStatusMode;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.api.model.ZhiChiInitModeBase;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.api.model.ZhiChiPushMessage;
import com.sobot.chat.api.model.ZhiChiReplyAnswer;
import com.sobot.chat.application.MyApplication;
import com.sobot.chat.core.channel.Const;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.NotificationUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.SobotOption;
import com.sobot.chat.utils.Util;
import com.sobot.chat.utils.ZhiChiConfig;
import com.sobot.chat.utils.ZhiChiConstant;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/server/SobotSessionServer.class */
public class SobotSessionServer extends Service {
    private LocalBroadcastManager localBroadcastManager;
    private MyMessageReceiver receiver;
    private MyNetWorkChangeReceiver receiverNet;
    private int tmpNotificationId = 0;
    private String currentUid = "";
    private Information info = null;
    private ZhiChiConfig config = null;
    private boolean isStartTimer = false;
    protected Timer timer = null;
    protected TimerTask task = null;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/server/SobotSessionServer$MyMessageReceiver.class */
    public class MyMessageReceiver extends BroadcastReceiver {
        public MyMessageReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ZhiChiPushMessage zhiChiPushMessage;
            Bundle extras;
            if (ZhiChiConstants.receiveMessageBrocast.equals(intent.getAction())) {
                try {
                    Bundle extras2 = intent.getExtras();
                    if (extras2 == null || (zhiChiPushMessage = (ZhiChiPushMessage) extras2.getSerializable(ZhiChiConstants.ZHICHI_PUSH_MESSAGE)) == null || !SobotSessionServer.this.isNeedShowMessage(zhiChiPushMessage.getAppId())) {
                        return;
                    }
                    SobotSessionServer.this.receiveMessage(context, zhiChiPushMessage);
                } catch (Exception e) {
                }
            } else if (!ZhiChiConstants.SOBOT_TIMER_BROCAST.equals(intent.getAction()) || (extras = intent.getExtras()) == null) {
            } else {
                SobotSessionServer.this.isStartTimer = extras.getBoolean("isStartTimer");
                if (!SobotSessionServer.this.isStartTimer) {
                    SobotSessionServer.this.stopTimeTask();
                    return;
                }
                SobotSessionServer.this.info = (Information) extras.getSerializable("info");
                SobotSessionServer sobotSessionServer = SobotSessionServer.this;
                sobotSessionServer.config = SobotMsgManager.getInstance(sobotSessionServer.getApplicationContext()).getConfig(SobotSessionServer.this.info.getApp_key());
                if (SobotSessionServer.this.config.getInitModel() == null || SobotSessionServer.this.config.customerState != CustomerState.Online) {
                    return;
                }
                SobotSessionServer.this.startTimeTask();
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/server/SobotSessionServer$MyNetWorkChangeReceiver.class */
    public class MyNetWorkChangeReceiver extends BroadcastReceiver {
        public MyNetWorkChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LogUtils.i("MyNetWorkChangeReceiver action=" + intent.getAction());
            if (context == null || intent == null) {
                return;
            }
            Util.hasNetWork(SobotSessionServer.this.getApplicationContext());
        }
    }

    private void createCustomerQueue(String str, String str2, String str3) {
        ZhiChiInitModeBase initModel;
        ZhiChiConfig config = SobotMsgManager.getInstance(getApplication()).getConfig(str);
        if (config.customerState != CustomerState.Queuing || TextUtils.isEmpty(str2) || Integer.parseInt(str2) <= 0 || (initModel = config.getInitModel()) == null) {
            return;
        }
        int parseInt = Integer.parseInt(initModel.getType());
        config.queueNum = Integer.parseInt(str2);
        if (config.isShowQueueTip && !TextUtils.isEmpty(str3)) {
            config.addMessage(ChatUtils.getInLineHint(str3));
        }
        if (parseInt == 2) {
            config.activityTitle = ChatUtils.getLogicTitle(getApplicationContext(), false, getResString("sobot_in_line"), initModel.getCompanyName());
            config.bottomViewtype = 3;
            return;
        }
        config.activityTitle = ChatUtils.getLogicTitle(getApplicationContext(), false, initModel.getRobotName(), initModel.getCompanyName());
        config.bottomViewtype = 5;
    }

    private void createCustomerService(Context context, String str, String str2, String str3, ZhiChiPushMessage zhiChiPushMessage) {
        ZhiChiConfig config = SobotMsgManager.getInstance(getApplication()).getConfig(str);
        ZhiChiInitModeBase initModel = config.getInitModel();
        if (initModel == null) {
            return;
        }
        config.current_client_model = 302;
        if (SobotOption.sobotChatStatusListener != null) {
            SobotOption.sobotChatStatusListener.onChatStatusListener(SobotChatStatusMode.ZCServerConnectArtificial);
        }
        config.customerState = CustomerState.Online;
        config.isAboveZero = false;
        config.isComment = false;
        config.queueNum = 0;
        config.currentUserName = TextUtils.isEmpty(str2) ? "" : str2;
        config.addMessage(ChatUtils.getServiceAcceptTip(getApplicationContext(), str2));
        if (isNeedShowMessage(zhiChiPushMessage.getAppId())) {
            showNotification(getResString("sobot_receive_new_message"), zhiChiPushMessage, false);
        }
        sendBroadcast(zhiChiPushMessage, ChatUtils.getResString(context, "sobot_service_accept_start") + " " + str2 + " " + ChatUtils.getResString(context, "sobot_service_accept_end"), false);
        if (initModel.isAdminHelloWordFlag()) {
            String admin_hello_word = ZCSobotApi.getCurrentInfoSetting(getApplicationContext()) != null ? ZCSobotApi.getCurrentInfoSetting(getApplicationContext()).getAdmin_hello_word() : "";
            if (TextUtils.isEmpty(admin_hello_word)) {
                config.addMessage(ChatUtils.getServiceHelloTip(str2, str3, initModel.getAdminHelloWord()));
            } else {
                config.addMessage(ChatUtils.getServiceHelloTip(str2, str3, admin_hello_word));
            }
        }
        config.activityTitle = ChatUtils.getLogicTitle(getApplicationContext(), false, str2, initModel.getCompanyName());
        config.bottomViewtype = 2;
        config.userInfoTimeTask = true;
        config.customTimeTask = false;
        config.isProcessAutoSendMsg = true;
        config.hideItemTransferBtn();
        if (isNeedShowMessage(str)) {
            showNotification(String.format(getResString("sobot_service_accept"), config.currentUserName), zhiChiPushMessage, true);
        }
    }

    private int getNotificationId() {
        if (this.tmpNotificationId == 999) {
            this.tmpNotificationId = 0;
        }
        int i = this.tmpNotificationId + 1;
        this.tmpNotificationId = i;
        return i;
    }

    private void initBrocastReceiver() {
        if (this.receiver == null) {
            this.receiver = new MyMessageReceiver();
        }
        if (this.receiverNet == null) {
            this.receiverNet = new MyNetWorkChangeReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ZhiChiConstants.receiveMessageBrocast);
        intentFilter.addAction(ZhiChiConstants.SOBOT_TIMER_BROCAST);
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        this.localBroadcastManager = localBroadcastManager;
        localBroadcastManager.registerReceiver(this.receiver, intentFilter);
        registerReceiver(this.receiverNet, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedShowMessage(String str) {
        String stringData = SharedPreferencesUtil.getStringData(getApplicationContext(), ZhiChiConstant.SOBOT_CURRENT_IM_APPID, "");
        String str2 = "";
        try {
            if (MyApplication.getInstance().getLastActivity() != null) {
                str2 = MyApplication.getInstance().getLastActivity().getComponentName().getClassName();
            }
        } catch (Exception e) {
            e.printStackTrace();
            str2 = "";
        }
        return (stringData.equals(str) && str2.contains("SobotChatActivity") && !CommonUtils.isScreenLock(getApplicationContext())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void receiveMessage(Context context, ZhiChiPushMessage zhiChiPushMessage) {
        List<ZhiChiMessageBase> messageList;
        int i;
        String str;
        if (zhiChiPushMessage == null) {
            return;
        }
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
        zhiChiMessageBase.setSenderName(zhiChiPushMessage.getAname());
        this.config = SobotMsgManager.getInstance(getApplication()).getConfig(zhiChiPushMessage.getAppId());
        if (200 == zhiChiPushMessage.getType()) {
            if (this.config.getInitModel() != null) {
                this.config.adminFace = zhiChiPushMessage.getAface();
                Integer.parseInt(this.config.getInitModel().getType());
                ZhiChiInitModeBase initModel = this.config.getInitModel();
                if (initModel != null) {
                    initModel.setAdminHelloWord(!TextUtils.isEmpty(zhiChiPushMessage.getAdminHelloWord()) ? zhiChiPushMessage.getAdminHelloWord() : initModel.getAdminHelloWord());
                    initModel.setServiceEndPushMsg(!TextUtils.isEmpty(zhiChiPushMessage.getServiceEndPushMsg()) ? zhiChiPushMessage.getServiceEndPushMsg() : initModel.getServiceEndPushMsg());
                    initModel.setAdminTipTime(!TextUtils.isEmpty(zhiChiPushMessage.getServiceOutTime()) ? zhiChiPushMessage.getServiceOutTime() : initModel.getAdminTipTime());
                    initModel.setAdminTipWord(!TextUtils.isEmpty(zhiChiPushMessage.getServiceOutDoc()) ? zhiChiPushMessage.getServiceOutDoc() : initModel.getAdminTipWord());
                }
                createCustomerService(context, zhiChiPushMessage.getAppId(), zhiChiPushMessage.getAname(), zhiChiPushMessage.getAface(), zhiChiPushMessage);
            }
        } else if (202 == zhiChiPushMessage.getType()) {
            if (this.config.getInitModel() != null && this.config.customerState == CustomerState.Online) {
                zhiChiMessageBase.setMsgId(zhiChiPushMessage.getMsgId());
                zhiChiMessageBase.setSender(zhiChiPushMessage.getAname());
                zhiChiMessageBase.setSenderName(zhiChiPushMessage.getAname());
                zhiChiMessageBase.setSenderFace(zhiChiPushMessage.getAface());
                zhiChiMessageBase.setOrderCardContent(zhiChiPushMessage.getOrderCardContent());
                zhiChiMessageBase.setConsultingContent(zhiChiPushMessage.getConsultingContent());
                zhiChiMessageBase.setSenderType("2");
                zhiChiMessageBase.setAnswer(zhiChiPushMessage.getAnswer());
                if (this.config.isShowUnreadUi) {
                    this.config.addMessage(ChatUtils.getUnreadMode(getApplicationContext()));
                    this.config.isShowUnreadUi = false;
                }
                this.config.addMessage(zhiChiMessageBase);
                if (this.config.customerState == CustomerState.Online) {
                    this.config.customTimeTask = false;
                    this.config.userInfoTimeTask = true;
                }
            }
            if (isNeedShowMessage(zhiChiPushMessage.getAppId())) {
                try {
                    JSONObject jSONObject = new JSONObject(zhiChiPushMessage.getContent());
                    str = jSONObject.optString("msg");
                    i = jSONObject.optInt("msgType");
                } catch (JSONException e) {
                    e.printStackTrace();
                    i = -1;
                    str = "";
                }
                if (i == -1 || TextUtils.isEmpty(str)) {
                    return;
                }
                if (i == 4 || i == 5) {
                    ResourceUtils.getResString(this, "sobot_chat_type_rich_text");
                    ResourceUtils.getResString(this, "sobot_receive_new_message");
                } else if (i == 1) {
                    ResourceUtils.getResString(this, "sobot_upload");
                    ResourceUtils.getResString(this, "sobot_upload");
                }
                showNotification(getResString("sobot_receive_new_message"), zhiChiPushMessage, true);
                sendBroadcast(zhiChiPushMessage, getResString("sobot_receive_new_message"), true);
            }
        } else if (215 == zhiChiPushMessage.getType()) {
            if (this.config.getInitModel() != null) {
                zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
                zhiChiMessageBase.setMsgId(zhiChiPushMessage.getMsgId());
                zhiChiMessageBase.setSender(zhiChiPushMessage.getAname());
                zhiChiMessageBase.setSenderName(zhiChiPushMessage.getAname());
                zhiChiMessageBase.setSenderFace(zhiChiPushMessage.getAface());
                if (TextUtils.isEmpty(zhiChiPushMessage.getSysType()) || !("1".equals(zhiChiPushMessage.getSysType()) || "2".equals(zhiChiPushMessage.getSysType()) || "5".equals(zhiChiPushMessage.getSysType()))) {
                    zhiChiMessageBase.setAction("29");
                    zhiChiMessageBase.setMsgId(zhiChiPushMessage.getMsgId());
                    zhiChiMessageBase.setMsg(zhiChiPushMessage.getContent());
                } else {
                    zhiChiMessageBase.setSenderType("2");
                    ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
                    zhiChiReplyAnswer.setMsg(zhiChiPushMessage.getContent());
                    zhiChiReplyAnswer.setMsgType("0");
                    zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
                }
                this.config.addMessage(zhiChiMessageBase);
                if (this.config.customerState == CustomerState.Online) {
                    this.config.customTimeTask = false;
                    this.config.userInfoTimeTask = true;
                }
                if (isNeedShowMessage(zhiChiPushMessage.getAppId())) {
                    showNotification(zhiChiPushMessage.getContent(), zhiChiPushMessage, false);
                }
                sendBroadcast(zhiChiPushMessage, zhiChiPushMessage.getContent(), false);
            }
        } else if (201 == zhiChiPushMessage.getType()) {
            if (this.config.getInitModel() != null) {
                createCustomerQueue(zhiChiPushMessage.getAppId(), zhiChiPushMessage.getCount(), zhiChiPushMessage.getQueueDoc());
                if (isNeedShowMessage(zhiChiPushMessage.getAppId())) {
                    showNotification(zhiChiPushMessage.getQueueDoc(), zhiChiPushMessage, false);
                }
                sendBroadcast(zhiChiPushMessage, zhiChiPushMessage.getQueueDoc(), false);
            }
        } else if (204 == zhiChiPushMessage.getType()) {
            if (SobotOption.sobotChatStatusListener != null) {
                SobotOption.sobotChatStatusListener.onChatStatusListener(SobotChatStatusMode.ZCServerConnectOffline);
            }
            SobotMsgManager.getInstance(getApplication()).clearAllConfig();
            CommonUtils.sendLocalBroadcast(getApplicationContext(), new Intent(Const.SOBOT_CHAT_USER_OUTLINE));
            if (isNeedShowMessage(zhiChiPushMessage.getAppId())) {
                showNotification(getResString("sobot_dialogue_finish"), zhiChiPushMessage, false);
            }
            sendBroadcast(zhiChiPushMessage, getResString("sobot_dialogue_finish"), false);
        } else if (210 == zhiChiPushMessage.getType()) {
            if (this.config.getInitModel() != null) {
                LogUtils.i("用户被转接--->" + zhiChiPushMessage.getName());
                this.config.activityTitle = zhiChiPushMessage.getName();
                this.config.adminFace = zhiChiPushMessage.getFace();
                this.config.currentUserName = zhiChiPushMessage.getName();
                if (isNeedShowMessage(zhiChiPushMessage.getAppId())) {
                    showNotification(ChatUtils.getResString(context, "sobot_service_accept_start") + " " + zhiChiPushMessage.getName() + " " + ChatUtils.getResString(context, "sobot_service_accept_end"), zhiChiPushMessage, false);
                }
                sendBroadcast(zhiChiPushMessage, ChatUtils.getResString(context, "sobot_service_accept_start") + " " + zhiChiPushMessage.getName() + " " + ChatUtils.getResString(context, "sobot_service_accept_end"), false);
            }
        } else if (211 != zhiChiPushMessage.getType()) {
            if (209 != zhiChiPushMessage.getType()) {
                if (213 == zhiChiPushMessage.getType()) {
                    LogUtils.i("SobotSessionServer  ---> push_message_user_get_session_lock_msg---------------" + zhiChiPushMessage.getLockType());
                    if (this.config.getInitModel() == null || this.config.customerState != CustomerState.Online) {
                        return;
                    }
                    if (1 == zhiChiPushMessage.getLockType()) {
                        this.config.isChatLock = 1;
                        stopTimeTask();
                        return;
                    }
                    this.config.isChatLock = 2;
                    startTimeTask();
                }
            } else if (this.config.getInitModel() == null || !this.config.isAboveZero || this.config.isComment || this.config.customerState != CustomerState.Online) {
            } else {
                this.config.addMessage(ChatUtils.getCustomEvaluateMode(zhiChiPushMessage));
                if (isNeedShowMessage(zhiChiPushMessage.getAppId())) {
                    showNotification(getResString("sobot_cus_service") + " " + zhiChiPushMessage.getAname() + " " + getResString("sobot_please_evaluate"), zhiChiPushMessage, false);
                }
                sendBroadcast(zhiChiPushMessage, getResString("sobot_cus_service") + " " + zhiChiPushMessage.getAname() + " " + getResString("sobot_please_evaluate"), false);
            }
        } else if (this.config.getInitModel() == null || TextUtils.isEmpty(zhiChiPushMessage.getRevokeMsgId()) || (messageList = this.config.getMessageList()) == null || messageList.size() <= 0) {
        } else {
            int size = messageList.size();
            while (true) {
                int i2 = size - 1;
                if (i2 < 0) {
                    return;
                }
                ZhiChiMessageBase zhiChiMessageBase2 = messageList.get(i2);
                if (zhiChiPushMessage.getRevokeMsgId().equals(zhiChiMessageBase2.getMsgId())) {
                    zhiChiMessageBase2.setRetractedMsg(true);
                    return;
                }
                size = i2;
            }
        }
    }

    private void showNotification(String str, ZhiChiPushMessage zhiChiPushMessage, boolean z) {
        String str2;
        if (SharedPreferencesUtil.getBooleanData(getApplicationContext(), Const.SOBOT_NOTIFICATION_FLAG, false)) {
            String resString = ResourceUtils.getResString(getApplicationContext(), "sobot_notification_tip_title");
            if (TextUtils.isEmpty(zhiChiPushMessage.getAname()) || !z) {
                str2 = str;
            } else {
                str2 = getResString("sobot_cus_service") + " " + zhiChiPushMessage.getAname() + "：" + str;
            }
            NotificationUtils.createNotification(getApplicationContext(), resString, str2, str, getNotificationId(), zhiChiPushMessage);
        }
    }

    public String getResString(String str) {
        return ResourceUtils.getResString(this, str);
    }

    public int getResStringId(String str) {
        return ResourceUtils.getIdByName(getApplicationContext(), "string", str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        LogUtils.i("SobotSessionServer  ---> onCreate");
        initBrocastReceiver();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager localBroadcastManager = this.localBroadcastManager;
        if (localBroadcastManager != null) {
            localBroadcastManager.unregisterReceiver(this.receiver);
        }
        MyNetWorkChangeReceiver myNetWorkChangeReceiver = this.receiverNet;
        if (myNetWorkChangeReceiver != null) {
            unregisterReceiver(myNetWorkChangeReceiver);
        }
        stopTimeTask();
        LogUtils.i("SobotSessionServer  ---> onDestroy");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            this.currentUid = intent.getStringExtra(ZhiChiConstant.SOBOT_CURRENT_IM_PARTNERID);
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void sendBroadcast(ZhiChiPushMessage zhiChiPushMessage, String str, boolean z) {
        int unreadCount;
        if (z) {
            SobotMsgManager sobotMsgManager = SobotMsgManager.getInstance(getApplicationContext());
            unreadCount = sobotMsgManager.addUnreadCount(zhiChiPushMessage, Calendar.getInstance().getTime().getTime() + "", this.currentUid);
        } else {
            unreadCount = SobotMsgManager.getInstance(getApplicationContext()).getUnreadCount(zhiChiPushMessage.getAppId(), false, this.currentUid);
        }
        Intent intent = new Intent();
        intent.setAction(ZhiChiConstant.sobot_unreadCountBrocast);
        intent.putExtra("noReadCount", unreadCount);
        intent.putExtra("content", str);
        intent.putExtra("sobot_appId", zhiChiPushMessage.getAppId());
        Bundle bundle = new Bundle();
        bundle.putSerializable("sobotMessage", zhiChiPushMessage);
        intent.putExtras(bundle);
        CommonUtils.sendBroadcast(getApplicationContext(), intent);
    }

    public void startTimeTask() {
        this.timer = new Timer();
        TimerTask timerTask = new TimerTask() { // from class: com.sobot.chat.server.SobotSessionServer.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (SobotSessionServer.this.config.userInfoTimeTask) {
                    if (SobotSessionServer.this.config.paseReplyTimeCustoms > 1800) {
                        SobotSessionServer.this.stopTimeTask();
                        return;
                    }
                    SobotSessionServer.this.config.paseReplyTimeUserInfo++;
                } else if (SobotSessionServer.this.config.paseReplyTimeCustoms > 1800) {
                    SobotSessionServer.this.stopTimeTask();
                } else {
                    SobotSessionServer.this.config.paseReplyTimeCustoms++;
                }
            }
        };
        this.task = timerTask;
        this.timer.schedule(timerTask, 1000L, 1000L);
    }

    public void stopTimeTask() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
        TimerTask timerTask = this.task;
        if (timerTask != null) {
            timerTask.cancel();
            this.task = null;
        }
    }
}
