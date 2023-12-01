package com.sobot.chat.viewHolder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.viewHolder.base.MessageHolderBase;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/SystemMessageHolder.class */
public class SystemMessageHolder extends MessageHolderBase {
    TextView center_Remind_Info;

    public SystemMessageHolder(Context context, View view) {
        super(context, view);
        this.center_Remind_Info = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_center_Remind_note"));
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(Context context, ZhiChiMessageBase zhiChiMessageBase) {
        if (TextUtils.isEmpty(zhiChiMessageBase.getMsg())) {
            return;
        }
        this.center_Remind_Info.setVisibility(0);
        this.center_Remind_Info.setText(zhiChiMessageBase.getMsg());
    }
}
