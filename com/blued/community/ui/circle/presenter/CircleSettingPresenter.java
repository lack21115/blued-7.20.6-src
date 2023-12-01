package com.blued.community.ui.circle.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.community.ui.circle.model.MyCircleModel;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/presenter/CircleSettingPresenter.class */
public class CircleSettingPresenter extends MvpPresenter {
    private MyCircleModel h;

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        if (bundle != null) {
            this.h = (MyCircleModel) bundle.getSerializable("circle_data");
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    public MyCircleModel m() {
        return this.h;
    }

    public String n() {
        return this.h.circle_id;
    }
}
