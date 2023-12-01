package com.opos.cmn.nt.crypt;

import android.text.TextUtils;
import android.util.Base64;
import com.opos.cmn.an.f.a;
import java.nio.charset.StandardCharsets;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/nt/crypt/EncryptUtils.class */
public final class EncryptUtils {
    public static final int DECRYPT_SCENES_ID_OF_OBTAIN_PHONE_NUMBER = 1;
    private static final byte[] DEFAULT_BYTE_DATA = new byte[0];
    private static final String DEFAULT_DATA = "";
    public static final int ENCRYPT_SCENES_ID_OF_ST = 0;
    public static final int SCENES_ID_OF_LOCAL_DATA = 0;
    public static final int SCENES_ID_OF_NET_DATA = 1;
    private static volatile boolean SO_ENABLED = false;
    private static final String TAG = "EncryptUtils";

    static {
        try {
            System.loadLibrary("ads-c");
            SO_ENABLED = true;
        } catch (Throwable th) {
            SO_ENABLED = false;
            a.c(TAG, "so error:", th);
        }
    }

    private static final byte[] decodeBase64(String str) {
        byte[] bArr = DEFAULT_BYTE_DATA;
        if (!TextUtils.isEmpty(str)) {
            try {
                return Base64.decode(str.getBytes(StandardCharsets.UTF_8), 2);
            } catch (Exception e) {
                a.c(TAG, "decodeBase64", e);
            }
        }
        return bArr;
    }

    private static final native byte[] decryptByScenesId(byte[] bArr, int i);

    private static final native byte[] decryptBytesV3(byte[] bArr, int i);

    private static final String encodeBase64(byte[] bArr) {
        if (bArr != null) {
            try {
                return Base64.encodeToString(bArr, 2);
            } catch (Exception e) {
                a.c(TAG, "encodeBase64", e);
                return "";
            }
        }
        return "";
    }

    private static final native byte[] encryptByScenesId(byte[] bArr, int i);

    private static final native byte[] encryptBytesV3(byte[] bArr, int i);

    @Deprecated
    public static final String executeDecrypt(String str) {
        return executeDecryptByScenesId(str, 1);
    }

    @Deprecated
    public static final String executeDecryptByScenesId(String str, int i) {
        if (!SO_ENABLED || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] decodeBase64 = decodeBase64(str);
            if (decodeBase64 == null || decodeBase64.length <= 0) {
                return "";
            }
            byte[] decryptByScenesId = decryptByScenesId(decodeBase64, i);
            String str2 = (decryptByScenesId == null || decryptByScenesId.length <= 0) ? "" : new String(decryptByScenesId, StandardCharsets.UTF_8);
            String str3 = str2;
            if (!TextUtils.isEmpty(str2)) {
                str3 = str2;
                if (str2.endsWith("sCt4VHQc")) {
                    str3 = str2;
                    if (str2.length() > 8) {
                        str3 = str2.substring(0, str2.length() - 8);
                    }
                }
            }
            return TextUtils.isEmpty(str3) ? "" : str3;
        } catch (Throwable th) {
            a.c(TAG, "executeDecryptByScenesId", th);
            return "";
        }
    }

    public static final byte[] executeDecryptBytesV3(byte[] bArr, int i) {
        byte[] bArr2;
        if (SO_ENABLED && bArr != null && bArr.length > 0) {
            try {
                byte[] decryptBytesV3 = decryptBytesV3(bArr, i);
                bArr2 = decryptBytesV3;
                if (decryptBytesV3 == null) {
                    return DEFAULT_BYTE_DATA;
                }
            } catch (Throwable th) {
                a.c(TAG, "executeDecryptBytesV3", th);
            }
            return bArr2;
        }
        bArr2 = DEFAULT_BYTE_DATA;
        return bArr2;
    }

    public static final String executeDecryptStringV3(String str, int i) {
        byte[] decryptBytesV3;
        if (!SO_ENABLED || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] decodeBase64 = decodeBase64(str);
            if (decodeBase64 == null || decodeBase64.length <= 0 || (decryptBytesV3 = decryptBytesV3(decodeBase64, i)) == null || decryptBytesV3.length <= 0) {
                return "";
            }
            String str2 = new String(decryptBytesV3, StandardCharsets.UTF_8);
            return TextUtils.isEmpty(str2) ? "" : str2;
        } catch (Throwable th) {
            a.c(TAG, "executeDecryptStringV3", th);
            return "";
        }
    }

    @Deprecated
    public static final String executeEncrypt(String str) {
        return executeEncryptByScenesId(str, 0);
    }

    @Deprecated
    public static final String executeEncryptByScenesId(String str, int i) {
        if (!SO_ENABLED || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] encryptByScenesId = encryptByScenesId((str + "WTpiiGG9").getBytes(StandardCharsets.UTF_8), i);
            String encodeBase64 = (encryptByScenesId == null || encryptByScenesId.length <= 0) ? "" : encodeBase64(encryptByScenesId);
            return TextUtils.isEmpty(encodeBase64) ? "" : encodeBase64;
        } catch (Throwable th) {
            a.c(TAG, "executeEncryptByScenesId", th);
            return "";
        }
    }

    public static final byte[] executeEncryptBytesV2(byte[] bArr) {
        return executeEncryptBytesV3(bArr, 1);
    }

    public static final byte[] executeEncryptBytesV3(byte[] bArr, int i) {
        byte[] bArr2;
        if (SO_ENABLED && bArr != null && bArr.length > 0) {
            try {
                byte[] encryptBytesV3 = encryptBytesV3(bArr, i);
                bArr2 = encryptBytesV3;
                if (encryptBytesV3 == null) {
                    return DEFAULT_BYTE_DATA;
                }
            } catch (Throwable th) {
                a.c(TAG, "executeEncryptBytesV3", th);
            }
            return bArr2;
        }
        bArr2 = DEFAULT_BYTE_DATA;
        return bArr2;
    }

    public static final String executeEncryptStringV3(String str, int i) {
        if (!SO_ENABLED || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] encryptBytesV3 = encryptBytesV3(str.getBytes(StandardCharsets.UTF_8), i);
            if (encryptBytesV3 == null || encryptBytesV3.length <= 0) {
                return "";
            }
            String encodeBase64 = encodeBase64(encryptBytesV3);
            return TextUtils.isEmpty(encodeBase64) ? "" : encodeBase64;
        } catch (Throwable th) {
            a.c(TAG, "executeEncryptStringV3", th);
            return "";
        }
    }

    @Deprecated
    public static final String executeMD5(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        }
        return str2;
    }

    @Deprecated
    public static final String executeSHA256(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        }
        return str2;
    }

    public static boolean isSoEnabled() {
        return SO_ENABLED;
    }
}
