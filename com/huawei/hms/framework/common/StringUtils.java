package com.huawei.hms.framework.common;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.secure.android.common.util.SafeString;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/common/StringUtils.class */
public class StringUtils {
    private static final int INIT_CAPACITY = 1024;
    private static boolean IS_AEGIS_STRING_LIBRARY_LOADED = false;
    private static final String SAFE_STRING_PATH = "com.huawei.secure.android.common.util.SafeString";
    private static final String TAG = "StringUtils";

    public static String anonymizeMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= charArray.length) {
                return new String(charArray);
            }
            if (i2 % 2 != 0) {
                charArray[i2] = '*';
            }
            i = i2 + 1;
        }
    }

    public static String byte2Str(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Logger.w("StringUtils.byte2str error: UnsupportedEncodingException", anonymizeMessage(e.getMessage()));
            return "";
        }
    }

    private static boolean checkCompatible(String str) {
        ClassLoader classLoader = SecurityBase64Utils.class.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        try {
            classLoader.loadClass(str);
            synchronized (StringUtils.class) {
                IS_AEGIS_STRING_LIBRARY_LOADED = true;
            }
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static String collection2String(Collection<String> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : collection) {
            sb.append(str);
            sb.append(t.aE);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public static String format(String str, Object... objArr) {
        return str == null ? "" : String.format(Locale.ROOT, str, objArr);
    }

    public static byte[] getBytes(long j) {
        return getBytes(String.valueOf(j));
    }

    public static byte[] getBytes(String str) {
        byte[] bArr = new byte[0];
        if (str == null) {
            return bArr;
        }
        try {
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            Logger.w(TAG, "the content has error while it is converted to bytes");
            return bArr;
        }
    }

    public static String getTraceInfo(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder(1024);
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            sb.append("at ");
            sb.append(stackTraceElement.toString());
            sb.append(t.aE);
            i = i2 + 1;
        }
    }

    public static String replace(String str, CharSequence charSequence, CharSequence charSequence2) {
        if (IS_AEGIS_STRING_LIBRARY_LOADED || checkCompatible(SAFE_STRING_PATH)) {
            try {
                return SafeString.replace(str, charSequence, charSequence2);
            } catch (Throwable th) {
                Logger.w(TAG, "SafeString.substring error");
            }
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            str2 = str;
            if (!TextUtils.isEmpty(charSequence)) {
                try {
                    str2 = str.replace(charSequence, charSequence2);
                } catch (Exception e) {
                    return str;
                }
            }
        }
        return str2;
    }

    public static byte[] str2Byte(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            Logger.w("StringUtils.str2Byte error: UnsupportedEncodingException", anonymizeMessage(e.getMessage()));
            return new byte[0];
        }
    }

    public static boolean strEquals(String str, String str2) {
        if (str != str2) {
            return str != null && str.equals(str2);
        }
        return true;
    }

    public static boolean stringToBoolean(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        try {
            return Boolean.valueOf(str).booleanValue();
        } catch (NumberFormatException e) {
            Logger.w(TAG, "String to Integer catch NumberFormatException." + anonymizeMessage(e.getMessage()));
            return z;
        }
    }

    public static int stringToInteger(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            Logger.w(TAG, "String to Integer catch NumberFormatException." + anonymizeMessage(e.getMessage()));
            return i;
        }
    }

    public static long stringToLong(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            Logger.w(TAG, "String to Long catch NumberFormatException." + anonymizeMessage(e.getMessage()));
            return j;
        }
    }

    public static String substring(String str, int i) {
        if (checkCompatible(SAFE_STRING_PATH)) {
            try {
                return SafeString.substring(str, i);
            } catch (Throwable th) {
                Logger.w(TAG, "SafeString.substring error");
            }
        }
        if (TextUtils.isEmpty(str) || str.length() < i || i < 0) {
            return "";
        }
        try {
            return str.substring(i);
        } catch (Exception e) {
            return "";
        }
    }

    public static String substring(String str, int i, int i2) {
        if (IS_AEGIS_STRING_LIBRARY_LOADED || checkCompatible(SAFE_STRING_PATH)) {
            try {
                return SafeString.substring(str, i, i2);
            } catch (Throwable th) {
                Logger.w(TAG, "SafeString.substring error");
            }
        }
        if (TextUtils.isEmpty(str) || i < 0 || i2 > str.length() || i2 < i) {
            return "";
        }
        try {
            return str.substring(i, i2);
        } catch (Exception e) {
            return "";
        }
    }

    public static String toLowerCase(String str) {
        return str == null ? "" : str.toLowerCase(Locale.ROOT);
    }
}
