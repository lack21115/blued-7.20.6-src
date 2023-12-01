package android.media;

import android.text.format.Time;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: source-9557208-dex2jar.jar:android/media/ExifInterface.class */
public class ExifInterface {
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final String TAG_APERTURE = "FNumber";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    public static final String TAG_ISO = "ISOSpeedRatings";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final int WHITEBALANCE_AUTO = 0;
    public static final int WHITEBALANCE_MANUAL = 1;
    private static SimpleDateFormat sFormatter;
    private static final Object sLock;
    private HashMap<String, String> mAttributes;
    private String mFilename;
    private boolean mHasThumbnail;

    static {
        System.loadLibrary("jhead_jni");
        sFormatter = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        sFormatter.setTimeZone(TimeZone.getTimeZone(Time.TIMEZONE_UTC));
        sLock = new Object();
    }

    public ExifInterface(String str) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("filename cannot be null");
        }
        this.mFilename = str;
        loadAttributes();
    }

    private native boolean appendThumbnailNative(String str, String str2);

    private native void commitChangesNative(String str);

    private static float convertRationalLatLonToFloat(String str, String str2) {
        try {
            String[] split = str.split(",");
            String[] split2 = split[0].split(BridgeUtil.SPLIT_MARK);
            double parseDouble = Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim());
            String[] split3 = split[1].split(BridgeUtil.SPLIT_MARK);
            double parseDouble2 = Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim());
            String[] split4 = split[2].split(BridgeUtil.SPLIT_MARK);
            double parseDouble3 = (parseDouble2 / 60.0d) + parseDouble + ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d);
            if (!str2.equals(androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH)) {
                if (!str2.equals("W")) {
                    return (float) parseDouble3;
                }
            }
            return (float) (-parseDouble3);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException();
        }
    }

    private native String getAttributesNative(String str);

    private native byte[] getThumbnailNative(String str);

    private native long[] getThumbnailRangeNative(String str);

    private void loadAttributes() throws IOException {
        String attributesNative;
        this.mAttributes = new HashMap<>();
        synchronized (sLock) {
            attributesNative = getAttributesNative(this.mFilename);
        }
        int indexOf = attributesNative.indexOf(32);
        int parseInt = Integer.parseInt(attributesNative.substring(0, indexOf));
        int i = indexOf + 1;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= parseInt) {
                return;
            }
            int indexOf2 = attributesNative.indexOf(61, i);
            String substring = attributesNative.substring(i, indexOf2);
            int i4 = indexOf2 + 1;
            int indexOf3 = attributesNative.indexOf(32, i4);
            int parseInt2 = Integer.parseInt(attributesNative.substring(i4, indexOf3));
            int i5 = indexOf3 + 1;
            String substring2 = attributesNative.substring(i5, i5 + parseInt2);
            i = i5 + parseInt2;
            if (substring.equals("hasThumbnail")) {
                this.mHasThumbnail = substring2.equalsIgnoreCase("true");
            } else {
                this.mAttributes.put(substring, substring2);
            }
            i2 = i3 + 1;
        }
    }

    private native void saveAttributesNative(String str, String str2);

    public double getAltitude(double d) {
        int i = -1;
        double attributeDouble = getAttributeDouble("GPSAltitude", -1.0d);
        int attributeInt = getAttributeInt("GPSAltitudeRef", -1);
        double d2 = d;
        if (attributeDouble >= 0.0d) {
            d2 = d;
            if (attributeInt >= 0) {
                if (attributeInt != 1) {
                    i = 1;
                }
                d2 = attributeDouble * i;
            }
        }
        return d2;
    }

    public String getAttribute(String str) {
        return this.mAttributes.get(str);
    }

    public double getAttributeDouble(String str, double d) {
        String str2 = this.mAttributes.get(str);
        if (str2 != null) {
            try {
                int indexOf = str2.indexOf(BridgeUtil.SPLIT_MARK);
                if (indexOf != -1) {
                    double parseDouble = Double.parseDouble(str2.substring(indexOf + 1));
                    if (parseDouble != 0.0d) {
                        return Double.parseDouble(str2.substring(0, indexOf)) / parseDouble;
                    }
                }
            } catch (NumberFormatException e) {
                return d;
            }
        }
        return d;
    }

    public int getAttributeInt(String str, int i) {
        String str2 = this.mAttributes.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            return Integer.valueOf(str2).intValue();
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public long getDateTime() {
        String str = this.mAttributes.get("DateTime");
        if (str == null) {
            return -1L;
        }
        try {
            Date parse = sFormatter.parse(str, new ParsePosition(0));
            if (parse != null) {
                return parse.getTime();
            }
            return -1L;
        } catch (IllegalArgumentException e) {
            return -1L;
        }
    }

    public long getGpsDateTime() {
        String str;
        String str2 = this.mAttributes.get("GPSDateStamp");
        String str3 = this.mAttributes.get("GPSTimeStamp");
        if (str2 == null || str3 == null || (str2 + ' ' + str3) == null) {
            return -1L;
        }
        try {
            Date parse = sFormatter.parse(str, new ParsePosition(0));
            if (parse != null) {
                return parse.getTime();
            }
            return -1L;
        } catch (IllegalArgumentException e) {
            return -1L;
        }
    }

    public boolean getLatLong(float[] fArr) {
        String str = this.mAttributes.get("GPSLatitude");
        String str2 = this.mAttributes.get("GPSLatitudeRef");
        String str3 = this.mAttributes.get("GPSLongitude");
        String str4 = this.mAttributes.get("GPSLongitudeRef");
        if (str == null || str2 == null || str3 == null || str4 == null) {
            return false;
        }
        try {
            fArr[0] = convertRationalLatLonToFloat(str, str2);
            fArr[1] = convertRationalLatLonToFloat(str3, str4);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public byte[] getThumbnail() {
        byte[] thumbnailNative;
        synchronized (sLock) {
            thumbnailNative = getThumbnailNative(this.mFilename);
        }
        return thumbnailNative;
    }

    public long[] getThumbnailRange() {
        long[] thumbnailRangeNative;
        synchronized (sLock) {
            thumbnailRangeNative = getThumbnailRangeNative(this.mFilename);
        }
        return thumbnailRangeNative;
    }

    public boolean hasThumbnail() {
        return this.mHasThumbnail;
    }

    public void saveAttributes() throws IOException {
        StringBuilder sb = new StringBuilder();
        int size = this.mAttributes.size();
        int i = size;
        if (this.mAttributes.containsKey("hasThumbnail")) {
            i = size - 1;
        }
        sb.append(i + " ");
        for (Map.Entry<String, String> entry : this.mAttributes.entrySet()) {
            String key = entry.getKey();
            if (!key.equals("hasThumbnail")) {
                String value = entry.getValue();
                sb.append(key + "=");
                sb.append(value.length() + " ");
                sb.append(value);
            }
        }
        String sb2 = sb.toString();
        synchronized (sLock) {
            saveAttributesNative(this.mFilename, sb2);
            commitChangesNative(this.mFilename);
        }
    }

    public void setAttribute(String str, String str2) {
        this.mAttributes.put(str, str2);
    }
}
