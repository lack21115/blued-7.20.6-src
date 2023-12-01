package com.bytedance.applog;

import android.accounts.Account;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.applog.alink.IALinkListener;
import com.bytedance.applog.event.IEventHandler;
import com.bytedance.applog.network.INetworkClient;
import com.bytedance.applog.profile.UserProfileCallback;
import com.bytedance.bdtracker.c;
import com.bytedance.bdtracker.d;
import com.bytedance.bdtracker.j1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/AppLog.class */
public final class AppLog {

    /* renamed from: a  reason: collision with root package name */
    public static final IAppLogInstance f21169a = newInstance();
    public static volatile boolean b = false;

    public static void activateALink(Uri uri) {
        f21169a.activateALink(uri);
    }

    public static void addDataObserver(IDataObserver iDataObserver) {
        f21169a.addDataObserver(iDataObserver);
    }

    public static void addEventObserver(IEventObserver iEventObserver) {
        f21169a.addEventObserver(iEventObserver);
    }

    public static String addNetCommonParams(Context context, String str, boolean z, Level level) {
        return f21169a.addNetCommonParams(context, str, z, level);
    }

    public static void addSessionHook(ISessionObserver iSessionObserver) {
        f21169a.addSessionHook(iSessionObserver);
    }

    public static void flush() {
        f21169a.flush();
    }

    public static <T> T getAbConfig(String str, T t) {
        return (T) f21169a.getAbConfig(str, t);
    }

    public static String getAbSdkVersion() {
        return f21169a.getAbSdkVersion();
    }

    public static IActiveCustomParamsCallback getActiveCustomParams() {
        return f21169a.getActiveCustomParams();
    }

    @Deprecated
    public static String getAid() {
        return f21169a.getAid();
    }

    public static JSONObject getAllAbTestConfigs() {
        return f21169a.getAllAbTestConfigs();
    }

    public static d getAppContext() {
        return f21169a.getAppContext();
    }

    public static String getAppId() {
        return f21169a.getAppId();
    }

    public static String getClientUdid() {
        return f21169a.getClientUdid();
    }

    public static Context getContext() {
        return f21169a.getContext();
    }

    public static String getDid() {
        return f21169a.getDid();
    }

    public static boolean getEncryptAndCompress() {
        return f21169a.getEncryptAndCompress();
    }

    public static JSONObject getHeader() {
        return f21169a.getHeader();
    }

    public static IHeaderCustomTimelyCallback getHeaderCustomCallback() {
        return f21169a.getHeaderCustomCallback();
    }

    public static <T> T getHeaderValue(String str, T t, Class<T> cls) {
        return (T) f21169a.getHeaderValue(str, t, cls);
    }

    public static String getIid() {
        return f21169a.getIid();
    }

    public static InitConfig getInitConfig() {
        return f21169a.getInitConfig();
    }

    public static IAppLogInstance getInstance() {
        return f21169a;
    }

    public static INetworkClient getNetClient() {
        return f21169a.getNetClient();
    }

    public static String getOpenUdid() {
        return f21169a.getOpenUdid();
    }

    public static Map<String, String> getRequestHeader() {
        return f21169a.getRequestHeader();
    }

    public static String getSdkVersion() {
        return f21169a.getSdkVersion();
    }

    public static String getSessionId() {
        return f21169a.getSessionId();
    }

    public static String getSsid() {
        return f21169a.getSsid();
    }

    public static void getSsidGroup(Map<String, String> map) {
        f21169a.getSsidGroup(map);
    }

    public static String getUdid() {
        return f21169a.getUdid();
    }

    public static String getUserID() {
        return f21169a.getUserID();
    }

    public static String getUserUniqueID() {
        return f21169a.getUserUniqueID();
    }

    public static JSONObject getViewProperties(View view) {
        return f21169a.getViewProperties(view);
    }

    public static boolean hasStarted() {
        return f21169a.hasStarted();
    }

    public static void ignoreAutoTrackClick(View view) {
        f21169a.ignoreAutoTrackClick(view);
    }

    public static void ignoreAutoTrackClickByViewType(Class<?>... clsArr) {
        f21169a.ignoreAutoTrackClickByViewType(clsArr);
    }

    public static void ignoreAutoTrackPage(Class<?>... clsArr) {
        f21169a.ignoreAutoTrackPage(clsArr);
    }

    public static void init(Context context, InitConfig initConfig) {
        synchronized (AppLog.class) {
            try {
                if (j1.a(b, "Default AppLog is initialized, please create another instance by `AppLog.newInstance()`.")) {
                    return;
                }
                b = true;
                if (TextUtils.isEmpty(initConfig.getSpName())) {
                    initConfig.setSpName("applog_stats");
                }
                f21169a.init(context, initConfig);
            } finally {
            }
        }
    }

