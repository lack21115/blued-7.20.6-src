package com.sobot.chat.viewHolder;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sobot.chat.api.model.SobotMultiDiaRespInfo;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.listener.NoDoubleClickListener;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.HtmlTools;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.viewHolder.base.MessageHolderBase;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/RobotTemplateMessageHolder5.class */
public class RobotTemplateMessageHolder5 extends MessageHolderBase {
    public ZhiChiMessageBase message;
    private LinearLayout sobot_ll_transferBtn;
    private TextView sobot_template5_msg;
    private TextView sobot_template5_title;
    private TextView sobot_tv_transferBtn;

    public RobotTemplateMessageHolder5(Context context, View view) {
        super(context, view);
        this.sobot_template5_msg = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template5_msg"));
        this.sobot_template5_title = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template5_title"));
        this.sobot_ll_transferBtn = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_transferBtn"));
        TextView textView = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_transferBtn"));
        this.sobot_tv_transferBtn = textView;
        textView.setText(ResourceUtils.getResString(context, "sobot_transfer_to_customer_service"));
        this.sobot_template5_title.setMaxWidth(ScreenUtils.getScreenWidth((Activity) this.mContext) - ScreenUtils.dip2px(this.mContext, 102.0f));
        this.sobot_template5_msg.setMaxWidth(ScreenUtils.getScreenWidth((Activity) this.mContext) - ScreenUtils.dip2px(this.mContext, 102.0f));
    }

