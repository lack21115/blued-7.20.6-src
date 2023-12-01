package com.soft.blued.ui.find.presenter;

import android.app.Application;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.send.vm.SelectCityViewModel;
import com.blued.community.utils.CityHelper;
import com.blued.das.client.feed.FeedProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.ui.find.model.CityLocation;
import com.soft.blued.ui.find.model.HomeTopTabModel;
import com.soft.blued.ui.find.model.MapChanceEncounterStatusModel;
import com.soft.blued.ui.find.observer.NearbyViewModel;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.user.model.VipInvisibleSettingModel;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/presenter/NearbyHomePresenter.class */
public class NearbyHomePresenter extends MvpPresenter {
    public boolean h;
    public boolean i;
    public List<HomeTopTabModel> j;
    public int k = 1;
    private SelectCityViewModel l;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Rect rect) {
        a("recommend_view_rect", rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Boolean bool) {
        if (bool.booleanValue()) {
            ChatHttpUtils.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Void r3) {
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Void r4) {
        f_("filter_state");
    }

    private void n() {
        ProfileHttpUtils.a(h(), new BluedUIHttpResponse<BluedEntityA<VipInvisibleSettingModel>>(g()) { // from class: com.soft.blued.ui.find.presenter.NearbyHomePresenter.10
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<VipInvisibleSettingModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                VipInvisibleSettingModel vipInvisibleSettingModel = (VipInvisibleSettingModel) bluedEntityA.data.get(0);
                boolean z = vipInvisibleSettingModel.is_invisible_all == 1;
                boolean z2 = vipInvisibleSettingModel.is_age_stealth == 1;
                Boolean valueOf = Boolean.valueOf((vipInvisibleSettingModel.is_role_stealth == 1) || (vipInvisibleSettingModel.is_stealth_distance == 1) || z2 || z);
                Log.v("drb", "--setDataToUI INVISIBLE_STATE:" + valueOf + " -- " + NearbyHomePresenter.this.g().isActive());
                NearbyHomePresenter.this.a("invisible_state", valueOf);
                NearbyHomePresenter.this.a("map_avatar_location_state", (Object) Boolean.valueOf(vipInvisibleSettingModel.avatar_location_status == 1), false);
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), g());
    }

    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        this.j = BluedConfig.a().c(fragmentActivity);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.j.size()) {
                return;
            }
            if (this.j.get(i2).tab_id == 2) {
                this.k = i2;
                return;
            }
            i = i2 + 1;
        }
    }

    public void a(LifecycleOwner lifecycleOwner) {
        super.a(lifecycleOwner);
        LiveEventBus.get(EventBusConstant.KEY_EVENT_NEARBY_ACTIVITY, BluedADExtra.class).observe(lifecycleOwner, new Observer<BluedADExtra>() { // from class: com.soft.blued.ui.find.presenter.NearbyHomePresenter.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(BluedADExtra bluedADExtra) {
                Log.v("drb", "KEY_EVENT_NEARBY_ACTIVITY onChanged");
                NearbyHomePresenter.this.a(EventBusConstant.KEY_EVENT_NEARBY_ACTIVITY, (Object) bluedADExtra, false);
            }
        });
        LiveEventBus.get("INVISIBLE_DISTANCE", Boolean.class).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.soft.blued.ui.find.presenter.NearbyHomePresenter.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                Log.v("drb", "onChanged:" + bool);
                NearbyHomePresenter.this.a("invisible_state", bool);
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_IS_CLICK_ON_HEADER, Boolean.class).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.soft.blued.ui.find.presenter.NearbyHomePresenter.3
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                NearbyHomePresenter.this.i = bool.booleanValue();
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_SET_TIP_VISIBILITY, Boolean.class).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.soft.blued.ui.find.presenter.NearbyHomePresenter.4
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                NearbyHomePresenter.this.a(EventBusConstant.KEY_EVENT_SET_TIP_VISIBILITY, false);
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_IS_SHOW_TIP, Boolean.class).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.soft.blued.ui.find.presenter.NearbyHomePresenter.5
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                NearbyHomePresenter.this.h = BluedPreferences.ac(UserInfo.getInstance().getLoginUserInfo().uid);
                String dY = BluedPreferences.dY();
                boolean z = false;
                if (!TextUtils.isEmpty(dY)) {
                    String[] split = dY.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    int intValue = Integer.valueOf(split[0]).intValue();
                    int intValue2 = Integer.valueOf(split[1]).intValue();
                    z = NearbyHomePresenter.this.a(intValue, intValue2, intValue, intValue2);
                }
                if ((UserInfo.getInstance().getLoginUserInfo().is_user_reactive != 1 && !z) || NearbyHomePresenter.this.h || NearbyHomePresenter.this.i) {
                    return;
                }
                NearbyHomePresenter.this.f_(EventBusConstant.KEY_EVENT_IS_SHOW_TIP);
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_MAP_STATE, Boolean.class).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.soft.blued.ui.find.presenter.NearbyHomePresenter.6
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                NearbyHomePresenter.this.a("map_avatar_location_state", bool);
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_SHOW_GOLD_ANIMAITON, Boolean.class).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.soft.blued.ui.find.presenter.NearbyHomePresenter.7
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                NearbyHomePresenter.this.a("show_gold_guide_animation", false);
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_SHOW_SHOW_RED_PACK_SIGN_TIP, String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.soft.blued.ui.find.presenter.NearbyHomePresenter.8
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                NearbyHomePresenter.this.a("SHOW_RED_PACK_SIGN_TIP", (Object) str, false);
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_FLASH_FREE_TIMES_TO_POST, Boolean.class).observe(lifecycleOwner, new Observer() { // from class: com.soft.blued.ui.find.presenter.-$$Lambda$NearbyHomePresenter$tEIY9S-PBDha9U8Wob2IhmkLobE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NearbyHomePresenter.a((Boolean) obj);
            }
        });
        if (HomeActivity.f17295c != null) {
            NearbyViewModel nearbyViewModel = (NearbyViewModel) ViewModelProviders.of((FragmentActivity) HomeActivity.f17295c).get(NearbyViewModel.class);
            nearbyViewModel.f16935a.observe(lifecycleOwner, new Observer() { // from class: com.soft.blued.ui.find.presenter.-$$Lambda$NearbyHomePresenter$roIZP6wkXK6_lRi5M8tLzXsLhi0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    NearbyHomePresenter.this.a((Rect) obj);
                }
            });
            nearbyViewModel.f16936c.observe(lifecycleOwner, new Observer() { // from class: com.soft.blued.ui.find.presenter.-$$Lambda$NearbyHomePresenter$n4VmhW-EuZl7MShnZgzWl2MqDW8
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    NearbyHomePresenter.this.b((Void) obj);
                }
            });
            nearbyViewModel.d.observe(lifecycleOwner, new Observer() { // from class: com.soft.blued.ui.find.presenter.-$$Lambda$NearbyHomePresenter$WY-JyIXucRS4rXKyt2aWNGnXthc
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    NearbyHomePresenter.this.a((Void) obj);
                }
            });
        }
        SelectCityViewModel selectCityViewModel = new ViewModelProvider((ViewModelStoreOwner) h(), ViewModelProvider.AndroidViewModelFactory.getInstance((Application) AppInfo.d())).get(SelectCityViewModel.class);
        this.l = selectCityViewModel;
        selectCityViewModel.d().observe(lifecycleOwner, new Observer<String>() { // from class: com.soft.blued.ui.find.presenter.NearbyHomePresenter.9
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                CityHelper.a().c(str);
                CityHelper.a().a(NearbyHomePresenter.this.l.e());
                CityHelper.a().b(NearbyHomePresenter.this.l.f());
                if (CityHelper.a().b()) {
                    for (HomeTopTabModel homeTopTabModel : NearbyHomePresenter.this.j) {
                        if (homeTopTabModel.tab_id == 2) {
                            homeTopTabModel.tab_title = CityHelper.a().g();
                        }
                    }
                    NearbyHomePresenter.this.a("home_city_title", false);
                    if (HomeActivity.f17295c != null) {
                        ((NearbyViewModel) ViewModelProviders.of((FragmentActivity) HomeActivity.f17295c).get(NearbyViewModel.class)).e.postValue(null);
                    }
                    EventTrackFeed.a(FeedProtos.Event.CITY_CHANGE, "");
                }
            }
        });
    }

    public void a(IRequestHost iRequestHost) {
        FindHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<MapChanceEncounterStatusModel>>(iRequestHost) { // from class: com.soft.blued.ui.find.presenter.NearbyHomePresenter.12
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MapChanceEncounterStatusModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                NearbyHomePresenter.this.a("REFRESH_MAP_ENTER_REMIND_STATUS", (MapChanceEncounterStatusModel) bluedEntityA.getSingleData());
            }
        }, iRequestHost, UserInfo.getInstance().getLoginUserInfo().uid, 1);
    }

    public void a(IFetchDataListener iFetchDataListener) {
        Log.v("drb", "onFetchData---");
        n();
    }

    public boolean a(int i, int i2, int i3, int i4) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        Time time = new Time();
        time.set(currentTimeMillis);
        Time time2 = new Time();
        time2.set(currentTimeMillis);
        time2.hour = i;
        time2.minute = i2;
        Time time3 = new Time();
        time3.set(currentTimeMillis);
        time3.hour = i3;
        time3.minute = i4;
        if (time2.before(time3)) {
            z = false;
            if (!time.before(time2)) {
                z = false;
                if (!time.after(time3)) {
                    z = true;
                }
            }
        } else {
            time2.set(time2.toMillis(true) - 86400000);
            z = false;
            if (!time.before(time2)) {
                z = false;
                if (!time.after(time3)) {
                    z = true;
                }
            }
            Time time4 = new Time();
            time4.set(time2.toMillis(true) + 86400000);
            if (!time.before(time4)) {
                return true;
            }
        }
        return z;
    }

    public void b(IFetchDataListener iFetchDataListener) {
    }

    public void m() {
        if (CityHelper.a().b()) {
            return;
        }
        FindHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<CityLocation>>(g()) { // from class: com.soft.blued.ui.find.presenter.NearbyHomePresenter.11
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<CityLocation> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                BluedPreferences.V(((CityLocation) bluedEntityA.getSingleData()).city_code);
                for (HomeTopTabModel homeTopTabModel : NearbyHomePresenter.this.j) {
                    if (homeTopTabModel.tab_id == 2) {
                        homeTopTabModel.tab_title = CityHelper.a().a(NearbyHomePresenter.this.h(), BluedPreferences.dd());
                    }
                }
                BluedPreferences.T(((CityLocation) bluedEntityA.getSingleData()).has_verify_mobile == 1);
                BluedPreferences.U(((CityLocation) bluedEntityA.getSingleData()).has_used_mobile == 1);
                NearbyHomePresenter.this.a("home_city_title", false);
            }
        }, CityHelper.a().c(), CityHelper.a().e(), g());
    }
}
