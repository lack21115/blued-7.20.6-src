package com.soft.blued.ui.user.contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.user.model.PictureTabModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/contract/InterestGalleryContract.class */
public class InterestGalleryContract {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/contract/InterestGalleryContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/contract/InterestGalleryContract$IView.class */
    public interface IView extends BaseView<IPresenter> {
        void a();

        void a(List<PictureTabModel> list);
    }
}
