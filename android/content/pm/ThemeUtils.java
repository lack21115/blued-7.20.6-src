package android.content.pm;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.PackageParser;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.ThemeConfig;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.FileUtils;
import android.os.SystemProperties;
import android.provider.MediaStore;
import android.provider.Settings;
import android.provider.ThemesContract;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.StrictJarFile;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/ThemeUtils.class */
public class ThemeUtils {
    public static final String ACTION_THEME_CHANGED = "org.mokee.intent.action.THEME_CHANGED";
    public static final String CATEGORY_THEME_COMPONENT_PREFIX = "org.mokee.intent.category.";
    public static final String COMMON_RES_PATH = "assets/overlays/common/";
    public static final String COMMON_RES_SUFFIX = ".common";
    public static final String COMMON_RES_TARGET = "common";
    private static final String DEFAULT_PKG = "default";
    public static final String EXTRA_COMPONENTS = "components";
    public static final String EXTRA_REQUEST_TYPE = "request_type";
    public static final String EXTRA_UPDATE_TIME = "update_time";
    public static final String FONT_XML = "fonts.xml";
    public static final String ICONS_PATH = "assets/icons/";
    public static final String ICON_HASH_FILENAME = "hash";
    private static final byte IDMAP_HASH_VERSION = 3;
    public static final String IDMAP_SUFFIX = "@idmap";
    public static final String LOCKSCREEN_WALLPAPER_PATH = "lockscreen";
    private static final String MANIFEST_NAME = "META-INF/MANIFEST.MF";
    private static final String MEDIA_CONTENT_URI = "content://media/internal/audio/media";
    public static final String OVERLAY_PATH = "assets/overlays/";
    public static final String RESOURCE_CACHE_DIR = "/data/resource-cache/";
    private static final String SETTINGS_DB = "/data/data/com.android.providers.settings/databases/settings.db";
    private static final String SETTINGS_SECURE_TABLE = "secure";
    public static final String SYSTEM_ALARMS_PATH = null;
    public static final String SYSTEM_MEDIA_PATH = "/system/media/audio";
    public static final String SYSTEM_NOTIFICATIONS_PATH = null;
    public static final String SYSTEM_RINGTONES_PATH = null;
    public static final int SYSTEM_TARGET_API = 0;
    public static final String SYSTEM_THEME_ALARM_PATH = null;
    public static final String SYSTEM_THEME_FONT_PATH = null;
    public static final String SYSTEM_THEME_ICON_CACHE_DIR = null;
    public static final String SYSTEM_THEME_NOTIFICATION_PATH = null;
    public static final String SYSTEM_THEME_PATH = "/data/system/theme";
    public static final String SYSTEM_THEME_RINGTONE_PATH = null;
    private static final String TAG = "ThemeUtils";
    public static final String THEME_BOOTANIMATION_PATH = "assets/bootanimation/bootanimation.zip";
    public static final String WALLPAPER_PATH = "wallpapers";
    public static final String[] sSupportedActions = null;
    public static final String[] sSupportedCategories = null;

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/ThemeUtils$ThemedUiContext.class */
    private static class ThemedUiContext extends ContextWrapper {
        private Context mAppContext;

        public ThemedUiContext(Context context, Context context2) {
            super(context);
            this.mAppContext = context2;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return this.mAppContext;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public String getPackageName() {
            return this.mAppContext.getPackageName();
        }
    }

    static {
        new StringBuilder();
        throw new VerifyError("bad dex opcode");
    }

    public static void clearAudibles(Context context, String str) {
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        String[] list = file.list();
        ContentResolver contentResolver = context.getContentResolver();
        int length = list.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str2 = str + File.separator + list[i2];
            contentResolver.delete(MediaStore.Audio.Media.getContentUriForPath(str2), "_data=\"" + str2 + "\"", null);
            new File(str2).delete();
            i = i2 + 1;
        }
    }

    public static void clearIconCache() {
        FileUtils.deleteContents(new File(SYSTEM_THEME_ICON_CACHE_DIR));
    }

