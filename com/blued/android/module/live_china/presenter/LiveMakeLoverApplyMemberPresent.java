package com.blued.android.module.live_china.presenter;

import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.model.LiveMakeLoverApplyMemberModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveMakeLoverApplyMemberPresent.class */
public class LiveMakeLoverApplyMemberPresent extends MvpPresenter {
    private String j;
    private String k;
    private int i = 1;
    public int h = 0;

    static /* synthetic */ int b(LiveMakeLoverApplyMemberPresent liveMakeLoverApplyMemberPresent) {
        int i = liveMakeLoverApplyMemberPresent.i;
        liveMakeLoverApplyMemberPresent.i = i - 1;
        return i;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        this.i = 1;
        c(iFetchDataListener);
    }

    public void a(final LiveMakeLoverApplyMemberModel liveMakeLoverApplyMemberModel) {
        if (liveMakeLoverApplyMemberModel == null) {
            return;
        }
        LiveRoomHttpUtils.d(this.j, liveMakeLoverApplyMemberModel.uid, new BluedUIHttpResponse(g()) { // from class: com.blued.android.module.live_china.presenter.LiveMakeLoverApplyMemberPresent.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LiveMakeLoverApplyMemberPresent.this.h = i;
                AppMethods.a((CharSequence) str);
                LiveMakeLoverApplyMemberPresent.this.b("LIVE_MAKE_LOVER_AGREE", false);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveMakeLoverApplyMemberPresent.this.h = 0;
                LiveMakeLoverApplyMemberPresent.this.a("LIVE_MAKE_LOVER_AGREE", (String) liveMakeLoverApplyMemberModel);
                LiveMakeLoverApplyMemberPresent.this.b("LIVE_MAKE_LOVER_AGREE", true);
            }
        }, g());
    }

    public void a(String str, String str2) {
        this.j = str;
        this.k = str2;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        this.i++;
        c(iFetchDataListener);
    }

    public void b(final LiveMakeLoverApplyMemberModel liveMakeLoverApplyMemberModel) {
        if (liveMakeLoverApplyMemberModel == null) {
            return;
        }
        LiveRoomHttpUtils.e(this.j, liveMakeLoverApplyMemberModel.uid, new BluedUIHttpResponse(g()) { // from class: com.blued.android.module.live_china.presenter.LiveMakeLoverApplyMemberPresent.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LiveMakeLoverApplyMemberPresent.this.h = i;
                AppMethods.a((CharSequence) str);
                LiveMakeLoverApplyMemberPresent.this.b("LIVE_MAKE_LOVER_IGNORE", false);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveMakeLoverApplyMemberPresent.this.h = 0;
                LiveMakeLoverApplyMemberPresent.this.a("LIVE_MAKE_LOVER_IGNORE", (String) liveMakeLoverApplyMemberModel);
                LiveMakeLoverApplyMemberPresent.this.b("LIVE_MAKE_LOVER_IGNORE", true);
            }
        }, g());
    }

    public void c(final IFetchDataListener iFetchDataListener) {
        LiveRoomHttpUtils.a(this.i, this.j, this.k, new BluedUIHttpResponse<BluedEntityA<LiveMakeLoverApplyMemberModel>>(g()) { // from class: com.blued.android.module.live_china.presenter.LiveMakeLoverApplyMemberPresent.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveMakeLoverApplyMemberModel> bluedEntityA) {
                IFetchDataListener iFetchDataListener2;
                LiveMakeLoverApplyMemberPresent.this.h = 0;
                if (bluedEntityA == null) {
                    LiveMakeLoverApplyMemberPresent.this.b("LIVE_MAKE_LOVER_APPLY_LIST", true);
                    return;
                }
                if (bluedEntityA.data != null && (iFetchDataListener2 = iFetchDataListener) != null) {
                    iFetchDataListener2.a("LIVE_MAKE_LOVER_APPLY_LIST", bluedEntityA.data);
                }
                IFetchDataListener iFetchDataListener3 = iFetchDataListener;
                if (iFetchDataListener3 != null) {
                    iFetchDataListener3.b(bluedEntityA.hasMore());
                }
                LiveMakeLoverApplyMemberPresent.this.b("LIVE_MAKE_LOVER_APPLY_LIST", true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LiveMakeLoverApplyMemberPresent.this.h = i;
                AppMethods.a((CharSequence) str);
                if (LiveMakeLoverApplyMemberPresent.this.i > 1) {
                    LiveMakeLoverApplyMemberPresent.b(LiveMakeLoverApplyMemberPresent.this);
                }
                LiveMakeLoverApplyMemberPresent.this.b("LIVE_MAKE_LOVER_APPLY_LIST", false);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a();
                }
            }
        }, g());
    }
}
