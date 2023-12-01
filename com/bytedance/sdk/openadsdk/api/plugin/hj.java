package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.pd.ExHandler;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.api.plugin.ko;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/hj.class */
public final class hj {
    private static SharedPreferences b;
    private static ScheduledExecutorService ox = Executors.newSingleThreadScheduledExecutor(new ko.ox("tt_pangle_thread_pl_report"));
    private static final List<Pair<String, JSONObject>> hj = new ArrayList();
    static final Map<String, String> mb = new HashMap();
    private static volatile boolean h = false;

    public static void b(String str, JSONObject jSONObject) {
        hj.add(new Pair<>(str, jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(List<JSONObject> list) {
        if (list == null) {
            return;
        }
        SharedPreferences sharedPreferences = b;
        String format = String.format("https://%s%s", sharedPreferences != null ? sharedPreferences.getString("url_alog", "api-access.pangolin-sdk-toutiao.com") : "api-access.pangolin-sdk-toutiao.com", "/api/ad/union/sdk/stats/batch/");
        JSONObject jSONObject = new JSONObject();
        try {
            if (hj.size() > 0) {
                Iterator<Pair<String, JSONObject>> it = hj.iterator();
                while (it.hasNext()) {
                    Pair<String, JSONObject> next = it.next();
                    list.add(u(next.first, next.second));
                    it.remove();
                }
            }
            jSONObject.put("stats_list", new JSONArray((Collection) list));
        } catch (JSONException e) {
        }
        com.bytedance.sdk.openadsdk.api.plugin.mb.b.mb().mb(true, format, com.bytedance.sdk.openadsdk.api.plugin.ox.ox.mb(jSONObject).toString().getBytes());
    }

    private static void h(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            ox(str, jSONObject);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 1);
        bundle.putString("event_name", str);
        bundle.putString("event_extra", jSONObject.toString());
        adManager.getExtra(Bundle.class, bundle);
    }

    public static void mb() {
        if (h) {
            return;
        }
        try {
            h = true;
            ox.shutdown();
        } catch (Throwable th) {
        }
    }

    public static final void mb(int i, String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("duration", Long.valueOf(j));
            jSONObject.putOpt("code", Integer.valueOf(i));
            jSONObject.putOpt("message", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        h("plugin_load_failed", jSONObject);
    }

    public static void mb(Context context) {
        b = context.getSharedPreferences("tt_sdk_settings_other", 0);
    }

    public static void mb(final Bundle bundle) {
        if (h) {
            return;
        }
        ox.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.hj.3
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle2 = Bundle.this;
                if (bundle2 == null) {
                    return;
                }
                try {
                    String string = bundle2.getString("event_name");
                    String string2 = Bundle.this.getString("event_extra");
                    JSONObject jSONObject = TextUtils.isEmpty(string2) ? new JSONObject() : new JSONObject(string2);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(hj.u(string, jSONObject));
                    hj.b(arrayList);
                } catch (Exception e) {
                }
            }
        });
    }

    public static void mb(AdConfig adConfig) {
        if (adConfig == null) {
            return;
        }
        mb.put("appid", adConfig.getAppId());
        Object extra = adConfig.getExtra("plugin_update_conf");
        if (extra instanceof Integer) {
            String num = ((Integer) extra).toString();
            Map<String, String> map = mb;
            if (num == null) {
                num = "2";
            }
            map.put("plugin_update_conf", num);
        }
        TTCustomController customController = adConfig.getCustomController();
        if (customController != null) {
            try {
                mb.put("oaid", customController.getDevOaid());
                mb.put(ExHandler.JSON_REQUEST_IMEI, customController.getDevImei());
            } catch (Exception e) {
            }
        }
    }

    public static void mb(String str, JSONObject jSONObject) {
        h("zeus_" + str, jSONObject);
    }

    public static void mb(final List<JSONObject> list) {
        if (h) {
            return;
        }
        if (list != null && list.isEmpty() && hj.isEmpty()) {
            return;
        }
        ox.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.hj.2
            @Override // java.lang.Runnable
            public void run() {
                hj.b(list);
            }
        });
    }

    public static final void ox(int i, String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("duration", Long.valueOf(j));
            jSONObject.putOpt("code", Integer.valueOf(i));
            jSONObject.putOpt("message", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ox("plugin_load_failed", jSONObject);
    }

    public static void ox(final String str, final JSONObject jSONObject) {
        if (h) {
            return;
        }
        ox.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.hj.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(hj.u(str, jSONObject));
                hj.b(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject u(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("support_abi", Arrays.toString(Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2}));
            jSONObject2.put("ad_sdk_version", "5.1.0.2");
            String mb2 = u.mb("com.byted.pangle");
            if (TextUtils.isEmpty(mb2)) {
                mb2 = "5.1.0.2";
            }
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, mb2);
            jSONObject2.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject2.put("is_plugin", true);
            jSONObject2.put("event_extra", jSONObject != null ? jSONObject.toString() : "");
            jSONObject2.put("type", str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("model", Build.MODEL);
            jSONObject3.put(MediaDrm.PROPERTY_VENDOR, Build.MANUFACTURER);
            jSONObject3.put(ExHandler.JSON_REQUEST_IMEI, mb.get(ExHandler.JSON_REQUEST_IMEI));
            jSONObject3.put("oaid", mb.get("oaid"));
            jSONObject2.put("device_info", jSONObject3);
            return jSONObject2;
        } catch (JSONException e) {
            return jSONObject2;
        }
    }
}