    public static void closeQuietly(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException e) {
        }
    }

    public static void closeQuietly(OutputStream outputStream) {
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
    }

    public static void completeComponentMap(Context context, Map<String, String> map) {
        if (map == null) {
            return;
        }
        Map<String, String> defaultComponents = getDefaultComponents(context);
        for (String str : defaultComponents.keySet()) {
            if (!map.containsKey(str)) {
                map.put(str, defaultComponents.get(str));
            }
        }
    }

    public static void copyAndScaleBootAnimation(Context context, InputStream inputStream, String str) throws IOException {
        int i;
        int i2;
        int i3;
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(inputStream));
        zipOutputStream.setMethod(0);
        byte[] bArr = new byte[4096];
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                zipOutputStream.close();
                return;
            }
            ZipEntry zipEntry = new ZipEntry(nextEntry.getName());
            zipEntry.setMethod(0);
            zipEntry.setCrc(nextEntry.getCrc());
            zipEntry.setSize(nextEntry.getSize());
            zipEntry.setCompressedSize(nextEntry.getSize());
            if (nextEntry.getName().equals("desc.txt")) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(zipInputStream));
                String[] split = bufferedReader.readLine().split(" ");
                WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
                if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                    i = displayMetrics.heightPixels;
                    i2 = displayMetrics.widthPixels;
                } else {
                    i = displayMetrics.widthPixels;
                    i2 = displayMetrics.heightPixels;
                }
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                if (parseInt == parseInt2) {
                    i3 = i;
                } else {
                    int i4 = (int) (parseInt2 * (i / parseInt));
                    i3 = i2;
                    if (i4 < i2) {
                        i3 = i4;
                    }
                }
                CRC32 crc32 = new CRC32();
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                String format = String.format("%d %d %s\n", Integer.valueOf(i), Integer.valueOf(i3), split[2]);
                wrap.put(format.getBytes());
                int length = 0 + format.getBytes().length;
                crc32.update(format.getBytes());
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String format2 = String.format("%s\n", readLine);
                    wrap.put(format2.getBytes());
                    length += format2.getBytes().length;
                    crc32.update(format2.getBytes());
                }
                zipEntry.setCrc(crc32.getValue());
                zipEntry.setSize(length);
                zipEntry.setCompressedSize(length);
                zipOutputStream.putNextEntry(zipEntry);
                zipOutputStream.write(wrap.array(), 0, length);
            } else {
                zipOutputStream.putNextEntry(zipEntry);
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read > 0) {
                        zipOutputStream.write(bArr, 0, read);
                    }
                }
            }
            zipOutputStream.closeEntry();
        }
    }

    public static void createAlarmDirIfNotExists() {
        createDirIfNotExists(SYSTEM_THEME_ALARM_PATH);
    }

    public static void createCacheDirIfNotExists() throws IOException {
        File file = new File(RESOURCE_CACHE_DIR);
        if (!file.exists() && !file.mkdir()) {
            throw new IOException("Could not create dir: " + file.toString());
        }
        FileUtils.setPermissions(file, 509, -1, -1);
    }

    private static void createDirIfNotExists(String str) {
        if (dirExists(str)) {
            return;
        }
        File file = new File(str);
        if (file.mkdir()) {
            FileUtils.setPermissions(file, 509, -1, -1);
        }
    }

    public static void createFontDirIfNotExists() {
        createDirIfNotExists(SYSTEM_THEME_FONT_PATH);
    }

    public static void createIconCacheDirIfNotExists() {
        createDirIfNotExists(SYSTEM_THEME_ICON_CACHE_DIR);
    }

    public static void createIconDirIfNotExists(String str) throws IOException {
        createDirIfNotExists(getOverlayResourceCacheDir(str));
        File file = new File(getIconPackDir(str));
        if (!file.exists() && !file.mkdir()) {
            throw new IOException("Could not create dir: " + file.toString());
        }
        FileUtils.setPermissions(file, 509, -1, -1);
    }

    public static void createNotificationDirIfNotExists() {
        createDirIfNotExists(SYSTEM_THEME_NOTIFICATION_PATH);
    }

    public static void createResourcesDirIfNotExists(String str, String str2) throws IOException {
        createDirIfNotExists(getOverlayResourceCacheDir(str2));
        File file = new File(getTargetCacheDir(str, str2));
        if (!file.exists() && !file.mkdir()) {
            throw new IOException("Could not create dir: " + file.toString());
        }
        FileUtils.setPermissions(file, 509, -1, -1);
    }

    public static void createRingtoneDirIfNotExists() {
        createDirIfNotExists(SYSTEM_THEME_RINGTONE_PATH);
    }

    public static void createThemeDirIfNotExists() {
        createDirIfNotExists(SYSTEM_THEME_PATH);
    }

    public static Context createUiContext(Context context) {
        try {
            return new ThemedUiContext(context.createPackageContext(ThemeConfig.SYSTEMUI_STATUS_BAR_PKG, 4), context.getApplicationContext());
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    private static boolean dirExists(String str) {
        File file = new File(str);
        return file.exists() && file.isDirectory();
    }

    public static List<String> getAllComponents() {
        ArrayList arrayList = new ArrayList(9);
        arrayList.add(ThemesContract.ThemesColumns.MODIFIES_FONTS);
        arrayList.add(ThemesContract.ThemesColumns.MODIFIES_LAUNCHER);
        arrayList.add(ThemesContract.ThemesColumns.MODIFIES_ALARMS);
        arrayList.add(ThemesContract.ThemesColumns.MODIFIES_BOOT_ANIM);
        arrayList.add(ThemesContract.ThemesColumns.MODIFIES_ICONS);
        arrayList.add(ThemesContract.ThemesColumns.MODIFIES_LOCKSCREEN);
        arrayList.add(ThemesContract.ThemesColumns.MODIFIES_NOTIFICATIONS);
        arrayList.add(ThemesContract.ThemesColumns.MODIFIES_OVERLAYS);
        arrayList.add(ThemesContract.ThemesColumns.MODIFIES_RINGTONES);
        arrayList.add(ThemesContract.ThemesColumns.MODIFIES_STATUS_BAR);
        arrayList.add(ThemesContract.ThemesColumns.MODIFIES_NAVIGATION_BAR);
        arrayList.add(ThemesContract.ThemesColumns.MODIFIES_LIVE_LOCK_SCREEN);
        return arrayList;
    }

    /* JADX WARN: Finally extract failed */
    public static ThemeConfig getBootThemeDirty() {
        ThemeConfig themeConfig;
        SQLiteDatabase sQLiteDatabase = null;
        SQLiteDatabase sQLiteDatabase2 = null;
        ThemeConfig themeConfig2 = null;
        try {
            try {
                SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(SETTINGS_DB, null, 1);
                ThemeConfig themeConfig3 = null;
                if (openDatabase != null) {
                    Cursor query = openDatabase.query(SETTINGS_SECURE_TABLE, new String[]{"value"}, "name=?", new String[]{Configuration.THEME_PKG_CONFIGURATION_PERSISTENCE_PROPERTY}, null, null, null);
                    themeConfig3 = null;
                    if (query != null) {
                        themeConfig3 = null;
                        if (query.getCount() > 0) {
                            query.moveToFirst();
                            String string = query.getString(0);
                            themeConfig3 = null;
                            if (string != null) {
                                themeConfig3 = ThemeConfig.fromJson(string);
                            }
                        }
                        sQLiteDatabase2 = openDatabase;
                        themeConfig2 = themeConfig3;
                        sQLiteDatabase = openDatabase;
                        query.close();
                    }
                }
                themeConfig = themeConfig3;
                if (openDatabase != null) {
                    openDatabase.close();
                    themeConfig = themeConfig3;
                }
            } catch (Exception e) {
                sQLiteDatabase = sQLiteDatabase2;
                Log.w(TAG, "Unable to open /data/data/com.android.providers.settings/databases/settings.db", e);
                themeConfig = themeConfig2;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                    return themeConfig2;
                }
            }
            return themeConfig;
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    public static String getCommonPackageName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return "common";
    }

    public static String getDefaultAudiblePath(int i) {
        String str = null;
        switch (i) {
            case 1:
                String str2 = SystemProperties.get("ro.config.ringtone", null);
                String str3 = null;
                if (str2 != null) {
                    str3 = SYSTEM_RINGTONES_PATH + File.separator + str2;
                }
                return str3;
            case 2:
                String str4 = SystemProperties.get("ro.config.notification_sound", null);
                String str5 = null;
                if (str4 != null) {
                    str5 = SYSTEM_NOTIFICATIONS_PATH + File.separator + str4;
                }
                return str5;
            case 3:
            default:
                return null;
            case 4:
                String str6 = SystemProperties.get("ro.config.alarm_alert", null);
                if (str6 != null) {
                    str = SYSTEM_ALARMS_PATH + File.separator + str6;
                }
                return str;
        }
    }

    public static Map<String, String> getDefaultComponents(Context context) {
        String defaultThemePackageName = getDefaultThemePackageName(context);
        List<String> supportedComponents = getSupportedComponents(context, "system");
        List<String> supportedComponents2 = "system".equals(defaultThemePackageName) ? null : getSupportedComponents(context, defaultThemePackageName);
        HashMap hashMap = new HashMap(supportedComponents.size());
        if (supportedComponents2 != null) {
            for (String str : supportedComponents2) {
                hashMap.put(str, defaultThemePackageName);
            }
        }
        for (String str2 : supportedComponents) {
            if (!hashMap.containsKey(str2)) {
                hashMap.put(str2, "system");
            }
        }
        return hashMap;
    }

    public static String getDefaultThemePackageName(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.DEFAULT_THEME_PACKAGE);
        if (TextUtils.isEmpty(string)) {
            return "system";
        }
        try {
            return context.getPackageManager().getPackageInfo(string, 0) != null ? string : "system";
        } catch (PackageManager.NameNotFoundException e) {
            Log.w(TAG, "Default theme " + string + " not found", e);
            return "system";
        }
    }

    private static String getFirstNonEmptyAsset(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            String str = strArr[i2];
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            i = i2 + 1;
        }
    }

    public static String getIconHashFile(String str) {
        return getIconPackDir(str) + File.separator + ICON_HASH_FILENAME;
    }

    public static String getIconPackApkPath(String str) {
        return getIconPackDir(str) + "/resources.apk";
    }

    public static String getIconPackDir(String str) {
        return getOverlayResourceCacheDir(str) + File.separator + "icons";
    }

    public static String getIconPackResPath(String str) {
        return getIconPackDir(str) + "/resources.arsc";
    }

    public static String getIdmapPath(String str, String str2) {
        return getTargetCacheDir(str, str2) + File.separator + "idmap";
    }

    public static InputStream getInputStreamFromAsset(Context context, String str) throws IOException {
        if (context == null || str == null) {
            return null;
        }
        return context.getAssets().open(str.substring("file:///android_asset/".length()));
    }

    public static String getLockscreenWallpaperPath(AssetManager assetManager) throws IOException {
        String firstNonEmptyAsset = getFirstNonEmptyAsset(assetManager.list("lockscreen"));
        if (firstNonEmptyAsset == null) {
            return null;
        }
        return "lockscreen" + File.separator + firstNonEmptyAsset;
    }

    public static String getOverlayPathToTarget(String str) {
        return OVERLAY_PATH + str + '/';
    }

    public static String getOverlayResourceCacheDir(String str) {
        return RESOURCE_CACHE_DIR + str;
    }

    public static int getPackageHashCode(PackageParser.Package r3, StrictJarFile strictJarFile) {
        int i;
        int i2;
        int hashCode = r3.manifestDigest != null ? r3.manifestDigest.hashCode() : 0;
        ZipEntry findEntry = strictJarFile.findEntry("META-INF/MANIFEST.MF");
        int i3 = hashCode;
        if (findEntry != null) {
            try {
                ManifestDigest fromInputStream = ManifestDigest.fromInputStream(strictJarFile.getInputStream(findEntry));
                i3 = hashCode;
                if (fromInputStream != null) {
                    i3 = hashCode + fromInputStream.hashCode();
                }
                i = i3;
                i2 = i3;
                strictJarFile.close();
            } catch (IOException e) {
                i3 = i;
            } catch (RuntimeException e2) {
                i3 = i2;
            }
        }
        return (i3 * 31) + 3;
    }

    public static List<String> getSupportedComponents(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        Cursor query = context.getContentResolver().query(ThemesContract.ThemesColumns.CONTENT_URI, null, "pkg_name= ?", new String[]{str}, null);
        if (query != null) {
            if (query.moveToFirst()) {
                for (String str2 : getAllComponents()) {
                    if (query.getInt(query.getColumnIndex(str2)) == 1) {
                        arrayList.add(str2);
                    }
                }
            }
            query.close();
        }
        return arrayList;
    }

    public static String getTargetCacheDir(String str, PackageInfo packageInfo) {
        return getTargetCacheDir(str, packageInfo.packageName);
    }

    public static String getTargetCacheDir(String str, PackageParser.Package r4) {
        return getTargetCacheDir(str, r4.packageName);
    }

    public static String getTargetCacheDir(String str, String str2) {
        return getOverlayResourceCacheDir(str2) + File.separator + str;
    }

    public static String getWallpaperPath(AssetManager assetManager) throws IOException {
        String firstNonEmptyAsset = getFirstNonEmptyAsset(assetManager.list(WALLPAPER_PATH));
        if (firstNonEmptyAsset == null) {
            return null;
        }
        return WALLPAPER_PATH + File.separator + firstNonEmptyAsset;
    }

    public static List<String> getWallpaperPathList(AssetManager assetManager) throws IOException {
        ArrayList arrayList = new ArrayList();
        String[] list = assetManager.list(WALLPAPER_PATH);
        int length = list.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            String str = list[i2];
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(WALLPAPER_PATH + File.separator + str);
            }
            i = i2 + 1;
        }
    }

    public static boolean isPerAppThemeComponent(String str) {
        return ("default".equals(str) || ThemeConfig.SYSTEMUI_STATUS_BAR_PKG.equals(str) || ThemeConfig.SYSTEMUI_NAVBAR_PKG.equals(str)) ? false : true;
    }

    public static boolean isValidAudible(String str) {
        if (str != null) {
            return str.endsWith(".mp3") || str.endsWith(".ogg");
        }
        return false;
    }

    public static void registerThemeChangeReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        context.registerReceiver(broadcastReceiver, new IntentFilter(ACTION_THEME_CHANGED));
    }

    public static boolean setAudible(Context context, File file, int i, String str) {
        String absolutePath = file.getAbsolutePath();
        String str2 = str.endsWith(".ogg") ? "audio/ogg" : "audio/mp3";
        ContentValues contentValues = new ContentValues();
        contentValues.put("_data", absolutePath);
        contentValues.put("title", str);
        contentValues.put("mime_type", str2);
        contentValues.put("_size", Long.valueOf(file.length()));
        contentValues.put(MediaStore.Audio.AudioColumns.IS_RINGTONE, Boolean.valueOf(i == 1));
        contentValues.put(MediaStore.Audio.AudioColumns.IS_NOTIFICATION, Boolean.valueOf(i == 2));
        contentValues.put(MediaStore.Audio.AudioColumns.IS_ALARM, Boolean.valueOf(i == 4));
        contentValues.put(MediaStore.Audio.AudioColumns.IS_MUSIC, (Boolean) false);
        Uri contentUriForPath = MediaStore.Audio.Media.getContentUriForPath(absolutePath);
        Cursor query = context.getContentResolver().query(contentUriForPath, new String[]{"_id"}, "_data='" + absolutePath + "'", null, null);
        Uri uri = null;
        if (query != null) {
            uri = null;
            if (query.getCount() > 0) {
                query.moveToFirst();
                long j = query.getLong(0);
                query.close();
                uri = Uri.withAppendedPath(Uri.parse(MEDIA_CONTENT_URI), "" + j);
                context.getContentResolver().update(contentUriForPath, contentValues, "_id=" + j, null);
            }
        }
        Uri uri2 = uri;
        if (uri == null) {
            uri2 = context.getContentResolver().insert(contentUriForPath, contentValues);
        }
        try {
            RingtoneManager.setActualDefaultRingtoneUri(context, i, uri2);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean setDefaultAudible(Context context, int i) {
        String defaultAudiblePath = getDefaultAudiblePath(i);
        if (defaultAudiblePath != null) {
            Uri contentUriForPath = MediaStore.Audio.Media.getContentUriForPath(defaultAudiblePath);
            Cursor query = context.getContentResolver().query(contentUriForPath, new String[]{"_id"}, "_data='" + defaultAudiblePath + "'", null, null);
            Uri uri = contentUriForPath;
            if (query != null) {
                uri = contentUriForPath;
                if (query.getCount() > 0) {
                    query.moveToFirst();
                    long j = query.getLong(0);
                    query.close();
                    uri = Uri.withAppendedPath(Uri.parse(MEDIA_CONTENT_URI), "" + j);
                }
            }
            if (uri != null) {
                RingtoneManager.setActualDefaultRingtoneUri(context, i, uri);
                return true;
            }
            return true;
        }
        return false;
    }
}
