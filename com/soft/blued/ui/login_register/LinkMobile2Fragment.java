package com.soft.blued.ui.login_register;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.BluedLoginResultVerBinding;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.login.LoginAndRegisterProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.gridcodeedittext.GridCodeEditText;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.setting.fragment.PayPasswordSettingFragment;
import com.soft.blued.ui.setting.model.LoginProtectionModel;
import com.soft.blued.utils.StringUtils;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/LinkMobile2Fragment.class */
public class LinkMobile2Fragment extends BaseFragment implements View.OnClickListener {
    private View d;
    private Context e;
    private Dialog f;
    private CommonTopTitleNoTrans g;
    private TextView h;
    private String i;
    private String j;
    private GridCodeEditText k;
    private TextView l;
    private String m;
    private String n;
    private TextView o;
    private int p;
    private String q;
    private Dialog s;

    /* renamed from: c  reason: collision with root package name */
    private String f17685c = LinkMobile2Fragment.class.getSimpleName();
    private boolean r = true;

    /* renamed from: a  reason: collision with root package name */
    Runnable f17684a = new Runnable() { // from class: com.soft.blued.ui.login_register.LinkMobile2Fragment.3
        @Override // java.lang.Runnable
        public void run() {
            if (LinkMobile2Fragment.this.p == 0) {
                LinkMobile2Fragment.this.l.setEnabled(true);
                LinkMobile2Fragment.this.l.setClickable(true);
                LinkMobile2Fragment.this.l.setText(LinkMobile2Fragment.this.getResources().getString(2131891539));
                LinkMobile2Fragment.this.l.setTextColor(LinkMobile2Fragment.this.getResources().getColor(2131101190));
                return;
            }
            LinkMobile2Fragment.this.l.setEnabled(false);
            LinkMobile2Fragment.this.l.setClickable(false);
            LinkMobile2Fragment.this.l.setText(String.format(LinkMobile2Fragment.this.getResources().getString(2131886709), Integer.valueOf(LinkMobile2Fragment.this.p)));
            LinkMobile2Fragment.this.l.setTextColor(LinkMobile2Fragment.this.getResources().getColor(2131101206));
            LinkMobile2Fragment.g(LinkMobile2Fragment.this);
            if (LinkMobile2Fragment.this.p == 0) {
                LinkMobile2Fragment.this.postSafeRunOnUiThread(this);
            } else {
                LinkMobile2Fragment.this.postDelaySafeRunOnUiThread(this, 1000L);
            }
        }
    };
    public BluedUIHttpResponse b = new BluedUIHttpResponse(getFragmentActive()) { // from class: com.soft.blued.ui.login_register.LinkMobile2Fragment.13
        public boolean onUIFailure(int i, String str) {
            if (i == 4036210) {
                LinkMobile2Fragment.this.getActivity().finish();
            }
            return super.onUIFailure(i, str);
        }

        public void onUIFinish() {
            DialogUtils.b(LinkMobile2Fragment.this.f);
            super.onUIFinish();
        }

        public void onUIStart() {
            DialogUtils.a(LinkMobile2Fragment.this.f);
            super.onUIStart();
        }

        public void onUIUpdate(BluedEntity bluedEntity) {
            LinkMobile2Fragment.this.c(-1);
        }
    };

