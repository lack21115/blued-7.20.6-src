package com.soft.blued.ui.live.contract;

import com.blued.android.module.live_china.model.BannerModel;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.BluedLiveState;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/contract/LiveListContract.class */
public class LiveListContract {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/contract/LiveListContract$IPresenter.class */
    public interface IPresenter {
        BluedLiveState a();

        void a(IView iView);

        void a(boolean z);

        void b();

        void c();

        int d();

        void e();

        void f();
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/contract/LiveListContract$IView.class */
    public interface IView {
        void a();

        void a(int i);

        void a(List<BannerModel> list);

        void a(List<BluedLiveListData> list, boolean z);

        void b();

        void c();

        void d();

        void e();
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/contract/LiveListContract$ServicePresenter.class */
    public interface ServicePresenter {
    }
}
