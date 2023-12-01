package com.soft.blued.ui.user.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.common.user.model.UserTag;
import com.soft.blued.R;
import com.soft.blued.utils.StringUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/UserTagforUserinfoAdapter.class */
public class UserTagforUserinfoAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f20084a;
    private List<UserTag> b;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/UserTagforUserinfoAdapter$ViewHolder.class */
    class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f20085a;
        public TextView b;

        private ViewHolder() {
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public UserTag getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
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
            view2 = this.f20084a.inflate(R.layout.item_user_tag_userinfo, viewGroup, false);
            viewHolder.f20085a = (LinearLayout) view2.findViewById(R.id.ll_bg);
            viewHolder.b = (TextView) view2.findViewById(R.id.tv_tage);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        UserTag userTag = this.b.get(i);
        if (StringUtils.d(userTag.name)) {
            viewHolder.f20085a.setVisibility(8);
            return view2;
        }
        viewHolder.f20085a.setVisibility(0);
        viewHolder.b.setText(userTag.name);
        return view2;
    }
}
