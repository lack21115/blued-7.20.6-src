package com.soft.blued.ui.login_register.View;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.gridcodeedittext.GridCodeEditText;
import com.soft.blued.ui.login_register.Contract.VerifyCodeContract;
import com.soft.blued.ui.login_register.presenter.VerifyCodePresenter;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/View/VerifyCodeFragment.class */
public class VerifyCodeFragment extends BaseFragment implements View.OnClickListener, VerifyCodeContract.IView {

    /* renamed from: a  reason: collision with root package name */
    Runnable f31539a = new Runnable() { // from class: com.soft.blued.ui.login_register.View.VerifyCodeFragment.2
        @Override // java.lang.Runnable
        public void run() {
            if (VerifyCodeFragment.this.r == 0) {
                VerifyCodeFragment.this.h.setEnabled(true);
                VerifyCodeFragment.this.h.setClickable(true);
                VerifyCodeFragment.this.h.setText(VerifyCodeFragment.this.getResources().getString(2131891539));
                VerifyCodeFragment.this.h.setTextColor(VerifyCodeFragment.this.getResources().getColor(2131101190));
                return;
            }
            VerifyCodeFragment.this.h.setEnabled(false);
            VerifyCodeFragment.this.h.setClickable(false);
            VerifyCodeFragment.this.h.setText(String.format(VerifyCodeFragment.this.getResources().getString(2131886709), Integer.valueOf(VerifyCodeFragment.this.r)));
            VerifyCodeFragment.this.h.setTextColor(VerifyCodeFragment.this.getResources().getColor(2131101206));
            VerifyCodeFragment.d(VerifyCodeFragment.this);
            if (VerifyCodeFragment.this.r == 0) {
                VerifyCodeFragment.this.postSafeRunOnUiThread(this);
            } else {
                VerifyCodeFragment.this.postDelaySafeRunOnUiThread(this, 1000L);
            }
        }
    };
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f31540c;
    private Context d;
    private VerifyCodeContract.IPresenter e;
    private TextView f;
    private TextView g;
    private TextView h;
    private GridCodeEditText i;
    private CommonTopTitleNoTrans j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private int q;
    private int r;
    private String s;
    private String t;

    public static void a(Context context, Bundle bundle) {
        TerminalActivity.d(context, VerifyCodeFragment.class, bundle);
    }

    static /* synthetic */ int d(VerifyCodeFragment verifyCodeFragment) {
        int i = verifyCodeFragment.r;
        verifyCodeFragment.r = i - 1;
        return i;
    }

    private void d() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.q = arguments.getInt("target_type");
            this.k = arguments.getString("token");
            this.l = arguments.getString("mobile");
            this.m = arguments.getString("password");
            this.n = arguments.getString("login_type");
            this.o = arguments.getString("login_account");
            this.p = arguments.getString("aliasUserId");
            this.s = arguments.getString("safe_device_type");
            this.t = arguments.getString("safe_device_number");
            Log.v("drb", "mSafeDeviceType:" + this.s + " -- mSafeDeviceNumber:" + this.t);
        }
        this.f31540c = DialogUtils.a(this.d);
        this.f = (TextView) this.b.findViewById(2131371164);
        this.g = (TextView) this.b.findViewById(2131371262);
        this.h = (TextView) this.b.findViewById(R.id.tv_resend);
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.b.findViewById(2131370694);
        this.j = commonTopTitleNoTrans;
        commonTopTitleNoTrans.a();
        this.j.f();
        this.j.setCenterText("");
        this.j.setTitleBackgroundDrawable(2131101780);
        GridCodeEditText gridCodeEditText = (GridCodeEditText) this.b.findViewById(R.id.gcet_grid_code_view);
        this.i = gridCodeEditText;
        gridCodeEditText.setPasswordVisibility(true);
        this.f.setOnClickListener(this);
        this.j.setLeftClickListener(this);
        this.h.setOnClickListener(this);
        this.i.setOnPasswordChangedListener(new GridCodeEditText.OnPasswordChangedListener() { // from class: com.soft.blued.ui.login_register.View.VerifyCodeFragment.1
            @Override // com.soft.blued.customview.gridcodeedittext.GridCodeEditText.OnPasswordChangedListener
            public void a(String str) {
                if (str == null || str.length() != 6) {
                    VerifyCodeFragment.this.f.setEnabled(false);
                    VerifyCodeFragment.this.f.setClickable(false);
                    return;
                }
                VerifyCodeFragment.this.f.setEnabled(true);
                VerifyCodeFragment.this.f.setClickable(true);
            }

            @Override // com.soft.blued.customview.gridcodeedittext.GridCodeEditText.OnPasswordChangedListener
            public void b(String str) {
            }
        });
        e();
        if (TextUtils.equals(this.s, "relation_mobile") || TextUtils.equals(this.s, "login_mobile")) {
            this.j.setCenterText(this.d.getResources().getString(2131890639));
            TextView textView = this.g;
            textView.setText(getResources().getString(2131886705) + this.t + "\n" + getResources().getString(2131886707));
        } else if (!TextUtils.equals(this.s, "safe_email") && !TextUtils.equals(this.s, "login_email")) {
            this.j.setCenterText(this.d.getResources().getString(2131890639));
            TextView textView2 = this.g;
            textView2.setText(getResources().getString(2131886705) + this.l + "\n" + getResources().getString(2131886707));
        } else {
            this.j.setCenterText(this.d.getResources().getString(2131887689));
            TextView textView3 = this.g;
            textView3.setText(getResources().getString(2131886668) + "：" + this.t + "\n" + getResources().getString(2131886707));
        }
    }

    private void e() {
        this.r = 60;
        postSafeRunOnUiThread(this.f31539a);
    }

    @Override // com.soft.blued.ui.login_register.Contract.VerifyCodeContract.IView
    public void a() {
        DialogUtils.a(this.f31540c);
    }

    @Override // com.soft.blued.ui.login_register.Contract.VerifyCodeContract.IView
    public void b() {
        DialogUtils.b(this.f31540c);
    }

    @Override // com.soft.blued.ui.login_register.Contract.VerifyCodeContract.IView
    public void c() {
        getActivity().setResult(1, null);
        getActivity().finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.login_register.View.VerifyCodeFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    VerifyCodeFragment.this.getActivity().finish();
                }
            });
        } else if (id == 2131371164) {
            this.e.a(this.k, this.i.getPassWord(), this.n, this.o, this.m, this.q, this.p);
        } else if (id != 2131372436) {
        } else {
            e();
            this.e.a(this.k, this.q);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_verify_code, viewGroup, false);
            this.e = new VerifyCodePresenter(this.d, this, getFragmentActive());
            d();
        } else {
            ((ViewGroup) view.getParent()).removeView(this.b);
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        b();
    }
}
