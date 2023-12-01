package com.tencent.tinker.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/TinkerResourcePatcher.class */
class TinkerResourcePatcher {
    private static final String TAG = "Tinker.ResourcePatcher";
    private static final String TEST_ASSETS_VALUE = "only_use_to_test_tinker_resource.txt";
    private static Method addAssetPathAsSharedLibraryMethod;
    private static Method addAssetPathMethod;
    private static Field assetsFiled;
    private static Object currentActivityThread;
    private static Method ensureStringBlocksMethod;
    private static AssetManager newAssetManager;
    private static Field packagesFiled;
    private static Field publicSourceDirField;
    private static Collection<WeakReference<Resources>> references;
    private static Field resDir;
    private static Field resourcePackagesFiled;
    private static Field resourcesImplFiled;
    private static Field stringBlocksField;

    TinkerResourcePatcher() {
    }

    private static boolean checkResUpdate(Context context) {
        try {
            SharePatchFileUtil.closeQuietly(context.getAssets().open(TEST_ASSETS_VALUE));
            ShareTinkerLog.i(TAG, "checkResUpdate success, found test resource assets file only_use_to_test_tinker_resource.txt", new Object[0]);
            return true;
        } catch (Throwable th) {
            try {
                ShareTinkerLog.e(TAG, "checkResUpdate failed, can't find test resource assets file only_use_to_test_tinker_resource.txt e:" + th.getMessage(), new Object[0]);
                SharePatchFileUtil.closeQuietly(null);
                return false;
            } catch (Throwable th2) {
                SharePatchFileUtil.closeQuietly(null);
                throw th2;
            }
        }
    }

    private static void clearPreloadTypedArrayIssue(Resources resources) {
        ShareTinkerLog.w(TAG, "try to clear typedArray cache!", new Object[0]);
        try {
            Object obj = ShareReflectUtil.findField((Class<?>) Resources.class, "mTypedArrayPool").get(resources);
            do {
            } while (ShareReflectUtil.findMethod(obj, "acquire", new Class[0]).invoke(obj, new Object[0]) != null);
        } catch (Throwable th) {
            ShareTinkerLog.e(TAG, "clearPreloadTypedArrayIssue failed, ignore error: " + th, new Object[0]);
        }
    }

