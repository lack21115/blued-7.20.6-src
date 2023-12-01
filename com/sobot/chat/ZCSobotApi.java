package com.sobot.chat;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.anythink.expressad.video.dynview.a.a;
import com.sobot.chat.activity.SobotConsultationListActivity;
import com.sobot.chat.activity.SobotHelpCenterActivity;
import com.sobot.chat.activity.SobotPostMsgActivity;
import com.sobot.chat.api.ZhiChiApi;
import com.sobot.chat.api.apiUtils.SobotApp;
import com.sobot.chat.api.apiUtils.SobotBaseUrl;
import com.sobot.chat.api.apiUtils.ZhiChiUrlApi;
import com.sobot.chat.api.enumtype.SobotChatAvatarDisplayMode;
import com.sobot.chat.api.enumtype.SobotChatStatusMode;
import com.sobot.chat.api.enumtype.SobotChatTitleDisplayMode;
import com.sobot.chat.api.model.CommonModel;
import com.sobot.chat.api.model.ConsultingContent;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.api.model.OrderCardContentModel;
import com.sobot.chat.api.model.SobotCusFieldConfig;
import com.sobot.chat.api.model.SobotFieldModel;
import com.sobot.chat.api.model.SobotLeaveMsgConfig;
import com.sobot.chat.api.model.SobotLeaveReplyModel;
import com.sobot.chat.api.model.SobotLocationModel;
import com.sobot.chat.api.model.SobotMsgCenterModel;
import com.sobot.chat.api.model.SobotTransferOperatorParam;
import com.sobot.chat.api.model.ZhiChiInitModeBase;
import com.sobot.chat.conversation.SobotChatActivity;
import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.core.channel.Const;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.listener.HyperlinkListener;
import com.sobot.chat.listener.NewHyperlinkListener;
import com.sobot.chat.listener.SobotChatStatusListener;
import com.sobot.chat.listener.SobotFunctionClickListener;
import com.sobot.chat.listener.SobotImagePreviewListener;
import com.sobot.chat.listener.SobotLeaveMsgListener;
import com.sobot.chat.listener.SobotNoReadLeaveReplyListener;
import com.sobot.chat.listener.SobotOrderCardListener;
import com.sobot.chat.presenter.StPostMsgPresenter;
import com.sobot.chat.server.SobotSessionServer;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.HtmlTools;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.NotificationUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.SobotCache;
import com.sobot.chat.utils.SobotOption;
import com.sobot.chat.utils.StServiceUtils;
import com.sobot.chat.utils.SystemUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.network.apiUtils.SobotHttpUtils;
import com.sobot.network.http.callback.StringResultCallBack;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/ZCSobotApi.class */
public class ZCSobotApi {
    private static String Tag = ZhiChiApi.class.getSimpleName();

    public static void cancleAllNotification(Context context) {
        if (context == null) {
            return;
        }
        NotificationUtils.cancleAllNotification(context);
    }

    public static void checkIMConnected(Context context, String str) {
        LogUtils.i("checkIMConnected partnerid=" + str);
        if (context == null) {
            return;
        }
        clearUnReadNumber(context, str);
        Context applicationContext = context.getApplicationContext();
        SharedPreferencesUtil.removeKey(applicationContext, Const.SOBOT_WAYHTTP);
        SobotMsgManager.getInstance(applicationContext).getZhiChiApi().reconnectChannel();
        Intent intent = new Intent(applicationContext, SobotSessionServer.class);
        intent.putExtra(ZhiChiConstant.SOBOT_CURRENT_IM_PARTNERID, str);
        StServiceUtils.safeStartService(applicationContext, intent);
    }

