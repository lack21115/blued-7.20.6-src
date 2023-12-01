package com.amap.api.col.p0003sl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.em  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/em.class */
public final class em extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {
    private boolean[] b;

    /* renamed from: c  reason: collision with root package name */
    private Context f4920c;
    private er d;
    private et f;
    private OfflineMapManager g;
    private List<OfflineMapProvince> e = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    List<OfflineMapProvince> f4919a = new ArrayList();

    /* renamed from: com.amap.api.col.3sl.em$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/em$a.class */
    public final class a {

        /* renamed from: a  reason: collision with root package name */
        public er f4922a;

        public a() {
        }
    }

    public em(Context context, et etVar, OfflineMapManager offlineMapManager, List<OfflineMapProvince> list) {
        this.f4920c = context;
        this.f = etVar;
        this.g = offlineMapManager;
        if (list != null && list.size() > 0) {
            this.e.clear();
            this.e.addAll(list);
            for (OfflineMapProvince offlineMapProvince : this.e) {
                if (offlineMapProvince != null && offlineMapProvince.getDownloadedCityList().size() > 0) {
                    this.f4919a.add(offlineMapProvince);
                }
            }
        }
        this.b = new boolean[this.f4919a.size()];
    }

    public final void a() {
        for (OfflineMapProvince offlineMapProvince : this.e) {
            if (offlineMapProvince.getDownloadedCityList().size() > 0 && !this.f4919a.contains(offlineMapProvince)) {
                this.f4919a.add(offlineMapProvince);
            }
        }
        this.b = new boolean[this.f4919a.size()];
        notifyDataSetChanged();
    }

    public final void b() {
        try {
            int size = this.f4919a.size();
            while (true) {
                int i = size;
                if (i <= 0) {
                    this.b = new boolean[this.f4919a.size()];
                    notifyDataSetChanged();
                    return;
                }
                OfflineMapProvince offlineMapProvince = this.f4919a.get(i - 1);
                if (offlineMapProvince.getDownloadedCityList().size() == 0) {
                    this.f4919a.remove(offlineMapProvince);
                }
                size = i - 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getChild(int i, int i2) {
        return this.f4919a.get(i).getDownloadedCityList().get(i2);
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
            er erVar = new er(this.f4920c, this.g);
            this.d = erVar;
            erVar.a(2);
            view = this.d.a();
            aVar.f4922a = this.d;
            view.setTag(aVar);
        }
        OfflineMapProvince offlineMapProvince = this.f4919a.get(i);
        if (i2 < offlineMapProvince.getDownloadedCityList().size()) {
            final OfflineMapCity offlineMapCity = offlineMapProvince.getDownloadedCityList().get(i2);
            aVar.f4922a.a(offlineMapCity);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.amap.api.col.3sl.em.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Tracker.onClick(view2);
                    em.this.f.a(offlineMapCity);
                }
            });
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getChildrenCount(int i) {
        return this.f4919a.get(i).getDownloadedCityList().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getGroup(int i) {
        return this.f4919a.get(i).getProvinceName();
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getGroupCount() {
        return this.f4919a.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        RelativeLayout relativeLayout = view;
        if (view == null) {
            relativeLayout = (RelativeLayout) ev.a(this.f4920c, (int) R.array.animal);
        }
        TextView textView = (TextView) relativeLayout.findViewById(2131165201);
        ImageView imageView = (ImageView) relativeLayout.findViewById(2131165202);
        textView.setText(this.f4919a.get(i).getProvinceName());
        if (this.b[i]) {
            imageView.setImageDrawable(ev.a().getDrawable(2130837509));
            return relativeLayout;
        }
        imageView.setImageDrawable(ev.a().getDrawable(2130837510));
        return relativeLayout;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public final void onGroupCollapse(int i) {
        this.b[i] = false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public final void onGroupExpand(int i) {
        this.b[i] = true;
    }
}
