package com.blued.android.module.live_china.presenter;

import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.model.LiveFansMemberModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveFansRecordMemberPresent.class */
public class LiveFansRecordMemberPresent extends MvpPresenter {
    private IFetchDataListener k;
    private int i = 0;
    private int j = 1;
    BluedUIHttpResponse h = new BluedUIHttpResponse<BluedEntityA<LiveFansMemberModel>>(g()) { // from class: com.blued.android.module.live_china.presenter.LiveFansRecordMemberPresent.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<LiveFansMemberModel> bluedEntityA) {
            if (bluedEntityA == null) {
                return;
            }
            if (bluedEntityA.data != null && LiveFansRecordMemberPresent.this.k != null) {
                LiveFansRecordMemberPresent.this.k.a("MEMBER_DATA", bluedEntityA.data);
            }
            if (LiveFansRecordMemberPresent.this.k != null) {
                LiveFansRecordMemberPresent.this.k.b(bluedEntityA.hasMore());
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            AppMethods.a((CharSequence) str);
            if (LiveFansRecordMemberPresent.this.j > 1) {
                LiveFansRecordMemberPresent.c(LiveFansRecordMemberPresent.this);
                return true;
            }
            return true;
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            if (LiveFansRecordMemberPresent.this.k != null) {
                LiveFansRecordMemberPresent.this.k.a(true);
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            if (LiveFansRecordMemberPresent.this.k != null) {
                LiveFansRecordMemberPresent.this.k.a();
            }
        }
    };

    static /* synthetic */ int c(LiveFansRecordMemberPresent liveFansRecordMemberPresent) {
        int i = liveFansRecordMemberPresent.j;
        liveFansRecordMemberPresent.j = i - 1;
        return i;
    }

    public void a(int i) {
        this.i = i;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        this.j = 1;
        c(iFetchDataListener);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        this.j++;
        c(iFetchDataListener);
    }

    public void c(IFetchDataListener iFetchDataListener) {
        this.k = iFetchDataListener;
        int i = this.i;
        if (i == 0) {
            LiveRoomHttpUtils.b(this.j, this.h, g());
        } else if (i == 1) {
            LiveRoomHttpUtils.c(this.j, this.h, g());
        } else if (i == 2) {
            LiveRoomHttpUtils.d(this.j, this.h, g());
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public boolean c() {
        return false;
    }
}
