package com.soft.blued.ui.login_register;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.blued.android.module.common.view.ClearEditText;
import com.blued.android.module.common.view.CommonEdittextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/LinkMobileFragment.class */
public class LinkMobileFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private View f17702c;
    private Context d;
    private ClearEditText e;
    private Dialog f;
    private CommonTopTitleNoTrans g;
    private TextView h;
    private CommonEdittextView i;
    private TextView j;
    private String k;
    private String l;
    private String m;
    private TextView n;
    private TextView o;
    private CommonEdittextView p;
    private ClearEditText q;
    private String r;
    private int s;
    private String b = LinkMobileFragment.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public BluedUIHttpResponse f17701a = new BluedUIHttpResponse() { // from class: com.soft.blued.ui.login_register.LinkMobileFragment.4
        public void onUIFinish() {
            DialogUtils.b(LinkMobileFragment.this.f);
            super.onUIFinish();
        }

        public void onUIStart() {
            DialogUtils.a(LinkMobileFragment.this.f);
            super.onUIStart();
        }

        public void onUIUpdate(BluedEntity bluedEntity) {
            AppMethods.a(LinkMobileFragment.this.d.getResources().getString(2131886716));
            LinkMobileFragment.this.f();
        }
    };

    private void b() {
        CommonTopTitleNoTrans findViewById = this.f17702c.findViewById(R.id.top_title);
        this.g = findViewById;
        findViewById.a();
        this.g.setCenterText("");
        this.g.setLeftClickListener(this);
        this.g.f();
        this.g.setTitleBackgroundDrawable(2131101191);
    }

    private void c() {
        this.f = DialogUtils.a(this.d);
        this.g.setCenterText((int) R.string.binding_cellphone);
        TextView textView = (TextView) this.f17702c.findViewById(R.id.tv_to_register);
        this.h = textView;
        textView.setOnClickListener(this);
        CommonEdittextView findViewById = this.f17702c.findViewById(R.id.edv_password);
        this.p = findViewById;
        this.q = findViewById.getEditText();
        CommonEdittextView findViewById2 = this.f17702c.findViewById(R.id.edv_areacode_root);
        this.i = findViewById2;
        findViewById2.setAreaCodeClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.LinkMobileFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                Bundle bundle = new Bundle();
                bundle.putString(RegisterV1AreaCodeFragment.k, LinkMobileFragment.class.getSimpleName());
                TerminalActivity.a(LinkMobileFragment.this, RegisterV1AreaCodeFragment.class, bundle, 100);
            }
        });
        this.j = this.i.getAreaCodeText();
        ClearEditText editText = this.i.getEditText();
        this.e = editText;
        editText.setInputType(2);
        this.e.addTextChangedListener(new TextWatcher() { // from class: com.soft.blued.ui.login_register.LinkMobileFragment.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (LinkMobileFragment.this.p.getVisibility() == 8) {
                    if (TextUtils.isEmpty(LinkMobileFragment.this.e.getText().toString())) {
                        LinkMobileFragment.this.h.setEnabled(false);
                        LinkMobileFragment.this.h.setClickable(false);
                        return;
                    }
                    LinkMobileFragment.this.h.setEnabled(true);
                    LinkMobileFragment.this.h.setClickable(true);
                } else if (TextUtils.isEmpty(LinkMobileFragment.this.e.getText().toString()) || TextUtils.isEmpty(LinkMobileFragment.this.q.getText().toString())) {
                    LinkMobileFragment.this.h.setEnabled(false);
                    LinkMobileFragment.this.h.setClickable(false);
                } else {
                    LinkMobileFragment.this.h.setEnabled(true);
                    LinkMobileFragment.this.h.setClickable(true);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.n = (TextView) this.f17702c.findViewById(R.id.change_phone_notice);
        this.o = (TextView) this.f17702c.findViewById(R.id.binding_phone_notice);
        int loginType = UserInfo.getInstance().getLoginType();
        this.s = loginType;
        if (loginType == 2) {
            this.o.setText(getResources().getString(2131890505));
            this.p.setVisibility(0);
            this.q.addTextChangedListener(new TextWatcher() { // from class: com.soft.blued.ui.login_register.LinkMobileFragment.3
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TextUtils.isEmpty(LinkMobileFragment.this.e.getText().toString()) || TextUtils.isEmpty(LinkMobileFragment.this.q.getText().toString())) {
                        LinkMobileFragment.this.h.setEnabled(false);
                        LinkMobileFragment.this.h.setClickable(false);
                        return;
                    }
                    LinkMobileFragment.this.h.setEnabled(true);
                    LinkMobileFragment.this.h.setClickable(true);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
            this.o.setText(String.format(getResources().getString(2131890505), getResources().getString(2131892806)));
        }
    }

    private void d() {
        if (getArguments() != null) {
            this.r = getArguments().getString("from_page");
            this.k = getArguments().getString(LoginRegisterTools.k);
            this.l = getArguments().getString(LoginRegisterTools.g);
            this.m = getArguments().getString(LoginRegisterTools.e);
            if (!StringUtils.d(this.k) && this.k.equals(LoginRegisterTools.l)) {
                this.g.setCenterText(this.d.getResources().getString(2131890496));
                this.n.setVisibility(0);
                this.o.setVisibility(8);
                this.e.setText(this.m);
                this.e.b();
                this.e.setEnabled(false);
                this.i.setAreaCodeClickListener((View.OnClickListener) null);
            }
        }
        if (!StringUtils.d(this.l)) {
            this.j.setText(this.l);
            this.i.setEnabled(false);
            return;
        }
        String areaCode = AreaUtils.getAreaCode(AreaUtils.getAreaCodeList());
        if (StringUtils.d(areaCode)) {
            this.j.setText("+86");
        } else {
            this.j.setText(areaCode);
        }
    }

    private void e() {
        if (StringUtils.d(this.e.getText().toString())) {
            AppMethods.d(2131886603);
        } else if (!StringUtils.d(this.k) && this.k.equals(LoginRegisterTools.l)) {
            BluedUIHttpResponse bluedUIHttpResponse = this.f17701a;
            LoginRegisterHttpUtils.a(bluedUIHttpResponse, this.j.getText().toString() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.e.getText().toString(), "mobile", "", this.q.getText().toString(), 1, (IRequestHost) getFragmentActive());
        } else if (StringUtils.d(this.k) || !this.k.equals(LoginRegisterTools.o)) {
            BluedUIHttpResponse bluedUIHttpResponse2 = this.f17701a;
            LoginRegisterHttpUtils.a(bluedUIHttpResponse2, this.j.getText().toString() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.e.getText().toString(), "mobile", "", this.q.getText().toString(), 0, (IRequestHost) getFragmentActive());
        } else {
            BluedUIHttpResponse bluedUIHttpResponse3 = this.f17701a;
            LoginRegisterHttpUtils.a(bluedUIHttpResponse3, this.j.getText().toString() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.e.getText().toString(), "mobile", "", this.q.getText().toString(), 0, (IRequestHost) getFragmentActive());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Bundle bundle = new Bundle();
        bundle.putString(LoginRegisterTools.g, this.j.getText().toString());
        bundle.putString(LoginRegisterTools.e, this.e.getText().toString());
        bundle.putString(LoginRegisterTools.k, this.k);
        bundle.putString(LoginRegisterTools.m, this.q.getText().toString());
        bundle.putString("from_page", this.r);
        Logger.b(this.b, "areacode===", this.j.getText().toString());
        Logger.b(this.b, "phonenum===", this.e.getText().toString());
        TerminalActivity.d(getActivity(), LinkMobile2Fragment.class, bundle);
        getActivity().finish();
    }

    public void a() {
        int length = this.q.getText().toString().length();
        if (this.s != 2) {
            e();
        } else if (length >= 6) {
            e();
        } else {
            AppMethods.d(2131886713);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && intent != null) {
            String stringExtra = intent.getStringExtra(RegisterV1AreaCodeFragment.j);
            if (StringUtils.d(stringExtra)) {
                return;
            }
            this.j.setText(stringExtra);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131372777) {
        } else {
            a();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = getActivity();
        View view = this.f17702c;
        if (view == null) {
            this.f17702c = layoutInflater.inflate(R.layout.fragment_linkmobile_v1_step1, viewGroup, false);
            b();
            c();
            d();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f17702c.getParent()).removeView(this.f17702c);
        }
        return this.f17702c;
    }
}
