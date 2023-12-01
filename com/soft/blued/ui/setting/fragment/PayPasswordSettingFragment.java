package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.module.common.model.DecryptJson;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.blued.android.module.common.view.ClearEditText;
import com.blued.android.module.common.view.CommonEdittextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.live_china.model.PayRemaining;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.gridcodeedittext.GridCodeEditText;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.ui.login_register.LinkMobile2Fragment;
import com.soft.blued.ui.login_register.LinkMobileFragment;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.setting.model.PayPWDStatusModel;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/PayPasswordSettingFragment.class */
public class PayPasswordSettingFragment extends BaseFragment implements View.OnClickListener {
    private static final String b = PayPasswordSettingFragment.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public BluedUIHttpResponse f33520a = new BluedUIHttpResponse() { // from class: com.soft.blued.ui.setting.fragment.PayPasswordSettingFragment.5
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            DialogUtils.b(PayPasswordSettingFragment.this.d);
            super.onUIFinish();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(PayPasswordSettingFragment.this.d);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity bluedEntity) {
            AppMethods.a((CharSequence) PayPasswordSettingFragment.this.getActivity().getResources().getString(2131886716));
            Bundle bundle = new Bundle();
            bundle.putString(LoginRegisterTools.g, PayPasswordSettingFragment.this.j);
            bundle.putString(LoginRegisterTools.e, PayPasswordSettingFragment.this.k);
            bundle.putString(LoginRegisterTools.k, LoginRegisterTools.n);
            bundle.putString(LoginRegisterTools.m, "");
            TerminalActivity.d(PayPasswordSettingFragment.this.getActivity(), LinkMobile2Fragment.class, bundle);
            PayPasswordSettingFragment.this.getActivity().finish();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private View f33521c;
    private Dialog d;
    private TextView e;
    private TextView f;
    private ClearEditText g;
    private TextView h;
    private CommonTopTitleNoTrans i;
    private String j;
    private String k;
    private LinearLayout l;
    private LinearLayout m;
    private LinearLayout n;
    private boolean o;
    private GridCodeEditText p;
    private CommonEdittextView q;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        PayHttpUtils.a(str, false, 2, new BluedUIHttpResponse<BluedEntityA<PayRemaining>>() { // from class: com.soft.blued.ui.setting.fragment.PayPasswordSettingFragment.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PayRemaining> bluedEntityA) {
                AppMethods.a((CharSequence) PayPasswordSettingFragment.this.getString(2131886100));
                if (bluedEntityA != null && bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                    try {
                        BluedPreferences.H(((DecryptJson) AppInfo.f().fromJson(AesCrypto.c(bluedEntityA.data.get(0).encrypted), (Class<Object>) DecryptJson.class)).token);
                    } catch (Exception e) {
                    }
                }
                PayPasswordSettingFragment.this.getActivity().finish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(PayPasswordSettingFragment.this.d);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(PayPasswordSettingFragment.this.d);
            }
        }, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        PayHttpUtils.a(str, new BluedUIHttpResponse() { // from class: com.soft.blued.ui.setting.fragment.PayPasswordSettingFragment.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                PayPasswordSettingFragment.this.p.a();
                return super.onUIFailure(i, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(PayPasswordSettingFragment.this.d);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                if (PayPasswordSettingFragment.this.d.isShowing()) {
                    return;
                }
                DialogUtils.a(PayPasswordSettingFragment.this.d);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                AppMethods.a((CharSequence) PayPasswordSettingFragment.this.getString(2131886100));
                PayPasswordSettingFragment.this.getActivity().finish();
            }
        }, getFragmentActive());
    }

