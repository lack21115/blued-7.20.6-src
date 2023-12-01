package com.amap.api.col.p0003sl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.soft.blued.R;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.en  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/en.class */
public final class en extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    /* renamed from: a  reason: collision with root package name */
    private boolean[] f4923a;
    private int b = -1;

    /* renamed from: c  reason: collision with root package name */
    private List<OfflineMapProvince> f4924c;
    private OfflineMapManager d;
    private Context e;

    /* renamed from: com.amap.api.col.3sl.en$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/en$a.class */
    public final class a {

        /* renamed from: a  reason: collision with root package name */
        public er f4925a;

        public a() {
        }
    }

    public en(List<OfflineMapProvince> list, OfflineMapManager offlineMapManager, Context context) {
        this.f4924c = null;
        this.f4924c = list;
        this.d = offlineMapManager;
        this.e = context;
        this.f4923a = new boolean[list.size()];
    }

    private boolean a(int i) {
        return (i == 0 || i == getGroupCount() - 1) ? false : true;
    }

    public final void a() {
        this.b = -1;
        notifyDataSetChanged();
    }

    public final void b() {
        this.b = 0;
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getChild(int i, int i2) {
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            aVar = new a();
            er erVar = new er(this.e, this.d);
            erVar.a(1);
            view = erVar.a();
            aVar.f4925a = erVar;
            view.setTag(aVar);
        }
        aVar.f4925a.a(this.f4924c.get(i).getCityList().get(i2));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getChildrenCount(int i) {
        return a(i) ? this.f4924c.get(i).getCityList().size() : this.f4924c.get(i).getCityList().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getGroup(int i) {
        return this.f4924c.get(i).getProvinceName();
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getGroupCount() {
        int i = this.b;
        int i2 = i;
        if (i == -1) {
            i2 = this.f4924c.size();
        }
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        RelativeLayout relativeLayout = view;
        if (view == null) {
            relativeLayout = (RelativeLayout) ev.a(this.e, (int) R.array.animal);
        }
        TextView textView = (TextView) relativeLayout.findViewById(2131165201);
        ImageView imageView = (ImageView) relativeLayout.findViewById(2131165202);
        textView.setText(this.f4924c.get(i).getProvinceName());
        if (this.f4923a[i]) {
            imageView.setImageDrawable(ev.a().getDrawable(2130837509));
            return relativeLayout;
        }
        imageView.setImageDrawable(ev.a().getDrawable(2130837510));
        return relativeLayout;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public final void onGroupCollapse(int i) {
        this.f4923a[i] = false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public final void onGroupExpand(int i) {
        this.f4923a[i] = true;
    }
}
