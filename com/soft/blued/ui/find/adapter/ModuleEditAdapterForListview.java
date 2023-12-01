package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.find.model.NearbyModule;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/ModuleEditAdapterForListview.class */
public class ModuleEditAdapterForListview extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public View.OnClickListener f30070a;
    private List<NearbyModule> b;

    /* renamed from: c  reason: collision with root package name */
    private Context f30071c;
    private LayoutInflater d;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/ModuleEditAdapterForListview$ViewHolder.class */
    public class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f30074a;
        public ImageView b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f30075c;

        public ViewHolder() {
        }
    }

    public ModuleEditAdapterForListview(Context context, View.OnClickListener onClickListener) {
        this.f30071c = context;
        this.d = LayoutInflater.from(context);
        this.f30070a = onClickListener;
    }

    public List<NearbyModule> a() {
        return this.b;
    }

    public void a(List<NearbyModule> list) {
        List<NearbyModule> list2 = this.b;
        if (list2 != null) {
            list2.clear();
        } else {
            this.b = new ArrayList();
        }
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<NearbyModule> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.d.inflate(R.layout.item_nearby_module_edit, viewGroup, false);
            viewHolder.f30074a = (TextView) view2.findViewById(2131372754);
            viewHolder.b = (ImageView) view2.findViewById(R.id.img_on_off);
            viewHolder.f30075c = (LinearLayout) view2.findViewById(R.id.ll_item);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        final NearbyModule nearbyModule = this.b.get(i);
        viewHolder.f30074a.setText(nearbyModule.title);
        if (nearbyModule.is_fixed == 1) {
            viewHolder.f30074a.setTextColor(this.f30071c.getResources().getColor(2131101206));
            viewHolder.b.setVisibility(8);
            return view2;
        }
        viewHolder.f30074a.setTextColor(this.f30071c.getResources().getColor(2131101202));
        viewHolder.b.setVisibility(0);
        viewHolder.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.ModuleEditAdapterForListview.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                NearbyModule nearbyModule2 = nearbyModule;
                int i2 = 1;
                if (((NearbyModule) ModuleEditAdapterForListview.this.b.get(i)).is_show == 1) {
                    i2 = 0;
                }
                nearbyModule2.is_show = i2;
                ModuleEditAdapterForListview.this.notifyDataSetChanged();
                ModuleEditAdapterForListview.this.f30070a.onClick(view3);
            }
        });
        if (this.b.get(i).is_show == 1) {
            viewHolder.b.setImageResource(2131237259);
            return view2;
        }
        viewHolder.b.setImageResource(2131237258);
        return view2;
    }
}
