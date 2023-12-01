package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.ClearEditText;
import com.blued.android.module.common.view.CommonEdittextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.RegisterV1ForEmail2Fragment;
import com.soft.blued.ui.setting.Contract.BindingSecureEmailContract;
import com.soft.blued.ui.setting.Presenter.BindingSecureEmailPresenter;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/BindingSecureEmailFragment.class */
public class BindingSecureEmailFragment extends BaseFragment implements View.OnClickListener, BindingSecureEmailContract.IView {
    private BindingSecureEmailContract.IPresenter b;

    /* renamed from: c  reason: collision with root package name */
    private Context f19634c;
    private ImageView d;
    private CommonEdittextView e;
    private CommonEdittextView f;
    private Dialog g;
    private ClearEditText h;
    private ClearEditText i;
    private TextView j;
    private View k;
    private TextWatcher l;

    /* renamed from: a  reason: collision with root package name */
    private String f19633a = BindingSecureEmailFragment.class.getSimpleName();
    private String m = "";

    private void g() {
        if (getArguments() != null) {
            this.m = getArguments().getString("binding_type");
        }
    }

    private void h() {
        CommonTopTitleNoTrans findViewById = this.k.findViewById(R.id.top_title);
        findViewById.a();
        findViewById.f();
        findViewById.setTitleBackgroundDrawable(2131101191);
        findViewById.setCenterText("");
        findViewById.setLeftClickListener(this);
        if ("add".equals(this.m)) {
            findViewById.setCenterText(this.f19634c.getString(2131892292));
        } else {
            findViewById.setCenterText(this.f19634c.getString(R.string.change_secure_email));
        }
        this.d = (ImageView) this.k.findViewById(2131361892);
        CommonEdittextView findViewById2 = this.k.findViewById(2131362783);
        this.f = findViewById2;
        this.h = findViewById2.getEditText();
        CommonEdittextView findViewById3 = this.k.findViewById(R.id.cev_email);
        this.e = findViewById3;
        this.i = findViewById3.getEditText();
        this.g = DialogUtils.a(this.f19634c);
        this.j = (TextView) this.k.findViewById(R.id.tv_next_step);
    }

    private void i() {
        this.d.setOnClickListener(this);
        this.j.setOnClickListener(this);
        TextWatcher textWatcher = new TextWatcher() { // from class: com.soft.blued.ui.setting.fragment.BindingSecureEmailFragment.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                BindingSecureEmailFragment.this.f();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.l = textWatcher;
        this.h.addTextChangedListener(textWatcher);
        this.i.addTextChangedListener(this.l);
    }

    @Override // com.soft.blued.ui.setting.Contract.BindingSecureEmailContract.IView
    public void a() {
        DialogUtils.b(this.g);
    }

    @Override // com.soft.blued.ui.setting.Contract.BindingSecureEmailContract.IView
    public void a(Bundle bundle) {
        TerminalActivity.d(this.f19634c, RegisterV1ForEmail2Fragment.class, bundle);
        getActivity().finish();
    }

    @Override // com.soft.blued.ui.setting.Contract.BindingSecureEmailContract.IView
    public void a(String str) {
        LoginRegisterTools.a((IRequestHost) getFragmentActive(), this.d, str);
    }

    @Override // com.soft.blued.ui.setting.Contract.BindingSecureEmailContract.IView
    public void b() {
        DialogUtils.a(this.g);
    }

    @Override // com.soft.blued.ui.setting.Contract.BindingSecureEmailContract.IView
    public void c() {
        AppMethods.d(2131887272);
    }

    @Override // com.soft.blued.ui.setting.Contract.BindingSecureEmailContract.IView
    public void d() {
        AppMethods.d(2131886716);
    }

    @Override // com.soft.blued.ui.setting.Contract.BindingSecureEmailContract.IView
    public void e() {
        AppMethods.d(2131886677);
    }

    public void f() {
        if (StringUtils.d(this.i.getText().toString()) || StringUtils.d(this.h.getText().toString())) {
            this.j.setClickable(false);
            this.j.setEnabled(false);
            return;
        }
        this.j.setClickable(true);
        this.j.setEnabled(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        try {
            int id = view.getId();
            if (id == 2131361892) {
                if (StringUtils.d(this.b.b())) {
                    return;
                }
                a(this.b.b());
            } else if (id == 2131363120) {
                getActivity().finish();
            } else if (id != 2131372079) {
            } else {
                String obj = this.h.getText().toString();
                String obj2 = this.i.getText().toString();
                if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2)) {
                    return;
                }
                this.b.a(obj, 0, obj2, this.m);
            }
        } catch (Exception e) {
            e.printStackTrace();
            AppMethods.a(this.f19634c.getString(R.string.operate_fail));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f19634c = getActivity();
        View view = this.k;
        if (view == null) {
            this.k = layoutInflater.inflate(R.layout.fragment_binding_secure_email_step1, viewGroup, false);
            g();
            h();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.k.getParent()).removeView(this.k);
        }
        return this.k;
    }

    public void onStart() {
        super.onStart();
        f();
        this.b.ar_();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        i();
        this.b = new BindingSecureEmailPresenter(this.f19634c, this);
    }
}
