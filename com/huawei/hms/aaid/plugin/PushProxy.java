package com.huawei.hms.aaid.plugin;

import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/aaid/plugin/PushProxy.class */
public interface PushProxy {
    void deleteAllToken(Context context) throws ApiException;

    void deleteToken(Context context, String str, String str2) throws ApiException;

    JSONObject getPlatform();

    String getProxyType();

    void getToken(Context context, String str, String str2) throws ApiException;

    Task<Void> subscribe(Context context, String str, String str2);

    Task<Void> turnOff(Context context, String str);

    Task<Void> turnOn(Context context, String str);

    Task<Void> unsubscribe(Context context, String str, String str2);
}
