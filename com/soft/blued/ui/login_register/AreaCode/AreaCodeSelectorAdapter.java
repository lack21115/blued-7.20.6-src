package com.soft.blued.ui.login_register.AreaCode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import com.blued.android.module.common.utils.area.AreaCode;
import com.soft.blued.R;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/AreaCode/AreaCodeSelectorAdapter.class */
public class AreaCodeSelectorAdapter extends BaseAdapter implements AreaCodeIndexer {

    /* renamed from: a  reason: collision with root package name */
    private final LayoutInflater f17664a;
    private List<AreaCode> b;

    /* renamed from: c  reason: collision with root package name */
    private Context f17665c;
    private ArrayMap<String, Integer> d = new ArrayMap<>();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/AreaCode/AreaCodeSelectorAdapter$ViewHolder.class */
    static class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        TextView f17666a;
        TextView b;

        /* renamed from: c  reason: collision with root package name */
        TextView f17667c;

        ViewHolder() {
        }
    }

    public AreaCodeSelectorAdapter(Context context, List<AreaCode> list) {
        this.b = list;
        this.f17665c = context;
        this.f17664a = LayoutInflater.from(context);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return;
            }
            String sort = this.b.get(i2).getSort();
            if (sort != null && !"".equals(sort)) {
                String upperCase = sort.toUpperCase();
                if (!this.d.containsKey(upperCase)) {
                    this.d.put(upperCase, Integer.valueOf(i2));
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
        if (this.d.containsKey(str)) {
            return this.d.get(str).intValue();
        }
        return -1;
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
        if (view == null) {
            view = this.f17664a.inflate(R.layout.areacode_list_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.f17666a = (TextView) view.findViewById(R.id.tvName);
            viewHolder.b = (TextView) view.findViewById(R.id.tvSection);
            viewHolder.f17667c = (TextView) view.findViewById(R.id.tvCode);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        AreaCode areaCode = this.b.get(i);
        viewHolder.f17666a.setText(areaCode.getName());
        viewHolder.f17667c.setText(areaCode.getCode());
        String upperCase = areaCode.getSort().toUpperCase();
        if (i == 0) {
            a(viewHolder.b, upperCase);
            return view;
        } else if (upperCase.equals(this.b.get(i - 1).getSort().toUpperCase())) {
            viewHolder.b.setVisibility(8);
            return view;
        } else {
            a(viewHolder.b, upperCase);
            return view;
        }
    }
}
