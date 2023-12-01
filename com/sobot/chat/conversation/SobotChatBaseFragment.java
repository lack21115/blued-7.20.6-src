package com.sobot.chat.conversation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.alipay.sdk.util.i;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.sobot.chat.SobotApi;
import com.sobot.chat.ZCSobotApi;
import com.sobot.chat.activity.SobotQueryFromActivity;
import com.sobot.chat.adapter.SobotMsgAdapter;
import com.sobot.chat.api.ResultCallBack;
import com.sobot.chat.api.apiUtils.GsonUtil;
import com.sobot.chat.api.enumtype.CustomerState;
import com.sobot.chat.api.enumtype.SobotAutoSendMsgMode;
import com.sobot.chat.api.model.BaseCode;
import com.sobot.chat.api.model.CommonModel;
import com.sobot.chat.api.model.CommonModelBase;
import com.sobot.chat.api.model.ConsultingContent;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.api.model.OrderCardContentModel;
import com.sobot.chat.api.model.SobotConnCusParam;
import com.sobot.chat.api.model.SobotLocationModel;
import com.sobot.chat.api.model.SobotQueryFormModel;
import com.sobot.chat.api.model.SobotQuestionRecommend;
import com.sobot.chat.api.model.SobotUserTicketInfoFlag;
import com.sobot.chat.api.model.ZhiChiInitModeBase;
import com.sobot.chat.api.model.ZhiChiMessage;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.api.model.ZhiChiReplyAnswer;
import com.sobot.chat.camera.util.FileUtil;
import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.core.channel.Const;
import com.sobot.chat.core.channel.LimitQueue;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.fragment.SobotBaseFragment;
import com.sobot.chat.notchlib.INotchScreen;
import com.sobot.chat.notchlib.NotchScreenManager;
import com.sobot.chat.utils.AudioTools;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.FileOpenHelper;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.MD5Util;
import com.sobot.chat.utils.NotificationUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.utils.Util;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.network.http.callback.StringResultCallBack;
import com.umeng.analytics.pro.d;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/conversation/SobotChatBaseFragment.class */
public abstract class SobotChatBaseFragment extends SobotBaseFragment implements SensorEventListener {
    protected static final int CANCEL_VOICE = 2;
    protected static final int SEND_TEXT = 0;
    protected static final int SEND_VOICE = 0;
    protected static final int UPDATE_TEXT = 1;
    protected static final int UPDATE_TEXT_VOICE = 2;
    protected static final int UPDATE_VOICE = 1;
    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
    protected String currentUserName;
    protected Information info;
    protected ZhiChiInitModeBase initModel;
    protected boolean isRemindTicketInfo;
    protected Context mAppContext;
    private AudioAttributes mAttribute;
    private AudioFocusRequest mFocusRequest;
    protected SobotMsgAdapter messageAdapter;
    private PollingHandler pollingHandler;
    private String puid;
    protected TimerTask taskCustom;
    private TimerTask taskUserInfo;
    protected Timer timerCustom;
    private Timer timerUserInfo;
    private String uid;
    protected int current_client_model = 301;
    protected CustomerState customerState = CustomerState.Offline;
    private String adminFace = "";
    protected boolean isAboveZero = false;
    protected int remindRobotMessageTimes = 0;
    private boolean isQueryFroming = false;
    protected boolean isHasRequestQueryFrom = false;
    protected boolean customTimeTask = false;
    protected boolean userInfoTimeTask = false;
    protected boolean is_startCustomTimerTask = false;
    protected int noReplyTimeUserInfo = 0;
    public int paseReplyTimeUserInfo = 0;
    protected int isChatLock = 0;
    protected int noReplyTimeCustoms = 0;
    public int paseReplyTimeCustoms = 0;
    protected int serviceOutTimeTipCount = 0;
    private Timer inputtingListener = null;
    private boolean isSendInput = false;
    private String lastInputStr = "";
    private TimerTask inputTimerTask = null;
    public AudioManager audioManager = null;
    public SensorManager _sensorManager = null;
    public Sensor mProximiny = null;
    private Map<String, String> pollingParams = new HashMap();
    private Map<String, String> ackParams = new HashMap();
    public boolean inPolling = false;
    public boolean isWritePollingLog = true;
    private Runnable pollingRun = new Runnable() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.18
        @Override // java.lang.Runnable
        public void run() {
            SobotChatBaseFragment.this.inPolling = true;
            SobotChatBaseFragment.this.pollingMsg();
        }
    };
    private LimitQueue<String> receiveMsgQueue = new LimitQueue<>(50);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/conversation/SobotChatBaseFragment$PollingHandler.class */
    public static class PollingHandler extends Handler {
        public PollingHandler() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PollingHandler getPollingHandler() {
        if (this.pollingHandler == null) {
            this.pollingHandler = new PollingHandler();
        }
        return this.pollingHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pollingMsg() {
        String stringData = SharedPreferencesUtil.getStringData(getSobotActivity(), ZhiChiConstant.SOBOT_PLATFORM_UNIONCODE, "");
        this.pollingParams.put("uid", this.uid);
        this.pollingParams.put(d.N, this.puid);
        Map<String, String> map = this.pollingParams;
        map.put("tnk", System.currentTimeMillis() + "");
        this.zhiChiApi.pollingMsg(this, this.pollingParams, stringData, new StringResultCallBack<BaseCode>() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.19
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                String str2;
                SobotChatBaseFragment.this.getPollingHandler().removeCallbacks(SobotChatBaseFragment.this.pollingRun);
                SobotChatBaseFragment.this.getPollingHandler().postDelayed(SobotChatBaseFragment.this.pollingRun, 10000L);
                LogUtils.i("msg::::" + str);
                if (("SobotChatBaseFragment 轮询:请求参数 " + SobotChatBaseFragment.this.pollingParams) != null) {
                    str2 = GsonUtil.map2Json(SobotChatBaseFragment.this.pollingParams);
                } else {
                    str2 = "" + exc.toString();
                }
                LogUtils.i2Local("轮询接口失败", str2);
                try {
                    SobotMsgManager.getInstance(SobotChatBaseFragment.this.getSobotActivity()).getZhiChiApi().logCollect(SobotChatBaseFragment.this.getSobotActivity(), SharedPreferencesUtil.getAppKey(SobotChatBaseFragment.this.getSobotActivity(), ""), true);
                } catch (Exception e) {
                }
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(BaseCode baseCode) {
                if (SobotChatBaseFragment.this.isWritePollingLog) {
                    LogUtils.i2Local("SobotChatBaseFragment 轮询结果", baseCode.toString());
                    try {
                        SobotMsgManager.getInstance(SobotChatBaseFragment.this.getSobotActivity()).getZhiChiApi().logCollect(SobotChatBaseFragment.this.getSobotActivity(), SharedPreferencesUtil.getAppKey(SobotChatBaseFragment.this.getSobotActivity(), ""), true);
                    } catch (Exception e) {
                    }
                }
                SobotChatBaseFragment.this.isWritePollingLog = false;
                LogUtils.i("fragment pollingMsg 轮询请求结果:" + baseCode.getData().toString());
                SobotChatBaseFragment.this.getPollingHandler().removeCallbacks(SobotChatBaseFragment.this.pollingRun);
                if (baseCode != null) {
                    if ("0".equals(baseCode.getCode()) && "210021".equals(baseCode.getData())) {
                        LogUtils.i2Local("fragment 轮询结果异常", baseCode.toString() + " 非法用户，停止轮询");
                    } else if ("0".equals(baseCode.getCode()) && "200003".equals(baseCode.getData())) {
                        LogUtils.i2Local("fragment 轮询结果异常", baseCode.toString() + " 找不到用户，停止轮询");
                    } else {
                        SobotChatBaseFragment.this.getPollingHandler().postDelayed(SobotChatBaseFragment.this.pollingRun, 5000L);
                        if (baseCode.getData() != null) {
                            SobotChatBaseFragment sobotChatBaseFragment = SobotChatBaseFragment.this;
                            sobotChatBaseFragment.responseAck(sobotChatBaseFragment.getSobotActivity(), baseCode.getData().toString());
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void questionRecommend(final Handler handler, final ZhiChiInitModeBase zhiChiInitModeBase, Information information) {
        if (information.getMargs() == null || information.getMargs().size() == 0) {
            return;
        }
        this.zhiChiApi.questionRecommend(this, zhiChiInitModeBase.getPartnerid(), information.getMargs(), new StringResultCallBack<SobotQuestionRecommend>() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.17
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(SobotQuestionRecommend sobotQuestionRecommend) {
                if (SobotChatBaseFragment.this.isActive() && sobotQuestionRecommend != null && SobotChatBaseFragment.this.current_client_model == 301) {
                    ZhiChiMessageBase questionRecommendData = ChatUtils.getQuestionRecommendData(zhiChiInitModeBase, sobotQuestionRecommend);
                    Message obtainMessage = handler.obtainMessage();
                    obtainMessage.what = 602;
                    obtainMessage.obj = questionRecommendData;
                    handler.sendMessage(obtainMessage);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void responseAck(Context context, String str) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray3 = new JSONArray(str);
            JSONArray jSONArray4 = new JSONArray();
            int i = 0;
            while (true) {
                int i2 = i;
                jSONArray2 = jSONArray4;
                try {
                    if (i2 >= jSONArray3.length()) {
                        break;
                    }
                    String string = jSONArray3.getString(i2);
                    String msgId = Util.getMsgId(string);
                    if (TextUtils.isEmpty(msgId)) {
                        Util.notifyMsg(context, string);
                    } else {
                        if (this.receiveMsgQueue.indexOf(msgId) == -1) {
                            this.receiveMsgQueue.offer(msgId);
                            Util.notifyMsg(context, string);
                        }
                        jSONArray4.put(new JSONObject("{msgId:" + msgId + i.d));
                    }
                    i = i2 + 1;
                } catch (JSONException e) {
                    jSONArray = jSONArray4;
                    e = e;
                    e.printStackTrace();
                    jSONArray2 = jSONArray;
                    if (jSONArray2 != null) {
                        return;
                    }
                    return;
                }
            }
        } catch (JSONException e2) {
            e = e2;
            jSONArray = null;
        }
        if (jSONArray2 != null || jSONArray2.length() <= 0) {
            return;
        }
        this.ackParams.put("content", jSONArray2.toString());
        this.ackParams.put("tnk", System.currentTimeMillis() + "");
        this.zhiChiApi.msgAck(this, this.ackParams, new StringResultCallBack<BaseCode>() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.21
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str2) {
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(BaseCode baseCode) {
            }
        });
    }

    public void abandonAudioFocus() {
        if (Build.VERSION.SDK_INT > 7 && this.audioManager != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                AudioFocusRequest audioFocusRequest = this.mFocusRequest;
                if (audioFocusRequest != null) {
                    this.audioManager.abandonAudioFocusRequest(audioFocusRequest);
                }
            } else {
                AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.audioFocusChangeListener;
                if (onAudioFocusChangeListener != null) {
                    this.audioManager.abandonAudioFocus(onAudioFocusChangeListener);
                }
            }
            this.audioManager = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cancelUiVoiceMessage(SobotMsgAdapter sobotMsgAdapter, Message message) {
        sobotMsgAdapter.cancelVoiceUiById(((ZhiChiMessageBase) message.obj).getId());
        sobotMsgAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearCache() {
        SobotMsgManager.getInstance(this.mAppContext).clearAllConfig();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void connectCustomerService(SobotConnCusParam sobotConnCusParam) {
        connectCustomerService(sobotConnCusParam, true);
    }

    protected void connectCustomerService(SobotConnCusParam sobotConnCusParam, boolean z) {
    }

    protected void customerServiceOffline(ZhiChiInitModeBase zhiChiInitModeBase, int i) {
    }

    @Override // com.sobot.chat.fragment.SobotBaseFragment
    public void displayInNotch(final View view) {
        if (SobotApi.getSwitchMarkStatus(1) && SobotApi.getSwitchMarkStatus(4) && view != null) {
            NotchScreenManager.getInstance().getNotchInfo(getActivity(), new INotchScreen.NotchScreenCallback() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.1
                @Override // com.sobot.chat.notchlib.INotchScreen.NotchScreenCallback
                public void onResult(INotchScreen.NotchScreenInfo notchScreenInfo) {
                    if (notchScreenInfo.hasNotch) {
                        for (Rect rect : notchScreenInfo.notchRects) {
                            View view2 = view;
                            if ((view2 instanceof WebView) && (view2.getParent() instanceof LinearLayout)) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                                layoutParams.rightMargin = (rect.right > 110 ? 110 : rect.right) + 14;
                                layoutParams.leftMargin = (rect.right <= 110 ? rect.right : 110) + 14;
                                view.setLayoutParams(layoutParams);
                            } else {
                                View view3 = view;
                                if ((view3 instanceof WebView) && (view3.getParent() instanceof RelativeLayout)) {
                                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                                    layoutParams2.rightMargin = (rect.right > 110 ? 110 : rect.right) + 14;
                                    layoutParams2.leftMargin = (rect.right <= 110 ? rect.right : 110) + 14;
                                    view.setLayoutParams(layoutParams2);
                                } else {
                                    View view4 = view;
                                    int i = rect.right > 110 ? 110 : rect.right;
                                    int paddingLeft = view.getPaddingLeft();
                                    view4.setPadding(i + paddingLeft, view.getPaddingTop(), (rect.right <= 110 ? rect.right : 110) + view.getPaddingRight(), view.getPaddingBottom());
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        if (!isActive() || getSobotActivity() == null) {
            return;
        }
        getSobotActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getAdminFace() {
        return this.adminFace;
    }

    protected abstract String getSendMessageStr();

    public void initAudioManager() {
        if (this.audioManager == null) {
            this.audioManager = (AudioManager) getContext().getSystemService("audio");
        }
        if (this._sensorManager == null) {
            this._sensorManager = (SensorManager) getContext().getSystemService("sensor");
        }
        SensorManager sensorManager = this._sensorManager;
        if (sensorManager != null) {
            this.mProximiny = sensorManager.getDefaultSensor(8);
        }
        this.audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.13
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i) {
                if (i == -1 && AudioTools.getInstance().isPlaying()) {
                    AudioTools.getInstance().stop();
                }
            }
        };
        if (Build.VERSION.SDK_INT >= 21) {
            this.mAttribute = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.mFocusRequest = new AudioFocusRequest.Builder(2).setWillPauseWhenDucked(true).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(this.audioFocusChangeListener, new Handler()).setAudioAttributes(this.mAttribute).build();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isActive() {
        return isAdded();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isUserBlack() {
        ZhiChiInitModeBase zhiChiInitModeBase = this.initModel;
        return zhiChiInitModeBase != null && "1".equals(zhiChiInitModeBase.getIsblack());
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mAppContext = getContext().getApplicationContext();
        if (SobotApi.getSwitchMarkStatus(1) && SobotApi.getSwitchMarkStatus(4)) {
            NotchScreenManager.getInstance().setDisplayInNotch(getActivity());
            getActivity().getWindow().setFlags(1024, 1024);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        stopPolling();
        HttpUtils.getInstance().cancelTag(this);
        super.onDestroy();
    }

    @Override // com.sobot.chat.fragment.SobotBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.initModel != null && this.customerState == CustomerState.Online && this.current_client_model == 302) {
            restartInputListener();
            CommonUtils.sendLocalBroadcast(this.mAppContext, new Intent(Const.SOBOT_CHAT_CHECK_CONNCHANNEL));
        }
        NotificationUtils.cancleAllNotification(this.mAppContext);
        SensorManager sensorManager = this._sensorManager;
        if (sensorManager != null) {
            sensorManager.registerListener(this, this.mProximiny, 3);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (Build.MODEL.toLowerCase().contains("mi") || this.audioManager == null) {
                return;
            }
            if (sensorEvent.values[0] >= this.mProximiny.getMaximumRange()) {
                this.audioManager.setSpeakerphoneOn(true);
                this.audioManager.setMode(0);
                this.audioManager.setStreamVolume(1, this.audioManager.getStreamVolume(1), 0);
                return;
            }
            this.audioManager.setSpeakerphoneOn(false);
            if (Build.VERSION.SDK_INT >= 21) {
                this.audioManager.setMode(3);
                this.audioManager.setStreamVolume(0, this.audioManager.getStreamMaxVolume(0), 0);
                return;
            }
            this.audioManager.setMode(2);
            this.audioManager.setStreamVolume(0, this.audioManager.getStreamMaxVolume(0), 0);
        } catch (Exception e) {
        }
    }

    public void pollingMsgForOne() {
        this.uid = SharedPreferencesUtil.getStringData(getSobotActivity(), Const.SOBOT_UID, "");
        this.puid = SharedPreferencesUtil.getStringData(getSobotActivity(), Const.SOBOT_PUID, "");
        String stringData = SharedPreferencesUtil.getStringData(getSobotActivity(), ZhiChiConstant.SOBOT_PLATFORM_UNIONCODE, "");
        this.pollingParams.put("uid", this.uid);
        this.pollingParams.put(d.N, this.puid);
        Map<String, String> map = this.pollingParams;
        map.put("tnk", System.currentTimeMillis() + "");
        LogUtils.i2Local("开启轮询", "SobotChatBaseFragment 至少只请求一次轮询接口 参数:" + this.pollingParams.toString());
        this.zhiChiApi.pollingMsg(this, this.pollingParams, stringData, new StringResultCallBack<BaseCode>() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.20
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                String str2;
                LogUtils.i("msg::::" + str);
                if (("请求参数 " + SobotChatBaseFragment.this.pollingParams) != null) {
                    str2 = GsonUtil.map2Json(SobotChatBaseFragment.this.pollingParams);
                } else {
                    str2 = "" + exc.toString();
                }
                LogUtils.i2Local("轮询接口失败", str2);
                try {
                    SobotMsgManager.getInstance(SobotChatBaseFragment.this.getSobotActivity()).getZhiChiApi().logCollect(SobotChatBaseFragment.this.getSobotActivity(), SharedPreferencesUtil.getAppKey(SobotChatBaseFragment.this.getSobotActivity(), ""), true);
                } catch (Exception e) {
                }
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(BaseCode baseCode) {
                LogUtils.i2Local("SobotChatBaseFragment至少只请求一次轮询接口", " 轮询请求结果:" + baseCode.toString());
                LogUtils.i("fragment pollingMsgForOne 轮询请求结果:" + baseCode.getData().toString());
                if (baseCode != null) {
                    if ("0".equals(baseCode.getCode()) && "210021".equals(baseCode.getData())) {
                        return;
                    }
                    if (("0".equals(baseCode.getCode()) && "200003".equals(baseCode.getData())) || baseCode.getData() == null) {
                        return;
                    }
                    SobotChatBaseFragment sobotChatBaseFragment = SobotChatBaseFragment.this;
                    sobotChatBaseFragment.responseAck(sobotChatBaseFragment.getSobotActivity(), baseCode.getData().toString());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processAutoSendMsg(Information information) {
        if (information.getAutoSendMsgMode() == null || information.getAutoSendMsgMode() == SobotAutoSendMsgMode.Default) {
            return;
        }
        SobotAutoSendMsgMode autoSendMsgMode = information.getAutoSendMsgMode();
        if (TextUtils.isEmpty(autoSendMsgMode.getContent())) {
            return;
        }
        int i = this.current_client_model;
        if (i == 301) {
            if (autoSendMsgMode == SobotAutoSendMsgMode.SendToRobot || autoSendMsgMode == SobotAutoSendMsgMode.SendToAll) {
                sendMsg(autoSendMsgMode.getContent());
            }
        } else if (i == 302) {
            if ((autoSendMsgMode == SobotAutoSendMsgMode.SendToOperator || autoSendMsgMode == SobotAutoSendMsgMode.SendToAll) && this.customerState == CustomerState.Online) {
                sendMsg(autoSendMsgMode.getContent());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processNewTicketMsg(final Handler handler) {
        if (this.initModel.getMsgFlag() != 0 || TextUtils.isEmpty(this.initModel.getCustomerId())) {
            return;
        }
        this.isRemindTicketInfo = true;
        this.zhiChiApi.checkUserTicketInfo(this, this.initModel.getPartnerid(), this.initModel.getCompanyId(), this.initModel.getCustomerId(), new StringResultCallBack<SobotUserTicketInfoFlag>() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.16
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(SobotUserTicketInfoFlag sobotUserTicketInfoFlag) {
                if (sobotUserTicketInfoFlag.isExistFlag()) {
                    ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
                    zhiChiMessageBase.setSenderType("24");
                    ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
                    zhiChiReplyAnswer.setRemindType(9);
                    zhiChiReplyAnswer.setMsg("<font color='#ffacb5c4'>" + SobotChatBaseFragment.this.getResString("sobot_new_ticket_info") + " </font> <a href='sobot:SobotTicketInfo'  target='_blank' >" + SobotChatBaseFragment.this.getResString("sobot_new_ticket_info_update") + "</a> ");
                    zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
                    Message obtainMessage = handler.obtainMessage();
                    obtainMessage.what = 601;
                    obtainMessage.obj = zhiChiMessageBase;
                    handler.sendMessage(obtainMessage);
                }
            }
        });
    }

    public void remindRobotMessage(final Handler handler, final ZhiChiInitModeBase zhiChiInitModeBase, final Information information) {
        boolean booleanData = SharedPreferencesUtil.getBooleanData(this.mAppContext, ZhiChiConstant.SOBOT_IS_EXIT, false);
        if (zhiChiInitModeBase == null) {
            return;
        }
        int i = this.remindRobotMessageTimes + 1;
        this.remindRobotMessageTimes = i;
        if (i == 1) {
            if (zhiChiInitModeBase.getUstatus() == -1 && !booleanData) {
                processNewTicketMsg(handler);
                return;
            }
            ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
            ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
            if (zhiChiInitModeBase.isRobotHelloWordFlag()) {
                String robot_hello_word = ZCSobotApi.getCurrentInfoSetting(this.mAppContext) != null ? ZCSobotApi.getCurrentInfoSetting(this.mAppContext).getRobot_hello_word() : "";
                if (!TextUtils.isEmpty(robot_hello_word) || !TextUtils.isEmpty(zhiChiInitModeBase.getRobotHelloWord())) {
                    if (!TextUtils.isEmpty(robot_hello_word)) {
                        zhiChiReplyAnswer.setMsg(robot_hello_word);
                    } else if (TextUtils.isEmpty(zhiChiInitModeBase.getRobotHelloWord())) {
                        return;
                    } else {
                        String replace = zhiChiInitModeBase.getRobotHelloWord().replace("\n", "<br/>");
                        String str = replace;
                        if (replace.startsWith("<br/>")) {
                            str = replace.substring(5, replace.length());
                        }
                        String str2 = str;
                        if (str.endsWith("<br/>")) {
                            str2 = str.substring(0, str.length() - 5);
                        }
                        zhiChiReplyAnswer.setMsg(str2);
                    }
                    zhiChiReplyAnswer.setMsgType("0");
                    zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
                    zhiChiMessageBase.setSenderFace(zhiChiInitModeBase.getRobotLogo());
                    zhiChiMessageBase.setSender(zhiChiInitModeBase.getRobotName());
                    zhiChiMessageBase.setSenderType(BaseWrapper.ENTER_ID_TOOLKIT);
                    zhiChiMessageBase.setSenderName(zhiChiInitModeBase.getRobotName());
                    Message obtainMessage = handler.obtainMessage();
                    obtainMessage.what = 602;
                    obtainMessage.obj = zhiChiMessageBase;
                    handler.sendMessage(obtainMessage);
                }
            }
            if (1 == zhiChiInitModeBase.getGuideFlag()) {
                this.zhiChiApi.robotGuide(this, zhiChiInitModeBase.getPartnerid(), zhiChiInitModeBase.getRobotid(), information.getFaqId(), new StringResultCallBack<ZhiChiMessageBase>() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.15
                    @Override // com.sobot.network.http.callback.StringResultCallBack
                    public void onFailure(Exception exc, String str3) {
                    }

                    @Override // com.sobot.network.http.callback.StringResultCallBack
                    public void onSuccess(ZhiChiMessageBase zhiChiMessageBase2) {
                        if (SobotChatBaseFragment.this.isActive() && SobotChatBaseFragment.this.current_client_model == 301) {
                            zhiChiMessageBase2.setSenderFace(zhiChiInitModeBase.getRobotLogo());
                            zhiChiMessageBase2.setSenderType("27");
                            Message obtainMessage2 = handler.obtainMessage();
                            obtainMessage2.what = 602;
                            obtainMessage2.obj = zhiChiMessageBase2;
                            handler.sendMessage(obtainMessage2);
                            SobotChatBaseFragment.this.questionRecommend(handler, zhiChiInitModeBase, information);
                            SobotChatBaseFragment.this.processAutoSendMsg(information);
                            SobotChatBaseFragment.this.processNewTicketMsg(handler);
                        }
                    }
                });
                return;
            }
            questionRecommend(handler, zhiChiInitModeBase, information);
            processAutoSendMsg(information);
            processNewTicketMsg(handler);
        }
    }

    public void requestAudioFocus() {
        if (Build.VERSION.SDK_INT <= 7) {
            return;
        }
        if (this.audioManager == null) {
            this.audioManager = (AudioManager) getContext().getSystemService("audio");
        }
        if (this.audioManager != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                AudioFocusRequest audioFocusRequest = this.mFocusRequest;
                if (audioFocusRequest != null) {
                    this.audioManager.requestAudioFocus(audioFocusRequest);
                    return;
                }
                return;
            }
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.audioFocusChangeListener;
            if (onAudioFocusChangeListener != null) {
                this.audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void requestQueryFrom(final SobotConnCusParam sobotConnCusParam, final boolean z) {
        if (this.customerState == CustomerState.Queuing || this.isHasRequestQueryFrom) {
            connectCustomerService(sobotConnCusParam);
        } else if (this.isQueryFroming) {
        } else {
            this.isHasRequestQueryFrom = true;
            this.isQueryFroming = true;
            this.zhiChiApi.queryFormConfig(this, this.initModel.getPartnerid(), new StringResultCallBack<SobotQueryFormModel>() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.14
                @Override // com.sobot.network.http.callback.StringResultCallBack
                public void onFailure(Exception exc, String str) {
                    SobotChatBaseFragment.this.isQueryFroming = false;
                    if (SobotChatBaseFragment.this.isActive()) {
                        ToastUtil.showToast(SobotChatBaseFragment.this.mAppContext, str);
                    }
                }

                @Override // com.sobot.network.http.callback.StringResultCallBack
                public void onSuccess(SobotQueryFormModel sobotQueryFormModel) {
                    SobotChatBaseFragment.this.isQueryFroming = false;
                    if (SobotChatBaseFragment.this.isActive()) {
                        if (!sobotQueryFormModel.isOpenFlag() || z || sobotQueryFormModel.getField() == null || sobotQueryFormModel.getField().size() <= 0) {
                            SobotChatBaseFragment.this.connectCustomerService(sobotConnCusParam);
                            return;
                        }
                        Intent intent = new Intent(SobotChatBaseFragment.this.mAppContext, SobotQueryFromActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_GROUPID, sobotConnCusParam.getGroupId());
                        bundle.putString(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_GROUPNAME, sobotConnCusParam.getGroupName());
                        bundle.putSerializable(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_FIELD, sobotQueryFormModel);
                        bundle.putSerializable(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_UID, SobotChatBaseFragment.this.initModel.getPartnerid());
                        bundle.putInt(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_TRANSFER_TYPE, sobotConnCusParam.getTransferType());
                        bundle.putString(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_DOCID, sobotConnCusParam.getDocId());
                        bundle.putString(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_UNKNOWNQUESTION, sobotConnCusParam.getUnknownQuestion());
                        bundle.putString(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_ACTIVETRANSFER, sobotConnCusParam.getActiveTransfer());
                        bundle.putString(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_KEYWORD, sobotConnCusParam.getKeyword());
                        bundle.putString(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_KEYWORD_ID, sobotConnCusParam.getKeywordId());
                        intent.putExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA, bundle);
                        SobotChatBaseFragment.this.startActivityForResult(intent, 104);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void restartInputListener() {
        stopInputListener();
        startInputListener();
    }

    public void restartMyTimeTask(Handler handler) {
        if (this.customerState == CustomerState.Online && this.current_client_model == 302 && !this.is_startCustomTimerTask) {
            stopUserInfoTimeTask();
            startCustomTimeTask(handler);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendHttpCardMsg(String str, String str2, final Handler handler, final String str3, final ConsultingContent consultingContent) {
        this.zhiChiApi.sendCardMsg(consultingContent, str, str2, new StringResultCallBack<CommonModelBase>() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.6
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str4) {
                if (SobotChatBaseFragment.this.isActive()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("sendHttpCardMsg", exc.toString() + str4);
                    LogUtils.i2Local(hashMap, "1");
                    LogUtils.i("sendHttpCardMsg error:" + exc.toString());
                }
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(CommonModelBase commonModelBase) {
                if (SobotChatBaseFragment.this.isActive()) {
                    if ("2".equals(commonModelBase.getStatus())) {
                        SobotChatBaseFragment sobotChatBaseFragment = SobotChatBaseFragment.this;
                        sobotChatBaseFragment.customerServiceOffline(sobotChatBaseFragment.initModel, 1);
                    } else if (!"1".equals(commonModelBase.getStatus()) || TextUtils.isEmpty(str3)) {
                    } else {
                        SobotChatBaseFragment.this.isAboveZero = true;
                        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
                        zhiChiMessageBase.setId(str3);
                        zhiChiMessageBase.setConsultingContent(consultingContent);
                        zhiChiMessageBase.setSenderType("0");
                        zhiChiMessageBase.setSendSuccessState(1);
                        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
                        zhiChiReplyAnswer.setMsgType("24");
                        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
                        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
                        Message obtainMessage = handler.obtainMessage();
                        obtainMessage.what = 601;
                        obtainMessage.obj = zhiChiMessageBase;
                        handler.sendMessage(obtainMessage);
                    }
                }
            }
        });
    }

    protected void sendHttpCustomServiceMessage(String str, String str2, String str3, final Handler handler, final String str4) {
        this.zhiChiApi.sendMsgToCoutom(str, str2, str3, new StringResultCallBack<CommonModelBase>() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.5
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str5) {
                if (SobotChatBaseFragment.this.isActive()) {
                    SobotChatBaseFragment.this.sendTextMessageToHandler(str4, null, handler, 0, 1);
                }
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(CommonModelBase commonModelBase) {
                if (SobotChatBaseFragment.this.isActive()) {
                    Boolean valueOf = Boolean.valueOf(Boolean.valueOf(commonModelBase.getSwitchFlag()).booleanValue());
                    if (valueOf.booleanValue()) {
                        HashMap hashMap = new HashMap();
                        if (CommonUtils.isServiceWork(SobotChatBaseFragment.this.getSobotActivity(), "com.sobot.chat.core.channel.SobotTCPServer")) {
                            hashMap.put("TCPServer 运行情况", "在运行");
                        } else {
                            hashMap.put("TCPServer 运行情况", "没运行，直接走fragment 界面的轮询");
                        }
                        hashMap.put("commonModelBase", commonModelBase.toString());
                        LogUtils.i2Local("开启轮询 fragment ", "switchFlag=" + valueOf + " " + hashMap.toString());
                        SobotChatBaseFragment.this.pollingMsgForOne();
                        try {
                            SobotMsgManager.getInstance(SobotChatBaseFragment.this.getSobotActivity()).getZhiChiApi().logCollect(SobotChatBaseFragment.this.getSobotActivity(), SharedPreferencesUtil.getAppKey(SobotChatBaseFragment.this.getSobotActivity(), ""), true);
                        } catch (Exception e) {
                        }
                        if (CommonUtils.isServiceWork(SobotChatBaseFragment.this.getSobotActivity(), "com.sobot.chat.core.channel.SobotTCPServer")) {
                            LogUtils.i2Local("开启轮询", "SobotTCPServer 在运行");
                            CommonUtils.sendLocalBroadcast(SobotChatBaseFragment.this.mAppContext, new Intent(Const.SOBOT_CHAT_CHECK_SWITCHFLAG));
                        } else {
                            LogUtils.i2Local("开启轮询", "SobotTCPServer 没运行，直接走fragment 界面的轮询");
                            SobotMsgManager.getInstance(SobotChatBaseFragment.this.getSobotActivity()).getZhiChiApi().disconnChannel();
                            if (!SobotChatBaseFragment.this.inPolling) {
                                SobotChatBaseFragment.this.startPolling();
                            }
                        }
                    } else if (CommonUtils.isServiceWork(SobotChatBaseFragment.this.getSobotActivity(), "com.sobot.chat.core.channel.SobotTCPServer")) {
                        CommonUtils.sendLocalBroadcast(SobotChatBaseFragment.this.mAppContext, new Intent(Const.SOBOT_CHAT_CHECK_CONNCHANNEL));
                    } else {
                        SobotChatBaseFragment.this.zhiChiApi.reconnectChannel();
                    }
                    if (commonModelBase.getSentisive() == 1) {
                        SobotChatBaseFragment.this.isAboveZero = true;
                        SobotChatBaseFragment.this.sendTextMessageToHandler(str4, null, handler, 1, 1, commonModelBase.getSentisive(), commonModelBase.getSentisiveExplain());
                    } else if ("2".equals(commonModelBase.getStatus())) {
                        SobotChatBaseFragment.this.sendTextMessageToHandler(str4, null, handler, 0, 1);
                        SobotChatBaseFragment sobotChatBaseFragment = SobotChatBaseFragment.this;
                        sobotChatBaseFragment.customerServiceOffline(sobotChatBaseFragment.initModel, 1);
                    } else if (!"1".equals(commonModelBase.getStatus()) || TextUtils.isEmpty(str4)) {
                    } else {
                        SobotChatBaseFragment.this.isAboveZero = true;
                        SobotChatBaseFragment.this.sendTextMessageToHandler(str4, null, commonModelBase.getDesensitizationWord(), handler, 1, 1, 0, "");
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendHttpOrderCardMsg(String str, String str2, final Handler handler, final String str3, final OrderCardContentModel orderCardContentModel) {
        this.zhiChiApi.sendOrderCardMsg(orderCardContentModel, str, str2, new StringResultCallBack<CommonModelBase>() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.7
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str4) {
                if (SobotChatBaseFragment.this.isActive()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("sendHttpOrderCardMsg", exc.toString() + str4);
                    LogUtils.i2Local(hashMap, "1");
                    LogUtils.i("sendHttpOrderCardMsg error:" + exc.toString());
                }
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(CommonModelBase commonModelBase) {
                if (SobotChatBaseFragment.this.isActive()) {
                    if ("2".equals(commonModelBase.getStatus())) {
                        SobotChatBaseFragment sobotChatBaseFragment = SobotChatBaseFragment.this;
                        sobotChatBaseFragment.customerServiceOffline(sobotChatBaseFragment.initModel, 1);
                    } else if (!"1".equals(commonModelBase.getStatus()) || TextUtils.isEmpty(str3)) {
                    } else {
                        SobotChatBaseFragment.this.isAboveZero = true;
                        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
                        zhiChiMessageBase.setId(str3);
                        zhiChiMessageBase.setOrderCardContent(orderCardContentModel);
                        zhiChiMessageBase.setSenderType("0");
                        zhiChiMessageBase.setSendSuccessState(1);
                        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
                        zhiChiReplyAnswer.setMsgType("25");
                        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
                        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
                        Message obtainMessage = handler.obtainMessage();
                        obtainMessage.what = 601;
                        obtainMessage.obj = zhiChiMessageBase;
                        handler.sendMessage(obtainMessage);
                    }
                }
            }
        });
    }

    protected void sendHttpRobotMessage(final String str, String str2, String str3, String str4, final Handler handler, int i, String str5, String str6) {
        HashMap hashMap = new HashMap();
        hashMap.put("adminId", this.info.getChoose_adminid());
        hashMap.put("tranFlag", this.info.getTranReceptionistFlag() + "");
        hashMap.put("groupId", this.info.getGroupid());
        hashMap.put("transferAction", this.info.getTransferAction());
        SharedPreferencesUtil.getStringData(getSobotActivity(), ZhiChiConstant.SOBOT_PLATFORM_UNIONCODE, "");
        this.zhiChiApi.chatSendMsgToRoot(this.initModel.getRobotid(), str2, i, str5, str3, str4, hashMap, new StringResultCallBack<ZhiChiMessageBase>() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.4
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str7) {
                if (SobotChatBaseFragment.this.isActive()) {
                    SobotChatBaseFragment.this.sendTextMessageToHandler(str, null, handler, 0, 1);
                }
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(ZhiChiMessageBase zhiChiMessageBase) {
                if (SobotChatBaseFragment.this.isActive()) {
                    if (zhiChiMessageBase != null && zhiChiMessageBase.getSentisive() == 1) {
                        SobotChatBaseFragment.this.isAboveZero = true;
                        SobotChatBaseFragment.this.sendTextMessageToHandler(str, null, handler, 1, 1, zhiChiMessageBase.getSentisive(), zhiChiMessageBase.getSentisiveExplain());
                        return;
                    }
                    String str7 = System.currentTimeMillis() + "";
                    if (zhiChiMessageBase.getUstatus() == 0) {
                        SobotChatBaseFragment.this.sendTextMessageToHandler(str, null, handler, 0, 1);
                        zhiChiMessageBase.setId(str7);
                        zhiChiMessageBase.setSenderName(SobotChatBaseFragment.this.initModel.getRobotName());
                        zhiChiMessageBase.setSender(SobotChatBaseFragment.this.initModel.getRobotName());
                        zhiChiMessageBase.setSenderFace(SobotChatBaseFragment.this.initModel.getRobotLogo());
                        zhiChiMessageBase.setSenderType("1");
                        if (SobotChatBaseFragment.this.messageAdapter != null) {
                            SobotChatBaseFragment.this.messageAdapter.justAddData(zhiChiMessageBase);
                            SobotChatBaseFragment.this.messageAdapter.notifyDataSetChanged();
                        }
                        SobotChatBaseFragment sobotChatBaseFragment = SobotChatBaseFragment.this;
                        sobotChatBaseFragment.customerServiceOffline(sobotChatBaseFragment.initModel, 4);
                    } else if (zhiChiMessageBase.getUstatus() == 1) {
                        SobotChatBaseFragment.this.sendTextMessageToHandler(str, null, handler, 0, 1);
                        LogUtils.i("应该是人工状态给机器人发消息拦截,连接通道，修改当前模式为人工模式");
                        ZCSobotApi.checkIMConnected(SobotChatBaseFragment.this.getSobotActivity(), SobotChatBaseFragment.this.info.getPartnerid());
                        SobotChatBaseFragment.this.current_client_model = 302;
                    } else {
                        SobotChatBaseFragment.this.sendTextMessageToHandler(str, null, zhiChiMessageBase.getDesensitizationWord(), handler, 1, 1, 0, "");
                        SobotChatBaseFragment.this.isAboveZero = true;
                        zhiChiMessageBase.setId(str7);
                        zhiChiMessageBase.setSenderName(SobotChatBaseFragment.this.initModel.getRobotName());
                        zhiChiMessageBase.setSender(SobotChatBaseFragment.this.initModel.getRobotName());
                        zhiChiMessageBase.setSenderFace(SobotChatBaseFragment.this.initModel.getRobotLogo());
                        zhiChiMessageBase.setSenderType("1");
                        Message obtainMessage = handler.obtainMessage();
                        obtainMessage.what = 602;
                        obtainMessage.obj = zhiChiMessageBase;
                        handler.sendMessage(obtainMessage);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendLocation(String str, SobotLocationModel sobotLocationModel, final Handler handler, boolean z) {
        if (isActive() && this.initModel != null && this.current_client_model == 302) {
            if (z) {
                str = System.currentTimeMillis() + "";
                sendNewMsgToHandler(ChatUtils.getLocationModel(str, sobotLocationModel), handler, 2);
            } else if (TextUtils.isEmpty(str)) {
                return;
            } else {
                updateMsgToHandler(str, handler, 2);
            }
            final String str2 = str;
            this.zhiChiApi.sendLocation(this, sobotLocationModel, this.initModel.getPartnerid(), this.initModel.getCid(), new StringResultCallBack<CommonModelBase>() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.8
                @Override // com.sobot.network.http.callback.StringResultCallBack
                public void onFailure(Exception exc, String str3) {
                    if (SobotChatBaseFragment.this.isActive()) {
                        SobotChatBaseFragment.this.updateMsgToHandler(str2, handler, 0);
                    }
                }

                @Override // com.sobot.network.http.callback.StringResultCallBack
                public void onSuccess(CommonModelBase commonModelBase) {
                    if (SobotChatBaseFragment.this.isActive()) {
                        if ("2".equals(commonModelBase.getStatus())) {
                            SobotChatBaseFragment.this.updateMsgToHandler(str2, handler, 0);
                            SobotChatBaseFragment sobotChatBaseFragment = SobotChatBaseFragment.this;
                            sobotChatBaseFragment.customerServiceOffline(sobotChatBaseFragment.initModel, 1);
                        } else if (!"1".equals(commonModelBase.getStatus()) || TextUtils.isEmpty(str2)) {
                        } else {
                            SobotChatBaseFragment.this.isAboveZero = true;
                            SobotChatBaseFragment.this.updateMsgToHandler(str2, handler, 1);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMessageWithLogic(String str, String str2, ZhiChiInitModeBase zhiChiInitModeBase, Handler handler, int i, int i2, String str3) {
        if (301 == i) {
            sendHttpRobotMessage(str, str2, zhiChiInitModeBase.getPartnerid(), zhiChiInitModeBase.getCid(), handler, i2, str3, this.info.getLocale());
            LogUtils.i("机器人模式");
        } else if (302 == i) {
            sendHttpCustomServiceMessage(str2, zhiChiInitModeBase.getPartnerid(), zhiChiInitModeBase.getCid(), handler, str);
            LogUtils.i("客服模式");
        }
    }

    protected void sendMsg(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMuitidiaLeaveMsg(String str, String str2, final Handler handler, boolean z) {
        if (!isActive() || this.initModel == null) {
            return;
        }
        if (z) {
            str = System.currentTimeMillis() + "";
            sendNewMsgToHandler(ChatUtils.getMuitidiaLeaveMsgModel(str, str2), handler, 2);
        } else if (TextUtils.isEmpty(str)) {
            return;
        } else {
            updateMsgToHandler(str, handler, 2);
        }
        final String str3 = str;
        this.zhiChiApi.insertSysMsg(this, this.initModel.getCid(), this.initModel.getPartnerid(), str2.replace("\n", "<br/>"), "多轮对话工单提交确认提示", new StringResultCallBack<BaseCode>() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.9
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str4) {
                if (SobotChatBaseFragment.this.isActive()) {
                    SobotChatBaseFragment.this.updateMsgToHandler(str3, handler, 0);
                }
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(BaseCode baseCode) {
                if (SobotChatBaseFragment.this.isActive()) {
                    SobotChatBaseFragment.this.updateMsgToHandler(str3, handler, 1);
                }
            }
        });
    }

    protected void sendNewMsgToHandler(ZhiChiMessageBase zhiChiMessageBase, Handler handler, int i) {
        if (zhiChiMessageBase == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        zhiChiMessageBase.setSendSuccessState(i);
        obtainMessage.what = 601;
        obtainMessage.obj = zhiChiMessageBase;
        handler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendTextMessageToHandler(String str, String str2, Handler handler, int i, int i2) {
        sendTextMessageToHandler(str, str2, handler, i, i2, 0, "");
    }

    protected void sendTextMessageToHandler(String str, String str2, Handler handler, int i, int i2, int i3, String str3) {
        sendTextMessageToHandler(str, str2, "", handler, i, i2, i3, str3);
    }

    protected void sendTextMessageToHandler(String str, String str2, String str3, Handler handler, int i, int i2, int i3, String str4) {
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        zhiChiMessageBase.setId(str);
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        if (TextUtils.isEmpty(str2)) {
            zhiChiReplyAnswer.setMsg(str2);
        } else {
            zhiChiReplyAnswer.setMsg(str2.replace("&", "&amp;").replace(SimpleComparison.LESS_THAN_OPERATION, "&lt;").replace(SimpleComparison.GREATER_THAN_OPERATION, "&gt;").replace("\n", "<br/>").replace("&lt;br/&gt;", "<br/>"));
        }
        zhiChiReplyAnswer.setMsgType("0");
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        zhiChiMessageBase.setDesensitizationWord(str3);
        zhiChiMessageBase.setSenderName(this.info.getUser_nick());
        zhiChiMessageBase.setSenderFace(this.info.getFace());
        zhiChiMessageBase.setSenderType("0");
        zhiChiMessageBase.setSendSuccessState(i);
        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
        zhiChiMessageBase.setSentisive(i3);
        zhiChiMessageBase.setSentisiveExplain(str4);
        Message obtainMessage = handler.obtainMessage();
        if (i2 == 0) {
            obtainMessage.what = 601;
        } else if (i2 == 1) {
            obtainMessage.what = ZhiChiConstant.hander_update_msg_status;
        } else if (i2 == 2) {
            obtainMessage.what = 613;
        }
        obtainMessage.obj = zhiChiMessageBase;
        handler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendVoice(final String str, final String str2, String str3, String str4, final String str5, final Handler handler) {
        int i = this.current_client_model;
        if (i == 301) {
            this.zhiChiApi.sendVoiceToRobot(str5, str4, str3, this.initModel.getRobotid(), str2, new ResultCallBack<ZhiChiMessage>() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.10
                @Override // com.sobot.chat.api.ResultCallBack
                public void onFailure(Exception exc, String str6) {
                    if (SobotChatBaseFragment.this.isActive()) {
                        LogUtils.i("发送语音error:" + str6 + "exception:" + exc.toString());
                        SobotChatBaseFragment.this.sendVoiceMessageToHandler(str, str5, str2, 0, 1, handler);
                    }
                }

                @Override // com.sobot.chat.api.ResultCallBack
                public void onLoading(long j, long j2, boolean z) {
                }

                @Override // com.sobot.chat.api.ResultCallBack
                public void onSuccess(ZhiChiMessage zhiChiMessage) {
                    if (SobotChatBaseFragment.this.isActive()) {
                        LogUtils.i("发送给机器人语音---sobot---" + zhiChiMessage.getMsg());
                        String str6 = System.currentTimeMillis() + "";
                        SobotChatBaseFragment.this.isAboveZero = true;
                        SobotChatBaseFragment.this.restartMyTimeTask(handler);
                        if (TextUtils.isEmpty(zhiChiMessage.getMsg())) {
                            SobotChatBaseFragment.this.sendVoiceMessageToHandler(str, str5, str2, 1, 1, handler);
                        } else {
                            SobotChatBaseFragment.this.sendTextMessageToHandler(str, zhiChiMessage.getMsg(), handler, 1, 2);
                        }
                        ZhiChiMessageBase data = zhiChiMessage.getData();
                        if (data.getUstatus() == 0) {
                            SobotChatBaseFragment sobotChatBaseFragment = SobotChatBaseFragment.this;
                            sobotChatBaseFragment.customerServiceOffline(sobotChatBaseFragment.initModel, 4);
                            return;
                        }
                        SobotChatBaseFragment.this.isAboveZero = true;
                        data.setId(str6);
                        data.setSenderName(SobotChatBaseFragment.this.initModel.getRobotName());
                        data.setSender(SobotChatBaseFragment.this.initModel.getRobotName());
                        data.setSenderFace(SobotChatBaseFragment.this.initModel.getRobotLogo());
                        data.setSenderType("1");
                        Message obtainMessage = handler.obtainMessage();
                        obtainMessage.what = 602;
                        obtainMessage.obj = data;
                        handler.sendMessage(obtainMessage);
                    }
                }
            });
        } else if (i == 302) {
            LogUtils.i("发送给人工语音---sobot---" + str5);
            this.zhiChiApi.sendFile(str3, str4, str5, str2, new ResultCallBack<ZhiChiMessage>() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.11
                @Override // com.sobot.chat.api.ResultCallBack
                public void onFailure(Exception exc, String str6) {
                    if (SobotChatBaseFragment.this.isActive()) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("sendHttpCustomServiceMessage", exc.toString() + str6);
                        LogUtils.i2Local(hashMap, "1");
                        LogUtils.i("发送语音error:" + str6 + "exception:" + exc.toString());
                        SobotChatBaseFragment.this.sendVoiceMessageToHandler(str, str5, str2, 0, 1, handler);
                    }
                }

                @Override // com.sobot.chat.api.ResultCallBack
                public void onLoading(long j, long j2, boolean z) {
                }

                @Override // com.sobot.chat.api.ResultCallBack
                public void onSuccess(ZhiChiMessage zhiChiMessage) {
                    if (SobotChatBaseFragment.this.isActive()) {
                        SobotChatBaseFragment.this.isAboveZero = true;
                        SobotChatBaseFragment.this.restartMyTimeTask(handler);
                        SobotChatBaseFragment.this.sendVoiceMessageToHandler(str, str5, str2, 1, 1, handler);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendVoiceMessageToHandler(String str, String str2, String str3, int i, int i2, Handler handler) {
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        zhiChiReplyAnswer.setMsg(str2);
        zhiChiReplyAnswer.setDuration(str3);
        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        zhiChiMessageBase.setSenderType("25");
        zhiChiMessageBase.setId(str);
        zhiChiMessageBase.setSendSuccessState(i);
        Message obtainMessage = handler.obtainMessage();
        if (i2 == 1) {
            obtainMessage.what = 2000;
        } else if (i2 == 2) {
            obtainMessage.what = 2001;
        } else if (i2 == 0) {
            obtainMessage.what = 601;
        }
        obtainMessage.obj = zhiChiMessageBase;
        handler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdminFace(String str) {
        LogUtils.i("头像地址是" + str);
        this.adminFace = str;
    }

    public void setAudioStreamType(boolean z) {
        if (z) {
            this.audioManager.setSpeakerphoneOn(true);
            this.audioManager.setMode(0);
            AudioManager audioManager = this.audioManager;
            audioManager.setStreamVolume(1, audioManager.getStreamVolume(1), 0);
            return;
        }
        this.audioManager.setSpeakerphoneOn(false);
        if (Build.VERSION.SDK_INT >= 21) {
            this.audioManager.setMode(3);
            AudioManager audioManager2 = this.audioManager;
            audioManager2.setStreamVolume(0, audioManager2.getStreamMaxVolume(0), 0);
            return;
        }
        this.audioManager.setMode(2);
        AudioManager audioManager3 = this.audioManager;
        audioManager3.setStreamVolume(0, audioManager3.getStreamMaxVolume(0), 0);
    }

    public void setTimeTaskMethod(Handler handler) {
        if (this.customerState != CustomerState.Online) {
            stopCustomTimeTask();
            stopUserInfoTimeTask();
        } else if (this.current_client_model != 302 || this.is_startCustomTimerTask) {
        } else {
            stopUserInfoTimeTask();
            startCustomTimeTask(handler);
        }
    }

    public void startCustomTimeTask(Handler handler) {
        if (this.isChatLock != 1 && this.current_client_model == 302 && this.initModel.isServiceOutTimeFlag()) {
            if (this.initModel.isServiceOutCountRule() && this.serviceOutTimeTipCount >= 1) {
                stopCustomTimeTask();
            } else if (this.is_startCustomTimerTask) {
            } else {
                stopCustomTimeTask();
                this.customTimeTask = true;
                this.is_startCustomTimerTask = true;
                this.timerCustom = new Timer();
                TimerTask timerTask = new TimerTask() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.3
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                    }
                };
                this.taskCustom = timerTask;
                this.timerCustom.schedule(timerTask, 1000L, 1000L);
            }
        }
    }

    protected void startInputListener() {
        this.inputtingListener = new Timer();
        TimerTask timerTask = new TimerTask() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.12
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (SobotChatBaseFragment.this.customerState == CustomerState.Online && SobotChatBaseFragment.this.current_client_model == 302 && !SobotChatBaseFragment.this.isSendInput) {
                    try {
                        String sendMessageStr = SobotChatBaseFragment.this.getSendMessageStr();
                        if (TextUtils.isEmpty(sendMessageStr) || sendMessageStr.equals(SobotChatBaseFragment.this.lastInputStr)) {
                            return;
                        }
                        SobotChatBaseFragment.this.lastInputStr = sendMessageStr;
                        SobotChatBaseFragment.this.isSendInput = true;
                        SobotChatBaseFragment.this.zhiChiApi.input(SobotChatBaseFragment.this.initModel.getPartnerid(), sendMessageStr, new StringResultCallBack<CommonModel>() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.12.1
                            @Override // com.sobot.network.http.callback.StringResultCallBack
                            public void onFailure(Exception exc, String str) {
                                SobotChatBaseFragment.this.isSendInput = false;
                            }

                            @Override // com.sobot.network.http.callback.StringResultCallBack
                            public void onSuccess(CommonModel commonModel) {
                                SobotChatBaseFragment.this.isSendInput = false;
                            }
                        });
                    } catch (Exception e) {
                    }
                }
            }
        };
        this.inputTimerTask = timerTask;
        this.inputtingListener.schedule(timerTask, 0L, this.initModel.getInputTime() * 1000);
    }

    public void startPolling() {
        this.uid = SharedPreferencesUtil.getStringData(getSobotActivity(), Const.SOBOT_UID, "");
        this.puid = SharedPreferencesUtil.getStringData(getSobotActivity(), Const.SOBOT_PUID, "");
        getPollingHandler().removeCallbacks(this.pollingRun);
        getPollingHandler().postDelayed(this.pollingRun, 5000L);
        SharedPreferencesUtil.getStringData(getSobotActivity(), ZhiChiConstant.SOBOT_PLATFORM_UNIONCODE, "");
        LogUtils.i2Local("开启轮询", "SobotChatBaseFragment 轮询开始：参数{uid:" + this.uid + ",puid:" + this.puid + i.d);
    }

    public void startUserInfoTimeTask(Handler handler) {
        LogUtils.i("--->  startUserInfoTimeTask=====" + this.isChatLock);
        if (this.isChatLock != 1 && this.current_client_model == 302 && this.initModel.isCustomOutTimeFlag()) {
            stopUserInfoTimeTask();
            this.userInfoTimeTask = true;
            this.timerUserInfo = new Timer();
            TimerTask timerTask = new TimerTask() { // from class: com.sobot.chat.conversation.SobotChatBaseFragment.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                }
            };
            this.taskUserInfo = timerTask;
            this.timerUserInfo.schedule(timerTask, 1000L, 1000L);
        }
    }

    public void stopCustomTimeTask() {
        this.customTimeTask = false;
        this.is_startCustomTimerTask = false;
        Timer timer = this.timerCustom;
        if (timer != null) {
            timer.cancel();
            this.timerCustom = null;
        }
        TimerTask timerTask = this.taskCustom;
        if (timerTask != null) {
            timerTask.cancel();
            this.taskCustom = null;
        }
        this.noReplyTimeCustoms = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopInputListener() {
        Timer timer = this.inputtingListener;
        if (timer != null) {
            timer.cancel();
            this.inputtingListener = null;
        }
    }

    public void stopPolling() {
        if (this.pollingRun == null || getPollingHandler() == null) {
            return;
        }
        getPollingHandler().removeCallbacks(this.pollingRun);
        this.inPolling = false;
    }

    public void stopUserInfoTimeTask() {
        this.userInfoTimeTask = false;
        Timer timer = this.timerUserInfo;
        if (timer != null) {
            timer.cancel();
            this.timerUserInfo = null;
        }
        TimerTask timerTask = this.taskUserInfo;
        if (timerTask != null) {
            timerTask.cancel();
            this.taskUserInfo = null;
        }
        this.noReplyTimeUserInfo = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateMessageStatus(SobotMsgAdapter sobotMsgAdapter, Message message) {
        ZhiChiMessageBase zhiChiMessageBase = (ZhiChiMessageBase) message.obj;
        sobotMsgAdapter.updateDataStateById(zhiChiMessageBase.getId(), zhiChiMessageBase);
        sobotMsgAdapter.notifyDataSetChanged();
    }

    protected void updateMsgToHandler(String str, Handler handler, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        zhiChiMessageBase.setId(str);
        zhiChiMessageBase.setSendSuccessState(i);
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = ZhiChiConstant.hander_update_msg_status;
        obtainMessage.obj = zhiChiMessageBase;
        handler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateUiMessage(SobotMsgAdapter sobotMsgAdapter, Message message) {
        updateUiMessage(sobotMsgAdapter, (ZhiChiMessageBase) message.obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateUiMessage(SobotMsgAdapter sobotMsgAdapter, ZhiChiMessageBase zhiChiMessageBase) {
        sobotMsgAdapter.addData(zhiChiMessageBase);
        sobotMsgAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateUiMessageBefore(SobotMsgAdapter sobotMsgAdapter, ZhiChiMessageBase zhiChiMessageBase) {
        sobotMsgAdapter.addDataBefore(zhiChiMessageBase);
        sobotMsgAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateUiMessageStatus(SobotMsgAdapter sobotMsgAdapter, String str, int i, int i2) {
        sobotMsgAdapter.updateMsgInfoById(str, i, i2);
        sobotMsgAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateVoiceStatusMessage(SobotMsgAdapter sobotMsgAdapter, Message message) {
        ZhiChiMessageBase zhiChiMessageBase = (ZhiChiMessageBase) message.obj;
        sobotMsgAdapter.updateVoiceStatusById(zhiChiMessageBase.getId(), zhiChiMessageBase.getSendSuccessState(), zhiChiMessageBase.getAnswer().getDuration());
        sobotMsgAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uploadFile(File file, Handler handler, ListView listView, SobotMsgAdapter sobotMsgAdapter, boolean z) {
        if (file == null || !file.exists()) {
            return;
        }
        LogUtils.i(file.toString());
        String lowerCase = file.getName().toLowerCase();
        if (lowerCase.endsWith(".gif") || lowerCase.endsWith(".jpg") || lowerCase.endsWith(".png")) {
            ChatUtils.sendPicLimitBySize(file.getAbsolutePath(), this.initModel.getCid(), this.initModel.getPartnerid(), handler, this.mAppContext, listView, sobotMsgAdapter, z);
        } else if (file.length() > 52428800) {
            ToastUtil.showToast(getContext(), getResString("sobot_file_upload_failed"));
        } else if (FileOpenHelper.checkEndsWithInStringArray(lowerCase, getContext(), "sobot_fileEndingAll")) {
        } else {
            String valueOf = String.valueOf(System.currentTimeMillis());
            LogUtils.i("tmpMsgId:" + valueOf);
            this.zhiChiApi.addUploadFileTask(false, valueOf, this.initModel.getPartnerid(), this.initModel.getCid(), file.getAbsolutePath(), null);
            updateUiMessage(sobotMsgAdapter, ChatUtils.getUploadFileModel(getContext(), valueOf, file));
            this.isAboveZero = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uploadVideo(File file, Uri uri, SobotMsgAdapter sobotMsgAdapter) {
        String valueOf = String.valueOf(System.currentTimeMillis());
        LogUtils.i("tmpMsgId:" + valueOf);
        String encode = MD5Util.encode(file.getAbsolutePath());
        try {
            Activity sobotActivity = getSobotActivity();
            String saveImageFile = FileUtil.saveImageFile(sobotActivity, uri, encode + FileUtil.getFileEndWith(file.getAbsolutePath()), file.getAbsolutePath());
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(saveImageFile);
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(1L, 2);
            String saveBitmap = frameAtTime != null ? FileUtil.saveBitmap(100, frameAtTime) : "";
            this.zhiChiApi.addUploadFileTask(true, valueOf, this.initModel.getPartnerid(), this.initModel.getCid(), saveImageFile, saveBitmap);
            updateUiMessage(sobotMsgAdapter, ChatUtils.getUploadVideoModel(getContext(), valueOf, new File(saveImageFile), saveBitmap));
            this.isAboveZero = true;
        } catch (Exception e) {
            e.printStackTrace();
            ToastUtil.showToast(getSobotActivity(), ResourceUtils.getResString(getSobotActivity(), "sobot_pic_type_error"));
        }
    }
}