    public static void init(Context context, InitConfig initConfig, Activity activity) {
        synchronized (AppLog.class) {
            try {
                if (j1.a(b, "Default AppLog is initialized, please create another instance by `new AppLogInstance()`.")) {
                    return;
                }
                b = true;
                if (TextUtils.isEmpty(initConfig.getSpName())) {
                    initConfig.setSpName("applog_stats");
                }
                f21169a.init(context, initConfig, activity);
            } finally {
            }
        }
    }

    public static boolean isAutoTrackClickIgnored(View view) {
        return f21169a.isAutoTrackClickIgnored(view);
    }

    public static boolean isAutoTrackPageIgnored(Class<?> cls) {
        return f21169a.isAutoTrackPageIgnored(cls);
    }

    public static boolean isH5BridgeEnable() {
        return f21169a.isH5BridgeEnable();
    }

    public static boolean isH5CollectEnable() {
        return f21169a.isH5CollectEnable();
    }

    public static boolean isNewUser() {
        return f21169a.isNewUser();
    }

    public static boolean isPrivacyMode() {
        return f21169a.isPrivacyMode();
    }

    public static boolean manualActivate() {
        return f21169a.manualActivate();
    }

    public static IAppLogInstance newInstance() {
        return new c();
    }

    public static void onActivityPause() {
        f21169a.onActivityPause();
    }

    public static void onActivityResumed(Activity activity, int i) {
        f21169a.onActivityResumed(activity, i);
    }

    @Deprecated
    public static void onEvent(String str) {
        f21169a.onEvent(str);
    }

    @Deprecated
    public static void onEvent(String str, String str2) {
        f21169a.onEvent(str, str2);
    }

    @Deprecated
    public static void onEvent(String str, String str2, String str3, long j, long j2) {
        f21169a.onEvent(str, str2, str3, j, j2);
    }

    public static void onEvent(String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        f21169a.onEvent(str, str2, str3, j, j2, jSONObject);
    }

    public static void onEventV3(String str) {
        f21169a.onEventV3(str);
    }

    public static void onEventV3(String str, Bundle bundle) {
        f21169a.onEventV3(str, bundle);
    }

    public static void onEventV3(String str, Bundle bundle, int i) {
        f21169a.onEventV3(str, bundle, i);
    }

    public static void onEventV3(String str, JSONObject jSONObject) {
        f21169a.onEventV3(str, jSONObject);
    }

    public static void onEventV3(String str, JSONObject jSONObject, int i) {
        f21169a.onEventV3(str, jSONObject, i);
    }

    @Deprecated
    public static void onInternalEventV3(String str, Bundle bundle, String str2, String str3, String str4) {
        f21169a.onInternalEventV3(str, bundle, str2, str3, str4);
    }

    @Deprecated
    public static void onInternalEventV3(String str, JSONObject jSONObject, String str2, String str3, String str4) {
        f21169a.onInternalEventV3(str, jSONObject, str2, str3, str4);
    }

    public static void onMiscEvent(String str, JSONObject jSONObject) {
        f21169a.onMiscEvent(str, jSONObject);
    }

    public static void onPause(Context context) {
        f21169a.onPause(context);
    }

    public static void onResume(Context context) {
        f21169a.onResume(context);
    }

    public static void profileAppend(JSONObject jSONObject) {
        f21169a.profileAppend(jSONObject);
    }

    public static void profileIncrement(JSONObject jSONObject) {
        f21169a.profileIncrement(jSONObject);
    }

    public static void profileSet(JSONObject jSONObject) {
        f21169a.profileSet(jSONObject);
    }

    public static void profileSetOnce(JSONObject jSONObject) {
        f21169a.profileSetOnce(jSONObject);
    }

    public static void profileUnset(String str) {
        f21169a.profileUnset(str);
    }

    public static void pullAbTestConfigs() {
        f21169a.pullAbTestConfigs();
    }

    public static void putCommonParams(Context context, Map<String, String> map, boolean z, Level level) {
        f21169a.putCommonParams(context, map, z, level);
    }

    public static void registerHeaderCustomCallback(IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback) {
        f21169a.registerHeaderCustomCallback(iHeaderCustomTimelyCallback);
    }

    public static void removeAllDataObserver() {
        f21169a.removeAllDataObserver();
    }

    public static void removeDataObserver(IDataObserver iDataObserver) {
        f21169a.removeDataObserver(iDataObserver);
    }

    public static void removeEventObserver(IEventObserver iEventObserver) {
        f21169a.removeEventObserver(iEventObserver);
    }

    public static void removeHeaderInfo(String str) {
        f21169a.removeHeaderInfo(str);
    }

    public static void removeOaidObserver(IOaidObserver iOaidObserver) {
        f21169a.removeOaidObserver(iOaidObserver);
    }

