package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import com.blued.android.module.common.utils.area.Country;
import com.soft.blued.R;
import com.soft.blued.ui.login_register.AreaCode.AreaCodeIndexer;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/CountryAdapter.class */
public class CountryAdapter extends BaseAdapter implements AreaCodeIndexer {

    /* renamed from: a  reason: collision with root package name */
    private final LayoutInflater f33737a;
    private List<Country> b;
    private Context e;

    /* renamed from: c  reason: collision with root package name */
    private List<Country> f33738c = new ArrayList();
    private List<Country> d = new ArrayList();
    private Map<String, Integer> f = new ArrayMap();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/CountryAdapter$ViewHolder.class */
    static class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        TextView f33739a;
        TextView b;

        /* renamed from: c  reason: collision with root package name */
        View f33740c;
        TextView d;

        ViewHolder() {
        }
    }

    public CountryAdapter(Context context, List<Country> list) {
        this.b = new ArrayList();
        this.b = list;
        this.f33738c.addAll(list);
        this.d.addAll(list);
        this.e = context;
        this.f33737a = LayoutInflater.from(context);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return;
            }
            String str = this.b.get(i2).group_by;
            if (str != null && !"".equals(str)) {
                String upperCase = str.toUpperCase();
                if (!this.f.containsKey(upperCase)) {
                    this.f.put(upperCase, Integer.valueOf(i2));
                }
            }
            i = i2 + 1;
        }
    }

    private void a(TextView textView, String str) {
        textView.setVisibility(0);
        textView.setText(str);
    }

    @Override // com.soft.blued.ui.login_register.AreaCode.AreaCodeIndexer
    public int a(String str) {
        if (this.f.containsKey(str)) {
            return this.f.get(str).intValue();
        }
        return -1;
    }

    public void a(Country country) {
        List<Country> list;
        if (country == null || (list = this.f33738c) == null || list.size() <= 0) {
            return;
        }
        this.f33738c.add(0, country);
        this.b.add(0, country);
    }

    public void b(String str) {
        List<Country> list = this.f33738c;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.d.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f33738c.size()) {
                break;
            }
            if (this.f33738c.get(i2).nation.contains(str) || this.f33738c.get(i2).abbr.contains(str) || this.f33738c.get(i2).group_by.equals(this.e.getResources().getString(R.string.position_now))) {
                this.d.add(this.f33738c.get(i2));
            }
            i = i2 + 1;
        }
        this.b.clear();
        if (StringUtils.d(str)) {
            this.b.addAll(this.f33738c);
        } else {
            this.b.addAll(this.d);
        }
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
        return this.b.get(i).abbr.hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.f33737a.inflate(R.layout.fragment_user_choosearea_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.f33739a = (TextView) view.findViewById(2131372046);
            viewHolder.b = (TextView) view.findViewById(2131371577);
            viewHolder.f33740c = view.findViewById(R.id.tv_rightArrow);
            viewHolder.d = (TextView) view.findViewById(R.id.tv_cutter);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Country country = this.b.get(i);
        viewHolder.f33739a.setText(country.nation);
        String str = country.group_by;
        String upperCase = str.toUpperCase();
        if (i == 0) {
            if (StringUtils.d(str)) {
                viewHolder.d.setVisibility(8);
                viewHolder.b.setVisibility(8);
            } else {
                a(viewHolder.b, upperCase);
                viewHolder.d.setVisibility(8);
                viewHolder.b.setVisibility(0);
            }
        } else if (upperCase.equals(this.b.get(i - 1).group_by.toUpperCase())) {
            viewHolder.b.setVisibility(8);
            viewHolder.d.setVisibility(0);
        } else {
            a(viewHolder.b, upperCase);
            viewHolder.d.setVisibility(8);
        }
        if ("1".equals(country.has_child)) {
            viewHolder.f33740c.setVisibility(0);
            return view;
        }
        viewHolder.f33740c.setVisibility(8);
        return view;
    }
}
