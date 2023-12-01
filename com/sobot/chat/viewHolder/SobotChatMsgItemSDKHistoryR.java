package com.sobot.chat.viewHolder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.viewHolder.base.MessageHolderBase;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/SobotChatMsgItemSDKHistoryR.class */
public class SobotChatMsgItemSDKHistoryR extends MessageHolderBase {
    private TextView sobot_sdk_history_msg;

    public SobotChatMsgItemSDKHistoryR(Context context, View view) {
        super(context, view);
        this.sobot_sdk_history_msg = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_sdk_history_msg"));
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(Context context, ZhiChiMessageBase zhiChiMessageBase) {
        if (zhiChiMessageBase.getAnswer() == null || zhiChiMessageBase.getAnswer().getInterfaceRetList() == null || zhiChiMessageBase.getAnswer().getInterfaceRetList().size() <= 0) {
            return;
        }
        List<Map<String, String>> interfaceRetList = zhiChiMessageBase.getAnswer().getInterfaceRetList();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= interfaceRetList.size()) {
                this.sobot_sdk_history_msg.setText(sb);
                return;
            }
            Map<String, String> map = interfaceRetList.get(i2);
            if (map != null && map.size() > 0) {
                sb.append(map.get("title"));
            }
            i = i2 + 1;
        }
    }
}
