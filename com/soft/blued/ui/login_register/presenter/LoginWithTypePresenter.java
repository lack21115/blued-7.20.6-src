package com.soft.blued.ui.login_register.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityStack;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.module.common.db.UserAccountsVDao;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.BluedLoginResultVerBinding;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.auto.LoginServiceManager;
import com.blued.login.constant.LoginConstants;
import com.blued.login.face.AVConfig;
import com.blued.login.face.AVConfigExtra;
import com.blued.login.fragment.FinishProfile1Fragment;
import com.blued.login.log.EventTrackLogin;
import com.bytedance.applog.tracker.Tracker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.push.PushManager;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.login_register.AdultVerifyFragment;
import com.soft.blued.ui.login_register.Contract.LoginWithTypeContract;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.View.StartLoginVerifyFragment;
import com.soft.blued.ui.user.fragment.AccountLockedFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.tencent.bugly.crashreport.CrashReport;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/presenter/LoginWithTypePresenter.class */
public class LoginWithTypePresenter implements LoginWithTypeContract.IPresenter {

    /* renamed from: a  reason: collision with root package name */
    String f17868a;
    private Context d;
    private IRequestHost e;
    private LoginWithTypeContract.IView f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;

    /* renamed from: c  reason: collision with root package name */
    private final String f17869c = LoginWithTypePresenter.class.getSimpleName();
    boolean b = false;

    public LoginWithTypePresenter(Context context, LoginWithTypeContract.IView iView, IRequestHost iRequestHost) {
        if (iView == null || context == null) {
            return;
        }
        this.f = iView;
        this.e = iRequestHost;
        this.d = context;
    }

