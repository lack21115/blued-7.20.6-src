package com.sobot.chat.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sobot.chat.adapter.base.SobotBaseGvAdapter;
import com.sobot.chat.api.model.SobotPostMsgTemplate;
import com.sobot.chat.utils.ResourceUtils;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotPostMsgTmpListAdapter.class */
public class SobotPostMsgTmpListAdapter extends SobotBaseGvAdapter<SobotPostMsgTemplate> {

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotPostMsgTmpListAdapter$ViewHolder.class */
    static class ViewHolder extends SobotBaseGvAdapter.BaseViewHolder<SobotPostMsgTemplate> {
        private LinearLayout sobot_ll_content;
        private TextView sobot_tv_content;

        private ViewHolder(Context context, View view) {
            super(context, view);
            this.sobot_ll_content = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_content"));
            this.sobot_tv_content = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_content"));
        }

        @Override // com.sobot.chat.adapter.base.SobotBaseGvAdapter.BaseViewHolder
        public void bindData(SobotPostMsgTemplate sobotPostMsgTemplate, int i) {
            if (sobotPostMsgTemplate != null && !TextUtils.isEmpty(sobotPostMsgTemplate.getTemplateName())) {
                this.sobot_ll_content.setVisibility(0);
                this.sobot_tv_content.setText(sobotPostMsgTemplate.getTemplateName());
                return;
            }
            this.sobot_ll_content.setVisibility(4);
            this.sobot_ll_content.setSelected(false);
            this.sobot_tv_content.setText("");
        }
    }

    public SobotPostMsgTmpListAdapter(Context context, List<SobotPostMsgTemplate> list) {
        super(context, list);
    }

    @Override // com.sobot.chat.adapter.base.SobotBaseGvAdapter
    public String getContentLayoutName() {
        return "sobot_list_item_robot";
    }

    @Override // com.sobot.chat.adapter.base.SobotBaseGvAdapter
    public SobotBaseGvAdapter.BaseViewHolder getViewHolder(Context context, View view) {
        return new ViewHolder(context, view);
    }
}
