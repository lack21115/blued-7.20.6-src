package com.soft.blued.ui.login_register.View;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.db.UserAccountsVDao;
import com.blued.android.module.common.db.model.UserAccountsModel;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.blued.android.module.common.view.ClearEditText;
import com.blued.android.module.common.view.CommonEdittextView;
import com.blued.android.module.common.view.CommonGuidePop;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.activity.PhoneOrEmailLoginActivity;
import com.blued.login.constant.LoginConstants;
import com.blued.login.log.EventTrackLogin;
import com.bytedance.applog.tracker.Tracker;
import com.ishumei.sdk.captcha.SmCaptchaWebView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.login_register.Contract.LoginWithTypeContract;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.RegisterV1AreaCodeFragment;
import com.soft.blued.ui.login_register.SignInActivity;
import com.soft.blued.ui.login_register.model.AppConfigModel;
import com.soft.blued.ui.login_register.presenter.LoginWithTypePresenter;
import com.soft.blued.ui.login_register.utils.LoginTool;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/View/LoginWithPhoneFragment.class */
public class LoginWithPhoneFragment extends BaseFragment implements View.OnClickListener, LoginWithTypeContract.IView {
    private CommonGuidePop A;
    private boolean B = true;
    private boolean C = true;
    private ConstraintLayout D;
    private Dialog E;

    /* renamed from: a  reason: collision with root package name */
    public View f31507a;
    public ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public CommonEdittextView f31508c;
    public CommonEdittextView d;
    public CommonEdittextView e;
    public ClearEditText f;
    public ClearEditText g;
    public ClearEditText h;
    public TextView i;
    public View j;
    public TextView k;
    public ClearEditText l;
    private Context m;
    private LoginWithTypeContract.IPresenter n;
    private View o;
    private Dialog p;
    private TextView q;
    private TextView r;
    private Bundle s;
    private CountDownTimer t;
    private boolean u;
    private boolean v;
    private CommonTopTitleNoTrans w;
    private CheckBox x;
    private boolean y;
    private boolean z;

