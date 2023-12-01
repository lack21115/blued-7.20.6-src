package com.blued.android.module.live_china.presenter;

import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.model.LiveFansGroupModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveFansGroupPlayingPresent.class */
public class LiveFansGroupPlayingPresent extends MvpPresenter {
    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    public void a(LiveFansGroupModel liveFansGroupModel) {
        if (liveFansGroupModel == null) {
            a("APPLY_JOIN_GROUP", "404", false);
        } else {
            LiveRoomHttpUtils.a(liveFansGroupModel.group_id, liveFansGroupModel.allow_join, "", new BluedUIHttpResponse<BluedEntityA<Object>>(g()) { // from class: com.blued.android.module.live_china.presenter.LiveFansGroupPlayingPresent.3
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                    LiveFansGroupPlayingPresent.this.a("APPLY_JOIN_GROUP", String.valueOf(bluedEntityA.code), false);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str) {
                    LiveFansGroupPlayingPresent.this.a("APPLY_JOIN_GROUP", String.valueOf(i), false);
                    return super.onUIFailure(i, str);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    super.onUIFinish();
                }
            }, g());
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    public void m() {
        LiveRoomHttpUtils.l(new BluedUIHttpResponse<BluedEntityA<LiveFansGroupModel>>(g()) { // from class: com.blued.android.module.live_china.presenter.LiveFansGroupPlayingPresent.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveFansGroupModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() == 0) {
                    LiveFansGroupPlayingPresent.this.a("FANS_GROUP_LIST_NULL", "FANS_GROUP_LIST_NULL", false);
                } else {
                    LiveFansGroupPlayingPresent.this.a("FANS_GROUP_LIST", (String) bluedEntityA.data, false);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LiveFansGroupPlayingPresent.this.a("FANS_GROUP_LIST_ERROR", "FANS_GROUP_LIST_ERROR", false);
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }
        }, g());
    }

    public void n() {
        LiveRoomHttpUtils.m(new BluedUIHttpResponse<BluedEntityA<LiveFansGroupModel>>(g()) { // from class: com.blued.android.module.live_china.presenter.LiveFansGroupPlayingPresent.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveFansGroupModel> bluedEntityA) {
                LiveFansGroupPlayingPresent.this.a("VERIFY_JOIN_GROUP", String.valueOf(bluedEntityA.code), false);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LiveFansGroupPlayingPresent.this.a("VERIFY_JOIN_GROUP", String.valueOf(i), false);
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }
        }, g());
    }
}
