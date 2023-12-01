package com.soft.blued.ui.login_register.Contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/Contract/VerifyCodeContract.class */
public interface VerifyCodeContract {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/Contract/VerifyCodeContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
        void a(String str, int i);

        void a(String str, String str2, String str3, String str4, String str5, int i, String str6);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/Contract/VerifyCodeContract$IView.class */
    public interface IView extends BaseView<IPresenter> {
        void a();

        void b();

        void c();
    }
}
