package com.danlan.android.cognition.collector.listener;

import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/collector/listener/DeviceInfoDependency.class */
public interface DeviceInfoDependency {
    Map<String, String> setApi();

    Map<String, String> setHeaderData();

    Map<String, String> setServerDomain();

    String setSpecialUserAgent();

    Map<String, Object> setUserData();
}
