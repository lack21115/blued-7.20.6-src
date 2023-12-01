package com.soft.blued.ui.live.presenter;

import android.content.Context;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.NetworkUtils;
import com.blued.android.module.live_china.model.BannerModel;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.android.module.live_china.model.LiveListCommonModel;
import com.blued.android.module.live_china.observer.LiveSwipeRefreshObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.ui.live.contract.LiveListContract;
import com.soft.blued.ui.live.model.LiveListRankFlagExtra;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/presenter/LiveListPresenter.class */
public class LiveListPresenter implements LiveListContract.IPresenter {

    /* renamed from: a  reason: collision with root package name */
    private static final String f31285a = LiveListPresenter.class.getSimpleName();
    private BluedLiveState b;

    /* renamed from: c  reason: collision with root package name */
    private Context f31286c;
    private LiveListCommonModel d;
    private LiveListContract.IView e;
    private int f;
    private String g;
    private int h;
    private List<BluedLiveListData> i;
    private List<BluedLiveListData> j;

    public LiveListPresenter(Context context, String str, int i) {
        if (context != null) {
            this.d = new LiveListCommonModel();
            this.f31286c = context;
            this.g = str;
            this.h = i;
            this.i = new ArrayList();
            this.j = new ArrayList();
        }
    }

    private void a(final String str, final int i) {
        if (NetworkUtils.b()) {
            LiveHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedLiveListData, LiveListRankFlagExtra>>() { // from class: com.soft.blued.ui.live.presenter.LiveListPresenter.1
                @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                public void onFailure(Throwable th, int i2, String str2) {
                    super.onFailure(th, i2, str2);
                    AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.live.presenter.LiveListPresenter.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LiveListPresenter.this.e != null) {
                                LiveListPresenter.this.e.a(null, false);
                            }
                        }
                    });
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    Logger.a(LiveListPresenter.f31285a, "onUIFinish");
                    LiveSwipeRefreshObserver.a().b();
                    if (LiveListPresenter.this.e != null) {
                        LiveListPresenter.this.e.c();
                        LiveListPresenter.this.e.b();
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity<BluedLiveListData, LiveListRankFlagExtra> bluedEntity) {
                    try {
                        if (bluedEntity.extra != null) {
                            LiveListPresenter.this.d.setCanReCommend(bluedEntity.extra.recommend == 1);
                        }
                        if (bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                            if (LiveListPresenter.this.d.getPage() != 1) {
                                LiveListPresenter.this.d.setPage(LiveListPresenter.this.d.getPage() - 1);
                            } else if (LiveListPresenter.this.e != null) {
                                LiveListPresenter.this.e.a(bluedEntity.data, false);
                            }
                            if (LiveListPresenter.this.d.isCanReCommend()) {
                                LiveListPresenter.this.d.setRecommendPage(LiveListPresenter.this.d.getRecommendPage() + 1);
                                LiveListPresenter.this.a(str, true);
                            } else if (LiveListPresenter.this.e != null) {
                                LiveListPresenter.this.e.a();
                            }
                        } else {
                            Log.i("xpm", "parseData.data: " + bluedEntity.data);
                            if (bluedEntity.hasMore()) {
                                LiveListPresenter.this.d.setHasData(true);
                                if (LiveListPresenter.this.e != null) {
                                    LiveListPresenter.this.e.e();
                                }
                            } else {
                                LiveListPresenter.this.d.setHasData(false);
                                if (!LiveListPresenter.this.d.isCanReCommend() && LiveListPresenter.this.e != null) {
                                    LiveListPresenter.this.e.a();
                                }
                            }
                            if (i == 1) {
                                for (BluedLiveListData bluedLiveListData : bluedEntity.data) {
                                    bluedLiveListData.liveType = 6;
                                }
                            }
                            LiveListPresenter.this.i.addAll(bluedEntity.data);
                            if (LiveListPresenter.this.e != null) {
                                LiveListPresenter.this.e.a(bluedEntity.data, LiveListPresenter.this.d.getPage() != 1);
                            }
                            if (!LiveListPresenter.this.d.getHasData()) {
                                LiveListPresenter.this.d.setRecommendPage(LiveListPresenter.this.d.getRecommendPage() + 1);
                                LiveListPresenter.this.a(str, false);
                            }
                        }
                        if (LiveListPresenter.this.e != null) {
                            LiveListPresenter.this.e.a(LiveListPresenter.this.f);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (LiveListPresenter.this.d.getPage() != 1) {
                            LiveListPresenter.this.d.setPage(LiveListPresenter.this.d.getPage() - 1);
                        }
                        AppMethods.a((CharSequence) LiveListPresenter.this.f31286c.getResources().getString(2131887272));
                    }
                }
            }, str, String.valueOf(this.d.getPage()), (IRequestHost) null);
            return;
        }
        LiveListContract.IView iView = this.e;
        if (iView != null) {
            iView.d();
            this.e.c();
            this.e.b();
        }
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IPresenter
    public BluedLiveState a() {
        return this.b;
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IPresenter
    public void a(LiveListContract.IView iView) {
        this.e = iView;
    }

    public void a(String str, boolean z) {
        if (this.d.isCanReCommend()) {
            LiveHttpUtils.b(new BluedUIHttpResponse<BluedEntity<BluedLiveListData, LiveListRankFlagExtra>>() { // from class: com.soft.blued.ui.live.presenter.LiveListPresenter.3
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    Logger.a(LiveListPresenter.f31285a, "onUIFinish");
                    LiveSwipeRefreshObserver.a().b();
                    if (LiveListPresenter.this.e != null) {
                        LiveListPresenter.this.e.c();
                        LiveListPresenter.this.e.b();
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity<BluedLiveListData, LiveListRankFlagExtra> bluedEntity) {
                    try {
                        if (bluedEntity.data != null && bluedEntity.data.size() > 0) {
                            for (BluedLiveListData bluedLiveListData : bluedEntity.data) {
                                bluedLiveListData.liveType = 10;
                            }
                            LiveListPresenter.this.j.addAll(bluedEntity.data);
                            if (LiveListPresenter.this.e != null) {
                                LiveListPresenter.this.e.a(bluedEntity.data, true);
                            }
                        }
                        if (bluedEntity.hasMore() || LiveListPresenter.this.e == null) {
                            return;
                        }
                        LiveListPresenter.this.e.a();
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (LiveListPresenter.this.d.getRecommendPage() != 0) {
                            LiveListPresenter.this.d.setRecommendPage(LiveListPresenter.this.d.getRecommendPage() - 1);
                        }
                        AppMethods.a((CharSequence) LiveListPresenter.this.f31286c.getResources().getString(2131887272));
                    }
                }
            }, str, String.valueOf(this.d.getRecommendPage()), null);
        }
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IPresenter
    public void a(boolean z) {
        if (z) {
            this.d.setPage(1);
            this.d.setRecommendPage(0);
            this.d.setCanReCommend(false);
            this.d.setHasData(true);
            g();
            a(this.g, this.h);
        } else if (!this.d.getHasData()) {
            LiveListCommonModel liveListCommonModel = this.d;
            liveListCommonModel.setRecommendPage(liveListCommonModel.getRecommendPage() + 1);
            a(this.g, false);
        } else {
            LiveListCommonModel liveListCommonModel2 = this.d;
            liveListCommonModel2.setPage(liveListCommonModel2.getPage() + 1);
            if (this.d.getHasData() || this.d.getPage() == 1 || this.d.isCanReCommend()) {
                a(this.g, this.h);
                return;
            }
            LiveListCommonModel liveListCommonModel3 = this.d;
            liveListCommonModel3.setPage(liveListCommonModel3.getPage() - 1);
            AppMethods.a((CharSequence) this.f31286c.getResources().getString(2131887275));
            LiveListContract.IView iView = this.e;
            if (iView != null) {
                iView.c();
            }
        }
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IPresenter
    public void b() {
        LiveListContract.IView iView;
        LiveListContract.IView iView2;
        List<BluedLiveListData> list = this.i;
        if (list != null && (iView2 = this.e) != null) {
            iView2.a(list, false);
        }
        List<BluedLiveListData> list2 = this.j;
        if (list2 == null || list2.size() <= 0 || (iView = this.e) == null) {
            return;
        }
        iView.a(this.j, true);
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IPresenter
    public void c() {
        List<BluedLiveListData> list = this.i;
        if (list != null) {
            list.clear();
        }
        List<BluedLiveListData> list2 = this.j;
        if (list2 != null) {
            list2.clear();
        }
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IPresenter
    public int d() {
        List<BluedLiveListData> list = this.i;
        int i = 0;
        if (list != null) {
            i = 0 + list.size();
        }
        List<BluedLiveListData> list2 = this.j;
        int i2 = i;
        if (list2 != null) {
            i2 = i + list2.size();
        }
        return i2;
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IPresenter
    public void e() {
        this.e = null;
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IPresenter
    public void f() {
        h();
    }

    public void g() {
        LiveRoomHttpUtils.e(new BluedUIHttpResponse<BluedEntityA<BluedLiveState>>() { // from class: com.soft.blued.ui.live.presenter.LiveListPresenter.2
            /* JADX WARN: Removed duplicated region for block: B:16:0x0069 A[Catch: Exception -> 0x0073, TryCatch #0 {Exception -> 0x0073, blocks: (B:2:0x0000, B:4:0x0007, B:6:0x0013, B:8:0x0036, B:11:0x0047, B:14:0x005d, B:16:0x0069, B:12:0x0053), top: B:21:0x0000 }] */
            /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA<com.blued.android.module.live_china.model.BluedLiveState> r5) {
                /*
                    r4 = this;
                    r0 = r5
                    java.util.List<T> r0 = r0.data     // Catch: java.lang.Exception -> L73
                    if (r0 == 0) goto L78
                    r0 = r5
                    java.util.List<T> r0 = r0.data     // Catch: java.lang.Exception -> L73
                    int r0 = r0.size()     // Catch: java.lang.Exception -> L73
                    if (r0 <= 0) goto L78
                    r0 = r4
                    com.soft.blued.ui.live.presenter.LiveListPresenter r0 = com.soft.blued.ui.live.presenter.LiveListPresenter.this     // Catch: java.lang.Exception -> L73
                    r1 = r5
                    java.util.List<T> r1 = r1.data     // Catch: java.lang.Exception -> L73
                    r2 = 0
                    java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Exception -> L73
                    com.blued.android.module.live_china.model.BluedLiveState r1 = (com.blued.android.module.live_china.model.BluedLiveState) r1     // Catch: java.lang.Exception -> L73
                    com.blued.android.module.live_china.model.BluedLiveState r0 = com.soft.blued.ui.live.presenter.LiveListPresenter.a(r0, r1)     // Catch: java.lang.Exception -> L73
                    r0 = 1
                    r1 = r4
                    com.soft.blued.ui.live.presenter.LiveListPresenter r1 = com.soft.blued.ui.live.presenter.LiveListPresenter.this     // Catch: java.lang.Exception -> L73
                    com.blued.android.module.live_china.model.BluedLiveState r1 = com.soft.blued.ui.live.presenter.LiveListPresenter.f(r1)     // Catch: java.lang.Exception -> L73
                    int r1 = r1.is_permission     // Catch: java.lang.Exception -> L73
                    if (r0 == r1) goto L53
                    r0 = 2
                    r1 = r4
                    com.soft.blued.ui.live.presenter.LiveListPresenter r1 = com.soft.blued.ui.live.presenter.LiveListPresenter.this     // Catch: java.lang.Exception -> L73
                    com.blued.android.module.live_china.model.BluedLiveState r1 = com.soft.blued.ui.live.presenter.LiveListPresenter.f(r1)     // Catch: java.lang.Exception -> L73
                    int r1 = r1.is_permission     // Catch: java.lang.Exception -> L73
                    if (r0 != r1) goto L47
                    goto L53
                L47:
                    r0 = r4
                    com.soft.blued.ui.live.presenter.LiveListPresenter r0 = com.soft.blued.ui.live.presenter.LiveListPresenter.this     // Catch: java.lang.Exception -> L73
                    r1 = 0
                    int r0 = com.soft.blued.ui.live.presenter.LiveListPresenter.a(r0, r1)     // Catch: java.lang.Exception -> L73
                    goto L5c
                L53:
                    r0 = r4
                    com.soft.blued.ui.live.presenter.LiveListPresenter r0 = com.soft.blued.ui.live.presenter.LiveListPresenter.this     // Catch: java.lang.Exception -> L73
                    r1 = 1
                    int r0 = com.soft.blued.ui.live.presenter.LiveListPresenter.a(r0, r1)     // Catch: java.lang.Exception -> L73
                L5c:
                    r0 = r4
                    com.soft.blued.ui.live.presenter.LiveListPresenter r0 = com.soft.blued.ui.live.presenter.LiveListPresenter.this     // Catch: java.lang.Exception -> L73
                    com.blued.android.module.live_china.model.BluedLiveState r0 = com.soft.blued.ui.live.presenter.LiveListPresenter.f(r0)     // Catch: java.lang.Exception -> L73
                    int r0 = r0.allow_applied     // Catch: java.lang.Exception -> L73
                    if (r0 != 0) goto L78
                    r0 = r4
                    com.soft.blued.ui.live.presenter.LiveListPresenter r0 = com.soft.blued.ui.live.presenter.LiveListPresenter.this     // Catch: java.lang.Exception -> L73
                    r1 = 0
                    int r0 = com.soft.blued.ui.live.presenter.LiveListPresenter.a(r0, r1)     // Catch: java.lang.Exception -> L73
                    return
                L73:
                    r5 = move-exception
                    r0 = r5
                    r0.printStackTrace()
                L78:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.live.presenter.LiveListPresenter.AnonymousClass2.onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA):void");
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), (IRequestHost) null);
    }

    public void h() {
        LiveHttpUtils.e(new BluedUIHttpResponse<BluedEntityA<BannerModel>>() { // from class: com.soft.blued.ui.live.presenter.LiveListPresenter.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BannerModel> bluedEntityA) {
                if (LiveListPresenter.this.e == null || bluedEntityA == null) {
                    return;
                }
                LiveListPresenter.this.e.a(bluedEntityA.data);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (LiveListPresenter.this.e != null) {
                    LiveListPresenter.this.e.a((List<BannerModel>) null);
                }
                return super.onUIFailure(i, str);
            }
        }, null);
    }
}
