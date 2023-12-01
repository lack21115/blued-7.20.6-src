package com.sobot.chat.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.SobotApi;
import com.sobot.chat.SobotUIConfig;
import com.sobot.chat.ZCSobotApi;
import com.sobot.chat.activity.SobotFileDetailActivity;
import com.sobot.chat.activity.SobotPhotoActivity;
import com.sobot.chat.activity.SobotVideoActivity;
import com.sobot.chat.activity.WebViewActivity;
import com.sobot.chat.adapter.base.SobotBaseAdapter;
import com.sobot.chat.api.model.SobotCacheFile;
import com.sobot.chat.api.model.SobotFileModel;
import com.sobot.chat.api.model.SobotUserTicketEvaluate;
import com.sobot.chat.api.model.SobotUserTicketInfo;
import com.sobot.chat.api.model.StUserDealTicketInfo;
import com.sobot.chat.api.model.StUserDealTicketReply;
import com.sobot.chat.notchlib.INotchScreen;
import com.sobot.chat.notchlib.NotchScreenManager;
import com.sobot.chat.utils.DateUtil;
import com.sobot.chat.utils.HtmlTools;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.utils.SobotOption;
import com.sobot.chat.utils.StringUtils;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.widget.StExpandableTextView;
import com.sobot.chat.widget.attachment.AttachmentView;
import com.sobot.chat.widget.attachment.FileAttachmentAdapter;
import com.sobot.chat.widget.attachment.FileTypeConfig;
import com.sobot.chat.widget.attachment.SpaceItemDecoration;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotTicketDetailAdapter.class */
public class SobotTicketDetailAdapter extends SobotBaseAdapter<Object> {
    public static final int MSG_TYPE_HEAD = 0;
    public static final int MSG_TYPE_TYPE1 = 1;
    public static final int MSG_TYPE_TYPE2 = 2;
    public static final int MSG_TYPE_TYPE3 = 3;
    public static final int MSG_TYPE_TYPE4 = 4;
    private static final String[] layoutRes = {"sobot_ticket_detail_head_item", "sobot_ticket_detail_created_item", "sobot_ticket_detail_processing_item", "sobot_ticket_detail_completed_item", "sobot_ticket_detail_foot_item"};
    private int attachmentCount;
    AttachmentView.Listener listener;
    private Activity mActivity;
    private Context mContext;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotTicketDetailAdapter$BaseViewHolder.class */
    static abstract class BaseViewHolder {
        Context mContext;

        BaseViewHolder(Context context, View view) {
            this.mContext = context;
        }

