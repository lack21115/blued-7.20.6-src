package com.getui.gtc.dim.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.blued.das.live.LiveProtos;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.util.io.IOUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/e/c.class */
public final class c {
    public static Object a(int i, String str, Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null || i < 0) {
                return null;
            }
            return telephonyManager.getClass().getMethod(str, c(str)).invoke(telephonyManager, Integer.valueOf(i));
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    public static Object a(byte[] bArr) throws Exception {
        byte b = bArr[0];
        byte[] bArr2 = new byte[bArr.length - 1];
        System.arraycopy(bArr, 1, bArr2, 0, bArr.length - 1);
        if (b != 0) {
            if (b == 1) {
                Object c2 = c(bArr2);
                List<Parcelable> list = c2;
                if (c2 instanceof com.getui.gtc.dim.d.c) {
                    list = ((com.getui.gtc.dim.d.c) c2).getParcelables();
                }
                return list;
            }
            throw new RuntimeException("bytesToObject failed, invalid type");
        }
        return b(bArr2);
    }

    public static Process a(String str) throws Throwable {
        Class<?> cls = Class.forName(new String(Base64.decode("amF2YS5sYW5nLlJ1bnRpbWU=", 0)));
        Method declaredMethod = cls.getDeclaredMethod(new String(Base64.decode("Z2V0UnVudGltZQ==", 0)), new Class[0]);
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(null, new Object[0]);
        Method declaredMethod2 = cls.getDeclaredMethod(new String(Base64.decode("ZXhlYw==", 0)), String.class);
        declaredMethod2.setAccessible(true);
        return (Process) declaredMethod2.invoke(invoke, str);
    }