    private void a() {
        CommonTopTitleNoTrans findViewById = this.d.findViewById(R.id.top_title);
        this.g = findViewById;
        findViewById.a();
        this.g.f();
        this.g.setTitleBackgroundDrawable(2131101780);
        this.g.setLeftClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i, final String str) {
        Context context = this.e;
        CommonAlertDialog.a(context, "", context.getResources().getString(2131890498), this.e.getResources().getString(2131886718), (DialogInterface.OnClickListener) null, this.e.getResources().getString(2131886739), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.LinkMobile2Fragment.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Tracker.onClick(dialogInterface, i2);
                switch (i) {
                    case 4036208:
                        LinkMobile2Fragment.this.c(str);
                        return;
                    case 4036209:
                        LinkMobile2Fragment.this.b(str);
                        return;
                    default:
                        return;
                }
            }
        }, (DialogInterface.OnDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.USER_VERIFY_POP_FAIL);
        Context context = this.e;
        CommonAlertDialog.a(context, context.getString(R.string.common_string_notice), str, this.e.getString(R.string.qr_scan_login_close), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null, 0);
    }

    private void b() {
        this.o = (TextView) this.d.findViewById(R.id.tv_desc);
        this.f = DialogUtils.a(this.e);
        TextView textView = (TextView) this.d.findViewById(2131371164);
        this.h = textView;
        textView.setOnClickListener(this);
        GridCodeEditText gridCodeEditText = (GridCodeEditText) this.d.findViewById(R.id.et_ver_code);
        this.k = gridCodeEditText;
        gridCodeEditText.setPasswordVisibility(true);
        this.k.setOnPasswordChangedListener(new GridCodeEditText.OnPasswordChangedListener() { // from class: com.soft.blued.ui.login_register.LinkMobile2Fragment.1
            @Override // com.soft.blued.customview.gridcodeedittext.GridCodeEditText.OnPasswordChangedListener
            public void a(String str) {
                if (str == null || str.length() != 6) {
                    LinkMobile2Fragment.this.h.setEnabled(false);
                    LinkMobile2Fragment.this.h.setClickable(false);
                    return;
                }
                LinkMobile2Fragment.this.h.setEnabled(true);
                LinkMobile2Fragment.this.h.setClickable(true);
            }

            @Override // com.soft.blued.customview.gridcodeedittext.GridCodeEditText.OnPasswordChangedListener
            public void b(String str) {
            }
        });
        TextView textView2 = (TextView) this.d.findViewById(R.id.lr_btn_countdown);
        this.l = textView2;
        textView2.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Context context = this.e;
        CommonAlertDialog.a(context, "", str, context.getResources().getString(2131886718), (DialogInterface.OnClickListener) null, this.e.getResources().getString(2131886752), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.LinkMobile2Fragment.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                LinkMobile2Fragment.this.l();
            }
        }, (DialogInterface.OnDismissListener) null);
    }

    private void c() {
        if (getArguments() != null) {
            this.q = getArguments().getString("from_page");
            this.i = getArguments().getString(LoginRegisterTools.e);
            this.j = getArguments().getString(LoginRegisterTools.g);
            this.m = getArguments().getString(LoginRegisterTools.k);
            TextView textView = this.o;
            textView.setText(getResources().getString(2131886705) + LoginRegisterTools.e(this.i) + "\n" + getResources().getString(2131886707));
            if (!StringUtils.d(this.m) && (this.m.equals(LoginRegisterTools.l) || this.m.equals(LoginRegisterTools.n))) {
                this.g.setCenterText(getResources().getString(2131890502));
                TextView textView2 = this.o;
                textView2.setText(getResources().getString(2131886706) + LoginRegisterTools.e(this.i) + "\n" + getResources().getString(2131886707));
            }
            this.n = getArguments().getString(LoginRegisterTools.m);
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        if (!StringUtils.d(this.m) && this.m.equals(LoginRegisterTools.l)) {
            TerminalActivity.d(getActivity(), LinkMobileFragment.class, (Bundle) null);
            getActivity().finish();
            return;
        }
        BluedLoginResultVerBinding verified_bindings = UserInfo.getInstance().getLoginUserInfo().getVerified_bindings();
        BluedLoginResultVerBinding bluedLoginResultVerBinding = verified_bindings;
        if (verified_bindings == null) {
            bluedLoginResultVerBinding = new BluedLoginResultVerBinding();
        }
        bluedLoginResultVerBinding.mobile = LoginRegisterTools.a(this.j, this.i);
        UserInfo.getInstance().getLoginUserInfo().setNeed_auth(0);
        if (StringUtils.d(this.m) || !(this.m.equals(LoginRegisterTools.n) || this.m.equals(LoginRegisterTools.o))) {
            AppMethods.d(2131890501);
            k();
            if ("login_secure".equals(this.q)) {
                j();
                return;
            } else {
                getActivity().finish();
                return;
            }
        }
        if (i == 3) {
            EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.USER_VERIFY_POP_SUCCESS);
            Dialog dialog = this.s;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("RECOME", true);
        TerminalActivity.d(getActivity(), PayPasswordSettingFragment.class, bundle);
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Context context = this.e;
        CommonAlertDialog.a(context, "", str, context.getResources().getString(2131886718), (DialogInterface.OnClickListener) null, this.e.getResources().getString(2131886752), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.LinkMobile2Fragment.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                LinkMobile2Fragment.this.l();
            }
        }, (DialogInterface.OnDismissListener) null);
    }

    private void d() {
        this.p = 60;
        postSafeRunOnUiThread(this.f17684a);
        if (StringUtils.d(this.m) || !this.m.equals(LoginRegisterTools.n)) {
            return;
        }
        e();
    }

    private void e() {
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.login_register.LinkMobile2Fragment.2
            @Override // java.lang.Runnable
            public void run() {
                if (LinkMobile2Fragment.this.r) {
                    BluedUIHttpResponse b = LinkMobile2Fragment.this.b(2);
                    LoginRegisterHttpUtils.a(b, LinkMobile2Fragment.this.j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + LinkMobile2Fragment.this.i, "mobile", "", "", 2, (IRequestHost) LinkMobile2Fragment.this.getFragmentActive());
                }
            }
        }, 45000L);
    }

    private void f() {
        if (StringUtils.d(this.m) || !(this.m.equals(LoginRegisterTools.l) || this.m.equals(LoginRegisterTools.n))) {
            LoginRegisterHttpUtils.a(a(1), this.k.getPassWord(), 0, (IRequestHost) getFragmentActive());
        } else {
            LoginRegisterHttpUtils.a(a(1), this.k.getPassWord(), 1, (IRequestHost) getFragmentActive());
        }
    }

    static /* synthetic */ int g(LinkMobile2Fragment linkMobile2Fragment) {
        int i = linkMobile2Fragment.p;
        linkMobile2Fragment.p = i - 1;
        return i;
    }

    private void g() {
        if (StringUtils.d(this.m) || !(this.m.equals(LoginRegisterTools.l) || this.m.equals(LoginRegisterTools.n))) {
            BluedUIHttpResponse b = b(0);
            LoginRegisterHttpUtils.a(b, this.j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.i, "mobile", "", this.n, 0, (IRequestHost) getFragmentActive());
            return;
        }
        BluedUIHttpResponse b2 = b(1);
        LoginRegisterHttpUtils.a(b2, this.j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.i, "mobile", "", this.n, 1, (IRequestHost) getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.l.setEnabled(false);
        this.l.setText(this.e.getResources().getString(2131886708));
    }

    private void j() {
        LoginRegisterHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<LoginProtectionModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.login_register.LinkMobile2Fragment.9
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LoginProtectionModel> bluedEntityA) {
                LinkMobile2Fragment.this.getActivity().finish();
            }
        }, "set", "", "", (IRequestHost) getFragmentActive());
    }

    private void k() {
        UserInfo.getInstance().setBindPhoneNum(LoginRegisterTools.a(this.j, this.i));
        CommonPreferences.u(LoginRegisterTools.a(this.j, this.i));
        CommonPreferences.g(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        LoginRegisterHttpUtils.c(this.b, getFragmentActive());
    }

    public BluedUIHttpResponse a(final int i) {
        return new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.login_register.LinkMobile2Fragment.4
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                LinkMobile2Fragment.this.c(i);
            }

            public boolean onUIFailure(int i2, String str) {
                if (i2 == 4036014) {
                    if (TextUtils.isEmpty(str)) {
                        return true;
                    }
                    LinkMobile2Fragment.this.a(str);
                    return true;
                }
                switch (i2) {
                    case 4036207:
                    case 4036210:
                        AppMethods.a(AppInfo.d().getResources().getString(R.string.e4036207));
                        if (LinkMobile2Fragment.this.getActivity() != null) {
                            LinkMobile2Fragment.this.getActivity().finish();
                            return true;
                        }
                        return true;
                    case 4036208:
                        LinkMobile2Fragment.this.a(4036208, str);
                        return true;
                    case 4036209:
                        LinkMobile2Fragment.this.a(4036209, str);
                        return true;
                    default:
                        return super.onUIFailure(i2, str);
                }
            }

            public void onUIFinish() {
                DialogUtils.b(LinkMobile2Fragment.this.f);
                super.onUIFinish();
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(LinkMobile2Fragment.this.f);
            }
        };
    }

    public void a(final String str, final String str2) {
        View inflate = LayoutInflater.from(this.e).inflate(R.layout.send_sms_dialog_custom, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(2131371186);
        ShapeTextView findViewById = inflate.findViewById(R.id.tv_to_send);
        ShapeTextView findViewById2 = inflate.findViewById(R.id.tv_sended);
        ImageView imageView = (ImageView) inflate.findViewById(2131365207);
        this.s = new Dialog(this.e);
        textView.setText(this.e.getString(2131890478) + this.i + this.e.getString(2131890483) + str + this.e.getString(2131890482) + str2 + this.e.getString(2131890485));
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.LinkMobile2Fragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.USER_VERIFY_POP_SEND_CLICK);
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + str2));
                intent.putExtra("sms_body", str);
                LinkMobile2Fragment.this.getActivity().startActivity(intent);
            }
        });
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.LinkMobile2Fragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.USER_VERIFY_POP_DONE_CLICK);
                LoginRegisterHttpUtils.a(LinkMobile2Fragment.this.a(3), str, 3, (IRequestHost) LinkMobile2Fragment.this.getFragmentActive());
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.LinkMobile2Fragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LinkMobile2Fragment.this.s.dismiss();
            }
        });
        this.s.setContentView(inflate);
        this.s.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.s.setCanceledOnTouchOutside(false);
        this.s.show();
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.USER_VERIFY_POP_SHOW);
    }

    public BluedUIHttpResponse b(final int i) {
        return new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>(getFragmentActive()) { // from class: com.soft.blued.ui.login_register.LinkMobile2Fragment.5
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLoginResult> bluedEntityA) {
                int i2 = i;
                if (i2 == 0 || i2 == 1) {
                    AppMethods.a(LinkMobile2Fragment.this.e.getResources().getString(2131886716));
                    LinkMobile2Fragment.this.h();
                }
                if (bluedEntityA == null || !bluedEntityA.hasData() || bluedEntityA.data.get(0) == null) {
                    return;
                }
                String encrypted = ((BluedLoginResult) bluedEntityA.data.get(0)).getEncrypted();
                String str = null;
                try {
                    str = AesCrypto2.a(encrypted);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (str == null) {
                    return;
                }
                BluedLoginResult bluedLoginResult = (BluedLoginResult) AppInfo.f().fromJson(str, (Class<Object>) BluedLoginResult.class);
                if (i == 2) {
                    LinkMobile2Fragment.this.a(bluedLoginResult.captcha, bluedLoginResult.target);
                }
            }

            public boolean onUIFailure(int i2, String str) {
                if (i2 == 4036204) {
                    LinkMobile2Fragment.this.i();
                    AppMethods.d((int) R.string.e4036204);
                    return true;
                }
                return super.onUIFailure(i2, str);
            }

            public void onUIFinish() {
                DialogUtils.b(LinkMobile2Fragment.this.f);
                super.onUIFinish();
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(LinkMobile2Fragment.this.f);
            }
        };
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id == 2131368406) {
            this.k.a();
            g();
        } else if (id != 2131371164) {
        } else {
            if (StringUtils.d(this.k.getPassWord())) {
                AppMethods.d(2131886603);
                return;
            }
            f();
            this.r = false;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = getActivity();
        View view = this.d;
        if (view == null) {
            this.d = layoutInflater.inflate(R.layout.fragment_linkmobile_v1_step2, viewGroup, false);
            a();
            b();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        return this.d;
    }
}
