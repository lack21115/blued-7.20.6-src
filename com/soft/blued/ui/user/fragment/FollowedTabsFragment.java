package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.user.observer.FollowAndFansSelectedTabObserver;
import com.soft.blued.ui.user.observer.SecretlyFollowedObserver;
import com.soft.blued.user.BluedConfig;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/FollowedTabsFragment.class */
public class FollowedTabsFragment extends PreloadFragment implements FollowAndFansSelectedTabObserver.IFollowAndFansSelectedTabObserver, SecretlyFollowedObserver.ISecretlyFollowedObserver {
    private Context k;
    private View l;
    private LayoutInflater m;
    private ViewPager n;
    private NormalFollowedFragment o;
    private SecretlyFollowedFragment p;
    private MyAdapter q;
    private TextView s;
    private TextView t;
    private ArrayList<BaseFragment> r = new ArrayList<>();
    public String j = "";

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/FollowedTabsFragment$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return FollowedTabsFragment.this.r.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return FollowedTabsFragment.this.p;
            }
            return FollowedTabsFragment.this.o;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return "";
        }
    }

    private void h() {
        TextView textView = (TextView) this.l.findViewById(R.id.tv_normal_followed);
        this.s = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.FollowedTabsFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FollowedTabsFragment.this.n.setCurrentItem(0);
            }
        });
        TextView textView2 = (TextView) this.l.findViewById(R.id.tv_secret_followed);
        this.t = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.FollowedTabsFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FollowedTabsFragment.this.n.setCurrentItem(1);
            }
        });
        ViewPager viewPager = (ViewPager) this.l.findViewById(R.id.main_find_viewpager);
        this.n = viewPager;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.user.fragment.FollowedTabsFragment.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i == 0) {
                    FollowedTabsFragment.this.s.setTextColor(BluedSkinUtils.a(FollowedTabsFragment.this.k, 2131102254));
                    FollowedTabsFragment.this.t.setTextColor(BluedSkinUtils.a(FollowedTabsFragment.this.k, 2131102260));
                } else if (i != 1) {
                } else {
                    FollowedTabsFragment.this.s.setTextColor(BluedSkinUtils.a(FollowedTabsFragment.this.k, 2131102260));
                    FollowedTabsFragment.this.t.setTextColor(BluedSkinUtils.a(FollowedTabsFragment.this.k, 2131102254));
                }
            }
        });
        this.p = new SecretlyFollowedFragment();
        this.o = new NormalFollowedFragment();
        this.r.clear();
        this.r.add(this.p);
        this.r.add(this.o);
        Bundle bundle = new Bundle();
        bundle.putString("uid", this.j);
        this.p.setArguments(bundle);
        this.o.setArguments(bundle);
        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager());
        this.q = myAdapter;
        this.n.setAdapter(myAdapter);
    }

    @Override // com.soft.blued.ui.user.observer.FollowAndFansSelectedTabObserver.IFollowAndFansSelectedTabObserver
    public void a(int i) {
    }

    @Override // com.soft.blued.ui.user.observer.SecretlyFollowedObserver.ISecretlyFollowedObserver
    public void a(int i, int i2) {
        String string = this.k.getResources().getString(R.string.follow_secretly);
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 2 && BluedConfig.a().g().is_secretly_followed != 1 && i <= 0) {
            this.t.setText(string);
            return;
        }
        TextView textView = this.t;
        textView.setText(string + " " + i + BridgeUtil.SPLIT_MARK + i2);
    }

    @Override // com.blued.android.framework.activity.PreloadFragment
    public void a(View view) {
        FragmentActivity activity = getActivity();
        this.k = activity;
        this.l = view;
        LayoutInflater from = LayoutInflater.from(activity);
        this.m = from;
        ((ViewGroup) this.l).addView(from.inflate(R.layout.fragment_followed_tabs, (ViewGroup) null));
        this.j = getArguments().getString("uid");
        SecretlyFollowedObserver.a().a(this);
        FollowAndFansSelectedTabObserver.a().a(this);
        h();
    }

    @Override // com.soft.blued.ui.user.observer.FollowAndFansSelectedTabObserver.IFollowAndFansSelectedTabObserver
    public void b(int i) {
        if (i < 0 || i >= this.n.getChildCount()) {
            return;
        }
        this.n.setCurrentItem(i);
    }

    @Override // com.blued.android.framework.activity.PreloadFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SecretlyFollowedObserver.a().b(this);
        FollowAndFansSelectedTabObserver.a().b(this);
    }

    @Override // com.blued.android.framework.activity.HomeTabFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
