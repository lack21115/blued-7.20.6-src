package com.bytedance.applog;

import android.accounts.Account;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.bytedance.applog.alink.IALinkListener;
import com.bytedance.applog.event.IEventHandler;
import com.bytedance.applog.network.INetworkClient;
import com.bytedance.applog.profile.UserProfileCallback;
import com.bytedance.bdtracker.a0;
import com.bytedance.bdtracker.d;
import com.bytedance.bdtracker.t1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/IAppLogInstance.class */
public interface IAppLogInstance {
    void activateALink(Uri uri);

    void addDataObserver(IDataObserver iDataObserver);

    void addEventObserver(IEventObserver iEventObserver);

    String addNetCommonParams(Context context, String str, boolean z, Level level);

    void addSessionHook(ISessionObserver iSessionObserver);

    void flush();

    IALinkListener getALinkListener();

    <T> T getAbConfig(String str, T t);

    String getAbSdkVersion();

    IActiveCustomParamsCallback getActiveCustomParams();

    @Deprecated
    String getAid();

    JSONObject getAllAbTestConfigs();

    d getAppContext();

    String getAppId();

    String getClientUdid();

    Context getContext();

    String getDeepLinkUrl();

    String getDid();

    boolean getEncryptAndCompress();

    a0 getEventFilterByClient();

    IEventHandler getEventHandler();

    JSONObject getHeader();

    IHeaderCustomTimelyCallback getHeaderCustomCallback();

    <T> T getHeaderValue(String str, T t, Class<T> cls);

    String getIid();

    InitConfig getInitConfig();

    int getLaunchFrom();

    INetworkClient getNetClient();

    String getOpenUdid();

    Map<String, String> getRequestHeader();

    String getSdkVersion();

    String getSessionId();

    String getSsid();

    void getSsidGroup(Map<String, String> map);

    String getUdid();

    String getUserID();

    String getUserUniqueID();

    JSONObject getViewProperties(View view);

    boolean hasStarted();

    void ignoreAutoTrackClick(View view);

    void ignoreAutoTrackClickByViewType(Class<?>... clsArr);

    void ignoreAutoTrackPage(Class<?>... clsArr);

    void init(Context context, InitConfig initConfig);

    void init(Context context, InitConfig initConfig, Activity activity);

    void initMetaSec(Context context);

    boolean isAutoTrackClickIgnored(View view);

    boolean isAutoTrackPageIgnored(Class<?> cls);

    boolean isBavEnabled();

    boolean isH5BridgeEnable();

    boolean isH5CollectEnable();

    boolean isNewUser();

    boolean isPrivacyMode();

    boolean manualActivate();

    void onActivityPause();

    void onActivityResumed(Activity activity, int i);

    @Deprecated
    void onEvent(String str);

    @Deprecated
    void onEvent(String str, String str2);

    @Deprecated
    void onEvent(String str, String str2, String str3, long j, long j2);

    @Deprecated
    void onEvent(String str, String str2, String str3, long j, long j2, JSONObject jSONObject);

    void onEventV3(String str);

    void onEventV3(String str, Bundle bundle);

    void onEventV3(String str, Bundle bundle, int i);

    void onEventV3(String str, JSONObject jSONObject);

    void onEventV3(String str, JSONObject jSONObject, int i);

    @Deprecated
    void onInternalEventV3(String str, Bundle bundle, String str2, String str3, String str4);

    @Deprecated
    void onInternalEventV3(String str, JSONObject jSONObject, String str2, String str3, String str4);

    void onMiscEvent(String str, JSONObject jSONObject);

    void onPause(Context context);

    void onResume(Context context);

    void profileAppend(JSONObject jSONObject);

    void profileIncrement(JSONObject jSONObject);

    void profileSet(JSONObject jSONObject);

    void profileSetOnce(JSONObject jSONObject);

    void profileUnset(String str);

    void pullAbTestConfigs();

    void putCommonParams(Context context, Map<String, String> map, boolean z, Level level);

    void receive(t1 t1Var);

    void receive(String[] strArr);

    void registerHeaderCustomCallback(IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback);

    void removeAllDataObserver();

    void removeDataObserver(IDataObserver iDataObserver);

    void removeEventObserver(IEventObserver iEventObserver);

    void removeHeaderInfo(String str);

    void removeOaidObserver(IOaidObserver iOaidObserver);

    void removeSessionHook(ISessionObserver iSessionObserver);

    boolean reportPhoneDetailInfo();

    void setALinkListener(IALinkListener iALinkListener);

    void setAccount(Account account);

    void setActiveCustomParams(IActiveCustomParamsCallback iActiveCustomParamsCallback);

    void setAppContext(d dVar);

    void setAppLanguageAndRegion(String str, String str2);

    void setAppTrack(JSONObject jSONObject);

    void setClipboardEnabled(boolean z);

    void setEncryptAndCompress(boolean z);

    void setEventFilterByClient(List<String> list, boolean z);

    void setEventHandler(IEventHandler iEventHandler);

    void setExternalAbVersion(String str);

    void setExtraParams(IExtraParams iExtraParams);

    void setForbidReportPhoneDetailInfo(boolean z);

    void setGoogleAid(String str);

    void setHeaderInfo(String str, Object obj);

    void setHeaderInfo(HashMap<String, Object> hashMap);

    void setLaunchFrom(int i);

    void setOaidObserver(IOaidObserver iOaidObserver);

    void setPrivacyMode(boolean z);

    void setPullAbTestConfigsThrottleMills(Long l);

    void setRangersEventVerifyEnable(boolean z, String str);

    void setTouchPoint(String str);

    void setTracerData(JSONObject jSONObject);

    void setUriRuntime(UriConfig uriConfig);

    void setUserAgent(String str);

    void setUserID(long j);

    void setUserUniqueID(String str);

    void setViewId(Dialog dialog, String str);

    void setViewId(View view, String str);

    void setViewId(Object obj, String str);

    void setViewProperties(View view, JSONObject jSONObject);

    void start();

    void startSimulator(String str);

    void trackClick(View view);

    void trackClick(View view, JSONObject jSONObject);

    void trackPage(Activity activity);

    void trackPage(Activity activity, JSONObject jSONObject);

    void trackPage(Object obj);

    void trackPage(Object obj, JSONObject jSONObject);

    void userProfileSetOnce(JSONObject jSONObject, UserProfileCallback userProfileCallback);

    void userProfileSync(JSONObject jSONObject, UserProfileCallback userProfileCallback);
}
