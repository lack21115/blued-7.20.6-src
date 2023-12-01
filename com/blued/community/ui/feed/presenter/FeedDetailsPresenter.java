package com.blued.community.ui.feed.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.community.R;
import com.blued.community.http.EventHttpUtils;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedParse;
import com.blued.community.model.FeedUserInfoModel;
import com.blued.community.track.ByteDanceEvent;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.ui.eventbus.BusFeedInteractModel;
import com.blued.community.ui.feed.fragment.FeedDetailsFragment;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.feed.model.FeedDetailParams;
import com.blued.community.ui.feed.model.FeedDetailsExtra;
import com.blued.community.ui.feed.model.FeedRepost;
import com.blued.community.ui.feed.observer.CommentListDataObserver;
import com.blued.community.ui.feed.observer.IFeedDataObserver;
import com.blued.das.client.feed.FeedProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/feed/presenter/FeedDetailsPresenter.class */
public class FeedDetailsPresenter extends MvpPresenter implements IFeedDataObserver {
    private FeedDetailParams A;
    private int I;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    private BluedIngSelfFeed n;
    private String o;
    private int r;
    private String s;
    private FeedDetailsFragment v;
    private String x;
    private String y;
    private int p = -1;
    private int q = -1;
    private boolean t = true;
    private boolean u = false;
    private List<FeedComment> w = new ArrayList();
    private boolean z = true;
    private int B = 1;
    private int C = 1;
    private int D = 1;
    private int E = 1;
    private boolean F = true;
    private int G = 1;
    private DataStatus H = new DataStatus();
    public boolean m = false;
    private boolean J = false;
    private boolean K = false;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/feed/presenter/FeedDetailsPresenter$DataStatus.class */
    public class DataStatus {
        public boolean a = true;
        public boolean b = true;
        public boolean c = true;
        public boolean d = true;
        public boolean e = false;
        public boolean f = false;
        public boolean g = false;
        public boolean h = false;

        public DataStatus() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(BluedIngSelfFeed bluedIngSelfFeed) {
        if (this.K) {
            return;
        }
        EventTrackFeed.a(FeedProtos.Event.FEED_DETAIL_PAGE_SOURCE, w(), TextUtils.isEmpty(bluedIngSelfFeed.super_did) ? "" : bluedIngSelfFeed.super_did, "", this.j == 1, -1, bluedIngSelfFeed.is_top_hot == 1, bluedIngSelfFeed.is_feed_anonym == 1, this.k == 1, this.l == 1, EventTrackFeed.a(bluedIngSelfFeed), this.A.mode, bluedIngSelfFeed, this.m, 0L, bluedIngSelfFeed.getYYLiving());
        this.K = true;
        ByteDanceEvent.a("FEED_DETAIL_PAGE_SOURCE", bluedIngSelfFeed, EventTrackFeed.d(w()));
    }

    private void l(IFetchDataListener iFetchDataListener) {
        iFetchDataListener.a("comment_list", this.w);
        this.w.clear();
        iFetchDataListener.a(true);
    }

