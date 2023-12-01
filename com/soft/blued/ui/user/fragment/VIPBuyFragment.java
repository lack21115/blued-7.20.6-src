package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.PageTabLayout;
import com.blued.android.module.live.base.constants.LiveEventBusConstant;
import com.blued.android.module.live_china.click.SingleClickProxy;
import com.blued.community.utils.CommunityPreferences;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.user.model.VIPBuyTipsModel;
import com.soft.blued.ui.user.observer.VIPBuyOnBackPressedObserver;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.user.views.PopVipCancelBuyTipsDialogFragment;
import com.soft.blued.utils.BluedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VIPBuyFragment.class */
public class VIPBuyFragment extends BaseFragment implements VIPBuyOnBackPressedObserver.IVIPBuyOnBackPressedObserver, VIPBuyResultObserver.IVIPBuyResultObserver {

    /* renamed from: a  reason: collision with root package name */
    public Context f34109a;
    public View b;
    private CommonTopTitleNoTrans d;
    private ShapeTextView e;
    private PageTabLayout f;
    private ViewPager g;
    private VIPBuyOptionListFragment h;
    private VIPBuyOptionListFragment i;
    private int j;
    private String k;
    private String l;
    private String m;
    private int q;
    private int r;
    private int s;
    private VipProtos.FromType t;
    private boolean n = false;
    private boolean o = true;
    private boolean p = false;
    private boolean u = false;

