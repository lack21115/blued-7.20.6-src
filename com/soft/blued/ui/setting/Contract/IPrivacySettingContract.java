package com.soft.blued.ui.setting.Contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/IPrivacySettingContract.class */
public class IPrivacySettingContract {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/IPrivacySettingContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
        void a(boolean z);

        void a(boolean z, boolean z2);

        void b();

        void c();
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/IPrivacySettingContract$IView.class */
    public interface IView extends BaseView<IPresenter> {
        boolean D();

        boolean E();

        void a(String str, String str2);

        void b(boolean z, String str);

        void f(boolean z);

        void g(boolean z);

        void h(boolean z);

        void i(boolean z);

        void j(boolean z);

        void k(boolean z);

        void l(boolean z);

        void m(boolean z);

        void n(boolean z);

        void o(boolean z);
    }
}
