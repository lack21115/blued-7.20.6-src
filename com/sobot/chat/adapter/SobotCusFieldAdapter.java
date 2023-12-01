package com.sobot.chat.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.expressad.foundation.h.i;
import com.sobot.chat.SobotApi;
import com.sobot.chat.adapter.base.SobotBaseAdapter;
import com.sobot.chat.api.model.SobotCusFieldDataInfo;
import com.sobot.chat.notchlib.INotchScreen;
import com.sobot.chat.notchlib.NotchScreenManager;
import com.sobot.chat.utils.ResourceUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotCusFieldAdapter.class */
public class SobotCusFieldAdapter extends SobotBaseAdapter<SobotCusFieldDataInfo> implements Filterable {
    private List<SobotCusFieldDataInfo> adminList;
    private List<SobotCusFieldDataInfo> displayList;
    private int fieldType;
    private Activity mActivity;
    private Context mContext;
    private MyFilter mFilter;
    private MyViewHolder myViewHolder;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotCusFieldAdapter$MyFilter.class */
    public class MyFilter extends Filter {
        public MyFilter() {
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null || charSequence.length() == 0) {
                filterResults.values = SobotCusFieldAdapter.this.adminList;
                filterResults.count = SobotCusFieldAdapter.this.adminList.size();
                return filterResults;
            }
            String charSequence2 = charSequence.toString();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= SobotCusFieldAdapter.this.adminList.size()) {
                    filterResults.values = arrayList;
                    filterResults.count = arrayList.size();
                    return filterResults;
                }
                if (((SobotCusFieldDataInfo) SobotCusFieldAdapter.this.adminList.get(i2)).getDataName().contains(charSequence2)) {
                    arrayList.add(SobotCusFieldAdapter.this.adminList.get(i2));
                }
                i = i2 + 1;
            }
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            SobotCusFieldAdapter.this.displayList = (List) filterResults.values;
            if (SobotCusFieldAdapter.this.displayList.size() > 0) {
                SobotCusFieldAdapter.this.notifyDataSetChanged();
            } else {
                SobotCusFieldAdapter.this.notifyDataSetInvalidated();
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotCusFieldAdapter$MyViewHolder.class */
    class MyViewHolder {
        private ImageView categorySmallCheckBox;
        private ImageView categorySmallIshave;
        private TextView categorySmallTitle;
        private View categorySmallline;
        private Activity mActivity;

        MyViewHolder(Activity activity, View view) {
            this.mActivity = activity;
            this.categorySmallTitle = (TextView) view.findViewById(ResourceUtils.getIdByName(SobotCusFieldAdapter.this.context, "id", "sobot_activity_cusfield_listview_items_title"));
            this.categorySmallIshave = (ImageView) view.findViewById(ResourceUtils.getIdByName(SobotCusFieldAdapter.this.context, "id", "sobot_activity_cusfield_listview_items_ishave"));
            this.categorySmallCheckBox = (ImageView) view.findViewById(ResourceUtils.getIdByName(SobotCusFieldAdapter.this.context, "id", "sobot_activity_cusfield_listview_items_checkbox"));
            this.categorySmallline = view.findViewById(ResourceUtils.getIdByName(SobotCusFieldAdapter.this.context, "id", "sobot_activity_cusfield_listview_items_line"));
            displayInNotch(this.categorySmallTitle);
        }

        public void displayInNotch(final View view) {
            if (SobotApi.getSwitchMarkStatus(1) && SobotApi.getSwitchMarkStatus(4) && view != null) {
                NotchScreenManager.getInstance().setDisplayInNotch(this.mActivity);
                this.mActivity.getWindow().setFlags(1024, 1024);
                NotchScreenManager.getInstance().getNotchInfo(this.mActivity, new INotchScreen.NotchScreenCallback() { // from class: com.sobot.chat.adapter.SobotCusFieldAdapter.MyViewHolder.1
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

    public SobotCusFieldAdapter(Activity activity, Context context, List<SobotCusFieldDataInfo> list, int i) {
        super(context, list);
        this.mContext = context;
        this.mActivity = activity;
        this.fieldType = i;
        this.adminList = list;
        this.displayList = list;
    }

    @Override // com.sobot.chat.adapter.base.SobotBaseAdapter, android.widget.Adapter
    public int getCount() {
        return this.displayList.size();
    }

    @Override // android.widget.Filterable
    public MyFilter getFilter() {
        if (this.mFilter == null) {
            this.mFilter = new MyFilter();
        }
        return this.mFilter;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            Context context = this.mContext;
            view = View.inflate(context, ResourceUtils.getIdByName(context, "layout", "sobot_activity_cusfield_listview_items"), null);
            MyViewHolder myViewHolder = new MyViewHolder(this.mActivity, view);
            this.myViewHolder = myViewHolder;
            view.setTag(myViewHolder);
        } else {
            this.myViewHolder = (MyViewHolder) view.getTag();
        }
        this.myViewHolder.categorySmallTitle.setText(this.displayList.get(i).getDataName());
        if (7 == this.fieldType) {
            this.myViewHolder.categorySmallIshave.setVisibility(8);
            this.myViewHolder.categorySmallCheckBox.setVisibility(0);
            if (this.displayList.get(i).isChecked()) {
                this.myViewHolder.categorySmallCheckBox.setBackgroundResource(ResourceUtils.getIdByName(this.mContext, i.f5112c, "sobot_post_category_checkbox_pressed"));
            } else {
                this.myViewHolder.categorySmallCheckBox.setBackgroundResource(ResourceUtils.getIdByName(this.mContext, i.f5112c, "sobot_post_category_checkbox_normal"));
            }
        } else {
            this.myViewHolder.categorySmallCheckBox.setVisibility(8);
            if (this.displayList.get(i).isChecked()) {
                this.myViewHolder.categorySmallIshave.setVisibility(0);
                this.myViewHolder.categorySmallIshave.setBackgroundResource(ResourceUtils.getIdByName(this.mContext, i.f5112c, "sobot_work_order_selected_mark"));
            } else {
                this.myViewHolder.categorySmallIshave.setVisibility(8);
            }
        }
        if (this.displayList.size() < 2) {
            this.myViewHolder.categorySmallline.setVisibility(8);
            return view;
        } else if (i == this.displayList.size() - 1) {
            this.myViewHolder.categorySmallline.setVisibility(8);
            return view;
        } else {
            this.myViewHolder.categorySmallline.setVisibility(0);
            return view;
        }
    }
}