    private void c() {
        if (getArguments() != null) {
            boolean z = getArguments().getBoolean("RECOME");
            this.o = z;
            if (z) {
                this.l.setVisibility(0);
                this.m.setVisibility(8);
                this.n.setVisibility(8);
            }
        } else {
            e();
        }
        GridCodeEditText gridCodeEditText = (GridCodeEditText) this.f33521c.findViewById(R.id.gpv_modify_pwd);
        this.p = gridCodeEditText;
        gridCodeEditText.setPasswordVisibility(true);
        this.p.setOnPasswordChangedListener(new GridCodeEditText.OnPasswordChangedListener() { // from class: com.soft.blued.ui.setting.fragment.PayPasswordSettingFragment.1
            @Override // com.soft.blued.customview.gridcodeedittext.GridCodeEditText.OnPasswordChangedListener
            public void a(String str) {
            }

            @Override // com.soft.blued.customview.gridcodeedittext.GridCodeEditText.OnPasswordChangedListener
            public void b(String str) {
                if (PayPasswordSettingFragment.this.o) {
                    PayPasswordSettingFragment.this.b(str);
                } else {
                    PayPasswordSettingFragment.this.a(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.g.setText(this.k);
        this.g.b();
        this.g.setEnabled(false);
        if (!StringUtils.d(this.j)) {
            this.h.setText(this.j);
            return;
        }
        String areaCode = AreaUtils.getAreaCode(AreaUtils.getAreaCodeList());
        if (StringUtils.d(areaCode)) {
            this.h.setText("+86");
        } else {
            this.h.setText(areaCode);
        }
    }

    private void e() {
        PayHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<PayPWDStatusModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.PayPasswordSettingFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PayPWDStatusModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData() || bluedEntityA.getSingleData().status != 1) {
                    PayPasswordSettingFragment.this.i.setCenterText(2131886221);
                    PayPasswordSettingFragment.this.l.setVisibility(0);
                    PayPasswordSettingFragment.this.m.setVisibility(8);
                    PayPasswordSettingFragment.this.n.setVisibility(8);
                    return;
                }
                String b2 = LoginRegisterTools.b();
                if (StringUtils.d(b2)) {
                    PayPasswordSettingFragment.this.i.setCenterText(2131886221);
                    PayPasswordSettingFragment.this.l.setVisibility(8);
                    PayPasswordSettingFragment.this.m.setVisibility(0);
                    PayPasswordSettingFragment.this.n.setVisibility(8);
                    return;
                }
                String[] g = LoginRegisterTools.g(b2);
                PayPasswordSettingFragment.this.j = g[0];
                PayPasswordSettingFragment.this.k = g[1];
                if (g.length < 2) {
                    PayPasswordSettingFragment.this.i.setCenterText(2131886221);
                    PayPasswordSettingFragment.this.l.setVisibility(8);
                    PayPasswordSettingFragment.this.m.setVisibility(0);
                    PayPasswordSettingFragment.this.n.setVisibility(8);
                    return;
                }
                PayPasswordSettingFragment.this.d();
                PayPasswordSettingFragment.this.i.setCenterText(2131886230);
                PayPasswordSettingFragment.this.l.setVisibility(8);
                PayPasswordSettingFragment.this.m.setVisibility(8);
                PayPasswordSettingFragment.this.n.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(PayPasswordSettingFragment.this.d);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(PayPasswordSettingFragment.this.d);
            }
        }, getFragmentActive());
    }

    protected void a() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.f33521c.findViewById(2131370749);
        this.i = commonTopTitleNoTrans;
        commonTopTitleNoTrans.a();
        this.i.f();
        this.i.setTitleBackgroundDrawable(2131101191);
        this.i.setLeftClickListener(this);
    }

    protected void b() {
        LinearLayout linearLayout = (LinearLayout) this.f33521c.findViewById(R.id.ll_modify_pwd);
        this.l = linearLayout;
        LoginRegisterTools.a(linearLayout);
        this.m = (LinearLayout) this.f33521c.findViewById(R.id.ll_pay_biding);
        this.d = DialogUtils.a(getActivity());
        this.n = (LinearLayout) this.f33521c.findViewById(R.id.ll_pay_vertify);
        TextView textView = (TextView) this.f33521c.findViewById(R.id.btn_binding);
        this.e = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) this.f33521c.findViewById(R.id.btn_vertify_next);
        this.f = textView2;
        textView2.setOnClickListener(this);
        CommonEdittextView commonEdittextView = (CommonEdittextView) this.f33521c.findViewById(R.id.cev_mobile);
        this.q = commonEdittextView;
        this.g = commonEdittextView.getEditText();
        this.h = this.q.getAreaCodeText();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131362542) {
            Bundle bundle = new Bundle();
            bundle.putString(LoginRegisterTools.k, LoginRegisterTools.o);
            bundle.putString(LoginRegisterTools.e, this.k);
            bundle.putString(LoginRegisterTools.g, this.j);
            TerminalActivity.d(getActivity(), LinkMobileFragment.class, bundle);
            getActivity().finish();
        } else if (id != 2131362666) {
            if (id != 2131363120) {
                return;
            }
            getActivity().finish();
        } else {
            BluedUIHttpResponse bluedUIHttpResponse = this.f33520a;
            LoginRegisterHttpUtils.a(bluedUIHttpResponse, this.j + "-" + this.k, "mobile", "", "", 1, getFragmentActive());
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.f33521c;
        if (view == null) {
            this.f33521c = layoutInflater.inflate(R.layout.fragment_pay_password_settings, viewGroup, false);
            a();
            b();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f33521c.getParent()).removeView(this.f33521c);
        }
        return this.f33521c;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        DialogUtils.b(this.d);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
