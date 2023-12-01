package com.tencent.tmsbeacon.base.util;

import android.content.SharedPreferences;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/util/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Random f25835a = new Random();
    private static final AtomicInteger b = new AtomicInteger(0);

    public static int a(String str, int i, int i2, int i3) {
        int i4;
        int i5 = i;
        if (str != null) {
            try {
                i4 = Integer.parseInt(str);
            } catch (Exception e) {
                c.a(e);
                i4 = i;
            }
            i5 = i;
            if (i4 >= i2) {
                i5 = i;
                if (i4 <= i3) {
                    i5 = i4;
                }
            }
        }
        return i5;
    }

    public static long a(String str, long j, long j2, long j3) {
        long j4;
        long j5 = j;
        if (str != null) {
            try {
                j4 = Long.parseLong(str);
            } catch (Exception e) {
                c.a(e);
                j4 = j;
            }
            j5 = j;
            if (j4 >= j2) {
                j5 = j;
                if (j4 <= j3) {
                    j5 = j4;
                }
            }
        }
        return j5;
    }

    public static Object a(byte[] bArr) {
        ObjectInputStream objectInputStream;
        if (bArr == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
        } catch (Throwable th) {
            th = th;
            objectInputStream = null;
        }
        try {
            Object readObject = objectInputStream.readObject();
            a(objectInputStream);
            a(byteArrayInputStream);
            return readObject;
        } catch (Throwable th2) {
            th = th2;
            try {
                c.a(th);
                c.b(th.getMessage(), new Object[0]);
                a(objectInputStream);
                a(byteArrayInputStream);
                return null;
            } catch (Throwable th3) {
                a(objectInputStream);
                a(byteArrayInputStream);
                throw th3;
            }
        }
    }

    public static String a() {
        return a(16);
    }

    private static String a(int i) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return stringBuffer.toString();
            }
            stringBuffer.append("abcdef0123456789".charAt(random.nextInt(16)));
            i2 = i3 + 1;
        }
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String replace = (th.getMessage() + "\n" + stringWriter.getBuffer().toString()).replace("\t", " ").replace("\n", " ").replace("$", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        String str = replace;
        if (replace.length() > 10240) {
            str = replace.substring(0, 10240);
        }
        return str;
    }

    public static ArrayList<String> a(String[] strArr) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream(), Charset.forName("UTF-8")));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = null;
                }
            }
            bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getErrorStream(), Charset.forName("UTF-8")));
            while (true) {
                try {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 == null) {
                        a(bufferedReader);
                        a(bufferedReader2);
                        return arrayList;
                    }
                    arrayList.add(readLine2);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        c.a(th);
                        a(bufferedReader);
                        a(bufferedReader2);
                        return null;
                    } catch (Throwable th3) {
                        a(bufferedReader);
                        a(bufferedReader2);
                        throw th3;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            bufferedReader2 = null;
        }
    }

    public static HashSet<String> a(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        HashSet<String> hashSet = new HashSet<>(arrayList.size());
        hashSet.addAll(arrayList);
        return hashSet;
    }

    public static void a(Closeable... closeableArr) {
        int length = closeableArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Closeable closeable = closeableArr[i2];
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e) {
                    c.a(e);
                }
            }
            i = i2 + 1;
        }
    }

    public static boolean a(SharedPreferences.Editor editor) {
        if (editor == null) {
            c.b("BeaconProperties editor is null!", new Object[0]);
            return false;
        }
        return true;
    }

    public static boolean a(String str) {
        return str.startsWith("rqd_");
    }

    public static boolean a(String str, boolean z) {
        boolean z2 = z;
        if (str != null) {
            if (str.toLowerCase().equals("y")) {
                return true;
            }
            z2 = z;
            if (str.toLowerCase().equals("n")) {
                z2 = false;
            }
        }
        return z2;
    }

    public static byte[] a(Object obj) {
        ObjectOutputStream objectOutputStream;
        if (!(obj instanceof Serializable)) {
            c.b("not serial obj ", new Object[0]);
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream2.writeObject(obj);
                objectOutputStream2.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                a(objectOutputStream2);
                a(byteArrayOutputStream);
                return byteArray;
            } catch (Throwable th) {
                objectOutputStream = objectOutputStream2;
                th = th;
                try {
                    c.a(th);
                    c.b(th.getMessage(), new Object[0]);
                    a(objectOutputStream);
                    a(byteArrayOutputStream);
                    return null;
                } catch (Throwable th2) {
                    a(objectOutputStream);
                    a(byteArrayOutputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream = null;
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        byte[] bArr2 = bArr;
        if (bArr != null) {
            if (i == -1) {
                return bArr;
            }
            c.a("unzp: %s len: %s", Integer.valueOf(i), Integer.valueOf(bArr.length));
            try {
                return com.tencent.tmsbeacon.base.net.b.a.b(i, bArr);
            } catch (Throwable th) {
                com.tencent.tmsbeacon.a.b.d.b().a("509", "unzipData length: " + bArr.length + ",type:" + i, th);
                c.a(th);
                StringBuilder sb = new StringBuilder();
                sb.append("err unzp}");
                sb.append(th.toString());
                c.b(sb.toString(), new Object[0]);
                bArr2 = null;
            }
        }
        return bArr2;
    }

    public static byte[] a(byte[] bArr, int i, int i2, String str) {
        try {
            return a(b(bArr, i2, str), i);
        } catch (Exception e) {
            c.a(e);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, int i, String str) {
        byte[] bArr2 = bArr;
        if (bArr != null) {
            if (i == -1) {
                return bArr;
            }
            c.a("CoreUtils", "encry data length:%d type: %d", Integer.valueOf(bArr.length), Integer.valueOf(i));
            try {
                return com.tencent.tmsbeacon.base.net.b.c.b(i, str, bArr);
            } catch (Throwable th) {
                c.a(th);
                com.tencent.tmsbeacon.a.b.d b2 = com.tencent.tmsbeacon.a.b.d.b();
                b2.a("507", "data length: " + bArr.length + ",type:" + i + ",key: " + str, th);
                bArr2 = null;
            }
        }
        return bArr2;
    }

    public static String b() {
        com.tencent.tmsbeacon.a.c.c d = com.tencent.tmsbeacon.a.c.c.d();
        String f = d != null ? d.f() : "";
        String d2 = com.tencent.tmsbeacon.a.c.e.l().d();
        int nextInt = f25835a.nextInt(2147473647);
        return b(f + "_" + d2 + "_" + new Date().getTime() + "_" + (nextInt + 1000));
    }

    public static String b(String str) {
        String c2 = c(str);
        if (c2 != null) {
            try {
                return c2.substring(8, 24);
            } catch (Exception e) {
                c.a(e);
            }
        }
        return c2;
    }

    public static byte[] b(byte[] bArr, int i) {
        byte[] bArr2 = bArr;
        if (bArr != null) {
            if (i == -1) {
                return bArr;
            }
            c.a("zp: %s len: %s", Integer.valueOf(i), Integer.valueOf(bArr.length));
            try {
                return com.tencent.tmsbeacon.base.net.b.a.a(i, bArr);
            } catch (Throwable th) {
                com.tencent.tmsbeacon.a.b.d b2 = com.tencent.tmsbeacon.a.b.d.b();
                b2.a("509", "zipData length: " + bArr.length + ",type:" + i, th);
                c.a(th);
                c.b("err zp : %s", th.toString());
                bArr2 = null;
            }
        }
        return bArr2;
    }

    public static byte[] b(byte[] bArr, int i, int i2, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return a(b(bArr, i), i2, str);
        } catch (Throwable th) {
            c.a(th);
            return null;
        }
    }

    public static byte[] b(byte[] bArr, int i, String str) {
        byte[] bArr2 = bArr;
        if (bArr != null) {
            bArr2 = bArr;
            if (bArr.length > 0) {
                if (i == -1) {
                    return bArr;
                }
                try {
                    return com.tencent.tmsbeacon.base.net.b.c.a(i, str, bArr);
                } catch (Throwable th) {
                    c.e("data length: " + bArr.length + ",type:" + i + ",key: " + str + ",error: " + th.getMessage(), new Object[0]);
                    com.tencent.tmsbeacon.a.b.d b2 = com.tencent.tmsbeacon.a.b.d.b();
                    StringBuilder sb = new StringBuilder();
                    sb.append("data length: ");
                    sb.append(bArr.length);
                    sb.append(",type:");
                    sb.append(i);
                    sb.append(",key: ");
                    sb.append(str);
                    b2.a("508", sb.toString(), th);
                    bArr2 = null;
                }
            }
        }
        return bArr2;
    }

    public static long c() {
        return new Date().getTime() + com.tencent.tmsbeacon.a.c.c.d().j();
    }

    public static String c(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes(Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            int length = digest.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return sb.toString();
                }
                int i3 = digest[i2] & 255;
                if (i3 < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(i3));
                i = i2 + 1;
            }
        } catch (Exception e) {
            c.a(e);
            return str;
        }
    }

    public static String d() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
        } catch (Throwable th) {
            c.a(th);
            return "";
        }
    }

    public static Date d(String str) {
        if (str == null || str.trim().length() <= 0) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(str);
        } catch (ParseException e) {
            c.a(e);
            return null;
        }
    }
}