    private void m(final IFetchDataListener iFetchDataListener) {
        Activity h = h();
        BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>(g()) { // from class: com.blued.community.ui.feed.presenter.FeedDetailsPresenter.6
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
                        bluedIngSelfFeed.feedParse = new FeedParse(FeedDetailsPresenter.this.h(), bluedIngSelfFeed, 14);
                    }
                }
                return bluedEntityA;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
                if (bluedEntityA != null) {
                    ArrayList arrayList = new ArrayList();
                    if (FeedDetailsPresenter.this.n != null && FeedDetailsPresenter.this.E == 1 && !TextUtils.isEmpty(FeedDetailsPresenter.this.n.feed_uid) && bluedEntityA.getSingleData() != null) {
                        Iterator<BluedIngSelfFeed> it = bluedEntityA.data.iterator();
                        while (it.hasNext()) {
                            BluedIngSelfFeed next = it.next();
                            if (StringUtils.a(next.feed_uid, FeedDetailsPresenter.this.n.feed_uid)) {
                                arrayList.add(next);
                                it.remove();
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        iFetchDataListener.a("similar_list", arrayList);
                    }
                    iFetchDataListener.a("feed_list", bluedEntityA.data);
                    if (bluedEntityA.extra == 0 || bluedEntityA.extra.hasmore != 1) {
                        FeedDetailsPresenter.this.H.d = false;
                    } else {
                        FeedDetailsPresenter.this.H.d = true;
                    }
                } else {
                    FeedDetailsPresenter.this.H.d = false;
                }
                if (FeedDetailsPresenter.this.G == 1) {
                    iFetchDataListener.b(FeedDetailsPresenter.this.H.d);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                if (!z) {
                    FeedDetailsPresenter.this.H.d = false;
                }
                FeedDetailsPresenter.this.H.h = !z;
                iFetchDataListener.a(z);
                FeedDetailsPresenter.this.f_("change_place_height");
            }
        };
        String o = o();
        FeedHttpUtils.a(h, bluedUIHttpResponse, o, this.E + "", "20", g());
    }

