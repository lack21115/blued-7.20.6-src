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
import androidx.lifecycle.LifecycleOwnerKt;
import com.blued.android.config.FlexDebugSevConfig;
import com.blued.android.core.AppInfo;
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
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/WelcomeFragment.class */
public final class WelcomeFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f34618a = new Companion(null);
    public static boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f34619c = true;
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
        public final boolean a(String type) {
            Intrinsics.e(type, "type");
            int hashCode = type.hashCode();
            if (hashCode == 50) {
                return type.equals("2");
            } else if (hashCode == 57) {
                return type.equals("9");
            } else if (hashCode == 1603) {
                return type.equals("25");
            } else if (hashCode == 1604) {
                return type.equals("26");
            } else {
                switch (hashCode) {
                    case 1573:
                        return type.equals("16");
                    case 1574:
                        return type.equals("17");
                    case 1575:
                        return type.equals("18");
                    case 1576:
                        return type.equals("19");
                    default:
                        switch (hashCode) {
                            case 1598:
                                return type.equals(BaseWrapper.ENTER_ID_SYSTEM_HELPER);
                            case 1599:
                                return type.equals("21");
                            case 1600:
                                return type.equals("22");
                            case 1601:
                                return type.equals("23");
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
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.a(continuation), 1);
        cancellableContinuationImpl.e();
        BuildersKt__Builders_commonKt.a(LifecycleOwnerKt.getLifecycleScope(this), null, null, new WelcomeFragment$loadAd$2$1(this, cancellableContinuationImpl, null), 3, null);
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
        if (str2 != null && f34618a.a(str2)) {
            z = true;
        }
        if (!z && !TextUtils.isEmpty(str)) {
            return Intrinsics.a(str, (Object) showEntity.image);
        }
        return showEntity.image;
    }

    private final void a() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.d = arguments.getBoolean("arg_show_ad");
            boolean z = arguments.getBoolean("arg_open_home", this.f34619c);
            this.f34619c = z;
            a(Intrinsics.a("initData openHome:", (Object) Boolean.valueOf(z)));
        }
        BuildersKt__Builders_commonKt.a(LifecycleOwnerKt.getLifecycleScope(this), null, null, new WelcomeFragment$initData$1(this, null), 3, null);
    }

    @JvmStatic
    public static final void a(Context context, boolean z) {
        f34618a.a(context, z);
    }

    @JvmStatic
    public static final void a(Context context, boolean z, boolean z2) {
        f34618a.a(context, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final SplashAdListener splashAdListener) {
        String a2 = ADUtils.a();
        this.f = a2;
        a(Intrinsics.a("开始请求开机图广告（请求自己服务端）requestId Md5:", (Object) a2));
        InstantLogBody instantLogBody = new InstantLogBody();
        instantLogBody.service = "AD_REQUEST";
        Map<String, String> params = BluedHttpTools.a();
        Intrinsics.c(params, "params");
        params.put("req_id", this.f);
        InstantLog.a(instantLogBody, params);
        EventTrackLoginAndRegister.b(LoginAndRegisterProtos.Event.AD_REQUEST, this.f);
        Context d = AppInfo.d();
        String aT = BluedPreferences.aT();
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        LoginRegisterHttpUtils.a(d, aT, new BluedUIHttpResponse<BluedEntity<SplashEntity, SplashExtraEntity>>(fragmentActive) { // from class: com.soft.blued.ui.welcome.WelcomeFragment$loadSplashAd$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onSuccess(String str) {
                WelcomeFragment.this.a(String.valueOf(str));
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                String str2;
                String str3;
                LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_REQUEST_FAIL;
                str2 = WelcomeFragment.this.f;
                EventTrackLoginAndRegister.a(event, str2, String.valueOf(i));
                InstantLogBody instantLogBody2 = new InstantLogBody();
                instantLogBody2.service = "AD_REQUEST_FAIL";
                Map<String, String> params2 = BluedHttpTools.a();
                Intrinsics.c(params2, "params");
                params2.put("code", i + "");
                str3 = WelcomeFragment.this.f;
                params2.put("req_id", str3);
                InstantLog.a(instantLogBody2, params2);
                WelcomeFragment welcomeFragment = WelcomeFragment.this;
                welcomeFragment.a("开机图接口请求失败errorCode：" + i + " errorMessage:" + ((Object) str));
                splashAdListener.a(i, String.valueOf(str));
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<SplashEntity, SplashExtraEntity> bluedEntity) {
                String str;
                String str2;
                String str3;
                String a3;
                String a4;
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
                Map<String, String> map = BluedHttpTools.a();
                Intrinsics.c(map, "map");
                str3 = WelcomeFragment.this.f;
                map.put("req_id", str3);
                InstantLog.a(instantLogBody2, map);
                for (SplashEntity splashEntity : bluedEntity.data) {
                    WelcomeFragment welcomeFragment = WelcomeFragment.this;
                    welcomeFragment.a("广告通用埋点_api广告请求 广告id:" + splashEntity.id + " 类型：" + ((Object) splashEntity.today.adms_type) + " 广告位id:" + ((Object) splashEntity.position_code));
                    LoginAndRegisterProtos.Event event3 = LoginAndRegisterProtos.Event.AD_API_REQUEST;
                    String valueOf = String.valueOf(splashEntity.id);
                    String str5 = splashEntity.today.adms_type;
                    String a5 = Intrinsics.a(splashEntity.position_code, (Object) "");
                    str4 = WelcomeFragment.this.f;
                    EventTrackLoginAndRegister.a(event3, valueOf, str5, a5, str4);
                }
                List<SplashEntity> list = bluedEntity.data;
                Intrinsics.c(list, "parseData.data");
                CollectionsKt.d((List) list);
                SplashEntity splashResult = bluedEntity.data.get(0);
                SplashEntity.ShowEntity showEntity = splashResult.today;
                SplashExtraEntity splashExtraEntity = bluedEntity.extra;
                String str6 = splashExtraEntity.IMGURL;
                if (showEntity != null) {
                    splashResult.today.splashResultList = bluedEntity.data;
                    if ((splashExtraEntity == null ? null : splashExtraEntity.splash_config) != null) {
                        showEntity.interval = splashExtraEntity.splash_config.interval;
                        showEntity.timeout = splashExtraEntity.splash_config.timeout;
                        showEntity.security = splashExtraEntity.splash_config.security;
                        BluedPreferences.a(splashExtraEntity.splash_config.interval);
                    }
                    showEntity.third_id = splashResult.third_id;
                    showEntity.ads_id = splashResult.id;
                    showEntity.download_type = splashResult.download_type;
                    a4 = WelcomeFragment.this.a(str6, showEntity);
                    showEntity.ads_pics = a4;
                }
                if (showEntity.splashResultList != null) {
                    for (SplashEntity splashEntity2 : showEntity.splashResultList) {
                        splashEntity2.today.third_id = splashEntity2.third_id;
                        splashEntity2.today.position_code = splashEntity2.position_code;
                        splashEntity2.today.ads_id = splashEntity2.id;
                        splashEntity2.today.download_type = splashEntity2.download_type;
                        splashEntity2.today.material_type = splashEntity2.material_type;
                        if (splashEntity2.extra_json != null) {
                            if (splashEntity2.extra_json.splash != null) {
                                splashEntity2.today.hot_area_limit_type = splashEntity2.extra_json.splash.hot_area_limit_type;
                                splashEntity2.today.request_time_out = splashEntity2.extra_json.splash.request_time_out;
                                splashEntity2.today.show_time_limit = splashEntity2.extra_json.splash.show_time_limit;
                                splashEntity2.today.transparency = splashEntity2.extra_json.splash.transparency;
                                splashEntity2.today.hot_dynamic = splashEntity2.extra_json.splash.hot_dynamic;
                                splashEntity2.today.text_click_button = splashEntity2.extra_json.splash.text_click_button;
                                splashEntity2.today.text_wipe_up = splashEntity2.extra_json.splash.text_wipe_up;
                                splashEntity2.today.text_shake_it = splashEntity2.extra_json.splash.text_shake_it;
                                if (splashEntity2.extra_json.splash.is_accurate == 2) {
                                    splashEntity2.today.ads_pics = splashEntity2.today.image;
                                } else {
                                    SplashEntity.ShowEntity showEntity2 = splashEntity2.today;
                                    WelcomeFragment welcomeFragment2 = WelcomeFragment.this;
                                    SplashEntity.ShowEntity showEntity3 = splashEntity2.today;
                                    Intrinsics.c(showEntity3, "splashEntity.today");
                                    a3 = welcomeFragment2.a(str6, showEntity3);
                                    showEntity2.ads_pics = a3;
                                }
                            }
                            if (splashEntity2.extra_json.sensitive != null) {
                                splashEntity2.today.operating_time = splashEntity2.extra_json.sensitive.operating_time;
                                splashEntity2.today.turn_angle = splashEntity2.extra_json.sensitive.turn_angle;
                                splashEntity2.today.speed = splashEntity2.extra_json.sensitive.speed;
                            }
                        }
                        if ((splashExtraEntity == null ? null : splashExtraEntity.splash_config) != null) {
                            splashEntity2.today.interval = splashExtraEntity.splash_config.interval;
                            splashEntity2.today.timeout = splashExtraEntity.splash_config.timeout;
                            splashEntity2.today.security = splashExtraEntity.splash_config.security;
                        }
                        splashEntity2.today.request_id = bluedEntity.request_id;
                    }
                }
                BluedPreferences.D(splashExtraEntity.ID);
                SplashAdListener splashAdListener2 = splashAdListener;
                Intrinsics.c(splashResult, "splashResult");
                splashAdListener2.a(splashResult);
            }
        }, this.f, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(SplashEntity.ShowEntity showEntity) {
        if (FlexDebugSevConfig.a().b().android_forbidden_splash_ad != 0) {
            f34618a.b(getContext(), this.f34619c);
            return;
        }
        a("跳转开机图展示页");
        SerialSplashFragment.a(this, showEntity, 105);
    }

    @JvmStatic
    public static final void b(Context context, boolean z) {
        f34618a.b(context, z);
    }

    public final void a(String log) {
        Intrinsics.e(log, "log");
        Logger.a("drb", Intrinsics.a("「开机图请求页」", (Object) log));
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        a(Intrinsics.a("返回开机图请求页 onActivityResult openHome:", (Object) Boolean.valueOf(this.f34619c)));
        f34618a.b(getContext(), this.f34619c);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BluedPreferences.I(false);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        a("页面初始化 onCreateView");
        View inflate = inflater.inflate(R.layout.fragment_welcome_new, (ViewGroup) null);
        this.e = FragmentWelcomeNewBinding.a(inflate);
        a();
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        b = false;
        a("开机图请求页销毁");
    }
}
