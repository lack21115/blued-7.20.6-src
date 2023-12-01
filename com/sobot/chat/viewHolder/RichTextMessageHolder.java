package com.sobot.chat.viewHolder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.activity.SobotFileDetailActivity;
import com.sobot.chat.activity.SobotVideoActivity;
import com.sobot.chat.activity.WebViewActivity;
import com.sobot.chat.adapter.SobotMsgAdapter;
import com.sobot.chat.api.model.ChatMessageRichListModel;
import com.sobot.chat.api.model.SobotCacheFile;
import com.sobot.chat.api.model.Suggestions;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.camera.util.FileUtil;
import com.sobot.chat.listener.NoDoubleClickListener;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.HtmlTools;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.utils.SobotOption;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.viewHolder.base.MessageHolderBase;
import com.sobot.chat.widget.attachment.FileTypeConfig;
import com.sobot.pictureframe.SobotBitmapUtil;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/RichTextMessageHolder.class */
public class RichTextMessageHolder extends MessageHolderBase implements View.OnClickListener {
    private LinearLayout answersList;
    private TextView msg;
    int msgMaxWidth;
    private LinearLayout sobot_chat_more_action;
    private LinearLayout sobot_ll_content;
    private LinearLayout sobot_ll_dislikeBtn;
    private LinearLayout sobot_ll_likeBtn;
    private LinearLayout sobot_ll_switch;
    private LinearLayout sobot_ll_transferBtn;
    private TextView sobot_msgStripe;
    private LinearLayout sobot_rich_ll;
    private RelativeLayout sobot_right_empty_rl;
    private TextView sobot_tv_dislikeBtn;
    private TextView sobot_tv_likeBtn;
    private TextView sobot_tv_switch;
    private TextView sobot_tv_transferBtn;
    private View sobot_view_split;
    private TextView stripe;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/RichTextMessageHolder$AnsWerClickLisenter.class */
    public static class AnsWerClickLisenter implements View.OnClickListener {
        private Context context;
        private String docId;
        private String id;
        private ImageView img;
        private SobotMsgAdapter.SobotMsgCallBack mMsgCallBack;
        private String msgContent;

