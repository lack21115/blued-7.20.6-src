package com.soft.blued.ui.setting.Contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.blued.android.module.common.user.model.VerifyStatus;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/SettingContract.class */
public class SettingContract {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/SettingContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
        void b();

        void c();
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/SettingContract$IView.class */
    public interface IView extends BaseView<IPresenter> {
        void a();

        void a(VerifyStatus[] verifyStatusArr);

        void a(VerifyStatus[] verifyStatusArr, String str, String str2, String str3, String str4);
    }
}
