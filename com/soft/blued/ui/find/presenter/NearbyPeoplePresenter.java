package com.soft.blued.ui.find.presenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.config.FlexDebugSevConfig;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.statistics.BluedStatistics;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.FeedTopBannerModel;
import com.blued.community.model.HomeTabBubble;
import com.blued.community.model.HomeTabBubbleExtra;
import com.blued.community.ui.square.model.NearbyTransformersExtra;
import com.blued.community.ui.square.model.NearbyTransformersModel;
import com.blued.community.utils.CityHelper;
import com.blued.das.guy.GuyProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.log.bytedance.GuyEventUtils;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.manager.FollowedUsersNotificationManager;
import com.soft.blued.ui.ab_test.models.ShortEntranceExtra;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.manager.MapFindManager;
import com.soft.blued.ui.find.model.AdvertFloatExtra;
import com.soft.blued.ui.find.model.AdvertFloatModel;
import com.soft.blued.ui.find.model.CallHelloModel;
import com.soft.blued.ui.find.model.CallMeStatusData;
import com.soft.blued.ui.find.model.CheckNearbyAdModel;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.find.model.FindDataExtra;
import com.soft.blued.ui.find.model.FindRecommendData;
import com.soft.blued.ui.find.model.FindRecommendExtra;
import com.soft.blued.ui.find.model.JoyEntryModel;
import com.soft.blued.ui.find.model.NearbyChatRoomModel;
import com.soft.blued.ui.find.model.RecommendPopModel;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.find.model.UsersNewCallBubbleModel;
import com.soft.blued.ui.find.observer.CallHelloObserver;
import com.soft.blued.ui.find.observer.FloatRedBagViewScrollObserver;
import com.soft.blued.ui.find.observer.NearbyPeoplePushTypeObserver;
import com.soft.blued.ui.find.observer.NearbyPeopleTabSelectedObserver;
import com.soft.blued.ui.find.observer.NearbyViewModel;
import com.soft.blued.ui.find.observer.PeopleDataObserver;
import com.soft.blued.ui.find.observer.SetModelObserver;
import com.soft.blued.ui.find.view.RecommendPopView;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.msg.model.FriendsNotificationExtra;
import com.soft.blued.ui.welcome.model.NearbyTwoFloorModel;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/presenter/NearbyPeoplePresenter.class */
public class NearbyPeoplePresenter extends MvpPresenter implements CallHelloObserver.ICallHelloObserver, FloatRedBagViewScrollObserver.IFloatRedBagViewScrollObserver, NearbyPeoplePushTypeObserver.INearbyPeoplePushTypeObserver, NearbyPeopleTabSelectedObserver.INearbyPeopleTabSelectedObserver, PeopleDataObserver.IFriendsDataRefreshObserver, SetModelObserver.ISetModelObserver {
    public boolean h;
    public AdvertFloatModel i;
    public int k;
    public int l;
    public boolean p;
    public List<UserFindResult> r;
    public BluedEntity<FindRecommendData, FindRecommendExtra> t;
    private String y;
    public String j = null;
    public int m = 0;
    public int n = 1;
    private int u = 60;
    public boolean o = true;
    public boolean q = false;
    private FilterEntity v = new FilterEntity();
    private boolean w = false;
    private List<UserFindResult> x = new ArrayList();
    private boolean z = true;
    private Observer<String> A = new Observer<String>() { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.6
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(String str) {
            NearbyPeoplePresenter.this.a(" header_two_level", false);
        }
    };
    private boolean B = true;
    public BluedUIHttpResponse s = new BluedUIHttpResponse<BluedEntity<JoyEntryModel, ShortEntranceExtra>>("joy_enter_btest", w()) { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.10
        public void onSuccess(String str) {
            super.onSuccess(str);
            Logger.a("drb", "content:" + str);
        }

        public void onUICache(BluedEntity<JoyEntryModel, ShortEntranceExtra> bluedEntity) {
            super.onUICache(bluedEntity);
            if (bluedEntity != null) {
                NearbyPeoplePresenter.this.a("entry_data_cache", (Object) ((ShortEntranceExtra) bluedEntity.extra), false);
            }
        }

        public void onUIUpdate(BluedEntity<JoyEntryModel, ShortEntranceExtra> bluedEntity) {
            if (bluedEntity != null) {
                NearbyPeoplePresenter.this.a("entry_data", (Object) ((ShortEntranceExtra) bluedEntity.extra), false);
            }
        }
    };
    private BluedUIHttpResponse<BluedEntityA<NearbyTwoFloorModel>> C = new BluedUIHttpResponse<BluedEntityA<NearbyTwoFloorModel>>(w()) { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.15
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<NearbyTwoFloorModel> bluedEntityA) {
            if (bluedEntityA == null) {
                NearbyPeoplePresenter.this.f_("two_level_no_data");
            } else if (bluedEntityA.hasData()) {
                NearbyPeoplePresenter.this.a("two_level", bluedEntityA.data);
            } else {
                NearbyPeoplePresenter.this.f_("two_level_no_data");
            }
        }

