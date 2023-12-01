package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTInitializer;
import com.bytedance.sdk.openadsdk.api.plugin.u;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/ko.class */
public class ko implements TTInitializer {
    private static final Map<String, Bundle> b = new ConcurrentHashMap();
    public static ScheduledExecutorService mb = Executors.newSingleThreadScheduledExecutor(new ox());
    private volatile TTInitializer ox;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/ko$mb.class */
    static class mb implements TTAdSdk.InitCallback {
        private TTAdSdk.InitCallback mb;

        public mb(TTAdSdk.InitCallback initCallback) {
            this.mb = initCallback;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i, String str) {
            TTAdSdk.InitCallback initCallback = this.mb;
            if (initCallback != null) {
                initCallback.fail(i, str);
                hj.ox(i, str, 0L);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
            TTAdSdk.InitCallback initCallback = this.mb;
            if (initCallback != null) {
                initCallback.success();
            }
            hj.mb();
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/ko$ox.class */
    public static class ox implements ThreadFactory {
        private final String b;
        private final ThreadGroup mb;
        private final AtomicInteger ox;

        ox() {
            this.ox = new AtomicInteger(1);
            this.mb = new ThreadGroup("csj_g_pl_init");
            this.b = "csj_pl_init";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ox(String str) {
            this.ox = new AtomicInteger(1);
            this.mb = new ThreadGroup("csj_g_pl_init");
            this.b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.mb;
            Thread thread = new Thread(threadGroup, runnable, this.b + this.ox.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 10) {
                thread.setPriority(10);
            }
            return thread;
        }
    }

    private static final Bundle mb(Map<String, Bundle> map) {
        if (map == null || map.size() == 0) {
            return new Bundle();
        }
        Bundle bundle = new Bundle();
        for (Map.Entry<String, Bundle> entry : map.entrySet()) {
            String key = entry.getKey();
            Bundle value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value != null) {
                bundle.putBundle(key, value);
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TTInitializer mb(AdConfig adConfig, h hVar) {
        if (this.ox == null) {
            synchronized (this) {
                if (this.ox == null) {
                    hj.mb(adConfig);
                    com.bytedance.sdk.openadsdk.api.mb.ox("TTPluginManager", "Create initializer");
                    this.ox = ox(adConfig, hVar);
                    hVar.mb();
                    JSONObject jSONObject = new JSONObject();
                    hVar.mb(jSONObject, 20L);
                    try {
                        jSONObject.put("zeus", u.mb(TTAppContextHolder.getContext()).ox());
                    } catch (JSONException e) {
                    }
                    adConfig.setExtra("plugin", jSONObject);
                }
            }
        }
        return this.ox;
    }

    private void mb(final Context context, final AdConfig adConfig, final TTAdSdk.InitCallback initCallback, final h hVar) {
        mb.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.ko.1
            @Override // java.lang.Runnable
            public void run() {
                hVar.ox("wait_asyn_cost");
                TTInitializer mb2 = ko.this.mb(adConfig, hVar);
                if (mb2 == null) {
                    initCallback.fail(4201, "No initializer");
                    return;
                }
                com.bytedance.sdk.openadsdk.api.plugin.mb.mb.mb(mb2.getAdManager());
                mb2.init(context, adConfig, initCallback);
                mb2.getAdManager().register(com.bytedance.sdk.openadsdk.mb.ox.mb());
            }
        });
    }

    public static void mb(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || bundle == null) {
            return;
        }
        b.put(str, bundle);
    }

    private static TTInitializer ox(AdConfig adConfig, h hVar) {
        try {
            hVar.ox("call_create_initializer");
            u mb2 = u.mb(TTAppContextHolder.getContext());
            BaseDexClassLoader mb3 = mb2.mb(hVar);
            if (mb3 == null) {
                hj.mb(6, "Load plugin failed", 0L);
                com.bytedance.sdk.openadsdk.api.mb.h("TTPluginManager", "Load plugin failed");
                return null;
            }
            Class<?> loadClass = mb3.loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
            hVar.ox("get_init_class_cost");
            Bundle bundle = new Bundle();
            bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_LISTENER, new u.ox());
            bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new u.b());
            Bundle mb4 = mb(b);
            bundle.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, mb4);
            hVar.ox("create_bundle_cost");
            bundle.putSerializable(PluginConstants.KEY_LIVE_SDK, com.bytedance.sdk.openadsdk.live.ox.mb());
            Bundle mb5 = com.bytedance.sdk.openadsdk.live.mb.mb(mb2, adConfig.getAppId());
            com.bytedance.sdk.openadsdk.live.ox.mb().mb(mb2, mb5);
            if (mb5 != null) {
                mb4.putBundle("com.byted.live.lite", mb5);
            }
            hVar.ox("live_init_cost");
            Method declaredMethod = loadClass.getDeclaredMethod("getInstance", Bundle.class);
            hVar.ox("get_init_method_cost");
            TTInitializer tTInitializer = (TTInitializer) declaredMethod.invoke(null, bundle);
            hVar.ox("get_init_instance_cost");
            com.bytedance.sdk.openadsdk.api.mb.ox("TTPluginManager", "Create initializer success");
            return tTInitializer;
        } catch (Throwable th) {
            if (th instanceof b) {
                b bVar = th;
                hj.mb(bVar.mb(), bVar.getMessage(), 0L);
            } else {
                hj.mb(6, th.getMessage(), 0L);
            }
            com.bytedance.sdk.openadsdk.api.mb.h("TTPluginManager", "Create initializer failed: " + th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public TTAdManager getAdManager() {
        return com.bytedance.sdk.openadsdk.api.plugin.mb.mb;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public void init(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        if (Build.VERSION.SDK_INT < 21) {
            initCallback.fail(4201, "Only support >= 5.0");
            return;
        }
        u.mb(context).mb();
        if (this.ox != null) {
            this.ox.init(context, adConfig, new mb(initCallback));
        } else {
            mb(context, adConfig, new mb(initCallback), h.mb("duration"));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public boolean isInitSuccess() {
        if (this.ox != null) {
            return this.ox.isInitSuccess();
        }
        return false;
    }
}
