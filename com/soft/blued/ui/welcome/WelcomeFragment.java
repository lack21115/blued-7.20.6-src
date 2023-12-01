package com.soft.blued.ui.welcome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.blued.android.config.FlexDebugSevConfig;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.urlroute.BluedURIRouter;
import com.blued.android.module.common.log.oldtrack.InstantLogBody;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.das.login.LoginAndRegisterProtos;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.soft.blued.R;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.databinding.FragmentWelcomeNewBinding;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.login_register.SignInActivity;
import com.soft.blued.ui.welcome.model.SplashEntity;
import com.soft.blued.ui.welcome.model.SplashExtraEntity;
import com.soft.blued.ui.welcome.model.SplashModel;
import com.soft.blued.utils.ADUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.Logger;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/WelcomeFragment.class */
public final class WelcomeFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f20927a = new Companion(null);
    public static boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f20928c = true;
    private boolean d = true;
    private FragmentWelcomeNewBinding e;
    private String f;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/WelcomeFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(Context context, boolean z) {
            Intrinsics.e(context, "context");
            a(context, z, true);
        }

        @JvmStatic
        public final void a(Context context, boolean z, boolean z2) {
            Intrinsics.e(context, "context");
            Bundle bundle = new Bundle();
            bundle.putBoolean("arg_show_ad", z);
            bundle.putBoolean("arg_open_home", z2);
            WelcomeActivity.a(bundle);
            WelcomeActivity.d(context, WelcomeFragment.class, bundle);
            WelcomeFragment.b = true;
        }

        @JvmStatic
        public final boolean a(String str) {
            Intrinsics.e(str, "type");
            int hashCode = str.hashCode();
            if (hashCode == 50) {
                return str.equals("2");
            } else if (hashCode == 57) {
                return str.equals("9");
            } else if (hashCode == 1603) {
                return str.equals("25");
            } else if (hashCode == 1604) {
                return str.equals("26");
            } else {
                switch (hashCode) {
                    case 1573:
                        return str.equals("16");
                    case 1574:
                        return str.equals("17");
                    case 1575:
                        return str.equals("18");
                    case 1576:
                        return str.equals("19");
                    default:
                        switch (hashCode) {
                            case 1598:
                                return str.equals(BaseWrapper.ENTER_ID_SYSTEM_HELPER);
                            case 1599:
                                return str.equals("21");
                            case 1600:
                                return str.equals("22");
                            case 1601:
                                return str.equals("23");
                            default:
                                return false;
                        }
                }
            }
        }

        @JvmStatic
        public final void b(Context context, boolean z) {
            if (!GuideFragment.a(context)) {
                if (!UserInfo.getInstance().isLogin()) {
                    SignInActivity.a(context, new Bundle[0]);
                } else if (z) {
                    Log.v("drb", "「开机图请求页」关闭开机图请求页，跳转至首页");
                    HomeArgumentHelper.a(context);
                } else {
                    Log.v("drb", "「开机图请求页」处理外部跳转链接");
                    if (BluedApplicationLike.outUri != null) {
                        BluedURIRouter.a().a(context, BluedApplicationLike.outUri);
                        BluedApplicationLike.outUri = null;
                    }
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            }
            DeviceUtils.a(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(Continuation<? super SplashModel> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.a(continuation), 1);
        cancellableContinuationImpl.e();
        BuildersKt.a(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new WelcomeFragment$loadAd$2$1(this, cancellableContinuationImpl, null), 3, (Object) null);
        Object h = cancellableContinuationImpl.h();
        if (h == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a(String str, SplashEntity.ShowEntity showEntity) {
        String str2 = showEntity.adms_type;
        boolean z = false;
        if (str2 != null && f20927a.a(str2)) {
            z = true;
        }
        if (!z && !TextUtils.isEmpty(str)) {
            return Intrinsics.a(str, showEntity.image);
        }
        return showEntity.image;
    }

    private final void a() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.d = arguments.getBoolean("arg_show_ad");
            boolean z = arguments.getBoolean("arg_open_home", this.f20928c);
            this.f20928c = z;
            a(Intrinsics.a("initData openHome:", Boolean.valueOf(z)));
        }
        BuildersKt.a(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new WelcomeFragment$initData$1(this, null), 3, (Object) null);
    }

    @JvmStatic
    public static final void a(Context context, boolean z) {
        f20927a.a(context, z);
    }

    @JvmStatic
    public static final void a(Context context, boolean z, boolean z2) {
        f20927a.a(context, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final SplashAdListener splashAdListener) {
        String a2 = ADUtils.a();
        this.f = a2;
        a(Intrinsics.a("开始请求开机图广告（请求自己服务端）requestId Md5:", a2));
        InstantLogBody instantLogBody = new InstantLogBody();
        instantLogBody.service = "AD_REQUEST";
        Map a3 = BluedHttpTools.a();
        Intrinsics.c(a3, "params");
        a3.put("req_id", this.f);
        InstantLog.a(instantLogBody, a3);
        EventTrackLoginAndRegister.b(LoginAndRegisterProtos.Event.AD_REQUEST, this.f);
        Context d = AppInfo.d();
        String aT = BluedPreferences.aT();
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        LoginRegisterHttpUtils.a(d, aT, new BluedUIHttpResponse<BluedEntity<SplashEntity, SplashExtraEntity>>(splashAdListener, fragmentActive) { // from class: com.soft.blued.ui.welcome.WelcomeFragment$loadSplashAd$1
            final /* synthetic */ SplashAdListener b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super((IRequestHost) fragmentActive);
            }

            public void onSuccess(String str) {
                WelcomeFragment.this.a(String.valueOf(str));
            }

            public boolean onUIFailure(int i, String str) {
                String str2;
                String str3;
                LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_REQUEST_FAIL;
                str2 = WelcomeFragment.this.f;
                EventTrackLoginAndRegister.a(event, str2, String.valueOf(i));
                InstantLogBody instantLogBody2 = new InstantLogBody();
                instantLogBody2.service = "AD_REQUEST_FAIL";
                Map a4 = BluedHttpTools.a();
                Intrinsics.c(a4, "params");
                a4.put("code", i + "");
                str3 = WelcomeFragment.this.f;
                a4.put("req_id", str3);
                InstantLog.a(instantLogBody2, a4);
                WelcomeFragment welcomeFragment = WelcomeFragment.this;
                welcomeFragment.a("开机图接口请求失败errorCode：" + i + " errorMessage:" + ((Object) str));
                this.b.a(i, String.valueOf(str));
                return true;
            }

            public void onUIUpdate(BluedEntity<SplashEntity, SplashExtraEntity> bluedEntity) {
                String str;
                String str2;
                String str3;
                String a4;
                String a5;
                String str4;
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_REQUEST_FAIL;
                    str = WelcomeFragment.this.f;
                    EventTrackLoginAndRegister.a(event, str, "服务端未返回数据");
                    WelcomeFragment.this.a("开机图接口请求成功，但是没有数据");
                    return;
                }
                WelcomeFragment.this.a("开机图接口请求成功");
                LoginAndRegisterProtos.Event event2 = LoginAndRegisterProtos.Event.AD_API_REQUEST_SUCCESS;
                str2 = WelcomeFragment.this.f;
                EventTrackLoginAndRegister.b(event2, str2);
                InstantLogBody instantLogBody2 = new InstantLogBody();
                instantLogBody2.service = "AD_API_REQUEST_SUCCESS";
                Map a6 = BluedHttpTools.a();
                Intrinsics.c(a6, "map");
                str3 = WelcomeFragment.this.f;
                a6.put("req_id", str3);
                InstantLog.a(instantLogBody2, a6);
                for (SplashEntity splashEntity : bluedEntity.data) {
                    WelcomeFragment welcomeFragment = WelcomeFragment.this;
                    welcomeFragment.a("广告通用埋点_api广告请求 广告id:" + splashEntity.id + " 类型：" + ((Object) splashEntity.today.adms_type) + " 广告位id:" + ((Object) splashEntity.position_code));
                    LoginAndRegisterProtos.Event event3 = LoginAndRegisterProtos.Event.AD_API_REQUEST;
                    String valueOf = String.valueOf(splashEntity.id);
                    String str5 = splashEntity.today.adms_type;
                    String a7 = Intrinsics.a(splashEntity.position_code, "");
                    str4 = WelcomeFragment.this.f;
                    EventTrackLoginAndRegister.a(event3, valueOf, str5, a7, str4);
                }
                List list = bluedEntity.data;
                Intrinsics.c(list, "parseData.data");
                CollectionsKt.d(list);
                SplashEntity splashEntity2 = (SplashEntity) bluedEntity.data.get(0);
                SplashEntity.ShowEntity showEntity = splashEntity2.today;
                SplashExtraEntity splashExtraEntity = (SplashExtraEntity) bluedEntity.extra;
                String str6 = splashExtraEntity.IMGURL;
                if (showEntity != null) {
                    splashEntity2.today.splashResultList = bluedEntity.data;
                    if ((splashExtraEntity == null ? null : splashExtraEntity.splash_config) != null) {
                        showEntity.interval = splashExtraEntity.splash_config.interval;
                        showEntity.timeout = splashExtraEntity.splash_config.timeout;
                        showEntity.security = splashExtraEntity.splash_config.security;
                        BluedPreferences.a(splashExtraEntity.splash_config.interval);
                    }
                    showEntity.third_id = splashEntity2.third_id;
                    showEntity.ads_id = splashEntity2.id;
                    showEntity.download_type = splashEntity2.download_type;
                    a5 = WelcomeFragment.this.a(str6, showEntity);
                    showEntity.ads_pics = a5;
                }
                if (showEntity.splashResultList != null) {
                    for (SplashEntity splashEntity3 : showEntity.splashResultList) {
                        splashEntity3.today.third_id = splashEntity3.third_id;
                        splashEntity3.today.position_code = splashEntity3.position_code;
                        splashEntity3.today.ads_id = splashEntity3.id;
                        splashEntity3.today.download_type = splashEntity3.download_type;
                        splashEntity3.today.material_type = splashEntity3.material_type;
                        if (splashEntity3.extra_json != null) {
                            if (splashEntity3.extra_json.splash != null) {
                                splashEntity3.today.hot_area_limit_type = splashEntity3.extra_json.splash.hot_area_limit_type;
                                splashEntity3.today.request_time_out = splashEntity3.extra_json.splash.request_time_out;
                                splashEntity3.today.show_time_limit = splashEntity3.extra_json.splash.show_time_limit;
                                splashEntity3.today.transparency = splashEntity3.extra_json.splash.transparency;
                                splashEntity3.today.hot_dynamic = splashEntity3.extra_json.splash.hot_dynamic;
                                splashEntity3.today.text_click_button = splashEntity3.extra_json.splash.text_click_button;
                                splashEntity3.today.text_wipe_up = splashEntity3.extra_json.splash.text_wipe_up;
                                splashEntity3.today.text_shake_it = splashEntity3.extra_json.splash.text_shake_it;
                                if (splashEntity3.extra_json.splash.is_accurate == 2) {
                                    splashEntity3.today.ads_pics = splashEntity3.today.image;
                                } else {
                                    SplashEntity.ShowEntity showEntity2 = splashEntity3.today;
                                    WelcomeFragment welcomeFragment2 = WelcomeFragment.this;
                                    SplashEntity.ShowEntity showEntity3 = splashEntity3.today;
                                    Intrinsics.c(showEntity3, "splashEntity.today");
                                    a4 = welcomeFragment2.a(str6, showEntity3);
                                    showEntity2.ads_pics = a4;
                                }
                            }
                            if (splashEntity3.extra_json.sensitive != null) {
                                splashEntity3.today.operating_time = splashEntity3.extra_json.sensitive.operating_time;
                                splashEntity3.today.turn_angle = splashEntity3.extra_json.sensitive.turn_angle;
                                splashEntity3.today.speed = splashEntity3.extra_json.sensitive.speed;
                            }
                        }
                        if ((splashExtraEntity == null ? null : splashExtraEntity.splash_config) != null) {
                            splashEntity3.today.interval = splashExtraEntity.splash_config.interval;
                            splashEntity3.today.timeout = splashExtraEntity.splash_config.timeout;
                            splashEntity3.today.security = splashExtraEntity.splash_config.security;
                        }
                        splashEntity3.today.request_id = bluedEntity.request_id;
                    }
                }
                BluedPreferences.D(splashExtraEntity.ID);
                SplashAdListener splashAdListener2 = this.b;
                Intrinsics.c(splashEntity2, "splashResult");
                splashAdListener2.a(splashEntity2);
            }
        }, this.f, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(SplashEntity.ShowEntity showEntity) {
        if (FlexDebugSevConfig.a().b().android_forbidden_splash_ad != 0) {
            f20927a.b(getContext(), this.f20928c);
            return;
        }
        a("跳转开机图展示页");
        SerialSplashFragment.a((Fragment) this, showEntity, 105);
    }

    @JvmStatic
    public static final void b(Context context, boolean z) {
        f20927a.b(context, z);
    }

    public final void a(String str) {
        Intrinsics.e(str, "log");
        Logger.a("drb", Intrinsics.a("「开机图请求页」", str));
    }

    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        a(Intrinsics.a("返回开机图请求页 onActivityResult openHome:", Boolean.valueOf(this.f20928c)));
        f20927a.b(getContext(), this.f20928c);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BluedPreferences.I(false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(layoutInflater, "inflater");
        a("页面初始化 onCreateView");
        View inflate = layoutInflater.inflate(R.layout.fragment_welcome_new, (ViewGroup) null);
        this.e = FragmentWelcomeNewBinding.a(inflate);
        a();
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        b = false;
        a("开机图请求页销毁");
    }
}
