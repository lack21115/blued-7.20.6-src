package com.blued.android.module.live_china.presenter;

import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveFansMemberModel;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveMakeLoverApplyGuestPresent.class */
public class LiveMakeLoverApplyGuestPresent extends MvpPresenter {
    public int h = 0;

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    public void a(String str, String str2) {
        LiveRoomHttpUtils.f(str, str2, new BluedUIHttpResponse<BluedEntityA<LiveFansMemberModel>>(g()) { // from class: com.blued.android.module.live_china.presenter.LiveMakeLoverApplyGuestPresent.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveFansMemberModel> bluedEntityA) {
                LiveMakeLoverApplyGuestPresent.this.f_("LIVE_MAKE_LOVER_APPLY");
                LiveMakeLoverApplyGuestPresent.this.b("LIVE_MAKE_LOVER_APPLY", true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str3) {
                LiveMakeLoverApplyGuestPresent.this.h = i;
                LiveMakeLoverApplyGuestPresent.this.b("LIVE_MAKE_LOVER_APPLY", false);
                AppMethods.a((CharSequence) str3);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveMakeLoverApplyGuestPresent.this.d_("LIVE_MAKE_LOVER_APPLY");
            }
        }, g());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    public void d(final String str) {
        LiveRoomInfo.a().a(new PermissionCallbacks() { // from class: com.blued.android.module.live_china.presenter.LiveMakeLoverApplyGuestPresent.2
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
                LiveMsgSendManager.a().d("开启权限");
                LiveRoomHttpUtils.v(new BluedUIHttpResponse<BluedEntity<LiveFriendModel, LiveFriendModel>>(LiveMakeLoverApplyGuestPresent.this.g()) { // from class: com.blued.android.module.live_china.presenter.LiveMakeLoverApplyGuestPresent.2.1
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public boolean onUIFailure(int i, String str2) {
                        LiveMakeLoverApplyGuestPresent.this.h = i;
                        LiveMakeLoverApplyGuestPresent.this.b("LIVE_MAKE_LOVER_START", false);
                        AppMethods.a((CharSequence) str2);
                        return true;
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public void onUIStart() {
                        super.onUIStart();
                        LiveMakeLoverApplyGuestPresent.this.d_("LIVE_MAKE_LOVER_START");
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public void onUIUpdate(BluedEntity<LiveFriendModel, LiveFriendModel> bluedEntity) {
                        LiveMakeLoverApplyGuestPresent.this.f_("LIVE_MAKE_LOVER_START");
                        LiveMakeLoverApplyGuestPresent.this.b("LIVE_MAKE_LOVER_START", true);
                    }
                }, str);
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] strArr) {
                LiveMsgSendManager.a().d("关闭权限");
                LiveMakeLoverApplyGuestPresent.this.f(str);
            }
        });
    }

    public void e(String str) {
        LiveRoomHttpUtils.w(new BluedUIHttpResponse(g()) { // from class: com.blued.android.module.live_china.presenter.LiveMakeLoverApplyGuestPresent.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                LiveMakeLoverApplyGuestPresent.this.h = i;
                LiveMakeLoverApplyGuestPresent.this.b("LIVE_MAKE_LOVER_CANCEL", false);
                AppMethods.a((CharSequence) str2);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveMakeLoverApplyGuestPresent.this.d_("LIVE_MAKE_LOVER_CANCEL");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveMakeLoverApplyGuestPresent.this.f_("LIVE_MAKE_LOVER_CANCEL");
                LiveMakeLoverApplyGuestPresent.this.b("LIVE_MAKE_LOVER_CANCEL", true);
            }
        }, str);
    }

    public void f(String str) {
        LiveRoomHttpUtils.x(new BluedUIHttpResponse(g()) { // from class: com.blued.android.module.live_china.presenter.LiveMakeLoverApplyGuestPresent.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                LiveMakeLoverApplyGuestPresent.this.h = i;
                LiveMakeLoverApplyGuestPresent.this.b("LIVE_MAKE_LOVER_REFUSE", false);
                AppMethods.a((CharSequence) str2);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveMakeLoverApplyGuestPresent.this.d_("LIVE_MAKE_LOVER_REFUSE");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveMakeLoverApplyGuestPresent.this.f_("LIVE_MAKE_LOVER_REFUSE");
                LiveMakeLoverApplyGuestPresent.this.b("LIVE_MAKE_LOVER_REFUSE", true);
            }
        }, str);
    }
}
