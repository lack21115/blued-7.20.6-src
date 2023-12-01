package com.baidu.idl.license;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.cos.xml.crypto.JceEncryptionConstants;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/idl/license/LicenseDevice.class */
public class LicenseDevice {
    private static final String KEY_DEVICE = "com.baidu.face.deviceid";
    private static final String KEY_FACE = "com.baidu.face";
    private static final String KEY_IMEI = "com.baidu.face.i";

    public static String decrypt(String str, String str2) throws Exception {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("ASCII"), "AES");
            Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
            cipher.init(2, secretKeySpec, new IvParameterSpec("01251500ascfacei".getBytes()));
            try {
                return new String(cipher.doFinal(Base64.decode(str, 2)));
            } catch (Exception e) {
                return "";
            }
        } catch (Exception e2) {
            System.out.println(e2.toString());
            return "";
        }
    }

    public static String encrypt(String str, String str2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
        cipher.init(1, secretKeySpec, new IvParameterSpec("01251500ascfacei".getBytes()));
        return Base64.encodeToString(cipher.doFinal(str.getBytes()), 2);
    }

    public static String getAndroidID(Context context) {
        return Settings.System.getString(context.getContentResolver(), "android_id");
    }

    public static String getDeviceCode(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return (telephonyManager == null || context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) ? "" : telephonyManager.getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getDeviceID(Context context) {
        String androidID = getAndroidID(context);
        if (Build.VERSION.SDK_INT >= 23) {
            return md5((KEY_FACE + androidID).getBytes());
        }
        String str = "";
        try {
            String imei = getImei(context);
            if (TextUtils.isEmpty(imei)) {
                String macAddr = getMacAddr();
                StringBuilder sb = new StringBuilder();
                sb.append(macAddr);
                sb.append(androidID);
                return md5(sb.toString().getBytes());
            }
            String string = Settings.System.getString(context.getContentResolver(), KEY_DEVICE);
            str = "";
            if (!TextUtils.isEmpty(string)) {
                try {
                    str = decrypt(string, imei + 1);
                    if (!TextUtils.isEmpty(str)) {
                        return str;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(imei);
            sb2.append(androidID);
            sb2.append(UUID.randomUUID());
            String md5 = md5(sb2.toString().getBytes());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(imei);
            sb3.append(1);
            Settings.System.putString(context.getContentResolver(), KEY_DEVICE, encrypt(md5, sb3.toString()));
            return md5;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    private static String getImei(Context context) {
        String string = Settings.System.getString(context.getContentResolver(), KEY_IMEI);
        if (!TextUtils.isEmpty(string)) {
            try {
                String decrypt = decrypt(string, "01251500ascfacei");
                if (!TextUtils.isEmpty(decrypt)) {
                    if (decrypt.length() == 15) {
                        return decrypt;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String deviceCode = getDeviceCode(context);
        if (!TextUtils.isEmpty(deviceCode)) {
            try {
                Settings.System.putString(context.getContentResolver(), KEY_IMEI, encrypt(deviceCode, "01251500ascfacei"));
                return deviceCode;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return deviceCode;
    }

    public static String getMacAddr() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
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
                }
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String md5(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder sb = new StringBuilder(digest.length * 2);
            int length = digest.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return sb.toString();
                }
                int i3 = digest[i2] & 255;
                if (i3 < 16) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(i3));
                i = i2 + 1;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