    public static void a(Context context, Bundle bundle) {
        PhoneOrEmailLoginActivity.d.a(context, LoginWithPhoneFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        if (this.B) {
            EventTrackLogin.a(LoginAndRegisterProtos.Event.AUTHCODE_GET_CLICK, LoginAndRegisterProtos.Source.UNKNOWN_SOURCE);
            this.B = false;
        } else {
            EventTrackLogin.a(LoginAndRegisterProtos.Event.AUTHCODE_RESEND_BTN_CLICK, LoginAndRegisterProtos.Source.UNKNOWN_SOURCE);
        }
        if (StringUtils.d(this.g.getText().toString())) {
            AppMethods.a((CharSequence) AppInfo.d().getResources().getString(2131886704));
        } else if (this.y) {
            j();
        } else if (this.x.isChecked()) {
            j();
        } else {
            LoginTool.f31584a.a(this.x, this.A, this.o.findViewById(2131364005));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        Bundle bundle = this.s;
        return bundle != null && bundle.containsKey("aliasUserId");
    }

    private void m() {
        this.D = (ConstraintLayout) this.o.findViewById(R.id.cl_main);
        this.A = LoginTool.f31584a.a(getContext());
        this.p = DialogUtils.a(this.m);
        CommonEdittextView commonEdittextView = (CommonEdittextView) this.o.findViewById(2131362783);
        this.e = commonEdittextView;
        commonEdittextView.a();
        this.b = (ImageView) this.o.findViewById(2131361892);
        this.f = this.e.getEditText();
        TextView textView = (TextView) this.o.findViewById(R.id.tv_one_login_btn);
        this.r = textView;
        textView.setVisibility(8);
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.View.-$$Lambda$LoginWithPhoneFragment$Z65x9f27VmGO0S_4y21KA2uanno
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        CommonEdittextView commonEdittextView2 = (CommonEdittextView) this.o.findViewById(R.id.cev_password);
        this.d = commonEdittextView2;
        commonEdittextView2.a();
        ClearEditText editText = this.d.getEditText();
        this.h = editText;
        editText.setInputType(128);
        this.h.setTypeface(Typeface.DEFAULT);
        this.h.setTransformationMethod(new PasswordTransformationMethod());
        CommonEdittextView commonEdittextView3 = (CommonEdittextView) this.o.findViewById(R.id.cev_mobile);
        this.f31508c = commonEdittextView3;
        commonEdittextView3.a();
        ClearEditText editText2 = this.f31508c.getEditText();
        this.g = editText2;
        editText2.setInputType(2);
        this.f31507a = this.o.findViewById(2131367685);
        this.i = this.f31508c.getAreaCodeText();
        this.q = (TextView) this.o.findViewById(R.id.tv_login);
        this.j = this.o.findViewById(R.id.ll_phone_vcode);
        this.k = (TextView) this.o.findViewById(R.id.tv_vcode_desc);
        this.g.addTextChangedListener(new TextWatcher() { // from class: com.soft.blued.ui.login_register.View.LoginWithPhoneFragment.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if ("+86".equals(LoginWithPhoneFragment.this.i.getText().toString()) && editable.toString().length() > 11) {
                    LoginWithPhoneFragment.this.g.setText(editable.toString().substring(0, 11));
                } else if (!LoginWithPhoneFragment.this.k.isEnabled() || TextUtils.isEmpty(editable.toString())) {
                    LoginWithPhoneFragment.this.k.setTextColor(BluedSkinUtils.a(LoginWithPhoneFragment.this.getContext(), 2131102264));
                } else {
                    LoginWithPhoneFragment.this.k.setTextColor(BluedSkinUtils.a(LoginWithPhoneFragment.this.getContext(), 2131101766));
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.g.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.soft.blued.ui.login_register.View.LoginWithPhoneFragment.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Tracker.onFocusChange(view, z);
                if (!z || LoginWithPhoneFragment.this.x.isChecked()) {
                    return;
                }
                LoginTool.f31584a.a(LoginWithPhoneFragment.this.x, LoginWithPhoneFragment.this.A, LoginWithPhoneFragment.this.o.findViewById(2131364005));
            }
        });
        this.h.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.soft.blued.ui.login_register.View.LoginWithPhoneFragment.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Tracker.onFocusChange(view, z);
                if (!z || LoginWithPhoneFragment.this.x.isChecked()) {
                    return;
                }
                LoginTool.f31584a.a(LoginWithPhoneFragment.this.x, LoginWithPhoneFragment.this.A, LoginWithPhoneFragment.this.o.findViewById(2131364005));
            }
        });
        ClearEditText clearEditText = (ClearEditText) this.o.findViewById(R.id.edt_phone_vcode);
        this.l = clearEditText;
        clearEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.soft.blued.ui.login_register.View.LoginWithPhoneFragment.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Tracker.onFocusChange(view, z);
                if (!z || LoginWithPhoneFragment.this.x.isChecked()) {
                    return;
                }
                LoginTool.f31584a.a(LoginWithPhoneFragment.this.x, LoginWithPhoneFragment.this.A, LoginWithPhoneFragment.this.o.findViewById(2131364005));
            }
        });
        this.l.setInputType(2);
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.View.-$$Lambda$LoginWithPhoneFragment$0PXAlfMLxFE8KP5S3UPRrgrB6GA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginWithPhoneFragment.this.a(view);
            }
        });
        this.o.findViewById(R.id.tv_login_Q).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.View.LoginWithPhoneFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LoginRegisterTools.b(LoginWithPhoneFragment.this.getActivity());
            }
        });
        final String string = this.m.getResources().getString(2131888229);
        this.t = new CountDownTimer(60000L, 1000L) { // from class: com.soft.blued.ui.login_register.View.LoginWithPhoneFragment.7
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (TextUtils.isEmpty(LoginWithPhoneFragment.this.f31508c.getEditText().getText().toString())) {
                    LoginWithPhoneFragment.this.k.setTextColor(BluedSkinUtils.a(LoginWithPhoneFragment.this.m, 2131102264));
                } else {
                    LoginWithPhoneFragment.this.k.setTextColor(BluedSkinUtils.a(LoginWithPhoneFragment.this.m, 2131101766));
                }
                LoginWithPhoneFragment.this.k.setEnabled(true);
                LoginWithPhoneFragment.this.k.setText(2131891539);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                TextView textView2 = LoginWithPhoneFragment.this.k;
                String str = string;
                textView2.setText(String.format(str, (j / 1000) + ""));
            }
        };
        this.x = (CheckBox) this.o.findViewById(2131364005).findViewById(2131362774);
        LoginTool.f31584a.a(this.o, false);
        LiveEventBus.get(EventBusConstant.KEY_EVENT_LOGIN_CHECK, Boolean.class).observe(this, new Observer<Boolean>() { // from class: com.soft.blued.ui.login_register.View.LoginWithPhoneFragment.8
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                if (bool.booleanValue()) {
                    LoginTool.f31584a.a(LoginWithPhoneFragment.this.x, LoginWithPhoneFragment.this.A, LoginWithPhoneFragment.this.o.findViewById(2131364005));
                }
            }
        });
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.o.findViewById(2131370694);
        this.w = commonTopTitleNoTrans;
        commonTopTitleNoTrans.setRightText(2131891264);
        this.w.setRightTextColor(2131101766);
        this.w.getLeftImg().setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.View.LoginWithPhoneFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LoginWithPhoneFragment.this.getActivity().finish();
            }
        });
        this.w.getRightTextView().setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.View.LoginWithPhoneFragment.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (!LoginWithPhoneFragment.this.x.isChecked()) {
                    LoginTool.f31584a.a(LoginWithPhoneFragment.this.x, LoginWithPhoneFragment.this.A, LoginWithPhoneFragment.this.o.findViewById(2131364005));
                    return;
                }
                int i = 8;
                if (LoginWithPhoneFragment.this.m.getResources().getString(2131891264).equals(LoginWithPhoneFragment.this.w.getRightTextView().getText().toString())) {
                    LoginWithPhoneFragment.this.o.findViewById(R.id.tv_login_hint).setVisibility(0);
                    LoginWithPhoneFragment.this.w.setRightText(2131891263);
                    LoginWithPhoneFragment.this.d.setVisibility(8);
                    LoginWithPhoneFragment.this.j.setVisibility(0);
                    View view2 = LoginWithPhoneFragment.this.f31507a;
                    if (LoginWithPhoneFragment.this.v) {
                        i = 0;
                    }
                    view2.setVisibility(i);
                    return;
                }
                LoginWithPhoneFragment.this.o.findViewById(R.id.tv_login_hint).setVisibility(4);
                LoginWithPhoneFragment.this.w.setRightText(2131891264);
                LoginWithPhoneFragment.this.d.setVisibility(0);
                LoginWithPhoneFragment.this.j.setVisibility(8);
                View view3 = LoginWithPhoneFragment.this.f31507a;
                if (LoginWithPhoneFragment.this.u) {
                    i = 0;
                }
                view3.setVisibility(i);
            }
        });
        this.w.getRightTextView().performClick();
        k();
    }

    private void n() {
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.login_register.View.LoginWithPhoneFragment.11
            @Override // java.lang.Runnable
            public void run() {
                if (LoginWithPhoneFragment.this.C) {
                    LoginWithTypeContract.IPresenter iPresenter = LoginWithPhoneFragment.this.n;
                    Context context = LoginWithPhoneFragment.this.m;
                    iPresenter.a(context, LoginWithPhoneFragment.this.i.getText().toString() + "-" + LoginWithPhoneFragment.this.g.getText().toString(), LoginWithPhoneFragment.this.f.getText().toString(), LoginWithPhoneFragment.this.l.getText().toString());
                }
            }
        }, 45000L);
    }

    private void o() {
        this.b.setOnClickListener(this);
        TextWatcher textWatcher = new TextWatcher() { // from class: com.soft.blued.ui.login_register.View.LoginWithPhoneFragment.12
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                LoginWithPhoneFragment.this.k();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        TextWatcher textWatcher2 = new TextWatcher() { // from class: com.soft.blued.ui.login_register.View.LoginWithPhoneFragment.13
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                LoginWithPhoneFragment.this.k();
                if (LoginWithPhoneFragment.this.q.isEnabled()) {
                    LoginWithPhoneFragment.this.r();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.f.addTextChangedListener(textWatcher);
        this.g.addTextChangedListener(textWatcher);
        this.h.addTextChangedListener(textWatcher);
        this.l.addTextChangedListener(textWatcher2);
        if (!this.y) {
            this.i.setOnClickListener(this);
        }
        this.q.setOnClickListener(this);
    }

    private void p() {
        UserAccountsModel a2;
        String areaCode = AreaUtils.getAreaCode(AreaUtils.getAreaCodeList());
        if (StringUtils.d(areaCode)) {
            this.i.setText("+86");
        } else {
            this.i.setText(areaCode);
        }
        if (getArguments() != null) {
            boolean z = getArguments().getBoolean("is_bind_phone", false);
            this.y = z;
            if (z) {
                boolean z2 = getArguments().getBoolean("is_from_home", false);
                this.z = z2;
                this.n.a(z2);
                q();
            }
        }
        if (l() || this.y || (a2 = UserAccountsVDao.a().a(1)) == null || StringUtils.d(a2.getUsername()) || !a2.getUsername().contains("-")) {
            return;
        }
        String[] split = a2.getUsername().split("-");
        this.i.setText(split[0]);
        this.g.setText(split[1]);
        this.g.setSelection(split[1].length());
    }

    private void q() {
        this.o.findViewById(R.id.tv_login_hint).setVisibility(4);
        this.o.findViewById(R.id.tv_login_Q).setVisibility(4);
        this.o.findViewById(R.id.tv_login_hint).setVisibility(4);
        this.w.getRightTextView().setVisibility(4);
        if (this.z) {
            this.w.getLeftImg().setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.l.getText().toString().length() == 6) {
            this.q.performClick();
        }
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void a() {
        DialogUtils.b(this.p);
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void a(String str) {
        Context context = this.m;
        CommonAlertDialog.a(context, context.getString(R.string.common_string_notice), str, this.m.getString(R.string.qr_scan_login_close), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null, 0);
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void a(final String str, final String str2) {
        View inflate = LayoutInflater.from(this.m).inflate(R.layout.send_sms_dialog_custom, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(2131371186);
        ShapeTextView shapeTextView = (ShapeTextView) inflate.findViewById(R.id.tv_to_send);
        ShapeTextView shapeTextView2 = (ShapeTextView) inflate.findViewById(R.id.tv_sended);
        ImageView imageView = (ImageView) inflate.findViewById(2131365207);
        this.E = new Dialog(this.m);
        textView.setText(this.m.getString(2131890478) + this.g.getText().toString() + this.m.getString(2131890483) + str + this.m.getString(2131890482) + str2 + this.m.getString(2131890485));
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.View.LoginWithPhoneFragment.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.USER_VERIFY_POP_SEND_CLICK);
                try {
                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + str2));
                    intent.putExtra("sms_body", str);
                    LoginWithPhoneFragment.this.getActivity().startActivity(intent);
                } catch (Exception e) {
                }
            }
        });
        shapeTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.View.LoginWithPhoneFragment.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.USER_VERIFY_POP_DONE_CLICK);
                LoginWithTypeContract.IPresenter iPresenter = LoginWithPhoneFragment.this.n;
                LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE phone_code_login_stage = LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE.VERIFY_UP;
                iPresenter.a(phone_code_login_stage, LoginWithPhoneFragment.this.i.getText().toString() + "-" + LoginWithPhoneFragment.this.g.getText().toString(), str, "");
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.View.LoginWithPhoneFragment.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LoginWithPhoneFragment.this.E.dismiss();
            }
        });
        this.E.setContentView(inflate);
        this.E.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.E.setCanceledOnTouchOutside(false);
        this.E.show();
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.USER_VERIFY_POP_SHOW);
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void a(String str, boolean z) {
        LoginRegisterTools.a(getFragmentActive(), this.b, str);
        this.f31507a.setVisibility(0);
        this.f.requestFocus();
        if (z) {
            this.u = true;
        } else {
            this.v = true;
        }
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void a(boolean z) {
        LoginRegisterTools.a(this.m, new SmCaptchaWebView.ResultListener() { // from class: com.soft.blued.ui.login_register.View.LoginWithPhoneFragment.14
            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
            public void onError(int i) {
            }

            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
            public void onReady() {
            }

            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
            public void onSuccess(CharSequence charSequence, boolean z2) {
                if (z2) {
                    LoginWithPhoneFragment.this.n.b(charSequence.toString());
                    LoginWithPhoneFragment.this.q.callOnClick();
                }
            }
        });
        if (z) {
            this.u = true;
        } else {
            this.v = true;
        }
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void b() {
        DialogUtils.a(this.p);
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void c() {
        LoginRegisterTools.a(getActivity(), 0);
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void d() {
        this.k.setTextColor(BluedSkinUtils.a(this.m, 2131102264));
        this.k.setEnabled(false);
        this.k.setText(String.format(this.m.getResources().getString(2131888229), Camera.Parameters.VIDEO_HFR_2X));
        this.t.start();
        if (this.y) {
            return;
        }
        n();
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public int e() {
        return this.j.getVisibility() == 0 ? 1 : 0;
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void f() {
        this.f31508c.getEditText().setText("");
        this.l.setText("");
        this.f31508c.getEditText().requestFocus();
        KeyboardUtils.a(this.f31508c.getEditText().getContext(), this.f31508c.getEditText());
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void g() {
        getActivity().finish();
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void h() {
        Dialog dialog = this.E;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void i() {
        LoginRegisterHttpUtils.a(getFragmentActive(), new BluedUIHttpResponse<BluedEntityA<AppConfigModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.login_register.View.LoginWithPhoneFragment.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<AppConfigModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData() || bluedEntityA.getSingleData().oneclick == 1) {
                    if (LoginWithPhoneFragment.this.l()) {
                        LoginWithPhoneFragment.this.r.setVisibility(8);
                    } else {
                        LoginWithPhoneFragment.this.r.setVisibility(0);
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return true;
            }
        });
    }

    public void j() {
        if (this.y) {
            LoginWithTypeContract.IPresenter iPresenter = this.n;
            LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE phone_code_login_stage = LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE.IDENTIFY;
            iPresenter.a(phone_code_login_stage, this.i.getText().toString() + "-" + this.g.getText().toString(), this.l.getText().toString());
        } else {
            LoginWithTypeContract.IPresenter iPresenter2 = this.n;
            LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE phone_code_login_stage2 = LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE.IDENTIFY;
            iPresenter2.a(phone_code_login_stage2, this.i.getText().toString() + "-" + this.g.getText().toString(), this.f.getText().toString(), this.l.getText().toString());
        }
        this.l.requestFocus();
        KeyboardUtils.a(this.l.getContext(), this.l);
    }

    public void k() {
        if (this.m.getResources().getString(2131891263).equals(this.w.getRightTextView().getText().toString())) {
            if (StringUtils.d(this.g.getText().toString()) || StringUtils.d(this.l.getText().toString())) {
                this.q.setEnabled(false);
            } else if (this.f31507a.getVisibility() != 0) {
                this.q.setEnabled(true);
            } else if (StringUtils.d(this.f.getText().toString())) {
                this.q.setEnabled(false);
            } else {
                this.q.setEnabled(true);
            }
        } else if (StringUtils.d(this.g.getText().toString()) || StringUtils.d(this.h.getText().toString())) {
            this.q.setEnabled(false);
        } else if (this.f31507a.getVisibility() != 0) {
            this.q.setEnabled(true);
        } else if (StringUtils.d(this.f.getText().toString())) {
            this.q.setEnabled(false);
        } else {
            this.q.setEnabled(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && intent != null) {
            String stringExtra = intent.getStringExtra(RegisterV1AreaCodeFragment.j);
            if (StringUtils.d(stringExtra)) {
                return;
            }
            LoginConstants.f20505c = stringExtra;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        return this.z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131361892) {
            if (this.m.getResources().getString(2131891263).equals(this.w.getRightTextView().getText().toString())) {
                if (StringUtils.d(this.n.c())) {
                    return;
                }
                a(this.n.c(), false);
            } else if (StringUtils.d(this.n.b())) {
            } else {
                a(this.n.b(), true);
            }
        } else if (id == 2131370914) {
            if (!this.x.isChecked()) {
                LoginTool.f31584a.a(this.x, this.A, this.o.findViewById(2131364005));
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(RegisterV1AreaCodeFragment.k, LoginWithPhoneFragment.class.getSimpleName());
            TerminalActivity.a(this, RegisterV1AreaCodeFragment.class, bundle, 100);
        } else if (id != 2131371873) {
        } else {
            KeyboardUtils.a(getActivity());
            EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.AUTHCODE_CONFIRM_BTN_CLICK);
            if (!this.x.isChecked()) {
                LoginTool.f31584a.a(this.x, this.A, this.o.findViewById(2131364005));
                return;
            }
            BluedPreferences.aE();
            if (!this.m.getResources().getString(2131891263).equals(this.w.getRightTextView().getText().toString())) {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_BTN_CLICK, LoginAndRegisterProtos.Source.PHONE);
                if (StringUtils.d(this.g.getText().toString()) || StringUtils.d(this.h.getText().toString())) {
                    AppMethods.a((CharSequence) AppInfo.d().getResources().getString(R.string.user_login_fail));
                    return;
                }
                LoginWithTypeContract.IPresenter iPresenter = this.n;
                iPresenter.a("mobile", this.i.getText().toString() + "-" + this.g.getText().toString(), this.h.getText().toString(), this.n.d(), this.f.getText().toString());
            } else if (StringUtils.d(this.g.getText().toString()) || StringUtils.d(this.l.getText().toString())) {
                AppMethods.a((CharSequence) AppInfo.d().getResources().getString(2131891287));
            } else {
                if (this.y) {
                    LoginWithTypeContract.IPresenter iPresenter2 = this.n;
                    LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE phone_code_login_stage = LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE.VERIFY;
                    iPresenter2.a(phone_code_login_stage, this.i.getText().toString() + "-" + this.g.getText().toString(), this.l.getText().toString());
                } else {
                    EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_BTN_CLICK, LoginAndRegisterProtos.Source.PHONE);
                    LoginWithTypeContract.IPresenter iPresenter3 = this.n;
                    LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE phone_code_login_stage2 = LoginRegisterHttpUtils.PHONE_CODE_LOGIN_STAGE.VERIFY;
                    iPresenter3.a(phone_code_login_stage2, this.i.getText().toString() + "-" + this.g.getText().toString(), this.f.getText().toString(), this.l.getText().toString());
                }
                this.C = false;
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity activity = getActivity();
        this.m = activity;
        View view = this.o;
        if (view == null) {
            this.n = new LoginWithTypePresenter(activity, this, getFragmentActive());
            this.o = layoutInflater.inflate(R.layout.fragment_login_v1_mobile, viewGroup, false);
            this.s = getArguments();
            m();
            p();
            i();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.o.getParent()).removeView(this.o);
        }
        return this.o;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a();
        CountDownTimer countDownTimer = this.t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.t = null;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (TextUtils.isEmpty(SignInActivity.e) || TextUtils.isEmpty(SignInActivity.f)) {
            if (this.i == null || StringUtils.d(LoginConstants.f20505c)) {
                return;
            }
            this.i.setText(LoginConstants.f20505c);
            return;
        }
        this.i.setText(SignInActivity.f);
        this.g.setText(SignInActivity.e);
        this.g.setSelection(SignInActivity.e.length());
        SignInActivity.e = null;
        SignInActivity.f = null;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (l()) {
            this.n.a(this.s.getString("aliasUserId"));
        }
        o();
    }
}
