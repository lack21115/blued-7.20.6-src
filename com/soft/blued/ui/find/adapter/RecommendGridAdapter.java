package com.soft.blued.ui.find.adapter;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.anythink.expressad.video.dynview.a.a;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.soft.blued.R;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/RecommendGridAdapter.class */
public class RecommendGridAdapter extends BaseAdapter {
    private static final int[] b = {R.id.header_view1, R.id.header_view2, R.id.header_view3, R.id.header_view4};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f16422c = {R.id.role_view1, R.id.role_view2, R.id.role_view3, R.id.role_view4};
    private static final int[] d = {R.id.attention_status1, R.id.attention_status2, R.id.attention_status3, R.id.attention_status4};
    private static final int[] e = {R.id.bottom_bg1, R.id.bottom_bg2, R.id.bottom_bg3, R.id.bottom_bg4};
    private Context f;
    private LayoutInflater g;
    private ActivityFragmentActive h;
    private Dialog i;
    private LoadOptions j;
    private int l;
    private int m;
    private int n;
    private View.OnClickListener o;

    /* renamed from: a  reason: collision with root package name */
    public List<BluedRecommendUsers> f16423a = new ArrayList();
    private HashSet<String> k = new HashSet<>();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/RecommendGridAdapter$ViewHolder.class */
    class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f16424a;
        public ImageView[] b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView[] f16425c;
        public ImageView[] d;
        public ImageView[] e;