        abstract void bindData(Object obj, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotTicketDetailAdapter$HeadViewHolder.class */
    public class HeadViewHolder extends BaseViewHolder {
        private int bg1_resId;
        private int bg2_resId;
        private int bg3_resId;
        private ImageView imageView;
        private Context mContext;
        private RecyclerView recyclerView;
        private String str1_resId;
        private String str2_resId;
        private String str3_resId;
        private TextView textView;
        private StExpandableTextView tv_exp;
        private TextView tv_ticket_status;
        private TextView tv_time;
        private TextView tv_title;

        HeadViewHolder(Context context, View view) {
            super(context, view);
            this.mContext = context;
            this.tv_title = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_title"));
            StExpandableTextView stExpandableTextView = (StExpandableTextView) view.findViewById(ResourceUtils.getResId(context, "sobot_content_fl"));
            this.tv_exp = stExpandableTextView;
            this.imageView = stExpandableTextView.getImageView();
            this.textView = this.tv_exp.getTextBtn();
            this.tv_exp.setOnExpandStateChangeListener(new StExpandableTextView.OnExpandStateChangeListener() { // from class: com.sobot.chat.adapter.SobotTicketDetailAdapter.HeadViewHolder.1
                @Override // com.sobot.chat.widget.StExpandableTextView.OnExpandStateChangeListener
                public void onExpandStateChanged(TextView textView, boolean z) {
                    if (z) {
                        HeadViewHolder.this.textView.setText(ResourceUtils.getResString(HeadViewHolder.this.mContext, "sobot_notice_collapse"));
                    } else {
                        HeadViewHolder.this.textView.setText(ResourceUtils.getResString(HeadViewHolder.this.mContext, "sobot_notice_expand"));
                    }
                }
            });
            this.textView.setText(ResourceUtils.getResString(this.mContext, "sobot_notice_expand"));
            this.imageView.setImageResource(ResourceUtils.getDrawableId(this.mContext, "sobot_icon_arrow_down"));
            this.tv_time = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_time"));
            ViewGroup viewGroup = this.tv_exp.getmOtherView();
            if (viewGroup != null) {
                this.recyclerView = (RecyclerView) viewGroup.findViewById(ResourceUtils.getResId(context, "sobot_attachment_file_layout"));
                GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
                this.recyclerView.addItemDecoration(new SpaceItemDecoration(ScreenUtils.dip2px(this.mContext, 10.0f), ScreenUtils.dip2px(this.mContext, 10.0f), 0, 1));
                this.recyclerView.setLayoutManager(gridLayoutManager);
            }
            this.tv_ticket_status = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_ticket_status"));
            this.bg1_resId = ResourceUtils.getDrawableId(context, "sobot_ticket_status_bg3");
            this.bg2_resId = ResourceUtils.getDrawableId(context, "sobot_ticket_status_bg2");
            this.bg3_resId = ResourceUtils.getDrawableId(context, "sobot_ticket_status_bg1");
            this.str1_resId = ResourceUtils.getResString(context, "sobot_created_1");
            this.str2_resId = ResourceUtils.getResString(context, "sobot_processing");
            this.str3_resId = ResourceUtils.getResString(context, "sobot_completed");
        }

        @Override // com.sobot.chat.adapter.SobotTicketDetailAdapter.BaseViewHolder
        void bindData(Object obj, int i) {
            SobotTicketDetailAdapter sobotTicketDetailAdapter = SobotTicketDetailAdapter.this;
            sobotTicketDetailAdapter.displayInNotch(sobotTicketDetailAdapter.mActivity, this.tv_time, 0);
            SobotTicketDetailAdapter sobotTicketDetailAdapter2 = SobotTicketDetailAdapter.this;
            sobotTicketDetailAdapter2.displayInNotch(sobotTicketDetailAdapter2.mActivity, this.tv_exp, 0);
            SobotUserTicketInfo sobotUserTicketInfo = (SobotUserTicketInfo) obj;
            if (sobotUserTicketInfo != null && !TextUtils.isEmpty(sobotUserTicketInfo.getContent())) {
                this.tv_exp.setText(TextUtils.isEmpty(sobotUserTicketInfo.getContent()) ? "" : Html.fromHtml(sobotUserTicketInfo.getContent().replaceAll("<br/>", "").replace("<p></p>", "").replaceAll("<p>", "").replaceAll("</p>", "<br/>").replaceAll("\n", "<br/>")));
            }
            int resColorValue = ResourceUtils.getResColorValue(SobotTicketDetailAdapter.this.context, "sobot_common_text_gray");
            if (2 == sobotUserTicketInfo.getFlag()) {
                this.tv_ticket_status.setText(this.str2_resId);
                this.tv_ticket_status.setBackgroundResource(this.bg2_resId);
            } else if (3 == sobotUserTicketInfo.getFlag()) {
                this.tv_ticket_status.setText(this.str3_resId);
                this.tv_ticket_status.setBackgroundResource(this.bg3_resId);
            } else {
                this.tv_ticket_status.setText(this.str1_resId);
                this.tv_ticket_status.setBackgroundResource(this.bg1_resId);
            }
            this.tv_time.setText(DateUtil.stringToFormatString(sobotUserTicketInfo.getTimeStr(), DateUtil.DATE_TIME_FORMAT, Boolean.valueOf(ZCSobotApi.getSwitchMarkStatus(8))));
            StExpandableTextView stExpandableTextView = this.tv_exp;
            boolean z = false;
            if (sobotUserTicketInfo.getFileList() != null) {
                z = false;
                if (sobotUserTicketInfo.getFileList().size() > 0) {
                    z = true;
                }
            }
            stExpandableTextView.setHaveFile(z);
            this.recyclerView.setAdapter(new FileAttachmentAdapter(SobotTicketDetailAdapter.this.context, sobotUserTicketInfo.getFileList(), resColorValue, SobotTicketDetailAdapter.this.listener));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotTicketDetailAdapter$Type1ViewHolder.class */
    public class Type1ViewHolder extends BaseViewHolder {
        private View sobot_line_split;
        private View sobot_line_view;
        private LinearLayout sobot_ll_root;
        private TextView sobot_tv_icon2;
        private TextView sobot_tv_secod;
        private TextView sobot_tv_status;
        private TextView sobot_tv_time;

        Type1ViewHolder(Context context, View view) {
            super(context, view);
            this.sobot_ll_root = (LinearLayout) view.findViewById(ResourceUtils.getResId(context, "sobot_ll_root"));
            this.sobot_tv_icon2 = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_icon2"));
            TextView textView = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_status"));
            this.sobot_tv_status = textView;
            textView.setText(ResourceUtils.getResString(context, "sobot_created_1"));
            this.sobot_tv_time = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_time"));
            this.sobot_tv_secod = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_secod"));
            this.sobot_line_view = view.findViewById(ResourceUtils.getResId(context, "sobot_line_view"));
            this.sobot_line_split = view.findViewById(ResourceUtils.getResId(context, "sobot_line_split"));
        }

        @Override // com.sobot.chat.adapter.SobotTicketDetailAdapter.BaseViewHolder
        void bindData(Object obj, int i) {
            LinearLayout.LayoutParams layoutParams;
            SobotTicketDetailAdapter sobotTicketDetailAdapter = SobotTicketDetailAdapter.this;
            sobotTicketDetailAdapter.displayInNotch(sobotTicketDetailAdapter.mActivity, this.sobot_ll_root, ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 20.0f));
            if (i == 1) {
                layoutParams = new LinearLayout.LayoutParams(ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 19.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 19.0f));
                this.sobot_tv_time.setSelected(true);
                this.sobot_tv_status.setSelected(true);
                this.sobot_tv_secod.setSelected(true);
                this.sobot_tv_icon2.setSelected(true);
                this.sobot_line_split.setVisibility(0);
                this.sobot_line_view.setBackgroundColor(Color.parseColor("#00000000"));
                this.sobot_ll_root.setPadding(ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 20.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 30.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 20.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 30.0f));
            } else {
                this.sobot_tv_time.setSelected(false);
                this.sobot_tv_status.setSelected(false);
                this.sobot_tv_secod.setSelected(false);
                this.sobot_tv_icon2.setSelected(false);
                layoutParams = new LinearLayout.LayoutParams(ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 14.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 14.0f));
                this.sobot_line_split.setVisibility(8);
                this.sobot_line_view.setBackgroundColor(ContextCompat.getColor(SobotTicketDetailAdapter.this.context, ResourceUtils.getResColorId(SobotTicketDetailAdapter.this.context, "sobot_ticket_deal_line_grey")));
                this.sobot_ll_root.setPadding(ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 20.0f), 0, ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 20.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 30.0f));
            }
            this.sobot_tv_icon2.setLayoutParams(layoutParams);
            StUserDealTicketInfo stUserDealTicketInfo = (StUserDealTicketInfo) obj;
            this.sobot_tv_time.setText(DateUtil.stringToFormatString(stUserDealTicketInfo.getTimeStr(), "MM-dd", Boolean.valueOf(ZCSobotApi.getSwitchMarkStatus(8))));
            this.sobot_tv_secod.setText(DateUtil.stringToFormatString(stUserDealTicketInfo.getTimeStr(), "HH:mm", Boolean.valueOf(ZCSobotApi.getSwitchMarkStatus(8))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotTicketDetailAdapter$Type2ViewHolder.class */
    public class Type2ViewHolder extends BaseViewHolder {
        private RecyclerView recyclerView;
        private View sobot_line_split;
        private LinearLayout sobot_ll_container;
        private LinearLayout sobot_ll_root;
        private View sobot_top_line_view;
        private TextView sobot_tv_content;
        private TextView sobot_tv_content_detail;
        private View sobot_tv_content_detail_split;
        private LinearLayout sobot_tv_content_ll;
        private TextView sobot_tv_icon2;
        private TextView sobot_tv_secod;
        private TextView sobot_tv_status;
        private TextView sobot_tv_time;

        Type2ViewHolder(Context context, View view) {
            super(context, view);
            this.sobot_ll_root = (LinearLayout) view.findViewById(ResourceUtils.getResId(context, "sobot_ll_root"));
            this.sobot_tv_icon2 = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_icon2"));
            this.sobot_tv_status = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_status"));
            this.sobot_tv_time = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_time"));
            this.sobot_tv_secod = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_secod"));
            this.sobot_tv_content_ll = (LinearLayout) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_content_ll"));
            this.sobot_tv_content = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_content"));
            this.sobot_tv_content_detail_split = view.findViewById(ResourceUtils.getResId(context, "sobot_tv_content_detail_split"));
            TextView textView = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_content_detail"));
            this.sobot_tv_content_detail = textView;
            textView.setText(ResourceUtils.getResString(context, "sobot_see_detail"));
            this.sobot_ll_container = (LinearLayout) view.findViewById(ResourceUtils.getResId(context, "sobot_ll_container"));
            this.sobot_top_line_view = view.findViewById(ResourceUtils.getResId(context, "sobot_top_line_view"));
            this.sobot_line_split = view.findViewById(ResourceUtils.getResId(context, "sobot_line_split"));
            this.recyclerView = (RecyclerView) view.findViewById(ResourceUtils.getResId(context, "sobot_attachment_file_layout"));
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
            this.recyclerView.addItemDecoration(new SpaceItemDecoration(ScreenUtils.dip2px(this.mContext, 10.0f), ScreenUtils.dip2px(this.mContext, 10.0f), 0, 1));
            this.recyclerView.setLayoutManager(gridLayoutManager);
        }

        @Override // com.sobot.chat.adapter.SobotTicketDetailAdapter.BaseViewHolder
        void bindData(Object obj, int i) {
            int resColorValue;
            LinearLayout.LayoutParams layoutParams;
            String fromHtml;
            SobotTicketDetailAdapter sobotTicketDetailAdapter = SobotTicketDetailAdapter.this;
            sobotTicketDetailAdapter.displayInNotch(sobotTicketDetailAdapter.mActivity, this.sobot_ll_root, ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 20.0f));
            if (i == 1) {
                layoutParams = new LinearLayout.LayoutParams(ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 19.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 19.0f));
                this.sobot_tv_time.setSelected(true);
                this.sobot_tv_secod.setSelected(true);
                this.sobot_tv_icon2.setSelected(true);
                this.sobot_tv_status.setSelected(true);
                this.sobot_ll_container.setSelected(true);
                resColorValue = ResourceUtils.getResColorValue(SobotTicketDetailAdapter.this.context, "sobot_common_gray1");
                this.sobot_top_line_view.setBackgroundColor(Color.parseColor("#00000000"));
                this.sobot_line_split.setVisibility(0);
                this.sobot_tv_icon2.setBackgroundResource(ResourceUtils.getDrawableId(SobotTicketDetailAdapter.this.context, "sobot_icon_processing_point_selector_2"));
                this.sobot_ll_root.setPadding(ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 20.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 30.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 20.0f), 0);
            } else {
                this.sobot_tv_time.setSelected(false);
                this.sobot_tv_secod.setSelected(false);
                this.sobot_tv_icon2.setSelected(false);
                this.sobot_tv_status.setSelected(false);
                this.sobot_ll_container.setSelected(false);
                resColorValue = ResourceUtils.getResColorValue(SobotTicketDetailAdapter.this.context, "sobot_common_text_gray");
                layoutParams = new LinearLayout.LayoutParams(ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 14.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 14.0f));
                this.sobot_tv_icon2.setBackgroundResource(ResourceUtils.getDrawableId(SobotTicketDetailAdapter.this.context, "sobot_icon_processing_point_selector"));
                this.sobot_top_line_view.setBackgroundColor(ContextCompat.getColor(SobotTicketDetailAdapter.this.context, ResourceUtils.getResColorId(SobotTicketDetailAdapter.this.context, "sobot_ticket_deal_line_grey")));
                this.sobot_line_split.setVisibility(8);
                this.sobot_ll_root.setPadding(ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 20.0f), 0, ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 20.0f), 0);
            }
            this.sobot_tv_icon2.setLayoutParams(layoutParams);
            StUserDealTicketInfo stUserDealTicketInfo = (StUserDealTicketInfo) obj;
            final StUserDealTicketReply reply = stUserDealTicketInfo.getReply();
            if (reply == null) {
                this.sobot_tv_status.setVisibility(8);
                this.sobot_tv_content.setText(TextUtils.isEmpty(stUserDealTicketInfo.getContent()) ? "" : Html.fromHtml(stUserDealTicketInfo.getContent().replaceAll("<p>", "").replaceAll("</p>", "")));
                this.sobot_tv_time.setText(DateUtil.stringToFormatString(stUserDealTicketInfo.getTimeStr(), "MM-dd", Boolean.valueOf(ZCSobotApi.getSwitchMarkStatus(8))));
                this.sobot_tv_secod.setText(DateUtil.stringToFormatString(stUserDealTicketInfo.getTimeStr(), "HH:mm", Boolean.valueOf(ZCSobotApi.getSwitchMarkStatus(8))));
                return;
            }
            if (reply.getStartType() == 0) {
                this.sobot_tv_status.setVisibility(0);
                this.sobot_tv_status.setText(ResourceUtils.getResString(SobotTicketDetailAdapter.this.context, "sobot_processing"));
                if (TextUtils.isEmpty(reply.getReplyContent())) {
                    this.sobot_tv_content_ll.setBackgroundDrawable(null);
                    this.sobot_tv_content_detail.setVisibility(8);
                    this.sobot_tv_content_detail.setOnClickListener(null);
                    this.sobot_tv_content_detail_split.setVisibility(8);
                    this.sobot_tv_content.setPadding(0, 0, 0, 0);
                } else {
                    if (StringUtils.getImgSrc(reply.getReplyContent()).size() > 0) {
                        this.sobot_tv_content_ll.setBackgroundDrawable(SobotTicketDetailAdapter.this.context.getResources().getDrawable(ResourceUtils.getDrawableId(SobotTicketDetailAdapter.this.context, "sobot_round_ticket")));
                        this.sobot_tv_content_detail.setVisibility(0);
                        this.sobot_tv_content_detail_split.setVisibility(0);
                        this.sobot_tv_content.setPadding(ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 15.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 10.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 15.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 10.0f));
                        this.sobot_tv_content_detail.setPadding(ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 15.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 11.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 15.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 11.0f));
                        this.sobot_tv_content_detail.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.adapter.SobotTicketDetailAdapter.Type2ViewHolder.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Tracker.onClick(view);
                                Intent intent = new Intent(SobotTicketDetailAdapter.this.context, WebViewActivity.class);
                                intent.putExtra("url", reply.getReplyContent());
                                SobotTicketDetailAdapter.this.context.startActivity(intent);
                            }
                        });
                    } else {
                        this.sobot_tv_content_ll.setBackgroundDrawable(null);
                        this.sobot_tv_content_detail.setVisibility(8);
                        this.sobot_tv_content_detail.setOnClickListener(null);
                        this.sobot_tv_content_detail_split.setVisibility(8);
                        this.sobot_tv_content.setPadding(0, 0, 0, 0);
                    }
                    HtmlTools htmlTools = HtmlTools.getInstance(SobotTicketDetailAdapter.this.context);
                    TextView textView = this.sobot_tv_content;
                    String replaceAll = reply.getReplyContent().replaceAll("<br/>", "").replaceAll("\n", "<br/>");
                    htmlTools.setRichText(textView, replaceAll.replaceAll("<img.*?/>", " " + ResourceUtils.getResString(SobotTicketDetailAdapter.this.context, "sobot_upload") + " "), SobotTicketDetailAdapter.this.getLinkTextColor());
                }
            } else {
                this.sobot_tv_content_ll.setBackgroundDrawable(null);
                this.sobot_tv_content_detail.setVisibility(8);
                this.sobot_tv_content_detail.setOnClickListener(null);
                this.sobot_tv_content_detail_split.setVisibility(8);
                this.sobot_tv_content.setPadding(0, 0, 0, 0);
                this.sobot_tv_status.setVisibility(0);
                this.sobot_tv_status.setText(ResourceUtils.getResString(SobotTicketDetailAdapter.this.context, "sobot_my_reply"));
                TextView textView2 = this.sobot_tv_content;
                if (TextUtils.isEmpty(reply.getReplyContent())) {
                    fromHtml = ResourceUtils.getResString(SobotTicketDetailAdapter.this.context, "sobot_nothing");
                } else {
                    String replyContent = reply.getReplyContent();
                    fromHtml = Html.fromHtml(replyContent.replaceAll("<img.*?/>", " " + ResourceUtils.getResString(SobotTicketDetailAdapter.this.context, "sobot_upload") + " "));
                }
                textView2.setText(fromHtml);
            }
            this.sobot_tv_time.setText(DateUtil.toDate(reply.getReplyTime() * 1000, DateUtil.DATE_FORMAT6));
            this.sobot_tv_secod.setText(DateUtil.toDate(reply.getReplyTime() * 1000, DateUtil.DATE_FORMAT3));
            this.recyclerView.setAdapter(new FileAttachmentAdapter(SobotTicketDetailAdapter.this.context, stUserDealTicketInfo.getFileList(), resColorValue, SobotTicketDetailAdapter.this.listener));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotTicketDetailAdapter$Type3ViewHolder.class */
    public class Type3ViewHolder extends BaseViewHolder {
        private RecyclerView recyclerView;
        private View sobot_line_split;
        private LinearLayout sobot_ll_root;
        private View sobot_top_line_view;
        private TextView sobot_tv_content;
        private TextView sobot_tv_content_detail;
        private View sobot_tv_content_detail_split;
        private LinearLayout sobot_tv_content_ll;
        private TextView sobot_tv_icon2;
        private TextView sobot_tv_secod;
        private TextView sobot_tv_status;
        private TextView sobot_tv_time;

        Type3ViewHolder(Context context, View view) {
            super(context, view);
            this.sobot_ll_root = (LinearLayout) view.findViewById(ResourceUtils.getResId(context, "sobot_ll_root"));
            this.sobot_tv_icon2 = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_icon2"));
            this.sobot_tv_status = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_status"));
            this.sobot_tv_time = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_time"));
            this.sobot_tv_secod = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_secod"));
            this.sobot_tv_content = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_content"));
            this.sobot_tv_content_ll = (LinearLayout) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_content_ll"));
            this.sobot_tv_content_detail_split = view.findViewById(ResourceUtils.getResId(context, "sobot_tv_content_detail_split"));
            TextView textView = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_content_detail"));
            this.sobot_tv_content_detail = textView;
            textView.setText(ResourceUtils.getResString(context, "sobot_see_detail"));
            this.sobot_line_split = view.findViewById(ResourceUtils.getResId(context, "sobot_top_line_view_slip"));
            this.sobot_top_line_view = view.findViewById(ResourceUtils.getResId(context, "sobot_top_line_view"));
            this.recyclerView = (RecyclerView) view.findViewById(ResourceUtils.getResId(context, "sobot_attachment_file_layout"));
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
            this.recyclerView.addItemDecoration(new SpaceItemDecoration(ScreenUtils.dip2px(this.mContext, 10.0f), ScreenUtils.dip2px(this.mContext, 10.0f), 0, 1));
            this.recyclerView.setLayoutManager(gridLayoutManager);
        }

        @Override // com.sobot.chat.adapter.SobotTicketDetailAdapter.BaseViewHolder
        void bindData(Object obj, int i) {
            int resColorValue;
            LinearLayout.LayoutParams layoutParams;
            SobotTicketDetailAdapter sobotTicketDetailAdapter = SobotTicketDetailAdapter.this;
            sobotTicketDetailAdapter.displayInNotch(sobotTicketDetailAdapter.mActivity, this.sobot_ll_root, ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 20.0f));
            if (i == 1) {
                layoutParams = new LinearLayout.LayoutParams(ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 19.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 19.0f));
                this.sobot_tv_time.setSelected(true);
                this.sobot_tv_secod.setSelected(true);
                this.sobot_tv_icon2.setSelected(true);
                this.sobot_tv_status.setSelected(true);
                this.sobot_tv_content.setSelected(true);
                this.sobot_line_split.setVisibility(0);
                resColorValue = ResourceUtils.getResColorValue(SobotTicketDetailAdapter.this.context, "sobot_common_gray1");
                this.sobot_top_line_view.setBackgroundColor(Color.parseColor("#00000000"));
                this.sobot_ll_root.setPadding(ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 20.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 30.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 20.0f), 0);
            } else {
                this.sobot_tv_time.setSelected(false);
                this.sobot_tv_secod.setSelected(false);
                this.sobot_tv_icon2.setSelected(false);
                this.sobot_tv_status.setSelected(false);
                this.sobot_tv_content.setSelected(false);
                this.sobot_line_split.setVisibility(8);
                resColorValue = ResourceUtils.getResColorValue(SobotTicketDetailAdapter.this.context, "sobot_common_text_gray");
                this.sobot_top_line_view.setBackgroundColor(ContextCompat.getColor(SobotTicketDetailAdapter.this.context, ResourceUtils.getResColorId(SobotTicketDetailAdapter.this.context, "sobot_ticket_deal_line_grey")));
                this.sobot_ll_root.setPadding(ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 20.0f), 0, ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 20.0f), 0);
                layoutParams = new LinearLayout.LayoutParams(ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 14.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 14.0f));
            }
            this.sobot_tv_icon2.setLayoutParams(layoutParams);
            final StUserDealTicketInfo stUserDealTicketInfo = (StUserDealTicketInfo) obj;
            this.sobot_tv_time.setText(DateUtil.stringToFormatString(stUserDealTicketInfo.getTimeStr(), "MM-dd", Boolean.valueOf(ZCSobotApi.getSwitchMarkStatus(8))));
            this.sobot_tv_secod.setText(DateUtil.stringToFormatString(stUserDealTicketInfo.getTimeStr(), "HH:mm", Boolean.valueOf(ZCSobotApi.getSwitchMarkStatus(8))));
            if (TextUtils.isEmpty(stUserDealTicketInfo.getContent())) {
                this.sobot_tv_content_ll.setBackgroundDrawable(null);
                this.sobot_tv_content_detail.setVisibility(8);
                this.sobot_tv_content_detail.setOnClickListener(null);
                this.sobot_tv_content_detail_split.setVisibility(8);
                this.sobot_tv_content.setPadding(0, 0, 0, 0);
            } else {
                if (StringUtils.getImgSrc(stUserDealTicketInfo.getContent()).size() > 0) {
                    this.sobot_tv_content_ll.setBackgroundDrawable(SobotTicketDetailAdapter.this.context.getResources().getDrawable(ResourceUtils.getDrawableId(SobotTicketDetailAdapter.this.context, "sobot_round_ticket")));
                    this.sobot_tv_content_detail.setVisibility(0);
                    this.sobot_tv_content_detail_split.setVisibility(0);
                    this.sobot_tv_content.setPadding(ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 15.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 11.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 15.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 11.0f));
                    this.sobot_tv_content_detail.setPadding(ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 15.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 11.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 15.0f), ScreenUtils.dip2px(SobotTicketDetailAdapter.this.context, 11.0f));
                    this.sobot_tv_content_detail.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.adapter.SobotTicketDetailAdapter.Type3ViewHolder.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            Intent intent = new Intent(SobotTicketDetailAdapter.this.context, WebViewActivity.class);
                            intent.putExtra("url", stUserDealTicketInfo.getContent());
                            SobotTicketDetailAdapter.this.context.startActivity(intent);
                        }
                    });
                } else {
                    this.sobot_tv_content_ll.setBackgroundDrawable(null);
                    this.sobot_tv_content_detail.setVisibility(8);
                    this.sobot_tv_content_detail.setOnClickListener(null);
                    this.sobot_tv_content_detail_split.setVisibility(8);
                    this.sobot_tv_content.setPadding(0, 0, 0, 0);
                }
                HtmlTools htmlTools = HtmlTools.getInstance(SobotTicketDetailAdapter.this.context);
                TextView textView = this.sobot_tv_content;
                String replaceAll = stUserDealTicketInfo.getContent().replaceAll("<br/>", "").replaceAll("\n", "<br/>");
                htmlTools.setRichText(textView, replaceAll.replaceAll("<img.*?/>", " " + ResourceUtils.getResString(SobotTicketDetailAdapter.this.context, "sobot_upload") + " "), SobotTicketDetailAdapter.this.getLinkTextColor());
            }
            this.recyclerView.setAdapter(new FileAttachmentAdapter(SobotTicketDetailAdapter.this.context, stUserDealTicketInfo.getFileList(), resColorValue, SobotTicketDetailAdapter.this.listener));
            if (stUserDealTicketInfo.getStartType() == 0) {
                this.sobot_tv_status.setText(ResourceUtils.getResString(SobotTicketDetailAdapter.this.context, "sobot_completed"));
            } else {
                this.sobot_tv_status.setText(ResourceUtils.getResString(SobotTicketDetailAdapter.this.context, "sobot_my_reply"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotTicketDetailAdapter$Type4ViewHolder.class */
    public class Type4ViewHolder extends BaseViewHolder {
        private LinearLayout sobot_ll_remark;
        private LinearLayout sobot_ll_score;
        private LinearLayout sobot_my_evaluate_ll;
        private TextView sobot_my_evaluate_tv;
        private RatingBar sobot_ratingBar;
        private TextView sobot_tv_my_evaluate_remark;
        private TextView sobot_tv_my_evaluate_score;
        private TextView sobot_tv_remark;

        Type4ViewHolder(Context context, View view) {
            super(context, view);
            this.sobot_ll_score = (LinearLayout) view.findViewById(ResourceUtils.getResId(context, "sobot_ll_score"));
            this.sobot_tv_remark = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_remark"));
            this.sobot_ll_remark = (LinearLayout) view.findViewById(ResourceUtils.getResId(context, "sobot_ll_remark"));
            this.sobot_ratingBar = (RatingBar) view.findViewById(ResourceUtils.getResId(context, "sobot_ratingBar"));
            TextView textView = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_my_evaluate_tv"));
            this.sobot_my_evaluate_tv = textView;
            textView.setText(ResourceUtils.getResString(context, "sobot_my_service_comment"));
            TextView textView2 = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_my_evaluate_score"));
            this.sobot_tv_my_evaluate_score = textView2;
            textView2.setText(ResourceUtils.getResString(context, "sobot_rating_score") + "：");
            TextView textView3 = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_my_evaluate_remark"));
            this.sobot_tv_my_evaluate_remark = textView3;
            textView3.setText(ResourceUtils.getResString(context, "sobot_rating_dec") + "：");
            this.sobot_my_evaluate_ll = (LinearLayout) view.findViewById(ResourceUtils.getResId(context, "sobot_my_evaluate_ll"));
        }

        @Override // com.sobot.chat.adapter.SobotTicketDetailAdapter.BaseViewHolder
        void bindData(Object obj, int i) {
            SobotTicketDetailAdapter sobotTicketDetailAdapter = SobotTicketDetailAdapter.this;
            sobotTicketDetailAdapter.displayInNotch(sobotTicketDetailAdapter.mActivity, this.sobot_my_evaluate_ll, 0);
            SobotUserTicketEvaluate sobotUserTicketEvaluate = (SobotUserTicketEvaluate) obj;
            if (!sobotUserTicketEvaluate.isOpen()) {
                this.sobot_my_evaluate_tv.setVisibility(8);
                this.sobot_my_evaluate_ll.setVisibility(8);
                this.sobot_ll_score.setVisibility(8);
                this.sobot_ll_remark.setVisibility(8);
            } else if (!sobotUserTicketEvaluate.isEvalution()) {
                this.sobot_my_evaluate_tv.setVisibility(8);
                this.sobot_my_evaluate_ll.setVisibility(8);
                this.sobot_ll_score.setVisibility(8);
                this.sobot_ll_remark.setVisibility(8);
            } else {
                this.sobot_ratingBar.setIsIndicator(true);
                this.sobot_my_evaluate_tv.setVisibility(0);
                this.sobot_my_evaluate_ll.setVisibility(0);
                List<SobotUserTicketEvaluate.TicketScoreInfooListBean> ticketScoreInfooList = sobotUserTicketEvaluate.getTicketScoreInfooList();
                if (ticketScoreInfooList == null || ticketScoreInfooList.size() < sobotUserTicketEvaluate.getScore()) {
                    this.sobot_ll_score.setVisibility(8);
                } else {
                    this.sobot_ll_score.setVisibility(0);
                    this.sobot_ratingBar.setRating(sobotUserTicketEvaluate.getScore());
                }
                if (TextUtils.isEmpty(sobotUserTicketEvaluate.getRemark())) {
                    this.sobot_ll_remark.setVisibility(8);
                    return;
                }
                this.sobot_ll_remark.setVisibility(0);
                this.sobot_tv_remark.setText(sobotUserTicketEvaluate.getRemark());
            }
        }
    }

    public SobotTicketDetailAdapter(Activity activity, Context context, List list) {
        this(activity, context, list, 2);
    }

    public SobotTicketDetailAdapter(Activity activity, Context context, List list, int i) {
        super(context, list);
        this.listener = new AttachmentView.Listener() { // from class: com.sobot.chat.adapter.SobotTicketDetailAdapter.1
            @Override // com.sobot.chat.widget.attachment.AttachmentView.Listener
            public void downFileLister(SobotFileModel sobotFileModel, int i2) {
                Intent intent = new Intent(SobotTicketDetailAdapter.this.mContext, SobotFileDetailActivity.class);
                SobotCacheFile sobotCacheFile = new SobotCacheFile();
                sobotCacheFile.setFileName(sobotFileModel.getFileName());
                sobotCacheFile.setUrl(sobotFileModel.getFileUrl());
                sobotCacheFile.setFileType(FileTypeConfig.getFileType(sobotFileModel.getFileType()));
                sobotCacheFile.setMsgId(sobotFileModel.getFileId());
                intent.putExtra(ZhiChiConstant.SOBOT_INTENT_DATA_SELECTED_FILE, sobotCacheFile);
                intent.setFlags(268435456);
                SobotTicketDetailAdapter.this.mContext.startActivity(intent);
            }

            @Override // com.sobot.chat.widget.attachment.AttachmentView.Listener
            public void previewMp4(SobotFileModel sobotFileModel, int i2) {
                SobotCacheFile sobotCacheFile = new SobotCacheFile();
                sobotCacheFile.setFileName(sobotFileModel.getFileName());
                sobotCacheFile.setUrl(sobotFileModel.getFileUrl());
                sobotCacheFile.setFileType(FileTypeConfig.getFileType(sobotFileModel.getFileType()));
                sobotCacheFile.setMsgId(sobotFileModel.getFileId());
                SobotTicketDetailAdapter.this.mContext.startActivity(SobotVideoActivity.newIntent(SobotTicketDetailAdapter.this.mContext, sobotCacheFile));
            }

            @Override // com.sobot.chat.widget.attachment.AttachmentView.Listener
            public void previewPic(String str, String str2, int i2) {
                if (SobotOption.imagePreviewListener == null || !SobotOption.imagePreviewListener.onPreviewImage(SobotTicketDetailAdapter.this.mContext, str)) {
                    Intent intent = new Intent(SobotTicketDetailAdapter.this.context, SobotPhotoActivity.class);
                    intent.putExtra("imageUrL", str);
                    SobotTicketDetailAdapter.this.context.startActivity(intent);
                }
            }
        };
        this.mContext = context;
        this.mActivity = activity;
        this.attachmentCount = i;
    }

    private View initView(View view, int i, int i2, Object obj) {
        View view2 = view;
        if (view == null) {
            view2 = LayoutInflater.from(this.context).inflate(ResourceUtils.getIdByName(this.context, "layout", layoutRes[i]), (ViewGroup) null);
            view2.setTag(i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? new HeadViewHolder(this.context, view2) : new Type4ViewHolder(this.context, view2) : new Type3ViewHolder(this.context, view2) : new Type2ViewHolder(this.context, view2) : new Type1ViewHolder(this.context, view2) : new HeadViewHolder(this.context, view2));
        }
        return view2;
    }

    public void displayInNotch(Activity activity, final View view, final int i) {
        if (SobotApi.getSwitchMarkStatus(1) && SobotApi.getSwitchMarkStatus(4) && view != null) {
            NotchScreenManager.getInstance().setDisplayInNotch(activity);
            activity.getWindow().setFlags(1024, 1024);
            NotchScreenManager.getInstance().getNotchInfo(activity, new INotchScreen.NotchScreenCallback() { // from class: com.sobot.chat.adapter.SobotTicketDetailAdapter.2
                @Override // com.sobot.chat.notchlib.INotchScreen.NotchScreenCallback
                public void onResult(INotchScreen.NotchScreenInfo notchScreenInfo) {
                    if (notchScreenInfo.hasNotch) {
                        for (Rect rect : notchScreenInfo.notchRects) {
                            View view2 = view;
                            int i2 = 110;
                            int i3 = rect.right > 110 ? 110 : rect.right;
                            int i4 = i;
                            int paddingTop = view.getPaddingTop();
                            if (rect.right <= 110) {
                                i2 = rect.right;
                            }
                            view2.setPadding(i3 + i4, paddingTop, i2 + view.getPaddingRight(), view.getPaddingBottom());
                        }
                    }
                }
            });
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object obj = this.list.get(i);
        if (obj instanceof SobotUserTicketInfo) {
            return 0;
        }
        if (!(obj instanceof StUserDealTicketInfo)) {
            return obj instanceof SobotUserTicketEvaluate ? 4 : 0;
        }
        StUserDealTicketInfo stUserDealTicketInfo = (StUserDealTicketInfo) obj;
        if (stUserDealTicketInfo.getFlag() == 1) {
            return 1;
        }
        if (stUserDealTicketInfo.getFlag() == 2) {
            return 2;
        }
        return stUserDealTicketInfo.getFlag() == 3 ? 3 : 0;
    }

    protected int getLinkTextColor() {
        return -1 != SobotUIConfig.sobot_chat_left_link_textColor ? SobotUIConfig.sobot_chat_left_link_textColor : ResourceUtils.getIdByName(this.mContext, "color", "sobot_color_link");
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Object obj = this.list.get(i);
        View view2 = view;
        if (obj != null) {
            view2 = initView(view, getItemViewType(i), i, obj);
            ((BaseViewHolder) view2.getTag()).bindData(obj, i);
        }
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        String[] strArr = layoutRes;
        return strArr.length > 0 ? strArr.length : super.getViewTypeCount();
    }
}
