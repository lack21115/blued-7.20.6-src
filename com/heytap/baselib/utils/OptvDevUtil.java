package com.heytap.baselib.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/heytap/baselib/utils/OptvDevUtil.class */
public class OptvDevUtil {
    public static final String TYPE_TV = "TV";
    private static IDResult UUID;
    private static final String TAG = OptvDevUtil.class.getSimpleName();
    private static final String BRAND = idIOUtil.base64Decode("T25lUGx1c1RW");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/heytap/baselib/utils/OptvDevUtil$MD5Util.class */
    public static class MD5Util {
        public static final String TAG = MD5Util.class.getSimpleName();

        private MD5Util() {
        }

        public static String md5(String str) {
            StringBuilder sb = new StringBuilder();
            if (str != null && !str.equals("")) {
                try {
                    byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
                    int length = digest.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        String upperCase = Integer.toHexString(digest[i2] & 255).toUpperCase();
                        if (upperCase.length() == 1) {
                            sb.append("0");
                        }
                        sb.append(upperCase);
                        i = i2 + 1;
                    }
                } catch (NoSuchAlgorithmException e) {
                    if (ClientIdEnvironment.debug) {
                        ClientIdEnvironment.log(e.toString());
                    }
                }
            }
            return sb.toString();
        }
    }

    OptvDevUtil() {
    }

    public static String getMacAddress() {
        return getMacFromHardware("eth0");
    }

    private static String getMacFromHardware(String str) {
        NetworkInterface networkInterface;
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            do {
                if (!it.hasNext()) {
                    return "02:00:00:00:00:00";
                }
                networkInterface = (NetworkInterface) it.next();
            } while (!networkInterface.getName().equalsIgnoreCase(str));
            byte[] hardwareAddress = networkInterface.getHardwareAddress();
            if (hardwareAddress == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int length = hardwareAddress.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
                i = i2 + 1;
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Exception e) {
            if (ClientIdEnvironment.debug) {
                ClientIdEnvironment.log(e.toString());
                return "02:00:00:00:00:00";
            }
            return "02:00:00:00:00:00";
        }
    }

    public static String getSerialNumber() {
        return Build.VERSION.SDK_INT >= 26 ? Build.getSerial() : "";
    }

    public static String getUUID() {
        return getUUIDWithRetCode().mResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IDResult getUUIDWithRetCode() {
        IDResult iDResult = UUID;
        if (iDResult == null || TextUtils.isEmpty(iDResult.mResult)) {
            String serialNumber = getSerialNumber();
            String removeMacAddressColon = removeMacAddressColon(getMacAddress());
            IDResult iDResult2 = new IDResult(MD5Util.md5(serialNumber + removeMacAddressColon + MD5Util.md5(BRAND)), Constant.RET_CODE_TV_UUID_FAILED);
            if (TextUtils.isEmpty(serialNumber) || TextUtils.isEmpty(removeMacAddressColon)) {
                Log.e(TAG, "Invalid uuid : SN or MAC is null.");
            } else {
                iDResult2.retCode = Constant.RET_CODE_TV_UUID_SUCCESS;
                UUID = iDResult2;
            }
            return iDResult2;
        }
        return UUID;
    }

    public static String getWiFiMacAddress() {
        return getMacFromHardware("wlan0");
    }

    private static String removeMacAddressColon(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sb.length()) {
                return sb.toString();
            }
            int i3 = i2;
            if (':' == sb.charAt(i2)) {
                sb.deleteCharAt(i2);
                i3 = i2 - 1;
            }
            i = i3 + 1;
        }
    }
}
