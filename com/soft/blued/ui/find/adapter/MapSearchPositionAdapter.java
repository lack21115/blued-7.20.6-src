package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.find.model.SearchPositionModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/MapSearchPositionAdapter.class */
public class MapSearchPositionAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f30064a;
    private List<SearchPositionModel> b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f30065c;
    private OnItemClickListener d;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/MapSearchPositionAdapter$OnItemClickListener.class */
    public interface OnItemClickListener {
        void a(View view, int i, SearchPositionModel searchPositionModel);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/MapSearchPositionAdapter$ViewHolder.class */
    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ConstraintLayout f30068a;
        public TextView b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f30069c;
        public TextView d;

        public ViewHolder(View view) {
            super(view);
            this.f30068a = (ConstraintLayout) view.findViewById(2131364780);
            this.b = (TextView) view.findViewById(2131370786);
            this.f30069c = (TextView) view.findViewById(R.id.tv_del);
            this.d = (TextView) view.findViewById(2131371817);
        }
    }

    public MapSearchPositionAdapter(Context context, List<SearchPositionModel> list) {
        this.f30064a = context;
        if (list.size() > 0) {
            SearchPositionModel searchPositionModel = new SearchPositionModel();
            searchPositionModel.isDel = true;
            list.add(searchPositionModel);
            notifyDataSetChanged();
        }
        this.b = list;
    }

    public MapSearchPositionAdapter(Context context, List<String> list, int i) {
        this.f30064a = context;
        this.b = c(list, true);
    }

    private List<SearchPositionModel> c(List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            SearchPositionModel searchPositionModel = new SearchPositionModel();
            searchPositionModel.name = str;
            arrayList.add(searchPositionModel);
        }
        Log.v("drb", "getModelList list.size():" + arrayList.size());
        if (arrayList.size() > 0 && z) {
            SearchPositionModel searchPositionModel2 = new SearchPositionModel();
            searchPositionModel2.isDel = true;
            arrayList.add(searchPositionModel2);
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.f30064a);
        this.f30065c = from;
        return new ViewHolder(from.inflate(R.layout.item_map_search_position, viewGroup, false));
    }

    public void a() {
        this.b.clear();
        notifyDataSetChanged();
    }

    public void a(OnItemClickListener onItemClickListener) {
        this.d = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final SearchPositionModel searchPositionModel = this.b.get(i);
        if (searchPositionModel.isDel) {
            viewHolder.b.setVisibility(8);
            viewHolder.d.setVisibility(8);
            viewHolder.f30069c.setVisibility(0);
        } else {
            viewHolder.b.setVisibility(0);
            viewHolder.d.setVisibility(0);
            viewHolder.f30069c.setVisibility(8);
        }
        viewHolder.b.setText(searchPositionModel.name);
        viewHolder.f30068a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.MapSearchPositionAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (MapSearchPositionAdapter.this.d == null || viewHolder.getAdapterPosition() == -1) {
                    return;
                }
                MapSearchPositionAdapter.this.d.a(view, viewHolder.getAdapterPosition(), searchPositionModel);
            }
        });
    }

    public void a(List<String> list, boolean z) {
        this.b = c(list, z);
        notifyDataSetChanged();
    }

    public void b(List<SearchPositionModel> list, boolean z) {
        Log.v("drb", "setDataList dataList.size():" + list.size());
        if (list.size() > 0 && z && !list.get(list.size() - 1).isDel) {
            SearchPositionModel searchPositionModel = new SearchPositionModel();
            searchPositionModel.isDel = true;
            list.add(searchPositionModel);
        }
        this.b = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<SearchPositionModel> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
