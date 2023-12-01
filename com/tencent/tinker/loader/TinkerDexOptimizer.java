package com.tencent.tinker.loader;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.anythink.expressad.video.module.a.a.m;
import com.huawei.hms.framework.common.ContainerUtils;
import com.igexin.assist.util.AssistUtils;
import com.tencent.tinker.loader.shareutil.ShareFileLockHelper;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/TinkerDexOptimizer.class */
public final class TinkerDexOptimizer {
    private static final String INTERPRET_LOCK_FILE_NAME = "interpret.lock";
    private static final String TAG = "Tinker.ParallelDex";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker.class */
    public static class OptimizeWorker {
        private static final PackageManager[] CACHED_SYNC_PM = {null};
        private static final String PM_INTERFACE_DESCRIPTOR = "android.content.pm.IPackageManager";
        private static String targetISA;
        private final ResultCallback callback;
        private final Context context;
        private final File dexFile;
        private final File optimizedDir;
        private final boolean useDLC;
        private final boolean useInterpretMode;

        OptimizeWorker(Context context, File file, File file2, boolean z, boolean z2, String str, ResultCallback resultCallback) {
            this.context = context;
            this.dexFile = file;
            this.optimizedDir = file2;
            this.useInterpretMode = z;
            this.useDLC = z2;
            this.callback = resultCallback;
            targetISA = str;
        }

        private static PackageManager getSynchronizedPackageManager(Context context) throws Throwable {
            synchronized (CACHED_SYNC_PM) {
                if (CACHED_SYNC_PM[0] != null) {
                    return CACHED_SYNC_PM[0];
                }
                final IBinder iBinder = (IBinder) ShareReflectUtil.findMethod(Class.forName("android.os.ServiceManager"), "getService", (Class<?>[]) new Class[]{String.class}).invoke(null, "package");
                IInterface iInterface = (IInterface) ShareReflectUtil.findMethod(Class.forName("android.content.pm.IPackageManager$Stub"), "asInterface", (Class<?>[]) new Class[]{IBinder.class}).invoke(null, (IBinder) Proxy.newProxyInstance(context.getClassLoader(), iBinder.getClass().getInterfaces(), new InvocationHandler() { // from class: com.tencent.tinker.loader.TinkerDexOptimizer.OptimizeWorker.2
                    @Override // java.lang.reflect.InvocationHandler
                    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                        if ("transact".equals(method.getName())) {
                            objArr[3] = 0;
                        }
                        return method.invoke(IBinder.this, objArr);
                    }
                }));
                Context context2 = context;
                if (context instanceof ContextWrapper) {
                    context2 = ((ContextWrapper) context).getBaseContext();
                }
                PackageManager packageManager = (PackageManager) Class.forName("android.app.ApplicationPackageManager").getDeclaredConstructor(context2.getClass(), iInterface.getClass().getInterfaces()[0]).newInstance(context2, iInterface);
                CACHED_SYNC_PM[0] = packageManager;
                return packageManager;
            }
        }

