package com.blued.android.module.live_china.presenter;

import android.content.Context;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.contrast.LiveRewardDetailsContract;
import com.blued.android.module.live_china.model.LiveRewardExtraModel;
import com.blued.android.module.live_china.model.LiveRewardListModel;
import com.blued.android.module.live_china.model.RewardDetailsCommonModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveRewardDetailsPresenter.class */
public class LiveRewardDetailsPresenter implements LiveRewardDetailsContract.IPresenter {

    /* renamed from: a  reason: collision with root package name */
    private Context f14048a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private RewardDetailsCommonModel f14049c;
    private long d;
    private String e;
    private LiveRewardDetailsContract.IView f;

    public LiveRewardDetailsPresenter(Context context, LiveRewardDetailsContract.IView iView, IRequestHost iRequestHost, RewardDetailsCommonModel rewardDetailsCommonModel, String str, long j) {
        this.b = iRequestHost;
        this.f14049c = rewardDetailsCommonModel;
        this.f14048a = context;
        this.e = str;
        this.d = j;
        this.f = iView;
    }

    @Override // com.blued.android.framework.mvp_similarity.BasePresenter
    public void ar_() {
    }

    public void b() {
        LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntity<LiveRewardListModel, LiveRewardExtraModel>>(this.b) { // from class: com.blued.android.module.live_china.presenter.LiveRewardDetailsPresenter.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.presenter.LiveRewardDetailsPresenter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveRewardDetailsPresenter.this.f.a(null, false);
                    }
                });
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                LiveRewardDetailsPresenter.this.f.d();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveRewardListModel, LiveRewardExtraModel> bluedEntity) {
                try {
                    if (bluedEntity.extra != null) {
                        LiveRewardDetailsPresenter.this.f.a(bluedEntity.extra);
                    }
                    if (bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                        if (LiveRewardDetailsPresenter.this.f14049c.page == 1) {
                            LiveRewardDetailsPresenter.this.f.a(bluedEntity.data, false);
                        } else {
                            LiveRewardDetailsPresenter.this.f14049c.page--;
                        }
                        LiveRewardDetailsPresenter.this.f.c();
                        return;
                    }
                    if (bluedEntity.hasMore()) {
                        LiveRewardDetailsPresenter.this.f14049c.hasData = true;
                        LiveRewardDetailsPresenter.this.f.e();
                    } else {
                        LiveRewardDetailsPresenter.this.f14049c.hasData = false;
                        LiveRewardDetailsPresenter.this.f.c();
                    }
                    if (LiveRewardDetailsPresenter.this.f14049c.page == 1) {
                        LiveRewardDetailsPresenter.this.f.a(bluedEntity.data, false);
                    } else {
                        LiveRewardDetailsPresenter.this.f.a(bluedEntity.data, true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (LiveRewardDetailsPresenter.this.f14049c.page != 1) {
                        LiveRewardDetailsPresenter.this.f14049c.page--;
                    }
                    AppMethods.a((CharSequence) LiveRewardDetailsPresenter.this.f14048a.getResources().getString(R.string.common_net_error));
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public BluedEntity<LiveRewardListModel, LiveRewardExtraModel> parseData(String str) {
                return super.parseData(str);
            }
        }, this.e, String.valueOf(this.d), String.valueOf(this.f14049c.page), String.valueOf(this.f14049c.last_record_id));
    }
}
