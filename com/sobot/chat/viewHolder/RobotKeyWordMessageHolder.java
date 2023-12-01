package com.sobot.chat.viewHolder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.api.apiUtils.ZhiChiConstants;
import com.sobot.chat.api.model.SobotKeyWordTransfer;
import com.sobot.chat.api.model.ZhiChiGroupBase;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.HtmlTools;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.viewHolder.base.MessageHolderBase;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/RobotKeyWordMessageHolder.class */
public class RobotKeyWordMessageHolder extends MessageHolderBase {
    private View.OnClickListener mKeyWorkCheckGroupClickListener;
    private LinearLayout sobot_keyword_grouplist;
    private TextView tv_title;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/RobotKeyWordMessageHolder$KeyWorkTempModel.class */
    class KeyWorkTempModel {
        private String keyword;
        private String keywordId;
        private String tempGroupId;

        KeyWorkTempModel() {
        }

        public String getKeyword() {
            return this.keyword;
        }

        public String getKeywordId() {
            return this.keywordId;
        }

        public String getTempGroupId() {
            return this.tempGroupId;
        }

        public void setKeyword(String str) {
            this.keyword = str;
        }

        public void setKeywordId(String str) {
            this.keywordId = str;
        }

        public void setTempGroupId(String str) {
            this.tempGroupId = str;
        }
    }

    public RobotKeyWordMessageHolder(Context context, View view) {
        super(context, view);
        this.mKeyWorkCheckGroupClickListener = new View.OnClickListener() { // from class: com.sobot.chat.viewHolder.RobotKeyWordMessageHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                Intent intent = new Intent();
                intent.setAction(ZhiChiConstants.SOBOT_BROCAST_KEYWORD_CLICK);
                KeyWorkTempModel keyWorkTempModel = (KeyWorkTempModel) view2.getTag();
                intent.putExtra("tempGroupId", keyWorkTempModel.getTempGroupId());
                intent.putExtra("keyword", keyWorkTempModel.getKeyword());
                intent.putExtra("keywordId", keyWorkTempModel.getKeywordId());
                CommonUtils.sendLocalBroadcast(RobotKeyWordMessageHolder.this.mContext, intent);
            }
        };
        this.tv_title = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_keyword_tips_msg"));
        this.sobot_keyword_grouplist = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_keyword_grouplist"));
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(Context context, ZhiChiMessageBase zhiChiMessageBase) {
        SobotKeyWordTransfer sobotKeyWordTransfer;
        if (zhiChiMessageBase == null || (sobotKeyWordTransfer = zhiChiMessageBase.getSobotKeyWordTransfer()) == null) {
            return;
        }
        if (sobotKeyWordTransfer.getTipsMessage() != null) {
            applyTextViewUIConfig(this.tv_title);
            HtmlTools htmlTools = HtmlTools.getInstance(context);
            TextView textView = this.tv_title;
            String tipsMessage = sobotKeyWordTransfer.getTipsMessage();
            boolean z = this.isRight;
            htmlTools.setRichText(textView, tipsMessage, getLinkTextColor());
        }
        List<ZhiChiGroupBase> groupList = sobotKeyWordTransfer.getGroupList();
        if (groupList == null || groupList.size() <= 0) {
            this.sobot_keyword_grouplist.setVisibility(8);
            return;
        }
        this.sobot_keyword_grouplist.removeAllViews();
        this.sobot_keyword_grouplist.setVisibility(0);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= groupList.size()) {
                return;
            }
            KeyWorkTempModel keyWorkTempModel = new KeyWorkTempModel();
            keyWorkTempModel.setTempGroupId(groupList.get(i2).getGroupId());
            keyWorkTempModel.setKeyword(sobotKeyWordTransfer.getKeyword());
            keyWorkTempModel.setKeywordId(sobotKeyWordTransfer.getKeywordId());
            TextView initAnswerItemTextView = ChatUtils.initAnswerItemTextView(context, false);
            initAnswerItemTextView.setText(groupList.get(i2).getGroupName());
            initAnswerItemTextView.setTag(keyWorkTempModel);
            initAnswerItemTextView.setOnClickListener(this.mKeyWorkCheckGroupClickListener);
            this.sobot_keyword_grouplist.addView(initAnswerItemTextView);
            i = i2 + 1;
        }
    }
}
