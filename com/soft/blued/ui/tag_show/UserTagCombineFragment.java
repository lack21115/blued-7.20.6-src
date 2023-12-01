package com.soft.blued.ui.tag_show;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.community.ui.topic.fragment.SuperTopicDetailFragment;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.TabPageIndicatorWithDot;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/tag_show/UserTagCombineFragment.class */
public class UserTagCombineFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public static String f20035a = "TAG";
    public static String b = "TAGID";

    /* renamed from: c  reason: collision with root package name */
    public static String f20036c = "tab";
    public String d;
    public String e;
    public int f = 0;
    private Context g;
    private View h;
    private CommonTopTitleNoTrans i;
    private ViewPager j;
    private TagUserFragment k;
    private TagGroupFragment l;
    private SuperTopicDetailFragment m;
    private TabPageIndicatorWithDot n;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/tag_show/UserTagCombineFragment$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {
        private String[] b;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.b = UserTagCombineFragment.this.a();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.b.length;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i != 0) {
                return null;
            }
            return UserTagCombineFragment.this.k;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.b[i];
        }
    }

    public static void a(Context context, String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putString(b, str);
        bundle.putString(f20035a, str2);
        bundle.putInt(f20036c, i);
        TerminalActivity.d(context, UserTagCombineFragment.class, bundle);
    }

    private void b() {
        Bundle bundle = new Bundle();
        bundle.putString(TagUserFragment.b, this.e);
        bundle.putString(TagUserFragment.f20028a, this.d);
        TagUserFragment tagUserFragment = new TagUserFragment();
        this.k = tagUserFragment;
        tagUserFragment.setArguments(bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putString(TagGroupFragment.g, this.d);
        TagGroupFragment tagGroupFragment = new TagGroupFragment();
        this.l = tagGroupFragment;
        tagGroupFragment.setArguments(bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putBoolean("if_hide_title", true);
        SuperTopicDetailFragment superTopicDetailFragment = new SuperTopicDetailFragment();
        this.m = superTopicDetailFragment;
        superTopicDetailFragment.setArguments(bundle3);
    }

    private void c() {
        this.j = (ViewPager) this.h.findViewById(R.id.main_find_viewpager);
        this.j.setAdapter(new MyAdapter(getChildFragmentManager()));
        this.j.setOffscreenPageLimit(2);
        TabPageIndicatorWithDot tabPageIndicatorWithDot = (TabPageIndicatorWithDot) this.h.findViewById(R.id.indicator);
        this.n = tabPageIndicatorWithDot;
        tabPageIndicatorWithDot.setViewPager(this.j);
        this.j.setCurrentItem(this.f);
    }

    private void d() {
        CommonTopTitleNoTrans findViewById = this.h.findViewById(R.id.top_title);
        this.i = findViewById;
        findViewById.a();
        this.i.setCenterText("");
        this.i.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.tag_show.UserTagCombineFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                UserTagCombineFragment.this.getActivity().finish();
            }
        });
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.d = arguments.getString(f20035a);
        this.e = arguments.getString(b);
        int i = arguments.getInt(f20036c);
        this.f = i;
        if (i < 0 || i >= 2) {
            this.f = 0;
        }
        if (TextUtils.isEmpty(this.d)) {
            return;
        }
        this.i.setCenterText(this.d);
    }

    public String[] a() {
        return new String[]{this.g.getResources().getString(R.string.nearby_feed)};
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.g = getActivity();
        View view = this.h;
        if (view == null) {
            this.h = layoutInflater.inflate(R.layout.fragment_tab_show, viewGroup, false);
            d();
            b();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.h.getParent()).removeView(this.h);
        }
        return this.h;
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
