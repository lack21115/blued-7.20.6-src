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
    private View f19706a;
    private TextView b;

    private void a() {
        TextView textView = (TextView) this.f19706a.findViewById(R.id.btn_lock_pattern_create);
        this.b = textView;
        textView.setOnClickListener(this);
    }

    private void b() {
        CommonTopTitleNoTrans findViewById = this.f19706a.findViewById(R.id.top_title);
        findViewById.a();
        findViewById.setTitleBackgroundDrawable(2131101191);
        findViewById.setCenterText(getString(R.string.lock_pattern_title));
        findViewById.setLeftClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131362602) {
            TerminalActivity.d(getActivity(), LockPatternSetupFragment.class, (Bundle) null);
            getActivity().finish();
        } else if (id != 2131363120) {
        } else {
            getActivity().finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.f19706a;
        if (view == null) {
            this.f19706a = layoutInflater.inflate(R.layout.fragment_lock_pattern_create, viewGroup, false);
            a();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f19706a.getParent()).removeView(this.f19706a);
        }
        return this.f19706a;
    }
}
