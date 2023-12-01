package com.soft.blued.ui.setting.Contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.setting.model.DeviceModel;
import com.soft.blued.ui.setting.model.LoginProtectionModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/LoginDeviceListContract.class */
public interface LoginDeviceListContract {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/LoginDeviceListContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
        void a(String str, String str2);

        List<DeviceModel> b();
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/LoginDeviceListContract$IView.class */
    public interface IView extends BaseView<IPresenter> {
        void a();

        void a(LoginProtectionModel loginProtectionModel);

        void a(String str);

        void a(boolean z);

        void b();

        void c();
    }
}
