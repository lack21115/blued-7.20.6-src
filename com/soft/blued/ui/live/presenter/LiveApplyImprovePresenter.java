package com.soft.blued.ui.live.presenter;

import android.util.Log;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.ui.live.model.LiveIDCardUploadResult;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/presenter/LiveApplyImprovePresenter.class */
public class LiveApplyImprovePresenter extends LiveBaseImprovePresenter {
    @Override // com.soft.blued.ui.live.presenter.LiveBaseImprovePresenter
    public void a(final int i, String str) {
        LiveHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<LiveIDCardUploadResult>>(g()) { // from class: com.soft.blued.ui.live.presenter.LiveApplyImprovePresenter.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveIDCardUploadResult> bluedEntityA) {
                if (bluedEntityA != null) {
                    Log.v("pk", "上传图片成功：" + i);
                    int i2 = i;
                    if (i2 == 0) {
                        LiveApplyImprovePresenter.this.a("LIVE_CARD_FRONT_UPLOAD", bluedEntityA.data);
                    } else if (i2 != 1) {
                    } else {
                        LiveApplyImprovePresenter.this.a("LIVE_CARD_BACK_UPLOAD", bluedEntityA.data);
                    }
                }
            }

            public void onUIFinish() {
                super.onUIFinish();
                int i2 = i;
                if (i2 == 0) {
                    LiveApplyImprovePresenter.this.b("LIVE_CARD_FRONT_UPLOAD", true);
                } else if (i2 != 1) {
                } else {
                    LiveApplyImprovePresenter.this.b("LIVE_CARD_BACK_UPLOAD", true);
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), i, str, g());
    }

    @Override // com.soft.blued.ui.live.presenter.LiveBaseImprovePresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    public void a(final boolean z) {
        LiveHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<BluedLiveState>>(g()) { // from class: com.soft.blued.ui.live.presenter.LiveApplyImprovePresenter.1
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLiveState> bluedEntityA) {
                if (bluedEntityA != null) {
                    LiveApplyImprovePresenter.this.a("LIVE_IMPROVE_STATE", bluedEntityA.data);
                    if (!z || bluedEntityA.data.size() <= 0 || bluedEntityA.data.get(0) == null) {
                        return;
                    }
                    BluedLiveState bluedLiveState = (BluedLiveState) bluedEntityA.data.get(0);
                    if (bluedLiveState.idcard_verify_status != 1) {
                        AppMethods.a(bluedLiveState.idcard_verify_fail_reason);
                        return;
                    }
                    LiveApplyImprovePresenter.this.f_("LIVE_SHOW_AGREEMENT");
                    LiveApplyImprovePresenter.this.h().finish();
                }
            }

            public boolean onUIFailure(int i, String str) {
                AppMethods.a(str);
                return true;
            }

            public void onUIFinish() {
                super.onUIFinish();
                LiveApplyImprovePresenter.this.b("LIVE_IMPROVE_STATE", true);
            }

            public void onUIStart() {
                super.onUIStart();
                LiveApplyImprovePresenter.this.d_("LIVE_IMPROVE_STATE");
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), g());
    }

    public void b(final int i, String str) {
        LiveHttpUtils.e(new BluedUIHttpResponse(g()) { // from class: com.soft.blued.ui.live.presenter.LiveApplyImprovePresenter.3
            public boolean onUIFailure(int i2, String str2) {
                AppMethods.a(str2);
                return true;
            }

            public void onUIFinish() {
                super.onUIFinish();
                int i2 = i;
                if (i2 == 0) {
                    LiveApplyImprovePresenter.this.b("LIVE_CARD_FRONT_DELETE", true);
                } else if (i2 != 1) {
                } else {
                    LiveApplyImprovePresenter.this.b("LIVE_CARD_BACK_DELETE", true);
                }
            }

            public void onUIStart() {
                super.onUIStart();
                int i2 = i;
                if (i2 == 0) {
                    LiveApplyImprovePresenter.this.d_("LIVE_CARD_FRONT_DELETE");
                } else if (i2 != 1) {
                } else {
                    LiveApplyImprovePresenter.this.d_("LIVE_CARD_BACK_DELETE");
                }
            }

            public void onUIUpdate(BluedEntity bluedEntity) {
                int i2 = i;
                if (i2 == 0) {
                    LiveApplyImprovePresenter.this.f_("LIVE_CARD_FRONT_DELETE");
                } else if (i2 != 1) {
                } else {
                    LiveApplyImprovePresenter.this.f_("LIVE_CARD_BACK_DELETE");
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), i, str, g());
    }

    @Override // com.soft.blued.ui.live.presenter.LiveBaseImprovePresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }
}