    private void checkShowTransferBtn() {
        if (this.message.getTransferType() == 4) {
            showTransferBtn();
        } else {
            hideTransferBtn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRevaluate(boolean z) {
        if (this.msgCallBack == null || this.message == null) {
            return;
        }
        this.msgCallBack.doRevaluate(z, this.message);
    }

    private void setFailureView() {
        this.sobot_template5_msg.setVisibility(0);
        this.sobot_template5_title.setVisibility(8);
    }

    private void setSuccessView() {
        this.sobot_template5_msg.setVisibility(0);
        this.sobot_template5_title.setVisibility(0);
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(Context context, ZhiChiMessageBase zhiChiMessageBase) {
        this.message = zhiChiMessageBase;
        if (zhiChiMessageBase.getAnswer() != null && zhiChiMessageBase.getAnswer().getMultiDiaRespInfo() != null) {
            checkShowTransferBtn();
            SobotMultiDiaRespInfo multiDiaRespInfo = zhiChiMessageBase.getAnswer().getMultiDiaRespInfo();
            HtmlTools.getInstance(context).setRichText(this.sobot_template5_msg, ChatUtils.getMultiMsgTitle(multiDiaRespInfo).replaceAll("\n", "<br/>"), getLinkTextColor());
            applyTextViewUIConfig(this.sobot_template5_msg);
            List<Map<String, String>> interfaceRetList = multiDiaRespInfo.getInterfaceRetList();
            if (!"000000".equals(multiDiaRespInfo.getRetCode()) || interfaceRetList == null || interfaceRetList.size() <= 0) {
                setFailureView();
            } else {
                Map<String, String> map = interfaceRetList.get(0);
                if (map != null && map.size() > 0) {
                    setSuccessView();
                    HtmlTools.getInstance(context).setRichText(this.sobot_template5_title, map.get("title"), getLinkTextColor());
                }
            }
        }
        refreshRevaluateItem();
    }

    public void hideRevaluateBtn() {
        this.sobot_tv_likeBtn.setVisibility(8);
        this.sobot_tv_dislikeBtn.setVisibility(8);
        this.sobot_ll_likeBtn.setVisibility(8);
        this.sobot_ll_dislikeBtn.setVisibility(8);
        this.rightEmptyRL.setVisibility(8);
    }

    public void hideTransferBtn() {
        this.sobot_ll_transferBtn.setVisibility(8);
        this.sobot_tv_transferBtn.setVisibility(8);
        ZhiChiMessageBase zhiChiMessageBase = this.message;
        if (zhiChiMessageBase != null) {
            zhiChiMessageBase.setShowTransferBtn(false);
        }
    }

    public void refreshRevaluateItem() {
        if (this.message == null || this.sobot_tv_likeBtn == null || this.sobot_tv_dislikeBtn == null || this.sobot_ll_likeBtn == null || this.sobot_ll_dislikeBtn == null) {
            return;
        }
        int revaluateState = this.message.getRevaluateState();
        if (revaluateState == 1) {
            showRevaluateBtn();
        } else if (revaluateState == 2) {
            showLikeWordView();
        } else if (revaluateState != 3) {
            hideRevaluateBtn();
        } else {
            showDislikeWordView();
        }
    }

    public void showDislikeWordView() {
        this.sobot_tv_dislikeBtn.setSelected(true);
        this.sobot_tv_dislikeBtn.setEnabled(false);
        this.sobot_tv_likeBtn.setEnabled(false);
        this.sobot_tv_likeBtn.setSelected(false);
        this.sobot_tv_likeBtn.setVisibility(8);
        this.sobot_tv_dislikeBtn.setVisibility(0);
        this.sobot_ll_likeBtn.setVisibility(8);
        this.sobot_ll_dislikeBtn.setVisibility(0);
        this.rightEmptyRL.setVisibility(0);
    }

    public void showLikeWordView() {
        this.sobot_tv_likeBtn.setSelected(true);
        this.sobot_tv_likeBtn.setEnabled(false);
        this.sobot_tv_dislikeBtn.setEnabled(false);
        this.sobot_tv_dislikeBtn.setSelected(false);
        this.sobot_tv_likeBtn.setVisibility(0);
        this.sobot_tv_dislikeBtn.setVisibility(8);
        this.sobot_ll_likeBtn.setVisibility(0);
        this.sobot_ll_dislikeBtn.setVisibility(8);
        this.rightEmptyRL.setVisibility(0);
    }

    public void showRevaluateBtn() {
        this.sobot_tv_likeBtn.setVisibility(0);
        this.sobot_tv_dislikeBtn.setVisibility(0);
        this.sobot_ll_likeBtn.setVisibility(0);
        this.sobot_ll_dislikeBtn.setVisibility(0);
        this.rightEmptyRL.setVisibility(0);
        this.sobot_tv_likeBtn.setEnabled(true);
        this.sobot_tv_dislikeBtn.setEnabled(true);
        this.sobot_tv_likeBtn.setSelected(false);
        this.sobot_tv_dislikeBtn.setSelected(false);
        this.sobot_tv_likeBtn.setOnClickListener(new NoDoubleClickListener() { // from class: com.sobot.chat.viewHolder.RobotTemplateMessageHolder5.2
            @Override // com.sobot.chat.listener.NoDoubleClickListener
            public void onNoDoubleClick(View view) {
                RobotTemplateMessageHolder5.this.doRevaluate(true);
            }
        });
        this.sobot_tv_dislikeBtn.setOnClickListener(new NoDoubleClickListener() { // from class: com.sobot.chat.viewHolder.RobotTemplateMessageHolder5.3
            @Override // com.sobot.chat.listener.NoDoubleClickListener
            public void onNoDoubleClick(View view) {
                RobotTemplateMessageHolder5.this.doRevaluate(false);
            }
        });
    }

    public void showTransferBtn() {
        this.sobot_tv_transferBtn.setVisibility(0);
        this.sobot_ll_transferBtn.setVisibility(0);
        ZhiChiMessageBase zhiChiMessageBase = this.message;
        if (zhiChiMessageBase != null) {
            zhiChiMessageBase.setShowTransferBtn(true);
        }
        this.sobot_ll_transferBtn.setOnClickListener(new NoDoubleClickListener() { // from class: com.sobot.chat.viewHolder.RobotTemplateMessageHolder5.1
            @Override // com.sobot.chat.listener.NoDoubleClickListener
            public void onNoDoubleClick(View view) {
                if (RobotTemplateMessageHolder5.this.msgCallBack != null) {
                    RobotTemplateMessageHolder5.this.msgCallBack.doClickTransferBtn(RobotTemplateMessageHolder5.this.message);
                }
            }
        });
    }
}
