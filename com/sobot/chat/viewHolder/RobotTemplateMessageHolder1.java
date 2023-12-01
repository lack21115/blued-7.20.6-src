package com.sobot.chat.viewHolder;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.chat.data.MsgType;
import com.sobot.chat.activity.WebViewActivity;
import com.sobot.chat.api.model.SobotMultiDiaRespInfo;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.listener.NoDoubleClickListener;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.HtmlTools;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.SobotOption;
import com.sobot.chat.viewHolder.base.MessageHolderBase;
import com.sobot.chat.widget.horizontalgridpage.HorizontalGridPage;
import com.sobot.chat.widget.horizontalgridpage.PageBuilder;
import com.sobot.chat.widget.horizontalgridpage.PageCallBack;
import com.sobot.chat.widget.horizontalgridpage.PageGridAdapter;
import com.sobot.chat.widget.image.SobotRCImageView;
import com.sobot.pictureframe.SobotBitmapUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/RobotTemplateMessageHolder1.class */
public class RobotTemplateMessageHolder1 extends MessageHolderBase {
    private PageGridAdapter adapter;
    private Context mContext;
    public ZhiChiMessageBase message;
    private PageBuilder pageBuilder;
    private HorizontalGridPage pageView;
    private LinearLayout sobot_ll_content;
    private LinearLayout sobot_ll_transferBtn;
    private TextView sobot_tv_transferBtn;
    private TextView tv_title;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/RobotTemplateMessageHolder1$Template1ViewHolder.class */
    class Template1ViewHolder extends RecyclerView.ViewHolder {
        TextView sobotLable;
        LinearLayout sobotLayout;
        TextView sobotOtherLable;
        TextView sobotSummary;
        SobotRCImageView sobotThumbnail;
        TextView sobotTitle;

        public Template1ViewHolder(View view, Context context) {
            super(view);
            this.sobotLayout = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template1_item_"));
            this.sobotThumbnail = (SobotRCImageView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template1_item_thumbnail"));
            this.sobotTitle = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template1_item_title"));
            this.sobotSummary = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template1_item_summary"));
            this.sobotLable = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template1_item_lable"));
            this.sobotOtherLable = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template1_item_other_flag"));
        }
    }

