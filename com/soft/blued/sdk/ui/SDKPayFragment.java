package com.soft.blued.sdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.sdk.SDKActionManager;
import com.soft.blued.sdk.ui.SDKPayContract;
import com.soft.blued.utils.Logger;
import com.soft.blued.view.dialog.CommonAlertDialog2;
import com.soft.blued.view.dialog.DialogWith6PW;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/sdk/ui/SDKPayFragment.class */
public class SDKPayFragment extends BaseFragment implements View.OnClickListener, SDKPayContract.IView {

    /* renamed from: a  reason: collision with root package name */
    CommonTopTitleNoTrans f16061a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private int f16062c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private SDKPayContract.IPresenter j;
    private View k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private Button p;
    private Dialog q;
    private TextView r;
    private TextView s;

    public static void a(Context context, long j, int i, String str, String str2, String str3, String str4, String str5, String str6) {
        Bundle bundle = new Bundle();
        bundle.putLong("action_id", j);
        bundle.putInt("goods_id", i);
        bundle.putString("app_key", str);
        bundle.putString("secret_key", str2);
        bundle.putString("app_sign", str3);
        bundle.putString("app_sign_t", str4);
        bundle.putString("app_token", str5);
        bundle.putString("app_body", str6);
        Logger.a("SDKAction", "SDKPayFragment.show(), actionId:", Long.valueOf(j), ", goodsId:", Integer.valueOf(i), ", appKey:", str, ", appSecretKey:", str2, ", appSign:", str3, ", appSignT:", str4, ", appToken:", str5, ", appBody:", str6);
        TerminalActivity.d(context, SDKPayFragment.class, bundle);
    }

    private void i() {
        this.b = getArguments().getLong("action_id");
        this.f16062c = getArguments().getInt("goods_id");
        this.d = getArguments().getString("app_key");
        this.e = getArguments().getString("secret_key");
        this.g = getArguments().getString("app_sign");
        this.h = getArguments().getString("app_sign_t");
        this.f = getArguments().getString("app_token");
        this.i = getArguments().getString("app_body");
        this.j = new SDKPayPresenter(getActivity(), this.b, this.f16062c, this.d, this.e, this.g, this.h, this.f, this.i, this);
        this.l = (TextView) this.k.findViewById(R.id.tv_beans_count);
        this.m = (TextView) this.k.findViewById(R.id.tv_order_id);
        this.n = (TextView) this.k.findViewById(R.id.tv_payee_name);
        this.o = (TextView) this.k.findViewById(R.id.tv_goods_name);
        Button button = (Button) this.k.findViewById(R.id.btn_pay);
        this.p = button;
        button.setOnClickListener(this);
        this.q = DialogUtils.b(getActivity());
        this.r = (TextView) this.k.findViewById(R.id.tv_balance_count);
        TextView textView = (TextView) this.k.findViewById(R.id.tv_topup);
        this.s = textView;
        textView.setOnClickListener(this);
        this.j.ar_();
        CommonTopTitleNoTrans findViewById = this.k.findViewById(2131370699);
        this.f16061a = findViewById;
        findViewById.setCenterText(getString(R.string.sdk_pay_title));
        this.f16061a.setLeftClickListener(this);
        this.f16061a.a();
    }

    @Override // com.soft.blued.sdk.ui.SDKPayContract.IView
    public void a() {
        DialogUtils.a(this.q);
    }

    @Override // com.soft.blued.sdk.ui.SDKPayContract.IView
    public void a(double d) {
        this.r.setText(getString(R.string.sdk_pay_balance_count, new Object[]{Long.valueOf((long) d)}));
    }

    @Override // com.soft.blued.sdk.ui.SDKPayContract.IView
    public void a(int i) {
        this.l.setText(String.valueOf(i));
    }

    @Override // com.soft.blued.sdk.ui.SDKPayContract.IView
    public void a(String str) {
        this.n.setText(str);
    }

    @Override // com.soft.blued.sdk.ui.SDKPayContract.IView
    public void b() {
        DialogUtils.b(this.q);
    }

    @Override // com.soft.blued.sdk.ui.SDKPayContract.IView
    public void b(String str) {
        this.m.setText(getString(R.string.sdk_pay_order_number, new Object[]{str}));
    }

    @Override // com.soft.blued.sdk.ui.SDKPayContract.IView
    public void c() {
        this.p.setVisibility(0);
    }

    @Override // com.soft.blued.sdk.ui.SDKPayContract.IView
    public void c(String str) {
        this.o.setText(str);
    }

    @Override // com.soft.blued.sdk.ui.SDKPayContract.IView
    public void d() {
        this.p.setVisibility(8);
    }

    @Override // com.soft.blued.sdk.ui.SDKPayContract.IView
    public void e() {
        CommonAlertDialog2.a(getActivity(), getString(R.string.Live_SendPresent_verifyPassword), getString(R.string.sdk_pay_verify_paycode), true, true, true, false, new CommonAlertDialog2.PWDListener() { // from class: com.soft.blued.sdk.ui.SDKPayFragment.1
            @Override // com.soft.blued.view.dialog.CommonAlertDialog2.PWDListener
            public void onClick(String str, boolean z, DialogWith6PW dialogWith6PW) {
                SDKPayFragment.this.j.a(str);
            }
        }, null);
    }

    @Override // com.soft.blued.sdk.ui.SDKPayContract.IView
    public void f() {
        if (getFragmentActive() == null || !getFragmentActive().isActive()) {
            return;
        }
        getActivity().finish();
    }

    @Override // com.soft.blued.sdk.ui.SDKPayContract.IView
    public void g() {
        CommonAlertDialog.a(getActivity(), (View) null, "", getString(R.string.sdk_pay_no_money), getString(R.string.common_cancel), getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.sdk.ui.SDKPayFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                SDKPayFragment.this.j.b();
            }
        }, (DialogInterface.OnClickListener) null, (DialogInterface.OnCancelListener) null, true);
    }

    @Override // com.soft.blued.sdk.ui.SDKPayContract.IView
    public void h() {
        CommonAlertDialog.a(getActivity(), (View) null, "", getString(R.string.sdk_pay_no_paycode), getString(R.string.common_cancel), getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.sdk.ui.SDKPayFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                SDKPayFragment.this.j.c();
            }
        }, (DialogInterface.OnClickListener) null, (DialogInterface.OnCancelListener) null, true);
    }

    public boolean onBackPressed() {
        SDKActionManager.a(getActivity(), this.b);
        getActivity().finish();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131362616) {
            this.j.a((String) null);
        } else if (id != 2131363120) {
            if (id != 2131372820) {
                return;
            }
            this.j.b();
        } else {
            Logger.a("SDKAction", "click return btn, cancel action");
            SDKActionManager.a(getActivity(), this.b);
            getActivity().finish();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.k;
        if (view == null) {
            this.k = layoutInflater.inflate(R.layout.fragment_sdk_pay, viewGroup, false);
            i();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.k.getParent()).removeView(this.k);
        }
        return this.k;
    }

    public void onResume() {
        super.onResume();
        if (SDKActionManager.a(this.b)) {
            this.j.a(true);
        } else {
            getActivity().finish();
        }
    }
}
