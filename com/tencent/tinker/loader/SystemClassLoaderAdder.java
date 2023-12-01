package com.tencent.tinker.loader;

import android.app.Application;
import android.os.Build;
import com.cdo.oaps.ad.OapsWrapper;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.ZipFile;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/SystemClassLoaderAdder.class */
public class SystemClassLoaderAdder {
    public static final String CHECK_DEX_CLASS = "com.tencent.tinker.loader.TinkerTestDexLoad";
    public static final String CHECK_DEX_FIELD = "isPatch";
    private static final String TAG = "Tinker.ClassLoaderAdder";
    private static int sPatchDexCount;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/SystemClassLoaderAdder$ArkHot.class */
    static final class ArkHot {
        private ArkHot() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void install(ClassLoader classLoader, List<File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException, ClassNotFoundException, SecurityException {
            Class<?> loadClass = ClassLoader.getSystemClassLoader().getParent().loadClass("com.huawei.ark.classloader.ExtendedClassLoaderHelper");
            for (File file : list) {
                String canonicalPath = file.getCanonicalPath();
                Method declaredMethod = loadClass.getDeclaredMethod("applyPatch", ClassLoader.class, String.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, classLoader, canonicalPath);
                ShareTinkerLog.i(SystemClassLoaderAdder.TAG, "ArkHot install path = " + canonicalPath, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/SystemClassLoaderAdder$V14.class */
    public static final class V14 {
        private V14() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void install(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            Object obj = ShareReflectUtil.findField(classLoader, "pathList").get(classLoader);
            ShareReflectUtil.expandFieldArray(obj, "dexElements", makeDexElements(obj, new ArrayList(list), file));
        }

        private static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) ShareReflectUtil.findMethod(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, arrayList, file);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/SystemClassLoaderAdder$V19.class */
    public static final class V19 {
        private V19() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void install(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            Object obj = ShareReflectUtil.findField(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ShareReflectUtil.expandFieldArray(obj, "dexElements", makeDexElements(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                    ShareTinkerLog.w(SystemClassLoaderAdder.TAG, "Exception in makeDexElement", iOException);
                    throw iOException;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            Method findMethod;
            try {
                findMethod = ShareReflectUtil.findMethod(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class);
            } catch (NoSuchMethodException e) {
                ShareTinkerLog.e(SystemClassLoaderAdder.TAG, "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure", new Object[0]);
                try {
                    findMethod = ShareReflectUtil.findMethod(obj, "makeDexElements", List.class, File.class, List.class);
                } catch (NoSuchMethodException e2) {
                    ShareTinkerLog.e(SystemClassLoaderAdder.TAG, "NoSuchMethodException: makeDexElements(List,File,List) failure", new Object[0]);
                    throw e2;
                }
            }
            return (Object[]) findMethod.invoke(obj, arrayList, file, arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/SystemClassLoaderAdder$V23.class */
    public static final class V23 {
        private V23() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void install(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            Object obj = ShareReflectUtil.findField(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ShareReflectUtil.expandFieldArray(obj, "dexElements", makePathElements(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                    ShareTinkerLog.w(SystemClassLoaderAdder.TAG, "Exception in makePathElement", iOException);
                    throw iOException;
                }
            }
        }

        private static Object[] makePathElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            Method findMethod;
            try {
                findMethod = ShareReflectUtil.findMethod(obj, "makePathElements", List.class, File.class, List.class);
            } catch (NoSuchMethodException e) {
                ShareTinkerLog.e(SystemClassLoaderAdder.TAG, "NoSuchMethodException: makePathElements(List,File,List) failure", new Object[0]);
                try {
                    findMethod = ShareReflectUtil.findMethod(obj, "makePathElements", ArrayList.class, File.class, ArrayList.class);
                } catch (NoSuchMethodException e2) {
                    ShareTinkerLog.e(SystemClassLoaderAdder.TAG, "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure", new Object[0]);
                    try {
                        ShareTinkerLog.e(SystemClassLoaderAdder.TAG, "NoSuchMethodException: try use v19 instead", new Object[0]);
                        return V19.makeDexElements(obj, arrayList, file, arrayList2);
                    } catch (NoSuchMethodException e3) {
                        ShareTinkerLog.e(SystemClassLoaderAdder.TAG, "NoSuchMethodException: makeDexElements(List,File,List) failure", new Object[0]);
                        throw e3;
                    }
                }
            }
            return (Object[]) findMethod.invoke(obj, arrayList, file, arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/SystemClassLoaderAdder$V4.class */
    public static final class V4 {
        private V4() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void install(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            int size = list.size();
            Field findField = ShareReflectUtil.findField(classLoader, OapsWrapper.KEY_PATH);
            StringBuilder sb = new StringBuilder((String) findField.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator<File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File next = listIterator.next();
                String absolutePath = next.getAbsolutePath();
                sb.append(':');
                sb.append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = next;
                zipFileArr[previousIndex] = new ZipFile(next);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, SharePatchFileUtil.optimizedPathFor(next, file), 0);
            }
            findField.set(classLoader, sb.toString());
            ShareReflectUtil.expandFieldArray(classLoader, "mPaths", strArr);
            ShareReflectUtil.expandFieldArray(classLoader, "mFiles", fileArr);
            ShareReflectUtil.expandFieldArray(classLoader, "mZips", zipFileArr);
            try {
                ShareReflectUtil.expandFieldArray(classLoader, "mDexs", dexFileArr);
            } catch (Exception e) {
            }
        }
    }

    private static boolean checkDexInstall(ClassLoader classLoader) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        boolean booleanValue = ((Boolean) ShareReflectUtil.findField(Class.forName(CHECK_DEX_CLASS, true, classLoader), CHECK_DEX_FIELD).get(null)).booleanValue();
        ShareTinkerLog.w(TAG, "checkDexInstall result:" + booleanValue, new Object[0]);
        return booleanValue;
    }

    private static List<File> createSortedAdditionalPathEntries(List<File> list) {
        ArrayList<File> arrayList = new ArrayList(list);
        final HashMap hashMap = new HashMap();
        for (File file : arrayList) {
            String name = file.getName();
            hashMap.put(name, Boolean.valueOf(ShareConstants.CLASS_N_PATTERN.matcher(name).matches()));
        }
        Collections.sort(arrayList, new Comparator<File>() { // from class: com.tencent.tinker.loader.SystemClassLoaderAdder.1
            @Override // java.util.Comparator
            public int compare(File file2, File file3) {
                if (file2 == null && file3 == null) {
                    return 0;
                }
                if (file2 == null) {
                    return -1;
                }
                if (file3 == null) {
                    return 1;
                }
                String name2 = file2.getName();
                String name3 = file3.getName();
                if (name2.equals(name3)) {
                    return 0;
                }
                if (name2.startsWith(ShareConstants.TEST_DEX_NAME)) {
                    return 1;
                }
                if (name3.startsWith(ShareConstants.TEST_DEX_NAME)) {
                    return -1;
                }
                boolean booleanValue = ((Boolean) hashMap.get(name2)).booleanValue();
                boolean booleanValue2 = ((Boolean) hashMap.get(name3)).booleanValue();
                if (!booleanValue || !booleanValue2) {
                    if (booleanValue) {
                        return -1;
                    }
                    if (booleanValue2) {
                        return 1;
                    }
                    return name2.compareTo(name3);
                }
                int indexOf = name2.indexOf(46);
                int indexOf2 = name3.indexOf(46);
                int parseInt = indexOf > 7 ? Integer.parseInt(name2.substring(7, indexOf)) : 1;
                int parseInt2 = indexOf2 > 7 ? Integer.parseInt(name3.substring(7, indexOf2)) : 1;
                if (parseInt == parseInt2) {
                    return 0;
                }
                return parseInt < parseInt2 ? -1 : 1;
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void injectDexesInternal(ClassLoader classLoader, List<File> list, File file) throws Throwable {
        if (Build.VERSION.SDK_INT >= 23) {
            V23.install(classLoader, list, file);
        } else if (Build.VERSION.SDK_INT >= 19) {
            V19.install(classLoader, list, file);
        } else if (Build.VERSION.SDK_INT >= 14) {
            V14.install(classLoader, list, file);
        } else {
            V4.install(classLoader, list, file);
        }
    }

    public static void installApk(PathClassLoader pathClassLoader, List<File> list) throws Throwable {
        if (list.isEmpty()) {
            return;
        }
        List<File> createSortedAdditionalPathEntries = createSortedAdditionalPathEntries(list);
        ArkHot.install(pathClassLoader, createSortedAdditionalPathEntries);
        sPatchDexCount = createSortedAdditionalPathEntries.size();
        ShareTinkerLog.i(TAG, "after loaded classloader: " + pathClassLoader + ", dex size:" + sPatchDexCount, new Object[0]);
        checkDexInstall(pathClassLoader);
    }

    public static void installDexes(Application application, ClassLoader classLoader, File file, List<File> list, boolean z, boolean z2) throws Throwable {
        ShareTinkerLog.i(TAG, "installDexes dexOptDir: " + file.getAbsolutePath() + ", dex size:" + list.size(), new Object[0]);
        if (list.isEmpty()) {
            return;
        }
        List<File> createSortedAdditionalPathEntries = createSortedAdditionalPathEntries(list);
        if (Build.VERSION.SDK_INT < 24 || z) {
            injectDexesInternal(classLoader, createSortedAdditionalPathEntries, file);
        } else {
            classLoader = NewClassLoaderInjector.inject(application, classLoader, file, z2, createSortedAdditionalPathEntries);
        }
        sPatchDexCount = createSortedAdditionalPathEntries.size();
        ShareTinkerLog.i(TAG, "after loaded classloader: " + classLoader + ", dex size:" + sPatchDexCount, new Object[0]);
        if (checkDexInstall(classLoader)) {
            return;
        }
        uninstallPatchDex(classLoader);
        throw new TinkerRuntimeException(ShareConstants.CHECK_DEX_INSTALL_FAIL);
    }

    public static void uninstallPatchDex(ClassLoader classLoader) throws Throwable {
        if (sPatchDexCount <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            ShareReflectUtil.reduceFieldArray(ShareReflectUtil.findField(classLoader, "pathList").get(classLoader), "dexElements", sPatchDexCount);
            return;
        }
        ShareReflectUtil.reduceFieldArray(classLoader, "mPaths", sPatchDexCount);
        ShareReflectUtil.reduceFieldArray(classLoader, "mFiles", sPatchDexCount);
        ShareReflectUtil.reduceFieldArray(classLoader, "mZips", sPatchDexCount);
        try {
            ShareReflectUtil.reduceFieldArray(classLoader, "mDexs", sPatchDexCount);
        } catch (Exception e) {
        }
    }
}
