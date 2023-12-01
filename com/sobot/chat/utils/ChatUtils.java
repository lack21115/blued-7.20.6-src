package com.sobot.chat.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.anythink.expressad.foundation.h.i;
import com.blued.android.chat.data.MsgType;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.sobot.chat.R;
import com.sobot.chat.SobotUIConfig;
import com.sobot.chat.ZCSobotApi;
import com.sobot.chat.adapter.SobotMsgAdapter;
import com.sobot.chat.api.ResultCallBack;
import com.sobot.chat.api.apiUtils.GsonUtil;
import com.sobot.chat.api.enumtype.SobotChatAvatarDisplayMode;
import com.sobot.chat.api.enumtype.SobotChatTitleDisplayMode;
import com.sobot.chat.api.model.CommonModel;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.api.model.SobotCacheFile;
import com.sobot.chat.api.model.SobotEvaluateModel;
import com.sobot.chat.api.model.SobotLocationModel;
import com.sobot.chat.api.model.SobotMsgCenterModel;
import com.sobot.chat.api.model.SobotMultiDiaRespInfo;
import com.sobot.chat.api.model.SobotQuestionRecommend;
import com.sobot.chat.api.model.SobotUserTicketEvaluate;
import com.sobot.chat.api.model.ZhiChiInitModeBase;
import com.sobot.chat.api.model.ZhiChiMessage;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.api.model.ZhiChiPushMessage;
import com.sobot.chat.api.model.ZhiChiReplyAnswer;
import com.sobot.chat.application.MyApplication;
import com.sobot.chat.camera.util.FileUtil;
import com.sobot.chat.core.channel.Const;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.viewHolder.ImageMessageHolder;
import com.sobot.chat.widget.dialog.SobotDialogUtils;
import com.sobot.chat.widget.dialog.SobotEvaluateDialog;
import com.sobot.chat.widget.dialog.SobotRobotListDialog;
import com.sobot.chat.widget.dialog.SobotTicketEvaluateDialog;
import com.sobot.network.http.callback.StringResultCallBack;
import com.sobot.pictureframe.SobotBitmapUtil;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/ChatUtils.class */
public class ChatUtils {

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/ChatUtils$SobotSendFileListener.class */
    public interface SobotSendFileListener {
        void onError();

        void onSuccess(String str);
    }