        private ViewHolder() {
            this.b = new ImageView[RecommendGridAdapter.this.m];
            this.f16425c = new ImageView[RecommendGridAdapter.this.m];
            this.d = new ImageView[RecommendGridAdapter.this.m];
            this.e = new ImageView[RecommendGridAdapter.this.m];
        }
    }

    public RecommendGridAdapter(Context context, int i, View.OnClickListener onClickListener, ActivityFragmentActive activityFragmentActive, Dialog dialog) {
        this.h = null;
        this.i = null;
        this.m = 4;
        this.f = context;
        if (i != 0) {
            this.m = i;
        }
        int E = LiveFloatManager.a().E();
        int a2 = DensityUtils.a(context, 6.0f);
        int i2 = this.m;
        this.n = (E - (a2 * (i2 + 1))) / i2;
        this.o = onClickListener;
        this.h = activityFragmentActive;
        this.i = dialog;
        this.g = LayoutInflater.from(context);
        int i3 = context.getResources().getDisplayMetrics().widthPixels;
        LoadOptions loadOptions = new LoadOptions();
        this.j = loadOptions;
        loadOptions.d = 2131237314;
        this.j.b = 2131237314;
        int i4 = i3 >> 1;
        this.j.a(i4, i4);
    }

    public void a(List<BluedRecommendUsers> list) {
        this.k.clear();
        this.f16423a.clear();
        this.l = 0;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                BluedRecommendUsers bluedRecommendUsers = list.get(i);
                if (!this.k.contains(bluedRecommendUsers.uid)) {
                    this.f16423a.add(bluedRecommendUsers);
                    this.k.add(bluedRecommendUsers.uid);
                }
            }
        }
        notifyDataSetChanged();
    }

    public void b(List<BluedRecommendUsers> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                notifyDataSetChanged();
                return;
            }
            BluedRecommendUsers bluedRecommendUsers = list.get(i2);
            if (this.k.contains(bluedRecommendUsers.uid)) {
                this.l++;
            } else {
                this.f16423a.add(bluedRecommendUsers);
                this.k.add(bluedRecommendUsers.uid);
            }
            i = i2 + 1;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return (int) Math.ceil(this.f16423a.size() / this.m);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        int i2;
        if (view == null) {
            ViewHolder viewHolder2 = new ViewHolder();
            int i3 = this.m;
            if (i3 == 3) {
                view = this.g.inflate(R.layout.fragment_recommend_gird_3_item, viewGroup, false);
            } else if (i3 == 4) {
                view = this.g.inflate(R.layout.fragment_recommend_gird_4_item, viewGroup, false);
            }
            viewHolder2.f16424a = view.findViewById(2131366742);
            viewHolder2.f16424a.setLayoutParams(new FrameLayout.LayoutParams(-1, this.n));
            viewHolder2.f16424a.requestLayout();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= this.m) {
                    break;
                }
                viewHolder2.b[i5] = (ImageView) view.findViewById(f16422c[i5]);
                viewHolder2.f16425c[i5] = (ImageView) view.findViewById(d[i5]);
                viewHolder2.e[i5] = (ImageView) view.findViewById(b[i5]);
                viewHolder2.d[i5] = (ImageView) view.findViewById(e[i5]);
                i4 = i5 + 1;
            }
            view.setTag(viewHolder2);
            viewHolder = viewHolder2;
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        int size = this.f16423a.size();
        int i6 = this.m;
        int i7 = size - (i * i6);
        int i8 = i6;
        if (i7 < i6) {
            i8 = i7;
        }
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= i8) {
                break;
            }
            viewHolder.f16425c[i10].setVisibility(0);
            viewHolder.b[i10].setVisibility(0);
            viewHolder.e[i10].setVisibility(0);
            viewHolder.d[i10].setVisibility(0);
            BluedRecommendUsers bluedRecommendUsers = this.f16423a.get((i * i8) + i10);
            ImageWrapper b2 = ImageLoader.a(this.h, AvatarUtils.a(0, bluedRecommendUsers.avatar)).b(2131237314);
            if (this.m == 4) {
                b2.c();
            }
            b2.a(viewHolder.e[i10]);
            if (TextUtils.isEmpty(bluedRecommendUsers.role)) {
                viewHolder.b[i10].setImageResource(R.drawable.role_other);
            } else {
                String language = BlueAppLocal.c().getLanguage();
                if (TextUtils.isEmpty(language) || !language.toLowerCase().equals(a.V)) {
                    if ("0".equals(bluedRecommendUsers.role)) {
                        viewHolder.b[i10].setImageResource(R.drawable.role_b);
                    } else if ("1".equals(bluedRecommendUsers.role)) {
                        viewHolder.b[i10].setImageResource(R.drawable.role_t);
                    } else if ("0.5".equals(bluedRecommendUsers.role)) {
                        viewHolder.b[i10].setImageResource(R.drawable.role_v);
                    } else {
                        viewHolder.b[i10].setImageResource(R.drawable.role_other);
                    }
                } else if ("0".equals(bluedRecommendUsers.role)) {
                    viewHolder.b[i10].setImageResource(R.drawable.role_0);
                } else if ("1".equals(bluedRecommendUsers.role)) {
                    viewHolder.b[i10].setImageResource(R.drawable.role_1);
                } else if ("0.5".equals(bluedRecommendUsers.role)) {
                    viewHolder.b[i10].setImageResource(R.drawable.role_5);
                } else if ("-1".equals(bluedRecommendUsers.role)) {
                    viewHolder.b[i10].setImageResource(R.drawable.role_other);
                } else {
                    viewHolder.b[i10].setImageResource(R.drawable.role_other);
                }
            }
            if (!bluedRecommendUsers.isGridVisibility) {
                bluedRecommendUsers.isGridVisibility = true;
            }
            viewHolder.e[i10].setTag(Integer.valueOf((this.m * i) + i10));
            viewHolder.e[i10].setOnClickListener(this.o);
            if (StringUtils.d(bluedRecommendUsers.relationship)) {
                viewHolder.f16425c[i10].setImageResource(2131237251);
            } else if ("0".equals(bluedRecommendUsers.relationship)) {
                viewHolder.f16425c[i10].setImageResource(2131237251);
            } else {
                viewHolder.f16425c[i10].setImageResource(2131237254);
            }
            i9 = i10 + 1;
        }
        for (i2 = i8; i2 < this.m; i2++) {
            viewHolder.f16425c[i2].setVisibility(4);
            viewHolder.b[i2].setVisibility(4);
            viewHolder.e[i2].setVisibility(4);
            viewHolder.d[i2].setVisibility(4);
            viewHolder.e[i2].setOnClickListener(null);
        }
        return view;
    }
}
