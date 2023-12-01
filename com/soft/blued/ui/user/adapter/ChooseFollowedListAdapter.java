package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.AvatarUtils;
import com.soft.blued.R;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/ChooseFollowedListAdapter.class */
public class ChooseFollowedListAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f33733a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f33734c;
    private List<BluedRecommendUsers> d;
    private LoadOptions e;
    private String f = "";

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/ChooseFollowedListAdapter$ViewHolder.class */
    class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f33735a;
        public TextView b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f33736c;
        public ImageView d;
        public ImageView e;
        public ImageView f;
        public ImageView g;

        private ViewHolder() {
        }
    }

    public ChooseFollowedListAdapter(IRequestHost iRequestHost, Context context) {
        this.d = new ArrayList();
        this.f33733a = context;
        this.b = iRequestHost;
        this.f33734c = LayoutInflater.from(context);
        this.d = new ArrayList();
        LoadOptions loadOptions = new LoadOptions();
        this.e = loadOptions;
        loadOptions.d = 2131237310;
        this.e.b = 2131237310;
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public BluedRecommendUsers getItem(int i) {
        return this.d.get(i);
    }

    public void a() {
        this.d.clear();
        notifyDataSetChanged();
    }

    public void a(String str) {
        this.f = str;
        notifyDataSetChanged();
    }

    public void a(List<BluedRecommendUsers> list) {
        this.d.clear();
        this.d.addAll(list);
        notifyDataSetChanged();
    }

    public void b(List<BluedRecommendUsers> list) {
        this.d.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.d.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        int indexOf;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.f33734c.inflate(R.layout.item_choose_followed_list, viewGroup, false);
            viewHolder.f33735a = (ImageView) view2.findViewById(2131364544);
            viewHolder.b = (TextView) view2.findViewById(2131372046);
            viewHolder.d = (ImageView) view2.findViewById(2131364720);
            viewHolder.e = (ImageView) view2.findViewById(2131364625);
            viewHolder.f = (ImageView) view2.findViewById(2131364459);
            viewHolder.f33736c = (TextView) view2.findViewById(2131372122);
            viewHolder.g = (ImageView) view2.findViewById(2131364726);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        BluedRecommendUsers bluedRecommendUsers = this.d.get(i);
        ImageLoader.a(this.b, AvatarUtils.a(0, bluedRecommendUsers.avatar)).c().b(2131237310).a(viewHolder.f33735a);
        String str = bluedRecommendUsers.name;
        if (StringUtils.d(bluedRecommendUsers.note)) {
            viewHolder.f33736c.setVisibility(8);
        } else {
            viewHolder.f33736c.setVisibility(0);
            viewHolder.f33736c.setText(this.f33733a.getResources().getString(R.string.name_note) + bluedRecommendUsers.note);
        }
        UserRelationshipUtils.a(viewHolder.g, bluedRecommendUsers);
        if (StringUtils.d(bluedRecommendUsers.blued_pic)) {
            viewHolder.f.setVisibility(8);
        } else {
            viewHolder.f.setVisibility(0);
            ImageLoader.a(this.b, bluedRecommendUsers.blued_pic).b(R.drawable.blued_medal_default).a(viewHolder.f);
        }
        if (1 == bluedRecommendUsers.online_state) {
            viewHolder.e.setVisibility(0);
        } else {
            viewHolder.e.setVisibility(8);
        }
        if (StringUtils.d(str)) {
            viewHolder.b.setText("");
        } else if (StringUtils.d(this.f) || !str.toLowerCase().contains(this.f.toLowerCase())) {
            viewHolder.b.setText(str);
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            String lowerCase = str.toLowerCase();
            this.f = this.f.toLowerCase();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= lowerCase.length() || (indexOf = lowerCase.indexOf(this.f, i3)) < 0) {
                    break;
                }
                spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, this.f.length() + indexOf, 33);
                i2 = Math.max(i3 + 1, indexOf);
            }
            viewHolder.b.setText(spannableStringBuilder);
        }
        UserRelationshipUtils.a(this.f33733a, viewHolder.b, bluedRecommendUsers);
        UserInfoHelper.a(viewHolder.d, bluedRecommendUsers.vbadge, 3);
        return view2;
    }
}
