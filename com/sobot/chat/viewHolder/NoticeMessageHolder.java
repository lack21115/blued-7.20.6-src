package com.sobot.chat.viewHolder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.viewHolder.base.MessageHolderBase;
import com.sobot.chat.widget.StExpandableTextView;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/NoticeMessageHolder.class */
public class NoticeMessageHolder extends MessageHolderBase {
    private StExpandableTextView expand_text_view;
    private ZhiChiMessageBase mMessage;

    public NoticeMessageHolder(Context context, View view) {
        super(context, view);
        StExpandableTextView stExpandableTextView = (StExpandableTextView) view.findViewById(ResourceUtils.getResId(context, "expand_text_view"));
        this.expand_text_view = stExpandableTextView;
        stExpandableTextView.setLinkBottomLine(true);
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(Context context, ZhiChiMessageBase zhiChiMessageBase) {
        this.mMessage = zhiChiMessageBase;
        if (zhiChiMessageBase.getAnswer() == null || TextUtils.isEmpty(zhiChiMessageBase.getAnswer().getMsg())) {
            return;
        }
        this.expand_text_view.setText(zhiChiMessageBase.getAnswer().getMsg());
    }
}
