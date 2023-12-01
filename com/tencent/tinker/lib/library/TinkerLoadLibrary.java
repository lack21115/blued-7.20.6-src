package com.tencent.tinker.lib.library;

import android.content.Context;
import android.os.Build;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerApplicationHelper;
import com.tencent.tinker.lib.tinker.TinkerLoadResult;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/library/TinkerLoadLibrary.class */
public class TinkerLoadLibrary {
    private static final String TAG = "Tinker.LoadLibrary";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/library/TinkerLoadLibrary$V14.class */
    public static final class V14 {
        private V14() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void install(ClassLoader classLoader, File file) throws Throwable {
            Object obj = ShareReflectUtil.findField(classLoader, "pathList").get(classLoader);
            Field findField = ShareReflectUtil.findField(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) findField.get(obj);
            ArrayList arrayList = new ArrayList(fileArr.length + 1);
            arrayList.add(file);
            int length = fileArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    findField.set(obj, arrayList.toArray(new File[0]));
                    return;
                }
                File file2 = fileArr[i2];
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/library/TinkerLoadLibrary$V23.class */
    public static final class V23 {
        private V23() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void install(ClassLoader classLoader, File file) throws Throwable {
            Object obj = ShareReflectUtil.findField(classLoader, "pathList").get(classLoader);
            List list = (List) ShareReflectUtil.findField(obj, "nativeLibraryDirectories").get(obj);
            ArrayList arrayList = list;
            if (list == null) {
                arrayList = new ArrayList(2);
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (file.equals((File) it.next())) {
                    it.remove();
                    break;
                }
            }
            arrayList.add(0, file);
            List list2 = (List) ShareReflectUtil.findField(obj, "systemNativeLibraryDirectories").get(obj);
            ArrayList arrayList2 = list2;
            if (list2 == null) {
                arrayList2 = new ArrayList(2);
            }
            ArrayList arrayList3 = new ArrayList(arrayList.size() + arrayList2.size() + 1);
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            ShareReflectUtil.findField(obj, "nativeLibraryPathElements").set(obj, (Object[]) ShareReflectUtil.findMethod(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList3, null, new ArrayList()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/library/TinkerLoadLibrary$V25.class */
    public static final class V25 {
        private V25() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void install(ClassLoader classLoader, File file) throws Throwable {
            Object obj = ShareReflectUtil.findField(classLoader, "pathList").get(classLoader);
            List list = (List) ShareReflectUtil.findField(obj, "nativeLibraryDirectories").get(obj);
            ArrayList arrayList = list;
            if (list == null) {
                arrayList = new ArrayList(2);
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (file.equals((File) it.next())) {
                    it.remove();
                    break;
                }
            }
            arrayList.add(0, file);
            List list2 = (List) ShareReflectUtil.findField(obj, "systemNativeLibraryDirectories").get(obj);
            ArrayList arrayList2 = list2;
            if (list2 == null) {
                arrayList2 = new ArrayList(2);
            }
            ArrayList arrayList3 = new ArrayList(arrayList.size() + arrayList2.size() + 1);
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            ShareReflectUtil.findField(obj, "nativeLibraryPathElements").set(obj, (Object[]) ShareReflectUtil.findMethod(obj, "makePathElements", List.class).invoke(obj, arrayList3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/library/TinkerLoadLibrary$V4.class */
    public static final class V4 {
        private V4() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void install(ClassLoader classLoader, File file) throws Throwable {
            String path = file.getPath();
            Field findField = ShareReflectUtil.findField(classLoader, "libPath");
            String[] split = ((String) findField.get(classLoader)).split(":");
            StringBuilder sb = new StringBuilder(path);
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = split[i2];
                if (str != null && !path.equals(str)) {
                    sb.append(':');
                    sb.append(str);
                }
                i = i2 + 1;
            }
            findField.set(classLoader, sb.toString());
            Field findField2 = ShareReflectUtil.findField(classLoader, "libraryPathElements");
            List list = (List) findField2.get(classLoader);
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (path.equals((String) it.next())) {
                    it.remove();
                    break;
                }
            }
            list.add(0, path);
            findField2.set(classLoader, list);
        }
    }

    public static boolean installNativeLibraryABIWithoutTinkerInstalled(ApplicationLike applicationLike, String str) {
        String currentVersion = TinkerApplicationHelper.getCurrentVersion(applicationLike);
        if (ShareTinkerInternals.isNullOrNil(currentVersion)) {
            ShareTinkerLog.e(TAG, "failed to get current patch version.", new Object[0]);
            return false;
        }
        File patchDirectory = SharePatchFileUtil.getPatchDirectory(applicationLike.getApplication());
        if (patchDirectory == null) {
            ShareTinkerLog.e(TAG, "failed to get current patch directory.", new Object[0]);
            return false;
        }
        File file = new File(patchDirectory.getAbsolutePath() + "/" + SharePatchFileUtil.getPatchVersionDirectory(currentVersion));
        File file2 = new File(file.getAbsolutePath() + "/lib/lib/" + str);
        if (!file2.exists()) {
            ShareTinkerLog.e(TAG, "tinker lib path [%s] is not exists.", file2);
            return false;
        }
        ClassLoader classLoader = applicationLike.getApplication().getClassLoader();
        if (classLoader == null) {
            ShareTinkerLog.e(TAG, "classloader is null", new Object[0]);
            return false;
        }
        ShareTinkerLog.i(TAG, "before hack classloader:" + classLoader.toString(), new Object[0]);
        try {
            Method declaredMethod = TinkerLoadLibrary.class.getDeclaredMethod("installNativeLibraryPath", ClassLoader.class, File.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, classLoader, file2);
            ShareTinkerLog.i(TAG, "after hack classloader:" + classLoader.toString(), new Object[0]);
            return true;
        } catch (Throwable th) {
            try {
                ShareTinkerLog.e(TAG, "installNativeLibraryPath fail:" + file2 + ", thr: " + th, new Object[0]);
                ShareTinkerLog.i(TAG, "after hack classloader:" + classLoader.toString(), new Object[0]);
                return false;
            } catch (Throwable th2) {
                ShareTinkerLog.i(TAG, "after hack classloader:" + classLoader.toString(), new Object[0]);
                throw th2;
            }
        }
    }

    private static void installNativeLibraryPath(ClassLoader classLoader, File file) throws Throwable {
        if (file == null || !file.exists()) {
            ShareTinkerLog.e(TAG, "installNativeLibraryPath, folder %s is illegal", file);
        } else if ((Build.VERSION.SDK_INT == 25 && Build.VERSION.PREVIEW_SDK_INT != 0) || Build.VERSION.SDK_INT > 25) {
            try {
                V25.install(classLoader, file);
            } catch (Throwable th) {
                ShareTinkerLog.e(TAG, "installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23", Integer.valueOf(Build.VERSION.SDK_INT), th.getMessage());
                V23.install(classLoader, file);
            }
        } else if (Build.VERSION.SDK_INT < 23) {
            if (Build.VERSION.SDK_INT >= 14) {
                V14.install(classLoader, file);
            } else {
                V4.install(classLoader, file);
            }
        } else {
            try {
                V23.install(classLoader, file);
            } catch (Throwable th2) {
                ShareTinkerLog.e(TAG, "installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14", Integer.valueOf(Build.VERSION.SDK_INT), th2.getMessage());
                V14.install(classLoader, file);
            }
        }
    }

    public static boolean installNavitveLibraryABI(Context context, String str) {
        Tinker with = Tinker.with(context);
        if (!with.isTinkerLoaded()) {
            ShareTinkerLog.i(TAG, "tinker is not loaded, just return", new Object[0]);
            return false;
        }
        TinkerLoadResult tinkerLoadResultIfPresent = with.getTinkerLoadResultIfPresent();
        if (tinkerLoadResultIfPresent.libs == null) {
            ShareTinkerLog.i(TAG, "tinker libs is null, just return", new Object[0]);
            return false;
        }
        File file = tinkerLoadResultIfPresent.libraryDirectory;
        File file2 = new File(file, "lib/" + str);
        if (!file2.exists()) {
            ShareTinkerLog.e(TAG, "current libraryABI folder is not exist, path: %s", file2.getPath());
            return false;
        }
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader == null) {
            ShareTinkerLog.e(TAG, "classloader is null", new Object[0]);
            return false;
        }
        ShareTinkerLog.i(TAG, "before hack classloader:" + classLoader.toString(), new Object[0]);
        try {
            installNativeLibraryPath(classLoader, file2);
            ShareTinkerLog.i(TAG, "after hack classloader:" + classLoader.toString(), new Object[0]);
            return true;
        } catch (Throwable th) {
            try {
                ShareTinkerLog.e(TAG, "installNativeLibraryPath fail:" + th, new Object[0]);
                ShareTinkerLog.i(TAG, "after hack classloader:" + classLoader.toString(), new Object[0]);
                return false;
            } catch (Throwable th2) {
                ShareTinkerLog.i(TAG, "after hack classloader:" + classLoader.toString(), new Object[0]);
                throw th2;
            }
        }
    }

    public static void loadArmLibrary(Context context, String str) {
        if (str == null || str.isEmpty() || context == null) {
            throw new TinkerRuntimeException("libName or context is null!");
        }
        if (Tinker.with(context).isEnabledForNativeLib() && loadLibraryFromTinker(context, "lib/armeabi", str)) {
            return;
        }
        System.loadLibrary(str);
    }

    public static void loadArmLibraryWithoutTinkerInstalled(ApplicationLike applicationLike, String str) {
        if (str == null || str.isEmpty() || applicationLike == null) {
            throw new TinkerRuntimeException("libName or appLike is null!");
        }
        if (TinkerApplicationHelper.isTinkerEnableForNativeLib(applicationLike) && TinkerApplicationHelper.loadLibraryFromTinker(applicationLike, "lib/armeabi", str)) {
            return;
        }
        System.loadLibrary(str);
    }

    public static void loadArmV7Library(Context context, String str) {
        if (str == null || str.isEmpty() || context == null) {
            throw new TinkerRuntimeException("libName or context is null!");
        }
        if (Tinker.with(context).isEnabledForNativeLib() && loadLibraryFromTinker(context, "lib/armeabi-v7a", str)) {
            return;
        }
        System.loadLibrary(str);
    }

    public static void loadArmV7LibraryWithoutTinkerInstalled(ApplicationLike applicationLike, String str) {
        if (str == null || str.isEmpty() || applicationLike == null) {
            throw new TinkerRuntimeException("libName or appLike is null!");
        }
        if (TinkerApplicationHelper.isTinkerEnableForNativeLib(applicationLike) && TinkerApplicationHelper.loadLibraryFromTinker(applicationLike, "lib/armeabi-v7a", str)) {
            return;
        }
        System.loadLibrary(str);
    }

    public static boolean loadLibraryFromTinker(Context context, String str, String str2) throws UnsatisfiedLinkError {
        Tinker with = Tinker.with(context);
        if (!str2.startsWith(ShareConstants.SO_PATH)) {
            str2 = ShareConstants.SO_PATH + str2;
        }
        if (!str2.endsWith(".so")) {
            str2 = str2 + ".so";
        }
        String str3 = str + "/" + str2;
        if (with.isEnabledForNativeLib() && with.isTinkerLoaded()) {
            TinkerLoadResult tinkerLoadResultIfPresent = with.getTinkerLoadResultIfPresent();
            if (tinkerLoadResultIfPresent.libs == null) {
                return false;
            }
            for (String str4 : tinkerLoadResultIfPresent.libs.keySet()) {
                if (str4.equals(str3)) {
                    String str5 = tinkerLoadResultIfPresent.libraryDirectory + "/" + str4;
                    File file = new File(str5);
                    if (!file.exists()) {
                        continue;
                    } else if (!with.isTinkerLoadVerify() || SharePatchFileUtil.verifyFileMd5(file, tinkerLoadResultIfPresent.libs.get(str4))) {
                        System.load(str5);
                        ShareTinkerLog.i(TAG, "loadLibraryFromTinker success:" + str5, new Object[0]);
                        return true;
                    } else {
                        with.getLoadReporter().onLoadFileMd5Mismatch(file, 5);
                    }
                }
            }
            return false;
        }
        return false;
    }
}
