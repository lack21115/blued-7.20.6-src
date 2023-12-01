package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.model.AnchorMedal;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.utils.StringUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/UserMedalsAdapter.class */
public class UserMedalsAdapter extends RecyclerView.Adapter<MedalViewHolder> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f20070a;
    private List<AnchorMedal> b;

    /* renamed from: c  reason: collision with root package name */
    private Context f20071c;
    private IRequestHost d;
    private RecyclerViewItemClickListener e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/UserMedalsAdapter$MedalViewHolder.class */
    public class MedalViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f20072a;
        public LinearLayout b;

        public MedalViewHolder(View view) {
            super(view);
            this.f20072a = (ImageView) view.findViewById(R.id.img_medal);
            this.b = (LinearLayout) view.findViewById(2131367715);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/UserMedalsAdapter$RecyclerViewItemClickListener.class */
    public interface RecyclerViewItemClickListener {
        void onItemClick(View view, int i);
    }

    public UserMedalsAdapter(IRequestHost iRequestHost, Context context, List<AnchorMedal> list) {
        this.f20071c = context;
        this.d = iRequestHost;
        this.f20070a = LayoutInflater.from(context);
        this.b = list;
    }

    public View a() {
        return this.f20070a.inflate(R.layout.item_user_anchor_medal, (ViewGroup) null);
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
            if (StringUtils.d(anchorMedal.pic)) {
                return;
            }
            ImageLoader.a(this.d, anchorMedal.pic).b(2131230936).a(medalViewHolder.f20072a);
            medalViewHolder.b.setTag(Integer.valueOf(i));
        }
    }

    public void a(RecyclerViewItemClickListener recyclerViewItemClickListener) {
        this.e = recyclerViewItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int intValue = ((Integer) view.getTag()).intValue();
        if (this.e != null) {
            EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PROFILE_MEDAL_CLICK);
            this.e.onItemClick(view, intValue);
        }
    }
}
