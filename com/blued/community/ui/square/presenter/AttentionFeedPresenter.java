package com.blued.community.ui.square.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedParse;
import com.blued.community.model.LiveRecommendExtra;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.send.observer.FeedRefreshObserver;
import com.blued.community.ui.square.adapter.FeedHorizontalRecommendAdapter;
import com.blued.community.ui.square.model.AttentionLiveRecommendData;
import com.blued.community.ui.square.model.FeedRecommendUser;
import com.blued.community.ui.topic.model.BluedTopic;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/presenter/AttentionFeedPresenter.class */
public class AttentionFeedPresenter extends MvpPresenter implements FeedRefreshObserver.IFeedRefreshObserver {
    private List<BluedIngSelfFeed> h;
    private FeedListAdapterForRecyclerView l;
    private List<AttentionLiveRecommendData> o;
    private int i = 1;
    private int j = 12;
    private boolean k = true;
    private int m = 1;
    private boolean n = true;
    private String p = "follows";
    private String q = "500";
    private BluedUIHttpResponse r = new BluedUIHttpResponse<BluedEntityA<AttentionLiveRecommendData>>(g()) { // from class: com.blued.community.ui.square.presenter.AttentionFeedPresenter.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<AttentionLiveRecommendData> bluedEntityA) {
            if (!bluedEntityA.hasData()) {
                AttentionFeedPresenter.this.n = false;
                return;
            }
            if (AttentionFeedPresenter.this.m == 1) {
                AttentionFeedPresenter.this.o = bluedEntityA.data;
            } else {
                List<AttentionLiveRecommendData> list = bluedEntityA.data;
                for (AttentionLiveRecommendData attentionLiveRecommendData : AttentionFeedPresenter.this.o) {
                    Iterator<AttentionLiveRecommendData> it = list.iterator();
                    while (it.hasNext()) {
                        AttentionLiveRecommendData next = it.next();
                        if (attentionLiveRecommendData.uid != null && attentionLiveRecommendData.uid.equals(next.uid)) {
                            it.remove();
                        }
                    }
                }
                AttentionFeedPresenter.this.o.addAll(list);
            }
            AttentionFeedPresenter.this.n = bluedEntityA.hasMore();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish(boolean z) {
            super.onUIFinish(z);
            if (!z) {
                AttentionFeedPresenter.h(AttentionFeedPresenter.this);
            }
            AttentionFeedPresenter attentionFeedPresenter = AttentionFeedPresenter.this;
            attentionFeedPresenter.a("live_list", (String) attentionFeedPresenter.o);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, BluedIngSelfFeed bluedIngSelfFeed) {
        int i2 = i;
        if (i <= 0) {
            i2 = 3;
        }
        if (p().size() > i2) {
            p().add(i2, bluedIngSelfFeed);
        } else {
            p().add(bluedIngSelfFeed);
        }
    }

    private void c(IFetchDataListener iFetchDataListener) {
        if (this.i == 1) {
            CommunityServiceManager.e().e(13);
            LiveEventBus.get("EVENT_HIDE_HOME_TAB_DOT").post("feed");
            FeedHttpUtils.a(d(iFetchDataListener), UserInfo.getInstance().getLoginUserInfo().getUid(), this.p, this.i + "", this.j + "", CommunityServiceManager.c().e(), CommunityServiceManager.c().f(), this.q, "", g());
            e(iFetchDataListener);
        } else if (this.l != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.l.c());
            sb.append(TextUtils.isEmpty("") ? "" : ",");
            sb.append("");
            String sb2 = sb.toString();
            FeedHttpUtils.a(d(iFetchDataListener), UserInfo.getInstance().getLoginUserInfo().getUid(), this.p, this.i + "", this.j + "", CommunityServiceManager.c().e(), CommunityServiceManager.c().f(), this.q, sb2, g());
        }
    }

    static /* synthetic */ int d(AttentionFeedPresenter attentionFeedPresenter) {
        int i = attentionFeedPresenter.i;
        attentionFeedPresenter.i = i - 1;
        return i;
    }

