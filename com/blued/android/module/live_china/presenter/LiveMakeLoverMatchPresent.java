package com.blued.android.module.live_china.presenter;

import android.app.Activity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveMakeLoverReleationModel;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveMakeLoverMatchPresent.class */
public class LiveMakeLoverMatchPresent extends MvpPresenter {
    public BluedUIHttpResponse h = new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(g()) { // from class: com.blued.android.module.live_china.presenter.LiveMakeLoverMatchPresent.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<LiveRoomUserModel> bluedEntityA) {
            LiveRoomUserModel liveRoomUserModel;
            if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || (liveRoomUserModel = bluedEntityA.data.get(0)) == null) {
                return;
            }
            LiveMakeLoverReleationModel liveMakeLoverReleationModel = new LiveMakeLoverReleationModel();
            liveMakeLoverReleationModel.relation = liveRoomUserModel.relationship;
            LiveMakeLoverMatchPresent.this.a("MAKE_LOVER_RELATION", (String) liveMakeLoverReleationModel);
        }
    };

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    public void a(String str, long j, short s) {
        LiveRoomHttpUtils.a(h(), this.h, str, "", Long.valueOf(j), Short.valueOf(s), g());
    }

    public void a(String str, String str2) {
        LiveRoomInfo a = LiveRoomInfo.a();
        Activity h = h();
        LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone = new LiveUserRelationshipUtils.IAddOrRemoveAttentionDone() { // from class: com.blued.android.module.live_china.presenter.LiveMakeLoverMatchPresent.1
            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void Q_() {
                LiveMakeLoverMatchPresent.this.d_("MAKE_LOVER_RELATION_ADD");
            }

            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void a(String str3) {
                LiveMakeLoverMatchPresent.this.b("MAKE_LOVER_RELATION_ADD", true);
            }

            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void b(String str3) {
                LiveMakeLoverMatchPresent.this.b("MAKE_LOVER_RELATION_ADD", true);
            }

            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void c() {
                LiveMakeLoverMatchPresent.this.b("MAKE_LOVER_RELATION_ADD", true);
            }

            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void d() {
                LiveMakeLoverMatchPresent.this.b("MAKE_LOVER_RELATION_ADD", false);
            }
        };
        a.a(h, iAddOrRemoveAttentionDone, str2, "liveanchor_" + str, g());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public boolean c() {
        return false;
    }
}
