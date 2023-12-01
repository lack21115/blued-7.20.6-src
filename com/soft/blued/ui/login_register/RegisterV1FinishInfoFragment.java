package com.soft.blued.ui.login_register;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserTag;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.ClearEditText;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.android.module.common.view.MDatePickerDialog;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.face.AVConfigExtra;
import com.blued.login.model.BluedCheckResult;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.PopMenuFromCenter;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.login_register.model.PassportTipsModel;
import com.soft.blued.ui.setting.fragment.ModifyHealthFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import net.simonvt.datepicker.DatePicker;
import net.simonvt.datepicker.DatePickerDialog;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/RegisterV1FinishInfoFragment.class */
public class RegisterV1FinishInfoFragment extends KeyBoardFragment implements View.OnClickListener {
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private String E;
    private CommonTopTitleNoTrans G;
    private String[] V;
    private String[] W;
    private String X;
    private int Y;
    private String Z;
    private String aa;
    private String ab;
    private ImageView ac;
    private String[] ad;
    private int ae;
    private String af;
    private TextWatcher ag;
    private ShapeFrameLayout ah;
    private FlowLayout ai;
    private View ak;
    private String al;
    private String an;
    private String ao;
    private String ap;
    private View l;
    private Context m;
    private Dialog n;
    private KeyboardListenLinearLayout p;
    private TextView q;
    private ClearEditText r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;
    private String k = RegisterV1FinishInfoFragment.class.getSimpleName();
    private PassportTipsModel o = new PassportTipsModel();
    private String F = "-1";
    private int H = 1994;
    private int I = 0;
    private int J = 1;
    private String K = "";
    private String L = "";
    private int M = 0;
    private int N = 170;
    private int O = 60;
    private int P = 120;
    private int Q = 220;
    private int R = 30;
    private int S = 200;
    private String T = "";
    private String U = "";
    private LoginAndRegisterProtos.Source aj = LoginAndRegisterProtos.Source.PHONE;
    private DatePickerDialog.OnDateSetListener am = new DatePickerDialog.OnDateSetListener() { // from class: com.soft.blued.ui.login_register.RegisterV1FinishInfoFragment.7
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            int a2 = TimeAndDateUtils.a(TimeAndDateUtils.c(i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (i2 + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i3, "yyyy-MM-dd"));
            if (a2 < 18) {
                AppMethods.d(2131886373);
            } else if (a2 > 80) {
                AppMethods.d(2131886372);
            } else {
                RegisterV1FinishInfoFragment.this.H = i;
                RegisterV1FinishInfoFragment.this.I = i2;
                RegisterV1FinishInfoFragment.this.J = i3;
                TextView textView = RegisterV1FinishInfoFragment.this.s;
                textView.setText(RegisterV1FinishInfoFragment.this.H + "/" + (RegisterV1FinishInfoFragment.this.I + 1) + "/" + RegisterV1FinishInfoFragment.this.J);
                RegisterV1FinishInfoFragment registerV1FinishInfoFragment = RegisterV1FinishInfoFragment.this;
                registerV1FinishInfoFragment.K = RegisterV1FinishInfoFragment.this.H + "/" + (RegisterV1FinishInfoFragment.this.I + 1) + "/" + RegisterV1FinishInfoFragment.this.J;
            }
        }
    };
    public BluedUIHttpResponse b = new BluedUIHttpResponse<BluedEntityA<BluedCheckResult>>() { // from class: com.soft.blued.ui.login_register.RegisterV1FinishInfoFragment.13
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public BluedEntityA<BluedCheckResult> parseData(String str) {
            BluedEntityA<BluedCheckResult> parseData = super.parseData(str);
            if (parseData != null) {
                try {
                    if (parseData.data != null && parseData.data.size() > 0) {
                        String a2 = AesCrypto2.a(((BluedCheckResult) parseData.data.get(0)).getEncrypted());
                        Logger.b(RegisterV1FinishInfoFragment.this.k, "解密：deData===", a2);
                        BluedCheckResult bluedCheckResult = (BluedCheckResult) AppInfo.f().fromJson(a2, (Class<Object>) BluedCheckResult.class);
                        parseData.data.set(0, bluedCheckResult);
                        if (bluedCheckResult != null) {
                            String msg = bluedCheckResult.getMsg();
                            Logger.b(RegisterV1FinishInfoFragment.this.k, "ret===", msg);
                            Message obtain = Message.obtain();
                            obtain.what = 3000;
                            obtain.obj = msg;
                            RegisterV1FinishInfoFragment.this.j.sendMessage(obtain);
                            return parseData;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return parseData;
        }

        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedCheckResult> bluedEntityA) {
        }

        public void onFailure(Throwable th, int i, String str) {
            Logger.b(RegisterV1FinishInfoFragment.this.k, "===error", "responseCode:", Integer.valueOf(i), ",responseJson:", RegisterV1FinishInfoFragment.this.af);
            super.onFailure(th, i, str);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public BluedUIHttpResponse f17736c = new BluedUIHttpResponse<BluedEntity<BluedLoginResult, AVConfigExtra>>() { // from class: com.soft.blued.ui.login_register.RegisterV1FinishInfoFragment.14
        public boolean onUIFailure(int i, String str) {
            if (i == 4036001) {
                if (RegisterV1FinishInfoFragment.this.getActivity() != null) {
                    RegisterV1FinishInfoFragment.this.getActivity().finish();
                    return true;
                }
                return true;
            }
            return super.onUIFailure(i, str);
        }

        public void onUIFinish() {
            DialogUtils.b(RegisterV1FinishInfoFragment.this.n);
        }

        public void onUIStart() {
            DialogUtils.a(RegisterV1FinishInfoFragment.this.n);
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x00f0  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x012a A[Catch: Exception -> 0x018e, TryCatch #0 {Exception -> 0x018e, blocks: (B:2:0x0000, B:4:0x0028, B:6:0x0035, B:8:0x0049, B:9:0x005a, B:9:0x005a, B:10:0x005d, B:12:0x0069, B:15:0x007c, B:17:0x0096, B:19:0x00a4, B:30:0x00da, B:34:0x00f5, B:36:0x012a, B:38:0x0138, B:40:0x0152, B:43:0x015b, B:45:0x0163, B:47:0x0171, B:22:0x00b0, B:26:0x00c0, B:28:0x00cb, B:13:0x0071), top: B:54:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0152 A[Catch: Exception -> 0x018e, TryCatch #0 {Exception -> 0x018e, blocks: (B:2:0x0000, B:4:0x0028, B:6:0x0035, B:8:0x0049, B:9:0x005a, B:9:0x005a, B:10:0x005d, B:12:0x0069, B:15:0x007c, B:17:0x0096, B:19:0x00a4, B:30:0x00da, B:34:0x00f5, B:36:0x012a, B:38:0x0138, B:40:0x0152, B:43:0x015b, B:45:0x0163, B:47:0x0171, B:22:0x00b0, B:26:0x00c0, B:28:0x00cb, B:13:0x0071), top: B:54:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x019f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onUIUpdate(com.blued.android.framework.http.parser.BluedEntity<com.blued.android.module.common.user.model.BluedLoginResult, com.blued.login.face.AVConfigExtra> r11) {
            /*
                Method dump skipped, instructions count: 420
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.login_register.RegisterV1FinishInfoFragment.AnonymousClass14.onUIUpdate(com.blued.android.framework.http.parser.BluedEntity):void");
        }

        public BluedEntity<BluedLoginResult, AVConfigExtra> parseData(String str) {
            RegisterV1FinishInfoFragment.this.af = str;
            BluedEntity<BluedLoginResult, AVConfigExtra> parseData = super.parseData(str);
            if (parseData != null) {
                try {
                    if (parseData.data != null && parseData.data.size() > 0) {
                        String a2 = AesCrypto2.a(((BluedLoginResult) parseData.data.get(0)).getEncrypted());
                        Logger.b(RegisterV1FinishInfoFragment.this.k, "解密：deData===", a2);
                        parseData.data.set(0, (BluedLoginResult) AppInfo.f().fromJson(a2, (Class<Object>) BluedLoginResult.class));
                        return parseData;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.d(2131887272);
                }
            }
            return parseData;
        }
    };
    public Handler j = new MsgHandler(this);

    /* renamed from: com.soft.blued.ui.login_register.RegisterV1FinishInfoFragment$11  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/RegisterV1FinishInfoFragment$11.class */
    class AnonymousClass11 implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RegisterV1FinishInfoFragment f17739a;

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Tracker.onClick(dialogInterface, i);
            Logger.b(this.f17739a.k, "which==", Integer.valueOf(i));
            if (i == 0) {
                this.f17739a.F = "1";
            } else if (i == 1) {
                this.f17739a.F = "0";
            } else if (i == 2) {
                this.f17739a.F = "0.5";
            } else if (i == 3) {
                this.f17739a.F = "-1";
            }
            this.f17739a.u.setText(this.f17739a.W[i]);
        }
    }

    /* renamed from: com.soft.blued.ui.login_register.RegisterV1FinishInfoFragment$4  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/RegisterV1FinishInfoFragment$4.class */
    class AnonymousClass4 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
        }
    }

    /* renamed from: com.soft.blued.ui.login_register.RegisterV1FinishInfoFragment$5  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/RegisterV1FinishInfoFragment$5.class */
    class AnonymousClass5 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PopMenuFromCenter f17746a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            this.f17746a.d();
        }
    }

    /* renamed from: com.soft.blued.ui.login_register.RegisterV1FinishInfoFragment$6  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/RegisterV1FinishInfoFragment$6.class */
    class AnonymousClass6 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PopMenuFromCenter f17747a;
        final /* synthetic */ RegisterV1FinishInfoFragment b;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            this.b.h();
            this.f17747a.d();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/RegisterV1FinishInfoFragment$MsgHandler.class */
    static class MsgHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<Fragment> f17751a;

        MsgHandler(Fragment fragment) {
            this.f17751a = new WeakReference<>(fragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            RegisterV1FinishInfoFragment registerV1FinishInfoFragment = (RegisterV1FinishInfoFragment) this.f17751a.get();
            if (registerV1FinishInfoFragment != null) {
                registerV1FinishInfoFragment.a(message);
            }
        }
    }

    private void a(TextWatcher textWatcher) {
        this.r.addTextChangedListener(textWatcher);
        this.s.addTextChangedListener(textWatcher);
        this.t.addTextChangedListener(textWatcher);
    }

    private void b(TextWatcher textWatcher) {
        this.r.removeTextChangedListener(textWatcher);
        this.s.removeTextChangedListener(textWatcher);
        this.t.removeTextChangedListener(textWatcher);
    }

    private void i() {
        CommonTopTitleNoTrans findViewById = this.l.findViewById(R.id.top_title);
        this.G = findViewById;
        findViewById.a();
        this.G.f();
        this.G.setCenterText("");
        this.G.setLeftClickListener(this);
        this.G.setTitleBackgroundDrawable(2131101191);
    }

    private void j() {
        this.n = DialogUtils.a(this.m);
        ShapeFrameLayout findViewById = this.l.findViewById(R.id.sfl_nick);
        this.ah = findViewById;
        ShapeHelper.b(findViewById, 2131102360);
        KeyboardListenLinearLayout findViewById2 = this.l.findViewById(R.id.keyboardRelativeLayout);
        this.p = findViewById2;
        findViewById2.setOnClickListener(this);
        BluedPreferences.d(1);
        this.n = DialogUtils.a(this.m);
        ClearEditText findViewById3 = this.l.findViewById(R.id.et_nickname);
        this.r = findViewById3;
        findViewById3.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.soft.blued.ui.login_register.RegisterV1FinishInfoFragment.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Tracker.onFocusChange(view, z);
                if (z) {
                    return;
                }
                RegisterV1FinishInfoFragment.this.p();
            }
        });
        this.y = (TextView) this.l.findViewById(R.id.tv_role_0);
        this.z = (TextView) this.l.findViewById(R.id.tv_role_05);
        this.A = (TextView) this.l.findViewById(R.id.tv_role_1);
        this.B = (TextView) this.l.findViewById(R.id.tv_role_others);
        this.C = (TextView) this.l.findViewById(R.id.tv_role_075);
        this.D = (TextView) this.l.findViewById(R.id.tv_role_025);
        this.C.setVisibility(8);
        this.D.setVisibility(8);
        this.ai = this.l.findViewById(2131369446);
        this.y.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        TextView textView = (TextView) this.l.findViewById(2131371164);
        this.q = textView;
        textView.setOnClickListener(this);
        this.l.findViewById(R.id.ll_birthday).setOnClickListener(this);
        this.l.findViewById(R.id.ll_height_weight).setOnClickListener(this);
        View findViewById4 = this.l.findViewById(R.id.ll_health);
        this.ak = findViewById4;
        findViewById4.setOnClickListener(this);
        this.s = (TextView) this.l.findViewById(2131370989);
        this.x = (TextView) this.l.findViewById(2131371656);
        this.t = (TextView) this.l.findViewById(2131371664);
        this.u = (TextView) this.l.findViewById(2131372467);
        TextView textView2 = (TextView) this.l.findViewById(R.id.tv_cm);
        this.v = textView2;
        textView2.setText("cm/kg");
        this.v.setOnClickListener(this);
        TextView textView3 = (TextView) this.l.findViewById(R.id.tv_feet);
        this.w = textView3;
        textView3.setText("ft/lb");
        this.w.setOnClickListener(this);
        ImageView imageView = (ImageView) this.l.findViewById(2131364232);
        this.ac = imageView;
        imageView.setOnClickListener(this);
        this.ag = new TextWatcher() { // from class: com.soft.blued.ui.login_register.RegisterV1FinishInfoFragment.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                RegisterV1FinishInfoFragment.this.l();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
    }