    public RobotTemplateMessageHolder1(Context context, View view) {
        super(context, view);
        this.tv_title = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot__template1_msg"));
        this.sobot_ll_content = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_content"));
        this.pageView = (HorizontalGridPage) view.findViewById(ResourceUtils.getIdByName(context, "id", "pageView"));
        this.sobot_ll_transferBtn = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_transferBtn"));
        TextView textView = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_transferBtn"));
        this.sobot_tv_transferBtn = textView;
        textView.setText(ResourceUtils.getResString(context, "sobot_transfer_to_customer_service"));
        this.mContext = context;
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

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(Context context, ZhiChiMessageBase zhiChiMessageBase) {
        this.message = zhiChiMessageBase;
        if (zhiChiMessageBase.getAnswer() != null && zhiChiMessageBase.getAnswer().getMultiDiaRespInfo() != null) {
            SobotMultiDiaRespInfo multiDiaRespInfo = zhiChiMessageBase.getAnswer().getMultiDiaRespInfo();
            String multiMsgTitle = ChatUtils.getMultiMsgTitle(multiDiaRespInfo);
            if (TextUtils.isEmpty(multiMsgTitle)) {
                this.sobot_ll_content.setVisibility(4);
            } else {
                HtmlTools.getInstance(context).setRichText(this.tv_title, multiMsgTitle.replaceAll("\n", "<br/>"), getLinkTextColor());
                this.sobot_ll_content.setVisibility(0);
            }
            checkShowTransferBtn();
            List<Map<String, String>> interfaceRetList = multiDiaRespInfo.getInterfaceRetList();
            if (!MsgType.UID_GROUP_AT_ALL.equals(multiDiaRespInfo.getRetCode()) || interfaceRetList == null || interfaceRetList.size() <= 0) {
                this.pageView.setVisibility(8);
            } else {
                this.pageView.setVisibility(0);
                if (interfaceRetList.size() >= 3) {
                    initView(3, 1);
                } else {
                    initView(interfaceRetList.size(), (int) Math.ceil(interfaceRetList.size() / 3.0f));
                }
                this.adapter.setData((ArrayList) interfaceRetList);
                this.adapter.setZhiChiMessageBaseData(zhiChiMessageBase);
            }
        }
        applyTextViewUIConfig(this.tv_title);
        refreshRevaluateItem();
        this.pageView.selectCurrentItem();
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

    public void initView(int i, int i2) {
        if (this.pageBuilder != null) {
            return;
        }
        this.pageBuilder = new PageBuilder.Builder().setGrid(i, i2).setPageMargin(0).setIndicatorMargins(5, 10, 5, 10).setIndicatorSize(10).setIndicatorRes(17301609, 17301611).setIndicatorGravity(17).setSwipePercent(40).setShowIndicator(true).setSpace(5).setItemHeight(ScreenUtils.dip2px(this.mContext, 125.0f)).build();
        this.adapter = new PageGridAdapter(new PageCallBack() { // from class: com.sobot.chat.viewHolder.RobotTemplateMessageHolder1.1
            @Override // com.sobot.chat.widget.horizontalgridpage.PageCallBack
            public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
                Map map = (Map) RobotTemplateMessageHolder1.this.adapter.getData().get(i3);
                if (TextUtils.isEmpty((CharSequence) map.get("thumbnail"))) {
                    ((Template1ViewHolder) viewHolder).sobotThumbnail.setVisibility(8);
                } else {
                    Template1ViewHolder template1ViewHolder = (Template1ViewHolder) viewHolder;
                    template1ViewHolder.sobotThumbnail.setVisibility(0);
                    template1ViewHolder.sobotSummary.setMaxLines(1);
                    template1ViewHolder.sobotSummary.setEllipsize(TextUtils.TruncateAt.END);
                    SobotBitmapUtil.display(RobotTemplateMessageHolder1.this.mContext, (String) map.get("thumbnail"), template1ViewHolder.sobotThumbnail, ResourceUtils.getDrawableId(RobotTemplateMessageHolder1.this.mContext, "sobot_bg_default_pic_img"), ResourceUtils.getDrawableId(RobotTemplateMessageHolder1.this.mContext, "sobot_bg_default_pic_img"));
                }
                Template1ViewHolder template1ViewHolder2 = (Template1ViewHolder) viewHolder;
                template1ViewHolder2.sobotTitle.setText((CharSequence) map.get("title"));
                template1ViewHolder2.sobotSummary.setText((CharSequence) map.get("summary"));
                template1ViewHolder2.sobotLable.setText((CharSequence) map.get("label"));
                template1ViewHolder2.sobotOtherLable.setText((CharSequence) map.get("tag"));
                if (TextUtils.isEmpty((CharSequence) map.get("label"))) {
                    template1ViewHolder2.sobotLable.setVisibility(8);
                } else {
                    template1ViewHolder2.sobotLable.setVisibility(0);
                }
            }

            @Override // com.sobot.chat.widget.horizontalgridpage.PageCallBack
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
                return new Template1ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(ResourceUtils.getResLayoutId(viewGroup.getContext(), "sobot_chat_msg_item_template1_item_l"), viewGroup, false), viewGroup.getContext());
            }

            @Override // com.sobot.chat.widget.horizontalgridpage.PageCallBack
            public void onItemClickListener(View view, int i3) {
                String stringData = SharedPreferencesUtil.getStringData(RobotTemplateMessageHolder1.this.mContext, "lastCid", "");
                if (RobotTemplateMessageHolder1.this.adapter.getZhiChiMessageBaseData().getSugguestionsFontColor() == 0 && !TextUtils.isEmpty(RobotTemplateMessageHolder1.this.adapter.getZhiChiMessageBaseData().getCid()) && stringData.equals(RobotTemplateMessageHolder1.this.adapter.getZhiChiMessageBaseData().getCid())) {
                    if (RobotTemplateMessageHolder1.this.adapter.getZhiChiMessageBaseData().getAnswer().getMultiDiaRespInfo().getClickFlag() != 0 || RobotTemplateMessageHolder1.this.adapter.getZhiChiMessageBaseData().getClickCount() <= 0) {
                        RobotTemplateMessageHolder1.this.adapter.getZhiChiMessageBaseData().addClickCount();
                        SobotMultiDiaRespInfo multiDiaRespInfo = RobotTemplateMessageHolder1.this.adapter.getZhiChiMessageBaseData().getAnswer().getMultiDiaRespInfo();
                        Map map = (Map) RobotTemplateMessageHolder1.this.adapter.getData().get(i3);
                        if (RobotTemplateMessageHolder1.this.mContext == null || multiDiaRespInfo == null || map == null) {
                            return;
                        }
                        if (!multiDiaRespInfo.getEndFlag() || TextUtils.isEmpty((CharSequence) map.get("anchor"))) {
                            ChatUtils.sendMultiRoundQuestions(RobotTemplateMessageHolder1.this.mContext, multiDiaRespInfo, map, RobotTemplateMessageHolder1.this.msgCallBack);
                        } else if (SobotOption.newHyperlinkListener == null || !SobotOption.newHyperlinkListener.onUrlClick(RobotTemplateMessageHolder1.this.mContext, (String) map.get("anchor"))) {
                            Intent intent = new Intent(RobotTemplateMessageHolder1.this.mContext, WebViewActivity.class);
                            intent.putExtra("url", (String) map.get("anchor"));
                            RobotTemplateMessageHolder1.this.mContext.startActivity(intent);
                        }
                    }
                }
            }

            @Override // com.sobot.chat.widget.horizontalgridpage.PageCallBack
            public void onItemLongClickListener(View view, int i3) {
            }
        });
        this.pageView.init(this.pageBuilder, this.message.getCurrentPageNum());
        this.adapter.init(this.pageBuilder);
        this.pageView.setAdapter(this.adapter, this.message);
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
        this.sobot_tv_likeBtn.setOnClickListener(new NoDoubleClickListener() { // from class: com.sobot.chat.viewHolder.RobotTemplateMessageHolder1.3
            @Override // com.sobot.chat.listener.NoDoubleClickListener
            public void onNoDoubleClick(View view) {
                RobotTemplateMessageHolder1.this.doRevaluate(true);
            }
        });
        this.sobot_tv_dislikeBtn.setOnClickListener(new NoDoubleClickListener() { // from class: com.sobot.chat.viewHolder.RobotTemplateMessageHolder1.4
            @Override // com.sobot.chat.listener.NoDoubleClickListener
            public void onNoDoubleClick(View view) {
                RobotTemplateMessageHolder1.this.doRevaluate(false);
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
        this.sobot_ll_transferBtn.setOnClickListener(new NoDoubleClickListener() { // from class: com.sobot.chat.viewHolder.RobotTemplateMessageHolder1.2
            @Override // com.sobot.chat.listener.NoDoubleClickListener
            public void onNoDoubleClick(View view) {
                if (RobotTemplateMessageHolder1.this.msgCallBack != null) {
                    RobotTemplateMessageHolder1.this.msgCallBack.doClickTransferBtn(RobotTemplateMessageHolder1.this.message);
                }
            }
        });
    }
}
