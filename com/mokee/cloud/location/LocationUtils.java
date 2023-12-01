package com.mokee.cloud.location;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.Telephony;
import android.text.TextUtils;
import com.mokee.cloud.location.CloudNumber;
import com.mokee.volley.VolleyError;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/cloud/location/LocationUtils.class */
public class LocationUtils {
    private static final String[] a = null;
    private static final String[] b = null;

    static {
        String[] strArr = new String[31];
        throw new VerifyError("bad dex opcode");
    }

    public static int getEngineTypeID(CloudNumber.EngineType engineType) {
        return engineType == CloudNumber.EngineType.OFFLINE ? 1 : 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0145 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v12, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.mokee.cloud.location.LocationInfo getLocationInfo(android.content.ContentResolver r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.cloud.location.LocationUtils.getLocationInfo(android.content.ContentResolver, java.lang.String):com.mokee.cloud.location.LocationInfo");
    }

    public static CloudNumber.PhoneType getPhoneType(String str) {
        return str.contains(b[2]) ? CloudNumber.PhoneType.HARASS : str.contains(b[0]) ? CloudNumber.PhoneType.FRAUD : str.contains(b[1]) ? CloudNumber.PhoneType.ADVERTISEMENT : CloudNumber.PhoneType.NORMAL;
    }

    public static CloudNumber.PhoneType getPhoneTypeByID(int i) {
        switch (i) {
            case 1:
                return CloudNumber.PhoneType.HARASS;
            case 2:
                return CloudNumber.PhoneType.FRAUD;
            case 3:
                return CloudNumber.PhoneType.ADVERTISEMENT;
            default:
                return CloudNumber.PhoneType.NORMAL;
        }
    }

    public static int getPhoneTypeID(CloudNumber.PhoneType phoneType) {
        if (phoneType == CloudNumber.PhoneType.HARASS) {
            return 1;
        }
        if (phoneType == CloudNumber.PhoneType.FRAUD) {
            return 2;
        }
        return phoneType == CloudNumber.PhoneType.ADVERTISEMENT ? 3 : 0;
    }

    public static void insertOrUpdateLocationInfo(ContentResolver contentResolver, LocationInfo locationInfo, String str, String str2, int i, int i2) {
        if (locationInfo != null) {
            if (locationInfo.getEngineType() < i2) {
                return;
            }
            Uri.Builder buildUpon = Telephony.PhoneLocation.CONTENT_FILTER_BYNUMBER_URI.buildUpon();
            buildUpon.appendPath(str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(b[18], str2);
            contentValues.put(b[21], Integer.valueOf(i));
            contentValues.put(b[15], Integer.valueOf(i2));
            contentValues.put(b[24], Long.valueOf(System.currentTimeMillis()));
            contentResolver.update(buildUpon.build(), contentValues, null, null);
            if (!CloudNumber.b) {
                return;
            }
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(b[22], str);
        contentValues2.put(b[16], str2);
        contentValues2.put(b[19], Integer.valueOf(i));
        contentValues2.put(b[20], Integer.valueOf(i2));
        contentValues2.put(b[23], "");
        contentValues2.put(b[17], Long.valueOf(System.currentTimeMillis()));
        contentResolver.insert(Telephony.PhoneLocation.CONTENT_URI, contentValues2);
    }

    public static String rewritePhoneLocation(String str) {
        String str2;
        if (str.startsWith(b[14])) {
            str2 = b[11];
        } else {
            str2 = str;
            if (str.startsWith(b[13])) {
                return b[12];
            }
        }
        return str2;
    }

    public static boolean shouldUpdateLocationInfo(LocationInfo locationInfo) {
        if (locationInfo != null) {
            if (locationInfo.getEngineType() == 1 && locationInfo.getUpdateTime() + 259200000 < System.currentTimeMillis() && TextUtils.isEmpty(locationInfo.getUserMark())) {
                return true;
            }
            return locationInfo.getEngineType() == 0 && locationInfo.getUpdateTime() + 259200000 < System.currentTimeMillis();
        }
        return true;
    }

    public static void updateUserMarkInfo(ContentResolver contentResolver, String str, String str2, int i) {
        boolean z = CloudNumber.b;
        LocationInfo locationInfo = getLocationInfo(contentResolver, str);
        Uri.Builder buildUpon = Telephony.PhoneLocation.CONTENT_FILTER_BYNUMBER_URI.buildUpon();
        buildUpon.appendPath(str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(b[28], str);
        contentValues.put(b[25], locationInfo == null ? "" : locationInfo.getLocation());
        contentValues.put(b[26], Integer.valueOf(i));
        contentValues.put(b[29], Integer.valueOf(getEngineTypeID(CloudNumber.EngineType.OFFLINE)));
        contentValues.put(b[30], str2);
        contentValues.put(b[27], Long.valueOf(System.currentTimeMillis()));
        contentResolver.update(buildUpon.build(), contentValues, null, null);
        if (z) {
            VolleyError.b = !VolleyError.b;
        }
    }
}
