package com.blued.android.module.live_china.presenter;

import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.model.LiveFansInfoModel;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveAnnounceContentPresent.class */
public class LiveAnnounceContentPresent extends MvpPresenter {

    /* renamed from: com.blued.android.module.live_china.presenter.LiveAnnounceContentPresent$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveAnnounceContentPresent$1.class */
    class AnonymousClass1 extends BluedUIHttpResponse<BluedEntityA<LiveFansInfoModel>> {
        final /* synthetic */ LiveAnnounceContentPresent a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<LiveFansInfoModel> bluedEntityA) {
            this.a.a("LIVE_ANNOUNCE_CONTENT", (String) bluedEntityA.data.get(0));
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            AppMethods.a((CharSequence) str);
            return true;
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }
}
