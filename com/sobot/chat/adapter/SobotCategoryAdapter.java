package com.sobot.chat.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sobot.chat.SobotApi;
import com.sobot.chat.adapter.base.SobotBaseAdapter;
import com.sobot.chat.api.model.StDocModel;
import com.sobot.chat.notchlib.INotchScreen;
import com.sobot.chat.notchlib.NotchScreenManager;
import com.sobot.chat.utils.ResourceUtils;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotCategoryAdapter.class */
public class SobotCategoryAdapter extends SobotBaseAdapter<StDocModel> {
    private Activity mActivity;
    private LayoutInflater mInflater;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotCategoryAdapter$ViewHolder.class */
    static class ViewHolder {
        private Activity mActivity;
        private TextView sobot_tv_title;

        public ViewHolder(Context context, Activity activity, View view) {
            this.mActivity = activity;
            this.sobot_tv_title = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_title"));
        }

        public void bindData(int i, StDocModel stDocModel) {
            this.sobot_tv_title.setText(stDocModel.getQuestionTitle());
            displayInNotch(this.sobot_tv_title);
        }

        public void displayInNotch(final View view) {
            if (SobotApi.getSwitchMarkStatus(1) && SobotApi.getSwitchMarkStatus(4) && view != null) {
                NotchScreenManager.getInstance().setDisplayInNotch(this.mActivity);
                this.mActivity.getWindow().setFlags(1024, 1024);
                NotchScreenManager.getInstance().getNotchInfo(this.mActivity, new INotchScreen.NotchScreenCallback() { // from class: com.sobot.chat.adapter.SobotCategoryAdapter.ViewHolder.1
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

    public SobotCategoryAdapter(Context context, Activity activity, List<StDocModel> list) {
        super(context, list);
        this.mActivity = activity;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.mInflater.inflate(ResourceUtils.getResLayoutId(this.context, "sobot_list_item_help_category"), (ViewGroup) null);
            viewHolder = new ViewHolder(this.context, this.mActivity, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.bindData(i, (StDocModel) this.list.get(i));
        return view;
    }
}
