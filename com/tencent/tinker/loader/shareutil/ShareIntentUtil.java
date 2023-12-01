package com.tencent.tinker.loader.shareutil;

import android.content.Intent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/shareutil/ShareIntentUtil.class */
public class ShareIntentUtil {
    public static final String INTENT_IS_PROTECTED_APP = "intent_is_protected_app";
    public static final String INTENT_PATCH_COST_TIME = "intent_patch_cost_time";
    public static final String INTENT_PATCH_DEXES_PATH = "intent_patch_dexes_path";
    public static final String INTENT_PATCH_EXCEPTION = "intent_patch_exception";
    public static final String INTENT_PATCH_INTERPRET_EXCEPTION = "intent_patch_interpret_exception";
    public static final String INTENT_PATCH_LIBS_PATH = "intent_patch_libs_path";
    public static final String INTENT_PATCH_MISMATCH_DEX_PATH = "intent_patch_mismatch_dex_path";
    public static final String INTENT_PATCH_MISMATCH_LIB_PATH = "intent_patch_mismatch_lib_path";
    public static final String INTENT_PATCH_MISSING_DEX_PATH = "intent_patch_missing_dex_path";
    public static final String INTENT_PATCH_MISSING_LIB_PATH = "intent_patch_missing_lib_path";
    public static final String INTENT_PATCH_NEW_VERSION = "intent_patch_new_version";
    public static final String INTENT_PATCH_OAT_DIR = "intent_patch_oat_dir";
    public static final String INTENT_PATCH_OLD_VERSION = "intent_patch_old_version";
    public static final String INTENT_PATCH_PACKAGE_CONFIG = "intent_patch_package_config";
    public static final String INTENT_PATCH_PACKAGE_PATCH_CHECK = "intent_patch_package_patch_check";
    public static final String INTENT_PATCH_SYSTEM_OTA = "intent_patch_system_ota";
    public static final String INTENT_RETURN_CODE = "intent_return_code";
    private static final String TAG = "ShareIntentUtil";

    public static void fixIntentClassLoader(Intent intent, ClassLoader classLoader) {
        try {
            intent.setExtrasClassLoader(classLoader);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean getBooleanExtra(Intent intent, String str, boolean z) {
        if (intent == null) {
            return z;
        }
        try {
            return intent.getBooleanExtra(str, z);
        } catch (Exception e) {
            ShareTinkerLog.e(TAG, "getBooleanExtra exception:" + e.getMessage(), new Object[0]);
            return z;
        }
    }

    public static int getIntExtra(Intent intent, String str, int i) {
        if (intent == null) {
            return i;
        }
        try {
            return intent.getIntExtra(str, i);
        } catch (Exception e) {
            ShareTinkerLog.e(TAG, "getIntExtra exception:" + e.getMessage(), new Object[0]);
            return i;
        }
    }

    public static Throwable getIntentInterpretException(Intent intent) {
        Serializable serializableExtra = getSerializableExtra(intent, INTENT_PATCH_INTERPRET_EXCEPTION);
        if (serializableExtra != null) {
            return (Throwable) serializableExtra;
        }
        return null;
    }

    public static HashMap<String, String> getIntentPackageConfig(Intent intent) {
        Serializable serializableExtra = getSerializableExtra(intent, INTENT_PATCH_PACKAGE_CONFIG);
        if (serializableExtra != null) {
            return (HashMap) serializableExtra;
        }
        return null;
    }

    public static long getIntentPatchCostTime(Intent intent) {
        return intent.getLongExtra(INTENT_PATCH_COST_TIME, 0L);
    }

    public static HashMap<String, String> getIntentPatchDexPaths(Intent intent) {
        Serializable serializableExtra = getSerializableExtra(intent, INTENT_PATCH_DEXES_PATH);
        if (serializableExtra != null) {
            return (HashMap) serializableExtra;
        }
        return null;
    }

    public static Throwable getIntentPatchException(Intent intent) {
        Serializable serializableExtra = getSerializableExtra(intent, INTENT_PATCH_EXCEPTION);
        if (serializableExtra != null) {
            return (Throwable) serializableExtra;
        }
        return null;
    }

    public static HashMap<String, String> getIntentPatchLibsPaths(Intent intent) {
        Serializable serializableExtra = getSerializableExtra(intent, INTENT_PATCH_LIBS_PATH);
        if (serializableExtra != null) {
            return (HashMap) serializableExtra;
        }
        return null;
    }

    public static int getIntentReturnCode(Intent intent) {
        return getIntExtra(intent, INTENT_RETURN_CODE, -10000);
    }

    public static long getLongExtra(Intent intent, String str, long j) {
        if (intent == null) {
            return j;
        }
        try {
            return intent.getLongExtra(str, j);
        } catch (Exception e) {
            ShareTinkerLog.e(TAG, "getIntExtra exception:" + e.getMessage(), new Object[0]);
            return j;
        }
    }

    public static Serializable getSerializableExtra(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        try {
            return intent.getSerializableExtra(str);
        } catch (Exception e) {
            ShareTinkerLog.e(TAG, "getSerializableExtra exception:" + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static ArrayList<String> getStringArrayListExtra(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        try {
            return intent.getStringArrayListExtra(str);
        } catch (Exception e) {
            ShareTinkerLog.e(TAG, "getStringExtra exception:" + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static String getStringExtra(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        try {
            return intent.getStringExtra(str);
        } catch (Exception e) {
            ShareTinkerLog.e(TAG, "getStringExtra exception:" + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static void setIntentPatchCostTime(Intent intent, long j) {
        intent.putExtra(INTENT_PATCH_COST_TIME, j);
    }

    public static void setIntentReturnCode(Intent intent, int i) {
        intent.putExtra(INTENT_RETURN_CODE, i);
    }
}
