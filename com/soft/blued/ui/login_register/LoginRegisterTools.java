package com.soft.blued.ui.login_register;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.android.internal.telephony.PhoneConstants;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.data.SessionHeader;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.BluedLoginResultVerBinding;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.blued.android.statistics.BluedStatistics;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.model.BluedCheckResult;
import com.bytedance.applog.tracker.Tracker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ishumei.sdk.captcha.SmCaptchaWebView;
import com.soft.blued.R;
import com.soft.blued.customview.CardDialog;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.login_register.model.RemindSettingModel;
import com.soft.blued.ui.setting.fragment.BindingSecureEmailFragment;
import com.soft.blued.ui.setting.tools.ServiceHelper;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/LoginRegisterTools.class */
public class LoginRegisterTools {
    private static String p = LoginRegisterTools.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public static String f31399a = "re_type";
    public static String b = "re_type_three";

    /* renamed from: c  reason: collision with root package name */
    public static String f31400c = "re_captcha";
    public static String d = "re_token";
    public static String e = "re_phone";
    public static String f = "re_email";
    public static String g = "re_phone_areacode";
    public static String h = "re_password";
    public static String i = "re_nickname";
    public static String j = "re_account";
    public static String k = "link_mobile_type";
    public static String l = "link_mobile_change_mobile";
    public static String m = "link_mobile_thr_password";
    public static String n = "link_mobile_change_pay";
    public static String o = "link_mobile_change_pay_bind";

    /* renamed from: com.soft.blued.ui.login_register.LoginRegisterTools$13  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/LoginRegisterTools$13.class */
    class AnonymousClass13 implements FetchDataListener<Map<String, SessionModel>> {
        AnonymousClass13() {
        }

        @Override // com.blued.android.chat.listener.FetchDataListener
        /* renamed from: a */
        public void onFetchData(final Map<String, SessionModel> map) {
            LoginRegisterHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<RemindSettingModel>>() { // from class: com.soft.blued.ui.login_register.LoginRegisterTools.13.1
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<RemindSettingModel> bluedEntityA) {
                    List<RemindSettingModel.GroupInfo> groups;
                    if (bluedEntityA != null) {
                        try {
                            if (!bluedEntityA.hasData() || (groups = bluedEntityA.data.get(0).getGroups()) == null) {
                                return;
                            }
                            ArrayList<RemindSettingModel.GroupInfo> arrayList = new ArrayList();
                            for (RemindSettingModel.GroupInfo groupInfo : groups) {
                                long parseLong = Long.parseLong(groupInfo.gid);
                                if (map != null) {
                                    SessionModel sessionModel = (SessionModel) map.get(SessionHeader.getSessionKey(3, parseLong));
                                    if (sessionModel != null && sessionModel.sessionSettingModel != null) {
                                        SessionSettingModel sessionSettingModel = (SessionSettingModel) sessionModel.sessionSettingModel;
                                        if (sessionSettingModel.getRemindAudio() != groupInfo.nodisturb) {
                                            sessionSettingModel.setRemindAudio(groupInfo.nodisturb);
                                            ChatManager.getInstance().setSessionSetting((short) 3, parseLong, sessionSettingModel);
                                        }
                                    }
                                }
                                arrayList.add(groupInfo);
                            }
                            for (RemindSettingModel.GroupInfo groupInfo2 : arrayList) {
                                long parseLong2 = Long.parseLong(groupInfo2.gid);
                                SessionSettingModel sessionSettingModel2 = new SessionSettingModel();
                                sessionSettingModel2.setRemindAudio(groupInfo2.nodisturb);
                                sessionSettingModel2.setLoadName(Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue());
                                sessionSettingModel2.setSessionId(parseLong2);
                                sessionSettingModel2.setSessionType((short) 3);
                                ChatManager.getInstance().setSessionSetting((short) 3, parseLong2, sessionSettingModel2);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, UserInfo.getInstance().getLoginUserInfo().getUid(), null);
        }
    }

    /* renamed from: com.soft.blued.ui.login_register.LoginRegisterTools$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/LoginRegisterTools$2.class */
    class AnonymousClass2 extends TypeToken<BluedEntityA<BluedCheckResult>> {
        AnonymousClass2() {
        }
    }

    public static AlertDialog a(Context context, final SmCaptchaWebView.ResultListener resultListener) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_sm_captcha, (ViewGroup) null, false);
        final AlertDialog create = new AlertDialog.Builder(context).setView(inflate).create();
        String string = context.getString(2131886715);
        SmCaptchaWebView smCaptchaWebView = (SmCaptchaWebView) inflate.findViewById(2131369860);
        SmCaptchaWebView.SmOption smOption = new SmCaptchaWebView.SmOption();
        smOption.setOrganization("qRLrIEyYwqE1vOhOACQy");
        smOption.setMode(SmCaptchaWebView.MODE_SLIDE);
        smOption.setAppId("1");
        smOption.setChannel(AppInfo.f9487c);
        if (!BlueAppLocal.d()) {
            HashMap hashMap = new HashMap();
            hashMap.put("lang", "en");
            smOption.setExtOption(hashMap);
        }
        if (!TextUtils.isEmpty(string)) {
            smOption.setTipMessage(string);
        }
        smCaptchaWebView.setBackgroundColor(0);
        int initWithOption = smCaptchaWebView.initWithOption(smOption, new SmCaptchaWebView.ResultListener() { // from class: com.soft.blued.ui.login_register.LoginRegisterTools.5
            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
            public void onError(int i2) {
                SmCaptchaWebView.ResultListener resultListener2 = SmCaptchaWebView.ResultListener.this;
                if (resultListener2 != null) {
                    resultListener2.onError(i2);
                }
            }

            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
            public void onReady() {
                SmCaptchaWebView.ResultListener resultListener2 = SmCaptchaWebView.ResultListener.this;
                if (resultListener2 != null) {
                    resultListener2.onReady();
                }
            }

            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
            public void onSuccess(CharSequence charSequence, boolean z) {
                AlertDialog alertDialog;
                SmCaptchaWebView.ResultListener resultListener2 = SmCaptchaWebView.ResultListener.this;
                if (resultListener2 != null) {
                    resultListener2.onSuccess(charSequence, z);
                }
                if (!z || (alertDialog = create) == null) {
                    return;
                }
                alertDialog.dismiss();
            }
        });
        if (SmCaptchaWebView.SMCAPTCHA_SUCCESS != initWithOption) {
            String str = p;
            Logger.e(str, "SmCaptchaWebView error: " + initWithOption);
            BluedStatistics.b().a("SM_CAPTCHA", initWithOption, "");
        }
        create.setCancelable(false);
        create.setCanceledOnTouchOutside(false);
        create.show();
        if (create.getWindow() != null) {
            create.getWindow().setBackgroundDrawableResource(2131102388);
        }
        return create;
    }

