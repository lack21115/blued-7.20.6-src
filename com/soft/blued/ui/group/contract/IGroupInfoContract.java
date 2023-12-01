package com.soft.blued.ui.group.contract;

import android.os.Bundle;
import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.group.model.BluedCreatedGroupInfo;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/contract/IGroupInfoContract.class */
public class IGroupInfoContract {

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/contract/IGroupInfoContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/contract/IGroupInfoContract$IView.class */
    public interface IView extends BaseView<IPresenter> {
        Bundle a();

        void a(BluedCreatedGroupInfo bluedCreatedGroupInfo);

        void a(String str);

        void a(boolean z);

        void a(String[] strArr);

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();
    }
}
