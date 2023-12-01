package com.soft.blued.ui.live.presenter;

import android.util.Log;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.model.LiveFansQuitModel;
import com.blued.android.module.live_china.model.LiveFansRecommendModel;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.ui.live.model.LiveJoinFansModel;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/presenter/LiveJoinFansPresenter.class */
public class LiveJoinFansPresenter extends MvpPresenter {
    public boolean h = false;
    public boolean i = false;
    public boolean j = false;
    public int k = 1;
    public int l = 1;

    public void a(IFetchDataListener iFetchDataListener) {
        this.k = 1;
        c(iFetchDataListener);
    }

    public void a(boolean z) {
        if (z) {
            this.l = 1;
        } else {
            this.l++;
        }
        Log.i("LiveJoinFansPresenter", "getJoinRecommend pageRecommend:" + this.l);
        LiveHttpUtils.b(this.l, new BluedUIHttpResponse<BluedEntityA<LiveFansRecommendModel>>(g()) { // from class: com.soft.blued.ui.live.presenter.LiveJoinFansPresenter.2
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveFansRecommendModel> bluedEntityA) {
                LiveJoinFansPresenter.this.j = bluedEntityA.hasMore();
                LiveJoinFansPresenter.this.a("LIVE_JOIN_RECOMMEND", bluedEntityA.data);
            }

            public boolean onUIFailure(int i, String str) {
                if (LiveJoinFansPresenter.this.l > 1) {
                    LiveJoinFansPresenter.this.l--;
                }
                LiveJoinFansPresenter.this.a("LIVE_JOIN_RECOMMEND", null);
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

    public void b(IFetchDataListener iFetchDataListener) {
        this.k++;
        c(iFetchDataListener);
    }

    public void c(final IFetchDataListener iFetchDataListener) {
        Log.i("LiveJoinFansPresenter", "getJoinFans pageFans:" + this.k);
        LiveHttpUtils.a(this.k, new BluedUIHttpResponse<BluedEntityA<LiveJoinFansModel>>(g()) { // from class: com.soft.blued.ui.live.presenter.LiveJoinFansPresenter.1
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveJoinFansModel> bluedEntityA) {
                if (bluedEntityA.data != null) {
                    iFetchDataListener.a("LIVE_JOIN_FANS", bluedEntityA.data);
                }
                LiveJoinFansPresenter.this.i = bluedEntityA.hasMore();
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.b(LiveJoinFansPresenter.this.i);
                }
                LiveJoinFansPresenter.this.b("LIVE_JOIN_FANS", true);
            }

            public boolean onUIFailure(int i, String str) {
                if (LiveJoinFansPresenter.this.k > 1) {
                    LiveJoinFansPresenter.this.k--;
                }
                iFetchDataListener.a("LIVE_JOIN_FANS", new ArrayList());
                LiveJoinFansPresenter.this.b("LIVE_JOIN_FANS", false);
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

    public boolean c() {
        return false;
    }

    public void d(final String str) {
        LiveHttpUtils.a(str, new BluedUIHttpResponse<BluedEntityA<LiveFansQuitModel>>(g()) { // from class: com.soft.blued.ui.live.presenter.LiveJoinFansPresenter.3
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveFansQuitModel> bluedEntityA) {
                LiveFansQuitModel liveFansQuitModel = new LiveFansQuitModel();
                liveFansQuitModel.localUid = str;
                LiveJoinFansPresenter.this.a("LIVE_JOIN_FANS_QUIT", liveFansQuitModel);
            }

            public boolean onUIFailure(int i, String str2) {
                AppMethods.a(str2);
                return true;
            }

            public void onUIFinish() {
                LiveJoinFansPresenter.this.b("LIVE_JOIN_FANS_QUIT", true);
                super.onUIFinish();
            }

            public void onUIStart() {
                super.onUIStart();
            }
        }, g());
    }
}
