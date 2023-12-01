package com.soft.blued.ui.setting.Presenter;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.R;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.setting.Contract.PrivacyPhotoAlbumContract;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Presenter/PrivacyPhotoAlbumPresenter.class */
public class PrivacyPhotoAlbumPresenter implements PrivacyPhotoAlbumContract.IPresenter {

    /* renamed from: a  reason: collision with root package name */
    private static final String f19540a = PrivacyPhotoAlbumPresenter.class.getSimpleName();
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private PrivacyPhotoAlbumContract.IView f19541c;
    private IRequestHost d;
    private Dialog e;
    private boolean f;
    private BluedUIHttpResponse g = new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>() { // from class: com.soft.blued.ui.setting.Presenter.PrivacyPhotoAlbumPresenter.7
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<UserInfoEntity> bluedEntityA) {
            if (bluedEntityA == null) {
                AppMethods.d(2131888227);
                return;
            }
            DialogUtils.b(PrivacyPhotoAlbumPresenter.this.e);
            UserInfoEntity userInfoEntity = (UserInfoEntity) bluedEntityA.data.get(0);
            if (userInfoEntity == null) {
                AppMethods.d(2131888227);
            } else if (userInfoEntity.album != null) {
                UserInfo.getInstance().getLoginUserInfo().setAlbum(userInfoEntity.album);
            }
        }
    };

    public PrivacyPhotoAlbumPresenter(Context context, PrivacyPhotoAlbumContract.IView iView, IRequestHost iRequestHost) {
        if (context == null || iView == null) {
            return;
        }
        this.b = context;
        this.f19541c = iView;
        this.d = iRequestHost;
        this.e = DialogUtils.a(context);
    }

    @Override // com.soft.blued.ui.setting.Contract.PrivacyPhotoAlbumContract.IPresenter
    public void a(final int i, int i2) {
        ProfileHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<UserFindResult>>() { // from class: com.soft.blued.ui.setting.Presenter.PrivacyPhotoAlbumPresenter.4
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public BluedEntityA<UserFindResult> parseData(String str) {
                Logger.a(PrivacyPhotoAlbumPresenter.f19540a, "getAuthedUserList, content:", str);
                return super.parseData(str);
            }

            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserFindResult> bluedEntityA) {
                try {
                    if (bluedEntityA == null) {
                        AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                        return;
                    }
                    PrivacyPhotoAlbumPresenter.this.f = bluedEntityA.hasMore();
                    PrivacyPhotoAlbumPresenter.this.f19541c.a(bluedEntityA.data);
                } catch (Resources.NotFoundException e) {
                    e.printStackTrace();
                    AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                }
            }

            public void onUIFinish() {
                if (i == 1) {
                    PrivacyPhotoAlbumPresenter.this.f19541c.c();
                }
                PrivacyPhotoAlbumPresenter.this.f19541c.b();
            }

            public void onUIStart() {
                if (i == 1) {
                    PrivacyPhotoAlbumPresenter.this.f19541c.d();
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), i, i2, (IRequestHost) null);
    }

    @Override // com.soft.blued.ui.setting.Contract.PrivacyPhotoAlbumContract.IPresenter
    public void a(final String str) {
        ProfileHttpUtils.b(this.b, new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>(this.d) { // from class: com.soft.blued.ui.setting.Presenter.PrivacyPhotoAlbumPresenter.6
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLoginResult> bluedEntityA) {
                AppMethods.d((int) R.string.delete_success);
                PrivacyPhotoAlbumPresenter.this.f19541c.a(str);
                UserHttpUtils.a(PrivacyPhotoAlbumPresenter.this.b, PrivacyPhotoAlbumPresenter.this.g, UserInfo.getInstance().getLoginUserInfo().getName(), PrivacyPhotoAlbumPresenter.this.d);
            }

            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(PrivacyPhotoAlbumPresenter.this.e);
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(PrivacyPhotoAlbumPresenter.this.e);
            }
        }, str, this.d);
    }

    @Override // com.soft.blued.ui.setting.Contract.PrivacyPhotoAlbumContract.IPresenter
    public void a(String str, final int i) {
        ProfileHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.setting.Presenter.PrivacyPhotoAlbumPresenter.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public BluedEntityA<Object> parseData(String str2) {
                Logger.a(PrivacyPhotoAlbumPresenter.f19540a, "deleteAuthedUser, content:", str2);
                return super.parseData(str2);
            }

            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                try {
                    if (bluedEntityA == null) {
                        AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                    } else {
                        PrivacyPhotoAlbumPresenter.this.f19541c.a(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                }
            }

            public void onUIFinish() {
                PrivacyPhotoAlbumPresenter.this.f19541c.c();
            }

            public void onUIStart() {
                PrivacyPhotoAlbumPresenter.this.f19541c.d();
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), str, (IRequestHost) null);
    }

    @Override // com.soft.blued.ui.setting.Contract.PrivacyPhotoAlbumContract.IPresenter
    public void a(final boolean z) {
        ProfileHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.setting.Presenter.PrivacyPhotoAlbumPresenter.5
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public BluedEntityA<Object> parseData(String str) {
                Logger.a(PrivacyPhotoAlbumPresenter.f19540a, "setPrivacyPhotoAlbumSetting, content:", str);
                return super.parseData(str);
            }

            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                try {
                    if (bluedEntityA == null) {
                        AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                        return;
                    }
                    BluedPreferences.H(z);
                    if (z) {
                        AppMethods.a(PrivacyPhotoAlbumPresenter.this.b.getResources().getString(R.string.already_visible));
                    } else {
                        AppMethods.a(PrivacyPhotoAlbumPresenter.this.b.getResources().getString(R.string.already_hidden));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                }
            }

            public void onUIFinish() {
                PrivacyPhotoAlbumPresenter.this.f19541c.c();
            }

            public void onUIStart() {
                PrivacyPhotoAlbumPresenter.this.f19541c.d();
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), z ? "1" : "0", (IRequestHost) null);
    }

    public void ar_() {
        d();
    }

    @Override // com.soft.blued.ui.setting.Contract.PrivacyPhotoAlbumContract.IPresenter
    public void b() {
        ProfileHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.setting.Presenter.PrivacyPhotoAlbumPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public BluedEntityA<Object> parseData(String str) {
                Logger.a(PrivacyPhotoAlbumPresenter.f19540a, "deleteAllAuthedUsers, content:", str);
                return super.parseData(str);
            }

            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                try {
                    if (bluedEntityA == null) {
                        AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                    } else {
                        PrivacyPhotoAlbumPresenter.this.f19541c.a();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                }
            }

            public void onUIFinish() {
                PrivacyPhotoAlbumPresenter.this.f19541c.c();
            }

            public void onUIStart() {
                PrivacyPhotoAlbumPresenter.this.f19541c.d();
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), null);
    }

    @Override // com.soft.blued.ui.setting.Contract.PrivacyPhotoAlbumContract.IPresenter
    public boolean c() {
        return this.f;
    }

    public void d() {
        ProfileHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<BluedBlackList.privacySettingEntity>>() { // from class: com.soft.blued.ui.setting.Presenter.PrivacyPhotoAlbumPresenter.3
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public BluedEntityA<BluedBlackList.privacySettingEntity> parseData(String str) {
                Logger.a(PrivacyPhotoAlbumPresenter.f19540a, "getPrivacyPhotoAlbumSetting, content:", str);
                return super.parseData(str);
            }

            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedBlackList.privacySettingEntity> bluedEntityA) {
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.hasData()) {
                            return;
                        }
                    } catch (Resources.NotFoundException e) {
                        e.printStackTrace();
                        AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                        return;
                    }
                }
                AppMethods.a(AppInfo.d().getResources().getString(2131887272));
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), (IRequestHost) null);
    }
}
