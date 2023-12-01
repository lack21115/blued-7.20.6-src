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
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.UserGift;
import com.soft.blued.utils.StringUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/UserProfileGiftdapter.class */
public class UserProfileGiftdapter extends RecyclerView.Adapter<GiftViewHolder> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f20074a;
    private List<UserGift.Gift> b;

    /* renamed from: c  reason: collision with root package name */
    private Context f20075c;
    private IRequestHost d;
    private RecyclerViewItemClickListener e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/UserProfileGiftdapter$GiftViewHolder.class */
    public class GiftViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f20076a;
        public LinearLayout b;

        public GiftViewHolder(View view) {
            super(view);
            this.f20076a = (ImageView) view.findViewById(R.id.img_medal);
            this.b = (LinearLayout) view.findViewById(2131367715);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/UserProfileGiftdapter$RecyclerViewItemClickListener.class */
    public interface RecyclerViewItemClickListener {
        void onItemClick(View view, int i);
    }

    public UserProfileGiftdapter(IRequestHost iRequestHost, Context context, List<UserGift.Gift> list) {
        this.f20075c = context;
        this.d = iRequestHost;
        this.f20074a = LayoutInflater.from(context);
        this.b = list;
    }

    public View a() {
        return this.f20074a.inflate(R.layout.item_user_profile_gift, (ViewGroup) null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public GiftViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View a2 = a();
        a2.setOnClickListener(this);
        return new GiftViewHolder(a2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(GiftViewHolder giftViewHolder, int i) {
        if (giftViewHolder != null) {
            UserGift.Gift gift = this.b.get(i);
            if (StringUtils.d(gift.icon)) {
                return;
            }
            ImageLoader.a(this.d, gift.icon).a(giftViewHolder.f20076a);
            giftViewHolder.b.setTag(Integer.valueOf(i));
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
        if (this.e != null) {
            int i = 0;
            try {
                i = ((Integer) view.getTag()).intValue();
            } catch (Exception e) {
            }
            this.e.onItemClick(view, i);
        }
    }
}
