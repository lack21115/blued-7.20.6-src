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
    public static final IAppLogInstance f7563a = newInstance();
    public static volatile boolean b = false;

    public static void activateALink(Uri uri) {
        f7563a.activateALink(uri);
    }

    public static void addDataObserver(IDataObserver iDataObserver) {
        f7563a.addDataObserver(iDataObserver);
    }

    public static void addEventObserver(IEventObserver iEventObserver) {
        f7563a.addEventObserver(iEventObserver);
    }

    public static String addNetCommonParams(Context context, String str, boolean z, Level level) {
        return f7563a.addNetCommonParams(context, str, z, level);
    }

    public static void addSessionHook(ISessionObserver iSessionObserver) {
        f7563a.addSessionHook(iSessionObserver);
    }

    public static void flush() {
        f7563a.flush();
    }

    public static <T> T getAbConfig(String str, T t) {
        return (T) f7563a.getAbConfig(str, t);
    }

    public static String getAbSdkVersion() {
        return f7563a.getAbSdkVersion();
    }

    public static IActiveCustomParamsCallback getActiveCustomParams() {
        return f7563a.getActiveCustomParams();
    }

    @Deprecated
    public static String getAid() {
        return f7563a.getAid();
    }

    public static JSONObject getAllAbTestConfigs() {
        return f7563a.getAllAbTestConfigs();
    }

    public static d getAppContext() {
        return f7563a.getAppContext();
    }

    public static String getAppId() {
        return f7563a.getAppId();
    }

    public static String getClientUdid() {
        return f7563a.getClientUdid();
    }

    public static Context getContext() {
        return f7563a.getContext();
    }

    public static String getDid() {
        return f7563a.getDid();
    }

    public static boolean getEncryptAndCompress() {
        return f7563a.getEncryptAndCompress();
    }

    public static JSONObject getHeader() {
        return f7563a.getHeader();
    }

    public static IHeaderCustomTimelyCallback getHeaderCustomCallback() {
        return f7563a.getHeaderCustomCallback();
    }

    public static <T> T getHeaderValue(String str, T t, Class<T> cls) {
        return (T) f7563a.getHeaderValue(str, t, cls);
    }

    public static String getIid() {
        return f7563a.getIid();
    }

    public static InitConfig getInitConfig() {
        return f7563a.getInitConfig();
    }

    public static IAppLogInstance getInstance() {
        return f7563a;
    }

    public static INetworkClient getNetClient() {
        return f7563a.getNetClient();
    }

    public static String getOpenUdid() {
        return f7563a.getOpenUdid();
    }

    public static Map<String, String> getRequestHeader() {
        return f7563a.getRequestHeader();
    }

    public static String getSdkVersion() {
        return f7563a.getSdkVersion();
    }

    public static String getSessionId() {
        return f7563a.getSessionId();
    }

    public static String getSsid() {
        return f7563a.getSsid();
    }

    public static void getSsidGroup(Map<String, String> map) {
        f7563a.getSsidGroup(map);
    }

    public static String getUdid() {
        return f7563a.getUdid();
    }

    public static String getUserID() {
        return f7563a.getUserID();
    }

    public static String getUserUniqueID() {
        return f7563a.getUserUniqueID();
    }

    public static JSONObject getViewProperties(View view) {
        return f7563a.getViewProperties(view);
    }

    public static boolean hasStarted() {
        return f7563a.hasStarted();
    }

    public static void ignoreAutoTrackClick(View view) {
        f7563a.ignoreAutoTrackClick(view);
    }

    public static void ignoreAutoTrackClickByViewType(Class<?>... clsArr) {
        f7563a.ignoreAutoTrackClickByViewType(clsArr);
    }

    public static void ignoreAutoTrackPage(Class<?>... clsArr) {
        f7563a.ignoreAutoTrackPage(clsArr);
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
                f7563a.init(context, initConfig);
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
                f7563a.init(context, initConfig, activity);
            } finally {
            }
        }
    }

    public static boolean isAutoTrackClickIgnored(View view) {
        return f7563a.isAutoTrackClickIgnored(view);
    }

    public static boolean isAutoTrackPageIgnored(Class<?> cls) {
        return f7563a.isAutoTrackPageIgnored(cls);
    }

    public static boolean isH5BridgeEnable() {
        return f7563a.isH5BridgeEnable();
    }

    public static boolean isH5CollectEnable() {
        return f7563a.isH5CollectEnable();
    }

    public static boolean isNewUser() {
        return f7563a.isNewUser();
    }

    public static boolean isPrivacyMode() {
        return f7563a.isPrivacyMode();
    }

    public static boolean manualActivate() {
        return f7563a.manualActivate();
    }

    public static IAppLogInstance newInstance() {
        return new c();
    }

    public static void onActivityPause() {
        f7563a.onActivityPause();
    }

    public static void onActivityResumed(Activity activity, int i) {
        f7563a.onActivityResumed(activity, i);
    }

    @Deprecated
    public static void onEvent(String str) {
        f7563a.onEvent(str);
    }

    @Deprecated
    public static void onEvent(String str, String str2) {
        f7563a.onEvent(str, str2);
    }

    @Deprecated
    public static void onEvent(String str, String str2, String str3, long j, long j2) {
        f7563a.onEvent(str, str2, str3, j, j2);
    }

    public static void onEvent(String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        f7563a.onEvent(str, str2, str3, j, j2, jSONObject);
    }

    public static void onEventV3(String str) {
        f7563a.onEventV3(str);
    }

    public static void onEventV3(String str, Bundle bundle) {
        f7563a.onEventV3(str, bundle);
    }

    public static void onEventV3(String str, Bundle bundle, int i) {
        f7563a.onEventV3(str, bundle, i);
    }

    public static void onEventV3(String str, JSONObject jSONObject) {
        f7563a.onEventV3(str, jSONObject);
    }

    public static void onEventV3(String str, JSONObject jSONObject, int i) {
        f7563a.onEventV3(str, jSONObject, i);
    }

    @Deprecated
    public static void onInternalEventV3(String str, Bundle bundle, String str2, String str3, String str4) {
        f7563a.onInternalEventV3(str, bundle, str2, str3, str4);
    }

    @Deprecated
    public static void onInternalEventV3(String str, JSONObject jSONObject, String str2, String str3, String str4) {
        f7563a.onInternalEventV3(str, jSONObject, str2, str3, str4);
    }

    public static void onMiscEvent(String str, JSONObject jSONObject) {
        f7563a.onMiscEvent(str, jSONObject);
    }

    public static void onPause(Context context) {
        f7563a.onPause(context);
    }

    public static void onResume(Context context) {
        f7563a.onResume(context);
    }

    public static void profileAppend(JSONObject jSONObject) {
        f7563a.profileAppend(jSONObject);
    }

    public static void profileIncrement(JSONObject jSONObject) {
        f7563a.profileIncrement(jSONObject);
    }

    public static void profileSet(JSONObject jSONObject) {
        f7563a.profileSet(jSONObject);
    }

    public static void profileSetOnce(JSONObject jSONObject) {
        f7563a.profileSetOnce(jSONObject);
    }

    public static void profileUnset(String str) {
        f7563a.profileUnset(str);
    }

    public static void pullAbTestConfigs() {
        f7563a.pullAbTestConfigs();
    }

    public static void putCommonParams(Context context, Map<String, String> map, boolean z, Level level) {
        f7563a.putCommonParams(context, map, z, level);
    }

    public static void registerHeaderCustomCallback(IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback) {
        f7563a.registerHeaderCustomCallback(iHeaderCustomTimelyCallback);
    }

    public static void removeAllDataObserver() {
        f7563a.removeAllDataObserver();
    }

    public static void removeDataObserver(IDataObserver iDataObserver) {
        f7563a.removeDataObserver(iDataObserver);
    }

    public static void removeEventObserver(IEventObserver iEventObserver) {
        f7563a.removeEventObserver(iEventObserver);
    }

    public static void removeHeaderInfo(String str) {
        f7563a.removeHeaderInfo(str);
    }

    public static void removeOaidObserver(IOaidObserver iOaidObserver) {
        f7563a.removeOaidObserver(iOaidObserver);
    }

    public static void removeSessionHook(ISessionObserver iSessionObserver) {
        f7563a.removeSessionHook(iSessionObserver);
    }

    public static boolean reportPhoneDetailInfo() {
        return f7563a.reportPhoneDetailInfo();
    }

    public static void setALinkListener(IALinkListener iALinkListener) {
        f7563a.setALinkListener(iALinkListener);
    }

    public static void setAccount(Account account) {
        f7563a.setAccount(account);
    }

    public static void setActiveCustomParams(IActiveCustomParamsCallback iActiveCustomParamsCallback) {
        f7563a.setActiveCustomParams(iActiveCustomParamsCallback);
    }

    public static void setAppContext(d dVar) {
        f7563a.setAppContext(dVar);
    }

    public static void setAppLanguageAndRegion(String str, String str2) {
        f7563a.setAppLanguageAndRegion(str, str2);
    }

    public static void setAppTrack(JSONObject jSONObject) {
        f7563a.setAppTrack(jSONObject);
    }

    public static void setClipboardEnabled(boolean z) {
        f7563a.setClipboardEnabled(z);
    }

    public static void setEncryptAndCompress(boolean z) {
        f7563a.setEncryptAndCompress(z);
    }

    public static void setEventFilterByClient(List<String> list, boolean z) {
        f7563a.setEventFilterByClient(list, z);
    }

    public static void setEventHandler(IEventHandler iEventHandler) {
        f7563a.setEventHandler(iEventHandler);
    }

    public static void setExternalAbVersion(String str) {
        f7563a.setExternalAbVersion(str);
    }

    public static void setExtraParams(IExtraParams iExtraParams) {
        f7563a.setExtraParams(iExtraParams);
    }

    public static void setForbidReportPhoneDetailInfo(boolean z) {
        f7563a.setForbidReportPhoneDetailInfo(z);
    }

    public static void setGoogleAid(String str) {
        f7563a.setGoogleAid(str);
    }

    public static void setHeaderInfo(String str, Object obj) {
        f7563a.setHeaderInfo(str, obj);
    }

    public static void setHeaderInfo(HashMap<String, Object> hashMap) {
        f7563a.setHeaderInfo(hashMap);
    }

    public static void setOaidObserver(IOaidObserver iOaidObserver) {
        f7563a.setOaidObserver(iOaidObserver);
    }

    public static void setPrivacyMode(boolean z) {
        f7563a.setPrivacyMode(z);
    }

    public static void setRangersEventVerifyEnable(boolean z, String str) {
        f7563a.setRangersEventVerifyEnable(z, str);
    }

    public static void setTouchPoint(String str) {
        f7563a.setTouchPoint(str);
    }

    public static void setTracerData(JSONObject jSONObject) {
        f7563a.setTracerData(jSONObject);
    }

    public static void setUriRuntime(UriConfig uriConfig) {
        f7563a.setUriRuntime(uriConfig);
    }

    public static void setUserAgent(String str) {
        f7563a.setUserAgent(str);
    }

    public static void setUserID(long j) {
        f7563a.setUserID(j);
    }

    public static void setUserUniqueID(String str) {
        f7563a.setUserUniqueID(str);
    }

    public static void setViewId(Dialog dialog, String str) {
        f7563a.setViewId(dialog, str);
    }

    public static void setViewId(View view, String str) {
        f7563a.setViewId(view, str);
    }

    public static void setViewId(Object obj, String str) {
        f7563a.setViewId(obj, str);
    }

    public static void setViewProperties(View view, JSONObject jSONObject) {
        f7563a.setViewProperties(view, jSONObject);
    }

    public static void start() {
        f7563a.start();
    }

    public static void startSimulator(String str) {
        f7563a.startSimulator(str);
    }

    public static void trackClick(View view) {
        f7563a.trackClick(view);
    }

    public static void trackClick(View view, JSONObject jSONObject) {
        f7563a.trackClick(view, jSONObject);
    }

    public static void trackPage(Activity activity) {
        f7563a.trackPage(activity);
    }

    public static void trackPage(Activity activity, JSONObject jSONObject) {
        f7563a.trackPage(activity, jSONObject);
    }

    public static void trackPage(Object obj) {
        f7563a.trackPage(obj);
    }

    public static void trackPage(Object obj, JSONObject jSONObject) {
        f7563a.trackPage(obj, jSONObject);
    }

    public static void userProfileSetOnce(JSONObject jSONObject, UserProfileCallback userProfileCallback) {
        f7563a.userProfileSetOnce(jSONObject, userProfileCallback);
    }

    public static void userProfileSync(JSONObject jSONObject, UserProfileCallback userProfileCallback) {
        f7563a.userProfileSync(jSONObject, userProfileCallback);
    }
}
