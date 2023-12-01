package com.soft.blued.ui.live.presenter;

import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.model.CountModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.community.http.FeedHttpUtils;
import com.soft.blued.R;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.ui.home.model.LiveBubble;
import com.soft.blued.utils.Logger;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/presenter/LivePresenter.class */
public class LivePresenter extends MvpPresenter {
    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        a(false);
        m();
    }

    public void a(String str, String str2) {
        FeedHttpUtils.a(h(), new BluedUIHttpResponse(g()) { // from class: com.soft.blued.ui.live.presenter.LivePresenter.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                AppMethods.d((int) R.string.report_success);
            }
        }, str, str2, g());
    }

    public void a(boolean z) {
        BluedUIHttpResponse<BluedEntityA<BluedLiveState>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<BluedLiveState>>(g()) { // from class: com.soft.blued.ui.live.presenter.LivePresenter.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<BluedLiveState> parseData(String str) {
                Logger.a("livestate", str);
                return (BluedEntityA) super.parseData(str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLiveState> bluedEntityA) {
                boolean booleanValue = (getData() == null || !(getData() instanceof Boolean)) ? false : ((Boolean) getData()).booleanValue();
                if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                    bluedEntityA.getSingleData().isLiveClickEvent = booleanValue;
                    LivePresenter.this.a("LIVE_STATE", (String) bluedEntityA.getSingleData());
                }
                LivePresenter.this.b("LIVE_STATE", true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
                LivePresenter.this.b("LIVE_STATE", false);
            }
        };
        bluedUIHttpResponse.setData(Boolean.valueOf(z));
        LiveRoomHttpUtils.e(bluedUIHttpResponse, UserInfo.getInstance().getLoginUserInfo().getUid(), g());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    public void m() {
        LiveHttpUtils.c(new BluedUIHttpResponse<BluedEntity<CountModel, CountModel>>(g()) { // from class: com.soft.blued.ui.live.presenter.LivePresenter.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<CountModel, CountModel> bluedEntity) {
                if (bluedEntity.extra != null) {
                    LivePresenter.this.a("REQUEST_LIVE_COUNT", (String) bluedEntity.extra);
                }
            }
        }, g());
    }

    public void n() {
        LiveHttpUtils.f(new BluedUIHttpResponse<BluedEntity<LiveBubble, BluedEntityBaseExtra>>(g()) { // from class: com.soft.blued.ui.live.presenter.LivePresenter.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveBubble, BluedEntityBaseExtra> bluedEntity) {
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    return;
                }
                LivePresenter.this.a("LIVE_TAB_SETTINGS", (String) bluedEntity.getSingleData());
            }
        }, g());
    }

    public void o() {
        a("LIVE_TAB_SETTINGS", (String) null);
    }

    public void p() {
        LiveHttpUtils.g(new BluedUIHttpResponse<BluedEntity<Object, BluedEntityBaseExtra>>(g()) { // from class: com.soft.blued.ui.live.presenter.LivePresenter.5
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<Object, BluedEntityBaseExtra> bluedEntity) {
            }
        }, g());
    }
}
