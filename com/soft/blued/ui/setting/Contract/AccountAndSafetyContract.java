package com.soft.blued.ui.setting.Contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/AccountAndSafetyContract.class */
public interface AccountAndSafetyContract {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/AccountAndSafetyContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
        void b();

        void c();
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/AccountAndSafetyContract$IView.class */
    public interface IView extends BaseView<IPresenter> {
        void a();

        void a(String str);

        void b();

        void b(String str);
    }
}
