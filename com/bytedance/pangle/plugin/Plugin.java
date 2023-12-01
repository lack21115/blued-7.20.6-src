package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.d.e;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.k;
import com.bytedance.pangle.util.l;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.tencent.open.GameAppOperation;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/plugin/Plugin.class */
public class Plugin {
    public static final int LIFE_INSTALLED = 2;
    public static final int LIFE_LOADED = 3;
    public static final int LIFE_PENDING = 1;
    private static final String TAG = "Plugin";
    private int mApiVersionCode;
    public final String mAppKey;
    public final String mAppSecretKey;
    public ZeusApplication mApplication;
    public PluginClassLoader mClassLoader;
    public PluginApplicationWrapper mHostApplication;
    public ApplicationInfo mHostApplicationInfoHookSomeField;
    private volatile boolean mInitialized;
    private String mInternalPath;
    private int mInternalVersionCode;
    public boolean mIsSupportLibIso;
    public int mMaxVersionCode;
    public int mMinVersionCode;
    public final boolean mOpenLoadClassOpt;
    private String mPackageDir;
    public String mPkgName;
    public final boolean mReInstallInternalPluginByMd5;
    public Resources mResources;
    public String mSignature;
    public final boolean mUnInstallPluginWhenHostChange;
    public final boolean mUseMemoryForActivityIntent;
    private int mVersionCode;
    public String response;
    public HashMap<String, ActivityInfo> pluginActivities = new HashMap<>();
    public HashMap<String, ServiceInfo> pluginServices = new HashMap<>();
    public HashMap<String, ActivityInfo> pluginReceiver = new HashMap<>();
    public HashMap<String, ProviderInfo> pluginProvider = new HashMap<>();
    private volatile int mLifeCycle = 1;
    public final List<String> mSharedHostSos = new ArrayList();
    final Object installLock = new Object();
    final Object initializeLock = new Object();

