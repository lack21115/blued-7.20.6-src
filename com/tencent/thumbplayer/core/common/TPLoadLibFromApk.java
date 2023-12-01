package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPLoadLibFromApk.class */
public final class TPLoadLibFromApk {
    private static final HashMap<String, WeakReference<ClassLoader>> mLoadedLibs = new HashMap<>();
    private static Context mContext = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPLoadLibFromApk$LibraryBrokenHandler.class */
    static class LibraryBrokenHandler implements Thread.UncaughtExceptionHandler {
        private Thread.UncaughtExceptionHandler mParent;

        LibraryBrokenHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.mParent = uncaughtExceptionHandler;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
        @Override // java.lang.Thread.UncaughtExceptionHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void uncaughtException(java.lang.Thread r5, java.lang.Throwable r6) {
            /*
                r4 = this;
                r0 = r6
                boolean r0 = r0 instanceof java.lang.UnsatisfiedLinkError
                r9 = r0
                r0 = 1
                r8 = r0
                r0 = r9
                if (r0 != 0) goto L29
                r0 = r6
                boolean r0 = r0 instanceof java.lang.NoSuchMethodError
                if (r0 == 0) goto L24
                r0 = r6
                java.lang.String r0 = r0.getMessage()
                java.lang.String r1 = ".*sig(nature)?[=:].*"
                boolean r0 = r0.matches(r1)
                if (r0 == 0) goto L24
                goto L29
            L24:
                r0 = 0
                r7 = r0
                goto L2b
            L29:
                r0 = 1
                r7 = r0
            L2b:
                r0 = r7
                if (r0 == 0) goto L3b
                android.content.Context r0 = com.tencent.thumbplayer.core.common.TPLoadLibFromApk.access$000()     // Catch: java.lang.Exception -> L60
                com.tencent.thumbplayer.core.common.TPLoadLibFromApk.access$100(r0)     // Catch: java.lang.Exception -> L60
                r0 = r8
                r7 = r0
                goto L3d
            L3b:
                r0 = 0
                r7 = r0
            L3d:
                r0 = r6
                r10 = r0
                r0 = r7
                if (r0 == 0) goto L53
                java.lang.UnsatisfiedLinkError r0 = new java.lang.UnsatisfiedLinkError
                r1 = r0
                java.lang.String r2 = "Invalid so detected and recovered."
                r1.<init>(r2)
                r1 = r6
                java.lang.Throwable r0 = r0.initCause(r1)
                r10 = r0
            L53:
                r0 = r4
                java.lang.Thread$UncaughtExceptionHandler r0 = r0.mParent
                r1 = r5
                r2 = r10
                r0.uncaughtException(r1, r2)
                return
            L60:
                r10 = move-exception
                goto L3b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPLoadLibFromApk.LibraryBrokenHandler.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
        }
    }

    private TPLoadLibFromApk() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void extractAllLibraries(Context context) {
        if (context == null) {
            return;
        }
        List<String> generateAbiList = generateAbiList();
        File dir = context.getDir("recover_lib", 0);
        ZipFile zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
        try {
            HashSet hashSet = new HashSet();
            Pattern compile = Pattern.compile("lib/[A-Za-z0-9-_=]+/lib([A-Za-z0-9-_=]+)\\.so");
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                if (!TextUtils.isEmpty(name) && name.contains("../")) {
                    throw new Exception("contain ../, throw err");
                }
                Matcher matcher = compile.matcher(nextElement.getName());
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    if (!hashSet.contains(group)) {
                        extractLibrary(zipFile, group, generateAbiList, new File(dir, ShareConstants.SO_PATH + group + ".so"));
                        hashSet.add(group);
                    }
                }
            }
        } finally {
            zipFile.close();
        }
    }

    private static boolean extractLibrary(ZipFile zipFile, String str, List<String> list, File file) {
        if (file.isFile()) {
            return true;
        }
        Iterator<String> it = list.iterator();
        if (!it.hasNext()) {
            return false;
        }
        String next = it.next();
        ZipEntry entry = zipFile.getEntry("lib/" + next + "/lib" + str + ".so");
        if (entry == null) {
            return false;
        }
        String name = entry.getName();
        if (!TextUtils.isEmpty(name) && name.contains("../")) {
            return false;
        }
        InputStream inputStream = zipFile.getInputStream(entry);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[2048];
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, 2048);
                if (read == -1) {
                    try {
                        file.setReadOnly();
                        return true;
                    } catch (Throwable th) {
                        return false;
                    }
                }
                fileOutputStream.write(bArr, 0, read);
            } finally {
                inputStream.close();
                fileOutputStream.close();
            }
        }
    }

    public static String find(String str, Context context) {
        String str2 = null;
        if (context == null) {
            return null;
        }
        try {
            ClassLoader classLoader = TPLoadLibFromApk.class.getClassLoader();
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("findLibrary", String.class);
            declaredMethod.setAccessible(true);
            str2 = (String) declaredMethod.invoke(classLoader, str);
        } catch (Exception e) {
        }
        String str3 = str2;
        if (str2 == null) {
            File file = new File(context.getDir("recover_lib", 0), ShareConstants.SO_PATH + str + ".so");
            str3 = str2;
            if (file.canRead()) {
                str3 = file.getAbsolutePath();
            }
        }
        return str3;
    }

    private static List<String> generateAbiList() {
        ArrayList arrayList = new ArrayList(3);
        Method method = Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class);
        String str = (String) method.invoke(null, "ro.product.cpu.abi");
        if (str != null && str.length() > 0) {
            arrayList.add(str);
        }
        String str2 = (String) method.invoke(null, "ro.product.cpu.abi2");
        if (str2 != null && str2.length() > 0) {
            arrayList.add(str2);
        }
        arrayList.add("armeabi");
        return arrayList;
    }

    public static boolean load(String str, ClassLoader classLoader, Context context) {
        if (str == null || str.length() == 0 || classLoader == null) {
            return false;
        }
        mContext = context;
        synchronized (mLoadedLibs) {
            ClassLoader classLoader2 = null;
            WeakReference<ClassLoader> weakReference = mLoadedLibs.get(str);
            if (weakReference != null) {
                classLoader2 = weakReference.get();
            }
            if (classLoader2 != null) {
                if (classLoader2 == classLoader) {
                    TPNativeLog.printLog(2, "callerClassLoader has already load ! name=".concat(String.valueOf(str)));
                    return true;
                }
                throw new UnsatisfiedLinkError("Library '" + str + "' was loaded by a different ClassLoader.");
            } else if (context != null) {
                File file = new File(context.getDir("recover_lib", 0), ShareConstants.SO_PATH + str + ".so");
                UnsatisfiedLinkError loadFromRecovery = loadFromRecovery(str, classLoader, context, file);
                if (loadFromRecovery == null) {
                    return true;
                }
                return loadFromApk(str, classLoader, context, file, loadFromRecovery);
            } else {
                try {
                    TPNativeLog.printLog(2, "context is null,load by System.loadLibrary,name= ".concat(String.valueOf(str)));
                    reflectSystemLoadLibrary(str, classLoader);
                    synchronized (mLoadedLibs) {
                        mLoadedLibs.put(str, new WeakReference<>(classLoader));
                    }
                    return true;
                } catch (InvocationTargetException e) {
                    throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed loading library: ".concat(String.valueOf(str))).initCause(e.getCause()));
                } catch (Exception e2) {
                    throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed loading library: ".concat(String.valueOf(str))).initCause(e2));
                }
            }
        }
    }

    private static boolean loadFromApk(String str, ClassLoader classLoader, Context context, File file, UnsatisfiedLinkError unsatisfiedLinkError) {
        ZipFile zipFile = null;
        try {
            try {
                String str2 = context.getApplicationInfo().sourceDir;
                ZipFile zipFile2 = new ZipFile(str2);
                try {
                    TPNativeLog.printLog(2, "unzip apk,name= " + str + "apkPath=" + str2);
                    if (!extractLibrary(zipFile2, str, generateAbiList(), file)) {
                        throw new RuntimeException("Can't find recover library: ".concat(String.valueOf(str)));
                    }
                    try {
                        zipFile2.close();
                        try {
                            TPNativeLog.printLog(2, "load from unzip apk,name= ".concat(String.valueOf(str)));
                            reflectSystemLoad(file.getAbsolutePath(), classLoader);
                            synchronized (mLoadedLibs) {
                                mLoadedLibs.put(str, new WeakReference<>(classLoader));
                            }
                            return true;
                        } catch (InvocationTargetException e) {
                            if (unsatisfiedLinkError == null) {
                                throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library: ".concat(String.valueOf(str))).initCause(e.getCause()));
                            }
                            throw unsatisfiedLinkError;
                        } catch (Exception e2) {
                            if (unsatisfiedLinkError == null) {
                                throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library.").initCause(e2));
                            }
                            throw unsatisfiedLinkError;
                        }
                    } catch (IOException e3) {
                        return false;
                    }
                } catch (Exception e4) {
                    e = e4;
                    zipFile = zipFile2;
                    throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library.").initCause(e));
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e5) {
                            return false;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
            zipFile = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.UnsatisfiedLinkError loadFromRecovery(java.lang.String r6, java.lang.ClassLoader r7, android.content.Context r8, java.io.File r9) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPLoadLibFromApk.loadFromRecovery(java.lang.String, java.lang.ClassLoader, android.content.Context, java.io.File):java.lang.UnsatisfiedLinkError");
    }

    private static void reflectSystemLoad(String str, ClassLoader classLoader) {
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("load", String.class, ClassLoader.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, str, classLoader);
    }

    private static void reflectSystemLoadLibrary(String str, ClassLoader classLoader) {
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("loadLibrary", String.class, ClassLoader.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, str, classLoader);
    }

    public static void setupBrokenLibraryHandler() {
        Thread.setDefaultUncaughtExceptionHandler(new LibraryBrokenHandler(Thread.getDefaultUncaughtExceptionHandler()));
    }
}
