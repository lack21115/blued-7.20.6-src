package com.soft.blued.ui.home;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/HomeContract.class */
public class HomeContract {

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/HomeContract$Presenter.class */
    interface Presenter extends BasePresenter {
        void a(boolean z);

        @Override // com.blued.android.framework.mvp_similarity.BasePresenter
        void ar_();

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/HomeContract$TabRefresh.class */
    public enum TabRefresh {
        DEFAULT,
        NOT_REFRESH,
        FORCE_REFRESH
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/HomeContract$View.class */
    public interface View extends BaseView<Presenter> {
        void a(String str, int i);

        void b(String str, int i);

        boolean b(String str);

        void c(String str);

        void d(String str);

        void e(String str);

        void f(String str);

        void g(String str);
    }
}
