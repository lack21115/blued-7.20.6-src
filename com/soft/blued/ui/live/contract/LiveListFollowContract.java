package com.soft.blued.ui.live.contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveRecommendModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/contract/LiveListFollowContract.class */
public class LiveListFollowContract {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/contract/LiveListFollowContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/contract/LiveListFollowContract$IView.class */
    public interface IView extends BaseView<IPresenter> {
        void a();

        void a(BluedLiveListData bluedLiveListData);

        void a(List<BluedLiveListData> list);

        void a(boolean z);

        void b();

        void b(List<LiveRecommendModel> list);

        void b(boolean z);

        void c();

        void c(List<LiveRecommendModel> list);

        void d();

        void e();

        void f();

        void g();

        void h();

        void i();

        void j();

        void k();
    }
}
