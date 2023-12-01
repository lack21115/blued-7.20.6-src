package android.mtp;

import android.content.IContentProvider;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/mtp/MtpPropertyGroup.class */
class MtpPropertyGroup {
    private static final String FORMAT_WHERE = "format=?";
    private static final String ID_FORMAT_WHERE = "_id=? AND format=?";
    private static final String ID_WHERE = "_id=?";
    private static final String PARENT_FORMAT_WHERE = "parent=? AND format=?";
    private static final String PARENT_WHERE = "parent=?";
    private static final String TAG = "MtpPropertyGroup";
    private String[] mColumns;
    private final MtpDatabase mDatabase;
    private final String mPackageName;
    private final Property[] mProperties;
    private final IContentProvider mProvider;
    private final Uri mUri;
    private final String mVolumeName;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/mtp/MtpPropertyGroup$Property.class */
    public class Property {
        int code;
        int column;
        int type;

        Property(int i, int i2, int i3) {
            this.code = i;
            this.type = i2;
            this.column = i3;
        }
    }

    public MtpPropertyGroup(MtpDatabase mtpDatabase, IContentProvider iContentProvider, String str, String str2, int[] iArr) {
        this.mDatabase = mtpDatabase;
        this.mProvider = iContentProvider;
        this.mPackageName = str;
        this.mVolumeName = str2;
        this.mUri = MediaStore.Files.getMtpObjectsUri(str2);
        int length = iArr.length;
        ArrayList<String> arrayList = new ArrayList<>(length);
        arrayList.add("_id");
        this.mProperties = new Property[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            this.mProperties[i2] = createProperty(iArr[i2], arrayList);
            i = i2 + 1;
        }
        int size = arrayList.size();
        this.mColumns = new String[size];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                return;
            }
            this.mColumns[i4] = arrayList.get(i4);
            i3 = i4 + 1;
        }
    }

    private Property createProperty(int i, ArrayList<String> arrayList) {
        int i2;
        String str = null;
        switch (i) {
            case MtpConstants.PROPERTY_STORAGE_ID /* 56321 */:
                str = MediaStore.Files.FileColumns.STORAGE_ID;
                i2 = 6;
                break;
            case MtpConstants.PROPERTY_OBJECT_FORMAT /* 56322 */:
                str = "format";
                i2 = 4;
                break;
            case MtpConstants.PROPERTY_PROTECTION_STATUS /* 56323 */:
                i2 = 4;
                break;
            case MtpConstants.PROPERTY_OBJECT_SIZE /* 56324 */:
                str = "_size";
                i2 = 8;
                break;
            case MtpConstants.PROPERTY_OBJECT_FILE_NAME /* 56327 */:
                str = "_data";
                i2 = 65535;
                break;
            case MtpConstants.PROPERTY_DATE_MODIFIED /* 56329 */:
                str = "date_modified";
                i2 = 65535;
                break;
            case MtpConstants.PROPERTY_PARENT_OBJECT /* 56331 */:
                str = "parent";
                i2 = 6;
                break;
            case MtpConstants.PROPERTY_PERSISTENT_UID /* 56385 */:
                str = MediaStore.Files.FileColumns.STORAGE_ID;
                i2 = 10;
                break;
            case MtpConstants.PROPERTY_NAME /* 56388 */:
                str = "title";
                i2 = 65535;
                break;
            case MtpConstants.PROPERTY_ARTIST /* 56390 */:
                i2 = 65535;
                break;
            case MtpConstants.PROPERTY_DESCRIPTION /* 56392 */:
                str = "description";
                i2 = 65535;
                break;
            case MtpConstants.PROPERTY_DATE_ADDED /* 56398 */:
                str = "date_added";
                i2 = 65535;
                break;
            case MtpConstants.PROPERTY_DURATION /* 56457 */:
                str = "duration";
                i2 = 6;
                break;
            case MtpConstants.PROPERTY_TRACK /* 56459 */:
                str = MediaStore.Audio.AudioColumns.TRACK;
                i2 = 4;
                break;
            case MtpConstants.PROPERTY_GENRE /* 56460 */:
                i2 = 65535;
                break;
            case MtpConstants.PROPERTY_COMPOSER /* 56470 */:
                str = MediaStore.Audio.AudioColumns.COMPOSER;
                i2 = 65535;
                break;
            case MtpConstants.PROPERTY_ORIGINAL_RELEASE_DATE /* 56473 */:
                str = MediaStore.Audio.AudioColumns.YEAR;
                i2 = 65535;
                break;
            case MtpConstants.PROPERTY_ALBUM_NAME /* 56474 */:
                i2 = 65535;
                break;
            case MtpConstants.PROPERTY_ALBUM_ARTIST /* 56475 */:
                str = MediaStore.Audio.AudioColumns.ALBUM_ARTIST;
                i2 = 65535;
                break;
            case MtpConstants.PROPERTY_DISPLAY_NAME /* 56544 */:
                str = "_display_name";
                i2 = 65535;
                break;
            case MtpConstants.PROPERTY_BITRATE_TYPE /* 56978 */:
            case MtpConstants.PROPERTY_NUMBER_OF_CHANNELS /* 56980 */:
                i2 = 4;
                break;
            case MtpConstants.PROPERTY_SAMPLE_RATE /* 56979 */:
            case MtpConstants.PROPERTY_AUDIO_WAVE_CODEC /* 56985 */:
            case MtpConstants.PROPERTY_AUDIO_BITRATE /* 56986 */:
                i2 = 6;
                break;
            default:
                i2 = 0;
                Log.e(TAG, "unsupported property " + i);
                break;
        }
        if (str != null) {
            arrayList.add(str);
            return new Property(i, i2, arrayList.size() - 1);
        }
        return new Property(i, i2, -1);
    }

    private native String format_date_time(long j);

    private static String nameFromPath(String str) {
        int i = 0;
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf >= 0) {
            i = lastIndexOf + 1;
        }
        int length = str.length();
        int i2 = length;
        if (length - i > 255) {
            i2 = i + 255;
        }
        return str.substring(i, i2);
    }

    private String queryAudio(int i, String str) {
        String str2;
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            Cursor query = this.mProvider.query(this.mPackageName, MediaStore.Audio.Media.getContentUri(this.mVolumeName), new String[]{"_id", str}, ID_WHERE, new String[]{Integer.toString(i)}, null, null);
            if (query == null || !query.moveToNext()) {
                str2 = "";
                if (query != null) {
                    query.close();
                    return "";
                }
            } else {
                cursor = query;
                cursor2 = query;
                String string = query.getString(1);
                str2 = string;
                if (query != null) {
                    query.close();
                    str2 = string;
                }
            }
            return str2;
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
                return null;
            }
            return null;
        } catch (Throwable th) {
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    private String queryGenre(int i) {
        String str;
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                Cursor query = this.mProvider.query(this.mPackageName, MediaStore.Audio.Genres.getContentUriForAudioId(this.mVolumeName, i), new String[]{"_id", "name"}, null, null, null, null);
                if (query == null || !query.moveToNext()) {
                    str = "";
                    if (query != null) {
                        query.close();
                        return "";
                    }
                } else {
                    cursor = query;
                    cursor2 = query;
                    String string = query.getString(1);
                    str = string;
                    if (query != null) {
                        query.close();
                        str = string;
                    }
                }
                return str;
            } catch (Exception e) {
                Log.e(TAG, "queryGenre exception", e);
                if (cursor != null) {
                    cursor.close();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    private Long queryLong(int i, String str) {
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            Cursor query = this.mProvider.query(this.mPackageName, this.mUri, new String[]{"_id", str}, ID_WHERE, new String[]{Integer.toString(i)}, null, null);
            if (query == null || !query.moveToNext()) {
                if (query != null) {
                    query.close();
                    return null;
                }
                return null;
            }
            cursor = query;
            cursor2 = query;
            Long l = new Long(query.getLong(1));
            if (query != null) {
                query.close();
            }
            return l;
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
                return null;
            }
            return null;
        } catch (Throwable th) {
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    private String queryString(int i, String str) {
        String str2;
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            Cursor query = this.mProvider.query(this.mPackageName, this.mUri, new String[]{"_id", str}, ID_WHERE, new String[]{Integer.toString(i)}, null, null);
            if (query == null || !query.moveToNext()) {
                str2 = "";
                if (query != null) {
                    query.close();
                    return "";
                }
            } else {
                cursor = query;
                cursor2 = query;
                String string = query.getString(1);
                str2 = string;
                if (query != null) {
                    query.close();
                    str2 = string;
                }
            }
            return str2;
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
                return null;
            }
            return null;
        } catch (Throwable th) {
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
        if (r9.mColumns.length > 1) goto L151;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.mtp.MtpPropertyList getPropertyList(int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 1344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.mtp.MtpPropertyGroup.getPropertyList(int, int, int):android.mtp.MtpPropertyList");
    }
}
