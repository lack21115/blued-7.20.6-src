package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.url.H5Url;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.NoScrollH5ViewPager;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.ui.web.NoTitleWebViewShowFragment;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveRankWebViewFragment.class */
public class LiveRankWebViewFragment extends BaseFragment implements View.OnClickListener {
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private ViewGroup f17522c;
    private View d;
    private ImageView e;
    private ImageView f;
    private TabPageIndicatorWithDot g;
    private NoScrollH5ViewPager h;
    private MyAdapter i;
    private int j;

    /* renamed from: a  reason: collision with root package name */
    public int f17521a = 2;
    private String k = "";
    private String l = "";
    private ViewPager.OnPageChangeListener m = new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.live.fragment.LiveRankWebViewFragment.1
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            LiveRankWebViewFragment.this.j = i;
        }
    };

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveRankWebViewFragment$FIRST_PAGE.class */
    public interface FIRST_PAGE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveRankWebViewFragment$FirstPageDef.class */
    public @interface FirstPageDef {
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveRankWebViewFragment$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        FragmentManager f17524a;

        /* renamed from: c  reason: collision with root package name */
        private String[] f17525c;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f17525c = LiveRankWebViewFragment.this.b.getResources().getStringArray(R.array.live_rank_title);
            this.f17524a = fragmentManager;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        /* renamed from: a */
        public NoTitleWebViewShowFragment getItem(int i) {
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return new NoTitleWebViewShowFragment().a(LiveRankWebViewFragment.this.l);
            }
            return new NoTitleWebViewShowFragment().a(LiveRankWebViewFragment.this.k);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return LiveRankWebViewFragment.this.f17521a;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.f17525c[i];
        }
    }

    private String a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    private void c() {
        this.k = H5Url.a(3);
        this.l = H5Url.a(4);
    }

    private void d() {
        this.d = this.f17522c.findViewById(2131370694);
        ImageView imageView = (ImageView) this.f17522c.findViewById(2131363120);
        this.e = imageView;
        imageView.setImageDrawable(BluedSkinUtils.b(this.b, 2131233902));
        this.e.setVisibility(0);
        this.e.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.f17522c.findViewById(2131363126);
        this.f = imageView2;
        imageView2.setImageResource(2131233917);
        this.f.setVisibility(0);
        this.f.setOnClickListener(this);
    }

    public ViewGroup a(LayoutInflater layoutInflater) {
        return (ViewGroup) layoutInflater.inflate(R.layout.fragment_live_rank_web_view, (ViewGroup) null);
    }

    public void a() {
        this.h = (NoScrollH5ViewPager) this.f17522c.findViewById(R.id.viewpager);
        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager());
        this.i = myAdapter;
        this.h.setAdapter(myAdapter);
        this.h.setOffscreenPageLimit(2);
        TabPageIndicatorWithDot tabPageIndicatorWithDot = (TabPageIndicatorWithDot) this.f17522c.findViewById(R.id.vp_indicator);
        this.g = tabPageIndicatorWithDot;
        tabPageIndicatorWithDot.setViewPager(this.h);
        this.g.setOnPageChangeListener(this.m);
        int i = getArguments().getInt("INT_FIRST_PAGE");
        this.j = i;
        this.h.setCurrentItem(i);
    }

    protected void b() {
        if (getFragmentActive() == null || !getFragmentActive().isActive()) {
            return;
        }
        getActivity().finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            b();
        } else if (id != 2131363126) {
        } else {
            ((NoTitleWebViewShowFragment) getChildFragmentManager().findFragmentByTag(a(this.h.getId(), this.j))).d();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getActivity().getWindow().setSoftInputMode(18);
        this.b = getActivity();
        ViewGroup viewGroup2 = this.f17522c;
        if (viewGroup2 == null) {
            this.f17522c = a(layoutInflater);
            c();
            d();
            a();
        } else if (viewGroup2.getParent() != null) {
            ((ViewGroup) this.f17522c.getParent()).removeView(this.f17522c);
        }
        return this.f17522c;
    }
}