    public static void clearMsgCenterList(Context context, String str) {
        if (context == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        SobotCache.get(context).remove(SobotMsgManager.getMsgCenterListKey(str2));
    }

    public static void clearUnReadNumber(Context context, String str) {
        if (context == null) {
            return;
        }
        SobotMsgManager.getInstance(context).clearAllUnreadCount(context, str);
    }

    public static void closeIMConnection(Context context) {
        if (context == null) {
            return;
        }
        if (SobotOption.sobotChatStatusListener != null) {
            SobotOption.sobotChatStatusListener.onChatStatusListener(SobotChatStatusMode.ZCServerConnectOffline);
        }
        SobotMsgManager.getInstance(context).getZhiChiApi().disconnChannel();
        SobotMsgManager.getInstance(context).clearAllConfig();
    }

    public static void connectCustomerService(Context context, SobotTransferOperatorParam sobotTransferOperatorParam) {
        if (context == null || sobotTransferOperatorParam == null) {
            return;
        }
        Intent intent = new Intent();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context.getApplicationContext());
        intent.setAction(ZhiChiConstant.SOBOT_BROCAST_ACTION_TRASNFER_TO_OPERATOR);
        intent.putExtra(ZhiChiConstant.SOBOT_SEND_DATA, sobotTransferOperatorParam);
        localBroadcastManager.sendBroadcast(intent);
    }

    public static String getAppName(Context context) {
        return SystemUtil.getAppName(context);
    }

    public static String getAppVersion(Context context) {
        return SystemUtil.getVersionCode(context) + "";
    }

    public static Information getCurrentInfoSetting(Context context) {
        if (context != null) {
            return (Information) SharedPreferencesUtil.getObject(context, ZhiChiConstant.sobot_last_current_info);
        }
        return null;
    }

    public static void getLastLeaveReplyMessage(Context context, String str, final SobotNoReadLeaveReplyListener sobotNoReadLeaveReplyListener) {
        if (context == null) {
            LogUtils.e("getLastLeaveReplyMessage context 为空");
        } else if (TextUtils.isEmpty(str)) {
            LogUtils.e("getLastLeaveReplyMessage partnerId 不能为空");
        } else {
            String stringData = SharedPreferencesUtil.getStringData(context, ZhiChiConstant.SOBOT_CONFIG_COMPANYID, "");
            if (TextUtils.isEmpty(stringData)) {
                LogUtils.e("getLastLeaveReplyMessage companyId 不能为空,请检查是否调用初始化方法");
                return;
            }
            final ArrayList arrayList = new ArrayList();
            SobotMsgManager.getInstance(context).getZhiChiApi().getUserTicketReplyInfo(context, stringData, str, new StringResultCallBack<List<SobotLeaveReplyModel>>() { // from class: com.sobot.chat.ZCSobotApi.2
                @Override // com.sobot.network.http.callback.StringResultCallBack
                public void onFailure(Exception exc, String str2) {
                }

                @Override // com.sobot.network.http.callback.StringResultCallBack
                public void onSuccess(List<SobotLeaveReplyModel> list) {
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    arrayList.addAll(list);
                    SobotNoReadLeaveReplyListener sobotNoReadLeaveReplyListener2 = sobotNoReadLeaveReplyListener;
                    if (sobotNoReadLeaveReplyListener2 != null) {
                        sobotNoReadLeaveReplyListener2.onNoReadLeaveReplyListener(arrayList);
                    }
                }
            });
        }
    }

    public static String getLastMessage(Context context) {
        return SharedPreferencesUtil.getStringData(context, ZhiChiConstant.SOBOT_LAST_MSG_CONTENT, "");
    }

