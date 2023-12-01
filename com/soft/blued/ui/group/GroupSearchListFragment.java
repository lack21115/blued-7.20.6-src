package com.soft.blued.ui.group;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchIndexablesContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.utils.ClickUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.TabPageIndicatorWithDot;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupSearchListFragment.class */
public class GroupSearchListFragment extends BaseFragment implements View.OnClickListener {
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f17161c;
    private TabPageIndicatorWithDot d;
    private ViewPager e;
    private MyPagerAdapter f;
    private String g;

    /* renamed from: a  reason: collision with root package name */
    private String f17160a = GroupSearchListFragment.class.getSimpleName();
    private ViewPager.OnPageChangeListener h = new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.group.GroupSearchListFragment.1
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
        }
    };

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupSearchListFragment$MyPagerAdapter.class */
    public class MyPagerAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public GroupSearchResultFragment f17163a;
        public GroupSearchResultFragment b;
        private final String[] d;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.d = new String[]{GroupSearchListFragment.this.getResources().getString(R.string.groups_search_nearby), GroupSearchListFragment.this.getResources().getString(R.string.groups_search_hot)};
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.d.length;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i == 0) {
                if (this.f17163a == null) {
                    this.f17163a = GroupSearchResultFragment.a(i, GroupSearchListFragment.this.g);
                }
                return this.f17163a;
            } else if (i != 1) {
                return null;
            } else {
                if (this.b == null) {
                    this.b = GroupSearchResultFragment.a(i, GroupSearchListFragment.this.g);
                }
                return this.b;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.d[i];
        }
    }

    private void a() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.g = arguments.getString(SearchIndexablesContract.RawData.COLUMN_KEYWORDS);
        }
    }

    public static void a(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(SearchIndexablesContract.RawData.COLUMN_KEYWORDS, str);
        TerminalActivity.d(context, GroupSearchListFragment.class, bundle);
    }

    private void b() {
        CommonTopTitleNoTrans findViewById = this.f17161c.findViewById(R.id.top_title);
        findViewById.a();
        findViewById.setCenterText(this.g);
        findViewById.setLeftClickListener(this);
        ((TextView) findViewById.findViewById(2131363108)).setOnTouchListener(new ClickUtils());
    }

    private void c() {
        TabPageIndicatorWithDot tabPageIndicatorWithDot = (TabPageIndicatorWithDot) this.f17161c.findViewById(R.id.indicator);
        this.d = tabPageIndicatorWithDot;
        tabPageIndicatorWithDot.setOnPageChangeListener(this.h);
        this.e = (ViewPager) this.f17161c.findViewById(R.id.p_viewpager);
        this.f = new MyPagerAdapter(getChildFragmentManager());
        this.e.setOffscreenPageLimit(2);
        this.e.setAdapter(this.f);
        this.d.setViewPager(this.e);
        this.d.setVisibility(0);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.f.f17163a != null) {
            this.f.f17163a.onActivityResult(i, i2, intent);
        }
        if (this.f.b != null) {
            this.f.b.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131363120) {
            return;
        }
        getActivity().finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        View view = this.f17161c;
        if (view == null) {
            this.f17161c = layoutInflater.inflate(R.layout.fragment_group_nearby_and_hot, viewGroup, false);
            a();
            b();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f17161c.getParent()).removeView(this.f17161c);
        }
        return this.f17161c;
    }
}
