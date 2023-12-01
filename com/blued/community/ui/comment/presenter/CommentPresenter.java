package com.blued.community.ui.comment.presenter;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.community.R;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.circle.model.CircleAddPoints;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.feed.observer.CommentListDataObserver;
import com.blued.community.utils.UserInfoUtils;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/comment/presenter/CommentPresenter.class */
public class CommentPresenter extends MvpPresenter {
    private String h;
    private String i;
    private String j;
    private String k;
    private BluedIngSelfFeed l;
    private String n;
    private boolean o;
    private int p;
    private boolean s;
    private FeedComment t;
    private String u;
    private String v;
    private int m = -1;
    private int q = 1;
    private int r = 20;

    private void c(final IFetchDataListener iFetchDataListener) {
        FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<FeedComment>>(g()) { // from class: com.blued.community.ui.comment.presenter.CommentPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<FeedComment> bluedEntityA) {
                if (bluedEntityA != null) {
                    CommentPresenter.this.t = bluedEntityA.getSingleData();
                    iFetchDataListener.a("comment", bluedEntityA.data);
                    iFetchDataListener.a(ContactsContract.StreamItemsColumns.COMMENTS, CommentPresenter.this.t.comments);
                    if (bluedEntityA.extra == 0 || bluedEntityA.extra.hasmore != 1) {
                        CommentPresenter.this.s = false;
                    } else {
                        CommentPresenter.this.s = true;
                    }
                    iFetchDataListener.b(CommentPresenter.this.s);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (CommentPresenter.this.q != 1) {
                    CommentPresenter.d(CommentPresenter.this);
                }
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                iFetchDataListener.a(z);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                iFetchDataListener.a();
            }
        }, A(), this.i, this.q + "", this.r + "", this.n, g());
    }

    static /* synthetic */ int d(CommentPresenter commentPresenter) {
        int i = commentPresenter.q;
        commentPresenter.q = i - 1;
        return i;
    }

    public boolean A() {
        return !B();
    }

    public boolean B() {
        return !TextUtils.isEmpty(this.k);
    }

    public boolean C() {
        return this.o;
    }

    public void a(int i) {
        m().must_anonym_reply = i;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        if (bundle != null) {
            this.h = bundle.getString("title");
            this.j = bundle.getString("feed_id");
            this.i = bundle.getString("comment_id");
            this.k = bundle.getString("circle_id");
            this.p = bundle.getInt("from");
            this.l = (BluedIngSelfFeed) bundle.getSerializable("feed_data");
            this.m = bundle.getInt("anonymous_header_number");
            this.n = bundle.getString("mark_comment_id");
            this.o = bundle.getBoolean("can_at", true);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        this.q = 1;
        c(iFetchDataListener);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        this.q++;
        c(iFetchDataListener);
    }

    public void c(String str, final boolean z) {
        if (this.t == null) {
            return;
        }
        if (TextUtils.isEmpty(this.u)) {
            w();
        }
        FeedComment feedComment = new FeedComment();
        feedComment.comment_id = this.u;
        feedComment.is_ads = m().is_ads;
        feedComment.aid = m().aid;
        BluedUIHttpResponse<BluedEntityA<FeedComment>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<FeedComment>>(g()) { // from class: com.blued.community.ui.comment.presenter.CommentPresenter.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<FeedComment> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                FeedComment feedComment2 = bluedEntityA.data.get(0);
                CommentListDataObserver.a().a(feedComment2, CommentPresenter.this.t.comment_id);
                CommentPresenter.this.f_("comment_success");
                if (z) {
                    CommentPresenter.this.a(1);
                } else {
                    CommentPresenter.this.a(2);
                }
                CommentPresenter.this.f_("comment_state");
                if (feedComment2.circle_active_comment <= 0) {
                    AppMethods.a((CharSequence) AppInfo.d().getString(R.string.send_successful));
                    return;
                }
                AppMethods.a((CharSequence) ("回帖成功，积分+" + feedComment2.circle_active_comment));
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z2) {
                CommentPresenter.this.b((String) null, z2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                CommentPresenter.this.d_(null);
            }
        };
        if (A()) {
            FeedHttpUtils.a(bluedUIHttpResponse, m(), feedComment, str, g());
        } else {
            CircleHttpUtils.a(bluedUIHttpResponse, m(), feedComment, str, z, this.m, g());
        }
    }

    public void d(String str) {
        this.u = str;
    }

    public void e(String str) {
        this.v = str;
    }

    public BluedIngSelfFeed m() {
        if (this.l == null) {
            this.l = new BluedIngSelfFeed();
        }
        return this.l;
    }

    public String n() {
        return this.k;
    }

    public String o() {
        return TextUtils.isEmpty(this.h) ? AppInfo.d().getString(R.string.notice_reply) : this.h;
    }

    public String p() {
        return "feed_comment_floor";
    }

    public FeedComment q() {
        if (this.t == null) {
            this.t = new FeedComment();
        }
        return this.t;
    }

    public String r() {
        FeedComment feedComment = this.t;
        if (feedComment != null) {
            return feedComment.feed_id;
        }
        return null;
    }

    public boolean s() {
        FeedComment feedComment = this.t;
        if (feedComment == null) {
            return true;
        }
        return TextUtils.equals(feedComment.comment_uid, UserInfoUtils.c());
    }

    public UserBasicModel t() {
        if (this.t == null || s()) {
            return null;
        }
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.name = this.t.user_name;
        userBasicModel.uid = this.t.comment_uid;
        userBasicModel.avatar = this.t.user_avatar;
        return userBasicModel;
    }

    public void u() {
        FeedComment feedComment = this.t;
        if (feedComment != null) {
            String str = feedComment.comment_id;
            String str2 = this.t.feed_id;
            int i = this.t.iliked == 0 ? 1 : 0;
            this.t.iliked = i;
            if (i == 1) {
                this.t.liked_count++;
            } else {
                this.t.liked_count--;
            }
            a("like", (String) this.t);
            FeedHttpUtils.a(str2, str, i, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<CircleAddPoints>>(g()) { // from class: com.blued.community.ui.comment.presenter.CommentPresenter.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<CircleAddPoints> bluedEntityA) {
                    if (bluedEntityA == null || !bluedEntityA.hasData() || bluedEntityA.getSingleData().circle_active_liked_posting <= 0) {
                        return;
                    }
                    AppMethods.a((CharSequence) ("点赞成功，积分+" + bluedEntityA.getSingleData().circle_active_liked_posting));
                }
            }, g(), true);
        }
    }

    public String v() {
        return this.v;
    }

    public void w() {
        FeedComment feedComment = this.t;
        if (feedComment == null) {
            return;
        }
        this.u = feedComment.comment_id;
        this.v = this.t.user_name;
    }

    public int x() {
        return m().must_anonym_reply;
    }

    public int y() {
        return this.m;
    }

    public int z() {
        return this.p;
    }
}
