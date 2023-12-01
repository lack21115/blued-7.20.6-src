package com.sobot.chat.viewHolder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.adapter.SobotMsgAdapter;
import com.sobot.chat.api.model.CommonModel;
import com.sobot.chat.api.model.ZhiChiInitModeBase;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.listener.NoDoubleClickListener;
import com.sobot.chat.utils.HtmlTools;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.StringUtils;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.viewHolder.base.MessageHolderBase;
import com.sobot.network.http.callback.StringResultCallBack;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/TextMessageHolder.class */
public class TextMessageHolder extends MessageHolderBase {
    TextView msg;
    RelativeLayout sobot_ll_yinsi;
    TextView sobot_msg_temp;
    TextView sobot_msg_temp_see_all;
    TextView sobot_sentisiveExplain;
    Button sobot_sentisive_cancle_send;
    TextView sobot_sentisive_cancle_tip;
    Button sobot_sentisive_ok_send;
    TextView sobot_tv_icon;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/TextMessageHolder$ReSendTextLisenter.class */
    public static class ReSendTextLisenter implements View.OnClickListener {
        private Context context;
        private String id;
        private SobotMsgAdapter.SobotMsgCallBack msgCallBack;
        private String msgContext;
        private ImageView msgStatus;

        public ReSendTextLisenter(Context context, String str, String str2, ImageView imageView, SobotMsgAdapter.SobotMsgCallBack sobotMsgCallBack) {
            this.context = context;
            this.msgCallBack = sobotMsgCallBack;
            this.id = str;
            this.msgContext = str2;
            this.msgStatus = imageView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendTextBrocast(Context context, String str, String str2) {
            if (this.msgCallBack != null) {
                ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
                zhiChiMessageBase.setContent(str2);
                zhiChiMessageBase.setId(str);
                this.msgCallBack.sendMessageToRobot(zhiChiMessageBase, 1, 0, "");
            }
        }

        private void showReSendTextDialog(final Context context, final String str, final String str2, ImageView imageView) {
            MessageHolderBase.showReSendDialog(context, imageView, new MessageHolderBase.ReSendListener() { // from class: com.sobot.chat.viewHolder.TextMessageHolder.ReSendTextLisenter.1
                @Override // com.sobot.chat.viewHolder.base.MessageHolderBase.ReSendListener
                public void onReSend() {
                    ReSendTextLisenter.this.sendTextBrocast(context, str, str2);
                }
            });
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            ImageView imageView = this.msgStatus;
            if (imageView != null) {
                imageView.setClickable(false);
            }
            showReSendTextDialog(this.context, this.id, this.msgContext, this.msgStatus);
        }
    }

