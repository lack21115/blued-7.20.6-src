package com.bytedance.pangle.service;

import android.app.IActivityManager;
import android.app.IntentService;
import android.content.ComponentName;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/service/PluginIntentService.class */
public abstract class PluginIntentService extends IntentService implements a {
    private static final String TAG = "PluginService";

    public PluginIntentService(String str) {
        super(str);
    }

    @Override // com.bytedance.pangle.service.a
    public void attach(Plugin plugin) {
        attachBaseContext(ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName));
        try {
            FieldUtils.writeField(this, "mActivityManager", createActivityManagerProxy());
            FieldUtils.writeField(this, "mClassName", getClass().getName());
            FieldUtils.writeField(this, "mApplication", Zeus.getAppApplication());
            FieldUtils.writeField(this, "mStartCompatibility", Boolean.valueOf(getApplicationInfo().targetSdkVersion < 5));
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "hook activityManager failed!", e);
        }
    }

    protected Object createActivityManagerProxy() {
        return Proxy.newProxyInstance(getClassLoader(), new Class[]{Class.forName(IActivityManager.descriptor)}, new InvocationHandler() { // from class: com.bytedance.pangle.service.PluginIntentService.1
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                boolean z;
                String name = method.getName();
                int hashCode = name.hashCode();
                if (hashCode == 39551382) {
                    if (name.equals("setServiceForeground")) {
                        z = true;
                    }
                    z = true;
                } else if (hashCode != 690954390) {
                    if (hashCode == 1930712422 && name.equals("stopServiceToken")) {
                        z = false;
                    }
                    z = true;
                } else {
                    if (name.equals("getForegroundServiceType")) {
                        z = true;
                    }
                    z = true;
                }
                if (z) {
                    return !z ? null : 0;
                }
                com.bytedance.pangle.service.a.a b = com.bytedance.pangle.service.a.a.b();
                PluginIntentService pluginIntentService = PluginIntentService.this;
                return Boolean.valueOf(b.a(new ComponentName(pluginIntentService, pluginIntentService.getClass().getName())));
            }
        });
    }
}
