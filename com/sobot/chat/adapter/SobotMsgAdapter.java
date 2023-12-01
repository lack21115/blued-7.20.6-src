package com.sobot.chat.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sobot.chat.ZCSobotApi;
import com.sobot.chat.adapter.base.SobotBaseAdapter;
import com.sobot.chat.api.apiUtils.GsonUtil;
import com.sobot.chat.api.model.SobotEvaluateModel;
import com.sobot.chat.api.model.SobotMultiDiaRespInfo;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.api.model.ZhiChiReplyAnswer;
import com.sobot.chat.utils.DateUtil;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.VersionUtils;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.viewHolder.CardMessageHolder;
import com.sobot.chat.viewHolder.ConsultMessageHolder;
import com.sobot.chat.viewHolder.CusEvaluateMessageHolder;
import com.sobot.chat.viewHolder.FileMessageHolder;
import com.sobot.chat.viewHolder.ImageMessageHolder;
import com.sobot.chat.viewHolder.LocationMessageHolder;
import com.sobot.chat.viewHolder.NoticeMessageHolder;
import com.sobot.chat.viewHolder.OrderCardMessageHolder;
import com.sobot.chat.viewHolder.RemindMessageHolder;
import com.sobot.chat.viewHolder.RetractedMessageHolder;
import com.sobot.chat.viewHolder.RichTextMessageHolder;
import com.sobot.chat.viewHolder.RobotAnswerItemsMsgHolder;
import com.sobot.chat.viewHolder.RobotKeyWordMessageHolder;
import com.sobot.chat.viewHolder.RobotQRMessageHolder;
import com.sobot.chat.viewHolder.RobotTemplateMessageHolder1;
import com.sobot.chat.viewHolder.RobotTemplateMessageHolder2;
import com.sobot.chat.viewHolder.RobotTemplateMessageHolder3;
import com.sobot.chat.viewHolder.RobotTemplateMessageHolder4;
import com.sobot.chat.viewHolder.RobotTemplateMessageHolder5;
import com.sobot.chat.viewHolder.RobotTemplateMessageHolder6;
import com.sobot.chat.viewHolder.SobotChatMsgItemSDKHistoryR;
import com.sobot.chat.viewHolder.SobotMuitiLeavemsgMessageHolder;
import com.sobot.chat.viewHolder.SystemMessageHolder;
import com.sobot.chat.viewHolder.TextMessageHolder;
import com.sobot.chat.viewHolder.VideoMessageHolder;
import com.sobot.chat.viewHolder.VoiceMessageHolder;
import com.sobot.chat.viewHolder.base.MessageHolderBase;
import com.tencent.connect.common.Constants;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotMsgAdapter.class */
public class SobotMsgAdapter extends SobotBaseAdapter<ZhiChiMessageBase> {
    public static final int MSG_TYPE_AUDIO_R = 6;
    public static final int MSG_TYPE_CARD_L = 27;
    public static final int MSG_TYPE_CARD_R = 24;
    public static final int MSG_TYPE_CONSULT = 7;
    public static final int MSG_TYPE_CUSTOM_EVALUATE = 8;
    public static final int MSG_TYPE_FILE_L = 19;
    public static final int MSG_TYPE_FILE_R = 20;
    public static final int MSG_TYPE_FRAUD_PREVENTION = 29;
    private static final int MSG_TYPE_ILLEGAL = 0;
    public static final int MSG_TYPE_IMG_L = 4;
    public static final int MSG_TYPE_IMG_R = 5;
    public static final int MSG_TYPE_LOCATION_R = 22;
    public static final int MSG_TYPE_MUITI_LEAVE_MSG_R = 31;
    public static final int MSG_TYPE_MULTI_ROUND_R = 12;
    public static final int MSG_TYPE_NOTICE = 23;
    public static final int MSG_TYPE_RETRACTED_MSG = 16;
    public static final int MSG_TYPE_RICH = 3;
    public static final int MSG_TYPE_ROBOT_ANSWER_ITEMS = 17;
    public static final int MSG_TYPE_ROBOT_KEYWORD_ITEMS = 18;
    public static final int MSG_TYPE_ROBOT_ORDERCARD_L = 26;
    public static final int MSG_TYPE_ROBOT_ORDERCARD_R = 25;
    public static final int MSG_TYPE_ROBOT_QUESTION_RECOMMEND = 15;
    public static final int MSG_TYPE_ROBOT_TEMPLATE1 = 9;
    public static final int MSG_TYPE_ROBOT_TEMPLATE2 = 10;
    public static final int MSG_TYPE_ROBOT_TEMPLATE3 = 11;
    public static final int MSG_TYPE_ROBOT_TEMPLATE4 = 13;
    public static final int MSG_TYPE_ROBOT_TEMPLATE5 = 14;
    public static final int MSG_TYPE_ROBOT_TEMPLATE6 = 28;
    public static final int MSG_TYPE_TIP = 2;
    public static final int MSG_TYPE_TXT_L = 0;
    public static final int MSG_TYPE_TXT_R = 1;
    public static final int MSG_TYPE_VIDEO_L = 30;
    public static final int MSG_TYPE_VIDEO_R = 21;
    private static final String[] layoutRes = {"sobot_chat_msg_item_txt_l", "sobot_chat_msg_item_txt_r", "sobot_chat_msg_item_tip", "sobot_chat_msg_item_rich", "sobot_chat_msg_item_imgt_l", "sobot_chat_msg_item_imgt_r", "sobot_chat_msg_item_audiot_r", "sobot_chat_msg_item_consult", "sobot_chat_msg_item_evaluate", "sobot_chat_msg_item_template1_l", "sobot_chat_msg_item_template2_l", "sobot_chat_msg_item_template3_l", "sobot_chat_msg_item_sdk_history_r", "sobot_chat_msg_item_template4_l", "sobot_chat_msg_item_template5_l", "sobot_chat_msg_item_question_recommend", "sobot_chat_msg_item_retracted_msg", "sobot_chat_msg_item_robot_answer_items_l", "sobot_chat_msg_item_robot_keyword_items_l", "sobot_chat_msg_item_file_l", "sobot_chat_msg_item_file_r", "sobot_chat_msg_item_video_r", "sobot_chat_msg_item_location_r", "sobot_chat_msg_item_notice", "sobot_chat_msg_item_card_r", "sobot_chat_msg_item_order_card_r", "sobot_chat_msg_item_order_card_l", "sobot_chat_msg_item_card_l", "sobot_chat_msg_item_template6_l", "sobot_chat_msg_item_system_tip", "sobot_chat_msg_item_video_l", "sobot_chat_msg_item_muiti_leave_msg"};
    private SobotMsgCallBack mMsgCallBack;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotMsgAdapter$SobotMsgCallBack.class */
    public interface SobotMsgCallBack {
        void addMessage(ZhiChiMessageBase zhiChiMessageBase);

