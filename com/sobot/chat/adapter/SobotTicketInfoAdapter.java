package com.sobot.chat.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sobot.chat.SobotApi;
import com.sobot.chat.ZCSobotApi;
import com.sobot.chat.adapter.base.SobotBaseAdapter;
import com.sobot.chat.api.model.SobotUserTicketInfo;
import com.sobot.chat.notchlib.INotchScreen;
import com.sobot.chat.notchlib.NotchScreenManager;
import com.sobot.chat.utils.DateUtil;
import com.sobot.chat.utils.ResourceUtils;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotTicketInfoAdapter.class */
public class SobotTicketInfoAdapter extends SobotBaseAdapter<SobotUserTicketInfo> {
    public static final int MSG_TYPE_FILE = 0;
    private static final String[] layoutRes = {"sobot_ticket_info_item"};
    private Activity activity;
    private Context mContext;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotTicketInfoAdapter$BaseViewHolder.class */
    static abstract class BaseViewHolder {
        Context mContext;

        BaseViewHolder(Context context, View view) {
            this.mContext = context;
        }

        abstract void bindData(SobotUserTicketInfo sobotUserTicketInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotTicketInfoAdapter$TicketInfoViewHolder.class */
    public class TicketInfoViewHolder extends BaseViewHolder {
        private int bg1_resId;
        private int bg2_resId;
        private int bg3_resId;
        private Activity mActivity;
        private Context mContext;
        private ImageView sobot_tv_new;
        private String str1_resId;
        private String str2_resId;
        private String str3_resId;
        private TextView tv_code;
        private TextView tv_content;
        private TextView tv_ticket_status;
        private TextView tv_time;
        private TextView tv_title;

        TicketInfoViewHolder(Activity activity, Context context, View view) {
            super(context, view);
            this.mContext = context;
            this.mActivity = activity;
            this.tv_title = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_title"));
            this.tv_ticket_status = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_ticket_status"));
            this.tv_content = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_content"));
            this.tv_code = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_code"));
            this.tv_time = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_time"));
            this.sobot_tv_new = (ImageView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_new"));
            this.bg1_resId = ResourceUtils.getDrawableId(context, "sobot_ticket_status_bg3");
            this.bg2_resId = ResourceUtils.getDrawableId(context, "sobot_ticket_status_bg2");
            this.bg3_resId = ResourceUtils.getDrawableId(context, "sobot_ticket_status_bg1");
            this.str1_resId = ResourceUtils.getResString(context, "sobot_created_1");
            this.str2_resId = ResourceUtils.getResString(context, "sobot_processing");
            this.str3_resId = ResourceUtils.getResString(context, "sobot_completed");
        }

        @Override // com.sobot.chat.adapter.SobotTicketInfoAdapter.BaseViewHolder
        void bindData(SobotUserTicketInfo sobotUserTicketInfo) {
            this.tv_content.setText(TextUtils.isEmpty(sobotUserTicketInfo.getContent()) ? "" : Html.fromHtml(sobotUserTicketInfo.getContent()));
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
            this.sobot_tv_new.setVisibility(sobotUserTicketInfo.isNewFlag() ? 0 : 8);
            this.tv_time.setText(DateUtil.stringToFormatString(sobotUserTicketInfo.getTimeStr(), DateUtil.DATE_TIME_FORMAT, Boolean.valueOf(ZCSobotApi.getSwitchMarkStatus(8))));
            displayInNotch(this.tv_time);
            displayInNotch(this.tv_content);
        }

        public void displayInNotch(final View view) {
            if (SobotApi.getSwitchMarkStatus(1) && SobotApi.getSwitchMarkStatus(4) && view != null) {
                NotchScreenManager.getInstance().setDisplayInNotch(this.mActivity);
                this.mActivity.getWindow().setFlags(1024, 1024);
                NotchScreenManager.getInstance().getNotchInfo(this.mActivity, new INotchScreen.NotchScreenCallback() { // from class: com.sobot.chat.adapter.SobotTicketInfoAdapter.TicketInfoViewHolder.1
                    @Override // com.sobot.chat.notchlib.INotchScreen.NotchScreenCallback
                    public void onResult(INotchScreen.NotchScreenInfo notchScreenInfo) {
                        if (notchScreenInfo.hasNotch) {
                            for (Rect rect : notchScreenInfo.notchRects) {
                                View view2 = view;
                                int i = 110;
                                if (rect.right <= 110) {
                                    i = rect.right;
                                }
                                view2.setPadding(i, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
                            }
                        }
                    }
                });
            }
        }
    }

    public SobotTicketInfoAdapter(Activity activity, Context context, List list) {
        super(context, list);
        this.mContext = context;
        this.activity = activity;
    }

    private View initView(View view, int i, int i2, SobotUserTicketInfo sobotUserTicketInfo) {
        View view2 = view;
        if (view == null) {
            view2 = LayoutInflater.from(this.context).inflate(ResourceUtils.getIdByName(this.context, "layout", layoutRes[i]), (ViewGroup) null);
            view2.setTag(i != 0 ? new TicketInfoViewHolder(this.activity, this.context, view2) : new TicketInfoViewHolder(this.activity, this.context, view2));
        }
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        SobotUserTicketInfo sobotUserTicketInfo = (SobotUserTicketInfo) this.list.get(i);
        View view2 = view;
        if (sobotUserTicketInfo != null) {
            view2 = initView(view, getItemViewType(i), i, sobotUserTicketInfo);
            ((BaseViewHolder) view2.getTag()).bindData(sobotUserTicketInfo);
        }
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        String[] strArr = layoutRes;
        return strArr.length > 0 ? strArr.length : super.getViewTypeCount();
    }
}