    public static void isResourceCanPatch(Context context) throws Throwable {
        Class<?> cls;
        Class<?> cls2 = Class.forName("android.app.ActivityThread");
        currentActivityThread = ShareReflectUtil.getActivityThread(context, cls2);
        try {
            cls = Class.forName("android.app.LoadedApk");
        } catch (ClassNotFoundException e) {
            cls = Class.forName("android.app.ActivityThread$PackageInfo");
        }
        resDir = ShareReflectUtil.findField(cls, "mResDir");
        packagesFiled = ShareReflectUtil.findField(cls2, "mPackages");
        if (Build.VERSION.SDK_INT < 27) {
            resourcePackagesFiled = ShareReflectUtil.findField(cls2, "mResourcePackages");
        }
        AssetManager assets = context.getAssets();
        addAssetPathMethod = ShareReflectUtil.findMethod(assets, "addAssetPath", String.class);
        if (shouldAddSharedLibraryAssets(context.getApplicationInfo())) {
            addAssetPathAsSharedLibraryMethod = ShareReflectUtil.findMethod(assets, "addAssetPathAsSharedLibrary", String.class);
        }
        try {
            stringBlocksField = ShareReflectUtil.findField(assets, "mStringBlocks");
            ensureStringBlocksMethod = ShareReflectUtil.findMethod(assets, "ensureStringBlocks", new Class[0]);
        } catch (Throwable th) {
        }
        newAssetManager = (AssetManager) ShareReflectUtil.findConstructor(assets, new Class[0]).newInstance(new Object[0]);
        if (Build.VERSION.SDK_INT >= 19) {
            Class<?> cls3 = Class.forName("android.app.ResourcesManager");
            Object invoke = ShareReflectUtil.findMethod(cls3, "getInstance", (Class<?>[]) new Class[0]).invoke(null, new Object[0]);
            try {
                references = ((ArrayMap) ShareReflectUtil.findField(cls3, "mActiveResources").get(invoke)).values();
            } catch (NoSuchFieldException e2) {
                references = (Collection) ShareReflectUtil.findField(cls3, "mResourceReferences").get(invoke);
            }
        } else {
            references = ((HashMap) ShareReflectUtil.findField(cls2, "mActiveResources").get(currentActivityThread)).values();
        }
        if (references == null) {
            throw new IllegalStateException("resource references is null");
        }
        Resources resources = context.getResources();
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                resourcesImplFiled = ShareReflectUtil.findField(resources, "mResourcesImpl");
            } catch (Throwable th2) {
                assetsFiled = ShareReflectUtil.findField(resources, "mAssets");
            }
        } else {
            assetsFiled = ShareReflectUtil.findField(resources, "mAssets");
        }
        try {
            publicSourceDirField = ShareReflectUtil.findField((Class<?>) ApplicationInfo.class, "publicSourceDir");
        } catch (NoSuchFieldException e3) {
        }
    }

    public static void monkeyPatchExistingResources(Context context, String str) throws Throwable {
        if (str == null) {
            return;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        Field[] fieldArr = Build.VERSION.SDK_INT < 27 ? new Field[]{packagesFiled, resourcePackagesFiled} : new Field[]{packagesFiled};
        int length = fieldArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            for (Map.Entry entry : ((Map) fieldArr[i2].get(currentActivityThread)).entrySet()) {
                Object obj = ((WeakReference) entry.getValue()).get();
                if (obj != null && applicationInfo.sourceDir.equals((String) resDir.get(obj))) {
                    resDir.set(obj, str);
                }
            }
            i = i2 + 1;
        }
        if (((Integer) addAssetPathMethod.invoke(newAssetManager, str)).intValue() == 0) {
            throw new IllegalStateException("Could not create new AssetManager");
        }
        if (shouldAddSharedLibraryAssets(applicationInfo)) {
            String[] strArr = applicationInfo.sharedLibraryFiles;
            int length2 = strArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length2) {
                    break;
                }
                String str2 = strArr[i4];
                if (str2.endsWith(".apk")) {
                    if (((Integer) addAssetPathAsSharedLibraryMethod.invoke(newAssetManager, str2)).intValue() == 0) {
                        throw new IllegalStateException("AssetManager add SharedLibrary Fail");
                    }
                    Log.i(TAG, "addAssetPathAsSharedLibrary " + str2);
                }
                i3 = i4 + 1;
            }
        }
        Field field = stringBlocksField;
        if (field != null && ensureStringBlocksMethod != null) {
            field.set(newAssetManager, null);
            ensureStringBlocksMethod.invoke(newAssetManager, new Object[0]);
        }
        for (WeakReference<Resources> weakReference : references) {
            Resources resources = weakReference.get();
            if (resources != null) {
                try {
                    assetsFiled.set(resources, newAssetManager);
                } catch (Throwable th) {
                    Object obj2 = resourcesImplFiled.get(resources);
                    ShareReflectUtil.findField(obj2, "mAssets").set(obj2, newAssetManager);
                }
                clearPreloadTypedArrayIssue(resources);
                resources.updateConfiguration(resources.getConfiguration(), resources.getDisplayMetrics());
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                if (publicSourceDirField != null) {
                    publicSourceDirField.set(context.getApplicationInfo(), str);
                }
            } catch (Throwable th2) {
            }
        }
        if (!checkResUpdate(context)) {
            throw new TinkerRuntimeException(ShareConstants.CHECK_RES_INSTALL_FAIL);
        }
    }

    private static boolean shouldAddSharedLibraryAssets(ApplicationInfo applicationInfo) {
        return (Build.VERSION.SDK_INT < 24 || applicationInfo == null || applicationInfo.sharedLibraryFiles == null) ? false : true;
    }
}