    public Plugin(JSONObject jSONObject) {
        this.mInternalVersionCode = -1;
        this.mMaxVersionCode = Integer.MAX_VALUE;
        this.mPkgName = jSONObject.getString("packageName");
        this.mMinVersionCode = jSONObject.optInt("minPluginVersion", 0);
        this.mMaxVersionCode = jSONObject.optInt("maxPluginVersion", Integer.MAX_VALUE);
        this.mApiVersionCode = jSONObject.getInt(TTLiveConstants.LIVE_API_VERSION_KEY);
        String signature = GlobalParam.getInstance().getSignature(this.mPkgName);
        this.mSignature = signature;
        if (TextUtils.isEmpty(signature)) {
            this.mSignature = jSONObject.optString(GameAppOperation.GAME_SIGNATURE, "");
        }
        this.mIsSupportLibIso = jSONObject.optBoolean("isSupportLibIsolate", false);
        this.mInternalPath = jSONObject.optString("internalPath", "");
        this.mInternalVersionCode = jSONObject.optInt("internalVersionCode", -1);
        this.mAppKey = jSONObject.optString("appKey", "");
        this.mAppSecretKey = jSONObject.optString("appSecretKey", "");
        this.mOpenLoadClassOpt = jSONObject.optBoolean("loadClassOpt", false);
        this.mUnInstallPluginWhenHostChange = jSONObject.optBoolean("unInstallPluginWhenHostChange", false);
        this.mUseMemoryForActivityIntent = jSONObject.optBoolean("useMemoryForActivityIntent", false);
        this.mReInstallInternalPluginByMd5 = jSONObject.optBoolean("reInstallInternalPluginByMd5", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("sharedHostSo");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.mSharedHostSos.add((String) optJSONArray.get(i));
            }
        }
        setupInternalPlugin();
    }

    private boolean checkValid(File file, String str, int i) {
        if (!TextUtils.equals(this.mPkgName, str)) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " package name not match !!!");
            return false;
        } else if (i < this.mMinVersionCode || i > this.mMaxVersionCode) {
            String format = String.format(" pluginApk ver[%s] not match plugin VerRange[%s, %s].", Integer.valueOf(i), Integer.valueOf(this.mMinVersionCode), Integer.valueOf(this.mMaxVersionCode));
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " " + format);
            return false;
        } else if (i < this.mVersionCode && isInstalled()) {
            String format2 = String.format(" pluginApk ver[%s] lower than installed plugin[%s].", Integer.valueOf(i), Integer.valueOf(this.mVersionCode));
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + format2);
            return false;
        } else if (file == null || !file.exists()) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk not exist.");
            return false;
        } else if (i == this.mVersionCode && l.a().f21506a.getString("IDENTITY_".concat(String.valueOf(str)), "").equals(com.bytedance.pangle.util.c.a(file)[0])) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk with the same identity has already installed.");
            return false;
        } else {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + ":" + i + " true");
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0120, code lost:
        if (r10 > r12) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean checkVersionValid(int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 505
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.plugin.Plugin.checkVersionValid(int, int, boolean):boolean");
    }

    private void deleteIfNeeded() {
        if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            if (l.a().f21506a.getBoolean("UNINSTALL__".concat(String.valueOf(this.mPkgName)), false)) {
                l a2 = l.a();
                String str = this.mPkgName;
                SharedPreferences.Editor edit = a2.f21506a.edit();
                edit.remove("UNINSTALL__".concat(String.valueOf(str)));
                edit.apply();
                deleteInstalledPlugin();
                ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPkgName);
            }
        }
    }

    private void deleteInstalledPlugin() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
        }
        new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.3
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                if (file.getName().matches("^version-(\\d+)$")) {
                    l.a().a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                    return false;
                }
                return false;
            }
        });
        g.a(this.mPackageDir);
    }

    private void deleteOtherExpiredVer(int i) {
        if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
            }
            final String concat = "version-".concat(String.valueOf(i));
            new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.4
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    if (file == null || concat.equals(file.getName()) || "data".equals(file.getName())) {
                        return false;
                    }
                    g.a(file.getAbsolutePath());
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteOtherExpired " + file.getAbsolutePath());
                    if (file.getName().matches("^version-(\\d+)$")) {
                        l.a().a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    private void installInternalPlugin() {
        if (!com.bytedance.pangle.d.d.a(Zeus.getAppApplication()) || this.mReInstallInternalPluginByMd5) {
            if (getVersion() > this.mInternalVersionCode) {
                return;
            }
        } else if (getVersion() >= this.mInternalVersionCode || TextUtils.isEmpty(this.mInternalPath)) {
            return;
        }
        e.a(new Runnable() { // from class: com.bytedance.pangle.plugin.Plugin.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    String b = com.bytedance.pangle.d.c.b();
                    File file = new File(b, Plugin.this.mPkgName + ".apk");
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin copyInternalPlugin " + Plugin.this.mInternalPath + " --> " + file.getAbsolutePath());
                    g.a(Zeus.getAppApplication().getAssets().open(Plugin.this.mInternalPath), new FileOutputStream(file));
                    if (file.exists()) {
                        PluginManager.getInstance().asyncInstall(Plugin.this.mPkgName, file);
                        return;
                    }
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + file.getAbsolutePath() + " is not exists.");
                } catch (Throwable th) {
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + th.getMessage());
                }
            }
        });
    }

    private int modifyResIfNeed(int i) {
        String b = com.bytedance.pangle.util.b.b(Zeus.getAppApplication());
        if (TextUtils.isEmpty(b) || !TextUtils.equals(l.a().b(this.mPkgName), b)) {
            if (this.mUnInstallPluginWhenHostChange || GlobalParam.getInstance().unInstallPluginWhenHostChange(this.mPkgName)) {
                ZeusLogger.d(ZeusLogger.TAG_INIT, "uninstall plugin by host update. " + this.mPkgName + " " + i);
                return 0;
            }
            ZeusLogger.d(ZeusLogger.TAG_INIT, "modifyRes by init. " + this.mPkgName + " " + i);
            int a2 = new com.bytedance.pangle.res.a.c().a(new File(com.bytedance.pangle.d.c.b(this.mPkgName, i)), true, new StringBuilder());
            if (a2 == 100 || a2 == 200) {
                return i;
            }
            return 0;
        }
        return i;
    }

    private void setupInternalPlugin() {
        if (l.a().f21506a.getInt(String.format(Locale.getDefault(), "OFFLINE_INTERNAL_%s", this.mPkgName), -1) == this.mApiVersionCode) {
            return;
        }
        if (!TextUtils.isEmpty(this.mInternalPath) && this.mInternalVersionCode != -1) {
            return;
        }
        try {
            String[] list = Zeus.getAppApplication().getAssets().list(com.bytedance.pangle.g.d);
            int length = list.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                String str = list[i2];
                if (str.startsWith(this.mPkgName + BridgeUtil.UNDERLINE_STR)) {
                    int a2 = k.a(str.split(BridgeUtil.UNDERLINE_STR)[1]);
                    if (a2 != -1) {
                        this.mInternalPath = com.bytedance.pangle.g.d + BridgeUtil.SPLIT_MARK + str;
                        this.mInternalVersionCode = a2;
                        return;
                    }
                }
                i = i2 + 1;
            }
        } catch (IOException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "setupInternalPlugin failed.", e);
        }
    }

    private void updateInstallStateFromMainProcess() {
        com.bytedance.pangle.c a2;
        try {
            if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication()) || this.mLifeCycle >= 2 || (a2 = com.bytedance.pangle.servermanager.b.a()) == null || !a2.a(this.mPkgName)) {
                return;
            }
            updateToInstalled(a2.b(this.mPkgName));
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("updateInstallStateFromMainProcess error. process = ");
            Zeus.getAppApplication();
            sb.append(com.bytedance.pangle.d.d.a());
            ZeusLogger.w(ZeusLogger.TAG_PPM, sb.toString(), th);
        }
    }

    private void updateToInstalled(int i) {
        this.mVersionCode = i;
        this.mLifeCycle = 2;
    }

    public int getApiVersionCode() {
        return this.mApiVersionCode;
    }

    public int getInstalledMaxVer() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
        }
        File[] listFiles = new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.2
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
        int i = -1;
        int i2 = -1;
        if (listFiles != null) {
            i2 = -1;
            if (listFiles.length > 0) {
                int length = listFiles.length;
                int i3 = 0;
                while (true) {
                    i2 = i;
                    if (i3 >= length) {
                        break;
                    }
                    int parseInt = Integer.parseInt(listFiles[i3].getName().split("-")[1]);
                    int i4 = i;
                    if (parseInt > i) {
                        i4 = i;
                        if (l.a().a(this.mPkgName, parseInt)) {
                            i4 = i;
                            if (new File(com.bytedance.pangle.d.c.b(this.mPkgName, parseInt)).exists()) {
                                i4 = parseInt;
                            }
                        }
                    }
                    i3++;
                    i = i4;
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + i2);
        return i2;
    }

    public int getInternalVersionCode() {
        return this.mInternalVersionCode;
    }

    public int getLifeCycle() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle;
    }

    public String getNativeLibraryDir() {
        int i = this.mVersionCode;
        return i > 0 ? com.bytedance.pangle.d.c.d(this.mPkgName, i) : com.bytedance.pangle.d.c.a(this.mPkgName);
    }

    public int getVersion() {
        updateInstallStateFromMainProcess();
        return this.mVersionCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        boolean z;
        l a2;
        String str;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
                int i = 0;
                if (!TextUtils.isEmpty(l.a().f21506a.getString("HOST_ABI_".concat(String.valueOf(this.mPkgName)), ""))) {
                    z = !TextUtils.equals(l.a().f21506a.getString("HOST_ABI_".concat(String.valueOf(this.mPkgName)), ""), Zeus.getHostAbi());
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils isHostAbiUpdate HOST_ABI=" + a2.f21506a.getString("HOST_ABI_".concat(String.valueOf(str)), "") + ", " + Zeus.getHostAbi() + ", result=" + z);
                } else {
                    z = false;
                }
                deleteIfNeeded();
                int installedMaxVer = getInstalledMaxVer();
                if (checkVersionValid(installedMaxVer, this.mApiVersionCode, z)) {
                    i = modifyResIfNeed(installedMaxVer);
                    updateToInstalled(i);
                }
                deleteOtherExpiredVer(i);
                ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin initPlugins result=".concat(String.valueOf(this)));
                l a3 = l.a();
                String str2 = this.mPkgName;
                SharedPreferences.Editor edit = a3.f21506a.edit();
                edit.putString("ROM_LAST_".concat(String.valueOf(str2)), Build.VERSION.INCREMENTAL);
                edit.apply();
                l a4 = l.a();
                String str3 = this.mPkgName;
                String string = a4.f21506a.getString("HOST_ABI_".concat(String.valueOf(str3)), "");
                SharedPreferences.Editor edit2 = a4.f21506a.edit();
                edit2.putString("HOST_ABI_".concat(String.valueOf(str3)), Zeus.getHostAbi());
                edit2.apply();
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + string + " --> " + Zeus.getHostAbi());
                l a5 = l.a();
                String str4 = this.mPkgName;
                String b = com.bytedance.pangle.util.b.b(Zeus.getAppApplication());
                String b2 = a5.b(str4);
                if (!TextUtils.equals(b2, b)) {
                    SharedPreferences.Editor edit3 = a5.f21506a.edit();
                    edit3.putString("HOST_IDENTITY_".concat(String.valueOf(str4)), b);
                    edit3.apply();
                }
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostIdentity(" + str4 + ") " + b2 + " --> " + b);
                l a6 = l.a();
                String str5 = this.mPkgName;
                int i2 = this.mApiVersionCode;
                int a7 = a6.a(str5);
                if (a7 != i2) {
                    SharedPreferences.Editor edit4 = a6.f21506a.edit();
                    edit4.putInt("PLUGIN_API_VERSION_".concat(String.valueOf(str5)), i2);
                    edit4.apply();
                }
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + a7 + " --> " + i2);
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
            installInternalPlugin();
        }
    }

    public void injectResponse(String str) {
        this.response = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean install(File file, com.bytedance.pangle.f.a.e eVar) {
        boolean z = false;
        try {
            StringBuilder sb = new StringBuilder("Plugin install from local file ");
            sb.append(file);
            sb.append(", ");
            sb.append(Thread.currentThread().getName());
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, sb.toString());
            String str = eVar.f21402a;
            int i = eVar.b;
            synchronized (this.installLock) {
                try {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=".concat(String.valueOf(this)));
                    boolean checkValid = checkValid(file, str, i);
                    z = false;
                    if (checkValid) {
                        z = b.a(file, str, i);
                        if (z) {
                            try {
                                String str2 = com.bytedance.pangle.util.c.a(new File(com.bytedance.pangle.d.c.b(this.mPkgName, i)))[0];
                                l a2 = l.a();
                                String str3 = this.mPkgName;
                                SharedPreferences.Editor edit = a2.f21506a.edit();
                                edit.putString("IDENTITY_".concat(String.valueOf(str3)), str2);
                                edit.apply();
                                l.a().a(this.mPkgName, i, true);
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPkgName + ":" + i + " identity=" + str2);
                                g.a(file);
                            } catch (Throwable th) {
                                th = th;
                                boolean z2 = z;
                                throw th;
                            }
                        }
                    }
                    synchronized (this) {
                        if (!checkValid) {
                            g.a(file);
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin deleting invalid " + str + ":" + i);
                        } else if (this.mLifeCycle == 3) {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin LIFE_LOADED, valid next restart " + str + ":" + i);
                        } else if (z) {
                            updateToInstalled(i);
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALLED " + str + ":" + i);
                        } else {
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + str + ":" + i);
                            g.a(file);
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin delete file by failedCount > 0 " + str + ":" + i);
                        }
                    }
                    boolean z3 = z;
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    z = false;
                }
            }
        } catch (Throwable th3) {
            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "Plugin IMPOSSIBLE!!!", th3);
            return z;
        }
    }

    public boolean isInstalled() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle >= 2;
    }

    public boolean isLoaded() {
        return this.mLifeCycle == 3;
    }

    public boolean isVersionInstalled(int i) {
        return l.a().a(this.mPkgName, i);
    }

    public void setApiCompatVersion(int i, int i2, int i3) {
        l a2 = l.a();
        String str = this.mPkgName;
        SharedPreferences.Editor edit = a2.f21506a.edit();
        edit.putInt("API_MIN_" + str + BridgeUtil.UNDERLINE_STR + i, i2);
        edit.putInt("API_MAX_" + str + BridgeUtil.UNDERLINE_STR + i, i3);
        edit.apply();
    }

    public void setLifeCycle(int i) {
        this.mLifeCycle = i;
    }

    public String toString() {
        return "Plugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + '}';
    }
}
