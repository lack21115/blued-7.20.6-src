package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bw;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.TTAdEvent;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.ss.android.downloadlib.constants.EventConstants;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/u.class */
public class u {
    private static volatile BaseDexClassLoader hj;
    private static volatile TTPluginListener je;
    private static volatile boolean u;
    private final Context x;
    private static final String mb = "next" + File.separator;
    private static final HashMap<String, TTPluginListener> ox = new HashMap<>();
    private static final HashMap<String, Handler> b = new HashMap<>();
    private static volatile u h = null;
    private final CountDownLatch ko = new CountDownLatch(1);
    private volatile boolean ww = false;
    private volatile String lz = "none";
    private JSONObject jb = new JSONObject();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/u$b.class */
    public static final class b implements EventListener, Serializable {
        @Override // com.bykv.vk.openvk.api.proto.EventListener
        public ValueSet onEvent(int i, Result result) {
            com.bytedance.sdk.openadsdk.api.b mb = com.bytedance.sdk.openadsdk.api.b.mb();
            if (i == 1) {
                ValueSet values = result.values();
                if (values == null) {
                    return null;
                }
                String stringValue = values.stringValue(3);
                int code = result.code();
                if (!result.isSuccess()) {
                    u.b(stringValue, code);
                    return null;
                }
                com.bytedance.sdk.openadsdk.api.plugin.ox b = u.b(values.stringValue(2));
                if (b == null || TextUtils.isEmpty(b.mPackageName)) {
                    com.bytedance.sdk.openadsdk.api.mb.hj("TTPluginManager", "plugin update received with invalid config");
                    return null;
                }
                com.bytedance.sdk.openadsdk.api.mb.hj("TTPluginManager", "plugin update received: " + b.mPackageName);
                if (b.isRevert()) {
                    Zeus.unInstallPlugin(b.mPackageName);
                } else if (u.ox(b)) {
                    mb.mb(4, true);
                }
            }
            return mb.ox();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/u$mb.class */
    public static final class mb implements IZeusLogger {
        private mb() {
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void e(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.mb.ox(str, str2, th);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void i(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.mb.b(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void v(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.mb.mb(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.mb.mb(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.mb.mb(str, str2, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/u$ox.class */
    public static final class ox implements TTAdEvent {
        @Override // com.bytedance.sdk.openadsdk.TTAdEvent
        public void onEvent(int i, Bundle bundle) {
            if (i == 1) {
                String string = bundle.getString(com.igexin.push.core.b.U);
                String string2 = bundle.getString("plugin_pkg_name");
                int i2 = bundle.getInt("code");
                if (i2 != 0) {
                    u.b(string2, i2);
                    return;
                }
                com.bytedance.sdk.openadsdk.api.plugin.ox b = u.b(string);
                if (b == null || TextUtils.isEmpty(b.mPackageName)) {
                    com.bytedance.sdk.openadsdk.api.mb.hj("TTPluginManager", "plugin update received with invalid config");
                } else if (!bundle.getBoolean(bw.o)) {
                    u.b(b.mPackageName, 1004);
                } else {
                    com.bytedance.sdk.openadsdk.api.mb.hj("TTPluginManager", "plugin update received: " + b.mPackageName);
                    if (b.isRevert()) {
                        Zeus.unInstallPlugin(b.mPackageName);
                    } else if (u.ox(b)) {
                        bundle.putBoolean("installed", true);
                    }
                }
            }
        }
    }

    private u(Context context) {
        this.x = context.getApplicationContext();
        hj.mb(context);
        ox(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.api.plugin.ox b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return mb(new JSONObject(str));
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.mb.h("TTPluginManager", "Invalid plugin info:" + str);
            return null;
        }
    }

    private static File b(Context context) {
        return new File(new File(context.getDir("tt_pangle_bykv_file", 0), "pangle_com.byted.pangle"), mb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, int i) {
        com.bytedance.sdk.openadsdk.api.mb.hj("TTPluginManager", "plugin update failed");
        Bundle bundle = new Bundle();
        bundle.putInt("code", i);
        TTPluginListener tTPluginListener = ox.get(str);
        if (tTPluginListener != null) {
            tTPluginListener.onPluginListener(1001, null, null, bundle);
        }
    }

    private static com.bytedance.sdk.openadsdk.api.plugin.ox mb(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.api.plugin.ox oxVar = new com.bytedance.sdk.openadsdk.api.plugin.ox();
        oxVar.mPackageName = jSONObject.optString("package_name");
        oxVar.mVersionCode = jSONObject.optInt("version_code");
        oxVar.mUrl = jSONObject.optString(EventConstants.ExtraJson.DOWNLOAD_URL);
        oxVar.mMd5 = jSONObject.optString("md5");
        oxVar.mApiVersionMin = jSONObject.optInt("min_version");
        oxVar.mApiVersionMax = jSONObject.optInt("max_version");
        oxVar.mb = jSONObject.optString(com.anythink.expressad.d.a.b.d);
        oxVar.mFlag = jSONObject.optBoolean("is_revert") ? 3 : 2;
        oxVar.ox = new File(jSONObject.optString("plugin_file"));
        return oxVar;
    }

    public static u mb(Context context) {
        if (h == null) {
            synchronized (u.class) {
                try {
                    if (h == null) {
                        h = new u(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return h;
    }

    public static String mb(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= charArray.length) {
                return sb.toString();
            }
            sb.append(charArray[i3]);
            if (i3 < charArray.length - 1) {
                sb.append(".");
            }
            i2 = i3 + 1;
        }
    }

    public static String mb(String str) {
        Plugin plugin;
        try {
            if (!Zeus.isPluginInstalled(str) || (plugin = Zeus.getPlugin(str)) == null) {
                return null;
            }
            return mb(plugin.getVersion());
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.mb.hj("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    public static void mb(Throwable th) {
        if (th instanceof AbstractMethodError) {
            Zeus.unInstallPlugin("com.byted.pangle");
            com.bytedance.sdk.openadsdk.api.mb.hj("TTPluginManager", "AbstractMethodError, rollback to builtin version.");
        }
    }

    private static void mb(boolean z, String str) {
        TTPluginListener tTPluginListener = ox.get(str);
        StringBuilder sb = new StringBuilder();
        sb.append("Install dl plugin ");
        sb.append(str);
        sb.append(z ? " success" : " failed");
        sb.append(", need notify: ");
        sb.append(tTPluginListener != null);
        com.bytedance.sdk.openadsdk.api.mb.ox("TTPluginManager", sb.toString());
        Handler handler = b.get(str);
        if (z) {
            TTPluginListener tTPluginListener2 = je;
            if (!mb(tTPluginListener2, str) && (tTPluginListener == null || handler == null)) {
                return;
            }
            if (Zeus.loadPlugin(str)) {
                Plugin plugin = Zeus.getPlugin(str);
                ox(plugin);
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                if (tTPluginListener != null) {
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
                if (mb(tTPluginListener2, str)) {
                    tTPluginListener2.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                    je = null;
                }
            } else {
                b(str, 1002);
            }
        } else {
            b(str, 1003);
        }
        ox.remove(str);
        b.remove(str);
    }

    private static boolean mb(TTPluginListener tTPluginListener, String str) {
        if (tTPluginListener == null || tTPluginListener.packageName() == null) {
            return false;
        }
        return tTPluginListener.packageName().equals(str);
    }

    private void ox(Context context) {
        try {
            IZeusReporter iZeusReporter = new IZeusReporter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.u.1
                @Override // com.bytedance.pangle.log.IZeusReporter
                public void report(String str, JSONObject jSONObject) {
                    if (str == "load_finish" && jSONObject != null && "com.byted.pangle".endsWith(jSONObject.optString("plugin_package_name"))) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("duration", jSONObject.opt("duration"));
                            jSONObject2.put("message", jSONObject.opt("message"));
                            u.this.jb.put("zeus", jSONObject2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (u.u) {
                        hj.mb(str, jSONObject);
                    } else {
                        hj.b(str, jSONObject);
                    }
                }
            };
            GlobalParam globalParam = GlobalParam.getInstance();
            globalParam.setReporter(iZeusReporter);
            globalParam.setCheckPermission(false);
            globalParam.setDownloadDir(b(context));
            globalParam.setLogger(new mb());
            globalParam.setSignature("com.byted.pangle", "MIIDfTCCAmWgAwIBAgIEfRwYPjANBgkqhkiG9w0BAQsFADBvMQswCQYDVQQGEwJDTjEQMA4GA1UECBMHQmVpamluZzEQMA4GA1UEBxMHQmVpamluZzESMBAGA1UEChMJQnl0ZURhbmNlMQ8wDQYDVQQLEwZQYW5nbGUxFzAVBgNVBAMTDkNodWFuIFNoYW4gSmlhMB4XDTIxMTEwODA2MjQzOVoXDTQ2MTEwMjA2MjQzOVowbzELMAkGA1UEBhMCQ04xEDAOBgNVBAgTB0JlaWppbmcxEDAOBgNVBAcTB0JlaWppbmcxEjAQBgNVBAoTCUJ5dGVEYW5jZTEPMA0GA1UECxMGUGFuZ2xlMRcwFQYDVQQDEw5DaHVhbiBTaGFuIEppYTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIBKeRL+4mfCn1SLYv6OemfwwItkjlLPyqOEugkV6lanFTcZgLwEl5LIkL0y28UncPtMX1Mii6DzCdJ/plw7S9+RT/hYDneu339IKWojaU2qai/5FokHlQ0MMnYl5yry00ghVPsl1u+03cQA2ZnjIMiFhrBJpQzHt7IYvq2aEEMBcY8uT7iFoBI848e1mL1joVS2z02C3NliP7ZNARkXH+rTQAlCJulT5IZk+V/PTaKqzgNrkhsKh0/tBmU7m8u79x/xpgGsE19H18AgS4P/9/MDCRe2Z35boZeccaUy2MXCwv3djzUcDk3rRzQPYzdpyyRnrFMuhiKesc5VHgUMs9kCAwEAAaMhMB8wHQYDVR0OBBYEFENENrNWGzc2WhxdvhoMDs57U70zMA0GCSqGSIb3DQEBCwUAA4IBAQAHqDCrmvyBBmIGXwuL1rwS/Qv9ZJIZykBIaNMm+H1IfitCl4yXd9N2n+PjE0UZtxZ21UZOt9wAr+RFiSl5YRXqpt7WLARTy4YW3RiQ+wiL7bshzeSYBoSiC427Bfeq0WjwY0/jHlr8uouppyJOz++6U9hrYX2EW/6UjH5XlWiKQJ6b2ZzPcP8Xpg/TJn4tWvXJP6jw9kRRP2GmMttY78leWQst2QEZILmWJubXRLPj9O+qx2uP9oGTD4sc1vb9hzkOHBIHzGaalqLFbbGaeFpLFHoGTsnOfPTwUVKDZYmxbkcmR1bp7eYOW+nSQNMLn0FjDewZl5l37Sa/gz0WVHon");
            globalParam.setSignature("com.byted.csj.ext", "MIIDezCCAmOgAwIBAgIENkE1KDANBgkqhkiG9w0BAQsFADBtMQswCQYDVQQGEwI4NjEQMA4GA1UECBMHYmVpamluZzEQMA4GA1UEBxMHYmVpamluZzESMBAGA1UEChMJYnl0ZWRhbmNlMRIwEAYDVQQLEwlieXRlZGFuY2UxEjAQBgNVBAMTCWJ5dGVkYW5jZTAgFw0yMjExMDIwODI3MzlaGA8yMDUwMDMyMDA4MjczOVowbTELMAkGA1UEBhMCODYxEDAOBgNVBAgTB2JlaWppbmcxEDAOBgNVBAcTB2JlaWppbmcxEjAQBgNVBAoTCWJ5dGVkYW5jZTESMBAGA1UECxMJYnl0ZWRhbmNlMRIwEAYDVQQDEwlieXRlZGFuY2UwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCc9Z2F3xxOMX1qTXMy2aPmS9OSkqrp8C8bHwS1hkNVR4umKREuqOn73INNo+R706jaCVnlPwxDwWjtX6H74DE4CveivyM9f2wNC3yIyDW+5j7lW/keTQcOlGLDEJQv4O/6FbB/jNU6epjyNaNIZhgZcvTpgaSixbdyHzRTFmvMh+WovdVK/J9LnHOQ+pmPZj7NB6MQRGMUrPEotLHQca3cmnLrnPAaZQaVoaFE9lOt9syyqEuf361SprNIGDtbkJuX3EqV/QOKWFwZX94IS7ZGSvfyCojcD4kaUSbaSoZC7zEuBb7l69g+ZMrJ/v6wkm01wxsNNssUwF7k6Sp0zubbAgMBAAGjITAfMB0GA1UdDgQWBBSxk+gVdDco1dP65hP67qoKNlMEYDANBgkqhkiG9w0BAQsFAAOCAQEAfosExl/AYEbS2xqHBTHa28cvnp/SElUQuzW6aWLqkfk9cxmFSI/euUV3/eB8RN+U2X47Y05u6+XUxTv0tSSEtyXNawm0qWH8jkR4gZY38YqBChKjhea668oT5X3Uocrw7SYXO/BfI8SKPa0uI/U8Cyl3uctbmmq/pPUkd3mKAy+HgyJoThD6K0oyiADlygngUMVTv6Uvid4qPj/bBnxI+LvVeX4l1dxGqWkiafQW9sz+RbFdge3X2XsSH4eo01BsCwOYEv1lHO2FrbAtFNpnIsSqrERdFaAJZ3tlJmg9bA03png8A2AajEjkhaOhduJB8zkSlvHNpoQMIAS9WtkG/w==");
            globalParam.setSignature("com.byted.live.lite", "MIIDSTCCAjGgAwIBAgIEaLy5tzANBgkqhkiG9w0BAQsFADBVMQswCQYDVQQGEwIxMTEMMAoGA1UECBMDMTExMQ4wDAYDVQQHEwUxMTExMTEMMAoGA1UEChMDMTExMQwwCgYDVQQLEwMxMTExDDAKBgNVBAMTAzExMTAeFw0yMDEyMDMxMjQyMTJaFw00NTExMjcxMjQyMTJaMFUxCzAJBgNVBAYTAjExMQwwCgYDVQQIEwMxMTExDjAMBgNVBAcTBTExMTExMQwwCgYDVQQKEwMxMTExDDAKBgNVBAsTAzExMTEMMAoGA1UEAxMDMTExMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA45E52YdkJm4gPCXZq7KDoM1h6pgSswllC/CwDOmh8pDGvX4ROaYP1vr2biRlXMHg7G0iXpxWVdlTtx+4QFd3dC+cGJQk0f6apGo2n2RpMA0zIsSf0VO1a3GjWLei5INo+4RDdciqJ4jfsoqBIjZETRkky+UU4eO/oyrAwOu4KdMln3Bg3u7eHWU4kMFrXxrRruT3Q/9gzlO90yQa0CZPWVDrk6cGJtJwJGhWm+62S3U8D26HE++eGP7ve83QBDGtKqx7HpCAFWUiYBgXGq12H0amQDkKcPcr/EFCaBlombSgkN0t6zBX80m+wcUPC75IBTmMV/DT2dXcgjZ2I1JSCQIDAQABoyEwHzAdBgNVHQ4EFgQUPDyIeKI0KhZFPHyn36gMMIYrpukwDQYJKoZIhvcNAQELBQADggEBAHkl0DoCRwn+XKsDJE+wGMpBBqUDzL6DSOnJx4SNqb7YZZU0ThcDK7jY4If3QRkvMio6ODrVZc2U/m/Tc3VeMk5h2W2UZRUWHNH3k9Xe0720uL20ZeH2Y6IG4L5HG8kIbTbFtX3gJpPG/xAcez+CzyCFLWQAZt1N+csG0syWkXJ0Nryq8VrgSCyCXD1KzFxrOe+65wtu50Vi68Vlbk7BZe/G8Qm0RhKmxq5BPMBJ4uY3be+03Ba5qC//o1XQHOEAjrJKXcN5wqHdFZTkmuxVyIPogZOzx4JlNl0zOrYGDJxp7aZfKF9FkXQyF7x0Ns3mZEtjx/+flXRzAAU9MDhPr/0=");
            Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.u.2
                @Override // com.bytedance.pangle.ZeusPluginStateListener
                public void onPluginStateChange(final String str, final int i, Object... objArr) {
                    com.bytedance.sdk.openadsdk.api.mb.ox("TTPluginManager", str + " state changed, " + i);
                    if (i == 7) {
                        u.this.ox(str, i);
                    } else if (i == 6) {
                        com.bytedance.sdk.openadsdk.ox.mb.mb().mb(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.u.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                u.this.ox(str, i);
                            }
                        });
                    }
                }
            });
            Zeus.init((Application) context, true);
            this.ww = true;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.mb.mb("TTPluginManager", "Unexpected error for init zeus.", th);
            this.lz = th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ox(Plugin plugin) {
        if (plugin == null) {
            com.bytedance.sdk.openadsdk.api.mb.hj("TTPluginManager", "plugin is null.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 0);
        bundle.putString("plugin_pkg_name", plugin.mPkgName);
        bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, mb(plugin.getVersion()));
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ox(String str, int i) {
        if ("com.byted.pangle".equals(str) && i == 6) {
            this.ko.countDown();
        }
        mb(i == 6, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ox(com.bytedance.sdk.openadsdk.api.plugin.ox oxVar) {
        if (oxVar == null || oxVar.ox == null) {
            com.bytedance.sdk.openadsdk.api.mb.hj("TTPluginManager", "plugin config is null");
            return false;
        }
        boolean syncInstallPlugin = Zeus.syncInstallPlugin(oxVar.mPackageName, oxVar.ox.getAbsolutePath());
        mb(syncInstallPlugin, oxVar.mPackageName);
        return syncInstallPlugin;
    }

    public Bundle mb(String str, Bundle bundle) {
        String mb2 = mb(str);
        if (!TextUtils.isEmpty(mb2)) {
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, mb2);
        }
        ko.mb(str, bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(str, bundle);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, bundle2);
        return bundle3;
    }

    public BaseDexClassLoader mb(h hVar) throws Exception {
        if (!this.ww) {
            com.bytedance.sdk.openadsdk.api.mb.hj("TTPluginManager", "Zeus init failed.");
            throw new com.bytedance.sdk.openadsdk.api.plugin.b(4, this.lz);
        }
        if (!Zeus.isPluginInstalled("com.byted.pangle")) {
            try {
                this.ko.await(60000L, TimeUnit.MILLISECONDS);
                hVar.ox("wait_install_cost");
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.mb.hj("TTPluginManager", "Install wait time out");
                throw new com.bytedance.sdk.openadsdk.api.plugin.b(8, "install wait timeout");
            }
        }
        boolean z = false;
        if (Zeus.isPluginLoaded("com.byted.pangle") || Zeus.loadPlugin("com.byted.pangle")) {
            hj = Zeus.getPlugin("com.byted.pangle").mClassLoader;
            z = true;
        }
        hVar.ox("get_classloader_cost");
        Zeus.installFromDownloadDir();
        if (hj == null) {
            if (this.ko.getCount() != 0) {
                com.bytedance.sdk.openadsdk.api.mb.hj("TTPluginManager", "Install wait time out");
                throw new com.bytedance.sdk.openadsdk.api.plugin.b(8, "install wait timeout");
            } else if (z) {
                com.bytedance.sdk.openadsdk.api.mb.hj("TTPluginManager", "Get null after load");
                throw new com.bytedance.sdk.openadsdk.api.plugin.b(9, "Get null after load");
            }
        }
        hVar.ox("get_classloader_done");
        return hj;
    }

    public void mb() {
        u = true;
        hj.mb(new ArrayList());
    }

    public void mb(final TTPluginListener tTPluginListener) {
        if (!this.ww) {
            com.bytedance.sdk.openadsdk.api.mb.hj("TTPluginManager", "Zeus init failed.");
            if (tTPluginListener != null) {
                tTPluginListener.onPluginListener(1002, null, null, null);
                return;
            }
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.u.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.api.mb.ox("TTPluginManager", "Load plugin failed, caused by timeout.");
                tTPluginListener.onPluginListener(1001, null, null, null);
            }
        }, 180000L);
        String packageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
        StringBuilder sb = new StringBuilder();
        sb.append("Find plugin:");
        sb.append(plugin != null);
        com.bytedance.sdk.openadsdk.api.mb.ox("TTPluginManager", sb.toString());
        if (plugin == null) {
            ox.put(packageName, tTPluginListener);
            b.put(packageName, handler);
            return;
        }
        ox(plugin);
        handler.removeCallbacksAndMessages(null);
        tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
    }

    public JSONObject ox() {
        return this.jb;
    }

    public void ox(final TTPluginListener tTPluginListener) {
        com.bytedance.sdk.openadsdk.ox.mb.mb().mb(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.u.4
            @Override // java.lang.Runnable
            public void run() {
                String packageName = tTPluginListener.packageName();
                Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
                StringBuilder sb = new StringBuilder();
                sb.append("Find plugin:");
                sb.append(plugin != null);
                com.bytedance.sdk.openadsdk.api.mb.ox("TTPluginManager", sb.toString());
                if (plugin == null) {
                    TTPluginListener unused = u.je = tTPluginListener;
                    return;
                }
                u.ox(plugin);
                tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
            }
        });
    }
}