        void clickAudioItem(ZhiChiMessageBase zhiChiMessageBase);

        void doClickTransferBtn(ZhiChiMessageBase zhiChiMessageBase);

        void doEvaluate(boolean z, ZhiChiMessageBase zhiChiMessageBase);

        void doRevaluate(boolean z, ZhiChiMessageBase zhiChiMessageBase);

        void hidePanelAndKeyboard();

        void mulitDiaToLeaveMsg(String str);

        void removeMessageByMsgId(String str);

        void sendConsultingContent();

        void sendMessage(String str);

        void sendMessageToRobot(ZhiChiMessageBase zhiChiMessageBase, int i, int i2, String str);

        void sendMessageToRobot(ZhiChiMessageBase zhiChiMessageBase, int i, int i2, String str, String str2);
    }

    public SobotMsgAdapter(Context context, List<ZhiChiMessageBase> list, SobotMsgCallBack sobotMsgCallBack) {
        super(context, list);
        this.mMsgCallBack = sobotMsgCallBack;
    }

    private ZhiChiMessageBase getMsgInfo(String str) {
        int size = this.list.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return null;
            }
            ZhiChiMessageBase zhiChiMessageBase = (ZhiChiMessageBase) this.list.get(i);
            if (zhiChiMessageBase != null && zhiChiMessageBase.getId() != null && zhiChiMessageBase.getId().equals(str)) {
                return zhiChiMessageBase;
            }
            size = i;
        }
    }

    private String getTimeStr(ZhiChiMessageBase zhiChiMessageBase, int i) {
        String stringData = SharedPreferencesUtil.getStringData(this.context, "lastCid", "");
        zhiChiMessageBase.setTs(TextUtils.isEmpty(zhiChiMessageBase.getTs()) ? DateUtil.getCurrentDateTime() : zhiChiMessageBase.getTs());
        String stringToFormatString = DateUtil.stringToFormatString(zhiChiMessageBase.getTs() + "", "yyyy-MM-dd", Boolean.valueOf(ZCSobotApi.getSwitchMarkStatus(8)));
        String currentDate = DateUtil.getCurrentDate();
        if (zhiChiMessageBase.getCid() != null && zhiChiMessageBase.getCid().equals(stringData) && currentDate.equals(stringToFormatString)) {
            return DateUtil.formatDateTime(zhiChiMessageBase.getTs(), true, "", Boolean.valueOf(ZCSobotApi.getSwitchMarkStatus(8)));
        }
        return DateUtil.stringToFormatString(((ZhiChiMessageBase) this.list.get(i)).getTs() + "", "MM-dd HH:mm", Boolean.valueOf(ZCSobotApi.getSwitchMarkStatus(8)));
    }

    private View initView(View view, int i, int i2, ZhiChiMessageBase zhiChiMessageBase) {
        MessageHolderBase textMessageHolder;
        if (view != null) {
            switch (i) {
                case 9:
                    View inflate = LayoutInflater.from(this.context).inflate(ResourceUtils.getIdByName(this.context, "layout", layoutRes[i]), (ViewGroup) null);
                    inflate.setTag(new RobotTemplateMessageHolder1(this.context, inflate));
                    return inflate;
                case 10:
                    View inflate2 = LayoutInflater.from(this.context).inflate(ResourceUtils.getIdByName(this.context, "layout", layoutRes[i]), (ViewGroup) null);
                    inflate2.setTag(new RobotTemplateMessageHolder2(this.context, inflate2));
                    return inflate2;
                case 11:
                    View inflate3 = LayoutInflater.from(this.context).inflate(ResourceUtils.getIdByName(this.context, "layout", layoutRes[i]), (ViewGroup) null);
                    inflate3.setTag(new RobotTemplateMessageHolder3(this.context, inflate3));
                    return inflate3;
                default:
                    return view;
            }
        }
        View inflate4 = LayoutInflater.from(this.context).inflate(ResourceUtils.getIdByName(this.context, "layout", layoutRes[i]), (ViewGroup) null);
        switch (i) {
            case 0:
            case 1:
                textMessageHolder = new TextMessageHolder(this.context, inflate4);
                if (i != 0) {
                    textMessageHolder.setRight(true);
                    break;
                } else {
                    textMessageHolder.setRight(false);
                    break;
                }
            case 2:
                textMessageHolder = new RemindMessageHolder(this.context, inflate4);
                break;
            case 3:
                textMessageHolder = new RichTextMessageHolder(this.context, inflate4);
                break;
            case 4:
            case 5:
                textMessageHolder = new ImageMessageHolder(this.context, inflate4);
                if (i != 4) {
                    textMessageHolder.setRight(true);
                    break;
                } else {
                    textMessageHolder.setRight(false);
                    break;
                }
            case 6:
                textMessageHolder = new VoiceMessageHolder(this.context, inflate4);
                textMessageHolder.setRight(true);
                break;
            case 7:
                textMessageHolder = new ConsultMessageHolder(this.context, inflate4);
                break;
            case 8:
                textMessageHolder = new CusEvaluateMessageHolder(this.context, inflate4);
                break;
            case 9:
                textMessageHolder = new RobotTemplateMessageHolder1(this.context, inflate4);
                break;
            case 10:
                textMessageHolder = new RobotTemplateMessageHolder2(this.context, inflate4);
                break;
            case 11:
                textMessageHolder = new RobotTemplateMessageHolder3(this.context, inflate4);
                break;
            case 12:
                textMessageHolder = new SobotChatMsgItemSDKHistoryR(this.context, inflate4);
                break;
            case 13:
                textMessageHolder = new RobotTemplateMessageHolder4(this.context, inflate4);
                break;
            case 14:
                textMessageHolder = new RobotTemplateMessageHolder5(this.context, inflate4);
                break;
            case 15:
                textMessageHolder = new RobotQRMessageHolder(this.context, inflate4);
                break;
            case 16:
                textMessageHolder = new RetractedMessageHolder(this.context, inflate4);
                break;
            case 17:
                textMessageHolder = new RobotAnswerItemsMsgHolder(this.context, inflate4);
                break;
            case 18:
                textMessageHolder = new RobotKeyWordMessageHolder(this.context, inflate4);
                break;
            case 19:
            case 20:
                textMessageHolder = new FileMessageHolder(this.context, inflate4);
                if (i != 19) {
                    textMessageHolder.setRight(true);
                    break;
                } else {
                    textMessageHolder.setRight(false);
                    break;
                }
            case 21:
            case 30:
                textMessageHolder = new VideoMessageHolder(this.context, inflate4);
                if (i != 30) {
                    textMessageHolder.setRight(true);
                    break;
                } else {
                    textMessageHolder.setRight(false);
                    break;
                }
            case 22:
                textMessageHolder = new LocationMessageHolder(this.context, inflate4);
                textMessageHolder.setRight(true);
                break;
            case 23:
                textMessageHolder = new NoticeMessageHolder(this.context, inflate4);
                break;
            case 24:
            case 27:
                textMessageHolder = new CardMessageHolder(this.context, inflate4);
                if (i != 27) {
                    textMessageHolder.setRight(true);
                    break;
                } else {
                    textMessageHolder.setRight(false);
                    break;
                }
            case 25:
            case 26:
                textMessageHolder = new OrderCardMessageHolder(this.context, inflate4);
                if (i != 26) {
                    textMessageHolder.setRight(true);
                    break;
                } else {
                    textMessageHolder.setRight(false);
                    break;
                }
            case 28:
                textMessageHolder = new RobotTemplateMessageHolder6(this.context, inflate4);
                break;
            case 29:
                textMessageHolder = new SystemMessageHolder(this.context, inflate4);
                break;
            case 31:
                textMessageHolder = new SobotMuitiLeavemsgMessageHolder(this.context, inflate4);
                break;
            default:
                textMessageHolder = new TextMessageHolder(this.context, inflate4);
                break;
        }
        inflate4.setTag(textMessageHolder);
        return inflate4;
    }

    private void removeByAction(ZhiChiMessageBase zhiChiMessageBase, String str, String str2, boolean z) {
        if (zhiChiMessageBase.getAction() == null || !zhiChiMessageBase.getAction().equals(str)) {
            return;
        }
        int size = this.list.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            if (((ZhiChiMessageBase) this.list.get(i)).getAction() != null && ((ZhiChiMessageBase) this.list.get(i)).getAction().equals(str2)) {
                this.list.remove(i);
                zhiChiMessageBase.setShake(z);
            }
            size = i;
        }
    }

    private void setDefaultCid(String str, ZhiChiMessageBase zhiChiMessageBase) {
        ZhiChiReplyAnswer answer = zhiChiMessageBase.getAnswer();
        if ((answer == null || answer.getRemindType() != 6) && zhiChiMessageBase.getCid() == null) {
            zhiChiMessageBase.setCid(str);
        }
    }

    private void setDefaultCid(List<ZhiChiMessageBase> list) {
        String stringData = SharedPreferencesUtil.getStringData(this.context, "lastCid", "");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            setDefaultCid(stringData, list.get(i2));
            i = i2 + 1;
        }
    }

    public void addData(ZhiChiMessageBase zhiChiMessageBase) {
        if (zhiChiMessageBase == null) {
            return;
        }
        if (zhiChiMessageBase.getAction() != null && ZhiChiConstant.action_remind_connt_success.equals(zhiChiMessageBase.getAction())) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.list.size()) {
                    break;
                }
                if (((ZhiChiMessageBase) this.list.get(i2)).getSugguestionsFontColor() != 1) {
                    ((ZhiChiMessageBase) this.list.get(i2)).setSugguestionsFontColor(1);
                }
                i = i2 + 1;
            }
        }
        removeByAction(zhiChiMessageBase, ZhiChiConstant.action_remind_no_service, ZhiChiConstant.action_remind_no_service, true);
        removeByAction(zhiChiMessageBase, ZhiChiConstant.action_remind_info_paidui, ZhiChiConstant.action_remind_info_paidui, true);
        removeByAction(zhiChiMessageBase, ZhiChiConstant.action_remind_info_paidui, ZhiChiConstant.action_remind_info_post_msg, true);
        removeByAction(zhiChiMessageBase, ZhiChiConstant.action_remind_connt_success, ZhiChiConstant.action_remind_info_paidui, false);
        removeByAction(zhiChiMessageBase, ZhiChiConstant.action_remind_info_post_msg, ZhiChiConstant.action_remind_info_post_msg, true);
        removeByAction(zhiChiMessageBase, ZhiChiConstant.action_remind_connt_success, ZhiChiConstant.action_remind_info_post_msg, false);
        removeByAction(zhiChiMessageBase, ZhiChiConstant.action_consultingContent_info, ZhiChiConstant.action_consultingContent_info, false);
        removeByAction(zhiChiMessageBase, ZhiChiConstant.sobot_outline_leverByManager, ZhiChiConstant.sobot_outline_leverByManager, true);
        removeByAction(zhiChiMessageBase, ZhiChiConstant.action_custom_evaluate, ZhiChiConstant.action_custom_evaluate, true);
        removeByAction(zhiChiMessageBase, ZhiChiConstant.action_remind_connt_success, ZhiChiConstant.action_remind_info_zhuanrengong, false);
        if (zhiChiMessageBase.getAction() != null && zhiChiMessageBase.getAction().equals(ZhiChiConstant.action_remind_past_time) && zhiChiMessageBase.getAnswer() != null && 5 == zhiChiMessageBase.getAnswer().getRemindType()) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.list.size()) {
                    break;
                }
                if (((ZhiChiMessageBase) this.list.get(i4)).getAction() != null && ((ZhiChiMessageBase) this.list.get(i4)).getAction().equals(ZhiChiConstant.action_remind_past_time) && zhiChiMessageBase.getAnswer() != null && 5 == zhiChiMessageBase.getAnswer().getRemindType()) {
                    this.list.remove(i4);
                    zhiChiMessageBase.setShake(true);
                }
                i3 = i4 + 1;
            }
        }
        justAddData(zhiChiMessageBase);
    }

    public void addData(List<ZhiChiMessageBase> list) {
        setDefaultCid(list);
        this.list.addAll(0, list);
    }

    public void addDataBefore(ZhiChiMessageBase zhiChiMessageBase) {
        setDefaultCid(SharedPreferencesUtil.getStringData(this.context, "lastCid", ""), zhiChiMessageBase);
        this.list.add(0, zhiChiMessageBase);
    }

    public void addMessage(int i, ZhiChiMessageBase zhiChiMessageBase) {
        setDefaultCid(SharedPreferencesUtil.getStringData(this.context, "lastCid", ""), zhiChiMessageBase);
        this.list.add(i, zhiChiMessageBase);
    }

    public void cancelVoiceUiById(String str) {
        ZhiChiMessageBase msgInfo = getMsgInfo(str);
        if (msgInfo == null || msgInfo.getSendSuccessState() != 4) {
            return;
        }
        this.list.remove(msgInfo);
    }

    @Override // com.sobot.chat.adapter.base.SobotBaseAdapter, android.widget.Adapter
    public ZhiChiMessageBase getItem(int i) {
        if (i < 0 || i >= this.list.size()) {
            return null;
        }
        return (ZhiChiMessageBase) this.list.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        try {
            ZhiChiMessageBase item = getItem(i);
            if (item == null) {
                return 0;
            }
            if (item.isRetractedMsg()) {
                return 16;
            }
            int i2 = -1;
            if (!TextUtils.isEmpty(item.getSenderType())) {
                i2 = Integer.parseInt(item.getSenderType());
            } else if (29 == Integer.parseInt(item.getAction())) {
                return 29;
            }
            if (i2 != 0 && 1 != i2 && 2 != i2) {
                if (24 == i2) {
                    return 2;
                }
                if (23 == i2) {
                    return 5;
                }
                if (25 == i2) {
                    return 6;
                }
                if (26 == i2) {
                    return 7;
                }
                if (27 == i2) {
                    return 3;
                }
                if (28 == i2) {
                    return 8;
                }
                if (29 == i2) {
                    return 15;
                }
                if (30 == i2) {
                    return 3;
                }
                if (31 == i2) {
                    return 18;
                }
                if (32 == i2) {
                    return 23;
                }
                if (29 == Integer.parseInt(item.getAction())) {
                    return 29;
                }
                return "44".equals(item.getAction()) ? 2 : 0;
            } else if (item.getAnswer() != null) {
                if (Integer.parseInt(item.getAnswer().getMsgType()) == 0) {
                    if (1 == Integer.parseInt(item.getSenderType())) {
                        return 3;
                    }
                    return (2 != Integer.parseInt(item.getSenderType()) && Integer.parseInt(item.getSenderType()) == 0) ? 1 : 0;
                } else if (1 == Integer.parseInt(item.getAnswer().getMsgType())) {
                    if (1 == Integer.parseInt(item.getSenderType()) || 2 == Integer.parseInt(item.getSenderType())) {
                        return 4;
                    }
                    return Integer.parseInt(item.getSenderType()) == 0 ? 5 : 0;
                } else if (2 == Integer.parseInt(item.getAnswer().getMsgType())) {
                    if (1 == Integer.parseInt(item.getSenderType()) || 2 == Integer.parseInt(item.getSenderType()) || Integer.parseInt(item.getSenderType()) != 0) {
                        return 0;
                    }
                    return (item.getAnswer() == null || TextUtils.isEmpty(item.getAnswer().getMsgTransfer())) ? 6 : 1;
                } else if (3 == Integer.parseInt(item.getAnswer().getMsgType())) {
                    return (1 == Integer.parseInt(item.getSenderType()) || 2 == Integer.parseInt(item.getSenderType())) ? 3 : 0;
                } else if (4 == Integer.parseInt(item.getAnswer().getMsgType())) {
                    return (1 == Integer.parseInt(item.getSenderType()) || 2 == Integer.parseInt(item.getSenderType())) ? 3 : 0;
                } else if (5 == Integer.parseInt(item.getAnswer().getMsgType())) {
                    return (1 == Integer.parseInt(item.getSenderType()) || 2 == Integer.parseInt(item.getSenderType())) ? 3 : 0;
                } else if (Integer.parseInt(item.getAnswer().getMsgType()) == 7 || Integer.parseInt(item.getAnswer().getMsgType()) == 11) {
                    return 3;
                } else {
                    if ("10".equals(item.getAnswer().getMsgType())) {
                        return 12;
                    }
                    if (!"9".equals(item.getAnswer().getMsgType())) {
                        if ("12".equals(item.getAnswer().getMsgType())) {
                            if (2 == Integer.parseInt(item.getSenderType())) {
                                return 19;
                            }
                            return Integer.parseInt(item.getSenderType()) == 0 ? 20 : 0;
                        } else if ("23".equals(item.getAnswer().getMsgType())) {
                            return 2 == Integer.parseInt(item.getSenderType()) ? item.getAnswer().getCacheFile() != null ? 30 : 0 : (Integer.parseInt(item.getSenderType()) != 0 || item.getAnswer().getCacheFile() == null) ? 0 : 21;
                        } else if ("22".equals(item.getAnswer().getMsgType())) {
                            return (Integer.parseInt(item.getSenderType()) != 0 || item.getAnswer().getLocationData() == null) ? 0 : 22;
                        } else if (24 == Integer.parseInt(item.getAnswer().getMsgType())) {
                            if (item.getConsultingContent() != null) {
                                if (2 == Integer.parseInt(item.getSenderType())) {
                                    return 27;
                                }
                                return Integer.parseInt(item.getSenderType()) == 0 ? 24 : 0;
                            }
                            return 0;
                        } else if (25 != Integer.parseInt(item.getAnswer().getMsgType())) {
                            return ZhiChiConstant.message_type_muiti_leave_msg.equals(item.getAnswer().getMsgType()) ? 31 : 0;
                        } else if (item.getOrderCardContent() != null) {
                            if (2 == Integer.parseInt(item.getSenderType())) {
                                return 26;
                            }
                            return Integer.parseInt(item.getSenderType()) == 0 ? 25 : 0;
                        } else {
                            return 0;
                        }
                    } else if (!GsonUtil.isMultiRoundSession(item) || item.getAnswer().getMultiDiaRespInfo() == null) {
                        return 0;
                    } else {
                        SobotMultiDiaRespInfo multiDiaRespInfo = item.getAnswer().getMultiDiaRespInfo();
                        if ("1511".equals(item.getAnswerType())) {
                            return 17;
                        }
                        if ("1522".equals(item.getAnswerType())) {
                            return 3;
                        }
                        if (multiDiaRespInfo.getInputContentList() == null || multiDiaRespInfo.getInputContentList().length <= 0) {
                            if (TextUtils.isEmpty(multiDiaRespInfo.getTemplate())) {
                                if (multiDiaRespInfo.getInterfaceRetList() == null || multiDiaRespInfo.getInterfaceRetList().size() <= 0) {
                                    return (multiDiaRespInfo.getInputContentList() == null || multiDiaRespInfo.getInputContentList().length <= 0) ? 14 : 10;
                                }
                                return 10;
                            } else if ("0".equals(multiDiaRespInfo.getTemplate())) {
                                return 9;
                            } else {
                                if ("1".equals(multiDiaRespInfo.getTemplate())) {
                                    return 10;
                                }
                                if ("2".equals(multiDiaRespInfo.getTemplate())) {
                                    return 11;
                                }
                                if ("3".equals(multiDiaRespInfo.getTemplate())) {
                                    return 13;
                                }
                                if ("4".equals(multiDiaRespInfo.getTemplate())) {
                                    return 14;
                                }
                                return "99".equals(multiDiaRespInfo.getTemplate()) ? 28 : 0;
                            }
                        }
                        return 10;
                    }
                }
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getMsgInfoPosition(String str) {
        int i = 0;
        for (Object obj : this.list) {
            int i2 = i + 1;
            if (obj instanceof ZhiChiMessageBase) {
                ZhiChiMessageBase zhiChiMessageBase = (ZhiChiMessageBase) obj;
                i = i2;
                if (zhiChiMessageBase.getId() != null) {
                    i = i2;
                    if (zhiChiMessageBase.getId().equals(str)) {
                        return i2;
                    }
                } else {
                    continue;
                }
            } else {
                i = i2;
            }
        }
        return this.list.size() - 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ZhiChiMessageBase zhiChiMessageBase = (ZhiChiMessageBase) this.list.get(i);
        View view2 = view;
        if (zhiChiMessageBase != null) {
            int itemViewType = getItemViewType(i);
            view2 = initView(view, itemViewType, i, zhiChiMessageBase);
            MessageHolderBase messageHolderBase = (MessageHolderBase) view2.getTag();
            messageHolderBase.setMsgCallBack(this.mMsgCallBack);
            handerRemindTiem(messageHolderBase, i);
            messageHolderBase.initNameAndFace(itemViewType);
            messageHolderBase.applyCustomUI();
            messageHolderBase.bindZhiChiMessageBase(zhiChiMessageBase);
            messageHolderBase.bindData(this.context, zhiChiMessageBase);
        }
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        String[] strArr = layoutRes;
        return strArr.length > 0 ? strArr.length : super.getViewTypeCount();
    }

    public void handerRemindTiem(MessageHolderBase messageHolderBase, int i) {
        if (SharedPreferencesUtil.getBooleanData(this.context, "sobot_use_language", false)) {
            return;
        }
        ZhiChiMessageBase zhiChiMessageBase = (ZhiChiMessageBase) this.list.get(i);
        if (messageHolderBase.reminde_time_Text == null) {
            return;
        }
        VersionUtils.setBackground((Drawable) null, messageHolderBase.reminde_time_Text);
        messageHolderBase.reminde_time_Text.setTextColor(this.context.getResources().getColor(ResourceUtils.getIdByName(this.context, "color", "sobot_color_remind_time_color")));
        if (i != 0) {
            if (zhiChiMessageBase.getCid() == null || zhiChiMessageBase.getCid().equals(((ZhiChiMessageBase) this.list.get(i - 1)).getCid())) {
                messageHolderBase.reminde_time_Text.setVisibility(8);
                return;
            }
            String timeStr = getTimeStr(zhiChiMessageBase, i);
            messageHolderBase.reminde_time_Text.setVisibility(0);
            messageHolderBase.reminde_time_Text.setText(timeStr);
            return;
        }
        ZhiChiReplyAnswer answer = zhiChiMessageBase.getAnswer();
        if (answer != null && answer.getRemindType() == 6) {
            messageHolderBase.reminde_time_Text.setVisibility(8);
            return;
        }
        messageHolderBase.reminde_time_Text.setText(getTimeStr(zhiChiMessageBase, i));
        messageHolderBase.reminde_time_Text.setVisibility(0);
    }

    public void justAddData(ZhiChiMessageBase zhiChiMessageBase) {
        if (zhiChiMessageBase == null) {
            return;
        }
        setDefaultCid(SharedPreferencesUtil.getStringData(this.context, "lastCid", ""), zhiChiMessageBase);
        this.list.add(zhiChiMessageBase);
    }

    public void removeByMsgId(String str) {
        Object msgInfo = getMsgInfo(str);
        if (msgInfo != null) {
            this.list.remove(msgInfo);
        }
    }

    public void removeConsulting() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.list.size()) {
                return;
            }
            if (((ZhiChiMessageBase) this.list.get(i2)).getAction() != null && ((ZhiChiMessageBase) this.list.get(i2)).getAction().equals(ZhiChiConstant.action_consultingContent_info)) {
                this.list.remove(i2);
                return;
            }
            i = i2 + 1;
        }
    }

    public void removeEvaluateData() {
        int size = this.list.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            ZhiChiMessageBase zhiChiMessageBase = (ZhiChiMessageBase) this.list.get(i);
            if (Constants.VIA_ACT_TYPE_TWENTY_EIGHT.equals(zhiChiMessageBase.getSenderType()) && zhiChiMessageBase.getSobotEvaluateModel() != null) {
                this.list.remove(zhiChiMessageBase);
                return;
            }
            size = i;
        }
    }

    public void removeKeyWordTranferItem() {
        try {
            List<ZhiChiMessageBase> datas = getDatas();
            int size = datas.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return;
                }
                if (31 == Integer.parseInt(datas.get(i).getSenderType())) {
                    datas.remove(i);
                    return;
                }
                size = i;
            }
        } catch (Exception e) {
            LogUtils.i("error : removeKeyWordTranferItem()");
        }
    }

    public void submitEvaluateData(int i, int i2) {
        SobotEvaluateModel sobotEvaluateModel;
        int size = this.list.size();
        while (true) {
            int i3 = size - 1;
            if (i3 < 0) {
                return;
            }
            ZhiChiMessageBase zhiChiMessageBase = (ZhiChiMessageBase) this.list.get(i3);
            if (Constants.VIA_ACT_TYPE_TWENTY_EIGHT.equals(zhiChiMessageBase.getSenderType()) && (sobotEvaluateModel = zhiChiMessageBase.getSobotEvaluateModel()) != null) {
                sobotEvaluateModel.setIsResolved(i);
                sobotEvaluateModel.setScore(i2);
                sobotEvaluateModel.setEvaluateStatus(1);
                return;
            }
            size = i3;
        }
    }

    public void updateDataById(String str, ZhiChiMessageBase zhiChiMessageBase) {
        ZhiChiMessageBase msgInfo = getMsgInfo(str);
        if (msgInfo != null) {
            msgInfo.setAnswer(zhiChiMessageBase.getAnswer());
            msgInfo.setSenderType(zhiChiMessageBase.getSenderType());
            msgInfo.setSendSuccessState(zhiChiMessageBase.getSendSuccessState());
        }
    }

    public void updateDataStateById(String str, ZhiChiMessageBase zhiChiMessageBase) {
        ZhiChiMessageBase msgInfo = getMsgInfo(str);
        if (msgInfo != null) {
            msgInfo.setSendSuccessState(zhiChiMessageBase.getSendSuccessState());
            msgInfo.setSentisive(zhiChiMessageBase.getSentisive());
            msgInfo.setSentisiveExplain(zhiChiMessageBase.getSentisiveExplain());
            msgInfo.setClickCancleSend(zhiChiMessageBase.isClickCancleSend());
            msgInfo.setShowSentisiveSeeAll(zhiChiMessageBase.isShowSentisiveSeeAll());
            msgInfo.setDesensitizationWord(zhiChiMessageBase.getDesensitizationWord());
        }
    }

    public void updateMsgInfoById(String str, int i, int i2) {
        ZhiChiMessageBase msgInfo = getMsgInfo(str);
        if (msgInfo == null || msgInfo.getSendSuccessState() == 1) {
            return;
        }
        msgInfo.setSendSuccessState(i);
        msgInfo.setProgressBar(i2);
    }

    public void updatePicStatusById(String str, int i) {
        ZhiChiMessageBase msgInfo = getMsgInfo(str);
        if (msgInfo != null) {
            msgInfo.setSendSuccessState(i);
        }
    }

    public void updateVoiceStatusById(String str, int i, String str2) {
        ZhiChiMessageBase msgInfo = getMsgInfo(str);
        if (msgInfo != null) {
            msgInfo.setSendSuccessState(i);
            if (TextUtils.isEmpty(str2) || msgInfo.getAnswer() == null) {
                return;
            }
            msgInfo.getAnswer().setDuration(str2);
        }
    }
}
