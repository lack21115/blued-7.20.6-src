package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPNativeLibraryLoader.class */
public class TPNativeLibraryLoader {
    private static final String DEFAULT_LIB_PLAYER_CORE_VERSION = "2.31.0.127.min";
    private static final String MAIN_PLAYER_CORE_VERSION = "2.31.0";
    private static final boolean mIsNeedLoadThirdPartiesAndFFmpeg = true;
    private static final String mLibIjkPrefix = "ijkhlscache-master";
    private static final boolean mLibNameHasArchSuffix = false;
    private static final String mLibPlayerCorePrefix = "tpcore-master";
    private static final String mLibThirdPartiesPrefix = "tpthirdparties-master";
    private static final int mPlayerCoreSupportMinAndroidAPILevel = 14;
    private static Object mIsLibLoadedLock = new Object();
    private static boolean mIsLibLoaded = false;
    private static ITPNativeLibraryExternalLoader mLibLoader = null;

    private static native String _getPlayerCoreVersion();

    public static String getLibVersion() {
        return getPlayerCoreVersion();
    }

    public static String getPlayerCoreVersion() {
        try {
            return _getPlayerCoreVersion();
        } catch (Throwable th) {
            TPNativeLog.printLog(2, "getPlayerCoreVersion: *.so is not loaded yet, return the hard-coded version number:2.31.0.127.min");
            return DEFAULT_LIB_PLAYER_CORE_VERSION;
        }
    }

    public static boolean isLibLoaded() {
        boolean z;
        try {
            loadLibIfNeeded(null);
        } catch (Throwable th) {
            TPNativeLog.printLog(4, "TPNativeLibraryLoader isLibLoaded error:" + th.getMessage());
        }
        synchronized (mIsLibLoadedLock) {
            z = mIsLibLoaded;
        }
        return z;
    }

    private static boolean isMatchJavaAndPlayerCore(String str, String str2) {
        TPNativeLog.printLog(2, "javaVersion:" + str + ", coreVersion:" + str2);
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            z = false;
            if (split.length >= 3) {
                if (split2.length >= 3) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= 3) {
                            z = true;
                            break;
                        } else if (!split[i2].matches(split2[i2])) {
                            return false;
                        } else {
                            i = i2 + 1;
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return z;
    }

    private static boolean loadLib(Context context) {
        String concat;
        TPNativeLog.printLog(2, "loadLib cpu arch:" + TPSystemInfo.getCpuArchitecture());
        int i = 3;
        if (TPSystemInfo.getApiLevel() >= 14) {
            boolean z = false;
            if (TPSystemInfo.getCpuArchitecture() != 3) {
                i = 4;
                z = false;
                if (TPSystemInfo.getCpuArchitecture() != 4) {
                    if (TPSystemInfo.getCpuArchitecture() == 0) {
                        return false;
                    }
                    String concat2 = mLibThirdPartiesPrefix.concat("");
                    ITPNativeLibraryExternalLoader iTPNativeLibraryExternalLoader = mLibLoader;
                    if (iTPNativeLibraryExternalLoader != null ? iTPNativeLibraryExternalLoader.loadLib(concat2, DEFAULT_LIB_PLAYER_CORE_VERSION) : loadLibDefault(concat2, context)) {
                        String concat3 = mLibPlayerCorePrefix.concat("");
                        ITPNativeLibraryExternalLoader iTPNativeLibraryExternalLoader2 = mLibLoader;
                        boolean loadLib = iTPNativeLibraryExternalLoader2 != null ? iTPNativeLibraryExternalLoader2.loadLib(concat3, DEFAULT_LIB_PLAYER_CORE_VERSION) : loadLibDefault(concat3, context);
                        z = loadLib;
                        if (loadLib) {
                            String playerCoreVersion = getPlayerCoreVersion();
                            z = isMatchJavaAndPlayerCore(MAIN_PLAYER_CORE_VERSION, playerCoreVersion);
                            if (!z) {
                                TPNativeLog.printLog(4, "nativePlayerCoreVer(" + playerCoreVersion + ") doesn't match javaPlayerCoreVer:(2.31.0)");
                            }
                        }
                        String concat4 = mLibIjkPrefix.concat("");
                        ITPNativeLibraryExternalLoader iTPNativeLibraryExternalLoader3 = mLibLoader;
                        if (iTPNativeLibraryExternalLoader3 != null) {
                            iTPNativeLibraryExternalLoader3.loadLib(concat4, DEFAULT_LIB_PLAYER_CORE_VERSION);
                        } else {
                            loadLibDefault(concat4, context);
                        }
                        if (z) {
                            TPNativeLog.printLog(2, "Native libs loaded successfully");
                            return z;
                        }
                        TPNativeLog.printLog(4, "Failed to load native libs");
                    } else {
                        concat = "Failed to load ".concat(String.valueOf(concat2));
                    }
                }
            }
            return z;
        }
        concat = "so load failed, current api level " + TPSystemInfo.getApiLevel() + " is less than 14";
        TPNativeLog.printLog(i, concat);
        return false;
    }

    private static boolean loadLibDefault(String str, Context context) {
        boolean z = false;
        try {
            TPNativeLog.printLog(2, "loadLibDefault loading ".concat(String.valueOf(str)));
            System.loadLibrary(str);
            StringBuilder sb = new StringBuilder("loadLibDefault ");
            sb.append(str);
            sb.append(" loaded successfully");
            z = true;
            TPNativeLog.printLog(2, sb.toString());
            z = true;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, "loadLibDefault failed to load " + str + "," + th.getMessage());
        }
        boolean z2 = z;
        if (!z) {
            z2 = z;
            if (context != null) {
                z2 = z;
                if (TPSystemInfo.getCpuArchitecture() >= 6) {
                    z2 = z;
                    try {
                        StringBuilder sb2 = new StringBuilder("loadLibDefault try to load ");
                        boolean z3 = z;
                        sb2.append(str);
                        boolean z4 = z;
                        sb2.append(" from APK");
                        boolean z5 = z;
                        TPNativeLog.printLog(2, sb2.toString());
                        boolean z6 = z;
                        boolean load = TPLoadLibFromApk.load(str, TPNativeLibraryLoader.class.getClassLoader(), context);
                        if (load) {
                            StringBuilder sb3 = new StringBuilder("loadLibDefault loaded ");
                            sb3.append(str);
                            sb3.append(" from APK successfully");
                            TPNativeLog.printLog(2, sb3.toString());
                            return load;
                        }
                        StringBuilder sb4 = new StringBuilder("loadLibDefault loaded ");
                        sb4.append(str);
                        sb4.append(" from APK failed");
                        TPNativeLog.printLog(4, sb4.toString());
                        return load;
                    } catch (Throwable th2) {
                        TPNativeLog.printLog(4, "loadLibDefault loaded " + str + " from APK failed," + th2.getMessage());
                    }
                }
            }
        }
        return z2;
    }

    public static void loadLibIfNeeded(Context context) {
        synchronized (mIsLibLoadedLock) {
            if (!mIsLibLoaded) {
                boolean loadLib = loadLib(context);
                mIsLibLoaded = loadLib;
                TPNativeLog.printLog(2, loadLib ? "TPNativeLibraryLoader load lib successfully" : "TPNativeLibraryLoader load lib failed");
            }
            if (!mIsLibLoaded) {
                throw new UnsupportedOperationException("Failed to load native library");
            }
        }
    }

    public static void setLibLoader(ITPNativeLibraryExternalLoader iTPNativeLibraryExternalLoader) {
        mLibLoader = iTPNativeLibraryExternalLoader;
    }
}
