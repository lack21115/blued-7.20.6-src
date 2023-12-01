package com.blued.android.module.live_china.contrast;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.blued.android.module.live_china.model.LiveRewardExtraModel;
import com.blued.android.module.live_china.model.LiveRewardListModel;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/contrast/LiveRewardDetailsContract.class */
public class LiveRewardDetailsContract {

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/contrast/LiveRewardDetailsContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/contrast/LiveRewardDetailsContract$IView.class */
    public interface IView extends BaseView<IPresenter> {
        void a(LiveRewardExtraModel liveRewardExtraModel);

        void a(List<LiveRewardListModel> list, boolean z);

        void c();

        void d();

        void e();
    }
}
