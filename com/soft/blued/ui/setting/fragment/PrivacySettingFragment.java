package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.lifecycle.Observer;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.find.view.TwoWaysBar;
import com.soft.blued.ui.setting.Contract.IPrivacySettingContract;
import com.soft.blued.ui.setting.Presenter.PrivacySettingPresenter;
import com.soft.blued.ui.user.fragment.VipInvisibleDialogFragment;
import com.soft.blued.ui.user.fragment.VipUpgradeDialogFragment;
import com.soft.blued.ui.user.model.VipUpgradeModel;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/PrivacySettingFragment.class */
public class PrivacySettingFragment extends BaseFragment implements View.OnClickListener, IPrivacySettingContract.IView {
    private ShapeTextView A;
    private View B;

    /* renamed from: a  reason: collision with root package name */
    private Context f19874a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private ToggleButton f19875c;
    private ToggleButton d;
    private ToggleButton e;
    private ToggleButton f;
    private ToggleButton g;
    private ToggleButton h;
    private ToggleButton i;
    private ToggleButton j;
    private ToggleButton k;
    private ToggleButton l;
    private LinearLayout m;
    private LinearLayout n;
    private TextView o;
    private TextView p;
    private PrivacySettingPresenter q;
    private View r;
    private View s;
    private View t;
    private LinearLayout u;
    private LinearLayout v;
    private TextView w;
    private TwoWaysBar x;
    private ShapeTextView y;
    private boolean z;

