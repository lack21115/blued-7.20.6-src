package com.sobot.chat.viewHolder;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.anythink.expressad.foundation.h.i;
import com.blued.android.chat.data.MsgType;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.activity.WebViewActivity;
import com.sobot.chat.api.model.SobotMultiDiaRespInfo;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.listener.NoDoubleClickListener;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.HtmlTools;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SobotOption;
import com.sobot.chat.viewHolder.base.MessageHolderBase;
import com.sobot.pictureframe.SobotBitmapUtil;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/RobotTemplateMessageHolder4.class */
public class RobotTemplateMessageHolder4 extends MessageHolderBase {
    public ZhiChiMessageBase message;
    private LinearLayout sobot_ll_transferBtn;
    private TextView sobot_template4_anchor;
    private TextView sobot_template4_summary;
    private TextView sobot_template4_temp_title;
    private ImageView sobot_template4_thumbnail;
    private TextView sobot_template4_title;
    private TextView sobot_tv_transferBtn;

    public RobotTemplateMessageHolder4(Context context, View view) {
        super(context, view);
        this.sobot_template4_temp_title = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template4_temp_title"));
        this.sobot_template4_thumbnail = (ImageView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template4_thumbnail"));
        this.sobot_template4_title = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template4_title"));
        this.sobot_template4_summary = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template4_summary"));
        TextView textView = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template4_anchor"));
        this.sobot_template4_anchor = textView;
        textView.setText(ResourceUtils.getResString(context, "sobot_see_detail"));
        this.sobot_ll_transferBtn = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_transferBtn"));
        TextView textView2 = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_transferBtn"));
        this.sobot_tv_transferBtn = textView2;
        textView2.setText(ResourceUtils.getResString(context, "sobot_transfer_to_customer_service"));
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
        this.sobot_template4_title.setVisibility(0);
        this.sobot_template4_thumbnail.setVisibility(8);
        this.sobot_template4_temp_title.setVisibility(8);
        this.sobot_template4_summary.setVisibility(8);
        this.sobot_template4_anchor.setVisibility(8);
    }

    private void setSuccessView() {
        this.sobot_template4_title.setVisibility(0);
        this.sobot_template4_thumbnail.setVisibility(0);
        this.sobot_template4_summary.setVisibility(0);
        this.sobot_template4_anchor.setVisibility(0);
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(final Context context, ZhiChiMessageBase zhiChiMessageBase) {
        this.message = zhiChiMessageBase;
        if (zhiChiMessageBase.getAnswer() != null && zhiChiMessageBase.getAnswer().getMultiDiaRespInfo() != null) {
            checkShowTransferBtn();
            SobotMultiDiaRespInfo multiDiaRespInfo = zhiChiMessageBase.getAnswer().getMultiDiaRespInfo();
            String multiMsgTitle = ChatUtils.getMultiMsgTitle(multiDiaRespInfo);
            if (TextUtils.isEmpty(multiMsgTitle)) {
                this.sobot_ll_content.setVisibility(4);
            } else {
                HtmlTools.getInstance(context).setRichText(this.sobot_template4_temp_title, multiMsgTitle.replaceAll("\n", "<br/>"), getLinkTextColor());
                this.sobot_ll_content.setVisibility(0);
            }
            if (MsgType.UID_GROUP_AT_ALL.equals(multiDiaRespInfo.getRetCode())) {
                List<Map<String, String>> interfaceRetList = multiDiaRespInfo.getInterfaceRetList();
                if (interfaceRetList == null || interfaceRetList.size() <= 0) {
                    this.sobot_template4_title.setText(multiDiaRespInfo.getAnswerStrip());
                    setFailureView();
                } else {
                    final Map<String, String> map = interfaceRetList.get(0);
                    if (map != null && map.size() > 0) {
                        setSuccessView();
                        HtmlTools.getInstance(context).setRichText(this.sobot_template4_title, map.get("title"), getLinkTextColor());
                        if (TextUtils.isEmpty(map.get("thumbnail"))) {
                            this.sobot_template4_thumbnail.setVisibility(8);
                        } else {
                            SobotBitmapUtil.display(context, map.get("thumbnail"), this.sobot_template4_thumbnail, ResourceUtils.getIdByName(context, i.f7952c, "sobot_bg_default_long_pic"), ResourceUtils.getIdByName(context, i.f7952c, "sobot_bg_default_long_pic"));
                            this.sobot_template4_thumbnail.setVisibility(0);
                        }
                        this.sobot_template4_summary.setText(map.get("summary"));
                        if (multiDiaRespInfo.getEndFlag() && map.get("anchor") != null) {
                            this.sobot_template4_anchor.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.viewHolder.RobotTemplateMessageHolder4.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    Tracker.onClick(view);
                                    if (SobotOption.newHyperlinkListener == null || !SobotOption.newHyperlinkListener.onUrlClick(RobotTemplateMessageHolder4.this.mContext, (String) map.get("anchor"))) {
                                        Intent intent = new Intent(context, WebViewActivity.class);
                                        intent.putExtra("url", (String) map.get("anchor"));
                                        context.startActivity(intent);
                                    }
                                }
                            });
                        }
                    }
                }
            } else {
                this.sobot_template4_title.setText(multiDiaRespInfo.getRetErrorMsg());
                setFailureView();
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
        this.sobot_tv_likeBtn.setOnClickListener(new NoDoubleClickListener() { // from class: com.sobot.chat.viewHolder.RobotTemplateMessageHolder4.3
            @Override // com.sobot.chat.listener.NoDoubleClickListener
            public void onNoDoubleClick(View view) {
                RobotTemplateMessageHolder4.this.doRevaluate(true);
            }
        });
        this.sobot_tv_dislikeBtn.setOnClickListener(new NoDoubleClickListener() { // from class: com.sobot.chat.viewHolder.RobotTemplateMessageHolder4.4
            @Override // com.sobot.chat.listener.NoDoubleClickListener
            public void onNoDoubleClick(View view) {
                RobotTemplateMessageHolder4.this.doRevaluate(false);
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
        this.sobot_ll_transferBtn.setOnClickListener(new NoDoubleClickListener() { // from class: com.sobot.chat.viewHolder.RobotTemplateMessageHolder4.2
            @Override // com.sobot.chat.listener.NoDoubleClickListener
            public void onNoDoubleClick(View view) {
                if (RobotTemplateMessageHolder4.this.msgCallBack != null) {
                    RobotTemplateMessageHolder4.this.msgCallBack.doClickTransferBtn(RobotTemplateMessageHolder4.this.message);
                }
            }
        });
    }
}
