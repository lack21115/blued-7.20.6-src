package com.soft.blued.ui.find.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.swipecard.SwipeFlingAdapterView;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/SwipeCardAdapter.class */
public class SwipeCardAdapter extends BaseAdapter {
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private SwipeFlingAdapterView f16455c;
    private View.OnClickListener d;
    private ActivityFragmentActive e;
    private Dialog f;
    private int i;
    private int m;

    /* renamed from: a  reason: collision with root package name */
    public List<BluedRecommendUsers> f16454a = new ArrayList();
    private List<BluedRecommendUsers> g = new ArrayList();
    private int h = 0;
    private boolean j = false;
    private SwipeCardListener k = null;
    private HashSet<String> l = new HashSet<>();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/SwipeCardAdapter$SwipeCardListener.class */
    public interface SwipeCardListener {
        void a();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/SwipeCardAdapter$ViewHolder.class */
    class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f16459a;
        public TextView b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16460c;
        public TextView d;
        public ImageView e;
        public TextView f;
        public ImageView g;
        public ImageView h;
        public RelativeLayout i;
        public ImageView j;
        public TextView k;
        public ImageView l;
        public ImageView m;

        private ViewHolder() {
            this.f16459a = null;
            this.b = null;
            this.f16460c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
        }
    }

    public SwipeCardAdapter(Context context, SwipeFlingAdapterView swipeFlingAdapterView, View.OnClickListener onClickListener, ActivityFragmentActive activityFragmentActive, Dialog dialog) {
        this.i = 0;
        this.b = context;
        this.f16455c = swipeFlingAdapterView;
        this.d = onClickListener;
        this.e = activityFragmentActive;
        this.f = dialog;
        this.i = swipeFlingAdapterView.getVisibleCount();
    }

    public int a() {
        return this.h;
    }

    public void a(int i) {
        if (i > -1) {
            this.g.size();
        }
    }

    public void a(SwipeCardListener swipeCardListener) {
        this.k = swipeCardListener;
    }

