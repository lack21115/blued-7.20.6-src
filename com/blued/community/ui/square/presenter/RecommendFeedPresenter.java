package com.blued.community.ui.square.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.LogUtils;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.ChatRoom;
import com.blued.community.model.FeedDiversionExtra;
import com.blued.community.model.FeedDiversionModel;
import com.blued.community.model.LiveRecommendExtra;
import com.blued.community.ui.circle.adapter.CircleListAdapter;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.square.adapter.FeedHorizontalRecommendAdapter;
import com.blued.community.ui.square.adapter.RecommendChatRoomAdapter;
import com.blued.community.ui.square.adapter.RecommendTopicAdapter;
import com.blued.community.ui.square.model.CommBannerModel;
import com.blued.community.ui.square.model.DiscoverRecommendModel;
import com.blued.community.ui.square.model.DiscoverSquareExtra;
import com.blued.community.ui.square.model.FeedRecommendUser;
import com.blued.community.ui.square.model.SquareRecommendExtra;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.utils.CommunityPreferences;
import com.google.gson.reflect.TypeToken;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/presenter/RecommendFeedPresenter.class */
public class RecommendFeedPresenter extends MvpPresenter {
    private FeedListAdapterForRecyclerView k;
    private List<BluedIngSelfFeed> l;
    private int n;
    private int i = 1;
    private boolean j = true;
    private BluedTopic m = null;
    public String h = "";

