package com.soft.blued.ui.live.presenter;

import android.content.Context;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveListCommonModel;
import com.blued.android.module.live_china.model.LiveRecommendModel;
import com.blued.community.model.LiveRecommendExtra;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.ui.live.contract.LiveListFollowContract;
import com.soft.blued.ui.live.model.LiveListRecommendModel;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/presenter/LiveListFollowPresenter.class */
public class LiveListFollowPresenter implements LiveListFollowContract.IPresenter {

    /* renamed from: a  reason: collision with root package name */
    private final String f31274a;
    private BaseFragment b;

    /* renamed from: c  reason: collision with root package name */
    private Context f31275c;
    private LiveListFollowContract.IView d;
    private LiveListCommonModel e;
    private LiveListRecommendModel f;
    private List<LiveRecommendModel> g;
    private boolean h;

    /* renamed from: com.soft.blued.ui.live.presenter.LiveListFollowPresenter$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/presenter/LiveListFollowPresenter$1.class */
    class AnonymousClass1 implements UserRelationshipUtils.IAddOrRemoveAttentionDone {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BluedLiveListData f31276a;
        final /* synthetic */ LiveListFollowPresenter b;

        @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
        public void a() {
        }

        @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
        public void a(String str) {
        }

        @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
        public void b() {
        }

        @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
        public void b(String str) {
            this.b.d.a(this.f31276a);
        }

        @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
        public void c() {
        }
    }

    /* renamed from: com.soft.blued.ui.live.presenter.LiveListFollowPresenter$3  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/presenter/LiveListFollowPresenter$3.class */
    class AnonymousClass3 extends BluedUIHttpResponse<BluedEntity<LiveRecommendModel, LiveRecommendExtra>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f31279a;
        final /* synthetic */ LiveListFollowPresenter b;

        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFailure(Throwable th, int i, String str) {
            AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.live.presenter.LiveListFollowPresenter.3.1
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass3.this.b.b();
                }
            });
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            this.b.d.d();
            this.b.d.k();
            this.b.d.j();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<LiveRecommendModel, LiveRecommendExtra> bluedEntity) {
            if (bluedEntity.extra == null) {
                this.b.b();
                return;
            }
            LiveRecommendExtra liveRecommendExtra = bluedEntity.extra;
            if (liveRecommendExtra.is_new == 1) {
                this.b.d.a(true);
                this.b.d.b(bluedEntity.data);
            } else {
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    this.b.f.hasData = false;
                    this.b.d.b(false);
                } else {
                    this.b.f.hasData = true;
                    this.b.d.b(true);
                }
                if (this.f31279a) {
                    this.b.d.c(bluedEntity.data);
                } else {
                    this.b.g = bluedEntity.data;
                    this.b.b();
                }
            }
            this.b.f.lastUid = liveRecommendExtra.last_id;
        }
    }

    @Override // com.blued.android.framework.mvp_similarity.BasePresenter
    public void ar_() {
    }

    public void b() {
        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.live.presenter.LiveListFollowPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                LiveListFollowPresenter.this.d.f();
                LiveHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<BluedLiveListData>>(LiveListFollowPresenter.this.b.getFragmentActive()) { // from class: com.soft.blued.ui.live.presenter.LiveListFollowPresenter.2.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public BluedEntityA<BluedLiveListData> parseData(String str) {
                        Logger.a(LiveListFollowPresenter.this.f31274a, "getLiveListFollow, content:", str);
                        return (BluedEntityA) super.parseData(str);
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<BluedLiveListData> bluedEntityA) {
                        if (bluedEntityA != null) {
                            try {
                                if (bluedEntityA.hasData()) {
                                    if (bluedEntityA.hasMore()) {
                                        LiveListFollowPresenter.this.e.setHasData(true);
                                        LiveListFollowPresenter.this.d.i();
                                    } else {
                                        LiveListFollowPresenter.this.e.setHasData(false);
                                        LiveListFollowPresenter.this.d.b();
                                    }
                                    if (!LiveListFollowPresenter.this.h && LiveListFollowPresenter.this.g != null && LiveListFollowPresenter.this.g.size() > 0) {
                                        int i = 0;
                                        while (true) {
                                            int i2 = i;
                                            if (i2 >= bluedEntityA.data.size()) {
                                                break;
                                            }
                                            BluedLiveListData bluedLiveListData = bluedEntityA.data.get(i2);
                                            if (bluedLiveListData.livetype == 0) {
                                                Logger.a("ddrb", "推荐数为：", Integer.valueOf(LiveListFollowPresenter.this.g.size()));
                                                Logger.a("ddrb", "position = " + i2);
                                                BluedLiveListData bluedLiveListData2 = new BluedLiveListData();
                                                bluedLiveListData2.liveRecommendModelList = LiveListFollowPresenter.this.g;
                                                bluedLiveListData2.recommend_type = 1;
                                                bluedLiveListData2.lid = "0";
                                                bluedLiveListData2.anchor = new UserBasicModel();
                                                if (bluedLiveListData.anchor != null) {
                                                    bluedLiveListData2.anchor.uid = bluedLiveListData.anchor.uid;
                                                    bluedLiveListData2.anchor.name = bluedLiveListData.anchor.name;
                                                    bluedLiveListData2.anchor.avatar = bluedLiveListData.anchor.avatar;
                                                    bluedLiveListData2.anchor.vbadge = bluedLiveListData.anchor.vbadge;
                                                }
                                                bluedEntityA.data.add(i2, bluedLiveListData2);
                                                LiveListFollowPresenter.this.h = true;
                                            } else {
                                                i = i2 + 1;
                                            }
                                        }
                                    }
                                    LiveListFollowPresenter.this.d.a(bluedEntityA.data);
                                    LiveListFollowPresenter.this.d.g();
                                    LiveListFollowPresenter.this.d.a();
                                    LiveListFollowPresenter.this.e.setHasFollowData(true);
                                    LiveListFollowPresenter.this.d.h();
                                    return;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                if (LiveListFollowPresenter.this.e.getPage() != 1) {
                                    LiveListFollowPresenter.this.e.setPage(LiveListFollowPresenter.this.e.getPage() - 1);
                                }
                                AppMethods.a((CharSequence) LiveListFollowPresenter.this.f31275c.getResources().getString(2131887272));
                                return;
                            }
                        }
                        LiveListFollowPresenter.this.d.a(bluedEntityA.data);
                        LiveListFollowPresenter.this.d.b();
                        LiveListFollowPresenter.this.d.h();
                        if (LiveListFollowPresenter.this.e.getPage() != 1) {
                            LiveListFollowPresenter.this.e.setPage(LiveListFollowPresenter.this.e.getPage() - 1);
                            return;
                        }
                        LiveListFollowPresenter.this.e.setHasFollowData(false);
                        LiveListFollowPresenter.this.e.setTipShow(false);
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                    public void onFailure(Throwable th, int i, String str) {
                        super.onFailure(th, i, str);
                        if (LiveListFollowPresenter.this.e.getPage() != 1) {
                            LiveListFollowPresenter.this.e.setPage(LiveListFollowPresenter.this.e.getPage() - 1);
                        }
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public void onUIFinish() {
                        Logger.a(LiveListFollowPresenter.this.f31274a, "onFinish");
                        LiveListFollowPresenter.this.d.e();
                        LiveListFollowPresenter.this.d.c();
                        LiveListFollowPresenter.this.d.j();
                        LiveListFollowPresenter.this.d.a(false);
                    }
                }, String.valueOf(LiveListFollowPresenter.this.e.getPage()), LiveListFollowPresenter.this.b.getFragmentActive());
            }
        });
    }
}
