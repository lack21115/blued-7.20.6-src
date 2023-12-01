package com.unikuwei.mianmi.account.shield.tencent.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Enumeration;
import javax.crypto.Cipher;

/* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/e/j.class */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f27321a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static int a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return -1;
            }
            if (activeNetworkInfo.getType() == 1) {
                if (a(connectivityManager)) {
                    g.b("Data and WIFI");
                    return 1;
                }
                g.b("Only WIFI");
                return 2;
            } else if (activeNetworkInfo.getType() == 0) {
                g.b("Only Data");
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (TextUtils.isEmpty(extraInfo)) {
                    return 0;
                }
                h.d(extraInfo);
                return 0;
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer("");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= digest.length) {
                    return stringBuffer.toString();
                }
                byte b = digest[i2];
                byte b2 = b;
                if (b < 0) {
                    b2 = b + 256;
                }
                if (b2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(b2));
                i = i2 + 1;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(String str, String str2) {
        PublicKey e = e(str2);
        Cipher cipher = Cipher.getInstance(new String(com.unikuwei.mianmi.account.shield.tencent.a.b.b("UlNBL0VDQi9QS0NTMVBhZGRpbmc=")));
        cipher.init(1, e);
        return com.unikuwei.mianmi.account.shield.tencent.a.b.a(cipher.doFinal(str.getBytes()));
    }

    public static String a(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(bArr);
            int length = digest.length;
            char[] cArr = new char[length * 2];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return new String(cArr);
                }
                byte b = digest[i2];
                byte b2 = digest[i2];
                int i3 = i2 * 2;
                cArr[i3] = f27321a[(b2 & 240) >> 4];
                cArr[i3 + 1] = f27321a[b & 15];
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean a(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            boolean booleanValue = ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
            g.a("data is on:" + booleanValue);
            return booleanValue;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static byte[] a(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo.packageName.equals(str)) {
                return packageInfo.signatures[0].toByteArray();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(Context context) {
        try {
            return (String) context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0));
        } catch (Exception e) {
            return "";
        }
    }

    public static String b(Context context, String str) {
        try {
            return a(a(context, str));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String b(String str) {
        int indexOf = str.indexOf("://");
        String str2 = str;
        if (indexOf > 0) {
            str2 = str.substring(indexOf + 3);
        }
        int indexOf2 = str2.indexOf(58);
        String str3 = str2;
        if (indexOf2 >= 0) {
            str3 = str2.substring(0, indexOf2);
        }
        int indexOf3 = str3.indexOf(47);
        String str4 = str3;
        if (indexOf3 >= 0) {
            str4 = str3.substring(0, indexOf3);
        }
        int indexOf4 = str4.indexOf(63);
        String str5 = str4;
        if (indexOf4 >= 0) {
            str5 = str4.substring(0, indexOf4);
        }
        return str5;
    }

    public static int c(String str) {
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            return (address[0] & 255) | ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8);
        } catch (UnknownHostException e) {
            return -1;
        }
    }

    public static String c(Context context) {
        try {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (!nextElement.getName().toLowerCase().contains("wlan") && !nextElement.getName().toLowerCase().contains("tun")) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (!nextElement2.isLoopbackAddress() && !nextElement2.isLinkLocalAddress()) {
                            if (nextElement2 instanceof Inet4Address) {
                                sb.append(nextElement2.getHostAddress());
                                sb.append(",");
                            }
                            if (nextElement2 instanceof Inet6Address) {
                                sb2.append(nextElement2.getHostAddress());
                                sb2.append(",");
                            }
                        }
                    }
                }
            }
            StringBuilder sb3 = sb;
            if (sb.length() > 0) {
                sb3 = sb.delete(sb.length() - 1, sb.length());
            }
            StringBuilder sb4 = sb2;
            if (sb2.length() > 0) {
                sb4 = sb2.delete(sb2.length() - 1, sb2.length());
            }
            String str = sb3.toString() + "|" + sb4.toString();
            g.b(str);
            if (!TextUtils.isEmpty(sb3.toString())) {
                h.e(sb3.toString());
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String d(String str) {
        try {
            return a(str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbRkBR4leALApkWRp2ng8zJ2WgI7YEqtMwW9Q1tmRzDLPNhH0ugACfbiStBG4ybdYNHzRlxvOwQ7R0MeN56qEPsv6qieg/HiRXBnQ2hQ2hypo9JHqHx8BX54ESZ+BIf0imjGTcxtHvbzYA04ckmH5Enl2Pkd+R/RZuMK589C7KwQIDAQAB");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static PublicKey e(String str) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(com.unikuwei.mianmi.account.shield.tencent.a.b.b(str)));
    }
}