    private BluedUIHttpResponse a(final IFetchDataListener iFetchDataListener, final boolean z) {
        return new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, DiscoverSquareExtra>>("discoverylistdata", g()) { // from class: com.blued.community.ui.square.presenter.RecommendFeedPresenter.5
            private void a(BluedEntity<BluedIngSelfFeed, DiscoverSquareExtra> bluedEntity, boolean z2) {
                List<DiscoverSquareExtra.Explore> defaultExplores = (bluedEntity.extra == null || bluedEntity.extra.explore_list == null || bluedEntity.extra.explore_list.size() <= 0) ? DiscoverSquareExtra.getDefaultExplores() : bluedEntity.extra.explore_list;
                if (RecommendFeedPresenter.this.i == 1 && bluedEntity.extra != null) {
                    CommunityPreferences.l(bluedEntity.extra.super_num);
                }
                if (z2) {
                    return;
                }
                RecommendFeedPresenter.this.a("discover_entry", (String) defaultExplores);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUICache(BluedEntity<BluedIngSelfFeed, DiscoverSquareExtra> bluedEntity) {
                super.onUICache(bluedEntity);
                if (bluedEntity != null) {
                    RecommendFeedPresenter.this.a("featured_list_cache", (String) bluedEntity.data);
                    a(bluedEntity, true);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z2) {
                if (RecommendFeedPresenter.this.i == 1) {
                    RecommendFeedPresenter.this.d(iFetchDataListener);
                }
                if (!z2) {
                    RecommendFeedPresenter.e(RecommendFeedPresenter.this);
                }
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a(z2);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                if (z) {
                    RecommendFeedPresenter.this.a("feed_data_list_refresh", false);
                }
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BluedIngSelfFeed, DiscoverSquareExtra> bluedEntity) {
                if (bluedEntity != null) {
                    int p = CommunityServiceManager.a().p();
                    String[] r = CommunityServiceManager.a().r();
                    LogUtils.c("推荐下滑--> DiscoveryFeedBubbleSource=" + p);
                    LogUtils.c("推荐下滑--> bubbleIds=" + r);
                    if (p > 0 && r != null && r.length >= 4) {
                        for (BluedIngSelfFeed bluedIngSelfFeed : bluedEntity.data) {
                            String str = r[1];
                            String str2 = r[3];
                            RecommendFeedPresenter.this.h = str2;
                            if (TextUtils.equals(str, bluedIngSelfFeed.feed_uid) && TextUtils.equals(str2, bluedIngSelfFeed.feed_id)) {
                                bluedIngSelfFeed.feed_bubble_type = CommunityServiceManager.a().p();
                                bluedIngSelfFeed.is_top_new = 1;
                            }
                        }
                    }
                    LogUtils.c("推荐下滑--> strBubbleInsertFeedId=" + RecommendFeedPresenter.this.h);
                    if (CommunityServiceManager.a().q() != 6) {
                        CommunityServiceManager.a().s();
                    }
                    if (iFetchDataListener != null) {
                        if (RecommendFeedPresenter.this.i == 1) {
                            RecommendFeedPresenter.this.l = bluedEntity.data;
                        } else if (bluedEntity.data != null && RecommendFeedPresenter.this.l != null) {
                            RecommendFeedPresenter.this.l.addAll(bluedEntity.data);
                        }
                        RecommendFeedPresenter recommendFeedPresenter = RecommendFeedPresenter.this;
                        recommendFeedPresenter.a("featured_list", (String) recommendFeedPresenter.l);
                    }
                    if (RecommendFeedPresenter.this.i == 1) {
                        a(bluedEntity, false);
                        if (bluedEntity.hasData()) {
                            RecommendFeedPresenter.this.g(iFetchDataListener);
                            RecommendFeedPresenter.this.f(iFetchDataListener);
                        }
                    }
                    RecommendFeedPresenter.this.j = bluedEntity.hasMore();
                } else {
                    RecommendFeedPresenter.this.j = false;
                }
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.b(RecommendFeedPresenter.this.j);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public BluedEntity<BluedIngSelfFeed, DiscoverSquareExtra> parseData(String str) {
                return super.parseData(str);
            }
        };
    }

    private void a(int i, BluedIngSelfFeed bluedIngSelfFeed) {
        int i2 = i;
        if (i <= 0) {
            i2 = 3;
        }
        if (m().size() > i2) {
            m().add(i2, bluedIngSelfFeed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedEntity<FeedRecommendUser, LiveRecommendExtra> bluedEntity) {
        if (bluedEntity.data == null || bluedEntity.extra == null) {
            return;
        }
        this.k.w = bluedEntity.extra.hasmore;
        this.k.t = bluedEntity.extra.last_lid;
        this.k.u = bluedEntity.extra.ai_last_uid;
        this.k.v = bluedEntity.extra.recommend_char;
        int i = bluedEntity.extra.line - 1;
        if (bluedEntity.data.size() < 3 || i < 0 || i >= this.k.getData().size()) {
            return;
        }
        BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) this.k.getData().get(i);
        if (bluedIngSelfFeed.dataType != 3) {
            BluedIngSelfFeed bluedIngSelfFeed2 = (BluedIngSelfFeed) bluedIngSelfFeed.clone();
            bluedIngSelfFeed2.feed_id = "0";
            bluedIngSelfFeed2.feed_uid = "0";
            bluedIngSelfFeed2.feed_type = -99;
            bluedIngSelfFeed2.dataType = 3;
            if (this.k.x == null) {
                this.k.x = new FeedHorizontalRecommendAdapter(h(), g(), "recommend", bluedEntity.extra.line);
            }
            this.k.x.setEnableLoadMore(true);
            this.k.x.loadMoreEnd(false);
            this.k.x.setNewData(bluedEntity.data);
            a(i, bluedIngSelfFeed2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MyCircleModel> list, int i, IFetchDataListener iFetchDataListener) {
        if (list == null || list.size() < 1 || i < 0 || i >= this.k.getData().size()) {
            return;
        }
        BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) ((BluedIngSelfFeed) this.k.getData().get(i)).clone();
        bluedIngSelfFeed.feed_id = "0";
        bluedIngSelfFeed.feed_uid = "0";
        bluedIngSelfFeed.feed_type = -99;
        bluedIngSelfFeed.dataType = 5;
        if (this.k.A == null) {
            this.k.A = new CircleListAdapter(h(), CircleConstants.CIRCLE_FROM_PAGE.RECOMMEND_CIRCLE, g(), null);
        }
        this.k.A.setEnableLoadMore(false);
        this.k.A.setNewData(list);
        a(i, bluedIngSelfFeed);
        if (iFetchDataListener != null) {
            iFetchDataListener.a("featured_list", m());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<BluedTopic> list, int i, IFetchDataListener iFetchDataListener) {
        if (list == null || list.size() < 1 || i < 0 || i >= this.k.getData().size()) {
            return;
        }
        BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) ((BluedIngSelfFeed) this.k.getData().get(i)).clone();
        bluedIngSelfFeed.feed_id = "0";
        bluedIngSelfFeed.feed_uid = "0";
        bluedIngSelfFeed.feed_type = -99;
        bluedIngSelfFeed.dataType = 4;
        if (this.k.y == null) {
            this.k.y = new RecommendTopicAdapter(h(), g());
        }
        this.k.y.setEnableLoadMore(false);
        ArrayList arrayList = new ArrayList();
        for (List<BluedTopic> list2 : a(list, 3).values()) {
            BluedTopic bluedTopic = new BluedTopic();
            bluedTopic.bluedTopicList = new ArrayList();
            bluedTopic.bluedTopicList.addAll(list2);
            arrayList.add(bluedTopic);
        }
        this.k.y.setNewData(arrayList);
        a(i, bluedIngSelfFeed);
        if (iFetchDataListener != null) {
            iFetchDataListener.a("featured_list", m());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<ChatRoom> list, int i, IFetchDataListener iFetchDataListener) {
        if (list == null || list.size() < 1 || i < 0 || i >= this.k.getData().size()) {
            return;
        }
        BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) ((BluedIngSelfFeed) this.k.getData().get(i)).clone();
        bluedIngSelfFeed.feed_id = "0";
        bluedIngSelfFeed.feed_uid = "0";
        bluedIngSelfFeed.feed_type = -99;
        bluedIngSelfFeed.dataType = 7;
        if (this.k.z == null) {
            this.k.z = new RecommendChatRoomAdapter(h(), g());
        }
        this.k.z.setEnableLoadMore(false);
        this.k.z.setNewData(list);
        a(i, bluedIngSelfFeed);
        if (iFetchDataListener != null) {
            iFetchDataListener.a("featured_list", m());
        }
    }

    static /* synthetic */ int e(RecommendFeedPresenter recommendFeedPresenter) {
        int i = recommendFeedPresenter.i;
        recommendFeedPresenter.i = i - 1;
        return i;
    }

    private BluedUIHttpResponse e(final IFetchDataListener iFetchDataListener) {
        return new BluedUIHttpResponse<BluedEntity<FeedRecommendUser, LiveRecommendExtra>>("recoomendlivedata", g()) { // from class: com.blued.community.ui.square.presenter.RecommendFeedPresenter.6
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUICache(BluedEntity<FeedRecommendUser, LiveRecommendExtra> bluedEntity) {
                super.onUICache(bluedEntity);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                RecommendFeedPresenter recommendFeedPresenter = RecommendFeedPresenter.this;
                recommendFeedPresenter.a("featured_list", (String) recommendFeedPresenter.m());
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a(true);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<FeedRecommendUser, LiveRecommendExtra> bluedEntity) {
                if (bluedEntity != null) {
                    RecommendFeedPresenter.this.a(bluedEntity);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public BluedEntity<FeedRecommendUser, LiveRecommendExtra> parseData(String str) {
                return super.parseData(str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(IFetchDataListener iFetchDataListener) {
        String str;
        String str2;
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.k;
        if (feedListAdapterForRecyclerView != null) {
            str = feedListAdapterForRecyclerView.t;
            str2 = this.k.u;
        } else {
            str = "";
            str2 = str;
        }
        FeedHttpUtils.a(str, str2, (String) null, "recommend", g(), e(iFetchDataListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final IFetchDataListener iFetchDataListener) {
        FeedHttpUtils.a(h(), new BluedUIHttpResponse<BluedEntity<DiscoverRecommendModel, SquareRecommendExtra>>(g()) { // from class: com.blued.community.ui.square.presenter.RecommendFeedPresenter.7
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<DiscoverRecommendModel, SquareRecommendExtra> bluedEntity) {
                if (bluedEntity == null || bluedEntity.extra == null) {
                    return;
                }
                RecommendFeedPresenter.this.n = bluedEntity.extra.type;
                CommunityPreferences.a(RecommendFeedPresenter.this.n);
                int i = bluedEntity.extra.line - 1;
                if (i < 0) {
                    return;
                }
                if ((3 >= RecommendFeedPresenter.this.k.getData().size() || ((BluedIngSelfFeed) RecommendFeedPresenter.this.k.getData().get(3)).is_ads != 1) && bluedEntity.hasData()) {
                    if (bluedEntity.getSingleData() instanceof MyCircleModel) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<DiscoverRecommendModel> it = bluedEntity.data.iterator();
                        while (it.hasNext()) {
                            arrayList.add((MyCircleModel) it.next());
                        }
                        RecommendFeedPresenter.this.a(arrayList, i, iFetchDataListener);
                    } else if (bluedEntity.getSingleData() instanceof BluedTopic) {
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<DiscoverRecommendModel> it2 = bluedEntity.data.iterator();
                        while (it2.hasNext()) {
                            arrayList2.add((BluedTopic) it2.next());
                        }
                        RecommendFeedPresenter.this.b(arrayList2, i, iFetchDataListener);
                    } else if (bluedEntity.getSingleData() instanceof ChatRoom) {
                        ArrayList arrayList3 = new ArrayList();
                        Iterator<DiscoverRecommendModel> it3 = bluedEntity.data.iterator();
                        while (it3.hasNext()) {
                            arrayList3.add((ChatRoom) it3.next());
                        }
                        RecommendFeedPresenter.this.c(arrayList3, i, iFetchDataListener);
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public BluedEntity<DiscoverRecommendModel, SquareRecommendExtra> parseData(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                BluedEntity<DiscoverRecommendModel, SquareRecommendExtra> parseData = super.parseData(str);
                Type type = null;
                if (parseData.extra != null) {
                    int i = parseData.extra.type;
                    type = i != 1 ? i != 2 ? i != 3 ? null : new TypeToken<BluedEntity<ChatRoom, SquareRecommendExtra>>() { // from class: com.blued.community.ui.square.presenter.RecommendFeedPresenter.7.3
                    }.getType() : new TypeToken<BluedEntity<BluedTopic, SquareRecommendExtra>>() { // from class: com.blued.community.ui.square.presenter.RecommendFeedPresenter.7.2
                    }.getType() : new TypeToken<BluedEntity<MyCircleModel, SquareRecommendExtra>>() { // from class: com.blued.community.ui.square.presenter.RecommendFeedPresenter.7.1
                    }.getType();
                }
                return type == null ? parseData : (BluedEntity) AppInfo.f().fromJson(str, type);
            }
        }, this.n, g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.m == null) {
            return;
        }
        FeedMethods.a(m(), this.m, 6);
        CommunityPreferences.a("RecommendDrawDepthBubbleShowCount", 0);
        a("featured_list", (String) m(), false);
    }

    public Map<Integer, List<BluedTopic>> a(List<BluedTopic> list, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(1, new ArrayList());
        for (BluedTopic bluedTopic : list) {
            List list2 = (List) hashMap.get(Integer.valueOf(hashMap.size()));
            ArrayList arrayList = list2;
            if (list2.size() == i) {
                arrayList = new ArrayList();
                hashMap.put(Integer.valueOf(hashMap.size() + 1), arrayList);
            }
            arrayList.add(bluedTopic);
        }
        return hashMap;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        this.n = CommunityPreferences.l();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(LifecycleOwner lifecycleOwner) {
        super.a(lifecycleOwner);
        FeedMethods.a(lifecycleOwner, this.k);
        CircleMethods.a(lifecycleOwner, this.k);
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.k;
        if (feedListAdapterForRecyclerView != null) {
            feedListAdapterForRecyclerView.a("recommend");
        }
        LiveEventBus.get("circle_delete_feed", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.community.ui.square.presenter.RecommendFeedPresenter.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                RecommendFeedPresenter.this.a("delete_circle_feed", str, false);
            }
        });
        LiveEventBus.get("feed_delete", BluedIngSelfFeed.class).observe(lifecycleOwner, new Observer<BluedIngSelfFeed>() { // from class: com.blued.community.ui.square.presenter.RecommendFeedPresenter.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(BluedIngSelfFeed bluedIngSelfFeed) {
                if (bluedIngSelfFeed == null) {
                    return;
                }
                RecommendFeedPresenter.this.l.remove(bluedIngSelfFeed);
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(final IFetchDataListener iFetchDataListener) {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.community.ui.square.presenter.-$$Lambda$RecommendFeedPresenter$lxcSdodfauSh0Uxr8HnEcU-Iqxs
            @Override // java.lang.Runnable
            public final void run() {
                RecommendFeedPresenter.this.h(iFetchDataListener);
            }
        }, 500L);
        this.i = 1;
        FeedHttpUtils.a(a(iFetchDataListener, true), this.i, "", CommunityPreferences.T(), g());
    }

    public void a(FeedListAdapterForRecyclerView feedListAdapterForRecyclerView) {
        this.k = feedListAdapterForRecyclerView;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        if (this.j) {
            this.i++;
            FeedHttpUtils.a(a(iFetchDataListener, false), this.i, this.k.c(), "", g());
        }
    }

    /* renamed from: c */
    public void h(final IFetchDataListener iFetchDataListener) {
        FeedHttpUtils.b(h(), new BluedUIHttpResponse<BluedEntityA<CommBannerModel>>(g()) { // from class: com.blued.community.ui.square.presenter.RecommendFeedPresenter.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<CommBannerModel> bluedEntityA) {
                iFetchDataListener.a("discover_picture_list", bluedEntityA.data);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                if (z) {
                    return;
                }
                RecommendFeedPresenter.this.a("discover_picture_list", (String) null);
            }
        }, "", g());
    }

    public void d(final IFetchDataListener iFetchDataListener) {
        FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntity<FeedDiversionModel, FeedDiversionExtra>>(g()) { // from class: com.blued.community.ui.square.presenter.RecommendFeedPresenter.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                if (z) {
                    return;
                }
                RecommendFeedPresenter.this.a("FEED_FLOAT_OP_DATA", (String) null);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<FeedDiversionModel, FeedDiversionExtra> bluedEntity) {
                iFetchDataListener.a("FEED_FLOAT_OP_DATA", bluedEntity.data);
                if (bluedEntity.extra != null) {
                    RecommendFeedPresenter.this.m = bluedEntity.extra.getGuide();
                } else {
                    RecommendFeedPresenter.this.m = null;
                }
                RecommendFeedPresenter.this.n();
            }
        }, 2, CommunityManager.f19086a.a().c(), g());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void k() {
        a("feed_data_list_refresh", false);
        a((IFetchDataListener) null, false).refresh();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public String[] l() {
        return new String[]{"featured_list"};
    }

    public List<BluedIngSelfFeed> m() {
        if (this.l == null) {
            this.l = new ArrayList();
        }
        return this.l;
    }
}
