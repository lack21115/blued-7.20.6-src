package com.soft.blued.ui.login_register.presenter;

import android.content.Context;
import android.os.Bundle;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.module.common.db.UserAccountsVDao;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.login.constant.LoginConstants;
import com.blued.login.face.AVConfig;
import com.blued.login.face.AVConfigExtra;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.login_register.AdultVerifyFragment;
import com.soft.blued.ui.login_register.Contract.VerifyCodeContract;
import com.soft.blued.ui.user.fragment.AccountLockedFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/presenter/VerifyCodePresenter.class */
public class VerifyCodePresenter implements VerifyCodeContract.IPresenter {

    /* renamed from: a  reason: collision with root package name */
    private VerifyCodeContract.IView f31576a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f31577c;
    private String d;

    public VerifyCodePresenter(Context context, VerifyCodeContract.IView iView, IRequestHost iRequestHost) {
        this.f31576a = iView;
        this.b = context;
        this.f31577c = iRequestHost;
    }

    public BluedUIHttpResponse a(String str, String str2, final String str3, final String str4, final String str5) {
        return new BluedUIHttpResponse<BluedEntity<BluedLoginResult, AVConfigExtra>>(this.f31577c) { // from class: com.soft.blued.ui.login_register.presenter.VerifyCodePresenter.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str6, String str7) {
                boolean z;
                if (i != 4036501) {
                    z = true;
                } else {
                    try {
                        BluedEntityA bluedEntityA = (BluedEntityA) AppInfo.f().fromJson(str7, new TypeToken<BluedEntityA<BluedLoginResult>>() { // from class: com.soft.blued.ui.login_register.presenter.VerifyCodePresenter.4.1
                        }.getType());
                        z = false;
                        if (bluedEntityA != null) {
                            z = false;
                            if (bluedEntityA.data != null) {
                                z = false;
                                if (bluedEntityA.data.size() > 0) {
                                    BluedLoginResult bluedLoginResult = (BluedLoginResult) bluedEntityA.data.get(0);
                                    AccountLockedFragment.a(VerifyCodePresenter.this.b, bluedLoginResult.reason, bluedLoginResult.uid);
                                    z = false;
                                }
                            }
                        }
                    } catch (Exception e) {
                        z = false;
                    }
                }
                if (z) {
                    return super.onUIFailure(i, str6);
                }
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                VerifyCodePresenter.this.f31576a.b();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                VerifyCodePresenter.this.f31576a.a();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BluedLoginResult, AVConfigExtra> bluedEntity) {
                if (bluedEntity != null) {
                    try {
                        if (!bluedEntity.hasData() || bluedEntity.data.get(0) == null) {
                            return;
                        }
                        if (bluedEntity.extra != null) {
                            AVConfig.a().a(bluedEntity.extra.f20538a, false);
                        }
                        BluedLoginResult bluedLoginResult = bluedEntity.data.get(0);
                        BluedPreferences.J(bluedLoginResult.getDevice_safe() == 1);
                        int i = "mobile".equals(str3) ? 1 : "email".equals(str3) ? 0 : 2;
                        Logger.b(VerifyCodePresenter.class.getSimpleName(), "VerifyCodePresenter", "===success", "加密：responseJson:", bluedEntity);
                        UserInfo.getInstance().saveUserInfo(str4, i, VerifyCodePresenter.this.d, bluedLoginResult, str5);
                        if (!StringUtils.d(str5)) {
                            UserAccountsVDao.a().c(str5);
                        }
                        if (bluedLoginResult != null && bluedLoginResult.getNeedAdultVerify() == 1) {
                            AdultVerifyFragment.a(VerifyCodePresenter.this.b);
                            return;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("from_tag_page", "from_tag_login");
                        HomeArgumentHelper.a(VerifyCodePresenter.this.b, (String) null, bundle);
                        LoginConstants.f20505c = "";
                        BluedApplicationLike.initAppLanguage();
                        ChatManager.getInstance().initLanguage();
                    } catch (Exception e) {
                        e.printStackTrace();
                        AppMethods.a((CharSequence) VerifyCodePresenter.this.b.getResources().getString(2131887272));
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public BluedEntity<BluedLoginResult, AVConfigExtra> parseData(String str6) {
                VerifyCodePresenter.this.d = str6;
                BluedEntity<BluedLoginResult, AVConfigExtra> parseData = super.parseData(str6);
                if (parseData != null) {
                    try {
                        if (parseData.hasData()) {
                            parseData.data.set(0, (BluedLoginResult) AppInfo.f().fromJson(AesCrypto2.a(parseData.data.get(0).getEncrypted()), (Class<Object>) BluedLoginResult.class));
                            return parseData;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        AppMethods.a((CharSequence) VerifyCodePresenter.this.b.getResources().getString(2131887272));
                    }
                }
                return parseData;
            }
        };
    }

    @Override // com.soft.blued.ui.login_register.Contract.VerifyCodeContract.IPresenter
    public void a(String str, int i) {
        if (i == 0) {
            LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this.f31577c) { // from class: com.soft.blued.ui.login_register.presenter.VerifyCodePresenter.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                }
            }, str, "reset", "", "", this.f31577c);
        } else if (i != 1) {
        } else {
            LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this.f31577c) { // from class: com.soft.blued.ui.login_register.presenter.VerifyCodePresenter.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                }
            }, "reset", "", "", this.f31577c);
        }
    }

    @Override // com.soft.blued.ui.login_register.Contract.VerifyCodeContract.IPresenter
    public void a(String str, String str2, String str3, String str4, String str5, int i, String str6) {
        if (i == 0) {
            LoginRegisterHttpUtils.a(a(str, str2, str3, str4, str6), str, "verify", str2, "", this.f31577c);
        } else if (i != 1) {
        } else {
            LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this.f31577c) { // from class: com.soft.blued.ui.login_register.presenter.VerifyCodePresenter.3
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                    VerifyCodePresenter.this.f31576a.c();
                }
            }, "verify", str2, "", this.f31577c);
        }
    }

    @Override // com.blued.android.framework.mvp_similarity.BasePresenter
    public void ar_() {
    }
}
