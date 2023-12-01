package com.soft.blued.ui.find.fragment;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.ad.ADConstants;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.find.adapter.PeopleVIPGridAdapter;
import com.soft.blued.ui.find.model.AdvertFloatModel;
import com.soft.blued.ui.find.model.FindDataExtra;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.io.File;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyPeopleTabPageVIPFragment.class */
public class NearbyPeopleTabPageVIPFragment extends NearbyPeopleTabPageFragment implements HomeTabClick.TabClickListener, VIPBuyResultObserver.IVIPBuyResultObserver {
    ValueAnimator r;
    VipProtos.IdentityType s;
    private boolean t = false;
    private View u;
    private View v;
    private View w;

    private void a(FindDataExtra findDataExtra) {
        if (findDataExtra == null || findDataExtra.guide_map == null) {
            return;
        }
        final FindDataExtra.GuideMap guideMap = findDataExtra.guide_map;
        if (guideMap.is_open != 1 || TextUtils.isEmpty(guideMap.image)) {
            return;
        }
        String bS = BluedPreferences.bS();
        if (TextUtils.isEmpty(guideMap.code) || guideMap.code.equals(bS)) {
            return;
        }
        final AdvertFloatModel advertFloatModel = new AdvertFloatModel();
        advertFloatModel.advert_pic = guideMap.image;
        ImageFileLoader.a(getFragmentActive()).a(advertFloatModel.advert_pic).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleTabPageVIPFragment.2
            @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
            public void onUIFinish(File file, Exception exc) {
                if (file != null && file.exists() && NearbyPeopleTabPageVIPFragment.this.k) {
                    BluedPreferences.R(guideMap.code);
                    AdvertFloatFragment.a(NearbyPeopleTabPageVIPFragment.this.f30524a, advertFloatModel, ADConstants.AD_POSITION.NONE);
                }
            }
        }).a();
    }

    public static NearbyPeopleTabPageVIPFragment i() {
        NearbyPeopleTabPageVIPFragment nearbyPeopleTabPageVIPFragment = new NearbyPeopleTabPageVIPFragment();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_SORT_BY", UserFindResult.USER_SORT_BY.SELECTED);
        nearbyPeopleTabPageVIPFragment.setArguments(bundle);
        return nearbyPeopleTabPageVIPFragment;
    }

    private void j() {
        this.f.clearOnScrollListeners();
        this.d.setRefreshEnabled(true);
        this.d.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleTabPageVIPFragment.1
            @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase.OnRefreshListener
            public void onRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                NearbyPeopleTabPageVIPFragment.this.a(true);
            }
        });
        this.d.k();
        f().refresh();
    }

    private void k() {
        this.d.setVisibility(8);
        this.n.setVisibility(8);
        this.u.setVisibility(0);
        this.v.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleTabPageVIPFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PayUtils.a(NearbyPeopleTabPageVIPFragment.this.f30524a, "nearby_choice_for_you_buy", 26, VipProtos.FromType.UNKNOWN_FROM);
            }
        });
        this.w.setVisibility(8);
    }

    private void l() {
        this.d.setVisibility(0);
        this.n.setVisibility(0);
        this.w.setVisibility(0);
        this.w.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleTabPageVIPFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PayUtils.a(NearbyPeopleTabPageVIPFragment.this.f30524a, "nearby_choice_for_you_buy", 26, VipProtos.FromType.UNKNOWN_FROM);
            }
        });
        this.u.setVisibility(8);
    }

    @Override // com.soft.blued.ui.find.fragment.NearbyPeopleTabPageFragment
    public void a() {
        super.a();
        this.u = this.b.findViewById(R.id.ll_go_buy_vip);
        this.v = this.b.findViewById(R.id.tv_buy_vip);
        this.w = this.b.findViewById(R.id.stv_buy_vip);
        int i = BluedConfig.a().b().vip_grade;
        if (i == 0) {
            this.s = VipProtos.IdentityType.NONE;
        } else if (i == 1) {
            this.s = VipProtos.IdentityType.VIP_TYPE;
        } else if (i == 2) {
            this.s = VipProtos.IdentityType.SVIP_TYPE;
        }
        j();
    }

    @Override // com.soft.blued.ui.find.fragment.NearbyPeopleTabPageFragment, com.soft.blued.ui.find.observer.SetModelObserver.ISetModelObserver
    public void a(int i) {
    }

    @Override // com.soft.blued.ui.user.observer.VIPBuyResultObserver.IVIPBuyResultObserver
    public void a(int i, boolean z) {
        if (z) {
            a(true);
        }
    }

    @Override // com.soft.blued.ui.find.fragment.NearbyPeopleTabPageFragment
    public void a(RecyclerView recyclerView) {
    }

    @Override // com.soft.blued.ui.find.fragment.NearbyPeopleTabPageFragment
    public void a(BluedEntity<UserFindResult, FindDataExtra> bluedEntity, boolean z) {
        super.a(bluedEntity, z);
        if (bluedEntity != null) {
            a(bluedEntity.extra);
        }
        if (z) {
            this.h.setNewData(null);
            this.n.setVisibility(8);
            this.u.setVisibility(8);
            this.w.setVisibility(8);
            return;
        }
        if (BluedConfig.a().b().vip_grade == 2) {
            this.d.setVisibility(0);
            this.n.setVisibility(0);
            this.u.setVisibility(8);
            this.w.setVisibility(8);
        } else if (BluedConfig.a().b().selected_not_vip_show_type == 0) {
            k();
        } else {
            l();
        }
    }

    @Override // com.soft.blued.ui.find.fragment.NearbyPeopleTabPageFragment
    public void a(String str) {
        if (this.t || this.n == null) {
            return;
        }
        this.t = true;
        if (this.n.getVisibility() == 8) {
            this.n.setVisibility(0);
        }
        if (StringUtils.d(str)) {
            return;
        }
        this.n.setText(str);
        this.r.start();
        this.n.postDelayed(new Runnable() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleTabPageVIPFragment.6
            @Override // java.lang.Runnable
            public void run() {
                NearbyPeopleTabPageVIPFragment.this.t = false;
                NearbyPeopleTabPageVIPFragment.this.r.reverse();
            }
        }, 5000L);
    }

    @Override // com.soft.blued.ui.find.fragment.NearbyPeopleTabPageFragment
    public void b() {
        this.i = 2;
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void c(String str) {
        if (!"find".equals(str) || this.d == null) {
            return;
        }
        this.d.k();
    }

    @Override // com.soft.blued.ui.find.fragment.NearbyPeopleTabPageFragment
    public void d() {
        this.h = new PeopleVIPGridAdapter(new ArrayList(), getActivity(), getFragmentActive(), this.f30525c, this.f);
        ValueAnimator ofInt = ValueAnimator.ofInt(DensityUtils.a(this.f30524a, -35.0f), DensityUtils.a(this.f30524a, 10.0f));
        this.r = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.find.fragment.NearbyPeopleTabPageVIPFragment.5

            /* renamed from: a  reason: collision with root package name */
            FrameLayout.LayoutParams f30538a;

            {
                this.f30538a = (FrameLayout.LayoutParams) NearbyPeopleTabPageVIPFragment.this.n.getLayoutParams();
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f30538a.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                NearbyPeopleTabPageVIPFragment.this.n.setLayoutParams(this.f30538a);
            }
        });
        this.r.setInterpolator(new AccelerateDecelerateInterpolator());
        this.r.setDuration(500L);
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void d(String str) {
        c(str);
    }

    @Override // com.soft.blued.ui.find.fragment.NearbyPeopleTabPageFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        HomeTabClick.b("find", this);
    }

    @Override // com.soft.blued.ui.find.fragment.NearbyPeopleTabPageFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            HomeTabClick.a("find", this);
        }
    }
}
