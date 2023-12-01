package com.blued.community.ui.square.presenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.amap.api.services.district.DistrictSearchQuery;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.listener.LocationHelperNew;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.ReflectionUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedDiversionExtra;
import com.blued.community.model.FeedDiversionModel;
import com.blued.community.model.FeedParse;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.send.observer.FeedRefreshObserver;
import com.blued.community.ui.square.model.NearbyFeedExtraModel;
import com.blued.community.ui.square.model.NearbyFeedListModel;
import com.blued.community.ui.square.model.NearbyTransformersModel;
import com.blued.community.ui.square.model.SignFeedExtra;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.utils.CityHelper;
import com.blued.community.utils.CommunityPreferences;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/presenter/NearbyFeedPresenter.class */
public class NearbyFeedPresenter extends MvpPresenter implements FeedRefreshObserver.IFeedRefreshObserver {
    public String k;
    private FeedListAdapterForRecyclerView l;
    private List<NearbyTransformersModel> o;
    private int m = 1;
    public int h = 0;
    private Map<Integer, NearbyFeedListModel> n = new HashMap();
    private String p = DistrictSearchQuery.KEYWORDS_CITY;
    private String q = "500";
    private String r = "";
    private boolean s = false;
    private boolean t = true;
    private String u = "";
    public BluedIngSelfFeed i = null;
    public int j = 0;
    private BluedTopic v = null;

