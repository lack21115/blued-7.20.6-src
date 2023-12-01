package com.soft.blued.ui.find.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.community.manager.CommunityManager;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.utils.BluedPreferences;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/HomeGuideFragment.class */
public class HomeGuideFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f30340a;
    private final int[] b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f30341c;
    private final int d;
    private View e;
    private ViewPager f;
    private TextView g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/HomeGuideFragment$GlidePagerAdapter.class */
    public class GlidePagerAdapter extends FragmentPagerAdapter {
        private List<GuideBean> b;

        public GlidePagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.b = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= HomeGuideFragment.this.f30340a.length) {
                    return;
                }
                GuideBean guideBean = new GuideBean();
                guideBean.f30345a = HomeGuideFragment.this.f30340a[i2];
                guideBean.b = HomeGuideFragment.this.b[i2];
                guideBean.f30346c = HomeGuideFragment.this.f30341c[i2];
                this.b.add(guideBean);
                i = i2 + 1;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return HomeGuideFragment.this.f30340a.length;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            GuideItemFragment guideItemFragment = new GuideItemFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data", this.b.get(i));
            guideItemFragment.setArguments(bundle);
            return guideItemFragment;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/HomeGuideFragment$GuideBean.class */
    public static class GuideBean implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public int f30345a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f30346c;
    }

    public HomeGuideFragment() {
        int[] iArr = {R.drawable.home_guide_1, R.drawable.home_guide_2};
        this.f30340a = iArr;
        this.b = new int[]{R.string.guide_700_title_1, R.string.guide_700_title_2};
        this.f30341c = new int[]{R.string.guide_700_desc_1, R.string.guide_700_desc_2};
        this.d = iArr.length - 1;
    }

    private void a() {
        this.f = (ViewPager) this.e.findViewById(2131373209);
        this.g = (TextView) this.e.findViewById(R.id.tv_go);
        this.f.setAdapter(new GlidePagerAdapter(getChildFragmentManager()));
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.HomeGuideFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (HomeGuideFragment.this.f.getCurrentItem() < HomeGuideFragment.this.d) {
                    HomeGuideFragment.this.f.setCurrentItem(HomeGuideFragment.this.f.getCurrentItem() + 1);
                } else if (HomeGuideFragment.this.f.getCurrentItem() == HomeGuideFragment.this.d) {
                    BluedPreferences.bO();
                    HomeGuideFragment.this.getActivity().finish();
                    ActivityChangeAnimationUtils.c(HomeGuideFragment.this.getActivity());
                }
            }
        });
        if (this.d == 0) {
            this.g.setText(getResources().getString(R.string.guide_700_enter));
        }
        this.f.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.find.fragment.HomeGuideFragment.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i == HomeGuideFragment.this.d) {
                    HomeGuideFragment.this.g.setText(HomeGuideFragment.this.getResources().getString(R.string.guide_700_enter));
                } else {
                    HomeGuideFragment.this.g.setText(HomeGuideFragment.this.getResources().getString(R.string.guide_700_go_on));
                }
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.e = layoutInflater.inflate(R.layout.dialog_fragment_home_guide, (ViewGroup) null);
            a();
        } catch (Exception e) {
            this.e = new RelativeLayout(getContext());
            getActivity().finish();
        }
        CommunityManager.f19086a.a().e(true);
        return this.e;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CommunityManager.f19086a.a().e(false);
    }
}
