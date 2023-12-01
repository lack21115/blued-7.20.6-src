package com.blued.android.module.live_china.presenter;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live_china.live_interface.IGrabRewardView;
import com.blued.android.module.live_china.model.LiveRewardExtraModel;
import com.blued.android.module.live_china.model.LiveRewardListModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveGrabRewardPresenter.class */
public class LiveGrabRewardPresenter {
    private IGrabRewardView a;
    private IRequestHost b;

    public LiveGrabRewardPresenter(IGrabRewardView iGrabRewardView, IRequestHost iRequestHost) {
        this.a = iGrabRewardView;
        this.b = iRequestHost;
    }

    public void a(String str, long j, String str2, final String str3) {
        LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<LiveRewardListModel, LiveRewardExtraModel>>(this.b) { // from class: com.blued.android.module.live_china.presenter.LiveGrabRewardPresenter.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(final Throwable th, final int i, final String str4) {
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.presenter.LiveGrabRewardPresenter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveGrabRewardPresenter.this.a.a(th, i, str4);
                    }
                });
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveGrabRewardPresenter.this.a.f();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveRewardListModel, LiveRewardExtraModel> bluedEntity) {
                try {
                    if (bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                        return;
                    }
                    LiveGrabRewardPresenter.this.a.a(bluedEntity.data.get(0));
                    if (TextUtils.isEmpty(str3)) {
                        return;
                    }
                    LiveSetDataObserver.a().c(str3);
                } catch (Exception e) {
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public BluedEntity<LiveRewardListModel, LiveRewardExtraModel> parseData(String str4) {
                return super.parseData(str4);
            }
        }, str, String.valueOf(j), str2, str3);
    }
}