    private BluedUIHttpResponse a(final LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE phone_code_login_stage, final String str) {
        return new BluedUIHttpResponse<BluedEntityA>(this.e) { // from class: com.soft.blued.ui.login_register.presenter.LoginWithTypePresenter.4
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA bluedEntityA) {
                if (phone_code_login_stage == LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE.IDENTIFY) {
                    LoginWithTypePresenter.this.f.d();
                    return;
                }
                BluedLoginResultVerBinding verified_bindings = UserInfo.getInstance().getLoginUserInfo().getVerified_bindings();
                UserInfo.getInstance().getLoginUserInfo().setNeed_auth(0);
                BluedLoginResultVerBinding bluedLoginResultVerBinding = verified_bindings;
                if (verified_bindings == null) {
                    bluedLoginResultVerBinding = new BluedLoginResultVerBinding();
                    UserInfo.getInstance().getLoginUserInfo().setVerified_bindings(bluedLoginResultVerBinding);
                }
                bluedLoginResultVerBinding.relation_mobile = str;
                if (LoginWithTypePresenter.this.b) {
                    LoginWithTypePresenter.this.f.g();
                } else {
                    LoginServiceManager.a().b(LoginWithTypePresenter.this.d);
                }
            }

            public boolean onUIFailure(int i, String str2) {
                if (i == 4036215) {
                    LoginWithTypePresenter loginWithTypePresenter = LoginWithTypePresenter.this;
                    loginWithTypePresenter.a(loginWithTypePresenter.d);
                    return true;
                }
                return super.onUIFailure(i, str2);
            }
        };
    }

    public static void e() {
        Locale c2 = LocaleUtils.c();
        String language = c2 != null ? c2.getLanguage() : "";
        if (TextUtils.isEmpty(language)) {
            return;
        }
        if (BluedPreferences.aG()) {
            BluedApplicationLike.previousLanguage = language;
        } else {
            BluedApplicationLike.previousLanguage = null;
        }
    }

    public BluedUIHttpResponse a(final String str, final String str2, final boolean z, final LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE phone_code_login_stage) {
        return new BluedUIHttpResponse<BluedEntity<BluedLoginResult, AVConfigExtra>>(this.e) { // from class: com.soft.blued.ui.login_register.presenter.LoginWithTypePresenter.1
            public boolean onUIFailure(int i, String str3, String str4) {
                boolean z2;
                BluedAlbum bluedAlbum;
                if (phone_code_login_stage == LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE.VERIFY_UP) {
                    EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.USER_VERIFY_POP_FAIL);
                }
                try {
                    switch (i) {
                        case 401:
                            if (z) {
                                LoginWithTypePresenter.this.f.c();
                                if (StringUtils.d(LoginWithTypePresenter.this.b())) {
                                    return true;
                                }
                                LoginWithTypePresenter.this.f.a(LoginWithTypePresenter.this.b(), true);
                                return true;
                            }
                            return true;
                        case 4035009:
                            Bundle bundle = new Bundle();
                            String token = LoginRegisterTools.d(str4).getToken();
                            String login_mobile = LoginRegisterTools.d(str4).getLogin_mobile();
                            String relation_mobile = LoginRegisterTools.d(str4).getRelation_mobile();
                            String login_email = LoginRegisterTools.d(str4).getLogin_email();
                            String safe_email = LoginRegisterTools.d(str4).getSafe_email();
                            Log.v("drb", "put login_mobile:" + login_mobile + " --  relation_mobile:" + relation_mobile + " --  login_email:" + login_email + " --  safe_email:" + safe_email);
                            bundle.putString("token", token);
                            bundle.putString("login_mobile", login_mobile);
                            bundle.putString("relation_mobile", relation_mobile);
                            bundle.putString("login_email", login_email);
                            bundle.putString("safe_email", safe_email);
                            bundle.putString("password", LoginWithTypePresenter.this.j);
                            bundle.putString("login_type", str);
                            bundle.putString("login_account", str2);
                            bundle.putString("key_uid", LoginRegisterTools.d(str4).getUid());
                            if (!TextUtils.isEmpty(LoginWithTypePresenter.this.k)) {
                                bundle.putString("aliasUserId", LoginWithTypePresenter.this.k);
                            }
                            bundle.putInt("target_type", 0);
                            StartLoginVerifyFragment.a(LoginWithTypePresenter.this.d, bundle);
                            return true;
                        case 4036002:
                        case 4036205:
                            try {
                                AppMethods.a(str3);
                                LoginWithTypePresenter.this.c(LoginRegisterTools.b(str4)[0]);
                                if (LoginRegisterTools.c(str4)) {
                                    LoginWithTypePresenter.this.f.a(z);
                                    return true;
                                }
                                LoginWithTypePresenter.this.h = LoginRegisterTools.b(str4)[1];
                                LoginWithTypePresenter.this.f.a(LoginWithTypePresenter.this.h, z);
                                return true;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return true;
                            }
                        case 4036014:
                            if (TextUtils.isEmpty(str3)) {
                                return true;
                            }
                            LoginWithTypePresenter.this.f.a(str3);
                            return true;
                        case 4036300:
                            try {
                                Gson f = AppInfo.f();
                                BluedEntityA bluedEntityA = (BluedEntityA) f.fromJson(str4, new TypeToken<BluedEntityA<BluedLoginResult>>() { // from class: com.soft.blued.ui.login_register.presenter.LoginWithTypePresenter.1.2
                                }.getType());
                                if (bluedEntityA != null && bluedEntityA.data != null && bluedEntityA.data.size() > 0 && (bluedAlbum = (BluedAlbum) f.fromJson(AesCrypto2.a(((BluedLoginResult) bluedEntityA.getSingleData()).getEncrypted()), (Class<Object>) BluedAlbum.class)) != null) {
                                    if (!StringUtils.d(bluedAlbum.token)) {
                                        FinishProfile1Fragment.f6934a.a(LoginWithTypePresenter.this.d, bluedAlbum.token, "", str2, LoginAndRegisterProtos.Source.PHONE, LoginWithTypePresenter.this.k);
                                        Iterator it = ActivityStack.a().b().iterator();
                                        while (true) {
                                            z2 = false;
                                            if (!it.hasNext()) {
                                                break;
                                            } else {
                                                Activity activity = (Activity) it.next();
                                                if (activity.getClass() == HomeActivity.class) {
                                                    activity.finish();
                                                }
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                            }
                            z2 = true;
                            break;
                        case 4036501:
                            BluedEntityA bluedEntityA2 = (BluedEntityA) AppInfo.f().fromJson(str4, new TypeToken<BluedEntityA<BluedLoginResult>>() { // from class: com.soft.blued.ui.login_register.presenter.LoginWithTypePresenter.1.1
                            }.getType());
                            z2 = false;
                            if (bluedEntityA2 != null) {
                                z2 = false;
                                if (bluedEntityA2.data != null) {
                                    z2 = false;
                                    if (bluedEntityA2.data.size() > 0) {
                                        BluedLoginResult bluedLoginResult = (BluedLoginResult) bluedEntityA2.data.get(0);
                                        AccountLockedFragment.a(LoginWithTypePresenter.this.d, bluedLoginResult.reason, bluedLoginResult.uid);
                                        z2 = false;
                                        break;
                                    }
                                }
                            }
                            break;
                        default:
                            if (z) {
                                if (!StringUtils.d(LoginWithTypePresenter.this.b())) {
                                    LoginWithTypePresenter.this.f.a(LoginWithTypePresenter.this.b(), true);
                                }
                            } else if (!StringUtils.d(LoginWithTypePresenter.this.c())) {
                                LoginWithTypePresenter.this.f.a(LoginWithTypePresenter.this.c(), true);
                            }
                            z2 = true;
                            break;
                    }
                } catch (Exception e3) {
                    z2 = false;
                }
                if (z2) {
                    AppMethods.a(str3);
                    return true;
                }
                return true;
            }

            public void onUIFinish() {
                LoginWithTypePresenter.this.f.a();
            }

            public void onUIStart() {
                if (phone_code_login_stage != LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE.IDENTIFY_UP) {
                    LoginWithTypePresenter.this.f.b();
                }
            }

            public void onUIUpdate(BluedEntity<BluedLoginResult, AVConfigExtra> bluedEntity) {
                int i;
                try {
                    if (phone_code_login_stage == LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE.IDENTIFY) {
                        LoginWithTypePresenter.this.f.d();
                    } else if (bluedEntity == null || !bluedEntity.hasData()) {
                    } else {
                        boolean z2 = false;
                        if (bluedEntity.data.get(0) != null) {
                            if (bluedEntity.extra != null) {
                                AVConfig.a().a(((AVConfigExtra) bluedEntity.extra).f6932a, false);
                            }
                            BluedLoginResult bluedLoginResult = (BluedLoginResult) bluedEntity.data.get(0);
                            if (phone_code_login_stage == LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE.IDENTIFY_UP) {
                                LoginWithTypePresenter.this.f.a(bluedLoginResult.captcha, bluedLoginResult.target);
                                return;
                            }
                            if (phone_code_login_stage == LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE.VERIFY_UP) {
                                LoginWithTypePresenter.this.f.h();
                                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.USER_VERIFY_POP_SUCCESS);
                            }
                            if ("mobile".equals(str)) {
                                if (LoginWithTypePresenter.this.f.e() == 1) {
                                    EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_SUCCESS, LoginAndRegisterProtos.Source.PHONE_CODE, bluedLoginResult.uid);
                                } else {
                                    EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_SUCCESS, LoginAndRegisterProtos.Source.PHONE, bluedLoginResult.uid);
                                }
                                i = 1;
                            } else {
                                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_SUCCESS, LoginAndRegisterProtos.Source.EMAIL, bluedLoginResult.uid);
                                i = 0;
                            }
                            Logger.b(LoginWithTypePresenter.this.f17869c, "===success", "加密：responseJson:", bluedEntity);
                            UserInfo.getInstance().saveUserInfo(str2, i, LoginWithTypePresenter.this.g, bluedLoginResult, new String[]{LoginWithTypePresenter.this.k});
                            if (!StringUtils.d(LoginWithTypePresenter.this.k)) {
                                UserAccountsVDao.a().c(LoginWithTypePresenter.this.k);
                            }
                            PushManager.a().d();
                            if (bluedLoginResult != null && bluedLoginResult.getNeedAdultVerify() == 1) {
                                AdultVerifyFragment.a(LoginWithTypePresenter.this.d);
                                return;
                            }
                            Bundle bundle = new Bundle();
                            bundle.putString("from_tag_page", "from_tag_login");
                            HomeArgumentHelper.a(LoginWithTypePresenter.this.d, (String) null, bundle);
                            LoginConstants.f6899c = "";
                            LoginWithTypePresenter.e();
                            ChatManager.getInstance().initLanguage();
                            if (bluedLoginResult.getDevice_safe() == 1) {
                                z2 = true;
                            }
                            BluedPreferences.J(z2);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.a(LoginWithTypePresenter.this.d.getResources().getString(2131887272));
                }
            }

            public BluedEntity<BluedLoginResult, AVConfigExtra> parseData(String str3) {
                LoginWithTypePresenter.this.g = str3;
                BluedEntity<BluedLoginResult, AVConfigExtra> parseData = super.parseData(str3);
                if (parseData != null) {
                    try {
                        if (parseData.data != null && parseData.data.size() > 0) {
                            String a2 = AesCrypto2.a(((BluedLoginResult) parseData.data.get(0)).getEncrypted());
                            Logger.b(LoginWithTypePresenter.this.f17869c, "解密：deData===", a2);
                            BluedLoginResult bluedLoginResult = (BluedLoginResult) AppInfo.f().fromJson(a2, (Class<Object>) BluedLoginResult.class);
                            CrashReport.setUserId(bluedLoginResult.uid);
                            parseData.data.set(0, bluedLoginResult);
                            return parseData;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                    }
                }
                return parseData;
            }
        };
    }

    public void a(Context context) {
        EventTrackLogin.a(LoginAndRegisterProtos.Event.REGISTER_PHONE_BIND_LIMIT_SHOW, LoginAndRegisterProtos.Source.UNKNOWN_SOURCE);
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(context);
        builder.f(2131101766).g(2131102263).a(this.d.getString(2131890466)).b(this.d.getString(2131890465)).a((View) null).a(this.d.getString(2131890419), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.presenter.LoginWithTypePresenter.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                dialogInterface.dismiss();
                LoginWithTypePresenter.this.f.f();
                EventTrackLogin.a(LoginAndRegisterProtos.Event.REGISTER_PHONE_BIND_LIMIT_CHANGE_CLICK, LoginAndRegisterProtos.Source.UNKNOWN_SOURCE);
            }
        }).b(this.d.getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.presenter.LoginWithTypePresenter.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                EventTrackLogin.a(LoginAndRegisterProtos.Event.REGISTER_PHONE_BIND_LIMIT_CANCEL_CLICK, LoginAndRegisterProtos.Source.UNKNOWN_SOURCE);
            }
        }).a(false).b(true).a((DialogInterface.OnDismissListener) null).a(0).b(0);
        BluedAlertDialog a2 = builder.a();
        a2.setCanceledOnTouchOutside(true);
        a2.show();
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IPresenter
    public void a(Context context, String str, String str2, String str3) {
        LoginRegisterHttpUtils.a(this.e, LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE.IDENTIFY_UP, str, str2, str3, this.f17868a, a("mobile", str, false, LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE.IDENTIFY_UP));
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IPresenter
    public void a(LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE phone_code_login_stage, String str, String str2) {
        LoginRegisterHttpUtils.a(a(phone_code_login_stage, str), this.e, phone_code_login_stage == LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE.IDENTIFY ? "send" : "verify", str, str2);
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IPresenter
    public void a(final LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE phone_code_login_stage, final String str, final String str2, final String str3) {
        if (TextUtils.isEmpty(this.k) || !UserInfo.getInstance().isLogin()) {
            LoginRegisterHttpUtils.a(this.e, phone_code_login_stage, str, str2, str3, this.f17868a, a("mobile", str, false, phone_code_login_stage));
        } else {
            UserRelationshipUtils.a(new Runnable() { // from class: com.soft.blued.ui.login_register.presenter.LoginWithTypePresenter.3
                @Override // java.lang.Runnable
                public void run() {
                    LiveEventBus.get(EventBusConstant.KEY_EVENT_HIDE_LOGIN_BACK).post(null);
                    UserAccountsVDao.a().i();
                    LoginRegisterHttpUtils.a(LoginWithTypePresenter.this.e, phone_code_login_stage, str, str2, str3, LoginWithTypePresenter.this.f17868a, LoginWithTypePresenter.this.a("mobile", str, false, phone_code_login_stage));
                }
            }, "bind_Acc");
        }
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IPresenter
    public void a(String str) {
        this.k = str;
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IPresenter
    public void a(String str, String str2, String str3, String str4, String str5) {
        if (!TextUtils.isEmpty(this.k) && UserInfo.getInstance().isLogin()) {
            b(str, str2, str3, str4, str5);
            return;
        }
        try {
            this.j = BluedHttpTools.b(str3);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        LoginRegisterHttpUtils.a(a(str, str2, true, LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE.VERIFY), str, str2, this.j, this.e, str4, str5, this.f17868a, false);
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IPresenter
    public void a(boolean z) {
        this.b = z;
    }

    public void ar_() {
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IPresenter
    public String b() {
        return this.h;
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IPresenter
    public void b(String str) {
        this.f17868a = str;
    }

    public void b(final String str, final String str2, final String str3, final String str4, final String str5) {
        UserRelationshipUtils.a(new Runnable() { // from class: com.soft.blued.ui.login_register.presenter.LoginWithTypePresenter.2
            @Override // java.lang.Runnable
            public void run() {
                LiveEventBus.get(EventBusConstant.KEY_EVENT_HIDE_LOGIN_BACK).post(null);
                UserAccountsVDao.a().i();
                LoginWithTypePresenter.this.a(str, str2, str3, str4, str5);
            }
        }, "bind_Acc");
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IPresenter
    public String c() {
        return this.l;
    }

    public void c(String str) {
        this.i = str;
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IPresenter
    public String d() {
        return this.i;
    }
}
