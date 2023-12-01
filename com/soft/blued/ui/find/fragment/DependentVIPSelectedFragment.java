package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/DependentVIPSelectedFragment.class */
public class DependentVIPSelectedFragment extends MvpFragment {
    @BindView
    CommonTopTitleNoTrans title;

    public static void a(Context context) {
        TerminalActivity.d(context, DependentVIPSelectedFragment.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        getActivity().finish();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.title.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$DependentVIPSelectedFragment$vJETfRoMuPgG4wgWdXcYhWAHX3c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DependentVIPSelectedFragment.this.a(view);
            }
        });
        this.title.a();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_dependent_vip_selected;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        NearbyPeopleTabPageVIPFragment i = NearbyPeopleTabPageVIPFragment.i();
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(2131363059, i);
        beginTransaction.commitAllowingStateLoss();
    }
}
