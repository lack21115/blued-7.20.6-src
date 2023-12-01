package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinObserver;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.VerifyStatus;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.qr_scan.CaptureActivity;
import com.soft.blued.ui.setting.Contract.SettingContract;
import com.soft.blued.ui.setting.Presenter.SettingPresenter;
import com.soft.blued.ui.setting.activity.SwitchAccountActivity;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import skin.support.observe.SkinObservable;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/SettingFragment.class */
public class SettingFragment extends BaseFragment implements View.OnClickListener, BluedSkinObserver, SettingContract.IView {
    private ShapeTextView A;

    /* renamed from: a  reason: collision with root package name */
    private Context f19909a;
    private SettingContract.IPresenter b;

    /* renamed from: c  reason: collision with root package name */
    private View f19910c;
    private Dialog d;
    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private LinearLayout k;
    private LinearLayout l;
    private LinearLayout m;
    private LinearLayout n;
    private LinearLayout o;
    private LinearLayout p;
    private CommonTopTitleNoTrans q;
    private TextView r;
    private TextView s;
    private TextView t;
    private View u;
    private RelativeLayout v;
    private ShapeTextView w;
    private ShapeTextView x;
    private ShapeTextView y;
    private ShapeTextView z;

    public static void a(Context context) {
        TerminalActivity.d(context, SettingFragment.class, (Bundle) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c() {
        CommonTopTitleNoTrans findViewById = this.f19910c.findViewById(R.id.top_title);
        this.q = findViewById;
        findViewById.f();
        this.q.a();
        this.q.setLeftImg(2131233902);
        this.q.setCenterText(getString(R.string.setting));
        this.q.setLeftClickListener(this);
        this.q.f();
        this.q.setCenterTextColor(2131102254);
        this.e = (LinearLayout) this.f19910c.findViewById(R.id.ll_about_blued);
        this.f = (LinearLayout) this.f19910c.findViewById(R.id.ll_face_verify);
        this.g = (LinearLayout) this.f19910c.findViewById(R.id.ll_live_setting);
        this.h = (LinearLayout) this.f19910c.findViewById(R.id.ll_general_setting);
        this.i = (LinearLayout) this.f19910c.findViewById(R.id.ll_privacy_setting);
        this.j = (LinearLayout) this.f19910c.findViewById(R.id.ll_scan_setting);
        this.k = (LinearLayout) this.f19910c.findViewById(R.id.ll_remind_setting);
        this.l = (LinearLayout) this.f19910c.findViewById(R.id.ll_safe_center);
        this.m = (LinearLayout) this.f19910c.findViewById(R.id.ll_account_and_safety);
        this.n = (LinearLayout) this.f19910c.findViewById(R.id.ll_debug);
        this.r = (TextView) this.f19910c.findViewById(R.id.tv_quit_login);
        this.s = (TextView) this.f19910c.findViewById(R.id.tv_verify_status);
        this.u = this.f19910c.findViewById(R.id.tv_verify_warning);
        this.o = (LinearLayout) this.f19910c.findViewById(R.id.ll_privacy_clause);
        this.p = (LinearLayout) this.f19910c.findViewById(R.id.ll_information_gathering);
        this.w = this.f19910c.findViewById(R.id.iv_live_setting_dot);
        this.x = this.f19910c.findViewById(R.id.iv_sync_common_dot);
        this.t = (TextView) this.f19910c.findViewById(R.id.tv_version);
        this.v = (RelativeLayout) this.f19910c.findViewById(R.id.rl_switch_account);
        this.y = this.f19910c.findViewById(R.id.iv_switch_dot);
        this.d = DialogUtils.a(this.f19909a);
        this.z = this.f19910c.findViewById(R.id.tv_unread_tips);
        this.A = this.f19910c.findViewById(R.id.tv_new_function);
        if (!BluedPreferences.cf()) {
            this.w.setVisibility(0);
        }
        if (!BluedPreferences.ch()) {
            this.x.setVisibility(0);
        }
        if (!BluedPreferences.cl()) {
            this.y.setVisibility(0);
        }
        if (CommonPreferences.m()) {
            this.z.setVisibility(0);
            BluedPreferences.Z(false);
            int dH = BluedPreferences.dH();
            if (dH == 1) {
                this.z.setText((int) R.string.account_unread);
            } else if (dH == 2) {
                this.z.setText((int) R.string.setting_switch_unread_follower);
            } else if (dH == 3) {
                this.z.setText((int) R.string.setting_switch_unread_visitor);
            }
        }
        String str = "v" + DeviceUtils.c();
        String str2 = str;
        if ("a8888a".equals(AppInfo.c)) {
            str2 = str + " beta";
        }
        this.t.setText(str2);
        LiveEventBus.get(EventBusConstant.KEY_EVENT_FINISH_SETTING, Void.class).observe(this, new Observer<Void>() { // from class: com.soft.blued.ui.setting.fragment.SettingFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Void r3) {
                SettingFragment.this.getActivity().finish();
            }
        });
    }

    private void d() {
        this.q.setLeftClickListener(this);
        this.f.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.v.setOnClickListener(this);
    }

    @Override // com.soft.blued.ui.setting.Contract.SettingContract.IView
    public void a() {
        AppMethods.a(AppInfo.d().getResources().getString(2131887272));
    }

    public void a(SkinObservable skinObservable, Object obj) {
        Log.e("skin", "SettingFragment updateSkin");
        CommonTopTitleNoTrans commonTopTitleNoTrans = this.q;
        if (commonTopTitleNoTrans != null) {
            commonTopTitleNoTrans.setCenterTextColor(2131102254);
            getActivity().findViewById(android.R.id.content).setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101780));
        }
        StatusBarHelper.a(getActivity());
        StatusBarHelper.a(getActivity(), BluedSkinUtils.a(getContext(), AppInfo.k()));
    }

    @Override // com.soft.blued.ui.setting.Contract.SettingContract.IView
    public void a(VerifyStatus[] verifyStatusArr) {
        if (verifyStatusArr == null || verifyStatusArr.length <= 0) {
            return;
        }
        String str = verifyStatusArr[0].has_audited;
        this.s.setTextColor(BluedSkinUtils.a(this.f19909a, 2131102254));
        if ("1".equals(str)) {
            this.s.setText(getResources().getString(2131892551));
        } else if (!"2".equals(str)) {
            if ("0".equals(str)) {
                this.s.setText(getResources().getString(2131892566));
            } else {
                this.s.setText(getResources().getString(2131892553));
            }
        } else {
            this.s.setText(getResources().getString(2131892395));
            if (!BluedPreferences.aN().equals(verifyStatusArr[0].verified_time)) {
                this.u.setVisibility(0);
                BluedPreferences.B(verifyStatusArr[0].verified_time);
            }
            this.s.setTextColor(getResources().getColor(2131101201));
        }
    }

    @Override // com.soft.blued.ui.setting.Contract.SettingContract.IView
    public void a(VerifyStatus[] verifyStatusArr, String str, String str2, String str3, String str4) {
        if (this.u.getVisibility() != 8) {
            this.u.setVisibility(8);
            if (verifyStatusArr != null && verifyStatusArr.length > 0) {
                BluedPreferences.B(verifyStatusArr[0].verified_time);
            }
        }
        if (verifyStatusArr == null || verifyStatusArr.length <= 0 || !"1".equals(verifyStatusArr[0].has_audited)) {
            PersonalVerifyFragment.a(getActivity(), 2);
            return;
        }
        ShowVerifyFragment.a(getActivity(), str2, str3, verifyStatusArr[0].verified_time, str4, false);
    }

    public void b() {
        CommonAlertDialog.a(getActivity(), getResources().getString(R.string.common_string_notice), getResources().getString(R.string.confirm_logout), getString(2131886752), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.SettingFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                SettingFragment.this.b.c();
            }
        }, getString(2131886718), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131363120:
                getActivity().finish();
                return;
            case R.id.ll_about_blued /* 2131367606 */:
                InstantLog.b("my_model", 10);
                TerminalActivity.d(getActivity(), AboutBluedFragment.class, (Bundle) null);
                return;
            case R.id.ll_account_and_safety /* 2131367607 */:
                InstantLog.b("my_model", 5);
                AccountAndSafetyFragment.a(this.f19909a);
                return;
            case R.id.ll_debug /* 2131367734 */:
                DebugFragment.a(this.f19909a);
                return;
            case R.id.ll_face_verify /* 2131367785 */:
                InstantLog.b("my_model", 4);
                this.b.b();
                return;
            case R.id.ll_general_setting /* 2131367828 */:
                InstantLog.b("my_model", 8);
                GeneralFragment.a(getActivity());
                if (BluedPreferences.ch()) {
                    return;
                }
                BluedPreferences.ci();
                this.x.setVisibility(8);
                return;
            case R.id.ll_information_gathering /* 2131367928 */:
                WebViewShowInfoFragment.show(this.f19909a, H5Url.a(92), -1);
                return;
            case R.id.ll_live_setting /* 2131367980 */:
                EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_LIVE_CLICK);
                WebViewShowInfoFragment.show(getContext(), "https://app.blued.cn/?action=live_setting");
                if (BluedPreferences.cf()) {
                    return;
                }
                BluedPreferences.cg();
                this.w.setVisibility(8);
                return;
            case R.id.ll_privacy_clause /* 2131368141 */:
                WebViewShowInfoFragment.show(getActivity(), H5Url.a(22), 0);
                return;
            case R.id.ll_privacy_setting /* 2131368144 */:
                InstantLog.b("my_model", 7);
                TerminalActivity.d(this.f19909a, PrivacySettingFragment.class, (Bundle) null);
                return;
            case R.id.ll_remind_setting /* 2131368183 */:
                InstantLog.b("my_model", 6);
                TerminalActivity.d(getActivity(), RemindSettingFragment.class, (Bundle) null);
                return;
            case R.id.ll_safe_center /* 2131368213 */:
                InstantLog.b("my_model", 9);
                WebViewShowInfoFragment.show(this.f19909a, BluedHttpUrl.f(), -1);
                return;
            case R.id.ll_scan_setting /* 2131368216 */:
                getActivity().startActivity(new Intent(getActivity(), CaptureActivity.class));
                return;
            case R.id.rl_switch_account /* 2131369411 */:
                startActivity(new Intent().setClass(getActivity(), SwitchAccountActivity.class));
                if (BluedPreferences.cl()) {
                    return;
                }
                BluedPreferences.cm();
                this.y.setVisibility(8);
                return;
            case R.id.tv_quit_login /* 2131372344 */:
                InstantLog.a("logout_btn_click");
                EventTrackSettings.a(SettingsProtos.Event.LOGOUT_BTN_CLICK);
                b();
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f19909a = getActivity();
        getActivity().findViewById(android.R.id.content).setBackgroundColor(BluedSkinUtils.a(this.f19909a, 2131101780));
        View view = this.f19910c;
        if (view == null) {
            this.f19910c = layoutInflater.inflate(R.layout.fragment_settings, viewGroup, false);
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f19910c.getParent()).removeView(this.f19910c);
        }
        return this.f19910c;
    }

    public void onDestroyView() {
        super.onDestroyView();
        BluedSkinUtils.b(this);
    }

    public void onResume() {
        super.onResume();
        BluedSkinUtils.a(this);
        if (BluedPreferences.eW()) {
            this.A.setVisibility(4);
        } else {
            this.A.setVisibility(0);
        }
    }

    public void onStart() {
        super.onStart();
        this.b.ar_();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        d();
        this.b = new SettingPresenter(this, this.f19909a, getFragmentActive());
    }
}
