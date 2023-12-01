package com.soft.blued.ui.user.contract;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.user.model.ServiceMenuModel;
import com.soft.blued.ui.user.model.UserInfoEntity;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/contract/IUserInfoNewContract.class */
public class IUserInfoNewContract {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/contract/IUserInfoNewContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/contract/IUserInfoNewContract$IView.class */
    public interface IView extends BaseView<IPresenter> {
        void a(UserInfoEntity userInfoEntity);

        void a(UserInfoEntity userInfoEntity, int i);

        void a(List<ServiceMenuModel> list);

        void a(List<UserFindResult> list, boolean z);

        boolean a();

        void b();

        void b(UserInfoEntity userInfoEntity);

        IRequestHost c();

        void c(UserInfoEntity userInfoEntity);

        void d();
    }
}
