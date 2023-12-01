package android.telecom;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.IllegalFormatException;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/Log.class */
public final class Log {
    public static final boolean FORCE_LOGGING = false;
    private static final String TAG = "TelecomFramework";
    public static final boolean DEBUG = isLoggable(3);
    public static final boolean INFO = isLoggable(4);
    public static final boolean VERBOSE = isLoggable(2);
    public static final boolean WARN = isLoggable(5);
    public static final boolean ERROR = isLoggable(6);

    private Log() {
    }

    private static String buildMessage(String str, String str2, Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    str2 = String.format(Locale.US, str2, objArr);
                }
            } catch (IllegalFormatException e) {
                wtf("Log", (Throwable) e, "IllegalFormatException: formatString='%s' numArgs=%d", str2, Integer.valueOf(objArr.length));
                str2 = str2 + " (An error occurred while formatting the message.)";
            }
        }
        return String.format(Locale.US, "%s: %s", str, str2);
    }

    public static void d(Object obj, String str, Object... objArr) {
        if (DEBUG) {
            android.util.Log.d(TAG, buildMessage(getPrefixFromObject(obj), str, objArr));
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (DEBUG) {
            android.util.Log.d(TAG, buildMessage(str, str2, objArr));
        }
    }

    public static void e(Object obj, Throwable th, String str, Object... objArr) {
        if (ERROR) {
            android.util.Log.e(TAG, buildMessage(getPrefixFromObject(obj), str, objArr), th);
        }
    }

    public static void e(String str, Throwable th, String str2, Object... objArr) {
        if (ERROR) {
            android.util.Log.e(TAG, buildMessage(str, str2, objArr), th);
        }
    }

    private static String encodeHex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return stringBuffer.toString();
            }
            int i3 = bArr[i2] & 255;
            if (i3 < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toString(i3, 16));
            i = i2 + 1;
        }
    }

    private static String getPrefixFromObject(Object obj) {
        return obj == null ? "<null>" : obj.getClass().getSimpleName();
    }

    public static void i(Object obj, String str, Object... objArr) {
        if (INFO) {
            android.util.Log.i(TAG, buildMessage(getPrefixFromObject(obj), str, objArr));
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (INFO) {
            android.util.Log.i(TAG, buildMessage(str, str2, objArr));
        }
    }

    public static boolean isLoggable(int i) {
        return android.util.Log.isLoggable(TAG, i);
    }

    public static String pii(Object obj) {
        return (obj == null || VERBOSE) ? String.valueOf(obj) : "[" + secureHash(String.valueOf(obj).getBytes()) + "]";
    }

    private static String secureHash(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr);
            return encodeHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static void v(Object obj, String str, Object... objArr) {
        if (VERBOSE) {
            android.util.Log.v(TAG, buildMessage(getPrefixFromObject(obj), str, objArr));
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (VERBOSE) {
            android.util.Log.v(TAG, buildMessage(str, str2, objArr));
        }
    }

    public static void w(Object obj, String str, Object... objArr) {
        if (WARN) {
            android.util.Log.w(TAG, buildMessage(getPrefixFromObject(obj), str, objArr));
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (WARN) {
            android.util.Log.w(TAG, buildMessage(str, str2, objArr));
        }
    }

    public static void wtf(Object obj, String str, Object... objArr) {
        String buildMessage = buildMessage(getPrefixFromObject(obj), str, objArr);
        android.util.Log.wtf(TAG, buildMessage, new IllegalStateException(buildMessage));
    }

    public static void wtf(Object obj, Throwable th, String str, Object... objArr) {
        android.util.Log.wtf(TAG, buildMessage(getPrefixFromObject(obj), str, objArr), th);
    }

    public static void wtf(String str, String str2, Object... objArr) {
        String buildMessage = buildMessage(str, str2, objArr);
        android.util.Log.wtf(TAG, buildMessage, new IllegalStateException(buildMessage));
    }

    public static void wtf(String str, Throwable th, String str2, Object... objArr) {
        android.util.Log.wtf(TAG, buildMessage(str, str2, objArr), th);
    }
}