    private void a(final int i, final String str) {
        PayHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<VipUpgradeModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.PrivacySettingFragment.8
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<VipUpgradeModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    PayUtils.a(PrivacySettingFragment.this.getActivity(), i, str);
                } else {
                    VipUpgradeDialogFragment.f20487a.a(PrivacySettingFragment.this.getContext(), PrivacySettingFragment.this.getParentFragmentManager(), bluedEntityA.data, 2, str, i);
                }
            }

            public boolean onUIFailure(int i2, String str2, String str3) {
                PayUtils.a(PrivacySettingFragment.this.getActivity(), i, str);
                return true;
            }
        }, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        TerminalActivity.d(getActivity(), BlacklistFragment.class, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        Tracker.onCheckedChanged(compoundButton, z);
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0) {
            EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_PRIVACY_ACCESS_CLICK, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(CompoundButton compoundButton, boolean z) {
        Tracker.onCheckedChanged(compoundButton, z);
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0) {
            EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_PRIVACY_HIDE_DISTANCE_CLICK, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c() {
        LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_BLACK_LIST_NUM, Boolean.class).observe(this, new Observer<Boolean>() { // from class: com.soft.blued.ui.setting.fragment.PrivacySettingFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                if (bool.booleanValue()) {
                    PrivacySettingFragment.this.q.c();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        Tracker.onClick(view);
        VipInvisibleDialogFragment vipInvisibleDialogFragment = new VipInvisibleDialogFragment();
        vipInvisibleDialogFragment.b = this.f19874a.getResources().getString(R.string.custom_invisible);
        vipInvisibleDialogFragment.a(new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.setting.fragment.PrivacySettingFragment.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (PrivacySettingFragment.this.getActivity() != null && PrivacySettingFragment.this.isActivityListenerEnable() && (PrivacySettingFragment.this.getActivity() instanceof BaseFragmentActivity)) {
                    PrivacySettingFragment.this.getActivity().a(PrivacySettingFragment.this);
                }
            }
        });
        vipInvisibleDialogFragment.show(getChildFragmentManager(), PrivacySettingFragment.class.getName());
        EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_PRIVACY_STEALTH_BTN_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(CompoundButton compoundButton, boolean z) {
        Tracker.onCheckedChanged(compoundButton, z);
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0) {
            EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_PRIVACY_HIDE_TIME_CLICK, z);
        }
    }

    private void d() {
        this.q.b(this.f19875c.isChecked());
        this.q.c(this.e.isChecked());
        this.q.e(this.f.isChecked());
        this.q.f(this.g.isChecked());
        this.q.g(this.h.isChecked());
        this.q.h(this.i.isChecked());
        this.q.j(this.j.isChecked());
        this.q.l(this.k.isChecked());
        this.q.i(this.l.isChecked());
        this.q.k(BluedPreferences.aA());
        this.q.e();
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        Tracker.onClick(view);
        CustomOptionsFragment.f19646a.a(this.f19874a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(CompoundButton compoundButton, boolean z) {
        Tracker.onCheckedChanged(compoundButton, z);
        if (z == BluedPreferences.av()) {
            return;
        }
        if (z && UserInfo.getInstance().getLoginUserInfo().vip_grade != 2 && BluedConfig.a().g().is_view_secretly == 0) {
            return;
        }
        EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_PRIVACY_VIEW_PRIVATE_CLICK, z);
        InstantLog.a("setting_view_secretly_all_click", 1);
        PrivacySettingPresenter privacySettingPresenter = this.q;
        if (privacySettingPresenter != null) {
            privacySettingPresenter.a(z, false);
        }
    }

    private void e() {
        new BluedAlertDialog.Builder(getContext()).d((int) R.string.no_disturb_hint_dialog_title).e((int) R.string.no_disturb_hint_dialog_message).a(2131887278, (DialogInterface.OnClickListener) null).f(2131101766).a().show();
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public boolean D() {
        return false;
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public boolean E() {
        return this.j.isChecked();
    }

    public void a() {
        if (BluedConfig.a().y()) {
            LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.ll_half_invisible);
            this.u = linearLayout;
            linearLayout.setVisibility(0);
        }
        this.t = this.b.findViewById(R.id.ll_system_permission);
        LinearLayout linearLayout2 = (LinearLayout) this.b.findViewById(R.id.ll_custom_options);
        this.n = linearLayout2;
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$PrivacySettingFragment$zvF2qKxskAXMk3DdLTvfyY0VP2o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrivacySettingFragment.this.d(view);
            }
        });
        String ab = BluedPreferences.ab();
        this.q.b = ab;
        this.v = (LinearLayout) this.b.findViewById(R.id.ll_half_range_text);
        this.w = (TextView) this.b.findViewById(R.id.tv_half_range_value);
        TwoWaysBar twoWaysBar = (TwoWaysBar) this.b.findViewById(R.id.half_range_bar);
        this.x = twoWaysBar;
        twoWaysBar.a(ab, 100);
        this.w.setText(TwoWaysBar.a(this.f19874a, ab, 1));
        this.x.setTwoWaysBarListner(new TwoWaysBar.TowWaysBarListenerAdapter() { // from class: com.soft.blued.ui.setting.fragment.PrivacySettingFragment.2
            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TowWaysBarListenerAdapter, com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void a(int i, int i2) {
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb.append(i2 >= 100 ? "max" : Integer.valueOf(i2));
                String sb2 = sb.toString();
                BluedPreferences.x(sb2);
                PrivacySettingFragment.this.q.b = sb2;
                PrivacySettingFragment.this.w.setText(TwoWaysBar.a(PrivacySettingFragment.this.f19874a, i, i2, 1));
            }

            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TowWaysBarListenerAdapter, com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void a(boolean z) {
            }

            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TowWaysBarListenerAdapter, com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void b(boolean z) {
            }
        });
        this.r = this.b.findViewById(R.id.ll_msg_box);
        this.s = this.b.findViewById(R.id.tv_msg_box_desc);
        this.r.setVisibility(8);
        this.s.setVisibility(8);
        View findViewById = this.b.findViewById(R.id.ll_custom_invisible);
        this.B = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$PrivacySettingFragment$6lYtELJx045TcWRcq5f86RSicVc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrivacySettingFragment.this.c(view);
            }
        });
        CommonTopTitleNoTrans findViewById2 = this.b.findViewById(R.id.top_title);
        findViewById2.f();
        findViewById2.a();
        findViewById2.setCenterText(getString(R.string.privacy_setting));
        findViewById2.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$PrivacySettingFragment$wZHs1JkS0hJ61mtZ1MVeM7HN5EM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrivacySettingFragment.this.b(view);
            }
        });
        ToggleButton toggleButton = (ToggleButton) this.b.findViewById(R.id.tglbtn_attention_onoff);
        this.f19875c = toggleButton;
        toggleButton.setChecked(true);
        ToggleButton toggleButton2 = (ToggleButton) this.b.findViewById(R.id.tglbtn_fans_onoff);
        this.e = toggleButton2;
        toggleButton2.setChecked(true);
        ToggleButton toggleButton3 = (ToggleButton) this.b.findViewById(R.id.tglbtn_secret_onoff);
        this.d = toggleButton3;
        toggleButton3.setOnClickListener(this);
        this.d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$PrivacySettingFragment$hfyAIrt5E0mqb6cycm0ApmcPAeU
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                PrivacySettingFragment.this.d(compoundButton, z);
            }
        });
        ToggleButton toggleButton4 = (ToggleButton) this.b.findViewById(R.id.tglbtn_map_finder_onoff);
        this.f = toggleButton4;
        toggleButton4.setChecked(true);
        ToggleButton toggleButton5 = (ToggleButton) this.b.findViewById(R.id.tglbtn_last_operate_onoff);
        this.g = toggleButton5;
        toggleButton5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$PrivacySettingFragment$JD_0z2ItiAwM6VKmzjE8b2S2UPA
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                PrivacySettingFragment.c(compoundButton, z);
            }
        });
        ToggleButton toggleButton6 = (ToggleButton) this.b.findViewById(R.id.tglbtn_distance_onoff);
        this.h = toggleButton6;
        toggleButton6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$PrivacySettingFragment$Ae8lV45Fm5Y52xlsS6LhpeypwlI
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                PrivacySettingFragment.b(compoundButton, z);
            }
        });
        this.j = (ToggleButton) this.b.findViewById(R.id.tglbtn_invisible_half_onoff);
        ToggleButton toggleButton7 = (ToggleButton) this.b.findViewById(R.id.tglbtn_incognito_visitor_onoff);
        this.i = toggleButton7;
        toggleButton7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$PrivacySettingFragment$Ri8BmA0pRCHySDLchNps08JRTlo
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                PrivacySettingFragment.a(compoundButton, z);
            }
        });
        this.k = (ToggleButton) this.b.findViewById(R.id.tglbtn_msg_disturb_onoff);
        ToggleButton toggleButton8 = (ToggleButton) this.b.findViewById(R.id.tglbtn_see_groups);
        this.l = toggleButton8;
        toggleButton8.setChecked(true);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.t.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) this.b.findViewById(R.id.ll_black_list);
        this.m = linearLayout3;
        linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$PrivacySettingFragment$FVZ2kL8qLMyvKiAUBROsDQJgCL4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrivacySettingFragment.this.a(view);
            }
        });
        this.o = (TextView) this.b.findViewById(R.id.tv_black_list_count);
        this.p = (TextView) this.b.findViewById(R.id.tv_black_count_max);
        this.q.c();
        this.y = this.b.findViewById(R.id.tv_fans_list_red_point);
        this.A = this.b.findViewById(R.id.tv_group_list_red_point);
        if (BluedPreferences.cY()) {
            return;
        }
        this.A.setVisibility(0);
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void a(String str, String str2) {
        this.o.setText(str);
        TextView textView = this.p;
        textView.setText("/" + str2);
    }

    public void b() {
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void b(boolean z, String str) {
        BluedPreferences.x(str);
        this.x.a(str, 100);
        this.j.setChecked(z);
        if (z) {
            this.v.setVisibility(0);
            this.x.setVisibility(0);
            return;
        }
        this.v.setVisibility(8);
        this.x.setVisibility(8);
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void f(boolean z) {
        this.f19875c.setChecked(z);
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void g(boolean z) {
        this.e.setChecked(z);
    }

    public String getPageBizName() {
        return super.getPageBizName();
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void h(boolean z) {
        this.l.setChecked(z);
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void i(boolean z) {
        BluedPreferences.B(z);
        this.d.setChecked(z);
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void j(boolean z) {
        this.f.setChecked(z);
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void k(boolean z) {
        this.g.setChecked(z);
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void l(boolean z) {
        this.h.setChecked(z);
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void m(boolean z) {
        this.i.setChecked(z);
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void n(boolean z) {
        this.k.setChecked(z);
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void o(boolean z) {
        this.z = z;
    }

    public boolean onBackPressed() {
        d();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        final int i = UserInfo.getInstance().getLoginUserInfo().vip_grade;
        int id = view.getId();
        if (id == 2131368266) {
            TerminalActivity.d(getContext(), SystemPermissionFragment.class, (Bundle) null);
        } else if (id == 2131370660) {
            if (this.k.isChecked()) {
                e();
            }
            EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_ANTI_HARASS, this.k.isChecked());
        } else {
            switch (id) {
                case R.id.tglbtn_distance_onoff /* 2131370647 */:
                    if (this.z && UserInfo.getInstance().getLoginUserInfo().vip_grade != 0) {
                        Context context = this.f19874a;
                        CommonAlertDialog.a(context, context.getResources().getString(2131888879), this.f19874a.getResources().getString(R.string.close_the_location_and_open_hide_distance), this.f19874a.getResources().getString(R.string.close_now), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.PrivacySettingFragment.4
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                Tracker.onClick(dialogInterface, i2);
                                if (i != 0 || BluedConfig.a().g().is_hide_distance != 0) {
                                    InstantLog.a("setting_hide_distance_click", 1);
                                    return;
                                }
                                PrivacySettingFragment.this.h.setChecked(false);
                                EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_PRIVACY_HIDE_DISTANCE_CLICK, false);
                                PayUtils.a(PrivacySettingFragment.this.getActivity(), 1, "setting_hide_distance");
                                InstantLog.a("setting_hide_distance_click", 0);
                            }
                        }, this.f19874a.getResources().getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.PrivacySettingFragment.5
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                Tracker.onClick(dialogInterface, i2);
                                PrivacySettingFragment.this.h.setChecked(false);
                            }
                        }, (DialogInterface.OnDismissListener) null);
                        return;
                    } else if (i != 0 || BluedConfig.a().g().is_hide_distance != 0) {
                        InstantLog.a("setting_hide_distance_click", 1);
                        return;
                    } else {
                        this.h.setChecked(false);
                        EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_PRIVACY_HIDE_DISTANCE_CLICK, false);
                        PayUtils.a(getActivity(), 1, "setting_hide_distance");
                        InstantLog.a("setting_hide_distance_click", 0);
                        return;
                    }
                case R.id.tglbtn_fans_onoff /* 2131370648 */:
                    BluedPreferences.cX();
                    this.y.setVisibility(8);
                    return;
                case R.id.tglbtn_incognito_visitor_onoff /* 2131370649 */:
                    if (i == 2 || BluedConfig.a().g().is_traceless_access != 0) {
                        InstantLog.a("setting_traceless_visit_click", 1);
                        return;
                    }
                    this.i.setChecked(false);
                    EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_PRIVACY_ACCESS_CLICK, false);
                    a(11, "setting_traceless");
                    InstantLog.a("setting_traceless_visit_click", 0);
                    return;
                case R.id.tglbtn_invisible_half_onoff /* 2131370650 */:
                    if (i == 0 && BluedConfig.a().g().is_invisible_half == 0) {
                        this.j.setChecked(false);
                        PayUtils.a(getActivity(), 3, "setting_half_invisible");
                        InstantLog.a("setting_half_invisible_click", 0);
                        return;
                    } else if (!this.j.isChecked()) {
                        this.v.setVisibility(8);
                        this.x.setVisibility(8);
                        return;
                    } else {
                        CommonAlertDialog.a(this.f19874a, this.f19874a.getResources().getString(R.string.open_half_invisible), this.f19874a.getResources().getString(R.string.open_half_invisible_alert), (String) null, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.PrivacySettingFragment.6
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                Tracker.onClick(dialogInterface, i2);
                                InstantLog.a("setting_half_invisible_click", 1);
                                if (!PrivacySettingFragment.this.j.isChecked()) {
                                    PrivacySettingFragment.this.v.setVisibility(8);
                                    PrivacySettingFragment.this.x.setVisibility(8);
                                    return;
                                }
                                PrivacySettingFragment.this.v.setVisibility(0);
                                PrivacySettingFragment.this.x.setVisibility(0);
                                PrivacySettingFragment.this.x.a(BluedPreferences.ab(), 100);
                            }
                        }, (String) null, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.PrivacySettingFragment.7
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                Tracker.onClick(dialogInterface, i2);
                                PrivacySettingFragment.this.j.setChecked(false);
                                PrivacySettingFragment.this.v.setVisibility(8);
                                PrivacySettingFragment.this.x.setVisibility(8);
                            }
                        }, (DialogInterface.OnDismissListener) null);
                        return;
                    }
                case R.id.tglbtn_last_operate_onoff /* 2131370651 */:
                    if (i != 0 || BluedConfig.a().g().is_hide_last_operate != 0) {
                        InstantLog.a("setting_hide_last_operate_click", 1);
                        return;
                    }
                    this.g.setChecked(false);
                    EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_PRIVACY_HIDE_TIME_CLICK, false);
                    PayUtils.a(getActivity(), 0, "setting_hide_operate");
                    InstantLog.a("setting_hide_last_operate_click", 0);
                    return;
                default:
                    switch (id) {
                        case R.id.tglbtn_secret_onoff /* 2131370671 */:
                            if (i == 2 || BluedConfig.a().g().is_view_secretly != 0) {
                                return;
                            }
                            this.d.setChecked(false);
                            a(13, "setting_msg_quiet_all");
                            InstantLog.a("setting_view_secretly_all_click", 0);
                            EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_PRIVACY_VIEW_PRIVATE_CLICK, false);
                            return;
                        case R.id.tglbtn_see_groups /* 2131370672 */:
                            BluedPreferences.cZ();
                            this.A.setVisibility(8);
                            return;
                        default:
                            return;
                    }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_privacy_setting, viewGroup, false);
            this.f19874a = getActivity();
            this.q = new PrivacySettingPresenter(getActivity(), getFragmentActive(), this);
            a();
            c();
            this.q.b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    public void onStart() {
        super.onStart();
        b();
        this.q.d();
    }
}
