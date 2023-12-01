package com.blued.community.ui.comment.presenter;

import android.app.Dialog;
import android.content.Context;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.community.R;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.comment.adapter.CommentListAdapter;
import com.blued.community.ui.comment.contract.IHotCommentsContract;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.feed.observer.CommentListDataObserver;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/comment/presenter/HotCommentsPresenter.class */
public class HotCommentsPresenter implements IHotCommentsContract.IPresenter {
    private IHotCommentsContract.IView a;
    private Context b;
    private IRequestHost c;
    private BluedIngSelfFeed d;
    private boolean f;
    private String i;
    private String j;
    private CommentListAdapter.FeedCommentListner k;
    private Dialog l;
    private int e = 1;
    private boolean g = true;
    private boolean h = true;
    private BluedUIHttpResponse m = new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>() { // from class: com.blued.community.ui.comment.presenter.HotCommentsPresenter.2
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
            HotCommentsPresenter.this.a.e();
            if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || bluedEntityA.data.get(0) == null || bluedEntityA.data.get(0).comments == null) {
                if (HotCommentsPresenter.this.e != 1) {
                    HotCommentsPresenter.d(HotCommentsPresenter.this);
                    HotCommentsPresenter.this.f = false;
                } else {
                    HotCommentsPresenter.this.a.f();
                }
                HotCommentsPresenter.this.a.b();
            } else if (bluedEntityA.data.get(0).comments.size() <= 0) {
                HotCommentsPresenter.this.a.b();
                if (HotCommentsPresenter.this.e == 1) {
                    HotCommentsPresenter.this.a.f();
                } else {
                    AppMethods.a((CharSequence) HotCommentsPresenter.this.b.getResources().getString(R.string.common_nomore_data));
                }
            } else {
                if (bluedEntityA.extra == 0 || bluedEntityA.extra.hasmore != 1) {
                    HotCommentsPresenter.this.f = false;
                    HotCommentsPresenter.this.a.b();
                } else {
                    HotCommentsPresenter.this.f = true;
                    HotCommentsPresenter.this.a.a();
                }
                if (HotCommentsPresenter.this.e == 1) {
                    HotCommentsPresenter.this.a.b(bluedEntityA.data.get(0).comments);
                } else {
                    HotCommentsPresenter.this.a.a(bluedEntityA.data.get(0).comments);
                }
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
            AppInfo.n().post(new Runnable() { // from class: com.blued.community.ui.comment.presenter.HotCommentsPresenter.2.1
                @Override // java.lang.Runnable
                public void run() {
                    HotCommentsPresenter.this.a.g();
                }
            });
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            HotCommentsPresenter.this.a.c();
        }
    };

    public HotCommentsPresenter(final Context context, BluedIngSelfFeed bluedIngSelfFeed, final IHotCommentsContract.IView iView, IRequestHost iRequestHost) {
        this.b = context;
        this.d = bluedIngSelfFeed;
        this.c = iRequestHost;
        this.a = iView;
        this.l = DialogUtils.a(context);
        this.k = new CommentListAdapter.FeedCommentListner() { // from class: com.blued.community.ui.comment.presenter.HotCommentsPresenter.1
            @Override // com.blued.community.ui.comment.adapter.CommentListAdapter.FeedCommentListner
            public void contentClick(FeedComment feedComment) {
                HotCommentsPresenter.this.g = false;
                HotCommentsPresenter.this.j = feedComment.comment_id;
                String string = context.getResources().getString(R.string.reply);
                HotCommentsPresenter.this.i = feedComment.user_name;
                IHotCommentsContract.IView iView2 = iView;
                iView2.a(string + feedComment.user_name + ":");
            }
        };
    }

    private void b(boolean z) {
        int i;
        if (z) {
            this.e = 1;
            this.a.b(new ArrayList());
        }
        if (this.e == 1) {
            this.f = true;
        }
        if (this.f || (i = this.e) == 1) {
            FeedHttpUtils.a(this.b, this.m, this.d.feed_id, this.e, 20, this.c);
            return;
        }
        this.e = i - 1;
        AppMethods.a((CharSequence) this.b.getResources().getString(R.string.common_nomore_data));
        this.a.c();
    }

    static /* synthetic */ int d(HotCommentsPresenter hotCommentsPresenter) {
        int i = hotCommentsPresenter.e;
        hotCommentsPresenter.e = i - 1;
        return i;
    }

    @Override // com.blued.community.ui.comment.contract.IHotCommentsContract.IPresenter
    public void a(String str) {
        this.j = str;
    }

    @Override // com.blued.community.ui.comment.contract.IHotCommentsContract.IPresenter
    public void a(String str, boolean z) {
        FeedComment feedComment = new FeedComment();
        if (!this.g) {
            feedComment.comment_id = this.j;
            feedComment.is_ads = this.d.is_ads;
            feedComment.aid = this.d.aid;
        }
        BluedUIHttpResponse<BluedEntityA<FeedComment>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<FeedComment>>(this.c) { // from class: com.blued.community.ui.comment.presenter.HotCommentsPresenter.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<FeedComment> bluedEntityA) {
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                            return;
                        }
                        FeedComment feedComment2 = bluedEntityA.data.get(0);
                        CommentListDataObserver.a().a(feedComment2, "");
                        LiveEventBus.get("feed_add_comment").post(feedComment2);
                        HotCommentsPresenter.this.g = true;
                        HotCommentsPresenter.this.a.d();
                        AppMethods.d(R.string.send_successful);
                    } catch (Exception e) {
                        AppMethods.d(R.string.common_net_error);
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogUtils.b(HotCommentsPresenter.this.l);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                DialogUtils.a(HotCommentsPresenter.this.l);
            }
        };
        if (e()) {
            FeedHttpUtils.a(bluedUIHttpResponse, this.d, feedComment, str, this.c);
        } else {
            CircleHttpUtils.a(bluedUIHttpResponse, this.d, feedComment, str, z, -1, this.c);
        }
    }

    @Override // com.blued.community.ui.comment.contract.IHotCommentsContract.IPresenter
    public void a(boolean z) {
        this.h = z;
    }

    @Override // com.blued.android.framework.mvp_similarity.BasePresenter
    public void ar_() {
    }

    @Override // com.blued.community.ui.comment.contract.IHotCommentsContract.IPresenter
    public void b() {
        b(true);
    }

    @Override // com.blued.community.ui.comment.contract.IHotCommentsContract.IPresenter
    public void b(String str) {
        this.i = str;
    }

    @Override // com.blued.community.ui.comment.contract.IHotCommentsContract.IPresenter
    public void c() {
        this.e++;
        b(false);
    }

    @Override // com.blued.community.ui.comment.contract.IHotCommentsContract.IPresenter
    public CommentListAdapter.FeedCommentListner d() {
        return this.k;
    }

    public boolean e() {
        return !f();
    }

    public boolean f() {
        BluedIngSelfFeed bluedIngSelfFeed = this.d;
        return bluedIngSelfFeed != null && CircleMethods.a(bluedIngSelfFeed);
    }
}