        public AnsWerClickLisenter(Context context, String str, String str2, ImageView imageView, String str3, SobotMsgAdapter.SobotMsgCallBack sobotMsgCallBack) {
            this.context = context;
            this.msgContent = str2;
            this.id = str;
            this.img = imageView;
            this.docId = str3;
            this.mMsgCallBack = sobotMsgCallBack;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            ImageView imageView = this.img;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            SobotMsgAdapter.SobotMsgCallBack sobotMsgCallBack = this.mMsgCallBack;
            if (sobotMsgCallBack != null) {
                sobotMsgCallBack.hidePanelAndKeyboard();
                ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
                zhiChiMessageBase.setContent(this.msgContent);
                zhiChiMessageBase.setId(this.id);
                this.mMsgCallBack.sendMessageToRobot(zhiChiMessageBase, 0, 1, this.docId);
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/RichTextMessageHolder$ReadAllTextLisenter.class */
    public static class ReadAllTextLisenter implements View.OnClickListener {
        private Context context;
        private String mUrlContent;

        public ReadAllTextLisenter(Context context, String str) {
            this.mUrlContent = str;
            this.context = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            if (!this.mUrlContent.startsWith("http://") && !this.mUrlContent.startsWith("https://")) {
                this.mUrlContent = "http://" + this.mUrlContent;
            }
            Intent intent = new Intent(this.context, WebViewActivity.class);
            intent.putExtra("url", this.mUrlContent);
            this.context.startActivity(intent);
        }
    }

    public RichTextMessageHolder(Context context, View view) {
        super(context, view);
        this.msgMaxWidth = ScreenUtils.getScreenWidth((Activity) this.mContext) - ScreenUtils.dip2px(this.mContext, 102.0f);
        this.msg = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_msg"));
        this.sobot_rich_ll = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_rich_ll"));
        this.sobot_msgStripe = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_msgStripe"));
        this.sobot_chat_more_action = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_chat_more_action"));
        this.sobot_ll_transferBtn = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_transferBtn"));
        this.sobot_ll_likeBtn = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_likeBtn"));
        this.sobot_ll_dislikeBtn = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_dislikeBtn"));
        this.sobot_ll_content = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_content"));
        this.sobot_ll_switch = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_switch"));
        TextView textView = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_switch"));
        this.sobot_tv_switch = textView;
        textView.setText(ResourceUtils.getResString(context, "sobot_switch"));
        this.sobot_view_split = view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_view_split"));
        this.sobot_right_empty_rl = (RelativeLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_right_empty_rl"));
        this.stripe = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_stripe"));
        this.answersList = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_answersList"));
        TextView textView2 = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_transferBtn"));
        this.sobot_tv_transferBtn = textView2;
        textView2.setText(ResourceUtils.getResString(context, "sobot_transfer_to_customer_service"));
        this.sobot_tv_likeBtn = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_likeBtn"));
        this.sobot_tv_dislikeBtn = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_dislikeBtn"));
        this.sobot_ll_switch.setOnClickListener(this);
        this.msg.setMaxWidth(this.msgMaxWidth);
    }

    private void checkShowTransferBtn() {
        if (this.message.isShowTransferBtn()) {
            showTransferBtn();
        } else {
            hideTransferBtn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRevaluate(boolean z) {
        if (this.msgCallBack != null) {
            this.msgCallBack.doRevaluate(z, this.message);
        }
    }

    private void hideContainer() {
        if (this.message.isShowTransferBtn() || this.message.getRevaluateState() != 0) {
            this.sobot_chat_more_action.setVisibility(0);
        } else {
            this.sobot_chat_more_action.setVisibility(8);
        }
    }

    private String processPrefix(ZhiChiMessageBase zhiChiMessageBase, int i) {
        if (zhiChiMessageBase == null || zhiChiMessageBase.getAnswer() == null || zhiChiMessageBase.getAnswer().getMultiDiaRespInfo() == null || zhiChiMessageBase.getAnswer().getMultiDiaRespInfo().getIcLists() == null) {
            return i + ".";
        }
        return "•";
    }

    private void resetAnswersList() {
        int i;
        int i2;
        int i3;
        if (this.message == null) {
            return;
        }
        if (this.message.getListSuggestions() == null || this.message.getListSuggestions().size() <= 0) {
            String[] sugguestions = this.message.getSugguestions();
            this.answersList.removeAllViews();
            this.answersList.setVisibility(0);
            for (int i4 = 0; i4 < sugguestions.length; i4++) {
                TextView initAnswerItemTextView = ChatUtils.initAnswerItemTextView(this.mContext, true);
                initAnswerItemTextView.setText(processPrefix(this.message, i) + sugguestions[i4]);
                this.answersList.addView(initAnswerItemTextView);
            }
        } else {
            ArrayList<Suggestions> listSuggestions = this.message.getListSuggestions();
            this.answersList.removeAllViews();
            this.answersList.setVisibility(0);
            int size = listSuggestions.size();
            if (!this.message.isGuideGroupFlag() || this.message.getGuideGroupNum() <= -1) {
                i2 = 0;
            } else {
                i2 = this.message.getCurrentPageNum() * this.message.getGuideGroupNum();
                size = Math.min(this.message.getGuideGroupNum() + i2, listSuggestions.size());
            }
            while (i2 < size) {
                TextView initAnswerItemTextView2 = ChatUtils.initAnswerItemTextView(this.mContext, false);
                initAnswerItemTextView2.setOnClickListener(new AnsWerClickLisenter(this.mContext, null, listSuggestions.get(i2).getQuestion(), null, listSuggestions.get(i2).getDocId(), this.msgCallBack));
                initAnswerItemTextView2.setText(processPrefix(this.message, i3) + listSuggestions.get(i2).getQuestion());
                this.answersList.addView(initAnswerItemTextView2);
                i2++;
            }
        }
        resetMaxWidth();
    }

    private void resetMaxWidth() {
        ViewGroup.LayoutParams layoutParams = this.sobot_ll_content.getLayoutParams();
        layoutParams.width = ScreenUtils.getScreenWidth((Activity) this.mContext) - ScreenUtils.dip2px(this.mContext, 72.0f);
        this.sobot_ll_content.setLayoutParams(layoutParams);
    }

    private void resetMinWidth() {
        ViewGroup.LayoutParams layoutParams = this.sobot_ll_content.getLayoutParams();
        layoutParams.width = -2;
        this.sobot_ll_content.setLayoutParams(layoutParams);
    }

    private void setupMsgContent(final Context context, final ZhiChiMessageBase zhiChiMessageBase) {
        LinearLayout.LayoutParams layoutParams;
        String str;
        if (zhiChiMessageBase.getAnswer() == null || zhiChiMessageBase.getAnswer().getRichList() == null || zhiChiMessageBase.getAnswer().getRichList().size() <= 0) {
            this.sobot_rich_ll.setVisibility(8);
            if (zhiChiMessageBase.getAnswer() == null || TextUtils.isEmpty(zhiChiMessageBase.getAnswer().getMsg())) {
                this.msg.setVisibility(8);
                return;
            }
            this.msg.setVisibility(0);
            HtmlTools.getInstance(context).setRichText(this.msg, "9".equals(zhiChiMessageBase.getAnswer().getMsgType()) ? zhiChiMessageBase.getAnswer().getMultiDiaRespInfo() != null ? zhiChiMessageBase.getAnswer().getMultiDiaRespInfo().getAnswer() : "" : zhiChiMessageBase.getAnswer().getMsg(), getLinkTextColor());
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, ScreenUtils.dip2px(context, 3.0f), 0, 0);
        this.sobot_rich_ll.removeAllViews();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= zhiChiMessageBase.getAnswer().getRichList().size()) {
                this.sobot_rich_ll.setVisibility(0);
                this.msg.setVisibility(8);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.leftMargin = ScreenUtils.dip2px(context, 12.0f);
                this.sobot_ll_content.setLayoutParams(layoutParams3);
                return;
            }
            final ChatMessageRichListModel chatMessageRichListModel = zhiChiMessageBase.getAnswer().getRichList().get(i2);
            if (chatMessageRichListModel != null && (!TextUtils.isEmpty(chatMessageRichListModel.getMsg()) || i2 != zhiChiMessageBase.getAnswer().getRichList().size() - 1)) {
                if (chatMessageRichListModel.getType() == 0) {
                    TextView textView = new TextView(this.mContext);
                    textView.setTextSize(14.0f);
                    textView.setLayoutParams(layoutParams2);
                    textView.setMaxWidth(this.msgMaxWidth);
                    textView.setLineSpacing(0.0f, 1.1f);
                    if (TextUtils.isEmpty(chatMessageRichListModel.getName()) || !HtmlTools.isHasPatterns(chatMessageRichListModel.getMsg())) {
                        textView.setTextColor(ContextCompat.getColor(this.mContext, ResourceUtils.getResColorId(this.mContext, "sobot_left_msg_text_color")));
                        if (TextUtils.isEmpty(chatMessageRichListModel.getMsg()) || i2 != zhiChiMessageBase.getAnswer().getRichList().size() - 1) {
                            HtmlTools.getInstance(this.mContext).setRichTextViewText(textView, chatMessageRichListModel.getMsg(), getLinkTextColor());
                        } else {
                            String trim = chatMessageRichListModel.getMsg().trim();
                            while (true) {
                                str = trim;
                                if (str.length() <= 5 || !"<br/>".equals(str.substring(str.length() - 5, str.length()))) {
                                    break;
                                }
                                trim = str.substring(0, str.length() - 5);
                            }
                            HtmlTools.getInstance(this.mContext).setRichTextViewText(textView, str, getLinkTextColor());
                        }
                    } else {
                        textView.setTextColor(ContextCompat.getColor(this.mContext, ResourceUtils.getResColorId(this.mContext, "sobot_color_link")));
                        textView.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.viewHolder.RichTextMessageHolder.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Tracker.onClick(view);
                                if (SobotOption.newHyperlinkListener == null || !SobotOption.newHyperlinkListener.onUrlClick(RichTextMessageHolder.this.mContext, chatMessageRichListModel.getMsg())) {
                                    Intent intent = new Intent(context, WebViewActivity.class);
                                    intent.putExtra("url", chatMessageRichListModel.getMsg());
                                    context.startActivity(intent);
                                }
                            }
                        });
                        textView.setText(chatMessageRichListModel.getName());
                    }
                    this.sobot_rich_ll.addView(textView);
                } else if (chatMessageRichListModel.getType() == 1 && HtmlTools.isHasPatterns(chatMessageRichListModel.getMsg())) {
                    try {
                        int resDimenId = ResourceUtils.getResDimenId(this.mContext, "sobot_rich_msg_picture_width_dp");
                        int resDimenId2 = ResourceUtils.getResDimenId(this.mContext, "sobot_rich_msg_picture_height_dp");
                        int i3 = resDimenId;
                        if (resDimenId == 0) {
                            i3 = this.msgMaxWidth;
                        }
                        int i4 = i3;
                        int i5 = resDimenId2;
                        if (i3 > this.msgMaxWidth) {
                            float f = i3 / this.msgMaxWidth;
                            i4 = this.msgMaxWidth;
                            i5 = (int) (resDimenId2 / f);
                        }
                        layoutParams = new LinearLayout.LayoutParams(i4, i5);
                    } catch (Exception e) {
                        e.printStackTrace();
                        layoutParams = new LinearLayout.LayoutParams(this.msgMaxWidth, ScreenUtils.dip2px(context, 200.0f));
                    }
                    layoutParams.setMargins(0, ScreenUtils.dip2px(context, 3.0f), 0, 0);
                    ImageView imageView = new ImageView(this.mContext);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    imageView.setLayoutParams(layoutParams);
                    SobotBitmapUtil.display(this.mContext, chatMessageRichListModel.getMsg(), imageView);
                    imageView.setOnClickListener(new MessageHolderBase.ImageClickLisenter(context, chatMessageRichListModel.getMsg(), this.isRight));
                    this.sobot_rich_ll.addView(imageView);
                } else if (chatMessageRichListModel.getType() == 3 && HtmlTools.isHasPatterns(chatMessageRichListModel.getMsg())) {
                    View inflate = LayoutInflater.from(this.mContext).inflate(ResourceUtils.getResLayoutId(this.mContext, "sobot_chat_msg_item_rich_vedio_view"), (ViewGroup) null);
                    this.sobot_rich_ll.addView(inflate);
                    inflate.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.viewHolder.RichTextMessageHolder.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            SobotCacheFile sobotCacheFile = new SobotCacheFile();
                            sobotCacheFile.setFileName(chatMessageRichListModel.getName());
                            sobotCacheFile.setUrl(chatMessageRichListModel.getMsg());
                            sobotCacheFile.setFileType(FileTypeConfig.getFileType(FileUtil.getFileEndWith(chatMessageRichListModel.getMsg())));
                            sobotCacheFile.setMsgId(zhiChiMessageBase.getMsgId() + chatMessageRichListModel.getMsg());
                            RichTextMessageHolder.this.mContext.startActivity(SobotVideoActivity.newIntent(RichTextMessageHolder.this.mContext, sobotCacheFile));
                        }
                    });
                } else if ((chatMessageRichListModel.getType() == 4 || chatMessageRichListModel.getType() == 2) && HtmlTools.isHasPatterns(chatMessageRichListModel.getMsg())) {
                    TextView textView2 = new TextView(this.mContext);
                    textView2.setMaxWidth(this.msgMaxWidth);
                    HtmlTools.getInstance(this.mContext).setRichText(textView2, TextUtils.isEmpty(chatMessageRichListModel.getName()) ? chatMessageRichListModel.getMsg() : chatMessageRichListModel.getName(), getLinkTextColor());
                    textView2.setLayoutParams(layoutParams2);
                    textView2.setTextColor(ContextCompat.getColor(this.mContext, ResourceUtils.getResColorId(this.mContext, "sobot_color_link")));
                    this.sobot_rich_ll.addView(textView2);
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.viewHolder.RichTextMessageHolder.7
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            Intent intent = new Intent(RichTextMessageHolder.this.mContext, SobotFileDetailActivity.class);
                            SobotCacheFile sobotCacheFile = new SobotCacheFile();
                            sobotCacheFile.setFileName(chatMessageRichListModel.getName());
                            sobotCacheFile.setUrl(chatMessageRichListModel.getMsg());
                            sobotCacheFile.setFileType(FileTypeConfig.getFileType(FileUtil.getFileEndWith(chatMessageRichListModel.getMsg())));
                            sobotCacheFile.setMsgId(zhiChiMessageBase.getMsgId() + chatMessageRichListModel.getMsg());
                            intent.putExtra(ZhiChiConstant.SOBOT_INTENT_DATA_SELECTED_FILE, sobotCacheFile);
                            intent.setFlags(268435456);
                            RichTextMessageHolder.this.mContext.startActivity(intent);
                        }
                    });
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(final Context context, final ZhiChiMessageBase zhiChiMessageBase) {
        if (zhiChiMessageBase.getAnswer() != null) {
            setupMsgContent(context, zhiChiMessageBase);
            if (TextUtils.isEmpty(zhiChiMessageBase.getAnswer().getMsgStripe())) {
                this.sobot_msgStripe.setVisibility(8);
            } else {
                this.sobot_msgStripe.setVisibility(0);
                this.sobot_msgStripe.setText(zhiChiMessageBase.getAnswer().getMsgStripe());
            }
        }
        String trim = zhiChiMessageBase.getStripe() != null ? zhiChiMessageBase.getStripe().trim() : "";
        if (TextUtils.isEmpty(trim)) {
            this.stripe.setText((CharSequence) null);
            this.stripe.setVisibility(8);
        } else {
            String replace = trim.replace("<p>", "").replace("</p>", "");
            this.stripe.setVisibility(0);
            HtmlTools.getInstance(context).setRichText(this.stripe, replace, getLinkTextColor());
        }
        if (!zhiChiMessageBase.isGuideGroupFlag() || zhiChiMessageBase.getListSuggestions() == null || zhiChiMessageBase.getGuideGroupNum() <= -1 || zhiChiMessageBase.getListSuggestions().size() <= 0 || zhiChiMessageBase.getGuideGroupNum() >= zhiChiMessageBase.getListSuggestions().size()) {
            this.sobot_ll_switch.setVisibility(8);
            this.sobot_view_split.setVisibility(8);
        } else {
            this.sobot_ll_switch.setVisibility(0);
            this.sobot_view_split.setVisibility(0);
        }
        if (zhiChiMessageBase.getSugguestions() == null || zhiChiMessageBase.getSugguestions().length <= 0) {
            this.answersList.setVisibility(8);
        } else {
            resetAnswersList();
        }
        checkShowTransferBtn();
        this.msg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.sobot.chat.viewHolder.RichTextMessageHolder.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (TextUtils.isEmpty(zhiChiMessageBase.getAnswer().getMsg())) {
                    return false;
                }
                ToastUtil.showCopyPopWindows(context, view, zhiChiMessageBase.getAnswer().getMsg(), 30, 0);
                return false;
            }
        });
        applyTextViewUIConfig(this.msg);
        refreshItem();
    }

    int getTextSize(TextView textView) {
        CharSequence text = textView.getText();
        return (int) Layout.getDesiredWidth(text, 0, text.length(), textView.getPaint());
    }

    public void hideRevaluateBtn() {
        hideContainer();
        this.sobot_tv_likeBtn.setVisibility(8);
        this.sobot_tv_dislikeBtn.setVisibility(8);
        this.sobot_ll_likeBtn.setVisibility(8);
        this.sobot_right_empty_rl.setVisibility(8);
        this.sobot_ll_dislikeBtn.setVisibility(8);
        this.msg.setMinHeight(ScreenUtils.dip2px(this.mContext, 22.0f));
    }

    public void hideTransferBtn() {
        hideContainer();
        this.sobot_ll_transferBtn.setVisibility(8);
        this.sobot_tv_transferBtn.setVisibility(8);
        if (this.message != null) {
            this.message.setShowTransferBtn(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view != this.sobot_ll_switch || this.message == null || this.message.getListSuggestions() == null || this.message.getListSuggestions().size() <= 0) {
            return;
        }
        LogUtils.i(this.message.getCurrentPageNum() + "==================");
        int currentPageNum = this.message.getCurrentPageNum() + 1;
        int size = this.message.getListSuggestions().size();
        int guideGroupNum = this.message.getGuideGroupNum();
        int i = guideGroupNum;
        if (guideGroupNum == 0) {
            i = 5;
        }
        int i2 = size / i;
        int i3 = size % i == 0 ? i2 : i2 + 1;
        LogUtils.i(i3 + "=========maxNum=========");
        int i4 = currentPageNum;
        if (currentPageNum >= i3) {
            i4 = 0;
        }
        this.message.setCurrentPageNum(i4);
        LogUtils.i(this.message.getCurrentPageNum() + "==================");
        resetAnswersList();
    }

    public void refreshItem() {
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
        this.sobot_chat_more_action.setVisibility(0);
        this.sobot_tv_likeBtn.setVisibility(8);
        this.sobot_tv_dislikeBtn.setVisibility(0);
        this.sobot_right_empty_rl.setVisibility(0);
        this.sobot_ll_likeBtn.setVisibility(8);
        this.sobot_ll_dislikeBtn.setVisibility(0);
        this.msg.setMinHeight(ScreenUtils.dip2px(this.mContext, 52.0f));
    }

    public void showLikeWordView() {
        this.sobot_tv_likeBtn.setSelected(true);
        this.sobot_tv_likeBtn.setEnabled(false);
        this.sobot_tv_dislikeBtn.setEnabled(false);
        this.sobot_tv_dislikeBtn.setSelected(false);
        this.sobot_chat_more_action.setVisibility(0);
        this.sobot_tv_likeBtn.setVisibility(0);
        this.sobot_tv_dislikeBtn.setVisibility(8);
        this.sobot_ll_likeBtn.setVisibility(0);
        this.sobot_right_empty_rl.setVisibility(0);
        this.sobot_ll_dislikeBtn.setVisibility(8);
        this.msg.setMinHeight(ScreenUtils.dip2px(this.mContext, 52.0f));
    }

    public void showRevaluateBtn() {
        this.sobot_chat_more_action.setVisibility(0);
        this.sobot_tv_likeBtn.setVisibility(0);
        this.sobot_tv_dislikeBtn.setVisibility(0);
        this.sobot_ll_likeBtn.setVisibility(0);
        this.sobot_ll_dislikeBtn.setVisibility(0);
        this.sobot_right_empty_rl.setVisibility(0);
        this.sobot_tv_likeBtn.setEnabled(true);
        this.sobot_tv_dislikeBtn.setEnabled(true);
        this.sobot_tv_likeBtn.setSelected(false);
        this.sobot_tv_dislikeBtn.setSelected(false);
        this.msg.setMinHeight(ScreenUtils.dip2px(this.mContext, 52.0f));
        LinearLayout linearLayout = this.sobot_rich_ll;
        if (linearLayout != null && linearLayout.getChildCount() == 1) {
            for (int i = 0; i < this.sobot_rich_ll.getChildCount(); i++) {
                View childAt = this.sobot_rich_ll.getChildAt(i);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setMinHeight(ScreenUtils.dip2px(this.mContext, 52.0f));
                }
            }
        }
        this.sobot_tv_likeBtn.setOnClickListener(new NoDoubleClickListener() { // from class: com.sobot.chat.viewHolder.RichTextMessageHolder.3
            @Override // com.sobot.chat.listener.NoDoubleClickListener
            public void onNoDoubleClick(View view) {
                RichTextMessageHolder.this.doRevaluate(true);
            }
        });
        this.sobot_tv_dislikeBtn.setOnClickListener(new NoDoubleClickListener() { // from class: com.sobot.chat.viewHolder.RichTextMessageHolder.4
            @Override // com.sobot.chat.listener.NoDoubleClickListener
            public void onNoDoubleClick(View view) {
                RichTextMessageHolder.this.doRevaluate(false);
            }
        });
    }

    public void showTransferBtn() {
        this.sobot_chat_more_action.setVisibility(0);
        this.sobot_tv_transferBtn.setVisibility(0);
        this.sobot_ll_transferBtn.setVisibility(0);
        if (this.message != null) {
            this.message.setShowTransferBtn(true);
        }
        this.sobot_ll_transferBtn.setOnClickListener(new NoDoubleClickListener() { // from class: com.sobot.chat.viewHolder.RichTextMessageHolder.2
            @Override // com.sobot.chat.listener.NoDoubleClickListener
            public void onNoDoubleClick(View view) {
                if (RichTextMessageHolder.this.msgCallBack != null) {
                    RichTextMessageHolder.this.msgCallBack.doClickTransferBtn(RichTextMessageHolder.this.message);
                }
            }
        });
    }
}
