package com.soft.blued.ui.find.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.find.model.JoyEntryModel;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/HomeNearbyEntrancesAdapter.class */
public class HomeNearbyEntrancesAdapter extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f16362a;
    private List<JoyEntryModel> b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f16363c;
    private HomeNearbyEntranceItemClickListener d;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/HomeNearbyEntrancesAdapter$HomeNearbyEntranceItemClickListener.class */
    public interface HomeNearbyEntranceItemClickListener {
        void a(View view, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/HomeNearbyEntrancesAdapter$ViewHolder.class */
    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f16364a;
        public TextView b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f16365c;

        public ViewHolder(View view) {
            super(view);
            this.f16364a = (ImageView) view.findViewById(R.id.img_cover);
            this.b = (TextView) view.findViewById(2131372046);
            this.f16365c = (LinearLayout) view.findViewById(2131367715);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.f16362a.inflate(R.layout.item_nearby_entrances_btest, (ViewGroup) null);
        inflate.setOnClickListener(this);
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (viewHolder != null) {
            JoyEntryModel joyEntryModel = this.b.get(i);
            viewHolder.b.setText(joyEntryModel.name);
            ImageLoader.a(this.f16363c, joyEntryModel.icon).b(2131231620).a(viewHolder.f16364a);
            viewHolder.f16365c.setTag(Integer.valueOf(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int intValue = ((Integer) view.getTag()).intValue();
        HomeNearbyEntranceItemClickListener homeNearbyEntranceItemClickListener = this.d;
        if (homeNearbyEntranceItemClickListener != null) {
            homeNearbyEntranceItemClickListener.a(view, intValue);
        }
    }
}
