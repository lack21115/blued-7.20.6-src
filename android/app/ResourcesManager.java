package android.app;

import android.content.Context;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.ThemeUtils;
import android.content.res.AssetManager;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.ResourcesKey;
import android.content.res.ThemeConfig;
import android.graphics.Typeface;
import android.hardware.display.DisplayManagerGlobal;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.DisplayMetrics;
import android.util.Slog;
import android.view.Display;
import android.view.DisplayAdjustments;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/app/ResourcesManager.class */
public class ResourcesManager {
    static final boolean DEBUG_CACHE = false;
    static final boolean DEBUG_STATS = true;
    private static final int NUM_DEFAULT_ASSETS = 2;
    static final String TAG = "ResourcesManager";
    static IPackageManager sPackageManager;
    private static ResourcesManager sResourcesManager;
    CompatibilityInfo mResCompatibilityInfo;
    Configuration mResConfiguration;
    final ArrayMap<ResourcesKey, WeakReference<Resources>> mActiveResources = new ArrayMap<>();
    final ArrayMap<DisplayAdjustments, DisplayMetrics> mDefaultDisplayMetrics = new ArrayMap<>();
    final Configuration mTmpConfig = new Configuration();

    private boolean attachCommonAssets(AssetManager assetManager, ThemeConfig themeConfig) {
        String basePackageName;
        PackageInfo packageInfo;
        int basePackageCount = assetManager.getBasePackageCount();
        if (basePackageCount > 2) {
            basePackageName = assetManager.getBasePackageName(2);
        } else if (basePackageCount != 2) {
            return false;
        } else {
            basePackageName = assetManager.getBasePackageName(0);
        }
        try {
            packageInfo = getPackageManager().getPackageInfo(themeConfig.getOverlayPkgNameForApp(basePackageName), 0, UserHandle.getCallingUserId());
        } catch (RemoteException e) {
            packageInfo = null;
        }
        if (packageInfo == null || packageInfo.applicationInfo == null) {
            return false;
        }
        String commonPackageName = ThemeUtils.getCommonPackageName(packageInfo.applicationInfo.packageName);
        if (commonPackageName == null || commonPackageName.isEmpty()) {
            return true;
        }
        int addCommonOverlayPath = assetManager.addCommonOverlayPath(packageInfo.applicationInfo.publicSourceDir, ThemeUtils.getTargetCacheDir("common", packageInfo) + "/resources.apk", ThemeUtils.COMMON_RES_PATH);
        if (addCommonOverlayPath != 0) {
            assetManager.setCommonResCookie(addCommonOverlayPath);
            assetManager.setCommonResPackageName(commonPackageName);
            return true;
        }
        return true;
    }

