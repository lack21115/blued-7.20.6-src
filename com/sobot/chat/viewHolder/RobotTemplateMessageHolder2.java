package com.sobot.chat.viewHolder;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.BatteryManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.chat.data.MsgType;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.activity.WebViewActivity;
import com.sobot.chat.api.apiUtils.GsonUtil;
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
import com.sobot.chat.widget.horizontalgridpage.PagerGridLayoutManager;
import com.sobot.chat.widget.lablesview.SobotLablesViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/RobotTemplateMessageHolder2.class */
public class RobotTemplateMessageHolder2 extends MessageHolderBase {
    private static final int PAGE_SIZE = 30;
    private PageGridAdapter adapter;
    private LinearLayout ll_sobot_template2_item_page;
    private Context mContext;
    public ZhiChiMessageBase message;
    private PageBuilder pageBuilder;
    private HorizontalGridPage pageView;
    private LinearLayout sobot_ll_transferBtn;
    private TextView sobot_template2_item_last_page;
    private TextView sobot_template2_item_previous_page;
    private TextView sobot_tv_transferBtn;
    private TextView tv_msg;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/RobotTemplateMessageHolder2$Template2ViewHolder.class */
    class Template2ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout sobotTemplateItemLL;
        TextView sobotTitle;

        public Template2ViewHolder(View view, Context context) {
            super(view);
            this.sobotTemplateItemLL = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template_item_ll"));
            this.sobotTitle = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template_item_title"));
        }
    }

    public RobotTemplateMessageHolder2(Context context, View view) {
        super(context, view);
        this.tv_msg = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template2_msg"));
        this.pageView = (HorizontalGridPage) view.findViewById(ResourceUtils.getIdByName(context, "id", "pageView"));
        this.sobot_ll_transferBtn = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ll_transferBtn"));
        TextView textView = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_transferBtn"));
        this.sobot_tv_transferBtn = textView;
        textView.setText(ResourceUtils.getResString(context, "sobot_transfer_to_customer_service"));
        this.sobot_template2_item_previous_page = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template2_item_previous_page"));
        this.sobot_template2_item_last_page = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template2_item_last_page"));
        this.ll_sobot_template2_item_page = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "ll_sobot_template2_item_page"));
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

    private int getDisplayNum(SobotMultiDiaRespInfo sobotMultiDiaRespInfo, int i) {
        if (sobotMultiDiaRespInfo == null) {
            return 0;
        }
        return Math.min(sobotMultiDiaRespInfo.getPageNum() * 30, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMultiRoundQuestions(SobotLablesViewModel sobotLablesViewModel, SobotMultiDiaRespInfo sobotMultiDiaRespInfo, int i) {
        if (sobotMultiDiaRespInfo == null) {
            return;
        }
        String title = sobotLablesViewModel.getTitle();
        String[] outPutParamList = sobotMultiDiaRespInfo.getOutPutParamList();
        if (this.msgCallBack == null || this.message == null) {
            return;
        }
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        HashMap hashMap = new HashMap();
        hashMap.put(BatteryManager.EXTRA_LEVEL, sobotMultiDiaRespInfo.getLevel() + "");
        hashMap.put("conversationId", sobotMultiDiaRespInfo.getConversationId());
        if (outPutParamList != null) {
            if (outPutParamList.length == 1) {
                hashMap.put(outPutParamList[0], sobotLablesViewModel.getTitle());
            } else if (sobotMultiDiaRespInfo.getInterfaceRetList() != null && sobotMultiDiaRespInfo.getInterfaceRetList().size() > 0) {
                for (String str : outPutParamList) {
                    hashMap.put(str, sobotMultiDiaRespInfo.getInterfaceRetList().get(i).get(str));
                }
            }
        }
        zhiChiMessageBase.setContent(GsonUtil.map2Str(hashMap));
        zhiChiMessageBase.setId(System.currentTimeMillis() + "");
        this.msgCallBack.sendMessageToRobot(zhiChiMessageBase, 4, 2, title, title);
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(final Context context, ZhiChiMessageBase zhiChiMessageBase) {
        this.message = zhiChiMessageBase;
        if (zhiChiMessageBase.getAnswer() != null && zhiChiMessageBase.getAnswer().getMultiDiaRespInfo() != null) {
            SobotMultiDiaRespInfo multiDiaRespInfo = zhiChiMessageBase.getAnswer().getMultiDiaRespInfo();
            String multiMsgTitle = ChatUtils.getMultiMsgTitle(multiDiaRespInfo);
            if (TextUtils.isEmpty(multiMsgTitle)) {
                this.sobot_ll_content.setVisibility(4);
            } else {
                applyTextViewUIConfig(this.tv_msg);
                HtmlTools.getInstance(context).setRichText(this.tv_msg, multiMsgTitle, getLinkTextColor());
                this.sobot_ll_content.setVisibility(0);
            }
            checkShowTransferBtn();
            if (MsgType.UID_GROUP_AT_ALL.equals(multiDiaRespInfo.getRetCode())) {
                List<Map<String, String>> interfaceRetList = multiDiaRespInfo.getInterfaceRetList();
                String[] inputContentList = multiDiaRespInfo.getInputContentList();
                ArrayList arrayList = new ArrayList();
                if (interfaceRetList != null && interfaceRetList.size() > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= getDisplayNum(multiDiaRespInfo, interfaceRetList.size())) {
                            break;
                        }
                        Map<String, String> map = interfaceRetList.get(i2);
                        SobotLablesViewModel sobotLablesViewModel = new SobotLablesViewModel();
                        sobotLablesViewModel.setTitle(map.get("title"));
                        sobotLablesViewModel.setAnchor(map.get("anchor"));
                        arrayList.add(sobotLablesViewModel);
                        i = i2 + 1;
                    }
                    if (arrayList.size() >= 10) {
                        initView(10, 1, "0");
                        this.ll_sobot_template2_item_page.setVisibility(0);
                    } else {
                        initView(arrayList.size(), (int) Math.ceil(arrayList.size() / 10.0f), "0");
                        this.ll_sobot_template2_item_page.setVisibility(8);
                    }
                    this.adapter.setData(arrayList);
                    this.adapter.setZhiChiMessageBaseData(zhiChiMessageBase);
                } else if (inputContentList == null || inputContentList.length <= 0) {
                    this.pageView.setVisibility(8);
                } else {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= getDisplayNum(multiDiaRespInfo, inputContentList.length)) {
                            break;
                        }
                        SobotLablesViewModel sobotLablesViewModel2 = new SobotLablesViewModel();
                        sobotLablesViewModel2.setTitle(inputContentList[i4]);
                        arrayList.add(sobotLablesViewModel2);
                        i3 = i4 + 1;
                    }
                    if (arrayList.size() >= 10) {
                        initView(10, 1, multiDiaRespInfo.getTemplate());
                        this.ll_sobot_template2_item_page.setVisibility(0);
                    } else {
                        initView(arrayList.size(), (int) Math.ceil(arrayList.size() / 10.0f), multiDiaRespInfo.getTemplate());
                        this.ll_sobot_template2_item_page.setVisibility(8);
                    }
                    this.adapter.setData(arrayList);
                    this.adapter.setZhiChiMessageBaseData(zhiChiMessageBase);
                }
            } else {
                this.pageView.setVisibility(8);
            }
        }
        this.pageView.setPageListener(new PagerGridLayoutManager.PageListener() { // from class: com.sobot.chat.viewHolder.RobotTemplateMessageHolder2.2
            @Override // com.sobot.chat.widget.horizontalgridpage.PagerGridLayoutManager.PageListener
            public void onPageSelect(int i5) {
                if (RobotTemplateMessageHolder2.this.pageView.isFirstPage()) {
                    TextView textView = RobotTemplateMessageHolder2.this.sobot_template2_item_previous_page;
                    Context context2 = context;
                    textView.setTextColor(ContextCompat.getColor(context2, ResourceUtils.getResColorId(context2, "sobot_common_gray3")));
                    Drawable drawable = RobotTemplateMessageHolder2.this.mContext.getResources().getDrawable(ResourceUtils.getDrawableId(RobotTemplateMessageHolder2.this.mContext, "sobot_no_pre_page"));
                    if (drawable != null) {
                        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                        RobotTemplateMessageHolder2.this.sobot_template2_item_previous_page.setCompoundDrawables(null, null, drawable, null);
                    }
                } else {
                    TextView textView2 = RobotTemplateMessageHolder2.this.sobot_template2_item_previous_page;
                    Context context3 = context;
                    textView2.setTextColor(ContextCompat.getColor(context3, ResourceUtils.getResColorId(context3, "sobot_common_gray2")));
                    Drawable drawable2 = RobotTemplateMessageHolder2.this.mContext.getResources().getDrawable(ResourceUtils.getDrawableId(RobotTemplateMessageHolder2.this.mContext, "sobot_pre_page"));
                    if (drawable2 != null) {
                        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                        RobotTemplateMessageHolder2.this.sobot_template2_item_previous_page.setCompoundDrawables(null, null, drawable2, null);
                    }
                }
                if (RobotTemplateMessageHolder2.this.pageView.isLastPage()) {
                    TextView textView3 = RobotTemplateMessageHolder2.this.sobot_template2_item_last_page;
                    Context context4 = context;
                    textView3.setTextColor(ContextCompat.getColor(context4, ResourceUtils.getResColorId(context4, "sobot_common_gray3")));
                    Drawable drawable3 = RobotTemplateMessageHolder2.this.mContext.getResources().getDrawable(ResourceUtils.getDrawableId(RobotTemplateMessageHolder2.this.mContext, "sobot_no_last_page"));
                    if (drawable3 != null) {
                        drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                        RobotTemplateMessageHolder2.this.sobot_template2_item_last_page.setCompoundDrawables(null, null, drawable3, null);
                        return;
                    }
                    return;
                }
                TextView textView4 = RobotTemplateMessageHolder2.this.sobot_template2_item_last_page;
                Context context5 = context;
                textView4.setTextColor(ContextCompat.getColor(context5, ResourceUtils.getResColorId(context5, "sobot_common_gray2")));
                Drawable drawable4 = RobotTemplateMessageHolder2.this.mContext.getResources().getDrawable(ResourceUtils.getDrawableId(RobotTemplateMessageHolder2.this.mContext, "sobot_last_page"));
                if (drawable4 != null) {
                    drawable4.setBounds(0, 0, drawable4.getMinimumWidth(), drawable4.getMinimumHeight());
                    RobotTemplateMessageHolder2.this.sobot_template2_item_last_page.setCompoundDrawables(null, null, drawable4, null);
                }
            }

            @Override // com.sobot.chat.widget.horizontalgridpage.PagerGridLayoutManager.PageListener
            public void onPageSizeChanged(int i5) {
            }
        });
        this.sobot_template2_item_previous_page.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.viewHolder.RobotTemplateMessageHolder2.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                RobotTemplateMessageHolder2.this.pageView.selectPreviousPage();
                RobotTemplateMessageHolder2.this.updatePreBtn(context);
            }
        });
        this.sobot_template2_item_last_page.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.viewHolder.RobotTemplateMessageHolder2.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                RobotTemplateMessageHolder2.this.pageView.selectLastPage();
                RobotTemplateMessageHolder2.this.updateLastBtn(context);
            }
        });
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

    public void initView(int i, int i2, final String str) {
        Context context;
        float f;
        if (this.pageBuilder != null) {
            return;
        }
        PageBuilder.Builder space = new PageBuilder.Builder().setGrid(i, i2).setPageMargin(10).setIndicatorMargins(5, 10, 5, 10).setIndicatorSize(10).setIndicatorRes(17301609, 17301611).setIndicatorGravity(17).setSwipePercent(40).setShowIndicator(false).setSpace(2);
        if ("0".equals(str)) {
            context = this.mContext;
            f = 42.0f;
        } else {
            context = this.mContext;
            f = 36.0f;
        }
        this.pageBuilder = space.setItemHeight(ScreenUtils.dip2px(context, f)).build();
        this.adapter = new PageGridAdapter(new PageCallBack() { // from class: com.sobot.chat.viewHolder.RobotTemplateMessageHolder2.1
            @Override // com.sobot.chat.widget.horizontalgridpage.PageCallBack
            public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
                SobotLablesViewModel sobotLablesViewModel = (SobotLablesViewModel) RobotTemplateMessageHolder2.this.adapter.getData().get(i3);
                Template2ViewHolder template2ViewHolder = (Template2ViewHolder) viewHolder;
                template2ViewHolder.sobotTitle.setText(sobotLablesViewModel.getTitle());
                RobotTemplateMessageHolder2.this.adapter.getZhiChiMessageBaseData().getAnswer().getMultiDiaRespInfo();
                if ("1".equals(str)) {
                    template2ViewHolder.sobotTemplateItemLL.setBackground(null);
                    TextView textView = template2ViewHolder.sobotTitle;
                    textView.setText((i3 + 1) + "、 " + sobotLablesViewModel.getTitle());
                    template2ViewHolder.sobotTitle.setGravity(19);
                    template2ViewHolder.sobotTitle.setMaxLines(2);
                    template2ViewHolder.sobotTitle.setPadding(0, 0, 0, 0);
                    if (RobotTemplateMessageHolder2.this.adapter.getZhiChiMessageBaseData().getSugguestionsFontColor() == 0) {
                        template2ViewHolder.sobotTitle.setTextColor(ContextCompat.getColor(RobotTemplateMessageHolder2.this.mContext, ResourceUtils.getResColorId(RobotTemplateMessageHolder2.this.mContext, "sobot_color_link")));
                    } else {
                        template2ViewHolder.sobotTitle.setTextColor(ContextCompat.getColor(RobotTemplateMessageHolder2.this.mContext, ResourceUtils.getResColorId(RobotTemplateMessageHolder2.this.mContext, "sobot_common_gray1")));
                    }
                }
            }

            @Override // com.sobot.chat.widget.horizontalgridpage.PageCallBack
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
                return new Template2ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(ResourceUtils.getResLayoutId(viewGroup.getContext(), "sobot_chat_msg_item_template2_item_l"), viewGroup, false), viewGroup.getContext());
            }

            @Override // com.sobot.chat.widget.horizontalgridpage.PageCallBack
            public void onItemClickListener(View view, int i3) {
                if (RobotTemplateMessageHolder2.this.message == null || RobotTemplateMessageHolder2.this.message.getAnswer() == null) {
                    return;
                }
                String stringData = SharedPreferencesUtil.getStringData(RobotTemplateMessageHolder2.this.mContext, "lastCid", "");
                if (RobotTemplateMessageHolder2.this.adapter.getZhiChiMessageBaseData().getSugguestionsFontColor() == 0 && !TextUtils.isEmpty(RobotTemplateMessageHolder2.this.adapter.getZhiChiMessageBaseData().getCid()) && stringData.equals(RobotTemplateMessageHolder2.this.adapter.getZhiChiMessageBaseData().getCid())) {
                    if (RobotTemplateMessageHolder2.this.adapter.getZhiChiMessageBaseData().getAnswer().getMultiDiaRespInfo().getClickFlag() != 0 || RobotTemplateMessageHolder2.this.adapter.getZhiChiMessageBaseData().getClickCount() <= 0) {
                        RobotTemplateMessageHolder2.this.adapter.getZhiChiMessageBaseData().addClickCount();
                        SobotMultiDiaRespInfo multiDiaRespInfo = RobotTemplateMessageHolder2.this.message.getAnswer().getMultiDiaRespInfo();
                        SobotLablesViewModel sobotLablesViewModel = (SobotLablesViewModel) RobotTemplateMessageHolder2.this.adapter.getData().get(i3);
                        if (multiDiaRespInfo == null || !multiDiaRespInfo.getEndFlag() || TextUtils.isEmpty(sobotLablesViewModel.getAnchor())) {
                            RobotTemplateMessageHolder2.this.sendMultiRoundQuestions(sobotLablesViewModel, multiDiaRespInfo, i3);
                        } else if (SobotOption.newHyperlinkListener == null || !SobotOption.newHyperlinkListener.onUrlClick(RobotTemplateMessageHolder2.this.mContext, sobotLablesViewModel.getAnchor())) {
                            Intent intent = new Intent(RobotTemplateMessageHolder2.this.mContext, WebViewActivity.class);
                            intent.putExtra("url", sobotLablesViewModel.getAnchor());
                            RobotTemplateMessageHolder2.this.mContext.startActivity(intent);
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
        this.sobot_tv_likeBtn.setOnClickListener(new NoDoubleClickListener() { // from class: com.sobot.chat.viewHolder.RobotTemplateMessageHolder2.6
            @Override // com.sobot.chat.listener.NoDoubleClickListener
            public void onNoDoubleClick(View view) {
                RobotTemplateMessageHolder2.this.doRevaluate(true);
            }
        });
        this.sobot_tv_dislikeBtn.setOnClickListener(new NoDoubleClickListener() { // from class: com.sobot.chat.viewHolder.RobotTemplateMessageHolder2.7
            @Override // com.sobot.chat.listener.NoDoubleClickListener
            public void onNoDoubleClick(View view) {
                RobotTemplateMessageHolder2.this.doRevaluate(false);
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
        this.sobot_ll_transferBtn.setOnClickListener(new NoDoubleClickListener() { // from class: com.sobot.chat.viewHolder.RobotTemplateMessageHolder2.5
            @Override // com.sobot.chat.listener.NoDoubleClickListener
            public void onNoDoubleClick(View view) {
                if (RobotTemplateMessageHolder2.this.msgCallBack != null) {
                    RobotTemplateMessageHolder2.this.msgCallBack.doClickTransferBtn(RobotTemplateMessageHolder2.this.message);
                }
            }
        });
    }

    public void updateLastBtn(Context context) {
        this.sobot_template2_item_previous_page.setTextColor(ContextCompat.getColor(context, ResourceUtils.getResColorId(context, "sobot_common_gray2")));
        Drawable drawable = this.mContext.getResources().getDrawable(ResourceUtils.getDrawableId(this.mContext, "sobot_pre_page"));
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.sobot_template2_item_previous_page.setCompoundDrawables(null, null, drawable, null);
        this.sobot_template2_item_last_page.setTextColor(ContextCompat.getColor(context, ResourceUtils.getResColorId(context, "sobot_common_gray2")));
        Drawable drawable2 = this.mContext.getResources().getDrawable(ResourceUtils.getDrawableId(this.mContext, "sobot_last_page"));
        if (this.pageView.isLastPage()) {
            this.sobot_template2_item_last_page.setTextColor(ContextCompat.getColor(context, ResourceUtils.getResColorId(context, "sobot_common_gray3")));
            drawable2 = this.mContext.getResources().getDrawable(ResourceUtils.getDrawableId(this.mContext, "sobot_no_last_page"));
        }
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.sobot_template2_item_last_page.setCompoundDrawables(null, null, drawable2, null);
        }
    }

    public void updatePreBtn(Context context) {
        this.sobot_template2_item_last_page.setTextColor(ContextCompat.getColor(context, ResourceUtils.getResColorId(context, "sobot_common_gray2")));
        Drawable drawable = this.mContext.getResources().getDrawable(ResourceUtils.getDrawableId(this.mContext, "sobot_last_page"));
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.sobot_template2_item_last_page.setCompoundDrawables(null, null, drawable, null);
        Drawable drawable2 = this.mContext.getResources().getDrawable(ResourceUtils.getDrawableId(this.mContext, "sobot_pre_page"));
        this.sobot_template2_item_previous_page.setTextColor(ContextCompat.getColor(context, ResourceUtils.getResColorId(context, "sobot_common_gray2")));
        if (this.pageView.isFirstPage()) {
            this.sobot_template2_item_previous_page.setTextColor(ContextCompat.getColor(context, ResourceUtils.getResColorId(context, "sobot_common_gray3")));
            drawable2 = this.mContext.getResources().getDrawable(ResourceUtils.getDrawableId(this.mContext, "sobot_no_pre_page"));
        }
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.sobot_template2_item_previous_page.setCompoundDrawables(null, null, drawable2, null);
        }
    }
}
