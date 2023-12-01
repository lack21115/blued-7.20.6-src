package com.blued.community.ui.circle.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.utils.CommunityPreferences;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/presenter/CircleJoinSettingPresenter.class */
public class CircleJoinSettingPresenter extends MvpPresenter {
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

    public void d(final String str) {
        CircleHttpUtils.c(new BluedUIHttpResponse(g()) { // from class: com.blued.community.ui.circle.presenter.CircleJoinSettingPresenter.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                CommunityPreferences.a(str.equals("1"));
            }
        }, m(), str, g());
    }

    public String m() {
        return this.h.circle_id;
    }
}
