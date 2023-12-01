package com.sobot.chat.viewHolder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.adapter.SobotMsgAdapter;
import com.sobot.chat.api.model.SobotQuestionRecommend;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.HtmlTools;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.viewHolder.base.MessageHolderBase;
import com.sobot.pictureframe.SobotBitmapUtil;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/RobotQRMessageHolder.class */
public class RobotQRMessageHolder extends MessageHolderBase {
    private HorizontalScrollView sobot_horizontal_scrollview;
    private LinearLayout sobot_horizontal_scrollview_layout;
    private TextView tv_title;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/RobotQRMessageHolder$QuestionRecommendViewHolder.class */
    public static class QuestionRecommendViewHolder implements View.OnClickListener {
        Context mContext;
        SobotQuestionRecommend.SobotQRMsgBean mQrMsgBean;
        SobotMsgAdapter.SobotMsgCallBack msgCallBack;
        LinearLayout sobotLayout;
        ImageView sobotThumbnail;
        TextView sobotTitle;

        private QuestionRecommendViewHolder(Context context, View view, SobotMsgAdapter.SobotMsgCallBack sobotMsgCallBack) {
            this.msgCallBack = sobotMsgCallBack;
            this.sobotLayout = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template1_item"));
            this.sobotThumbnail = (ImageView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_item_thumbnail"));
            this.sobotTitle = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_item_title"));
        }

        public void bindData(Context context, SobotQuestionRecommend.SobotQRMsgBean sobotQRMsgBean, boolean z) {
            this.mContext = context;
            this.mQrMsgBean = sobotQRMsgBean;
            if (sobotQRMsgBean != null) {
                int i = 0;
                SobotBitmapUtil.display(context, sobotQRMsgBean.getIcon(), this.sobotThumbnail, 0, 0);
                this.sobotTitle.setText(TextUtils.isEmpty(sobotQRMsgBean.getTitle()) ? sobotQRMsgBean.getQuestion() : sobotQRMsgBean.getTitle());
                this.sobotLayout.setOnClickListener(this);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.sobotLayout.getLayoutParams();
                int i2 = layoutParams.leftMargin;
                int i3 = layoutParams.topMargin;
                if (z) {
                    i = (int) CommonUtils.getDimensPix(context, "sobot_item_qr_divider");
                }
                layoutParams.setMargins(i2, i3, i, layoutParams.bottomMargin);
                this.sobotLayout.setLayoutParams(layoutParams);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            if (this.msgCallBack == null || this.mQrMsgBean == null) {
                return;
            }
            ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
            zhiChiMessageBase.setContent(this.mQrMsgBean.getQuestion());
            this.msgCallBack.sendMessageToRobot(zhiChiMessageBase, 0, 0, null);
        }
    }

    public RobotQRMessageHolder(Context context, View view) {
        super(context, view);
        this.tv_title = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_msg"));
        this.sobot_horizontal_scrollview_layout = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template1_horizontal_scrollview_layout"));
        this.sobot_horizontal_scrollview = (HorizontalScrollView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template1_horizontal_scrollview"));
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(Context context, ZhiChiMessageBase zhiChiMessageBase) {
        QuestionRecommendViewHolder questionRecommendViewHolder;
        if (zhiChiMessageBase.getAnswer() == null || zhiChiMessageBase.getAnswer().getQuestionRecommend() == null) {
            return;
        }
        SobotQuestionRecommend questionRecommend = zhiChiMessageBase.getAnswer().getQuestionRecommend();
        if (TextUtils.isEmpty(questionRecommend.getGuide())) {
            this.tv_title.setVisibility(8);
        } else {
            HtmlTools.getInstance(context).setRichText(this.tv_title, questionRecommend.getGuide(), getLinkTextColor());
            applyTextViewUIConfig(this.tv_title);
            this.tv_title.setVisibility(0);
        }
        List<SobotQuestionRecommend.SobotQRMsgBean> msg = questionRecommend.getMsg();
        if (msg == null || msg.size() <= 0) {
            this.sobot_horizontal_scrollview.setVisibility(8);
            return;
        }
        this.sobot_horizontal_scrollview.setVisibility(0);
        int childCount = this.sobot_horizontal_scrollview_layout.getChildCount();
        int size = msg.size();
        while (true) {
            int i = size;
            if (i >= childCount) {
                break;
            }
            this.sobot_horizontal_scrollview_layout.getChildAt(i).setVisibility(8);
            size = i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= msg.size()) {
                return;
            }
            SobotQuestionRecommend.SobotQRMsgBean sobotQRMsgBean = msg.get(i3);
            if (i3 < childCount) {
                View childAt = this.sobot_horizontal_scrollview_layout.getChildAt(i3);
                childAt.setVisibility(0);
                questionRecommendViewHolder = (QuestionRecommendViewHolder) childAt.getTag();
            } else {
                View inflate = View.inflate(context, ResourceUtils.getIdByName(context, "layout", "sobot_chat_msg_item_qr_item"), null);
                questionRecommendViewHolder = new QuestionRecommendViewHolder(context, inflate, this.msgCallBack);
                inflate.setTag(questionRecommendViewHolder);
                this.sobot_horizontal_scrollview_layout.addView(inflate);
            }
            boolean z = true;
            if (i3 != msg.size() - 1) {
                z = false;
            }
            questionRecommendViewHolder.bindData(context, sobotQRMsgBean, z);
            i2 = i3 + 1;
        }
    }
}