    public static List<SobotMsgCenterModel> getMsgCenterList(Context context, String str) {
        if (context == null) {
            return null;
        }
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        SobotCache sobotCache = SobotCache.get(context);
        ArrayList arrayList = (ArrayList) sobotCache.getAsObject(SobotMsgManager.getMsgCenterListKey(str2));
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null && arrayList.size() > 0) {
            arrayList2.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                SobotMsgCenterModel sobotMsgCenterModel = (SobotMsgCenterModel) sobotCache.getAsObject(SobotMsgManager.getMsgCenterDataKey((String) it.next(), str2));
                if (sobotMsgCenterModel != null) {
                    arrayList2.add(sobotMsgCenterModel);
                }
            }
        }
        return arrayList2;
    }

    public static String getPhoneType() {
        return SystemUtil.getSystemModel();
    }

    public static boolean getSwitchMarkStatus(int i) {
        if (((i - 1) & i) == 0) {
            return MarkConfig.getON_OFF(i);
        }
        throw new Resources.NotFoundException("markConfig 必须为2的指数次幂");
    }

    public static String getSystem() {
        return SystemUtil.getSystemVersion();
    }

    public static int getUnReadMessage(Context context, String str) {
        int i = 0;
        if (context == null) {
            return 0;
        }
        List<SobotMsgCenterModel> msgCenterList = getMsgCenterList(context, str);
        if (msgCenterList != null) {
            i = 0;
            for (int i2 = 0; i2 < msgCenterList.size(); i2++) {
                i += msgCenterList.get(i2).getUnreadCount();
            }
        }
        return i;
    }

    public static String getUserUUID(Context context) {
        return CommonUtils.getPartnerId(context);
    }

    public static String getVersion(Context context) {
        return ZhiChiUrlApi.VERSION;
    }

    @Deprecated
    public static void hideHistoryMsg(Context context, long j) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveLongData(context, "sobot_scope_time", j);
    }

    public static void hideTimemsgForMessageList(Context context, boolean z) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveBooleanData(context, "sobot_use_language", z);
    }

    public static void initPlatformUnion(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_PLATFORM_UNIONCODE, str);
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_PLATFORM_KEY, str2);
    }

    public static void initSobotSDK(final Context context, final String str, final String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            String str3 = Tag;
            Log.e(str3, "initSobotSDK  参数为空 context:" + context + "  appkey:" + str);
            return;
        }
        SobotHttpUtils.init(context, SobotBaseUrl.getApi_Host());
        SobotApp.setApplicationContext(context);
        SharedPreferencesUtil.saveAppKey(context, str);
        SharedPreferencesUtil.saveStringData(context, Const.SOBOT_APPKEY, str);
        SharedPreferencesUtil.saveBooleanData(context, ZhiChiConstant.SOBOT_CONFIG_INITSDK, true);
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_CONFIG_APPKEY, str);
        SharedPreferencesUtil.saveObject(context, "SobotLanguage", null);
        if (CommonUtils.inMainProcess(context.getApplicationContext())) {
            LogUtils.setSaveDir(CommonUtils.getPrivatePath(context));
            new Thread(new Runnable() { // from class: com.sobot.chat.ZCSobotApi.4
                @Override // java.lang.Runnable
                public void run() {
                    SobotMsgManager.getInstance(Context.this).initSobotSDK(Context.this, str, str2);
                }
            }).start();
        }
    }

    public static boolean isActiveOperator(Context context, String str) {
        return SobotMsgManager.getInstance(context.getApplicationContext()).isActiveOperator(str);
    }

    public static void openLeave(final Context context, final Information information, final boolean z) {
        if (information == null) {
            Log.e(Tag, "参数info不能为空");
        } else if (context == null || TextUtils.isEmpty(information.getApp_key())) {
            Log.e(Tag, "参数info中app_key的不能为空");
        } else {
            if (TextUtils.isEmpty(information.getPartnerid())) {
                information.setPartnerid(CommonUtils.getDeviceId(context));
            }
            SobotMsgManager.getInstance(context).getZhiChiApi().sobotInit(context, information, new StringResultCallBack<ZhiChiInitModeBase>() { // from class: com.sobot.chat.ZCSobotApi.1
                @Override // com.sobot.network.http.callback.StringResultCallBack
                public void onFailure(Exception exc, String str) {
                }

                @Override // com.sobot.network.http.callback.StringResultCallBack
                public void onSuccess(final ZhiChiInitModeBase zhiChiInitModeBase) {
                    SharedPreferencesUtil.saveObject(Context.this, ZhiChiConstant.sobot_last_current_info, information);
                    final ArrayList arrayList = new ArrayList();
                    if (information.getLeaveCusFieldMap() != null && information.getLeaveCusFieldMap().size() > 0) {
                        for (String str : information.getLeaveCusFieldMap().keySet()) {
                            SobotFieldModel sobotFieldModel = new SobotFieldModel();
                            SobotCusFieldConfig sobotCusFieldConfig = new SobotCusFieldConfig();
                            sobotCusFieldConfig.setFieldId(str);
                            sobotCusFieldConfig.setValue(information.getLeaveCusFieldMap().get(str));
                            sobotFieldModel.setCusFieldConfig(sobotCusFieldConfig);
                            arrayList.add(sobotFieldModel);
                        }
                    }
                    if (!TextUtils.isEmpty(information.getLeaveTemplateId())) {
                        SobotMsgManager.getInstance(Context.this).getZhiChiApi().getMsgTemplateConfig(this, zhiChiInitModeBase.getPartnerid(), information.getLeaveTemplateId(), new StringResultCallBack<SobotLeaveMsgConfig>() { // from class: com.sobot.chat.ZCSobotApi.1.1
                            @Override // com.sobot.network.http.callback.StringResultCallBack
                            public void onFailure(Exception exc, String str2) {
                                exc.printStackTrace();
                                LogUtils.i("通过配置模版id跳转到留言界面：" + str2);
                            }

                            @Override // com.sobot.network.http.callback.StringResultCallBack
                            public void onSuccess(SobotLeaveMsgConfig sobotLeaveMsgConfig) {
                                if (sobotLeaveMsgConfig != null) {
                                    Intent intent = new Intent(Context.this, SobotPostMsgActivity.class);
                                    intent.putExtra("intent_key_uid", zhiChiInitModeBase.getPartnerid());
                                    intent.putExtra(StPostMsgPresenter.INTENT_KEY_CONFIG, sobotLeaveMsgConfig);
                                    intent.putExtra("intent_key_companyid", zhiChiInitModeBase.getCompanyId());
                                    intent.putExtra(StPostMsgPresenter.INTENT_KEY_CUSTOMERID, zhiChiInitModeBase.getCustomerId());
                                    intent.putExtra(ZhiChiConstant.FLAG_EXIT_SDK, false);
                                    intent.putExtra(StPostMsgPresenter.INTENT_KEY_GROUPID, information.getLeaveMsgGroupId());
                                    intent.putExtra(StPostMsgPresenter.INTENT_KEY_CUS_FIELDS, (Serializable) arrayList);
                                    intent.putExtra(StPostMsgPresenter.INTENT_KEY_IS_SHOW_TICKET, z);
                                    Context.this.startActivity(intent);
                                }
                            }
                        });
                        return;
                    }
                    SobotLeaveMsgConfig sobotLeaveMsgConfig = new SobotLeaveMsgConfig();
                    sobotLeaveMsgConfig.setEmailFlag(zhiChiInitModeBase.isEmailFlag());
                    sobotLeaveMsgConfig.setEmailShowFlag(zhiChiInitModeBase.isEmailShowFlag());
                    sobotLeaveMsgConfig.setEnclosureFlag(zhiChiInitModeBase.isEnclosureFlag());
                    sobotLeaveMsgConfig.setEnclosureShowFlag(zhiChiInitModeBase.isEnclosureShowFlag());
                    sobotLeaveMsgConfig.setTelFlag(zhiChiInitModeBase.isTelFlag());
                    sobotLeaveMsgConfig.setTelShowFlag(zhiChiInitModeBase.isTelShowFlag());
                    sobotLeaveMsgConfig.setTicketStartWay(zhiChiInitModeBase.isTicketStartWay());
                    sobotLeaveMsgConfig.setTicketShowFlag(zhiChiInitModeBase.isTicketShowFlag());
                    sobotLeaveMsgConfig.setCompanyId(zhiChiInitModeBase.getCompanyId());
                    if (TextUtils.isEmpty(information.getLeaveMsgTemplateContent())) {
                        sobotLeaveMsgConfig.setMsgTmp(zhiChiInitModeBase.getMsgTmp());
                    } else {
                        sobotLeaveMsgConfig.setMsgTmp(information.getLeaveMsgTemplateContent());
                    }
                    if (TextUtils.isEmpty(information.getLeaveMsgGuideContent())) {
                        sobotLeaveMsgConfig.setMsgTxt(zhiChiInitModeBase.getMsgTxt());
                    } else {
                        sobotLeaveMsgConfig.setMsgTxt(information.getLeaveMsgGuideContent());
                    }
                    Intent intent = new Intent(Context.this, SobotPostMsgActivity.class);
                    intent.putExtra("intent_key_uid", zhiChiInitModeBase.getPartnerid());
                    intent.putExtra(StPostMsgPresenter.INTENT_KEY_CONFIG, sobotLeaveMsgConfig);
                    intent.putExtra("intent_key_companyid", zhiChiInitModeBase.getCompanyId());
                    intent.putExtra(StPostMsgPresenter.INTENT_KEY_CUSTOMERID, zhiChiInitModeBase.getCustomerId());
                    intent.putExtra(ZhiChiConstant.FLAG_EXIT_SDK, false);
                    intent.putExtra(StPostMsgPresenter.INTENT_KEY_GROUPID, information.getLeaveMsgGroupId());
                    intent.putExtra(StPostMsgPresenter.INTENT_KEY_CUS_FIELDS, arrayList);
                    intent.putExtra(StPostMsgPresenter.INTENT_KEY_IS_SHOW_TICKET, z);
                    Context.this.startActivity(intent);
                }
            });
        }
    }

    public static void openZCChat(Context context, Information information) {
        if (information == null || context == null) {
            Log.e(Tag, "Information is Null!");
        } else if (!SharedPreferencesUtil.getBooleanData(context, ZhiChiConstant.SOBOT_CONFIG_INITSDK, false)) {
            Log.e(Tag, "请在Application中调用【ZCSobotApi.initSobotSDK()】来初始化SDK!");
        } else {
            Intent intent = new Intent(context, SobotChatActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(ZhiChiConstant.SOBOT_BUNDLE_INFO, information);
            intent.putExtra(ZhiChiConstant.SOBOT_BUNDLE_INFORMATION, bundle);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static void openZCChatListView(Context context, String str) {
        Intent intent = new Intent(context, SobotConsultationListActivity.class);
        intent.setFlags(268435456);
        intent.putExtra(ZhiChiConstant.SOBOT_CURRENT_IM_PARTNERID, str);
        context.startActivity(intent);
    }

    public static void openZCServiceCenter(Context context, Information information) {
        if (information == null || context == null) {
            Log.e(Tag, "Information is Null!");
        } else if (!SharedPreferencesUtil.getBooleanData(context, ZhiChiConstant.SOBOT_CONFIG_INITSDK, false)) {
            Log.e(Tag, "请在Application中调用【SobotApi.initSobotSDK()】来初始化SDK!");
        } else {
            Intent intent = new Intent(context, SobotHelpCenterActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(ZhiChiConstant.SOBOT_BUNDLE_INFO, information);
            intent.putExtra(ZhiChiConstant.SOBOT_BUNDLE_INFORMATION, bundle);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static void outCurrentUserZCLibInfo(Context context) {
        SharedPreferencesUtil.saveBooleanData(context, ZhiChiConstant.SOBOT_IS_EXIT, true);
        if (context == null) {
            return;
        }
        try {
            closeIMConnection(context);
            context.stopService(new Intent(context, SobotSessionServer.class));
            String stringData = SharedPreferencesUtil.getStringData(context, Const.SOBOT_CID, "");
            String stringData2 = SharedPreferencesUtil.getStringData(context, Const.SOBOT_UID, "");
            SharedPreferencesUtil.removeKey(context, Const.SOBOT_WSLINKBAK);
            SharedPreferencesUtil.removeKey(context, Const.SOBOT_WSLINKDEFAULT);
            SharedPreferencesUtil.removeKey(context, Const.SOBOT_UID);
            SharedPreferencesUtil.removeKey(context, Const.SOBOT_CID);
            SharedPreferencesUtil.removeKey(context, Const.SOBOT_PUID);
            SharedPreferencesUtil.removeKey(context, Const.SOBOT_APPKEY);
            if (TextUtils.isEmpty(stringData) || TextUtils.isEmpty(stringData2)) {
                return;
            }
            SobotMsgManager.getInstance(context).getZhiChiApi().out(stringData, stringData2, new StringResultCallBack<CommonModel>() { // from class: com.sobot.chat.ZCSobotApi.3
                @Override // com.sobot.network.http.callback.StringResultCallBack
                public void onFailure(Exception exc, String str) {
                }

                @Override // com.sobot.network.http.callback.StringResultCallBack
                public void onSuccess(CommonModel commonModel) {
                    LogUtils.i("下线成功");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readLogFileDateString(String str) {
        return LogUtils.getLogFileByDate(str);
    }

    public static void replacePhoneNumberPattern(String str) {
        HtmlTools.setPhoneNumberPattern(Pattern.compile(str));
    }

    public static void replaceWebUrlPattern(String str) {
        HtmlTools.setWebUrl(Pattern.compile(str));
    }

    public static void sendLeaveReplyNotification(Context context, SobotLeaveReplyModel sobotLeaveReplyModel, int i, int i2) {
        ZhiChiInitModeBase zhiChiInitModeBase = (ZhiChiInitModeBase) SharedPreferencesUtil.getObject(context, ZhiChiConstant.sobot_last_current_initModel);
        if (sobotLeaveReplyModel == null) {
            return;
        }
        SharedPreferencesUtil.saveIntData(context, ZhiChiConstant.SOBOT_NOTIFICATION_SMALL_ICON, i);
        SharedPreferencesUtil.saveIntData(context, ZhiChiConstant.SOBOT_NOTIFICATION_LARGE_ICON, i2);
        NotificationUtils.createLeaveReplyNotification(context, sobotLeaveReplyModel.getTicketTitle(), sobotLeaveReplyModel.getReplyContent(), ResourceUtils.getResString(context, "sobot_notification_tip_title"), 1001, zhiChiInitModeBase == null ? "" : zhiChiInitModeBase.getCompanyId(), zhiChiInitModeBase != null ? zhiChiInitModeBase.getUid() : "", sobotLeaveReplyModel);
    }

    public static void sendLocation(Context context, SobotLocationModel sobotLocationModel) {
        if (context == null || sobotLocationModel == null) {
            return;
        }
        Intent intent = new Intent();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context.getApplicationContext());
        intent.setAction(ZhiChiConstant.SOBOT_BROCAST_ACTION_SEND_LOCATION);
        intent.putExtra(ZhiChiConstant.SOBOT_LOCATION_DATA, sobotLocationModel);
        localBroadcastManager.sendBroadcast(intent);
    }

    public static void sendMessageToUser(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context.getApplicationContext());
        intent.setAction(ZhiChiConstant.SOBOT_BROCAST_ACTION_SEND_OBJECT);
        intent.putExtra(ZhiChiConstant.SOBOT_SEND_DATA, str);
        intent.putExtra(ZhiChiConstant.SOBOT_TYPE_DATA, str2);
        localBroadcastManager.sendBroadcast(intent);
    }

    public static void sendOrderGoodsInfo(Context context, OrderCardContentModel orderCardContentModel) {
        if (context == null || orderCardContentModel == null) {
            return;
        }
        if (TextUtils.isEmpty(orderCardContentModel.getOrderCode())) {
            LogUtils.e("订单编号不能为空");
            return;
        }
        Intent intent = new Intent();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context.getApplicationContext());
        intent.setAction(ZhiChiConstant.SOBOT_BROCAST_ACTION_SEND_ORDER_CARD);
        intent.putExtra(ZhiChiConstant.SOBOT_SEND_DATA, orderCardContentModel);
        localBroadcastManager.sendBroadcast(intent);
    }

    public static void sendProductInfo(Context context, ConsultingContent consultingContent) {
        if (context == null || consultingContent == null) {
            return;
        }
        Intent intent = new Intent();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context.getApplicationContext());
        intent.setAction(ZhiChiConstant.SOBOT_BROCAST_ACTION_SEND_CARD);
        intent.putExtra(ZhiChiConstant.SOBOT_SEND_DATA, consultingContent);
        localBroadcastManager.sendBroadcast(intent);
    }

    public static void sendTextToRobot(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context.getApplicationContext());
        intent.setAction(ZhiChiConstant.SOBOT_BROCAST_ACTION_SEND_TEXT);
        intent.putExtra(ZhiChiConstant.SOBOT_SEND_DATA, str);
        intent.putExtra("sendTextTo", "robot");
        localBroadcastManager.sendBroadcast(intent);
    }

    public static void sendTextToUser(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context.getApplicationContext());
        intent.setAction(ZhiChiConstant.SOBOT_BROCAST_ACTION_SEND_TEXT);
        intent.putExtra(ZhiChiConstant.SOBOT_SEND_DATA, str);
        intent.putExtra("sendTextTo", "user");
        localBroadcastManager.sendBroadcast(intent);
    }

    public static void setAdmin_Hello_Word(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_ADMIN_HELLO_WORD, str);
    }

    public static void setAdmin_Offline_Title(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_ADMIN_OFFLINE_TITLE, str);
    }

    public static void setAdmin_Tip_Word(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_ADMIN_TIP_WORD, str);
    }

    public static void setChatAvatarDisplayMode(Context context, SobotChatAvatarDisplayMode sobotChatAvatarDisplayMode, String str, boolean z) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveIntData(context, ZhiChiConstant.SOBOT_CHAT_AVATAR_DISPLAY_MODE, sobotChatAvatarDisplayMode.getValue());
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_CHAT_AVATAR_DISPLAY_CONTENT, str);
        SharedPreferencesUtil.saveBooleanData(context, ZhiChiConstant.SOBOT_CHAT_AVATAR_IS_SHOW, z);
    }

    public static void setChatStatusListener(SobotChatStatusListener sobotChatStatusListener) {
        SobotOption.sobotChatStatusListener = sobotChatStatusListener;
    }

    public static void setChatTitleDisplayMode(Context context, SobotChatTitleDisplayMode sobotChatTitleDisplayMode, String str, boolean z) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveIntData(context, ZhiChiConstant.SOBOT_CHAT_TITLE_DISPLAY_MODE, sobotChatTitleDisplayMode.getValue());
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_CHAT_TITLE_DISPLAY_CONTENT, str);
        SharedPreferencesUtil.saveBooleanData(context, ZhiChiConstant.SOBOT_CHAT_TITLE_IS_SHOW, z);
    }

    @Deprecated
    public static void setCustomAdminHelloWord(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_ADMIN_HELLO_WORD, str);
    }

    @Deprecated
    public static void setCustomAdminNonelineTitle(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_ADMIN_OFFLINE_TITLE, str);
    }

    @Deprecated
    public static void setCustomAdminTipWord(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_ADMIN_TIP_WORD, str);
    }

    @Deprecated
    public static void setCustomRobotHelloWord(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_ROBOT_HELLO_WORD, str);
    }

    @Deprecated
    public static void setCustomUserOutWord(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_USER_OUT_WORD, str);
    }

    @Deprecated
    public static void setCustomUserTipWord(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_USER_TIP_WORD, str);
    }

    public static void setEvaluationCompletedExit(Context context, boolean z) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveBooleanData(context, ZhiChiConstant.SOBOT_CHAT_EVALUATION_COMPLETED_EXIT, z);
    }

    @Deprecated
    public static void setFlowCompanyId(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_FLOW_COMPANYID, str);
    }

    @Deprecated
    public static void setFlowGroupId(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_FLOW_GROUPID, str);
    }

    @Deprecated
    public static void setFlowType(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_FLOW_TYPE, str);
    }

    public static void setFlow_Company_Id(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_FLOW_COMPANYID, str);
    }

    public static void setFlow_GroupId(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_FLOW_GROUPID, str);
    }

    public static void setFlow_Type(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_FLOW_TYPE, str);
    }

    public static void setFunctionClickListener(SobotFunctionClickListener sobotFunctionClickListener) {
        SobotOption.functionClickListener = sobotFunctionClickListener;
    }

    public static void setHyperlinkListener(HyperlinkListener hyperlinkListener) {
        SobotOption.hyperlinkListener = hyperlinkListener;
    }

    public static void setImagePreviewListener(SobotImagePreviewListener sobotImagePreviewListener) {
        SobotOption.imagePreviewListener = sobotImagePreviewListener;
    }

    public static void setInternationalLanguage(final Context context, final String str, boolean z, boolean z2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferencesUtil.saveObject(context, "SobotLanguage", null);
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_USER_SETTTINNG_LANGUAGE, "");
        SharedPreferencesUtil.saveBooleanData(context, "sobot_use_language", z);
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_LANGUAGE_STRING_PATH, "");
        if (z) {
            SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_LANGUAGE_STRING_NAME, "sobot_android_strings_" + str);
            String str2 = "sobot_android_strings_" + str + ".json";
            final String str3 = CommonUtils.getPrivatePath(context) + File.separator + getAppName(context) + "sobot_language" + File.separator + ZhiChiUrlApi.LANGUAGE_VERSION + File.separator + str2;
            File file = new File(str3);
            if (z2 && file.exists()) {
                file.delete();
                SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_LANGUAGE_STRING_PATH, "");
            }
            if (!file.exists()) {
                HttpUtils.getInstance().download("https://img.sobot.com/mobile/multilingual/android/3_1_3/" + str2, file, null, new HttpUtils.FileCallBack() { // from class: com.sobot.chat.ZCSobotApi.5
                    @Override // com.sobot.chat.core.HttpUtils.FileCallBack
                    public void inProgress(int i) {
                    }

                    @Override // com.sobot.chat.core.HttpUtils.FileCallBack
                    public void onError(Exception exc, String str4, int i) {
                        LogUtils.i(" 国际化语言包下载失败:", exc);
                        SharedPreferencesUtil.saveBooleanData(context, "sobot_use_language", false);
                    }

                    @Override // com.sobot.chat.core.HttpUtils.FileCallBack
                    public void onResponse(File file2) {
                        if (a.aa.equals(str)) {
                            SharedPreferencesUtil.saveObject(context, "SobotLanguage", new Locale(a.aa));
                        }
                        if ("he".equals(str)) {
                            SharedPreferencesUtil.saveObject(context, "SobotLanguage", new Locale("iw"));
                        }
                        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_USER_SETTTINNG_LANGUAGE, str);
                        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_LANGUAGE_STRING_PATH, str3);
                        SharedPreferencesUtil.saveBooleanData(context, "sobot_use_language", true);
                        LogUtils.i(" 国际化语言包保存路径:" + file2.getPath());
                    }
                });
                return;
            }
            SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_LANGUAGE_STRING_PATH, str3);
            if (a.aa.equals(str)) {
                SharedPreferencesUtil.saveObject(context, "SobotLanguage", new Locale(a.aa));
            }
            if ("he".equals(str)) {
                SharedPreferencesUtil.saveObject(context, "SobotLanguage", new Locale("iw"));
            }
            SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_USER_SETTTINNG_LANGUAGE, str);
        }
    }

    public static void setNewHyperlinkListener(NewHyperlinkListener newHyperlinkListener) {
        SobotOption.newHyperlinkListener = newHyperlinkListener;
    }

    public static void setNotificationFlag(Context context, boolean z, int i, int i2) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveBooleanData(context, Const.SOBOT_NOTIFICATION_FLAG, z);
        SharedPreferencesUtil.saveIntData(context, ZhiChiConstant.SOBOT_NOTIFICATION_SMALL_ICON, i);
        SharedPreferencesUtil.saveIntData(context, ZhiChiConstant.SOBOT_NOTIFICATION_LARGE_ICON, i2);
    }

    @Deprecated
    public static void setOrderCardListener(SobotOrderCardListener sobotOrderCardListener) {
        SobotOption.orderCardListener = sobotOrderCardListener;
    }

    public static void setRobot_Hello_Word(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_ROBOT_HELLO_WORD, str);
    }

    public static void setScope_time(Context context, long j) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveLongData(context, "sobot_scope_time", j);
    }

    public static void setShowDebug(Boolean bool) {
        if (bool.booleanValue()) {
            LogUtils.isDebug = true;
            LogUtils.allowI = true;
            LogUtils.allowE = true;
            LogUtils.allowD = true;
            return;
        }
        LogUtils.isDebug = false;
        LogUtils.allowI = false;
        LogUtils.allowE = false;
        LogUtils.allowD = true;
    }

    public static void setSobotLeaveMsgListener(SobotLeaveMsgListener sobotLeaveMsgListener) {
        SobotOption.sobotLeaveMsgListener = sobotLeaveMsgListener;
    }

    public static void setSwitchMarkStatus(int i, boolean z) {
        if (((i - 1) & i) != 0) {
            throw new Resources.NotFoundException("markConfig 必须为2的指数次幂");
        }
        MarkConfig.setON_OFF(i, z);
    }

    public static void setUser_Out_Word(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_USER_OUT_WORD, str);
    }

    public static void setUser_Tip_Word(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_USER_TIP_WORD, str);
    }
}
