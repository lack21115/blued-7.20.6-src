package com.soft.blued.ui.setting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.setting.model.BluedIcon;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/adapter/BluedIconAdapter.class */
public class BluedIconAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f33280a;
    private OnItemClickListener b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f33281c;
    private List<BluedIcon> d;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/adapter/BluedIconAdapter$OnItemClickListener.class */
    public interface OnItemClickListener {
        void a(View view, int i);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/adapter/BluedIconAdapter$ViewHolder.class */
    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f33283a;

        public ViewHolder(View view) {
            super(view);
            this.f33283a = (ImageView) view.findViewById(2131364373);
        }
    }

    public BluedIconAdapter(Context context, List<BluedIcon> list) {
        this.f33280a = context;
        this.d = list;
        this.f33281c = LayoutInflater.from(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.f33281c.inflate(R.layout.item_blued_icon, (ViewGroup) null));
    }

    public void a(OnItemClickListener onItemClickListener) {
        this.b = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        if (viewHolder != null) {
            BluedIcon bluedIcon = this.d.get(i);
            viewHolder.f33283a.setImageResource(bluedIcon.getIconResourceId());
            if (bluedIcon.isChecked()) {
                viewHolder.f33283a.getBackground().setAlpha(255);
            } else {
                viewHolder.f33283a.getBackground().setAlpha(0);
            }
            viewHolder.f33283a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.adapter.BluedIconAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (BluedIconAdapter.this.b == null || viewHolder.getAdapterPosition() == -1) {
                        return;
                    }
                    BluedIconAdapter.this.b.a(view, viewHolder.getAdapterPosition());
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<BluedIcon> list = this.d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
