package com.soft.blued.ui.find.contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.find.model.ImmediateTabModel;
import com.soft.blued.ui.find.model.ImmediateUserModel;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/contract/ImmediateDetailContract.class */
public interface ImmediateDetailContract {

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/contract/ImmediateDetailContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/contract/ImmediateDetailContract$IView.class */
    public interface IView extends BaseView<IPresenter> {
        int a();

        void a(int i);

        void a(ImmediateTabModel immediateTabModel);

        void a(ImmediateUserModel immediateUserModel);

        void b();

        void b(int i);

        void c();
    }
}
