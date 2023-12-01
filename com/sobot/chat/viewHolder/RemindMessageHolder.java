package com.sobot.chat.viewHolder;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.utils.HtmlTools;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.viewHolder.base.MessageHolderBase;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/RemindMessageHolder.class */
public class RemindMessageHolder extends MessageHolderBase {
    TextView center_Remind_Info;
    TextView center_Remind_Info1;
    TextView center_Remind_Info2;
    RelativeLayout rl_not_read;
    TextView sobot_center_Remind_note5;

    public RemindMessageHolder(Context context, View view) {
        super(context, view);
        this.center_Remind_Info = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_center_Remind_note"));
        this.center_Remind_Info1 = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_center_Remind_note1"));
        this.center_Remind_Info2 = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_center_Remind_note2"));
        this.rl_not_read = (RelativeLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "rl_not_read"));
        TextView textView = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_center_Remind_note5"));
        this.sobot_center_Remind_note5 = textView;
        textView.setText(ResourceUtils.getResString(context, "sobot_no_read"));
    }

    private void setRemindPostMsg(Context context, TextView textView, ZhiChiMessageBase zhiChiMessageBase, boolean z) {
        int intData = SharedPreferencesUtil.getIntData(context, ZhiChiConstant.sobot_msg_flag, 0);
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "，" : " ");
        sb.append(ResourceUtils.getResString(context, "sobot_can"));
        sb.append("<a href='sobot:SobotPostMsgActivity'> ");
        sb.append(ResourceUtils.getResString(context, "sobot_str_bottom_message"));
        sb.append("</a>");
        String sb2 = sb.toString();
        String replace = zhiChiMessageBase.getAnswer().getMsg().replace("<br/>", "").replace("<p>", "").replace("</p>", "");
        String str = replace;
        if (intData == 0) {
            str = replace + sb2;
        }
        HtmlTools.getInstance(context).setRichText(textView, str, ResourceUtils.getIdByName(context, "color", "sobot_color_link_remind"));
        textView.setEnabled(true);
        zhiChiMessageBase.setShake(false);
    }

    private void setRemindToCustom(Context context, TextView textView) {
        HtmlTools.getInstance(context).setRichText(textView, ResourceUtils.getResString(context, "sobot_cant_solve_problem") + "<a href='sobot:SobotToCustomer'> " + ResourceUtils.getResString(context, "sobot_customer_service") + "</a>", ResourceUtils.getIdByName(context, "color", "sobot_color_link_remind"));
        textView.setEnabled(true);
    }

    public static Animation shakeAnimation(int i) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 10.0f, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new CycleInterpolator(i));
        translateAnimation.setDuration(1000L);
        return translateAnimation;
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(Context context, ZhiChiMessageBase zhiChiMessageBase) {
        if (zhiChiMessageBase.getAnswer() == null || TextUtils.isEmpty(zhiChiMessageBase.getAnswer().getMsg())) {
            if (ZhiChiConstant.action_remind_info_zhuanrengong.equals(zhiChiMessageBase.getAction())) {
                this.rl_not_read.setVisibility(8);
                this.center_Remind_Info2.setVisibility(8);
                this.center_Remind_Info.setVisibility(0);
                this.center_Remind_Info1.setVisibility(8);
                setRemindToCustom(context, this.center_Remind_Info);
                return;
            } else if ("44".equals(zhiChiMessageBase.getAction())) {
                this.rl_not_read.setVisibility(8);
                this.center_Remind_Info2.setVisibility(8);
                this.center_Remind_Info.setVisibility(0);
                this.center_Remind_Info1.setVisibility(8);
                this.center_Remind_Info.setText(ResourceUtils.getResStrId(context, "sobot_agree_sentisive_tip"));
                return;
            } else {
                return;
            }
        }
        if (zhiChiMessageBase.getAnswer().getRemindType() == 6) {
            this.rl_not_read.setVisibility(8);
            this.center_Remind_Info2.setVisibility(8);
            this.center_Remind_Info.setVisibility(8);
            this.center_Remind_Info1.setVisibility(0);
            this.center_Remind_Info1.setText(zhiChiMessageBase.getAnswer().getMsg());
        } else if (zhiChiMessageBase.getAnswer().getRemindType() == 7) {
            this.rl_not_read.setVisibility(0);
            this.center_Remind_Info.setVisibility(8);
            this.center_Remind_Info1.setVisibility(8);
            this.center_Remind_Info2.setVisibility(8);
        } else if (zhiChiMessageBase.getAnswer().getRemindType() == 9) {
            this.rl_not_read.setVisibility(8);
            this.center_Remind_Info.setVisibility(8);
            this.center_Remind_Info1.setVisibility(8);
            this.center_Remind_Info2.setVisibility(0);
            HtmlTools.getInstance(context).setRichText(this.center_Remind_Info2, zhiChiMessageBase.getAnswer().getMsg(), ResourceUtils.getIdByName(context, "color", "sobot_color_link_remind"));
        } else {
            this.rl_not_read.setVisibility(8);
            this.center_Remind_Info2.setVisibility(8);
            this.center_Remind_Info.setVisibility(0);
            this.center_Remind_Info1.setVisibility(8);
            int remindType = zhiChiMessageBase.getAnswer().getRemindType();
            if (ZhiChiConstant.action_remind_info_post_msg.equals(zhiChiMessageBase.getAction())) {
                if (remindType == 1) {
                    if (zhiChiMessageBase.isShake()) {
                        this.center_Remind_Info.setAnimation(shakeAnimation(5));
                    }
                    setRemindPostMsg(context, this.center_Remind_Info, zhiChiMessageBase, false);
                }
                if (remindType == 2) {
                    if (zhiChiMessageBase.isShake()) {
                        this.center_Remind_Info.setAnimation(shakeAnimation(5));
                    }
                    setRemindPostMsg(context, this.center_Remind_Info, zhiChiMessageBase, true);
                }
            } else if (ZhiChiConstant.action_remind_info_paidui.equals(zhiChiMessageBase.getAction())) {
                if (remindType == 3) {
                    if (zhiChiMessageBase.isShake()) {
                        this.center_Remind_Info.setAnimation(shakeAnimation(5));
                    }
                    setRemindPostMsg(context, this.center_Remind_Info, zhiChiMessageBase, false);
                }
            } else if (ZhiChiConstant.action_remind_connt_success.equals(zhiChiMessageBase.getAction())) {
                if (remindType == 4) {
                    this.center_Remind_Info.setText(Html.fromHtml(zhiChiMessageBase.getAnswer().getMsg()));
                }
            } else if (ZhiChiConstant.sobot_outline_leverByManager.equals(zhiChiMessageBase.getAction()) || ZhiChiConstant.action_remind_past_time.equals(zhiChiMessageBase.getAction())) {
                HtmlTools.getInstance(context).setRichText(this.center_Remind_Info, zhiChiMessageBase.getAnswer().getMsg(), ResourceUtils.getIdByName(context, "color", "sobot_color_link_remind"));
            } else if (remindType == 8 || remindType == 4) {
                this.center_Remind_Info.setText(zhiChiMessageBase.getAnswer().getMsg());
            }
        }
        if (zhiChiMessageBase.isShake()) {
            this.center_Remind_Info.setAnimation(shakeAnimation(5));
            zhiChiMessageBase.setShake(false);
        }
    }
}