    public void a(List<BluedRecommendUsers> list) {
        this.l.clear();
        this.f16454a.clear();
        this.m = 0;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                BluedRecommendUsers bluedRecommendUsers = list.get(i);
                if (!this.l.contains(bluedRecommendUsers.uid)) {
                    this.f16454a.add(bluedRecommendUsers);
                    this.l.add(bluedRecommendUsers.uid);
                }
            }
        }
        this.f16455c.setTag(R.id.current_index, Integer.valueOf(a()));
        this.f16455c.setTag(R.id.total_szie, Integer.valueOf(this.f16454a.size()));
        c(this.h);
    }

    public void a(boolean z) {
        this.j = z;
    }

    public void b() {
        int i = this.h - 1;
        this.h = i;
        c(i);
    }

    public void b(int i) {
        List<BluedRecommendUsers> list;
        if (i < 0 || (list = this.f16454a) == null || i >= list.size()) {
            return;
        }
        InstantLog.c("target_from_guide", this.f16454a.get(i).uid);
    }

    public void b(List<BluedRecommendUsers> list) {
        if (list != null && list.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                BluedRecommendUsers bluedRecommendUsers = list.get(i2);
                if (this.l.contains(bluedRecommendUsers.uid)) {
                    this.m++;
                } else {
                    this.f16454a.add(bluedRecommendUsers);
                    this.l.add(bluedRecommendUsers.uid);
                }
                i = i2 + 1;
            }
        }
        this.f16455c.setTag(R.id.current_index, Integer.valueOf(a()));
        this.f16455c.setTag(R.id.total_szie, Integer.valueOf(this.f16454a.size()));
        c(this.h);
    }

    public void c() {
        int i = this.h + 1;
        this.h = i;
        Logger.b("swipecard", "pointerForward", Integer.valueOf(i));
        c(this.h);
        if (this.k == null || this.f16454a.size() - 1 != this.h || this.j) {
            return;
        }
        this.k.a();
    }

    public void c(int i) {
        int i2;
        int i3;
        this.h = i;
        if (i < 0 || i >= this.f16454a.size()) {
            return;
        }
        this.g.clear();
        this.g.add(this.f16454a.get(this.h));
        int i4 = this.h;
        while (true) {
            int i5 = i4 + 1;
            i2 = this.h;
            if (i5 > (this.i / 2) + i2) {
                break;
            }
            i4 = i5;
            if (i5 < this.f16454a.size()) {
                this.g.add(this.f16454a.get(i5));
                i4 = i5;
            }
        }
        while (true) {
            i2--;
            i3 = this.h;
            if (i2 < i3 - (this.i / 2)) {
                break;
            } else if (i2 >= 0) {
                this.g.add(this.f16454a.get(i2));
            }
        }
        SwipeFlingAdapterView swipeFlingAdapterView = this.f16455c;
        if (swipeFlingAdapterView != null) {
            swipeFlingAdapterView.setTag(R.id.current_index, Integer.valueOf(i3));
            this.f16455c.setTag(R.id.total_szie, Integer.valueOf(this.f16454a.size()));
        }
        notifyDataSetChanged();
        final BluedRecommendUsers bluedRecommendUsers = this.f16454a.get(this.h);
        this.f16455c.post(new Runnable() { // from class: com.soft.blued.ui.find.adapter.SwipeCardAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                if (SwipeCardAdapter.this.f16455c.getVisibility() != 0 || bluedRecommendUsers.isSwipeVisibility) {
                    return;
                }
                bluedRecommendUsers.isSwipeVisibility = true;
            }
        });
    }

    @Override // android.widget.Adapter
    /* renamed from: d */
    public BluedRecommendUsers getItem(int i) {
        List<BluedRecommendUsers> list = this.g;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.g.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.g.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = LayoutInflater.from(this.b).inflate(R.layout.fragment_recommend_card_view, viewGroup, false);
            viewHolder.f16459a = (TextView) view2.findViewById(R.id.card_name);
            viewHolder.e = (ImageView) view2.findViewById(R.id.card_role);
            viewHolder.f16460c = (TextView) view2.findViewById(R.id.card_last_operate);
            viewHolder.b = (TextView) view2.findViewById(R.id.card_distance);
            viewHolder.h = (ImageView) view2.findViewById(R.id.portrait);
            viewHolder.d = (TextView) view2.findViewById(R.id.card_index);
            viewHolder.f = (TextView) view2.findViewById(R.id.card_city);
            viewHolder.g = (ImageView) view2.findViewById(R.id.close_btn);
            viewHolder.j = (ImageView) view2.findViewById(R.id.card_icon_attention);
            viewHolder.k = (TextView) view2.findViewById(R.id.card_tv_attention);
            viewHolder.i = (RelativeLayout) view2.findViewById(R.id.attention_lay);
            viewHolder.l = (ImageView) view2.findViewById(R.id.img_verify);
            viewHolder.m = (ImageView) view2.findViewById(R.id.img_blued_medal);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        final BluedRecommendUsers bluedRecommendUsers = this.g.get(i);
        viewHolder.g.setOnClickListener(this.d);
        ImageLoader.a(this.e, AvatarUtils.a(0, bluedRecommendUsers.avatar)).c().b(2131237310).a(viewHolder.h);
        viewHolder.f16459a.setText(bluedRecommendUsers.name);
        if ("0.5".equals(bluedRecommendUsers.role)) {
            viewHolder.e.setImageResource(R.drawable.icon_userinfo_role_5);
        } else if ("1".equals(bluedRecommendUsers.role)) {
            viewHolder.e.setImageResource(R.drawable.icon_userinfo_role_1);
        } else if ("0".equals(bluedRecommendUsers.role)) {
            viewHolder.e.setImageResource(R.drawable.icon_userinfo_role_0);
        } else {
            viewHolder.e.setImageResource(R.drawable.icon_userinfo_role_other);
        }
        UserRelationshipUtils.a(bluedRecommendUsers.relationship, viewHolder.k, viewHolder.j);
        if (!StringUtils.d(bluedRecommendUsers.distance)) {
            viewHolder.b.setText(DistanceUtils.a(bluedRecommendUsers.distance, BlueAppLocal.c(), true));
        }
        if (!StringUtils.d(bluedRecommendUsers.last_operate)) {
            viewHolder.f16460c.setText(TimeAndDateUtils.f(this.b, TimeAndDateUtils.c(bluedRecommendUsers.last_operate)));
        }
        viewHolder.d.setText(String.format(this.b.getString(R.string.card_user_index), bluedRecommendUsers.age, StringUtils.a(bluedRecommendUsers.height, BlueAppLocal.c(), true), StringUtils.b(bluedRecommendUsers.weight, BlueAppLocal.c(), true)));
        viewHolder.f.setText(AreaUtils.getAreaTxt(bluedRecommendUsers.city_settled, BlueAppLocal.c()));
        UserInfoHelper.a(viewHolder.l, bluedRecommendUsers.vbadge, 1);
        if (StringUtils.d(bluedRecommendUsers.blued_pic)) {
            viewHolder.m.setVisibility(8);
        } else {
            viewHolder.m.setVisibility(0);
            ImageLoader.a(this.e, bluedRecommendUsers.blued_pic).b((int) R.drawable.blued_medal_default).a(viewHolder.m);
        }
        viewHolder.i.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.SwipeCardAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                if ("0".equals(bluedRecommendUsers.relationship) || "2".equals(bluedRecommendUsers.relationship)) {
                    InstantLog.a("attention_from_guide");
                    if (UserInfoHelper.a(bluedRecommendUsers.relationship)) {
                        return;
                    }
                    try {
                        UserRelationshipUtils.a(SwipeCardAdapter.this.b, new UserRelationshipUtils.IAddOrRemoveAttentionDone() { // from class: com.soft.blued.ui.find.adapter.SwipeCardAdapter.2.1
                            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
                            public void a() {
                                DialogUtils.a(SwipeCardAdapter.this.f);
                            }

                            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
                            public void a(String str) {
                                bluedRecommendUsers.relationship = str;
                                SwipeCardAdapter.this.f16454a.get(SwipeCardAdapter.this.h).relationship = str;
                                SwipeCardAdapter.this.f16455c.f14973a = null;
                                SwipeCardAdapter.this.notifyDataSetChanged();
                            }

                            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
                            public void b() {
                                DialogUtils.b(SwipeCardAdapter.this.f);
                            }

                            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
                            public void b(String str) {
                                bluedRecommendUsers.relationship = str;
                                SwipeCardAdapter.this.f16454a.get(SwipeCardAdapter.this.h).relationship = str;
                                SwipeCardAdapter.this.f16455c.f14973a = null;
                                SwipeCardAdapter.this.notifyDataSetChanged();
                            }

                            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
                            public void c() {
                                DialogUtils.b(SwipeCardAdapter.this.f);
                            }
                        }, bluedRecommendUsers.uid, bluedRecommendUsers.relationship, "", SwipeCardAdapter.this.e, true);
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.g.isEmpty();
    }
}
