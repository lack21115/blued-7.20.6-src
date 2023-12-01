package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.setting.Contract.IPrivacySettingContract;
import com.soft.blued.ui.setting.Presenter.PrivacySettingPresenter;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/MapFinderSettingFragment.class */
public class MapFinderSettingFragment extends BaseFragment implements IPrivacySettingContract.IView {

    /* renamed from: a  reason: collision with root package name */
    private Context f19725a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private ToggleButton f19726c;
    private IPrivacySettingContract.IPresenter d;

    public static void a(Context context) {
        TerminalActivity.d(context, MapFinderSettingFragment.class, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.d.a(this.f19726c.isChecked());
        getActivity().finish();
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public boolean D() {
        return false;
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public boolean E() {
        return false;
    }

    public void a() {
        CommonTopTitleNoTrans findViewById = this.b.findViewById(R.id.top_title);
        findViewById.a();
        findViewById.setCenterText(getString(R.string.map_finder));
        findViewById.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.MapFinderSettingFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                MapFinderSettingFragment.this.b();
            }
        });
        ToggleButton toggleButton = (ToggleButton) this.b.findViewById(R.id.tglbtn_map_finder_onoff);
        this.f19726c = toggleButton;
        toggleButton.setChecked(true);
        this.d.c();
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void a(String str, String str2) {
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void b(boolean z, String str) {
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void f(boolean z) {
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void g(boolean z) {
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void h(boolean z) {
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void i(boolean z) {
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void j(boolean z) {
        this.f19726c.setChecked(z);
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void k(boolean z) {
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void l(boolean z) {
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void m(boolean z) {
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void n(boolean z) {
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void o(boolean z) {
    }

    public boolean onBackPressed() {
        b();
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_map_finder_setting, viewGroup, false);
            this.f19725a = getActivity();
            this.d = new PrivacySettingPresenter(getActivity(), getFragmentActive(), this);
            a();
            this.d.b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