    private BluedUIHttpResponse d(final IFetchDataListener iFetchDataListener) {
        return new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>("attentionfeedlist", g()) { // from class: com.blued.community.ui.square.presenter.AttentionFeedPresenter.2
            boolean a = false;

            private void a(BluedEntityA<BluedIngSelfFeed> bluedEntityA, boolean z) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    AttentionFeedPresenter.this.k = false;
                } else {
                    if (AttentionFeedPresenter.this.i == 1) {
                        AttentionFeedPresenter.this.h = bluedEntityA.data;
                    } else if (bluedEntityA.data != null && AttentionFeedPresenter.this.h != null) {
                        AttentionFeedPresenter.this.h.addAll(bluedEntityA.data);
                    }
                    IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                    if (iFetchDataListener2 != null) {
                        iFetchDataListener2.a("feed_list", AttentionFeedPresenter.this.h);
                    } else {
                        AttentionFeedPresenter attentionFeedPresenter = AttentionFeedPresenter.this;
                        attentionFeedPresenter.a("feed_list", (String) attentionFeedPresenter.h);
                    }
                    AttentionFeedPresenter.this.k = bluedEntityA.hasMore();
                }
                IFetchDataListener iFetchDataListener3 = iFetchDataListener;
                if (iFetchDataListener3 != null) {
                    iFetchDataListener3.b(AttentionFeedPresenter.this.k);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<BluedIngSelfFeed> parseData(String str) {
                BluedEntityA<BluedIngSelfFeed> bluedEntityA = (BluedEntityA) super.parseData(str);
                if (bluedEntityA != null) {
                    if (!bluedEntityA.hasData()) {
                        return bluedEntityA;
                    }
                    for (BluedIngSelfFeed bluedIngSelfFeed : bluedEntityA.data) {
                        bluedIngSelfFeed.feedParse = new FeedParse(AttentionFeedPresenter.this.h(), bluedIngSelfFeed, 0);
                    }
                }
                return bluedEntityA;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUICache(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
                a(bluedEntityA, true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: b */
            public void onUIUpdate(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
                a(bluedEntityA, false);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                if (!z) {
                    AttentionFeedPresenter.d(AttentionFeedPresenter.this);
                }
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a(z);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }
        };
    }

    private void e(final IFetchDataListener iFetchDataListener) {
        String str;
        String str2;
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.l;
        if (feedListAdapterForRecyclerView != null) {
            str = feedListAdapterForRecyclerView.t;
            str2 = this.l.u;
        } else {
            str = "";
            str2 = str;
        }
        FeedHttpUtils.a(str, str2, (String) null, "followed", g(), new BluedUIHttpResponse<BluedEntity<FeedRecommendUser, LiveRecommendExtra>>(g()) { // from class: com.blued.community.ui.square.presenter.AttentionFeedPresenter.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a("feed_list", AttentionFeedPresenter.this.p());
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<FeedRecommendUser, LiveRecommendExtra> bluedEntity) {
                if (bluedEntity == null || bluedEntity.data == null || bluedEntity.extra == null) {
                    return;
                }
                AttentionFeedPresenter.this.l.w = bluedEntity.extra.hasmore;
                AttentionFeedPresenter.this.l.t = bluedEntity.extra.last_lid;
                AttentionFeedPresenter.this.l.u = bluedEntity.extra.ai_last_uid;
                AttentionFeedPresenter.this.l.v = bluedEntity.extra.recommend_char;
                int i = bluedEntity.extra.line - 1;
                if (bluedEntity.data.size() < 3 || i < 0 || i >= AttentionFeedPresenter.this.l.getData().size()) {
                    return;
                }
                BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) AttentionFeedPresenter.this.l.getData().get(i);
                if (bluedIngSelfFeed.dataType != 3) {
                    BluedIngSelfFeed bluedIngSelfFeed2 = (BluedIngSelfFeed) bluedIngSelfFeed.clone();
                    bluedIngSelfFeed2.feed_id = "0";
                    bluedIngSelfFeed2.feed_uid = "0";
                    bluedIngSelfFeed2.feed_type = -99;
                    bluedIngSelfFeed2.dataType = 3;
                    if (AttentionFeedPresenter.this.l.x == null) {
                        AttentionFeedPresenter.this.l.x = new FeedHorizontalRecommendAdapter(AttentionFeedPresenter.this.h(), AttentionFeedPresenter.this.g(), "followed", bluedEntity.extra.line);
                    }
                    AttentionFeedPresenter.this.l.x.setEnableLoadMore(true);
                    AttentionFeedPresenter.this.l.x.loadMoreEnd(false);
                    AttentionFeedPresenter.this.l.x.getData().clear();
                    AttentionFeedPresenter.this.l.x.setNewData(bluedEntity.data);
                    AttentionFeedPresenter.this.a(i, bluedIngSelfFeed2);
                }
            }
        });
    }

    static /* synthetic */ int h(AttentionFeedPresenter attentionFeedPresenter) {
        int i = attentionFeedPresenter.m;
        attentionFeedPresenter.m = i - 1;
        return i;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(final LifecycleOwner lifecycleOwner) {
        super.a(lifecycleOwner);
        FeedMethods.a(lifecycleOwner, this.l);
        CircleMethods.a(lifecycleOwner, this.l);
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.l;
        if (feedListAdapterForRecyclerView != null) {
            feedListAdapterForRecyclerView.a("followed");
        }
        FeedRefreshObserver.a().a(this);
        lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.blued.community.ui.square.presenter.AttentionFeedPresenter.1
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void onDestroy() {
                FeedRefreshObserver.a().b(AttentionFeedPresenter.this);
                lifecycleOwner.getLifecycle().removeObserver(this);
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        this.i = 1;
        c(iFetchDataListener);
        a(true);
        m();
    }

    public void a(FeedListAdapterForRecyclerView feedListAdapterForRecyclerView) {
        this.l = feedListAdapterForRecyclerView;
    }

    @Override // com.blued.community.ui.send.observer.FeedRefreshObserver.IFeedRefreshObserver
    public void a(Object obj, int i) {
        f_("send_list_visibility");
        if (i == 2 && (obj instanceof BluedIngSelfFeed)) {
            BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) obj;
            if (this.l == null || CircleMethods.a(bluedIngSelfFeed)) {
                return;
            }
            this.l.addData(0, bluedIngSelfFeed);
            this.l.notifyDataSetChanged();
        }
    }

    public void a(boolean z) {
        if (z) {
            this.m = 1;
        } else {
            this.m++;
        }
        FeedHttpUtils.a(this.r, this.m, g());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        this.i++;
        c(iFetchDataListener);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void k() {
        d((IFetchDataListener) null).refresh();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public String[] l() {
        return new String[]{"feed_list"};
    }

    public void m() {
        FeedHttpUtils.e(new BluedUIHttpResponse<BluedEntityA<BluedTopic>>(g()) { // from class: com.blued.community.ui.square.presenter.AttentionFeedPresenter.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedTopic> bluedEntityA) {
                AttentionFeedPresenter.this.a("subject_attention", (String) bluedEntityA.data);
            }
        }, g());
    }

    public boolean n() {
        return this.k;
    }

    public int o() {
        return this.m;
    }

    public List<BluedIngSelfFeed> p() {
        if (this.h == null) {
            this.h = new ArrayList();
        }
        return this.h;
    }
}
