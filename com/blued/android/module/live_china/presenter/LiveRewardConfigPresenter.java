package com.blued.android.module.live_china.presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live_china.live_interface.IRewardConfigView;
import com.blued.android.module.live_china.model.LiveRewardConfigModel;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveRewardConfigPresenter.class */
public class LiveRewardConfigPresenter {

    /* renamed from: a  reason: collision with root package name */
    private IRewardConfigView f14046a;
    private IRequestHost b;

    public LiveRewardConfigPresenter(IRewardConfigView iRewardConfigView, IRequestHost iRequestHost) {
        this.f14046a = iRewardConfigView;
        this.b = iRequestHost;
    }

    public void a() {
        Logger.a("drb", "getRewardConfig");
        LiveRoomHttpUtils.l(new BluedUIHttpResponse<BluedEntityA<LiveRewardConfigModel>>(this.b) { // from class: com.blued.android.module.live_china.presenter.LiveRewardConfigPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveRewardConfigModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                LiveRewardConfigPresenter.this.f14046a.a(bluedEntityA.data.get(0));
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveRewardConfigPresenter.this.f14046a.a();
            }
        });
    }
}