    public TextMessageHolder(Context context, View view) {
        super(context, view);
        this.msg = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_msg"));
        TextView textView = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_icon"));
        this.sobot_tv_icon = textView;
        if (textView != null) {
            textView.setText(ResourceUtils.getResString(context, "sobot_leavemsg_title"));
        }
        this.rightEmptyRL = (RelativeLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_right_empty_rl"));
        this.sobot_ll_likeBtn = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_likeBtn"));
        this.sobot_ll_dislikeBtn = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_dislikeBtn"));
        this.sobot_tv_likeBtn = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_likeBtn"));
        this.sobot_tv_dislikeBtn = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_dislikeBtn"));
        this.sobot_ll_yinsi = (RelativeLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_yinsi"));
        this.sobot_msg_temp = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_msg_temp"));
        this.sobot_sentisiveExplain = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_sentisiveExplain"));
        this.sobot_msg_temp_see_all = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_msg_temp_see_all"));
        this.sobot_sentisive_ok_send = (Button) view.findViewById(ResourceUtils.getResId(context, "sobot_sentisive_ok_send"));
        this.sobot_sentisive_cancle_send = (Button) view.findViewById(ResourceUtils.getResId(context, "sobot_sentisive_cancle_send"));
        this.sobot_sentisive_cancle_tip = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_sentisive_cancle_tip"));
        this.msg.setMaxWidth(ScreenUtils.getScreenWidth((Activity) this.mContext) - ScreenUtils.dip2px(this.mContext, 102.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRevaluate(boolean z) {
        if (this.msgCallBack == null || this.message == null) {
            return;
        }
        this.msgCallBack.doRevaluate(z, this.message);
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(final Context context, final ZhiChiMessageBase zhiChiMessageBase) {
        if (zhiChiMessageBase.getAnswer() == null || (TextUtils.isEmpty(zhiChiMessageBase.getAnswer().getMsg()) && TextUtils.isEmpty(zhiChiMessageBase.getAnswer().getMsgTransfer()))) {
            this.msg.setText("");
        } else {
            String msgTransfer = !TextUtils.isEmpty(zhiChiMessageBase.getAnswer().getMsgTransfer()) ? zhiChiMessageBase.getAnswer().getMsgTransfer() : zhiChiMessageBase.getAnswer().getMsg();
            int i = 0;
            this.msg.setVisibility(0);
            HtmlTools htmlTools = HtmlTools.getInstance(context);
            TextView textView = this.msg;
            boolean z = this.isRight;
            htmlTools.setRichText(textView, msgTransfer, getLinkTextColor());
            applyTextViewUIConfig(this.msg);
            if (this.isRight) {
                try {
                    this.msgStatus.setClickable(true);
                    if (zhiChiMessageBase.getSendSuccessState() == 1) {
                        if (!StringUtils.isEmpty(zhiChiMessageBase.getDesensitizationWord())) {
                            HtmlTools htmlTools2 = HtmlTools.getInstance(context);
                            TextView textView2 = this.msg;
                            String desensitizationWord = zhiChiMessageBase.getDesensitizationWord();
                            boolean z2 = this.isRight;
                            htmlTools2.setRichText(textView2, desensitizationWord, getLinkTextColor());
                        }
                        this.msgStatus.setVisibility(8);
                        this.msgProgressBar.setVisibility(8);
                        if (zhiChiMessageBase.getSentisive() == 1) {
                            this.sobot_ll_content.setVisibility(8);
                            this.sobot_ll_yinsi.setVisibility(0);
                            if (StringUtils.isEmpty(zhiChiMessageBase.getDesensitizationWord())) {
                                HtmlTools.getInstance(context).setRichText(this.sobot_msg_temp, msgTransfer, getLinkTextColor());
                            } else {
                                HtmlTools.getInstance(context).setRichText(this.sobot_msg_temp, zhiChiMessageBase.getDesensitizationWord(), getLinkTextColor());
                            }
                            this.sobot_sentisiveExplain.setText(zhiChiMessageBase.getSentisiveExplain());
                            this.sobot_msg_temp.post(new Runnable() { // from class: com.sobot.chat.viewHolder.TextMessageHolder.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (TextMessageHolder.this.sobot_msg_temp.getLineCount() < 3 || zhiChiMessageBase.isShowSentisiveSeeAll()) {
                                        TextMessageHolder.this.sobot_msg_temp.setPadding(ScreenUtils.dip2px(context, 10.0f), ScreenUtils.dip2px(context, 10.0f), ScreenUtils.dip2px(context, 10.0f), ScreenUtils.dip2px(context, 10.0f));
                                        TextMessageHolder.this.sobot_msg_temp_see_all.setVisibility(8);
                                        TextMessageHolder.this.sobot_msg_temp.setMaxLines(100);
                                        return;
                                    }
                                    TextMessageHolder.this.sobot_msg_temp.setMaxLines(3);
                                    TextMessageHolder.this.sobot_msg_temp.setPadding(ScreenUtils.dip2px(context, 10.0f), ScreenUtils.dip2px(context, 10.0f), ScreenUtils.dip2px(context, 10.0f), 0);
                                    TextMessageHolder.this.sobot_msg_temp_see_all.setVisibility(0);
                                    TextMessageHolder.this.sobot_msg_temp.getPaint().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, TextMessageHolder.this.sobot_msg_temp.getMeasuredHeight(), new int[]{Color.parseColor(ResourceUtils.getColorById(context, "sobot_common_gray2")), Color.parseColor(ResourceUtils.getColorById(context, "sobot_common_gray2")), Color.parseColor(ResourceUtils.getColorById(context, "sobot_common_gray3"))}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
                                    TextMessageHolder.this.sobot_msg_temp.invalidate();
                                }
                            });
                            this.sobot_msg_temp_see_all.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.viewHolder.TextMessageHolder.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    Tracker.onClick(view);
                                    TextMessageHolder.this.sobot_msg_temp.setPadding(ScreenUtils.dip2px(context, 10.0f), ScreenUtils.dip2px(context, 10.0f), ScreenUtils.dip2px(context, 10.0f), ScreenUtils.dip2px(context, 10.0f));
                                    TextMessageHolder.this.sobot_msg_temp.setMaxLines(100);
                                    TextMessageHolder.this.sobot_msg_temp.getPaint().setShader(null);
                                    TextMessageHolder.this.sobot_msg_temp_see_all.setVisibility(8);
                                    zhiChiMessageBase.setShowSentisiveSeeAll(true);
                                }
                            });
                            final String str = msgTransfer;
                            this.sobot_sentisive_ok_send.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.viewHolder.TextMessageHolder.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    Tracker.onClick(view);
                                    ZhiChiInitModeBase zhiChiInitModeBase = (ZhiChiInitModeBase) SharedPreferencesUtil.getObject(context, ZhiChiConstant.sobot_last_current_initModel);
                                    ZhiChiMessageBase zhiChiMessageBase2 = zhiChiMessageBase;
                                    zhiChiMessageBase2.setMsgId(System.currentTimeMillis() + "");
                                    zhiChiMessageBase.setContent(str);
                                    SobotMsgManager.getInstance(context).getZhiChiApi().authSensitive(str, zhiChiInitModeBase.getPartnerid(), "1", new StringResultCallBack<CommonModel>() { // from class: com.sobot.chat.viewHolder.TextMessageHolder.3.1
                                        @Override // com.sobot.network.http.callback.StringResultCallBack
                                        public void onFailure(Exception exc, String str2) {
                                        }

                                        @Override // com.sobot.network.http.callback.StringResultCallBack
                                        public void onSuccess(CommonModel commonModel) {
                                            if (commonModel.getData() == null || TextUtils.isEmpty(commonModel.getData().getStatus())) {
                                                return;
                                            }
                                            if ("1".equals(commonModel.getData().getStatus()) || "2".equals(commonModel.getData().getStatus()) || "3".equals(commonModel.getData().getStatus())) {
                                                TextMessageHolder.this.msgCallBack.removeMessageByMsgId(zhiChiMessageBase.getId());
                                                TextMessageHolder.this.msgCallBack.sendMessage(str);
                                                if ("3".equals(commonModel.getData().getStatus())) {
                                                    return;
                                                }
                                                ZhiChiMessageBase zhiChiMessageBase3 = new ZhiChiMessageBase();
                                                zhiChiMessageBase3.setAction("44");
                                                zhiChiMessageBase3.setMsgId(System.currentTimeMillis() + "");
                                                TextMessageHolder.this.msgCallBack.addMessage(zhiChiMessageBase3);
                                            }
                                        }
                                    });
                                }
                            });
                            if (zhiChiMessageBase.isClickCancleSend()) {
                                this.sobot_sentisive_cancle_tip.setVisibility(0);
                                this.sobot_sentisive_cancle_send.setVisibility(8);
                            } else {
                                this.sobot_sentisive_cancle_tip.setVisibility(8);
                                this.sobot_sentisive_cancle_send.setVisibility(0);
                            }
                            final String str2 = msgTransfer;
                            this.sobot_sentisive_cancle_send.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.viewHolder.TextMessageHolder.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    Tracker.onClick(view);
                                    SobotMsgManager.getInstance(context).getZhiChiApi().authSensitive(str2, ((ZhiChiInitModeBase) SharedPreferencesUtil.getObject(context, ZhiChiConstant.sobot_last_current_initModel)).getPartnerid(), "0", new StringResultCallBack<CommonModel>() { // from class: com.sobot.chat.viewHolder.TextMessageHolder.4.1
                                        @Override // com.sobot.network.http.callback.StringResultCallBack
                                        public void onFailure(Exception exc, String str3) {
                                        }

                                        @Override // com.sobot.network.http.callback.StringResultCallBack
                                        public void onSuccess(CommonModel commonModel) {
                                            if (commonModel.getData() == null || TextUtils.isEmpty(commonModel.getData().getStatus()) || "0".equals(commonModel.getData().getStatus())) {
                                                return;
                                            }
                                            zhiChiMessageBase.setClickCancleSend(true);
                                            TextMessageHolder.this.sobot_sentisive_cancle_tip.setVisibility(0);
                                            TextMessageHolder.this.sobot_sentisive_cancle_send.setVisibility(8);
                                        }
                                    });
                                }
                            });
                        } else {
                            this.sobot_ll_content.setVisibility(0);
                            this.sobot_ll_yinsi.setVisibility(8);
                        }
                    } else if (zhiChiMessageBase.getSendSuccessState() == 0) {
                        this.msgStatus.setVisibility(0);
                        this.msgProgressBar.setVisibility(8);
                        this.msgStatus.setOnClickListener(new ReSendTextLisenter(context, zhiChiMessageBase.getId(), msgTransfer, this.msgStatus, this.msgCallBack));
                    } else if (zhiChiMessageBase.getSendSuccessState() == 2) {
                        this.msgProgressBar.setVisibility(0);
                        this.msgStatus.setVisibility(8);
                    }
                    if (this.sobot_tv_icon != null) {
                        TextView textView3 = this.sobot_tv_icon;
                        if (!zhiChiMessageBase.isLeaveMsgFlag()) {
                            i = 8;
                        }
                        textView3.setVisibility(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        this.msg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.sobot.chat.viewHolder.TextMessageHolder.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (TextUtils.isEmpty(TextMessageHolder.this.msg.getText().toString())) {
                    return false;
                }
                ToastUtil.showCopyPopWindows(context, view, TextMessageHolder.this.msg.getText().toString().replace("&amp;", "&"), 30, 0);
                return false;
            }
        });
        refreshRevaluateItem();
    }

    public void hideRevaluateBtn() {
        this.sobot_tv_likeBtn.setVisibility(8);
        this.sobot_tv_dislikeBtn.setVisibility(8);
        this.sobot_ll_likeBtn.setVisibility(8);
        this.sobot_ll_dislikeBtn.setVisibility(8);
        this.rightEmptyRL.setVisibility(8);
        this.msg.setMinHeight(ScreenUtils.dip2px(this.mContext, 22.0f));
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
        this.msg.setMinHeight(ScreenUtils.dip2px(this.mContext, 52.0f));
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
        this.msg.setMinHeight(ScreenUtils.dip2px(this.mContext, 52.0f));
    }

    public void showRevaluateBtn() {
        this.sobot_tv_likeBtn.setVisibility(0);
        this.sobot_tv_dislikeBtn.setVisibility(0);
        this.sobot_ll_likeBtn.setVisibility(0);
        this.sobot_ll_dislikeBtn.setVisibility(0);
        this.rightEmptyRL.setVisibility(0);
        this.msg.setMinHeight(ScreenUtils.dip2px(this.mContext, 52.0f));
        this.sobot_tv_likeBtn.setEnabled(true);
        this.sobot_tv_dislikeBtn.setEnabled(true);
        this.sobot_tv_likeBtn.setSelected(false);
        this.sobot_tv_dislikeBtn.setSelected(false);
        this.sobot_tv_likeBtn.setOnClickListener(new NoDoubleClickListener() { // from class: com.sobot.chat.viewHolder.TextMessageHolder.6
            @Override // com.sobot.chat.listener.NoDoubleClickListener
            public void onNoDoubleClick(View view) {
                TextMessageHolder.this.doRevaluate(true);
            }
        });
        this.sobot_tv_dislikeBtn.setOnClickListener(new NoDoubleClickListener() { // from class: com.sobot.chat.viewHolder.TextMessageHolder.7
            @Override // com.sobot.chat.listener.NoDoubleClickListener
            public void onNoDoubleClick(View view) {
                TextMessageHolder.this.doRevaluate(false);
            }
        });
    }
}
