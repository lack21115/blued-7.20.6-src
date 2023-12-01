package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.login_register.LinkMobileFragment;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.View.VerifyCodeFragment;
import com.soft.blued.ui.setting.Contract.LoginDeviceListContract;
import com.soft.blued.ui.setting.Presenter.LoginDeviceListPresenter;
import com.soft.blued.ui.setting.adapter.LoginDeviceListAdapter;
import com.soft.blued.ui.setting.model.DeviceModel;
import com.soft.blued.ui.setting.model.LoginProtectionModel;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/LoginDeviceListFragment.class */
public class LoginDeviceListFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, LoginDeviceListContract.IView {

    /* renamed from: a  reason: collision with root package name */
    private View f19715a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private LoginDeviceListContract.IPresenter f19716c;
    private LoginDeviceListAdapter d;
    private View e;
    private Dialog f;
    private TextView g;
    private ListView h;
    private ToggleButton i;
    private CommonTopTitleNoTrans j;
    private RenrenPullToRefreshListView k;
    private String l;
    private List<DeviceModel> m;
    private boolean n;

    public static void a(Context context) {
        TerminalActivity.d(context, LoginDeviceListFragment.class, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, List<DeviceModel> list) {
        this.m.clear();
        if (!z) {
            this.g.setVisibility(8);
        } else if (list == null || list.size() == 0) {
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(0);
            this.m.addAll(list);
        }
        this.d.notifyDataSetChanged();
    }

    private void d() {
        CommonTopTitleNoTrans findViewById = this.f19715a.findViewById(R.id.cttnt_title);
        this.j = findViewById;
        findViewById.a();
        this.j.setLeftImg(2131233902);
        this.j.setCenterText((int) R.string.login_protection);
        this.j.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.LoginDeviceListFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LoginDeviceListFragment.this.getActivity().finish();
            }
        });
        this.f = DialogUtils.a(this.b);
        RenrenPullToRefreshListView findViewById2 = this.f19715a.findViewById(R.id.rptrlv_device_list);
        this.k = findViewById2;
        findViewById2.setRefreshEnabled(false);
        this.h = (ListView) this.k.getRefreshableView();
        this.m = new ArrayList();
        this.d = new LoginDeviceListAdapter(this.b, this.f19716c, this.m);
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.header_login_protection, (ViewGroup) this.h, false);
        this.e = inflate;
        this.g = (TextView) inflate.findViewById(R.id.tv_list_sticker);
        this.i = (ToggleButton) this.e.findViewById(R.id.tglbtn_login_protection_onoff);
        this.h.addHeaderView(this.e);
        this.h.setAdapter((ListAdapter) this.d);
        this.i.setOnCheckedChangeListener(this);
    }

    @Override // com.soft.blued.ui.setting.Contract.LoginDeviceListContract.IView
    public void a() {
        DialogUtils.a(this.f);
    }

    @Override // com.soft.blued.ui.setting.Contract.LoginDeviceListContract.IView
    public void a(LoginProtectionModel loginProtectionModel) {
        if (loginProtectionModel != null) {
            boolean z = true;
            if (loginProtectionModel.device_safe != 1) {
                z = false;
            }
            this.i.setChecked(z);
            BluedPreferences.J(z);
            a(z, loginProtectionModel.devices);
        }
    }

    @Override // com.soft.blued.ui.setting.Contract.LoginDeviceListContract.IView
    public void a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("mobile", str);
        bundle.putInt("target_type", 1);
        VerifyCodeFragment.a(this.b, bundle);
    }

    @Override // com.soft.blued.ui.setting.Contract.LoginDeviceListContract.IView
    public void a(boolean z) {
        this.n = false;
        this.i.setOnCheckedChangeListener(null);
        this.i.setChecked(z);
        BluedPreferences.J(z);
        this.i.setOnCheckedChangeListener(this);
    }

    @Override // com.soft.blued.ui.setting.Contract.LoginDeviceListContract.IView
    public void b() {
        DialogUtils.b(this.f);
    }

    @Override // com.soft.blued.ui.setting.Contract.LoginDeviceListContract.IView
    public void c() {
        this.n = true;
        CommonAlertDialog.a(this.b, (View) null, getResources().getString(R.string.open_login_protection), getResources().getString(R.string.bind_mobile_first), getResources().getString(2131886885), getResources().getString(R.string.start_binding), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.LoginDeviceListFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                Bundle bundle = new Bundle();
                bundle.putString("from_page", "login_secure");
                TerminalActivity.d(LoginDeviceListFragment.this.getActivity(), LinkMobileFragment.class, bundle);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.LoginDeviceListFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                LoginDeviceListFragment.this.a(false);
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.soft.blued.ui.setting.fragment.LoginDeviceListFragment.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                LoginDeviceListFragment.this.a(false);
            }
        }, false);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, final boolean z) {
        Tracker.onCheckedChanged(compoundButton, z);
        this.i.setEnabled(false);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.LoginDeviceListFragment.5
            @Override // java.lang.Runnable
            public void run() {
                LoginDeviceListFragment.this.i.setEnabled(true);
            }
        }, 1000L);
        if (compoundButton.isPressed()) {
            BluedPreferences.J(z);
            if (z) {
                this.f19716c.a("set", "");
                return;
            }
            this.n = true;
            CommonAlertDialog.a(this.b, (View) null, getResources().getString(R.string.turn_off), getResources().getString(R.string.turn_off_desc), getResources().getString(2131886885), getResources().getString(2131892209), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.LoginDeviceListFragment.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    LoginDeviceListFragment loginDeviceListFragment = LoginDeviceListFragment.this;
                    loginDeviceListFragment.a(z, loginDeviceListFragment.f19716c.b());
                    LoginDeviceListFragment.this.f19716c.a("close", "");
                }
            }, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.LoginDeviceListFragment.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    LoginDeviceListFragment.this.a(true);
                }
            }, new DialogInterface.OnCancelListener() { // from class: com.soft.blued.ui.setting.fragment.LoginDeviceListFragment.8
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    LoginDeviceListFragment.this.a(true);
                }
            }, false);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        View view = this.f19715a;
        if (view == null) {
            this.f19715a = layoutInflater.inflate(R.layout.fragment_login_device_list, viewGroup, false);
            this.f19716c = new LoginDeviceListPresenter(this, getFragmentActive());
            d();
        } else {
            ((ViewGroup) view.getParent()).removeView(this.f19715a);
        }
        return this.f19715a;
    }

    public void onDestroy() {
        super.onDestroy();
        b();
    }

    public void onStart() {
        super.onStart();
        this.f19716c.ar_();
        this.l = LoginRegisterTools.b();
    }
}
