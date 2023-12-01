package com.soft.blued.ui.msg.contract;

import android.app.Activity;
import android.content.Context;
import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.setting.Contract.IPrivacySettingContract;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/contract/IMsgContract.class */
public class IMsgContract {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/contract/IMsgContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/contract/IMsgContract$IView.class */
    public interface IView extends BaseView<IPrivacySettingContract.IPresenter> {
        Activity getActivity();

        Context getContext();
    }
}
