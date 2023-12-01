package android.mokee.location;

import android.text.TextUtils;

/* loaded from: source-9557208-dex2jar.jar:android/mokee/location/PhoneNumberOfflineGeocoder.class */
public final class PhoneNumberOfflineGeocoder {
    private static String LIBNAME = "mokee-phonelocation";

    static {
        System.loadLibrary(LIBNAME);
    }

    private static String doGetDescriptionForNumber(String str) {
        String nativeGetDescriptionForNumber;
        synchronized (PhoneNumberOfflineGeocoder.class) {
            try {
                nativeGetDescriptionForNumber = nativeGetDescriptionForNumber(str);
            } catch (Throwable th) {
                throw th;
            }
        }
        return nativeGetDescriptionForNumber;
    }

    private static String getDescriptionForNumber(String str, int i) {
        String doGetDescriptionForNumber = doGetDescriptionForNumber(str.replaceAll("(?:-| )", ""));
        if (TextUtils.isEmpty(doGetDescriptionForNumber)) {
            return null;
        }
        String[] split = doGetDescriptionForNumber.split(",");
        if (split.length == 2) {
            return split[i];
        }
        return null;
    }

    public static String getPhoneCode(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            String descriptionForNumber = getDescriptionForNumber(str.toString(), 0);
            str2 = descriptionForNumber;
            if (TextUtils.isEmpty(descriptionForNumber)) {
                return "";
            }
        }
        return str2;
    }

    public static String getPhoneLocation(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            String descriptionForNumber = getDescriptionForNumber(str.toString(), 1);
            str2 = descriptionForNumber;
            if (TextUtils.isEmpty(descriptionForNumber)) {
                return "";
            }
        }
        return str2;
    }

    private static native String nativeGetDescriptionForNumber(String str);
}
