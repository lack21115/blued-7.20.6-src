package com.android.internal.content;

import android.content.pm.PackageParser;
import android.os.Environment;
import android.os.FileUtils;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.storage.IMountService;
import android.util.Log;
import com.android.internal.content.NativeLibraryHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import libcore.io.IoUtils;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/content/PackageHelper.class */
public class PackageHelper {
    public static final int APP_INSTALL_AUTO = 0;
    public static final int APP_INSTALL_EXTERNAL = 2;
    public static final int APP_INSTALL_INTERNAL = 1;
    public static final int RECOMMEND_FAILED_ALREADY_EXISTS = -4;
    public static final int RECOMMEND_FAILED_INSUFFICIENT_STORAGE = -1;
    public static final int RECOMMEND_FAILED_INVALID_APK = -2;
    public static final int RECOMMEND_FAILED_INVALID_LOCATION = -3;
    public static final int RECOMMEND_FAILED_INVALID_URI = -6;
    public static final int RECOMMEND_FAILED_VERSION_DOWNGRADE = -7;
    public static final int RECOMMEND_INSTALL_EXTERNAL = 2;
    public static final int RECOMMEND_INSTALL_INTERNAL = 1;
    public static final int RECOMMEND_MEDIA_UNAVAILABLE = -5;
    private static final String TAG = "PackageHelper";
    private static final boolean localLOGV = false;

    public static long calculateInstalledSize(PackageParser.PackageLite packageLite, NativeLibraryHelper.Handle handle, boolean z, String str) throws IOException {
        long j = 0;
        for (String str2 : packageLite.getAllCodePaths()) {
            File file = new File(str2);
            long length = j + file.length();
            j = length;
            if (z) {
                j = length + extractPublicFiles(file, null);
            }
        }
        return j + NativeLibraryHelper.sumNativeBinariesWithOverride(handle, str);
    }

    public static long calculateInstalledSize(PackageParser.PackageLite packageLite, boolean z, String str) throws IOException {
        NativeLibraryHelper.Handle handle = null;
        try {
            NativeLibraryHelper.Handle create = NativeLibraryHelper.Handle.create(packageLite);
            handle = create;
            long calculateInstalledSize = calculateInstalledSize(packageLite, create, z, str);
            IoUtils.closeQuietly(create);
            return calculateInstalledSize;
        } catch (Throwable th) {
            IoUtils.closeQuietly(handle);
            throw th;
        }
    }

