package com.heytap.baselib.utils;

import android.text.Spanned;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/baselib/utils/ClientIdHelper.class */
class ClientIdHelper {
    private static String EXTRAS_KEY_A0 = "A0";
    private static int EXTRAS_KEY_CLIENT_ID_LEN = 15;
    private static String EXTRAS_KEY_GEN = "G0";
    private static String EXTRAS_KEY_NULL = "null";
    private static String EXTRAS_KEY_UNKNOWN = "unknown";
    private static String EXTRAS_KEY_ZERO = "0";

    ClientIdHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String buildClientId() {
        String substring = new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date()).substring(0, 6);
        String str = substring + uuidHashCode();
        String str2 = str;
        if (str.length() < EXTRAS_KEY_CLIENT_ID_LEN) {
            str2 = (str + "123456789012345").substring(0, EXTRAS_KEY_CLIENT_ID_LEN);
        }
        return checkClientIdLength(idIOUtil.replaceNonHexChar(str2).replace(",", substring));
    }

    private static String checkClientIdLength(String str) {
        int length = str.length();
        if (length < 29) {
            StringBuilder sb = new StringBuilder(str);
            while (length < 29) {
                sb.append("0");
                length = sb.length();
            }
            return sb.toString();
        }
        return str.substring(0, 29);
    }

    public static boolean hasIMEIRetCode(int i) {
        return i == Constant.RET_CODE_IMEI_CACHED || i == Constant.RET_CODE_IMEI_SUCCESS;
    }

    public static boolean hasLocalIDRetCode(int i) {
        return (i & 65280) != 0;
    }

    public static boolean hasTVUUIDRetCode(int i) {
        return (i & Spanned.SPAN_PRIORITY) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isGeneratedClientId(String str) {
        return str.startsWith(EXTRAS_KEY_A0) || str.startsWith(EXTRAS_KEY_GEN);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isInvalidClientId(String str) {
        return idIOUtil.isNullOrEmpty(str) || EXTRAS_KEY_UNKNOWN.equalsIgnoreCase(str) || EXTRAS_KEY_NULL.equalsIgnoreCase(str) || EXTRAS_KEY_ZERO.equalsIgnoreCase(str);
    }

    private static String uuidHashCode() {
        String valueOf = String.valueOf(Math.abs(UUID.randomUUID().toString().hashCode()));
        String str = valueOf;
        if (valueOf.length() < 9) {
            while (true) {
                str = valueOf;
                if (valueOf.length() >= 9) {
                    break;
                }
                valueOf = valueOf + "0";
            }
        }
        return str.substring(0, 9);
    }
}
