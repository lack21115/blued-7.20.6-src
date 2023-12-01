package android.media;

import android.os.Parcel;
import android.util.Log;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.TimeZone;

@Deprecated
/* loaded from: source-9557208-dex2jar.jar:android/media/Metadata.class */
public class Metadata {
    public static final int ALBUM = 8;
    public static final int ALBUM_ART = 18;
    public static final int ANY = 0;
    public static final int ARTIST = 9;
    public static final int AUDIO_BIT_RATE = 21;
    public static final int AUDIO_CODEC = 26;
    public static final int AUDIO_SAMPLE_RATE = 23;
    public static final int AUTHOR = 10;
    public static final int BIT_RATE = 20;
    public static final int BOOLEAN_VAL = 3;
    public static final int BYTE_ARRAY_VAL = 7;
    public static final int CD_TRACK_MAX = 16;
    public static final int CD_TRACK_NUM = 15;
    public static final int COMMENT = 6;
    public static final int COMPOSER = 11;
    public static final int COPYRIGHT = 7;
    public static final int DATE = 13;
    public static final int DATE_VAL = 6;
    public static final int DOUBLE_VAL = 5;
    public static final int DRM_CRIPPLED = 31;
    public static final int DURATION = 14;
    private static final int FIRST_CUSTOM = 8192;
    public static final int GENRE = 12;
    public static final int INTEGER_VAL = 2;
    private static final int LAST_SYSTEM = 31;
    private static final int LAST_TYPE = 7;
    public static final int LONG_VAL = 4;
    public static final int MIME_TYPE = 25;
    public static final int NUM_TRACKS = 30;
    public static final int PAUSE_AVAILABLE = 1;
    public static final int RATING = 17;
    public static final int SEEK_AVAILABLE = 4;
    public static final int SEEK_BACKWARD_AVAILABLE = 2;
    public static final int SEEK_FORWARD_AVAILABLE = 3;
    public static final int STRING_VAL = 1;
    private static final String TAG = "media.Metadata";
    public static final int TITLE = 5;
    public static final int VIDEO_BIT_RATE = 22;
    public static final int VIDEO_CODEC = 27;
    public static final int VIDEO_FRAME = 19;
    public static final int VIDEO_FRAME_RATE = 24;
    public static final int VIDEO_HEIGHT = 28;
    public static final int VIDEO_WIDTH = 29;
    private static final int kInt32Size = 4;
    private static final int kMetaHeaderSize = 8;
    private static final int kMetaMarker = 1296389185;
    private static final int kRecordHeaderSize = 12;
    private final HashMap<Integer, Integer> mKeyToPosMap = new HashMap<>();
    private Parcel mParcel;
    public static final Set<Integer> MATCH_NONE = Collections.EMPTY_SET;
    public static final Set<Integer> MATCH_ALL = Collections.singleton(0);

    private boolean checkMetadataId(int i) {
        if (i <= 0 || (31 < i && i < 8192)) {
            Log.e(TAG, "Invalid metadata ID " + i);
            return false;
        }
        return true;
    }

    private void checkType(int i, int i2) {
        this.mParcel.setDataPosition(this.mKeyToPosMap.get(Integer.valueOf(i)).intValue());
        int readInt = this.mParcel.readInt();
        if (readInt != i2) {
            throw new IllegalStateException("Wrong type " + i2 + " but got " + readInt);
        }
    }

    public static int firstCustomId() {
        return 8192;
    }

    public static int lastSytemId() {
        return 31;
    }

    public static int lastType() {
        return 7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b6, code lost:
        android.util.Log.e(android.media.Metadata.TAG, "Invalid metadata type " + r0);
        r6 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean scanAllRecords(android.os.Parcel r5, int r6) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.Metadata.scanAllRecords(android.os.Parcel, int):boolean");
    }

    public boolean getBoolean(int i) {
        checkType(i, 3);
        return this.mParcel.readInt() == 1;
    }

    public byte[] getByteArray(int i) {
        checkType(i, 7);
        return this.mParcel.createByteArray();
    }

    public Date getDate(int i) {
        checkType(i, 6);
        long readLong = this.mParcel.readLong();
        String readString = this.mParcel.readString();
        if (readString.length() == 0) {
            return new Date(readLong);
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(readString));
        calendar.setTimeInMillis(readLong);
        return calendar.getTime();
    }

    public double getDouble(int i) {
        checkType(i, 5);
        return this.mParcel.readDouble();
    }

    public int getInt(int i) {
        checkType(i, 2);
        return this.mParcel.readInt();
    }

    public long getLong(int i) {
        checkType(i, 4);
        return this.mParcel.readLong();
    }

    public String getString(int i) {
        checkType(i, 1);
        return this.mParcel.readString();
    }

    public boolean has(int i) {
        if (checkMetadataId(i)) {
            return this.mKeyToPosMap.containsKey(Integer.valueOf(i));
        }
        throw new IllegalArgumentException("Invalid key: " + i);
    }

    public Set<Integer> keySet() {
        return this.mKeyToPosMap.keySet();
    }

    public boolean parse(Parcel parcel) {
        if (parcel.dataAvail() < 8) {
            Log.e(TAG, "Not enough data " + parcel.dataAvail());
            return false;
        }
        int dataPosition = parcel.dataPosition();
        int readInt = parcel.readInt();
        if (parcel.dataAvail() + 4 < readInt || readInt < 8) {
            Log.e(TAG, "Bad size " + readInt + " avail " + parcel.dataAvail() + " position " + dataPosition);
            parcel.setDataPosition(dataPosition);
            return false;
        }
        int readInt2 = parcel.readInt();
        if (readInt2 != kMetaMarker) {
            Log.e(TAG, "Marker missing " + Integer.toHexString(readInt2));
            parcel.setDataPosition(dataPosition);
            return false;
        } else if (scanAllRecords(parcel, readInt - 8)) {
            this.mParcel = parcel;
            return true;
        } else {
            parcel.setDataPosition(dataPosition);
            return false;
        }
    }

    public void recycleParcel() {
        if (this.mParcel != null) {
            this.mParcel.recycle();
        }
    }
}
