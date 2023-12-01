package com.blued.community.ui.video.presenter;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.community.R;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedParse;
import com.blued.community.model.FeedUserInfoModel;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.eventbus.BusFeedInteractModel;
import com.blued.community.ui.feed.model.FeedRepost;
import com.blued.community.ui.feed.observer.CommentListDataObserver;
import com.blued.community.ui.feed.observer.IFeedDataObserver;
import com.blued.community.ui.video.observer.IFeedDetailContract;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/presenter/FeedDetailOldPresenter.class */
public class FeedDetailOldPresenter implements IFeedDataObserver, IFeedDetailContract.IPresenter {

    /* renamed from: a  reason: collision with root package name */
    private BluedIngSelfFeed f20429a;
    private IFeedDetailContract.IView b;

    /* renamed from: c  reason: collision with root package name */
    private Context f20430c;
    private IRequestHost d;
    private Dialog e;
    private int j;
    private boolean m;
    private int f = 1;
    private int g = 1;
    private int h = 1;
    private boolean k = true;
    private boolean l = false;
    private int n = 1;
    private DataStatus i = new DataStatus();

    /* renamed from: com.blued.community.ui.video.presenter.FeedDetailOldPresenter$1  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/presenter/FeedDetailOldPresenter$1.class */
    class AnonymousClass1 extends BluedUIHttpResponse<BluedEntityA> {
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA bluedEntityA) {
        }
    }

    /* renamed from: com.blued.community.ui.video.presenter.FeedDetailOldPresenter$3  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/presenter/FeedDetailOldPresenter$3.class */
    class AnonymousClass3 extends BluedUIHttpResponse<BluedEntity> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedDetailOldPresenter f20432a;

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            this.f20432a.b.n();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            this.f20432a.b.m();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity bluedEntity) {
            AppMethods.d(R.string.del_success);
            LiveEventBus.get("feed_delete").post(this.f20432a.f20429a);
            if (this.f20432a.f20429a.repost != null) {
                LiveEventBus.get("feed_delete_repost").post(this.f20432a.f20429a.repost.feed_id);
            }
            this.f20432a.b.s();
        }
    }

    /* renamed from: com.blued.community.ui.video.presenter.FeedDetailOldPresenter$4  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/presenter/FeedDetailOldPresenter$4.class */
    class AnonymousClass4 extends BluedUIHttpResponse<BluedEntity> {
        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onSuccess(String str) {
            AppMethods.d(R.string.community_report_success);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity bluedEntity) {
        }
    }

    /* renamed from: com.blued.community.ui.video.presenter.FeedDetailOldPresenter$5  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/presenter/FeedDetailOldPresenter$5.class */
    class AnonymousClass5 extends BluedUIHttpResponse<BluedEntityA<FeedUserInfoModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f20433a;
        final /* synthetic */ FeedDetailOldPresenter b;

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<FeedUserInfoModel> bluedEntityA) {
            boolean z = true;
            if (bluedEntityA != null) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    if (this.f20433a == 1) {
                        this.b.b.a(new ArrayList());
                        this.b.i.d = 0;
                    }
                } else if (this.f20433a == 1) {
                    this.b.b.a(bluedEntityA.data);
                } else {
                    this.b.b.d(bluedEntityA.data);
                }
                if (bluedEntityA.extra != 0) {
                    DataStatus dataStatus = this.b.i;
                    if (bluedEntityA.extra.hasmore != 1) {
                        z = false;
                    }
                    dataStatus.f20440a = z;
                } else {
                    this.b.i.f20440a = false;
                }
            } else {
                this.b.i.d = 1;
            }
            this.b.b.b(0);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
            this.b.i.d = 2;
            this.b.i.f20440a = false;
            AppInfo.n().post(new Runnable() { // from class: com.blued.community.ui.video.presenter.FeedDetailOldPresenter.5.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AnonymousClass5.this.f20433a == 1) {
                        AnonymousClass5.this.b.b.b(0);
                    } else {
                        AnonymousClass5.this.b.b.q();
                    }
                }
            });
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            this.b.b.r();
            this.b.b.u();
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/presenter/FeedDetailOldPresenter$DATA_STATUS.class */
    public interface DATA_STATUS {
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/presenter/FeedDetailOldPresenter$DataStatus.class */
    public class DataStatus {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20440a = true;
        public boolean b = true;

        /* renamed from: c  reason: collision with root package name */
        public boolean f20441c = true;
        public int d = 1;
        public int e = 1;
        public int f = 1;
        public boolean g = true;

        public DataStatus() {
        }
    }

    public FeedDetailOldPresenter(Context context, IFeedDetailContract.IView iView, BluedIngSelfFeed bluedIngSelfFeed, int i, IRequestHost iRequestHost) {
        this.j = -1;
        this.f20430c = context;
        this.b = iView;
        this.f20429a = bluedIngSelfFeed;
        this.d = iRequestHost;
        this.j = i;
        this.e = DialogUtils.a(this.f20430c);
    }

    private void h() {
        final int i = this.n;
        Context context = this.f20430c;
        BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>(this.d) { // from class: com.blued.community.ui.video.presenter.FeedDetailOldPresenter.6
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
                        bluedIngSelfFeed.feedParse = new FeedParse(FeedDetailOldPresenter.this.f20430c, bluedIngSelfFeed, 2);
                    }
                }
                return bluedEntityA;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
                boolean z = false;
                if (bluedEntityA == null) {
                    FeedDetailOldPresenter.this.b.a(null, i, false);
                    return;
                }
                if (bluedEntityA.extra != 0) {
                    DataStatus dataStatus = FeedDetailOldPresenter.this.i;
                    if (bluedEntityA.extra.hasmore == 1) {
                        z = true;
                    }
                    dataStatus.g = z;
                } else {
                    FeedDetailOldPresenter.this.i.g = false;
                }
                FeedDetailOldPresenter.this.b.a(bluedEntityA.data, i, FeedDetailOldPresenter.this.i.g);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                if (z) {
                    return;
                }
                FeedDetailOldPresenter.this.b.a(null, i, false);
            }
        };
        String str = this.f20429a.feed_id;
        FeedHttpUtils.a(context, bluedUIHttpResponse, str, this.n + "", BaseWrapper.ENTER_ID_SYSTEM_HELPER, this.d);
    }

    private void i() {
        BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>() { // from class: com.blued.community.ui.video.presenter.FeedDetailOldPresenter.7
            private int b;

            /* renamed from: c  reason: collision with root package name */
            private String f20437c;
            private boolean d;

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
                boolean z = false;
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    FeedDetailOldPresenter.this.i.e = 0;
                } else {
                    BluedIngSelfFeed bluedIngSelfFeed = bluedEntityA.data.get(0);
                    if (bluedIngSelfFeed != null && !TextUtils.isEmpty(bluedIngSelfFeed.feed_id)) {
                        FeedDetailOldPresenter.this.f20429a = bluedIngSelfFeed;
                        FeedDetailOldPresenter.this.b.c(FeedDetailOldPresenter.this.f20429a);
                    }
                    if (FeedDetailOldPresenter.this.g == 1) {
                        if ((bluedIngSelfFeed.hot_comments == null || bluedIngSelfFeed.hot_comments.size() == 0) && (bluedIngSelfFeed.comments == null || bluedIngSelfFeed.comments.size() == 0)) {
                            FeedDetailOldPresenter.this.i.e = 0;
                        } else if (bluedIngSelfFeed.hot_comments == null || bluedIngSelfFeed.hot_comments.size() <= 0) {
                            FeedDetailOldPresenter.this.b.e(bluedIngSelfFeed.comments);
                        } else {
                            bluedIngSelfFeed.hot_comments.get(bluedIngSelfFeed.hot_comments.size() - 1).isLastHotComment = true;
                            if (bluedIngSelfFeed.hot_comments_more == 1) {
                                bluedIngSelfFeed.hot_comments.get(bluedIngSelfFeed.hot_comments.size() - 1).isHasMoreHotComment = true;
                            }
                            FeedDetailOldPresenter.this.b.e(bluedIngSelfFeed.hot_comments);
                            FeedDetailOldPresenter.this.b.f(bluedIngSelfFeed.comments);
                        }
                        FeedDetailOldPresenter.this.b();
                    } else if (bluedIngSelfFeed.comments == null || bluedIngSelfFeed.comments.size() <= 0) {
                        FeedDetailOldPresenter.this.i.e = 0;
                    } else {
                        FeedDetailOldPresenter.this.b.f(bluedIngSelfFeed.comments);
                    }
                    if (bluedEntityA.extra != 0) {
                        DataStatus dataStatus = FeedDetailOldPresenter.this.i;
                        if (bluedEntityA.extra.hasmore == 1) {
                            z = true;
                        }
                        dataStatus.b = z;
                    } else {
                        FeedDetailOldPresenter.this.i.b = false;
                    }
                }
                FeedDetailOldPresenter.this.b.b(1);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                this.b = i;
                this.f20437c = str;
                FeedDetailOldPresenter.this.i.e = 2;
                this.d = true;
                if (FeedDetailOldPresenter.this.m && i == 404100) {
                    return true;
                }
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                int i;
                FeedDetailOldPresenter.this.b.r();
                FeedDetailOldPresenter.this.b.u();
                if (FeedDetailOldPresenter.this.k) {
                    FeedDetailOldPresenter.this.k = false;
                    if (FeedDetailOldPresenter.this.l) {
                        FeedDetailOldPresenter.this.b.t();
                    }
                }
                if (FeedDetailOldPresenter.this.m && this.b == 404100) {
                    AppMethods.d(R.string.shine_video_has_delete);
                    FeedDetailOldPresenter.this.b.s();
                    return;
                }
                if (FeedDetailOldPresenter.this.g == 1 && ((i = this.b) == 404100 || i == 4031216)) {
                    FeedDetailOldPresenter.this.b.s();
                } else if (this.d) {
                    FeedDetailOldPresenter.this.b.q();
                    FeedDetailOldPresenter.this.i.b = false;
                    if (FeedDetailOldPresenter.this.g == 1) {
                        FeedDetailOldPresenter.this.b.b(1);
                    }
                }
                this.d = false;
            }
        };
        String str = this.f20429a.feed_id;
        FeedHttpUtils.a(bluedUIHttpResponse, str, this.g + "", this.m ? "100" : BaseWrapper.ENTER_ID_OAPS_PHONEMANAGER, "", this.f20429a.is_ads, this.d);
    }

    private void j() {
        final int i = this.h;
        Context context = this.f20430c;
        BluedUIHttpResponse<BluedEntity<FeedRepost, BluedEntityBaseExtra>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<FeedRepost, BluedEntityBaseExtra>>() { // from class: com.blued.community.ui.video.presenter.FeedDetailOldPresenter.8
            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i2, String str) {
                super.onFailure(th, i2, str);
                FeedDetailOldPresenter.this.i.f = 2;
                FeedDetailOldPresenter.this.i.f20441c = false;
                AppInfo.n().post(new Runnable() { // from class: com.blued.community.ui.video.presenter.FeedDetailOldPresenter.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (i != 1) {
                            FeedDetailOldPresenter.this.b.q();
                            return;
                        }
                        FeedDetailOldPresenter.this.b.g(new ArrayList());
                        FeedDetailOldPresenter.this.b.b(2);
                    }
                });
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                FeedDetailOldPresenter.this.b.r();
                FeedDetailOldPresenter.this.b.u();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<FeedRepost, BluedEntityBaseExtra> bluedEntity) {
                if (bluedEntity != null) {
                    boolean z = false;
                    if (bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                        if (i == 1) {
                            FeedDetailOldPresenter.this.i.f = 0;
                            FeedDetailOldPresenter.this.b.g(new ArrayList());
                        }
                    } else if (i == 1) {
                        FeedDetailOldPresenter.this.b.g(bluedEntity.data);
                    } else {
                        FeedDetailOldPresenter.this.b.h(bluedEntity.data);
                    }
                    if (bluedEntity.extra != null) {
                        DataStatus dataStatus = FeedDetailOldPresenter.this.i;
                        if (bluedEntity.extra.hasmore == 1) {
                            z = true;
                        }
                        dataStatus.f20441c = z;
                    }
                }
                FeedDetailOldPresenter.this.b.b(2);
            }
        };
        String str = this.f20429a.feed_id;
        FeedHttpUtils.a(context, bluedUIHttpResponse, str, this.h + "", BaseWrapper.ENTER_ID_SYSTEM_HELPER, this.f20429a.is_ads, this.d);
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed == null) {
            return;
        }
        String str = bluedIngSelfFeed.feed_id;
        if (this.f20429a.feed_id.equals(str) && str.equals(this.f20429a.feed_id)) {
            this.b.s();
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(FeedComment feedComment) {
        if (this.f20429a.feed_id.equals(feedComment.feed_id)) {
            this.f20429a.feed_comment++;
            this.i.e = 1;
            this.b.b(1);
            this.b.c(this.f20429a);
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(BusFeedInteractModel busFeedInteractModel) {
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(FeedRepost feedRepost) {
        if (this.f20429a.feed_id.equals(feedRepost.feed_id)) {
            this.f20429a.repost_count++;
            if (this.i.f != 1) {
                this.i.f20441c = false;
                this.i.f = 1;
            }
            this.b.b(2);
            this.b.c(this.f20429a);
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(String str, int i) {
        this.f20429a.allow_comments = i;
        this.b.c(this.f20429a);
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(String str, String str2) {
        if (this.f20429a.feed_id.equals(str)) {
            this.f20429a.feed_comment--;
            if (this.f20429a.feed_comment < 0) {
                this.f20429a.feed_comment = 0;
            }
            if (this.f20429a.feed_comment == 0) {
                this.i.e = 0;
            } else {
                this.i.e = 1;
            }
            this.b.b(1);
            this.b.c(this.f20429a);
        }
    }

    public void a(String str, String str2, final String str3, boolean z) {
        FeedComment feedComment = new FeedComment();
        if (!z) {
            feedComment.comment_id = str3;
            feedComment.is_ads = this.f20429a.is_ads;
            feedComment.aid = this.f20429a.aid;
        }
        FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<FeedComment>>(this.d) { // from class: com.blued.community.ui.video.presenter.FeedDetailOldPresenter.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<FeedComment> bluedEntityA) {
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                            return;
                        }
                        FeedComment feedComment2 = bluedEntityA.data.get(0);
                        CommentListDataObserver.a().a(feedComment2, str3);
                        LiveEventBus.get("feed_add_comment").post(feedComment2);
                        FeedDetailOldPresenter.this.f().e = 1;
                        FeedDetailOldPresenter.this.b.d(1);
                        FeedDetailOldPresenter.this.b.l();
                        AppMethods.a((CharSequence) FeedDetailOldPresenter.this.f20430c.getString(R.string.send_successful));
                    } catch (Exception e) {
                        AppMethods.a((CharSequence) FeedDetailOldPresenter.this.f20430c.getResources().getString(R.string.common_net_error));
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str4) {
                if (!FeedDetailOldPresenter.this.m) {
                    super.onFailure(th, i, str4);
                    return;
                }
                Pair<Integer, String> a2 = BluedHttpUtils.a(th, i, str4);
                if (a2 == null || a2.first.intValue() != 404100) {
                    super.onFailure(th, i, str4);
                } else {
                    AppMethods.d(R.string.shine_video_has_delete);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                FeedDetailOldPresenter.this.b.n();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                FeedDetailOldPresenter.this.b.m();
            }
        }, g(), feedComment, str, this.d);
    }

    public void a(boolean z) {
        this.l = z;
    }

    @Override // com.blued.android.framework.mvp_similarity.BasePresenter
    public void ar_() {
    }

    public void b() {
        this.n = 1;
        this.i.g = true;
        h();
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void b(BluedIngSelfFeed bluedIngSelfFeed) {
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void b(String str, int i) {
        this.f20429a.reading_scope = i;
        this.b.c(this.f20429a);
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void b(String str, String str2) {
    }

    public void c() {
        this.g = 1;
        i();
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void c(int i) {
        if (TextUtils.equals(this.f20429a.feed_uid, UserInfo.getInstance().getLoginUserInfo().uid)) {
            this.f20429a.theme_id = i;
        }
        this.b.c(this.f20429a);
    }

    public void c(BluedIngSelfFeed bluedIngSelfFeed) {
        this.m = true;
        this.f20429a = bluedIngSelfFeed;
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void c(String str) {
        if (this.f20429a.feed_id.equals(str) && !TextUtils.isEmpty(str) && str.equals(this.f20429a.feed_id)) {
            this.f20429a.repost_count--;
            BluedIngSelfFeed bluedIngSelfFeed = this.f20429a;
            bluedIngSelfFeed.repost_count = bluedIngSelfFeed.repost_count < 0 ? 0 : this.f20429a.repost_count;
            this.b.c(this.f20429a);
            e();
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void c(String str, int i) {
        if (this.f20429a.feed_id.equals(str)) {
            if (i == 1) {
                this.f20429a.feed_dig++;
            } else {
                this.f20429a.feed_dig--;
                if (this.f20429a.feed_dig < 0) {
                    this.f20429a.feed_dig = 0;
                }
            }
            this.f20429a.iliked = i;
            if (this.f20429a.feed_dig == 0) {
                this.i.d = 0;
            } else {
                this.i.d = 1;
            }
            this.b.b(0);
            this.b.c(this.f20429a);
            this.f20429a.isPlayLikeAnim = false;
        }
    }

    public void d() {
        if (this.i.b) {
            this.g++;
            i();
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void d(int i) {
        if (TextUtils.equals(this.f20429a.feed_uid, UserInfo.getInstance().getLoginUserInfo().uid)) {
            this.f20429a.theme_pendant = i;
        }
        this.b.c(this.f20429a);
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void d(String str, int i) {
    }

    public void e() {
        this.h = 1;
        j();
    }

    public DataStatus f() {
        return this.i;
    }

    public BluedIngSelfFeed g() {
        return this.f20429a;
    }
}
