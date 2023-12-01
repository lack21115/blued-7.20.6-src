package com.soft.blued.ui.login_register.auto;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.auto.ILoginService;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.login_register.LoginV1ForThreeActivity;
import com.soft.blued.ui.login_register.RegisterV1ForPhoneFragment;
import com.soft.blued.ui.login_register.View.LoginWithEmailFragment;
import com.soft.blued.ui.login_register.View.LoginWithPhoneFragment;
import com.soft.blued.ui.login_register.View.OneLoginFragmentNew;
import com.soft.blued.ui.login_register.utils.LoginTool;
import com.soft.blued.ui.mine.fragment.TouristFragment;
import com.soft.blued.ui.setting.fragment.ModifyHealthFragment;
import com.soft.blued.ui.setting.fragment.ServerAddressSettingFragment;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.Arrays;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/auto/LoginServiceImpl.class */
public class LoginServiceImpl implements ILoginService {
    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, CheckBox checkBox) {
        boolean z;
        int hashCode = str.hashCode();
        if (hashCode == -518324925) {
            if (str.equals("check_term")) {
                z = false;
            }
            z = true;
        } else if (hashCode != 1069181927) {
            if (hashCode == 1938103376 && str.equals("one_login")) {
                z = true;
            }
            z = true;
        } else {
            if (str.equals("to_register")) {
                z = true;
            }
            z = true;
        }
        if (!z) {
            if (BluedPreferences.aD()) {
                return;
            }
            checkBox.setChecked(false);
            LiveEventBus.get(EventBusConstant.KEY_EVENT_LOGIN_CHECK).post(false);
        } else if (!z) {
        } else {
            EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_PAGE_REGISTER_BTN_CLICK);
            LoginRegisterHttpUtils.a("signup_main");
            TerminalActivity.d(checkBox.getContext(), RegisterV1ForPhoneFragment.class, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, Context context, final CheckBox checkBox) {
        BluedAlertDialog a2 = CommonAlertDialog.a(context, 0, context.getString(2131892461), context.getString(2131892460), context.getString(2131892459), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.auto.LoginServiceImpl.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                LoginTool loginTool = LoginTool.f31584a;
                LoginTool.a();
                BluedPreferences.aE();
                LoginServiceImpl.this.a(str, checkBox);
            }
        }, context.getString(2131892458), (DialogInterface.OnClickListener) null, new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.login_register.auto.LoginServiceImpl.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (BluedPreferences.aD()) {
                    EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_PRIVACY_POP_AGREE_CLICK);
                    return;
                }
                if (TextUtils.equals(str, "check_term")) {
                    checkBox.setChecked(false);
                }
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_PRIVACY_POP_DISAGREE_CLICK);
            }
        }, 3);
        a2.a(false);
        final TextView h = a2.h();
        h.setMovementMethod(LinkMovementClickMethod.a());
        h.setText(StringUtils.a(StringUtils.a(new SpannableStringBuilder(h.getText().toString()), h.getContext().getString(2131890427), new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.auto.LoginServiceImpl.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                WebViewShowInfoFragment.show(h.getContext(), H5Url.a(21), 0);
            }
        }), h.getContext().getString(2131890425), new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.auto.LoginServiceImpl.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                WebViewShowInfoFragment.show(h.getContext(), H5Url.a(22), 0);
            }
        }));
    }

    @Override // com.blued.login.auto.ILoginService
    public String a() {
        return "MAIN";
    }

    @Override // com.blued.login.auto.ILoginService
    public String a(String str) {
        return UserRelationshipUtils.b(str) + "";
    }

    @Override // com.blued.login.auto.ILoginService
    public void a(Context context) {
        TerminalActivity.d(context, ServerAddressSettingFragment.class, null);
    }

    @Override // com.blued.login.auto.ILoginService
    public void a(Context context, Bundle bundle) {
        LoginWithPhoneFragment.a(context, bundle);
    }

    @Override // com.blued.login.auto.ILoginService
    public void a(Context context, Bundle bundle, Bundle bundle2) {
        HomeArgumentHelper.a(context, bundle, bundle2);
    }

    @Override // com.blued.login.auto.ILoginService
    public void a(TextView textView, TextView textView2, boolean z) {
        LoginTool.f31584a.a(textView, textView2, z);
    }

    @Override // com.blued.login.auto.ILoginService
    public void a(BaseFragment baseFragment, int i, int i2) {
        PhotoSelectFragment.a(baseFragment, i, i2);
    }

    @Override // com.blued.login.auto.ILoginService
    public void a(BaseFragment baseFragment, String str, String str2, String str3, int i) {
        ModifyHealthFragment.a(baseFragment, str, str2, str3, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016c  */
    @Override // com.blued.login.auto.ILoginService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.module.common.user.model.BluedLoginResult r11, com.blued.login.model.LoginAVConfigExtra r12, com.blued.login.model.ProfileInfoModel r13, android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.login_register.auto.LoginServiceImpl.a(com.blued.android.module.common.user.model.BluedLoginResult, com.blued.login.model.LoginAVConfigExtra, com.blued.login.model.ProfileInfoModel, android.content.Context):void");
    }

    @Override // com.blued.login.auto.ILoginService
    public void a(final String str, final Context context, final CheckBox checkBox) {
        if (BluedPreferences.aD()) {
            a(str, checkBox);
            return;
        }
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_PRIVACY_POP_SHOW);
        BluedAlertDialog a2 = CommonAlertDialog.a(context, 0, context.getString(2131892465), context.getString(2131892464), context.getString(2131892463), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.auto.LoginServiceImpl.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                LoginTool loginTool = LoginTool.f31584a;
                LoginTool.a();
                BluedPreferences.aE();
            }
        }, context.getString(2131892462), (DialogInterface.OnClickListener) null, new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.login_register.auto.LoginServiceImpl.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (!BluedPreferences.aD()) {
                    LoginServiceImpl.this.b(str, context, checkBox);
                    return;
                }
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_PRIVACY_POP_AGREE_CLICK);
                LoginServiceImpl.this.a(str, checkBox);
            }
        }, 3);
        a2.a(false);
        final TextView h = a2.h();
        h.setMovementMethod(LinkMovementClickMethod.a());
        h.setText(StringUtils.a(StringUtils.a(StringUtils.a(StringUtils.a(new SpannableStringBuilder(h.getText().toString()), Arrays.asList(h.getContext().getResources().getStringArray(2130903100)), 2131102254), h.getContext().getString(2131890427), new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.auto.LoginServiceImpl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                WebViewShowInfoFragment.show(h.getContext(), H5Url.a(21), 0);
            }
        }), h.getContext().getString(2131890425), new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.auto.LoginServiceImpl.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                WebViewShowInfoFragment.show(h.getContext(), H5Url.a(22), 0);
            }
        }), h.getContext().getString(2131890426), new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.auto.LoginServiceImpl.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                WebViewShowInfoFragment.show(context, H5Url.a(83), 0);
            }
        }));
    }

    @Override // com.blued.login.auto.ILoginService
    public String b() {
        return DeviceUtils.g();
    }

    @Override // com.blued.login.auto.ILoginService
    public String b(String str) {
        return UserRelationshipUtils.c(str) + "";
    }

    @Override // com.blued.login.auto.ILoginService
    public void b(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("from_tag_page", "from_tag_register");
        bundle.putBoolean("show_tag_page", true);
        HomeArgumentHelper.a(context, (String) null, bundle);
    }

    @Override // com.blued.login.auto.ILoginService
    public void b(Context context, Bundle bundle) {
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_BTN_CLICK, LoginAndRegisterProtos.Source.WECHAT);
        Intent intent = new Intent(context, LoginV1ForThreeActivity.class);
        if (bundle != null) {
            intent.putExtra("fragment_args", bundle);
        }
        intent.putExtra("from_three_plat", "plat_weixin");
        context.startActivity(intent);
    }

    @Override // com.blued.login.auto.ILoginService
    public void c() {
        UserRelationshipUtils.b();
    }

    @Override // com.blued.login.auto.ILoginService
    public void c(Context context) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_bind_phone", true);
        bundle.putBoolean("from_register", true);
        a(context, bundle);
    }

    @Override // com.blued.login.auto.ILoginService
    public void c(Context context, Bundle bundle) {
        if (context instanceof BaseFragmentActivity) {
            OneLoginFragmentNew.a(context, bundle);
        }
    }

    @Override // com.blued.login.auto.ILoginService
    public void d(Context context) {
        TerminalActivity.d(context, TouristFragment.class, null);
    }

    @Override // com.blued.login.auto.ILoginService
    public void d(Context context, Bundle bundle) {
        LoginWithEmailFragment.a(context, bundle);
    }
}