    private void k() {
        this.V = this.m.getResources().getStringArray(R.array.race_array_key_2);
        this.W = this.m.getResources().getStringArray(R.array.biao_role_array);
        if (getArguments() != null) {
            this.al = getArguments().getString("aliasUserId", "");
            this.aj = (LoginAndRegisterProtos.Source) getArguments().getSerializable("RE_KEY_FROM_SRC");
            this.X = getArguments().getString(LoginRegisterTools.d);
            try {
                this.T = BluedHttpTools.b(getArguments().getString(LoginRegisterTools.h));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            String string = getArguments().getString(LoginRegisterTools.i);
            if (!StringUtils.d(string)) {
                this.r.setText(string);
            }
            this.Y = getArguments().getInt(LoginRegisterTools.f17709a);
            this.Z = getArguments().getString(LoginRegisterTools.b);
            this.aa = getArguments().getString(LoginRegisterTools.j);
            int i = this.Y;
            if (i == 1) {
                LoginRegisterHttpUtils.a("mo_info");
                LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_SHOW;
                LoginAndRegisterProtos.Source source = this.aj;
                LoginAndRegisterProtos.Source source2 = source;
                if (source == null) {
                    source2 = LoginAndRegisterProtos.Source.PHONE;
                }
                EventTrackLoginAndRegister.a(event, source2);
            } else if (i != 2) {
                LoginRegisterHttpUtils.a("mail_info");
                LoginAndRegisterProtos.Event event2 = LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_SHOW;
                LoginAndRegisterProtos.Source source3 = this.aj;
                LoginAndRegisterProtos.Source source4 = source3;
                if (source3 == null) {
                    source4 = LoginAndRegisterProtos.Source.PHONE;
                }
                EventTrackLoginAndRegister.a(event2, source4);
            } else if (this.Z.equals("onclick")) {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_SHOW, LoginAndRegisterProtos.Source.ONE_CLICK);
            } else {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_SHOW, LoginAndRegisterProtos.Source.WECHAT);
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UserTag("1", this.m.getResources().getString(2131891552)));
        arrayList.add(new UserTag("0.5", this.m.getResources().getString(2131891551)));
        arrayList.add(new UserTag("0", this.m.getResources().getString(2131891550)));
        arrayList.add(new UserTag("-1", this.m.getResources().getString(2131891462)));
        a(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (StringUtils.d(this.r.getText().toString()) || StringUtils.d(this.s.getText().toString())) {
            this.q.setEnabled(false);
        } else {
            this.q.setEnabled(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m() {
        /*
            Method dump skipped, instructions count: 770
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.login_register.RegisterV1FinishInfoFragment.m():void");
    }

    private boolean n() {
        return StringUtils.d(this.r.getText().toString()) || StringUtils.d(this.K);
    }

    private void o() {
        LoginRegisterHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<BluedCheckResult>>(getFragmentActive()) { // from class: com.soft.blued.ui.login_register.RegisterV1FinishInfoFragment.12
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedCheckResult> bluedEntityA) {
                BluedCheckResult bluedCheckResult;
                if (bluedEntityA == null || (bluedCheckResult = (BluedCheckResult) bluedEntityA.data.get(0)) == null) {
                    return;
                }
                if (bluedCheckResult.health_test_info_show == 1) {
                    RegisterV1FinishInfoFragment.this.ak.setVisibility(0);
                } else {
                    RegisterV1FinishInfoFragment.this.ak.setVisibility(8);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        int length = this.r.getText().toString().length();
        if (length < 1 || length > 20) {
            AppMethods.d(2131887713);
        } else if (StringUtils.d(this.r.getText().toString())) {
        } else {
            LoginRegisterHttpUtils.b(this.b, this.X, this.r.getText().toString(), (IRequestHost) getFragmentActive());
        }
    }

    private void q() {
        PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.login_register.RegisterV1FinishInfoFragment.15
            public void U_() {
                PhotoSelectFragment.a(RegisterV1FinishInfoFragment.this, 1, 22);
            }

            public void a(String[] strArr) {
            }
        });
    }

    private void r() {
        int aF;
        if (StringUtils.d(this.L) || this.M == 0 || this.ae == (aF = BluedPreferences.aF())) {
            return;
        }
        String str = ((Object) this.t.getText()) + "";
        if (StringUtils.d(str) || !str.contains(" / ")) {
            return;
        }
        String str2 = str.split(" / ")[0];
        String str3 = str.split(" / ")[1];
        if (aF == 1) {
            str2 = UserRelationshipUtils.b(str2) + "";
            str3 = UserRelationshipUtils.c(str3) + "";
        } else if (aF == 2) {
            str2 = str2 + "";
            str3 = str3 + "";
        }
        this.M = Integer.parseInt(str3);
        String a2 = StringUtils.a(str2, BlueAppLocal.c(), false);
        String replace = StringUtils.b(str3, BlueAppLocal.c(), false).replace(" lbs", "");
        this.t.setText(a2 + " / " + replace);
    }

    public void a(Message message) {
        if (message.what != 3000) {
            return;
        }
        String str = (String) message.obj;
        if (TextUtils.isEmpty(str)) {
            AppMethods.d(2131886680);
        } else {
            AppMethods.a(str);
        }
    }

    public void a(TextView textView) {
        textView.requestFocus();
        this.C.setSelected(false);
        this.z.setSelected(false);
        this.A.setSelected(false);
        this.B.setSelected(false);
        this.D.setSelected(false);
        this.y.setSelected(false);
        this.C.setTextColor(BluedSkinUtils.a(this.m, 2131102254));
        this.y.setTextColor(BluedSkinUtils.a(this.m, 2131102254));
        this.D.setTextColor(BluedSkinUtils.a(this.m, 2131102254));
        this.z.setTextColor(BluedSkinUtils.a(this.m, 2131102254));
        this.A.setTextColor(BluedSkinUtils.a(this.m, 2131102254));
        this.B.setTextColor(BluedSkinUtils.a(this.m, 2131102254));
        textView.setSelected(true);
        textView.setTextColor(getResources().getColor(2131101780));
        l();
    }

    public void a(final List<UserTag> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.ai.removeAllViews();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.ai.setOnItemClickListener(new FlowLayout.OnItemClickListener() { // from class: com.soft.blued.ui.login_register.RegisterV1FinishInfoFragment.3
                    public void onItemClick(View view, int i3) {
                        Logger.a("drb", "mFlowLayout onItemClick");
                        UserTag userTag = (UserTag) list.get(i3);
                        if (userTag.checked == 0) {
                            int i4 = 0;
                            while (true) {
                                int i5 = i4;
                                if (i5 >= list.size()) {
                                    break;
                                }
                                ((UserTag) list.get(i5)).checked = 0;
                                TextView textView = (TextView) RegisterV1FinishInfoFragment.this.ai.getChildAt(i5).findViewById(2131372684);
                                textView.setBackgroundResource(R.drawable.user_job_text_bg);
                                textView.setTextColor(BluedSkinUtils.a(RegisterV1FinishInfoFragment.this.m, 2131102254));
                                i4 = i5 + 1;
                            }
                            userTag.checked = 1;
                            TextView textView2 = (TextView) view.findViewById(2131372684);
                            textView2.setBackground(BluedSkinUtils.b(RegisterV1FinishInfoFragment.this.m, (int) R.drawable.user_job_text_select_bg));
                            textView2.setTextColor(BluedSkinUtils.a(RegisterV1FinishInfoFragment.this.m, 2131101780));
                            RegisterV1FinishInfoFragment.this.F = userTag.id;
                        }
                        Log.v("drb", "userTag.checked = " + userTag.checked);
                        RegisterV1FinishInfoFragment.this.l();
                    }
                });
                return;
            }
            View inflate = LayoutInflater.from(this.m).inflate(2131560737, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(2131372684);
            textView.setText(list.get(i2).name);
            Log.v("drb", "name:" + list.get(i2).name);
            if (list.get(i2).checked == 0) {
                textView.setBackground(BluedSkinUtils.b(this.m, (int) R.drawable.user_job_text_bg));
                textView.setTextColor(BluedSkinUtils.a(this.m, 2131102254));
            } else {
                textView.setBackground(BluedSkinUtils.b(this.m, (int) R.drawable.user_job_text_select_bg));
                textView.setTextColor(BluedSkinUtils.a(this.m, 2131101780));
            }
            this.ai.addView(inflate);
            i = i2 + 1;
        }
    }

    public void h() {
        int i;
        String str = ((Object) this.t.getText()) + "";
        int aF = BluedPreferences.aF();
        if (StringUtils.d(str)) {
            str = aF == 2 ? "5'7\" / 143" : "170 / 65";
            i = 1;
        } else {
            i = 0;
        }
        if (str.contains(" / ")) {
            String str2 = str.split(" / ")[0];
            String str3 = str.split(" / ")[1];
            if (aF == 2) {
                str2 = UserRelationshipUtils.b(str2) + "";
                StringBuilder sb = new StringBuilder();
                sb.append(UserRelationshipUtils.c(str3 + ""));
                sb.append("");
                str3 = sb.toString();
            }
            LoginRegisterHttpUtils.a(this.f17736c, this.X, this.r.getText().toString(), this.T, str2 + "", str3 + "", this.F, TimeAndDateUtils.b(this.s.getText().toString(), "yyyy/MM/dd"), this.E, i, TextUtils.equals(this.an, "-1") ? "" : this.an, TextUtils.equals(this.ao, "-1") ? "" : this.ao, TextUtils.equals(this.ap, "-1") ? "" : this.ap, getFragmentActive());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i != 22) {
                if (i == 513) {
                    this.an = intent.getStringExtra("health_result");
                    this.ao = intent.getStringExtra("health_time");
                    this.ap = intent.getStringExtra("health_prep");
                    if (TextUtils.equals(this.an, "-1") && TextUtils.equals(this.ao, "-1") && TextUtils.equals(this.ap, "-1")) {
                        this.x.setText("");
                    } else {
                        this.x.setText(R.string.health_information_completed);
                    }
                }
            } else if (intent != null) {
                this.ab = intent.getStringExtra("photo_path");
                ImageLoader.d(getFragmentActive(), this.ab).c().b(2131237310).a(this.ac);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        switch (id) {
            case 2131363120:
                getActivity().finish();
                return;
            case 2131364232:
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CLICK);
                if (this.r.isFocused()) {
                    this.r.clearFocus();
                }
                q();
                return;
            case R.id.keyboardRelativeLayout /* 2131366091 */:
                KeyboardUtils.a(getActivity());
                return;
            case R.id.ll_birthday /* 2131367661 */:
                if (this.r.isFocused()) {
                    this.r.clearFocus();
                }
                new MDatePickerDialog(this.m, this.am, this.H, this.I, this.J).show();
                return;
            case R.id.ll_health /* 2131367891 */:
                ModifyHealthFragment.a(this, this.an, this.ao, this.ap, 513);
                return;
            case R.id.ll_height_weight /* 2131367897 */:
                if (this.r.isFocused()) {
                    this.r.clearFocus();
                }
                m();
                return;
            case R.id.tv_cm /* 2131371136 */:
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_UNIT_BTN_CLICK, LoginAndRegisterProtos.UnitType.CM_KG);
                if (this.r.isFocused()) {
                    this.r.clearFocus();
                }
                this.ae = BluedPreferences.aF();
                BluedPreferences.d(1);
                this.v.setBackground(BluedSkinUtils.b(this.m, (int) R.drawable.user_job_text_select_bg));
                this.w.setBackground(BluedSkinUtils.b(this.m, (int) R.drawable.user_job_text_bg));
                this.v.setTextColor(BluedSkinUtils.a(this.m, 2131101780));
                this.w.setTextColor(BluedSkinUtils.a(this.m, 2131102254));
                r();
                return;
            case 2131371164:
                LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_CONFIRM_BTN_CLICK;
                LoginAndRegisterProtos.Source source = this.aj;
                LoginAndRegisterProtos.Source source2 = source;
                if (source == null) {
                    source2 = LoginAndRegisterProtos.Source.PHONE;
                }
                EventTrackLoginAndRegister.a(event, source2);
                if (this.r.isFocused()) {
                    this.r.clearFocus();
                }
                int i = this.Y;
                if (i == 0) {
                    LoginRegisterHttpUtils.a("mail_fin");
                } else if (i == 1) {
                    LoginRegisterHttpUtils.a("mo_fin");
                }
                if (n()) {
                    AppMethods.d(2131886764);
                    return;
                } else {
                    h();
                    return;
                }
            case R.id.tv_feet /* 2131371432 */:
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_UNIT_BTN_CLICK, LoginAndRegisterProtos.UnitType.FT_LB);
                if (this.r.isFocused()) {
                    this.r.clearFocus();
                }
                this.ae = BluedPreferences.aF();
                BluedPreferences.d(2);
                this.w.setBackground(BluedSkinUtils.b(this.m, (int) R.drawable.user_job_text_select_bg));
                this.v.setBackground(BluedSkinUtils.b(this.m, (int) R.drawable.user_job_text_bg));
                this.w.setTextColor(BluedSkinUtils.a(this.m, 2131101780));
                this.v.setTextColor(BluedSkinUtils.a(this.m, 2131102254));
                r();
                return;
            default:
                switch (id) {
                    case R.id.tv_role_0 /* 2131372468 */:
                        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_ROLE_BTN_CLICK, LoginAndRegisterProtos.RoleType.ZERO);
                        if (this.r.isFocused()) {
                            this.r.clearFocus();
                        }
                        this.F = "0";
                        a(this.y);
                        return;
                    case R.id.tv_role_025 /* 2131372469 */:
                        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_ROLE_BTN_CLICK, LoginAndRegisterProtos.RoleType.HARF);
                        if (this.r.isFocused()) {
                            this.r.clearFocus();
                        }
                        this.F = "0.25";
                        a(this.D);
                        return;
                    case R.id.tv_role_05 /* 2131372470 */:
                        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_ROLE_BTN_CLICK, LoginAndRegisterProtos.RoleType.HARF);
                        if (this.r.isFocused()) {
                            this.r.clearFocus();
                        }
                        this.F = "0.5";
                        a(this.z);
                        return;
                    case R.id.tv_role_075 /* 2131372471 */:
                        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_ROLE_BTN_CLICK, LoginAndRegisterProtos.RoleType.UNKNOWN_ROLE_TYPE);
                        if (this.r.isFocused()) {
                            this.r.clearFocus();
                        }
                        this.F = "0.75";
                        a(this.C);
                        return;
                    case R.id.tv_role_1 /* 2131372472 */:
                        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_ROLE_BTN_CLICK, LoginAndRegisterProtos.RoleType.ONE);
                        if (this.r.isFocused()) {
                            this.r.clearFocus();
                        }
                        this.F = "1";
                        a(this.A);
                        return;
                    case R.id.tv_role_others /* 2131372473 */:
                        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_ROLE_BTN_CLICK, LoginAndRegisterProtos.RoleType.OTHER);
                        if (this.r.isFocused()) {
                            this.r.clearFocus();
                        }
                        this.F = "-1";
                        a(this.B);
                        return;
                    default:
                        return;
                }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ad = getResources().getStringArray(2130903084);
        this.m = getActivity();
        Calendar calendar = Calendar.getInstance();
        this.H = calendar.get(1) - 20;
        this.I = calendar.get(2);
        this.J = calendar.get(5);
        View view = this.l;
        if (view == null) {
            this.l = layoutInflater.inflate(R.layout.fragment_register_v1_forphone_step3, viewGroup, false);
            i();
            j();
            k();
            this.p.setBackgroundColor(BluedSkinUtils.a(this.m, 2131101780));
            a(this.p);
            o();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.l.getParent()).removeView(this.l);
        }
        return this.l;
    }

    public void onResume() {
        super.onResume();
        l();
        a(this.ag);
    }

    public void onStop() {
        b(this.ag);
        super.onStop();
    }
}
