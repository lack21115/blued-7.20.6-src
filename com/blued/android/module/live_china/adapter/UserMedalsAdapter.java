package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.AnchorMedal;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/UserMedalsAdapter.class */
public class UserMedalsAdapter extends RecyclerView.Adapter<MedalViewHolder> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f11716a;
    private List<AnchorMedal> b;

    /* renamed from: c  reason: collision with root package name */
    private Context f11717c;
    private RecyclerViewItemClickListener d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/UserMedalsAdapter$MedalViewHolder.class */
    public class MedalViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f11718a;
        public LinearLayout b;

        public MedalViewHolder(View view) {
            super(view);
            this.f11718a = (ImageView) view.findViewById(R.id.img_medal);
            this.b = (LinearLayout) view.findViewById(R.id.ll_content);
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/UserMedalsAdapter$RecyclerViewItemClickListener.class */
    public interface RecyclerViewItemClickListener {
        void a(View view, int i);
    }

    public UserMedalsAdapter(Context context, List<AnchorMedal> list) {
        this.f11717c = context;
        this.f11716a = LayoutInflater.from(context);
        this.b = list;
    }

    public View a() {
        return this.f11716a.inflate(R.layout.item_user_anchor_medal4card, (ViewGroup) null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public MedalViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View a2 = a();
        a2.setOnClickListener(this);
        return new MedalViewHolder(a2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(MedalViewHolder medalViewHolder, int i) {
        if (medalViewHolder != null) {
            AnchorMedal anchorMedal = this.b.get(i);
            if (TextUtils.isEmpty(anchorMedal.pic)) {
                return;
            }
            ImageLoader.a((IRequestHost) null, anchorMedal.pic).a(medalViewHolder.f11718a);
            medalViewHolder.b.setTag(Integer.valueOf(i));
        }
    }

    public void a(RecyclerViewItemClickListener recyclerViewItemClickListener) {
        this.d = recyclerViewItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int intValue = ((Integer) view.getTag()).intValue();
        RecyclerViewItemClickListener recyclerViewItemClickListener = this.d;
        if (recyclerViewItemClickListener != null) {
            recyclerViewItemClickListener.a(view, intValue);
        }
    }
}
