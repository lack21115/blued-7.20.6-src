package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.chat.utils.BlueAppChatLocal;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.DistanceUtils;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.utils.StringUtils;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/RecommendedGroupAdapter.class */
public class RecommendedGroupAdapter extends RecyclerView.Adapter<GroupViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f30130a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private List<BluedGroupLists> f30131c;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/RecommendedGroupAdapter$GroupViewHolder.class */
    public class GroupViewHolder extends RecyclerView.ViewHolder {
        private TextView b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f30134c;
        private TextView d;
        private ImageView e;
        private ConstraintLayout f;
        private ImageView g;

        public GroupViewHolder(View view) {
            super(view);
            this.f = (ConstraintLayout) view.findViewById(R.id.cl_root_view);
            this.b = (TextView) view.findViewById(2131371285);
            this.f30134c = (TextView) view.findViewById(R.id.tv_group_name);
            this.d = (TextView) view.findViewById(R.id.tv_group_size);
            this.e = (ImageView) view.findViewById(R.id.iv_verify_icon);
            this.g = (ImageView) view.findViewById(R.id.aariv_group_avatar);
        }
    }

    public RecommendedGroupAdapter(Context context, IRequestHost iRequestHost, List<BluedGroupLists> list) {
        this.f30130a = context;
        this.b = iRequestHost;
        this.f30131c = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public GroupViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        try {
            return new GroupViewHolder(LayoutInflater.from(this.f30130a).inflate(R.layout.item_recommended_group, viewGroup, false));
        } catch (Exception e) {
            return null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(GroupViewHolder groupViewHolder, int i) {
        final BluedGroupLists bluedGroupLists = this.f30131c.get(i);
        if (groupViewHolder == null || bluedGroupLists == null) {
            return;
        }
        if (TextUtils.isEmpty(bluedGroupLists.groups_distance)) {
            groupViewHolder.b.setVisibility(4);
        } else {
            groupViewHolder.b.setText(DistanceUtils.b(bluedGroupLists.groups_distance, BlueAppLocal.c(), false));
            groupViewHolder.b.setVisibility(0);
        }
        if (BlueAppChatLocal.isZh()) {
            if (TextUtils.isEmpty(bluedGroupLists.groups_members_count)) {
                groupViewHolder.d.setVisibility(4);
            } else {
                TextView textView = groupViewHolder.d;
                textView.setText(StringUtils.a(bluedGroupLists.groups_members_count) + "人");
                groupViewHolder.d.setVisibility(0);
            }
        } else if (TextUtils.isEmpty(bluedGroupLists.groups_members_count)) {
            groupViewHolder.d.setVisibility(4);
        } else {
            groupViewHolder.d.setText(StringUtils.a(bluedGroupLists.groups_members_count));
            groupViewHolder.d.setVisibility(0);
        }
        if (TextUtils.isEmpty(bluedGroupLists.groups_name)) {
            groupViewHolder.f30134c.setVisibility(4);
        } else {
            groupViewHolder.f30134c.setText(bluedGroupLists.groups_name);
            groupViewHolder.f30134c.setVisibility(0);
        }
        ImageLoader.a(this.b, bluedGroupLists.groups_avatar).b(R.drawable.group_default_head).c().a(groupViewHolder.g);
        UserInfoHelper.a(groupViewHolder.e, bluedGroupLists.vbadge, 3);
        groupViewHolder.f.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.RecommendedGroupAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                InstantLog.a("groups_recommend");
                GroupInfoFragment.a(RecommendedGroupAdapter.this.f30130a, bluedGroupLists.groups_gid, "recommend");
            }
        });
    }

    public void a(List<BluedGroupLists> list) {
        this.f30131c.clear();
        if (list != null) {
            this.f30131c.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<BluedGroupLists> list = this.f30131c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
