package com.blued.android.module.live_china.presenter;

import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.model.LiveFansGroupModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveFansGroupRecordingPresent.class */
public class LiveFansGroupRecordingPresent extends MvpPresenter {
    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    public void d(String str) {
        LiveRoomHttpUtils.g(str, new BluedUIHttpResponse<BluedEntityA<LiveFansGroupModel>>(g()) { // from class: com.blued.android.module.live_china.presenter.LiveFansGroupRecordingPresent.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveFansGroupModel> bluedEntityA) {
                if (bluedEntityA != null) {
                    LiveFansGroupRecordingPresent.this.a("FANS_GROUP_UPGRADE_SUCCEED", bluedEntityA.getSingleData().group_id, false);
                    LiveFansGroupRecordingPresent.this.m();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }
        }, g());
    }

    public void m() {
        LiveRoomHttpUtils.j(new BluedUIHttpResponse<BluedEntityA<LiveFansGroupModel>>(g()) { // from class: com.blued.android.module.live_china.presenter.LiveFansGroupRecordingPresent.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveFansGroupModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() == 0) {
                    LiveFansGroupRecordingPresent.this.a("FANS_GROUP_LIST_NULL", "FANS_GROUP_LIST_NULL", false);
                } else {
                    LiveFansGroupRecordingPresent.this.a("FANS_GROUP_LIST", (String) bluedEntityA.data, false);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LiveFansGroupRecordingPresent.this.a("FANS_GROUP_LIST_ERROR", str, false);
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }
        }, g());
    }

    public void n() {
        LiveRoomHttpUtils.k(new BluedUIHttpResponse<BluedEntityA<LiveFansGroupModel>>(g()) { // from class: com.blued.android.module.live_china.presenter.LiveFansGroupRecordingPresent.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveFansGroupModel> bluedEntityA) {
                if (bluedEntityA != null) {
                    LiveFansGroupRecordingPresent.this.a("FANS_GROUP_CREATE_SUCCEED", bluedEntityA.getSingleData().group_id, false);
                    LiveFansGroupRecordingPresent.this.m();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }
        }, g());
    }
}