    private static void copyZipEntry(ZipEntry zipEntry, ZipFile zipFile, ZipOutputStream zipOutputStream) throws IOException {
        byte[] bArr = new byte[4096];
        zipOutputStream.putNextEntry(zipEntry.getMethod() == 0 ? new ZipEntry(zipEntry) : new ZipEntry(zipEntry.getName()));
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    zipOutputStream.flush();
                    return;
                }
                zipOutputStream.write(bArr, 0, read);
            } finally {
                IoUtils.closeQuietly(inputStream);
            }
        }
    }

    public static String createSdDir(long j, String str, String str2, int i, boolean z) {
        int i2 = (int) ((1048576 + j) / 1048576);
        try {
            IMountService mountService = getMountService();
            if (mountService.createSecureContainer(str, i2 + 1, "ext4", str2, i, z) != 0) {
                Log.e(TAG, "Failed to create secure container " + str);
                return null;
            }
            return mountService.getSecureContainerPath(str);
        } catch (RemoteException e) {
            Log.e(TAG, "MountService running?");
            return null;
        }
    }

    public static boolean destroySdDir(String str) {
        try {
            if (getMountService().destroySecureContainer(str, true) != 0) {
                Log.i(TAG, "Failed to destroy container " + str);
                return false;
            }
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to destroy container " + str + " with exception " + e);
            return false;
        }
    }

    public static long extractPublicFiles(File file, File file2) throws IOException {
        FileOutputStream fileOutputStream;
        ZipOutputStream zipOutputStream;
        if (file2 == null) {
            fileOutputStream = null;
            zipOutputStream = null;
        } else {
            fileOutputStream = new FileOutputStream(file2);
            zipOutputStream = new ZipOutputStream(fileOutputStream);
            Log.d(TAG, "Extracting " + file + " to " + file2);
        }
        long j = 0;
        try {
            ZipFile zipFile = new ZipFile(file.getAbsolutePath());
            Iterator it = Collections.list(zipFile.entries()).iterator();
            while (it.hasNext()) {
                ZipEntry zipEntry = (ZipEntry) it.next();
                String name = zipEntry.getName();
                if ("AndroidManifest.xml".equals(name) || "resources.arsc".equals(name) || name.startsWith("res/")) {
                    long size = j + zipEntry.getSize();
                    j = size;
                    if (file2 != null) {
                        copyZipEntry(zipEntry, zipFile, zipOutputStream);
                        j = size;
                    }
                }
            }
            try {
                zipFile.close();
            } catch (IOException e) {
            }
            if (file2 != null) {
                zipOutputStream.finish();
                zipOutputStream.flush();
                FileUtils.sync(fileOutputStream);
                zipOutputStream.close();
                FileUtils.setPermissions(file2.getAbsolutePath(), 420, -1, -1);
            }
            IoUtils.closeQuietly(zipOutputStream);
            return j;
        } catch (Throwable th) {
            IoUtils.closeQuietly(zipOutputStream);
            throw th;
        }
    }

    public static boolean finalizeSdDir(String str) {
        try {
            if (getMountService().finalizeSecureContainer(str) != 0) {
                Log.i(TAG, "Failed to finalize container " + str);
                return false;
            }
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to finalize container " + str + " with exception " + e);
            return false;
        }
    }

    public static boolean fixSdPermissions(String str, int i, String str2) {
        try {
            if (getMountService().fixPermissionsSecureContainer(str, i, str2) != 0) {
                Log.i(TAG, "Failed to fixperms container " + str);
                return false;
            }
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to fixperms container " + str + " with exception " + e);
            return false;
        }
    }

    public static IMountService getMountService() throws RemoteException {
        IBinder service = ServiceManager.getService("mount");
        if (service != null) {
            return IMountService.Stub.asInterface(service);
        }
        Log.e(TAG, "Can't get mount service");
        throw new RemoteException("Could not contact mount service");
    }

    public static String getSdDir(String str) {
        try {
            return getMountService().getSecureContainerPath(str);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get container path for " + str + " with exception " + e);
            return null;
        }
    }

    public static String getSdFilesystem(String str) {
        try {
            return getMountService().getSecureContainerFilesystemPath(str);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get container path for " + str + " with exception " + e);
            return null;
        }
    }

    public static String[] getSecureContainerList() {
        try {
            return getMountService().getSecureContainerList();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get secure container list with exception" + e);
            return null;
        }
    }

    public static boolean isContainerMounted(String str) {
        try {
            return getMountService().isSecureContainerMounted(str);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to find out if container " + str + " mounted");
            return false;
        }
    }

    public static boolean isExternalInstallPossible() {
        if (Environment.isExternalStorageEmulated() || !"mounted".equals(Environment.getExternalStorageState())) {
            return Environment.isNoEmulatedStorageExist() && "mounted".equals(Environment.getSecondaryStorageState());
        }
        return true;
    }

    public static String mountSdDir(String str, String str2, int i) {
        return mountSdDir(str, str2, i, true);
    }

    public static String mountSdDir(String str, String str2, int i, boolean z) {
        try {
            int mountSecureContainer = getMountService().mountSecureContainer(str, str2, i, z);
            if (mountSecureContainer != 0) {
                Log.i(TAG, "Failed to mount container " + str + " rc : " + mountSecureContainer);
                return null;
            }
            return getMountService().getSecureContainerPath(str);
        } catch (RemoteException e) {
            Log.e(TAG, "MountService running?");
            return null;
        }
    }

    public static boolean renameSdDir(String str, String str2) {
        try {
            int renameSecureContainer = getMountService().renameSecureContainer(str, str2);
            if (renameSecureContainer != 0) {
                Log.e(TAG, "Failed to rename " + str + " to " + str2 + "with rc " + renameSecureContainer);
                return false;
            }
            return true;
        } catch (RemoteException e) {
            Log.i(TAG, "Failed ot rename  " + str + " to " + str2 + " with exception : " + e);
            return false;
        }
    }

    public static String replaceEnd(String str, String str2, String str3) {
        if (str.endsWith(str2)) {
            return str.substring(0, str.length() - str2.length()) + str3;
        }
        throw new IllegalArgumentException("Expected " + str + " to end with " + str2);
    }

    public static boolean resizeSdDir(long j, String str, String str2) {
        try {
            if (getMountService().resizeSecureContainer(str, ((int) ((j + 1048576) / 1048576)) + 1, str2) == 0) {
                return true;
            }
        } catch (RemoteException e) {
            Log.e(TAG, "MountService running?");
        }
        Log.e(TAG, "Failed to create secure container " + str);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005e, code lost:
        if (r10 == true) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0098, code lost:
        if (r10 == true) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int resolveInstallLocation(android.content.Context r5, java.lang.String r6, int r7, long r8, int r10) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.content.PackageHelper.resolveInstallLocation(android.content.Context, java.lang.String, int, long, int):int");
    }

    public static boolean unMountSdDir(String str) {
        try {
            int unmountSecureContainer = getMountService().unmountSecureContainer(str, true);
            if (unmountSecureContainer != 0) {
                Log.e(TAG, "Failed to unmount " + str + " with rc " + unmountSecureContainer);
                return false;
            }
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "MountService running?");
            return false;
        }
    }
}
