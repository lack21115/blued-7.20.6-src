package com.blued.android.module.shortvideo.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.shortvideo.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/adapter/CoverAdapter.class */
public class CoverAdapter extends RecyclerView.Adapter<CoverItemViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f15691a;
    private int b;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/adapter/CoverAdapter$CoverItemViewHolder.class */
    public class CoverItemViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        ImageView f15693a;
        ImageView b;

        public CoverItemViewHolder(View view) {
            super(view);
            this.f15693a = (ImageView) this.itemView.findViewById(R.id.stv_cover_img);
            this.b = (ImageView) this.itemView.findViewById(R.id.stv_cover_selected_icon);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public CoverItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CoverItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cover_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(CoverItemViewHolder coverItemViewHolder, final int i) {
        coverItemViewHolder.b.setVisibility(8);
        if (this.b == i) {
            coverItemViewHolder.f15693a.setAlpha(1.0f);
            coverItemViewHolder.b.setVisibility(0);
        } else {
            coverItemViewHolder.f15693a.setAlpha(0.6f);
        }
        coverItemViewHolder.f15693a.setTag(Integer.valueOf(i));
        coverItemViewHolder.f15693a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.shortvideo.adapter.CoverAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CoverAdapter coverAdapter = CoverAdapter.this;
                coverAdapter.notifyItemChanged(coverAdapter.b);
                CoverAdapter.this.b = i;
                CoverAdapter.this.f15691a = ((ImageView) view).getDrawable();
                CoverAdapter coverAdapter2 = CoverAdapter.this;
                coverAdapter2.notifyItemChanged(coverAdapter2.b);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }
}
