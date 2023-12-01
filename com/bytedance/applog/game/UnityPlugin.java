package com.bytedance.applog.game;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.ILogger;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.UriConfig;
import com.bytedance.bdtracker.z2;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/game/UnityPlugin.class */
public class UnityPlugin {

    /* renamed from: a  reason: collision with root package name */
    public Activity f21177a;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/game/UnityPlugin$a.class */
    public class a implements ILogger {
        public a(UnityPlugin unityPlugin) {
        }

        @Override // com.bytedance.applog.ILogger
        public void log(String str, Throwable th) {
            Log.d("AppLog", str, th);
        }
    }

    public void flush() {
        AppLog.flush();
    }

    public String getAbConfig(String str, String str2) {
        return (String) AppLog.getAbConfig(str, str2);
    }

    public String getAbSdkVersion() {
        return AppLog.getAbSdkVersion();
    }

    public String getAid() {
        return AppLog.getAid();
    }

    public String getAllAbTestConfigs() {
        return AppLog.getAllAbTestConfigs().toString();
    }

    public String getDeviceId() {
        return AppLog.getDid();
    }

    public String getIid() {
        return AppLog.getIid();
    }

    public String getSsid() {
        return AppLog.getSsid();
    }

    public String getUserUniqueID() {
        return AppLog.getUserUniqueID();
    }

    public void init(String str, String str2, boolean z, boolean z2, boolean z3, String str3) {
        InitConfig initConfig = new InitConfig(str, str2);
        initConfig.setAbEnable(z);
        AppLog.setEncryptAndCompress(z2);
        if (z3) {
            initConfig.setLogger(new a(this));
        }
        if (!TextUtils.isEmpty(str3)) {
            initConfig.setUriConfig(UriConfig.createByDomain(str3, null));
        }
        if (this.f21177a == null) {
            try {
                Class<?> cls = Class.forName("com.unity3d.player.UnityPlayer");
                this.f21177a = (Activity) cls.getDeclaredField("currentActivity").get(cls);
            } catch (Exception e) {
            }
        }
        AppLog.init(this.f21177a, initConfig);
    }

    public void onEventV3(String str, String str2) {
        try {
            AppLog.onEventV3(str, new JSONObject(str2));
        } catch (JSONException e) {
            z2.a(e);
        }
    }

    public void profileAppend(String str) {
        try {
            AppLog.profileAppend(new JSONObject(str));
        } catch (JSONException e) {
            z2.a(e);
        }
    }

    public void profileIncrement(String str) {
        try {
            AppLog.profileIncrement(new JSONObject(str));
        } catch (JSONException e) {
            z2.a(e);
        }
    }

    public void profileSet(String str) {
        try {
            AppLog.profileSet(new JSONObject(str));
        } catch (JSONException e) {
            z2.a(e);
        }
    }

    public void profileSetOnce(String str) {
        try {
            AppLog.profileSetOnce(new JSONObject(str));
        } catch (JSONException e) {
            z2.a(e);
        }
    }

    public void profileUnset(String str) {
        AppLog.profileUnset(str);
    }

    public void removeCustomHeaderInfo(String str) {
        AppLog.removeHeaderInfo(str);
    }

    public void setCustomHeaderInfo(String str, String str2) {
        AppLog.setHeaderInfo(str, str2);
    }

    public void setExternalAbVersion(String str) {
        AppLog.setExternalAbVersion(str);
    }

    public void setUserUniqueID(String str) {
        AppLog.setUserUniqueID(str);
    }
}
