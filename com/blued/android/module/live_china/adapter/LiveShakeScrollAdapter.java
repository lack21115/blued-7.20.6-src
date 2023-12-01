package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveShakeResModel;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveShakeScrollAdapter.class */
public class LiveShakeScrollAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<LiveShakeResModel> a;
    private Context b;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveShakeScrollAdapter$ViewHolder.class */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView b;

        public ViewHolder(View view) {
            super(view);
            this.b = (ImageView) view.findViewById(R.id.iv_num);
        }
    }

    public LiveShakeScrollAdapter(Context context) {
        this.b = context;
    }

    /* renamed from: a */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(View.inflate(this.b, R.layout.live_shake_item_view, null));
    }

    /* renamed from: a */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        List<LiveShakeResModel> list = this.a;
        if (list == null || list.size() == 0) {
            return;
        }
        LiveShakeResModel liveShakeResModel = this.a.get(i % this.a.size());
        viewHolder.b.setImageResource(this.b.getResources().getIdentifier("live_shake_num_" + liveShakeResModel.res_, "drawable", this.b.getPackageName()));
    }

    public void a(List<LiveShakeResModel> list) {
        this.a = list;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return Integer.MAX_VALUE;
    }
}
