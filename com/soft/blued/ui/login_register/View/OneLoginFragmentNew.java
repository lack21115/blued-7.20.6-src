package com.soft.blued.ui.login_register.View;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.db.UserAccountsVDao;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.HyperlinkUtils;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.auto.LoginServiceManager;
import com.blued.login.constant.LoginConstants;
import com.blued.login.face.AVConfig;
import com.blued.login.face.AVConfigExtra;
import com.blued.login.log.EventTrackLogin;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.databinding.FragmentOneLoginBinding;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.push.PushManager;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.login_register.AdultVerifyFragment;
import com.soft.blued.ui.login_register.presenter.LoginWithTypePresenter;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.third.model.TXOneLoginResult;
import com.tencent.tendinsv.OneKeyLoginManager;
import com.tencent.tendinsv.listener.LoginAuthListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/View/OneLoginFragmentNew.class */
public final class OneLoginFragmentNew extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f17844a = new Companion(null);
    private FragmentOneLoginBinding b;

    /* renamed from: c  reason: collision with root package name */
    private CheckBox f17845c;
    private TXOneLoginResult d;
    private String e;
    private String f;
    private Dialog g;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/View/OneLoginFragmentNew$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean a(Bundle bundle) {
            return bundle != null && bundle.containsKey("aliasUserId");
        }

        @JvmStatic
        public final void a(Context context, Bundle bundle) {
            Intrinsics.e(context, "context");
            Intrinsics.e(bundle, "arguments");
            if (!UserInfo.getInstance().isLogin() || a(bundle)) {
                TerminalActivity.d(context, OneLoginFragmentNew.class, bundle);
            }
        }
    }

    private final void a() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        ImageView imageView;
        ShapeTextView shapeTextView;
        ShapeTextView shapeTextView2;
        FrameLayout frameLayout3;
        this.g = DialogUtils.a(getContext());
        FragmentOneLoginBinding fragmentOneLoginBinding = this.b;
        TextView textView = (fragmentOneLoginBinding == null || (frameLayout = fragmentOneLoginBinding.f15231a) == null) ? null : (TextView) frameLayout.findViewById(2131372705);
        FragmentOneLoginBinding fragmentOneLoginBinding2 = this.b;
        if (fragmentOneLoginBinding2 != null && (frameLayout3 = fragmentOneLoginBinding2.f15231a) != null) {
            TextView textView2 = (TextView) frameLayout3.findViewById(2131372706);
        }
        final TXOneLoginResult tXOneLoginResult = this.d;
        if (tXOneLoginResult != null) {
            StringBuilder sb = new StringBuilder();
            Context context = getContext();
            sb.append((Object) (context == null ? null : context.getString(2131891195)));
            sb.append((char) 12298);
            sb.append(tXOneLoginResult.getProtocolName());
            sb.append((char) 12299);
            Context context2 = getContext();
            sb.append((Object) (context2 == null ? null : context2.getString(2131891196)));
            String sb2 = sb.toString();
            String str = (char) 12298 + tXOneLoginResult.getProtocolName() + (char) 12299;
            if (textView != null) {
                textView.setText(sb2);
            }
            HyperlinkUtils.a(getContext(), textView, str, BluedSkinUtils.a(getContext(), 2131102270), new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.View.-$$Lambda$OneLoginFragmentNew$Lpa0lMXX-DJ5AF_Vt1_tstbiV_E
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OneLoginFragmentNew.a(OneLoginFragmentNew.this, tXOneLoginResult, view);
                }
            });
        }
        FragmentOneLoginBinding fragmentOneLoginBinding3 = this.b;
        this.f17845c = (fragmentOneLoginBinding3 == null || (frameLayout2 = fragmentOneLoginBinding3.f15231a) == null) ? null : (CheckBox) frameLayout2.findViewById(2131362774);
        FragmentOneLoginBinding fragmentOneLoginBinding4 = this.b;
        if (fragmentOneLoginBinding4 != null && (shapeTextView2 = fragmentOneLoginBinding4.f15232c) != null) {
            shapeTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.View.-$$Lambda$OneLoginFragmentNew$j9mSgH4ydfAatkPPvtV7mdDU2zg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OneLoginFragmentNew.a(OneLoginFragmentNew.this, view);
                }
            });
        }
        FragmentOneLoginBinding fragmentOneLoginBinding5 = this.b;
        if (fragmentOneLoginBinding5 != null && (shapeTextView = fragmentOneLoginBinding5.f) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.View.-$$Lambda$OneLoginFragmentNew$wYzUjgPFKRL0UaTJevkWQRDsyzY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OneLoginFragmentNew.b(OneLoginFragmentNew.this, view);
                }
            });
        }
        FragmentOneLoginBinding fragmentOneLoginBinding6 = this.b;
        TextView textView3 = fragmentOneLoginBinding6 == null ? null : fragmentOneLoginBinding6.e;
        if (textView3 != null) {
            TXOneLoginResult tXOneLoginResult2 = this.d;
            textView3.setText(tXOneLoginResult2 == null ? null : tXOneLoginResult2.getNumber());
        }
        FragmentOneLoginBinding fragmentOneLoginBinding7 = this.b;
        if (fragmentOneLoginBinding7 == null || (imageView = fragmentOneLoginBinding7.b) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.View.-$$Lambda$OneLoginFragmentNew$EBcKgr2mOU42Bk6U7DsoOHGso8I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OneLoginFragmentNew.c(OneLoginFragmentNew.this, view);
            }
        });
    }

    @JvmStatic
    public static final void a(Context context, Bundle bundle) {
        f17844a.a(context, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(OneLoginFragmentNew oneLoginFragmentNew, int i, String str) {
        Intrinsics.e(oneLoginFragmentNew, "this$0");
        Log.v("drb", Intrinsics.a("result:", str));
        String optString = new JSONObject(str).optString("token");
        TXOneLoginResult tXOneLoginResult = oneLoginFragmentNew.d;
        if (tXOneLoginResult != null) {
            Intrinsics.c(optString, "token");
            tXOneLoginResult.setToken(optString);
        }
        oneLoginFragmentNew.a(oneLoginFragmentNew.d);
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.ONE_CLICK_POP_TRUE_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final OneLoginFragmentNew oneLoginFragmentNew, View view) {
        Tracker.onClick(view);
        Intrinsics.e(oneLoginFragmentNew, "this$0");
        CheckBox checkBox = oneLoginFragmentNew.f17845c;
        boolean z = false;
        if (checkBox != null && checkBox.isChecked()) {
            z = true;
        }
        if (!z) {
            AppMethods.d(2131890421);
            return;
        }
        DialogUtils.a(oneLoginFragmentNew.g);
        OneKeyLoginManager.getInstance().loginAuth(new LoginAuthListener() { // from class: com.soft.blued.ui.login_register.View.-$$Lambda$OneLoginFragmentNew$jUHZvleEgjUZ1Q-FrJXq8yxqQvo
            @Override // com.tencent.tendinsv.listener.LoginAuthListener
            public final void getLoginTokenStatus(int i, String str) {
                OneLoginFragmentNew.a(OneLoginFragmentNew.this, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(OneLoginFragmentNew oneLoginFragmentNew, TXOneLoginResult tXOneLoginResult, View view) {
        Tracker.onClick(view);
        Intrinsics.e(oneLoginFragmentNew, "this$0");
        Intrinsics.e(tXOneLoginResult, "$result");
        WebViewShowInfoFragment.show(oneLoginFragmentNew.getContext(), tXOneLoginResult.getProtocolUrl(), -1);
    }

    private final void a(TXOneLoginResult tXOneLoginResult) {
        if (TextUtils.isEmpty(this.f) || !UserInfo.getInstance().isLogin()) {
            LoginRegisterHttpUtils.a(tXOneLoginResult, getFragmentActive(), b());
        } else {
            b(tXOneLoginResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TXOneLoginResult tXOneLoginResult, OneLoginFragmentNew oneLoginFragmentNew) {
        Intrinsics.e(oneLoginFragmentNew, "this$0");
        LiveEventBus.get(EventBusConstant.KEY_EVENT_HIDE_LOGIN_BACK).post(null);
        UserAccountsVDao.a().i();
        LoginRegisterHttpUtils.a(tXOneLoginResult, oneLoginFragmentNew.getFragmentActive(), oneLoginFragmentNew.b());
    }

    private final BluedUIHttpResponse<?> b() {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        return new BluedUIHttpResponse<BluedEntity<BluedLoginResult, AVConfigExtra>>(fragmentActive) { // from class: com.soft.blued.ui.login_register.View.OneLoginFragmentNew$buildLoginResponse$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super((IRequestHost) fragmentActive);
            }

            /* JADX WARN: Removed duplicated region for block: B:40:0x0144  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onUIFailure(int r10, java.lang.String r11, java.lang.String r12) {
                /*
                    Method dump skipped, instructions count: 343
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.login_register.View.OneLoginFragmentNew$buildLoginResponse$1.onUIFailure(int, java.lang.String, java.lang.String):boolean");
            }

            public void onUIFinish() {
                Dialog dialog;
                dialog = OneLoginFragmentNew.this.g;
                DialogUtils.b(dialog);
                OneLoginFragmentNew.this.c();
            }

            public void onUIUpdate(BluedEntity<BluedLoginResult, AVConfigExtra> bluedEntity) {
                String str;
                String str2;
                String str3;
                String str4;
                if (bluedEntity != null) {
                    try {
                        if (bluedEntity.hasData()) {
                            boolean z = false;
                            if (bluedEntity.data.get(0) != null) {
                                if (bluedEntity.extra != null) {
                                    AVConfig a2 = AVConfig.a();
                                    BluedEntityBaseExtra bluedEntityBaseExtra = bluedEntity.extra;
                                    Intrinsics.a(bluedEntityBaseExtra);
                                    a2.a(((AVConfigExtra) bluedEntityBaseExtra).f6932a, false);
                                }
                                BluedLoginResult bluedLoginResult = (BluedLoginResult) bluedEntity.data.get(0);
                                LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.LOGIN_SUCCESS;
                                LoginAndRegisterProtos.Source source = LoginAndRegisterProtos.Source.ONE_CLICK;
                                Intrinsics.a(bluedLoginResult);
                                EventTrackLoginAndRegister.a(event, source, bluedLoginResult.uid);
                                Log.v("drb", Intrinsics.a("===success 加密：responseJson:", bluedEntity));
                                String str5 = bluedLoginResult.uid;
                                UserInfo userInfo = UserInfo.getInstance();
                                str = OneLoginFragmentNew.this.e;
                                str2 = OneLoginFragmentNew.this.f;
                                userInfo.saveUserInfo(str5, 2, str, bluedLoginResult, new String[]{str2});
                                str3 = OneLoginFragmentNew.this.f;
                                if (!StringUtils.d(str3)) {
                                    UserAccountsVDao a3 = UserAccountsVDao.a();
                                    str4 = OneLoginFragmentNew.this.f;
                                    a3.c(str4);
                                }
                                PushManager.a().d();
                                if (bluedLoginResult.getNeedAdultVerify() == 1) {
                                    AdultVerifyFragment.a(OneLoginFragmentNew.this.getContext());
                                    return;
                                }
                                Bundle bundle = new Bundle();
                                bundle.putString("from_tag_page", "from_tag_login");
                                Log.v("drb", "跳转home openHomeActivityWithTab");
                                HomeArgumentHelper.a(OneLoginFragmentNew.this.getContext(), (String) null, bundle);
                                LoginConstants.f6899c = "";
                                LoginWithTypePresenter.e();
                                ChatManager.getInstance().initLanguage();
                                if (bluedLoginResult.getDevice_safe() == 1) {
                                    z = true;
                                }
                                BluedPreferences.J(z);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            public BluedEntity<BluedLoginResult, AVConfigExtra> parseData(String str) {
                List list;
                Intrinsics.e(str, "response");
                OneLoginFragmentNew.this.e = str;
                BluedEntity<BluedLoginResult, AVConfigExtra> parseData = super.parseData(str);
                if (parseData == null) {
                    list = null;
                } else {
                    try {
                        list = parseData.data;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (list != null && parseData.data.size() > 0) {
                    BluedLoginResult bluedLoginResult = (BluedLoginResult) parseData.data.get(0);
                    Intrinsics.a(bluedLoginResult);
                    String a2 = AesCrypto2.a(bluedLoginResult.getEncrypted());
                    Log.v("drb", Intrinsics.a("解密：deData=== ", a2));
                    parseData.data.set(0, (BluedLoginResult) AppInfo.f().fromJson(a2, (Class<Object>) BluedLoginResult.class));
                    return parseData;
                }
                return parseData;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(OneLoginFragmentNew oneLoginFragmentNew, View view) {
        Tracker.onClick(view);
        Intrinsics.e(oneLoginFragmentNew, "this$0");
        CheckBox checkBox = oneLoginFragmentNew.f17845c;
        boolean z = false;
        if (checkBox != null && checkBox.isChecked()) {
            z = true;
        }
        if (z) {
            LoginServiceManager.a().a(oneLoginFragmentNew.getContext(), oneLoginFragmentNew.getArguments());
        } else {
            AppMethods.d(2131890421);
        }
        EventTrackLogin.a(LoginAndRegisterProtos.Event.OTHER_PHONE_LOGIN_CLICK, LoginAndRegisterProtos.Source.UNKNOWN_SOURCE);
    }

    private final void b(final TXOneLoginResult tXOneLoginResult) {
        UserRelationshipUtils.a(new Runnable() { // from class: com.soft.blued.ui.login_register.View.-$$Lambda$OneLoginFragmentNew$Z3xrxucyblI6SnH9WdzgTWrRlfo
            @Override // java.lang.Runnable
            public final void run() {
                OneLoginFragmentNew.a(TXOneLoginResult.this, this);
            }
        }, "bind_Acc");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(OneLoginFragmentNew oneLoginFragmentNew, View view) {
        Tracker.onClick(view);
        Intrinsics.e(oneLoginFragmentNew, "this$0");
        oneLoginFragmentNew.c();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_one_login, (ViewGroup) null);
        this.b = FragmentOneLoginBinding.a(inflate);
        Bundle arguments = getArguments();
        try {
            TXOneLoginResult tXOneLoginResult = (TXOneLoginResult) AppInfo.f().fromJson(arguments == null ? null : arguments.getString("login_one_num"), (Class<Object>) TXOneLoginResult.class);
            this.d = tXOneLoginResult;
            Log.v("drb", Intrinsics.a("loginResult:", tXOneLoginResult));
        } catch (Exception e) {
        }
        Bundle arguments2 = getArguments();
        String string = arguments2 == null ? null : arguments2.getString("aliasUserId");
        this.f = string;
        Log.v("drb", Intrinsics.a("aliasUserId:", string));
        a();
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.ONE_CLICK_POP_SHOW);
        return inflate;
    }
}
