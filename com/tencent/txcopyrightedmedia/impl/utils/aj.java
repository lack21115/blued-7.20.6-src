package com.tencent.txcopyrightedmedia.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/aj.class */
public final class aj {

    /* renamed from: a  reason: collision with root package name */
    private static String f40055a;
    private static String b;

    /* renamed from: c  reason: collision with root package name */
    private static long f40056c = (long) (Math.random() * 1000000.0d);

    public static i a(ByteArrayOutputStream byteArrayOutputStream, int i, int i2, int i3, byte[] bArr) {
        int i4 = i2;
        if (i2 == 0) {
            i4 = (bArr.length + i3) - 1;
        }
        if (i > i4) {
            return new i(-5, "request range error: range[" + i + "-" + i4 + ")");
        } else if (bArr == null || bArr.length + i3 <= i || i3 > i4) {
            StringBuilder sb = new StringBuilder("This data not in range. current [");
            sb.append(i3);
            sb.append(", ");
            sb.append(i3);
            sb.append(bArr.length);
            sb.append("]");
            return new i(0, null);
        } else {
            int i5 = i - i3;
            int i6 = i5;
            if (i5 < 0) {
                i6 = 0;
            }
            int i7 = (i4 - i3) + 1;
            int i8 = i7;
            if (i7 > bArr.length) {
                i8 = bArr.length;
            }
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= 2) {
                    break;
                }
                try {
                    byteArrayOutputStream.write(bArr, i6, i8 - i6);
                    break;
                } catch (OutOfMemoryError e) {
                    System.gc();
                    i9 = i10 + 1;
                }
            }
            return new i(0, null);
        }
    }

    public static String a() {
        return Build.VERSION.RELEASE;
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
    }

    public static boolean a(File file) {
        if (file.exists()) {
            return file.isFile() ? b(file) : c(file);
        }
        return false;
    }

    public static String[] a(String str) {
        String[] strArr = null;
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf("=");
        if (indexOf <= 0) {
            return null;
        }
        String trim = str.substring(0, indexOf).trim();
        int indexOf2 = str.indexOf("\"");
        if (indexOf2 >= 0) {
            indexOf = indexOf2;
        }
        int lastIndexOf = str.lastIndexOf("\"");
        int i = lastIndexOf;
        if (lastIndexOf < 0) {
            i = str.length();
        }
        if (i > indexOf) {
            int i2 = indexOf + 1;
            if (i2 >= str.length()) {
                return null;
            }
            strArr = new String[]{trim, str.substring(i2, i).trim()};
        }
        return strArr;
    }

    public static String b() {
        if (b == null) {
            b bVar = (b) m.a().b(m.f40109a);
            if (bVar == null) {
                return null;
            }
            String string = bVar.d.f40099a.getString("SYSTEM_MODEL", null);
            b = string;
            if (string == null) {
                b = Build.MODEL;
                g gVar = bVar.d;
                String str = b;
                SharedPreferences.Editor edit = gVar.f40099a.edit();
                edit.putString("SYSTEM_MODEL", str);
                edit.apply();
            }
        }
        return b;
    }

    public static String b(Context context) {
        String string;
        synchronized (aj.class) {
            try {
                try {
                    string = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return string;
    }

    private static boolean b(File file) {
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static long c() {
        long abs;
        synchronized (aj.class) {
            try {
                abs = Math.abs((long) (f40056c + (Math.random() * 10000.0d)));
                f40056c = abs;
            } catch (Throwable th) {
                throw th;
            }
        }
        return abs;
    }

    public static String c(Context context) {
        String str = f40055a;
        if (str == null || str.length() <= 0) {
            b bVar = (b) m.a().b(m.f40109a);
            if (bVar == null) {
                return null;
            }
            String string = bVar.d.f40099a.getString("USER_ID", null);
            f40055a = string;
            if (string == null || string.length() == 0) {
                f40055a = "";
                long currentTimeMillis = System.currentTimeMillis();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                String packageName = context.getPackageName();
                int i = 5;
                while (true) {
                    int i2 = i;
                    if (i2 < 0) {
                        break;
                    }
                    f40055a += String.format("%02x", Byte.valueOf((byte) (255 & (currentTimeMillis >> (i2 * 8)))));
                    i = i2 - 1;
                }
                int i3 = 3;
                while (true) {
                    int i4 = i3;
                    if (i4 >= 0) {
                        f40055a += String.format("%02x", Byte.valueOf((byte) ((elapsedRealtime >> (i4 * 8)) & 255)));
                        i3 = i4 - 1;
                    } else {
                        try {
                            break;
                        } catch (NoSuchAlgorithmException e) {
                            e.printStackTrace();
                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(f40055a);
                sb.append(ac.b(packageName + UUID.randomUUID().toString()));
                f40055a = sb.toString();
                g gVar = bVar.d;
                String str2 = f40055a;
                SharedPreferences.Editor edit = gVar.f40099a.edit();
                edit.putString("USER_ID", str2);
                edit.apply();
            }
            new StringBuilder("UUID:").append(f40055a);
            return f40055a;
        }
        return f40055a;
    }

    private static boolean c(File file) {
        boolean z;
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            boolean z2 = true;
            if (listFiles == null) {
                return true;
            }
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                z = z2;
                if (i2 >= length) {
                    break;
                }
                File file2 = listFiles[i2];
                z2 = file2.isFile() ? b(file2) : c(file2);
                z = z2;
                if (!z2) {
                    break;
                }
                i = i2 + 1;
            }
            if (z) {
                return file.delete();
            }
            return false;
        }
        return false;
    }

    public static String d() {
        b bVar = (b) m.a().b(m.f40109a);
        return (bVar != null ? bVar.d : new g(TXCopyrightedMedia.instance().getApplicationContext())).f40099a.getString("USER_ID_TOKEN", null);
    }

    public static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String e() {
        return "audio/default";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String e(Context context) {
        String str;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return "unknown";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            str = "UNCONNECTED";
        } else if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        } else {
            if (activeNetworkInfo.getType() == 0) {
                String subtypeName = activeNetworkInfo.getSubtypeName();
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype != 20) {
                    str = "3G";
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2G";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            break;
                        case 13:
                            return "4G";
                        default:
                            str = "3G";
                            if (!subtypeName.equalsIgnoreCase("TD-SCDMA")) {
                                str = "3G";
                                if (!subtypeName.equalsIgnoreCase("WCDMA")) {
                                    return subtypeName.equalsIgnoreCase("CDMA2000") ? "3G" : subtypeName;
                                }
                            }
                            break;
                    }
                } else {
                    return "5G";
                }
            } else {
                return "";
            }
        }
        return str;
    }
}
