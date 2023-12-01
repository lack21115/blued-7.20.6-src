package com.soft.blued.sdk.ui;

import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/sdk/ui/SDKPayContract.class */
public class SDKPayContract {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/sdk/ui/SDKPayContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
        void a(String str);

        void a(boolean z);

        void b();

        void c();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/sdk/ui/SDKPayContract$IView.class */
    interface IView extends BaseView<IPresenter> {
        void a();

        void a(double d);

        void a(int i);

        void a(String str);

        void b();

        void b(String str);

        void c();

        void c(String str);

        void d();

        void e();

        void f();

        void g();

        ActivityFragmentActive getFragmentActive();

        void h();
    }
}
