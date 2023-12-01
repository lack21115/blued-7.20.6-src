package com.soft.blued.ui.setting.Contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.setting.model.BluedBlackList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/IBlackListContract.class */
public class IBlackListContract {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/IBlackListContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
        void b();

        void c();

        void d();
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/IBlackListContract$IView.class */
    public interface IView extends BaseView<IPresenter> {
        void a();

        void a(List<BluedBlackList> list);

        void a(boolean z);

        void b();

        void b(List<BluedBlackList> list);

        void c();

        void d();

        void e();

        void f();
    }
}