        public boolean onUIFailure(int i, String str) {
            Log.v("drb", "getBaseTwoLevel onUIFailure：" + str);
            return super.onUIFailure(i, str);
        }
    };
    private boolean D = false;
    private long E = 0;
    private final HashMap<String, Long> F = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        FindHttpUtils.b(new BluedUIHttpResponse<BluedEntity<FindRecommendData, FindRecommendExtra>>(w()) { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.14
            public void onUIUpdate(BluedEntity<FindRecommendData, FindRecommendExtra> bluedEntity) {
                if (bluedEntity.hasData() || bluedEntity.extra != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(bluedEntity.data);
                    LiveRoomManager.a().f(LiveRoomInfoChannel.b(arrayList, "nearby_mix_recommend"));
                }
            }
        }, w());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        String simpleName = getClass().getSimpleName();
        Logger.c(simpleName, "KEY_EVENT_MAP_FIND_CLICK=====" + bool);
        if (g().isActive()) {
            a("map_find", (Object) bool, false);
        } else {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        Long l = this.F.get(str);
        if (l != null) {
            long longValue = l.longValue();
            if (longValue > 0) {
                this.F.put(str, Long.valueOf(longValue - 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(String str) {
        a(" prepare_to_play", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IRequestHost w() {
        if (h() instanceof BaseFragmentActivity) {
            return h().a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        FeedHttpUtils.b(new BluedUIHttpResponse<BluedEntity<NearbyTransformersModel, NearbyTransformersExtra>>(g()) { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.7
            public void onUIFinish() {
                NearbyPeoplePresenter.this.u();
            }

            public void onUIUpdate(BluedEntity<NearbyTransformersModel, NearbyTransformersExtra> bluedEntity) {
                if (bluedEntity == null || bluedEntity.extra == null) {
                    return;
                }
                LiveEventBus.get("Nearby_Transformers_Extra").post(bluedEntity.extra.adv_extra_json);
            }
        }, CityHelper.a().c(), CityHelper.a().e(), CityHelper.a().c((Context) null), g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        NearbyHttpUtils.d(new BluedUIHttpResponse<BluedEntity<HomeTabBubble, HomeTabBubbleExtra>>(w()) { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.9
            public void onUIUpdate(BluedEntity<HomeTabBubble, HomeTabBubbleExtra> bluedEntity) {
                HomeTabBubble homeTabBubble = (bluedEntity == null || !bluedEntity.hasData()) ? null : (HomeTabBubble) bluedEntity.getSingleData();
                CommunityManager.a.a().a(bluedEntity.extra);
                LiveEventBus.get("home_tab_bubble").postDelay(homeTabBubble, NearbyPeoplePresenter.this.i != null ? 2000L : 0L);
            }
        }, w());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        FindHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<UsersNewCallBubbleModel>>(w()) { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.13
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UsersNewCallBubbleModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                NearbyPeoplePresenter.this.a("sho_new_call_bubble", (UsersNewCallBubbleModel) bluedEntityA.getSingleData());
            }
        }, w(), UserInfo.getInstance().getLoginUserInfo().uid);
    }

    public BluedUIHttpResponse a(final IFetchDataListener iFetchDataListener, final String str) {
        return new BluedUIHttpResponse<BluedEntity<UserFindResult, FindDataExtra>>("nearby_user_" + this.j, w()) { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.11
            public void onUICache(BluedEntity<UserFindResult, FindDataExtra> bluedEntity) {
                super.onUICache(bluedEntity);
                if (bluedEntity != null) {
                    NearbyPeoplePresenter.this.a("people_data", (Object) bluedEntity.data, false);
                    if (bluedEntity.extra != null && !TypeUtils.a(((FindDataExtra) bluedEntity.extra).nearby_dating) && ((FindDataExtra) bluedEntity.extra).nearby_dating.get(0) != null) {
                        ((FindDataExtra) bluedEntity.extra).nearby_dating.get(0).popup = null;
                    }
                    NearbyPeoplePresenter.this.a("people_data_extra_cache", (Object) ((FindDataExtra) bluedEntity.extra), false);
                }
            }

            public boolean onUIFailure(int i, String str2) {
                return super.onUIFailure(i, str2);
            }

            public boolean onUIFailure(int i, String str2, String str3) {
                if (i != -2011 && (i < 499 || i > 599)) {
                    NearbyPeoplePresenter.this.f("people");
                }
                return super.onUIFailure(i, str2, str3);
            }

            public void onUIFinish(boolean z) {
                if (!z) {
                    NearbyPeoplePresenter.this.n--;
                }
                if (NearbyPeoplePresenter.this.B) {
                    NearbyPeoplePresenter.this.x();
                    NearbyPeoplePresenter.this.B = false;
                }
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a(z);
                }
            }

            public void onUIStart() {
                super.onUIStart();
                NearbyPeoplePresenter.this.m++;
            }

            public void onUIUpdate(BluedEntity<UserFindResult, FindDataExtra> bluedEntity) {
                NearbyPeoplePresenter.this.f("people");
                String simpleName = NearbyPeoplePresenter.class.getSimpleName();
                Logger.c(simpleName, "people onUIUpdate=====" + bluedEntity.data.size());
                if (TextUtils.isEmpty(NearbyPeoplePresenter.this.j) || !NearbyPeoplePresenter.this.j.equals(str)) {
                    return;
                }
                if (bluedEntity != null) {
                    if (NearbyPeoplePresenter.this.x.size() > 0 && NearbyPeoplePresenter.this.n == 1) {
                        bluedEntity.data.addAll(0, NearbyPeoplePresenter.this.x);
                        NearbyPeoplePresenter.this.x.clear();
                    }
                    NearbyPeoplePresenter.this.a("people_data", (Object) bluedEntity.data, false);
                    NearbyPeoplePresenter.this.a("people_data_extra", (Object) ((FindDataExtra) bluedEntity.extra), false);
                    NearbyPeoplePresenter.this.a("refresh_num_plus", false);
                    NearbyPeoplePresenter.this.a(" show_chat_room", (Object) 10);
                    NearbyPeoplePresenter.this.p = bluedEntity.hasMore();
                    IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                    if (iFetchDataListener2 != null) {
                        iFetchDataListener2.b(NearbyPeoplePresenter.this.p);
                    }
                } else {
                    NearbyPeoplePresenter.this.p = false;
                }
                if (NearbyPeoplePresenter.this.g().isActive()) {
                    return;
                }
                NearbyPeoplePresenter.this.r = bluedEntity.data;
            }

            public BluedEntity<UserFindResult, FindDataExtra> parseData(String str2) {
                BluedEntity<UserFindResult, FindDataExtra> parseData = super.parseData(str2);
                if (parseData != null && parseData.hasData()) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= parseData.data.size()) {
                            break;
                        }
                        ((UserFindResult) parseData.data.get(i2)).distanceStr = DistanceUtils.a(((UserFindResult) parseData.data.get(i2)).distance, BlueAppLocal.c(), false);
                        ((UserFindResult) parseData.data.get(i2)).last_operate_time_stamp = ((UserFindResult) parseData.data.get(i2)).last_operate;
                        ((UserFindResult) parseData.data.get(i2)).last_operate_str = TimeAndDateUtils.a(NearbyPeoplePresenter.this.h(), TimeAndDateUtils.c(((UserFindResult) parseData.data.get(i2)).last_operate));
                        if (TextUtils.isEmpty(((UserFindResult) parseData.data.get(i2)).last_operate_str)) {
                            ((UserFindResult) parseData.data.get(i2)).last_operate_str = AppInfo.d().getString(R.string.unknown);
                        }
                        if (NearbyPeoplePresenter.this.d(((UserFindResult) parseData.data.get(i2)).last_operate_str)) {
                            BluedStatistics.c().a("NEARBY_TIME", 0L, 0, "my_uid:" + UserInfo.getInstance().getLoginUserInfo().uid + " --uid:" + ((UserFindResult) parseData.data.get(i2)).uid + " --last_operate:" + ((UserFindResult) parseData.data.get(i2)).last_operate);
                        }
                        i = i2 + 1;
                    }
                }
                if (parseData != null && parseData.extra != null && !TypeUtils.a(((FindDataExtra) parseData.extra).nearby_dating) && ((FindDataExtra) parseData.extra).nearby_dating.size() > 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= ((FindDataExtra) parseData.extra).nearby_dating.size()) {
                            break;
                        }
                        if (((FindDataExtra) parseData.extra).nearby_dating.get(i4).show_layer == 3 && ((FindDataExtra) parseData.extra).nearby_dating.get(i4).popup != null) {
                            ((FindDataExtra) parseData.extra).nearby_dating.get(i4).popup.setSourcePage(str);
                        }
                        i3 = i4 + 1;
                    }
                }
                return parseData;
            }
        };
    }

    @Override // com.soft.blued.ui.find.observer.SetModelObserver.ISetModelObserver
    public void a(int i) {
        a("notify_model", (Object) Integer.valueOf(i), false);
    }

    public void a(int i, List<UserFindResult> list, String str) {
        ArrayList<UserFindResult> arrayList = new ArrayList();
        if (list.size() > i) {
            arrayList.add(list.get(i));
        }
        int i2 = i + 1;
        if (list.size() > i2) {
            arrayList.add(list.get(i2));
        }
        ArrayList arrayList2 = new ArrayList();
        for (UserFindResult userFindResult : arrayList) {
            if (userFindResult.vbadge != 4) {
                CheckNearbyAdModel checkNearbyAdModel = new CheckNearbyAdModel();
                checkNearbyAdModel.setAuthor(userFindResult.name);
                checkNearbyAdModel.setTitle(userFindResult.name);
                checkNearbyAdModel.setBody(userFindResult.description);
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(userFindResult.avatar);
                checkNearbyAdModel.setImages(arrayList3);
                arrayList2.add(checkNearbyAdModel);
            }
        }
        FindHttpUtils.a(str.replace("_CTX_", AppInfo.f().toJson(arrayList2)), new BluedUIHttpResponse<BluedEntityA>(w()) { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.17
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA bluedEntityA) {
            }
        }, w());
    }

    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        this.l = PeopleGridQuickAdapter.a(h());
        m();
        int J = BluedPreferences.J();
        this.k = J;
        a(J);
        GuyEventUtils.a("NEARBY_FRIEND_SHOW");
    }

    public void a(final LifecycleOwner lifecycleOwner) {
        super.a(lifecycleOwner);
        PeopleDataObserver.a().a(this);
        SetModelObserver.a().a(this);
        FloatRedBagViewScrollObserver.a().a(this);
        NearbyPeopleTabSelectedObserver.a().a(this);
        NearbyPeoplePushTypeObserver.a().a(this);
        CallHelloObserver.a().a(this, lifecycleOwner.getLifecycle());
        Log.v("drb", "onRegisterLiveListener");
        lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.1
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void onDestroy() {
                Log.v("drb", "unRegistorObserver");
                PeopleDataObserver.a().b(NearbyPeoplePresenter.this);
                SetModelObserver.a().b(NearbyPeoplePresenter.this);
                FloatRedBagViewScrollObserver.a().b(NearbyPeoplePresenter.this);
                NearbyPeopleTabSelectedObserver.a().b(NearbyPeoplePresenter.this);
                NearbyPeoplePushTypeObserver.a().b(NearbyPeoplePresenter.this);
                LiveEventBus.get("live_back_to_two_level", String.class).removeObserver(NearbyPeoplePresenter.this.A);
                lifecycleOwner.getLifecycle().removeObserver(this);
            }
        });
        if (HomeActivity.f17295c != null) {
            NearbyViewModel nearbyViewModel = (NearbyViewModel) ViewModelProviders.of((FragmentActivity) HomeActivity.f17295c).get(NearbyViewModel.class);
            LiveEventBus.get(EventBusConstant.KEY_EVENT_MAP_FIND_CLICK, Boolean.class).observeForever(new Observer() { // from class: com.soft.blued.ui.find.presenter.-$$Lambda$NearbyPeoplePresenter$Wrn0Xt9Re5IRXWgEJmCQF51meMw
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    NearbyPeoplePresenter.this.a((Boolean) obj);
                }
            });
            nearbyViewModel.b.observe(lifecycleOwner, new Observer<Void>() { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.2
                @Override // androidx.lifecycle.Observer
                /* renamed from: a */
                public void onChanged(Void r5) {
                    NearbyPeoplePresenter.this.a("list_mode", false);
                }
            });
        }
        LiveEventBus.get(EventBusConstant.KEY_EVENT_BLUED_SKIN, Boolean.class).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.3
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                NearbyPeoplePresenter.this.a("sort_by_view", false);
            }
        });
        LiveEventBus.get("live_float_dismiss", String.class).observe(lifecycleOwner, new Observer() { // from class: com.soft.blued.ui.find.presenter.-$$Lambda$NearbyPeoplePresenter$8yXkcIdcE9Xz595t-Yf8oJ5zl7k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NearbyPeoplePresenter.this.g((String) obj);
            }
        });
        LiveEventBus.get("live_back_to_two_level", String.class).observeForever(this.A);
        LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_RED_PACK_GUIDE_STATE, Boolean.class).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.4
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                NearbyPeoplePresenter.this.a(EventBusConstant.KEY_EVENT_REFRESH_RED_PACK_GUIDE_STATE, (Object) bool, false);
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_USER_VIP_INFO, Boolean.class).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.5
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                NearbyPeoplePresenter.this.a("refresh_vip_to_visible", false);
            }
        });
    }

    @Override // com.soft.blued.ui.find.observer.FloatRedBagViewScrollObserver.IFloatRedBagViewScrollObserver
    public void a(RecyclerView recyclerView, int i, int i2) {
    }

    public void a(IFetchDataListener iFetchDataListener) {
        Log.v("drb", "onFetchData");
        this.n = 1;
        BluedPreferences.ay(BluedPreferences.fH().equals("operate") ? "super_call" : "operate");
        c(iFetchDataListener);
        t();
        if (this.z) {
            this.z = false;
            AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.find.presenter.-$$Lambda$NearbyPeoplePresenter$zautq66ABPlxi2pkYgDVoe3qJnc
                @Override // java.lang.Runnable
                public final void run() {
                    NearbyHttpUtils.b();
                }
            }, 1000L);
        }
    }

    @Override // com.soft.blued.ui.find.observer.CallHelloObserver.ICallHelloObserver
    public void a(CallMeStatusData callMeStatusData) {
        a("set_call_data_update", callMeStatusData);
    }

    @Override // com.soft.blued.ui.find.observer.NearbyPeoplePushTypeObserver.INearbyPeoplePushTypeObserver
    public void a(String str) {
        this.y = str;
        e();
    }

    public void a(final boolean z) {
        FindHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<NearbyChatRoomModel>>(w()) { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.16
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<NearbyChatRoomModel> bluedEntityA) {
                NearbyChatRoomModel nearbyChatRoomModel = (NearbyChatRoomModel) bluedEntityA.getSingleData();
                NearbyPeoplePresenter.this.a(" show_chat_room", nearbyChatRoomModel);
                if (z && nearbyChatRoomModel != null && nearbyChatRoomModel.show) {
                    EventTrackGuy.b(GuyProtos.Event.NEARBY_CHATROOM_ENTRY_SHOW);
                    Log.v("drb", "上抛埋点");
                }
            }

            public void onUIFinish() {
                super.onUIFinish();
            }
        });
    }

    @Override // com.soft.blued.ui.find.observer.CallHelloObserver.ICallHelloObserver
    public void a(boolean z, String str) {
        CallHelloModel callHelloModel = new CallHelloModel();
        callHelloModel.isShowCount = z;
        callHelloModel.count = str;
        a("count_update", callHelloModel);
    }

    @Override // com.soft.blued.ui.find.observer.PeopleDataObserver.IFriendsDataRefreshObserver
    public void ac_() {
        a("people_data_refresh", false);
    }

    @Override // com.soft.blued.ui.find.observer.PeopleDataObserver.IFriendsDataRefreshObserver
    public void ad_() {
        f_("home_refresh");
    }

    @Override // com.soft.blued.ui.find.observer.CallHelloObserver.ICallHelloObserver
    public void b(int i) {
        CallHelloModel callHelloModel = new CallHelloModel();
        callHelloModel.countDown = i;
        a("set_time_update", callHelloModel);
    }

    public void b(IFetchDataListener iFetchDataListener) {
        this.n++;
        c(iFetchDataListener);
    }

    @Override // com.soft.blued.ui.find.observer.NearbyPeopleTabSelectedObserver.INearbyPeopleTabSelectedObserver
    public void b(String str) {
        a("selected_tab", str);
    }

    public void c(int i) {
        this.k = i;
        BluedPreferences.b(i);
    }

    public void c(IFetchDataListener iFetchDataListener) {
        int i = this.u;
        int i2 = this.n;
        this.v.sort_by = this.j;
        if (MapFindManager.a().b()) {
            this.v.longitude = MapFindManager.a().c().f16909a;
            this.v.latitude = MapFindManager.a().c().b;
            this.v.source = "map";
        } else {
            this.v.longitude = CommonPreferences.u();
            this.v.latitude = CommonPreferences.v();
            this.v.source = null;
        }
        this.v.nickName = "";
        FilterEntity filterEntity = this.v;
        filterEntity.limit = this.u + "";
        this.v.column = this.l;
        this.v.scroll_type = BluedPreferences.y();
        this.v.custom = UserInfo.getInstance().getLoginUserInfo() == null ? "" : UserInfo.getInstance().getLoginUserInfo().getCustom();
        FilterEntity filterEntity2 = this.v;
        filterEntity2.start = (i * (i2 - 1)) + "";
        if (h() != null) {
            NearbyHttpUtils.a(h(), a(iFetchDataListener, this.j), this.v, "", w());
        }
    }

    public boolean d(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public boolean e(String str) {
        if (FlexDebugSevConfig.a().b().refresh_limit_count > 0) {
            Long l = this.F.get(str);
            long longValue = l != null ? l.longValue() : 0L;
            if (this.E + (FlexDebugSevConfig.a().b().refresh_limit_interval * 1000) <= System.currentTimeMillis()) {
                this.E = System.currentTimeMillis();
                for (Map.Entry<String, Long> entry : this.F.entrySet()) {
                    entry.setValue(1L);
                }
                return false;
            } else if (longValue <= FlexDebugSevConfig.a().b().refresh_limit_count) {
                this.F.put(str, Long.valueOf(longValue + 1));
                return false;
            } else if (str.equals("people")) {
                EventTrackGuy.b(GuyProtos.Event.PAGE_REFRESH_NO_API);
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public void k() {
        Log.v("drb", "onFetchCache");
        this.s.refresh();
        a((IFetchDataListener) null, this.j).refresh();
    }

    public void m() {
        NearbyHttpUtils.a(new BluedUIHttpResponse<BluedEntity<AdvertFloatModel, AdvertFloatExtra>>(w()) { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.8
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
            }

            public void onUIFinish() {
                NearbyPeoplePresenter.this.y();
            }

            public void onUIUpdate(BluedEntity<AdvertFloatModel, AdvertFloatExtra> bluedEntity) {
                boolean z = true;
                if (bluedEntity != null && bluedEntity.extra != null) {
                    if (((AdvertFloatExtra) bluedEntity.extra).is_after_splash != 1 && BluedPreferences.bp()) {
                        BluedPreferences.I(false);
                    }
                    if (z || bluedEntity == null || bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                        return;
                    }
                    NearbyPeoplePresenter.this.i = (AdvertFloatModel) bluedEntity.data.get(0);
                    if (NearbyPeoplePresenter.this.i == null || NearbyPeoplePresenter.this.i.images == null) {
                        return;
                    }
                    if (AppInfo.l >= 720) {
                        NearbyPeoplePresenter.this.i.advert_pic = NearbyPeoplePresenter.this.i.images._795x1020;
                    } else {
                        NearbyPeoplePresenter.this.i.advert_pic = NearbyPeoplePresenter.this.i.images._530x680;
                    }
                    ImageFileLoader.a(NearbyPeoplePresenter.this.w()).a(NearbyPeoplePresenter.this.i.advert_pic).a(new ImageLoadResult(NearbyPeoplePresenter.this.w()) { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.8.1
                        public void a() {
                            if (NearbyPeoplePresenter.this.i != null) {
                                NearbyPeoplePresenter.this.h = true;
                                NearbyPeoplePresenter.this.f_("advert_float");
                            }
                        }
                    }).a();
                    return;
                }
                z = false;
                if (z) {
                }
            }
        }, w());
    }

    public void n() {
        NearbyHttpUtils.a(this.s, w(), UserInfo.getInstance().getLoginUserInfo().getUid(), "full_index");
    }

    public void o() {
        Log.v("drb", "getMakeFriendRecommend -- ");
        if (e("live")) {
            f_("make_friend_recommend");
        } else {
            FindHttpUtils.b(new BluedUIHttpResponse<BluedEntity<FindRecommendData, FindRecommendExtra>>(w()) { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.12
                public boolean onUIFailure(int i, String str, String str2) {
                    if (i != -2011 && (i < 499 || i > 599)) {
                        NearbyPeoplePresenter.this.f("live");
                    }
                    return super.onUIFailure(i, str, str2);
                }

                public void onUIFinish() {
                    NearbyPeoplePresenter.this.f_("make_friend_recommend");
                    super.onUIFinish();
                }

                public void onUIUpdate(BluedEntity<FindRecommendData, FindRecommendExtra> bluedEntity) {
                    NearbyPeoplePresenter.this.f("live");
                    if (bluedEntity.hasData() || bluedEntity.extra != null) {
                        NearbyPeoplePresenter.this.t = bluedEntity;
                    }
                    NearbyPeoplePresenter.this.A();
                    NearbyPeoplePresenter.this.z();
                }
            }, w());
        }
    }

    public void p() {
        LiveHttpUtils.a(this.C, w());
        EventTrackGuy.b(GuyProtos.Event.HOME_REFRESH_SECOND_AD_REQUEST);
    }

    public FilterEntity q() {
        return this.v;
    }

    public boolean r() {
        return this.k == 0;
    }

    public boolean s() {
        return this.k == 1;
    }

    public void t() {
        FindHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<UserFindResult>>(w()) { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.18
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserFindResult> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                if (BluedPreferences.fj() == 0) {
                    BluedPreferences.D(System.currentTimeMillis());
                }
                if (NearbyPeoplePresenter.this.x.size() > 0) {
                    NearbyPeoplePresenter.this.x.clear();
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= bluedEntityA.data.size()) {
                        return;
                    }
                    UserFindResult userFindResult = (UserFindResult) bluedEntityA.data.get(i2);
                    userFindResult.distanceStr = DistanceUtils.a(userFindResult.distance, BlueAppLocal.c(), false);
                    userFindResult.last_operate_time_stamp = userFindResult.last_operate;
                    userFindResult.last_operate_str = TimeAndDateUtils.a(AppInfo.d(), TimeAndDateUtils.c(userFindResult.last_operate));
                    if (TextUtils.isEmpty(userFindResult.last_operate_str)) {
                        userFindResult.last_operate_str = AppInfo.d().getString(R.string.unknown);
                    }
                    NearbyPeoplePresenter.this.x.add(userFindResult);
                    i = i2 + 1;
                }
            }
        }, w(), this.y);
    }

    public void u() {
        if (this.D) {
            return;
        }
        this.D = true;
        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.19
            @Override // java.lang.Runnable
            public void run() {
                if (CommunityManager.a.a().m()) {
                    return;
                }
                int fK = BluedPreferences.fK();
                int i = Calendar.getInstance().get(6);
                if (fK == i) {
                    return;
                }
                BluedPreferences.A(i);
                NearbyHttpUtils.e(new BluedUIHttpResponse<BluedEntityA<RecommendPopModel>>(NearbyPeoplePresenter.this.w()) { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.19.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<RecommendPopModel> bluedEntityA) {
                        if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || NearbyPeoplePresenter.this.h() == null) {
                            return;
                        }
                        EventTrackGuy.b(GuyProtos.Event.PICK_FOR_YOU_POP_SHOW);
                        new XPopup.Builder(NearbyPeoplePresenter.this.h()).a(new RecommendPopView(NearbyPeoplePresenter.this.h(), bluedEntityA.data)).h();
                    }

                    public boolean onUIFailure(int i2, String str) {
                        return true;
                    }
                }, NearbyPeoplePresenter.this.w());
            }
        });
    }

    public void v() {
        FeedHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<FeedTopBannerModel>>(w()) { // from class: com.soft.blued.ui.find.presenter.NearbyPeoplePresenter.20
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<FeedTopBannerModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                FeedTopBannerModel feedTopBannerModel = (FeedTopBannerModel) bluedEntityA.getSingleData();
                ChattingModel chattingModel = new ChattingModel();
                chattingModel.msgType = (short) 274;
                FriendsNotificationExtra friendsNotificationExtra = new FriendsNotificationExtra();
                friendsNotificationExtra.push_type = 5;
                friendsNotificationExtra.extra = AppInfo.f().toJson(feedTopBannerModel);
                chattingModel.setMsgExtra(AppInfo.f().toJson(friendsNotificationExtra));
                FollowedUsersNotificationManager.f16008a.a(chattingModel);
            }
        }, w());
    }
}
