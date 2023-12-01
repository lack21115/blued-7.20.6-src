package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.soft.blued.R;
import com.soft.blued.ui.find.model.BluedMyVisitorList;
import com.soft.blued.ui.find.viewholder.VisitorViewHolder;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/VisitorGetVipAdapter.class */
public class VisitorGetVipAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f16461a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private LoadOptions f16462c;
    private List<BluedMyVisitorList> d;
    private LayoutInflater e;
    private List<Integer> f;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/VisitorGetVipAdapter$VisitorGetVipViewHolder.class */
    public class VisitorGetVipViewHolder extends VisitorViewHolder {

        /* renamed from: a  reason: collision with root package name */
        ImageView f16463a;

        public VisitorGetVipViewHolder(Context context, View view, LoadOptions loadOptions) {
            super(context, VisitorGetVipAdapter.this.b, view, loadOptions, 1);
            this.f16463a = (ImageView) view.findViewById(R.id.img_areo_cover);
        }

        @Override // com.soft.blued.ui.find.viewholder.VisitorViewHolder
        public void a(int i) {
            if (i < VisitorGetVipAdapter.this.f.size()) {
                this.f16463a.setImageResource(((Integer) VisitorGetVipAdapter.this.f.get(i)).intValue());
            }
        }

        @Override // com.soft.blued.ui.find.viewholder.VisitorViewHolder
        public void a(LogData logData) {
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.d.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        VisitorGetVipViewHolder visitorGetVipViewHolder;
        BluedMyVisitorList bluedMyVisitorList = this.d.get(i);
        if (view == null) {
            view2 = this.e.inflate(R.layout.item_visitor_my_visitor_get_vip, (ViewGroup) null);
            visitorGetVipViewHolder = new VisitorGetVipViewHolder(this.f16461a, view2, this.f16462c);
            view2.setTag(visitorGetVipViewHolder);
        } else {
            view2 = view;
            visitorGetVipViewHolder = (VisitorGetVipViewHolder) view.getTag();
        }
        visitorGetVipViewHolder.a(bluedMyVisitorList, i);
        return view2;
    }
}
