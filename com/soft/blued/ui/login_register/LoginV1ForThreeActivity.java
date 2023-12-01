package com.soft.blued.ui.login_register;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.module.common.db.UserAccountsVDao;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.share.Util;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.face.AVConfig;
import com.blued.login.face.AVConfigExtra;
import com.blued.login.fragment.FinishProfile1Fragment;
import com.blued.login.model.BluedCheckResult;
import com.bytedance.applog.tracker.Tracker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.push.PushManager;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.login_register.View.StartLoginVerifyFragment;
import com.soft.blued.ui.user.fragment.AccountLockedFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.wxapi.WXLoginBean;
import com.soft.blued.wxapi.WXProvider;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/LoginV1ForThreeActivity.class */
public class LoginV1ForThreeActivity extends BaseFragmentActivity {
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private Dialog i;
    private String j;
    private String l;

    /* renamed from: c  reason: collision with root package name */
    private String f17719c = LoginV1ForThreeActivity.class.getSimpleName();
    private int k = 0;
    private Handler m = new Handler(new Handler.Callback() { // from class: com.soft.blued.ui.login_register.LoginV1ForThreeActivity.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 4) {
                Logger.b(LoginV1ForThreeActivity.this.f17719c, "==WX_CALLBACK_OK====");
                WXLoginBean wXLoginBean = (WXLoginBean) message.obj;
                if (wXLoginBean == null) {
                    DialogUtils.b(LoginV1ForThreeActivity.this.i);
                    LoginV1ForThreeActivity.this.finish();
                    return false;
                }
                LoginV1ForThreeActivity.this.j = wXLoginBean.code;
                if (!StringUtils.d(LoginV1ForThreeActivity.this.l) && UserInfo.getInstance().isLogin()) {
                    LoginV1ForThreeActivity.this.f();
                    return false;
                }
                LoginV1ForThreeActivity loginV1ForThreeActivity = LoginV1ForThreeActivity.this;
                loginV1ForThreeActivity.a(loginV1ForThreeActivity.j);
                return false;
            } else if (i == 5) {
                Logger.b(LoginV1ForThreeActivity.this.f17719c, "==FB_CALLBACK_ERROR====");
                LoginV1ForThreeActivity.this.a(new Runnable() { // from class: com.soft.blued.ui.login_register.LoginV1ForThreeActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ToastUtils.a(LoginV1ForThreeActivity.this.getString(2131886653));
                    }
                });
                DialogUtils.b(LoginV1ForThreeActivity.this.i);
                LoginV1ForThreeActivity.this.finish();
                return false;
            } else if (i != 6) {
                DialogUtils.b(LoginV1ForThreeActivity.this.i);
                LoginV1ForThreeActivity.this.finish();
                return false;
            } else {
                Logger.b(LoginV1ForThreeActivity.this.f17719c, "==FB_CALLBACK_CANCEL====");
                ToastUtils.a(LoginV1ForThreeActivity.this.getResources().getString(2131886652));
                DialogUtils.b(LoginV1ForThreeActivity.this.i);
                LoginV1ForThreeActivity.this.finish();
                return false;
            }
        }
    });
    private BluedUIHttpResponse n = new BluedUIHttpResponse<BluedEntity<BluedLoginResult, AVConfigExtra>>() { // from class: com.soft.blued.ui.login_register.LoginV1ForThreeActivity.3
        public boolean onUIFailure(int i, String str, String str2) {
            switch (i) {
                case 4035009:
                    String a2 = LoginRegisterTools.a(LoginV1ForThreeActivity.this.e, LoginV1ForThreeActivity.this.f, "weixin");
                    Bundle bundle = new Bundle();
                    String token = LoginRegisterTools.d(str2).getToken();
                    String login_mobile = LoginRegisterTools.d(str2).getLogin_mobile();
                    String relation_mobile = LoginRegisterTools.d(str2).getRelation_mobile();
                    String login_email = LoginRegisterTools.d(str2).getLogin_email();
                    String safe_email = LoginRegisterTools.d(str2).getSafe_email();
                    bundle.putString("token", token);
                    bundle.putString("login_mobile", login_mobile);
                    bundle.putString("relation_mobile", relation_mobile);
                    bundle.putString("login_email", login_email);
                    bundle.putString("safe_email", safe_email);
                    bundle.putString("password", "");
                    bundle.putString("login_type", "third");
                    bundle.putString("login_account", a2);
                    bundle.putString("key_uid", LoginRegisterTools.d(str2).getUid());
                    bundle.putInt("target_type", 0);
                    if (!StringUtils.d(LoginV1ForThreeActivity.this.l)) {
                        bundle.putString("aliasUserId", LoginV1ForThreeActivity.this.l);
                    }
                    StartLoginVerifyFragment.a(LoginV1ForThreeActivity.this, bundle);
                    DialogUtils.b(LoginV1ForThreeActivity.this.i);
                    LoginV1ForThreeActivity.this.finish();
                    return true;
                case 4036005:
                case 4036501:
                    try {
                        BluedEntityA bluedEntityA = (BluedEntityA) AppInfo.f().fromJson(str2, new TypeToken<BluedEntityA<BluedLoginResult>>() { // from class: com.soft.blued.ui.login_register.LoginV1ForThreeActivity.3.4
                        }.getType());
                        if (bluedEntityA != null && bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                            BluedLoginResult bluedLoginResult = (BluedLoginResult) bluedEntityA.data.get(0);
                            AccountLockedFragment.a(LoginV1ForThreeActivity.this, bluedLoginResult.reason, bluedLoginResult.uid);
                        }
                    } catch (Exception e) {
                    }
                    DialogUtils.b(LoginV1ForThreeActivity.this.i);
                    LoginV1ForThreeActivity.this.finish();
                    return true;
                case 4036300:
                    try {
                        Gson f = AppInfo.f();
                        BluedEntityA bluedEntityA2 = (BluedEntityA) f.fromJson(str2, new TypeToken<BluedEntityA<BluedCheckResult>>() { // from class: com.soft.blued.ui.login_register.LoginV1ForThreeActivity.3.1
                        }.getType());
                        if (bluedEntityA2 == null || bluedEntityA2.data == null || bluedEntityA2.data.size() <= 0) {
                            return true;
                        }
                        String a3 = AesCrypto2.a(((BluedCheckResult) bluedEntityA2.data.get(0)).getEncrypted());
                        Logger.b(LoginV1ForThreeActivity.this.f17719c, "解密：deData===", a3);
                        final BluedCheckResult bluedCheckResult = (BluedCheckResult) f.fromJson(a3, (Class<Object>) BluedCheckResult.class);
                        if ("plat_weixin".endsWith(LoginV1ForThreeActivity.this.d)) {
                            LoginV1ForThreeActivity.this.e = bluedCheckResult.getThirdToken();
                            LoginV1ForThreeActivity.this.f = bluedCheckResult.getThirdUid();
                        }
                        if (bluedCheckResult != null) {
                            if (!StringUtils.d(LoginV1ForThreeActivity.this.l)) {
                                CommonAlertDialog.a(LoginV1ForThreeActivity.this, (String) null, LoginV1ForThreeActivity.this.getResources().getString(R.string.bind_account_register), LoginV1ForThreeActivity.this.getResources().getString(R.string.continue_register), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.LoginV1ForThreeActivity.3.2
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                        Tracker.onClick(dialogInterface, i2);
                                        dialogInterface.dismiss();
                                        LoginV1ForThreeActivity.this.b(bluedCheckResult.getToken());
                                        DialogUtils.b(LoginV1ForThreeActivity.this.i);
                                        LoginV1ForThreeActivity.this.finish();
                                    }
                                }, LoginV1ForThreeActivity.this.getResources().getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.LoginV1ForThreeActivity.3.3
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                        Tracker.onClick(dialogInterface, i2);
                                        dialogInterface.dismiss();
                                        DialogUtils.b(LoginV1ForThreeActivity.this.i);
                                        LoginV1ForThreeActivity.this.finish();
                                    }
                                }, (DialogInterface.OnDismissListener) null);
                                return true;
                            }
                            LoginV1ForThreeActivity.this.b(bluedCheckResult.getToken());
                            DialogUtils.b(LoginV1ForThreeActivity.this.i);
                            LoginV1ForThreeActivity.this.finish();
                            return true;
                        }
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return true;
                    }
                default:
                    DialogUtils.b(LoginV1ForThreeActivity.this.i);
                    LoginV1ForThreeActivity.this.finish();
                    return super.onUIFailure(i, str);
            }
        }

        public void onUIFinish() {
        }

        public void onUIStart() {
            DialogUtils.a(LoginV1ForThreeActivity.this.i);
        }

        public void onUIUpdate(BluedEntity<BluedLoginResult, AVConfigExtra> bluedEntity) {
            try {
                boolean z = false;
                Logger.b(LoginV1ForThreeActivity.this.f17719c + "===success", "===responseJson:", bluedEntity);
                if (bluedEntity.data.size() > 0 && bluedEntity.data.get(0) != null) {
                    if (bluedEntity.extra != null) {
                        AVConfig.a().a(((AVConfigExtra) bluedEntity.extra).f6932a, false);
                    }
                    BluedLoginResult bluedLoginResult = (BluedLoginResult) bluedEntity.data.get(0);
                    String str = "";
                    if ("plat_weixin".endsWith(LoginV1ForThreeActivity.this.d)) {
                        if (StringUtils.g(bluedLoginResult.getUid())) {
                            LoginV1ForThreeActivity.this.e = bluedLoginResult.getThird_access_token();
                            LoginV1ForThreeActivity.this.f = bluedLoginResult.getThird_user_id();
                            LoginV1ForThreeActivity.g(LoginV1ForThreeActivity.this);
                            Logger.b(LoginV1ForThreeActivity.this.f17719c, "===request time:", Integer.valueOf(LoginV1ForThreeActivity.this.k));
                            if (LoginV1ForThreeActivity.this.k <= 2) {
                                LoginRegisterHttpUtils.a(LoginV1ForThreeActivity.this.n, LoginV1ForThreeActivity.this.e, LoginV1ForThreeActivity.this.f, (String) null, "weixin", false);
                                return;
                            }
                            return;
                        }
                        str = LoginRegisterTools.a(LoginV1ForThreeActivity.this.e, LoginV1ForThreeActivity.this.f, "weixin");
                    }
                    Logger.b(LoginV1ForThreeActivity.this.f17719c, "accountJson===", str);
                    UserInfo.getInstance().saveUserInfo(str, 2, LoginV1ForThreeActivity.this.h, bluedLoginResult, new String[]{LoginV1ForThreeActivity.this.l});
                    if (!StringUtils.d(LoginV1ForThreeActivity.this.l)) {
                        UserAccountsVDao.a().c(LoginV1ForThreeActivity.this.l);
                    }
                    PushManager.a().d();
                    if (bluedLoginResult.getDevice_safe() == 1) {
                        z = true;
                    }
                    BluedPreferences.J(z);
                    EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_SUCCESS, LoginAndRegisterProtos.Source.WECHAT, bluedLoginResult.uid);
                    if (bluedLoginResult == null || bluedLoginResult.getNeedAdultVerify() != 1) {
                        Bundle bundle = new Bundle();
                        bundle.putString("from_tag_page", "from_tag_login");
                        HomeArgumentHelper.a((Context) LoginV1ForThreeActivity.this, (String) null, bundle);
                    } else {
                        AdultVerifyFragment.a((Context) LoginV1ForThreeActivity.this);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                AppMethods.a(AppInfo.d().getResources().getString(2131887272));
            }
            if (!"plat_weixin".endsWith(LoginV1ForThreeActivity.this.d)) {
                DialogUtils.b(LoginV1ForThreeActivity.this.i);
                LoginV1ForThreeActivity.this.finish();
            } else if (LoginV1ForThreeActivity.this.k >= 2) {
                DialogUtils.b(LoginV1ForThreeActivity.this.i);
                LoginV1ForThreeActivity.this.finish();
            }
        }

        public BluedEntity<BluedLoginResult, AVConfigExtra> parseData(String str) {
            LoginV1ForThreeActivity.this.h = str;
            BluedEntity<BluedLoginResult, AVConfigExtra> parseData = super.parseData(str);
            if (parseData != null) {
                try {
                    if (parseData.data != null && parseData.data.size() > 0) {
                        String a2 = AesCrypto2.a(((BluedLoginResult) parseData.data.get(0)).getEncrypted());
                        Logger.b(LoginV1ForThreeActivity.this.f17719c, "解密：deData===", a2);
                        parseData.data.set(0, (BluedLoginResult) AppInfo.f().fromJson(a2, (Class<Object>) BluedLoginResult.class));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (!StringUtils.d(str)) {
            this.k++;
            LoginRegisterHttpUtils.a(this.n, (String) null, (String) null, str, "weixin", false);
            return;
        }
        ToastUtils.a(getResources().getString(2131886653));
        DialogUtils.b(this.i);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(String str) {
        FinishProfile1Fragment.f6934a.a(this, str, this.g, this.d, this.e, this.f, this.l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        UserRelationshipUtils.a(new Runnable() { // from class: com.soft.blued.ui.login_register.LoginV1ForThreeActivity.2
            @Override // java.lang.Runnable
            public void run() {
                LiveEventBus.get(EventBusConstant.KEY_EVENT_HIDE_LOGIN_BACK).post(null);
                UserAccountsVDao.a().i();
                LoginV1ForThreeActivity loginV1ForThreeActivity = LoginV1ForThreeActivity.this;
                loginV1ForThreeActivity.a(loginV1ForThreeActivity.j);
            }
        }, "bind_Acc");
    }

    static /* synthetic */ int g(LoginV1ForThreeActivity loginV1ForThreeActivity) {
        int i = loginV1ForThreeActivity.k;
        loginV1ForThreeActivity.k = i + 1;
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void g() {
        this.i = DialogUtils.a(this);
    }

    private void h() {
        if (getIntent() == null) {
            finish();
            return;
        }
        String stringExtra = getIntent().getStringExtra("from_three_plat");
        this.d = stringExtra;
        try {
            if (!"plat_weixin".endsWith(stringExtra)) {
                finish();
                return;
            }
            i();
            Bundle bundleExtra = getIntent().getBundleExtra("fragment_args");
            if (bundleExtra != null) {
                this.l = bundleExtra.getString("aliasUserId");
            }
        } catch (Exception e) {
            finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i() {
        if (!Util.isClientAvailable(this, "com.tencent.mm")) {
            AppMethods.d(2131892807);
            finish();
            return;
        }
        DialogUtils.a(this.i);
        WXProvider.a().a(new WXProvider.ILoginCallback() { // from class: com.soft.blued.ui.login_register.LoginV1ForThreeActivity.4
            @Override // com.soft.blued.wxapi.WXProvider.ILoginCallback
            public void a() {
                LoginV1ForThreeActivity.this.m.sendEmptyMessage(5);
            }

            @Override // com.soft.blued.wxapi.WXProvider.ILoginCallback
            public void a(WXLoginBean wXLoginBean) {
                Message obtain = Message.obtain();
                obtain.what = 4;
                obtain.obj = wXLoginBean;
                LoginV1ForThreeActivity.this.m.sendMessage(obtain);
            }

            @Override // com.soft.blued.wxapi.WXProvider.ILoginCallback
            public void b() {
                LoginV1ForThreeActivity.this.m.sendEmptyMessage(6);
            }
        });
        WXProvider.a().a((Context) this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(new FrameLayout(this));
        g();
        h();
    }
}
