package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;
import butterknife.BindView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.setting.Presenter.MessageNotifyPresenter;
import com.soft.blued.utils.BluedPreferences;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/MessageNotifyFragment.class */
public class MessageNotifyFragment extends MvpFragment<MessageNotifyPresenter> implements CompoundButton.OnCheckedChangeListener {
    @BindView
    LinearLayout llMessageCommonLogin;
    @BindView
    LinearLayout llMessageMobileLogin;
    @BindView
    ToggleButton tbMessageCommonLogin;
    @BindView
    ToggleButton tbMessageMobileLogin;
    @BindView
    CommonTopTitleNoTrans topTitle;

    public static void a(Context context) {
        TerminalActivity.d(context, MessageNotifyFragment.class, null);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.topTitle.setCenterText(getResources().getString(R.string.message_remind));
        this.topTitle.a();
        this.topTitle.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.MessageNotifyFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                MessageNotifyFragment.this.getActivity().finish();
            }
        });
        this.llMessageMobileLogin.setVisibility(8);
        this.llMessageCommonLogin.setVisibility(8);
        boolean de2 = BluedPreferences.de();
        boolean df = BluedPreferences.df();
        if (de2) {
            this.llMessageMobileLogin.setVisibility(0);
        }
        if (df) {
            this.llMessageCommonLogin.setVisibility(0);
        }
        if (!de2 && !df) {
            this.llMessageMobileLogin.setVisibility(0);
            this.llMessageCommonLogin.setVisibility(0);
        }
        this.tbMessageMobileLogin.setChecked(BluedPreferences.cN());
        this.tbMessageCommonLogin.setChecked(BluedPreferences.cO());
        this.tbMessageMobileLogin.setOnCheckedChangeListener(this);
        this.tbMessageCommonLogin.setOnCheckedChangeListener(this);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_message_notify;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        String str;
        Tracker.onCheckedChanged(compoundButton, z);
        Map<String, String> a2 = BluedHttpTools.a();
        int id = compoundButton.getId();
        switch (id) {
            case R.id.tb_message_common_login /* 2131370587 */:
                BluedPreferences.S(z);
                str = z ? "1" : "0";
                a2.put("is_used_mobile_push", str);
                EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_MSG_USED_SWITCH_BTN_CLICK, z);
                break;
            case R.id.tb_message_mobile_login /* 2131370588 */:
                BluedPreferences.R(z);
                str = z ? "1" : "0";
                a2.put("is_verify_mobile_push", str);
                EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_MSG_LOGIN_SWITCH_BTN_CLICK, z);
                break;
            default:
                str = "";
                break;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        j().a(a2);
    }
}