    public static void callUp(String str, Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(Uri.parse("tel:" + str));
            context.startActivity(intent);
        } catch (Exception e) {
            ToastUtil.showCustomToast(context, context.getString(R.string.sobot_no_support_call));
            e.printStackTrace();
        }
    }

    public static boolean checkConfigChange(Context context, String str, Information information) {
        if (!SharedPreferencesUtil.getOnlyStringData(context, ZhiChiConstant.sobot_last_current_appkey, "").equals(information.getApp_key())) {
            SharedPreferencesUtil.removeKey(context, ZhiChiConstant.sobot_last_login_group_id);
            LogUtils.i("appkey发生了变化，重新初始化..............");
            return true;
        }
        String stringData = SharedPreferencesUtil.getStringData(context, str + BridgeUtil.UNDERLINE_STR + ZhiChiConstant.sobot_last_current_partnerId, "");
        String stringData2 = SharedPreferencesUtil.getStringData(context, str + BridgeUtil.UNDERLINE_STR + ZhiChiConstant.SOBOT_RECEPTIONISTID, "");
        String stringData3 = SharedPreferencesUtil.getStringData(context, str + BridgeUtil.UNDERLINE_STR + ZhiChiConstant.SOBOT_ROBOT_CODE, "");
        String stringData4 = SharedPreferencesUtil.getStringData(context, str + BridgeUtil.UNDERLINE_STR + ZhiChiConstant.sobot_last_current_remark, "");
        String stringData5 = SharedPreferencesUtil.getStringData(context, str + BridgeUtil.UNDERLINE_STR + ZhiChiConstant.sobot_last_current_groupid, "");
        int intData = SharedPreferencesUtil.getIntData(context, str + BridgeUtil.UNDERLINE_STR + ZhiChiConstant.sobot_last_current_service_mode, -1);
        String stringData6 = SharedPreferencesUtil.getStringData(context, str + BridgeUtil.UNDERLINE_STR + ZhiChiConstant.sobot_last_current_customer_fields, "");
        String stringData7 = SharedPreferencesUtil.getStringData(context, str + BridgeUtil.UNDERLINE_STR + ZhiChiConstant.sobot_last_current_isvip, "");
        String stringData8 = SharedPreferencesUtil.getStringData(context, str + BridgeUtil.UNDERLINE_STR + ZhiChiConstant.sobot_last_current_vip_level, "");
        String stringData9 = SharedPreferencesUtil.getStringData(context, str + BridgeUtil.UNDERLINE_STR + ZhiChiConstant.sobot_last_current_user_label, "");
        String stringData10 = SharedPreferencesUtil.getStringData(context, str + BridgeUtil.UNDERLINE_STR + ZhiChiConstant.sobot_last_current_robot_alias, "");
        if (!stringData.equals(information.getPartnerid() == null ? "" : information.getPartnerid())) {
            LogUtils.i("uid发生了变化，重新初始化..............");
            return true;
        }
        if (!stringData2.equals(information.getChoose_adminid() == null ? "" : information.getChoose_adminid())) {
            LogUtils.i("转入的指定客服发生了变化，重新初始化..............");
            return true;
        }
        if (!stringData3.equals(information.getRobotCode() == null ? "" : information.getRobotCode())) {
            LogUtils.i("指定机器人发生变化，重新初始化..............");
            return true;
        }
        if (!stringData10.equals(information.getRobot_alias() == null ? "" : information.getRobot_alias())) {
            LogUtils.i("指定机器人别名发生变化，重新初始化..............");
            return true;
        }
        if (!stringData4.equals(information.getRemark() == null ? "" : information.getRemark())) {
            LogUtils.i("备注发生变化，重新初始化..............");
            return true;
        }
        if (!stringData5.equals(information.getGroupid() == null ? "" : information.getGroupid())) {
            LogUtils.i("技能组发生变化，重新初始化..............");
            return true;
        } else if (intData != information.getService_mode()) {
            LogUtils.i("接入模式发生变化，重新初始化..............");
            return true;
        } else {
            if (!stringData6.equals(information.getCustomer_fields() == null ? "" : information.getCustomer_fields())) {
                LogUtils.i("自定义字段发生变化，重新初始化..............");
                return true;
            }
            if (!stringData7.equals(information.getIsVip() == null ? "" : information.getIsVip())) {
                LogUtils.i("是否vip发生变化，重新初始化..............");
                return true;
            }
            if (!stringData8.equals(information.getVip_level() == null ? "" : information.getVip_level())) {
                LogUtils.i("vip级别发生变化，重新初始化..............");
                return true;
            }
            if (stringData9.equals(information.getUser_label() == null ? "" : information.getUser_label())) {
                return false;
            }
            LogUtils.i("用户标签发生变化，重新初始化..............");
            return true;
        }
    }

    public static boolean checkManualType(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Integer valueOf = Integer.valueOf(str2);
            String[] split = str.split(",");
            if (valueOf.intValue() == 1 && "1".equals(split[0])) {
                return true;
            }
            if (valueOf.intValue() == 9 && "1".equals(split[0])) {
                return true;
            }
            if (valueOf.intValue() == 11 && "1".equals(split[0])) {
                return true;
            }
            if (valueOf.intValue() == 12 && "1".equals(split[0])) {
                return true;
            }
            if (valueOf.intValue() == 14 && "1".equals(split[0])) {
                return true;
            }
            if (valueOf.intValue() == 2 && "1".equals(split[1])) {
                return true;
            }
            if (valueOf.intValue() == 4 && "1".equals(split[2])) {
                return true;
            }
            if (valueOf.intValue() == 3) {
                return "1".equals(split[3]);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private static String formatQuestionStr(String[] strArr, Map<String, String> map, SobotMultiDiaRespInfo sobotMultiDiaRespInfo) {
        if (sobotMultiDiaRespInfo == null || map == null || map.size() <= 0) {
            return "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put(BatteryManager.EXTRA_LEVEL, Integer.valueOf(sobotMultiDiaRespInfo.getLevel()));
        hashMap.put("conversationId", sobotMultiDiaRespInfo.getConversationId());
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= strArr.length) {
                    break;
                }
                hashMap.put(strArr[i2], map.get(strArr[i2]));
                i = i2 + 1;
            }
        }
        return GsonUtil.map2JsonByObjectMap(hashMap);
    }

    public static String getCurrentCid(ZhiChiInitModeBase zhiChiInitModeBase, List<String> list, int i) {
        String str = "-1";
        if (zhiChiInitModeBase != null) {
            str = zhiChiInitModeBase.getCid();
            if (i > 0) {
                return i > list.size() - 1 ? "-1" : list.get(i);
            }
        }
        return str;
    }

    public static ZhiChiMessageBase getCustomEvaluateMode(ZhiChiPushMessage zhiChiPushMessage) {
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
        zhiChiMessageBase.setSenderName(TextUtils.isEmpty(zhiChiPushMessage.getAname()) ? ResourceUtils.getResString(MyApplication.getInstance(), "sobot_cus_service") : zhiChiPushMessage.getAname());
        SobotEvaluateModel sobotEvaluateModel = new SobotEvaluateModel();
        sobotEvaluateModel.setIsQuestionFlag(zhiChiPushMessage.getIsQuestionFlag());
        sobotEvaluateModel.setIsResolved(zhiChiPushMessage.getIsQuestionFlag() == 1 ? 0 : -1);
        zhiChiMessageBase.setSobotEvaluateModel(sobotEvaluateModel);
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        zhiChiMessageBase.setSenderType(Constants.VIA_ACT_TYPE_TWENTY_EIGHT);
        zhiChiMessageBase.setAction(ZhiChiConstant.action_custom_evaluate);
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        return zhiChiMessageBase;
    }

    public static int getFileIcon(Context context, int i) {
        if (context == null) {
            return 0;
        }
        switch (i) {
            case 13:
                return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_doc");
            case 14:
                return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_ppt");
            case 15:
                return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_xls");
            case 16:
                return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_pdf");
            case 17:
                return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_mp3");
            case 18:
                return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_mp4");
            case 19:
                return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_rar");
            case 20:
                return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_txt");
            case 21:
                return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_unknow");
            default:
                return ResourceUtils.getIdByName(context, i.f7952c, "sobot_icon_file_unknow");
        }
    }

    public static int getFileType(File file) {
        if (file == null) {
            return 21;
        }
        try {
            String lowerCase = file.getName().toLowerCase();
            if (!lowerCase.endsWith("doc") && !lowerCase.endsWith("docx")) {
                if (!lowerCase.endsWith("ppt") && !lowerCase.endsWith("pptx")) {
                    if (!lowerCase.endsWith("xls") && !lowerCase.endsWith("xlsx")) {
                        if (lowerCase.endsWith("pdf")) {
                            return 16;
                        }
                        if (lowerCase.endsWith("mp3")) {
                            return 17;
                        }
                        if (lowerCase.endsWith("mp4")) {
                            return 18;
                        }
                        if (!lowerCase.endsWith("rar") && !lowerCase.endsWith("zip")) {
                            return lowerCase.endsWith("txt") ? 20 : 21;
                        }
                        return 19;
                    }
                    return 15;
                }
                return 14;
            }
            return 13;
        } catch (Exception e) {
            return 21;
        }
    }

    public static ZhiChiMessageBase getInLineHint(String str) {
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        zhiChiMessageBase.setSenderType("24");
        zhiChiMessageBase.setAction(ZhiChiConstant.action_remind_info_paidui);
        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        zhiChiReplyAnswer.setMsg(str);
        zhiChiReplyAnswer.setRemindType(3);
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        return zhiChiMessageBase;
    }

    public static ZhiChiMessageBase getLeaveMsgTip(String str) {
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        zhiChiReplyAnswer.setMsg(str);
        zhiChiReplyAnswer.setMsgType("0");
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        zhiChiMessageBase.setLeaveMsgFlag(true);
        zhiChiMessageBase.setSenderType("0");
        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
        return zhiChiMessageBase;
    }

    public static ZhiChiMessageBase getLocationModel(String str, SobotLocationModel sobotLocationModel) {
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        zhiChiReplyAnswer.setLocationData(sobotLocationModel);
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        zhiChiMessageBase.setId(str);
        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
        zhiChiReplyAnswer.setMsgType("22");
        zhiChiMessageBase.setSenderType("0");
        return zhiChiMessageBase;
    }

    public static String getLogicAvatar(Context context, boolean z, String str, String str2) {
        int intData;
        if (!z && SobotChatAvatarDisplayMode.Default.getValue() != (intData = SharedPreferencesUtil.getIntData(context, ZhiChiConstant.SOBOT_CHAT_AVATAR_DISPLAY_MODE, SobotChatAvatarDisplayMode.Default.getValue()))) {
            if (SobotChatAvatarDisplayMode.ShowFixedAvatar.getValue() != intData) {
                return (SobotChatAvatarDisplayMode.ShowCompanyAvatar.getValue() != intData || TextUtils.isEmpty(str2)) ? str : str2;
            }
            String stringData = SharedPreferencesUtil.getStringData(context, ZhiChiConstant.SOBOT_CHAT_AVATAR_DISPLAY_CONTENT, "");
            return !TextUtils.isEmpty(stringData) ? stringData : str;
        }
        return str;
    }

    public static String getLogicTitle(Context context, boolean z, String str, String str2) {
        int intData;
        if (!z && SobotChatTitleDisplayMode.Default.getValue() != (intData = SharedPreferencesUtil.getIntData(context, ZhiChiConstant.SOBOT_CHAT_TITLE_DISPLAY_MODE, SobotChatTitleDisplayMode.Default.getValue()))) {
            if (SobotChatTitleDisplayMode.ShowFixedText.getValue() != intData) {
                return (SobotChatTitleDisplayMode.ShowCompanyName.getValue() != intData || TextUtils.isEmpty(str2)) ? str : str2;
            }
            String stringData = SharedPreferencesUtil.getStringData(context, ZhiChiConstant.SOBOT_CHAT_TITLE_DISPLAY_CONTENT, "");
            return !TextUtils.isEmpty(stringData) ? stringData : str;
        }
        return str;
    }

    public static String getMessageContentByOutLineType(Context context, ZhiChiInitModeBase zhiChiInitModeBase, int i) {
        String str;
        context.getResources();
        str = "";
        if (1 == i) {
            String str2 = str;
            if (zhiChiInitModeBase.isServiceEndPushFlag()) {
                str2 = str;
                if (!TextUtils.isEmpty(zhiChiInitModeBase.getServiceEndPushMsg())) {
                    str2 = zhiChiInitModeBase.getServiceEndPushMsg();
                }
            }
            return str2;
        } else if (2 == i) {
            String str3 = str;
            if (zhiChiInitModeBase.isServiceEndPushFlag()) {
                str3 = str;
                if (!TextUtils.isEmpty(zhiChiInitModeBase.getServiceEndPushMsg())) {
                    str3 = zhiChiInitModeBase.getServiceEndPushMsg();
                }
            }
            return str3;
        } else if (3 == i) {
            return ResourceUtils.getResString(context, ZhiChiConstant.sobot_outline_leverByManager);
        } else {
            if (4 != i) {
                return 5 == i ? ResourceUtils.getResString(context, ZhiChiConstant.sobot_outline_leverByManager) : 6 == i ? ResourceUtils.getResString(context, "sobot_outline_openNewWindows") : 99 == i ? ResourceUtils.getResString(context, "sobot_outline_leavemsg") : 9 == i ? ResourceUtils.getResString(context, "sobot_line_up_close_chat") : ResourceUtils.getResString(context, ZhiChiConstant.sobot_outline_leverByManager);
            }
            str = ZCSobotApi.getCurrentInfoSetting(context) != null ? ZCSobotApi.getCurrentInfoSetting(context).getUser_out_word() : "";
            return !TextUtils.isEmpty(str) ? str : zhiChiInitModeBase != null ? zhiChiInitModeBase.getUserOutWord() : ResourceUtils.getResString(context, ZhiChiConstant.sobot_outline_leverByManager);
        }
    }

    public static ZhiChiMessageBase getMuitidiaLeaveMsgModel(String str, String str2) {
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        zhiChiReplyAnswer.setMsg(str2);
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        zhiChiMessageBase.setId(str);
        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
        zhiChiReplyAnswer.setMsgType(ZhiChiConstant.message_type_muiti_leave_msg);
        zhiChiMessageBase.setSenderType("0");
        return zhiChiMessageBase;
    }

    public static String getMultiMsgTitle(SobotMultiDiaRespInfo sobotMultiDiaRespInfo) {
        return sobotMultiDiaRespInfo == null ? "" : MsgType.UID_GROUP_AT_ALL.equals(sobotMultiDiaRespInfo.getRetCode()) ? sobotMultiDiaRespInfo.getEndFlag() ? !TextUtils.isEmpty(sobotMultiDiaRespInfo.getAnswerStrip()) ? sobotMultiDiaRespInfo.getAnswerStrip() : sobotMultiDiaRespInfo.getAnswer() : sobotMultiDiaRespInfo.getRemindQuestion() : sobotMultiDiaRespInfo.getRetErrorMsg();
    }

    public static ZhiChiMessageBase getNoticeModel(Context context, ZhiChiInitModeBase zhiChiInitModeBase) {
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        String announceMsg = zhiChiInitModeBase.getAnnounceMsg();
        String str = announceMsg;
        if (!TextUtils.isEmpty(announceMsg)) {
            str = announceMsg.replace("<p>", "").replace("</p>", "").replace("<br/>", "").replace("\n", "");
        }
        zhiChiReplyAnswer.setMsg(str);
        zhiChiReplyAnswer.setMsgType("0");
        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        zhiChiMessageBase.setSenderType("32");
        return zhiChiMessageBase;
    }

    public static ZhiChiMessageBase getQuestionRecommendData(ZhiChiInitModeBase zhiChiInitModeBase, SobotQuestionRecommend sobotQuestionRecommend) {
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        zhiChiMessageBase.setSenderType("29");
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
        zhiChiReplyAnswer.setQuestionRecommend(sobotQuestionRecommend);
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        zhiChiMessageBase.setSenderFace(zhiChiInitModeBase.getRobotLogo());
        zhiChiMessageBase.setSender(zhiChiInitModeBase.getRobotName());
        zhiChiMessageBase.setSenderName(zhiChiInitModeBase.getRobotName());
        return zhiChiMessageBase;
    }

    public static int getResDrawableId(Context context, String str) {
        return ResourceUtils.getIdByName(context, i.f7952c, str);
    }

    public static int getResId(Context context, String str) {
        return ResourceUtils.getIdByName(context, "id", str);
    }

    public static int getResLayoutId(Context context, String str) {
        return ResourceUtils.getIdByName(context, "layout", str);
    }

    public static String getResString(Context context, String str) {
        return ResourceUtils.getResString(context, str);
    }

    public static int getResStringId(Context context, String str) {
        return ResourceUtils.getIdByName(context, "string", str);
    }

    public static ZhiChiMessageBase getRobotTransferTip(Context context, ZhiChiInitModeBase zhiChiInitModeBase) {
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        zhiChiReplyAnswer.setMsg(ResourceUtils.getResString(context, "sobot_robot_auto_transfer_tip"));
        zhiChiReplyAnswer.setMsgType("0");
        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        zhiChiMessageBase.setSenderFace(zhiChiInitModeBase.getRobotLogo());
        zhiChiMessageBase.setSender(zhiChiInitModeBase.getRobotName());
        zhiChiMessageBase.setSenderType("1");
        zhiChiMessageBase.setSenderName(zhiChiInitModeBase.getRobotName());
        return zhiChiMessageBase;
    }

    public static ZhiChiMessageBase getServiceAcceptTip(Context context, String str) {
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        zhiChiMessageBase.setSenderType("24");
        zhiChiMessageBase.setAction(ZhiChiConstant.action_remind_connt_success);
        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        zhiChiReplyAnswer.setMsgType(null);
        zhiChiReplyAnswer.setMsg(getResString(context, "sobot_service_accept_start") + " " + str + " " + getResString(context, "sobot_service_accept_end"));
        zhiChiReplyAnswer.setRemindType(4);
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        return zhiChiMessageBase;
    }

    public static ZhiChiMessageBase getServiceHelloTip(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
        String str4 = str;
        if (TextUtils.isEmpty(str)) {
            str4 = "";
        }
        zhiChiMessageBase.setSenderName(str4);
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        zhiChiReplyAnswer.setMsgType("0");
        zhiChiMessageBase.setSenderType("2");
        zhiChiReplyAnswer.setMsg(str3);
        zhiChiMessageBase.setSenderFace(str2);
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        return zhiChiMessageBase;
    }

    public static ZhiChiMessageBase getTipByText(String str) {
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        zhiChiMessageBase.setSenderType("24");
        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        zhiChiReplyAnswer.setMsg(str);
        zhiChiReplyAnswer.setRemindType(8);
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        return zhiChiMessageBase;
    }

    public static ZhiChiMessageBase getUnreadMode(Context context) {
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        zhiChiMessageBase.setSenderType("24");
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        zhiChiReplyAnswer.setMsg(ResourceUtils.getResString(context, "sobot_no_read"));
        zhiChiReplyAnswer.setRemindType(7);
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        return zhiChiMessageBase;
    }

    public static ZhiChiMessageBase getUploadFileModel(Context context, String str, File file) {
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        SobotCacheFile sobotCacheFile = new SobotCacheFile();
        sobotCacheFile.setMsgId(str);
        sobotCacheFile.setFilePath(file.getAbsolutePath());
        sobotCacheFile.setFileName(file.getName());
        sobotCacheFile.setFileType(getFileType(file));
        sobotCacheFile.setFileSize(Formatter.formatFileSize(context, file.length()));
        zhiChiReplyAnswer.setCacheFile(sobotCacheFile);
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        zhiChiMessageBase.setId(str);
        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
        zhiChiReplyAnswer.setMsgType("12");
        zhiChiMessageBase.setSenderType("0");
        return zhiChiMessageBase;
    }

    public static ZhiChiMessageBase getUploadVideoModel(Context context, String str, File file, String str2) {
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        SobotCacheFile sobotCacheFile = new SobotCacheFile();
        sobotCacheFile.setMsgId(str);
        sobotCacheFile.setFilePath(file.getAbsolutePath());
        sobotCacheFile.setFileName(file.getName());
        sobotCacheFile.setSnapshot(str2);
        sobotCacheFile.setFileType(getFileType(file));
        sobotCacheFile.setFileSize(Formatter.formatFileSize(context, file.length()));
        zhiChiReplyAnswer.setCacheFile(sobotCacheFile);
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        zhiChiMessageBase.setId(str);
        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
        zhiChiReplyAnswer.setMsgType("23");
        zhiChiMessageBase.setSenderType("0");
        return zhiChiMessageBase;
    }

    public static TextView initAnswerItemTextView(Context context, boolean z) {
        TextView textView = new TextView(context);
        textView.setTextSize(14.0f);
        textView.setPadding(0, ScreenUtils.dip2px(context, 7.0f), 0, ScreenUtils.dip2px(context, 7.0f));
        textView.setLineSpacing(2.0f, 1.0f);
        textView.setTextColor(context.getResources().getColor(z ? -1 != SobotUIConfig.sobot_chat_left_textColor ? SobotUIConfig.sobot_chat_left_textColor : ResourceUtils.getIdByName(context, "color", "sobot_color_suggestion_history") : -1 != SobotUIConfig.sobot_chat_left_link_textColor ? SobotUIConfig.sobot_chat_left_link_textColor : ResourceUtils.getIdByName(context, "color", "sobot_color_link")));
        return textView;
    }

    public static boolean isEvaluationCompletedExit(Context context, boolean z, int i) {
        return SharedPreferencesUtil.getBooleanData(context, ZhiChiConstant.SOBOT_CHAT_EVALUATION_COMPLETED_EXIT, false) && z && i == 302;
    }

    public static boolean isFreeAccount(int i) {
        return i == 0 || i == -1;
    }

    private static boolean isNeedWarning(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (i == 0 || i == 1) && str.contains(ResourceUtils.getResString(MyApplication.getInstance(), "sobot_ver_code"));
    }

    public static boolean isQuestionFlag(SobotEvaluateModel sobotEvaluateModel) {
        boolean z = false;
        if (sobotEvaluateModel != null) {
            z = false;
            if (sobotEvaluateModel.getIsQuestionFlag() == 1) {
                z = true;
            }
        }
        return z;
    }

    public static void msgLogicalProcess(ZhiChiInitModeBase zhiChiInitModeBase, SobotMsgAdapter sobotMsgAdapter, ZhiChiPushMessage zhiChiPushMessage) {
        if (zhiChiInitModeBase == null || !isNeedWarning(zhiChiPushMessage.getContent(), zhiChiInitModeBase.getAccountStatus())) {
            return;
        }
        sobotMsgAdapter.justAddData(getTipByText(ResourceUtils.getResString(MyApplication.getInstance(), "sobot_money_trading_tip")));
    }

    public static File openCamera(Activity activity) {
        return openCamera(activity, null);
    }

    public static File openCamera(Activity activity, Fragment fragment) {
        Uri uri;
        File file = new File(SobotPathManager.getInstance().getPicDir() + System.currentTimeMillis() + ".jpg");
        IOUtils.createFolder(file.getParentFile());
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                uri = FileOpenHelper.getUri(activity, file);
            } catch (Exception e) {
                e.printStackTrace();
                uri = null;
            }
        } else {
            uri = Uri.fromFile(file);
        }
        if (uri == null) {
            return null;
        }
        try {
            Intent putExtra = new Intent(MediaStore.ACTION_IMAGE_CAPTURE).putExtra(MediaStore.EXTRA_OUTPUT, uri);
            if (fragment != null) {
                fragment.startActivityForResult(putExtra, 702);
                return file;
            }
            activity.startActivityForResult(putExtra, 702);
            return file;
        } catch (Exception e2) {
            ToastUtil.showCustomToast(activity, "无法打开相机");
            e2.printStackTrace();
            return file;
        }
    }

    public static void openSelectPic(Activity activity) {
        openSelectPic(activity, null);
    }

    public static void openSelectPic(Activity activity, Fragment fragment) {
        Intent intent;
        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
        } else {
            intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        }
        try {
            if (fragment != null) {
                fragment.startActivityForResult(intent, 701);
            } else {
                activity.startActivityForResult(intent, 701);
            }
        } catch (Exception e) {
            ToastUtil.showToast(activity.getApplicationContext(), ResourceUtils.getResString(activity, "sobot_not_open_album"));
        }
    }

    public static void openSelectVedio(Activity activity) {
        Intent intent;
        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("video/*");
        } else {
            intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
            intent.setDataAndType(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, "video/*");
        }
        try {
            activity.startActivityForResult(intent, 701);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                activity.startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI), 701);
            } catch (Exception e2) {
                e2.printStackTrace();
                ToastUtil.showToast(activity.getApplicationContext(), ResourceUtils.getResString(activity, "sobot_not_open_album"));
            }
        }
    }

    public static void openSelectVedio(Activity activity, Fragment fragment) {
        Intent intent;
        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("video/*");
        } else {
            intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
            intent.setDataAndType(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, "video/*");
        }
        try {
            if (fragment != null) {
                fragment.startActivityForResult(intent, 701);
            } else {
                activity.startActivityForResult(intent, 701);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Intent intent2 = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
            try {
                if (fragment != null) {
                    fragment.startActivityForResult(intent2, 701);
                } else {
                    activity.startActivityForResult(intent2, 701);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                ToastUtil.showToast(activity.getApplicationContext(), ResourceUtils.getResString(activity, "sobot_not_open_album"));
            }
        }
    }

    public static void saveLastMsgInfo(Context context, Information information, String str, ZhiChiInitModeBase zhiChiInitModeBase, List<ZhiChiMessageBase> list) {
        String str2;
        String str3;
        SobotCache sobotCache = SobotCache.get(context);
        SobotMsgCenterModel sobotMsgCenterModel = new SobotMsgCenterModel();
        sobotMsgCenterModel.setInfo(information);
        sobotMsgCenterModel.setFace(zhiChiInitModeBase.getCompanyLogo());
        sobotMsgCenterModel.setName(zhiChiInitModeBase.getCompanyName());
        sobotMsgCenterModel.setAppkey(str);
        sobotMsgCenterModel.setUnreadCount(0);
        if (list != null) {
            int size = list.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                ZhiChiMessageBase zhiChiMessageBase = list.get(i);
                if ("26".equals(zhiChiMessageBase.getSenderType())) {
                    size = i;
                } else {
                    sobotMsgCenterModel.setSenderName(zhiChiMessageBase.getSenderName());
                    if (TextUtils.isEmpty(zhiChiMessageBase.getSenderFace())) {
                        sobotMsgCenterModel.setSenderFace("https://img.sobot.com/console/common/face/user.png");
                    } else {
                        sobotMsgCenterModel.setSenderFace("");
                    }
                    sobotMsgCenterModel.setLastMsg("23".equals(zhiChiMessageBase.getSenderType()) ? ResourceUtils.getResString(context, "sobot_upload") : "25".equals(zhiChiMessageBase.getSenderType()) ? ResourceUtils.getResString(context, "sobot_chat_type_voice") : zhiChiMessageBase.getAnswer() != null ? "1".equals(zhiChiMessageBase.getAnswer().getMsgType()) ? ResourceUtils.getResString(context, "sobot_upload") : zhiChiMessageBase.getAnswer().getMsg() == null ? "24".equals(zhiChiMessageBase.getAnswer().getMsgType()) ? ResourceUtils.getResString(context, "sobot_chat_type_goods") : "25".equals(zhiChiMessageBase.getAnswer().getMsgType()) ? ResourceUtils.getResString(context, "sobot_chat_type_card") : "23".equals(zhiChiMessageBase.getAnswer().getMsgType()) ? ResourceUtils.getResString(context, "sobot_upload_video") : "12".equals(zhiChiMessageBase.getAnswer().getMsgType()) ? ResourceUtils.getResString(context, "sobot_choose_file") : ResourceUtils.getResString(context, "sobot_chat_type_other_msg") : GsonUtil.isMultiRoundSession(zhiChiMessageBase) ? zhiChiMessageBase.getAnswer().getMultiDiaRespInfo().getAnswer() : GsonUtil.isMultiRoundSession(zhiChiMessageBase) ? zhiChiMessageBase.getAnswer().getMultiDiaRespInfo().getAnswer() : zhiChiMessageBase.getAnswer().getMsg() : "");
                    if (TextUtils.isEmpty(zhiChiMessageBase.getT())) {
                        str2 = Calendar.getInstance().getTime().getTime() + "";
                    } else {
                        str2 = zhiChiMessageBase.getT();
                    }
                    sobotMsgCenterModel.setLastDate(DateUtil.toDate(Long.parseLong(str2), DateUtil.DATE_FORMAT));
                    if (TextUtils.isEmpty(zhiChiMessageBase.getT())) {
                        str3 = Calendar.getInstance().getTime().getTime() + "";
                    } else {
                        str3 = zhiChiMessageBase.getT();
                    }
                    sobotMsgCenterModel.setLastDateTime(str3);
                }
            }
            sobotCache.put(SobotMsgManager.getMsgCenterDataKey(str, information.getPartnerid()), sobotMsgCenterModel);
            ArrayList arrayList = (ArrayList) sobotCache.getAsObject(SobotMsgManager.getMsgCenterListKey(information.getPartnerid()));
            ArrayList arrayList2 = arrayList;
            if (arrayList == null) {
                arrayList2 = new ArrayList();
            }
            if (!arrayList2.contains(str)) {
                arrayList2.add(str);
                sobotCache.put(SobotMsgManager.getMsgCenterListKey(information.getPartnerid()), arrayList2);
            }
            SharedPreferencesUtil.removeKey(context, ZhiChiConstant.SOBOT_CURRENT_IM_APPID);
            Intent intent = new Intent(ZhiChiConstant.SOBOT_ACTION_UPDATE_LAST_MSG);
            intent.putExtra("lastMsg", sobotMsgCenterModel);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_LAST_MSG_CONTENT, sobotMsgCenterModel.getLastMsg());
        }
    }

    public static void saveOptionSet(Context context, Information information) {
        SharedPreferencesUtil.saveIntData(context, "robot_current_themeImg", information.getTitleImgId());
        if (TextUtils.isEmpty(information.getPartnerid())) {
            information.setEquipmentId(CommonUtils.getPartnerId(context));
        }
    }

    public static void sendImageMessageToHandler(String str, Handler handler, String str2) {
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        zhiChiReplyAnswer.setMsg(str);
        zhiChiMessageBase.setAnswer(zhiChiReplyAnswer);
        zhiChiMessageBase.setId(str2);
        zhiChiMessageBase.setT(Calendar.getInstance().getTime().getTime() + "");
        zhiChiMessageBase.setSendSuccessState(2);
        zhiChiMessageBase.setSenderType("23");
        Message message = new Message();
        message.what = 601;
        message.obj = zhiChiMessageBase;
        handler.sendMessage(message);
    }

    public static void sendMultiRoundQuestions(Context context, SobotMultiDiaRespInfo sobotMultiDiaRespInfo, Map<String, String> map, SobotMsgAdapter.SobotMsgCallBack sobotMsgCallBack) {
        if (context == null || sobotMultiDiaRespInfo == null || map == null) {
            return;
        }
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        String str = "{\"interfaceRetList\":[" + GsonUtil.map2Json(map) + "],\"template\":" + sobotMultiDiaRespInfo.getTemplate() + com.alipay.sdk.util.i.d;
        zhiChiMessageBase.setContent(formatQuestionStr(sobotMultiDiaRespInfo.getOutPutParamList(), map, sobotMultiDiaRespInfo));
        zhiChiMessageBase.setId(System.currentTimeMillis() + "");
        if (sobotMsgCallBack != null) {
            sobotMsgCallBack.sendMessageToRobot(zhiChiMessageBase, 4, 2, str, map.get("title"));
        }
    }

    public static void sendPicByFilePath(Context context, String str, SobotSendFileListener sobotSendFileListener, boolean z) {
        Bitmap bitmap;
        String saveImageFile;
        if (Build.VERSION.SDK_INT >= 29) {
            if (!TextUtils.isEmpty(str)) {
                sobotSendFileListener.onSuccess(str);
                return;
            }
            ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_pic_type_error"));
            sobotSendFileListener.onError();
            return;
        }
        Bitmap compress = SobotBitmapUtil.compress(str, context, z);
        if (compress == null) {
            ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_pic_type_error"));
            sobotSendFileListener.onError();
            return;
        }
        try {
            int readPictureDegree = ImageUtils.readPictureDegree(str);
            bitmap = compress;
            if (readPictureDegree > 0) {
                bitmap = ImageUtils.rotateBitmap(compress, readPictureDegree);
            }
        } catch (Exception e) {
            e.printStackTrace();
            bitmap = compress;
        }
        if (str.endsWith(".gif") || str.endsWith(".GIF")) {
            try {
                String encode = MD5Util.encode(str);
                saveImageFile = FileUtil.saveImageFile(context, ImageUtils.getImageContentUri(context, str), encode + FileUtil.getFileEndWith(str), str);
            } catch (Exception e2) {
                e2.printStackTrace();
                ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_pic_type_error"));
                return;
            }
        } else {
            String picDir = SobotPathManager.getInstance().getPicDir();
            IOUtils.createFolder(picDir);
            String str2 = picDir + MD5Util.encode(str) + "_tmp.jpg";
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(str2));
                saveImageFile = str2;
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
                ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_pic_type_error"));
                return;
            }
        }
        sobotSendFileListener.onSuccess(saveImageFile);
    }

    public static void sendPicByUri(Context context, Handler handler, Uri uri, ZhiChiInitModeBase zhiChiInitModeBase, ListView listView, SobotMsgAdapter sobotMsgAdapter, boolean z) {
        if (zhiChiInitModeBase == null) {
            return;
        }
        String path = ImageUtils.getPath(context, uri);
        LogUtils.i("picturePath:" + path);
        if (TextUtils.isEmpty(path)) {
            File file = new File(uri.getPath());
            if (file.exists()) {
                sendPicLimitBySize(file.getAbsolutePath(), zhiChiInitModeBase.getCid(), zhiChiInitModeBase.getPartnerid(), handler, context, listView, sobotMsgAdapter, z);
                return;
            } else {
                ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_not_find_pic"));
                return;
            }
        }
        File file2 = new File(path);
        if (file2.exists() && file2.isFile()) {
            sendPicLimitBySize(path, zhiChiInitModeBase.getCid(), zhiChiInitModeBase.getPartnerid(), handler, context, listView, sobotMsgAdapter, z);
        }
    }

    public static void sendPicByUriPost(Context context, Uri uri, SobotSendFileListener sobotSendFileListener, boolean z) {
        String path = ImageUtils.getPath(context, uri);
        if (!TextUtils.isEmpty(path)) {
            sendPicByFilePath(context, path, sobotSendFileListener, z);
        } else if (new File(uri.getPath()).exists()) {
            sendPicByFilePath(context, path, sobotSendFileListener, z);
        } else {
            SobotDialogUtils.stopProgressDialog(context);
            ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_not_find_pic"));
        }
    }

    public static void sendPicLimitBySize(String str, String str2, String str3, Handler handler, Context context, ListView listView, SobotMsgAdapter sobotMsgAdapter, boolean z) {
        Bitmap bitmap;
        String saveImageFile;
        if (Build.VERSION.SDK_INT >= 29) {
            if (TextUtils.isEmpty(str)) {
                ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_pic_type_error"));
                return;
            } else if (CommonUtils.getFileSize(str) >= 20971520) {
                ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_file_lt_8M"));
                return;
            } else {
                String str4 = System.currentTimeMillis() + "";
                sendImageMessageToHandler(str, handler, str4);
                sendPicture(context, str2, str3, str, handler, str4, listView, sobotMsgAdapter);
                return;
            }
        }
        Bitmap compress = SobotBitmapUtil.compress(str, context, z);
        if (compress == null) {
            ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_pic_type_error"));
            return;
        }
        try {
            int readPictureDegree = ImageUtils.readPictureDegree(str);
            bitmap = compress;
            if (readPictureDegree > 0) {
                bitmap = ImageUtils.rotateBitmap(compress, readPictureDegree);
            }
        } catch (Exception e) {
            e.printStackTrace();
            bitmap = compress;
        }
        if (str.endsWith(".gif") || str.endsWith(".GIF")) {
            try {
                String encode = MD5Util.encode(str);
                saveImageFile = FileUtil.saveImageFile(context, ImageUtils.getImageContentUri(context, str), encode + FileUtil.getFileEndWith(str), str);
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        } else {
            String picDir = SobotPathManager.getInstance().getPicDir();
            IOUtils.createFolder(picDir);
            saveImageFile = picDir + MD5Util.encode(str) + "_tmp.jpg";
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(saveImageFile));
            } catch (Exception e3) {
                e3.printStackTrace();
                return;
            }
        }
        if (CommonUtils.getFileSize(saveImageFile) >= 20971520) {
            ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_file_lt_8M"));
            return;
        }
        String str5 = System.currentTimeMillis() + "";
        sendImageMessageToHandler(saveImageFile, handler, str5);
        sendPicture(context, str2, str3, saveImageFile, handler, str5, listView, sobotMsgAdapter);
    }

    public static void sendPicture(Context context, String str, String str2, String str3, final Handler handler, final String str4, final ListView listView, final SobotMsgAdapter sobotMsgAdapter) {
        SobotMsgManager.getInstance(context).getZhiChiApi().sendFile(str, str2, str3, "", new ResultCallBack<ZhiChiMessage>() { // from class: com.sobot.chat.utils.ChatUtils.2
            @Override // com.sobot.chat.api.ResultCallBack
            public void onFailure(Exception exc, String str5) {
                LogUtils.i("发送图片error:" + str5 + "exception:" + exc);
                if (String.this != null) {
                    Message obtainMessage = handler.obtainMessage();
                    obtainMessage.what = 401;
                    obtainMessage.obj = String.this;
                    handler.sendMessage(obtainMessage);
                }
            }

            @Override // com.sobot.chat.api.ResultCallBack
            public void onLoading(long j, long j2, boolean z) {
                LogUtils.i("发送图片 进度:" + j2);
                String str5 = String.this;
                if (str5 != null) {
                    int msgInfoPosition = sobotMsgAdapter.getMsgInfoPosition(str5);
                    LogUtils.i("发送图片 position:" + msgInfoPosition);
                    ChatUtils.updateProgressPartly((int) j2, msgInfoPosition, listView);
                }
            }

            @Override // com.sobot.chat.api.ResultCallBack
            public void onSuccess(ZhiChiMessage zhiChiMessage) {
                if (1 != Integer.parseInt(zhiChiMessage.getCode()) || String.this == null) {
                    return;
                }
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 402;
                obtainMessage.obj = String.this;
                handler.sendMessage(obtainMessage);
            }
        });
    }

    public static SobotEvaluateDialog showEvaluateDialog(Activity activity, boolean z, boolean z2, boolean z3, ZhiChiInitModeBase zhiChiInitModeBase, int i, int i2, String str, int i3, int i4, String str2, boolean z4, boolean z5) {
        if (zhiChiInitModeBase == null) {
            return null;
        }
        SobotEvaluateDialog sobotEvaluateDialog = ScreenUtils.isFullScreen(activity) ? new SobotEvaluateDialog(activity, z, z2, z3, zhiChiInitModeBase, i, i2, str, i3, i4, str2, z4, z5, ResourceUtils.getIdByName(activity, "style", "sobot_FullScreenDialogStyle")) : new SobotEvaluateDialog(activity, z, z2, z3, zhiChiInitModeBase, i, i2, str, i3, i4, str2, z4, z5);
        sobotEvaluateDialog.setCanceledOnTouchOutside(true);
        sobotEvaluateDialog.show();
        return sobotEvaluateDialog;
    }

    public static SobotRobotListDialog showRobotListDialog(Activity activity, ZhiChiInitModeBase zhiChiInitModeBase, SobotRobotListDialog.SobotRobotListListener sobotRobotListListener) {
        if (activity == null || zhiChiInitModeBase == null || sobotRobotListListener == null) {
            return null;
        }
        SobotRobotListDialog sobotRobotListDialog = new SobotRobotListDialog(activity, zhiChiInitModeBase.getPartnerid(), zhiChiInitModeBase.getRobotid(), sobotRobotListListener);
        sobotRobotListDialog.setCanceledOnTouchOutside(true);
        sobotRobotListDialog.show();
        return sobotRobotListDialog;
    }

    public static void showThankDialog(final Activity activity, Handler handler, final boolean z) {
        CustomToast.makeText(activity.getApplicationContext(), ResourceUtils.getResString(activity, "sobot_thank_dialog_hint"), 1000, ResourceUtils.getDrawableId(activity.getApplicationContext(), "sobot_iv_login_right")).show();
        handler.postDelayed(new Runnable() { // from class: com.sobot.chat.utils.ChatUtils.1
            @Override // java.lang.Runnable
            public void run() {
                if (Activity.this.isFinishing() || !z) {
                    return;
                }
                Activity.this.finish();
            }
        }, 2000L);
    }

    public static SobotTicketEvaluateDialog showTicketEvaluateDialog(Activity activity, SobotUserTicketEvaluate sobotUserTicketEvaluate) {
        SobotTicketEvaluateDialog sobotTicketEvaluateDialog = new SobotTicketEvaluateDialog(activity, sobotUserTicketEvaluate);
        sobotTicketEvaluateDialog.setCanceledOnTouchOutside(true);
        sobotTicketEvaluateDialog.show();
        return sobotTicketEvaluateDialog;
    }

    public static void updateProgressPartly(int i, int i2, ListView listView) {
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int lastVisiblePosition = listView.getLastVisiblePosition();
        if (i2 < firstVisiblePosition || i2 > lastVisiblePosition) {
            return;
        }
        View childAt = listView.getChildAt(i2 - firstVisiblePosition);
        if (childAt.getTag() instanceof ImageMessageHolder) {
            ((ImageMessageHolder) childAt.getTag()).sobot_pic_progress_round.setProgress(i);
        }
    }

    public static void userLogout(Context context) {
        SharedPreferencesUtil.saveBooleanData(context, ZhiChiConstant.SOBOT_IS_EXIT, true);
        String stringData = SharedPreferencesUtil.getStringData(context, Const.SOBOT_CID, "");
        String stringData2 = SharedPreferencesUtil.getStringData(context, Const.SOBOT_UID, "");
        ZCSobotApi.closeIMConnection(context);
        if (TextUtils.isEmpty(stringData) || TextUtils.isEmpty(stringData2)) {
            return;
        }
        SobotMsgManager.getInstance(context).getZhiChiApi().out(stringData, stringData2, new StringResultCallBack<CommonModel>() { // from class: com.sobot.chat.utils.ChatUtils.3
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(CommonModel commonModel) {
            }
        });
    }
}
