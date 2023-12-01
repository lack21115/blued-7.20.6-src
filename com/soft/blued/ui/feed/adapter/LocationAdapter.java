package com.soft.blued.ui.feed.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.common.utils.gaode.PositionPOIModel;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/adapter/LocationAdapter.class */
public class LocationAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f29861a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private List<PositionPOIModel> f29862c;
    private PositonItemClickListener d;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/adapter/LocationAdapter$PositonItemClickListener.class */
    public interface PositonItemClickListener {
        void a(PositionPOIModel positionPOIModel);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/adapter/LocationAdapter$ViewHolder.class */
    class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f29863a;
        public TextView b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f29864c;
        public ImageView d;
        public TextView e;

        private ViewHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(PositionPOIModel positionPOIModel, int i, View view) {
        Tracker.onClick(view);
        positionPOIModel.mark_visible = true;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f29862c.size()) {
                break;
            }
            if (i3 != i) {
                this.f29862c.get(i3).mark_visible = false;
            }
            i2 = i3 + 1;
        }
        PositonItemClickListener positonItemClickListener = this.d;
        if (positonItemClickListener != null) {
            positonItemClickListener.a(positionPOIModel);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f29862c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.b.inflate(R.layout.item_location_poi, (ViewGroup) null);
            viewHolder.f29863a = (LinearLayout) view2.findViewById(R.id.ll_item);
            viewHolder.b = (TextView) view2.findViewById(R.id.tv_poi_shortname);
            viewHolder.f29864c = (TextView) view2.findViewById(R.id.tv_poi_address);
            viewHolder.d = (ImageView) view2.findViewById(R.id.img_choosen_mark);
            viewHolder.e = (TextView) view2.findViewById(2131371289);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        final PositionPOIModel positionPOIModel = this.f29862c.get(i);
        viewHolder.b.setText(positionPOIModel.name);
        if (positionPOIModel.mark_visible) {
            viewHolder.d.setVisibility(0);
        } else {
            viewHolder.d.setVisibility(4);
        }
        viewHolder.f29863a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.adapter.-$$Lambda$LocationAdapter$G2L7Qi_8EeIyQJvXLYvSbbqYJT0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LocationAdapter.this.a(positionPOIModel, i, view3);
            }
        });
        if (i == 0) {
            viewHolder.b.setTextColor(this.f29861a.getResources().getColor(2131101301));
            viewHolder.e.setVisibility(8);
        } else {
            viewHolder.b.setTextColor(this.f29861a.getResources().getColor(2131101287));
            viewHolder.e.setVisibility(0);
        }
        if (TextUtils.isEmpty(positionPOIModel.address)) {
            viewHolder.f29864c.setText("");
            viewHolder.f29864c.setVisibility(8);
            return view2;
        }
        viewHolder.f29864c.setText(positionPOIModel.address);
        viewHolder.f29864c.setVisibility(0);
        return view2;
    }
}
