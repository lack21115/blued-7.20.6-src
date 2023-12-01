package com.soft.blued.ui.login_register.utils;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.anythink.expressad.video.dynview.a.a;
import com.blued.android.chat.utils.BlueAppChatLocal;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.utils.NinePatchUtils;
import com.blued.android.module.common.view.CommonGuidePop;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.blued.login.auto.LoginServiceManager;
import com.blued.login.utils.LoginHelper;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.qq.e.comm.managers.GDTAdSdk;
import com.soft.blued.BluedConstant;
import com.soft.blued.app.InitTaskUtil;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.third.BluedFingerPrintUtils;
import com.soft.blued.utils.third.YouMengUtils;
import com.tencent.map.geolocation.TencentLocationManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/utils/LoginTool.class */
public final class LoginTool {

    /* renamed from: a  reason: collision with root package name */
    public static final LoginTool f31584a = new LoginTool();

    private LoginTool() {
    }

    @JvmStatic
    public static final void a() {
        try {
            AppInfo.t();
            AppInfo.q();
            AppInfo.s();
            BluedDeviceIdentity.a().a(AppInfo.d(), Intrinsics.a(BluedHttpUrl.q(), (Object) "/blued/device"), 2);
            InitTaskUtil.initBluedAPM();
            InitTaskUtil.initUMeng();
            InitTaskUtil.initMap();
            InitTaskUtil.initTTAdSDK();
            InitTaskUtil.initBDSDK();
            InitTaskUtil.initTXSDK();
            InitTaskUtil.initYouZanSDK();
            InitTaskUtil.initTopOnAdSDK();
            InitTaskUtil.initHWADSDK();
            InitTaskUtil.initKSSDK();
            InitTaskUtil.initBuglyCrash(AppInfo.d());
            InitTaskUtil.initByteDanceSDK();
            InitTaskUtil.initWMSDK();
            YouMengUtils.a();
            InitTaskUtil.initZego();
            InitTaskUtil.initPush();
            GDTAdSdk.init(AppInfo.d(), BluedConstant.a());
            TencentLocationManager.setUserAgreePrivacy(true);
            BluedFingerPrintUtils.a();
            InitTaskUtil.initLoginSplash();
            LoginRegisterHttpUtils.b();
            InitTaskUtil.initOPPOAdSDK();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Context context, View view) {
        Tracker.onClick(view);
        WebViewShowInfoFragment.show(context, H5Url.a(21), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View contentView, CheckBox checkBox, CompoundButton compoundButton, boolean z) {
        Tracker.onCheckedChanged(compoundButton, z);
        Intrinsics.e(contentView, "$contentView");
        if (z) {
            LoginServiceManager.a().a("check_term", contentView.getContext(), checkBox);
        }
        LiveEventBus.get(EventBusConstant.KEY_EVENT_LOGIN_CHECK).post(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Context context, View view) {
        Tracker.onClick(view);
        WebViewShowInfoFragment.show(context, H5Url.a(22), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Context context, View view) {
        Tracker.onClick(view);
        String language = BlueAppChatLocal.getLanguage();
        WebViewShowInfoFragment.show(context, Intrinsics.a((Object) language, (Object) "en") ? H5Url.a(86) : Intrinsics.a((Object) language, (Object) a.V) ? H5Url.a(85) : H5Url.a(87), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Context context, View view) {
        Tracker.onClick(view);
        WebViewShowInfoFragment.show(context, H5Url.a(21), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Context context, View view) {
        Tracker.onClick(view);
        WebViewShowInfoFragment.show(context, H5Url.a(22), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Context context, View view) {
        Tracker.onClick(view);
        String language = BlueAppChatLocal.getLanguage();
        WebViewShowInfoFragment.show(context, Intrinsics.a((Object) language, (Object) "en") ? H5Url.a(86) : Intrinsics.a((Object) language, (Object) a.V) ? H5Url.a(85) : H5Url.a(87), 0);
    }

    public final CommonGuidePop a(Context context) {
        Intrinsics.e(context, "context");
        String string = context.getString(2131890420);
        Intrinsics.c(string, "context.getString(R.string.login_check_argument)");
        CommonGuidePop commonGuidePop = new CommonGuidePop(context, string, NinePatchUtils.GuideArrowPosition.LEFT, 2131232896);
        commonGuidePop.setClickThrough(true);
        commonGuidePop.setDismissOnTouchOutside(false);
        commonGuidePop.setOffsetX(-DensityUtils.a(context, 15.0f));
        return commonGuidePop;
    }

    public final void a(final View contentView, boolean z) {
        Intrinsics.e(contentView, "contentView");
        View findViewById = contentView.findViewById(2131372705);
        Intrinsics.c(findViewById, "contentView.findViewById(R.id.tv_terms)");
        TextView textView = (TextView) findViewById;
        View findViewById2 = contentView.findViewById(2131372706);
        Intrinsics.c(findViewById2, "contentView.findViewById(R.id.tv_terms_en)");
        LoginServiceManager.a().a(textView, (TextView) findViewById2, z);
        final CheckBox checkBox = (CheckBox) contentView.findViewById(2131364005).findViewById(2131362774);
        checkBox.setChecked(true);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.login_register.utils.-$$Lambda$LoginTool$dLwmDeV6QUt7IONWbFCsbzqe7fU
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                LoginTool.a(View.this, checkBox, compoundButton, z2);
            }
        });
    }

    public final void a(CheckBox cb, CommonGuidePop rulePop, View view) {
        Intrinsics.e(cb, "cb");
        Intrinsics.e(rulePop, "rulePop");
        if (cb.isChecked()) {
            rulePop.p();
            return;
        }
        if (!rulePop.s()) {
            CommonGuidePop.t.a(rulePop, new SimpleCallback(), cb, 0L);
        }
        if (view == null) {
            return;
        }
        view.startAnimation(LoginHelper.f20590a.a(3));
    }

    public final void a(TextView tvTerms, TextView tvTermsEn, boolean z) {
        Intrinsics.e(tvTerms, "tvTerms");
        Intrinsics.e(tvTermsEn, "tvTermsEn");
        final Context d = AppInfo.d();
        if (BlueAppChatLocal.isZh()) {
            tvTermsEn.setVisibility(8);
            tvTerms.setVisibility(0);
            TypefaceUtils.a(d, tvTerms, new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.utils.-$$Lambda$LoginTool$kI4qh0MFNYDd9HF9spc45RyMxDQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginTool.a(Context.this, view);
                }
            }, new TypefaceUtils.SpannIndex(7, 18), new TypefaceUtils.SpannIndex(29, 49), z);
            TypefaceUtils.a(d, tvTerms, new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.utils.-$$Lambda$LoginTool$TSFKtSN-bJy_5moqkPCDSaqAVpg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginTool.b(Context.this, view);
                }
            }, new TypefaceUtils.SpannIndex(19, 29), new TypefaceUtils.SpannIndex(51, 89), z);
            TypefaceUtils.a(d, tvTerms, new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.utils.-$$Lambda$LoginTool$d6FdYkmNyKqs0E3bXP1439nL4q8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginTool.c(Context.this, view);
                }
            }, new TypefaceUtils.SpannIndex(29, 40), new TypefaceUtils.SpannIndex(91, 123), z);
            return;
        }
        tvTermsEn.setVisibility(0);
        tvTerms.setVisibility(8);
        TypefaceUtils.a(d, tvTermsEn, new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.utils.-$$Lambda$LoginTool$5dGPbuayXBVODhKNrAOisi9NeX0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginTool.d(Context.this, view);
            }
        }, new TypefaceUtils.SpannIndex(7, 18), new TypefaceUtils.SpannIndex(29, 49), z);
        TypefaceUtils.a(d, tvTermsEn, new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.utils.-$$Lambda$LoginTool$GoeP5MQBYYd0HwjjU90GwLCK1sI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginTool.e(Context.this, view);
            }
        }, new TypefaceUtils.SpannIndex(19, 29), new TypefaceUtils.SpannIndex(51, 89), z);
        TypefaceUtils.a(d, tvTermsEn, new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.utils.-$$Lambda$LoginTool$w8LSBTBFii5toU63r-zsgm1rgVw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginTool.f(Context.this, view);
            }
        }, new TypefaceUtils.SpannIndex(29, 40), new TypefaceUtils.SpannIndex(91, 123), z);
    }
}
