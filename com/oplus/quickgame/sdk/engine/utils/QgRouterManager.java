package com.oplus.quickgame.sdk.engine.utils;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.google.common.net.HttpHeaders;
import com.oplus.quickgame.sdk.QuickGame;
import com.oplus.quickgame.sdk.engine.callback.Callback;
import com.oplus.quickgame.sdk.engine.utils.d;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/QgRouterManager.class */
public class QgRouterManager {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f24404a = false;
    private static String b = "SP_GameEngineConfig";

    /* renamed from: c  reason: collision with root package name */
    private static String f24405c = "NEW_ENGINE_CONFIG_NATVIE_CACHE_KEY";
    private static String d = "NEW_ENGINE_CONFIG_NATVIE_CACHE_SAVE_DATE";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/QgRouterManager$a.class */
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f24406a;

        a(Context context) {
            this.f24406a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            QgRouterManager.e(this.f24406a);
        }
    }

    private static void a(Context context, String str) {
        context.getSharedPreferences(b, 0).edit().putString(f24405c, str).putLong(d, System.currentTimeMillis()).apply();
    }

    private static boolean a(String str, long j) {
        JSONObject jSONObject;
        String str2;
        boolean z;
        String str3;
        boolean z2 = true;
        try {
            jSONObject = new JSONObject(new JSONObject(str).getString("data"));
            try {
                str2 = jSONObject.getString("xgame_open_max_interval");
                z = true;
            } catch (JSONException e) {
                str2 = "0";
                z = false;
                if (!z) {
                }
                str3 = "快游戏引擎配置检测失败：不符合json格式";
                i.c("QuickGame", str3);
                z2 = false;
                return z2;
            }
        } catch (JSONException e2) {
            jSONObject = null;
        }
        if (!z && jSONObject != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!(currentTimeMillis > j && currentTimeMillis - j <= (Long.parseLong(str2) * 60) * 1000)) {
                str3 = "快游戏引擎配置检测失败：不符合最大有效时间：" + str2 + "min，return 空";
            }
            return z2;
        }
        str3 = "快游戏引擎配置检测失败：不符合json格式";
        i.c("QuickGame", str3);
        z2 = false;
        return z2;
    }

    private static String b(Context context) {
        return context.getSharedPreferences(b, 0).getString(f24405c, "");
    }

    private static long c(Context context) {
        return context.getSharedPreferences(b, 0).getLong(d, 0L);
    }

    public static boolean configDataCache(String str) {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).getString("data"));
            String string = jSONObject.getString("xgame_open_imei_range_2");
            String string2 = jSONObject.getString("xgame_open_phone_black_list");
            String string3 = jSONObject.getString("xgame_open_android_version_black_list");
            String string4 = jSONObject.getString("xgame_open_max_interval");
            d.a("xgame_open_imei_range_2", string);
            d.a("xgame_open_phone_black_list", string2);
            d.a("xgame_open_android_version_black_list", string3);
            d.a("xgame_open_max_interval", string4);
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static QuickGame.Req createReq(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, Callback callback) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "context =null 或者 url=空";
        } else if (!QuickGame.isUriSupported(str)) {
            str2 = "传入的url不支持快游戏引擎启动；url" + str;
        } else if (!QuickGame.isEngineInstalled(context)) {
            str2 = "快游戏引擎未安装，不支持引擎启动；";
        } else if (!QuickGame.isUseEngineConfig(context)) {
            str2 = "游戏引擎配置检索失败，不支持引擎启动；";
        } else if (!QuickGame.isUseEngine(context)) {
            str2 = "快游戏引擎配置不持支本次引擎启动；请检索日志QgRouterManager";
        } else if (map != null) {
            QuickGame.Builder createBuilder = QuickGame.createBuilder(map.get(HttpHeaders.ReferrerPolicyValues.ORIGIN), map.get("secret"));
            createBuilder.setRequestUrl(str);
            createBuilder.setCallback(callback);
            if ("1".equals(map2.get(OapsKey.KEY_SIGN_TYPE))) {
                createBuilder.signAsPlatform();
            }
            j.a(map, 0, createBuilder);
            j.a(map2, 1, createBuilder);
            j.a(map4, 2, createBuilder);
            j.a(map3, 3, createBuilder);
            return createBuilder.build();
        } else {
            str2 = "deepLinkParams = null";
        }
        i.c("QuickGame", str2);
        return null;
    }

    private static boolean d(Context context) {
        String str;
        if (!n.g(context)) {
            str = "open : new engine is not installed";
        } else if (d.a(d.a.OPEN, context)) {
            i.a("QgRouterManager", "open : is in imei range");
            if (d.a(d.a.OPEN)) {
                str = "open : is in androidver black list";
            } else {
                i.a("QgRouterManager", "open : is not in androidver black list");
                if (!d.b(d.a.OPEN)) {
                    i.a("QgRouterManager", "open : is not in phone black list");
                    i.a("QgRouterManager", "isUseNewEngine");
                    return true;
                }
                str = "open : is in phone black list";
            }
        } else {
            str = "open : is not in imei range";
        }
        i.a("QgRouterManager", str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Context context) {
        String str;
        f24404a = true;
        com.oplus.quickgame.sdk.engine.b.c a2 = new com.oplus.quickgame.sdk.engine.b.a().a(com.oplus.quickgame.sdk.engine.b.b.d().b(m.a()).a(MonitorConstants.CONNECT_TYPE_GET).a("Content-Type", "application/json;charset=UTF-8").a(HttpHeaders.ACCEPT, "application/json").a());
        if (a2 != null) {
            String a3 = a2.a();
            i.c("QuickGame", "快游戏下载引擎配置-> 成功，配置json：" + a3);
            if (configDataCache(a3)) {
                a(context, a3);
                f24404a = false;
            }
            a(context, "");
            str = "配置数据不符合json格式";
        } else {
            str = "快游戏下载引擎配置失败";
        }
        i.c("QuickGame", str);
        f24404a = false;
    }

    public static boolean isUseEngine(Context context) {
        return d(context);
    }

    public static boolean isUseXGameManageGameCache(Context context) {
        String str;
        if (!QuickGame.isEngineInstalled(context)) {
            str = "快游戏引擎未安装，不支持引擎启动；";
        } else if (!QuickGame.isUseEngineConfig(context)) {
            str = "游戏引擎配置检索失败，不支持引擎启动；";
        } else if (QuickGame.isUseEngine(context)) {
            return true;
        } else {
            str = "快游戏引擎配置不持支本次引擎启动；请检索日志QgRouterManager";
        }
        i.c("XGameCleanProvider", str);
        return false;
    }

    public static String requestEngineConfigIfNeed(Context context) {
        String b2 = b(context);
        i.c("QuickGame", "从缓存中获取 快游戏引擎配置：" + b2);
        long c2 = c(context);
        if (!TextUtils.isEmpty(b2) && a(b2, c2)) {
            i.c("QuickGame", "缓存未失效");
            return b2;
        } else if (f24404a) {
            return "";
        } else {
            if (l.a()) {
                l.a(new a(context));
                return "";
            }
            e(context);
            return "";
        }
    }
}