    public static String a(String str) {
        try {
            Gson f2 = AppInfo.f();
            BluedEntityA bluedEntityA = (BluedEntityA) f2.fromJson(str, new TypeToken<BluedEntityA<BluedCheckResult>>() { // from class: com.soft.blued.ui.login_register.LoginRegisterTools.1
            }.getType());
            if (bluedEntityA == null || !bluedEntityA.hasData()) {
                return null;
            }
            String a2 = AesCrypto2.a(((BluedCheckResult) bluedEntityA.data.get(0)).getEncrypted());
            Logger.b(p, "解密：deData===", a2);
            BluedCheckResult bluedCheckResult = (BluedCheckResult) f2.fromJson(a2, (Class<Object>) BluedCheckResult.class);
            if (bluedCheckResult != null) {
                return bluedCheckResult.getCaptcha();
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a(String str, String str2) {
        return str + "-" + str2;
    }

    public static String a(String str, String str2, String str3) {
        Gson f2 = AppInfo.f();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("access_token", str);
        arrayMap.put("user_id", str2);
        arrayMap.put("three_type", str3);
        return f2.toJson(arrayMap);
    }

    public static void a() {
        int h2 = CommonPreferences.h();
        Logger.a("Start_count", "start one time");
        CommonPreferences.h(h2 + 1);
    }

    public static void a(final Context context, int i2, int i3) {
        if (CommonPreferences.h() >= CommonPreferences.h) {
            final CardDialog.Builder builder = new CardDialog.Builder(context);
            builder.a().b(new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.LoginRegisterTools.11
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    Tracker.onClick(dialogInterface, i4);
                    if (CardDialog.Builder.this.b() != null) {
                        CardDialog.Builder.this.b().dismiss();
                    }
                }
            }).a(new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.LoginRegisterTools.10
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    Tracker.onClick(dialogInterface, i4);
                    if (CardDialog.Builder.this.d() != 1) {
                        if (CardDialog.Builder.this.d() == 0) {
                            String b2 = LoginRegisterTools.b();
                            if (StringUtils.d(b2)) {
                                TerminalActivity.d(context, LinkMobileFragment.class, null);
                                return;
                            }
                            String[] g2 = LoginRegisterTools.g(b2);
                            LoginRegisterTools.a(context, g2[0], g2[1]);
                            return;
                        }
                        return;
                    }
                    String d2 = LoginRegisterTools.d();
                    Bundle bundle = new Bundle();
                    bundle.putString(LoginRegisterTools.f, d2);
                    bundle.putInt(LoginRegisterTools.f31399a, 0);
                    if (!TextUtils.isEmpty(d2)) {
                        TerminalActivity.d(context, LinkMobileSuccessFragment.class, bundle);
                        return;
                    }
                    bundle.putString("binding_type", "add");
                    TerminalActivity.d(context, BindingSecureEmailFragment.class, bundle);
                }
            }).a(i2, i3).e().f();
            if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                builder.b().show();
            }
            CommonPreferences.h(0);
        }
    }

    public static void a(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt(f31399a, 1);
        bundle.putString(g, str);
        bundle.putString(e, str2);
        TerminalActivity.d(context, LinkMobileSuccessFragment.class, bundle);
    }

    public static void a(View view) {
        if (UserInfo.getInstance().getLoginType() != 2 || view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public static void a(FragmentActivity fragmentActivity) {
        final String string = fragmentActivity.getResources().getString(2131886661);
        CommonShowBottomWindow.a(fragmentActivity, fragmentActivity.getResources().getStringArray(R.array.login_forgetsecret_phone_email), new ActionSheet.ActionSheetListener() { // from class: com.soft.blued.ui.login_register.LoginRegisterTools.7
            @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
            public void a(ActionSheet actionSheet, int i2) {
                if (i2 == 0) {
                    EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.FIND_PWD_BY_PHONE);
                    WebViewShowInfoFragment.a(AppInfo.d(), BluedHttpUrl.b(), String.this, 1);
                } else if (i2 == 1) {
                    EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.FIND_PWD_BY_REG_EMAIL);
                    WebViewShowInfoFragment.a(AppInfo.d(), BluedHttpUrl.c(), String.this, 1);
                } else if (i2 != 2) {
                } else {
                    EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.FIND_PWD_BY_SAFE_EMAIL);
                    WebViewShowInfoFragment.a(AppInfo.d(), BluedHttpUrl.d(), String.this, 1);
                }
            }

            @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
            public void a(ActionSheet actionSheet, boolean z) {
            }
        });
    }

    public static void a(final FragmentActivity fragmentActivity, final int i2) {
        CommonAlertDialog.a(fragmentActivity, "", fragmentActivity.getResources().getString(2131890487), fragmentActivity.getResources().getString(2131886661), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.LoginRegisterTools.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                Tracker.onClick(dialogInterface, i3);
                LoginRegisterTools.b(FragmentActivity.this, i2);
            }
        }, fragmentActivity.getResources().getString(2131886717), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public static void a(IRequestHost iRequestHost, ImageView imageView, String str) {
        ImageLoader.a(iRequestHost, str + "?" + UUID.randomUUID()).a().a(imageView);
    }

    public static String b() {
        BluedLoginResultVerBinding verified_bindings;
        return !StringUtils.d(UserInfo.getInstance().getBindPhoneNum()) ? h(UserInfo.getInstance().getBindPhoneNum()) : (UserInfo.getInstance().getLoginUserInfo() == null || (verified_bindings = UserInfo.getInstance().getLoginUserInfo().getVerified_bindings()) == null) ? "" : verified_bindings.mobile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, int i2) {
        if (i2 == 0) {
            WebViewShowInfoFragment.a(AppInfo.d(), BluedHttpUrl.b(), context.getResources().getString(2131886661), 1);
        } else if (i2 != 1) {
        } else {
            WebViewShowInfoFragment.a(AppInfo.d(), BluedHttpUrl.c(), context.getResources().getString(2131886661), 1);
        }
    }

    public static void b(final FragmentActivity fragmentActivity) {
        CommonShowBottomWindow.a(fragmentActivity, new String[]{fragmentActivity.getResources().getStringArray(R.array.login_question)[0]}, new ActionSheet.ActionSheetListener() { // from class: com.soft.blued.ui.login_register.LoginRegisterTools.8
            @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
            public void a(ActionSheet actionSheet, int i2) {
                if (i2 == 0) {
                    LoginRegisterTools.a(FragmentActivity.this);
                } else if (i2 != 1) {
                } else {
                    ServiceHelper.f33645a.a(FragmentActivity.this);
                }
            }

            @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
            public void a(ActionSheet actionSheet, boolean z) {
            }
        });
    }

    public static String[] b(String str) {
        String[] strArr = new String[2];
        try {
            Gson f2 = AppInfo.f();
            BluedEntityA bluedEntityA = (BluedEntityA) f2.fromJson(str, new TypeToken<BluedEntityA<BluedCheckResult>>() { // from class: com.soft.blued.ui.login_register.LoginRegisterTools.3
            }.getType());
            if (bluedEntityA != null && bluedEntityA.hasData()) {
                String a2 = AesCrypto2.a(((BluedCheckResult) bluedEntityA.data.get(0)).getEncrypted());
                Logger.b(p, "解密：deData===", a2);
                BluedCheckResult bluedCheckResult = (BluedCheckResult) f2.fromJson(a2, (Class<Object>) BluedCheckResult.class);
                if (bluedCheckResult != null) {
                    strArr[0] = bluedCheckResult.getToken();
                    strArr[1] = bluedCheckResult.getCaptcha();
                    return strArr;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return strArr;
    }

    public static String c() {
        BluedLoginResultVerBinding verified_bindings;
        String boundWechat = UserInfo.getInstance().getBoundWechat();
        return !TextUtils.isEmpty(boundWechat) ? boundWechat : (UserInfo.getInstance().getLoginUserInfo() == null || (verified_bindings = UserInfo.getInstance().getLoginUserInfo().getVerified_bindings()) == null) ? "" : verified_bindings.third_weixin;
    }

    public static boolean c(String str) {
        try {
            Gson f2 = AppInfo.f();
            BluedEntityA bluedEntityA = (BluedEntityA) f2.fromJson(str, new TypeToken<BluedEntityA<BluedCheckResult>>() { // from class: com.soft.blued.ui.login_register.LoginRegisterTools.4
            }.getType());
            if (bluedEntityA == null || !bluedEntityA.hasData()) {
                return false;
            }
            String a2 = AesCrypto2.a(((BluedCheckResult) bluedEntityA.data.get(0)).getEncrypted());
            Logger.b(p, "解密：deData===", a2);
            BluedCheckResult bluedCheckResult = (BluedCheckResult) f2.fromJson(a2, (Class<Object>) BluedCheckResult.class);
            if (bluedCheckResult != null) {
                return bluedCheckResult.getIs_sm_captcha() == 1;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static BluedCheckResult d(String str) {
        try {
            Gson f2 = AppInfo.f();
            BluedEntityA bluedEntityA = (BluedEntityA) f2.fromJson(str, new TypeToken<BluedEntityA<BluedCheckResult>>() { // from class: com.soft.blued.ui.login_register.LoginRegisterTools.6
            }.getType());
            if (bluedEntityA != null && bluedEntityA.hasData()) {
                String a2 = AesCrypto2.a(((BluedCheckResult) bluedEntityA.data.get(0)).getEncrypted());
                Logger.b(p, "解密：deData===", a2);
                return (BluedCheckResult) f2.fromJson(a2, (Class<Object>) BluedCheckResult.class);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return new BluedCheckResult();
    }

    public static String d() {
        BluedLoginResultVerBinding verified_bindings;
        String boundMail = UserInfo.getInstance().getBoundMail();
        return !TextUtils.isEmpty(boundMail) ? boundMail : (UserInfo.getInstance().getLoginUserInfo() == null || (verified_bindings = UserInfo.getInstance().getLoginUserInfo().getVerified_bindings()) == null) ? "" : verified_bindings.safe_email;
    }

    public static String e(String str) {
        try {
            if (StringUtils.d(str)) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer(str);
            if (stringBuffer.length() <= 7) {
                return str;
            }
            String substring = stringBuffer.substring(0, 3);
            String substring2 = stringBuffer.substring(stringBuffer.length() - 4, stringBuffer.length());
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i2 = 0; i2 < stringBuffer.length() - 7; i2++) {
                stringBuffer2.append(PhoneConstants.APN_TYPE_ALL);
            }
            return substring + stringBuffer2.toString() + substring2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void e() {
        ChatManager.getInstance().getSessionSettingModel((short) 1, 2L, new FetchDataListener<SessionSettingBaseModel>() { // from class: com.soft.blued.ui.login_register.LoginRegisterTools.12
            @Override // com.blued.android.chat.listener.FetchDataListener
            /* renamed from: a */
            public void onFetchData(SessionSettingBaseModel sessionSettingBaseModel) {
                LoginRegisterHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<RemindSettingModel>>() { // from class: com.soft.blued.ui.login_register.LoginRegisterTools.12.1
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<RemindSettingModel> bluedEntityA) {
                        if (bluedEntityA != null) {
                            try {
                                if (bluedEntityA.hasData()) {
                                    boolean z = false;
                                    RemindSettingModel remindSettingModel = bluedEntityA.data.get(0);
                                    BluedPreferences.p("1".equals(remindSettingModel.is_other_message_push));
                                    BluedPreferences.m("1".equals(remindSettingModel.getIs_push_content()));
                                    BluedPreferences.k("1".equals(remindSettingModel.getIs_open_sound()));
                                    BluedPreferences.j("1".equals(remindSettingModel.getIs_bluedtone()));
                                    BluedPreferences.l("1".equals(remindSettingModel.getIs_open_shake()));
                                    BluedPreferences.n("1".equals(remindSettingModel.getIs_system_push()));
                                    BluedPreferences.o("0".equals(remindSettingModel.getIs_live_push()));
                                    BluedPreferences.q("1".equals(remindSettingModel.getIs_private_msg_push()));
                                    BluedPreferences.r("1".equals(remindSettingModel.getIs_followed_push()));
                                    BluedPreferences.s("1".equals(remindSettingModel.getIs_groups_notify()));
                                    if (!"2".equals(remindSettingModel.getIs_comment_push())) {
                                        if ("1".equals(remindSettingModel.getIs_comment_push())) {
                                        }
                                        BluedPreferences.t(z);
                                        BluedPreferences.x("1".equals(remindSettingModel.is_recall_live_push));
                                        BluedPreferences.u("1".equals(remindSettingModel.is_like_push));
                                        BluedPreferences.v("1".equals(remindSettingModel.is_at_push));
                                        BluedPreferences.w("1".equals(remindSettingModel.is_visited_push));
                                        BluedPreferences.y("1".equals(remindSettingModel.is_push_posting_post));
                                        BluedPreferences.R("1".equals(remindSettingModel.is_verify_mobile_push));
                                        BluedPreferences.S("1".equals(remindSettingModel.is_used_mobile_push));
                                    }
                                    z = true;
                                    BluedPreferences.t(z);
                                    BluedPreferences.x("1".equals(remindSettingModel.is_recall_live_push));
                                    BluedPreferences.u("1".equals(remindSettingModel.is_like_push));
                                    BluedPreferences.v("1".equals(remindSettingModel.is_at_push));
                                    BluedPreferences.w("1".equals(remindSettingModel.is_visited_push));
                                    BluedPreferences.y("1".equals(remindSettingModel.is_push_posting_post));
                                    BluedPreferences.R("1".equals(remindSettingModel.is_verify_mobile_push));
                                    BluedPreferences.S("1".equals(remindSettingModel.is_used_mobile_push));
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }, UserInfo.getInstance().getLoginUserInfo().getUid(), (IRequestHost) null);
            }
        });
    }

    public static String f(String str) {
        try {
            return !StringUtils.d(str) ? AesCrypto.c(str) : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String[] g(String str) {
        String[] strArr = new String[2];
        String[] strArr2 = strArr;
        if (!StringUtils.d(str)) {
            strArr2 = strArr;
            if (str.contains("-")) {
                String[] split = str.split("-");
                strArr2 = strArr;
                if (split.length == 2) {
                    strArr2 = split;
                }
            }
        }
        return strArr2;
    }

    public static String h(String str) {
        String[] g2 = g(str);
        return a(g2[0], e(g2[1]));
    }
}
