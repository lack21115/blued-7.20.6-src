package com.sobot.chat.conversation;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.video.module.a.a.m;
import com.bytedance.applog.tracker.Tracker;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.hms.ads.fw;
import com.igexin.push.core.b;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sobot.chat.SobotApi;
import com.sobot.chat.SobotUIConfig;
import com.sobot.chat.ZCSobotApi;
import com.sobot.chat.activity.SobotCameraActivity;
import com.sobot.chat.activity.SobotChooseFileActivity;
import com.sobot.chat.activity.SobotPostLeaveMsgActivity;
import com.sobot.chat.activity.SobotSkillGroupActivity;
import com.sobot.chat.activity.WebViewActivity;
import com.sobot.chat.adapter.SobotMsgAdapter;
import com.sobot.chat.api.ZhiChiApi;
import com.sobot.chat.api.apiUtils.ZhiChiConstants;
import com.sobot.chat.api.enumtype.CustomerState;
import com.sobot.chat.api.enumtype.SobotAutoSendMsgMode;
import com.sobot.chat.api.enumtype.SobotChatStatusMode;
import com.sobot.chat.api.model.BaseCode;
import com.sobot.chat.api.model.CommonModel;
import com.sobot.chat.api.model.CommonModelBase;
import com.sobot.chat.api.model.ConsultingContent;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.api.model.OrderCardContentModel;
import com.sobot.chat.api.model.SobotCommentParam;
import com.sobot.chat.api.model.SobotConnCusParam;
import com.sobot.chat.api.model.SobotEvaluateModel;
import com.sobot.chat.api.model.SobotKeyWordTransfer;
import com.sobot.chat.api.model.SobotLableInfoList;
import com.sobot.chat.api.model.SobotLocationModel;
import com.sobot.chat.api.model.SobotMultiDiaRespInfo;
import com.sobot.chat.api.model.SobotRobot;
import com.sobot.chat.api.model.SobotTransferOperatorParam;
import com.sobot.chat.api.model.ZhiChiCidsModel;
import com.sobot.chat.api.model.ZhiChiGroup;
import com.sobot.chat.api.model.ZhiChiGroupBase;
import com.sobot.chat.api.model.ZhiChiHistoryMessage;
import com.sobot.chat.api.model.ZhiChiHistoryMessageBase;
import com.sobot.chat.api.model.ZhiChiInitModeBase;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.api.model.ZhiChiPushMessage;
import com.sobot.chat.api.model.ZhiChiReplyAnswer;
import com.sobot.chat.core.channel.Const;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.listener.HyperlinkListener;
import com.sobot.chat.listener.NewHyperlinkListener;
import com.sobot.chat.listener.NoDoubleClickListener;
import com.sobot.chat.listener.PermissionListenerImpl;
import com.sobot.chat.listener.SobotFunctionType;
import com.sobot.chat.presenter.StPostMsgPresenter;
import com.sobot.chat.server.SobotSessionServer;
import com.sobot.chat.utils.AnimationUtil;
import com.sobot.chat.utils.AudioTools;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.CustomToast;
import com.sobot.chat.utils.ExtAudioRecorder;
import com.sobot.chat.utils.ImageUtils;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.MediaFileUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.SobotOption;
import com.sobot.chat.utils.SobotPathManager;
import com.sobot.chat.utils.SobotSerializableMap;
import com.sobot.chat.utils.StServiceUtils;
import com.sobot.chat.utils.StringUtils;
import com.sobot.chat.utils.TimeTools;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.utils.ZhiChiConfig;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.viewHolder.CusEvaluateMessageHolder;
import com.sobot.chat.viewHolder.RichTextMessageHolder;
import com.sobot.chat.viewHolder.RobotTemplateMessageHolder1;
import com.sobot.chat.viewHolder.RobotTemplateMessageHolder2;
import com.sobot.chat.viewHolder.RobotTemplateMessageHolder3;
import com.sobot.chat.viewHolder.RobotTemplateMessageHolder4;
import com.sobot.chat.viewHolder.RobotTemplateMessageHolder5;
import com.sobot.chat.viewHolder.RobotTemplateMessageHolder6;
import com.sobot.chat.viewHolder.VoiceMessageHolder;
import com.sobot.chat.voice.AudioPlayCallBack;
import com.sobot.chat.voice.AudioPlayPresenter;
import com.sobot.chat.widget.ClearHistoryDialog;
import com.sobot.chat.widget.ContainsEmojiEditText;
import com.sobot.chat.widget.DropdownListView;
import com.sobot.chat.widget.dialog.SobotBackDialog;
import com.sobot.chat.widget.dialog.SobotClearHistoryMsgDialog;
import com.sobot.chat.widget.dialog.SobotEvaluateDialog;
import com.sobot.chat.widget.dialog.SobotRobotListDialog;
import com.sobot.chat.widget.emoji.DisplayEmojiRules;
import com.sobot.chat.widget.emoji.EmojiconNew;
import com.sobot.chat.widget.emoji.InputHelper;
import com.sobot.chat.widget.image.SobotRCImageView;
import com.sobot.chat.widget.kpswitch.CustomeChattingPanel;
import com.sobot.chat.widget.kpswitch.util.KPSwitchConflictUtil;
import com.sobot.chat.widget.kpswitch.util.KeyboardUtil;
import com.sobot.chat.widget.kpswitch.view.ChattingPanelEmoticonView;
import com.sobot.chat.widget.kpswitch.view.ChattingPanelUploadView;
import com.sobot.chat.widget.kpswitch.view.CustomeViewFactory;
import com.sobot.chat.widget.kpswitch.widget.KPSwitchPanelLinearLayout;
import com.sobot.network.http.callback.StringResultCallBack;
import com.sobot.network.http.upload.SobotUpload;
import com.sobot.pictureframe.SobotBitmapUtil;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/conversation/SobotChatFragment.class */
public class SobotChatFragment extends SobotChatBaseFragment implements View.OnClickListener, SobotMsgAdapter.SobotMsgCallBack, ContainsEmojiEditText.SobotAutoCompleteListener, DropdownListView.OnRefreshListenerHeader, SobotRobotListDialog.SobotRobotListListener, ChattingPanelEmoticonView.SobotEmoticonClickListener, ChattingPanelUploadView.SobotPlusClickListener {
    private static String preCurrentCid;
    private static int statusFlag;
    private AnimationDrawable animationDrawable;
    private ImageButton btn_emoticon_view;
    private ImageButton btn_model_edit;
    private ImageButton btn_model_voice;
    private LinearLayout btn_press_to_speak;
    private Button btn_reconnect;
    private Button btn_send;
    private ImageButton btn_set_mode_rengong;
    private Button btn_upload_view;
    private RelativeLayout chat_main;
    private SobotClearHistoryMsgDialog clearHistoryMsgDialog;
    private LinearLayout edittext_layout;
    private ContainsEmojiEditText et_sendmessage;
    private ExtAudioRecorder extAudioRecorder;
    private ImageView icon_nonet;
    private ImageView image_endVoice;
    private ImageView image_reLoading;
    boolean isCutVoice;
    ZhiChiMessageBase keyWordMessageBase;
    private List<ZhiChiGroupBase> list_group;
    private ProgressBar loading_anim_view;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;
    private DropdownListView lv_message;
    public SobotRCImageView mAvatarIV;
    private SobotEvaluateDialog mEvaluateDialog;
    private ViewTreeObserver.OnGlobalLayoutListener mKPSwitchListener;
    private KPSwitchPanelLinearLayout mPanelRoot;
    private StPostMsgPresenter mPostMsgPresenter;
    private SobotRobotListDialog mRobotListDialog;
    public TextView mTitleTextView;
    private ImageView mic_image;
    private ImageView mic_image_animate;
    public RelativeLayout net_status_remide;
    private TextView notReadInfo;
    private String offlineMsgAdminId;
    private int offlineMsgConnectFlag;
    private MyMessageReceiver receiver;
    private LinearLayout recording_container;
    private TextView recording_hint;
    private ImageView recording_timeshort;
    public RelativeLayout relative;
    private TextView send_voice_robot_hint;
    private SobotBackDialog sobotBackDialog;
    private RelativeLayout sobot_announcement;
    private TextView sobot_announcement_right_icon;
    private TextView sobot_announcement_title;
    public ProgressBar sobot_conn_loading;
    public LinearLayout sobot_container_conn_status;
    private HorizontalScrollView sobot_custom_menu;
    private LinearLayout sobot_custom_menu_linearlayout;
    public LinearLayout sobot_header_center_ll;
    private LinearLayout sobot_ll_bottom;
    private RelativeLayout sobot_ll_restart_talk;
    private LinearLayout sobot_ll_switch_robot;
    public TextView sobot_net_not_connect;
    public TextView sobot_title_conn_status;
    private TextView sobot_tv_close;
    private TextView sobot_tv_message;
    public TextView sobot_tv_right_second;
    public TextView sobot_tv_right_third;
    private TextView sobot_tv_satisfaction;
    private TextView sobot_tv_switch_robot;
    private TextView sobot_txt_restart_talk;
    String tempMsgContent;
    private TextView textReConnect;
    private TextView txt_loading;
    private TextView txt_speak_content;
    private View view_model_split;
    protected Timer voiceTimer;
    protected TimerTask voiceTimerTask;
    private TextView voice_time_long;
    private LinearLayout voice_top_image;
    private FrameLayout welcome;
    private List<ZhiChiMessageBase> messageList = new ArrayList();
    private int showTimeVisiableCustomBtn = 0;
    protected int type = -1;
    private boolean isSessionOver = true;
    private boolean isComment = false;
    private boolean isShowQueueTip = true;
    private int queueNum = 0;
    private int queueTimes = 0;
    private int mUnreadNum = 0;
    protected int voiceTimerLong = 0;
    protected String voiceTimeLongStr = "00";
    private int minRecordTime = 60;
    private int recordDownTime = 60 - 10;
    private String voiceMsgId = "";
    private int currentVoiceLong = 0;
    AudioPlayPresenter mAudioPlayPresenter = null;
    AudioPlayCallBack mAudioPlayCallBack = null;
    private String mFileName = null;
    private List<String> cids = new ArrayList();
    private int currentCidPosition = 0;
    private int queryCidsStatus = 0;
    private boolean isInGethistory = false;
    private boolean isConnCustomerService = false;
    private boolean isNoMoreHistoryMsg = false;
    public int currentPanelId = 0;
    private int mBottomViewtype = 0;
    private boolean isAppInitEnd = true;
    public Handler handler = new Handler() { // from class: com.sobot.chat.conversation.SobotChatFragment.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (SobotChatFragment.this.isActive()) {
                int i = message.what;
                if (i == 613) {
                    ZhiChiMessageBase zhiChiMessageBase = (ZhiChiMessageBase) message.obj;
                    SobotChatFragment.this.messageAdapter.updateDataById(zhiChiMessageBase.getId(), zhiChiMessageBase);
                    SobotChatFragment.this.messageAdapter.notifyDataSetChanged();
                    SobotChatFragment.this.lv_message.setSelection(SobotChatFragment.this.messageAdapter.getCount());
                } else if (i == 800) {
                    SobotChatFragment sobotChatFragment = SobotChatFragment.this;
                    sobotChatFragment.updateUiMessage(sobotChatFragment.messageAdapter, message);
                    SobotChatFragment.this.stopUserInfoTimeTask();
                    LogUtils.i("客户的定时任务的时间  停止定时任务：" + SobotChatFragment.this.noReplyTimeUserInfo);
                } else if (i == 802) {
                    SobotChatFragment sobotChatFragment2 = SobotChatFragment.this;
                    sobotChatFragment2.updateUiMessage(sobotChatFragment2.messageAdapter, message);
                    LogUtils.i("客服的定时任务:" + SobotChatFragment.this.noReplyTimeCustoms);
                    SobotChatFragment.this.stopCustomTimeTask();
                } else if (i == 1602) {
                    SobotChatFragment sobotChatFragment3 = SobotChatFragment.this;
                    sobotChatFragment3.updateMessageStatus(sobotChatFragment3.messageAdapter, message);
                } else if (i == 1000) {
                    if (SobotChatFragment.this.voiceTimerLong >= SobotChatFragment.this.minRecordTime * 1000) {
                        SobotChatFragment.this.isCutVoice = true;
                        SobotChatFragment.this.voiceCuttingMethod();
                        SobotChatFragment.this.voiceTimerLong = 0;
                        SobotChatFragment.this.recording_hint.setText(SobotChatFragment.this.getResString("sobot_voiceTooLong"));
                        SobotChatFragment.this.recording_hint.setBackgroundResource(SobotChatFragment.this.getResDrawableId("sobot_recording_text_hint_bg"));
                        SobotChatFragment.this.recording_timeshort.setVisibility(0);
                        SobotChatFragment.this.mic_image.setVisibility(8);
                        SobotChatFragment.this.mic_image_animate.setVisibility(8);
                        SobotChatFragment.this.closeVoiceWindows(2);
                        SobotChatFragment.this.btn_press_to_speak.setPressed(false);
                        SobotChatFragment.this.currentVoiceLong = 0;
                        return;
                    }
                    int parseInt = Integer.parseInt(message.obj.toString());
                    SobotChatFragment.this.currentVoiceLong = parseInt;
                    if (parseInt < SobotChatFragment.this.recordDownTime * 1000) {
                        if (parseInt % 1000 == 0) {
                            SobotChatFragment.this.voiceTimeLongStr = TimeTools.instance.calculatTime(parseInt);
                            TextView textView = SobotChatFragment.this.voice_time_long;
                            textView.setText(SobotChatFragment.this.voiceTimeLongStr.substring(3) + "''");
                        }
                    } else if (parseInt >= SobotChatFragment.this.minRecordTime * 1000) {
                        SobotChatFragment.this.voice_time_long.setText(SobotChatFragment.this.getResString("sobot_voiceTooLong"));
                    } else if (parseInt % 1000 == 0) {
                        SobotChatFragment.this.voiceTimeLongStr = TimeTools.instance.calculatTime(parseInt);
                        TextView textView2 = SobotChatFragment.this.voice_time_long;
                        textView2.setText(SobotChatFragment.this.getResString("sobot_count_down") + (((SobotChatFragment.this.minRecordTime * 1000) - parseInt) / 1000));
                    }
                } else if (i == 1001) {
                    if (SobotChatFragment.this.sobot_tv_close != null && SobotChatFragment.this.info.isShowCloseBtn() && SobotChatFragment.this.current_client_model == 302) {
                        SobotChatFragment.this.sobot_tv_close.setVisibility(0);
                    }
                } else if (i == 2000) {
                    SobotChatFragment sobotChatFragment4 = SobotChatFragment.this;
                    sobotChatFragment4.updateVoiceStatusMessage(sobotChatFragment4.messageAdapter, message);
                } else if (i == 2001) {
                    SobotChatFragment sobotChatFragment5 = SobotChatFragment.this;
                    sobotChatFragment5.cancelUiVoiceMessage(sobotChatFragment5.messageAdapter, message);
                } else {
                    switch (i) {
                        case 401:
                            String str = (String) message.obj;
                            SobotChatFragment sobotChatFragment6 = SobotChatFragment.this;
                            sobotChatFragment6.updateUiMessageStatus(sobotChatFragment6.messageAdapter, str, 0, 0);
                            return;
                        case 402:
                            SobotChatFragment sobotChatFragment7 = SobotChatFragment.this;
                            sobotChatFragment7.setTimeTaskMethod(sobotChatFragment7.handler);
                            String str2 = (String) message.obj;
                            SobotChatFragment sobotChatFragment8 = SobotChatFragment.this;
                            sobotChatFragment8.updateUiMessageStatus(sobotChatFragment8.messageAdapter, str2, 1, 0);
                            return;
                        case 403:
                            String str3 = (String) message.obj;
                            int i2 = message.arg1;
                            SobotChatFragment sobotChatFragment9 = SobotChatFragment.this;
                            sobotChatFragment9.updateUiMessageStatus(sobotChatFragment9.messageAdapter, str3, 2, i2);
                            return;
                        default:
                            switch (i) {
                                case 601:
                                    SobotChatFragment sobotChatFragment10 = SobotChatFragment.this;
                                    sobotChatFragment10.updateUiMessage(sobotChatFragment10.messageAdapter, message);
                                    SobotChatFragment.this.lv_message.setSelection(SobotChatFragment.this.messageAdapter.getCount());
                                    return;
                                case 602:
                                    ZhiChiMessageBase zhiChiMessageBase2 = (ZhiChiMessageBase) message.obj;
                                    zhiChiMessageBase2.setT(Calendar.getInstance().getTime().getTime() + "");
                                    if ((SobotChatFragment.this.type == 3 || SobotChatFragment.this.type == 4) && SobotChatFragment.this.initModel != null && ChatUtils.checkManualType(SobotChatFragment.this.initModel.getManualType(), zhiChiMessageBase2.getAnswerType())) {
                                        zhiChiMessageBase2.setShowTransferBtn(true);
                                    }
                                    if ("1".equals(zhiChiMessageBase2.getAnswerType()) || "9".equals(zhiChiMessageBase2.getAnswerType()) || "2".equals(zhiChiMessageBase2.getAnswerType()) || "11".equals(zhiChiMessageBase2.getAnswerType()) || "12".equals(zhiChiMessageBase2.getAnswerType()) || "14".equals(zhiChiMessageBase2.getAnswerType()) || (!TextUtils.isEmpty(zhiChiMessageBase2.getAnswerType()) && zhiChiMessageBase2.getAnswerType().startsWith("152"))) {
                                        if (SobotChatFragment.this.initModel == null || !SobotChatFragment.this.initModel.isRealuateFlag()) {
                                            zhiChiMessageBase2.setRevaluateState(0);
                                        } else {
                                            zhiChiMessageBase2.setRevaluateState(1);
                                            if ("27".equals(zhiChiMessageBase2.getSenderType()) || (!TextUtils.isEmpty(zhiChiMessageBase2.getAnswerType()) && "1525".equals(zhiChiMessageBase2.getAnswerType()))) {
                                                zhiChiMessageBase2.setRevaluateState(0);
                                            }
                                        }
                                    }
                                    if (zhiChiMessageBase2.getAnswer() != null && zhiChiMessageBase2.getAnswer().getMultiDiaRespInfo() != null && zhiChiMessageBase2.getAnswer().getMultiDiaRespInfo().getEndFlag()) {
                                        SobotChatFragment.this.restMultiMsg();
                                        SobotMultiDiaRespInfo multiDiaRespInfo = zhiChiMessageBase2.getAnswer().getMultiDiaRespInfo();
                                        if (multiDiaRespInfo.getEndFlag() && "1525".equals(zhiChiMessageBase2.getAnswerType()) && !TextUtils.isEmpty(multiDiaRespInfo.getLeaveTemplateId())) {
                                            SobotChatFragment.this.mulitDiaToLeaveMsg(multiDiaRespInfo.getLeaveTemplateId());
                                        }
                                    }
                                    SobotKeyWordTransfer sobotKeyWordTransfer = zhiChiMessageBase2.getSobotKeyWordTransfer();
                                    if (sobotKeyWordTransfer == null) {
                                        SobotChatFragment.this.messageAdapter.justAddData(zhiChiMessageBase2);
                                        if (SobotChatFragment.this.type != 1 && (zhiChiMessageBase2.getTransferType() == 1 || zhiChiMessageBase2.getTransferType() == 2 || zhiChiMessageBase2.getTransferType() == 5)) {
                                            SobotChatFragment.this.messageAdapter.justAddData(ChatUtils.getRobotTransferTip(SobotChatFragment.this.getContext(), SobotChatFragment.this.initModel));
                                            if (zhiChiMessageBase2.getTransferType() == 5) {
                                                SobotChatFragment.this.transfer2Custom(null, null, null, true, "1".equals(zhiChiMessageBase2.getAnswerType()) ? 6 : "2".equals(zhiChiMessageBase2.getAnswerType()) ? 7 : "4".equals(zhiChiMessageBase2.getAnswerType()) ? 8 : "3".equals(zhiChiMessageBase2.getAnswerType()) ? 9 : 5, zhiChiMessageBase2.getDocId(), zhiChiMessageBase2.getOriginQuestion(), "0");
                                            } else if (zhiChiMessageBase2.getTransferType() == 3) {
                                                SobotChatFragment.this.transfer2Custom(null, zhiChiMessageBase2.getSobotKeyWordTransfer().getKeyword(), zhiChiMessageBase2.getSobotKeyWordTransfer().getKeywordId(), true, zhiChiMessageBase2.getTransferType(), zhiChiMessageBase2.getDocId(), zhiChiMessageBase2.getOriginQuestion(), "0");
                                            } else {
                                                SobotChatFragment.this.transfer2Custom(null, null, null, true, zhiChiMessageBase2.getTransferType(), zhiChiMessageBase2.getDocId(), zhiChiMessageBase2.getOriginQuestion(), "0");
                                            }
                                        }
                                    } else if (SobotChatFragment.this.type == 1) {
                                        SobotChatFragment.this.messageAdapter.justAddData(zhiChiMessageBase2);
                                    } else if (1 == sobotKeyWordTransfer.getTransferFlag()) {
                                        if (sobotKeyWordTransfer.isQueueFlag()) {
                                            SobotChatFragment.this.addKeyWordTipMsg(sobotKeyWordTransfer);
                                            SobotChatFragment.this.transfer2Custom(sobotKeyWordTransfer.getGroupId(), sobotKeyWordTransfer.getKeyword(), sobotKeyWordTransfer.getKeywordId(), sobotKeyWordTransfer.isQueueFlag(), zhiChiMessageBase2.getTransferType());
                                        } else if (sobotKeyWordTransfer.getOnlineFlag() == 1) {
                                            SobotChatFragment.this.addKeyWordTipMsg(sobotKeyWordTransfer);
                                            SobotChatFragment.this.transfer2Custom(sobotKeyWordTransfer.getGroupId(), sobotKeyWordTransfer.getKeyword(), sobotKeyWordTransfer.getKeywordId(), sobotKeyWordTransfer.isQueueFlag(), zhiChiMessageBase2.getTransferType());
                                        } else if (sobotKeyWordTransfer.getOnlineFlag() == 2) {
                                            SobotChatFragment.this.transfer2Custom(sobotKeyWordTransfer.getGroupId(), sobotKeyWordTransfer.getKeyword(), sobotKeyWordTransfer.getKeywordId(), sobotKeyWordTransfer.isQueueFlag(), zhiChiMessageBase2.getTransferType());
                                        } else if (sobotKeyWordTransfer.getOnlineFlag() == 3) {
                                            SobotChatFragment.this.messageAdapter.justAddData(zhiChiMessageBase2);
                                        }
                                    } else if (2 == sobotKeyWordTransfer.getTransferFlag()) {
                                        ZhiChiMessageBase zhiChiMessageBase3 = new ZhiChiMessageBase();
                                        zhiChiMessageBase3.setSenderFace(zhiChiMessageBase2.getSenderFace());
                                        zhiChiMessageBase3.setSenderType(BaseWrapper.ENTER_ID_OAPS_DEMO);
                                        zhiChiMessageBase3.setSenderName(zhiChiMessageBase2.getSenderName());
                                        zhiChiMessageBase3.setSobotKeyWordTransfer(sobotKeyWordTransfer);
                                        SobotChatFragment.this.messageAdapter.justAddData(zhiChiMessageBase3);
                                    } else if (3 == sobotKeyWordTransfer.getTransferFlag()) {
                                        if (sobotKeyWordTransfer.isQueueFlag()) {
                                            SobotChatFragment.this.addKeyWordTipMsg(sobotKeyWordTransfer);
                                            SobotChatFragment.this.transfer2Custom(sobotKeyWordTransfer.getGroupId(), sobotKeyWordTransfer.getKeyword(), sobotKeyWordTransfer.getKeywordId(), sobotKeyWordTransfer.isQueueFlag(), zhiChiMessageBase2.getTransferType());
                                        } else if (sobotKeyWordTransfer.getOnlineFlag() == 1) {
                                            SobotChatFragment.this.addKeyWordTipMsg(sobotKeyWordTransfer);
                                            SobotChatFragment.this.transfer2Custom(sobotKeyWordTransfer.getGroupId(), sobotKeyWordTransfer.getKeyword(), sobotKeyWordTransfer.getKeywordId(), sobotKeyWordTransfer.isQueueFlag(), zhiChiMessageBase2.getTransferType());
                                        } else if (sobotKeyWordTransfer.getOnlineFlag() == 2) {
                                            SobotChatFragment.this.transfer2Custom(sobotKeyWordTransfer.getGroupId(), sobotKeyWordTransfer.getKeyword(), sobotKeyWordTransfer.getKeywordId(), sobotKeyWordTransfer.isQueueFlag(), zhiChiMessageBase2.getTransferType());
                                        } else if (sobotKeyWordTransfer.getOnlineFlag() == 3) {
                                            SobotChatFragment.this.messageAdapter.justAddData(zhiChiMessageBase2);
                                        }
                                    }
                                    SobotChatFragment.this.messageAdapter.notifyDataSetChanged();
                                    if (SobotMsgManager.getInstance(SobotChatFragment.this.mAppContext).getConfig(SobotChatFragment.this.info.getApp_key()).getInitModel() != null) {
                                        SobotMsgManager.getInstance(SobotChatFragment.this.mAppContext).getConfig(SobotChatFragment.this.info.getApp_key()).addMessage(zhiChiMessageBase2);
                                    }
                                    if (SobotChatFragment.this.type == 3 && ("3".equals(zhiChiMessageBase2.getAnswerType()) || "4".equals(zhiChiMessageBase2.getAnswerType()))) {
                                        SobotChatFragment.this.showTransferCustomer();
                                    }
                                    SobotChatFragment.this.gotoLastItem();
                                    return;
                                case 603:
                                    int i3 = message.arg1;
                                    SobotChatFragment.this.txt_speak_content.setText(SobotChatFragment.this.getResString("sobot_press_say"));
                                    SobotChatFragment.this.currentVoiceLong = 0;
                                    SobotChatFragment.this.recording_container.setVisibility(8);
                                    if (i3 != 0) {
                                        return;
                                    }
                                    int size = SobotChatFragment.this.messageList.size();
                                    while (true) {
                                        int i4 = size - 1;
                                        if (i4 <= 0) {
                                            return;
                                        }
                                        if (!TextUtils.isEmpty(((ZhiChiMessageBase) SobotChatFragment.this.messageList.get(i4)).getSenderType()) && Integer.parseInt(((ZhiChiMessageBase) SobotChatFragment.this.messageList.get(i4)).getSenderType()) == 8) {
                                            SobotChatFragment.this.messageList.remove(i4);
                                            return;
                                        }
                                        size = i4;
                                    }
                                    break;
                                default:
                                    return;
                            }
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/conversation/SobotChatFragment$LocalReceiver.class */
    public class LocalReceiver extends BroadcastReceiver {
        LocalReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ZhiChiPushMessage zhiChiPushMessage;
            Bundle extras;
            SobotSerializableMap sobotSerializableMap;
            try {
                LogUtils.i("广播是  :" + intent.getAction());
                if (ZhiChiConstants.receiveMessageBrocast.equals(intent.getAction())) {
                    try {
                        extras = intent.getExtras();
                    } catch (Exception e) {
                    }
                    if (extras != null) {
                        zhiChiPushMessage = (ZhiChiPushMessage) extras.getSerializable(ZhiChiConstants.ZHICHI_PUSH_MESSAGE);
                        try {
                            LogUtils.i("广播对象是  :" + zhiChiPushMessage.toString());
                        } catch (Exception e2) {
                        }
                        if (zhiChiPushMessage != null || !SobotChatFragment.this.info.getApp_key().equals(zhiChiPushMessage.getAppId())) {
                            return;
                        }
                        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
                        if (215 == zhiChiPushMessage.getType()) {
                            zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
                            zhiChiMessageBase.setMsgId(zhiChiPushMessage.getMsgId());
                            zhiChiMessageBase.setSender(zhiChiPushMessage.getAname());
                            zhiChiMessageBase.setSenderName(zhiChiPushMessage.getAname());
                            zhiChiMessageBase.setSenderFace(zhiChiPushMessage.getAface());
                            if (TextUtils.isEmpty(zhiChiPushMessage.getSysType()) || !("1".equals(zhiChiPushMessage.getSysType()) || "2".equals(zhiChiPushMessage.getSysType()) || "5".equals(zhiChiPushMessage.getSysType()))) {
                                zhiChiMessageBase.setAction("29");
                                zhiChiMessageBase.setMsgId(zhiChiPushMessage.getMsgId());
                                zhiChiMessageBase.setMsg(zhiChiPushMessage.getContent());
                                SobotChatFragment.this.stopCustomTimeTask();
                                SobotChatFragment.this.startUserInfoTimeTask(SobotChatFragment.this.handler);
                            } else {
                                zhiChiMessageBase.setSenderType("2");
                                ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
                                zhiChiReplyAnswer.setMsg(zhiChiPushMessage.getContent());
                                zhiChiReplyAnswer.setMsgType("0");
                                zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
                            }
                            SobotChatFragment.this.messageAdapter.justAddData(zhiChiMessageBase);
                            SobotChatFragment.this.messageAdapter.notifyDataSetChanged();
                            ChatUtils.msgLogicalProcess(SobotChatFragment.this.initModel, SobotChatFragment.this.messageAdapter, zhiChiPushMessage);
                            SobotChatFragment.this.messageAdapter.notifyDataSetChanged();
                            return;
                        }
                        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
                        zhiChiMessageBase.setMsgId(zhiChiPushMessage.getMsgId());
                        zhiChiMessageBase.setSender(zhiChiPushMessage.getAname());
                        zhiChiMessageBase.setSenderName(zhiChiPushMessage.getAname());
                        zhiChiMessageBase.setSenderFace(zhiChiPushMessage.getAface());
                        zhiChiMessageBase.setOrderCardContent(zhiChiPushMessage.getOrderCardContent());
                        zhiChiMessageBase.setConsultingContent(zhiChiPushMessage.getConsultingContent());
                        zhiChiMessageBase.setSenderType("2");
                        zhiChiMessageBase.setAnswer(zhiChiPushMessage.getAnswer());
                        if (200 == zhiChiPushMessage.getType()) {
                            SobotChatFragment.this.setAdminFace(zhiChiPushMessage.getAface());
                            if (SobotChatFragment.this.initModel != null) {
                                SobotChatFragment.this.initModel.setAdminHelloWord(!TextUtils.isEmpty(zhiChiPushMessage.getAdminHelloWord()) ? zhiChiPushMessage.getAdminHelloWord() : SobotChatFragment.this.initModel.getAdminHelloWord());
                                SobotChatFragment.this.initModel.setServiceEndPushMsg(!TextUtils.isEmpty(zhiChiPushMessage.getServiceEndPushMsg()) ? zhiChiPushMessage.getServiceEndPushMsg() : SobotChatFragment.this.initModel.getServiceEndPushMsg());
                            }
                            SobotChatFragment.this.createCustomerService(zhiChiPushMessage.getAname(), zhiChiPushMessage.getAface());
                        } else if (201 == zhiChiPushMessage.getType()) {
                            SobotChatFragment.this.createCustomerQueue(zhiChiPushMessage.getCount(), 0, zhiChiPushMessage.getQueueDoc(), SobotChatFragment.this.isShowQueueTip);
                        } else if (202 == zhiChiPushMessage.getType()) {
                            zhiChiMessageBase.setMsgId(zhiChiPushMessage.getMsgId());
                            zhiChiMessageBase.setSender(zhiChiPushMessage.getAname());
                            zhiChiMessageBase.setSenderName(zhiChiPushMessage.getAname());
                            zhiChiMessageBase.setSenderFace(zhiChiPushMessage.getAface());
                            zhiChiMessageBase.setSenderType("2");
                            zhiChiMessageBase.setAnswer(zhiChiPushMessage.getAnswer());
                            SobotChatFragment.this.stopCustomTimeTask();
                            SobotChatFragment.this.startUserInfoTimeTask(SobotChatFragment.this.handler);
                            SobotChatFragment.this.messageAdapter.justAddData(zhiChiMessageBase);
                            SobotChatFragment.this.messageAdapter.notifyDataSetChanged();
                            ChatUtils.msgLogicalProcess(SobotChatFragment.this.initModel, SobotChatFragment.this.messageAdapter, zhiChiPushMessage);
                            SobotChatFragment.this.messageAdapter.notifyDataSetChanged();
                            SobotChatFragment.this.customerState = CustomerState.Online;
                        } else if (204 == zhiChiPushMessage.getType()) {
                            if (6 == Integer.parseInt(zhiChiPushMessage.getStatus())) {
                                String stringData = SharedPreferencesUtil.getStringData(SobotChatFragment.this.getSobotActivity(), Const.SOBOT_PUID, "");
                                if (!TextUtils.isEmpty(stringData) && !TextUtils.isEmpty(zhiChiPushMessage.getPuid()) && stringData.equals(zhiChiPushMessage.getPuid())) {
                                    SobotChatFragment.this.customerServiceOffline(SobotChatFragment.this.initModel, Integer.parseInt(zhiChiPushMessage.getStatus()));
                                }
                            } else {
                                SobotChatFragment.this.customerServiceOffline(SobotChatFragment.this.initModel, Integer.parseInt(zhiChiPushMessage.getStatus()));
                            }
                        } else if (210 == zhiChiPushMessage.getType()) {
                            LogUtils.i("用户被转接--->" + zhiChiPushMessage.getName());
                            SobotChatFragment.this.showLogicTitle(zhiChiPushMessage.getName(), zhiChiPushMessage.getFace(), false);
                            SobotChatFragment.this.setAdminFace(zhiChiPushMessage.getFace());
                            SobotChatFragment.this.currentUserName = zhiChiPushMessage.getName();
                        } else if (213 == zhiChiPushMessage.getType()) {
                            if (SobotChatFragment.this.customerState == CustomerState.Online) {
                                if (1 == zhiChiPushMessage.getLockType()) {
                                    SobotChatFragment.this.paseReplyTimeCustoms = SobotChatFragment.this.noReplyTimeCustoms;
                                    SobotChatFragment.this.paseReplyTimeUserInfo = SobotChatFragment.this.noReplyTimeUserInfo;
                                    SobotChatFragment.this.isChatLock = 1;
                                    if (SobotChatFragment.this.is_startCustomTimerTask) {
                                        LogUtils.i("客服定时任务 锁定--->" + SobotChatFragment.this.noReplyTimeCustoms);
                                        SobotChatFragment.this.stopCustomTimeTask();
                                        SobotChatFragment.this.is_startCustomTimerTask = true;
                                        SobotChatFragment.this.noReplyTimeCustoms = SobotChatFragment.this.paseReplyTimeCustoms;
                                        SobotChatFragment.this.customTimeTask = true;
                                    } else {
                                        LogUtils.i("用户定时任务 锁定--->" + SobotChatFragment.this.noReplyTimeUserInfo);
                                        SobotChatFragment.this.stopUserInfoTimeTask();
                                        SobotChatFragment.this.noReplyTimeUserInfo = SobotChatFragment.this.paseReplyTimeUserInfo;
                                        SobotChatFragment.this.userInfoTimeTask = true;
                                    }
                                } else {
                                    SobotChatFragment.this.isChatLock = 2;
                                    if (SobotChatFragment.this.current_client_model == 302) {
                                        if (SobotChatFragment.this.is_startCustomTimerTask) {
                                            SobotChatFragment.this.stopCustomTimeTask();
                                            SobotChatFragment.this.startCustomTimeTask(SobotChatFragment.this.handler);
                                            SobotChatFragment.this.noReplyTimeCustoms = SobotChatFragment.this.paseReplyTimeCustoms;
                                            SobotChatFragment.this.customTimeTask = true;
                                            LogUtils.i("客服定时任务 解锁--->" + SobotChatFragment.this.noReplyTimeCustoms);
                                        } else {
                                            SobotChatFragment.this.stopUserInfoTimeTask();
                                            SobotChatFragment.this.startUserInfoTimeTask(SobotChatFragment.this.handler);
                                            SobotChatFragment.this.userInfoTimeTask = true;
                                            SobotChatFragment.this.noReplyTimeUserInfo = SobotChatFragment.this.paseReplyTimeUserInfo;
                                            LogUtils.i("用户定时任务 解锁--->" + SobotChatFragment.this.noReplyTimeUserInfo);
                                        }
                                    }
                                }
                            }
                        } else if (209 == zhiChiPushMessage.getType()) {
                            LogUtils.i("客服推送满意度评价.................");
                            if (SobotChatFragment.this.isAboveZero && !SobotChatFragment.this.isComment && SobotChatFragment.this.customerState == CustomerState.Online) {
                                SobotChatFragment.this.updateUiMessage(SobotChatFragment.this.messageAdapter, ChatUtils.getCustomEvaluateMode(zhiChiPushMessage));
                            }
                        } else if (211 == zhiChiPushMessage.getType() && !TextUtils.isEmpty(zhiChiPushMessage.getRevokeMsgId())) {
                            List<ZhiChiMessageBase> datas = SobotChatFragment.this.messageAdapter.getDatas();
                            int size = datas.size();
                            while (true) {
                                int i = size - 1;
                                if (i < 0) {
                                    break;
                                }
                                ZhiChiMessageBase zhiChiMessageBase2 = datas.get(i);
                                if (!zhiChiPushMessage.getRevokeMsgId().equals(zhiChiMessageBase2.getMsgId())) {
                                    size = i;
                                } else if (!zhiChiMessageBase2.isRetractedMsg()) {
                                    zhiChiMessageBase2.setRetractedMsg(true);
                                    SobotChatFragment.this.messageAdapter.notifyDataSetChanged();
                                }
                            }
                        }
                    }
                    zhiChiPushMessage = null;
                    if (zhiChiPushMessage != null) {
                        return;
                    }
                    return;
                } else if (ZhiChiConstant.SOBOT_BROCAST_ACTION_SEND_LOCATION.equals(intent.getAction())) {
                    SobotLocationModel sobotLocationModel = (SobotLocationModel) intent.getSerializableExtra(ZhiChiConstant.SOBOT_LOCATION_DATA);
                    if (sobotLocationModel != null) {
                        SobotChatFragment.this.sendLocation(null, sobotLocationModel, SobotChatFragment.this.handler, true);
                    }
                } else if (ZhiChiConstant.SOBOT_BROCAST_ACTION_SEND_TEXT.equals(intent.getAction())) {
                    String stringExtra = intent.getStringExtra(ZhiChiConstant.SOBOT_SEND_DATA);
                    String stringExtra2 = intent.getStringExtra("sendTextTo");
                    if (301 == SobotChatFragment.this.current_client_model && "robot".equals(stringExtra2)) {
                        if (!TextUtils.isEmpty(stringExtra)) {
                            SobotChatFragment.this.sendMsg(stringExtra);
                        }
                    } else if (302 == SobotChatFragment.this.current_client_model && "user".equals(stringExtra2) && !TextUtils.isEmpty(stringExtra)) {
                        SobotChatFragment.this.sendMsg(stringExtra);
                    }
                } else if (ZhiChiConstant.SOBOT_BROCAST_ACTION_SEND_OBJECT.equals(intent.getAction())) {
                    String stringExtra3 = intent.getStringExtra(ZhiChiConstant.SOBOT_SEND_DATA);
                    String stringExtra4 = intent.getStringExtra(ZhiChiConstant.SOBOT_TYPE_DATA);
                    if (302 == SobotChatFragment.this.current_client_model) {
                        if (TextUtils.isEmpty(stringExtra3)) {
                            LogUtils.i("发送内容不能为空");
                            return;
                        } else if ("0".equals(stringExtra4)) {
                            SobotChatFragment.this.sendMsg(stringExtra3);
                        } else if ("1".equals(stringExtra4)) {
                            File file = new File(stringExtra3);
                            if (file.exists()) {
                                SobotChatFragment.this.uploadFile(file, SobotChatFragment.this.handler, SobotChatFragment.this.lv_message, SobotChatFragment.this.messageAdapter, false);
                            }
                        } else if ("3".equals(stringExtra4)) {
                            File file2 = new File(stringExtra3);
                            if (file2.exists()) {
                                SobotChatFragment.this.uploadVideo(file2, null, SobotChatFragment.this.messageAdapter);
                            }
                        } else if ("4".equals(stringExtra4)) {
                            File file3 = new File(stringExtra3);
                            if (file3.exists()) {
                                SobotChatFragment.this.uploadFile(file3, SobotChatFragment.this.handler, SobotChatFragment.this.lv_message, SobotChatFragment.this.messageAdapter, false);
                            }
                        }
                    }
                } else if (ZhiChiConstant.SOBOT_BROCAST_ACTION_TRASNFER_TO_OPERATOR.equals(intent.getAction())) {
                    SobotTransferOperatorParam sobotTransferOperatorParam = (SobotTransferOperatorParam) intent.getSerializableExtra(ZhiChiConstant.SOBOT_SEND_DATA);
                    if (sobotTransferOperatorParam != null) {
                        if (sobotTransferOperatorParam.getConsultingContent() != null) {
                            SobotChatFragment.this.info.setConsultingContent(sobotTransferOperatorParam.getConsultingContent());
                        }
                        if (sobotTransferOperatorParam.getSummary_params() != null) {
                            SobotChatFragment.this.info.setSummary_params(sobotTransferOperatorParam.getSummary_params());
                        }
                        SobotConnCusParam sobotConnCusParam = new SobotConnCusParam();
                        sobotConnCusParam.setGroupId(sobotTransferOperatorParam.getGroupId());
                        sobotConnCusParam.setGroupName(sobotTransferOperatorParam.getGroupName());
                        sobotConnCusParam.setKeyword(sobotTransferOperatorParam.getKeyword());
                        sobotConnCusParam.setKeywordId(sobotTransferOperatorParam.getKeywordId());
                        SobotChatFragment.this.connectCustomerService(sobotConnCusParam, sobotTransferOperatorParam.isShowTips());
                    }
                } else if (ZhiChiConstant.SOBOT_BROCAST_ACTION_SEND_CARD.equals(intent.getAction())) {
                    SobotChatFragment.this.sendCardMsg((ConsultingContent) intent.getSerializableExtra(ZhiChiConstant.SOBOT_SEND_DATA));
                } else if (ZhiChiConstant.SOBOT_BROCAST_ACTION_SEND_ORDER_CARD.equals(intent.getAction())) {
                    SobotChatFragment.this.sendOrderCardMsg((OrderCardContentModel) intent.getSerializableExtra(ZhiChiConstant.SOBOT_SEND_DATA));
                }
                if (ZhiChiConstants.chat_remind_post_msg.equals(intent.getAction())) {
                    if (!intent.getBooleanExtra("isShowTicket", false)) {
                        SobotChatFragment.this.startToPostMsgActivty(false, false);
                        return;
                    }
                    int size2 = SobotChatFragment.this.messageList.size();
                    while (true) {
                        int i2 = size2 - 1;
                        if (i2 <= 0) {
                            break;
                        }
                        if (!TextUtils.isEmpty(((ZhiChiMessageBase) SobotChatFragment.this.messageList.get(i2)).getSenderType()) && Integer.parseInt(((ZhiChiMessageBase) SobotChatFragment.this.messageList.get(i2)).getSenderType()) == 24 && ((ZhiChiMessageBase) SobotChatFragment.this.messageList.get(i2)).getAnswer() != null && 9 == ((ZhiChiMessageBase) SobotChatFragment.this.messageList.get(i2)).getAnswer().getRemindType()) {
                            SobotChatFragment.this.messageList.remove(i2);
                            SobotChatFragment.this.messageAdapter.notifyDataSetChanged();
                            break;
                        }
                        size2 = i2;
                    }
                    Intent newPostMsgIntent = SobotChatFragment.this.mPostMsgPresenter.newPostMsgIntent(SobotChatFragment.this.initModel.getUid(), null);
                    newPostMsgIntent.putExtra("intent_key_companyid", SobotChatFragment.this.initModel.getCompanyId());
                    newPostMsgIntent.putExtra(StPostMsgPresenter.INTENT_KEY_CUSTOMERID, SobotChatFragment.this.initModel.getCustomerId());
                    newPostMsgIntent.putExtra(ZhiChiConstant.FLAG_EXIT_SDK, false);
                    newPostMsgIntent.putExtra(StPostMsgPresenter.INTENT_KEY_GROUPID, SobotChatFragment.this.info.getLeaveMsgGroupId());
                    newPostMsgIntent.putExtra(StPostMsgPresenter.INTENT_KEY_IS_SHOW_TICKET, true);
                    SobotChatFragment.this.startActivity(newPostMsgIntent);
                    if (SobotChatFragment.this.getSobotActivity() != null) {
                        SobotChatFragment.this.getSobotActivity().overridePendingTransition(ResourceUtils.getIdByName(SobotChatFragment.this.mAppContext, i.f, "sobot_push_left_in"), ResourceUtils.getIdByName(SobotChatFragment.this.mAppContext, i.f, "sobot_push_left_out"));
                    }
                } else if (ZhiChiConstants.sobot_click_cancle.equals(intent.getAction())) {
                    if (SobotChatFragment.this.type == 4 && SobotChatFragment.this.current_client_model == 301) {
                        SobotChatFragment.this.remindRobotMessage(SobotChatFragment.this.handler, SobotChatFragment.this.initModel, SobotChatFragment.this.info);
                    }
                } else if (ZhiChiConstants.chat_remind_to_customer.equals(intent.getAction())) {
                    SobotChatFragment.this.hidePanelAndKeyboard(SobotChatFragment.this.mPanelRoot);
                    SobotChatFragment.this.doEmoticonBtn2Blur();
                    SobotChatFragment.this.transfer2Custom(null, null, null, true, 10, "", "", "1");
                } else if (ZhiChiConstants.dcrc_comment_state.equals(intent.getAction())) {
                    SobotChatFragment.this.isComment = intent.getBooleanExtra("commentState", false);
                    boolean booleanExtra = intent.getBooleanExtra("isFinish", false);
                    boolean booleanExtra2 = intent.getBooleanExtra("isExitSession", false);
                    intent.getIntExtra("commentType", 1);
                    intent.getIntExtra(WBConstants.GAME_PARAMS_SCORE, 5);
                    intent.getIntExtra("isResolved", 0);
                    SobotChatFragment.this.messageAdapter.removeEvaluateData();
                    SobotChatFragment.this.messageAdapter.notifyDataSetChanged();
                    if (booleanExtra2 || ChatUtils.isEvaluationCompletedExit(SobotChatFragment.this.mAppContext, SobotChatFragment.this.isComment, SobotChatFragment.this.current_client_model)) {
                        SobotChatFragment.this.isSessionOver = true;
                        SobotChatFragment.this.customerServiceOffline(SobotChatFragment.this.initModel, 5);
                        ChatUtils.userLogout(SobotChatFragment.this.mAppContext);
                    }
                    if (SobotChatFragment.this.isActive()) {
                        ChatUtils.showThankDialog(SobotChatFragment.this.getSobotActivity(), SobotChatFragment.this.handler, booleanExtra);
                    }
                } else if (ZhiChiConstants.sobot_close_now.equals(intent.getAction())) {
                    if (intent.getBooleanExtra("isBackShowEvaluate", true)) {
                        SobotChatFragment.this.finish();
                        return;
                    }
                    SobotChatFragment.this.customerServiceOffline(SobotChatFragment.this.initModel, 1);
                    ChatUtils.userLogout(SobotChatFragment.this.mAppContext);
                    SobotChatFragment.this.finish();
                } else if (ZhiChiConstants.sobot_close_now_clear_cache.equals(intent.getAction())) {
                    SobotChatFragment.this.isSessionOver = true;
                    SobotChatFragment.this.finish();
                } else if (ZhiChiConstants.SOBOT_CHANNEL_STATUS_CHANGE.equals(intent.getAction())) {
                    if (SobotChatFragment.this.customerState != CustomerState.Online && SobotChatFragment.this.customerState != CustomerState.Queuing) {
                        SobotChatFragment.this.mTitleTextView.setVisibility(8);
                        SobotChatFragment.this.mAvatarIV.setVisibility(0);
                        SobotChatFragment.this.sobot_container_conn_status.setVisibility(8);
                        return;
                    }
                    int intExtra = intent.getIntExtra("connStatus", 1);
                    LogUtils.i("connStatus:" + intExtra);
                    if (intExtra == 0) {
                        SobotChatFragment.this.sobot_container_conn_status.setVisibility(0);
                        SobotChatFragment.this.sobot_title_conn_status.setText(SobotChatFragment.this.getResString("sobot_conntype_unconnected"));
                        if (SobotChatFragment.this.sobot_header_center_ll != null) {
                            SobotChatFragment.this.sobot_header_center_ll.setVisibility(8);
                        }
                        SobotChatFragment.this.sobot_conn_loading.setVisibility(8);
                        if (SobotChatFragment.this.welcome.getVisibility() != 0) {
                            SobotChatFragment.this.setShowNetRemind(true);
                        }
                    } else if (intExtra == 1) {
                        SobotChatFragment.this.sobot_container_conn_status.setVisibility(0);
                        SobotChatFragment.this.sobot_title_conn_status.setText(SobotChatFragment.this.getResString("sobot_conntype_in_connection"));
                        if (SobotChatFragment.this.sobot_header_center_ll != null) {
                            SobotChatFragment.this.sobot_header_center_ll.setVisibility(8);
                        }
                        SobotChatFragment.this.sobot_conn_loading.setVisibility(0);
                    } else if (intExtra == 2) {
                        SobotChatFragment.this.setShowNetRemind(false);
                        SobotChatFragment.this.sobot_container_conn_status.setVisibility(8);
                        SobotChatFragment.this.sobot_title_conn_status.setText("");
                        if (SobotChatFragment.this.sobot_header_center_ll != null) {
                            SobotChatFragment.this.sobot_header_center_ll.setVisibility(0);
                        }
                        SobotChatFragment.this.sobot_conn_loading.setVisibility(8);
                        SobotChatFragment.this.stopPolling();
                    }
                } else if (ZhiChiConstants.SOBOT_BROCAST_KEYWORD_CLICK.equals(intent.getAction())) {
                    SobotChatFragment.this.transfer2Custom(intent.getStringExtra("tempGroupId"), intent.getStringExtra("keyword"), intent.getStringExtra("keywordId"), true, 3);
                } else if (ZhiChiConstants.SOBOT_BROCAST_REMOVE_FILE_TASK.equals(intent.getAction())) {
                    String stringExtra5 = intent.getStringExtra("sobot_msgId");
                    if (TextUtils.isEmpty(stringExtra5)) {
                        return;
                    }
                    int size3 = SobotChatFragment.this.messageList.size();
                    while (true) {
                        int i3 = size3 - 1;
                        if (i3 < 0) {
                            break;
                        } else if (stringExtra5.equals(((ZhiChiMessageBase) SobotChatFragment.this.messageList.get(i3)).getId())) {
                            SobotChatFragment.this.messageList.remove(i3);
                            break;
                        } else {
                            size3 = i3;
                        }
                    }
                    SobotChatFragment.this.messageAdapter.notifyDataSetChanged();
                } else if (ZhiChiConstants.SOBOT_CHAT_MUITILEAVEMSG_TO_CHATLIST.equals(intent.getAction()) && intent != null && (sobotSerializableMap = (SobotSerializableMap) intent.getExtras().get("leaveMsgData")) != null) {
                    LinkedHashMap map = sobotSerializableMap.getMap();
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : map.entrySet()) {
                        sb.append((String) entry.getKey());
                        sb.append("\n");
                        sb.append((String) entry.getValue());
                        sb.append("\n");
                    }
                    if (TextUtils.isEmpty(sb.toString())) {
                        return;
                    }
                    SobotChatFragment.this.sendMuitidiaLeaveMsg(null, sb.toString().substring(0, sb.toString().lastIndexOf("\n")), SobotChatFragment.this.handler, true);
                }
            } catch (Exception e3) {
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/conversation/SobotChatFragment$MyMessageReceiver.class */
    public class MyMessageReceiver extends BroadcastReceiver {
        public MyMessageReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                if (CommonUtils.isNetWorkConnected(SobotChatFragment.this.mAppContext)) {
                    SobotChatFragment.this.setShowNetRemind(false);
                } else if (SobotChatFragment.this.welcome.getVisibility() != 0) {
                    SobotChatFragment.this.setShowNetRemind(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/conversation/SobotChatFragment$PressToSpeakListen.class */
    public class PressToSpeakListen implements View.OnTouchListener {
        PressToSpeakListen() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int i;
            SobotChatFragment.this.isCutVoice = false;
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                if (AudioTools.getInstance().isPlaying()) {
                    AudioTools.getInstance().stop();
                    SobotChatFragment.this.lv_message.post(new Runnable() { // from class: com.sobot.chat.conversation.SobotChatFragment.PressToSpeakListen.1
                        @Override // java.lang.Runnable
                        public void run() {
                            VoiceMessageHolder voiceMessageHolder;
                            if (SobotChatFragment.this.info == null) {
                                return;
                            }
                            int childCount = SobotChatFragment.this.lv_message.getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                View childAt = SobotChatFragment.this.lv_message.getChildAt(i2);
                                if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof VoiceMessageHolder) && (voiceMessageHolder = (VoiceMessageHolder) childAt.getTag()) != null) {
                                    voiceMessageHolder.stopAnim();
                                    voiceMessageHolder.checkBackground();
                                }
                            }
                        }
                    });
                }
                SobotChatFragment.this.abandonAudioFocus();
                SobotChatFragment.this.voiceMsgId = System.currentTimeMillis() + "";
                SobotChatFragment.this.btn_upload_view.setClickable(false);
                SobotChatFragment.this.btn_model_edit.setClickable(false);
                SobotChatFragment.this.btn_upload_view.setEnabled(false);
                SobotChatFragment.this.btn_model_edit.setEnabled(false);
                if (Build.VERSION.SDK_INT >= 11) {
                    SobotChatFragment.this.btn_upload_view.setAlpha(0.4f);
                    SobotChatFragment.this.btn_model_edit.setAlpha(0.4f);
                }
                SobotChatFragment.this.stopVoiceTimeTask();
                view.setPressed(true);
                SobotChatFragment.this.voice_time_long.setText("00''");
                SobotChatFragment.this.voiceTimeLongStr = "00:00";
                SobotChatFragment.this.voiceTimerLong = 0;
                SobotChatFragment.this.currentVoiceLong = 0;
                SobotChatFragment.this.recording_container.setVisibility(0);
                SobotChatFragment.this.voice_top_image.setVisibility(0);
                SobotChatFragment.this.mic_image.setVisibility(0);
                SobotChatFragment.this.mic_image_animate.setVisibility(0);
                SobotChatFragment.this.voice_time_long.setVisibility(0);
                SobotChatFragment.this.recording_timeshort.setVisibility(8);
                SobotChatFragment.this.image_endVoice.setVisibility(8);
                SobotChatFragment.this.txt_speak_content.setText(SobotChatFragment.this.getResString("sobot_up_send"));
                SobotChatFragment.this.startVoice();
                return true;
            } else if (action != 1) {
                if (action != 2) {
                    if (action == 5 || action == 6) {
                        return true;
                    }
                    SobotChatFragment sobotChatFragment = SobotChatFragment.this;
                    sobotChatFragment.sendVoiceMap(2, sobotChatFragment.voiceMsgId);
                    SobotChatFragment.this.closeVoiceWindows(2);
                    return true;
                }
                if (!SobotChatFragment.this.is_startCustomTimerTask) {
                    SobotChatFragment.this.noReplyTimeUserInfo = 0;
                }
                if (motionEvent.getY() < 10.0f) {
                    SobotChatFragment.this.voice_top_image.setVisibility(8);
                    SobotChatFragment.this.image_endVoice.setVisibility(0);
                    SobotChatFragment.this.mic_image.setVisibility(8);
                    SobotChatFragment.this.mic_image_animate.setVisibility(8);
                    SobotChatFragment.this.recording_timeshort.setVisibility(8);
                    SobotChatFragment.this.txt_speak_content.setText(SobotChatFragment.this.getResString("sobot_release_to_cancel"));
                    SobotChatFragment.this.recording_hint.setText(SobotChatFragment.this.getResString("sobot_release_to_cancel"));
                    SobotChatFragment.this.recording_hint.setBackgroundResource(SobotChatFragment.this.getResDrawableId("sobot_recording_text_hint_bg"));
                    return true;
                } else if (SobotChatFragment.this.voiceTimerLong != 0) {
                    SobotChatFragment.this.txt_speak_content.setText(SobotChatFragment.this.getResString("sobot_up_send"));
                    SobotChatFragment.this.voice_top_image.setVisibility(0);
                    SobotChatFragment.this.mic_image_animate.setVisibility(0);
                    SobotChatFragment.this.image_endVoice.setVisibility(8);
                    SobotChatFragment.this.mic_image.setVisibility(0);
                    SobotChatFragment.this.recording_timeshort.setVisibility(8);
                    SobotChatFragment.this.recording_hint.setText(SobotChatFragment.this.getResString("sobot_move_up_to_cancel"));
                    SobotChatFragment.this.recording_hint.setBackgroundResource(SobotChatFragment.this.getResDrawableId("sobot_recording_text_hint_bg1"));
                    return true;
                } else {
                    return true;
                }
            } else {
                SobotChatFragment.this.btn_upload_view.setClickable(true);
                SobotChatFragment.this.btn_model_edit.setClickable(true);
                SobotChatFragment.this.btn_upload_view.setEnabled(true);
                SobotChatFragment.this.btn_model_edit.setEnabled(true);
                if (Build.VERSION.SDK_INT >= 11) {
                    SobotChatFragment.this.btn_upload_view.setAlpha(1.0f);
                    SobotChatFragment.this.btn_model_edit.setAlpha(1.0f);
                }
                view.setPressed(false);
                SobotChatFragment.this.txt_speak_content.setText(SobotChatFragment.this.getResString("sobot_press_say"));
                SobotChatFragment.this.stopVoiceTimeTask();
                SobotChatFragment.this.stopVoice();
                if (SobotChatFragment.this.recording_container.getVisibility() != 0 || SobotChatFragment.this.isCutVoice) {
                    SobotChatFragment sobotChatFragment2 = SobotChatFragment.this;
                    sobotChatFragment2.sendVoiceMap(2, sobotChatFragment2.voiceMsgId);
                } else {
                    SobotChatFragment sobotChatFragment3 = SobotChatFragment.this;
                    sobotChatFragment3.hidePanelAndKeyboard(sobotChatFragment3.mPanelRoot);
                    if (SobotChatFragment.this.animationDrawable != null) {
                        SobotChatFragment.this.animationDrawable.stop();
                    }
                    SobotChatFragment.this.voice_time_long.setText("00''");
                    SobotChatFragment.this.voice_time_long.setVisibility(4);
                    if (motionEvent.getY() < 0.0f) {
                        SobotChatFragment.this.recording_container.setVisibility(8);
                        SobotChatFragment sobotChatFragment4 = SobotChatFragment.this;
                        sobotChatFragment4.sendVoiceMap(2, sobotChatFragment4.voiceMsgId);
                        return true;
                    }
                    if (SobotChatFragment.this.currentVoiceLong < 1000) {
                        SobotChatFragment.this.voice_top_image.setVisibility(0);
                        SobotChatFragment.this.recording_hint.setText(SobotChatFragment.this.getResString("sobot_voice_time_short"));
                        SobotChatFragment.this.recording_hint.setBackgroundResource(SobotChatFragment.this.getResDrawableId("sobot_recording_text_hint_bg"));
                        SobotChatFragment.this.recording_timeshort.setVisibility(0);
                        SobotChatFragment.this.voice_time_long.setVisibility(0);
                        SobotChatFragment.this.voice_time_long.setText("00:00");
                        SobotChatFragment.this.mic_image.setVisibility(8);
                        SobotChatFragment.this.mic_image_animate.setVisibility(8);
                        SobotChatFragment sobotChatFragment5 = SobotChatFragment.this;
                        sobotChatFragment5.sendVoiceMap(2, sobotChatFragment5.voiceMsgId);
                    } else if (SobotChatFragment.this.currentVoiceLong < SobotChatFragment.this.minRecordTime * 1000) {
                        SobotChatFragment.this.recording_container.setVisibility(8);
                        SobotChatFragment sobotChatFragment6 = SobotChatFragment.this;
                        sobotChatFragment6.sendVoiceMap(1, sobotChatFragment6.voiceMsgId);
                        return true;
                    } else if (SobotChatFragment.this.currentVoiceLong > SobotChatFragment.this.minRecordTime * 1000) {
                        SobotChatFragment.this.voice_top_image.setVisibility(0);
                        SobotChatFragment.this.recording_hint.setText(SobotChatFragment.this.getResString("sobot_voiceTooLong"));
                        SobotChatFragment.this.recording_hint.setBackgroundResource(SobotChatFragment.this.getResDrawableId("sobot_recording_text_hint_bg"));
                        SobotChatFragment.this.recording_timeshort.setVisibility(0);
                        SobotChatFragment.this.mic_image.setVisibility(8);
                        SobotChatFragment.this.mic_image_animate.setVisibility(8);
                        i = 1;
                        SobotChatFragment.this.currentVoiceLong = 0;
                        SobotChatFragment.this.closeVoiceWindows(i);
                    } else {
                        SobotChatFragment sobotChatFragment7 = SobotChatFragment.this;
                        sobotChatFragment7.sendVoiceMap(2, sobotChatFragment7.voiceMsgId);
                    }
                    i = 0;
                    SobotChatFragment.this.currentVoiceLong = 0;
                    SobotChatFragment.this.closeVoiceWindows(i);
                }
                SobotChatFragment.this.voiceTimerLong = 0;
                SobotChatFragment sobotChatFragment8 = SobotChatFragment.this;
                sobotChatFragment8.restartMyTimeTask(sobotChatFragment8.handler);
                return true;
            }
        }
    }

    static /* synthetic */ int access$7408(SobotChatFragment sobotChatFragment) {
        int i = sobotChatFragment.currentCidPosition;
        sobotChatFragment.currentCidPosition = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addKeyWordTipMsg(SobotKeyWordTransfer sobotKeyWordTransfer) {
        if (TextUtils.isEmpty(sobotKeyWordTransfer.getTransferTips())) {
            return;
        }
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
        zhiChiMessageBase.setId(System.currentTimeMillis() + "");
        zhiChiMessageBase.setSenderType("24");
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        zhiChiReplyAnswer.setRemindType(9);
        zhiChiReplyAnswer.setMsg(sobotKeyWordTransfer.getTransferTips());
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        this.messageAdapter.justAddData(zhiChiMessageBase);
    }

    private void applyUIConfig() {
        if (-1 != SobotUIConfig.sobot_serviceImgId) {
            this.btn_set_mode_rengong.setBackgroundResource(SobotUIConfig.sobot_serviceImgId);
        }
        if (-1 != SobotUIConfig.sobot_chat_bottom_bgColor) {
            this.sobot_ll_bottom.setBackgroundColor(getContext().getResources().getColor(SobotUIConfig.sobot_chat_bottom_bgColor));
        }
        if (-1 != SobotUIConfig.sobot_apicloud_titleBgColor) {
            this.relative.setBackgroundColor(SobotUIConfig.sobot_apicloud_titleBgColor);
        }
        if (-1 != SobotUIConfig.sobot_titleBgColor) {
            this.relative.setBackgroundColor(getContext().getResources().getColor(SobotUIConfig.sobot_titleBgColor));
        }
        if (SobotUIConfig.sobot_title_right_menu2_display) {
            this.sobot_tv_right_second.setVisibility(0);
            if (-1 != SobotUIConfig.sobot_title_right_menu2_bg) {
                Drawable drawable = getResources().getDrawable(SobotUIConfig.sobot_title_right_menu2_bg);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.sobot_tv_right_second.setCompoundDrawables(null, null, drawable, null);
            }
        }
        if (SobotUIConfig.sobot_title_right_menu3_display) {
            this.sobot_tv_right_third.setVisibility(0);
            if (-1 != SobotUIConfig.sobot_title_right_menu3_bg) {
                Drawable drawable2 = getResources().getDrawable(SobotUIConfig.sobot_title_right_menu3_bg);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                this.sobot_tv_right_third.setCompoundDrawables(null, null, drawable2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connCustomerServiceBlack(boolean z) {
        showLogicTitle(this.initModel.getRobotName(), this.initModel.getRobotLogo(), false);
        showSwitchRobotBtn();
        if (z) {
            showCustomerUanbleTip();
        }
        if (this.type == 4) {
            remindRobotMessage(this.handler, this.initModel, this.info);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connCustomerServiceFail(boolean z) {
        if (this.type == 2) {
            showLeaveMsg();
        } else {
            showLogicTitle(this.initModel.getRobotName(), this.initModel.getRobotLogo(), false);
            showSwitchRobotBtn();
            if (z) {
                showCustomerOfflineTip();
            }
            if (this.type == 4 && this.current_client_model == 301) {
                remindRobotMessage(this.handler, this.initModel, this.info);
            }
        }
        gotoLastItem();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connCustomerServiceSuccess(ZhiChiMessageBase zhiChiMessageBase) {
        if (zhiChiMessageBase == null || this.initModel == null) {
            return;
        }
        this.initModel.setAdminHelloWord(!TextUtils.isEmpty(zhiChiMessageBase.getAdminHelloWord()) ? zhiChiMessageBase.getAdminHelloWord() : this.initModel.getAdminHelloWord());
        this.initModel.setAdminTipTime(!TextUtils.isEmpty(zhiChiMessageBase.getServiceOutTime()) ? zhiChiMessageBase.getServiceOutTime() : this.initModel.getAdminTipTime());
        this.initModel.setAdminTipWord(!TextUtils.isEmpty(zhiChiMessageBase.getServiceOutDoc()) ? zhiChiMessageBase.getServiceOutDoc() : this.initModel.getAdminTipWord());
        this.zhiChiApi.connChannel(zhiChiMessageBase.getWslinkBak(), zhiChiMessageBase.getWslinkDefault(), this.initModel.getPartnerid(), zhiChiMessageBase.getPuid(), this.info.getApp_key(), zhiChiMessageBase.getWayHttp());
        createCustomerService(zhiChiMessageBase.getAname(), zhiChiMessageBase.getAface());
    }

    private void createConsultingContent(int i) {
        ConsultingContent consultingContent = this.info.getConsultingContent();
        if (consultingContent == null || TextUtils.isEmpty(consultingContent.getSobotGoodsTitle()) || TextUtils.isEmpty(consultingContent.getSobotGoodsFromUrl())) {
            if (this.messageAdapter != null) {
                this.messageAdapter.removeConsulting();
                return;
            }
            return;
        }
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        zhiChiMessageBase.setSenderType("26");
        if (!TextUtils.isEmpty(consultingContent.getSobotGoodsImgUrl())) {
            zhiChiMessageBase.setPicurl(consultingContent.getSobotGoodsImgUrl());
        }
        zhiChiMessageBase.setAnswer(new ZhiChiReplyAnswer());
        zhiChiMessageBase.setContent(consultingContent.getSobotGoodsTitle());
        zhiChiMessageBase.setUrl(consultingContent.getSobotGoodsFromUrl());
        zhiChiMessageBase.setCid(this.initModel == null ? "" : this.initModel.getCid());
        zhiChiMessageBase.setAname(consultingContent.getSobotGoodsLable());
        zhiChiMessageBase.setReceiverFace(consultingContent.getSobotGoodsDescribe());
        zhiChiMessageBase.setAction(ZhiChiConstant.action_consultingContent_info);
        updateUiMessage(this.messageAdapter, zhiChiMessageBase);
        this.handler.post(new Runnable() { // from class: com.sobot.chat.conversation.SobotChatFragment.33
            @Override // java.lang.Runnable
            public void run() {
                SobotChatFragment.this.lv_message.setSelection(SobotChatFragment.this.messageAdapter.getCount());
            }
        });
        if (consultingContent.isAutoSend()) {
            if (i != 1) {
                sendConsultingContent();
            } else if (consultingContent.isEveryTimeAutoSend()) {
                sendConsultingContent();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createCustomerQueue(String str, int i, String str2, boolean z) {
        if (this.customerState != CustomerState.Queuing || TextUtils.isEmpty(str) || Integer.parseInt(str) <= 0) {
            return;
        }
        stopUserInfoTimeTask();
        stopCustomTimeTask();
        stopInputListener();
        this.queueNum = Integer.parseInt(str);
        if (i != 7 && z) {
            showInLineHint(str2);
        }
        if (this.type == 2) {
            showLogicTitle(getResString("sobot_in_line"), null, false);
            setBottomView(3);
            this.mBottomViewtype = 3;
        } else {
            showLogicTitle(this.initModel.getRobotName(), this.initModel.getRobotLogo(), false);
            setBottomView(5);
            this.mBottomViewtype = 5;
        }
        int i2 = this.queueTimes + 1;
        this.queueTimes = i2;
        if (this.type == 4 && i2 == 1) {
            remindRobotMessage(this.handler, this.initModel, this.info);
        }
        showSwitchRobotBtn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createCustomerService(String str, String str2) {
        this.current_client_model = 302;
        if (SobotOption.sobotChatStatusListener != null) {
            SobotOption.sobotChatStatusListener.onChatStatusListener(SobotChatStatusMode.ZCServerConnectArtificial);
        }
        this.customerState = CustomerState.Online;
        this.isAboveZero = false;
        this.isComment = false;
        this.queueNum = 0;
        this.currentUserName = TextUtils.isEmpty(str) ? "" : str;
        this.messageAdapter.addData(ChatUtils.getServiceAcceptTip(this.mAppContext, str));
        this.messageAdapter.removeKeyWordTranferItem();
        if (this.initModel.isAdminHelloWordFlag() && (!this.initModel.isAdminHelloWordCountRule() || this.initModel.getUstatus() != 1)) {
            String admin_hello_word = ZCSobotApi.getCurrentInfoSetting(this.mAppContext) != null ? ZCSobotApi.getCurrentInfoSetting(this.mAppContext).getAdmin_hello_word() : "";
            if (TextUtils.isEmpty(admin_hello_word)) {
                this.messageAdapter.addData(ChatUtils.getServiceHelloTip(str, str2, this.initModel.getAdminHelloWord()));
            } else {
                this.messageAdapter.addData(ChatUtils.getServiceHelloTip(str, str2, admin_hello_word));
            }
        }
        this.messageAdapter.notifyDataSetChanged();
        showLogicTitle(str, str2, false);
        Message obtainMessage = this.handler.obtainMessage();
        obtainMessage.what = 1001;
        this.handler.sendMessage(obtainMessage);
        showSwitchRobotBtn();
        createConsultingContent(0);
        createOrderCardContent(0);
        gotoLastItem();
        setBottomView(2);
        this.mBottomViewtype = 2;
        restartInputListener();
        stopUserInfoTimeTask();
        this.is_startCustomTimerTask = false;
        startUserInfoTimeTask(this.handler);
        hideItemTransferBtn();
        this.et_sendmessage.setAutoCompleteEnable(false);
        if (this.info.getAutoSendMsgMode().getAuto_send_msgtype() == SobotAutoSendMsgMode.ZCMessageTypeText) {
            processAutoSendMsg(this.info);
        } else if (this.info.getAutoSendMsgMode() != null && this.info.getAutoSendMsgMode() != SobotAutoSendMsgMode.Default && this.current_client_model == 302 && !TextUtils.isEmpty(this.info.getAutoSendMsgMode().getContent()) && this.info.getAutoSendMsgMode() == SobotAutoSendMsgMode.SendToOperator && this.customerState == CustomerState.Online) {
            String content = this.info.getAutoSendMsgMode().getContent();
            if (this.info.getAutoSendMsgMode().getAuto_send_msgtype() == SobotAutoSendMsgMode.ZCMessageTypeFile) {
                File file = new File(content);
                if (file.exists()) {
                    uploadFile(file, this.handler, this.lv_message, this.messageAdapter, false);
                }
            } else if (this.info.getAutoSendMsgMode().getAuto_send_msgtype() == SobotAutoSendMsgMode.ZCMessageTypeVideo) {
                File file2 = new File(content);
                if (file2.exists()) {
                    uploadVideo(file2, null, this.messageAdapter);
                }
            } else if (this.info.getAutoSendMsgMode().getAuto_send_msgtype() == SobotAutoSendMsgMode.ZCMessageTypePhoto) {
                File file3 = new File(content);
                if (file3.exists()) {
                    uploadFile(file3, this.handler, this.lv_message, this.messageAdapter, false);
                }
            }
        }
        if (!this.isRemindTicketInfo) {
            processNewTicketMsg(this.handler);
        }
        if (!TextUtils.isEmpty(this.tempMsgContent)) {
            sendMsg(this.tempMsgContent);
            this.tempMsgContent = "";
        }
        if (CommonUtils.isServiceWork(getSobotActivity(), "com.sobot.chat.core.channel.SobotTCPServer")) {
            return;
        }
        LogUtils.i2Local("转人工成功后 开启轮询", "tcpserver 没运行，直接走fragment 界面的轮询");
        SobotMsgManager.getInstance(getSobotActivity()).getZhiChiApi().disconnChannel();
        pollingMsgForOne();
        startPolling();
    }

    private void createOrderCardContent(int i) {
        OrderCardContentModel orderGoodsInfo = this.info.getOrderGoodsInfo();
        if (orderGoodsInfo == null || TextUtils.isEmpty(orderGoodsInfo.getOrderCode()) || !orderGoodsInfo.isAutoSend()) {
            return;
        }
        if (i != 1) {
            sendOrderCardMsg(orderGoodsInfo);
        } else if (orderGoodsInfo.isEveryTimeAutoSend()) {
            sendOrderCardMsg(orderGoodsInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void customerInit(int i) {
        LogUtils.i("customerInit初始化接口");
        if (this.info.getService_mode() == 1) {
            ChatUtils.userLogout(this.mAppContext);
        }
        if (!this.isAppInitEnd) {
            LogUtils.i("初始化接口appinit 接口还没结束，结束前不能重复调用");
            return;
        }
        this.isAppInitEnd = false;
        if (this.info != null) {
            this.info.setIsFirstEntry(i);
        }
        String stringData = SharedPreferencesUtil.getStringData(getSobotActivity(), ZhiChiConstant.SOBOT_ROBOT_HELLO_WORD, "");
        String stringData2 = SharedPreferencesUtil.getStringData(getSobotActivity(), ZhiChiConstant.SOBOT_USER_OUT_WORD, "");
        String stringData3 = SharedPreferencesUtil.getStringData(getSobotActivity(), ZhiChiConstant.SOBOT_USER_TIP_WORD, "");
        String stringData4 = SharedPreferencesUtil.getStringData(getSobotActivity(), ZhiChiConstant.SOBOT_ADMIN_HELLO_WORD, "");
        String stringData5 = SharedPreferencesUtil.getStringData(getSobotActivity(), ZhiChiConstant.SOBOT_ADMIN_OFFLINE_TITLE, "");
        String stringData6 = SharedPreferencesUtil.getStringData(getSobotActivity(), ZhiChiConstant.SOBOT_ADMIN_TIP_WORD, "");
        if (this.info != null) {
            if (TextUtils.isEmpty(this.info.getRobot_hello_word()) && !TextUtils.isEmpty(stringData)) {
                this.info.setRobot_Hello_Word(stringData);
            }
            if (TextUtils.isEmpty(this.info.getUser_out_word()) && !TextUtils.isEmpty(stringData2)) {
                this.info.setUser_Out_Word(stringData2);
            }
            if (TextUtils.isEmpty(this.info.getUser_tip_word()) && !TextUtils.isEmpty(stringData3)) {
                this.info.setUser_Tip_Word(stringData3);
            }
            if (TextUtils.isEmpty(this.info.getAdmin_hello_word()) && !TextUtils.isEmpty(stringData4)) {
                this.info.setAdmin_Hello_Word(stringData4);
            }
            if (TextUtils.isEmpty(this.info.getAdmin_offline_title()) && !TextUtils.isEmpty(stringData5)) {
                this.info.setAdmin_Offline_Title(stringData5);
            }
            if (TextUtils.isEmpty(this.info.getAdmin_tip_word()) && !TextUtils.isEmpty(stringData6)) {
                this.info.setAdmin_Tip_Word(stringData6);
            }
        }
        this.zhiChiApi.sobotInit(this, this.info, new StringResultCallBack<ZhiChiInitModeBase>() { // from class: com.sobot.chat.conversation.SobotChatFragment.21
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                SobotChatFragment.this.isAppInitEnd = true;
                SharedPreferencesUtil.saveObject(SobotChatFragment.this.mAppContext, ZhiChiConstant.sobot_last_current_info, SobotChatFragment.this.info);
                if (SobotChatFragment.this.isActive()) {
                    if (!(exc instanceof IllegalArgumentException) || TextUtils.isEmpty(str)) {
                        SobotChatFragment.this.showInitError();
                    } else {
                        ToastUtil.showToast(SobotChatFragment.this.mAppContext, str);
                        SobotChatFragment.this.finish();
                    }
                    SobotChatFragment.this.isSessionOver = true;
                }
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(ZhiChiInitModeBase zhiChiInitModeBase) {
                SobotChatFragment.this.isAppInitEnd = true;
                if (SobotChatFragment.this.isActive()) {
                    SharedPreferencesUtil.saveStringData(SobotChatFragment.this.getSobotActivity(), ZhiChiConstant.sobot_connect_group_id, "");
                    SharedPreferencesUtil.saveLongData(SobotChatFragment.this.getSobotActivity(), ZhiChiConstant.SOBOT_FINISH_CURTIME, 0L);
                    SobotChatFragment.this.initModel = zhiChiInitModeBase;
                    SobotChatFragment.this.processPlatformAppId();
                    SobotChatFragment.this.getAnnouncement();
                    if (SobotChatFragment.this.info.getService_mode() > 0) {
                        ZhiChiInitModeBase zhiChiInitModeBase2 = SobotChatFragment.this.initModel;
                        zhiChiInitModeBase2.setType(SobotChatFragment.this.info.getService_mode() + "");
                    }
                    SobotChatFragment sobotChatFragment = SobotChatFragment.this;
                    sobotChatFragment.type = Integer.parseInt(sobotChatFragment.initModel.getType());
                    Context context = SobotChatFragment.this.mAppContext;
                    SharedPreferencesUtil.saveIntData(context, SobotChatFragment.this.info.getApp_key() + "_" + ZhiChiConstant.initType, SobotChatFragment.this.type);
                    SobotChatFragment.this.queryCids();
                    SobotChatFragment.this.sobotCustomMenu();
                    SobotChatFragment.this.showRobotLayout();
                    if (!TextUtils.isEmpty(SobotChatFragment.this.initModel.getPartnerid())) {
                        SharedPreferencesUtil.saveStringData(SobotChatFragment.this.mAppContext, Const.SOBOT_UID, SobotChatFragment.this.initModel.getPartnerid());
                    }
                    if (!TextUtils.isEmpty(SobotChatFragment.this.initModel.getCid())) {
                        SharedPreferencesUtil.saveStringData(SobotChatFragment.this.mAppContext, Const.SOBOT_CID, SobotChatFragment.this.initModel.getCid());
                    }
                    SharedPreferencesUtil.saveIntData(SobotChatFragment.this.mAppContext, ZhiChiConstant.sobot_msg_flag, SobotChatFragment.this.initModel.getMsgFlag());
                    SharedPreferencesUtil.saveBooleanData(SobotChatFragment.this.mAppContext, ZhiChiConstant.sobot_leave_msg_flag, SobotChatFragment.this.initModel.isMsgToTicketFlag());
                    SharedPreferencesUtil.saveStringData(SobotChatFragment.this.mAppContext, "lastCid", SobotChatFragment.this.initModel.getCid());
                    Context context2 = SobotChatFragment.this.mAppContext;
                    SharedPreferencesUtil.saveStringData(context2, SobotChatFragment.this.info.getApp_key() + "_" + ZhiChiConstant.sobot_last_current_partnerId, SobotChatFragment.this.info.getPartnerid());
                    SharedPreferencesUtil.saveOnlyStringData(SobotChatFragment.this.mAppContext, ZhiChiConstant.sobot_last_current_appkey, SobotChatFragment.this.info.getApp_key());
                    SharedPreferencesUtil.saveObject(SobotChatFragment.this.mAppContext, ZhiChiConstant.sobot_last_current_info, SobotChatFragment.this.info);
                    SharedPreferencesUtil.saveObject(SobotChatFragment.this.mAppContext, ZhiChiConstant.sobot_last_current_initModel, SobotChatFragment.this.initModel);
                    Context context3 = SobotChatFragment.this.mAppContext;
                    SharedPreferencesUtil.saveStringData(context3, SobotChatFragment.this.info.getApp_key() + "_" + ZhiChiConstant.SOBOT_RECEPTIONISTID, TextUtils.isEmpty(SobotChatFragment.this.info.getChoose_adminid()) ? "" : SobotChatFragment.this.info.getChoose_adminid());
                    Context context4 = SobotChatFragment.this.mAppContext;
                    SharedPreferencesUtil.saveStringData(context4, SobotChatFragment.this.info.getApp_key() + "_" + ZhiChiConstant.SOBOT_ROBOT_CODE, TextUtils.isEmpty(SobotChatFragment.this.info.getRobotCode()) ? "" : SobotChatFragment.this.info.getRobotCode());
                    Context context5 = SobotChatFragment.this.mAppContext;
                    SharedPreferencesUtil.saveStringData(context5, SobotChatFragment.this.info.getApp_key() + "_" + ZhiChiConstant.sobot_last_current_remark, TextUtils.isEmpty(SobotChatFragment.this.info.getRemark()) ? "" : SobotChatFragment.this.info.getRemark());
                    Context context6 = SobotChatFragment.this.mAppContext;
                    SharedPreferencesUtil.saveStringData(context6, SobotChatFragment.this.info.getApp_key() + "_" + ZhiChiConstant.sobot_last_current_groupid, TextUtils.isEmpty(SobotChatFragment.this.info.getGroupid()) ? "" : SobotChatFragment.this.info.getGroupid());
                    Context context7 = SobotChatFragment.this.mAppContext;
                    SharedPreferencesUtil.saveIntData(context7, SobotChatFragment.this.info.getApp_key() + "_" + ZhiChiConstant.sobot_last_current_service_mode, SobotChatFragment.this.info.getService_mode());
                    Context context8 = SobotChatFragment.this.mAppContext;
                    SharedPreferencesUtil.saveStringData(context8, SobotChatFragment.this.info.getApp_key() + "_" + ZhiChiConstant.sobot_last_current_customer_fields, TextUtils.isEmpty(SobotChatFragment.this.info.getCustomer_fields()) ? "" : SobotChatFragment.this.info.getCustomer_fields());
                    Context context9 = SobotChatFragment.this.mAppContext;
                    SharedPreferencesUtil.saveStringData(context9, SobotChatFragment.this.info.getApp_key() + "_" + ZhiChiConstant.sobot_last_current_isvip, TextUtils.isEmpty(SobotChatFragment.this.info.getIsVip()) ? "" : SobotChatFragment.this.info.getIsVip());
                    Context context10 = SobotChatFragment.this.mAppContext;
                    SharedPreferencesUtil.saveStringData(context10, SobotChatFragment.this.info.getApp_key() + "_" + ZhiChiConstant.sobot_last_current_vip_level, TextUtils.isEmpty(SobotChatFragment.this.info.getVip_level()) ? "" : SobotChatFragment.this.info.getVip_level());
                    Context context11 = SobotChatFragment.this.mAppContext;
                    SharedPreferencesUtil.saveStringData(context11, SobotChatFragment.this.info.getApp_key() + "_" + ZhiChiConstant.sobot_last_current_user_label, TextUtils.isEmpty(SobotChatFragment.this.info.getUser_label()) ? "" : SobotChatFragment.this.info.getUser_label());
                    Context context12 = SobotChatFragment.this.mAppContext;
                    SharedPreferencesUtil.saveStringData(context12, SobotChatFragment.this.info.getApp_key() + "_" + ZhiChiConstant.sobot_last_current_robot_alias, TextUtils.isEmpty(SobotChatFragment.this.info.getRobot_alias()) ? "" : SobotChatFragment.this.info.getRobot_alias());
                    if (SobotChatFragment.this.initModel.getAnnounceMsgFlag() && !SobotChatFragment.this.initModel.isAnnounceTopFlag() && !TextUtils.isEmpty(SobotChatFragment.this.initModel.getAnnounceMsg())) {
                        SobotChatFragment.this.messageAdapter.justAddData(ChatUtils.getNoticeModel(SobotChatFragment.this.getContext(), SobotChatFragment.this.initModel));
                        SobotChatFragment.this.messageAdapter.notifyDataSetChanged();
                    }
                    if (SobotChatFragment.this.initModel.getOfflineMsgConnectFlag() == 1 && !TextUtils.isEmpty(SobotChatFragment.this.initModel.getOfflineMsgAdminId()) && !b.l.equals(SobotChatFragment.this.initModel.getOfflineMsgAdminId())) {
                        SobotChatFragment sobotChatFragment2 = SobotChatFragment.this;
                        sobotChatFragment2.offlineMsgConnectFlag = sobotChatFragment2.initModel.getOfflineMsgConnectFlag();
                        SobotChatFragment sobotChatFragment3 = SobotChatFragment.this;
                        sobotChatFragment3.offlineMsgAdminId = sobotChatFragment3.initModel.getOfflineMsgAdminId();
                        new SobotConnCusParam();
                        SobotChatFragment.this.connectCustomerService(null, false);
                        return;
                    }
                    if (SobotChatFragment.this.type == 1) {
                        SobotChatFragment sobotChatFragment4 = SobotChatFragment.this;
                        sobotChatFragment4.remindRobotMessage(sobotChatFragment4.handler, SobotChatFragment.this.initModel, SobotChatFragment.this.info);
                        SobotChatFragment.this.showSwitchRobotBtn();
                        if (SobotOption.sobotChatStatusListener != null) {
                            SobotOption.sobotChatStatusListener.onChatStatusListener(SobotChatStatusMode.ZCServerConnectRobot);
                        }
                    } else if (SobotChatFragment.this.type == 3) {
                        if (SobotChatFragment.this.initModel.getUstatus() == 1 || SobotChatFragment.this.initModel.getUstatus() == -2) {
                            if (SobotChatFragment.this.initModel.getUstatus() == -2) {
                                SobotChatFragment sobotChatFragment5 = SobotChatFragment.this;
                                sobotChatFragment5.remindRobotMessage(sobotChatFragment5.handler, SobotChatFragment.this.initModel, SobotChatFragment.this.info);
                            }
                            SobotChatFragment.this.connectCustomerService(null);
                        } else {
                            SobotChatFragment sobotChatFragment6 = SobotChatFragment.this;
                            sobotChatFragment6.remindRobotMessage(sobotChatFragment6.handler, SobotChatFragment.this.initModel, SobotChatFragment.this.info);
                            SobotChatFragment.this.showSwitchRobotBtn();
                            if (SobotOption.sobotChatStatusListener != null) {
                                SobotOption.sobotChatStatusListener.onChatStatusListener(SobotChatStatusMode.ZCServerConnectRobot);
                            }
                        }
                    } else if (SobotChatFragment.this.type == 2) {
                        if (SobotChatFragment.this.isUserBlack()) {
                            SobotChatFragment.this.showLeaveMsg();
                        } else if (SobotChatFragment.this.initModel.getInvalidSessionFlag() == 1) {
                            String admin_hello_word = ZCSobotApi.getCurrentInfoSetting(SobotChatFragment.this.mAppContext) != null ? ZCSobotApi.getCurrentInfoSetting(SobotChatFragment.this.mAppContext).getAdmin_hello_word() : "";
                            if (TextUtils.isEmpty(admin_hello_word)) {
                                SobotChatFragment.this.messageAdapter.addData(ChatUtils.getServiceHelloTip("", "", SobotChatFragment.this.initModel.getAdminHelloWord()));
                            } else {
                                SobotChatFragment.this.messageAdapter.addData(ChatUtils.getServiceHelloTip("", "", admin_hello_word));
                            }
                            SobotChatFragment.this.setBottomView(0);
                            SobotChatFragment.this.btn_set_mode_rengong.setVisibility(8);
                            SobotChatFragment.this.btn_model_edit.setVisibility(8);
                            SobotChatFragment.this.btn_model_voice.setVisibility(8);
                            SobotChatFragment.this.btn_emoticon_view.setVisibility(0);
                            SobotChatFragment sobotChatFragment7 = SobotChatFragment.this;
                            sobotChatFragment7.setAvatar(sobotChatFragment7.getResDrawableId("sobot_def_admin"), true);
                            SobotChatFragment.this.setTitle("", false);
                        } else {
                            SobotChatFragment.this.transfer2Custom((String) null, (String) null, (String) null, true, "1");
                        }
                    } else if (SobotChatFragment.this.type == 4) {
                        if (SobotChatFragment.this.initModel.getInvalidSessionFlag() == 1) {
                            String robot_hello_word = ZCSobotApi.getCurrentInfoSetting(SobotChatFragment.this.mAppContext) != null ? ZCSobotApi.getCurrentInfoSetting(SobotChatFragment.this.mAppContext).getRobot_hello_word() : "";
                            if (TextUtils.isEmpty(robot_hello_word)) {
                                SobotChatFragment.this.messageAdapter.addData(ChatUtils.getServiceHelloTip("", "", SobotChatFragment.this.initModel.getRobotHelloWord()));
                            } else {
                                SobotChatFragment.this.messageAdapter.addData(ChatUtils.getServiceHelloTip("", "", robot_hello_word));
                            }
                            if (SobotChatFragment.this.info.getAutoSendMsgMode() != null && SobotChatFragment.this.info.getAutoSendMsgMode() != SobotAutoSendMsgMode.Default) {
                                SobotChatFragment.this.doClickTransferBtn();
                            }
                        } else {
                            SobotChatFragment.this.showSwitchRobotBtn();
                            SobotChatFragment.this.transfer2Custom((String) null, (String) null, (String) null, true, "1");
                        }
                    }
                    SobotChatFragment.this.isSessionOver = false;
                    if (SobotChatFragment.this.sobot_tv_close != null) {
                        if (SobotChatFragment.this.info.isShowCloseBtn() && SobotChatFragment.this.current_client_model == 302) {
                            SobotChatFragment.this.sobot_tv_close.setVisibility(0);
                        } else {
                            SobotChatFragment.this.sobot_tv_close.setVisibility(8);
                        }
                    }
                }
            }
        });
    }

    private void doKeepsessionInit(int i) {
        List<ZhiChiMessageBase> messageList = SobotMsgManager.getInstance(this.mAppContext).getConfig(this.info.getApp_key()).getMessageList();
        if (messageList == null || SobotMsgManager.getInstance(this.mAppContext).getConfig(this.info.getApp_key()).getInitModel() == null) {
            resetUser(i);
            return;
        }
        Context context = this.mAppContext;
        int intData = SharedPreferencesUtil.getIntData(context, this.info.getApp_key() + "_" + ZhiChiConstant.initType, -1);
        if (this.info.getService_mode() >= 0 && intData != this.info.getService_mode()) {
            resetUser(i);
        } else if (TextUtils.isEmpty(this.info.getGroupid())) {
            keepSession(messageList);
        } else {
            Context context2 = this.mAppContext;
            if (SharedPreferencesUtil.getStringData(context2, this.info.getApp_key() + "_" + ZhiChiConstant.sobot_last_login_group_id, "").equals(this.info.getGroupid())) {
                keepSession(messageList);
            } else {
                resetUser(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void editModelToVoice(int i, String str) {
        this.btn_model_edit.setVisibility(8 == i ? 8 : 0);
        this.btn_model_voice.setVisibility(i != 0 ? 0 : 8);
        this.btn_press_to_speak.setVisibility(8 != i ? 0 : 8);
        this.edittext_layout.setVisibility(i == 0 ? 8 : 0);
        if (TextUtils.isEmpty(this.et_sendmessage.getText().toString()) || !str.equals("123")) {
            this.btn_send.setVisibility(8);
            this.btn_upload_view.setVisibility(0);
            return;
        }
        this.btn_send.setVisibility(0);
        this.btn_upload_view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAnnouncement() {
        if (TextUtils.isEmpty(this.initModel.getAnnounceClickUrl()) || !this.initModel.getAnnounceClickFlag()) {
            this.sobot_announcement_title.setTextColor(ContextCompat.getColor(getContext(), ResourceUtils.getResColorId(getContext(), "sobot_announcement_title_color")));
            this.sobot_announcement_right_icon.setVisibility(8);
        } else {
            this.sobot_announcement_right_icon.setVisibility(8);
            this.sobot_announcement_title.setTextColor(ContextCompat.getColor(getContext(), ResourceUtils.getResColorId(getContext(), "sobot_announcement_title_color_2")));
        }
        if (!this.initModel.getAnnounceMsgFlag() || !this.initModel.isAnnounceTopFlag() || TextUtils.isEmpty(this.initModel.getAnnounceMsg())) {
            this.sobot_announcement.setVisibility(8);
            return;
        }
        this.sobot_announcement.setVisibility(0);
        this.sobot_announcement_title.setText(this.initModel.getAnnounceMsg());
        this.sobot_announcement.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (TextUtils.isEmpty(SobotChatFragment.this.initModel.getAnnounceClickUrl()) || !SobotChatFragment.this.initModel.getAnnounceClickFlag()) {
                    return;
                }
                if (SobotOption.hyperlinkListener != null) {
                    SobotOption.hyperlinkListener.onUrlClick(SobotChatFragment.this.initModel.getAnnounceClickUrl());
                } else if (SobotOption.newHyperlinkListener == null || !SobotOption.newHyperlinkListener.onUrlClick(SobotChatFragment.this.getSobotActivity(), SobotChatFragment.this.initModel.getAnnounceClickUrl())) {
                    Intent intent = new Intent(SobotChatFragment.this.mAppContext, WebViewActivity.class);
                    intent.putExtra("url", SobotChatFragment.this.initModel.getAnnounceClickUrl());
                    SobotChatFragment.this.startActivity(intent);
                }
            }
        });
    }

    private void getGroupInfo(final SobotConnCusParam sobotConnCusParam) {
        this.zhiChiApi.getGroupList(this, this.info.getApp_key(), this.initModel.getPartnerid(), new StringResultCallBack<ZhiChiGroup>() { // from class: com.sobot.chat.conversation.SobotChatFragment.22
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                if (SobotChatFragment.this.isActive()) {
                    ToastUtil.showToast(SobotChatFragment.this.mAppContext, str);
                }
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(ZhiChiGroup zhiChiGroup) {
                boolean z;
                if (SobotChatFragment.this.isActive()) {
                    if ("0".equals(zhiChiGroup.getUstatus())) {
                        SobotChatFragment sobotChatFragment = SobotChatFragment.this;
                        sobotChatFragment.customerServiceOffline(sobotChatFragment.initModel, 4);
                        return;
                    }
                    SobotChatFragment.this.list_group = zhiChiGroup.getData();
                    if (SobotChatFragment.this.list_group == null || SobotChatFragment.this.list_group.size() <= 0) {
                        SobotChatFragment sobotChatFragment2 = SobotChatFragment.this;
                        sobotChatFragment2.requestQueryFrom(sobotConnCusParam, sobotChatFragment2.info.isCloseInquiryForm());
                        return;
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= SobotChatFragment.this.list_group.size()) {
                            z = false;
                            break;
                        } else if (fw.Code.equals(((ZhiChiGroupBase) SobotChatFragment.this.list_group.get(i2)).isOnline())) {
                            z = true;
                            break;
                        } else {
                            i = i2 + 1;
                        }
                    }
                    if (!z) {
                        if (SobotChatFragment.this.messageAdapter == null || SobotChatFragment.this.keyWordMessageBase == null) {
                            SobotChatFragment.this.connCustomerServiceFail(true);
                            return;
                        }
                        SobotChatFragment.this.messageAdapter.justAddData(SobotChatFragment.this.keyWordMessageBase);
                        SobotChatFragment.this.messageAdapter.notifyDataSetChanged();
                        SobotChatFragment.this.keyWordMessageBase = null;
                    } else if (SobotChatFragment.this.initModel.getUstatus() == 1 || SobotChatFragment.this.initModel.getUstatus() == -2) {
                        SobotChatFragment.this.connectCustomerService(null);
                    } else if (!TextUtils.isEmpty(SobotChatFragment.this.info.getGroupid())) {
                        SobotChatFragment sobotChatFragment3 = SobotChatFragment.this;
                        SobotConnCusParam sobotConnCusParam2 = sobotConnCusParam;
                        int i3 = 0;
                        if (sobotConnCusParam2 != null) {
                            i3 = sobotConnCusParam2.getTransferType();
                        }
                        sobotChatFragment3.transfer2CustomBySkillId(sobotConnCusParam2, i3);
                    } else {
                        Intent intent = new Intent(SobotChatFragment.this.mAppContext, SobotSkillGroupActivity.class);
                        intent.putExtra("grouplist", (Serializable) SobotChatFragment.this.list_group);
                        intent.putExtra("uid", SobotChatFragment.this.initModel.getPartnerid());
                        intent.putExtra("type", SobotChatFragment.this.type);
                        intent.putExtra("appkey", SobotChatFragment.this.info.getApp_key());
                        intent.putExtra("companyId", SobotChatFragment.this.initModel.getCompanyId());
                        intent.putExtra("msgTmp", SobotChatFragment.this.initModel.getMsgTmp());
                        intent.putExtra("msgTxt", SobotChatFragment.this.initModel.getMsgTxt());
                        intent.putExtra("msgFlag", SobotChatFragment.this.initModel.getMsgFlag());
                        SobotConnCusParam sobotConnCusParam3 = sobotConnCusParam;
                        int i4 = 0;
                        if (sobotConnCusParam3 != null) {
                            i4 = sobotConnCusParam3.getTransferType();
                        }
                        intent.putExtra("transferType", i4);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("sobotConnCusParam", sobotConnCusParam);
                        intent.putExtras(bundle);
                        SobotChatFragment.this.startActivityForResult(intent, 100);
                    }
                }
            }
        });
    }

    private String getPanelViewTag(View view) {
        View childAt;
        return ((view instanceof KPSwitchPanelLinearLayout) && (childAt = ((KPSwitchPanelLinearLayout) view).getChildAt(0)) != null && (childAt instanceof CustomeChattingPanel)) ? ((CustomeChattingPanel) childAt).getPanelViewTag() : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoLastItem() {
        this.handler.post(new Runnable() { // from class: com.sobot.chat.conversation.SobotChatFragment.24
            @Override // java.lang.Runnable
            public void run() {
                SobotChatFragment.this.lv_message.setSelection(SobotChatFragment.this.messageAdapter.getCount());
            }
        });
    }

    private void hideRobotVoiceHint() {
        this.send_voice_robot_hint.setVisibility(8);
    }

    private void initBrocastReceiver() {
        if (this.receiver == null) {
            this.receiver = new MyMessageReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        getSobotActivity().registerReceiver(this.receiver, intentFilter);
        if (this.localReceiver == null) {
            this.localReceiver = new LocalReceiver();
        }
        this.localBroadcastManager = LocalBroadcastManager.getInstance(this.mAppContext);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(ZhiChiConstants.receiveMessageBrocast);
        intentFilter2.addAction(ZhiChiConstant.SOBOT_BROCAST_ACTION_SEND_LOCATION);
        intentFilter2.addAction(ZhiChiConstant.SOBOT_BROCAST_ACTION_SEND_TEXT);
        intentFilter2.addAction(ZhiChiConstant.SOBOT_BROCAST_ACTION_SEND_OBJECT);
        intentFilter2.addAction(ZhiChiConstant.SOBOT_BROCAST_ACTION_SEND_CARD);
        intentFilter2.addAction(ZhiChiConstant.SOBOT_BROCAST_ACTION_SEND_ORDER_CARD);
        intentFilter2.addAction(ZhiChiConstant.SOBOT_BROCAST_ACTION_TRASNFER_TO_OPERATOR);
        intentFilter2.addAction(ZhiChiConstants.chat_remind_post_msg);
        intentFilter2.addAction(ZhiChiConstants.sobot_click_cancle);
        intentFilter2.addAction(ZhiChiConstants.dcrc_comment_state);
        intentFilter2.addAction(ZhiChiConstants.sobot_close_now);
        intentFilter2.addAction(ZhiChiConstants.sobot_close_now_clear_cache);
        intentFilter2.addAction(ZhiChiConstants.SOBOT_CHANNEL_STATUS_CHANGE);
        intentFilter2.addAction(ZhiChiConstants.SOBOT_BROCAST_KEYWORD_CLICK);
        intentFilter2.addAction(ZhiChiConstants.SOBOT_BROCAST_REMOVE_FILE_TASK);
        intentFilter2.addAction(ZhiChiConstants.chat_remind_to_customer);
        intentFilter2.addAction(ZhiChiConstants.SOBOT_CHAT_MUITILEAVEMSG_TO_CHATLIST);
        this.localBroadcastManager.registerReceiver(this.localReceiver, intentFilter2);
    }

    private void initListener() {
        this.mKPSwitchListener = KeyboardUtil.attach(getSobotActivity(), this.mPanelRoot, new KeyboardUtil.OnKeyboardShowingListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.6
            @Override // com.sobot.chat.widget.kpswitch.util.KeyboardUtil.OnKeyboardShowingListener
            public void onKeyboardShowing(boolean z) {
                SobotChatFragment.this.resetEmoticonBtn();
                if (z) {
                    SobotChatFragment.this.lv_message.setSelection(SobotChatFragment.this.messageAdapter.getCount());
                }
            }
        });
        KPSwitchConflictUtil.attach(this.mPanelRoot, this.btn_upload_view, this.et_sendmessage);
        this.notReadInfo.setOnClickListener(this);
        this.btn_send.setOnClickListener(this);
        this.btn_upload_view.setOnClickListener(this);
        this.btn_emoticon_view.setOnClickListener(this);
        this.btn_model_edit.setOnClickListener(this);
        this.btn_model_voice.setOnClickListener(this);
        this.sobot_ll_switch_robot.setOnClickListener(this);
        this.sobot_tv_right_second.setOnClickListener(this);
        this.sobot_tv_right_third.setOnClickListener(this);
        if (SharedPreferencesUtil.getBooleanData(getSobotActivity(), "sobot_use_language", false) || !StringUtils.isZh(getSobotActivity())) {
            this.btn_set_mode_rengong.setBackgroundResource(ResourceUtils.getDrawableId(getSobotActivity(), "sobot_icon_common_manualwork"));
        }
        this.btn_set_mode_rengong.setOnClickListener(new NoDoubleClickListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.7
            @Override // com.sobot.chat.listener.NoDoubleClickListener
            public void onNoDoubleClick(View view) {
                SobotChatFragment.this.doClickTransferBtn();
            }
        });
        this.lv_message.setDropdownListScrollListener(new DropdownListView.DropdownListScrollListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.8
            @Override // com.sobot.chat.widget.DropdownListView.DropdownListScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (SobotChatFragment.this.notReadInfo.getVisibility() != 0 || SobotChatFragment.this.messageList.size() <= 0 || SobotChatFragment.this.messageList.size() <= i || SobotChatFragment.this.messageList.get(i) == null || ((ZhiChiMessageBase) SobotChatFragment.this.messageList.get(i)).getAnswer() == null || 7 != ((ZhiChiMessageBase) SobotChatFragment.this.messageList.get(i)).getAnswer().getRemindType()) {
                    return;
                }
                SobotChatFragment.this.notReadInfo.setVisibility(8);
            }
        });
        TextView textView = this.sobot_tv_close;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    SobotChatFragment.this.onCloseMenuClick();
                }
            });
        }
        this.et_sendmessage.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotChatFragment.this.resetBtnUploadAndSend();
            }
        });
        this.et_sendmessage.setSobotAutoCompleteListener(this);
        this.et_sendmessage.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotChatFragment.this.doEmoticonBtn2Blur();
                SobotChatFragment.this.btn_emoticon_view.setBackgroundResource(ResourceUtils.getDrawableId(SobotChatFragment.this.getContext(), "sobot_emoticon_button_selector"));
                if (SobotApi.getSwitchMarkStatus(1)) {
                    SobotChatFragment.this.et_sendmessage.dismissPop();
                }
            }
        });
        this.et_sendmessage.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.12
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Tracker.onFocusChange(view, z);
                if (!z || SobotChatFragment.this.et_sendmessage.getText().toString().trim().length() == 0) {
                    return;
                }
                SobotChatFragment.this.btn_send.setVisibility(0);
                SobotChatFragment.this.btn_upload_view.setVisibility(8);
            }
        });
        this.et_sendmessage.addTextChangedListener(new TextWatcher() { // from class: com.sobot.chat.conversation.SobotChatFragment.13
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SobotChatFragment.this.resetBtnUploadAndSend();
            }
        });
        this.btn_press_to_speak.setOnTouchListener(new PressToSpeakListen());
        this.lv_message.setOnTouchListener(new View.OnTouchListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    SobotChatFragment sobotChatFragment = SobotChatFragment.this;
                    sobotChatFragment.hidePanelAndKeyboard(sobotChatFragment.mPanelRoot);
                    return false;
                }
                return false;
            }
        });
        this.sobot_txt_restart_talk.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotChatFragment.this.initSdk(true, 0);
            }
        });
        this.sobot_tv_message.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotChatFragment.this.startToPostMsgActivty(false);
            }
        });
        this.sobot_tv_satisfaction.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotChatFragment.this.submitEvaluation(true, 5, 0, "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSdk(boolean z, int i) {
        if (z) {
            this.current_client_model = 301;
            this.showTimeVisiableCustomBtn = 0;
            this.messageList.clear();
            this.messageAdapter.notifyDataSetChanged();
            this.cids.clear();
            this.currentCidPosition = 0;
            this.queryCidsStatus = 0;
            this.isNoMoreHistoryMsg = false;
            this.isAboveZero = false;
            this.isComment = false;
            this.customerState = CustomerState.Offline;
            this.remindRobotMessageTimes = 0;
            this.queueTimes = 0;
            this.isSessionOver = false;
            this.isHasRequestQueryFrom = false;
            this.sobot_txt_restart_talk.setVisibility(8);
            this.sobot_tv_message.setVisibility(8);
            this.sobot_tv_satisfaction.setVisibility(8);
            this.image_reLoading.setVisibility(0);
            AnimationUtil.rotate(this.image_reLoading);
            this.lv_message.setPullRefreshEnable(true);
            Context context = this.mAppContext;
            this.info.setChoose_adminid(SharedPreferencesUtil.getStringData(context, this.info.getApp_key() + "_" + ZhiChiConstant.SOBOT_RECEPTIONISTID, ""));
            resetUser(i);
        } else if (ChatUtils.checkConfigChange(this.mAppContext, this.info.getApp_key(), this.info)) {
            resetUser(i);
        } else {
            doKeepsessionInit(i);
        }
        resetBtnUploadAndSend();
    }

    private void initView(View view) {
        if (view == null) {
            return;
        }
        this.relative = (RelativeLayout) view.findViewById(getResId("sobot_layout_titlebar"));
        this.sobot_header_center_ll = (LinearLayout) view.findViewById(getResId("sobot_header_center_ll"));
        this.mTitleTextView = (TextView) view.findViewById(getResId("sobot_text_title"));
        this.mAvatarIV = (SobotRCImageView) view.findViewById(getResId("sobot_avatar_iv"));
        this.sobot_title_conn_status = (TextView) view.findViewById(getResId("sobot_title_conn_status"));
        this.sobot_container_conn_status = (LinearLayout) view.findViewById(getResId("sobot_container_conn_status"));
        this.sobot_tv_right_second = (TextView) view.findViewById(getResId("sobot_tv_right_second"));
        this.sobot_tv_right_third = (TextView) view.findViewById(getResId("sobot_tv_right_third"));
        this.sobot_conn_loading = (ProgressBar) view.findViewById(getResId("sobot_conn_loading"));
        this.net_status_remide = (RelativeLayout) view.findViewById(getResId("sobot_net_status_remide"));
        TextView textView = (TextView) view.findViewById(getResId("sobot_net_not_connect"));
        this.sobot_net_not_connect = textView;
        textView.setText(ResourceUtils.getResString(getSobotActivity(), "sobot_network_unavailable"));
        this.relative.setVisibility(8);
        this.notReadInfo = (TextView) view.findViewById(getResId("notReadInfo"));
        this.chat_main = (RelativeLayout) view.findViewById(getResId("sobot_chat_main"));
        this.welcome = (FrameLayout) view.findViewById(getResId("sobot_welcome"));
        this.txt_loading = (TextView) view.findViewById(getResId("sobot_txt_loading"));
        TextView textView2 = (TextView) view.findViewById(getResId("sobot_textReConnect"));
        this.textReConnect = textView2;
        textView2.setText(ResourceUtils.getResString(getSobotActivity(), "sobot_try_again"));
        this.loading_anim_view = (ProgressBar) view.findViewById(getResId("sobot_image_view"));
        this.image_reLoading = (ImageView) view.findViewById(getResId("sobot_image_reloading"));
        this.icon_nonet = (ImageView) view.findViewById(getResId("sobot_icon_nonet"));
        Button button = (Button) view.findViewById(getResId("sobot_btn_reconnect"));
        this.btn_reconnect = button;
        button.setText(ResourceUtils.getResString(getSobotActivity(), "sobot_reunicon"));
        this.btn_reconnect.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                SobotChatFragment.this.textReConnect.setVisibility(8);
                SobotChatFragment.this.icon_nonet.setVisibility(8);
                SobotChatFragment.this.btn_reconnect.setVisibility(8);
                SobotChatFragment.this.loading_anim_view.setVisibility(0);
                SobotChatFragment.this.txt_loading.setVisibility(0);
                SobotChatFragment.this.customerInit(1);
            }
        });
        this.lv_message = (DropdownListView) view.findViewById(getResId("sobot_lv_message"));
        if (Build.VERSION.SDK_INT >= 8) {
            this.lv_message.setOverScrollMode(2);
        }
        ContainsEmojiEditText containsEmojiEditText = (ContainsEmojiEditText) view.findViewById(getResId("sobot_et_sendmessage"));
        this.et_sendmessage = containsEmojiEditText;
        containsEmojiEditText.setVisibility(0);
        Button button2 = (Button) view.findViewById(getResId("sobot_btn_send"));
        this.btn_send = button2;
        button2.setText(ResourceUtils.getResString(getSobotActivity(), "sobot_button_send"));
        this.btn_set_mode_rengong = (ImageButton) view.findViewById(getResId("sobot_btn_set_mode_rengong"));
        this.view_model_split = view.findViewById(getResId("sobot_view_model_split"));
        TextView textView3 = (TextView) view.findViewById(getResId("send_voice_robot_hint"));
        this.send_voice_robot_hint = textView3;
        textView3.setHint(ResourceUtils.getResString(getSobotActivity(), "sobot_robot_voice_hint"));
        this.send_voice_robot_hint.setVisibility(8);
        this.btn_upload_view = (Button) view.findViewById(getResId("sobot_btn_upload_view"));
        this.btn_emoticon_view = (ImageButton) view.findViewById(getResId("sobot_btn_emoticon_view"));
        this.btn_model_edit = (ImageButton) view.findViewById(getResId("sobot_btn_model_edit"));
        this.btn_model_voice = (ImageButton) view.findViewById(getResId("sobot_btn_model_voice"));
        this.mPanelRoot = (KPSwitchPanelLinearLayout) view.findViewById(getResId("sobot_panel_root"));
        this.btn_press_to_speak = (LinearLayout) view.findViewById(getResId("sobot_btn_press_to_speak"));
        this.edittext_layout = (LinearLayout) view.findViewById(getResId("sobot_edittext_layout"));
        this.recording_hint = (TextView) view.findViewById(getResId("sobot_recording_hint"));
        this.recording_container = (LinearLayout) view.findViewById(getResId("sobot_recording_container"));
        this.voice_top_image = (LinearLayout) view.findViewById(getResId("sobot_voice_top_image"));
        this.image_endVoice = (ImageView) view.findViewById(getResId("sobot_image_endVoice"));
        this.mic_image_animate = (ImageView) view.findViewById(getResId("sobot_mic_image_animate"));
        this.voice_time_long = (TextView) view.findViewById(getResId("sobot_voiceTimeLong"));
        TextView textView4 = (TextView) view.findViewById(getResId("sobot_txt_speak_content"));
        this.txt_speak_content = textView4;
        textView4.setText(getResString("sobot_press_say"));
        this.recording_timeshort = (ImageView) view.findViewById(getResId("sobot_recording_timeshort"));
        this.mic_image = (ImageView) view.findViewById(getResId("sobot_mic_image"));
        this.sobot_ll_restart_talk = (RelativeLayout) view.findViewById(getResId("sobot_ll_restart_talk"));
        TextView textView5 = (TextView) view.findViewById(getResId("sobot_txt_restart_talk"));
        this.sobot_txt_restart_talk = textView5;
        textView5.setText(ResourceUtils.getResString(getSobotActivity(), "sobot_restart_talk"));
        TextView textView6 = (TextView) view.findViewById(getResId("sobot_tv_message"));
        this.sobot_tv_message = textView6;
        textView6.setText(ResourceUtils.getResString(getSobotActivity(), "sobot_str_bottom_message"));
        TextView textView7 = (TextView) view.findViewById(getResId("sobot_tv_satisfaction"));
        this.sobot_tv_satisfaction = textView7;
        textView7.setText(ResourceUtils.getResString(getSobotActivity(), "sobot_str_bottom_satisfaction"));
        this.sobot_ll_bottom = (LinearLayout) view.findViewById(getResId("sobot_ll_bottom"));
        this.sobot_ll_switch_robot = (LinearLayout) view.findViewById(getResId("sobot_ll_switch_robot"));
        TextView textView8 = (TextView) view.findViewById(getResId("sobot_tv_switch_robot"));
        this.sobot_tv_switch_robot = textView8;
        textView8.setText(ResourceUtils.getResString(getSobotActivity(), "sobot_switch_business"));
        this.sobot_announcement = (RelativeLayout) view.findViewById(getResId("sobot_announcement"));
        this.sobot_announcement_right_icon = (TextView) view.findViewById(getResId("sobot_announcement_right_icon"));
        TextView textView9 = (TextView) view.findViewById(getResId("sobot_announcement_title"));
        this.sobot_announcement_title = textView9;
        textView9.setSelected(true);
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) view.findViewById(getResId("sobot_custom_menu"));
        this.sobot_custom_menu = horizontalScrollView;
        horizontalScrollView.setVisibility(8);
        this.sobot_custom_menu_linearlayout = (LinearLayout) view.findViewById(getResId("sobot_custom_menu_linearlayout"));
        applyUIConfig();
        this.mPostMsgPresenter = StPostMsgPresenter.newInstance(this, getContext());
    }

    private void keepSession(List<ZhiChiMessageBase> list) {
        ZhiChiConfig config = SobotMsgManager.getInstance(this.mAppContext).getConfig(this.info.getApp_key());
        this.initModel = config.getInitModel();
        updateFloatUnreadIcon();
        this.mUnreadNum = 0;
        this.messageAdapter.addData(list);
        this.messageAdapter.notifyDataSetChanged();
        this.current_client_model = config.current_client_model;
        this.type = Integer.parseInt(this.initModel.getType());
        String cid = this.initModel.getCid();
        String str = preCurrentCid;
        if (str == null) {
            statusFlag = 0;
        } else if (!cid.equals(str)) {
            statusFlag = 0;
        }
        Context context = this.mAppContext;
        SharedPreferencesUtil.saveIntData(context, this.info.getApp_key() + "_" + ZhiChiConstant.initType, this.type);
        StringBuilder sb = new StringBuilder();
        sb.append("sobot----type---->");
        sb.append(this.type);
        LogUtils.i(sb.toString());
        showLogicTitle(config.activityTitle, config.adminFace, false);
        showSwitchRobotBtn();
        this.customerState = config.customerState;
        this.remindRobotMessageTimes = config.remindRobotMessageTimes;
        this.isComment = config.isComment;
        this.isAboveZero = config.isAboveZero;
        this.currentUserName = config.currentUserName;
        this.isNoMoreHistoryMsg = config.isNoMoreHistoryMsg;
        this.currentCidPosition = config.currentCidPosition;
        this.queryCidsStatus = config.queryCidsStatus;
        this.isShowQueueTip = config.isShowQueueTip;
        if (config.cids != null) {
            this.cids.addAll(config.cids);
        }
        this.showTimeVisiableCustomBtn = config.showTimeVisiableCustomBtn;
        this.queueNum = config.queueNum;
        if (this.isNoMoreHistoryMsg) {
            this.lv_message.setPullRefreshEnable(false);
        }
        setAdminFace(config.adminFace);
        this.mBottomViewtype = config.bottomViewtype;
        setBottomView(config.bottomViewtype);
        this.isChatLock = config.isChatLock;
        if (this.type == 2 && statusFlag == 0) {
            preCurrentCid = cid;
            if (isUserBlack()) {
                showLeaveMsg();
            } else if (this.initModel.getInvalidSessionFlag() == 1) {
                setBottomView(0);
                this.btn_set_mode_rengong.setVisibility(8);
                this.btn_model_edit.setVisibility(8);
                this.btn_model_voice.setVisibility(8);
                this.btn_emoticon_view.setVisibility(0);
                this.tempMsgContent = config.tempMsgContent;
                setAvatar(getResDrawableId("sobot_def_admin"), true);
                setTitle("", false);
            } else {
                transfer2Custom((String) null, (String) null, (String) null, true, "1");
            }
        }
        if (this.type == 4 && statusFlag == 0) {
            this.tempMsgContent = config.tempMsgContent;
        }
        LogUtils.i("sobot----isChatLock--->userInfoTimeTask " + config.userInfoTimeTask + "=====customTimeTask====" + config.customTimeTask + this.isChatLock);
        this.paseReplyTimeCustoms = config.paseReplyTimeCustoms;
        this.paseReplyTimeUserInfo = config.paseReplyTimeUserInfo;
        if (config.userInfoTimeTask && this.isChatLock != 1) {
            stopUserInfoTimeTask();
            startUserInfoTimeTask(this.handler);
            this.noReplyTimeUserInfo = config.paseReplyTimeUserInfo;
        }
        if (config.customTimeTask && this.isChatLock != 1) {
            stopCustomTimeTask();
            startCustomTimeTask(this.handler);
            this.noReplyTimeCustoms = config.paseReplyTimeCustoms;
        }
        if (this.info.getAutoSendMsgMode().geIsEveryTimeAutoSend()) {
            config.isProcessAutoSendMsg = true;
        }
        if (config.isProcessAutoSendMsg) {
            if (this.info.getAutoSendMsgMode().getAuto_send_msgtype() == SobotAutoSendMsgMode.ZCMessageTypeText) {
                processAutoSendMsg(this.info);
            } else if (this.info.getAutoSendMsgMode() != null && this.info.getAutoSendMsgMode() != SobotAutoSendMsgMode.Default && this.current_client_model == 302 && !TextUtils.isEmpty(this.info.getAutoSendMsgMode().getContent()) && this.info.getAutoSendMsgMode() == SobotAutoSendMsgMode.SendToOperator && this.customerState == CustomerState.Online) {
                String content = this.info.getAutoSendMsgMode().getContent();
                if (this.info.getAutoSendMsgMode().getAuto_send_msgtype() == SobotAutoSendMsgMode.ZCMessageTypeFile) {
                    File file = new File(content);
                    if (file.exists()) {
                        uploadFile(file, this.handler, this.lv_message, this.messageAdapter, false);
                    }
                } else if (this.info.getAutoSendMsgMode().getAuto_send_msgtype() == SobotAutoSendMsgMode.ZCMessageTypeVideo) {
                    File file2 = new File(content);
                    if (file2.exists()) {
                        uploadVideo(file2, null, this.messageAdapter);
                    }
                } else if (this.info.getAutoSendMsgMode().getAuto_send_msgtype() == SobotAutoSendMsgMode.ZCMessageTypePhoto) {
                    File file3 = new File(content);
                    if (file3.exists()) {
                        uploadFile(file3, this.handler, this.lv_message, this.messageAdapter, false);
                    }
                }
            }
            config.isProcessAutoSendMsg = false;
        }
        this.et_sendmessage.setRequestParams(this.initModel.getPartnerid(), this.initModel.getRobotid());
        if (this.customerState == CustomerState.Online && this.current_client_model == 302) {
            createConsultingContent(1);
            createOrderCardContent(1);
            this.et_sendmessage.setAutoCompleteEnable(false);
            showLogicTitle(null, config.adminFace, false);
        } else {
            this.et_sendmessage.setAutoCompleteEnable(true);
            showLogicTitle(null, this.initModel.getRobotLogo(), false);
        }
        this.lv_message.setSelection(this.messageAdapter.getCount());
        getAnnouncement();
        sobotCustomMenu();
        config.clearMessageList();
        config.clearInitModel();
        this.isSessionOver = false;
        int size = this.messageList.size();
        while (true) {
            int i = size - 1;
            if (i > 0) {
                if (!TextUtils.isEmpty(this.messageList.get(i).getSenderType()) && Integer.parseInt(this.messageList.get(i).getSenderType()) == 24 && this.messageList.get(i).getAnswer() != null && 9 == this.messageList.get(i).getAnswer().getRemindType()) {
                    this.messageList.remove(i);
                    this.messageAdapter.notifyDataSetChanged();
                    break;
                }
                size = i;
            } else {
                break;
            }
        }
        processNewTicketMsg(this.handler);
        this.inPolling = config.inPolling;
        if (this.current_client_model == 302 && this.inPolling && !CommonUtils.isServiceWork(getSobotActivity(), "com.sobot.chat.core.channel.SobotTCPServer")) {
            startPolling();
        }
    }

    private void loadUnreadNum() {
        this.mUnreadNum = SobotMsgManager.getInstance(this.mAppContext).getUnreadCount(this.info.getApp_key(), true, this.info.getPartnerid());
    }

    public static SobotChatFragment newInstance(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(ZhiChiConstant.SOBOT_BUNDLE_INFORMATION, bundle);
        SobotChatFragment sobotChatFragment = new SobotChatFragment();
        sobotChatFragment.setArguments(bundle2);
        return sobotChatFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoad() {
        this.lv_message.onRefreshCompleteHeader();
    }

    private void onlyCustomPaidui() {
        if (SobotOption.sobotChatStatusListener != null) {
            SobotOption.sobotChatStatusListener.onChatStatusListener(SobotChatStatusMode.ZCServerConnectWaiting);
        }
        this.sobot_ll_bottom.setVisibility(0);
        this.btn_set_mode_rengong.setVisibility(8);
        this.btn_set_mode_rengong.setClickable(false);
        this.btn_upload_view.setVisibility(0);
        this.btn_send.setVisibility(8);
        this.btn_upload_view.setClickable(false);
        this.btn_upload_view.setEnabled(false);
        showEmotionBtn();
        this.btn_emoticon_view.setClickable(false);
        this.btn_emoticon_view.setEnabled(false);
        showVoiceBtn();
        this.btn_model_voice.setClickable(false);
        this.btn_model_voice.setEnabled(false);
        this.btn_model_voice.setVisibility(8);
        this.edittext_layout.setVisibility(8);
        this.btn_press_to_speak.setClickable(false);
        this.btn_press_to_speak.setEnabled(false);
        this.btn_press_to_speak.setVisibility(0);
        this.txt_speak_content.setText(getResString("sobot_in_line"));
        showLogicTitle(getResString("sobot_in_line"), null, false);
        if (this.sobot_ll_restart_talk.getVisibility() == 0) {
            this.sobot_ll_restart_talk.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processPlatformAppId() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queryCids() {
        int i;
        if (this.initModel == null || (i = this.queryCidsStatus) == 1 || i == 2) {
            return;
        }
        long longData = SharedPreferencesUtil.getLongData(this.mAppContext, "sobot_scope_time", 0L);
        this.queryCidsStatus = 1;
        this.zhiChiApi.queryCids(this, this.initModel.getPartnerid(), longData, new StringResultCallBack<ZhiChiCidsModel>() { // from class: com.sobot.chat.conversation.SobotChatFragment.26
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                SobotChatFragment.this.queryCidsStatus = 3;
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(ZhiChiCidsModel zhiChiCidsModel) {
                boolean z;
                if (SobotChatFragment.this.isActive()) {
                    SobotChatFragment.this.queryCidsStatus = 2;
                    SobotChatFragment.this.cids = zhiChiCidsModel.getCids();
                    if (SobotChatFragment.this.cids != null) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            z = false;
                            if (i3 >= SobotChatFragment.this.cids.size()) {
                                break;
                            } else if (((String) SobotChatFragment.this.cids.get(i3)).equals(SobotChatFragment.this.initModel.getCid())) {
                                z = true;
                                break;
                            } else {
                                i2 = i3 + 1;
                            }
                        }
                        if (!z) {
                            SobotChatFragment.this.cids.add(SobotChatFragment.this.initModel.getCid());
                        }
                        Collections.reverse(SobotChatFragment.this.cids);
                    }
                    SobotChatFragment.this.getHistoryMessage(true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void refreshItemByCategory(final Class<T> cls) {
        if (isActive()) {
            this.lv_message.post(new Runnable() { // from class: com.sobot.chat.conversation.SobotChatFragment.31
                @Override // java.lang.Runnable
                public void run() {
                    int childCount = SobotChatFragment.this.lv_message.getChildCount();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= childCount) {
                            return;
                        }
                        View childAt = SobotChatFragment.this.lv_message.getChildAt(i2);
                        if (childAt != null && childAt.getTag() != null) {
                            if (cls == RichTextMessageHolder.class && (childAt.getTag() instanceof RichTextMessageHolder)) {
                                ((RichTextMessageHolder) childAt.getTag()).refreshItem();
                            } else if (cls == CusEvaluateMessageHolder.class && (childAt.getTag() instanceof CusEvaluateMessageHolder)) {
                                ((CusEvaluateMessageHolder) childAt.getTag()).refreshItem();
                            } else if (cls == RobotTemplateMessageHolder1.class && (childAt.getTag() instanceof RobotTemplateMessageHolder1)) {
                                ((RobotTemplateMessageHolder1) childAt.getTag()).refreshRevaluateItem();
                            } else if (cls == RobotTemplateMessageHolder2.class && (childAt.getTag() instanceof RobotTemplateMessageHolder2)) {
                                ((RobotTemplateMessageHolder2) childAt.getTag()).refreshRevaluateItem();
                            } else if (cls == RobotTemplateMessageHolder3.class && (childAt.getTag() instanceof RobotTemplateMessageHolder3)) {
                                ((RobotTemplateMessageHolder3) childAt.getTag()).refreshRevaluateItem();
                            } else if (cls == RobotTemplateMessageHolder4.class && (childAt.getTag() instanceof RobotTemplateMessageHolder4)) {
                                ((RobotTemplateMessageHolder4) childAt.getTag()).refreshRevaluateItem();
                            } else if (cls == RobotTemplateMessageHolder5.class && (childAt.getTag() instanceof RobotTemplateMessageHolder5)) {
                                ((RobotTemplateMessageHolder5) childAt.getTag()).refreshRevaluateItem();
                            } else if (cls == RobotTemplateMessageHolder6.class && (childAt.getTag() instanceof RobotTemplateMessageHolder6)) {
                                ((RobotTemplateMessageHolder6) childAt.getTag()).refreshRevaluateItem();
                            }
                        }
                        i = i2 + 1;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetBtnUploadAndSend() {
        if (this.et_sendmessage.getText().toString().length() > 0) {
            this.btn_upload_view.setVisibility(8);
            this.btn_send.setVisibility(0);
            return;
        }
        this.btn_send.setVisibility(8);
        this.btn_upload_view.setVisibility(0);
        this.btn_upload_view.setEnabled(true);
        this.btn_upload_view.setClickable(true);
        if (Build.VERSION.SDK_INT >= 11) {
            this.btn_upload_view.setAlpha(1.0f);
        }
    }

    private void resetUser(int i) {
        SharedPreferencesUtil.getStringData(this.mAppContext, ZhiChiConstant.SOBOT_PLATFORM_UNIONCODE, "");
        this.zhiChiApi.disconnChannel();
        clearCache();
        Context context = this.mAppContext;
        SharedPreferencesUtil.saveStringData(context, this.info.getApp_key() + "_" + ZhiChiConstant.sobot_last_login_group_id, TextUtils.isEmpty(this.info.getGroupid()) ? "" : this.info.getGroupid());
        customerInit(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restMultiMsg() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.messageList.size()) {
                this.messageAdapter.notifyDataSetChanged();
                return;
            }
            ZhiChiMessageBase zhiChiMessageBase = this.messageList.get(i2);
            if (zhiChiMessageBase.getAnswer() != null && zhiChiMessageBase.getAnswer().getMultiDiaRespInfo() != null && !zhiChiMessageBase.getAnswer().getMultiDiaRespInfo().getEndFlag()) {
                zhiChiMessageBase.setMultiDiaRespEnd(1);
            }
            i = i2 + 1;
        }
    }

    private void saveCache() {
        ZhiChiConfig config = SobotMsgManager.getInstance(this.mAppContext).getConfig(this.info.getApp_key());
        config.isShowUnreadUi = true;
        config.setMessageList(this.messageList);
        config.setInitModel(this.initModel);
        config.current_client_model = this.current_client_model;
        if (this.queryCidsStatus == 2) {
            config.cids = this.cids;
            config.currentCidPosition = this.currentCidPosition;
            config.queryCidsStatus = this.queryCidsStatus;
        }
        config.activityTitle = getActivityTitle();
        config.customerState = this.customerState;
        config.remindRobotMessageTimes = this.remindRobotMessageTimes;
        config.isAboveZero = this.isAboveZero;
        config.isComment = this.isComment;
        config.adminFace = getAdminFace();
        config.paseReplyTimeCustoms = this.noReplyTimeCustoms;
        config.customTimeTask = this.customTimeTask;
        config.paseReplyTimeUserInfo = this.noReplyTimeUserInfo;
        config.userInfoTimeTask = this.userInfoTimeTask;
        config.isChatLock = this.isChatLock;
        config.currentUserName = this.currentUserName;
        config.isNoMoreHistoryMsg = this.isNoMoreHistoryMsg;
        config.showTimeVisiableCustomBtn = this.showTimeVisiableCustomBtn;
        config.bottomViewtype = this.mBottomViewtype;
        config.queueNum = this.queueNum;
        config.isShowQueueTip = this.isShowQueueTip;
        config.tempMsgContent = this.tempMsgContent;
        config.inPolling = this.inPolling;
        if (config.isChatLock == 2 || config.isChatLock == 0) {
            Intent intent = new Intent();
            intent.setAction(ZhiChiConstants.SOBOT_TIMER_BROCAST);
            intent.putExtra("info", this.info);
            intent.putExtra("isStartTimer", true);
            this.localBroadcastManager.sendBroadcast(intent);
        }
    }

    private void sendMsgToRobot(ZhiChiMessageBase zhiChiMessageBase, int i, int i2, String str) {
        sendMsgToRobot(zhiChiMessageBase, i, i2, str, null);
    }

    private void sendMsgToRobot(ZhiChiMessageBase zhiChiMessageBase, int i, int i2, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            sendTextMessageToHandler(zhiChiMessageBase.getId(), zhiChiMessageBase.getContent(), this.handler, 2, i);
        } else {
            sendTextMessageToHandler(zhiChiMessageBase.getId(), str2, this.handler, 2, i);
        }
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        zhiChiReplyAnswer.setMsgType("0");
        zhiChiReplyAnswer.setMsg(zhiChiMessageBase.getContent());
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        zhiChiMessageBase.setSenderType("0");
        sendMessageWithLogic(zhiChiMessageBase.getId(), zhiChiMessageBase.getContent(), this.initModel, this.handler, this.current_client_model, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendVoiceMap(int i, String str) {
        if (i == 0) {
            sendVoiceMessageToHandler(str, this.mFileName, this.voiceTimeLongStr, 4, 0, this.handler);
        } else if (i == 2) {
            sendVoiceMessageToHandler(str, this.mFileName, this.voiceTimeLongStr, 0, 2, this.handler);
        } else {
            sendVoiceMessageToHandler(str, this.mFileName, this.voiceTimeLongStr, 2, 1, this.handler);
            sendVoice(str, this.voiceTimeLongStr, this.initModel.getCid(), this.initModel.getPartnerid(), this.mFileName, this.handler);
            this.lv_message.setSelection(this.messageAdapter.getCount());
        }
        gotoLastItem();
    }

    private void setPanelView(View view, int i) {
        View childAt;
        if ((view instanceof KPSwitchPanelLinearLayout) && (childAt = ((KPSwitchPanelLinearLayout) view).getChildAt(0)) != null && (childAt instanceof CustomeChattingPanel)) {
            CustomeChattingPanel customeChattingPanel = (CustomeChattingPanel) childAt;
            Bundle bundle = new Bundle();
            bundle.putInt("current_client_model", this.current_client_model);
            customeChattingPanel.setupView(i, bundle, this);
        }
    }

    private void setToolBar() {
        if (getView() == null) {
            return;
        }
        if (this.info != null && this.info.getTitleImgId() != 0) {
            this.relative.setBackgroundResource(this.info.getTitleImgId());
        }
        View view = getView();
        View findViewById = view.findViewById(getResId("sobot_layout_titlebar"));
        TextView textView = (TextView) view.findViewById(getResId("sobot_tv_left"));
        TextView textView2 = (TextView) view.findViewById(getResId("sobot_tv_right"));
        TextView textView3 = (TextView) view.findViewById(getResId("sobot_tv_close"));
        this.sobot_tv_close = textView3;
        textView3.setText(ResourceUtils.getResString(getSobotActivity(), "sobot_colse"));
        if (findViewById != null) {
            if (textView != null) {
                showLeftMenu(textView, getResDrawableId("sobot_icon_back_grey"), "");
                displayInNotch(textView);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        SobotChatFragment.this.onLeftMenuClick();
                    }
                });
            }
            if (textView2 != null) {
                if (-1 != SobotUIConfig.sobot_moreBtnImgId) {
                    showRightMenu(textView2, SobotUIConfig.sobot_moreBtnImgId, "");
                } else {
                    showRightMenu(textView2, getResDrawableId("sobot_delete_hismsg_selector"), "");
                }
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        SobotChatFragment.this.onRightMenuClick(view2);
                    }
                });
                if (SobotUIConfig.sobot_title_right_menu1_display) {
                    textView2.setVisibility(0);
                } else {
                    textView2.setVisibility(8);
                }
            }
            if (this.sobot_tv_close != null && this.info.isShowCloseBtn() && this.current_client_model == 302) {
                this.sobot_tv_close.setVisibility(0);
            }
        }
    }

    private void setupListView() {
        this.messageAdapter = new SobotMsgAdapter(getContext(), this.messageList, this);
        this.lv_message.setAdapter((BaseAdapter) this.messageAdapter);
        this.lv_message.setPullRefreshEnable(true);
        this.lv_message.setOnRefreshListenerHead(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAudioRecorder() {
        try {
            this.mFileName = SobotPathManager.getInstance().getVoiceDir() + "sobot_tmp.wav";
            String externalStorageState = Environment.getExternalStorageState();
            if (!externalStorageState.equals(Environment.MEDIA_MOUNTED)) {
                LogUtils.i("SD Card is not mounted,It is  " + externalStorageState + ".");
            }
            File parentFile = new File(this.mFileName).getParentFile();
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                LogUtils.i("Path to file could not be created");
            }
            ExtAudioRecorder instanse = ExtAudioRecorder.getInstanse(false);
            this.extAudioRecorder = instanse;
            instanse.setOutputFile(this.mFileName);
            this.extAudioRecorder.prepare();
            this.extAudioRecorder.start(new ExtAudioRecorder.AudioRecorderListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.40
                @Override // com.sobot.chat.utils.ExtAudioRecorder.AudioRecorderListener
                public void onHasPermission() {
                    SobotChatFragment sobotChatFragment = SobotChatFragment.this;
                    sobotChatFragment.hidePanelAndKeyboard(sobotChatFragment.mPanelRoot);
                    SobotChatFragment.this.editModelToVoice(0, "");
                    if (SobotChatFragment.this.btn_press_to_speak.getVisibility() == 0) {
                        SobotChatFragment.this.btn_press_to_speak.setVisibility(0);
                        SobotChatFragment.this.btn_press_to_speak.setClickable(true);
                        SobotChatFragment.this.btn_press_to_speak.setOnTouchListener(new PressToSpeakListen());
                        SobotChatFragment.this.btn_press_to_speak.setEnabled(true);
                        SobotChatFragment.this.txt_speak_content.setText(SobotChatFragment.this.getResString("sobot_press_say"));
                        SobotChatFragment.this.txt_speak_content.setVisibility(0);
                    }
                }

                @Override // com.sobot.chat.utils.ExtAudioRecorder.AudioRecorderListener
                public void onNoPermission() {
                    ToastUtil.showToast(SobotChatFragment.this.mAppContext, SobotChatFragment.this.getResString("sobot_no_record_audio_permission"));
                }
            });
            stopVoice();
        } catch (Exception e) {
            LogUtils.i("prepare() failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCaiToCustomerTip() {
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        zhiChiMessageBase.setSenderType("24");
        zhiChiMessageBase.setAction(ZhiChiConstant.action_remind_info_zhuanrengong);
        updateUiMessage(this.messageAdapter, zhiChiMessageBase);
        gotoLastItem();
    }

    private void showCustomerOfflineTip() {
        if (this.initModel.isAdminNoneLineFlag()) {
            ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
            zhiChiReplyAnswer.setMsgType(null);
            String admin_offline_title = ZCSobotApi.getCurrentInfoSetting(this.mAppContext) != null ? ZCSobotApi.getCurrentInfoSetting(this.mAppContext).getAdmin_offline_title() : "";
            if (!TextUtils.isEmpty(admin_offline_title)) {
                zhiChiReplyAnswer.setMsg(admin_offline_title);
            } else if (TextUtils.isEmpty(this.initModel.getAdminNonelineTitle())) {
                return;
            } else {
                zhiChiReplyAnswer.setMsg(this.initModel.getAdminNonelineTitle());
            }
            zhiChiReplyAnswer.setRemindType(1);
            ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
            zhiChiMessageBase.setSenderType("24");
            zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
            zhiChiMessageBase.setAction(ZhiChiConstant.action_remind_info_post_msg);
            updateUiMessage(this.messageAdapter, zhiChiMessageBase);
        }
    }

    private void showCustomerUanbleTip() {
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        zhiChiReplyAnswer.setMsgType(null);
        zhiChiReplyAnswer.setMsg(getResString("sobot_unable_transfer_to_customer_service"));
        zhiChiReplyAnswer.setRemindType(2);
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        zhiChiMessageBase.setSenderType("24");
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        zhiChiMessageBase.setAction(ZhiChiConstant.action_remind_info_post_msg);
        updateUiMessage(this.messageAdapter, zhiChiMessageBase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showData(List<ZhiChiHistoryMessageBase> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            List<ZhiChiMessageBase> content = list.get(i2).getContent();
            for (ZhiChiMessageBase zhiChiMessageBase : content) {
                zhiChiMessageBase.setSugguestionsFontColor(1);
                if (!"29".equals(zhiChiMessageBase.getAction()) && zhiChiMessageBase.getSdkMsg() != null) {
                    ZhiChiReplyAnswer answer = zhiChiMessageBase.getSdkMsg().getAnswer();
                    if (answer != null) {
                        if (answer.getMsgType() == null) {
                            answer.setMsgType("0");
                        }
                        if (!TextUtils.isEmpty(answer.getMsg()) && answer.getMsg().length() > 4) {
                            String replace = answer.getMsg().replace("&lt;/p&gt;", "<br>");
                            String str = replace;
                            if (replace.endsWith("<br>")) {
                                str = replace.substring(0, replace.length() - 4);
                            }
                            answer.setMsg(str);
                        }
                    }
                    if (!TextUtils.isEmpty(zhiChiMessageBase.getSenderType())) {
                        if (1 == Integer.parseInt(zhiChiMessageBase.getSenderType())) {
                            zhiChiMessageBase.setSenderName(TextUtils.isEmpty(zhiChiMessageBase.getSenderName()) ? this.initModel.getRobotName() : zhiChiMessageBase.getSenderName());
                            zhiChiMessageBase.setSenderFace(TextUtils.isEmpty(zhiChiMessageBase.getSenderFace()) ? this.initModel.getRobotLogo() : zhiChiMessageBase.getSenderFace());
                        }
                        zhiChiMessageBase.setAnswer(answer);
                        zhiChiMessageBase.setAnswerType(zhiChiMessageBase.getSdkMsg().getAnswerType());
                    }
                }
            }
            arrayList.addAll(content);
            i = i2 + 1;
        }
        if (arrayList.size() > 0) {
            if (this.mUnreadNum > 0) {
                ZhiChiMessageBase unreadMode = ChatUtils.getUnreadMode(this.mAppContext);
                unreadMode.setCid(((ZhiChiMessageBase) arrayList.get(arrayList.size() - 1)).getCid());
                arrayList.add(arrayList.size() - this.mUnreadNum < 0 ? 0 : arrayList.size() - this.mUnreadNum, unreadMode);
                updateFloatUnreadIcon();
                this.mUnreadNum = 0;
            }
            this.messageAdapter.addData(arrayList);
            this.messageAdapter.notifyDataSetChanged();
            this.lv_message.setSelection(arrayList.size());
        }
    }

    private void showEmotionBtn() {
        if (DisplayEmojiRules.getMapAll(this.mAppContext).size() > 0) {
            this.btn_emoticon_view.setVisibility(0);
        } else {
            this.btn_emoticon_view.setVisibility(8);
        }
    }

    private void showHint(String str) {
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        zhiChiMessageBase.setSenderType("24");
        zhiChiReplyAnswer.setMsg(str);
        zhiChiReplyAnswer.setRemindType(8);
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        zhiChiMessageBase.setAction(ZhiChiConstant.action_remind_no_service);
        updateUiMessage(this.messageAdapter, zhiChiMessageBase);
    }

    private void showInLineHint(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        updateUiMessage(this.messageAdapter, ChatUtils.getInLineHint(str));
        gotoLastItem();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInitError() {
        showLogicTitle("", null, false);
        this.loading_anim_view.setVisibility(8);
        this.txt_loading.setVisibility(8);
        this.textReConnect.setVisibility(0);
        this.icon_nonet.setVisibility(0);
        this.btn_reconnect.setVisibility(0);
        this.et_sendmessage.setVisibility(8);
        this.relative.setVisibility(8);
        this.welcome.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLeaveMsg() {
        LogUtils.i("仅人工，无客服在线");
        showLogicTitle(getResString("sobot_no_access"), null, false);
        setBottomView(6);
        this.mBottomViewtype = 6;
        if (isUserBlack()) {
            showCustomerUanbleTip();
        } else {
            showCustomerOfflineTip();
        }
        this.isSessionOver = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLogicTitle(String str, String str2, boolean z) {
        if (this.initModel != null) {
            String logicAvatar = ChatUtils.getLogicAvatar(this.mAppContext, z, str2, this.initModel.getCompanyLogo());
            boolean booleanData = SharedPreferencesUtil.getBooleanData(getContext(), ZhiChiConstant.SOBOT_CHAT_AVATAR_IS_SHOW, true);
            if (TextUtils.isEmpty(str2)) {
                booleanData = false;
            }
            setAvatar(logicAvatar, booleanData);
            String logicTitle = ChatUtils.getLogicTitle(this.mAppContext, z, str, this.initModel.getCompanyName());
            boolean booleanData2 = SharedPreferencesUtil.getBooleanData(getContext(), ZhiChiConstant.SOBOT_CHAT_TITLE_IS_SHOW, false);
            if (TextUtils.isEmpty(str2)) {
                booleanData2 = true;
            }
            setTitle(logicTitle, booleanData2);
        }
    }

    private void showNoHistory() {
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        zhiChiMessageBase.setSenderType("24");
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        zhiChiReplyAnswer.setRemindType(6);
        zhiChiReplyAnswer.setMsg("");
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        updateUiMessageBefore(this.messageAdapter, zhiChiMessageBase);
        this.lv_message.setSelection(0);
        this.lv_message.setPullRefreshEnable(false);
        this.isNoMoreHistoryMsg = true;
        this.mUnreadNum = 0;
    }

    private void showOutlineTip(ZhiChiInitModeBase zhiChiInitModeBase, int i) {
        String str;
        if (SobotOption.sobotChatStatusListener != null) {
            SobotOption.sobotChatStatusListener.onChatStatusListener(SobotChatStatusMode.ZCServerConnectOffline);
        }
        String messageContentByOutLineType = ChatUtils.getMessageContentByOutLineType(this.mAppContext, zhiChiInitModeBase, i);
        if (TextUtils.isEmpty(messageContentByOutLineType)) {
            return;
        }
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        zhiChiMessageBase.setSenderType("24");
        zhiChiReplyAnswer.setRemindType(5);
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        if (1 == i) {
            zhiChiMessageBase.setAction(ZhiChiConstant.sobot_outline_leverByManager);
            str = messageContentByOutLineType;
        } else if (2 == i) {
            str = messageContentByOutLineType.replace("#" + ResourceUtils.getResString(getContext(), "sobot_cus_service") + "#", this.currentUserName);
            zhiChiMessageBase.setAction(ZhiChiConstant.sobot_outline_leverByManager);
        } else if (3 == i) {
            zhiChiMessageBase.setAction(ZhiChiConstant.sobot_outline_leverByManager);
            str = messageContentByOutLineType;
            if (zhiChiInitModeBase != null) {
                zhiChiInitModeBase.setIsblack("1");
                str = messageContentByOutLineType;
            }
        } else if (5 == i) {
            zhiChiMessageBase.setAction(ZhiChiConstant.sobot_outline_leverByManager);
            str = messageContentByOutLineType;
        } else if (4 == i) {
            zhiChiMessageBase.setAction(ZhiChiConstant.action_remind_past_time);
            str = messageContentByOutLineType;
        } else if (6 == i) {
            zhiChiMessageBase.setAction(ZhiChiConstant.sobot_outline_leverByManager);
            str = messageContentByOutLineType;
        } else if (99 == i) {
            zhiChiMessageBase.setAction(ZhiChiConstant.sobot_outline_leverByManager);
            str = messageContentByOutLineType;
        } else if (9 == i) {
            zhiChiMessageBase.setAction(ZhiChiConstant.sobot_outline_leverByManager);
            str = messageContentByOutLineType;
        } else {
            zhiChiMessageBase.setAction(ZhiChiConstant.sobot_outline_leverByManager);
            str = messageContentByOutLineType;
        }
        zhiChiReplyAnswer.setMsg(str);
        updateUiMessage(this.messageAdapter, zhiChiMessageBase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRobotLayout() {
        if (this.initModel != null) {
            int i = this.type;
            if (i == 1) {
                setBottomView(0);
                this.mBottomViewtype = 0;
                showLogicTitle(this.initModel.getRobotName(), this.initModel.getRobotLogo(), false);
            } else if (i == 3 || i == 4) {
                setBottomView(1);
                this.mBottomViewtype = 1;
                showLogicTitle(this.initModel.getRobotName(), this.initModel.getRobotLogo(), false);
            } else if (i == 2) {
                setBottomView(2);
                this.mBottomViewtype = 2;
                showLogicTitle(getResString("sobot_connecting_customer_service"), null, false);
            }
            if (this.type != 2) {
                this.et_sendmessage.setRequestParams(this.initModel.getPartnerid(), this.initModel.getRobotid());
                this.et_sendmessage.setAutoCompleteEnable(true);
            }
        }
    }

    private void showRobotVoiceHint() {
        this.send_voice_robot_hint.setVisibility(this.current_client_model == 301 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSwitchRobotBtn() {
        int i = 8;
        if (this.initModel == null || this.type == 2 || this.current_client_model != 301) {
            this.sobot_ll_switch_robot.setVisibility(8);
            return;
        }
        LinearLayout linearLayout = this.sobot_ll_switch_robot;
        if (this.initModel.isRobotSwitchFlag()) {
            i = 0;
        }
        linearLayout.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTransferCustomer() {
        int i = this.showTimeVisiableCustomBtn + 1;
        this.showTimeVisiableCustomBtn = i;
        if (i >= this.info.getArtificialIntelligenceNum()) {
            this.btn_set_mode_rengong.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sobotCustomMenu() {
        if (this.initModel.isLableLinkFlag()) {
            final int dimens = (int) getDimens("sobot_layout_lable_margin_right");
            this.zhiChiApi.getLableInfoList(this, this.initModel.getPartnerid(), new StringResultCallBack<List<SobotLableInfoList>>() { // from class: com.sobot.chat.conversation.SobotChatFragment.41
                @Override // com.sobot.network.http.callback.StringResultCallBack
                public void onFailure(Exception exc, String str) {
                    if (SobotChatFragment.this.isActive()) {
                        SobotChatFragment.this.sobot_custom_menu.setVisibility(8);
                    }
                }

                @Override // com.sobot.network.http.callback.StringResultCallBack
                public void onSuccess(List<SobotLableInfoList> list) {
                    if (!SobotChatFragment.this.isActive()) {
                        return;
                    }
                    SobotChatFragment.this.sobot_custom_menu_linearlayout.removeAllViews();
                    if (list == null || list.size() <= 0) {
                        SobotChatFragment.this.sobot_custom_menu.setVisibility(8);
                        return;
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            SobotChatFragment.this.sobot_custom_menu.setVisibility(0);
                            return;
                        }
                        TextView textView = (TextView) View.inflate(SobotChatFragment.this.getContext(), SobotChatFragment.this.getResLayoutId("sobot_layout_lable"), null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.setMargins(0, 0, dimens, 0);
                        textView.setLayoutParams(layoutParams);
                        textView.setText(list.get(i2).getLableName());
                        textView.setTag(list.get(i2).getLableLink());
                        SobotChatFragment.this.sobot_custom_menu_linearlayout.addView(textView);
                        if (!TextUtils.isEmpty(textView.getTag() + "")) {
                            textView.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.41.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    Tracker.onClick(view);
                                    SobotChatFragment.this.hidePanelAndKeyboard(SobotChatFragment.this.mPanelRoot);
                                    if (SobotOption.hyperlinkListener != null) {
                                        HyperlinkListener hyperlinkListener = SobotOption.hyperlinkListener;
                                        hyperlinkListener.onUrlClick(view.getTag() + "");
                                        return;
                                    }
                                    if (SobotOption.newHyperlinkListener != null) {
                                        NewHyperlinkListener newHyperlinkListener = SobotOption.newHyperlinkListener;
                                        Activity sobotActivity = SobotChatFragment.this.getSobotActivity();
                                        if (newHyperlinkListener.onUrlClick(sobotActivity, view.getTag() + "")) {
                                            return;
                                        }
                                    }
                                    Intent intent = new Intent(SobotChatFragment.this.getContext(), WebViewActivity.class);
                                    intent.putExtra("url", view.getTag() + "");
                                    SobotChatFragment.this.getSobotActivity().startActivity(intent);
                                }
                            });
                        }
                        i = i2 + 1;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startMicAnimate() {
        this.mic_image_animate.setBackgroundResource(getResDrawableId("sobot_voice_animation"));
        this.animationDrawable = (AnimationDrawable) this.mic_image_animate.getBackground();
        this.mic_image_animate.post(new Runnable() { // from class: com.sobot.chat.conversation.SobotChatFragment.18
            @Override // java.lang.Runnable
            public void run() {
                SobotChatFragment.this.animationDrawable.start();
            }
        });
        this.recording_hint.setText(getResString("sobot_move_up_to_cancel"));
        this.recording_hint.setBackgroundResource(getResDrawableId("sobot_recording_text_hint_bg1"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startVoice() {
        try {
            stopVoice();
            this.mFileName = SobotPathManager.getInstance().getVoiceDir() + UUID.randomUUID().toString() + ".wav";
            if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                LogUtils.i("sd卡被卸载了");
            }
            File parentFile = new File(this.mFileName).getParentFile();
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                LogUtils.i("文件夹创建失败");
            }
            ExtAudioRecorder instanse = ExtAudioRecorder.getInstanse(false);
            this.extAudioRecorder = instanse;
            instanse.setOutputFile(this.mFileName);
            this.extAudioRecorder.prepare();
            this.extAudioRecorder.start(new ExtAudioRecorder.AudioRecorderListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.19
                @Override // com.sobot.chat.utils.ExtAudioRecorder.AudioRecorderListener
                public void onHasPermission() {
                    SobotChatFragment.this.startMicAnimate();
                    SobotChatFragment sobotChatFragment = SobotChatFragment.this;
                    sobotChatFragment.startVoiceTimeTask(sobotChatFragment.handler);
                    SobotChatFragment sobotChatFragment2 = SobotChatFragment.this;
                    sobotChatFragment2.sendVoiceMap(0, sobotChatFragment2.voiceMsgId);
                }

                @Override // com.sobot.chat.utils.ExtAudioRecorder.AudioRecorderListener
                public void onNoPermission() {
                    ToastUtil.showToast(SobotChatFragment.this.mAppContext, SobotChatFragment.this.getResString("sobot_no_record_audio_permission"));
                }
            });
        } catch (Exception e) {
            LogUtils.i("prepare() failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVoice() {
        try {
            if (this.extAudioRecorder != null) {
                stopVoiceTimeTask();
                this.extAudioRecorder.stop();
                this.extAudioRecorder.release();
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transfer2Custom(String str, String str2, String str3, boolean z, int i) {
        transfer2Custom(str, str2, str3, z, i, "", "", "0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transfer2Custom(String str, String str2, String str3, boolean z, int i, String str4, String str5, String str6) {
        if (isUserBlack()) {
            SobotConnCusParam sobotConnCusParam = new SobotConnCusParam();
            sobotConnCusParam.setKeyword(str2);
            sobotConnCusParam.setKeywordId(str3);
            sobotConnCusParam.setDocId(str4);
            sobotConnCusParam.setUnknownQuestion(str5);
            sobotConnCusParam.setActiveTransfer(str6);
            connectCustomerService(sobotConnCusParam, z);
        } else if (SobotOption.transferOperatorInterceptor != null) {
            SobotTransferOperatorParam sobotTransferOperatorParam = new SobotTransferOperatorParam();
            sobotTransferOperatorParam.setGroupId(str);
            sobotTransferOperatorParam.setKeyword(str2);
            sobotTransferOperatorParam.setKeywordId(str3);
            sobotTransferOperatorParam.setShowTips(z);
            sobotTransferOperatorParam.setTransferType(i);
            sobotTransferOperatorParam.setConsultingContent(this.info.getConsultingContent());
            SobotOption.transferOperatorInterceptor.onTransferStart(getContext(), sobotTransferOperatorParam);
        } else if (!TextUtils.isEmpty(this.info.getGroupid())) {
            SobotConnCusParam sobotConnCusParam2 = new SobotConnCusParam();
            sobotConnCusParam2.setGroupId(this.info.getGroupid());
            sobotConnCusParam2.setGroupName(this.info.getGroup_name());
            sobotConnCusParam2.setKeyword(str2);
            sobotConnCusParam2.setKeywordId(str3);
            sobotConnCusParam2.setDocId(str4);
            sobotConnCusParam2.setUnknownQuestion(str5);
            sobotConnCusParam2.setActiveTransfer(str6);
            transfer2CustomBySkillId(sobotConnCusParam2, i);
        } else if (!TextUtils.isEmpty(str)) {
            SobotConnCusParam sobotConnCusParam3 = new SobotConnCusParam();
            sobotConnCusParam3.setGroupId(str);
            sobotConnCusParam3.setGroupName("");
            sobotConnCusParam3.setKeyword(str2);
            sobotConnCusParam3.setKeywordId(str3);
            sobotConnCusParam3.setDocId(str4);
            sobotConnCusParam3.setUnknownQuestion(str5);
            sobotConnCusParam3.setTransferType(i);
            sobotConnCusParam3.setActiveTransfer(str6);
            transfer2CustomBySkillId(sobotConnCusParam3, i);
        } else if (this.initModel.getGroupflag().equals("1") && TextUtils.isEmpty(this.info.getChoose_adminid()) && !this.initModel.isSmartRouteInfoFlag() && TextUtils.isEmpty(this.info.getTransferAction())) {
            SobotConnCusParam sobotConnCusParam4 = new SobotConnCusParam();
            sobotConnCusParam4.setDocId(str4);
            sobotConnCusParam4.setUnknownQuestion(str5);
            sobotConnCusParam4.setKeyword(str2);
            sobotConnCusParam4.setKeywordId(str3);
            sobotConnCusParam4.setTransferType(i);
            sobotConnCusParam4.setActiveTransfer(str6);
            getGroupInfo(sobotConnCusParam4);
        } else {
            SobotConnCusParam sobotConnCusParam5 = new SobotConnCusParam();
            sobotConnCusParam5.setDocId(str4);
            sobotConnCusParam5.setUnknownQuestion(str5);
            sobotConnCusParam5.setKeyword(str2);
            sobotConnCusParam5.setKeywordId(str3);
            sobotConnCusParam5.setTransferType(i);
            sobotConnCusParam5.setActiveTransfer(str6);
            requestQueryFrom(sobotConnCusParam5, this.info.isCloseInquiryForm());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transfer2Custom(String str, String str2, String str3, boolean z, String str4) {
        transfer2Custom(str, str2, str3, z, 0, "", "", str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transfer2CustomBySkillId(SobotConnCusParam sobotConnCusParam, int i) {
        if (sobotConnCusParam != null) {
            requestQueryFrom(sobotConnCusParam, this.info.isCloseInquiryForm());
            return;
        }
        SobotConnCusParam sobotConnCusParam2 = new SobotConnCusParam();
        sobotConnCusParam2.setGroupId(this.info.getGroupid());
        sobotConnCusParam2.setGroupName(this.info.getGroup_name());
        sobotConnCusParam2.setTransferType(i);
        requestQueryFrom(sobotConnCusParam2, this.info.isCloseInquiryForm());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFloatUnreadIcon() {
        if (this.mUnreadNum < 10) {
            this.notReadInfo.setVisibility(8);
            return;
        }
        this.notReadInfo.setVisibility(0);
        TextView textView = this.notReadInfo;
        textView.setText(this.mUnreadNum + getResString("sobot_new_msg"));
    }

    @Override // com.sobot.chat.adapter.SobotMsgAdapter.SobotMsgCallBack
    public void addMessage(ZhiChiMessageBase zhiChiMessageBase) {
        if (zhiChiMessageBase != null) {
            this.messageAdapter.justAddData(zhiChiMessageBase);
            this.messageAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.sobot.chat.widget.kpswitch.view.ChattingPanelEmoticonView.SobotEmoticonClickListener
    public void backspace() {
        InputHelper.backspace(this.et_sendmessage);
    }

    @Override // com.sobot.chat.widget.kpswitch.view.ChattingPanelUploadView.SobotPlusClickListener
    public void btnCameraPicture() {
        hidePanelAndKeyboard(this.mPanelRoot);
        selectPicFromCamera();
        this.lv_message.setSelection(this.messageAdapter.getCount());
    }

    @Override // com.sobot.chat.widget.kpswitch.view.ChattingPanelUploadView.SobotPlusClickListener
    public void btnPicture() {
        hidePanelAndKeyboard(this.mPanelRoot);
        selectPicFromLocal();
        this.lv_message.setSelection(this.messageAdapter.getCount());
    }

    @Override // com.sobot.chat.widget.kpswitch.view.ChattingPanelUploadView.SobotPlusClickListener
    public void btnSatisfaction() {
        this.lv_message.setSelection(this.messageAdapter.getCount());
        submitEvaluation(true, 5, 0, "");
    }

    @Override // com.sobot.chat.widget.kpswitch.view.ChattingPanelUploadView.SobotPlusClickListener
    public void btnVedio() {
        hidePanelAndKeyboard(this.mPanelRoot);
        selectVedioFromLocal();
        this.lv_message.setSelection(this.messageAdapter.getCount());
    }

    @Override // com.sobot.chat.widget.kpswitch.view.ChattingPanelUploadView.SobotPlusClickListener
    public void chooseFile() {
        if ((Build.VERSION.SDK_INT < 30 || CommonUtils.getTargetSdkVersion(getSobotActivity().getApplicationContext()) < 30) && (checkIsShowPermissionPop(getResString("sobot_memory_card"), getResString("sobot_memory_card_yongtu"), 1) || !checkStoragePermission())) {
            return;
        }
        hidePanelAndKeyboard(this.mPanelRoot);
        startActivityForResult(new Intent(getSobotActivity(), SobotChooseFileActivity.class), 107);
    }

    public void clearHistory() {
        SobotClearHistoryMsgDialog sobotClearHistoryMsgDialog = this.clearHistoryMsgDialog;
        if (sobotClearHistoryMsgDialog != null) {
            sobotClearHistoryMsgDialog.show();
            return;
        }
        SobotClearHistoryMsgDialog sobotClearHistoryMsgDialog2 = new SobotClearHistoryMsgDialog(getSobotActivity(), new View.OnClickListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotChatFragment.this.clearHistoryMsgDialog.dismiss();
                if (view.getId() == ResourceUtils.getResId(SobotChatFragment.this.getContext(), "sobot_btn_cancle_conversation")) {
                    ZhiChiApi zhiChiApi = SobotChatFragment.this.zhiChiApi;
                    SobotChatFragment sobotChatFragment = SobotChatFragment.this;
                    zhiChiApi.deleteHisMsg(sobotChatFragment, sobotChatFragment.initModel.getPartnerid(), new StringResultCallBack<CommonModelBase>() { // from class: com.sobot.chat.conversation.SobotChatFragment.36.1
                        @Override // com.sobot.network.http.callback.StringResultCallBack
                        public void onFailure(Exception exc, String str) {
                        }

                        @Override // com.sobot.network.http.callback.StringResultCallBack
                        public void onSuccess(CommonModelBase commonModelBase) {
                            if (SobotChatFragment.this.isActive()) {
                                SobotChatFragment.this.messageList.clear();
                                SobotChatFragment.this.cids.clear();
                                SobotChatFragment.this.messageAdapter.notifyDataSetChanged();
                                SobotChatFragment.this.lv_message.setPullRefreshEnable(true);
                            }
                        }
                    });
                } else if (view.getId() == ResourceUtils.getResId(SobotChatFragment.this.getContext(), "sobot_btn_temporary_leave")) {
                    SobotChatFragment.this.clearHistoryMsgDialog.dismiss();
                }
            }
        });
        this.clearHistoryMsgDialog = sobotClearHistoryMsgDialog2;
        sobotClearHistoryMsgDialog2.show();
    }

    @Override // com.sobot.chat.adapter.SobotMsgAdapter.SobotMsgCallBack
    public void clickAudioItem(ZhiChiMessageBase zhiChiMessageBase) {
        if (this.mAudioPlayPresenter == null) {
            this.mAudioPlayPresenter = new AudioPlayPresenter(this.mAppContext);
        }
        if (this.mAudioPlayCallBack == null) {
            this.mAudioPlayCallBack = new AudioPlayCallBack() { // from class: com.sobot.chat.conversation.SobotChatFragment.27
                @Override // com.sobot.chat.voice.AudioPlayCallBack
                public void onPlayEnd(ZhiChiMessageBase zhiChiMessageBase2) {
                    SobotChatFragment.this.showVoiceAnim(zhiChiMessageBase2, false);
                    SobotChatFragment.this.abandonAudioFocus();
                }

                @Override // com.sobot.chat.voice.AudioPlayCallBack
                public void onPlayStart(ZhiChiMessageBase zhiChiMessageBase2) {
                    SobotChatFragment.this.showVoiceAnim(zhiChiMessageBase2, true);
                    SobotChatFragment.this.initAudioManager();
                    SobotChatFragment.this.requestAudioFocus();
                }
            };
        }
        this.mAudioPlayPresenter.clickAudio(zhiChiMessageBase, this.mAudioPlayCallBack);
    }

    public void closeVoiceWindows(int i) {
        Message obtainMessage = this.handler.obtainMessage();
        obtainMessage.what = 603;
        obtainMessage.arg1 = i;
        this.handler.sendMessageDelayed(obtainMessage, 500L);
    }

    @Override // com.sobot.chat.conversation.SobotChatBaseFragment
    protected void connectCustomerService(SobotConnCusParam sobotConnCusParam, final boolean z) {
        if (this.isConnCustomerService) {
            return;
        }
        this.isConnCustomerService = true;
        boolean z2 = true;
        if (this.customerState != CustomerState.Queuing) {
            z2 = this.customerState == CustomerState.Online;
        }
        SobotConnCusParam sobotConnCusParam2 = sobotConnCusParam;
        if (sobotConnCusParam == null) {
            sobotConnCusParam2 = new SobotConnCusParam();
        }
        sobotConnCusParam2.setChooseAdminId(this.info.getChoose_adminid());
        sobotConnCusParam2.setTran_flag(this.info.getTranReceptionistFlag());
        sobotConnCusParam2.setPartnerid(this.initModel.getPartnerid());
        sobotConnCusParam2.setCid(this.initModel.getCid());
        sobotConnCusParam2.setCurrentFlag(z2);
        sobotConnCusParam2.setTransferAction(this.info.getTransferAction());
        sobotConnCusParam2.setIs_Queue_First(this.info.is_queue_first());
        sobotConnCusParam2.setSummary_params(this.info.getSummary_params());
        sobotConnCusParam2.setOfflineMsgAdminId(this.offlineMsgAdminId);
        sobotConnCusParam2.setOfflineMsgConnectFlag(this.offlineMsgConnectFlag);
        SharedPreferencesUtil.saveStringData(getSobotActivity(), ZhiChiConstant.sobot_connect_group_id, sobotConnCusParam2.getGroupId());
        final String keyword = sobotConnCusParam2.getKeyword();
        final String keywordId = sobotConnCusParam2.getKeywordId();
        final String docId = sobotConnCusParam2.getDocId();
        final String unknownQuestion = sobotConnCusParam2.getUnknownQuestion();
        final String activeTransfer = sobotConnCusParam2.getActiveTransfer();
        final int transferType = sobotConnCusParam2.getTransferType();
        this.zhiChiApi.connnect(this, sobotConnCusParam2, new StringResultCallBack<ZhiChiMessageBase>() { // from class: com.sobot.chat.conversation.SobotChatFragment.23
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                LogUtils.i("connectCustomerService:e= " + exc.toString() + str);
                SobotChatFragment.this.isConnCustomerService = false;
                if (SobotChatFragment.this.messageAdapter != null && SobotChatFragment.this.keyWordMessageBase != null) {
                    SobotChatFragment.this.messageAdapter.justAddData(SobotChatFragment.this.keyWordMessageBase);
                    SobotChatFragment.this.keyWordMessageBase = null;
                }
                if (SobotChatFragment.this.isActive()) {
                    if (SobotChatFragment.this.type == 2) {
                        SobotChatFragment.this.setBottomView(6);
                        SobotChatFragment sobotChatFragment = SobotChatFragment.this;
                        sobotChatFragment.showLogicTitle(sobotChatFragment.getResString("sobot_no_access"), null, false);
                        SobotChatFragment.this.isSessionOver = true;
                    }
                    ToastUtil.showToast(SobotChatFragment.this.mAppContext, str);
                }
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(ZhiChiMessageBase zhiChiMessageBase) {
                LogUtils.i("connectCustomerService:zhichiMessageBase= " + zhiChiMessageBase);
                SobotChatFragment.this.isConnCustomerService = false;
                SobotChatFragment.this.offlineMsgAdminId = "";
                SobotChatFragment.this.offlineMsgConnectFlag = 0;
                if (SobotChatFragment.this.isActive()) {
                    if (!TextUtils.isEmpty(zhiChiMessageBase.getServiceEndPushMsg())) {
                        SobotChatFragment.this.initModel.setServiceEndPushMsg(zhiChiMessageBase.getServiceEndPushMsg());
                    }
                    int parseInt = Integer.parseInt(zhiChiMessageBase.getStatus());
                    int unused = SobotChatFragment.statusFlag = parseInt;
                    String unused2 = SobotChatFragment.preCurrentCid = SobotChatFragment.this.initModel.getCid();
                    SobotChatFragment.this.setAdminFace(zhiChiMessageBase.getAface());
                    LogUtils.i("status---:" + parseInt);
                    if (parseInt == 0) {
                        LogUtils.i("转人工--排队");
                        SobotChatFragment.this.zhiChiApi.connChannel(zhiChiMessageBase.getWslinkBak(), zhiChiMessageBase.getWslinkDefault(), SobotChatFragment.this.initModel.getPartnerid(), zhiChiMessageBase.getPuid(), SobotChatFragment.this.info.getApp_key(), zhiChiMessageBase.getWayHttp());
                        SobotChatFragment.this.customerState = CustomerState.Queuing;
                        SobotChatFragment.this.isShowQueueTip = z;
                        SobotChatFragment sobotChatFragment = SobotChatFragment.this;
                        sobotChatFragment.createCustomerQueue(zhiChiMessageBase.getCount() + "", parseInt, zhiChiMessageBase.getQueueDoc(), z);
                        if (CommonUtils.isServiceWork(SobotChatFragment.this.getSobotActivity(), "com.sobot.chat.core.channel.SobotTCPServer")) {
                            return;
                        }
                        LogUtils.i2Local("转人工排队 开启轮询", "tcpserver 没运行，直接走fragment 界面的轮询");
                        SobotMsgManager.getInstance(SobotChatFragment.this.getSobotActivity()).getZhiChiApi().disconnChannel();
                        SobotChatFragment.this.pollingMsgForOne();
                        SobotChatFragment.this.startPolling();
                    } else if (parseInt == 5) {
                        SobotChatFragment sobotChatFragment2 = SobotChatFragment.this;
                        sobotChatFragment2.customerServiceOffline(sobotChatFragment2.initModel, 4);
                    } else if (parseInt == 6) {
                        SobotChatFragment sobotChatFragment3 = SobotChatFragment.this;
                        sobotChatFragment3.showLogicTitle(sobotChatFragment3.initModel.getRobotName(), SobotChatFragment.this.initModel.getRobotLogo(), false);
                        SobotChatFragment.this.info.setChoose_adminid(null);
                        SobotChatFragment.this.initModel.setSmartRouteInfoFlag(false);
                        SobotChatFragment.this.transfer2Custom(null, keyword, keywordId, z, transferType, docId, unknownQuestion, activeTransfer);
                    } else if (1 == parseInt) {
                        SobotChatFragment.this.connCustomerServiceSuccess(zhiChiMessageBase);
                    } else if (2 == parseInt) {
                        if (SobotChatFragment.this.messageAdapter == null || SobotChatFragment.this.keyWordMessageBase == null) {
                            SobotChatFragment.this.connCustomerServiceFail(z);
                            return;
                        }
                        SobotChatFragment.this.messageAdapter.justAddData(SobotChatFragment.this.keyWordMessageBase);
                        SobotChatFragment.this.messageAdapter.notifyDataSetChanged();
                        SobotChatFragment.this.keyWordMessageBase = null;
                    } else if (3 == parseInt) {
                        if (SobotChatFragment.this.messageAdapter == null || SobotChatFragment.this.keyWordMessageBase == null) {
                            SobotChatFragment.this.connCustomerServiceBlack(z);
                            return;
                        }
                        SobotChatFragment.this.messageAdapter.justAddData(SobotChatFragment.this.keyWordMessageBase);
                        SobotChatFragment.this.messageAdapter.notifyDataSetChanged();
                        SobotChatFragment.this.keyWordMessageBase = null;
                    } else if (4 == parseInt) {
                        SobotChatFragment.this.connCustomerServiceSuccess(zhiChiMessageBase);
                    } else if (7 == parseInt) {
                        if (SobotChatFragment.this.type == 2) {
                            SobotChatFragment sobotChatFragment4 = SobotChatFragment.this;
                            sobotChatFragment4.showLogicTitle(sobotChatFragment4.getResString("sobot_wait_full"), null, true);
                            SobotChatFragment.this.setBottomView(6);
                            SobotChatFragment.this.mBottomViewtype = 6;
                        }
                        if (SobotChatFragment.this.initModel.getMsgFlag() == 0) {
                            if (TextUtils.isEmpty(zhiChiMessageBase.getMsg())) {
                                ToastUtil.showCustomToastWithListenr(SobotChatFragment.this.mAppContext, ResourceUtils.getResString(SobotChatFragment.this.mAppContext, "sobot_line_transfinite_def_hint"), m.ag, new ToastUtil.OnAfterShowListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.23.2
                                    @Override // com.sobot.chat.utils.ToastUtil.OnAfterShowListener
                                    public void doAfter() {
                                        SobotChatFragment.this.startToPostMsgActivty(false);
                                    }
                                });
                            } else {
                                ToastUtil.showCustomToastWithListenr(SobotChatFragment.this.mAppContext, zhiChiMessageBase.getMsg(), m.ag, new ToastUtil.OnAfterShowListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.23.1
                                    @Override // com.sobot.chat.utils.ToastUtil.OnAfterShowListener
                                    public void doAfter() {
                                        SobotChatFragment.this.startToPostMsgActivty(false);
                                    }
                                });
                            }
                        }
                        SobotChatFragment.this.showSwitchRobotBtn();
                    }
                }
            }
        });
    }

    @Override // com.sobot.chat.conversation.SobotChatBaseFragment
    public void customerServiceOffline(ZhiChiInitModeBase zhiChiInitModeBase, int i) {
        TextView textView;
        if (zhiChiInitModeBase == null) {
            return;
        }
        this.queueNum = 0;
        stopInputListener();
        stopUserInfoTimeTask();
        stopCustomTimeTask();
        this.customerState = CustomerState.Offline;
        showOutlineTip(zhiChiInitModeBase, i);
        setBottomView(4);
        this.sobot_custom_menu.setVisibility(8);
        this.mBottomViewtype = 4;
        if (Integer.parseInt(zhiChiInitModeBase.getType()) == 2) {
            if (1 == i) {
                showLogicTitle(getResString("sobot_no_access"), null, false);
            }
            if (9 == i && (textView = this.mTitleTextView) != null) {
                textView.setVisibility(8);
            }
        }
        if (6 == i) {
            LogUtils.i("打开新窗口");
        }
        this.isSessionOver = true;
        CommonUtils.sendLocalBroadcast(this.mAppContext, new Intent(Const.SOBOT_CHAT_USER_OUTLINE));
        stopPolling();
    }

    public void doClickTransferBtn() {
        hidePanelAndKeyboard(this.mPanelRoot);
        doEmoticonBtn2Blur();
        transfer2Custom((String) null, (String) null, (String) null, true, "1");
    }

    @Override // com.sobot.chat.adapter.SobotMsgAdapter.SobotMsgCallBack
    public void doClickTransferBtn(ZhiChiMessageBase zhiChiMessageBase) {
        hidePanelAndKeyboard(this.mPanelRoot);
        doEmoticonBtn2Blur();
        if (zhiChiMessageBase == null) {
            transfer2Custom((String) null, (String) null, (String) null, true, "1");
            return;
        }
        int transferType = zhiChiMessageBase.getTransferType();
        if (transferType == 0) {
            if (Integer.parseInt(zhiChiMessageBase.getAnswerType()) == 1) {
                transferType = 6;
            } else if (Integer.parseInt(zhiChiMessageBase.getAnswerType()) == 2) {
                transferType = 7;
            } else if (Integer.parseInt(zhiChiMessageBase.getAnswerType()) == 3) {
                transferType = 9;
            } else if (Integer.parseInt(zhiChiMessageBase.getAnswerType()) == 4) {
                transferType = 8;
            }
        }
        transfer2Custom(null, null, null, true, transferType, zhiChiMessageBase.getDocId(), zhiChiMessageBase.getOriginQuestion(), "1");
    }

    public void doEmoticonBtn2Blur() {
        this.btn_emoticon_view.setSelected(false);
    }

    public void doEmoticonBtn2Focus() {
        this.btn_emoticon_view.setSelected(true);
    }

    @Override // com.sobot.chat.adapter.SobotMsgAdapter.SobotMsgCallBack
    public void doEvaluate(boolean z, final ZhiChiMessageBase zhiChiMessageBase) {
        SobotEvaluateModel sobotEvaluateModel;
        if (this.initModel == null || zhiChiMessageBase == null || (sobotEvaluateModel = zhiChiMessageBase.getSobotEvaluateModel()) == null) {
            return;
        }
        if (!z) {
            submitEvaluation(false, sobotEvaluateModel.getScore(), sobotEvaluateModel.getIsResolved(), sobotEvaluateModel.getProblem());
            return;
        }
        SobotCommentParam sobotCommentParam = new SobotCommentParam();
        sobotCommentParam.setType("1");
        sobotCommentParam.setScore(zhiChiMessageBase.getSobotEvaluateModel().getScore() + "");
        sobotCommentParam.setScoreFlag(zhiChiMessageBase.getSobotEvaluateModel().getScoreFlag());
        sobotCommentParam.setCommentType(0);
        sobotCommentParam.setProblem(sobotEvaluateModel.getProblem());
        if (sobotEvaluateModel.getIsQuestionFlag() != 1) {
            sobotCommentParam.setIsresolve(-1);
        } else if (sobotEvaluateModel.getIsResolved() == -1) {
            sobotCommentParam.setIsresolve(0);
        } else {
            sobotCommentParam.setIsresolve(sobotEvaluateModel.getIsResolved());
        }
        this.zhiChiApi.comment(this, this.initModel.getCid(), this.initModel.getPartnerid(), sobotCommentParam, new StringResultCallBack<CommonModel>() { // from class: com.sobot.chat.conversation.SobotChatFragment.30
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(CommonModel commonModel) {
                if (SobotChatFragment.this.isActive()) {
                    Intent intent = new Intent();
                    intent.setAction(ZhiChiConstants.dcrc_comment_state);
                    intent.putExtra("commentState", true);
                    intent.putExtra("commentType", 0);
                    intent.putExtra(WBConstants.GAME_PARAMS_SCORE, zhiChiMessageBase.getSobotEvaluateModel().getScore());
                    intent.putExtra("isResolved", zhiChiMessageBase.getSobotEvaluateModel().getIsResolved());
                    CommonUtils.sendLocalBroadcast(SobotChatFragment.this.mAppContext, intent);
                }
            }
        });
    }

    @Override // com.sobot.chat.adapter.SobotMsgAdapter.SobotMsgCallBack
    public void doRevaluate(final boolean z, final ZhiChiMessageBase zhiChiMessageBase) {
        if (this.isSessionOver) {
            showOutlineTip(this.initModel, 1);
            CustomToast.makeText(this.mAppContext, getResString("sobot_ding_cai_sessionoff"), 1500).show();
            return;
        }
        CustomToast.makeText(this.mAppContext, getResString(z ? "sobot_ding_cai_like" : "sobot_ding_cai_dislike"), 1500).show();
        this.zhiChiApi.rbAnswerComment(this, zhiChiMessageBase.getMsgId(), this.initModel.getPartnerid(), this.initModel.getCid(), this.initModel.getRobotid(), zhiChiMessageBase.getDocId(), zhiChiMessageBase.getDocName(), z, zhiChiMessageBase.getOriginQuestion(), zhiChiMessageBase.getAnswerType(), new StringResultCallBack<CommonModelBase>() { // from class: com.sobot.chat.conversation.SobotChatFragment.29
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                ToastUtil.showToast(SobotChatFragment.this.mAppContext, ResourceUtils.getResString(SobotChatFragment.this.getContext(), "sobot_net_work_err"));
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(CommonModelBase commonModelBase) {
                if (SobotChatFragment.this.isActive()) {
                    zhiChiMessageBase.setRevaluateState(z ? 2 : 3);
                    SobotChatFragment.this.refreshItemByCategory(RichTextMessageHolder.class);
                    if (!TextUtils.isEmpty(zhiChiMessageBase.getAnswerType()) && zhiChiMessageBase.getAnswerType().startsWith("152")) {
                        SobotChatFragment.this.refreshItemByCategory(RobotTemplateMessageHolder1.class);
                        SobotChatFragment.this.refreshItemByCategory(RobotTemplateMessageHolder2.class);
                        SobotChatFragment.this.refreshItemByCategory(RobotTemplateMessageHolder3.class);
                        SobotChatFragment.this.refreshItemByCategory(RobotTemplateMessageHolder4.class);
                        SobotChatFragment.this.refreshItemByCategory(RobotTemplateMessageHolder5.class);
                        SobotChatFragment.this.refreshItemByCategory(RobotTemplateMessageHolder6.class);
                    }
                    if (SobotChatFragment.this.initModel.getRealuateTransferFlag() != 1 || SobotChatFragment.this.current_client_model == 302 || z || SobotChatFragment.this.type == 1) {
                        return;
                    }
                    ZhiChiApi zhiChiApi = SobotChatFragment.this.zhiChiApi;
                    SobotChatFragment sobotChatFragment = SobotChatFragment.this;
                    String cid = sobotChatFragment.initModel.getCid();
                    String partnerid = SobotChatFragment.this.initModel.getPartnerid();
                    zhiChiApi.insertSysMsg(sobotChatFragment, cid, partnerid, ResourceUtils.getResString(SobotChatFragment.this.getSobotActivity(), "sobot_cant_solve_problem") + ResourceUtils.getResString(SobotChatFragment.this.getSobotActivity(), "sobot_customer_service"), "点踩转人工提示", new StringResultCallBack<BaseCode>() { // from class: com.sobot.chat.conversation.SobotChatFragment.29.1
                        @Override // com.sobot.network.http.callback.StringResultCallBack
                        public void onFailure(Exception exc, String str) {
                        }

                        @Override // com.sobot.network.http.callback.StringResultCallBack
                        public void onSuccess(BaseCode baseCode) {
                            SobotChatFragment.this.showCaiToCustomerTip();
                        }
                    });
                }
            }
        });
    }

    public String getActivityTitle() {
        return this.mTitleTextView.getText().toString();
    }

    public void getHistoryMessage(boolean z) {
        if (this.initModel == null) {
            return;
        }
        int i = this.queryCidsStatus;
        if (i == 0 || i == 3) {
            onLoad();
            queryCids();
        } else if ((i == 1 && !z) || this.isInGethistory) {
            onLoad();
        } else {
            String currentCid = ChatUtils.getCurrentCid(this.initModel, this.cids, this.currentCidPosition);
            if ("-1".equals(currentCid)) {
                showNoHistory();
                onLoad();
                return;
            }
            this.isInGethistory = true;
            this.zhiChiApi.getChatDetailByCid(this, this.initModel.getPartnerid(), currentCid, new StringResultCallBack<ZhiChiHistoryMessage>() { // from class: com.sobot.chat.conversation.SobotChatFragment.38
                @Override // com.sobot.network.http.callback.StringResultCallBack
                public void onFailure(Exception exc, String str) {
                    SobotChatFragment.this.isInGethistory = false;
                    if (SobotChatFragment.this.isActive()) {
                        SobotChatFragment.this.mUnreadNum = 0;
                        SobotChatFragment.this.updateFloatUnreadIcon();
                        SobotChatFragment.this.onLoad();
                    }
                }

                @Override // com.sobot.network.http.callback.StringResultCallBack
                public void onSuccess(ZhiChiHistoryMessage zhiChiHistoryMessage) {
                    SobotChatFragment.this.isInGethistory = false;
                    if (SobotChatFragment.this.isActive()) {
                        SobotChatFragment.this.onLoad();
                        SobotChatFragment.access$7408(SobotChatFragment.this);
                        List<ZhiChiHistoryMessageBase> data = zhiChiHistoryMessage.getData();
                        if (data == null || data.size() <= 0) {
                            SobotChatFragment.this.getHistoryMessage(false);
                        } else {
                            SobotChatFragment.this.showData(data);
                        }
                    }
                }
            });
        }
    }

    @Override // com.sobot.chat.conversation.SobotChatBaseFragment
    protected String getSendMessageStr() {
        return this.et_sendmessage.getText().toString().trim();
    }

    public void hideItemTransferBtn() {
        if (isActive()) {
            this.lv_message.post(new Runnable() { // from class: com.sobot.chat.conversation.SobotChatFragment.25
                @Override // java.lang.Runnable
                public void run() {
                    int childCount = SobotChatFragment.this.lv_message.getChildCount();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= childCount) {
                            return;
                        }
                        View childAt = SobotChatFragment.this.lv_message.getChildAt(i2);
                        if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof RichTextMessageHolder)) {
                            RichTextMessageHolder richTextMessageHolder = (RichTextMessageHolder) childAt.getTag();
                            if (richTextMessageHolder.message != null) {
                                richTextMessageHolder.message.setShowTransferBtn(false);
                            }
                            richTextMessageHolder.hideTransferBtn();
                        }
                        i = i2 + 1;
                    }
                }
            });
        }
    }

    @Override // com.sobot.chat.adapter.SobotMsgAdapter.SobotMsgCallBack
    public void hidePanelAndKeyboard() {
        hidePanelAndKeyboard(this.mPanelRoot);
    }

    public void hidePanelAndKeyboard(KPSwitchPanelLinearLayout kPSwitchPanelLinearLayout) {
        if (kPSwitchPanelLinearLayout != null) {
            kPSwitchPanelLinearLayout.setVisibility(8);
        }
        this.et_sendmessage.dismissPop();
        KPSwitchConflictUtil.hidePanelAndKeyboard(kPSwitchPanelLinearLayout);
        doEmoticonBtn2Blur();
        this.currentPanelId = 0;
    }

    public void hideReLoading() {
        this.image_reLoading.clearAnimation();
        this.image_reLoading.setVisibility(8);
    }

    protected void initData() {
        boolean z;
        setToolBar();
        initBrocastReceiver();
        initListener();
        setupListView();
        loadUnreadNum();
        ZhiChiConfig config = SobotMsgManager.getInstance(this.mAppContext).getConfig(this.info.getApp_key());
        if (config != null && config.getInitModel() != null && !config.isAboveZero) {
            long longData = SharedPreferencesUtil.getLongData(getSobotActivity(), ZhiChiConstant.SOBOT_FINISH_CURTIME, System.currentTimeMillis());
            long currentTimeMillis = System.currentTimeMillis() - longData;
            if (!TextUtils.isEmpty(config.getInitModel().getUserOutTime()) && longData > 0) {
                long parseLong = Long.parseLong(config.getInitModel().getUserOutTime()) * 60 * 1000;
                z = currentTimeMillis - parseLong > 0;
                LogUtils.i("进入当前界面减去上次界面关闭的时间差：" + currentTimeMillis + " ms");
                LogUtils.i("用户超时时间：" + parseLong + " ms");
                StringBuilder sb = new StringBuilder();
                sb.append("是否需要重新初始化：");
                sb.append(z);
                LogUtils.i(sb.toString());
                initSdk(z, 1);
                Intent intent = new Intent();
                intent.setAction(ZhiChiConstants.SOBOT_TIMER_BROCAST);
                intent.putExtra("isStartTimer", false);
                this.localBroadcastManager.sendBroadcast(intent);
            }
        }
        z = false;
        initSdk(z, 1);
        Intent intent2 = new Intent();
        intent2.setAction(ZhiChiConstants.SOBOT_TIMER_BROCAST);
        intent2.putExtra("isStartTimer", false);
        this.localBroadcastManager.sendBroadcast(intent2);
    }

    @Override // com.sobot.chat.widget.kpswitch.view.ChattingPanelEmoticonView.SobotEmoticonClickListener
    public void inputEmoticon(EmojiconNew emojiconNew) {
        InputHelper.input2OSC(this.et_sendmessage, emojiconNew);
    }

    @Override // com.sobot.chat.adapter.SobotMsgAdapter.SobotMsgCallBack
    public void mulitDiaToLeaveMsg(String str) {
        if (this.mPostMsgPresenter != null) {
            hidePanelAndKeyboard();
            this.mPostMsgPresenter.obtainTmpConfigToMuItiPostMsg(this.initModel.getPartnerid(), str);
        }
    }

    @Override // com.sobot.chat.conversation.SobotChatBaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.info == null) {
            LogUtils.e("初始化参数不能为空");
            finish();
            return;
        }
        SharedPreferencesUtil.getStringData(getSobotActivity(), ZhiChiConstant.SOBOT_PLATFORM_UNIONCODE, "");
        if (TextUtils.isEmpty(this.info.getApp_key())) {
            LogUtils.e("您的AppKey为空");
            finish();
            return;
        }
        SharedPreferencesUtil.saveStringData(this.mAppContext, ZhiChiConstant.SOBOT_CURRENT_IM_APPID, this.info.getApp_key());
        ChatUtils.saveOptionSet(this.mAppContext, this.info);
        initData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            super.onActivityResult(i, i2, intent);
            LogUtils.i("多媒体返回的结果：" + i + "--" + i2 + "--" + intent);
            if (i2 == -1) {
                if (i == 701) {
                    if (intent == null || intent.getData() == null) {
                        ToastUtil.showLongToast(this.mAppContext, getResString("sobot_did_not_get_picture_path"));
                    } else {
                        Uri data = intent.getData();
                        Uri uri = data;
                        if (data == null) {
                            uri = ImageUtils.getUri(intent, getSobotActivity());
                        }
                        String path = ImageUtils.getPath(getSobotActivity(), uri);
                        if (MediaFileUtils.isVideoFileType(path)) {
                            MediaPlayer mediaPlayer = new MediaPlayer();
                            try {
                                mediaPlayer.setDataSource(getSobotActivity(), uri);
                                mediaPlayer.prepare();
                                if (mediaPlayer.getDuration() / 1000 > 15) {
                                    ToastUtil.showToast(getSobotActivity(), getResString("sobot_upload_vodie_length"));
                                    return;
                                }
                                File file = new File(path);
                                if (file.exists()) {
                                    uploadVideo(file, uri, this.messageAdapter);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            ChatUtils.sendPicByUri(this.mAppContext, this.handler, uri, this.initModel, this.lv_message, this.messageAdapter, false);
                        }
                    }
                }
                hidePanelAndKeyboard(this.mPanelRoot);
            }
            if (intent != null) {
                if (i == 100) {
                    boolean booleanExtra = intent.getBooleanExtra("toLeaveMsg", false);
                    int intExtra = intent.getIntExtra("groupIndex", -1);
                    if (booleanExtra) {
                        SharedPreferencesUtil.saveStringData(getSobotActivity(), ZhiChiConstant.sobot_connect_group_id, this.list_group != null ? this.list_group.get(intExtra).getGroupId() : "");
                        startToPostMsgActivty(false);
                        return;
                    }
                    int intExtra2 = intent.getIntExtra("transferType", 0);
                    LogUtils.i("groupIndex-->" + intExtra);
                    if (intExtra >= 0) {
                        String stringExtra = intent.getStringExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_DOCID);
                        String stringExtra2 = intent.getStringExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_UNKNOWNQUESTION);
                        String stringExtra3 = intent.getStringExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_ACTIVETRANSFER);
                        String stringExtra4 = intent.getStringExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_KEYWORD);
                        String stringExtra5 = intent.getStringExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_KEYWORD_ID);
                        SobotConnCusParam sobotConnCusParam = new SobotConnCusParam();
                        sobotConnCusParam.setGroupId(this.list_group.get(intExtra).getGroupId());
                        sobotConnCusParam.setGroupName(this.list_group.get(intExtra).getGroupName());
                        sobotConnCusParam.setTransferType(intExtra2);
                        sobotConnCusParam.setDocId(stringExtra);
                        sobotConnCusParam.setUnknownQuestion(stringExtra2);
                        sobotConnCusParam.setActiveTransfer(stringExtra3);
                        sobotConnCusParam.setKeyword(stringExtra4);
                        sobotConnCusParam.setKeywordId(stringExtra5);
                        requestQueryFrom(sobotConnCusParam, this.info.isCloseInquiryForm());
                    }
                } else if (i == 104) {
                    if (i2 != 104) {
                        this.isHasRequestQueryFrom = false;
                        if (this.type == 2) {
                            this.isSessionOver = true;
                            clearCache();
                            finish();
                            return;
                        }
                        return;
                    }
                    String stringExtra6 = intent.getStringExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_GROUPID);
                    String stringExtra7 = intent.getStringExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_GROUPNAME);
                    int intExtra3 = intent.getIntExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_TRANSFER_TYPE, 0);
                    String stringExtra8 = intent.getStringExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_DOCID);
                    String stringExtra9 = intent.getStringExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_UNKNOWNQUESTION);
                    String stringExtra10 = intent.getStringExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_ACTIVETRANSFER);
                    String stringExtra11 = intent.getStringExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_KEYWORD);
                    String stringExtra12 = intent.getStringExtra(ZhiChiConstant.SOBOT_INTENT_BUNDLE_DATA_KEYWORD_ID);
                    SobotConnCusParam sobotConnCusParam2 = new SobotConnCusParam();
                    sobotConnCusParam2.setGroupId(stringExtra6);
                    sobotConnCusParam2.setGroupName(stringExtra7);
                    sobotConnCusParam2.setTransferType(intExtra3);
                    sobotConnCusParam2.setDocId(stringExtra8);
                    sobotConnCusParam2.setUnknownQuestion(stringExtra9);
                    sobotConnCusParam2.setActiveTransfer(stringExtra10);
                    sobotConnCusParam2.setKeyword(stringExtra11);
                    sobotConnCusParam2.setKeywordId(stringExtra12);
                    connectCustomerService(sobotConnCusParam2);
                } else {
                    switch (i) {
                        case 107:
                            Uri data2 = intent.getData();
                            if (data2 == null) {
                                uploadFile((File) intent.getSerializableExtra(ZhiChiConstant.SOBOT_INTENT_DATA_SELECTED_FILE), this.handler, this.lv_message, this.messageAdapter, false);
                                return;
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            Uri uri2 = data2;
                            if (data2 == null) {
                                uri2 = ImageUtils.getUri(intent, getSobotActivity());
                            }
                            String path2 = ImageUtils.getPath(getSobotActivity(), uri2);
                            if (TextUtils.isEmpty(path2)) {
                                ToastUtil.showToast(getSobotActivity(), ResourceUtils.getResString(getSobotActivity(), "sobot_cannot_open_file"));
                                return;
                            }
                            File file2 = new File(path2);
                            LogUtils.i("tmpMsgId:" + String.valueOf(currentTimeMillis));
                            uploadFile(file2, this.handler, this.lv_message, this.messageAdapter, true);
                            return;
                        case 108:
                            if (SobotCameraActivity.getActionType(intent) != 1) {
                                File file3 = new File(SobotCameraActivity.getSelectedImage(intent));
                                if (file3.exists()) {
                                    ChatUtils.sendPicLimitBySize(file3.getAbsolutePath(), this.initModel.getCid(), this.initModel.getPartnerid(), this.handler, this.mAppContext, this.lv_message, this.messageAdapter, true);
                                    return;
                                } else {
                                    ToastUtil.showLongToast(this.mAppContext, getResString("sobot_pic_select_again"));
                                    return;
                                }
                            }
                            File file4 = new File(SobotCameraActivity.getSelectedVideo(intent));
                            if (!file4.exists()) {
                                ToastUtil.showLongToast(this.mAppContext, getResString("sobot_pic_select_again"));
                                return;
                            }
                            SobotCameraActivity.getSelectedImage(intent);
                            uploadVideo(file4, null, this.messageAdapter);
                            return;
                        case 109:
                            ZhiChiMessageBase leaveMsgTip = ChatUtils.getLeaveMsgTip(SobotPostLeaveMsgActivity.getResultContent(intent));
                            ZhiChiMessageBase tipByText = ChatUtils.getTipByText(ResourceUtils.getResString(getContext(), "sobot_leavemsg_success_tip"));
                            this.messageAdapter.justAddData(leaveMsgTip);
                            this.messageAdapter.justAddData(tipByText);
                            this.messageAdapter.notifyDataSetChanged();
                            customerServiceOffline(this.initModel, 99);
                            return;
                        default:
                            return;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onBackPress() {
        if (isActive()) {
            if (this.mPanelRoot.getVisibility() == 0) {
                hidePanelAndKeyboard(this.mPanelRoot);
            } else if (this.info.isShowSatisfaction() && this.isAboveZero && !this.isComment) {
                this.mEvaluateDialog = ChatUtils.showEvaluateDialog(getSobotActivity(), this.isSessionOver, true, false, this.initModel, this.current_client_model, 1, this.currentUserName, 5, 0, "", true, true);
            } else {
                finish();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SobotRobotListDialog sobotRobotListDialog;
        Tracker.onClick(view);
        if (view == this.notReadInfo) {
            int size = this.messageList.size();
            while (true) {
                int i = size - 1;
                if (i >= 0) {
                    if (this.messageList.get(i).getAnswer() != null && 7 == this.messageList.get(i).getAnswer().getRemindType()) {
                        this.lv_message.setSelection(i);
                        break;
                    }
                    size = i;
                } else {
                    break;
                }
            }
            this.notReadInfo.setVisibility(8);
        }
        if (view == this.btn_send) {
            String trim = this.et_sendmessage.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                this.et_sendmessage.setText("");
            }
            if (!TextUtils.isEmpty(trim) && !this.isConnCustomerService) {
                resetEmoticonBtn();
                try {
                    this.et_sendmessage.setText("");
                    sendMsg(trim);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (view == this.btn_upload_view) {
            LogUtils.i("-------点击加号-------");
            hideRobotVoiceHint();
            pressSpeakSwitchPanelAndKeyboard(this.btn_upload_view);
            doEmoticonBtn2Blur();
            gotoLastItem();
        }
        ImageButton imageButton = this.btn_emoticon_view;
        if (view == imageButton) {
            pressSpeakSwitchPanelAndKeyboard(imageButton);
            switchEmoticonBtn();
            gotoLastItem();
        }
        if (view == this.btn_model_edit) {
            hideRobotVoiceHint();
            doEmoticonBtn2Blur();
            KPSwitchConflictUtil.showKeyboard(this.mPanelRoot, this.et_sendmessage);
            editModelToVoice(8, "123");
        }
        if (view == this.btn_model_voice) {
            showRobotVoiceHint();
            doEmoticonBtn2Blur();
            this.permissionListener = new PermissionListenerImpl() { // from class: com.sobot.chat.conversation.SobotChatFragment.39
                @Override // com.sobot.chat.listener.PermissionListenerImpl, com.sobot.chat.listener.PermissionListener
                public void onPermissionSuccessListener() {
                    SobotChatFragment.this.showAudioRecorder();
                }
            };
            if (checkIsShowPermissionPop(getResString("sobot_microphone"), getResString("sobot_microphone_yongtu"), 2) || !checkAudioPermission()) {
                return;
            }
            showAudioRecorder();
        }
        if (view == this.sobot_ll_switch_robot && !this.isSessionOver && ((sobotRobotListDialog = this.mRobotListDialog) == null || !sobotRobotListDialog.isShowing())) {
            this.mRobotListDialog = ChatUtils.showRobotListDialog(getSobotActivity(), this.initModel, this);
        }
        if (view == this.sobot_tv_right_second) {
            if (TextUtils.isEmpty(SobotUIConfig.sobot_title_right_menu2_call_num)) {
                btnSatisfaction();
            } else {
                if (SobotOption.functionClickListener != null) {
                    SobotOption.functionClickListener.onClickFunction(getSobotActivity(), SobotFunctionType.ZC_PhoneCustomerService);
                }
                ChatUtils.callUp(SobotUIConfig.sobot_title_right_menu2_call_num, getContext());
            }
        }
        if (view == this.sobot_tv_right_third) {
            if (TextUtils.isEmpty(SobotUIConfig.sobot_title_right_menu3_call_num)) {
                LogUtils.e("电话号码不能为空");
                return;
            }
            if (SobotOption.functionClickListener != null) {
                SobotOption.functionClickListener.onClickFunction(getSobotActivity(), SobotFunctionType.ZC_PhoneCustomerService);
            }
            ChatUtils.callUp(SobotUIConfig.sobot_title_right_menu3_call_num, getContext());
        }
    }

    protected void onCloseMenuClick() {
        hidePanelAndKeyboard(this.mPanelRoot);
        if (isActive()) {
            if (!this.info.isShowCloseSatisfaction()) {
                customerServiceOffline(this.initModel, 1);
                ChatUtils.userLogout(this.mAppContext);
            } else if (this.isAboveZero && !this.isComment) {
                this.mEvaluateDialog = ChatUtils.showEvaluateDialog(getSobotActivity(), this.isSessionOver, true, true, this.initModel, this.current_client_model, 1, this.currentUserName, 5, 0, "", false, true);
                return;
            } else {
                customerServiceOffline(this.initModel, 1);
                ChatUtils.userLogout(this.mAppContext);
            }
            finish();
        }
    }

    @Override // com.sobot.chat.fragment.SobotBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        Serializable serializable;
        super.onCreate(bundle);
        LogUtils.i("onCreate");
        if (getArguments() == null || (bundle2 = getArguments().getBundle(ZhiChiConstant.SOBOT_BUNDLE_INFORMATION)) == null || (serializable = bundle2.getSerializable(ZhiChiConstant.SOBOT_BUNDLE_INFO)) == null || !(serializable instanceof Information)) {
            return;
        }
        this.info = (Information) serializable;
        SharedPreferencesUtil.saveObject(getSobotActivity(), ZhiChiConstant.sobot_last_current_info, this.info);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getResLayoutId("sobot_chat_fragment"), viewGroup, false);
        initView(inflate);
        return inflate;
    }

    @Override // com.sobot.chat.conversation.SobotChatBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (SobotOption.functionClickListener != null) {
            SobotOption.functionClickListener.onClickFunction(getSobotActivity(), SobotFunctionType.ZC_CloseChat);
        }
    }

    @Override // com.sobot.chat.fragment.SobotBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (!this.isAboveZero) {
            SharedPreferencesUtil.saveLongData(getSobotActivity(), ZhiChiConstant.SOBOT_FINISH_CURTIME, System.currentTimeMillis());
        }
        hideReLoading();
        try {
            if (getSobotActivity() != null) {
                getSobotActivity().unregisterReceiver(this.receiver);
                KeyboardUtil.detach(getSobotActivity(), this.mKPSwitchListener);
            }
            if (this.localBroadcastManager != null) {
                this.localBroadcastManager.unregisterReceiver(this.localReceiver);
            }
        } catch (Exception e) {
        }
        stopUserInfoTimeTask();
        stopCustomTimeTask();
        stopVoice();
        AudioTools.destory();
        SobotUpload.getInstance().unRegister();
        this.mPostMsgPresenter.destory();
        SobotEvaluateDialog sobotEvaluateDialog = this.mEvaluateDialog;
        if (sobotEvaluateDialog != null && sobotEvaluateDialog.isShowing()) {
            this.mEvaluateDialog.dismiss();
        }
        SobotRobotListDialog sobotRobotListDialog = this.mRobotListDialog;
        if (sobotRobotListDialog != null && sobotRobotListDialog.isShowing()) {
            this.mRobotListDialog.dismiss();
        }
        if (SobotOption.sobotViewListener != null) {
            SobotOption.sobotViewListener.onChatActClose(this.customerState);
        }
        super.onDestroyView();
    }

    protected void onLeftBackColseClick() {
        hidePanelAndKeyboard(this.mPanelRoot);
        if (isActive()) {
            if (!this.info.isShowSatisfaction()) {
                customerServiceOffline(this.initModel, 1);
                ChatUtils.userLogout(this.mAppContext);
            } else if (this.isAboveZero && !this.isComment) {
                this.mEvaluateDialog = ChatUtils.showEvaluateDialog(getSobotActivity(), this.isSessionOver, true, true, this.initModel, this.current_client_model, 1, this.currentUserName, 5, 0, "", false, true);
                return;
            } else {
                customerServiceOffline(this.initModel, 1);
                ChatUtils.userLogout(this.mAppContext);
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLeftMenuClick() {
        this.showTimeVisiableCustomBtn = 0;
        hidePanelAndKeyboard(this.mPanelRoot);
        if (this.isSessionOver || !this.info.isShowLeftBackPop()) {
            onBackPress();
            return;
        }
        SobotBackDialog sobotBackDialog = new SobotBackDialog(getSobotActivity(), new View.OnClickListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotChatFragment.this.sobotBackDialog.dismiss();
                if (view.getId() == ResourceUtils.getResId(SobotChatFragment.this.getContext(), "sobot_btn_cancle_conversation")) {
                    SobotChatFragment.this.onLeftBackColseClick();
                } else if (view.getId() == ResourceUtils.getResId(SobotChatFragment.this.getContext(), "sobot_btn_temporary_leave") && SobotChatFragment.this.isActive()) {
                    if (SobotChatFragment.this.mPanelRoot.getVisibility() != 0) {
                        SobotChatFragment.this.finish();
                        return;
                    }
                    SobotChatFragment sobotChatFragment = SobotChatFragment.this;
                    sobotChatFragment.hidePanelAndKeyboard(sobotChatFragment.mPanelRoot);
                }
            }
        });
        this.sobotBackDialog = sobotBackDialog;
        sobotBackDialog.show();
    }

    @Override // com.sobot.chat.fragment.SobotBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        if (this.initModel != null) {
            if (this.isSessionOver) {
                clearCache();
            } else {
                saveCache();
            }
            ChatUtils.saveLastMsgInfo(this.mAppContext, this.info, this.info.getApp_key(), this.initModel, this.messageList);
        }
        stopInputListener();
        if (AudioTools.getInstance().isPlaying()) {
            AudioTools.getInstance().stop();
            this.lv_message.post(new Runnable() { // from class: com.sobot.chat.conversation.SobotChatFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    VoiceMessageHolder voiceMessageHolder;
                    if (SobotChatFragment.this.info == null) {
                        return;
                    }
                    int childCount = SobotChatFragment.this.lv_message.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = SobotChatFragment.this.lv_message.getChildAt(i);
                        if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof VoiceMessageHolder) && (voiceMessageHolder = (VoiceMessageHolder) childAt.getTag()) != null) {
                            voiceMessageHolder.stopAnim();
                            voiceMessageHolder.checkBackground();
                        }
                    }
                }
            });
        }
        abandonAudioFocus();
        if (this._sensorManager != null) {
            this._sensorManager.unregisterListener(this);
            this._sensorManager = null;
        }
        if (this.mProximiny != null) {
            this.mProximiny = null;
        }
        super.onPause();
    }

    @Override // com.sobot.chat.widget.DropdownListView.OnRefreshListenerHeader
    public void onRefresh() {
        getHistoryMessage(false);
    }

    @Override // com.sobot.chat.conversation.SobotChatBaseFragment, com.sobot.chat.fragment.SobotBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.sobot_tv_close != null) {
            if (this.info.isShowCloseBtn() && this.current_client_model == 302) {
                this.sobot_tv_close.setVisibility(0);
            } else {
                this.sobot_tv_close.setVisibility(8);
            }
        }
        SharedPreferencesUtil.saveStringData(this.mAppContext, ZhiChiConstant.SOBOT_CURRENT_IM_APPID, this.info.getApp_key());
        Intent intent = new Intent(this.mAppContext, SobotSessionServer.class);
        intent.putExtra(ZhiChiConstant.SOBOT_CURRENT_IM_PARTNERID, this.info.getPartnerid());
        StServiceUtils.safeStartService(this.mAppContext, intent);
        SobotMsgManager.getInstance(this.mAppContext).getConfig(this.info.getApp_key()).clearCache();
        if (this.customerState == CustomerState.Online || this.customerState == CustomerState.Queuing) {
            long longData = SharedPreferencesUtil.getLongData(this.mAppContext, "sobot_scope_time", System.currentTimeMillis());
            if (longData == 0 || CommonUtils.isServiceWork(getSobotActivity(), "com.sobot.chat.core.channel.SobotTCPServer")) {
                this.zhiChiApi.reconnectChannel();
            } else if (System.currentTimeMillis() - longData > 1800000) {
                initSdk(true, 0);
            } else {
                this.zhiChiApi.reconnectChannel();
            }
        }
    }

    protected void onRightMenuClick(View view) {
        hidePanelAndKeyboard(this.mPanelRoot);
        ClearHistoryDialog clearHistoryDialog = new ClearHistoryDialog(getSobotActivity());
        clearHistoryDialog.setCanceledOnTouchOutside(true);
        clearHistoryDialog.setOnClickListener(new ClearHistoryDialog.DialogOnClickListener() { // from class: com.sobot.chat.conversation.SobotChatFragment.35
            @Override // com.sobot.chat.widget.ClearHistoryDialog.DialogOnClickListener
            public void onSure() {
                SobotChatFragment.this.clearHistory();
            }
        });
        clearHistoryDialog.show();
    }

    @Override // com.sobot.chat.widget.ContainsEmojiEditText.SobotAutoCompleteListener
    public void onRobotGuessComplete(String str) {
        this.et_sendmessage.setText("");
        sendMsg(str);
    }

    @Override // com.sobot.chat.widget.dialog.SobotRobotListDialog.SobotRobotListListener
    public void onSobotRobotListItemClick(SobotRobot sobotRobot) {
        int i;
        if (this.initModel == null || sobotRobot == null) {
            return;
        }
        this.initModel.setGuideFlag(sobotRobot.getGuideFlag());
        this.initModel.setRobotid(sobotRobot.getRobotFlag());
        this.initModel.setRobotLogo(sobotRobot.getRobotLogo());
        this.initModel.setRobotName(sobotRobot.getRobotName());
        this.initModel.setRobotHelloWord(sobotRobot.getRobotHelloWord());
        showLogicTitle(this.initModel.getRobotName(), this.initModel.getRobotLogo(), false);
        List<ZhiChiMessageBase> datas = this.messageAdapter.getDatas();
        int size = datas.size() - 1;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (size < 0) {
                break;
            }
            if (!BaseWrapper.ENTER_ID_TOOLKIT.equals(datas.get(size).getSenderType()) && !"29".equals(datas.get(size).getSenderType())) {
                i = i3;
                if (!"27".equals(datas.get(size).getSenderType())) {
                    continue;
                    size--;
                    i2 = i;
                }
            }
            datas.remove(size);
            int i4 = i3 + 1;
            i = i4;
            if (i4 >= 3) {
                break;
            }
            size--;
            i2 = i;
        }
        this.messageAdapter.notifyDataSetChanged();
        this.remindRobotMessageTimes = 0;
        remindRobotMessage(this.handler, this.initModel, this.info);
    }

    public void pressSpeakSwitchPanelAndKeyboard(View view) {
        if (!this.btn_press_to_speak.isShown()) {
            switchPanelAndKeyboard(this.mPanelRoot, view, this.et_sendmessage);
            return;
        }
        this.btn_model_edit.setVisibility(8);
        showVoiceBtn();
        this.btn_press_to_speak.setVisibility(8);
        this.edittext_layout.setVisibility(0);
        this.et_sendmessage.requestFocus();
        KPSwitchConflictUtil.showPanel(this.mPanelRoot);
        setPanelView(this.mPanelRoot, view.getId());
        this.currentPanelId = view.getId();
    }

    @Override // com.sobot.chat.adapter.SobotMsgAdapter.SobotMsgCallBack
    public void removeMessageByMsgId(String str) {
        if (this.messageAdapter == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.messageAdapter.removeByMsgId(str);
        this.messageAdapter.notifyDataSetChanged();
    }

    public void resetEmoticonBtn() {
        String panelViewTag = getPanelViewTag(this.mPanelRoot);
        String instanceTag = CustomeViewFactory.getInstanceTag(this.mAppContext, this.btn_emoticon_view.getId());
        if (this.mPanelRoot.getVisibility() == 0 && instanceTag.equals(panelViewTag)) {
            doEmoticonBtn2Focus();
        } else {
            doEmoticonBtn2Blur();
        }
    }

    protected void sendCardMsg(ConsultingContent consultingContent) {
        if (this.initModel == null || consultingContent == null) {
            return;
        }
        String sobotGoodsTitle = consultingContent.getSobotGoodsTitle();
        String sobotGoodsFromUrl = consultingContent.getSobotGoodsFromUrl();
        if (this.customerState != CustomerState.Online || this.current_client_model != 302 || TextUtils.isEmpty(sobotGoodsFromUrl) || TextUtils.isEmpty(sobotGoodsTitle)) {
            return;
        }
        setTimeTaskMethod(this.handler);
        sendHttpCardMsg(this.initModel.getPartnerid(), this.initModel.getCid(), this.handler, System.currentTimeMillis() + "", consultingContent);
    }

    @Override // com.sobot.chat.adapter.SobotMsgAdapter.SobotMsgCallBack
    public void sendConsultingContent() {
        sendCardMsg(this.info.getConsultingContent());
    }

    @Override // com.sobot.chat.adapter.SobotMsgAdapter.SobotMsgCallBack
    public void sendMessage(String str) {
        sendMsg(str);
    }

    @Override // com.sobot.chat.adapter.SobotMsgAdapter.SobotMsgCallBack
    public void sendMessageToRobot(ZhiChiMessageBase zhiChiMessageBase, int i, int i2, String str) {
        sendMessageToRobot(zhiChiMessageBase, i, i2, str, null);
    }

    @Override // com.sobot.chat.adapter.SobotMsgAdapter.SobotMsgCallBack
    public void sendMessageToRobot(ZhiChiMessageBase zhiChiMessageBase, int i, int i2, String str, String str2) {
        if (i == 5) {
            sendLocation(zhiChiMessageBase.getId(), zhiChiMessageBase.getAnswer().getLocationData(), this.handler, false);
        }
        if (i == 4) {
            sendMsgToRobot(zhiChiMessageBase, 0, i2, str, str2);
        } else if (i == 3) {
            this.messageAdapter.updatePicStatusById(zhiChiMessageBase.getId(), zhiChiMessageBase.getSendSuccessState());
            this.messageAdapter.notifyDataSetChanged();
            ChatUtils.sendPicture(this.mAppContext, this.initModel.getCid(), this.initModel.getPartnerid(), zhiChiMessageBase.getContent(), this.handler, zhiChiMessageBase.getId(), this.lv_message, this.messageAdapter);
        } else if (i == 2) {
            sendVoiceMessageToHandler(zhiChiMessageBase.getId(), zhiChiMessageBase.getContent(), zhiChiMessageBase.getAnswer().getDuration(), 2, 1, this.handler);
            sendVoice(zhiChiMessageBase.getId(), zhiChiMessageBase.getAnswer().getDuration(), this.initModel.getCid(), this.initModel.getPartnerid(), zhiChiMessageBase.getContent(), this.handler);
        } else if (i == 1) {
            sendMsgToRobot(zhiChiMessageBase, 1, i2, str);
        } else if (i == 0) {
            if (this.isSessionOver) {
                showOutlineTip(this.initModel, 1);
            } else {
                ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
                zhiChiReplyAnswer.setMsgType("0");
                zhiChiReplyAnswer.setMsg(zhiChiMessageBase.getContent());
                zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
                zhiChiMessageBase.setSenderType("0");
                if (zhiChiMessageBase.getId() == null || TextUtils.isEmpty(zhiChiMessageBase.getId())) {
                    zhiChiMessageBase.setId(System.currentTimeMillis() + "");
                    updateUiMessage(this.messageAdapter, zhiChiMessageBase);
                }
                sendMessageWithLogic(zhiChiMessageBase.getId(), zhiChiMessageBase.getContent(), this.initModel, this.handler, this.current_client_model, i2, str);
            }
        }
        gotoLastItem();
    }

    @Override // com.sobot.chat.conversation.SobotChatBaseFragment
    protected void sendMsg(String str) {
        if (this.initModel == null) {
            return;
        }
        String str2 = System.currentTimeMillis() + "";
        if (301 == this.current_client_model) {
            if (this.type == 4 && this.initModel.getInvalidSessionFlag() == 1 && this.customerState != CustomerState.Queuing && TextUtils.isEmpty(this.tempMsgContent)) {
                this.tempMsgContent = str;
                doClickTransferBtn();
                return;
            }
            int i = this.type;
            if (i == 2) {
                if (this.initModel.getInvalidSessionFlag() == 1) {
                    this.tempMsgContent = str;
                }
                doClickTransferBtn();
                return;
            } else if ((i == 3 || i == 4) && this.info.getTransferKeyWord() != null) {
                HashSet<String> transferKeyWord = this.info.getTransferKeyWord();
                if (!TextUtils.isEmpty(str) && transferKeyWord.contains(str)) {
                    sendTextMessageToHandler(str2, str, this.handler, 1, 0);
                    doClickTransferBtn();
                    return;
                }
            }
        }
        sendTextMessageToHandler(str2, str, this.handler, 2, 0);
        LogUtils.i("当前发送消息模式：" + this.current_client_model);
        setTimeTaskMethod(this.handler);
        sendMessageWithLogic(str2, str, this.initModel, this.handler, this.current_client_model, 0, "");
    }

    protected void sendOrderCardMsg(OrderCardContentModel orderCardContentModel) {
        if (this.initModel == null || orderCardContentModel == null) {
            return;
        }
        String orderCode = orderCardContentModel.getOrderCode();
        if (this.customerState == CustomerState.Online && this.current_client_model == 302 && !TextUtils.isEmpty(orderCode)) {
            setTimeTaskMethod(this.handler);
            sendHttpOrderCardMsg(this.initModel.getPartnerid(), this.initModel.getCid(), this.handler, System.currentTimeMillis() + "", orderCardContentModel);
        }
    }

    public void sendVoiceTimeTask(Handler handler) {
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = 1000;
        int i = this.voiceTimerLong + 500;
        this.voiceTimerLong = i;
        obtainMessage.obj = Integer.valueOf(i);
        handler.sendMessage(obtainMessage);
    }

    public void setAvatar(int i, boolean z) {
        if (!z) {
            this.mAvatarIV.setVisibility(8);
            return;
        }
        this.mAvatarIV.setVisibility(0);
        this.mAvatarIV.setRoundAsCircle(true);
        this.mAvatarIV.setStrokeWidth(ScreenUtils.dip2px(getContext(), 0.4f));
        this.mAvatarIV.setStrokeColor(ResourceUtils.getResColorValue(getContext(), "sobot_line_1dp"));
        SobotBitmapUtil.display(getContext(), i, this.mAvatarIV);
    }

    public void setAvatar(String str, boolean z) {
        if (!z) {
            this.mAvatarIV.setVisibility(8);
            return;
        }
        this.mAvatarIV.setVisibility(0);
        this.mAvatarIV.setRoundAsCircle(true);
        this.mAvatarIV.setStrokeWidth(ScreenUtils.dip2px(getContext(), 0.4f));
        this.mAvatarIV.setStrokeColor(ResourceUtils.getResColorValue(getContext(), "sobot_line_1dp"));
        if (TextUtils.isEmpty(str)) {
            SobotBitmapUtil.display(getContext(), getResDrawableId("sobot_robot"), this.mAvatarIV);
        } else {
            SobotBitmapUtil.display(getContext(), str, this.mAvatarIV);
        }
    }

    public void setBottomView(int i) {
        this.welcome.setVisibility(8);
        this.relative.setVisibility(0);
        this.chat_main.setVisibility(0);
        this.et_sendmessage.setVisibility(0);
        this.sobot_ll_restart_talk.setVisibility(8);
        this.sobot_ll_bottom.setVisibility(0);
        if (isUserBlack()) {
            this.sobot_ll_restart_talk.setVisibility(8);
            this.sobot_ll_bottom.setVisibility(0);
            this.btn_model_voice.setVisibility(8);
            this.btn_emoticon_view.setVisibility(8);
        }
        if (this.info.isHideMenuSatisfaction()) {
            this.sobot_tv_satisfaction.setVisibility(8);
        } else {
            this.sobot_tv_satisfaction.setVisibility(0);
        }
        this.sobot_txt_restart_talk.setVisibility(0);
        this.sobot_tv_message.setVisibility(0);
        LogUtils.i("setBottomView:" + i);
        switch (i) {
            case 0:
                showVoiceBtn();
                if (this.image_reLoading.getVisibility() == 0) {
                    this.sobot_ll_bottom.setVisibility(0);
                    this.edittext_layout.setVisibility(0);
                    this.sobot_ll_restart_talk.setVisibility(8);
                    if (this.btn_press_to_speak.getVisibility() == 0) {
                        this.btn_press_to_speak.setVisibility(8);
                    }
                    this.btn_set_mode_rengong.setClickable(false);
                    this.btn_set_mode_rengong.setVisibility(8);
                }
                this.btn_emoticon_view.setVisibility(8);
                this.btn_upload_view.setVisibility(0);
                this.btn_send.setVisibility(8);
                break;
            case 1:
                if (!this.info.isArtificialIntelligence() || this.type != 3) {
                    this.btn_set_mode_rengong.setVisibility(0);
                } else if (this.showTimeVisiableCustomBtn >= this.info.getArtificialIntelligenceNum()) {
                    this.btn_set_mode_rengong.setVisibility(0);
                } else {
                    this.btn_set_mode_rengong.setVisibility(8);
                }
                this.btn_set_mode_rengong.setClickable(true);
                showVoiceBtn();
                if (Build.VERSION.SDK_INT >= 11) {
                    this.btn_set_mode_rengong.setAlpha(1.0f);
                }
                if (this.image_reLoading.getVisibility() == 0) {
                    this.sobot_ll_bottom.setVisibility(0);
                    this.edittext_layout.setVisibility(0);
                    this.sobot_ll_restart_talk.setVisibility(8);
                    if (this.btn_press_to_speak.getVisibility() == 0) {
                        this.btn_press_to_speak.setVisibility(8);
                    }
                    this.btn_set_mode_rengong.setClickable(true);
                    this.btn_set_mode_rengong.setEnabled(true);
                }
                this.btn_upload_view.setVisibility(0);
                this.btn_emoticon_view.setVisibility(8);
                this.btn_send.setVisibility(8);
                break;
            case 2:
                hideRobotVoiceHint();
                this.btn_model_edit.setVisibility(8);
                this.btn_set_mode_rengong.setVisibility(8);
                this.btn_upload_view.setVisibility(0);
                this.btn_send.setVisibility(8);
                showEmotionBtn();
                showVoiceBtn();
                this.btn_model_voice.setEnabled(true);
                this.btn_model_voice.setClickable(true);
                this.btn_upload_view.setEnabled(true);
                this.btn_upload_view.setClickable(true);
                this.btn_emoticon_view.setClickable(true);
                this.btn_emoticon_view.setEnabled(true);
                if (Build.VERSION.SDK_INT >= 11) {
                    this.btn_model_voice.setAlpha(1.0f);
                    this.btn_upload_view.setAlpha(1.0f);
                }
                this.edittext_layout.setVisibility(0);
                this.sobot_ll_bottom.setVisibility(0);
                this.btn_press_to_speak.setVisibility(8);
                this.btn_press_to_speak.setClickable(true);
                this.btn_press_to_speak.setEnabled(true);
                this.txt_speak_content.setText(getResString("sobot_press_say"));
                break;
            case 3:
                onlyCustomPaidui();
                hidePanelAndKeyboard(this.mPanelRoot);
                if (this.lv_message.getLastVisiblePosition() != this.messageAdapter.getCount()) {
                    this.lv_message.setSelection(this.messageAdapter.getCount());
                    break;
                }
                break;
            case 4:
                hideReLoading();
                hidePanelAndKeyboard(this.mPanelRoot);
                this.sobot_ll_bottom.setVisibility(8);
                this.sobot_ll_restart_talk.setVisibility(0);
                if (this.info.isHideMenuSatisfaction()) {
                    this.sobot_tv_satisfaction.setVisibility(8);
                } else if (this.isAboveZero) {
                    this.sobot_tv_satisfaction.setVisibility(0);
                } else {
                    this.sobot_tv_satisfaction.setVisibility(8);
                }
                this.sobot_txt_restart_talk.setVisibility(0);
                this.btn_model_edit.setVisibility(8);
                if (this.info.isHideMenuLeave()) {
                    this.sobot_tv_message.setVisibility(8);
                } else {
                    TextView textView = this.sobot_tv_message;
                    int i2 = 0;
                    if (this.initModel.getMsgFlag() == 1) {
                        i2 = 8;
                    }
                    textView.setVisibility(i2);
                }
                this.btn_model_voice.setVisibility(8);
                this.lv_message.setSelection(this.messageAdapter.getCount());
                break;
            case 5:
                if (this.btn_press_to_speak.getVisibility() == 8) {
                    showVoiceBtn();
                }
                this.btn_set_mode_rengong.setVisibility(0);
                this.btn_emoticon_view.setVisibility(8);
                if (this.image_reLoading.getVisibility() == 0) {
                    this.sobot_ll_bottom.setVisibility(0);
                    this.edittext_layout.setVisibility(0);
                    this.btn_model_voice.setVisibility(8);
                    this.sobot_ll_restart_talk.setVisibility(8);
                    if (this.btn_press_to_speak.getVisibility() == 0) {
                        this.btn_press_to_speak.setVisibility(8);
                        break;
                    }
                }
                break;
            case 6:
                this.sobot_ll_restart_talk.setVisibility(0);
                this.sobot_ll_bottom.setVisibility(8);
                if (this.image_reLoading.getVisibility() == 0) {
                    this.sobot_txt_restart_talk.setVisibility(0);
                    this.sobot_txt_restart_talk.setClickable(true);
                    this.sobot_txt_restart_talk.setEnabled(true);
                }
                if (this.initModel.getMsgFlag() != 1) {
                    this.sobot_tv_satisfaction.setVisibility(8);
                    this.sobot_tv_message.setVisibility(0);
                    break;
                } else {
                    this.sobot_tv_satisfaction.setVisibility(4);
                    this.sobot_tv_message.setVisibility(4);
                    break;
                }
        }
        hideReLoading();
    }

    public void setShowNetRemind(boolean z) {
        this.net_status_remide.setVisibility(z ? 0 : 8);
    }

    public void setTitle(CharSequence charSequence, boolean z) {
        if (z) {
            this.mTitleTextView.setVisibility(0);
        } else {
            this.mTitleTextView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.mTitleTextView.setText(charSequence);
        }
        applyTitleTextColor(this.mTitleTextView);
    }

    public void showVoiceAnim(final ZhiChiMessageBase zhiChiMessageBase, final boolean z) {
        if (isActive()) {
            this.lv_message.post(new Runnable() { // from class: com.sobot.chat.conversation.SobotChatFragment.28
                @Override // java.lang.Runnable
                public void run() {
                    if (zhiChiMessageBase == null) {
                        return;
                    }
                    int childCount = SobotChatFragment.this.lv_message.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = SobotChatFragment.this.lv_message.getChildAt(i);
                        if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof VoiceMessageHolder)) {
                            VoiceMessageHolder voiceMessageHolder = (VoiceMessageHolder) childAt.getTag();
                            voiceMessageHolder.stopAnim();
                            if (voiceMessageHolder.message == zhiChiMessageBase && z) {
                                voiceMessageHolder.startAnim();
                            }
                        }
                    }
                }
            });
        }
    }

    public void showVoiceBtn() {
        int i = 0;
        if (this.current_client_model != 301 || this.type == 2) {
            this.view_model_split.setVisibility(8);
            ImageButton imageButton = this.btn_model_voice;
            if (!this.info.isUseVoice()) {
                i = 8;
            }
            imageButton.setVisibility(i);
            return;
        }
        this.btn_model_voice.setVisibility((this.info.isUseVoice() && this.info.isUseRobotVoice()) ? 0 : 8);
        this.view_model_split.setVisibility((this.info.isUseVoice() && this.info.isUseRobotVoice()) ? 0 : 8);
        if (this.type == 1) {
            this.view_model_split.setVisibility(8);
        }
    }

    @Override // com.sobot.chat.widget.kpswitch.view.ChattingPanelUploadView.SobotPlusClickListener
    public void startToPostMsgActivty(boolean z) {
        startToPostMsgActivty(z, false);
    }

    public void startToPostMsgActivty(final boolean z, final boolean z2) {
        if (this.initModel == null) {
            return;
        }
        if (SobotOption.sobotLeaveMsgListener != null) {
            SobotOption.sobotLeaveMsgListener.onLeaveMsg();
            return;
        }
        hidePanelAndKeyboard();
        if (this.initModel.isMsgToTicketFlag()) {
            startActivityForResult(SobotPostLeaveMsgActivity.newIntent(getContext(), this.initModel.getMsgLeaveTxt(), this.initModel.getMsgLeaveContentTxt(), this.initModel.getPartnerid()), 109);
            return;
        }
        this.mPostMsgPresenter.obtainTemplateList(this.initModel.getPartnerid(), SharedPreferencesUtil.getStringData(getSobotActivity(), ZhiChiConstant.sobot_connect_group_id, ""), z, z2, new StPostMsgPresenter.ObtainTemplateListDelegate() { // from class: com.sobot.chat.conversation.SobotChatFragment.37
            @Override // com.sobot.chat.presenter.StPostMsgPresenter.ObtainTemplateListDelegate
            public void onSuccess(Intent intent) {
                intent.putExtra("intent_key_companyid", SobotChatFragment.this.initModel.getCompanyId());
                intent.putExtra(StPostMsgPresenter.INTENT_KEY_CUSTOMERID, SobotChatFragment.this.initModel.getCustomerId());
                intent.putExtra(ZhiChiConstant.FLAG_EXIT_SDK, z);
                intent.putExtra(StPostMsgPresenter.INTENT_KEY_GROUPID, SobotChatFragment.this.info.getLeaveMsgGroupId());
                intent.putExtra(StPostMsgPresenter.INTENT_KEY_IS_SHOW_TICKET, z2);
                SobotChatFragment.this.startActivity(intent);
                if (SobotChatFragment.this.getSobotActivity() != null) {
                    SobotChatFragment.this.getSobotActivity().overridePendingTransition(ResourceUtils.getIdByName(SobotChatFragment.this.mAppContext, i.f, "sobot_push_left_in"), ResourceUtils.getIdByName(SobotChatFragment.this.mAppContext, i.f, "sobot_push_left_out"));
                }
            }
        });
    }

    public void startVoiceTimeTask(final Handler handler) {
        this.voiceTimerLong = 0;
        stopVoiceTimeTask();
        this.voiceTimer = new Timer();
        TimerTask timerTask = new TimerTask() { // from class: com.sobot.chat.conversation.SobotChatFragment.20
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                SobotChatFragment.this.sendVoiceTimeTask(handler);
            }
        };
        this.voiceTimerTask = timerTask;
        this.voiceTimer.schedule(timerTask, 0L, 500L);
    }

    public void stopVoiceTimeTask() {
        Timer timer = this.voiceTimer;
        if (timer != null) {
            timer.cancel();
            this.voiceTimer = null;
        }
        TimerTask timerTask = this.voiceTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.voiceTimerTask = null;
        }
        this.voiceTimerLong = 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void submitEvaluation(boolean z, int i, int i2, String str) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public void switchEmoticonBtn() {
        if (this.btn_emoticon_view.isSelected()) {
            doEmoticonBtn2Blur();
        } else {
            doEmoticonBtn2Focus();
        }
        if (this.btn_emoticon_view.isSelected()) {
            this.btn_emoticon_view.setBackgroundResource(ResourceUtils.getDrawableId(getContext(), "sobot_keyboard_normal"));
        } else {
            this.btn_emoticon_view.setBackgroundResource(ResourceUtils.getDrawableId(getContext(), "sobot_emoticon_button_selector"));
        }
    }

    public void switchPanelAndKeyboard(View view, View view2, View view3) {
        int i = this.currentPanelId;
        if (i == 0 || i == view2.getId()) {
            if (view.getVisibility() != 0) {
                KPSwitchConflictUtil.showPanel(view);
                setPanelView(view, view2.getId());
            } else {
                KPSwitchConflictUtil.showKeyboard(view, view3);
            }
        } else {
            KPSwitchConflictUtil.showPanel(view);
            setPanelView(view, view2.getId());
        }
        this.currentPanelId = view2.getId();
    }

    public void voiceCuttingMethod() {
        stopVoice();
        sendVoiceMap(1, this.voiceMsgId);
        this.voice_time_long.setText("59''");
    }
}