    public static void removeSessionHook(ISessionObserver iSessionObserver) {
        f21169a.removeSessionHook(iSessionObserver);
    }

    public static boolean reportPhoneDetailInfo() {
        return f21169a.reportPhoneDetailInfo();
    }

    public static void setALinkListener(IALinkListener iALinkListener) {
        f21169a.setALinkListener(iALinkListener);
    }

    public static void setAccount(Account account) {
        f21169a.setAccount(account);
    }

    public static void setActiveCustomParams(IActiveCustomParamsCallback iActiveCustomParamsCallback) {
        f21169a.setActiveCustomParams(iActiveCustomParamsCallback);
    }

    public static void setAppContext(d dVar) {
        f21169a.setAppContext(dVar);
    }

    public static void setAppLanguageAndRegion(String str, String str2) {
        f21169a.setAppLanguageAndRegion(str, str2);
    }

    public static void setAppTrack(JSONObject jSONObject) {
        f21169a.setAppTrack(jSONObject);
    }

    public static void setClipboardEnabled(boolean z) {
        f21169a.setClipboardEnabled(z);
    }

    public static void setEncryptAndCompress(boolean z) {
        f21169a.setEncryptAndCompress(z);
    }

    public static void setEventFilterByClient(List<String> list, boolean z) {
        f21169a.setEventFilterByClient(list, z);
    }

    public static void setEventHandler(IEventHandler iEventHandler) {
        f21169a.setEventHandler(iEventHandler);
    }

    public static void setExternalAbVersion(String str) {
        f21169a.setExternalAbVersion(str);
    }

    public static void setExtraParams(IExtraParams iExtraParams) {
        f21169a.setExtraParams(iExtraParams);
    }

    public static void setForbidReportPhoneDetailInfo(boolean z) {
        f21169a.setForbidReportPhoneDetailInfo(z);
    }

    public static void setGoogleAid(String str) {
        f21169a.setGoogleAid(str);
    }

    public static void setHeaderInfo(String str, Object obj) {
        f21169a.setHeaderInfo(str, obj);
    }

    public static void setHeaderInfo(HashMap<String, Object> hashMap) {
        f21169a.setHeaderInfo(hashMap);
    }

    public static void setOaidObserver(IOaidObserver iOaidObserver) {
        f21169a.setOaidObserver(iOaidObserver);
    }

    public static void setPrivacyMode(boolean z) {
        f21169a.setPrivacyMode(z);
    }

    public static void setRangersEventVerifyEnable(boolean z, String str) {
        f21169a.setRangersEventVerifyEnable(z, str);
    }

    public static void setTouchPoint(String str) {
        f21169a.setTouchPoint(str);
    }

    public static void setTracerData(JSONObject jSONObject) {
        f21169a.setTracerData(jSONObject);
    }

    public static void setUriRuntime(UriConfig uriConfig) {
        f21169a.setUriRuntime(uriConfig);
    }

    public static void setUserAgent(String str) {
        f21169a.setUserAgent(str);
    }

    public static void setUserID(long j) {
        f21169a.setUserID(j);
    }

    public static void setUserUniqueID(String str) {
        f21169a.setUserUniqueID(str);
    }

    public static void setViewId(Dialog dialog, String str) {
        f21169a.setViewId(dialog, str);
    }

    public static void setViewId(View view, String str) {
        f21169a.setViewId(view, str);
    }

    public static void setViewId(Object obj, String str) {
        f21169a.setViewId(obj, str);
    }

    public static void setViewProperties(View view, JSONObject jSONObject) {
        f21169a.setViewProperties(view, jSONObject);
    }

    public static void start() {
        f21169a.start();
    }

    public static void startSimulator(String str) {
        f21169a.startSimulator(str);
    }

    public static void trackClick(View view) {
        f21169a.trackClick(view);
    }

    public static void trackClick(View view, JSONObject jSONObject) {
        f21169a.trackClick(view, jSONObject);
    }

    public static void trackPage(Activity activity) {
        f21169a.trackPage(activity);
    }

    public static void trackPage(Activity activity, JSONObject jSONObject) {
        f21169a.trackPage(activity, jSONObject);
    }

    public static void trackPage(Object obj) {
        f21169a.trackPage(obj);
    }

    public static void trackPage(Object obj, JSONObject jSONObject) {
        f21169a.trackPage(obj, jSONObject);
    }

    public static void userProfileSetOnce(JSONObject jSONObject, UserProfileCallback userProfileCallback) {
        f21169a.userProfileSetOnce(jSONObject, userProfileCallback);
    }

    public static void userProfileSync(JSONObject jSONObject, UserProfileCallback userProfileCallback) {
        f21169a.userProfileSync(jSONObject, userProfileCallback);
    }
}
