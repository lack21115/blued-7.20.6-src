package com.tencent.turingcam;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Debug;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.JsonWriter;
import android.util.Log;
import android.util.SparseArray;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.turingface.sdk.mfa.Bwfl9;
import com.tencent.turingface.sdk.mfa.G1g37;
import com.tencent.turingface.sdk.mfa.G2SZT;
import com.tencent.turingface.sdk.mfa.KKOXW;
import com.tencent.turingface.sdk.mfa.ORjG3;
import com.tencent.turingface.sdk.mfa.V3a8U;
import com.tencent.turingface.sdk.mfa.bUA8L;
import com.tencent.turingface.sdk.mfa.fDI6Z;
import com.tencent.turingface.sdk.mfa.kC0XR;
import com.tencent.turingface.sdk.mfa.tbHx2;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/oqKCa.class */
public class oqKCa {

    /* renamed from: a  reason: collision with root package name */
    public static int f39831a;

    public static byte a(Context context) {
        boolean z = true;
        byte b = -1;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    if (activeNetworkInfo.getType() == 1) {
                        return (byte) 0;
                    }
                    if (activeNetworkInfo.getType() == 0) {
                        if (Proxy.getDefaultHost() == null) {
                            return Proxy.getHost(context) != null ? (byte) 2 : (byte) 1;
                        }
                        return (byte) 2;
                    }
                    return (byte) -1;
                }
                return (byte) -1;
            }
            return (byte) -1;
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message == null || !message.contains("ACCESS_NETWORK_STATE")) {
                z = false;
            }
            if (z) {
                b = 0;
            }
            return b;
        }
    }

    public static int a(int i, boolean z, int i2) {
        return i | ((z ? 1 : 0) << i2);
    }

    public static int a(byte[] bArr, int i, char c2) {
        int i2 = i - 1;
        while (true) {
            int i3 = i2;
            int i4 = i3 + 1;
            if (i3 < bArr.length) {
                if (i4 != bArr.length && bArr[i4] != c2) {
                    i2 = i4;
                }
                return i4;
            }
            return 0;
        }
    }

    public static com.tencent.turingface.sdk.mfa.ucT3w a(com.tencent.turingface.sdk.mfa.ucT3w uct3w, byte[] bArr) {
        byte[] bArr2;
        if (bArr == null || bArr.length == 0) {
            Log.w("TuringDebug", "u1");
            return uct3w;
        }
        byte[] a2 = a(bArr, b());
        if (a2 == null || a2.length == 0) {
            Log.w("TuringDebug", "u2");
            return uct3w;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a2);
        InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inflaterInputStream.read();
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(read);
            } catch (Exception e) {
                try {
                    byteArrayInputStream.close();
                    inflaterInputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                bArr2 = null;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                    inflaterInputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                throw th;
            }
        }
        bArr2 = byteArrayOutputStream.toByteArray();
        try {
            byteArrayInputStream.close();
            inflaterInputStream.close();
            byteArrayOutputStream.close();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        if (bArr2 == null || bArr2.length == 0) {
            Log.w("TuringDebug", "u3");
            return uct3w;
        }
        KKOXW kkoxw = new KKOXW();
        new HashMap();
        HashMap hashMap = new HashMap();
        kkoxw.d = (short) 3;
        kkoxw.g = 3;
        if (bArr2.length >= 4) {
            try {
                com.tencent.turingface.sdk.mfa.nyvKz nyvkz = new com.tencent.turingface.sdk.mfa.nyvKz(bArr2, 4);
                nyvkz.b = "UTF-8";
                kkoxw.a(nyvkz);
                nyvkz.f39970a = ByteBuffer.wrap(kkoxw.j);
                if (G2SZT.f39878a == null) {
                    HashMap<String, byte[]> hashMap2 = new HashMap<>();
                    G2SZT.f39878a = hashMap2;
                    hashMap2.put("", new byte[0]);
                }
                HashMap a3 = nyvkz.a((Map) G2SZT.f39878a, 0, false);
                Object obj = null;
                try {
                    if (a3.containsKey("resp")) {
                        if (hashMap.containsKey("resp")) {
                            obj = hashMap.get("resp");
                        } else {
                            byte[] bArr3 = (byte[]) a3.get("resp");
                            try {
                                com.tencent.turingface.sdk.mfa.nyvKz nyvkz2 = new com.tencent.turingface.sdk.mfa.nyvKz();
                                nyvkz2.f39970a = ByteBuffer.wrap(bArr3);
                                nyvkz2.b = "UTF-8";
                                Object a4 = nyvkz2.a((com.tencent.turingface.sdk.mfa.nyvKz) uct3w, 0, true);
                                obj = a4;
                                if (a4 != null) {
                                    hashMap.put("resp", a4);
                                    obj = a4;
                                }
                            } catch (Exception e5) {
                                throw new Exception(e5);
                            }
                        }
                    }
                    return (com.tencent.turingface.sdk.mfa.ucT3w) obj;
                } catch (Throwable th2) {
                    Log.w("TuringDebug", th2);
                    return uct3w;
                }
            } catch (Exception e6) {
                throw new RuntimeException(e6);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    public static <E> E a(SparseArray<Object> sparseArray, int i, Class<E> cls) {
        if (sparseArray == null) {
            return null;
        }
        Object obj = sparseArray.get(i);
        E e = null;
        if (cls.isInstance(obj)) {
            e = cls.cast(obj);
        }
        return e;
    }

    public static String a() {
        try {
            File file = new File("/system/lib");
            if (!file.canRead()) {
                return "";
            }
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return "";
                }
                File file2 = listFiles[i2];
                if (file2.getName().contains("rockchip")) {
                    return file2.getAbsolutePath();
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            return "";
        }
    }

    public static String a(int i) {
        try {
            byte[] a2 = a(String.format(Locale.SIMPLIFIED_CHINESE, "/proc/%d/cmdline", Integer.valueOf(i)), 100);
            String str = a2 != null ? new String(a2, 0, a(a2, 0, (char) 0)) : "";
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                byte[] a3 = a(String.format(Locale.SIMPLIFIED_CHINESE, "/proc/%d/status", Integer.valueOf(i)), 150);
                str2 = str;
                if (a3 != null) {
                    int a4 = a(a3, 7, '\n');
                    if (a4 == 0) {
                        return "";
                    }
                    str2 = new String(a3, 6, a4 - 6);
                }
            }
            return str2;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String a(String str) {
        int indexOf;
        String[] split = str.split(" ", 3);
        if (split.length > 2 && "rwxp".equals(split[1]) && (indexOf = split[2].indexOf(47)) != -1) {
            String trim = split[2].substring(indexOf).trim();
            if (trim.startsWith("/data/")) {
                return null;
            }
            return split[1] + ";" + trim;
        }
        return null;
    }

    public static String a(String str, String str2, String str3) {
        String str4 = str3;
        if (!TextUtils.isEmpty(str3)) {
            str4 = str3.replace(str, str2);
        }
        return str4;
    }

    public static String a(String str, String str2, Pattern pattern, String str3) {
        int indexOf;
        String str4;
        boolean endsWith = str.endsWith(".so");
        boolean z = !endsWith && str.endsWith(ShareConstants.JAR_SUFFIX);
        if ((endsWith || z) && (indexOf = str.indexOf(47)) != -1) {
            String trim = str.substring(indexOf).trim();
            if (trim.startsWith("/data/")) {
                if (endsWith && str3 != null && trim.startsWith(str3)) {
                    return null;
                }
                String str5 = "/data/data/" + str2 + BridgeUtil.SPLIT_MARK;
                if (trim.startsWith(str5)) {
                    return null;
                }
                if (trim.startsWith("/data/app/" + str2) || pattern.matcher(trim).find()) {
                    return null;
                }
                if (endsWith) {
                    try {
                        str4 = new File(str5 + "lib").getCanonicalPath();
                    } catch (IOException e) {
                        str4 = null;
                    }
                    if (str4 == null || trim.startsWith(str4)) {
                        return null;
                    }
                }
                return trim;
            }
            return null;
        }
        return null;
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return stringBuffer.toString();
            }
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase(Locale.getDefault()));
            i = i2 + 1;
        }
    }

    public static List<String> a(File file) throws IOException {
        ArrayList arrayList = new ArrayList();
        JarFile jarFile = new JarFile(file);
        try {
            Certificate[] a2 = a(jarFile, jarFile.getJarEntry(ShareConstants.RES_MANIFEST), new byte[8192]);
            if (a2 != null) {
                int length = a2.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    arrayList.add(com.tencent.turingface.sdk.mfa.EQsUZ.a(a2[i2].getEncoded()));
                    i = i2 + 1;
                }
            }
        } catch (Exception e) {
        } catch (Throwable th) {
            jarFile.close();
            throw th;
        }
        jarFile.close();
        return arrayList;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    public static void a(byte[] bArr, int[] iArr) {
        int i;
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= (length >> 2)) {
                break;
            }
            int i4 = i + 1;
            iArr[i2] = bArr[i] & 255;
            int i5 = i4 + 1;
            iArr[i2] = iArr[i2] | ((bArr[i4] & 255) << 8);
            int i6 = i5 + 1;
            iArr[i2] = iArr[i2] | ((bArr[i5] & 255) << 16);
            iArr[i2] = iArr[i2] | ((bArr[i6] & 255) << 24);
            i2++;
            i3 = i6 + 1;
        }
        if (i >= bArr.length) {
            return;
        }
        int i7 = i + 1;
        iArr[i2] = bArr[i] & 255;
        int i8 = 8;
        while (true) {
            int i9 = i8;
            if (i7 >= bArr.length) {
                return;
            }
            iArr[i2] = iArr[i2] | ((bArr[i7] & 255) << i9);
            i7++;
            i8 = i9 + 8;
        }
    }

    public static void a(int[] iArr, int i, byte[] bArr) {
        int length = bArr.length >> 2;
        int i2 = length;
        if (length > i) {
            i2 = i;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i4 + 1;
            bArr[i4] = (byte) (iArr[i3] & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((iArr[i3] >>> 8) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((iArr[i3] >>> 16) & 255);
            i4 = i7 + 1;
            bArr[i7] = (byte) ((iArr[i3] >>> 24) & 255);
            i3++;
        }
        if (i <= i2 || i4 >= bArr.length) {
            return;
        }
        bArr[i4] = (byte) (iArr[i3] & 255);
        int i8 = 8;
        for (int i9 = i4 + 1; i8 <= 24 && i9 < bArr.length; i9++) {
            bArr[i9] = (byte) ((iArr[i3] >>> i8) & 255);
            i8 += 8;
        }
    }

    public static boolean a(String str, String str2) {
        int indexOf;
        if (str2 == null || (indexOf = str2.indexOf(47)) == -1) {
            return false;
        }
        String trim = str2.substring(indexOf).trim();
        if (trim.startsWith("/data/")) {
            if (trim.startsWith("/data/data/" + str + BridgeUtil.SPLIT_MARK)) {
                return false;
            }
            boolean endsWith = trim.endsWith(".so");
            return (endsWith || (!endsWith && trim.endsWith(ShareConstants.JAR_SUFFIX))) && str2.contains(kC0XR.a(kC0XR.m));
        }
        return false;
    }

    public static boolean a(InetAddress inetAddress) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket((SocketAddress) null);
            datagramSocket.send(new DatagramPacket(new byte[0], 0, inetAddress, 65535));
            datagramSocket.close();
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static byte[] a(SparseArray<Object> sparseArray) {
        byte[] bArr = (byte[]) a(sparseArray, 1, byte[].class);
        byte[] bArr2 = bArr;
        if (bArr == null) {
            bArr2 = new byte[0];
        }
        return bArr2;
    }

    public static byte[] a(String str, int i) {
        FileInputStream fileInputStream;
        int i2;
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[i];
                int i3 = 0;
                do {
                    int read = fileInputStream2.read(bArr, i3, i - i3);
                    i2 = i3;
                    if (read == -1) {
                        break;
                    }
                    i2 = i3 + read;
                    i3 = i2;
                } while (i2 < i);
                if (i2 == 0) {
                    b(fileInputStream2);
                    return null;
                }
                byte[] bArr2 = bArr;
                if (i2 < i) {
                    bArr2 = new byte[i2];
                    System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, i2);
                }
                b(fileInputStream2);
                return bArr2;
            } catch (Throwable th) {
                fileInputStream = fileInputStream2;
                b(fileInputStream);
                return null;
            }
        } catch (Throwable th2) {
            fileInputStream = null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        int i;
        byte[] b = b(bArr2);
        if (b != null && bArr.length != 0) {
            if (bArr.length % 4 != 0 || bArr.length < 8) {
                return null;
            }
            int length = bArr.length >>> 2;
            int[] iArr = new int[length];
            a(bArr, iArr);
            int length2 = b.length % 4 == 0 ? b.length >>> 2 : (b.length >>> 2) + 1;
            if (length2 < 4) {
                length2 = 4;
            }
            int[] iArr2 = new int[length2];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length2) {
                    break;
                }
                iArr2[i3] = 0;
                i2 = i3 + 1;
            }
            a(b, iArr2);
            int i4 = length - 1;
            int i5 = iArr[i4];
            int i6 = iArr[0];
            int i7 = ((52 / (i4 + 1)) + 6) * (-1640531527);
            while (true) {
                int i8 = i7;
                if (i8 == 0) {
                    break;
                }
                int i9 = (i8 >>> 2) & 3;
                int i10 = i6;
                int i11 = i4;
                while (true) {
                    i = i11;
                    if (i > 0) {
                        int i12 = iArr[i - 1];
                        i10 = iArr[i] - (((i10 ^ i8) + (i12 ^ iArr2[(i & 3) ^ i9])) ^ (((i12 >>> 5) ^ (i10 << 2)) + ((i10 >>> 3) ^ (i12 << 4))));
                        iArr[i] = i10;
                        i11 = i - 1;
                    }
                }
                int i13 = iArr[i4];
                i6 = iArr[0] - (((i10 ^ i8) + (iArr2[i9 ^ (i & 3)] ^ i13)) ^ (((i13 >>> 5) ^ (i10 << 2)) + ((i10 >>> 3) ^ (i13 << 4))));
                iArr[0] = i6;
                i7 = i8 + 1640531527;
            }
            int i14 = iArr[i4];
            if (i14 < 0 || i14 > (i4 << 2)) {
                return null;
            }
            byte[] bArr3 = new byte[i14];
            a(iArr, i4, bArr3);
            return bArr3;
        }
        return bArr;
    }

    public static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        InputStream inputStream;
        InputStream inputStream2;
        try {
            inputStream2 = jarFile.getInputStream(jarEntry);
            while (inputStream2.read(bArr, 0, bArr.length) != -1) {
                try {
                } catch (IOException e) {
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                            return null;
                        } catch (IOException e2) {
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    inputStream = inputStream2;
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            }
            Certificate[] certificateArr = null;
            if (jarEntry != null) {
                certificateArr = jarEntry.getCertificates();
            }
            try {
                inputStream2.close();
                return certificateArr;
            } catch (IOException e4) {
                return certificateArr;
            }
        } catch (IOException e5) {
            inputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public static int b(Context context) {
        boolean z;
        int i = Build.VERSION.SDK_INT;
        int a2 = a(a(0, i < 17 ? Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0 : Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0, 0), i >= 17 && Settings.Secure.getInt(context.getContentResolver(), "development_settings_enabled", 0) > 0, 1);
        if ((context.getApplicationInfo().flags & 2) > 0) {
            z = true;
            return a(a(a2, z, 2), Debug.isDebuggerConnected(), 3);
        }
        z = false;
        return a(a(a2, z, 2), Debug.isDebuggerConnected(), 3);
    }

    public static int b(SparseArray<Object> sparseArray) {
        Integer num = (Integer) a(sparseArray, 0, Integer.class);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.turingface.sdk.mfa.bUA8L b(int r9) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingcam.oqKCa.b(int):com.tencent.turingface.sdk.mfa.bUA8L");
    }

    public static StringBuilder b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    public static boolean b(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                try {
                    return file.delete();
                } catch (Throwable th) {
                    return false;
                }
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < length) {
                        b(listFiles[i2]);
                        i = i2 + 1;
                    }
                }
            }
            try {
                return file.delete();
            } catch (Throwable th2) {
                return false;
            }
        }
        return true;
    }

    public static byte[] b() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            String a2 = kC0XR.a(kC0XR.D0);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= a2.length()) {
                    return stringBuffer.toString().getBytes("UTF-8");
                }
                stringBuffer.append((char) (a2.charAt(i2) + new int[]{-36, -46, -45, -77, -22, -10, 47, -77, -72, -69, -32, 25, 21, -21, -6, -75, -71, 31, -39, -49, -49}[i2]));
                i = i2 + 1;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] b(byte[] bArr) {
        byte[] bArr2 = bArr;
        if (bArr != null) {
            bArr2 = bArr;
            if (bArr.length > 16) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(bArr);
                    return messageDigest.digest();
                } catch (Throwable th) {
                    bArr2 = null;
                }
            }
        }
        return bArr2;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        int i;
        byte[] b = b(bArr2);
        byte[] bArr3 = bArr;
        if (bArr != null) {
            bArr3 = bArr;
            if (b != null) {
                if (bArr.length == 0) {
                    return bArr;
                }
                int length = bArr.length % 4 == 0 ? (bArr.length >>> 2) + 1 : (bArr.length >>> 2) + 2;
                int[] iArr = new int[length];
                a(bArr, iArr);
                int i2 = length - 1;
                iArr[i2] = bArr.length;
                int length2 = b.length % 4 == 0 ? b.length >>> 2 : (b.length >>> 2) + 1;
                if (length2 < 4) {
                    length2 = 4;
                }
                int[] iArr2 = new int[length2];
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length2) {
                        break;
                    }
                    iArr2[i4] = 0;
                    i3 = i4 + 1;
                }
                a(b, iArr2);
                int i5 = iArr[i2];
                int i6 = iArr[0];
                int i7 = (52 / (i2 + 1)) + 6;
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    if (i7 <= 0) {
                        break;
                    }
                    int i10 = i9 - 1640531527;
                    int i11 = (i10 >>> 2) & 3;
                    int i12 = 0;
                    while (true) {
                        i = i12;
                        if (i < i2) {
                            int i13 = i + 1;
                            int i14 = iArr[i13];
                            i5 = ((((i5 >>> 5) ^ (i14 << 2)) + ((i14 >>> 3) ^ (i5 << 4))) ^ ((i14 ^ i10) + (i5 ^ iArr2[(i & 3) ^ i11]))) + iArr[i];
                            iArr[i] = i5;
                            i12 = i13;
                        }
                    }
                    int i15 = iArr[0];
                    i5 = ((((i5 >>> 5) ^ (i15 << 2)) + ((i15 >>> 3) ^ (i5 << 4))) ^ ((i15 ^ i10) + (i5 ^ iArr2[i11 ^ (i & 3)]))) + iArr[i2];
                    iArr[i2] = i5;
                    i7--;
                    i8 = i10;
                }
                bArr3 = new byte[length << 2];
                a(iArr, length, bArr3);
            }
        }
        return bArr3;
    }

    public static fDI6Z c(Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            boolean z = false;
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            tbHx2 tbhx2 = new tbHx2();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, tbhx2, 1)) {
                try {
                    IBinder a2 = tbhx2.a();
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    a2.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    Parcel obtain3 = Parcel.obtain();
                    Parcel obtain4 = Parcel.obtain();
                    obtain3.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain3.writeInt(1);
                    a2.transact(2, obtain3, obtain4, 0);
                    obtain4.readException();
                    if (obtain4.readInt() != 0) {
                        z = true;
                    }
                    obtain4.recycle();
                    obtain3.recycle();
                    return new fDI6Z(readString, z);
                } catch (Exception e) {
                    return null;
                } finally {
                    context.unbindService(tbhx2);
                }
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public static String c() {
        int i;
        StringBuilder sb = new StringBuilder();
        int myPid = Process.myPid();
        bUA8L b = b(myPid);
        if (b != null && (i = b.e) != 0 && i != myPid) {
            sb.append(myPid);
            sb.append(",");
            sb.append(b.b);
            sb.append(",");
            sb.append(b.f39940c);
            sb.append(",");
            sb.append(i);
            sb.append(",");
            bUA8L b2 = b(i);
            if (b2 != null) {
                sb.append(b2.d);
                sb.append(",");
                sb.append(b2.f39940c);
                sb.append(",");
                sb.append(b2.b);
            }
            return sb.toString();
        }
        return sb.toString();
    }

    public static byte[] c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            int i3 = i2 * 2;
            bArr[i2] = Integer.valueOf(str.substring(i3, i3 + 2), 16).byteValue();
            i = i2 + 1;
        }
    }

    public static byte[] c(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.finish();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                deflaterOutputStream.close();
                return byteArray;
            } catch (IOException e) {
                e.printStackTrace();
                return byteArray;
            }
        } catch (Exception e2) {
            try {
                byteArrayOutputStream.close();
                deflaterOutputStream.close();
                return null;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
                deflaterOutputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    public static String d() {
        Iterator it = ((ArrayList) com.tencent.turingface.sdk.mfa.wmqhz.a()).iterator();
        while (it.hasNext()) {
            Bwfl9 bwfl9 = (Bwfl9) it.next();
            if (bwfl9.f39862a.contains(com.tencent.turingface.sdk.mfa.uAnWx.f40001c)) {
                return bwfl9.b;
            }
        }
        return "";
    }

    public static String d(Context context) {
        BufferedReader bufferedReader;
        Pattern[] patternArr;
        System.currentTimeMillis();
        HashSet hashSet = new HashSet();
        try {
            String packageName = context.getPackageName();
            Pattern compile = Pattern.compile("^/data/user/\\d+/" + packageName);
            String str = context.getApplicationInfo().nativeLibraryDir;
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(kC0XR.a(kC0XR.n)));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    bufferedReader = bufferedReader2;
                    if (readLine == null) {
                        break;
                    }
                    String a2 = a(readLine, packageName, compile, str);
                    if (a2 != null) {
                        hashSet.add(a2);
                    }
                } catch (Throwable th) {
                    bufferedReader = bufferedReader2;
                }
            }
        } catch (Throwable th2) {
            bufferedReader = null;
        }
        b(bufferedReader);
        String[] strArr = V3a8U.f39925a;
        synchronized (V3a8U.class) {
            try {
                if (V3a8U.b != null) {
                    patternArr = V3a8U.b;
                } else {
                    V3a8U.b = new Pattern[strArr.length];
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= V3a8U.b.length) {
                            break;
                        }
                        try {
                            arrayList.add(Pattern.compile(strArr[i2]));
                        } catch (Throwable th3) {
                        }
                        i = i2 + 1;
                    }
                    V3a8U.b = (Pattern[]) arrayList.toArray(new Pattern[0]);
                    patternArr = V3a8U.b;
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            int length = patternArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    break;
                } else if (patternArr[i4].matcher(str2).find()) {
                    it.remove();
                    break;
                } else {
                    i3 = i4 + 1;
                }
            }
        }
        if (hashSet.size() > 0) {
            StringBuilder sb = new StringBuilder();
            Iterator it2 = hashSet.iterator();
            int i5 = 0;
            while (it2.hasNext()) {
                int i6 = i5 + 1;
                sb.append((String) it2.next());
                if (i6 >= 8) {
                    break;
                }
                i5 = i6;
                if (it2.hasNext()) {
                    sb.append(BridgeUtil.UNDERLINE_STR);
                    i5 = i6;
                }
            }
            return sb.toString();
        }
        return "";
    }

    public static byte[] d(String str) throws Throwable {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(fileInputStream.available());
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (-1 == read) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (byteArray == null) {
                        byteArray = "".getBytes();
                    }
                    b(fileInputStream);
                    b(byteArrayOutputStream);
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        b(fileInputStream);
                        b(byteArrayOutputStream);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(18:3|4|5|6|7|8|9|(2:43|(2:44|(2:46|(2:49|50)(1:48))(1:52)))(0)|12|13|f7|19|20|21|22|23|24|25)|56|7|8|9|(1:11)(4:38|40|43|(3:44|(0)(0)|48))|12|13|f7) */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0083 A[Catch: all -> 0x0150, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0150, blocks: (B:10:0x003d, B:13:0x005a, B:15:0x0069, B:18:0x0072, B:22:0x0083), top: B:53:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a0 A[EDGE_INSN: B:63:0x00a0->B:26:0x00a0 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int e(android.content.Context r7) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingcam.oqKCa.e(android.content.Context):int");
    }

    public static String e() {
        Iterator it = ((ArrayList) com.tencent.turingface.sdk.mfa.wmqhz.a()).iterator();
        while (it.hasNext()) {
            Bwfl9 bwfl9 = (Bwfl9) it.next();
            if (bwfl9.f39862a.contains(com.tencent.turingface.sdk.mfa.uAnWx.d)) {
                return bwfl9.b;
            }
        }
        return "";
    }

    public static byte[] e(String str) {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(new File(str), "r");
            try {
                long length = randomAccessFile.length();
                int i = (int) length;
                if (i == length) {
                    byte[] bArr = new byte[i];
                    randomAccessFile.readFully(bArr);
                    try {
                        randomAccessFile.close();
                        return bArr;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return bArr;
                    }
                }
                throw new IOException("");
            } catch (Throwable th) {
                try {
                    byte[] bArr2 = new byte[0];
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                            return bArr2;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return bArr2;
                        }
                    }
                    return bArr2;
                } catch (Throwable th2) {
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            randomAccessFile = null;
        }
    }

    public static String f(Context context) {
        String a2 = G1g37.b.a(context, "s_h");
        String str = "";
        if (a2 != null) {
            if (a2.isEmpty()) {
                return "";
            }
            HashSet hashSet = new HashSet(Arrays.asList(a2.split(";")));
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            try {
                jsonWriter.beginObject();
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    jsonWriter.name(str2);
                    ORjG3.SkEpO a3 = com.tencent.turingface.sdk.mfa.SkEpO.a(str2);
                    jsonWriter.beginObject();
                    jsonWriter.name("std");
                    jsonWriter.value(a3.f39905a);
                    jsonWriter.name("err");
                    jsonWriter.value(a3.b);
                    jsonWriter.endObject();
                }
                jsonWriter.endObject();
                str = stringWriter.toString();
            } catch (IOException e) {
                return "";
            }
        }
        return str;
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static int g(Context context) {
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
            if (registerReceiver != null && TextUtils.equals(registerReceiver.getAction(), Intent.ACTION_BATTERY_CHANGED)) {
                int i = 0;
                int intExtra = registerReceiver.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                int intExtra2 = registerReceiver.getIntExtra(BatteryManager.EXTRA_SCALE, 100);
                if (intExtra2 == 0) {
                    return -1;
                }
                int i2 = (intExtra * 100) / intExtra2;
                if (i2 >= 0) {
                    i = i2;
                }
                if (i > 100) {
                    return 100;
                }
                return i;
            }
            return -1;
        } catch (Throwable th) {
            return -1;
        }
    }

    public static int h(Context context) {
        Intent intent;
        try {
            intent = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        } catch (Throwable th) {
            intent = null;
        }
        if (intent == null) {
            return 0;
        }
        int intExtra = intent.getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            int intExtra2 = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            if (intExtra2 == 2) {
                return 3;
            }
            return intExtra2 == 1 ? 2 : 0;
        }
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0032, code lost:
        if (r5.exists() == false) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean i(android.content.Context r5) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingcam.oqKCa.i(android.content.Context):boolean");
    }

    public static int j(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    if (activeNetworkInfo.getType() == 1) {
                        return 0;
                    }
                    if (activeNetworkInfo.getType() == 0) {
                        if (Proxy.getDefaultHost() == null) {
                            return Proxy.getHost(context) != null ? 2 : 1;
                        }
                        return 2;
                    }
                    return -1;
                }
                return -1;
            }
            return -1;
        } catch (Throwable th) {
            String message = th.getMessage();
            int i = -3;
            if (message != null) {
                i = -3;
                if (message.contains("ACCESS_NETWORK_STATE")) {
                    i = -2;
                }
            }
            return i;
        }
    }

    public static String k(Context context) {
        try {
            StringBuilder sb = new StringBuilder();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            sb.append(telephonyManager.getSimState());
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                int phoneCount = telephonyManager.getPhoneCount();
                sb.append(",");
                sb.append(phoneCount);
                if (phoneCount > 0 && i >= 26) {
                    sb.append(",");
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= phoneCount) {
                            break;
                        }
                        if (i3 > 0) {
                            sb.append(";");
                        }
                        sb.append(telephonyManager.getSimState(i3));
                        i2 = i3 + 1;
                    }
                }
            }
            return sb.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    public static boolean l(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Throwable th) {
            String message = th.getMessage();
            return message != null && message.contains("ACCESS_NETWORK_STATE");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m(android.content.Context r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r8 = r0
            r0 = 0
            r7 = r0
            r0 = r8
            r1 = 24
            if (r0 < r1) goto Le
            r0 = 0
            return r0
        Le:
            java.io.File r0 = new java.io.File
            r1 = r0
            int[] r2 = com.tencent.turingface.sdk.mfa.kC0XR.n0
            java.lang.String r2 = com.tencent.turingface.sdk.mfa.kC0XR.a(r2)
            r1.<init>(r2)
            r10 = r0
            r0 = 0
            r9 = r0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L9a
            r1 = r0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L9a
            r3 = r2
            r4 = r10
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L9a
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L9a
            r10 = r0
            r0 = r10
            java.lang.String r0 = r0.readLine()     // Catch: java.lang.Throwable -> L9f
            r9 = r0
            r0 = r10
            a(r0)
            goto L50
        L3f:
            r0 = r10
            r9 = r0
            goto L45
        L45:
            r0 = r9
            if (r0 == 0) goto L4d
            r0 = r9
            a(r0)
        L4d:
            java.lang.String r0 = ""
            r9 = r0
        L50:
            r0 = r9
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L59
            r0 = 0
            return r0
        L59:
            java.lang.String r0 = "CONFIGURED"
            r1 = r9
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L80
            r0 = r6
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> La3
            java.lang.String r1 = "adb_enabled"
            r2 = 0
            int r0 = android.provider.Settings.Secure.getInt(r0, r1, r2)     // Catch: java.lang.Throwable -> La3
            r8 = r0
            r0 = r8
            if (r0 <= 0) goto L78
            r0 = 1
            r7 = r0
            goto L78
        L78:
            r0 = r7
            if (r0 == 0) goto L7e
            r0 = 1
            return r0
        L7e:
            r0 = 3
            return r0
        L80:
            java.lang.String r0 = "DISCONNECTED"
            r1 = r9
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L8c
            r0 = 2
            return r0
        L8c:
            java.lang.String r0 = "CONNECTED"
            r1 = r9
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L98
            r0 = 3
            return r0
        L98:
            r0 = 0
            return r0
        L9a:
            r10 = move-exception
            goto L45
        L9f:
            r9 = move-exception
            goto L3f
        La3:
            r6 = move-exception
            goto L78
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingcam.oqKCa.m(android.content.Context):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e6 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String n(android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingcam.oqKCa.n(android.content.Context):java.lang.String");
    }
}
