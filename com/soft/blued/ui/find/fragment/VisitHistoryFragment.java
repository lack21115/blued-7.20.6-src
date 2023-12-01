package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.ui.find.observer.VisitRecordSelectedTabObserver;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/VisitHistoryFragment.class */
public class VisitHistoryFragment extends BaseFragment implements VisitRecordSelectedTabObserver.IVisitRecordSelectedTabObserver {

    /* renamed from: a  reason: collision with root package name */
    private Context f30551a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private ViewPager f30552c;
    private MyVisitorFragment d;
    private MyVisitedFragment e;
    private BaseFragment[] f;
    private int g;
    private ViewPager.OnPageChangeListener h = new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.find.fragment.VisitHistoryFragment.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            VisitHistoryFragment.this.g = i;
        }
    };

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/VisitHistoryFragment$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {
        private String[] b;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.b = new String[]{VisitHistoryFragment.this.f30551a.getResources().getString(R.string.come_to_visit), VisitHistoryFragment.this.f30551a.getResources().getString(R.string.look_up)};
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 2;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return VisitHistoryFragment.this.e;
            }
            return VisitHistoryFragment.this.d;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.b[i];
        }
    }

    private void a() {
        this.f30552c = (ViewPager) this.b.findViewById(R.id.main_find_viewpager);
        this.f30552c.setAdapter(new MyAdapter(getChildFragmentManager()));
        TabPageIndicatorWithDot tabPageIndicatorWithDot = (TabPageIndicatorWithDot) this.b.findViewById(2131373299);
        tabPageIndicatorWithDot.setViewPager(this.f30552c);
        tabPageIndicatorWithDot.setOnPageChangeListener(this.h);
    }

    public static void a(Context context) {
        TerminalActivity.d(context, VisitHistoryFragment.class, null);
    }

    private void b() {
        ImageView imageView = (ImageView) this.b.findViewById(2131363120);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        marginLayoutParams.width = DensityUtils.a(this.f30551a, 24.0f);
        marginLayoutParams.height = marginLayoutParams.width;
        imageView.setLayoutParams(marginLayoutParams);
        imageView.setImageDrawable(BluedSkinUtils.b(this.f30551a, 2131233902));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.VisitHistoryFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                VisitHistoryFragment.this.getActivity().finish();
            }
        });
        this.b.findViewById(2131363126).setVisibility(8);
        this.b.findViewById(2131363135).setVisibility(8);
    }

    private void c() {
        this.d = new MyVisitorFragment();
        MyVisitedFragment myVisitedFragment = new MyVisitedFragment();
        this.e = myVisitedFragment;
        this.f = r0;
        BaseFragment[] baseFragmentArr = {this.d, myVisitedFragment};
    }

    @Override // com.soft.blued.ui.find.observer.VisitRecordSelectedTabObserver.IVisitRecordSelectedTabObserver
    public void a(int i) {
        if (i < this.f30552c.getAdapter().getCount()) {
            this.f30552c.setCurrentItem(i);
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f30551a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_visit_history, viewGroup, false);
            b();
            a();
            c();
            VisitRecordSelectedTabObserver.a().a(this);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        VisitRecordSelectedTabObserver.a().b(this);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
