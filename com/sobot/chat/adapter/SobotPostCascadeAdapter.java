package com.sobot.chat.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.expressad.foundation.h.i;
import com.sobot.chat.SobotApi;
import com.sobot.chat.adapter.base.SobotBaseAdapter;
import com.sobot.chat.api.model.SobotCusFieldDataInfo;
import com.sobot.chat.notchlib.INotchScreen;
import com.sobot.chat.notchlib.NotchScreenManager;
import com.sobot.chat.utils.ResourceUtils;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotPostCascadeAdapter.class */
public class SobotPostCascadeAdapter extends SobotBaseAdapter<SobotCusFieldDataInfo> {
    private Activity mActivity;
    private Context mContext;
    private ViewHolder myViewHolder;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotPostCascadeAdapter$ViewHolder.class */
    static class ViewHolder {
        private ImageView categoryIshave;
        private TextView categoryTitle;
        private Activity mActivity;
        private View work_order_category_line;

        ViewHolder(Activity activity, Context context, View view) {
            this.mActivity = activity;
            this.categoryTitle = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_category_title"));
            this.categoryIshave = (ImageView) view.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_category_ishave"));
            this.work_order_category_line = view.findViewById(ResourceUtils.getIdByName(context, "id", "work_order_category_line"));
            displayInNotch(this.categoryTitle);
        }

        public void displayInNotch(final View view) {
            if (SobotApi.getSwitchMarkStatus(1) && SobotApi.getSwitchMarkStatus(4) && view != null) {
                NotchScreenManager.getInstance().setDisplayInNotch(this.mActivity);
                this.mActivity.getWindow().setFlags(1024, 1024);
                NotchScreenManager.getInstance().getNotchInfo(this.mActivity, new INotchScreen.NotchScreenCallback() { // from class: com.sobot.chat.adapter.SobotPostCascadeAdapter.ViewHolder.1
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

    public SobotPostCascadeAdapter(Activity activity, Context context, List list) {
        super(context, list);
        this.mContext = context;
        this.mActivity = activity;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            Context context = this.mContext;
            view = View.inflate(context, ResourceUtils.getIdByName(context, "layout", "sobot_activity_post_category_items"), null);
            ViewHolder viewHolder = new ViewHolder(this.mActivity, this.mContext, view);
            this.myViewHolder = viewHolder;
            view.setTag(viewHolder);
        } else {
            this.myViewHolder = (ViewHolder) view.getTag();
        }
        this.myViewHolder.categoryTitle.setText(((SobotCusFieldDataInfo) this.list.get(i)).getDataName());
        if (((SobotCusFieldDataInfo) this.list.get(i)).isHasNext()) {
            this.myViewHolder.categoryIshave.setVisibility(0);
            this.myViewHolder.categoryIshave.setBackgroundResource(ResourceUtils.getIdByName(this.mContext, i.f7952c, "sobot_right_arrow_icon"));
        } else {
            this.myViewHolder.categoryIshave.setVisibility(8);
        }
        if (this.list.size() < 2) {
            this.myViewHolder.work_order_category_line.setVisibility(8);
            return view;
        } else if (i == this.list.size() - 1) {
            this.myViewHolder.work_order_category_line.setVisibility(8);
            return view;
        } else {
            this.myViewHolder.work_order_category_line.setVisibility(0);
            return view;
        }
    }
}
