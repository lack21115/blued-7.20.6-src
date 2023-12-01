package com.soft.blued.ui.login_register.AreaCode;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.blued.android.module.common.utils.area.AreaCode;
import com.soft.blued.R;
import com.soft.blued.utils.StringUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/AreaCode/AreaCodeSelectorSearchAdapter.class */
public class AreaCodeSelectorSearchAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final LayoutInflater f31358a;
    private List<AreaCode> b;

    /* renamed from: c  reason: collision with root package name */
    private Context f31359c;
    private String d;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/AreaCode/AreaCodeSelectorSearchAdapter$ViewHolder.class */
    static class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        TextView f31360a;
        TextView b;

        ViewHolder() {
        }
    }

    public AreaCodeSelectorSearchAdapter(Context context, List<AreaCode> list) {
        this.b = list;
        this.f31359c = context;
        this.f31358a = LayoutInflater.from(context);
    }

    public void a(List<AreaCode> list, String str) {
        this.d = str;
        this.b.clear();
        this.b.addAll(list);
        notifyDataSetChanged();
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
        return this.b.get(i).getSort().hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        int indexOf;
        if (view == null) {
            view = this.f31358a.inflate(R.layout.areacode_list_search_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.f31360a = (TextView) view.findViewById(2131370806);
            viewHolder.b = (TextView) view.findViewById(R.id.tvCode);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        AreaCode areaCode = this.b.get(i);
        viewHolder.b.setText(areaCode.getCode());
        String name = areaCode.getName();
        if (StringUtils.d(name) || StringUtils.d(this.d)) {
            viewHolder.f31360a.setText(name);
            return view;
        } else if (!name.toLowerCase().contains(this.d.toLowerCase())) {
            viewHolder.f31360a.setText(name);
            return view;
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            String lowerCase = name.toLowerCase();
            this.d = this.d.toLowerCase();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= lowerCase.length() || (indexOf = lowerCase.indexOf(this.d, i3)) < 0) {
                    break;
                }
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#f46200")), indexOf, this.d.length() + indexOf, 33);
                i2 = Math.max(i3 + 1, indexOf);
            }
            viewHolder.f31360a.setText(spannableStringBuilder);
            return view;
        }
    }
}
