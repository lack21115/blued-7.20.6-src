package com.soft.blued.ui.live.presenter;

import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/presenter/LiveApplySimplePresenter.class */
public class LiveApplySimplePresenter extends MvpPresenter {
    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    public void a(String str, String str2) {
        LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<BluedLiveListData>>(g()) { // from class: com.soft.blued.ui.live.presenter.LiveApplySimplePresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLiveListData> bluedEntityA) {
                LiveApplySimplePresenter.this.f_("LIVE_SIMPLE__APPLY");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str3) {
                AppMethods.a((CharSequence) str3);
                return false;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveApplySimplePresenter.this.b("LIVE_SIMPLE__APPLY", true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveApplySimplePresenter.this.d_("LIVE_SIMPLE__APPLY");
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), g(), 1, str, str2, 1);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    public void m() {
        LiveRoomHttpUtils.e(new BluedUIHttpResponse<BluedEntityA<BluedLiveState>>(g()) { // from class: com.soft.blued.ui.live.presenter.LiveApplySimplePresenter.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLiveState> bluedEntityA) {
                if (bluedEntityA != null) {
                    LiveApplySimplePresenter.this.a("LIVE_APPLY", (String) bluedEntityA.data);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                AppMethods.a((CharSequence) str);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveApplySimplePresenter.this.b("LIVE_APPLY", true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveApplySimplePresenter.this.d_("LIVE_APPLY");
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), g());
    }
}
