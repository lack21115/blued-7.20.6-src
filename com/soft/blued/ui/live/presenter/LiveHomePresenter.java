package com.soft.blued.ui.live.presenter;

import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.AnchorLiveStateModel;
import com.blued.android.module.live_china.model.BannerModel;
import com.blued.android.module.live_china.model.LiveLiangModel;
import com.blued.android.module.live_china.model.LiveTabInfo;
import com.blued.android.module.live_china.model.LiveTabModel;
import com.blued.android.module.live_china.model.LiveTwoFloorModel;
import com.blued.android.module.live_china.model.MultiDialogModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.ui.live.model.LiveFollowCurrent;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/presenter/LiveHomePresenter.class */
public class LiveHomePresenter extends MvpPresenter {
    private static final String h = LiveHomePresenter.class.getSimpleName();
    private int i = 0;

    /* renamed from: com.soft.blued.ui.live.presenter.LiveHomePresenter$4  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/presenter/LiveHomePresenter$4.class */
    class AnonymousClass4 extends BluedUIHttpResponse<BluedEntityA<LiveFollowCurrent>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LiveHomePresenter f17576a;

        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<LiveFollowCurrent> bluedEntityA) {
            if (bluedEntityA == null || !bluedEntityA.hasData()) {
                return;
            }
            try {
                this.f17576a.a("LIVE_COUNT", Integer.valueOf(((LiveFollowCurrent) bluedEntityA.data.get(0)).current));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(IFetchDataListener iFetchDataListener) {
        if (this.i == 0) {
            m();
        }
        c(iFetchDataListener);
        n();
    }

    public void a(final boolean z) {
        LiveRoomHttpUtils.a(0, new BluedUIHttpResponse<BluedEntityA<MultiDialogModel>>(g()) { // from class: com.soft.blued.ui.live.presenter.LiveHomePresenter.7
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MultiDialogModel> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                ((MultiDialogModel) bluedEntityA.getSingleData()).from_type = r6;
                LiveRoomManager.a().a((MultiDialogModel) bluedEntityA.getSingleData());
                LiveHomePresenter.this.a("LIVE_MULTI_INFO", (MultiDialogModel) bluedEntityA.getSingleData(), false);
            }

            public boolean onUIFailure(int i, String str) {
                return true;
            }

            public void onUIFinish() {
                if (z) {
                    LiveHomePresenter.this.o();
                }
                super.onUIFinish();
            }
        });
    }

    public void b(IFetchDataListener iFetchDataListener) {
    }

    public void c(final IFetchDataListener iFetchDataListener) {
        LiveRoomHttpUtils.g(new BluedUIHttpResponse<BluedEntityA<BannerModel>>() { // from class: com.soft.blued.ui.live.presenter.LiveHomePresenter.2
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BannerModel> bluedEntityA) {
                if (bluedEntityA != null) {
                    try {
                        iFetchDataListener.a("BANNER_INFO", bluedEntityA.data);
                    } catch (Exception e) {
                        e.printStackTrace();
                        AppMethods.a(LiveHomePresenter.this.h().getResources().getString(2131887272));
                    }
                }
            }

            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
                AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.live.presenter.LiveHomePresenter.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        iFetchDataListener.a("BANNER_INFO", (List) null);
                    }
                });
            }
        }, "hot", (IRequestHost) null);
    }

    public boolean c() {
        return false;
    }

    public void d(String str) {
        LiveHttpUtils.a(h(), new BluedUIHttpResponse<BluedEntityA<AnchorLiveStateModel>>() { // from class: com.soft.blued.ui.live.presenter.LiveHomePresenter.3
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<AnchorLiveStateModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                try {
                    LiveHomePresenter.this.a("GET_LIVE_STATE", (AnchorLiveStateModel) bluedEntityA.getSingleData());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, str, (IRequestHost) null);
    }

    public void m() {
        LiveRoomHttpUtils.s(new BluedUIHttpResponse<BluedEntity<LiveTabModel, LiveTabModel>>(g()) { // from class: com.soft.blued.ui.live.presenter.LiveHomePresenter.1
            public void onUICache(BluedEntity<LiveTabModel, LiveTabModel> bluedEntity) {
                if (bluedEntity.extra != null) {
                    bluedEntity.extra.default_cate_id = "0";
                }
                if (bluedEntity == null || bluedEntity.data == null) {
                    return;
                }
                LiveTabInfo liveTabInfo = new LiveTabInfo();
                liveTabInfo.liveTabs.addAll(bluedEntity.data);
                liveTabInfo.liveTabModelExtra = bluedEntity.extra;
                LiveHomePresenter.this.i = bluedEntity.data.size();
                LiveHomePresenter.this.a("LIST_TAB", liveTabInfo);
            }

            public boolean onUIFailure(int i, String str) {
                return true;
            }

            public void onUIFinish() {
                super.onUIFinish();
            }

            public void onUIStart() {
                super.onUIStart();
            }

            public void onUIUpdate(BluedEntity<LiveTabModel, LiveTabModel> bluedEntity) {
                if (bluedEntity == null || bluedEntity.data == null) {
                    return;
                }
                LiveTabInfo liveTabInfo = new LiveTabInfo();
                liveTabInfo.liveTabs.addAll(bluedEntity.data);
                liveTabInfo.liveTabModelExtra = bluedEntity.extra;
                LiveHomePresenter.this.i = bluedEntity.data.size();
                LiveHomePresenter.this.a("LIST_TAB", liveTabInfo);
            }
        }, g());
    }

    public void n() {
        LiveRoomHttpUtils.t(new BluedUIHttpResponse<BluedEntityA<LiveTwoFloorModel>>(g()) { // from class: com.soft.blued.ui.live.presenter.LiveHomePresenter.5
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveTwoFloorModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null) {
                    LiveHomePresenter.this.f_("TWO_LEVEL");
                } else {
                    LiveHomePresenter.this.a("TWO_LEVEL", bluedEntityA.data);
                }
            }

            public boolean onUIFailure(int i, String str) {
                return true;
            }

            public void onUIFinish() {
                super.onUIFinish();
            }

            public void onUIStart() {
                super.onUIStart();
            }
        }, g());
    }

    public void o() {
        LiveRoomHttpUtils.y(new BluedUIHttpResponse<BluedEntityA<LiveLiangModel>>(g()) { // from class: com.soft.blued.ui.live.presenter.LiveHomePresenter.6
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveLiangModel> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                LiveRoomManager.a().a((LiveLiangModel) bluedEntityA.data.get(0));
                LiveHomePresenter.this.a("LIVE_LIANG_ID", bluedEntityA.data);
            }

            public boolean onUIFailure(int i, String str) {
                LiveHomePresenter.this.a("LIVE_LIANG_ID", (Object) null);
                return true;
            }

            public void onUIFinish() {
                super.onUIFinish();
            }

            public void onUIStart() {
                super.onUIStart();
            }
        });
    }
}
