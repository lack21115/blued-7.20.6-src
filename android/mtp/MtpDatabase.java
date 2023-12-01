package android.mtp;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.IContentProvider;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaScanner;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.RemoteException;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/mtp/MtpDatabase.class */
public class MtpDatabase {
    static final int[] AUDIO_PROPERTIES;
    private static final int DEVICE_PROPERTIES_DATABASE_VERSION = 1;
    static final int[] FILE_PROPERTIES;
    private static final String FORMAT_PARENT_WHERE = "format=? AND parent=?";
    private static final String FORMAT_WHERE = "format=?";
    private static final String ID_WHERE = "_id=?";
    static final int[] IMAGE_PROPERTIES;
    private static final String PARENT_WHERE = "parent=?";
    private static final String PATH_WHERE = "_data=?";
    private static final String STORAGE_FORMAT_PARENT_WHERE = "storage_id=? AND format=? AND parent=?";
    private static final String STORAGE_FORMAT_WHERE = "storage_id=? AND format=?";
    private static final String STORAGE_PARENT_WHERE = "storage_id=? AND parent=?";
    private static final String STORAGE_WHERE = "storage_id=?";
    private static final String TAG = "MtpDatabase";
    static final int[] VIDEO_PROPERTIES;
    private int mBatteryLevel;
    private int mBatteryScale;
    private final Context mContext;
    private boolean mDatabaseModified;
    private SharedPreferences mDeviceProperties;
    private final IContentProvider mMediaProvider;
    private final MediaScanner mMediaScanner;
    private final String mMediaStoragePath;
    private long mNativeContext;
    private final Uri mObjectsUri;
    private final String mPackageName;
    private MtpServer mServer;
    private final String[] mSubDirectories;
    private String mSubDirectoriesWhere;
    private String[] mSubDirectoriesWhereArgs;
    private final String mVolumeName;
    private static final String[] ID_PROJECTION = {"_id"};
    private static final String[] PATH_PROJECTION = {"_id", "_data"};
    private static final String[] FORMAT_PROJECTION = {"_id", "format"};
    private static final String[] PATH_FORMAT_PROJECTION = {"_id", "_data", "format"};
    private static final String[] OBJECT_INFO_PROJECTION = {"_id", MediaStore.Files.FileColumns.STORAGE_ID, "format", "parent", "_data", "date_added", "date_modified"};
    private final HashMap<String, MtpStorage> mStorageMap = new HashMap<>();
    private final HashMap<Integer, MtpPropertyGroup> mPropertyGroupsByProperty = new HashMap<>();
    private final HashMap<Integer, MtpPropertyGroup> mPropertyGroupsByFormat = new HashMap<>();
    private BroadcastReceiver mBatteryReceiver = new BroadcastReceiver() { // from class: android.mtp.MtpDatabase.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)) {
                MtpDatabase.this.mBatteryScale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 0);
                int intExtra = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                if (intExtra != MtpDatabase.this.mBatteryLevel) {
                    MtpDatabase.this.mBatteryLevel = intExtra;
                    if (MtpDatabase.this.mServer != null) {
                        MtpDatabase.this.mServer.sendDevicePropertyChanged(MtpConstants.DEVICE_PROPERTY_BATTERY_LEVEL);
                    }
                }
            }
        }
    };

    static {
        System.loadLibrary("media_jni");
        FILE_PROPERTIES = new int[]{MtpConstants.PROPERTY_STORAGE_ID, MtpConstants.PROPERTY_OBJECT_FORMAT, MtpConstants.PROPERTY_PROTECTION_STATUS, MtpConstants.PROPERTY_OBJECT_SIZE, MtpConstants.PROPERTY_OBJECT_FILE_NAME, MtpConstants.PROPERTY_DATE_MODIFIED, MtpConstants.PROPERTY_PARENT_OBJECT, MtpConstants.PROPERTY_PERSISTENT_UID, MtpConstants.PROPERTY_NAME, MtpConstants.PROPERTY_DISPLAY_NAME, MtpConstants.PROPERTY_DATE_ADDED};
        AUDIO_PROPERTIES = new int[]{MtpConstants.PROPERTY_STORAGE_ID, MtpConstants.PROPERTY_OBJECT_FORMAT, MtpConstants.PROPERTY_PROTECTION_STATUS, MtpConstants.PROPERTY_OBJECT_SIZE, MtpConstants.PROPERTY_OBJECT_FILE_NAME, MtpConstants.PROPERTY_DATE_MODIFIED, MtpConstants.PROPERTY_PARENT_OBJECT, MtpConstants.PROPERTY_PERSISTENT_UID, MtpConstants.PROPERTY_NAME, MtpConstants.PROPERTY_DISPLAY_NAME, MtpConstants.PROPERTY_DATE_ADDED, MtpConstants.PROPERTY_ARTIST, MtpConstants.PROPERTY_ALBUM_NAME, MtpConstants.PROPERTY_ALBUM_ARTIST, MtpConstants.PROPERTY_TRACK, MtpConstants.PROPERTY_ORIGINAL_RELEASE_DATE, MtpConstants.PROPERTY_DURATION, MtpConstants.PROPERTY_GENRE, MtpConstants.PROPERTY_COMPOSER, MtpConstants.PROPERTY_AUDIO_WAVE_CODEC, MtpConstants.PROPERTY_BITRATE_TYPE, MtpConstants.PROPERTY_AUDIO_BITRATE, MtpConstants.PROPERTY_NUMBER_OF_CHANNELS, MtpConstants.PROPERTY_SAMPLE_RATE};
        VIDEO_PROPERTIES = new int[]{MtpConstants.PROPERTY_STORAGE_ID, MtpConstants.PROPERTY_OBJECT_FORMAT, MtpConstants.PROPERTY_PROTECTION_STATUS, MtpConstants.PROPERTY_OBJECT_SIZE, MtpConstants.PROPERTY_OBJECT_FILE_NAME, MtpConstants.PROPERTY_DATE_MODIFIED, MtpConstants.PROPERTY_PARENT_OBJECT, MtpConstants.PROPERTY_PERSISTENT_UID, MtpConstants.PROPERTY_NAME, MtpConstants.PROPERTY_DISPLAY_NAME, MtpConstants.PROPERTY_DATE_ADDED, MtpConstants.PROPERTY_ARTIST, MtpConstants.PROPERTY_ALBUM_NAME, MtpConstants.PROPERTY_DURATION, MtpConstants.PROPERTY_DESCRIPTION};
        IMAGE_PROPERTIES = new int[]{MtpConstants.PROPERTY_STORAGE_ID, MtpConstants.PROPERTY_OBJECT_FORMAT, MtpConstants.PROPERTY_PROTECTION_STATUS, MtpConstants.PROPERTY_OBJECT_SIZE, MtpConstants.PROPERTY_OBJECT_FILE_NAME, MtpConstants.PROPERTY_DATE_MODIFIED, MtpConstants.PROPERTY_PARENT_OBJECT, MtpConstants.PROPERTY_PERSISTENT_UID, MtpConstants.PROPERTY_NAME, MtpConstants.PROPERTY_DISPLAY_NAME, MtpConstants.PROPERTY_DATE_ADDED, MtpConstants.PROPERTY_DESCRIPTION};
    }

    public MtpDatabase(Context context, String str, String str2, String[] strArr) {
        native_setup();
        this.mContext = context;
        this.mPackageName = context.getPackageName();
        this.mMediaProvider = context.getContentResolver().acquireProvider(MediaStore.AUTHORITY);
        this.mVolumeName = str;
        this.mMediaStoragePath = str2;
        this.mObjectsUri = MediaStore.Files.getMtpObjectsUri(str);
        this.mMediaScanner = new MediaScanner(context);
        this.mSubDirectories = strArr;
        if (strArr != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                sb.append("_data=? OR _data LIKE ?");
                if (i2 != length - 1) {
                    sb.append(" OR ");
                }
                i = i2 + 1;
            }
            sb.append(")");
            this.mSubDirectoriesWhere = sb.toString();
            this.mSubDirectoriesWhereArgs = new String[length * 2];
            int i3 = 0;
            for (String str3 : strArr) {
                int i4 = i3 + 1;
                this.mSubDirectoriesWhereArgs[i3] = str3;
                i3 = i4 + 1;
                this.mSubDirectoriesWhereArgs[i4] = str3 + "/%";
            }
        }
        Locale locale = context.getResources().getConfiguration().locale;
        if (locale != null) {
            String language = locale.getLanguage();
            String country = locale.getCountry();
            if (language != null) {
                if (country != null) {
                    this.mMediaScanner.setLocale(language + "_" + country);
                } else {
                    this.mMediaScanner.setLocale(language);
                }
            }
        }
        initDeviceProperties(context);
    }

    private int beginSendObject(String str, int i, int i2, int i3, long j, long j2) {
        if (!inStorageRoot(str)) {
            Log.e(TAG, "attempt to put file outside of storage area: " + str);
            return -1;
        } else if (inStorageSubDirectory(str)) {
            if (str != null) {
                Cursor cursor = null;
                Cursor cursor2 = null;
                try {
                    try {
                        Cursor query = this.mMediaProvider.query(this.mPackageName, this.mObjectsUri, ID_PROJECTION, PATH_WHERE, new String[]{str}, null, null);
                        if (query != null && query.getCount() > 0) {
                            cursor2 = query;
                            cursor = query;
                            Log.w(TAG, "file already exists in beginSendObject: " + str);
                            if (query != null) {
                                query.close();
                                return -1;
                            }
                            return -1;
                        } else if (query != null) {
                            query.close();
                        }
                    } catch (RemoteException e) {
                        cursor = cursor2;
                        Log.e(TAG, "RemoteException in beginSendObject", e);
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            this.mDatabaseModified = true;
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", str);
            contentValues.put("format", Integer.valueOf(i));
            contentValues.put("parent", Integer.valueOf(i2));
            contentValues.put(MediaStore.Files.FileColumns.STORAGE_ID, Integer.valueOf(i3));
            contentValues.put("_size", Long.valueOf(j));
            contentValues.put("date_modified", Long.valueOf(j2));
            try {
                Uri insert = this.mMediaProvider.insert(this.mPackageName, this.mObjectsUri, contentValues);
                if (insert != null) {
                    return Integer.parseInt(insert.getPathSegments().get(2));
                }
                return -1;
            } catch (RemoteException e2) {
                Log.e(TAG, "RemoteException in beginSendObject", e2);
                return -1;
            }
        } else {
            return -1;
        }
    }

    private Cursor createObjectQuery(int i, int i2, int i3) throws RemoteException {
        String str;
        String[] strArr;
        int i4;
        if (i == -1) {
            if (i2 == 0) {
                if (i3 == 0) {
                    str = null;
                    strArr = null;
                } else {
                    int i5 = i3;
                    if (i3 == -1) {
                        i5 = 0;
                    }
                    str = PARENT_WHERE;
                    strArr = new String[]{Integer.toString(i5)};
                }
            } else if (i3 == 0) {
                str = FORMAT_WHERE;
                strArr = new String[]{Integer.toString(i2)};
            } else {
                int i6 = i3;
                if (i3 == -1) {
                    i6 = 0;
                }
                str = FORMAT_PARENT_WHERE;
                strArr = new String[]{Integer.toString(i2), Integer.toString(i6)};
            }
        } else if (i2 == 0) {
            if (i3 == 0) {
                str = STORAGE_WHERE;
                strArr = new String[]{Integer.toString(i)};
            } else {
                int i7 = i3;
                if (i3 == -1) {
                    i7 = 0;
                }
                str = STORAGE_PARENT_WHERE;
                strArr = new String[]{Integer.toString(i), Integer.toString(i7)};
            }
        } else if (i3 == 0) {
            str = STORAGE_FORMAT_WHERE;
            strArr = new String[]{Integer.toString(i), Integer.toString(i2)};
        } else {
            int i8 = i3;
            if (i3 == -1) {
                i8 = 0;
            }
            str = STORAGE_FORMAT_PARENT_WHERE;
            strArr = new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i8)};
        }
        String str2 = str;
        String[] strArr2 = strArr;
        if (this.mSubDirectoriesWhere != null) {
            if (str != null) {
                str2 = str + " AND " + this.mSubDirectoriesWhere;
                strArr2 = new String[strArr.length + this.mSubDirectoriesWhereArgs.length];
                int i9 = 0;
                while (true) {
                    i4 = i9;
                    if (i4 >= strArr.length) {
                        break;
                    }
                    strArr2[i4] = strArr[i4];
                    i9 = i4 + 1;
                }
                int i10 = 0;
                while (true) {
                    int i11 = i10;
                    if (i11 >= this.mSubDirectoriesWhereArgs.length) {
                        break;
                    }
                    strArr2[i4] = this.mSubDirectoriesWhereArgs[i11];
                    i4++;
                    i10 = i11 + 1;
                }
            } else {
                str2 = this.mSubDirectoriesWhere;
                strArr2 = this.mSubDirectoriesWhereArgs;
            }
        }
        return this.mMediaProvider.query(this.mPackageName, this.mObjectsUri, ID_PROJECTION, str2, strArr2, null, null);
    }

    private int deleteFile(int i) {
        int i2;
        this.mDatabaseModified = true;
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                Cursor query = this.mMediaProvider.query(this.mPackageName, this.mObjectsUri, PATH_FORMAT_PROJECTION, ID_WHERE, new String[]{Integer.toString(i)}, null, null);
                if (query == null || !query.moveToNext()) {
                    i2 = 8201;
                    if (query != null) {
                        query.close();
                        return 8201;
                    }
                } else {
                    String string = query.getString(1);
                    int i3 = query.getInt(2);
                    if (string == null || i3 == 0) {
                        i2 = 8194;
                        if (query != null) {
                            query.close();
                            i2 = 8194;
                        }
                    } else if (isStorageSubDirectory(string)) {
                        i2 = 8205;
                        if (query != null) {
                            query.close();
                            return MtpConstants.RESPONSE_OBJECT_WRITE_PROTECTED;
                        }
                    } else {
                        if (i3 == 12289) {
                            this.mMediaProvider.delete(this.mPackageName, MediaStore.Files.getMtpObjectsUri(this.mVolumeName), "_data LIKE ?1 AND lower(substr(_data,1,?2))=lower(?3)", new String[]{string + "/%", Integer.toString(string.length() + 1), string + "/"});
                        }
                        if (this.mMediaProvider.delete(this.mPackageName, MediaStore.Files.getMtpObjectsUri(this.mVolumeName, i), null, null) > 0) {
                            if (i3 != 12289 && string.toLowerCase(Locale.US).endsWith("/.nomedia")) {
                                try {
                                    this.mMediaProvider.call(this.mPackageName, MediaStore.UNHIDE_CALL, string.substring(0, string.lastIndexOf("/")), null);
                                } catch (RemoteException e) {
                                    cursor2 = query;
                                    cursor = query;
                                    Log.e(TAG, "failed to unhide/rescan for " + string);
                                }
                            }
                            i2 = 8193;
                            if (query != null) {
                                query.close();
                                return 8193;
                            }
                        } else {
                            i2 = 8201;
                            if (query != null) {
                                query.close();
                                return 8201;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (RemoteException e2) {
            cursor = cursor2;
            Log.e(TAG, "RemoteException in deleteFile", e2);
            i2 = 8194;
            if (cursor2 != null) {
                cursor2.close();
                return 8194;
            }
        }
        return i2;
    }

    private void endSendObject(String str, int i, int i2, boolean z) {
        if (!z) {
            deleteFile(i);
        } else if (i2 != 47621) {
            this.mMediaScanner.scanMtpFile(str, this.mVolumeName, i, i2);
        } else {
            int lastIndexOf = str.lastIndexOf(47);
            String str2 = str;
            if (lastIndexOf >= 0) {
                str2 = str.substring(lastIndexOf + 1);
            }
            String str3 = str2;
            if (str2.endsWith(".pla")) {
                str3 = str2.substring(0, str2.length() - 4);
            }
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("_data", str);
            contentValues.put("name", str3);
            contentValues.put("format", Integer.valueOf(i2));
            contentValues.put("date_modified", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put(MediaStore.MediaColumns.MEDIA_SCANNER_NEW_OBJECT_ID, Integer.valueOf(i));
            try {
                this.mMediaProvider.insert(this.mPackageName, MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI, contentValues);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException in endSendObject", e);
            }
        }
    }

    private int getDeviceProperty(int i, long[] jArr, char[] cArr) {
        switch (i) {
            case MtpConstants.DEVICE_PROPERTY_IMAGE_SIZE /* 20483 */:
                Display defaultDisplay = ((WindowManager) this.mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
                String str = Integer.toString(defaultDisplay.getMaximumSizeDimension()) + "x" + Integer.toString(defaultDisplay.getMaximumSizeDimension());
                str.getChars(0, str.length(), cArr, 0);
                cArr[str.length()] = 0;
                return 8193;
            case MtpConstants.DEVICE_PROPERTY_SYNCHRONIZATION_PARTNER /* 54273 */:
            case MtpConstants.DEVICE_PROPERTY_DEVICE_FRIENDLY_NAME /* 54274 */:
                String string = this.mDeviceProperties.getString(Integer.toString(i), "");
                int length = string.length();
                int i2 = length;
                if (length > 255) {
                    i2 = 255;
                }
                string.getChars(0, i2, cArr, 0);
                cArr[i2] = 0;
                return 8193;
            default:
                return MtpConstants.RESPONSE_DEVICE_PROP_NOT_SUPPORTED;
        }
    }

    private int getNumObjects(int i, int i2, int i3) {
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                Cursor createObjectQuery = createObjectQuery(i, i2, i3);
                if (createObjectQuery == null) {
                    if (createObjectQuery != null) {
                        createObjectQuery.close();
                        return -1;
                    }
                    return -1;
                }
                cursor2 = createObjectQuery;
                cursor = createObjectQuery;
                int count = createObjectQuery.getCount();
                if (createObjectQuery != null) {
                    createObjectQuery.close();
                }
                return count;
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException in getNumObjects", e);
                if (cursor2 != null) {
                    cursor2.close();
                    return -1;
                }
                return -1;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private int getObjectFilePath(int i, char[] cArr, long[] jArr) {
        int i2;
        if (i == 0) {
            this.mMediaStoragePath.getChars(0, this.mMediaStoragePath.length(), cArr, 0);
            cArr[this.mMediaStoragePath.length()] = 0;
            jArr[0] = 0;
            jArr[1] = 12289;
            i2 = 8193;
        } else {
            Cursor cursor = null;
            Cursor cursor2 = null;
            try {
                try {
                    Cursor query = this.mMediaProvider.query(this.mPackageName, this.mObjectsUri, PATH_FORMAT_PROJECTION, ID_WHERE, new String[]{Integer.toString(i)}, null, null);
                    if (query != null && query.moveToNext()) {
                        String string = query.getString(1);
                        string.getChars(0, string.length(), cArr, 0);
                        cArr[string.length()] = 0;
                        jArr[0] = new File(string).length();
                        cursor2 = query;
                        cursor = query;
                        jArr[1] = query.getLong(2);
                        if (query != null) {
                            query.close();
                            return 8193;
                        }
                        return 8193;
                    }
                    i2 = 8201;
                    if (query != null) {
                        query.close();
                        return 8201;
                    }
                } catch (RemoteException e) {
                    Log.e(TAG, "RemoteException in getObjectFilePath", e);
                    i2 = 8194;
                    if (cursor2 != null) {
                        cursor2.close();
                        return 8194;
                    }
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        return i2;
    }

    private int getObjectFormat(int i) {
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                Cursor query = this.mMediaProvider.query(this.mPackageName, this.mObjectsUri, FORMAT_PROJECTION, ID_WHERE, new String[]{Integer.toString(i)}, null, null);
                if (query == null || !query.moveToNext()) {
                    if (query != null) {
                        query.close();
                        return -1;
                    }
                    return -1;
                }
                cursor2 = query;
                cursor = query;
                int i2 = query.getInt(1);
                if (query != null) {
                    query.close();
                }
                return i2;
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException in getObjectFilePath", e);
                if (cursor2 != null) {
                    cursor2.close();
                    return -1;
                }
                return -1;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private boolean getObjectInfo(int i, int[] iArr, char[] cArr, long[] jArr) {
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                Cursor query = this.mMediaProvider.query(this.mPackageName, this.mObjectsUri, OBJECT_INFO_PROJECTION, ID_WHERE, new String[]{Integer.toString(i)}, null, null);
                if (query == null || !query.moveToNext()) {
                    if (query != null) {
                        query.close();
                        return false;
                    }
                    return false;
                }
                iArr[0] = query.getInt(1);
                iArr[1] = query.getInt(2);
                iArr[2] = query.getInt(3);
                String string = query.getString(4);
                int lastIndexOf = string.lastIndexOf(47);
                int i2 = lastIndexOf >= 0 ? lastIndexOf + 1 : 0;
                int length = string.length();
                int i3 = length;
                if (length - i2 > 255) {
                    i3 = i2 + 255;
                }
                string.getChars(i2, i3, cArr, 0);
                cArr[i3 - i2] = 0;
                jArr[0] = query.getLong(5);
                cursor2 = query;
                cursor = query;
                jArr[1] = query.getLong(6);
                if (jArr[0] == 0) {
                    jArr[0] = jArr[1];
                }
                if (query != null) {
                    query.close();
                    return true;
                }
                return true;
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException in getObjectInfo", e);
                if (cursor2 != null) {
                    cursor2.close();
                    return false;
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private int[] getObjectList(int i, int i2, int i3) {
        int[] iArr;
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                Cursor createObjectQuery = createObjectQuery(i, i2, i3);
                if (createObjectQuery == null) {
                    if (createObjectQuery != null) {
                        createObjectQuery.close();
                    }
                    iArr = null;
                } else {
                    int count = createObjectQuery.getCount();
                    if (count <= 0) {
                        if (createObjectQuery != null) {
                            createObjectQuery.close();
                            return null;
                        }
                        return null;
                    }
                    int[] iArr2 = new int[count];
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= count) {
                            break;
                        }
                        cursor2 = createObjectQuery;
                        cursor = createObjectQuery;
                        createObjectQuery.moveToNext();
                        iArr2[i5] = createObjectQuery.getInt(0);
                        i4 = i5 + 1;
                    }
                    iArr = iArr2;
                    if (createObjectQuery != null) {
                        createObjectQuery.close();
                        return iArr2;
                    }
                }
                return iArr;
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException in getObjectList", e);
                if (cursor2 != null) {
                    cursor2.close();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private MtpPropertyList getObjectPropertyList(long j, int i, long j2, int i2, int i3) {
        MtpPropertyGroup mtpPropertyGroup;
        int i4;
        if (i2 != 0) {
            return new MtpPropertyList(0, MtpConstants.RESPONSE_SPECIFICATION_BY_GROUP_UNSUPPORTED);
        }
        if (j2 == 4294967295L) {
            int i5 = i;
            if (i == 0) {
                i5 = i;
                if (j > 0) {
                    i5 = getObjectFormat((int) j);
                }
            }
            MtpPropertyGroup mtpPropertyGroup2 = this.mPropertyGroupsByFormat.get(Integer.valueOf(i5));
            mtpPropertyGroup = mtpPropertyGroup2;
            i4 = i5;
            if (mtpPropertyGroup2 == null) {
                mtpPropertyGroup = new MtpPropertyGroup(this, this.mMediaProvider, this.mPackageName, this.mVolumeName, getSupportedObjectProperties(i5));
                this.mPropertyGroupsByFormat.put(new Integer(i5), mtpPropertyGroup);
                i4 = i5;
            }
        } else {
            MtpPropertyGroup mtpPropertyGroup3 = this.mPropertyGroupsByProperty.get(Long.valueOf(j2));
            mtpPropertyGroup = mtpPropertyGroup3;
            i4 = i;
            if (mtpPropertyGroup3 == null) {
                mtpPropertyGroup = new MtpPropertyGroup(this, this.mMediaProvider, this.mPackageName, this.mVolumeName, new int[]{(int) j2});
                this.mPropertyGroupsByProperty.put(new Integer((int) j2), mtpPropertyGroup);
                i4 = i;
            }
        }
        return mtpPropertyGroup.getPropertyList((int) j, i4, i3);
    }

    private int[] getObjectReferences(int i) {
        int[] iArr;
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                Cursor query = this.mMediaProvider.query(this.mPackageName, MediaStore.Files.getMtpReferencesUri(this.mVolumeName, i), ID_PROJECTION, null, null, null, null);
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    iArr = null;
                } else {
                    int count = query.getCount();
                    if (count <= 0) {
                        if (query != null) {
                            query.close();
                            return null;
                        }
                        return null;
                    }
                    int[] iArr2 = new int[count];
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= count) {
                            break;
                        }
                        cursor2 = query;
                        cursor = query;
                        query.moveToNext();
                        iArr2[i3] = query.getInt(0);
                        i2 = i3 + 1;
                    }
                    iArr = iArr2;
                    if (query != null) {
                        query.close();
                        return iArr2;
                    }
                }
                return iArr;
            } catch (RemoteException e) {
                cursor = cursor2;
                Log.e(TAG, "RemoteException in getObjectList", e);
                if (cursor2 != null) {
                    cursor2.close();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private int[] getSupportedCaptureFormats() {
        return null;
    }

    private int[] getSupportedDeviceProperties() {
        return new int[]{MtpConstants.DEVICE_PROPERTY_SYNCHRONIZATION_PARTNER, MtpConstants.DEVICE_PROPERTY_DEVICE_FRIENDLY_NAME, MtpConstants.DEVICE_PROPERTY_IMAGE_SIZE, MtpConstants.DEVICE_PROPERTY_BATTERY_LEVEL};
    }

    private int[] getSupportedObjectProperties(int i) {
        switch (i) {
            case 12296:
            case 12297:
            case MtpConstants.FORMAT_WMA /* 47361 */:
            case MtpConstants.FORMAT_OGG /* 47362 */:
            case MtpConstants.FORMAT_AAC /* 47363 */:
                return AUDIO_PROPERTIES;
            case 12299:
            case MtpConstants.FORMAT_WMV /* 47489 */:
            case MtpConstants.FORMAT_3GP_CONTAINER /* 47492 */:
                return VIDEO_PROPERTIES;
            case MtpConstants.FORMAT_EXIF_JPEG /* 14337 */:
            case MtpConstants.FORMAT_BMP /* 14340 */:
            case MtpConstants.FORMAT_GIF /* 14343 */:
            case MtpConstants.FORMAT_PNG /* 14347 */:
                return IMAGE_PROPERTIES;
            default:
                return FILE_PROPERTIES;
        }
    }

    private int[] getSupportedPlaybackFormats() {
        return new int[]{12288, 12289, 12292, 12293, 12296, 12297, 12299, MtpConstants.FORMAT_EXIF_JPEG, MtpConstants.FORMAT_TIFF_EP, MtpConstants.FORMAT_BMP, MtpConstants.FORMAT_GIF, MtpConstants.FORMAT_JFIF, MtpConstants.FORMAT_PNG, MtpConstants.FORMAT_TIFF, MtpConstants.FORMAT_WMA, MtpConstants.FORMAT_OGG, MtpConstants.FORMAT_AAC, MtpConstants.FORMAT_MP4_CONTAINER, MtpConstants.FORMAT_MP2, MtpConstants.FORMAT_3GP_CONTAINER, MtpConstants.FORMAT_ABSTRACT_AV_PLAYLIST, MtpConstants.FORMAT_WPL_PLAYLIST, MtpConstants.FORMAT_M3U_PLAYLIST, MtpConstants.FORMAT_PLS_PLAYLIST, MtpConstants.FORMAT_XML_DOCUMENT, MtpConstants.FORMAT_FLAC};
    }

    private boolean inStorageRoot(String str) {
        try {
            String canonicalPath = new File(str).getCanonicalPath();
            Iterator<String> it = this.mStorageMap.keySet().iterator();
            do {
                if (!it.hasNext()) {
                    return false;
                }
            } while (!canonicalPath.startsWith(it.next()));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private boolean inStorageSubDirectory(String str) {
        boolean z;
        if (this.mSubDirectories != null) {
            if (str != null) {
                boolean z2 = false;
                int length = str.length();
                int i = 0;
                while (true) {
                    z = z2;
                    if (i >= this.mSubDirectories.length) {
                        break;
                    }
                    z = z2;
                    if (z2) {
                        break;
                    }
                    String str2 = this.mSubDirectories[i];
                    int length2 = str2.length();
                    boolean z3 = z2;
                    if (length2 < length) {
                        z3 = z2;
                        if (str.charAt(length2) == '/') {
                            z3 = z2;
                            if (str.startsWith(str2)) {
                                z3 = true;
                            }
                        }
                    }
                    i++;
                    z2 = z3;
                }
            } else {
                return false;
            }
        } else {
            z = true;
        }
        return z;
    }

    private void initDeviceProperties(Context context) {
        this.mDeviceProperties = context.getSharedPreferences("device-properties", 0);
        if (context.getDatabasePath("device-properties").exists()) {
            SQLiteDatabase sQLiteDatabase = null;
            SQLiteDatabase sQLiteDatabase2 = null;
            Cursor cursor = null;
            Cursor cursor2 = null;
            try {
                try {
                    SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("device-properties", 0, null);
                    Cursor cursor3 = null;
                    if (openOrCreateDatabase != null) {
                        Cursor query = openOrCreateDatabase.query("properties", new String[]{"_id", "code", "value"}, null, null, null, null, null);
                        cursor3 = query;
                        if (query != null) {
                            SharedPreferences.Editor edit = this.mDeviceProperties.edit();
                            while (query.moveToNext()) {
                                edit.putString(query.getString(1), query.getString(2));
                            }
                            sQLiteDatabase2 = openOrCreateDatabase;
                            cursor = query;
                            sQLiteDatabase = openOrCreateDatabase;
                            cursor2 = query;
                            edit.commit();
                            cursor3 = query;
                        }
                    }
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    if (openOrCreateDatabase != null) {
                        openOrCreateDatabase.close();
                    }
                } catch (Exception e) {
                    Log.e(TAG, "failed to migrate device properties", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                }
                context.deleteDatabase("device-properties");
            } catch (Throwable th) {
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
    }

    private boolean isStorageSubDirectory(String str) {
        if (this.mSubDirectories == null) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mSubDirectories.length) {
                return false;
            }
            if (str.equals(this.mSubDirectories[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private final native void native_finalize();

    private final native void native_setup();

    /* JADX WARN: Finally extract failed */
    private int renameFile(int i, String str) {
        int i2;
        String str2;
        int lastIndexOf;
        Cursor cursor = null;
        Cursor cursor2 = null;
        String[] strArr = {Integer.toString(i)};
        try {
            try {
                Cursor query = this.mMediaProvider.query(this.mPackageName, this.mObjectsUri, PATH_PROJECTION, ID_WHERE, strArr, null, null);
                str2 = null;
                if (query != null) {
                    str2 = null;
                    if (query.moveToNext()) {
                        cursor2 = query;
                        cursor = query;
                        str2 = query.getString(1);
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (RemoteException e) {
            cursor = cursor2;
            Log.e(TAG, "RemoteException in getObjectFilePath", e);
            i2 = 8194;
            if (cursor2 != null) {
                cursor2.close();
                return 8194;
            }
        }
        if (str2 == null) {
            i2 = 8201;
            return i2;
        } else if (isStorageSubDirectory(str2)) {
            return MtpConstants.RESPONSE_OBJECT_WRITE_PROTECTED;
        } else {
            File file = new File(str2);
            if (str2.lastIndexOf(47) <= 1) {
                return 8194;
            }
            String str3 = str2.substring(0, lastIndexOf + 1) + str;
            File file2 = new File(str3);
            if (!file.renameTo(file2)) {
                Log.w(TAG, "renaming " + str2 + " to " + str3 + " failed");
                return 8194;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", str3);
            int i3 = 0;
            try {
                i3 = this.mMediaProvider.update(this.mPackageName, this.mObjectsUri, contentValues, ID_WHERE, strArr);
            } catch (RemoteException e2) {
                Log.e(TAG, "RemoteException in mMediaProvider.update", e2);
            }
            if (i3 == 0) {
                Log.e(TAG, "Unable to update path for " + str2 + " to " + str3);
                file2.renameTo(file);
                return 8194;
            } else if (file2.isDirectory()) {
                if (!file.getName().startsWith(".") || str3.startsWith(".")) {
                    return 8193;
                }
                try {
                    this.mMediaProvider.call(this.mPackageName, MediaStore.UNHIDE_CALL, str3, null);
                    return 8193;
                } catch (RemoteException e3) {
                    Log.e(TAG, "failed to unhide/rescan for " + str3);
                    return 8193;
                }
            } else if (!file.getName().toLowerCase(Locale.US).equals(MediaStore.MEDIA_IGNORE_FILENAME) || str3.toLowerCase(Locale.US).equals(MediaStore.MEDIA_IGNORE_FILENAME)) {
                return 8193;
            } else {
                try {
                    this.mMediaProvider.call(this.mPackageName, MediaStore.UNHIDE_CALL, file.getParent(), null);
                    return 8193;
                } catch (RemoteException e4) {
                    Log.e(TAG, "failed to unhide/rescan for " + str3);
                    return 8193;
                }
            }
        }
    }

    private void sessionEnded() {
        if (this.mDatabaseModified) {
            this.mContext.sendBroadcast(new Intent(MediaStore.ACTION_MTP_SESSION_END));
            this.mDatabaseModified = false;
        }
    }

    private void sessionStarted() {
        this.mDatabaseModified = false;
    }

    private int setDeviceProperty(int i, long j, String str) {
        switch (i) {
            case MtpConstants.DEVICE_PROPERTY_SYNCHRONIZATION_PARTNER /* 54273 */:
            case MtpConstants.DEVICE_PROPERTY_DEVICE_FRIENDLY_NAME /* 54274 */:
                SharedPreferences.Editor edit = this.mDeviceProperties.edit();
                edit.putString(Integer.toString(i), str);
                return edit.commit() ? 8193 : 8194;
            default:
                return MtpConstants.RESPONSE_DEVICE_PROP_NOT_SUPPORTED;
        }
    }

    private int setObjectProperty(int i, int i2, long j, String str) {
        switch (i2) {
            case MtpConstants.PROPERTY_OBJECT_FILE_NAME /* 56327 */:
                return renameFile(i, str);
            default:
                return MtpConstants.RESPONSE_OBJECT_PROP_NOT_SUPPORTED;
        }
    }

    private int setObjectReferences(int i, int[] iArr) {
        this.mDatabaseModified = true;
        Uri mtpReferencesUri = MediaStore.Files.getMtpReferencesUri(this.mVolumeName, i);
        int length = iArr.length;
        ContentValues[] contentValuesArr = new ContentValues[length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                try {
                    break;
                } catch (RemoteException e) {
                    Log.e(TAG, "RemoteException in setObjectReferences", e);
                    return 8194;
                }
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", Integer.valueOf(iArr[i3]));
            contentValuesArr[i3] = contentValues;
            i2 = i3 + 1;
        }
        return this.mMediaProvider.bulkInsert(this.mPackageName, mtpReferencesUri, contentValuesArr) > 0 ? 8193 : 8194;
    }

    public void addStorage(MtpStorage mtpStorage) {
        this.mStorageMap.put(mtpStorage.getPath(), mtpStorage);
    }

    protected void finalize() throws Throwable {
        try {
            native_finalize();
        } finally {
            super.finalize();
        }
    }

    public void removeStorage(MtpStorage mtpStorage) {
        this.mStorageMap.remove(mtpStorage.getPath());
    }

    public void setServer(MtpServer mtpServer) {
        this.mServer = mtpServer;
        try {
            this.mContext.unregisterReceiver(this.mBatteryReceiver);
        } catch (IllegalArgumentException e) {
        }
        if (mtpServer != null) {
            this.mContext.registerReceiver(this.mBatteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        }
    }
}
