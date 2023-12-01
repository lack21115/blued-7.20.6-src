package com.blued.android.module.live_china.presenter;

import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.model.LiveFansGoodsModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveFansTaskPresent.class */
public class LiveFansTaskPresent extends MvpPresenter {
    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    public void d(String str) {
        LiveRoomHttpUtils.f(str, new BluedUIHttpResponse<BluedEntityA<LiveFansGoodsModel>>(g()) { // from class: com.blued.android.module.live_china.presenter.LiveFansTaskPresent.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveFansGoodsModel> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                LiveFansTaskPresent.this.a("LIVE_FANS_GOODS", (String) bluedEntityA.data.get(0));
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                AppMethods.a((CharSequence) str2);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }
        }, g());
    }
}
