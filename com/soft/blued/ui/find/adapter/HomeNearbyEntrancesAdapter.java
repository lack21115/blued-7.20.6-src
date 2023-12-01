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
    private LayoutInflater f30052a;
    private List<JoyEntryModel> b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f30053c;
    private HomeNearbyEntranceItemClickListener d;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/HomeNearbyEntrancesAdapter$HomeNearbyEntranceItemClickListener.class */
    public interface HomeNearbyEntranceItemClickListener {
        void a(View view, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/HomeNearbyEntrancesAdapter$ViewHolder.class */
    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f30054a;
        public TextView b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f30055c;

        public ViewHolder(View view) {
            super(view);
            this.f30054a = (ImageView) view.findViewById(2131364496);
            this.b = (TextView) view.findViewById(2131372046);
            this.f30055c = (LinearLayout) view.findViewById(2131367715);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.f30052a.inflate(R.layout.item_nearby_entrances_btest, (ViewGroup) null);
        inflate.setOnClickListener(this);
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (viewHolder != null) {
            JoyEntryModel joyEntryModel = this.b.get(i);
            viewHolder.b.setText(joyEntryModel.name);
            ImageLoader.a(this.f30053c, joyEntryModel.icon).b(2131231620).a(viewHolder.f30054a);
            viewHolder.f30055c.setTag(Integer.valueOf(i));
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
