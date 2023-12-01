package com.tencent.tinker.lib.tinker;

import android.content.Intent;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/tinker/TinkerApplicationHelper.class */
public class TinkerApplicationHelper {
    private static final String TAG = "Tinker.TinkerApplicationHelper";

    public static void cleanPatch(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        ShareTinkerInternals.cleanPatch(applicationLike.getApplication());
    }

    public static String getCurrentVersion(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
        if (tinkerResultIntent == null) {
            return null;
        }
        String stringExtra = ShareIntentUtil.getStringExtra(tinkerResultIntent, ShareIntentUtil.INTENT_PATCH_OLD_VERSION);
        String stringExtra2 = ShareIntentUtil.getStringExtra(tinkerResultIntent, ShareIntentUtil.INTENT_PATCH_NEW_VERSION);
        boolean isInMainProcess = ShareTinkerInternals.isInMainProcess(applicationLike.getApplication());
        if (stringExtra == null || stringExtra2 == null) {
            return null;
        }
        return isInMainProcess ? stringExtra2 : stringExtra;
    }

    public static HashMap<String, String> getLoadDexesAndMd5(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
        if (tinkerResultIntent != null && ShareIntentUtil.getIntentReturnCode(tinkerResultIntent) == 0) {
            return ShareIntentUtil.getIntentPatchDexPaths(tinkerResultIntent);
        }
        return null;
    }

    public static HashMap<String, String> getLoadLibraryAndMd5(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
        if (tinkerResultIntent != null && ShareIntentUtil.getIntentReturnCode(tinkerResultIntent) == 0) {
            return ShareIntentUtil.getIntentPatchLibsPaths(tinkerResultIntent);
        }
        return null;
    }

    public static HashMap<String, String> getPackageConfigs(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
        if (tinkerResultIntent != null && ShareIntentUtil.getIntentReturnCode(tinkerResultIntent) == 0) {
            return ShareIntentUtil.getIntentPackageConfig(tinkerResultIntent);
        }
        return null;
    }

    public static File getTinkerPatchDirectory(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        return SharePatchFileUtil.getPatchDirectory(applicationLike.getApplication());
    }

    public static boolean isTinkerEnableAll(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        return ShareTinkerInternals.isTinkerEnabledAll(applicationLike.getTinkerFlags());
    }

    public static boolean isTinkerEnableForDex(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        return ShareTinkerInternals.isTinkerEnabledForDex(applicationLike.getTinkerFlags());
    }

    public static boolean isTinkerEnableForNativeLib(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        return ShareTinkerInternals.isTinkerEnabledForNativeLib(applicationLike.getTinkerFlags());
    }

    public static boolean isTinkerEnableForResource(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        return ShareTinkerInternals.isTinkerEnabledForResource(applicationLike.getTinkerFlags());
    }

    public static boolean isTinkerLoadSuccess(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
        boolean z = false;
        if (tinkerResultIntent == null) {
            return false;
        }
        if (ShareIntentUtil.getIntentReturnCode(tinkerResultIntent) == 0) {
            z = true;
        }
        return z;
    }

    public static void loadArmLibrary(ApplicationLike applicationLike, String str) {
        if (str == null || str.isEmpty() || applicationLike == null) {
            throw new TinkerRuntimeException("libName or context is null!");
        }
        if (isTinkerEnableForNativeLib(applicationLike) && loadLibraryFromTinker(applicationLike, "lib/armeabi", str)) {
            return;
        }
        System.loadLibrary(str);
    }

    public static void loadArmV7aLibrary(ApplicationLike applicationLike, String str) {
        if (str == null || str.isEmpty() || applicationLike == null) {
            throw new TinkerRuntimeException("libName or context is null!");
        }
        if (isTinkerEnableForNativeLib(applicationLike) && loadLibraryFromTinker(applicationLike, "lib/armeabi-v7a", str)) {
            return;
        }
        System.loadLibrary(str);
    }

    public static boolean loadLibraryFromTinker(ApplicationLike applicationLike, String str, String str2) throws UnsatisfiedLinkError {
        HashMap<String, String> loadLibraryAndMd5;
        String currentVersion;
        File patchDirectory;
        if (!str2.startsWith(ShareConstants.SO_PATH)) {
            str2 = ShareConstants.SO_PATH + str2;
        }
        if (!str2.endsWith(".so")) {
            str2 = str2 + ".so";
        }
        String str3 = str + "/" + str2;
        if (isTinkerEnableForNativeLib(applicationLike) && isTinkerEnableForNativeLib(applicationLike) && (loadLibraryAndMd5 = getLoadLibraryAndMd5(applicationLike)) != null) {
            if (ShareTinkerInternals.isNullOrNil(getCurrentVersion(applicationLike)) || (patchDirectory = SharePatchFileUtil.getPatchDirectory(applicationLike.getApplication())) == null) {
                return false;
            }
            File file = new File(patchDirectory.getAbsolutePath() + "/" + SharePatchFileUtil.getPatchVersionDirectory(currentVersion));
            String str4 = file.getAbsolutePath() + "/" + ShareConstants.SO_PATH;
            for (Map.Entry<String, String> entry : loadLibraryAndMd5.entrySet()) {
                String key = entry.getKey();
                if (key.equals(str3)) {
                    String str5 = str4 + "/" + key;
                    File file2 = new File(str5);
                    if (!file2.exists()) {
                        continue;
                    } else if (!applicationLike.getTinkerLoadVerifyFlag() || SharePatchFileUtil.verifyFileMd5(file2, loadLibraryAndMd5.get(key))) {
                        System.load(str5);
                        ShareTinkerLog.i(TAG, "loadLibraryFromTinker success:" + str5, new Object[0]);
                        return true;
                    } else {
                        ShareTinkerLog.i(TAG, "loadLibraryFromTinker md5mismatch fail:" + str5, new Object[0]);
                    }
                }
            }
            return false;
        }
        return false;
    }
}