    private boolean attachIconAssets(AssetManager assetManager, ThemeConfig themeConfig) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(themeConfig.getIconPackPkgName(), 0, UserHandle.getCallingUserId());
        } catch (RemoteException e) {
        }
        if (packageInfo == null || packageInfo.applicationInfo == null) {
            return false;
        }
        String iconPackPkgName = themeConfig.getIconPackPkgName();
        if (iconPackPkgName == null || iconPackPkgName.isEmpty()) {
            return true;
        }
        String str = packageInfo.applicationInfo.publicSourceDir;
        String str2 = ThemeUtils.ICONS_PATH;
        String iconPackDir = ThemeUtils.getIconPackDir(iconPackPkgName);
        String str3 = iconPackDir + "/resources.arsc";
        String str4 = iconPackDir + "/resources.apk";
        if (packageInfo.isLegacyIconPackApk) {
            str2 = "";
            str4 = "";
        }
        int addIconPath = assetManager.addIconPath(str, str4, str2, 98);
        if (addIconPath != 0) {
            assetManager.setIconPackCookie(addIconPath);
            assetManager.setIconPackageName(iconPackPkgName);
            return true;
        }
        return true;
    }

    private boolean attachThemeAssets(AssetManager assetManager, ThemeConfig themeConfig) {
        String basePackageName;
        PackageInfo packageInfo;
        PackageInfo packageInfo2 = null;
        String str = null;
        int basePackageCount = assetManager.getBasePackageCount();
        if (basePackageCount > 2) {
            basePackageName = assetManager.getBasePackageName(2);
            str = assetManager.getBaseResourcePackageName(2);
        } else if (basePackageCount != 2) {
            return false;
        } else {
            basePackageName = assetManager.getBasePackageName(0);
        }
        PackageInfo packageInfo3 = null;
        try {
            PackageInfo packageInfo4 = getPackageManager().getPackageInfo(themeConfig.getOverlayPkgNameForApp(basePackageName), 0, UserHandle.getCallingUserId());
            PackageInfo packageInfo5 = getPackageManager().getPackageInfo(basePackageName, 0, UserHandle.getCallingUserId());
            PackageInfo packageInfo6 = packageInfo5;
            if (packageInfo5 == null) {
                packageInfo6 = packageInfo5;
                if (str != null) {
                    packageInfo6 = getPackageManager().getPackageInfo(str, 0, UserHandle.getCallingUserId());
                }
            }
            packageInfo3 = packageInfo6;
            packageInfo2 = packageInfo4;
            packageInfo2 = packageInfo4;
            packageInfo3 = packageInfo6;
            packageInfo = getPackageManager().getPackageInfo("android", 0, UserHandle.getCallingUserId());
        } catch (RemoteException e) {
            packageInfo = null;
        }
        if (packageInfo2 == null || packageInfo2.applicationInfo == null || packageInfo3 == null || packageInfo3.applicationInfo == null || packageInfo == null || packageInfo.applicationInfo == null || packageInfo2.mOverlayTargets == null) {
            return false;
        }
        String str2 = packageInfo2.packageName;
        String str3 = packageInfo2.applicationInfo.publicSourceDir;
        if (!packageInfo3.isThemeApk && packageInfo2.mOverlayTargets.contains(basePackageName)) {
            int addOverlayPath = assetManager.addOverlayPath(ThemeUtils.getIdmapPath(packageInfo3.packageName, packageInfo2.packageName), str3, ThemeUtils.getTargetCacheDir(packageInfo3.packageName, packageInfo2) + "/resources.apk", packageInfo3.applicationInfo.sourceDir, ThemeUtils.getOverlayPathToTarget(basePackageName));
            if (addOverlayPath != 0) {
                assetManager.setThemePackageName(str2);
                assetManager.addThemeCookie(addOverlayPath);
            }
        }
        if (packageInfo3.isThemeApk || "android".equals(basePackageName) || !packageInfo2.mOverlayTargets.contains("android")) {
            return true;
        }
        String targetCacheDir = ThemeUtils.getTargetCacheDir(packageInfo.packageName, packageInfo2);
        String overlayPathToTarget = ThemeUtils.getOverlayPathToTarget(packageInfo.packageName);
        int addOverlayPath2 = assetManager.addOverlayPath(ThemeUtils.getIdmapPath("android", packageInfo2.packageName), str3, targetCacheDir + "/resources.apk", packageInfo.applicationInfo.publicSourceDir, overlayPathToTarget);
        if (addOverlayPath2 != 0) {
            assetManager.setThemePackageName(str2);
            assetManager.addThemeCookie(addOverlayPath2);
            return true;
        }
        return true;
    }

    private void detachThemeAssets(AssetManager assetManager) {
        String themePackageName = assetManager.getThemePackageName();
        String iconPackageName = assetManager.getIconPackageName();
        String commonResPackageName = assetManager.getCommonResPackageName();
        if (!TextUtils.isEmpty(iconPackageName) && assetManager.getIconPackCookie() > 0) {
            assetManager.removeOverlayPath(iconPackageName, assetManager.getIconPackCookie());
            assetManager.setIconPackageName(null);
            assetManager.setIconPackCookie(0);
        }
        if (!TextUtils.isEmpty(commonResPackageName) && assetManager.getCommonResCookie() > 0) {
            assetManager.removeOverlayPath(commonResPackageName, assetManager.getCommonResCookie());
            assetManager.setCommonResPackageName(null);
            assetManager.setCommonResCookie(0);
        }
        ArrayList<Integer> themeCookies = assetManager.getThemeCookies();
        if (!TextUtils.isEmpty(themePackageName) && !themeCookies.isEmpty()) {
            int size = themeCookies.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                assetManager.removeOverlayPath(themePackageName, themeCookies.get(i).intValue());
                size = i;
            }
        }
        assetManager.getThemeCookies().clear();
        assetManager.setThemePackageName(null);
    }

    public static ResourcesManager getInstance() {
        ResourcesManager resourcesManager;
        synchronized (ResourcesManager.class) {
            try {
                if (sResourcesManager == null) {
                    sResourcesManager = new ResourcesManager();
                }
                resourcesManager = sResourcesManager;
            } catch (Throwable th) {
                throw th;
            }
        }
        return resourcesManager;
    }

    public static IPackageManager getPackageManager() {
        if (sPackageManager != null) {
            return sPackageManager;
        }
        sPackageManager = IPackageManager.Stub.asInterface(ServiceManager.getService("package"));
        return sPackageManager;
    }

    private ThemeConfig getThemeConfig() {
        Configuration configuration = getConfiguration();
        if (configuration != null) {
            return configuration.themeConfig;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0096, code lost:
        if (r0.get(r0.icon) == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setActivityIcons(android.content.res.Resources r6) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.ResourcesManager.setActivityIcons(android.content.res.Resources):void");
    }

    public boolean applyCompatConfiguration(int i, Configuration configuration) {
        if (this.mResCompatibilityInfo == null || this.mResCompatibilityInfo.supportsScreen()) {
            return false;
        }
        this.mResCompatibilityInfo.applyToConfiguration(i, configuration);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
        if (r5.mResCompatibilityInfo.equals(r7) == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean applyConfigurationToResourcesLocked(android.content.res.Configuration r6, android.content.res.CompatibilityInfo r7) {
        /*
            Method dump skipped, instructions count: 466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.ResourcesManager.applyConfigurationToResourcesLocked(android.content.res.Configuration, android.content.res.CompatibilityInfo):boolean");
    }

    final void applyNonDefaultDisplayMetricsToConfigurationLocked(DisplayMetrics displayMetrics, Configuration configuration) {
        configuration.touchscreen = 1;
        configuration.densityDpi = displayMetrics.densityDpi;
        configuration.screenWidthDp = (int) (displayMetrics.widthPixels / displayMetrics.density);
        configuration.screenHeightDp = (int) (displayMetrics.heightPixels / displayMetrics.density);
        int resetScreenLayout = Configuration.resetScreenLayout(configuration.screenLayout);
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            configuration.orientation = 2;
            configuration.screenLayout = Configuration.reduceScreenLayout(resetScreenLayout, configuration.screenWidthDp, configuration.screenHeightDp);
        } else {
            configuration.orientation = 1;
            configuration.screenLayout = Configuration.reduceScreenLayout(resetScreenLayout, configuration.screenHeightDp, configuration.screenWidthDp);
        }
        configuration.smallestScreenWidthDp = configuration.screenWidthDp;
        configuration.compatScreenWidthDp = configuration.screenWidthDp;
        configuration.compatScreenHeightDp = configuration.screenHeightDp;
        configuration.compatSmallestScreenWidthDp = configuration.smallestScreenWidthDp;
    }

    public void flushDisplayMetricsLocked() {
        this.mDefaultDisplayMetrics.clear();
    }

    public Configuration getConfiguration() {
        return this.mResConfiguration;
    }

    public DisplayMetrics getDisplayMetricsLocked(int i) {
        return getDisplayMetricsLocked(i, DisplayAdjustments.DEFAULT_DISPLAY_ADJUSTMENTS);
    }

    public DisplayMetrics getDisplayMetricsLocked(int i, DisplayAdjustments displayAdjustments) {
        boolean z = i == 0;
        DisplayMetrics displayMetrics = z ? this.mDefaultDisplayMetrics.get(displayAdjustments) : null;
        if (displayMetrics != null) {
            return displayMetrics;
        }
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        DisplayManagerGlobal displayManagerGlobal = DisplayManagerGlobal.getInstance();
        if (displayManagerGlobal == null) {
            displayMetrics2.setToDefaults();
            return displayMetrics2;
        }
        if (z) {
            this.mDefaultDisplayMetrics.put(displayAdjustments, displayMetrics2);
        }
        Display compatibleDisplay = displayManagerGlobal.getCompatibleDisplay(i, displayAdjustments);
        if (compatibleDisplay != null) {
            compatibleDisplay.getMetrics(displayMetrics2);
        } else {
            displayMetrics2.setToDefaults();
        }
        return displayMetrics2;
    }

    public Resources getTopLevelResources(String str, String[] strArr, String[] strArr2, String[] strArr3, int i, String str2, Configuration configuration, CompatibilityInfo compatibilityInfo, IBinder iBinder, Context context, boolean z) {
        Configuration configuration2;
        float f = compatibilityInfo.applicationScale;
        ThemeConfig themeConfig = getThemeConfig();
        ResourcesKey resourcesKey = new ResourcesKey(str, i, configuration, f, z, themeConfig, iBinder);
        synchronized (this) {
            WeakReference<Resources> weakReference = this.mActiveResources.get(resourcesKey);
            Resources resources = weakReference != null ? weakReference.get() : null;
            if (resources == null || !resources.getAssets().isUpToDate()) {
                AssetManager assetManager = new AssetManager();
                assetManager.setAppName(str2);
                assetManager.setThemeSupport(z);
                if (str == null || assetManager.addAssetPath(str) != 0) {
                    if (strArr != null) {
                        int length = strArr.length;
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= length) {
                                break;
                            } else if (assetManager.addAssetPath(strArr[i3]) == 0) {
                                return null;
                            } else {
                                i2 = i3 + 1;
                            }
                        }
                    }
                    if (strArr2 != null) {
                        int length2 = strArr2.length;
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= length2) {
                                break;
                            }
                            assetManager.addOverlayPath(strArr2[i5], null, null, null, null);
                            i4 = i5 + 1;
                        }
                    }
                    if (strArr3 != null) {
                        int length3 = strArr3.length;
                        int i6 = 0;
                        while (true) {
                            int i7 = i6;
                            if (i7 >= length3) {
                                break;
                            }
                            String str3 = strArr3[i7];
                            if (assetManager.addAssetPath(str3) == 0) {
                                Slog.w(TAG, "Asset path '" + str3 + "' does not exist or contains no resources.");
                            }
                            i6 = i7 + 1;
                        }
                    }
                    DisplayMetrics displayMetricsLocked = getDisplayMetricsLocked(i);
                    boolean z2 = i == 0;
                    boolean hasOverrideConfiguration = resourcesKey.hasOverrideConfiguration();
                    if (!z2 || hasOverrideConfiguration) {
                        Configuration configuration3 = new Configuration(getConfiguration());
                        if (!z2) {
                            applyNonDefaultDisplayMetricsToConfigurationLocked(displayMetricsLocked, configuration3);
                        }
                        configuration2 = configuration3;
                        if (hasOverrideConfiguration) {
                            configuration3.updateFrom(resourcesKey.mOverrideConfiguration);
                            configuration2 = configuration3;
                        }
                    } else {
                        configuration2 = getConfiguration();
                    }
                    boolean z3 = false;
                    if (configuration2 != null) {
                        z3 = false;
                        if (!context.getPackageManager().isSafeMode()) {
                            ThemeConfig themeConfig2 = themeConfig;
                            if (themeConfig == null) {
                                try {
                                    themeConfig2 = ThemeConfig.getBootTheme(context.getContentResolver());
                                } catch (Exception e) {
                                    Slog.d(TAG, "ThemeConfig.getBootTheme failed, falling back to system theme", e);
                                    themeConfig2 = ThemeConfig.getSystemTheme();
                                }
                            }
                            if (z) {
                                z3 = false;
                                if (themeConfig2 != null) {
                                    attachThemeAssets(assetManager, themeConfig2);
                                    attachCommonAssets(assetManager, themeConfig2);
                                    z3 = attachIconAssets(assetManager, themeConfig2);
                                }
                            } else {
                                z3 = false;
                                if (themeConfig2 != null) {
                                    z3 = false;
                                    if (!ThemeConfig.SYSTEM_DEFAULT.equals(themeConfig2.getFontPkgName())) {
                                        Typeface.recreateDefaults(true);
                                        z3 = false;
                                    }
                                }
                            }
                        }
                    }
                    Resources resources2 = new Resources(assetManager, displayMetricsLocked, configuration2, compatibilityInfo, iBinder);
                    if (z3) {
                        setActivityIcons(resources2);
                    }
                    synchronized (this) {
                        WeakReference<Resources> weakReference2 = this.mActiveResources.get(resourcesKey);
                        Resources resources3 = weakReference2 != null ? weakReference2.get() : null;
                        if (resources3 == null || !resources3.getAssets().isUpToDate()) {
                            this.mActiveResources.put(resourcesKey, new WeakReference<>(resources2));
                            return resources2;
                        }
                        resources2.getAssets().close();
                        return resources3;
                    }
                }
                return null;
            }
            return resources;
        }
    }

    public Resources getTopLevelThemedResources(String str, int i, String str2, String str3, Configuration configuration, CompatibilityInfo compatibilityInfo, IBinder iBinder, boolean z) {
        Configuration configuration2;
        ThemeConfig.Builder builder = new ThemeConfig.Builder();
        builder.defaultOverlay(str3);
        builder.defaultIcon(str3);
        builder.defaultFont(str3);
        ThemeConfig build = builder.build();
        ResourcesKey resourcesKey = new ResourcesKey(str, i, configuration, compatibilityInfo.applicationScale, z, build, iBinder);
        synchronized (this) {
            WeakReference<Resources> weakReference = this.mActiveResources.get(resourcesKey);
            Resources resources = weakReference != null ? weakReference.get() : null;
            if (resources == null || !resources.getAssets().isUpToDate()) {
                AssetManager assetManager = new AssetManager();
                assetManager.setAppName(str2);
                assetManager.setThemeSupport(z);
                if (assetManager.addAssetPath(str) == 0) {
                    return null;
                }
                DisplayMetrics displayMetricsLocked = getDisplayMetricsLocked(i);
                boolean z2 = i == 0;
                boolean hasOverrideConfiguration = resourcesKey.hasOverrideConfiguration();
                if (!z2 || hasOverrideConfiguration) {
                    Configuration configuration3 = new Configuration(getConfiguration());
                    if (!z2) {
                        applyNonDefaultDisplayMetricsToConfigurationLocked(displayMetricsLocked, configuration3);
                    }
                    configuration2 = configuration3;
                    if (hasOverrideConfiguration) {
                        configuration3.updateFrom(resourcesKey.mOverrideConfiguration);
                        configuration2 = configuration3;
                    }
                } else {
                    configuration2 = getConfiguration();
                }
                boolean z3 = false;
                if (z) {
                    attachThemeAssets(assetManager, build);
                    attachCommonAssets(assetManager, build);
                    z3 = attachIconAssets(assetManager, build);
                }
                Resources resources2 = new Resources(assetManager, displayMetricsLocked, configuration2, compatibilityInfo, iBinder);
                if (z3) {
                    setActivityIcons(resources2);
                }
                synchronized (this) {
                    WeakReference<Resources> weakReference2 = this.mActiveResources.get(resourcesKey);
                    Resources resources3 = weakReference2 != null ? weakReference2.get() : null;
                    if (resources3 == null || !resources3.getAssets().isUpToDate()) {
                        this.mActiveResources.put(resourcesKey, new WeakReference<>(resources2));
                        return resources2;
                    }
                    resources2.getAssets().close();
                    return resources3;
                }
            }
            return resources;
        }
    }
}