    public static String a(String str, String str2) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(a("getprop " + str).getInputStream()));
            String str3 = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return str3;
                }
                str3 = str3 + readLine;
            }
        } catch (Throwable th) {
            return str2;
        }
    }

    public static void a(Context context, String str, boolean z) {
        try {
            z = context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            b.a(th);
        }
        if (z) {
            return;
        }
        throw new IllegalStateException("permission " + str + " not granted");
    }

    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (Throwable th) {
            b.a(th);
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            b.a(th);
            return true;
        }
    }

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj instanceof CharSequence ? !TextUtils.isEmpty((CharSequence) obj) : obj instanceof Collection ? ((Collection) obj).size() > 0 : !(obj instanceof Map) || ((Map) obj).size() > 0;
    }

    public static boolean a(byte[] bArr, File file) throws Exception {
        FileOutputStream fileOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        if (bArr == null) {
            return false;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            byteArrayInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[LiveProtos.Event.LIVE_HOUR_LIST_TOP_TAB_SHOW_VALUE];
            while (true) {
                int read = byteArrayInputStream.read(bArr2);
                if (read == -1) {
                    fileOutputStream.flush();
                    IOUtils.safeClose(byteArrayInputStream);
                    IOUtils.safeClose(fileOutputStream);
                    return true;
                }
                fileOutputStream.write(bArr2, 0, read);
            }
        } catch (Throwable th3) {
            th = th3;
            IOUtils.safeClose(byteArrayInputStream);
            IOUtils.safeClose(fileOutputStream);
            throw th;
        }
    }

    private static byte[] a(Parcelable parcelable) {
        Parcel parcel;
        try {
            Parcel obtain = Parcel.obtain();
            try {
                obtain.writeParcelable(parcelable, 0);
                byte[] marshall = obtain.marshall();
                byte[] bArr = new byte[marshall.length + 1];
                bArr[0] = 1;
                System.arraycopy(marshall, 0, bArr, 1, marshall.length);
                if (obtain != null) {
                    obtain.recycle();
                }
                return bArr;
            } catch (Throwable th) {
                parcel = obtain;
                th = th;
                if (parcel != null) {
                    parcel.recycle();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            parcel = null;
        }
    }

    public static byte[] a(File file) throws Exception {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[LiveProtos.Event.LIVE_HOUR_LIST_TOP_TAB_SHOW_VALUE];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            byteArrayOutputStream.flush();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            IOUtils.safeClose(fileInputStream);
                            IOUtils.safeClose(byteArrayOutputStream);
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                } catch (Throwable th) {
                    th = th;
                    IOUtils.safeClose(fileInputStream);
                    IOUtils.safeClose(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    private static byte[] a(Serializable serializable) throws IOException {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
            objectOutputStream = null;
        }
        try {
            objectOutputStream.writeObject(serializable);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byte[] bArr = new byte[byteArray.length + 1];
            bArr[0] = 0;
            System.arraycopy(byteArray, 0, bArr, 1, byteArray.length);
            try {
                objectOutputStream.close();
                return bArr;
            } catch (Throwable th2) {
                return bArr;
            }
        } catch (Throwable th3) {
            th = th3;
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (Throwable th4) {
                }
            }
            throw th;
        }
    }

    private static Object b(byte[] bArr) {
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
            try {
                Object readObject = objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    return readObject;
                } catch (Throwable th) {
                    return readObject;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    b.a(th);
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                            return null;
                        } catch (Throwable th3) {
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th4) {
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Throwable th5) {
                        }
                    }
                    throw th4;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            objectInputStream = null;
        }
    }

    public static String b(String str) {
        Process process;
        BufferedReader bufferedReader;
        if (TextUtils.isEmpty(str) || "0.0.0.0".equalsIgnoreCase(str)) {
            return "";
        }
        try {
            try {
                Process a2 = a(new String(Base64.decode("aXAgbmVpZ2hib3Vy", 0)));
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(a2.getInputStream()));
                    int i = 0;
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                try {
                                    if (readLine.contains("192.168") || readLine.contains("wlan0")) {
                                        if (readLine.contains("FAILED")) {
                                            continue;
                                        } else {
                                            String[] split = readLine.split(" +");
                                            if (split.length < 6) {
                                                continue;
                                            } else {
                                                int i2 = i + 1;
                                                if (i <= 256) {
                                                    try {
                                                        String replaceAll = split[4].replaceAll(":", "");
                                                        if (str.equalsIgnoreCase(split[0])) {
                                                            try {
                                                                bufferedReader.close();
                                                            } catch (IOException e) {
                                                                b.a(e);
                                                            }
                                                            if (a2 != null) {
                                                                try {
                                                                    a2.destroy();
                                                                    return replaceAll;
                                                                } catch (Throwable th) {
                                                                    b.a(th);
                                                                }
                                                            }
                                                            return replaceAll;
                                                        }
                                                        i = i2;
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        i = i2;
                                                        b.a(th);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                b.a(e2);
                            }
                            if (a2 != null) {
                                a2.destroy();
                                return "";
                            }
                            return "";
                        } catch (Throwable th4) {
                            th = th4;
                            process = a2;
                            try {
                                b.a(th);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e3) {
                                        b.a(e3);
                                    }
                                }
                                if (process != null) {
                                    process.destroy();
                                    return "";
                                }
                                return "";
                            } catch (Throwable th5) {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e4) {
                                        b.a(e4);
                                    }
                                }
                                if (process != null) {
                                    try {
                                        process.destroy();
                                    } catch (Throwable th6) {
                                        b.a(th6);
                                    }
                                }
                                throw th5;
                            }
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    bufferedReader = null;
                    process = a2;
                }
            } catch (Throwable th8) {
                th = th8;
                process = null;
                bufferedReader = null;
            }
        } catch (Throwable th9) {
            b.a(th9);
            return "";
        }
    }

    public static boolean b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType() == 0;
            }
            return false;
        } catch (Throwable th) {
            b.a(th);
            return false;
        }
    }

    public static byte[] b(Object obj) throws Exception {
        if (obj instanceof Parcelable) {
            return a((Parcelable) obj);
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.get(0) instanceof Parcelable) {
                return a((Parcelable) new com.getui.gtc.dim.d.c(list));
            }
        }
        if (obj instanceof Serializable) {
            return a((Serializable) obj);
        }
        throw new IllegalArgumentException("objectToBytes failed, object type is not support: " + obj.getClass().getName());
    }

    private static Object c(byte[] bArr) {
        Parcel parcel;
        Parcel obtain;
        try {
            obtain = Parcel.obtain();
        } catch (Throwable th) {
            th = th;
            parcel = null;
        }
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            Parcelable readParcelable = obtain.readParcelable(GtcProvider.context().getClassLoader());
            if (obtain != null) {
                obtain.recycle();
            }
            return readParcelable;
        } catch (Throwable th2) {
            parcel = obtain;
            th = th2;
            if (parcel != null) {
                parcel.recycle();
            }
            throw th;
        }
    }

    public static boolean c(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType() == 1;
            }
            return false;
        } catch (Throwable th) {
            b.a(th);
            return false;
        }
    }

    private static Class[] c(String str) {
        Class<?>[] clsArr;
        Class<?>[] clsArr2 = null;
        Class<?>[] clsArr3 = null;
        try {
            Method[] declaredMethods = TelephonyManager.class.getDeclaredMethods();
            int i = 0;
            while (true) {
                clsArr2 = clsArr3;
                clsArr = clsArr3;
                if (i >= declaredMethods.length) {
                    break;
                }
                Class<?>[] clsArr4 = clsArr3;
                if (str.equals(declaredMethods[i].getName())) {
                    Class<?>[] clsArr5 = clsArr3;
                    Class<?>[] parameterTypes = declaredMethods[i].getParameterTypes();
                    clsArr = parameterTypes;
                    if (parameterTypes.length > 0) {
                        break;
                    }
                    clsArr4 = parameterTypes;
                }
                i++;
                clsArr3 = clsArr4;
            }
        } catch (Throwable th) {
            b.a(th);
            clsArr = clsArr2;
        }
        return clsArr;
    }
}