    private void n(final IFetchDataListener iFetchDataListener) {
        BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, FeedDetailsExtra>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, FeedDetailsExtra>>(g()) { // from class: com.blued.community.ui.feed.presenter.FeedDetailsPresenter.7
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (i >= 0 && i != 200) {
                    FeedDetailsPresenter.this.i();
                }
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                if (!z) {
                    FeedDetailsPresenter.this.H.b = false;
                }
                FeedDetailsPresenter.this.H.f = !z;
                iFetchDataListener.a(z);
                if (FeedDetailsPresenter.this.F) {
                    if (!TextUtils.isEmpty(FeedDetailsPresenter.this.o)) {
                        FeedDetailsPresenter.this.f_("scroll_to_mark_comment");
                    }
                    FeedDetailsPresenter.this.F = false;
                }
                if (z) {
                    FeedDetailsPresenter feedDetailsPresenter = FeedDetailsPresenter.this;
                    feedDetailsPresenter.c(feedDetailsPresenter.p());
                }
                FeedDetailsPresenter.this.f_("change_place_height");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BluedIngSelfFeed, FeedDetailsExtra> bluedEntity) {
                if (bluedEntity == null || bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                    FeedDetailsPresenter.this.H.b = false;
                } else {
                    if (bluedEntity.getSingleData() != null) {
                        if (!TextUtils.isEmpty(bluedEntity.getSingleData().feed_id)) {
                            FeedDetailsPresenter.this.n = bluedEntity.getSingleData();
                            FeedDetailsPresenter.this.n.feed_bubble_type = FeedDetailsPresenter.this.I;
                            iFetchDataListener.a("feed_data", bluedEntity.data);
                        }
                        if (FeedDetailsPresenter.this.C != 1) {
                            iFetchDataListener.a("comment_list", bluedEntity.getSingleData().comments);
                        } else if ((FeedDetailsPresenter.this.n.hot_comments == null || FeedDetailsPresenter.this.n.hot_comments.size() == 0) && (FeedDetailsPresenter.this.n.comments == null || FeedDetailsPresenter.this.n.comments.size() == 0)) {
                            FeedDetailsPresenter.this.H.b = false;
                            if (bluedEntity.extra != null && bluedEntity.extra.tick_negative_comment > 0) {
                                ArrayList arrayList = new ArrayList();
                                FeedComment feedComment = new FeedComment();
                                feedComment.itemViewType = 1;
                                feedComment.tick_negative_comment = bluedEntity.extra.tick_negative_comment;
                                arrayList.add(0, feedComment);
                                iFetchDataListener.a("comment_list", arrayList);
                            }
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            if (FeedDetailsPresenter.this.n.hot_comments != null && FeedDetailsPresenter.this.n.hot_comments.size() > 0) {
                                FeedDetailsPresenter.this.n.hot_comments.get(FeedDetailsPresenter.this.n.hot_comments.size() - 1).isLastHotComment = true;
                                if (FeedDetailsPresenter.this.n.hot_comments_more == 1) {
                                    FeedDetailsPresenter.this.n.hot_comments.get(FeedDetailsPresenter.this.n.hot_comments.size() - 1).isHasMoreHotComment = true;
                                }
                                arrayList2.addAll(FeedDetailsPresenter.this.n.hot_comments);
                            }
                            arrayList2.addAll(FeedDetailsPresenter.this.n.comments);
                            if (bluedEntity.extra != null && bluedEntity.extra.tick_negative_comment > 0) {
                                FeedComment feedComment2 = new FeedComment();
                                feedComment2.itemViewType = 1;
                                feedComment2.tick_negative_comment = bluedEntity.extra.tick_negative_comment;
                                arrayList2.add(0, feedComment2);
                            }
                            if (arrayList2.size() > 7) {
                                ArrayList arrayList3 = new ArrayList();
                                int i = 0;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= arrayList2.size()) {
                                        break;
                                    }
                                    if (i2 < 7) {
                                        arrayList3.add((FeedComment) arrayList2.get(i2));
                                    } else {
                                        FeedDetailsPresenter.this.w.add((FeedComment) arrayList2.get(i2));
                                    }
                                    i = i2 + 1;
                                }
                                iFetchDataListener.a("comment_list", arrayList3);
                                FeedDetailsPresenter.this.i = arrayList3.size() > 0;
                            } else {
                                iFetchDataListener.a("comment_list", arrayList2);
                                FeedDetailsPresenter.this.i = arrayList2.size() > 0;
                            }
                            if (FeedDetailsPresenter.this.v != null && FeedDetailsPresenter.this.v.k()) {
                                FeedDetailsPresenter.this.v.w();
                            }
                        }
                    }
                    if (bluedEntity.extra != null) {
                        FeedDetailsPresenter.this.a("show_ad", (String) bluedEntity.extra.adms);
                        DataStatus dataStatus = FeedDetailsPresenter.this.H;
                        boolean z = false;
                        if (bluedEntity.extra.hasmore == 1) {
                            z = true;
                        }
                        dataStatus.b = z;
                    } else {
                        FeedDetailsPresenter.this.H.b = false;
                    }
                }
                if (FeedDetailsPresenter.this.G != 1 || FeedDetailsPresenter.this.t) {
                    return;
                }
                iFetchDataListener.b(FeedDetailsPresenter.this.H.b);
            }
        };
        String o = o();
        FeedHttpUtils.a(bluedUIHttpResponse, o, this.C + "", "40", this.o, this.n.is_ads, g());
    }

    private void o(final IFetchDataListener iFetchDataListener) {
        Activity h = h();
        BluedUIHttpResponse<BluedEntityA<FeedUserInfoModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<FeedUserInfoModel>>() { // from class: com.blued.community.ui.feed.presenter.FeedDetailsPresenter.8
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<FeedUserInfoModel> bluedEntityA) {
                if (bluedEntityA != null) {
                    iFetchDataListener.a("like_list", bluedEntityA.data);
                    if (bluedEntityA.extra == 0 || bluedEntityA.extra.hasmore != 1) {
                        FeedDetailsPresenter.this.H.a = false;
                    } else {
                        FeedDetailsPresenter.this.H.a = true;
                    }
                } else {
                    FeedDetailsPresenter.this.H.a = false;
                }
                if (FeedDetailsPresenter.this.G == 0) {
                    iFetchDataListener.b(FeedDetailsPresenter.this.H.a);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                if (!z) {
                    FeedDetailsPresenter.this.H.a = false;
                }
                FeedDetailsPresenter.this.H.e = !z;
                iFetchDataListener.a(z);
                FeedDetailsPresenter.this.f_("change_place_height");
            }
        };
        String o = o();
        FeedHttpUtils.b(h, bluedUIHttpResponse, o, this.B + "", "20", this.n.is_ads, g());
    }

    private void p(final IFetchDataListener iFetchDataListener) {
        Activity h = h();
        BluedUIHttpResponse<BluedEntity<FeedRepost, BluedEntityBaseExtra>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<FeedRepost, BluedEntityBaseExtra>>() { // from class: com.blued.community.ui.feed.presenter.FeedDetailsPresenter.9
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                if (!z) {
                    FeedDetailsPresenter.this.H.c = false;
                }
                FeedDetailsPresenter.this.H.g = !z;
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a(z);
                }
                FeedDetailsPresenter.this.f_("change_place_height");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<FeedRepost, BluedEntityBaseExtra> bluedEntity) {
                IFetchDataListener iFetchDataListener2;
                if (bluedEntity != null) {
                    IFetchDataListener iFetchDataListener3 = iFetchDataListener;
                    if (iFetchDataListener3 != null) {
                        iFetchDataListener3.a("repost_list", bluedEntity.data);
                    } else {
                        FeedDetailsPresenter.this.a("repost_list", (String) bluedEntity.data);
                    }
                    if (bluedEntity.extra == null || bluedEntity.extra.hasmore != 1) {
                        FeedDetailsPresenter.this.H.c = false;
                    } else {
                        FeedDetailsPresenter.this.H.c = true;
                    }
                } else {
                    FeedDetailsPresenter.this.H.c = false;
                }
                if (FeedDetailsPresenter.this.G != 0 || (iFetchDataListener2 = iFetchDataListener) == null) {
                    return;
                }
                iFetchDataListener2.b(FeedDetailsPresenter.this.H.c);
            }
        };
        String o = o();
        FeedHttpUtils.a(h, bluedUIHttpResponse, o, this.D + "", "20", this.n.is_ads, g());
    }

    public DataStatus A() {
        return this.H;
    }

    public boolean B() {
        List<FeedComment> list = this.w;
        return list != null && list.size() > 0;
    }

    public String C() {
        return this.y;
    }

    public void a(int i) {
        this.G = i;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        if (bundle != null) {
            int i = bundle.getInt("from", -1);
            this.p = i;
            if (i == 0) {
                this.q = 8;
            } else if (i == 1) {
                this.q = 9;
            } else if (i == 4) {
                this.q = 6;
            } else if (i == 6) {
                this.q = 7;
            } else if (i == 8) {
                this.q = 10;
            }
            this.r = bundle.getInt("show_photo");
            int i2 = bundle.getInt("feed_is_ads");
            String string = bundle.getString("feed_aid");
            this.h = bundle.getBoolean("if_from_comment");
            this.i = bundle.getBoolean("has_comment");
            FeedDetailParams feedDetailParams = (FeedDetailParams) bundle.getSerializable("FEED_LIST_PARAMS");
            this.A = feedDetailParams;
            this.J = TextUtils.equals(feedDetailParams.agency, "like");
            try {
                BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) bundle.getSerializable("feed_data");
                this.n = bluedIngSelfFeed;
                if (bluedIngSelfFeed != null) {
                    this.j = bluedIngSelfFeed.is_top_new;
                    this.k = this.n.is_strong_insert;
                    this.I = this.n.feed_bubble_type;
                    this.l = this.n.is_hot_feed;
                }
                this.o = bundle.getString("feed_comment_id");
                this.s = p().getContentData().user_name;
                p().is_ads = i2;
                p().aid = string;
                p().is_recommend_ticktocks = 0;
                p().recommend_text = null;
                p().distance = null;
                p().feed_timestamp = null;
                f_("feed_data");
            } catch (Exception e) {
                i();
                e.printStackTrace();
            }
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(LifecycleOwner lifecycleOwner) {
        super.a(lifecycleOwner);
        FeedMethods.a(lifecycleOwner, this);
        LiveEventBus.get("comment_meanwhile", FeedComment.class).observe(lifecycleOwner, new Observer<FeedComment>() { // from class: com.blued.community.ui.feed.presenter.FeedDetailsPresenter.1
            /* renamed from: a */
            public void onChanged(FeedComment feedComment) {
                CommentListDataObserver.a().a(feedComment, FeedDetailsPresenter.this.y);
                LiveEventBus.get("feed_add_comment").post(feedComment);
                FeedDetailsPresenter.this.f_("init_edit");
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        A().b = true;
        e(iFetchDataListener);
        c(iFetchDataListener);
        A().a = true;
        g(iFetchDataListener);
        A().c = true;
        i(iFetchDataListener);
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed != null && o().equals(bluedIngSelfFeed.feed_id)) {
            i();
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(FeedComment feedComment) {
        if (feedComment == null || !o().equals(feedComment.feed_id)) {
            return;
        }
        p().feed_comment++;
        f_("feed_data");
        a("feed_no_data_tab", (String) 1);
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(BusFeedInteractModel busFeedInteractModel) {
        if (busFeedInteractModel == null || !o().equals(busFeedInteractModel.getFeedId())) {
            return;
        }
        p().interaction_count = busFeedInteractModel.getInteraction_count();
        p().interaction_id = busFeedInteractModel.getInteraction_id();
        if (busFeedInteractModel.isAdd()) {
            p().expression_id = busFeedInteractModel.getExpression_id();
        } else {
            p().expression_id = 0;
        }
        f_("feed_data");
    }

    public void a(FeedDetailsFragment feedDetailsFragment) {
        this.v = feedDetailsFragment;
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(FeedRepost feedRepost) {
        if (feedRepost == null || !o().equals(feedRepost.feed_id)) {
            return;
        }
        p().repost_count++;
        f_("feed_data");
        a("feed_no_data_tab", (String) 2);
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(String str, int i) {
        if (o().equals(str)) {
            p().allow_comments = i;
            f_("feed_data");
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(String str, String str2) {
        if (o().equals(str)) {
            p().feed_comment--;
            if (p().feed_comment < 0) {
                p().feed_comment = 0;
            }
            f_("feed_data");
            a("feed_no_data_tab", (String) 1);
        }
    }

    public void a(boolean z) {
        this.u = z;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        int i = this.G;
        if (i == 0) {
            h(iFetchDataListener);
        } else if (i != 1) {
            if (i != 2) {
                return;
            }
            j(iFetchDataListener);
        } else if (!this.u) {
            d(iFetchDataListener);
        } else if (this.w.size() > 0) {
            l(iFetchDataListener);
        } else {
            f(iFetchDataListener);
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void b(BluedIngSelfFeed bluedIngSelfFeed) {
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void b(String str, int i) {
        if (o().equals(str)) {
            p().reading_scope = i;
            f_("feed_data");
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void b(String str, String str2) {
    }

    public void b(boolean z) {
        LiveEventBus.get("feed_vote_change").post(this.n);
        FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA>(g()) { // from class: com.blued.community.ui.feed.presenter.FeedDetailsPresenter.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA bluedEntityA) {
            }
        }, o(), UserInfo.getInstance().getLoginUserInfo().uid, z, g());
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void c(int i) {
        Log.v("drb", "notifyDynamicSkin resId:" + i);
        if (i != -1 && TextUtils.equals(this.n.feed_uid, UserInfo.getInstance().getLoginUserInfo().uid)) {
            this.n.theme_id = i;
        }
        f_("feed_data");
    }

    public void c(IFetchDataListener iFetchDataListener) {
        this.E = 1;
        this.H.d = true;
        m(iFetchDataListener);
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void c(String str) {
        if (o().equals(str)) {
            p().repost_count--;
            p().repost_count = p().repost_count < 0 ? 0 : p().repost_count;
            f_("feed_data");
            a("feed_no_data_tab", (String) 2);
            i((IFetchDataListener) null);
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void c(String str, int i) {
        if (o().equals(str)) {
            if (i == 1) {
                p().feed_dig++;
                if (p().is_expression == 1) {
                    p().interaction_count++;
                }
            } else {
                p().feed_dig--;
                if (p().feed_dig < 0) {
                    p().feed_dig = 0;
                }
                if (p().is_expression == 1) {
                    p().interaction_count = Math.max(p().interaction_count - 1, 0);
                }
            }
            p().iliked = i;
            f_("feed_data");
            a("feed_no_data_tab", (String) 0);
            p().isPlayLikeAnim = false;
        }
    }

    public void c(String str, String str2) {
        FeedHttpUtils.a(h(), new BluedUIHttpResponse<BluedEntity>() { // from class: com.blued.community.ui.feed.presenter.FeedDetailsPresenter.5
            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onSuccess(String str3) {
                AppMethods.d(R.string.community_report_success);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, str, str2, g());
    }

    public void c(boolean z) {
        this.J = z;
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void d(int i) {
        if (i != -1 && TextUtils.equals(this.n.feed_uid, UserInfo.getInstance().getLoginUserInfo().uid)) {
            this.n.theme_pendant = i;
        }
        f_("feed_data");
    }

    public void d(IFetchDataListener iFetchDataListener) {
        if (this.H.d) {
            this.E++;
            m(iFetchDataListener);
        }
    }

    public void d(String str) {
        FeedComment feedComment = new FeedComment();
        final boolean z = this.z;
        if (!z) {
            feedComment.comment_id = this.y;
            feedComment.is_ads = this.n.is_ads;
            feedComment.aid = this.n.aid;
        }
        FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<FeedComment>>(g()) { // from class: com.blued.community.ui.feed.presenter.FeedDetailsPresenter.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<FeedComment> bluedEntityA) {
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                            return;
                        }
                        FeedComment feedComment2 = bluedEntityA.data.get(0);
                        CommentListDataObserver.a().a(feedComment2, FeedDetailsPresenter.this.y);
                        LiveEventBus.get("feed_add_comment").post(feedComment2);
                        FeedDetailsPresenter.this.f_("init_edit");
                        if (z) {
                            FeedDetailsPresenter.this.f_("scroll_to_comment_show_mark");
                        }
                        AppMethods.a((CharSequence) AppUtils.a(R.string.send_successful));
                        FeedDetailsPresenter.this.i = true;
                        if (FeedDetailsPresenter.this.v == null || !FeedDetailsPresenter.this.v.k()) {
                            return;
                        }
                        FeedDetailsPresenter.this.v.w();
                    } catch (Exception e) {
                        AppMethods.a((CharSequence) AppUtils.a(R.string.common_net_error));
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z2) {
                FeedDetailsPresenter.this.b("_load_type_default_", z2);
                if (z2) {
                    if (FeedDetailsPresenter.this.w() == 4 || FeedDetailsPresenter.this.w() == 19 || FeedDetailsPresenter.this.w() == 0 || FeedDetailsPresenter.this.w() == 6) {
                        FeedMethods.d();
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                FeedDetailsPresenter.this.d_("_load_type_default_");
            }
        }, p(), feedComment, str, g());
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void d(String str, int i) {
        if (TextUtils.equals(str, this.n.feed_id)) {
            this.n.is_top = i;
            f_("feed_data");
        }
    }

    public void d(boolean z) {
        this.z = z;
    }

    public void e(IFetchDataListener iFetchDataListener) {
        this.C = 1;
        n(iFetchDataListener);
        k(iFetchDataListener);
    }

    public void e(String str) {
        EventHttpUtils.c(new BluedUIHttpResponse<BluedEntityA>(g()) { // from class: com.blued.community.ui.feed.presenter.FeedDetailsPresenter.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA bluedEntityA) {
                FeedDetailsPresenter.this.f_("sub_owner_event");
            }
        }, str, g());
    }

    public void f(IFetchDataListener iFetchDataListener) {
        if (this.H.b) {
            this.C++;
            n(iFetchDataListener);
        }
    }

    public void f(String str) {
        this.x = str;
    }

    public void g(IFetchDataListener iFetchDataListener) {
        this.B = 1;
        o(iFetchDataListener);
    }

    public void g(String str) {
        this.y = str;
    }

    public void h(IFetchDataListener iFetchDataListener) {
        if (this.H.a) {
            this.B++;
            o(iFetchDataListener);
        }
    }

    public void i(IFetchDataListener iFetchDataListener) {
        this.D = 1;
        p(iFetchDataListener);
    }

    public void j(IFetchDataListener iFetchDataListener) {
        if (this.H.c) {
            this.D++;
            p(iFetchDataListener);
        }
    }

    public void k(IFetchDataListener iFetchDataListener) {
        FeedHttpUtils.g(new BluedUIHttpResponse<BluedEntityA<EventDetailsModel>>(g()) { // from class: com.blued.community.ui.feed.presenter.FeedDetailsPresenter.11
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EventDetailsModel> bluedEntityA) {
                if (bluedEntityA != null) {
                    FeedDetailsPresenter.this.a("recommend_event", (String) bluedEntityA.data);
                }
            }
        }, o(), g());
    }

    public void m() {
        FeedHttpUtils.a(h(), new BluedUIHttpResponse<BluedEntity>() { // from class: com.blued.community.ui.feed.presenter.FeedDetailsPresenter.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                FeedDetailsPresenter.this.b("_load_type_default_", z);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                FeedDetailsPresenter.this.d_("_load_type_default_");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                AppMethods.d(R.string.del_success);
                LiveEventBus.get("feed_delete").post(FeedDetailsPresenter.this.n);
                if (FeedDetailsPresenter.this.n.repost != null) {
                    LiveEventBus.get("feed_delete_repost").post(FeedDetailsPresenter.this.n.repost.feed_id);
                }
                FeedDetailsPresenter.this.i();
            }
        }, o(), g());
    }

    public int n() {
        return this.G;
    }

    public String o() {
        String str = p().feed_id;
        if (TextUtils.isEmpty(str)) {
            i();
        }
        return str;
    }

    public BluedIngSelfFeed p() {
        if (this.n == null) {
            this.n = new BluedIngSelfFeed();
        }
        this.n.strong_insert_data = q().strong_insert_data;
        this.n.is_new_face = q().is_new_face;
        this.n.tips_text = q().tips_text;
        this.n.tips = q().tips;
        this.n.recommend_time = q().recommend_time;
        this.n.is_top_feed = q().is_top_feed;
        this.n.is_op_recommend = q().is_subject_recommend_feed;
        return this.n;
    }

    public FeedDetailParams q() {
        if (this.A == null) {
            this.A = new FeedDetailParams(0);
        }
        return this.A;
    }

    public FeedParse r() {
        if (p().feedParse == null) {
            p().feedParse = new FeedParse(h(), this.n, 2, p().super_topics_name);
        }
        return p().feedParse;
    }

    public boolean s() {
        return this.J;
    }

    public boolean t() {
        return p().is_repost == 1 && p().repost != null;
    }

    public BluedIngSelfFeed u() {
        return t() ? p().repost : p();
    }

    public boolean v() {
        return this.t;
    }

    public int w() {
        return this.p;
    }

    public int x() {
        return this.q;
    }

    public int y() {
        return this.r;
    }

    public String z() {
        return this.s;
    }
}