    /* renamed from: c  reason: collision with root package name */
    String[] f34110c = null;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VIPBuyFragment$MyAdapter.class */
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
            return 2;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return VIPBuyFragment.this.h;
            }
            return VIPBuyFragment.this.i;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return i < VIPBuyFragment.this.f34110c.length ? VIPBuyFragment.this.f34110c[i] : VIPBuyFragment.this.f34110c[VIPBuyFragment.this.f34110c.length - 1];
        }
    }

    private void a(int i) {
        ((TextView) this.f.a(i).a().findViewById(2131371294)).setVisibility(0);
    }

    public static void a(Context context, int i, String str, int i2, VipProtos.FromType fromType, boolean z, boolean z2, boolean z3, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_VIP_GRADE", i);
        bundle.putString("KEY_VIP_DETAIL", str);
        bundle.putBoolean("KEY_IF_SHOW_COUPON", z);
        bundle.putBoolean("KEY_IF_SHOW_UPGRADE_BUTTON", z2);
        bundle.putBoolean("KEY_IF_OPEN_UPGRADE_DIALOG", z3);
        bundle.putInt("KEY_RIGHT_ID", i2);
        bundle.putInt("KEY_PARAMS_LEVEL", i3);
        bundle.putSerializable("KEY_VIP_FROM_TYPE", fromType);
        TerminalActivity.d(context, VIPBuyFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(VIPBuyTipsModel vIPBuyTipsModel) {
        if (vIPBuyTipsModel != null && vIPBuyTipsModel.open_intercept > 0) {
            Log.v("drb", "openIntercept:" + vIPBuyTipsModel.open_intercept);
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
            if (vIPBuyTipsModel.open_intercept > 4) {
                b(vIPBuyTipsModel);
                return;
            } else if (this.q == 0) {
                if (!CommunityPreferences.P().equals(format)) {
                    b(vIPBuyTipsModel);
                    CommunityPreferences.j(format);
                    return;
                }
            } else if (!CommunityPreferences.Q().equals(format)) {
                b(vIPBuyTipsModel);
                CommunityPreferences.k(format);
                return;
            }
        }
        if (this.u) {
            LiveEventBus.get(LiveEventBusConstant.f11377c).post(null);
        } else {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z) {
        if (z) {
            c();
        }
    }

    private void b() {
        LiveEventBus.get(LiveEventBusConstant.b, Boolean.class).observe(this, new Observer<Boolean>() { // from class: com.soft.blued.ui.user.fragment.VIPBuyFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                VIPBuyFragment.this.u = false;
                if (!bool.booleanValue() || VIPBuyFragment.this.getActivity() == null) {
                    return;
                }
                VIPBuyFragment.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.user.fragment.VIPBuyFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VIPBuyFragment.this.c();
                    }
                }, 300L);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        ((TextView) this.f.a(i).a().findViewById(2131371294)).setVisibility(8);
    }

    private void b(VIPBuyTipsModel vIPBuyTipsModel) {
        this.u = true;
        PopVipCancelBuyTipsDialogFragment.f34378a.a(this.f34109a, (BaseFragmentActivity) getActivity(), vIPBuyTipsModel, this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    private void d() {
        this.f34110c = new String[]{this.f34109a.getResources().getString(R.string.svip), this.f34109a.getResources().getString(R.string.vip)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        BluedUIHttpResponse<BluedEntityA<VIPBuyTipsModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<VIPBuyTipsModel>>() { // from class: com.soft.blued.ui.user.fragment.VIPBuyFragment.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<VIPBuyTipsModel> bluedEntityA) {
                VIPBuyTipsModel vIPBuyTipsModel;
                if (bluedEntityA == null || (vIPBuyTipsModel = bluedEntityA.data.get(0)) == null) {
                    return;
                }
                VIPBuyFragment.this.a(vIPBuyTipsModel);
            }
        };
        int i = 1;
        if (1 == this.q) {
            i = 0;
        }
        PayHttpUtils.a(bluedUIHttpResponse, i);
    }

    public void a() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.b.findViewById(2131370694);
        this.d = commonTopTitleNoTrans;
        commonTopTitleNoTrans.setLeftClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.VIPBuyFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackVIP.a(VipProtos.Event.VIP_BUY_BACK_BTN_CLICK);
                VIPBuyFragment.this.e();
            }
        }));
        this.d.a();
        this.d.setCenterText(R.string.vip_pay);
        this.f = (PageTabLayout) this.b.findViewById(2131370555);
        ShapeTextView shapeTextView = (ShapeTextView) this.b.findViewById(2131370550);
        this.e = shapeTextView;
        ShapeHelper.b(shapeTextView, 2131101796);
        this.g = (ViewPager) this.b.findViewById(R.id.vp_vip);
        this.h = new VIPBuyOptionListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_VIP_GRADE", 1);
        bundle.putString("KEY_TARGET_UID", this.k);
        bundle.putString("KEY_ACTIVITY_ID", this.l);
        bundle.putString("KEY_VIP_DETAIL", this.m);
        bundle.putInt("KEY_RIGHT_ID", this.r);
        bundle.putInt("KEY_PARAMS_LEVEL", this.s);
        bundle.putBoolean("KEY_IF_SHOW_COUPON", this.n);
        bundle.putSerializable("KEY_VIP_FROM_TYPE", this.t);
        this.h.setArguments(bundle);
        this.i = new VIPBuyOptionListFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("KEY_VIP_GRADE", 2);
        bundle2.putString("KEY_TARGET_UID", this.k);
        bundle2.putString("KEY_ACTIVITY_ID", this.l);
        bundle2.putString("KEY_VIP_DETAIL", this.m);
        bundle2.putInt("KEY_RIGHT_ID", this.r);
        bundle2.putInt("KEY_PARAMS_LEVEL", this.s);
        bundle2.putBoolean("KEY_IF_SHOW_COUPON", this.n);
        bundle2.putBoolean("KEY_IF_SHOW_UPGRADE_BUTTON", this.o);
        bundle2.putBoolean("KEY_IF_OPEN_UPGRADE_DIALOG", this.p);
        bundle2.putSerializable("KEY_VIP_FROM_TYPE", this.t);
        this.i.setArguments(bundle2);
        this.g.setAdapter(new MyAdapter(getChildFragmentManager()));
        this.f.setupWithViewPager(this.g);
        this.g.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.user.fragment.VIPBuyFragment.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                VIPBuyFragment.this.q = i;
                if (i == 0) {
                    VIPBuyFragment.this.b(i);
                    BluedPreferences.cq();
                }
            }
        });
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f34110c.length) {
                break;
            }
            View inflate = LayoutInflater.from(this.f34109a).inflate(R.layout.item_tab_with_dot, (ViewGroup) null);
            ShapeTextView shapeTextView2 = (ShapeTextView) inflate.findViewById(2131372754);
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView2, 2131102254);
            shapeTextView2.setText(this.f34110c[i2]);
            this.f.a(i2).a(inflate);
            i = i2 + 1;
        }
        if (this.j == 1) {
            this.g.setCurrentItem(1);
            this.q = 1;
            if (BluedPreferences.cp()) {
                a(0);
            }
        }
    }

    @Override // com.soft.blued.ui.user.observer.VIPBuyResultObserver.IVIPBuyResultObserver
    public void a(int i, final boolean z) {
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPBuyFragment$ZruKwCwlsvQHVbtBx0feC31cPNE
            @Override // java.lang.Runnable
            public final void run() {
                VIPBuyFragment.this.a(z);
            }
        }, 500L);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        e();
        return true;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f34109a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_vip_buy, viewGroup, false);
            if (getArguments() != null) {
                this.j = getArguments().getInt("KEY_VIP_GRADE");
                this.k = getArguments().getString("KEY_TARGET_UID");
                this.l = getArguments().getString("KEY_ACTIVITY_ID");
                this.m = getArguments().getString("KEY_VIP_DETAIL");
                this.n = getArguments().getBoolean("KEY_IF_SHOW_COUPON");
                this.o = getArguments().getBoolean("KEY_IF_SHOW_UPGRADE_BUTTON", true);
                this.p = getArguments().getBoolean("KEY_IF_OPEN_UPGRADE_DIALOG");
                this.r = getArguments().getInt("KEY_RIGHT_ID");
                this.s = getArguments().getInt("KEY_PARAMS_LEVEL");
                this.t = (VipProtos.FromType) getArguments().getSerializable("KEY_VIP_FROM_TYPE");
            }
            d();
            a();
            b();
            VIPBuyResultObserver.a().a(this, getLifecycle());
            VIPBuyOnBackPressedObserver.a().a(this, getLifecycle());
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        UserHttpUtils.a();
        super.onDestroyView();
    }
}
