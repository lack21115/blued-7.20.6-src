package com.soft.blued.ui.setting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/LockPatternCreateFragment.class */
public class LockPatternCreateFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private View f33397a;
    private TextView b;

    private void a() {
        TextView textView = (TextView) this.f33397a.findViewById(R.id.btn_lock_pattern_create);
        this.b = textView;
        textView.setOnClickListener(this);
    }

    private void b() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.f33397a.findViewById(2131370749);
        commonTopTitleNoTrans.a();
        commonTopTitleNoTrans.setTitleBackgroundDrawable(2131101191);
        commonTopTitleNoTrans.setCenterText(getString(R.string.lock_pattern_title));
        commonTopTitleNoTrans.setLeftClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131362602) {
            TerminalActivity.d(getActivity(), LockPatternSetupFragment.class, null);
            getActivity().finish();
        } else if (id != 2131363120) {
        } else {
            getActivity().finish();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.f33397a;
        if (view == null) {
            this.f33397a = layoutInflater.inflate(R.layout.fragment_lock_pattern_create, viewGroup, false);
            a();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f33397a.getParent()).removeView(this.f33397a);
        }
        return this.f33397a;
    }
}
