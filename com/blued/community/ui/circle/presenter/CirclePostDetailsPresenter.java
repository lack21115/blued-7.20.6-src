package com.blued.community.ui.circle.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.community.R;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.circle.model.CircleAddPoints;
import com.blued.community.ui.circle.model.CircleJoinState;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.comment.adapter.CircleMainDetailCommentAdapter;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.feed.model.CircleListToDetailParams;
import com.blued.community.utils.AtUserHelper;
import com.blued.community.utils.UserInfoUtils;
import com.blued.das.client.feed.FeedProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/presenter/CirclePostDetailsPresenter.class */
public class CirclePostDetailsPresenter extends MvpPresenter {
    private BluedIngSelfFeed j;
    private CircleListToDetailParams k;
    private String m;
    private FeedProtos.NoteSource n;
    private CircleMainDetailCommentAdapter o;
    private String l = "";
    private int p = 1;
    private int q = 20;
    public boolean h = true;
    private boolean r = false;
    private boolean s = false;
    private int t = -1;
    private boolean u = true;
    boolean i = false;

    private void c(final IFetchDataListener iFetchDataListener) {
        CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>(g()) { // from class: com.blued.community.ui.circle.presenter.CirclePostDetailsPresenter.6
            boolean a;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    CirclePostDetailsPresenter.this.h = false;
                } else {
                    if (CirclePostDetailsPresenter.this.p == 1) {
                        CirclePostDetailsPresenter.this.j = bluedEntityA.getSingleData();
                        CirclePostDetailsPresenter.this.a("data_circle_detail", (String) bluedEntityA.getSingleData());
                        if ((CirclePostDetailsPresenter.this.j.hot_comments == null || CirclePostDetailsPresenter.this.j.hot_comments.size() == 0) && (CirclePostDetailsPresenter.this.j.comments == null || CirclePostDetailsPresenter.this.j.comments.size() == 0)) {
                            iFetchDataListener.a("data_comment_list", new ArrayList());
                        } else {
                            ArrayList arrayList = new ArrayList();
                            if (CirclePostDetailsPresenter.this.j.hot_comments == null || CirclePostDetailsPresenter.this.j.hot_comments.size() <= 0) {
                                arrayList.addAll(CirclePostDetailsPresenter.this.j.comments);
                            } else {
                                CirclePostDetailsPresenter.this.j.hot_comments.get(CirclePostDetailsPresenter.this.j.hot_comments.size() - 1).isLastHotComment = true;
                                if (CirclePostDetailsPresenter.this.j.hot_comments_more == 1) {
                                    CirclePostDetailsPresenter.this.j.hot_comments.get(CirclePostDetailsPresenter.this.j.hot_comments.size() - 1).isHasMoreHotComment = true;
                                }
                                arrayList.addAll(CirclePostDetailsPresenter.this.j.hot_comments);
                                arrayList.addAll(CirclePostDetailsPresenter.this.j.comments);
                            }
                            iFetchDataListener.a("data_comment_list", arrayList);
                            boolean z = false;
                            if (arrayList.size() > 1) {
                                z = false;
                                if (((FeedComment) arrayList.get(0)).comment_pics != null) {
                                    z = false;
                                    if (((FeedComment) arrayList.get(0)).comment_pics.length > 0) {
                                        z = true;
                                    }
                                }
                            }
                            this.a = z;
                        }
                    } else {
                        iFetchDataListener.a("data_comment_list", bluedEntityA.getSingleData().comments);
                    }
                    CirclePostDetailsPresenter.this.h = bluedEntityA.hasMore();
                }
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.b(CirclePostDetailsPresenter.this.h);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (CirclePostDetailsPresenter.this.p <= 1) {
                    CirclePostDetailsPresenter.this.i();
                }
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (!z) {
                    CirclePostDetailsPresenter.d(CirclePostDetailsPresenter.this);
                }
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a(z);
                }
                if (CirclePostDetailsPresenter.this.u) {
                    if (!TextUtils.isEmpty(CirclePostDetailsPresenter.this.m)) {
                        CirclePostDetailsPresenter.this.a("data_scroll_to_mark_comment", (String) Boolean.valueOf(this.a), false);
                    }
                    CirclePostDetailsPresenter.this.u = false;
                }
                if (z) {
                    CirclePostDetailsPresenter.this.v();
                }
            }
        }, !p() ? this.l : this.j.feed_id, this.p, this.q, this.m, g());
    }

    static /* synthetic */ int d(CirclePostDetailsPresenter circlePostDetailsPresenter) {
        int i = circlePostDetailsPresenter.p;
        circlePostDetailsPresenter.p = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.i) {
            return;
        }
        EventTrackFeed.a(EventTrackFeed.a(FeedProtos.Event.CIRCLE_NOTE_DETAIL_SHOW, this.j, r(), r() == FeedProtos.NoteSource.CIRCLE_TOP, this.k.getMode()));
        this.i = true;
    }

    public void a(int i) {
        CircleHttpUtils.a(new BluedUIHttpResponse(g()) { // from class: com.blued.community.ui.circle.presenter.CirclePostDetailsPresenter.9
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                AppMethods.d(R.string.vote_success);
            }
        }, this.j.feed_id, i, g());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        if (bundle != null) {
            this.j = (BluedIngSelfFeed) bundle.getSerializable("feed_data");
            this.l = bundle.getString("feed_id");
            this.m = bundle.getString("comment_id");
            CircleListToDetailParams circleListToDetailParams = (CircleListToDetailParams) bundle.getSerializable("circle_list_to_detail_params");
            this.k = circleListToDetailParams;
            if (circleListToDetailParams == null) {
                this.k = new CircleListToDetailParams();
            }
            FeedProtos.NoteSource serializable = bundle.getSerializable("circle_from_page");
            this.n = serializable;
            if (serializable == null) {
                this.n = FeedProtos.NoteSource.UNKNOWN_NOTE_SOURCE;
            }
            boolean z = bundle.getBoolean("show_circle_entry");
            this.r = z;
            this.s = z;
            a("data_circle_detail", (String) this.j);
        }
        this.t = CircleMethods.a(h());
    }

    public void a(FragmentManager fragmentManager) {
        if (h() == null || fragmentManager == null) {
            return;
        }
        CircleMethods.a(h(), null, n().getJoinState(), g(), fragmentManager, false, true, !this.r);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(final LifecycleOwner lifecycleOwner) {
        super.a(lifecycleOwner);
        this.o.e();
        lifecycleOwner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.blued.community.ui.circle.presenter.CirclePostDetailsPresenter.1
            public void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    CirclePostDetailsPresenter.this.o.f();
                    lifecycleOwner.getLifecycle().removeObserver(this);
                }
            }
        });
        LiveEventBus.get("circle_delete_feed", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.community.ui.circle.presenter.CirclePostDetailsPresenter.2
            /* renamed from: a */
            public void onChanged(String str) {
                if (TextUtils.isEmpty(str) || !str.equals(CirclePostDetailsPresenter.this.n().feed_id)) {
                    return;
                }
                CirclePostDetailsPresenter.this.i();
            }
        });
        LiveEventBus.get("circle_join_state", CircleJoinState.class).observe(lifecycleOwner, new Observer<CircleJoinState>() { // from class: com.blued.community.ui.circle.presenter.CirclePostDetailsPresenter.3
            /* renamed from: a */
            public void onChanged(CircleJoinState circleJoinState) {
                if (TextUtils.isEmpty(CirclePostDetailsPresenter.this.o()) || !CirclePostDetailsPresenter.this.o().equals(circleJoinState.circle_id)) {
                    return;
                }
                CirclePostDetailsPresenter.this.n().setJoinState(circleJoinState);
                CirclePostDetailsPresenter circlePostDetailsPresenter = CirclePostDetailsPresenter.this;
                circlePostDetailsPresenter.a("data_circle_join", (String) circlePostDetailsPresenter.n());
            }
        });
        LiveEventBus.get("comment_meanwhile", FeedComment.class).observe(lifecycleOwner, new Observer<FeedComment>() { // from class: com.blued.community.ui.circle.presenter.CirclePostDetailsPresenter.4
            /* renamed from: a */
            public void onChanged(FeedComment feedComment) {
                CirclePostDetailsPresenter.this.a("data_add_comment", (String) feedComment);
            }
        });
        LiveEventBus.get("circle_info_modify", MyCircleModel.class).observe(lifecycleOwner, new Observer<MyCircleModel>() { // from class: com.blued.community.ui.circle.presenter.CirclePostDetailsPresenter.5
            /* renamed from: a */
            public void onChanged(MyCircleModel myCircleModel) {
                if (myCircleModel == null || !CirclePostDetailsPresenter.this.o().equals(myCircleModel.circle_id)) {
                    return;
                }
                CirclePostDetailsPresenter.this.n().cover = myCircleModel.cover;
                CirclePostDetailsPresenter circlePostDetailsPresenter = CirclePostDetailsPresenter.this;
                circlePostDetailsPresenter.a("data_circle_detail", (String) circlePostDetailsPresenter.n());
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        this.p = 1;
        this.h = true;
        c(iFetchDataListener);
    }

    public void a(CircleMainDetailCommentAdapter circleMainDetailCommentAdapter) {
        this.o = circleMainDetailCommentAdapter;
    }

    public void a(final FeedComment feedComment, String str, final boolean z) {
        if (!p() || TextUtils.isEmpty(this.j.circle_id)) {
            return;
        }
        EventTrackFeed.a(EventTrackFeed.a(FeedProtos.Event.CIRCLE_NOTE_COMMENT, this.j, (this.n == FeedProtos.NoteSource.CIRCLE_RECOMMEND_LIST || this.n == FeedProtos.NoteSource.CITY_NOTE) ? this.n : FeedProtos.NoteSource.NOTE_DETAIL, r() == FeedProtos.NoteSource.CIRCLE_TOP, this.k.getMode()).setCommentId(feedComment == null ? "" : feedComment.comment_id).setFeedClass(FeedProtos.FeedClass.FEED_WORD).setIsAnonymousComment(z));
        CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<FeedComment>>(g()) { // from class: com.blued.community.ui.circle.presenter.CirclePostDetailsPresenter.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<FeedComment> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                FeedComment feedComment2 = bluedEntityA.data.get(0);
                if (feedComment == null) {
                    CirclePostDetailsPresenter.this.a("data_add_comment", (String) feedComment2);
                } else {
                    CirclePostDetailsPresenter.this.a("data_add_reply", (String) feedComment2);
                }
                if (z) {
                    CirclePostDetailsPresenter.this.n().must_anonym_reply = 1;
                } else {
                    CirclePostDetailsPresenter.this.n().must_anonym_reply = 2;
                }
                CirclePostDetailsPresenter circlePostDetailsPresenter = CirclePostDetailsPresenter.this;
                circlePostDetailsPresenter.a("data_comment_state", (String) circlePostDetailsPresenter.n());
                if (feedComment2.circle_active_comment <= 0) {
                    AppMethods.a((CharSequence) CirclePostDetailsPresenter.this.h().getString(R.string.send_successful));
                    return;
                }
                AppMethods.a((CharSequence) ("回帖成功，积分+" + feedComment2.circle_active_comment));
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z2) {
                super.onUIFinish(z2);
                CirclePostDetailsPresenter.this.b("", z2);
                CirclePostDetailsPresenter.this.f_("data_enable_send_click");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                CirclePostDetailsPresenter.this.d_("");
            }
        }, n(), feedComment, str, z, this.t, g());
    }

    public void a(boolean z) {
        this.s = z;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        this.p++;
        c(iFetchDataListener);
    }

    public void m() {
        if (p()) {
            EventTrackFeed.a(this.j.circle_id, this.j.feed_id, "", this.j.iliked == 0, AtUserHelper.a(this.j.feed_content), EventTrackFeed.b(this.j), EventTrackFeed.c(this.j), this.j.is_anonym == 1, false, FeedProtos.NoteSource.NOTE_DETAIL, this.k.getMode());
            if (this.j.iliked == 0) {
                this.j.iliked = 1;
                this.j.feed_dig++;
                this.j.isPlayLikeAnim = true;
                a("data_circle_detail", (String) n());
                LiveEventBus.get("feed_like_change").post(this.j);
                CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<CircleAddPoints>>(g()) { // from class: com.blued.community.ui.circle.presenter.CirclePostDetailsPresenter.7
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<CircleAddPoints> bluedEntityA) {
                        if (bluedEntityA == null || !bluedEntityA.hasData() || bluedEntityA.getSingleData().circle_active_liked_posting <= 0) {
                            return;
                        }
                        AppMethods.a((CharSequence) ("点赞成功，积分+" + bluedEntityA.getSingleData().circle_active_liked_posting));
                    }
                }, UserInfoUtils.c(), this.j.feed_id, this.j.liked_url, g());
                return;
            }
            this.j.iliked = 0;
            if (this.j.feed_dig > 0) {
                this.j.feed_dig--;
            }
            a("data_circle_detail", (String) n());
            LiveEventBus.get("feed_like_change").post(this.j);
            CircleHttpUtils.a((BluedUIHttpResponse) null, UserInfoUtils.c(), this.j.feed_id, g());
        }
    }

    public BluedIngSelfFeed n() {
        if (!p()) {
            this.j = new BluedIngSelfFeed();
        }
        return this.j;
    }

    public String o() {
        return n().circle_id;
    }

    public boolean p() {
        BluedIngSelfFeed bluedIngSelfFeed = this.j;
        return (bluedIngSelfFeed == null || TextUtils.isEmpty(bluedIngSelfFeed.feed_id)) ? false : true;
    }

    public String q() {
        if (TextUtils.isEmpty(this.l)) {
            this.l = n().feed_id;
        }
        return this.l;
    }

    public FeedProtos.NoteSource r() {
        return this.n;
    }

    public int s() {
        return this.t;
    }

    public boolean t() {
        return this.r && n().isPublicCircle();
    }

    public boolean u() {
        return this.s && n().isPublicCircle();
    }
}
