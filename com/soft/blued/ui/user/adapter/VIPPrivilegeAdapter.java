package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.VIPPrivilegeModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPPrivilegeAdapter.class */
public class VIPPrivilegeAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f20112a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f20113c;
    private List<VIPPrivilegeModel> d;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPPrivilegeAdapter$ViewHolder.class */
    class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f20115a;
        public TextView b;

        ViewHolder() {
        }
    }

    public VIPPrivilegeAdapter(Context context, IRequestHost iRequestHost, List<VIPPrivilegeModel> list, GridView gridView) {
        this.b = context;
        this.f20113c = iRequestHost;
        this.f20112a = LayoutInflater.from(context);
        this.d = list;
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.user.adapter.VIPPrivilegeAdapter.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                if (((VIPPrivilegeModel) VIPPrivilegeAdapter.this.d.get(i)) == null) {
                }
            }
        });
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.d.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            ViewHolder viewHolder2 = new ViewHolder();
            View inflate = this.f20112a.inflate(R.layout.item_vip_privilege, viewGroup, false);
            viewHolder2.f20115a = (ImageView) inflate.findViewById(R.id.vip_privilege_view);
            viewHolder2.b = (TextView) inflate.findViewById(R.id.vip_privilege_name);
            inflate.setTag(viewHolder2);
            viewHolder = viewHolder2;
            view = inflate;
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        VIPPrivilegeModel vIPPrivilegeModel = this.d.get(i);
        if (vIPPrivilegeModel != null) {
            ImageLoader.a(this.f20113c, vIPPrivilegeModel.icon).b(2131237310).c().a(viewHolder.f20115a);
            viewHolder.b.setText(vIPPrivilegeModel.name);
            Log.v("drb", "model.name:" + vIPPrivilegeModel.name + " -- position");
        }
        return view;
    }
}
