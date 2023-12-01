package com.soft.blued.ui.login_register.Contract;

import android.content.Context;
import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.http.LoginRegisterHttpUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/Contract/LoginWithTypeContract.class */
public class LoginWithTypeContract {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/Contract/LoginWithTypeContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
        void a(Context context, String str, String str2, String str3);

        void a(LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE phone_code_login_stage, String str, String str2);

        void a(LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE phone_code_login_stage, String str, String str2, String str3);

        void a(String str);

        void a(String str, String str2, String str3, String str4, String str5);

        void a(boolean z);

        String b();

        void b(String str);

        String c();

        String d();
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/Contract/LoginWithTypeContract$IView.class */
    public interface IView extends BaseView<IPresenter> {
        void a();

        void a(String str);

        void a(String str, String str2);

        void a(String str, boolean z);

        void a(boolean z);

        void b();

        void c();

        void d();

        int e();

        void f();

        void g();

        void h();
    }
}
