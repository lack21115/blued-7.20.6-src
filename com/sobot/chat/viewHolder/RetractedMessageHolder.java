package com.sobot.chat.viewHolder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.viewHolder.base.MessageHolderBase;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/RetractedMessageHolder.class */
public class RetractedMessageHolder extends MessageHolderBase {
    TextView sobot_tv_tip;
    String tipStr;

    public RetractedMessageHolder(Context context, View view) {
        super(context, view);
        this.sobot_tv_tip = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_tip"));
        this.tipStr = ResourceUtils.getResString(context, "sobot_retracted_msg_tip_end");
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(Context context, ZhiChiMessageBase zhiChiMessageBase) {
        String str;
        if (zhiChiMessageBase != null) {
            TextView textView = this.sobot_tv_tip;
            if (TextUtils.isEmpty(zhiChiMessageBase.getSenderName())) {
                str = "";
            } else {
                str = zhiChiMessageBase.getSenderName() + " " + this.tipStr;
            }
            textView.setText(str);
        }
    }
}
