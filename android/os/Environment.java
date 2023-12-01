package android.os;

import android.os.storage.IMountService;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.annotations.GuardedBy;
import com.android.internal.util.cm.PowerMenuConstants;
import com.google.android.collect.Lists;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/os/Environment.class */
public class Environment {
    private static final File DATA_DIRECTORY;
    public static String DIRECTORY_ALARMS;
    @Deprecated
    public static final String DIRECTORY_ANDROID = "Android";
    public static String DIRECTORY_DCIM;
    public static String DIRECTORY_DOCUMENTS;
    public static String DIRECTORY_DOWNLOADS;
    public static String DIRECTORY_MOVIES;
    public static String DIRECTORY_MUSIC;
    public static String DIRECTORY_NOTIFICATIONS;
    public static String DIRECTORY_PICTURES;
    public static String DIRECTORY_PODCASTS;
    public static String DIRECTORY_RINGTONES;
    public static final String DIR_ANDROID = "Android";
    private static final String DIR_CACHE = "cache";
    private static final String DIR_DATA = "data";
    private static final String DIR_FILES = "files";
    private static final String DIR_MEDIA = "media";
    private static final String DIR_OBB = "obb";
    private static final File DOWNLOAD_CACHE_DIRECTORY;
    private static final String ENV_EMULATED_STORAGE_SOURCE = "EMULATED_STORAGE_SOURCE";
    private static final String ENV_EXTERNAL_STORAGE = "EXTERNAL_STORAGE";
    private static final String ENV_SECONDARY_STORAGE = "SECONDARY_STORAGE";
    public static final String MEDIA_BAD_REMOVAL = "bad_removal";
    public static final String MEDIA_CHECKING = "checking";
    public static final String MEDIA_FORMATTING = "formatting";
    public static final String MEDIA_MOUNTED = "mounted";
    public static final String MEDIA_MOUNTED_READ_ONLY = "mounted_ro";
    public static final String MEDIA_NOFS = "nofs";
    public static final String MEDIA_REMOVED = "removed";
    public static final String MEDIA_SHARED = "shared";
    public static final String MEDIA_UNKNOWN = "unknown";
    public static final String MEDIA_UNMOUNTABLE = "unmountable";
    public static final String MEDIA_UNMOUNTED = "unmounted";
    private static final File SECURE_DATA_DIRECTORY;
    private static final String SYSTEM_PROPERTY_EFS_ENABLED = "persist.security.efs.enabled";
    private static final String TAG = "Environment";
    private static UserEnvironment sCurrentUser;
    @GuardedBy("sLock")
    private static volatile StorageVolume sNoEmulatedVolume;
    private static boolean sUserRequired;
    private static final String ENV_ANDROID_ROOT = "ANDROID_ROOT";
    private static final File DIR_ANDROID_ROOT = getDirectory(ENV_ANDROID_ROOT, "/system");
    private static final String ENV_OEM_ROOT = "OEM_ROOT";
    private static final File DIR_OEM_ROOT = getDirectory(ENV_OEM_ROOT, "/oem");
    private static final String ENV_VENDOR_ROOT = "VENDOR_ROOT";
    private static final File DIR_VENDOR_ROOT = getDirectory(ENV_VENDOR_ROOT, "/vendor");
    private static final String ENV_PREBUNDLED_ROOT = "PREBUNDLED_ROOT";
    private static final File DIR_PREBUNDLED_ROOT = getDirectory(ENV_PREBUNDLED_ROOT, "/vendor/bundled-app");
    private static final String ENV_MEDIA_STORAGE = "MEDIA_STORAGE";
    private static final File DIR_MEDIA_STORAGE = getDirectory(ENV_MEDIA_STORAGE, "/data/media");
    private static final String ENV_EMULATED_STORAGE_TARGET = "EMULATED_STORAGE_TARGET";
    private static final String CANONCIAL_EMULATED_STORAGE_TARGET = getCanonicalPathOrNull(ENV_EMULATED_STORAGE_TARGET);
    private static final Object sLock = new Object();

    /* loaded from: source-9557208-dex2jar.jar:android/os/Environment$UserEnvironment.class */
    public static class UserEnvironment {
        private final File mEmulatedDirForDirect;
        private final File[] mExternalDirsForApp;
        private final File[] mExternalDirsForVold;

