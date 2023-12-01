package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.user.model.UserInfo;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.user.BluedConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VIPCenterNewFragment.class */
public class VIPCenterNewFragment extends BaseFragment implements VIPBuyResultObserver.IVIPBuyResultObserver {

    /* renamed from: a  reason: collision with root package name */
    public int f20443a;
    public String b;
    private View d;
    private List<String> e;
    private Context f;
    private MyAdapter g;
    private CustomViewPager h;
    private ImageView i;
    private ImageView j;
    private TabPageIndicatorWithDot k;
    private TabPageIndicatorWithDot l;
    private View m;
    private View n;
    private float o = 0.0f;
    private float p = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20444c = false;
    private int q = -1;
    private int r = -14540254;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VIPCenterNewFragment$MyAdapter.class */
    public class MyAdapter extends FragmentStatePagerAdapter {
        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return VIPCenterNewFragment.this.e.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return i != 0 ? VIPCenterTabPageNewFragment.b.a(1, VIPCenterNewFragment.this.b) : VIPCenterTabPageNewFragment.b.a(2, VIPCenterNewFragment.this.b);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return (String) VIPCenterNewFragment.this.e.get(i);
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            return super.instantiateItem(viewGroup, i);
        }
    }

    public static void a(Context context, int i, String str) {
        BluedConfig.a().c();
        BluedConfig.a().b = true;
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0) {
            VIPCenterTabPageNewFragment.b.a(context, UserInfo.getInstance().getLoginUserInfo().vip_grade, str);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_TAB_INDEX", i);
        bundle.putString("KEY_VIP_DETAIL", str);
        TerminalActivity.a(bundle);
        TerminalActivity.d(context, VIPCenterNewFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        a();
    }

    public void a() {
        BluedConfig.a().c();
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f, int i) {
        if (i == 2) {
            this.o = f;
        } else {
            this.p = f;
        }
        if (this.h.getCurrentItem() == 0) {
            this.n.setAlpha(this.o);
        } else {
            this.n.setAlpha(this.p);
        }
    }

    public void a(int i) {
        if (i != 0) {
            this.i.setImageResource(2131233902);
            this.n.setAlpha(this.p);
            StatusBarHelper.a(getActivity(), true);
            this.k.setTextColor(2131102203);
            this.k.setTabTextColorUnfocused(2131101975);
            this.k.setIndicatorColor(2131102203);
            TabPageIndicatorWithDot tabPageIndicatorWithDot = this.k;
            int i2 = this.r;
            tabPageIndicatorWithDot.c(i2, i2);
            this.l.setIndicatorColor(2131102203);
            TabPageIndicatorWithDot tabPageIndicatorWithDot2 = this.l;
            int i3 = this.r;
            tabPageIndicatorWithDot2.c(i3, i3);
            return;
        }
        this.i.setImageResource(2131233903);
        this.n.setAlpha(this.o);
        if (this.n.getAlpha() < 0.5f) {
            StatusBarHelper.a(getActivity(), false);
        } else {
            StatusBarHelper.a(getActivity(), true);
        }
        this.k.setTextColor(2131102170);
        this.k.setTabTextColorUnfocused(2131101977);
        this.k.setIndicatorColor(2131102170);
        TabPageIndicatorWithDot tabPageIndicatorWithDot3 = this.k;
        int i4 = this.q;
        tabPageIndicatorWithDot3.c(i4, i4);
        this.l.setIndicatorColor(2131102203);
        TabPageIndicatorWithDot tabPageIndicatorWithDot4 = this.l;
        int i5 = this.r;
        tabPageIndicatorWithDot4.c(i5, i5);
    }

    @Override // com.soft.blued.ui.user.observer.VIPBuyResultObserver.IVIPBuyResultObserver
    public void a(int i, boolean z) {
        if (z && i == 2) {
            VIPCenterTabPageNewFragment.b.a(this.f, UserInfo.getInstance().getLoginUserInfo().vip_grade, this.b);
            getActivity().finish();
        }
    }

    public void a(Rect rect) {
        CustomViewPager customViewPager = this.h;
        if (customViewPager != null) {
            customViewPager.setIgnoreRect(rect);
        }
    }

    protected void b() {
        this.h = (CustomViewPager) this.d.findViewById(2131373100);
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        arrayList.add(this.f.getResources().getString(R.string.svip));
        this.e.add(this.f.getResources().getString(R.string.vip));
        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager());
        this.g = myAdapter;
        this.h.setAdapter(myAdapter);
        this.i = (ImageView) this.d.findViewById(2131363120);
        this.j = (ImageView) this.d.findViewById(R.id.ctt_left_hover);
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterNewFragment$R7gJYKNFE2wFo98BI1UqzrcUhvM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCenterNewFragment.this.b(view);
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterNewFragment$6b91iiBdzOcfcXA6TS7d-bo453M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCenterNewFragment.this.a(view);
            }
        });
        this.k = (TabPageIndicatorWithDot) this.d.findViewById(R.id.vp_indicator);
        this.l = (TabPageIndicatorWithDot) this.d.findViewById(R.id.vp_indicator_hover);
        this.m = this.d.findViewById(R.id.fl_title);
        this.n = this.d.findViewById(R.id.fl_title_hover);
        this.l.setTextColor(2131102203);
        this.l.setTabTextColorUnfocused(2131101975);
        this.l.setIndicatorColor(2131102203);
        TabPageIndicatorWithDot tabPageIndicatorWithDot = this.l;
        int i = this.q;
        tabPageIndicatorWithDot.c(i, i);
        a(0);
        this.k.setViewPager(this.h);
        this.l.setViewPager(this.h);
        this.n.setAlpha(0.0f);
        this.m.setPadding(0, StatusBarHelper.a(this.f), 0, 0);
        this.n.setPadding(0, StatusBarHelper.a(this.f), 0, 0);
        int i2 = this.f20443a;
        if (i2 == 0 || i2 == 1) {
            this.h.setCurrentItem(this.f20443a);
        } else {
            this.h.setCurrentItem(0);
        }
        this.k.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.user.fragment.VIPCenterNewFragment.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i3, float f, int i4) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
                VIPCenterNewFragment.this.a(((VIPCenterTabPageNewFragment) VIPCenterNewFragment.this.g.instantiateItem((ViewGroup) VIPCenterNewFragment.this.h, i3)).a());
            }
        });
    }

    public void b(int i) {
        int i2 = this.f20443a;
        if (i2 == 0 || i2 == 1) {
            return;
        }
        if (i == 0 || i == 1) {
            this.h.setCurrentItem(i);
        }
    }

    public int c() {
        return this.h.getCurrentItem() == 0 ? 2 : 1;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f = getActivity();
        View view = this.d;
        if (view == null) {
            this.d = layoutInflater.inflate(R.layout.fragment_vip_center_new, viewGroup, false);
            this.f20443a = getArguments().getInt("KEY_TAB_INDEX", -1);
            this.b = getArguments().getString("KEY_VIP_DETAIL", "");
            b();
            StatusBarHelper.a(getActivity(), false);
            VIPBuyResultObserver.a().a(this, getLifecycle());
        } else if (view.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        return this.d;
    }

    public void onDestroy() {
        super.onDestroy();
        BluedConfig.a().b = false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 || i == 3) {
            a();
        }
        return super.onKeyDown(i, keyEvent);
    }
}
