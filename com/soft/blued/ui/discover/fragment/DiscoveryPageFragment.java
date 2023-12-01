package com.soft.blued.ui.discover.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.community.track.EventTrackFeed;
import com.blued.das.client.feed.FeedProtos;
import com.soft.blued.R;
import com.soft.blued.customview.BluedADConstraintLayout;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.ui.discover.presenter.DiscoveryPagePresenter;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/fragment/DiscoveryPageFragment.class */
public class DiscoveryPageFragment extends MvpFragment<DiscoveryPagePresenter> {

    /* renamed from: a  reason: collision with root package name */
    private MyAdapter f16117a;
    @BindView
    BluedADConstraintLayout bluedAdLayout;
    @BindView
    ImageView cttLeft;
    @BindView
    ImageView cttRight;
    @BindView
    FrameLayout cttRightMenu;
    @BindView
    TextView cttRightText;
    @BindView
    QBadgeContainer findBadgeContainer;
    @BindView
    ImageView imgNearbyAd;
    @BindView
    ShapeTextView imgRightNewDot;
    @BindView
    View title;
    @BindView
    CustomViewPager viewPager;
    @BindView
    TabPageIndicatorWithDot vpIndicator;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/fragment/DiscoveryPageFragment$MyAdapter.class */
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
            return ((DiscoveryPagePresenter) DiscoveryPageFragment.this.j()).m().size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return ((DiscoveryPagePresenter) DiscoveryPageFragment.this.j()).m().get(i).getFragment();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return ((DiscoveryPagePresenter) DiscoveryPageFragment.this.j()).m().get(i).title;
        }
    }

    private void b() {
        if (StatusBarHelper.a()) {
            this.findBadgeContainer.setPadding(0, StatusBarHelper.a(getActivity()), 0, 0);
        }
        this.cttLeft.setVisibility(4);
        this.title.setVisibility(0);
        this.cttRightMenu.setVisibility(8);
    }

    private void c() {
        if (this.f16117a == null) {
            this.f16117a = new MyAdapter(getChildFragmentManager());
        }
        this.viewPager.setAdapter(this.f16117a);
        this.vpIndicator.setViewPager(this.viewPager);
        ViewGroup.LayoutParams layoutParams = this.vpIndicator.getLayoutParams();
        int a2 = DensityUtils.a(getContext(), 50.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(a2, 0, a2, 0);
        this.vpIndicator.setLayoutParams(layoutParams);
        if (!BlueAppLocal.d()) {
            this.vpIndicator.setTabPaddingLeftRight(DensityUtils.a(getContext(), 5.0f));
        }
        this.vpIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.discover.fragment.DiscoveryPageFragment.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                DiscoveryPageFragment.this.vpIndicator.c(i);
                if (((DiscoveryPagePresenter) DiscoveryPageFragment.this.j()).m().size() <= i || ((DiscoveryPagePresenter) DiscoveryPageFragment.this.j()).m().get(i).tabid != 4) {
                    return;
                }
                EventTrackFeed.a(FeedProtos.Event.FIND_TOP_CIRCLE_CLICK);
            }
        });
        a(2);
    }

    public void a(int i) {
        int a2 = ((DiscoveryPagePresenter) j()).a(i);
        if (a2 < 0 || a2 >= this.viewPager.getAdapter().getCount()) {
            return;
        }
        this.viewPager.setCurrentItem(a2);
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        b();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Integer num) {
        if (num.intValue() < 0 || num.intValue() >= this.vpIndicator.f) {
            return;
        }
        this.vpIndicator.b(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Integer num) {
        if (num.intValue() < 0 || num.intValue() >= this.vpIndicator.f) {
            return;
        }
        this.vpIndicator.c(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Integer num) {
        if (num.intValue() < 0 || this.f16117a.getCount() <= num.intValue()) {
            return;
        }
        this.viewPager.setCurrentItem(num.intValue(), true);
    }

    public int g() {
        return R.layout.fragment_discovery;
    }

    public boolean q() {
        return true;
    }
}
