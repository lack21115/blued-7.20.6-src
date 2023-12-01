package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.live.presenter.LiveApplyVerifyPresenter;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveApplyVerifyFragment.class */
public class LiveApplyVerifyFragment extends MvpFragment<LiveApplyVerifyPresenter> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private BluedLiveState f31141a;
    private Context b;
    @BindView
    CommonTopTitleNoTrans top_title;
    @BindView
    TextView tv_tip_1;

    public static void a(Context context, BluedLiveState bluedLiveState) {
        Bundle bundle = new Bundle();
        if (bluedLiveState != null) {
            bundle.putSerializable("applyState", bluedLiveState);
        }
        TerminalActivity.d(context, LiveApplyVerifyFragment.class, bundle);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.top_title.f();
        this.top_title.a();
        this.top_title.setLeftImgDrawable(BluedSkinUtils.b(this.b, 2131233902));
        this.top_title.setCenterText(getString(2131886176));
        this.top_title.setLeftClickListener(this);
        BluedLiveState bluedLiveState = this.f31141a;
        if (bluedLiveState == null || bluedLiveState.is_easy_way != 0) {
            this.tv_tip_1.setText(getText(2131886156));
        } else {
            this.tv_tip_1.setText(getText(2131886157));
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_live_apply_verify;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131363120) {
            return;
        }
        getActivity().finish();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = getContext();
        if (getArguments() == null || getArguments().getSerializable("applyState") == null) {
            return;
        }
        this.f31141a = (BluedLiveState) getArguments().getSerializable("applyState");
    }
}
