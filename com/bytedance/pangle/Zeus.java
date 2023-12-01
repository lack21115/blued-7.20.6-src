package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.apm.ApmUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.util.HashMap;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/Zeus.class */
public class Zeus {
    private static Application sApplication;
    private static final HashMap<String, ProviderInfo> serverManagerHashMap = new HashMap<>();
    static final Object wait = new Object();
    private static volatile boolean onPrivacyAgreed = false;

    public static void addExternalAssetsForPlugin(String str, String str2) {
        Plugin plugin;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (plugin = getPlugin(str)) == null || plugin.mResources == null) {
            return;
        }
        new com.bytedance.pangle.res.a().a(plugin.mResources.getAssets(), str2, false);
    }

    public static void addPluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        h a2 = h.a();
        if (zeusPluginEventCallback != null) {
            synchronized (a2.f21430c) {
                a2.f21430c.add(zeusPluginEventCallback);
            }
        }
    }

    public static void fetchPlugin(final String str) {
        com.bytedance.pangle.download.a a2 = com.bytedance.pangle.download.a.a();
        if (com.bytedance.pangle.d.d.a(getAppApplication())) {
            if (!GlobalParam.getInstance().autoFetch()) {
                com.bytedance.pangle.download.b.a();
                return;
            }
            final com.bytedance.pangle.download.b a3 = com.bytedance.pangle.download.b.a();
            Runnable runnable = a3.f21381c.get(str);
            if (runnable != null) {
                a3.b.removeCallbacks(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: com.bytedance.pangle.download.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (com.bytedance.pangle.util.b.a(Zeus.getAppApplication())) {
                        b.this.b.postDelayed(this, 1800000L);
                    }
                }
            };
            a3.f21381c.put(str, runnable2);
            a3.b.postDelayed(runnable2, 1800000L);
            com.bytedance.pangle.download.b.a();
            if (a2.f21378a.contains(str)) {
                return;
            }
            a2.f21378a.add(str);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0021 -> B:6:0x001d). Please submit an issue!!! */
    public static Application getAppApplication() {
        if (sApplication == null) {
            b.a();
            try {
                sApplication = (Application) MethodUtils.invokeMethod(com.bytedance.pangle.d.a.a(), "getApplication", new Object[0]);
            } catch (Throwable th) {
            }
        }
        return sApplication;
    }

    public static String getHostAbi() {
        return com.bytedance.pangle.d.b.a();
    }

    public static int getHostAbiBit() {
        return com.bytedance.pangle.d.b.b();
    }

    public static int getInstalledPluginVersion(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            return -1;
        }
        int version = plugin.getVersion();
        ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, " getInstalledPluginVersion, " + str + " = " + version);
        return version;
    }

    public static int getMaxInstallVer(String str) {
        if (com.bytedance.pangle.d.d.a(getAppApplication())) {
            return getPlugin(str).getInstalledMaxVer();
        }
        return -1;
    }

    public static Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }

    public static Plugin getPlugin(String str, boolean z) {
        return PluginManager.getInstance().getPlugin(str, z);
    }

    public static HashMap<String, ProviderInfo> getServerManagerHashMap() {
        return serverManagerHashMap;
    }

    public static String getZeusDid() {
        String did = GlobalParam.getInstance().getDid();
        return !TextUtils.isEmpty(did) ? did : ApmUtils.getApmInstance().getDid();
    }

    public static boolean hasInit() {
        return h.a().f21429a;
    }

    public static void init(Application application, boolean z) {
        h.a().a(application, z);
        synchronized (wait) {
            wait.notifyAll();
        }
    }

    public static void installFromDownloadDir() {
        if (com.bytedance.pangle.d.d.a(getAppApplication())) {
            PluginManager.getInstance().installFromDownloadDir();
        }
    }

    public static boolean isPluginInstalled(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        return plugin != null && plugin.isInstalled();
    }

    public static boolean isPluginLoaded(String str) {
        return PluginManager.getInstance().isLoaded(str);
    }

    public static boolean loadPlugin(String str) {
        return PluginManager.getInstance().loadPlugin(str);
    }

    public static void onPrivacyAgreed() {
        synchronized (Zeus.class) {
            try {
                if (onPrivacyAgreed) {
                    return;
                }
                ApmUtils.getApmInstance().init();
                onPrivacyAgreed = true;
            } finally {
            }
        }
    }

    public static void registerPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        h.a().b.add(zeusPluginStateListener);
    }

    public static void removePluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        h a2 = h.a();
        if (zeusPluginEventCallback != null) {
            synchronized (a2.f21430c) {
                a2.f21430c.remove(zeusPluginEventCallback);
            }
        }
    }

    public static void setAllowDownloadPlugin(String str, int i, boolean z) {
        PluginManager.getInstance().setAllowDownloadPlugin(str, i, z);
    }

    public static void setAppContext(Application application) {
        if (application != null && TextUtils.equals(application.getClass().getSimpleName(), "PluginApplicationWrapper")) {
            try {
                sApplication = (Application) FieldUtils.readField(application, "mOriginApplication");
                return;
            } catch (Throwable th) {
            }
        }
        sApplication = application;
    }

    public static boolean syncInstallPlugin(String str, String str2) {
        c a2 = com.bytedance.pangle.servermanager.b.a();
        if (a2 != null) {
            try {
                return a2.a(str, str2);
            } catch (RemoteException e) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "syncInstallPlugin error.", e);
                return false;
            }
        }
        return false;
    }

    public static void triggerBgDexOpt() {
        com.bytedance.pangle.e.f.a();
    }

    public static void unInstallPlugin(String str) {
        PluginManager.getInstance().unInstallPackage(str);
    }

    public static void unregisterPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        h a2 = h.a();
        if (a2.b != null) {
            a2.b.remove(zeusPluginStateListener);
        }
    }

    public static boolean waitInit(int i) {
        if (h.a().f21429a) {
            return true;
        }
        synchronized (wait) {
            if (!h.a().f21429a) {
                try {
                    if (i == -1) {
                        wait.wait();
                    } else {
                        wait.wait(i);
                    }
                } catch (InterruptedException e) {
                }
            }
        }
        return h.a().f21429a;
    }
}
