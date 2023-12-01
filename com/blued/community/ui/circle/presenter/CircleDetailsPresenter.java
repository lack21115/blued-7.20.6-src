package com.blued.community.ui.circle.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.circle.model.CircleBubble;
import com.blued.community.ui.circle.model.CircleDetailsListModel;
import com.blued.community.ui.circle.model.CircleDetailsModel;
import com.blued.community.ui.circle.model.CircleJoinState;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.send.observer.FeedRefreshObserver;
import com.blued.community.utils.CommunityPreferences;
import com.blued.das.client.feed.FeedProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/presenter/CircleDetailsPresenter.class */
public class CircleDetailsPresenter extends MvpPresenter implements FeedRefreshObserver.IFeedRefreshObserver {
    public boolean h;
    public boolean i;
    private MyCircleModel l;
    private String m;
    private String n;
    private CircleConstants.CIRCLE_FROM_PAGE q;
    private int r;
    private int s;
    private int t;
    private int v;
    private int o = 0;
    private Map<Integer, CircleDetailsListModel> p = new HashMap();
    private boolean u = true;
    public boolean j = false;
    public boolean k = false;
    private boolean w = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (this.w) {
            return;
        }
        EventTrackFeed.a(FeedProtos.Event.CIRCLE_DETAIL_SHOW, t().circle_id, s(), EventTrackFeed.a(u(), v(), w(), x()), t().isJoin(), t().allow_join == 0, EventTrackFeed.i(t().admin_level), this.v);
        this.w = true;
    }

    private void a(final boolean z, final IFetchDataListener iFetchDataListener) {
        if (z) {
            y().page = 1;
        } else {
            y().page++;
        }
        if (y().hasMore || y().page == 1) {
            CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<CircleDetailsModel>>(g()) { // from class: com.blued.community.ui.circle.presenter.CircleDetailsPresenter.5
                int a;

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<CircleDetailsModel> bluedEntityA) {
                    boolean z2 = false;
                    if (bluedEntityA != null && bluedEntityA.hasData() && isActive()) {
                        CircleDetailsPresenter.this.m = bluedEntityA.getSingleData().circle_id;
                        if (bluedEntityA.getSingleData().allow_join == 1) {
                            z2 = true;
                        }
                        CommunityPreferences.a(z2);
                        if (z) {
                            CircleDetailsPresenter.this.y().dataList.clear();
                        }
                        if (!TypeUtils.a((List<?>) bluedEntityA.getSingleData().feeds)) {
                            CircleDetailsPresenter.this.y().dataList.addAll(bluedEntityA.getSingleData().feeds);
                        }
                        CircleDetailsPresenter.this.y().hasMore = bluedEntityA.hasMore();
                        if (CircleDetailsPresenter.this.o == 0) {
                            CircleDetailsPresenter circleDetailsPresenter = CircleDetailsPresenter.this;
                            circleDetailsPresenter.a("circle_new_list", (String) circleDetailsPresenter.y().dataList);
                        }
                        if (z) {
                            CircleDetailsPresenter.this.l = bluedEntityA.getSingleData();
                            iFetchDataListener.a("circle_details", bluedEntityA.data);
                            iFetchDataListener.a("circle_details_top", bluedEntityA.getSingleData().top);
                            CircleDetailsPresenter.this.a("circle_details_ad", (String) bluedEntityA.getSingleData().ad);
                        }
                    } else {
                        CircleDetailsPresenter.this.y().hasMore = false;
                    }
                    if (CircleDetailsPresenter.this.o == 0) {
                        iFetchDataListener.b(CircleDetailsPresenter.this.y().hasMore);
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str) {
                    this.a = i;
                    if (CircleDetailsPresenter.this.y().page != 1) {
                        CircleDetailsPresenter.this.y().page--;
                    }
                    return super.onUIFailure(i, str);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish(boolean z2) {
                    if (CircleDetailsPresenter.this.o == 0) {
                        iFetchDataListener.a(z2);
                    }
                    if (z2) {
                        CircleDetailsPresenter.this.B();
                    }
                    if (this.a == 40370003) {
                        CircleDetailsPresenter.this.i();
                    }
                }
            }, this.m, "last", y().page, y().size);
            return;
        }
        y().page--;
        iFetchDataListener.b(false);
    }

    private void b(final boolean z, final IFetchDataListener iFetchDataListener) {
        if (z) {
            z().page = 1;
        } else {
            z().page++;
        }
        if (z().hasMore || z().page == 1) {
            CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<CircleDetailsModel>>(g()) { // from class: com.blued.community.ui.circle.presenter.CircleDetailsPresenter.6
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<CircleDetailsModel> bluedEntityA) {
                    if (bluedEntityA != null && bluedEntityA.hasData() && isActive()) {
                        if (z) {
                            CircleDetailsPresenter.this.z().dataList.clear();
                        }
                        if (!TypeUtils.a((List<?>) bluedEntityA.getSingleData().feeds)) {
                            CircleDetailsPresenter.this.z().dataList.addAll(bluedEntityA.getSingleData().feeds);
                        }
                        CircleDetailsPresenter.this.z().hasMore = bluedEntityA.hasMore();
                        if (CircleDetailsPresenter.this.o == 1) {
                            CircleDetailsPresenter circleDetailsPresenter = CircleDetailsPresenter.this;
                            circleDetailsPresenter.a("circle_new_list", (String) circleDetailsPresenter.z().dataList);
                        }
                        if (z) {
                            CircleDetailsPresenter.this.l = bluedEntityA.getSingleData();
                            iFetchDataListener.a("circle_details", bluedEntityA.data);
                            iFetchDataListener.a("circle_details_top", bluedEntityA.getSingleData().top);
                            CircleDetailsPresenter.this.a("circle_details_ad", (String) bluedEntityA.getSingleData().ad);
                        }
                    } else {
                        CircleDetailsPresenter.this.z().hasMore = false;
                    }
                    if (CircleDetailsPresenter.this.o == 1) {
                        iFetchDataListener.b(CircleDetailsPresenter.this.z().hasMore);
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str) {
                    if (CircleDetailsPresenter.this.z().page != 1) {
                        CircleDetailsPresenter.this.z().page--;
                    }
                    return super.onUIFailure(i, str);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish(boolean z2) {
                    if (CircleDetailsPresenter.this.o == 1) {
                        iFetchDataListener.a(z2);
                    }
                    if (z2) {
                        CircleDetailsPresenter.this.B();
                    }
                }
            }, this.m, "hot", z().page, z().size);
            return;
        }
        z().page--;
        iFetchDataListener.b(false);
    }

    private void c(final IFetchDataListener iFetchDataListener) {
        CircleHttpUtils.e(new BluedUIHttpResponse<BluedEntityA<CircleBubble>>(g()) { // from class: com.blued.community.ui.circle.presenter.CircleDetailsPresenter.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<CircleBubble> bluedEntityA) {
                if (bluedEntityA != null && bluedEntityA.hasData() && isActive()) {
                    iFetchDataListener.a("circle_bubble", bluedEntityA.data);
                }
            }
        }, r(), g());
    }

    private void c(final boolean z, final IFetchDataListener iFetchDataListener) {
        if (z) {
            A().page = 1;
        } else {
            A().page++;
        }
        if (A().hasMore || A().page == 1) {
            CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<CircleDetailsModel>>(g()) { // from class: com.blued.community.ui.circle.presenter.CircleDetailsPresenter.7
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<CircleDetailsModel> bluedEntityA) {
                    if (bluedEntityA != null && bluedEntityA.hasData() && isActive()) {
                        if (z) {
                            CircleDetailsPresenter.this.A().dataList.clear();
                        }
                        if (!TypeUtils.a((List<?>) bluedEntityA.getSingleData().feeds)) {
                            CircleDetailsPresenter.this.A().dataList.addAll(bluedEntityA.getSingleData().feeds);
                        }
                        CircleDetailsPresenter.this.A().hasMore = bluedEntityA.hasMore();
                        if (CircleDetailsPresenter.this.o == 2) {
                            CircleDetailsPresenter circleDetailsPresenter = CircleDetailsPresenter.this;
                            circleDetailsPresenter.a("circle_new_list", (String) circleDetailsPresenter.A().dataList);
                        }
                        if (z) {
                            CircleDetailsPresenter.this.l = bluedEntityA.getSingleData();
                            iFetchDataListener.a("circle_details", bluedEntityA.data);
                            iFetchDataListener.a("circle_details_top", bluedEntityA.getSingleData().top);
                            CircleDetailsPresenter.this.a("circle_details_ad", (String) bluedEntityA.getSingleData().ad);
                        }
                    } else {
                        CircleDetailsPresenter.this.A().hasMore = false;
                    }
                    if (CircleDetailsPresenter.this.o == 2) {
                        iFetchDataListener.b(CircleDetailsPresenter.this.A().hasMore);
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str) {
                    if (CircleDetailsPresenter.this.A().page != 1) {
                        CircleDetailsPresenter.this.A().page--;
                    }
                    return super.onUIFailure(i, str);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish(boolean z2) {
                    if (CircleDetailsPresenter.this.o == 2) {
                        iFetchDataListener.a(z2);
                    }
                    if (z2) {
                        CircleDetailsPresenter.this.B();
                    }
                }
            }, this.m, "essence", A().page, A().size);
            return;
        }
        A().page--;
        iFetchDataListener.b(false);
    }

    public CircleDetailsListModel A() {
        return b(2);
    }

    public void a(int i) {
        this.o = i;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        this.p.put(0, new CircleDetailsListModel());
        this.p.put(1, new CircleDetailsListModel());
        this.p.put(2, new CircleDetailsListModel());
        if (bundle != null) {
            this.m = bundle.getString("circle_id");
            this.n = bundle.getString("feed_id");
            this.o = bundle.getInt("circle_details_tab", 0);
            this.q = (CircleConstants.CIRCLE_FROM_PAGE) bundle.getSerializable("circle_from_page");
            this.r = bundle.getInt("notify_from");
            this.s = bundle.getInt("feed_from");
            this.t = bundle.getInt("h5_from");
            this.v = bundle.getInt("circle_classify_id");
            this.j = bundle.getBoolean("show_apply_join", false);
            this.k = bundle.getBoolean("show_circle_entry", false);
            MyCircleModel myCircleModel = (MyCircleModel) bundle.getSerializable("circle_data");
            if (myCircleModel != null) {
                this.m = myCircleModel.circle_id;
                this.l = myCircleModel;
                a("circle_details", (String) myCircleModel);
            } else {
                f_("circle_details");
            }
        }
        e();
        f_("circle_tab");
    }

    public void a(FragmentManager fragmentManager) {
        if (this.j) {
            a(true, (CircleMethods.JoinViewChangeListener) null, fragmentManager);
            this.j = false;
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(final LifecycleOwner lifecycleOwner) {
        super.a(lifecycleOwner);
        FeedRefreshObserver.a().a(this);
        lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.blued.community.ui.circle.presenter.CircleDetailsPresenter.1
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void onDestroy() {
                FeedRefreshObserver.a().b(CircleDetailsPresenter.this);
                lifecycleOwner.getLifecycle().removeObserver(this);
            }
        });
        LiveEventBus.get("circle_delete_feed", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.community.ui.circle.presenter.CircleDetailsPresenter.2
            /* renamed from: a */
            public void onChanged(String str) {
                CircleDetailsPresenter.this.a("circle_delete_feed", str, false);
            }
        });
        LiveEventBus.get("circle_join_state", CircleJoinState.class).observe(lifecycleOwner, new Observer<CircleJoinState>() { // from class: com.blued.community.ui.circle.presenter.CircleDetailsPresenter.3
            /* renamed from: a */
            public void onChanged(CircleJoinState circleJoinState) {
                if (TextUtils.isEmpty(CircleDetailsPresenter.this.r()) || !CircleDetailsPresenter.this.r().equals(circleJoinState.circle_id)) {
                    return;
                }
                CircleDetailsPresenter.this.t().setJoinState(circleJoinState);
                CircleDetailsPresenter.this.f_("circle_join_state");
            }
        });
        LiveEventBus.get("circle_info_modify", MyCircleModel.class).observe(lifecycleOwner, new Observer<MyCircleModel>() { // from class: com.blued.community.ui.circle.presenter.CircleDetailsPresenter.4
            /* renamed from: a */
            public void onChanged(MyCircleModel myCircleModel) {
                if (myCircleModel == null || !CircleDetailsPresenter.this.r().equals(myCircleModel.circle_id)) {
                    return;
                }
                if (!TextUtils.isEmpty(myCircleModel.cover) && !TextUtils.equals(CircleDetailsPresenter.this.t().cover, myCircleModel.cover)) {
                    CircleDetailsPresenter.this.t().cover = myCircleModel.cover;
                    CircleDetailsPresenter.this.t().cover_is_auditing = 1;
                }
                CircleDetailsPresenter.this.t().description = myCircleModel.description;
                CircleDetailsPresenter circleDetailsPresenter = CircleDetailsPresenter.this;
                circleDetailsPresenter.a("circle_details", (String) circleDetailsPresenter.t());
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        if (this.u) {
            a(true, iFetchDataListener);
            b(true, iFetchDataListener);
            c(true, iFetchDataListener);
            c(iFetchDataListener);
            this.u = false;
        } else {
            int i = this.o;
            if (i == 0) {
                a(true, iFetchDataListener);
            } else if (i == 1) {
                b(true, iFetchDataListener);
            } else if (i == 2) {
                c(true, iFetchDataListener);
            }
        }
        this.h = true;
    }

    @Override // com.blued.community.ui.send.observer.FeedRefreshObserver.IFeedRefreshObserver
    public void a(Object obj, int i) {
        if (o() && i == 2 && (obj instanceof BluedIngSelfFeed)) {
            BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) obj;
            if (CircleMethods.a(bluedIngSelfFeed)) {
                a("circle_post", (String) bluedIngSelfFeed);
            }
        }
    }

    public void a(boolean z, CircleMethods.JoinViewChangeListener joinViewChangeListener, FragmentManager fragmentManager) {
        if (h() == null || fragmentManager == null) {
            return;
        }
        CircleMethods.a(h(), joinViewChangeListener, t().getJoinState(), g(), fragmentManager, z, false);
    }

    public CircleDetailsListModel b(int i) {
        return this.p.get(Integer.valueOf(i));
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        this.h = false;
        int i = this.o;
        if (i == 0) {
            a(false, iFetchDataListener);
        } else if (i == 1) {
            b(false, iFetchDataListener);
        } else if (i != 2) {
        } else {
            c(false, iFetchDataListener);
        }
    }

    public void m() {
        CircleMethods.a(t(), g());
    }

    public boolean n() {
        return t().isOwner() || t().isManager();
    }

    public boolean o() {
        return this.o == 0;
    }

    public int p() {
        return this.o;
    }

    public String q() {
        return t().title;
    }

    public String r() {
        return !TextUtils.isEmpty(t().circle_id) ? t().circle_id : this.m;
    }

    public String s() {
        return this.n;
    }

    public MyCircleModel t() {
        if (this.l == null) {
            this.l = new CircleDetailsModel();
        }
        if (TextUtils.isEmpty(this.l.circle_id)) {
            this.l.circle_id = this.m;
        }
        return this.l;
    }

    public CircleConstants.CIRCLE_FROM_PAGE u() {
        return this.q;
    }

    public int v() {
        return this.r;
    }

    public int w() {
        return this.s;
    }

    public int x() {
        return this.t;
    }

    public CircleDetailsListModel y() {
        return b(0);
    }

    public CircleDetailsListModel z() {
        return b(1);
    }
}
