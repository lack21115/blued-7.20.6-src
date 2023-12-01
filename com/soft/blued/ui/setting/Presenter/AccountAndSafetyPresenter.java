package com.soft.blued.ui.setting.Presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.user.model.BluedLoginResultVerBinding;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.setting.Contract.AccountAndSafetyContract;
import com.soft.blued.ui.setting.model.WechatModel;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.wxapi.WXLoginBean;
import com.soft.blued.wxapi.WXProvider;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Presenter/AccountAndSafetyPresenter.class */
public class AccountAndSafetyPresenter implements AccountAndSafetyContract.IPresenter {

    /* renamed from: a  reason: collision with root package name */
    private Context f33210a;
    private AccountAndSafetyContract.IView b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f33211c;
    private BluedUIHttpResponse d;
    private BluedUIHttpResponse e;

    public AccountAndSafetyPresenter(Context context, AccountAndSafetyContract.IView iView, IRequestHost iRequestHost) {
        this.d = new BluedUIHttpResponse<BluedEntityA<WechatModel>>(this.f33211c) { // from class: com.soft.blued.ui.setting.Presenter.AccountAndSafetyPresenter.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<WechatModel> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                String str = bluedEntityA.data.get(0).status;
                if (TextUtils.equals(str, "0")) {
                    CommonAlertDialog.a(AccountAndSafetyPresenter.this.f33210a, (String) null, AccountAndSafetyPresenter.this.f33210a.getString(2131892800), AccountAndSafetyPresenter.this.f33210a.getString(2131886752), (String) null, (View.OnClickListener) null, (View.OnClickListener) null);
                } else if (TextUtils.equals(str, "1")) {
                    UserInfo.getInstance().setBoundWechat("1");
                    AccountAndSafetyPresenter.this.e();
                    AppMethods.a((CharSequence) AccountAndSafetyPresenter.this.f33210a.getString(2131892799));
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                AccountAndSafetyPresenter.this.b.b();
            }
        };
        this.e = new BluedUIHttpResponse<BluedEntityA<WechatModel>>(this.f33211c) { // from class: com.soft.blued.ui.setting.Presenter.AccountAndSafetyPresenter.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<WechatModel> bluedEntityA) {
                BluedLoginResultVerBinding verified_bindings;
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                String str = bluedEntityA.data.get(0).status;
                if (!TextUtils.equals(str, "0") && TextUtils.equals(str, "1")) {
                    AppMethods.a((CharSequence) AccountAndSafetyPresenter.this.f33210a.getString(2131892804));
                }
                UserInfo.getInstance().setBoundWechat("");
                if (UserInfo.getInstance().getLoginUserInfo() != null && (verified_bindings = UserInfo.getInstance().getLoginUserInfo().getVerified_bindings()) != null) {
                    verified_bindings.third_weixin = "";
                }
                AccountAndSafetyPresenter.this.e();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                AccountAndSafetyPresenter.this.b.b();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                AccountAndSafetyPresenter.this.b.a();
            }
        };
        this.f33210a = context;
        this.b = iView;
        this.f33211c = iRequestHost;
    }

    @Override // com.blued.android.framework.mvp_similarity.BasePresenter
    public void ar_() {
        d();
        e();
    }

    @Override // com.soft.blued.ui.setting.Contract.AccountAndSafetyContract.IPresenter
    public void b() {
        this.b.a();
        LiveFloatManager.a().l();
        WXProvider.a().a(new WXProvider.ILoginCallback() { // from class: com.soft.blued.ui.setting.Presenter.AccountAndSafetyPresenter.1
            @Override // com.soft.blued.wxapi.WXProvider.ILoginCallback
            public void a() {
                LiveFloatManager.a().k();
                AccountAndSafetyPresenter.this.b.b();
                ToastUtils.a(AccountAndSafetyPresenter.this.f33210a.getString(2131886653));
            }

            @Override // com.soft.blued.wxapi.WXProvider.ILoginCallback
            public void a(WXLoginBean wXLoginBean) {
                if (wXLoginBean != null) {
                    LoginRegisterHttpUtils.a(AccountAndSafetyPresenter.this.d, 1, wXLoginBean.code, AccountAndSafetyPresenter.this.f33211c);
                } else {
                    AccountAndSafetyPresenter.this.b.b();
                }
                LiveFloatManager.a().k();
            }

            @Override // com.soft.blued.wxapi.WXProvider.ILoginCallback
            public void b() {
                LiveFloatManager.a().k();
                AccountAndSafetyPresenter.this.b.b();
                ToastUtils.a(AccountAndSafetyPresenter.this.f33210a.getString(2131886653));
            }
        });
        WXProvider.a().a(this.f33210a);
    }

    @Override // com.soft.blued.ui.setting.Contract.AccountAndSafetyContract.IPresenter
    public void c() {
        if (!StringUtils.d(LoginRegisterTools.b())) {
            LoginRegisterHttpUtils.a(this.e, 2, "", this.f33211c);
            return;
        }
        Context context = this.f33210a;
        CommonAlertDialog.a(context, (String) null, context.getString(2131892802), this.f33210a.getString(2131886752), (String) null, (View.OnClickListener) null, (View.OnClickListener) null);
    }

    public void d() {
        this.b.b(LoginRegisterTools.d());
    }

    public void e() {
        this.b.a(LoginRegisterTools.c());
    }
}
