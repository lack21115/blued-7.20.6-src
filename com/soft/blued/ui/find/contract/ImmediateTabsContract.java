package com.soft.blued.ui.find.contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.find.model.ImmediateTabModel;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/contract/ImmediateTabsContract.class */
public interface ImmediateTabsContract {

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/contract/ImmediateTabsContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/contract/ImmediateTabsContract$IView.class */
    public interface IView extends BaseView<IPresenter> {
        void a(List<ImmediateTabModel.Tab> list);
    }
}
