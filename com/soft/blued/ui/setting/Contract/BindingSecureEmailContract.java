package com.soft.blued.ui.setting.Contract;

import android.os.Bundle;
import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/BindingSecureEmailContract.class */
public class BindingSecureEmailContract {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/BindingSecureEmailContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
        void a(String str, int i, String str2, String str3);

        String b();
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/BindingSecureEmailContract$IView.class */
    public interface IView extends BaseView<IPresenter> {
        void a();

        void a(Bundle bundle);

        void a(String str);

        void b();

        void c();

        void d();

        void e();
    }
}