        private void interpretDex2Oat(String str, String str2) throws IOException {
            File file = new File(str2);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
            ShareFileLockHelper shareFileLockHelper = null;
            try {
                ShareFileLockHelper fileLock = ShareFileLockHelper.getFileLock(new File(file.getParentFile(), TinkerDexOptimizer.INTERPRET_LOCK_FILE_NAME));
                ArrayList arrayList = new ArrayList();
                arrayList.add("dex2oat");
                if (Build.VERSION.SDK_INT >= 24) {
                    arrayList.add("--runtime-arg");
                    arrayList.add("-classpath");
                    arrayList.add("--runtime-arg");
                    arrayList.add(ContainerUtils.FIELD_DELIMITER);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("--dex-file=");
                sb.append(str);
                arrayList.add(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("--oat-file=");
                sb2.append(str2);
                arrayList.add(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("--instruction-set=");
                sb3.append(targetISA);
                arrayList.add(sb3.toString());
                if (Build.VERSION.SDK_INT > 25) {
                    arrayList.add("--compiler-filter=quicken");
                } else {
                    arrayList.add("--compiler-filter=interpret-only");
                }
                ProcessBuilder processBuilder = new ProcessBuilder(arrayList);
                processBuilder.redirectErrorStream(true);
                Process start = processBuilder.start();
                StreamConsumer.consumeInputStream(start.getInputStream());
                StreamConsumer.consumeInputStream(start.getErrorStream());
                shareFileLockHelper = fileLock;
                try {
                    int waitFor = start.waitFor();
                    if (waitFor != 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("dex2oat works unsuccessfully, exit code: ");
                        sb4.append(waitFor);
                        shareFileLockHelper = fileLock;
                        throw new IOException(sb4.toString());
                    } else if (fileLock != null) {
                        try {
                            fileLock.close();
                        } catch (IOException e) {
                            ShareTinkerLog.w(TinkerDexOptimizer.TAG, "release interpret Lock error", e);
                        }
                    }
                } catch (InterruptedException e2) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("dex2oat is interrupted, msg: ");
                    sb5.append(e2.getMessage());
                    throw new IOException(sb5.toString(), e2);
                }
            } catch (Throwable th) {
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (IOException e3) {
                        ShareTinkerLog.w(TinkerDexOptimizer.TAG, "release interpret Lock error", e3);
                    }
                }
                throw th;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x00b8, code lost:
            com.tencent.tinker.loader.shareutil.ShareTinkerLog.i(com.tencent.tinker.loader.TinkerDexOptimizer.TAG, "[+] Secondary dexopt done.", new java.lang.Object[0]);
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00c2, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static void performDexOptSecondary(android.content.Context r7, java.lang.String r8) throws java.lang.IllegalStateException {
            /*
                Method dump skipped, instructions count: 235
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.TinkerDexOptimizer.OptimizeWorker.performDexOptSecondary(android.content.Context, java.lang.String):void");
        }

        private static void performDexOptSecondaryImpl(IBinder iBinder, int i, String str, String str2, boolean z) {
            Parcel parcel;
            long clearCallingIdentity = Binder.clearCallingIdentity();
            Parcel parcel2 = null;
            try {
                Parcel obtain = Parcel.obtain();
                parcel2 = null;
                try {
                    Parcel obtain2 = Parcel.obtain();
                    obtain.writeInterfaceToken(PM_INTERFACE_DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    parcel2 = obtain2;
                    try {
                        if (!iBinder.transact(i, obtain, obtain2, 0)) {
                            parcel2 = obtain2;
                            throw new IllegalStateException("Binder transaction failure.");
                        }
                        obtain2.readException();
                        if (!(obtain2.readInt() != 0)) {
                            ShareTinkerLog.w(TinkerDexOptimizer.TAG, "[!] System API return false.", new Object[0]);
                        }
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                        if (obtain2 != null) {
                            obtain2.recycle();
                        }
                        if (obtain != null) {
                            obtain.recycle();
                        }
                    } catch (RemoteException e) {
                        throw new IllegalStateException(e);
                    }
                } catch (Throwable th) {
                    th = th;
                    parcel = obtain;
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                    if (parcel2 != null) {
                        parcel2.recycle();
                    }
                    if (parcel != null) {
                        parcel.recycle();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                parcel = null;
            }
        }

        private static int queryPerformDexOptSecondaryTransactionCode() throws UnsupportedOperationException {
            try {
                Method findMethod = ShareReflectUtil.findMethod((Class<?>) Class.class, "getDeclaredField", (Class<?>[]) new Class[]{String.class});
                findMethod.setAccessible(true);
                Field field = (Field) findMethod.invoke(Class.forName("android.content.pm.IPackageManager$Stub"), "TRANSACTION_performDexOptSecondary");
                field.setAccessible(true);
                return ((Integer) field.get(null)).intValue();
            } catch (Throwable th) {
                throw new UnsupportedOperationException("Cannot query transaction code of performDexOptSecondary.", th);
            }
        }

        private static void registerDexModule(Context context, String str, String str2) throws IllegalStateException {
            try {
                PackageManager synchronizedPackageManager = getSynchronizedPackageManager(context);
                Method findMethod = ShareReflectUtil.findMethod(synchronizedPackageManager.getClass(), "registerDexModule", (Class<?>[]) new Class[]{String.class, PackageManager.DexModuleRegisterCallback.class});
                File file = new File(str2);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= 2) {
                        return;
                    }
                    Throwable th = null;
                    try {
                        findMethod.invoke(synchronizedPackageManager, str, new PackageManager.DexModuleRegisterCallback() { // from class: com.tencent.tinker.loader.TinkerDexOptimizer.OptimizeWorker.1
                            public void onDexModuleRegistered(String str3, boolean z, String str4) {
                                ShareTinkerLog.i(TinkerDexOptimizer.TAG, "[+] onDexModuleRegistered, path: %s, is_success: %s, msg: %s", str3, Boolean.valueOf(z), str4);
                            }
                        });
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    SystemClock.sleep(m.ag);
                    if (file.exists()) {
                        return;
                    }
                    if (i2 == 1) {
                        if (th != null) {
                            throw th;
                        }
                        if (!file.exists()) {
                            throw new IllegalStateException("Expected oat file: " + file.getAbsolutePath() + " does not exist.");
                        }
                    }
                    i = i2 + 1;
                }
            } catch (IllegalStateException e) {
                throw e;
            } catch (Throwable th3) {
                throw new IllegalStateException("Fail to call registerDexModule.", th3);
            }
        }

        private static void triggerPMDexOptOnDemand(Context context, String str, String str2) {
            if (Build.VERSION.SDK_INT != 29) {
                ShareTinkerLog.w(TinkerDexOptimizer.TAG, "[+] Not API 29 device, skip fixing.", new Object[0]);
                return;
            }
            ShareTinkerLog.i(TinkerDexOptimizer.TAG, "[+] Hit target device, do fix logic now.", new Object[0]);
            try {
                File file = new File(str2);
                if (file.exists()) {
                    ShareTinkerLog.i(TinkerDexOptimizer.TAG, "[+] Odex file exists, skip bg-dexopt triggering.", new Object[0]);
                    return;
                }
                performDexOptSecondary(context, str2);
                SystemClock.sleep(1000L);
                if ((1 == 0 || !file.exists()) && (AssistUtils.BRAND_HW.equalsIgnoreCase(Build.MANUFACTURER) || AssistUtils.BRAND_HON.equalsIgnoreCase(Build.MANUFACTURER))) {
                    registerDexModule(context, str, str2);
                }
                if (!file.exists()) {
                    throw new IllegalStateException("Bg-dexopt was triggered, but no odex file was generated.");
                }
                ShareTinkerLog.i(TinkerDexOptimizer.TAG, "[+] Bg-dexopt was triggered successfully.", new Object[0]);
            } catch (Throwable th) {
                ShareTinkerLog.printErrStackTrace(TinkerDexOptimizer.TAG, th, "[-] Fail to call triggerPMDexOptAsyncOnDemand.", new Object[0]);
            }
        }

        boolean run() {
            try {
                if (!SharePatchFileUtil.isLegalFile(this.dexFile) && this.callback != null) {
                    ResultCallback resultCallback = this.callback;
                    File file = this.dexFile;
                    File file2 = this.optimizedDir;
                    resultCallback.onFailed(file, file2, new IOException("dex file " + this.dexFile.getAbsolutePath() + " is not exist!"));
                    return false;
                }
                if (this.callback != null) {
                    this.callback.onStart(this.dexFile, this.optimizedDir);
                }
                String optimizedPathFor = SharePatchFileUtil.optimizedPathFor(this.dexFile, this.optimizedDir);
                if (!ShareTinkerInternals.isArkHotRuning()) {
                    if (this.useInterpretMode) {
                        interpretDex2Oat(this.dexFile.getAbsolutePath(), optimizedPathFor);
                    } else {
                        if (Build.VERSION.SDK_INT < 26 && (Build.VERSION.SDK_INT < 25 || Build.VERSION.PREVIEW_SDK_INT == 0)) {
                            DexFile.loadDex(this.dexFile.getAbsolutePath(), optimizedPathFor, 0);
                        }
                        NewClassLoaderInjector.triggerDex2Oat(this.context, this.optimizedDir, this.useDLC, this.dexFile.getAbsolutePath());
                        triggerPMDexOptOnDemand(this.context, this.dexFile.getAbsolutePath(), optimizedPathFor);
                    }
                }
                if (this.callback != null) {
                    this.callback.onSuccess(this.dexFile, this.optimizedDir, new File(optimizedPathFor));
                    return true;
                }
                return true;
            } catch (Throwable th) {
                ShareTinkerLog.e(TinkerDexOptimizer.TAG, "Failed to optimize dex: " + this.dexFile.getAbsolutePath(), th);
                ResultCallback resultCallback2 = this.callback;
                if (resultCallback2 != null) {
                    resultCallback2.onFailed(this.dexFile, this.optimizedDir, th);
                    return false;
                }
                return true;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback.class */
    public interface ResultCallback {
        void onFailed(File file, File file2, Throwable th);

        void onStart(File file, File file2);

        void onSuccess(File file, File file2, File file3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer.class */
    public static class StreamConsumer {
        static final Executor STREAM_CONSUMER = Executors.newSingleThreadExecutor();

        private StreamConsumer() {
        }

        static void consumeInputStream(final InputStream inputStream) {
            STREAM_CONSUMER.execute(new Runnable() { // from class: com.tencent.tinker.loader.TinkerDexOptimizer.StreamConsumer.1
                @Override // java.lang.Runnable
                public void run() {
                    if (inputStream == null) {
                        return;
                    }
                    do {
                        try {
                        } catch (IOException e) {
                        } catch (Throwable th) {
                            try {
                                inputStream.close();
                            } catch (Exception e2) {
                            }
                            throw th;
                        }
                    } while (inputStream.read(new byte[256]) > 0);
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                    }
                }
            });
        }
    }

    public static boolean optimizeAll(Context context, Collection<File> collection, File file, boolean z, ResultCallback resultCallback) {
        return optimizeAll(context, collection, file, false, z, null, resultCallback);
    }

    public static boolean optimizeAll(Context context, Collection<File> collection, File file, boolean z, boolean z2, String str, ResultCallback resultCallback) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList, new Comparator<File>() { // from class: com.tencent.tinker.loader.TinkerDexOptimizer.1
            @Override // java.util.Comparator
            public int compare(File file2, File file3) {
                int i = (file2.length() > file3.length() ? 1 : (file2.length() == file3.length() ? 0 : -1));
                if (i < 0) {
                    return 1;
                }
                return i == 0 ? 0 : -1;
            }
        });
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!new OptimizeWorker(context, (File) it.next(), file, z, z2, str, resultCallback).run()) {
                return false;
            }
        }
        return true;
    }
}