    private BluedUIHttpResponse a(final int i, final IFetchDataListener iFetchDataListener, final boolean z) {
        return new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, NearbyFeedExtraModel>>("nearbyfeedlist" + i, g()) { // from class: com.blued.community.ui.square.presenter.NearbyFeedPresenter.7
            private void a(BluedEntity<BluedIngSelfFeed, NearbyFeedExtraModel> bluedEntity, int i2, boolean z2, boolean z3) {
                if (bluedEntity == null || bluedEntity.extra == null || bluedEntity.extra.activity_floor == null || TextUtils.isEmpty(bluedEntity.extra.activity_floor.pic) || TextUtils.isEmpty(bluedEntity.extra.activity_floor.title)) {
                    b(bluedEntity, i2, z2, z3);
                    return;
                }
                int i3 = bluedEntity.extra.activity_floor.position;
                if (i3 >= bluedEntity.data.size()) {
                    i3 = bluedEntity.data.size() - 1;
                } else if (bluedEntity.data.size() == 0) {
                    i3 = 0;
                }
                BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
                BluedIngSelfFeed bluedIngSelfFeed2 = bluedIngSelfFeed;
                if (i3 < bluedEntity.data.size()) {
                    bluedIngSelfFeed2 = bluedIngSelfFeed;
                    if (bluedEntity.data.size() > 0) {
                        bluedIngSelfFeed2 = bluedEntity.data.get(i3);
                    }
                }
                BluedIngSelfFeed bluedIngSelfFeed3 = (BluedIngSelfFeed) bluedIngSelfFeed2.clone();
                bluedIngSelfFeed3.feed_id = "0";
                bluedIngSelfFeed3.feed_uid = "0";
                bluedIngSelfFeed3.feed_type = -99;
                bluedIngSelfFeed3.dataType = 6;
                if (bluedEntity.data.size() > 0) {
                    bluedEntity.data.add(i3, bluedIngSelfFeed3);
                } else {
                    bluedEntity.data.add(bluedIngSelfFeed3);
                }
                if (iFetchDataListener != null) {
                    b(bluedEntity, i2, z2, z3);
                }
            }

            private void b(BluedEntity<BluedIngSelfFeed, NearbyFeedExtraModel> bluedEntity, int i2, boolean z2, boolean z3) {
                int i3 = 0;
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    NearbyFeedPresenter.this.b(i2).hasMore = false;
                } else {
                    NearbyFeedPresenter.this.u = "0";
                    List<BluedIngSelfFeed> list = bluedEntity.data;
                    while (i3 < list.size()) {
                        if (list.get(i3).ads_id > 0) {
                            NearbyFeedPresenter.this.u = String.valueOf(list.get(i3).ads_id);
                        }
                        int i4 = i3;
                        if (list.get(i3).is_join_circle == 1) {
                            list.remove(i3);
                            i4 = i3 - 1;
                        }
                        i3 = i4 + 1;
                    }
                    String c = z2 ? i2 == 2 ? "feed_time_list_cache" : "feed_default_list_cache" : NearbyFeedPresenter.this.c(i2);
                    IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                    if (iFetchDataListener2 != null) {
                        iFetchDataListener2.a(c, list);
                    } else {
                        NearbyFeedPresenter.this.a(c, (String) list);
                    }
                    NearbyFeedPresenter.this.b(i2).hasMore = bluedEntity.hasMore();
                }
                IFetchDataListener iFetchDataListener3 = iFetchDataListener;
                if (iFetchDataListener3 != null) {
                    iFetchDataListener3.b(NearbyFeedPresenter.this.b(i2).hasMore);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUICache(BluedEntity<BluedIngSelfFeed, NearbyFeedExtraModel> bluedEntity) {
                a(bluedEntity, i, true, z);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z2) {
                if (!z2) {
                    NearbyFeedPresenter.this.b(i).page--;
                }
                if (z2 && NearbyFeedPresenter.this.b(i).page == 1) {
                    CommunityManager.a.a().c(false);
                    CommunityPreferences.o(!CommunityPreferences.O().booleanValue());
                }
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a(z2);
                }
                int i2 = i;
                if (i2 == 1 && NearbyFeedPresenter.this.b(i2).page == 1) {
                    NearbyFeedPresenter.this.c(iFetchDataListener);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BluedIngSelfFeed, NearbyFeedExtraModel> bluedEntity) {
                a(bluedEntity, i, false, z);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public BluedEntity<BluedIngSelfFeed, NearbyFeedExtraModel> parseData(String str) {
                BluedEntity<BluedIngSelfFeed, NearbyFeedExtraModel> parseData = super.parseData(str);
                if (parseData != null) {
                    if (!parseData.hasData()) {
                        return parseData;
                    }
                    for (BluedIngSelfFeed bluedIngSelfFeed : parseData.data) {
                        bluedIngSelfFeed.feedParse = new FeedParse(NearbyFeedPresenter.this.h(), bluedIngSelfFeed, 6);
                    }
                }
                return parseData;
            }
        };
    }

    private void a(final int i, final IFetchDataListener iFetchDataListener) {
        if (CityHelper.a().b()) {
            b(i, iFetchDataListener);
        } else {
            CommunityServiceManager.c().a(new LocationHelperNew.LocationFinishListener() { // from class: com.blued.community.ui.square.presenter.NearbyFeedPresenter.4
                @Override // com.blued.android.module.common.listener.LocationHelperNew.LocationFinishListener
                public void a() {
                    NearbyFeedPresenter.this.b(i, iFetchDataListener);
                }

                @Override // com.blued.android.module.common.listener.LocationHelperNew.LocationFinishListener
                public void a(int i2) {
                    NearbyFeedPresenter.this.b(i, iFetchDataListener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<BluedIngSelfFeed> list) {
        BluedTopic bluedTopic = this.v;
        if (bluedTopic == null) {
            return;
        }
        FeedMethods.a(list, bluedTopic, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, IFetchDataListener iFetchDataListener) {
        if (b(i).page == 1) {
            b(i).hasMore = true;
        }
        if (!b(i).hasMore && b(i).page != 1) {
            b(i).page--;
            AppMethods.a((CharSequence) AppUtils.a(R.string.common_nomore_data));
            if (iFetchDataListener != null) {
                iFetchDataListener.a(true);
            }
        } else if (b(i).page == 1) {
            a("feed_data_list_refresh", false);
            FeedHttpUtils.a(a(i, iFetchDataListener, true), UserInfo.getInstance().getLoginUserInfo().getUid(), this.p, b(i).page + "", b(i).size + "", CityHelper.a().c(), CityHelper.a().e(), this.q, "", i, CommunityServiceManager.a().o(), this.s, this.u, 0, g());
            FeedHttpUtils.b(s(), CityHelper.a().c(), CityHelper.a().e(), CityHelper.a().c((Context) null), g());
            d(iFetchDataListener);
        } else {
            FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.l;
            if (feedListAdapterForRecyclerView != null && feedListAdapterForRecyclerView.c() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.r);
                sb.append(TextUtils.isEmpty("") ? "" : ",");
                sb.append("");
                this.r = sb.toString();
            }
            FeedHttpUtils.a(a(i, iFetchDataListener, false), UserInfo.getInstance().getLoginUserInfo().getUid(), this.p, b(i).page + "", b(i).size + "", CityHelper.a().c(), CityHelper.a().e(), this.q, this.r, i, CommunityServiceManager.a().o(), this.s, this.u, this.l.getData().size(), g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(int i) {
        return i != 2 ? "feed_default_list" : "feed_time_list";
    }

    private void d(IFetchDataListener iFetchDataListener) {
        FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, SignFeedExtra>>(g()) { // from class: com.blued.community.ui.square.presenter.NearbyFeedPresenter.8
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BluedIngSelfFeed, SignFeedExtra> bluedEntity) {
                if (bluedEntity.getSingleData() == null || bluedEntity.extra == null) {
                    return;
                }
                int i = bluedEntity.extra.insert_floor;
                BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
                ReflectionUtils.a(bluedEntity.getSingleData(), bluedIngSelfFeed);
                bluedIngSelfFeed.signStateList = new ArrayList();
                long j = 0;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= Math.min(5, bluedEntity.data.size())) {
                        break;
                    }
                    bluedIngSelfFeed.signStateList.add(bluedEntity.data.get(i3));
                    j = Math.max(j, CommonStringUtils.c(bluedEntity.data.get(i3).feed_timestamp));
                    i2 = i3 + 1;
                }
                bluedIngSelfFeed.feed_timestamp = String.valueOf(j);
                NearbyFeedPresenter.this.i = bluedIngSelfFeed;
                if (bluedEntity.extra != null) {
                    NearbyFeedPresenter.this.j = bluedEntity.extra.insert_floor;
                    if (NearbyFeedPresenter.this.j < 0) {
                        NearbyFeedPresenter.this.j = 0;
                    }
                }
            }
        }, 1, this.p, CityHelper.a().c(), CityHelper.a().e(), "", "", g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(IFetchDataListener iFetchDataListener) {
        a(2, iFetchDataListener);
    }

    private void r() {
        if (CityHelper.a().b()) {
            return;
        }
        CommunityServiceManager.c().a(new LocationHelperNew.LocationFinishListener() { // from class: com.blued.community.ui.square.presenter.NearbyFeedPresenter.5
            @Override // com.blued.android.module.common.listener.LocationHelperNew.LocationFinishListener
            public void a() {
                CommunityServiceManager.e().d();
            }

            @Override // com.blued.android.module.common.listener.LocationHelperNew.LocationFinishListener
            public void a(int i) {
            }
        });
    }

    private BluedUIHttpResponse s() {
        return new BluedUIHttpResponse<BluedEntityA<NearbyTransformersModel>>("nearby_transformers", g()) { // from class: com.blued.community.ui.square.presenter.NearbyFeedPresenter.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<NearbyTransformersModel> bluedEntityA) {
                NearbyFeedPresenter.this.o = bluedEntityA.data;
                NearbyFeedPresenter nearbyFeedPresenter = NearbyFeedPresenter.this;
                nearbyFeedPresenter.a("feed_operate", (String) nearbyFeedPresenter.o);
            }
        };
    }

    public void a(int i) {
        this.m = i;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        this.n.put(1, new NearbyFeedListModel());
        this.n.put(2, new NearbyFeedListModel());
        b(1).page = 1;
        b(2).page = 1;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(final LifecycleOwner lifecycleOwner) {
        super.a(lifecycleOwner);
        FeedMethods.a(lifecycleOwner, this.l);
        LiveEventBus.get("feed_delete", BluedIngSelfFeed.class).observe(lifecycleOwner, new Observer<BluedIngSelfFeed>() { // from class: com.blued.community.ui.square.presenter.NearbyFeedPresenter.1
            /* renamed from: a */
            public void onChanged(BluedIngSelfFeed bluedIngSelfFeed) {
                if (bluedIngSelfFeed == null) {
                    return;
                }
                NearbyFeedPresenter nearbyFeedPresenter = NearbyFeedPresenter.this;
                nearbyFeedPresenter.b(nearbyFeedPresenter.m).dataList.remove(bluedIngSelfFeed);
            }
        });
        CircleMethods.a(lifecycleOwner, this.l);
        FeedRefreshObserver.a().a(this);
        lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.blued.community.ui.square.presenter.NearbyFeedPresenter.2
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void onDestroy() {
                FeedRefreshObserver.a().b(NearbyFeedPresenter.this);
                lifecycleOwner.getLifecycle().removeObserver(this);
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(final IFetchDataListener iFetchDataListener) {
        if (this.t) {
            if (CommunityManager.a.a().b() && CommunityManager.a.a().a() != null) {
                this.k = CommunityManager.a.a().a().predestined_person_feed_ttids;
                LogUtils.c("冒泡插入ID:" + this.k);
            }
            b(1).page = 1;
            b(2).page = 1;
            a(1, iFetchDataListener);
            if (this.t) {
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.community.ui.square.presenter.-$$Lambda$NearbyFeedPresenter$WHKZaAqposVK1HrMtRde05TXqwk
                    @Override // java.lang.Runnable
                    public final void run() {
                        NearbyFeedPresenter.this.e(iFetchDataListener);
                    }
                }, 3000L);
            }
            this.t = false;
        } else {
            this.k = null;
            this.s = !this.s;
            CommunityServiceManager.a().b(false);
            b(this.m).page = 1;
            r();
            a(this.m, iFetchDataListener);
        }
        CommunityPreferences.f(TimeAndDateUtils.a());
    }

    public void a(FeedListAdapterForRecyclerView feedListAdapterForRecyclerView) {
        this.l = feedListAdapterForRecyclerView;
    }

    @Override // com.blued.community.ui.send.observer.FeedRefreshObserver.IFeedRefreshObserver
    public void a(Object obj, int i) {
        if (i == 2 && (obj instanceof BluedIngSelfFeed)) {
            BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) obj;
            if (this.l == null || CircleMethods.a(bluedIngSelfFeed)) {
                return;
            }
            this.l.addData(0, bluedIngSelfFeed);
            this.l.notifyDataSetChanged();
        }
    }

    public NearbyFeedListModel b(int i) {
        return this.n.get(Integer.valueOf(i));
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        b(this.m).page++;
        b(this.m, iFetchDataListener);
    }

    public void c(final IFetchDataListener iFetchDataListener) {
        FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntity<FeedDiversionModel, FeedDiversionExtra>>(g()) { // from class: com.blued.community.ui.square.presenter.NearbyFeedPresenter.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                if (z) {
                    return;
                }
                NearbyFeedPresenter.this.a("FEED_FLOAT_OP_DATA", (String) null);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<FeedDiversionModel, FeedDiversionExtra> bluedEntity) {
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a("FEED_FLOAT_OP_DATA", bluedEntity.data);
                }
                if (bluedEntity.extra != null) {
                    NearbyFeedPresenter.this.v = bluedEntity.extra.getGuide();
                }
                if (bluedEntity.getSingleData() == null || (bluedEntity.getSingleData().getSuspension_bubble() == null && bluedEntity.getSingleData().getButton_bubble() == null)) {
                    NearbyFeedPresenter nearbyFeedPresenter = NearbyFeedPresenter.this;
                    nearbyFeedPresenter.a(nearbyFeedPresenter.b(1).dataList);
                    if (NearbyFeedPresenter.this.n() == 1) {
                        NearbyFeedPresenter nearbyFeedPresenter2 = NearbyFeedPresenter.this;
                        nearbyFeedPresenter2.a(nearbyFeedPresenter2.c(1), (String) NearbyFeedPresenter.this.b(1).dataList, false);
                    }
                }
            }
        }, 1, CommunityManager.a.a().d(), g());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void k() {
        a("feed_data_list_refresh", false);
        a(1, (IFetchDataListener) null, false).refresh();
        a(2, (IFetchDataListener) null, false).refresh();
        s().refresh();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public String[] l() {
        return new String[]{"feed_default_list"};
    }

    public boolean m() {
        return b(this.m).hasMore;
    }

    public int n() {
        return this.m;
    }

    public NearbyFeedListModel o() {
        return b(1);
    }

    public NearbyFeedListModel p() {
        return b(2);
    }

    public List<NearbyTransformersModel> q() {
        if (this.o == null) {
            this.o = new ArrayList();
        }
        return this.o;
    }
}