        public UserEnvironment(int i) {
            String str = System.getenv(Environment.ENV_EXTERNAL_STORAGE);
            String str2 = System.getenv(Environment.ENV_EMULATED_STORAGE_SOURCE);
            String str3 = System.getenv(Environment.ENV_EMULATED_STORAGE_TARGET);
            String str4 = System.getenv(Environment.ENV_MEDIA_STORAGE);
            String str5 = TextUtils.isEmpty(str4) ? "/data/media" : str4;
            ArrayList newArrayList = Lists.newArrayList();
            ArrayList newArrayList2 = Lists.newArrayList();
            if (TextUtils.isEmpty(str3)) {
                String str6 = str;
                if (TextUtils.isEmpty(str)) {
                    Log.w(Environment.TAG, "EXTERNAL_STORAGE undefined; falling back to default");
                    str6 = "/storage/sdcard0";
                }
                newArrayList.add(new File(str6));
                newArrayList2.add(new File(str6));
                this.mEmulatedDirForDirect = new File(str5);
            } else {
                String num = Integer.toString(i);
                File file = new File(str2);
                File file2 = new File(str3);
                File file3 = new File(str5);
                newArrayList.add(Environment.buildPath(file, num));
                newArrayList2.add(Environment.buildPath(file2, num));
                this.mEmulatedDirForDirect = Environment.buildPath(file3, num);
            }
            String str7 = System.getenv(Environment.ENV_SECONDARY_STORAGE);
            if (!TextUtils.isEmpty(str7) && i == 0) {
                String[] split = str7.split(":");
                int length = split.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        break;
                    }
                    String str8 = split[i3];
                    newArrayList.add(new File(str8));
                    newArrayList2.add(new File(str8));
                    i2 = i3 + 1;
                }
            }
            this.mExternalDirsForVold = (File[]) newArrayList.toArray(new File[newArrayList.size()]);
            this.mExternalDirsForApp = (File[]) newArrayList2.toArray(new File[newArrayList2.size()]);
        }

        public File[] buildExternalStorageAndroidDataDirs() {
            return Environment.buildPaths(this.mExternalDirsForApp, "Android", "data");
        }

        public File[] buildExternalStorageAndroidObbDirs() {
            return Environment.buildPaths(this.mExternalDirsForApp, "Android", "obb");
        }

        public File[] buildExternalStorageAndroidObbDirsForVold() {
            return Environment.buildPaths(this.mExternalDirsForVold, "Android", "obb");
        }

        public File[] buildExternalStorageAppCacheDirs(String str) {
            return Environment.buildPaths(this.mExternalDirsForApp, "Android", "data", str, Environment.DIR_CACHE);
        }

        public File[] buildExternalStorageAppDataDirs(String str) {
            return Environment.buildPaths(this.mExternalDirsForApp, "Android", "data", str);
        }

        public File[] buildExternalStorageAppDataDirsForVold(String str) {
            return Environment.buildPaths(this.mExternalDirsForVold, "Android", "data", str);
        }

        public File[] buildExternalStorageAppFilesDirs(String str) {
            return Environment.buildPaths(this.mExternalDirsForApp, "Android", "data", str, Environment.DIR_FILES);
        }

        public File[] buildExternalStorageAppMediaDirs(String str) {
            return Environment.buildPaths(this.mExternalDirsForApp, "Android", "media", str);
        }

        public File[] buildExternalStorageAppMediaDirsForVold(String str) {
            return Environment.buildPaths(this.mExternalDirsForVold, "Android", "media", str);
        }

        public File[] buildExternalStorageAppObbDirs(String str) {
            return Environment.buildPaths(this.mExternalDirsForApp, "Android", "obb", str);
        }

        public File[] buildExternalStorageAppObbDirsForVold(String str) {
            return Environment.buildPaths(this.mExternalDirsForVold, "Android", "obb", str);
        }

        public File[] buildExternalStoragePublicDirs(String str) {
            return Environment.buildPaths(this.mExternalDirsForApp, str);
        }

        public File[] getExternalDirsForApp() {
            return this.mExternalDirsForApp;
        }

        public File[] getExternalDirsForVold() {
            return this.mExternalDirsForVold;
        }

        @Deprecated
        public File getExternalStorageDirectory() {
            return this.mExternalDirsForApp[0];
        }

        @Deprecated
        public File getExternalStoragePublicDirectory(String str) {
            return buildExternalStoragePublicDirs(str)[0];
        }

        public File getMediaDir() {
            return this.mEmulatedDirForDirect;
        }

        public File getSecondaryStorageDirectory() {
            return this.mExternalDirsForApp.length > 1 ? this.mExternalDirsForApp[1] : this.mExternalDirsForApp[0];
        }
    }

    static {
        initForCurrentUser();
        DATA_DIRECTORY = getDirectory("ANDROID_DATA", "/data");
        SECURE_DATA_DIRECTORY = getDirectory("ANDROID_SECURE_DATA", "/data/secure");
        DOWNLOAD_CACHE_DIRECTORY = getDirectory("DOWNLOAD_CACHE", "/cache");
        DIRECTORY_MUSIC = "Music";
        DIRECTORY_PODCASTS = "Podcasts";
        DIRECTORY_RINGTONES = "Ringtones";
        DIRECTORY_ALARMS = "Alarms";
        DIRECTORY_NOTIFICATIONS = "Notifications";
        DIRECTORY_PICTURES = "Pictures";
        DIRECTORY_MOVIES = "Movies";
        DIRECTORY_DOWNLOADS = "Download";
        DIRECTORY_DCIM = "DCIM";
        DIRECTORY_DOCUMENTS = "Documents";
    }

    public static File[] buildExternalStorageAndroidDataDirs() {
        throwIfUserRequired();
        return sCurrentUser.buildExternalStorageAndroidDataDirs();
    }

    public static File[] buildExternalStorageAppCacheDirs(String str) {
        throwIfUserRequired();
        return sCurrentUser.buildExternalStorageAppCacheDirs(str);
    }

    public static File[] buildExternalStorageAppDataDirs(String str) {
        throwIfUserRequired();
        return sCurrentUser.buildExternalStorageAppDataDirs(str);
    }

    public static File[] buildExternalStorageAppFilesDirs(String str) {
        throwIfUserRequired();
        return sCurrentUser.buildExternalStorageAppFilesDirs(str);
    }

    public static File[] buildExternalStorageAppMediaDirs(String str) {
        throwIfUserRequired();
        return sCurrentUser.buildExternalStorageAppMediaDirs(str);
    }

    public static File[] buildExternalStorageAppObbDirs(String str) {
        throwIfUserRequired();
        return sCurrentUser.buildExternalStorageAppObbDirs(str);
    }

    public static File buildPath(File file, String... strArr) {
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return file;
            }
            String str = strArr[i2];
            file = file == null ? new File(str) : new File(file, str);
            i = i2 + 1;
        }
    }

    public static File[] buildPaths(File[] fileArr, String... strArr) {
        File[] fileArr2 = new File[fileArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fileArr.length) {
                return fileArr2;
            }
            fileArr2[i2] = buildPath(fileArr[i2], strArr);
            i = i2 + 1;
        }
    }

    private static String getCanonicalPathOrNull(String str) {
        String str2 = System.getenv(str);
        if (str2 == null) {
            return null;
        }
        try {
            return new File(str2).getCanonicalPath();
        } catch (IOException e) {
            Log.w(TAG, "Unable to resolve canonical path for " + str2);
            return null;
        }
    }

    public static File getDataDirectory() {
        return DATA_DIRECTORY;
    }

    static File getDirectory(String str, String str2) {
        String str3 = System.getenv(str);
        return str3 == null ? new File(str2) : new File(str3);
    }

    public static File getDownloadCacheDirectory() {
        return DOWNLOAD_CACHE_DIRECTORY;
    }

    public static File getEmulatedStorageObbSource() {
        return new File(System.getenv(ENV_EMULATED_STORAGE_SOURCE), "obb");
    }

    public static File getEmulatedStorageSource(int i) {
        return new File(System.getenv(ENV_EMULATED_STORAGE_SOURCE), String.valueOf(i));
    }

    public static File getExternalStorageDirectory() {
        throwIfUserRequired();
        return sCurrentUser.getExternalStorageDirectory();
    }

    public static File getExternalStoragePublicDirectory(String str) {
        throwIfUserRequired();
        return sCurrentUser.buildExternalStoragePublicDirs(str)[0];
    }

    public static String getExternalStorageState() {
        return getExternalStorageState(sCurrentUser.getExternalDirsForApp()[0]);
    }

    public static String getExternalStorageState(File file) {
        StorageVolume storageVolume = getStorageVolume(file);
        if (storageVolume != null) {
            try {
                return IMountService.Stub.asInterface(ServiceManager.getService("mount")).getVolumeState(storageVolume.getPath());
            } catch (RemoteException e) {
                return "unknown";
            }
        }
        return "unknown";
    }

    public static File getLegacyExternalStorageDirectory() {
        return new File(System.getenv(ENV_EXTERNAL_STORAGE));
    }

    public static File getLegacyExternalStorageObbDirectory() {
        return buildPath(getLegacyExternalStorageDirectory(), "Android", "obb");
    }

    public static File getMediaStorageDirectory() {
        throwIfUserRequired();
        return sCurrentUser.getMediaDir();
    }

    private static StorageVolume getNoEmulatedVolume() {
        if (sNoEmulatedVolume == null) {
            synchronized (sLock) {
                if (sNoEmulatedVolume == null) {
                    try {
                        sNoEmulatedVolume = StorageManager.getNoEmulatedVolume(IMountService.Stub.asInterface(ServiceManager.getService("mount")).getVolumeList());
                    } catch (Exception e) {
                        Log.e(TAG, "couldn't talk to MountService", e);
                    }
                }
            }
        }
        return sNoEmulatedVolume;
    }

    public static File getOemDirectory() {
        return DIR_OEM_ROOT;
    }

    public static File getPrebundledDirectory() {
        return DIR_PREBUNDLED_ROOT;
    }

    public static File getRootDirectory() {
        return DIR_ANDROID_ROOT;
    }

    public static File getSecondaryStorageDirectory() {
        throwIfUserRequired();
        return sCurrentUser.getSecondaryStorageDirectory();
    }

    public static String getSecondaryStorageState() {
        return getStorageState(getSecondaryStorageDirectory());
    }

    public static File getSecureDataDirectory() {
        return isEncryptedFilesystemEnabled() ? SECURE_DATA_DIRECTORY : DATA_DIRECTORY;
    }

    @Deprecated
    public static String getStorageState(File file) {
        return getExternalStorageState(file);
    }

    private static StorageVolume getStorageVolume(File file) {
        try {
            File canonicalFile = file.getCanonicalFile();
            try {
                StorageVolume[] volumeList = IMountService.Stub.asInterface(ServiceManager.getService("mount")).getVolumeList();
                int length = volumeList.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return null;
                    }
                    StorageVolume storageVolume = volumeList[i2];
                    if (FileUtils.contains(storageVolume.getPathFile(), canonicalFile)) {
                        return storageVolume;
                    }
                    i = i2 + 1;
                }
            } catch (RemoteException e) {
                return null;
            }
        } catch (IOException e2) {
            return null;
        }
    }

    public static File getSystemSecureDirectory() {
        return isEncryptedFilesystemEnabled() ? new File(SECURE_DATA_DIRECTORY, "system") : new File(DATA_DIRECTORY, "system");
    }

    public static File getUserConfigDirectory(int i) {
        return new File(new File(new File(getDataDirectory(), "misc"), "user"), Integer.toString(i));
    }

    public static File getUserSystemDirectory(int i) {
        return new File(new File(getSystemSecureDirectory(), PowerMenuConstants.GLOBAL_ACTION_KEY_USERS), Integer.toString(i));
    }

    public static File getVendorDirectory() {
        return DIR_VENDOR_ROOT;
    }

    public static void initForCurrentUser() {
        sCurrentUser = new UserEnvironment(UserHandle.myUserId());
    }

    public static boolean isEncryptedFilesystemEnabled() {
        return SystemProperties.getBoolean(SYSTEM_PROPERTY_EFS_ENABLED, false);
    }

    public static boolean isExternalStorageEmulated() {
        if (isStorageDisabled()) {
            return false;
        }
        return isExternalStorageEmulated(sCurrentUser.getExternalDirsForApp()[0]);
    }

    public static boolean isExternalStorageEmulated(File file) {
        StorageVolume storageVolume = getStorageVolume(file);
        if (storageVolume != null) {
            return storageVolume.isEmulated();
        }
        throw new IllegalArgumentException("Failed to find storage device at " + file);
    }

    public static boolean isExternalStorageRemovable() {
        if (isStorageDisabled()) {
            return false;
        }
        return isExternalStorageRemovable(sCurrentUser.getExternalDirsForApp()[0]);
    }

    public static boolean isExternalStorageRemovable(File file) {
        StorageVolume storageVolume = getStorageVolume(file);
        if (storageVolume != null) {
            return storageVolume.isRemovable();
        }
        throw new IllegalArgumentException("Failed to find storage device at " + file);
    }

    public static boolean isNoEmulatedStorageExist() {
        return getNoEmulatedVolume() != null;
    }

    private static boolean isStorageDisabled() {
        return SystemProperties.getBoolean("config.disable_storage", false);
    }

    public static File maybeTranslateEmulatedPathToInternal(File file) {
        if (isExternalStorageEmulated() && CANONCIAL_EMULATED_STORAGE_TARGET != null) {
            try {
                String canonicalPath = file.getCanonicalPath();
                if (canonicalPath.startsWith(CANONCIAL_EMULATED_STORAGE_TARGET)) {
                    File file2 = new File(DIR_MEDIA_STORAGE, canonicalPath.substring(CANONCIAL_EMULATED_STORAGE_TARGET.length()));
                    if (file2.exists()) {
                        return file2;
                    }
                }
            } catch (IOException e) {
                Log.w(TAG, "Failed to resolve canonical path for " + file);
                return file;
            }
        }
        return file;
    }

    public static void setUserRequired(boolean z) {
        sUserRequired = z;
    }

    private static void throwIfUserRequired() {
        if (sUserRequired) {
            Log.wtf(TAG, "Path requests must specify a user by using UserEnvironment", new Throwable());
        }
    }
}
