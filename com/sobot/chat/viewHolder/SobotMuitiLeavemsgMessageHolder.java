package com.sobot.chat.viewHolder;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.utils.StringUtils;
import com.sobot.chat.viewHolder.base.MessageHolderBase;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/SobotMuitiLeavemsgMessageHolder.class */
public class SobotMuitiLeavemsgMessageHolder extends MessageHolderBase implements View.OnClickListener {
    private ZhiChiMessageBase mMessage;
    private ProgressBar sobot_msgProgressBar;
    private ImageView sobot_msgStatus;
    private LinearLayout sobot_text_ll;

    public SobotMuitiLeavemsgMessageHolder(Context context, View view) {
        super(context, view);
        this.sobot_text_ll = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_text_ll"));
        this.sobot_msgProgressBar = (ProgressBar) view.findViewById(ResourceUtils.getResId(context, "sobot_msgProgressBar"));
        this.sobot_msgStatus = (ImageView) view.findViewById(ResourceUtils.getResId(context, "sobot_msgStatus"));
    }

    private void refreshUi() {
        try {
            if (this.mMessage == null) {
                return;
            }
            if (this.mMessage.getSendSuccessState() == 1) {
                this.sobot_msgStatus.setVisibility(8);
                this.sobot_msgProgressBar.setVisibility(8);
            } else if (this.mMessage.getSendSuccessState() == 0) {
                this.sobot_msgStatus.setVisibility(0);
                this.sobot_msgProgressBar.setVisibility(8);
                this.sobot_msgProgressBar.setClickable(true);
                this.sobot_msgStatus.setOnClickListener(this);
            } else if (this.mMessage.getSendSuccessState() == 2) {
                this.sobot_msgStatus.setVisibility(8);
                this.sobot_msgProgressBar.setVisibility(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setMsgContent(Context context, ZhiChiMessageBase zhiChiMessageBase) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, ScreenUtils.dip2px(context, 8.0f), 0, 0);
        this.sobot_text_ll.removeAllViews();
        if (TextUtils.isEmpty(zhiChiMessageBase.getAnswer().getMsg())) {
            return;
        }
        String[] split = zhiChiMessageBase.getAnswer().getMsg().split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= split.length) {
                return;
            }
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(14.0f);
            textView.setLayoutParams(layoutParams);
            this.sobot_text_ll.addView(textView);
            int i3 = i2 + 1;
            int i4 = i3 % 2;
            if (i4 == 0) {
                if (StringUtils.isEmpty(split[i2])) {
                    textView.setText(" - -");
                } else {
                    textView.setText(Html.fromHtml(split[i2]).toString().trim());
                }
                textView.setTextColor(ContextCompat.getColor(this.mContext, ResourceUtils.getResColorId(this.mContext, "sobot_common_gray1")));
            } else {
                textView.setText(Html.fromHtml(split[i2]).toString().trim() + ":");
                textView.setTextColor(ContextCompat.getColor(this.mContext, ResourceUtils.getResColorId(this.mContext, "sobot_common_gray2")));
            }
            if (i4 == 0 && i2 < split.length - 1) {
                View view = new View(this.mContext);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, ScreenUtils.dip2px(context, 0.4f));
                layoutParams2.setMargins(0, ScreenUtils.dip2px(context, 8.0f), 0, 0);
                view.setLayoutParams(layoutParams2);
                view.setBackgroundColor(ContextCompat.getColor(context, ResourceUtils.getResColorId(context, "sobot_line_1dp")));
                this.sobot_text_ll.addView(view);
            }
            i = i3;
        }
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(Context context, ZhiChiMessageBase zhiChiMessageBase) {
        this.mMessage = zhiChiMessageBase;
        setMsgContent(this.mContext, zhiChiMessageBase);
        refreshUi();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.sobot_msgStatus) {
            showReSendDialog(this.mContext, this.msgStatus, new MessageHolderBase.ReSendListener() { // from class: com.sobot.chat.viewHolder.SobotMuitiLeavemsgMessageHolder.1
                @Override // com.sobot.chat.viewHolder.base.MessageHolderBase.ReSendListener
                public void onReSend() {
                    if (SobotMuitiLeavemsgMessageHolder.this.msgCallBack == null || SobotMuitiLeavemsgMessageHolder.this.mMessage == null) {
                        return;
                    }
                    SobotMuitiLeavemsgMessageHolder.this.mMessage.getAnswer();
                }
            });
        }
    }
}
