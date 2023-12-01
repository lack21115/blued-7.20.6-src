package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.share.Util;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.login_register.LinkMobileSuccessFragment;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.setting.Contract.AccountAndSafetyContract;
import com.soft.blued.ui.setting.Presenter.AccountAndSafetyPresenter;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/AccountAndSafetyFragment.class */
public class AccountAndSafetyFragment extends BaseFragment implements View.OnClickListener, AccountAndSafetyContract.IView {

    /* renamed from: a  reason: collision with root package name */
    private View f19627a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private AccountAndSafetyContract.IPresenter f19628c;
    private Dialog d;
    private TextView e;
    private TextView f;
    private TextView g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private LinearLayout k;
    private LinearLayout l;
    private LinearLayout m;
    private CommonTopTitleNoTrans n;
    private String o;

    public static void a(Context context) {
        TerminalActivity.d(context, AccountAndSafetyFragment.class, (Bundle) null);
    }

    private void c() {
        CommonTopTitleNoTrans findViewById = this.f19627a.findViewById(R.id.top_title);
        this.n = findViewById;
        findViewById.a();
        this.n.setLeftImg(2131233902);
        this.n.setCenterText(getString(R.string.account_and_safety));
        this.n.setLeftClickListener(this);
        this.h = (LinearLayout) this.f19627a.findViewById(R.id.ll_modify_pwd);
        this.i = (LinearLayout) this.f19627a.findViewById(R.id.ll_binding_mail);
        this.j = (LinearLayout) this.f19627a.findViewById(R.id.ll_binding_wechat);
        this.k = (LinearLayout) this.f19627a.findViewById(R.id.ll_remove_account);
        this.l = (LinearLayout) this.f19627a.findViewById(R.id.ll_login_protection);
        this.m = (LinearLayout) this.f19627a.findViewById(R.id.ll_binding_cellphone);
        this.e = (TextView) this.f19627a.findViewById(R.id.tv_binding_mail_status);
        this.f = (TextView) this.f19627a.findViewById(R.id.tv_binding_wechat_status);
        this.g = (TextView) this.f19627a.findViewById(R.id.tv_login_protection_status);
        this.d = DialogUtils.a(this.b);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        if (BluedConfig.a().p()) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
    }

    @Override // com.soft.blued.ui.setting.Contract.AccountAndSafetyContract.IView
    public void a() {
        DialogUtils.a(this.d);
    }

    @Override // com.soft.blued.ui.setting.Contract.AccountAndSafetyContract.IView
    public void a(String str) {
        this.o = str;
        if (TextUtils.isEmpty(str)) {
            this.f.setText(R.string.unbinded);
            this.f.setTextColor(getActivity().getResources().getColor(2131101201));
            return;
        }
        this.f.setText(R.string.Live_applyHost_beBindinged);
        this.f.setTextColor(getActivity().getResources().getColor(2131101206));
    }

    @Override // com.soft.blued.ui.setting.Contract.AccountAndSafetyContract.IView
    public void b() {
        DialogUtils.b(this.d);
    }

    @Override // com.soft.blued.ui.setting.Contract.AccountAndSafetyContract.IView
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.e.setText(R.string.unbinded);
            this.e.setTextColor(getActivity().getResources().getColor(2131101201));
            return;
        }
        if (BlueAppLocal.d()) {
            this.e.setText(str);
        } else {
            this.e.setText(ChatManager.context.getString(R.string.Live_applyHost_beBindinged));
        }
        this.e.setTextColor(getActivity().getResources().getColor(2131101206));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131363120:
                postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.AccountAndSafetyFragment.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AccountAndSafetyFragment.this.getActivity().finish();
                    }
                });
                return;
            case R.id.ll_binding_cellphone /* 2131367658 */:
                WebViewShowInfoFragment.show(this.b, H5Url.a(9), -1);
                return;
            case R.id.ll_binding_mail /* 2131367659 */:
                String d = LoginRegisterTools.d();
                Bundle bundle = new Bundle();
                bundle.putString(LoginRegisterTools.f, d);
                bundle.putInt(LoginRegisterTools.f17709a, 0);
                if (!TextUtils.isEmpty(d)) {
                    TerminalActivity.d(this.b, LinkMobileSuccessFragment.class, bundle);
                    return;
                }
                bundle.putString("binding_type", "add");
                TerminalActivity.d(this.b, BindingSecureEmailFragment.class, bundle);
                return;
            case R.id.ll_binding_wechat /* 2131367660 */:
                if (!StringUtils.d(LoginRegisterTools.c())) {
                    CommonAlertDialog.a(this.b, getString(2131892794), getString(2131892803), getString(2131892801), getString(2131886718), new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.AccountAndSafetyFragment.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            Tracker.onClick(view2);
                            AccountAndSafetyFragment.this.f19628c.c();
                        }
                    }, (View.OnClickListener) null);
                } else if (Util.isClientAvailable(ChatManager.context, "com.tencent.mm")) {
                    this.f19628c.b();
                } else {
                    AppMethods.a(getString(2131892807));
                }
                if (TextUtils.isEmpty(this.o)) {
                    InstantLog.a("unbound_wechat");
                    EventTrackSettings.a(SettingsProtos.Event.UNBOUND_WECHAT);
                    return;
                }
                InstantLog.a("bound_wechat");
                EventTrackSettings.a(SettingsProtos.Event.BOUND_WECHAT);
                return;
            case R.id.ll_login_protection /* 2131367995 */:
                InstantLog.a("login_protection");
                EventTrackSettings.a(SettingsProtos.Event.LOGIN_PROTECTION);
                LoginDeviceListFragment.a(this.b);
                return;
            case R.id.ll_modify_pwd /* 2131368033 */:
                EventTrackSettings.a(SettingsProtos.Event.PWD_SETTINGS_CLICK);
                TerminalActivity.d(this.b, PasswordSettingFragment.class, (Bundle) null);
                return;
            case R.id.ll_remove_account /* 2131368184 */:
                EventTrackSettings.a(SettingsProtos.Event.CANCEL_ACCOUNT_BTN_CLICK);
                WebViewShowInfoFragment.show(this.b, H5Url.a(10), -1);
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        View view = this.f19627a;
        if (view == null) {
            this.f19627a = layoutInflater.inflate(R.layout.fragment_account_and_safety, viewGroup, false);
            this.f19628c = new AccountAndSafetyPresenter(this.b, this, getFragmentActive());
            c();
        } else {
            ((ViewGroup) view.getParent()).removeView(this.f19627a);
        }
        return this.f19627a;
    }

    public void onStart() {
        super.onStart();
        this.f19628c.ar_();
        if (BluedPreferences.bs()) {
            this.g.setText(getResources().getString(R.string.opened));
            this.g.setTextColor(getResources().getColor(2131101206));
            return;
        }
        this.g.setText(getResources().getString(R.string.closed));
        this.g.setTextColor(getResources().getColor(2131101201));
    }
}
