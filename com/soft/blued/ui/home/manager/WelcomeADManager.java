package com.soft.blued.ui.home.manager;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.log.oldtrack.InstantLogBody;
import com.blued.das.login.LoginAndRegisterProtos;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.welcome.model.SplashEntity;
import com.soft.blued.ui.welcome.model.SplashExtraEntity;
import com.soft.blued.ui.welcome.observer.ADDownloadObserver;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

@Deprecated
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/manager/WelcomeADManager.class */
public class WelcomeADManager {
    private static final String b = WelcomeADManager.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static WelcomeADManager f31044c;
    private SplashEntity d;
    private SplashExtraEntity e;
    private String j;
    private int f = -1;
    private String g = "";
    private boolean h = false;
    private boolean i = false;

    /* renamed from: a  reason: collision with root package name */
    public SplashEntity.Sensitive f31045a = new SplashEntity.Sensitive();
    private BluedUIHttpResponse k = new BluedUIHttpResponse<BluedEntity<SplashEntity, SplashExtraEntity>>() { // from class: com.soft.blued.ui.home.manager.WelcomeADManager.1
        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onSuccess(String str) {
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            InstantLogBody instantLogBody = new InstantLogBody();
            instantLogBody.service = "AD_REQUEST_FAIL";
            Map<String, String> a2 = BluedHttpTools.a();
            a2.put("code", i + "");
            a2.put("req_id", WelcomeADManager.this.j);
            InstantLog.a(instantLogBody, a2);
            LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_REQUEST_FAIL;
            String str2 = WelcomeADManager.this.j;
            EventTrackLoginAndRegister.a(event, str2, i + "");
            return true;
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<SplashEntity, SplashExtraEntity> bluedEntity) {
            String str;
            Log.v("drb", "========开机广告请求成功");
            if (bluedEntity != null) {
                try {
                    if (bluedEntity.data != null && bluedEntity.data.size() > 0) {
                        Collections.sort(bluedEntity.data);
                        WelcomeADManager.this.d = bluedEntity.data.get(0);
                        InstantLogBody instantLogBody = new InstantLogBody();
                        instantLogBody.service = "AD_API_REQUEST_SUCCESS";
                        Map<String, String> a2 = BluedHttpTools.a();
                        a2.put("req_id", WelcomeADManager.this.j);
                        InstantLog.a(instantLogBody, a2);
                        EventTrackLoginAndRegister.b(LoginAndRegisterProtos.Event.AD_API_REQUEST_SUCCESS, WelcomeADManager.this.j);
                        Iterator<SplashEntity> it = bluedEntity.data.iterator();
                        while (true) {
                            str = "";
                            if (!it.hasNext()) {
                                break;
                            }
                            SplashEntity next = it.next();
                            if (next.today != null) {
                                Log.v("drb", "广告通用埋点_api广告请求 广告id:" + next.id + " 类型：" + next.today.adms_type + " 广告位id:" + next.position_code + " requestId：" + bluedEntity.request_id);
                                LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_API_REQUEST;
                                StringBuilder sb = new StringBuilder();
                                sb.append(next.id);
                                sb.append("");
                                String sb2 = sb.toString();
                                String str2 = next.today.adms_type;
                                EventTrackLoginAndRegister.a(event, sb2, str2, next.position_code + "", WelcomeADManager.this.j);
                            }
                        }
                        SplashEntity.ShowEntity showEntity = WelcomeADManager.this.d.today;
                        SplashEntity.ShowEntity showEntity2 = WelcomeADManager.this.d.tomorrow;
                        WelcomeADManager.this.e = bluedEntity.extra;
                        String str3 = WelcomeADManager.this.e.IMGURL;
                        BluedPreferences.D(WelcomeADManager.this.e.ID);
                        if (WelcomeADManager.this.e != null && WelcomeADManager.this.e.splash_config != null) {
                            WelcomeADManager.this.d.today.interval = WelcomeADManager.this.e.splash_config.interval;
                            WelcomeADManager.this.d.today.timeout = WelcomeADManager.this.e.splash_config.timeout;
                            WelcomeADManager.this.d.today.security = WelcomeADManager.this.e.splash_config.security;
                            BluedPreferences.a(WelcomeADManager.this.e.splash_config.interval);
                        }
                        WelcomeADManager.this.d.today.third_id = WelcomeADManager.this.d.third_id;
                        WelcomeADManager.this.d.today.ads_id = WelcomeADManager.this.d.id;
                        WelcomeADManager.this.d.today.download_type = WelcomeADManager.this.d.download_type;
                        WelcomeADManager.this.d.today.ads_pics = WelcomeADManager.this.a(str3, WelcomeADManager.this.d.today);
                        Log.v("drb", "today:" + showEntity);
                        if (showEntity != null) {
                            WelcomeADManager.this.d.today.splashResultList = bluedEntity.data;
                            if (WelcomeADManager.this.d.today.splashResultList != null) {
                                for (SplashEntity splashEntity : WelcomeADManager.this.d.today.splashResultList) {
                                    splashEntity.today.third_id = splashEntity.third_id;
                                    splashEntity.today.position_code = splashEntity.position_code;
                                    splashEntity.today.ads_id = splashEntity.id;
                                    splashEntity.today.download_type = splashEntity.download_type;
                                    splashEntity.today.material_type = splashEntity.material_type;
                                    if (splashEntity.extra_json != null) {
                                        if (splashEntity.extra_json.splash != null) {
                                            splashEntity.today.hot_area_limit_type = splashEntity.extra_json.splash.hot_area_limit_type;
                                            splashEntity.today.request_time_out = splashEntity.extra_json.splash.request_time_out;
                                            splashEntity.today.show_time_limit = splashEntity.extra_json.splash.show_time_limit;
                                            splashEntity.today.transparency = splashEntity.extra_json.splash.transparency;
                                            splashEntity.today.hot_dynamic = splashEntity.extra_json.splash.hot_dynamic;
                                            splashEntity.today.text_click_button = splashEntity.extra_json.splash.text_click_button;
                                            splashEntity.today.text_wipe_up = splashEntity.extra_json.splash.text_wipe_up;
                                            splashEntity.today.text_shake_it = splashEntity.extra_json.splash.text_shake_it;
                                            if (splashEntity.extra_json.splash.is_accurate == 2) {
                                                splashEntity.today.ads_pics = splashEntity.today.image;
                                            } else {
                                                splashEntity.today.ads_pics = WelcomeADManager.this.a(str3, splashEntity.today);
                                            }
                                        }
                                        if (splashEntity.extra_json.sensitive != null) {
                                            splashEntity.today.operating_time = splashEntity.extra_json.sensitive.operating_time;
                                            splashEntity.today.turn_angle = splashEntity.extra_json.sensitive.turn_angle;
                                            splashEntity.today.speed = splashEntity.extra_json.sensitive.speed;
                                        }
                                    }
                                    if (WelcomeADManager.this.e != null && WelcomeADManager.this.e.splash_config != null) {
                                        splashEntity.today.interval = WelcomeADManager.this.e.splash_config.interval;
                                        splashEntity.today.timeout = WelcomeADManager.this.e.splash_config.timeout;
                                        splashEntity.today.security = WelcomeADManager.this.e.splash_config.security;
                                    }
                                    splashEntity.today.request_id = bluedEntity.request_id;
                                }
                                for (SplashEntity splashEntity2 : WelcomeADManager.this.d.today.splashResultList) {
                                    Log.v("drb", "splashEntity:" + splashEntity2.id + " -- " + splashEntity2.ranking + " -- " + splashEntity2.today.image + " -- " + splashEntity2.today.adms_type + " -- material_type:" + splashEntity2.today.material_type + " -- video_width:" + splashEntity2.today.material_width + " -- video_height:" + splashEntity2.today.material_height);
                                }
                            }
                            WelcomeADManager.this.f = 1;
                        } else {
                            WelcomeADManager.this.f = 0;
                        }
                        ADDownloadObserver.a().b();
                        String str4 = str;
                        if (showEntity2 != null) {
                            str4 = str;
                            if (!StringUtils.d(showEntity2.image)) {
                                StringBuilder sb3 = new StringBuilder();
                                if (!StringUtils.d(str3)) {
                                    str = str3;
                                }
                                sb3.append(str);
                                sb3.append(showEntity2.image);
                                str4 = sb3.toString();
                            }
                        }
                        if (StringUtils.d(str4)) {
                            return;
                        }
                        ImageFileLoader.a((IRequestHost) null).a(str4).a();
                        return;
                    }
                } catch (Exception e) {
                    WelcomeADManager.this.f = 0;
                    Log.v("drb", e.toString());
                    ADDownloadObserver.a().b();
                    InstantLogBody instantLogBody2 = new InstantLogBody();
                    instantLogBody2.service = "AD_REQUEST_FAIL";
                    Map<String, String> a3 = BluedHttpTools.a();
                    a3.put("code", "接口请求成功，客户端异常：" + e);
                    a3.put("req_id", WelcomeADManager.this.j);
                    InstantLog.a(instantLogBody2, a3);
                    LoginAndRegisterProtos.Event event2 = LoginAndRegisterProtos.Event.AD_REQUEST_FAIL;
                    String str5 = WelcomeADManager.this.j;
                    EventTrackLoginAndRegister.a(event2, str5, "接口请求成功，客户端异常：" + e);
                    return;
                }
            }
            WelcomeADManager.this.f = 0;
            ADDownloadObserver.a().b();
            InstantLogBody instantLogBody3 = new InstantLogBody();
            instantLogBody3.service = "AD_REQUEST_FAIL";
            Map<String, String> a4 = BluedHttpTools.a();
            a4.put("code", "接口请求成功，但是未返回数据");
            a4.put("req_id", WelcomeADManager.this.j);
            InstantLog.a(instantLogBody3, a4);
            EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.AD_REQUEST_FAIL, WelcomeADManager.this.j, "接口请求成功，但是未返回数据");
        }
    };

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/manager/WelcomeADManager$HAS_AD_STATUS.class */
    public interface HAS_AD_STATUS {
    }

    private WelcomeADManager() {
    }

    public static WelcomeADManager a() {
        if (f31044c == null) {
            f31044c = new WelcomeADManager();
        }
        return f31044c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, SplashEntity.ShowEntity showEntity) {
        if (!TextUtils.equals(showEntity.adms_type, "16") && !TextUtils.equals(showEntity.adms_type, "17") && !TextUtils.equals(showEntity.adms_type, "18") && !TextUtils.equals(showEntity.adms_type, "19") && !TextUtils.equals(showEntity.adms_type, BaseWrapper.ENTER_ID_SYSTEM_HELPER) && !TextUtils.equals(showEntity.adms_type, "21") && !TextUtils.equals(showEntity.adms_type, "22") && !TextUtils.equals(showEntity.adms_type, "23") && !TextUtils.equals(showEntity.adms_type, "25") && !TextUtils.equals(showEntity.adms_type, "26") && !TextUtils.isEmpty(str)) {
            return str + showEntity.image;
        }
        return showEntity.image;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public String b() {
        return this.j;
    }

    public boolean c() {
        return this.i;
    }

    public void d() {
        this.d = null;
        this.e = null;
        this.f = -1;
        this.g = "";
        this.h = false;
    }

    public SplashEntity e() {
        SplashEntity splashEntity = this.d;
        SplashEntity splashEntity2 = splashEntity;
        if (splashEntity == null) {
            splashEntity2 = new SplashEntity();
        }
        return splashEntity2;
    }

    public SplashExtraEntity f() {
        return this.e;
    }

    public String g() {
        Log.v("drb", "getTodayADPicUrl:" + this.g);
        return this.g;
    }

    public int h() {
        return this.f;
    }

    public boolean i() {
        return true;
    }
}
