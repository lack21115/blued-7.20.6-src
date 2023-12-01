package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.user.model.UserTag;
import com.soft.blued.R;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/UserTagAdapter.class */
public class UserTagAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f33769a;
    private List<UserTag> b;

    /* renamed from: c  reason: collision with root package name */
    private Context f33770c;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/UserTagAdapter$ViewHolder.class */
    class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f33771a;
        public TextView b;

        private ViewHolder() {
        }
    }

    public UserTagAdapter(Context context, List<UserTag> list) {
        this.f33769a = LayoutInflater.from(context);
        this.b = list == null ? new ArrayList() : list;
        this.f33770c = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.f33769a.inflate(R.layout.item_user_tag, viewGroup, false);
            viewHolder.f33771a = (LinearLayout) view2.findViewById(2131367656);
            viewHolder.b = (TextView) view2.findViewById(R.id.tv_tage);
            ViewGroup.LayoutParams layoutParams = viewHolder.f33771a.getLayoutParams();
            layoutParams.width = (this.f33770c.getResources().getDisplayMetrics().widthPixels - DensityUtils.a(this.f33770c, 90.0f)) / 4;
            viewHolder.f33771a.setLayoutParams(layoutParams);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        UserTag userTag = this.b.get(i);
        if (userTag.checked == 1) {
            if (Build.VERSION.SDK_INT < 16) {
                viewHolder.f33771a.setBackgroundDrawable(BluedSkinUtils.b(this.f33770c, R.drawable.user_job_text_select_bg));
            } else {
                viewHolder.f33771a.setBackground(BluedSkinUtils.b(this.f33770c, R.drawable.user_job_text_select_bg));
            }
            viewHolder.b.setTextColor(BluedSkinUtils.a(this.f33770c, 2131101780));
        } else {
            if (Build.VERSION.SDK_INT < 16) {
                viewHolder.f33771a.setBackgroundDrawable(BluedSkinUtils.b(this.f33770c, R.drawable.user_job_text_bg));
            } else {
                viewHolder.f33771a.setBackground(BluedSkinUtils.b(this.f33770c, R.drawable.user_job_text_bg));
            }
            viewHolder.b.setTextColor(BluedSkinUtils.a(this.f33770c, 2131102254));
        }
        if (StringUtils.d(userTag.name)) {
            viewHolder.f33771a.setVisibility(8);
        } else {
            viewHolder.f33771a.setVisibility(0);
            viewHolder.b.setText(userTag.name);
        }
        if (userTag.chooseable) {
            viewHolder.b.setTextColor(viewHolder.b.getTextColors());
            if (Build.VERSION.SDK_INT < 16) {
                viewHolder.f33771a.setBackgroundDrawable(viewHolder.f33771a.getBackground());
                return view2;
            }
            viewHolder.f33771a.setBackground(viewHolder.f33771a.getBackground());
            return view2;
        }
        viewHolder.b.setTextColor(BluedSkinUtils.a(this.f33770c, 2131102260));
        if (Build.VERSION.SDK_INT < 16) {
            viewHolder.f33771a.setBackgroundDrawable(BluedSkinUtils.b(this.f33770c, R.drawable.user_job_text_bg));
            return view2;
        }
        viewHolder.f33771a.setBackground(BluedSkinUtils.b(this.f33770c, R.drawable.user_job_text_bg));
        return view2;
    }
}
