package com.blued.android.module.yy_china.presenter;

import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYLiveState;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYApplyPresenter.class */
public class YYApplyPresenter extends MvpPresenter {
    private void m() {
        YYRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<YYLiveState>>(g()) { // from class: com.blued.android.module.yy_china.presenter.YYApplyPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYLiveState> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                YYApplyPresenter.this.a("yy_apply_state", (String) bluedEntityA.data.get(0));
            }
        }, YYRoomInfoManager.e().c().c(), g());
    }

    public int a(int i) {
        return h().getResources().getColor(i);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        m();
    }

    public void a(String str, String str2, String str3) {
        YYRoomHttpUtils.a(str, str2, str3, new BluedUIHttpResponse<BluedEntityA<Object>>(g()) { // from class: com.blued.android.module.yy_china.presenter.YYApplyPresenter.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                YYApplyPresenter.this.a("yy_apply_submit", false);
            }
        }, g());
    }

    public String b(int i) {
        return h().getResources().getString(i);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }
}
