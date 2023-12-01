package com.soft.blued.ui.group;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.SearchView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.ui.group.model.BluedGroupCheck;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupFragment.class */
public class GroupFragment extends BaseFragment implements View.OnClickListener {
    private static int A = 3;

    /* renamed from: a  reason: collision with root package name */
    public static int f17089a = 0;

    /* renamed from: c  reason: collision with root package name */
    public static String f17090c = "ISNEARBY";
    public static String d = "NEARBYGROUP1";
    public static String e = "NEARBYGROUP2";
    public BluedGroupCheck.GroupFailureReason b;
    GroupFragmentRecommend f;
    GroupFragmentNear g;
    UserGroupListsFragment h;
    private View j;
    private Context k;
    private LayoutInflater l;
    private View m;
    private SearchView n;
    private TextView o;
    private TextView p;
    private LinearLayout q;
    private View r;
    private ViewGroup s;
    private TextView t;
    private ImageView u;
    private ImageView v;
    private Bundle w;
    private boolean x;
    private int y;
    private ViewPager z;
    private String i = GroupFragment.class.getSimpleName();
    private ViewPager.OnPageChangeListener B = new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.group.GroupFragment.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            GroupFragment.this.y = i;
            int unused = GroupFragment.this.y;
        }
    };

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupFragment$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {
        private String[] b;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.b = new String[]{GroupFragment.this.k.getResources().getString(R.string.group_recommend), GroupFragment.this.k.getResources().getString(R.string.group_near), GroupFragment.this.k.getResources().getString(R.string.group_mine)};
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return GroupFragment.A;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return GroupFragment.this.h;
                }
                return GroupFragment.this.g;
            }
            return GroupFragment.this.f;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.b[i];
        }
    }

    private void b() {
        this.r = this.j.findViewById(2131370694);
        ViewGroup viewGroup = (ViewGroup) this.j.findViewById(R.id.ctt_right_menu);
        this.s = viewGroup;
        viewGroup.setVisibility(8);
        this.t = (TextView) this.j.findViewById(R.id.ctt_right_text);
        ImageView imageView = (ImageView) this.j.findViewById(2131363120);
        this.v = imageView;
        imageView.setImageDrawable(BluedSkinUtils.b(this.k, 2131233902));
        ImageView imageView2 = (ImageView) this.j.findViewById(2131363126);
        this.u = imageView2;
        imageView2.setVisibility(8);
        this.t.setText(getString(R.string.group_creates));
        this.t.setVisibility(0);
        this.v.setOnClickListener(this);
        this.t.setOnClickListener(this);
    }

    private void c() {
        Bundle arguments = getArguments();
        this.w = arguments;
        if (arguments != null) {
            this.x = arguments.getBoolean(f17090c);
        }
        this.l = (LayoutInflater) this.k.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (this.x) {
            f17089a = 0;
        } else {
            f17089a = 1;
        }
        View inflate = this.l.inflate(R.layout.fragment_group_lists_header, (ViewGroup) null);
        this.m = inflate;
        SearchView findViewById = inflate.findViewById(R.id.group_search);
        this.n = findViewById;
        findViewById.setMaskLayerOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.GroupFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                TerminalActivity.d(GroupFragment.this.k, GroupSearchFragment.class, (Bundle) null);
            }
        });
        this.o = (TextView) this.m.findViewById(R.id.tv_same_city);
        this.p = (TextView) this.m.findViewById(R.id.tv_recommended_category);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.m.findViewById(R.id.ll_group_options);
        this.q = linearLayout;
        linearLayout.setVisibility(8);
    }

    private void d() {
        this.b = new BluedGroupCheck.GroupFailureReason();
        this.z = (ViewPager) this.j.findViewById(R.id.group_list_viewpager);
        this.z.setAdapter(new MyAdapter(getChildFragmentManager()));
        this.z.setOnPageChangeListener(this.B);
        this.z.setOffscreenPageLimit(2);
        if (f17089a == 0) {
            this.z.setCurrentItem(1);
        }
        ((TabPageIndicatorWithDot) this.j.findViewById(R.id.vp_indicator)).setViewPager(this.z);
        A = 3;
        this.f = new GroupFragmentRecommend();
        this.g = new GroupFragmentNear();
        if (f17089a == 0) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(GroupFragmentNear.f17094a, this.w.getSerializable(d));
            bundle.putSerializable(GroupFragmentNear.b, this.w.getSerializable(e));
            this.g.setArguments(bundle);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("UID", UserInfo.getInstance().getLoginUserInfo().getUid());
        bundle2.putBoolean("hidetitle", true);
        UserGroupListsFragment userGroupListsFragment = new UserGroupListsFragment();
        this.h = userGroupListsFragment;
        userGroupListsFragment.setArguments(bundle2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131363135) {
        } else {
            TerminalActivity.d(getActivity(), GroupCreateFragment.class, (Bundle) null);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.k = getActivity();
        View view = this.j;
        if (view == null) {
            this.j = layoutInflater.inflate(R.layout.fragment_groups_tab3_list, viewGroup, false);
            b();
            c();
            d();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.j.getParent()).removeView(this.j);
        }
        return this.j;
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
