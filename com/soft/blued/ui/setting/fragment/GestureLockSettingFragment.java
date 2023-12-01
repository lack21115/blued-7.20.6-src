package com.soft.blued.ui.setting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/GestureLockSettingFragment.class */
public class GestureLockSettingFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private View f19689a;
    private LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f19690c;
    private ToggleButton d;

    private void a() {
        this.b = (LinearLayout) this.f19689a.findViewById(R.id.ll_lock_pattern_reset);
        this.f19690c = (TextView) this.f19689a.findViewById(R.id.tv_lock_pattern_reset);
        this.d = (ToggleButton) this.f19689a.findViewById(R.id.tglbtn_pattern_lock_onoff);
        this.b.setOnClickListener(this);
        if (BluedPreferences.aY()) {
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
        this.d.setChecked(BluedPreferences.aY());
        this.d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.setting.fragment.GestureLockSettingFragment.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                BluedPreferences.F(z);
                if (!z) {
                    GestureLockSettingFragment.this.b.setVisibility(8);
                } else if (!StringUtils.d(BluedPreferences.bb())) {
                    GestureLockSettingFragment.this.b.setVisibility(0);
                } else {
                    BluedPreferences.F(false);
                    GestureLockSettingFragment.this.b.setVisibility(8);
                    TerminalActivity.d(GestureLockSettingFragment.this.getActivity(), LockPatternSetupFragment.class, (Bundle) null);
                    GestureLockSettingFragment.this.getActivity().finish();
                }
            }
        });
    }

    private void b() {
        CommonTopTitleNoTrans findViewById = this.f19689a.findViewById(R.id.top_title);
        findViewById.a();
        findViewById.f();
        findViewById.setCenterText(getString(R.string.lock_pattern_title));
        findViewById.setLeftClickListener(this);
    }

    private void c() {
        getActivity().setResult(-1);
        getActivity().finish();
    }

    public boolean onBackPressed() {
        c();
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            c();
        } else if (id != 2131367992) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("FRAGMENT_NAME_KEY", GestureLockSettingFragment.class.getSimpleName());
            TerminalActivity.d(getActivity(), LockPatternSetupFragment.class, bundle);
            getActivity().finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.f19689a;
        if (view == null) {
            this.f19689a = layoutInflater.inflate(R.layout.fragment_gesture_lock_setting, viewGroup, false);
            a();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f19689a.getParent()).removeView(this.f19689a);
        }
        return this.f19689a;
    }
}
