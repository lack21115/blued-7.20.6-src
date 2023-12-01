package com.blued.community.ui.circle.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/presenter/CircleTextVoteEditPresenter.class */
public class CircleTextVoteEditPresenter extends MvpPresenter {
    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        if (bundle != null) {
            a("title", bundle.getString("circle_vote_title"));
            a("content", (String) ((List) bundle.getSerializable("circle_vote_content")));
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }
}
