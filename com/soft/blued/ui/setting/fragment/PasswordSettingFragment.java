package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/PasswordSettingFragment.class */
public class PasswordSettingFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private View f19827a;
    private Dialog b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f19828c;
    private LinearLayout d;
    private LinearLayout e;
    private LinearLayout f;
    private Context g;

    protected void a() {
        CommonTopTitleNoTrans findViewById = this.f19827a.findViewById(R.id.top_title);
        findViewById.a();
        findViewById.setCenterText(getString(R.string.Live_setting_passwordSetting));
        findViewById.setLeftClickListener(this);
    }

    protected void b() {
        LinearLayout linearLayout = (LinearLayout) this.f19827a.findViewById(R.id.ll_modify_pwd);
        this.d = linearLayout;
        linearLayout.setOnClickListener(this);
        if (!UserInfo.getInstance().isBindPhone()) {
            this.d.setVisibility(8);
        }
        LinearLayout linearLayout2 = (LinearLayout) this.f19827a.findViewById(R.id.ll_pay_setting);
        this.e = linearLayout2;
        linearLayout2.setOnClickListener(this);
        this.b = DialogUtils.a(getActivity());
        LinearLayout linearLayout3 = (LinearLayout) this.f19827a.findViewById(R.id.ll_lock_pattern_set);
        this.f = linearLayout3;
        linearLayout3.setOnClickListener(this);
        this.f19828c = (TextView) this.f19827a.findViewById(R.id.tv_lock_pattern_set);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131363120:
                getActivity().finish();
                return;
            case R.id.ll_lock_pattern_set /* 2131367993 */:
                EventTrackSettings.a(SettingsProtos.Event.GESTURE_PWD_SETTINGS_CLICK);
                if (StringUtils.d(BluedPreferences.bb())) {
                    TerminalActivity.d(getActivity(), LockPatternCreateFragment.class, (Bundle) null);
                    return;
                } else {
                    TerminalActivity.d(getActivity(), GestureLockSettingFragment.class, (Bundle) null);
                    return;
                }
            case R.id.ll_modify_pwd /* 2131368033 */:
                EventTrackSettings.a(SettingsProtos.Event.ACCOUNT_PWD_SETTINGS_CLICK);
                TerminalActivity.d(getActivity(), ResetPwdFragment.class, (Bundle) null);
                return;
            case R.id.ll_pay_setting /* 2131368123 */:
                EventTrackSettings.a(SettingsProtos.Event.PAY_PWD_SETTINGS_CLICK);
                TerminalActivity.d(getActivity(), PayPasswordSettingFragment.class, (Bundle) null);
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.g = getActivity();
        View view = this.f19827a;
        if (view == null) {
            this.f19827a = layoutInflater.inflate(R.layout.fragment_password_settings, viewGroup, false);
            a();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f19827a.getParent()).removeView(this.f19827a);
        }
        return this.f19827a;
    }

    public void onResume() {
        super.onResume();
        if (StringUtils.d(BluedPreferences.bb())) {
            BluedPreferences.E(false);
            this.f19828c.setText(getResources().getText(R.string.lock_pattern_not_set));
            this.f19828c.setTextColor(BluedSkinUtils.a(this.g, 2131102254));
        } else if (BluedPreferences.aY()) {
            this.f19828c.setText(getResources().getText(R.string.lock_pattern_set_on));
            this.f19828c.setTextColor(BluedSkinUtils.a(this.g, 2131101766));
        } else {
            this.f19828c.setText(getResources().getText(R.string.lock_pattern_set_off));
            this.f19828c.setTextColor(BluedSkinUtils.a(this.g, 2131102254));
        }
    }
}
