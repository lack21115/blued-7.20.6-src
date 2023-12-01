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
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.ClearEditText;
import com.blued.android.module.common.view.CommonEdittextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.RegisterV1ForEmail2Fragment;
import com.soft.blued.ui.login_register.RegisterV1ForPhone2Fragment;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/VerifyOriginalAccountDetailFragment.class */
public class VerifyOriginalAccountDetailFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final String f33629a = VerifyOriginalAccountDetailFragment.class.getSimpleName();
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f33630c;
    private ClearEditText d;
    private CommonTopTitleNoTrans e;
    private TextView f;
    private TextView g;
    private CommonEdittextView h;
    private View i;
    private String j;

    private void a() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.i.findViewById(2131370749);
        this.e = commonTopTitleNoTrans;
        commonTopTitleNoTrans.a();
        this.e.f();
        this.e.setTitleBackgroundDrawable(2131101191);
        this.e.setCenterText("");
        this.e.setLeftClickListener(this);
    }

    private void b() {
        this.f33630c = DialogUtils.a(this.b);
        this.f = (TextView) this.i.findViewById(2131371164);
        this.g = (TextView) this.i.findViewById(R.id.tv_to_mobile_verify);
        CommonEdittextView commonEdittextView = (CommonEdittextView) this.i.findViewById(R.id.cev_email);
        this.h = commonEdittextView;
        ClearEditText editText = commonEdittextView.getEditText();
        this.d = editText;
        editText.addTextChangedListener(new TextWatcher() { // from class: com.soft.blued.ui.setting.fragment.VerifyOriginalAccountDetailFragment.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                VerifyOriginalAccountDetailFragment.this.d();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
    }

    private void c() {
        if (getArguments() != null) {
            this.j = getArguments().getString("binding_type");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (TextUtils.isEmpty(this.d.getText().toString())) {
            this.f.setEnabled(false);
            this.f.setClickable(false);
            return;
        }
        this.f.setEnabled(true);
        this.f.setClickable(true);
    }

    private void e() {
        String b = LoginRegisterTools.b();
        final Bundle bundle = new Bundle();
        bundle.putString("binding_type", "change");
        bundle.putString(LoginRegisterTools.e, b);
        if (TextUtils.isEmpty(b)) {
            AppMethods.d(2131892289);
        } else {
            LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.setting.fragment.VerifyOriginalAccountDetailFragment.2
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                    try {
                        TerminalActivity.d(VerifyOriginalAccountDetailFragment.this.b, RegisterV1ForPhone2Fragment.class, bundle);
                        VerifyOriginalAccountDetailFragment.this.getActivity().finish();
                    } catch (Exception e) {
                        AppMethods.d(2131887272);
                        e.printStackTrace();
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    DialogUtils.b(VerifyOriginalAccountDetailFragment.this.f33630c);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIStart() {
                    DialogUtils.a(VerifyOriginalAccountDetailFragment.this.f33630c);
                }
            }, "mobile", "", (IRequestHost) null);
        }
    }

    private void f() {
        String obj = this.d.getText().toString();
        final Bundle bundle = new Bundle();
        bundle.putString("original_email", obj);
        bundle.putString("binding_type", "change");
        if (TextUtils.isEmpty(obj)) {
            return;
        }
        LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.setting.fragment.VerifyOriginalAccountDetailFragment.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                try {
                    TerminalActivity.d(VerifyOriginalAccountDetailFragment.this.b, RegisterV1ForEmail2Fragment.class, bundle);
                    VerifyOriginalAccountDetailFragment.this.getActivity().finish();
                } catch (Exception e) {
                    AppMethods.d(2131887272);
                    e.printStackTrace();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogUtils.b(VerifyOriginalAccountDetailFragment.this.f33630c);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                DialogUtils.a(VerifyOriginalAccountDetailFragment.this.f33630c);
            }
        }, "email", obj, (IRequestHost) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id == 2131371164) {
            f();
        } else if (id != 2131372774) {
        } else {
            e();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        View view = this.i;
        if (view == null) {
            this.i = layoutInflater.inflate(R.layout.fragment_verify_original, viewGroup, false);
            a();
            b();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.i.getParent()).removeView(this.i);
        }
        return this.i;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        d();
    }
}
