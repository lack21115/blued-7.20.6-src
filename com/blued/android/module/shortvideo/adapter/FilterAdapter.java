package com.blued.android.module.shortvideo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.module.base.data_statistics.StatisticsProxy;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.model.FilterItem;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/adapter/FilterAdapter.class */
public class FilterAdapter extends RecyclerView.Adapter<FilterItemViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f15695a;
    private List<FilterItem> b;

    /* renamed from: c  reason: collision with root package name */
    private int f15696c;
    private int d;
    private int e;
    private CommonModel f;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/adapter/FilterAdapter$FilterItemViewHolder.class */
    public class FilterItemViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f15699a;
        public ImageView b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15700c;

        public FilterItemViewHolder(View view) {
            super(view);
            this.b = (ImageView) view.findViewById(R.id.stv_filter_icon);
            this.f15699a = (ImageView) view.findViewById(R.id.stv_filter_selected_icon);
            this.f15700c = (TextView) view.findViewById(R.id.stv_filter_name);
        }
    }

    public FilterAdapter(Context context, CommonModel commonModel) {
        this.f15695a = context;
        this.f = commonModel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public FilterItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new FilterItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stv_filter_item, viewGroup, false));
    }

    public void a(int i) {
        notifyItemChanged(this.f15696c);
        this.f15696c = i;
        notifyItemChanged(i);
    }

    public void a(int i, int i2, int i3) {
        CommonModel commonModel = this.f;
        if (commonModel == null) {
            return;
        }
        this.d = i2;
        this.e = i3;
        int i4 = 0;
        if (i3 == 4 && i2 == 3) {
            boolean isUseData = commonModel.isUseData();
            this.b = this.f.getFilters();
            if (isUseData) {
                i4 = this.f.getSelectFilterPosition();
            }
        } else {
            boolean isUseData2 = this.f.isUseData();
            this.b = this.f.getFilters();
            if (isUseData2) {
                i4 = this.f.getSelectFilterPosition();
            }
        }
        final int i5 = i4;
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.shortvideo.adapter.FilterAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                FilterAdapter.this.a(i5);
            }
        }, 1000L);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(FilterItemViewHolder filterItemViewHolder, final int i) {
        FilterItem filterItem = this.b.get(i);
        filterItemViewHolder.f15699a.setVisibility(8);
        if (this.f15696c == i) {
            filterItemViewHolder.f15699a.setVisibility(0);
        }
        filterItemViewHolder.f15700c.setText(filterItem.a());
        filterItemViewHolder.b.setImageResource(filterItem.c());
        filterItemViewHolder.b.setTag(filterItem);
        filterItemViewHolder.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.shortvideo.adapter.FilterAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                StvViewUtils.a(view);
                FilterAdapter filterAdapter = FilterAdapter.this;
                filterAdapter.notifyItemChanged(filterAdapter.f15696c);
                FilterItem filterItem2 = (FilterItem) view.getTag();
                FilterAdapter.this.f15696c = i;
                if (FilterAdapter.this.f != null && FilterAdapter.this.f.getFrom() < 60) {
                    StatisticsProxy.a().a("sv_filter_click", FilterAdapter.this.f15696c);
                }
                FilterAdapter filterAdapter2 = FilterAdapter.this;
                filterAdapter2.notifyItemChanged(filterAdapter2.f15696c);
                if (FilterAdapter.this.f != null) {
                    FilterAdapter.this.f.setSelectedFilter(filterItem2);
                    FilterAdapter.this.f.setSelectFilterPosition(FilterAdapter.this.f15696c);
                }
                ObserverMgr.a().a(EventType.VALUE.UPDATE_FILTER);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<FilterItem> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }
}
