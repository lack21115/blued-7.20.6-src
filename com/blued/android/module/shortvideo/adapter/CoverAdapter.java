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
    private Drawable a;
    private int b;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/adapter/CoverAdapter$CoverItemViewHolder.class */
    public class CoverItemViewHolder extends RecyclerView.ViewHolder {
        ImageView a;
        ImageView b;

        public CoverItemViewHolder(View view) {
            super(view);
            this.a = (ImageView) this.itemView.findViewById(R.id.stv_cover_img);
            this.b = (ImageView) this.itemView.findViewById(R.id.stv_cover_selected_icon);
        }
    }

    /* renamed from: a */
    public CoverItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CoverItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cover_item, viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(CoverItemViewHolder coverItemViewHolder, final int i) {
        coverItemViewHolder.b.setVisibility(8);
        if (this.b == i) {
            coverItemViewHolder.a.setAlpha(1.0f);
            coverItemViewHolder.b.setVisibility(0);
        } else {
            coverItemViewHolder.a.setAlpha(0.6f);
        }
        coverItemViewHolder.a.setTag(Integer.valueOf(i));
        coverItemViewHolder.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.shortvideo.adapter.CoverAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CoverAdapter coverAdapter = CoverAdapter.this;
                coverAdapter.notifyItemChanged(coverAdapter.b);
                CoverAdapter.this.b = i;
                CoverAdapter.this.a = ((ImageView) view).getDrawable();
                CoverAdapter coverAdapter2 = CoverAdapter.this;
                coverAdapter2.notifyItemChanged(coverAdapter2.b);
            }
        });
    }

    public int getItemCount() {
        return 0;
    }

    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }
}
