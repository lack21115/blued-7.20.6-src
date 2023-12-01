package com.amap.api.col.p0003sl;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapActivity;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.eo  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/eo.class */
public final class eo extends BaseAdapter {
    private List<OfflineMapCity> a = new ArrayList();
    private OfflineMapManager b;
    private Activity c;

    /* renamed from: com.amap.api.col.3sl.eo$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/eo$a.class */
    public final class a {
        public TextView a;
        public TextView b;
        public TextView c;
        public ImageView d;

        public a() {
        }
    }

    public eo(OfflineMapManager offlineMapManager, OfflineMapActivity offlineMapActivity) {
        this.b = offlineMapManager;
        this.c = offlineMapActivity;
    }

    public final void a(List<OfflineMapCity> list) {
        this.a = list;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.a.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        try {
            final OfflineMapCity offlineMapCity = this.a.get(i);
            if (view == null) {
                aVar = new a();
                view = ev.a(this.c, 2130903042);
                aVar.a = (TextView) view.findViewById(2131165195);
                aVar.b = (TextView) view.findViewById(2131165199);
                aVar.c = (TextView) view.findViewById(2131165197);
                aVar.d = (ImageView) view.findViewById(2131165198);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            View view2 = view;
            final a aVar2 = aVar;
            aVar.d.setOnClickListener(new View.OnClickListener() { // from class: com.amap.api.col.3sl.eo.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Tracker.onClick(view3);
                    aVar2.d.setVisibility(8);
                    aVar2.c.setVisibility(0);
                    aVar2.c.setText("下载中");
                    try {
                        eo.this.b.downloadByCityName(offlineMapCity.getCity());
                    } catch (AMapException e) {
                        e.printStackTrace();
                    }
                }
            });
            View view3 = view;
            aVar.c.setVisibility(0);
            View view4 = view;
            aVar.a.setText(offlineMapCity.getCity());
            View view5 = view;
            double size = ((int) (((offlineMapCity.getSize() / 1024.0d) / 1024.0d) * 100.0d)) / 100.0d;
            View view6 = view;
            TextView textView = aVar.b;
            View view7 = view;
            StringBuilder sb = new StringBuilder();
            View view8 = view;
            sb.append(String.valueOf(size));
            View view9 = view;
            sb.append(" M");
            View view10 = view;
            textView.setText(sb.toString());
            View view11 = view;
            int state = offlineMapCity.getState();
            if (state != -1) {
                if (state == 0 || state == 1) {
                    aVar.d.setVisibility(8);
                    View view12 = view;
                    aVar.c.setText("下载中");
                    return view;
                } else if (state == 2) {
                    aVar.d.setVisibility(8);
                    View view13 = view;
                    aVar.c.setText("等待下载");
                    return view;
                } else if (state == 3) {
                    aVar.d.setVisibility(8);
                    View view14 = view;
                    aVar.c.setText("暂停中");
                    return view;
                } else if (state == 4) {
                    aVar.d.setVisibility(8);
                    View view15 = view;
                    aVar.c.setText("已下载");
                    return view;
                } else if (state == 6) {
                    aVar.d.setVisibility(0);
                    View view16 = view;
                    aVar.c.setVisibility(8);
                    return view;
                } else {
                    switch (state) {
                        case 101:
                        case 102:
                        case 103:
                            break;
                        default:
                            return view;
                    }
                }
            }
            aVar.d.setVisibility(8);
            View view17 = view;
            aVar.c.setText("下载失败");
            return view;
        } catch (Exception e) {
            e.printStackTrace();
            return view;
        }
    }
}
