package com.amap.api.col.p0003sl;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.WindowManager;
import com.android.internal.telephony.PhoneConstants;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.igexin.assist.util.AssistUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Map;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.amap.api.col.3sl.hs  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hs.class */
public final class hs {
    private static String A = "";
    private static String B = "";
    private static boolean C = false;
    private static boolean D = false;
    private static String E = "";
    private static boolean F = false;
    private static boolean G = false;
    private static long H = 0;
    private static int I = 0;
    private static String J;
    private static String K = "";
    private static boolean L = true;
    private static boolean M = false;
    private static String N = "";
    private static boolean O = false;
    private static int P = -1;
    private static boolean Q = false;
    private static int R = -1;
    private static boolean S = false;
    private static volatile b T;

    /* renamed from: a  reason: collision with root package name */
    static String f5099a = "";
    static String b = "";

    /* renamed from: c  reason: collision with root package name */
    static volatile boolean f5100c = true;
    public static boolean d = false;
    static String e = "";
    static boolean f = false;
    public static a g;
    static int h = -1;
    static String i = "";
    static String j = "";
    private static String k;
    private static boolean l = false;
    private static volatile boolean m = false;
    private static String n = "";
    private static boolean o = false;
    private static boolean p = false;
    private static boolean q = false;
    private static String r = "";
    private static String s = "";
    private static boolean t = false;
    private static boolean u = false;
    private static String v = "";
    private static boolean w = false;
    private static String x = "";
    private static boolean y = false;
    private static String z = "";

    /* renamed from: com.amap.api.col.3sl.hs$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hs$a.class */
    public interface a {
        kb a(byte[] bArr, Map<String, String> map);

        String a();

        String a(Context context, String str);

        String a(String str, String str2, String str3, String str4);

        Map<String, String> b();
    }

    /* renamed from: com.amap.api.col.3sl.hs$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hs$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private static Context f5103a;
        private static BroadcastReceiver b;

        /* renamed from: c  reason: collision with root package name */
        private static ConnectivityManager f5104c;
        private static NetworkRequest d;
        private static ConnectivityManager.NetworkCallback e;

        public final void a(Context context) {
            if (Build.VERSION.SDK_INT < 24) {
                if (context == null || b != null) {
                    return;
                }
                b = new BroadcastReceiver() { // from class: com.amap.api.col.3sl.hs.b.1
                    @Override // android.content.BroadcastReceiver
                    public final void onReceive(Context context2, Intent intent) {
                        if (ib.c("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(intent.getAction())) {
                            hs.h();
                        }
                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(ib.c("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
                context.registerReceiver(b, intentFilter);
            } else if (hs.c(context, ib.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && f5104c == null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                f5104c = connectivityManager;
                if (connectivityManager != null) {
                    d = new NetworkRequest.Builder().addCapability(0).addCapability(1).build();
                    ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.amap.api.col.3sl.hs.b.2
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public final void onAvailable(Network network) {
                            super.onAvailable(network);
                            hs.h();
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public final void onLost(Network network) {
                            super.onLost(network);
                            hs.h();
                        }
                    };
                    e = networkCallback;
                    f5104c.registerNetworkCallback(d, networkCallback);
                    f5103a = context;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.hs$c */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hs$c.class */
    public static final class c implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private static String f5107a;
        private Context b;

        /* renamed from: c  reason: collision with root package name */
        private int f5108c;

        c(Context context, int i) {
            this.b = context;
            this.f5108c = i;
        }

        private String a() {
            try {
                if (TextUtils.isEmpty(f5107a)) {
                    byte[] digest = MessageDigest.getInstance(ib.c("IU0hBMQ")).digest(this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 64).signatures[0].toByteArray());
                    StringBuffer stringBuffer = new StringBuffer();
                    for (byte b : digest) {
                        stringBuffer.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    if (!TextUtils.isEmpty(stringBuffer2)) {
                        f5107a = stringBuffer2;
                    }
                    return stringBuffer2;
                }
                return f5107a;
            } catch (Throwable th) {
                return "";
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0066 A[Catch: all -> 0x008a, TRY_ENTER, TryCatch #1 {all -> 0x008a, blocks: (B:3:0x0009, B:16:0x0066, B:11:0x0022, B:12:0x004a, B:13:0x0056), top: B:30:0x0009 }] */
        @Override // android.content.ServiceConnection
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onServiceConnected(android.content.ComponentName r7, android.os.IBinder r8) {
            /*
                r6 = this;
                android.os.Parcel r0 = android.os.Parcel.obtain()
                r7 = r0
                android.os.Parcel r0 = android.os.Parcel.obtain()
                r10 = r0
                r0 = r6
                int r0 = r0.f5108c     // Catch: java.lang.Throwable -> L8a
                r9 = r0
                r0 = r9
                r1 = 2
                if (r0 == r1) goto L56
                r0 = r9
                r1 = 4
                if (r0 == r1) goto L4a
                r0 = r9
                r1 = 5
                if (r0 == r1) goto L22
                r0 = 0
                r9 = r0
                goto L62
            L22:
                r0 = r7
                java.lang.String r1 = "KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"
                java.lang.String r1 = com.amap.api.col.p0003sl.ib.c(r1)     // Catch: java.lang.Throwable -> L8a
                r0.writeInterfaceToken(r1)     // Catch: java.lang.Throwable -> L8a
                r0 = r7
                r1 = r6
                android.content.Context r1 = r1.b     // Catch: java.lang.Throwable -> L8a
                java.lang.String r1 = r1.getPackageName()     // Catch: java.lang.Throwable -> L8a
                r0.writeString(r1)     // Catch: java.lang.Throwable -> L8a
                r0 = r7
                r1 = r6
                java.lang.String r1 = r1.a()     // Catch: java.lang.Throwable -> L8a
                r0.writeString(r1)     // Catch: java.lang.Throwable -> L8a
                r0 = r7
                java.lang.String r1 = "IT1VJRA"
                java.lang.String r1 = com.amap.api.col.p0003sl.ib.c(r1)     // Catch: java.lang.Throwable -> L8a
                r0.writeString(r1)     // Catch: java.lang.Throwable -> L8a
                goto Lae
            L4a:
                r0 = r7
                java.lang.String r1 = "UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ"
                java.lang.String r1 = com.amap.api.col.p0003sl.ib.c(r1)     // Catch: java.lang.Throwable -> L8a
                r0.writeInterfaceToken(r1)     // Catch: java.lang.Throwable -> L8a
                goto Lae
            L56:
                r0 = r7
                java.lang.String r1 = "UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U"
                java.lang.String r1 = com.amap.api.col.p0003sl.ib.c(r1)     // Catch: java.lang.Throwable -> L8a
                r0.writeInterfaceToken(r1)     // Catch: java.lang.Throwable -> L8a
                goto Lae
            L62:
                r0 = r9
                if (r0 == 0) goto L80
                r0 = r8
                r1 = 1
                r2 = r7
                r3 = r10
                r4 = 0
                boolean r0 = r0.transact(r1, r2, r3, r4)     // Catch: java.lang.Throwable -> L8a
                r0 = r10
                r0.readException()     // Catch: java.lang.Throwable -> L8a
                r0 = r10
                java.lang.String r0 = r0.readString()     // Catch: java.lang.Throwable -> L8a
                java.lang.String r0 = com.amap.api.col.p0003sl.hs.b(r0)     // Catch: java.lang.Throwable -> L8a
            L80:
                r0 = r10
                r0.recycle()
                r0 = r7
                r0.recycle()
                return
            L8a:
                r8 = move-exception
                r0 = r8
                java.lang.String r1 = "oac"
                r2 = r6
                int r2 = r2.f5108c     // Catch: java.lang.Throwable -> La2
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> La2
                com.amap.api.col.p0003sl.it.a(r0, r1, r2)     // Catch: java.lang.Throwable -> La2
                r0 = r10
                r0.recycle()
                r0 = r7
                r0.recycle()
                return
            La2:
                r8 = move-exception
                r0 = r10
                r0.recycle()
                r0 = r7
                r0.recycle()
                r0 = r8
                throw r0
            Lae:
                r0 = 1
                r9 = r0
                goto L62
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.hs.c.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String A(Context context) {
        try {
            return L(context);
        } catch (Throwable th) {
            return "";
        }
    }

    private static String C(Context context) {
        try {
            String b2 = jj.b(context, "Alvin2", "UTDID2", "");
            String str = b2;
            if (TextUtils.isEmpty(b2)) {
                str = jj.b(context, "Alvin2", "UTDID", "");
            }
            return str;
        } catch (Throwable th) {
            return "";
        }
    }

    private static String D(Context context) {
        FileInputStream fileInputStream;
        boolean z2;
        int i2;
        FileInputStream fileInputStream2 = null;
        try {
            if (ib.a(context, "android.permission.READ_EXTERNAL_STORAGE")) {
                fileInputStream2 = null;
                if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                    File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");
                    XmlPullParser newPullParser = Xml.newPullParser();
                    fileInputStream = new FileInputStream(file);
                    try {
                        newPullParser.setInput(fileInputStream, "utf-8");
                        boolean z3 = false;
                        for (int eventType = newPullParser.getEventType(); 1 != eventType; eventType = newPullParser.next()) {
                            if (eventType == 2) {
                                z2 = z3;
                                if (newPullParser.getAttributeCount() > 0) {
                                    int attributeCount = newPullParser.getAttributeCount();
                                    while (true) {
                                        int i3 = i2;
                                        z2 = z3;
                                        if (i3 >= attributeCount) {
                                            break;
                                        }
                                        String attributeValue = newPullParser.getAttributeValue(i3);
                                        i2 = ("UTDID2".equals(attributeValue) || "UTDID".equals(attributeValue)) ? 0 : i3 + 1;
                                        z3 = true;
                                    }
                                }
                            } else if (eventType == 3) {
                                z2 = false;
                            } else if (eventType != 4) {
                                z2 = z3;
                            } else {
                                z2 = z3;
                                if (z3) {
                                    String text = newPullParser.getText();
                                    try {
                                        fileInputStream.close();
                                        return text;
                                    } catch (Throwable th) {
                                        return text;
                                    }
                                }
                            }
                            z3 = z2;
                        }
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th2) {
                        if (fileInputStream == null) {
                            return "";
                        }
                        try {
                            fileInputStream.close();
                            return "";
                        } catch (Throwable th3) {
                            return "";
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            fileInputStream = null;
        }
        if (fileInputStream2 != null) {
            fileInputStream = fileInputStream2;
            fileInputStream.close();
            return "";
        }
        return "";
    }

    private static String E(Context context) {
        try {
            Class<?> cls = Class.forName(ib.c("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            Object invoke = cls.getMethod(ib.c("MZ2V0T0FJRA"), Context.class).invoke(cls.newInstance(), context);
            if (invoke != null) {
                String str = (String) invoke;
                n = str;
                return str;
            }
        } catch (Throwable th) {
            it.a(th, "oa", "xm");
            o = true;
        }
        return n;
    }

    private static String F(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(ib.c("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    int columnCount = query.getColumnCount();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= columnCount) {
                            break;
                        } else if (ib.c("IdmFsdWU").equals(query.getColumnName(i3))) {
                            n = query.getString(i3);
                            break;
                        } else {
                            i2 = i3 + 1;
                        }
                    }
                }
                query.close();
            }
        } catch (Throwable th) {
            o = true;
            it.a(th, "oa", AssistUtils.BRAND_VIVO);
        }
        return n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String G(Context context) {
        if (ib.c("IeGlhb21p").equalsIgnoreCase(Build.MANUFACTURER) || ib.c("IeGlhb21p").equalsIgnoreCase(Build.BRAND) || ib.c("IUkVETUk=").equalsIgnoreCase(Build.MANUFACTURER) || ib.c("IUkVETUk=").equalsIgnoreCase(Build.BRAND)) {
            return E(context);
        }
        if (ib.c("Idml2bw").equalsIgnoreCase(Build.MANUFACTURER) || ib.c("Idml2bw").equalsIgnoreCase(Build.BRAND)) {
            return F(context);
        }
        if (ib.c("IaHVhd2Vp").equalsIgnoreCase(Build.MANUFACTURER) || ib.c("IaHVhd2Vp").equalsIgnoreCase(Build.BRAND) || ib.c("ISE9OT1I=").equalsIgnoreCase(Build.MANUFACTURER)) {
            return a(context, 2);
        }
        if (ib.c("Mc2Ftc3VuZw").equalsIgnoreCase(Build.MANUFACTURER) || ib.c("Mc2Ftc3VuZw").equalsIgnoreCase(Build.BRAND)) {
            return a(context, 4);
        }
        if (ib.c("IT1BQTw").equalsIgnoreCase(Build.MANUFACTURER) || ib.c("IT1BQTw").equalsIgnoreCase(Build.BRAND) || ib.c("MT25lUGx1cw").equalsIgnoreCase(Build.MANUFACTURER) || ib.c("MT25lUGx1cw").equalsIgnoreCase(Build.BRAND) || ib.c("IUkVBTE1F").equalsIgnoreCase(Build.BRAND)) {
            return a(context, 5);
        }
        o = true;
        return n;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
        if (r4.getApplicationInfo().targetSdkVersion < 30) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String H(android.content.Context r4) {
        /*
            java.util.Enumeration r0 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch: java.lang.Exception -> Lc0
            java.util.ArrayList r0 = java.util.Collections.list(r0)     // Catch: java.lang.Exception -> Lc0
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> Lc0
            r7 = r0
        Lc:
            r0 = r7
            boolean r0 = r0.hasNext()     // Catch: java.lang.Exception -> Lc0
            if (r0 == 0) goto Lbd
            r0 = r7
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Exception -> Lc0
            java.net.NetworkInterface r0 = (java.net.NetworkInterface) r0     // Catch: java.lang.Exception -> Lc0
            r9 = r0
            r0 = r9
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Exception -> Lc0
            java.lang.String r1 = "wlan0"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Exception -> Lc0
            if (r0 == 0) goto Lc
            r0 = 0
            r8 = r0
            r0 = r8
            r7 = r0
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> Lc0
            r1 = 9
            if (r0 < r1) goto Lc4
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> Lc0
            r1 = 30
            if (r0 < r1) goto L53
            r0 = r8
            r7 = r0
            r0 = r4
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()     // Catch: java.lang.Exception -> Lc0
            int r0 = r0.targetSdkVersion     // Catch: java.lang.Exception -> Lc0
            r1 = 30
            if (r0 >= r1) goto Lc4
        L53:
            r0 = r9
            byte[] r0 = r0.getHardwareAddress()     // Catch: java.lang.Exception -> Lc0
            r7 = r0
            goto Lc4
        L5c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc0
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> Lc0
            r4 = r0
            r0 = r7
            int r0 = r0.length     // Catch: java.lang.Exception -> Lc0
            r6 = r0
            r0 = 0
            r5 = r0
        L69:
            r0 = r5
            r1 = r6
            if (r0 >= r1) goto La4
            r0 = r7
            r1 = r5
            r0 = r0[r1]     // Catch: java.lang.Exception -> Lc0
            r1 = 255(0xff, float:3.57E-43)
            r0 = r0 & r1
            java.lang.String r0 = java.lang.Integer.toHexString(r0)     // Catch: java.lang.Exception -> Lc0
            java.lang.String r0 = r0.toUpperCase()     // Catch: java.lang.Exception -> Lc0
            r8 = r0
            r0 = r8
            int r0 = r0.length()     // Catch: java.lang.Exception -> Lc0
            r1 = 1
            if (r0 != r1) goto L8e
            r0 = r4
            java.lang.String r1 = "0"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> Lc0
        L8e:
            r0 = r4
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> Lc0
            r0 = r4
            java.lang.String r1 = ":"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> Lc0
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L69
        La4:
            r0 = r4
            int r0 = r0.length()     // Catch: java.lang.Exception -> Lc0
            if (r0 <= 0) goto Lb6
            r0 = r4
            r1 = r4
            int r1 = r1.length()     // Catch: java.lang.Exception -> Lc0
            r2 = 1
            int r1 = r1 - r2
            java.lang.StringBuilder r0 = r0.deleteCharAt(r1)     // Catch: java.lang.Exception -> Lc0
        Lb6:
            r0 = r4
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Lc0
            r4 = r0
            r0 = r4
            return r0
        Lbd:
            java.lang.String r0 = ""
            return r0
        Lc0:
            r4 = move-exception
            java.lang.String r0 = ""
            return r0
        Lc4:
            r0 = r7
            if (r0 != 0) goto L5c
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.hs.H(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0070 -> B:10:0x006c). Please submit an issue!!! */
    private static String I(Context context) {
        if (TextUtils.isEmpty(E)) {
            try {
                String b2 = jj.b(context, "open_common", "a1", "");
                if (TextUtils.isEmpty(b2)) {
                    E = "amap" + UUID.randomUUID().toString().replace(BridgeUtil.UNDERLINE_STR, "").toLowerCase();
                    SharedPreferences.Editor a2 = jj.a(context, "open_common");
                    jj.a(a2, "a1", ib.b(E));
                    jj.a(a2);
                } else {
                    E = ib.c(b2);
                }
            } catch (Throwable th) {
            }
            return E;
        }
        return E;
    }

    private static boolean J(Context context) {
        TelephonyManager P2 = P(context);
        if (P2 == null) {
            return false;
        }
        int simState = P2.getSimState();
        boolean z2 = false;
        if (simState != 0) {
            z2 = false;
            if (simState != 1) {
                z2 = true;
            }
        }
        return z2;
    }

    private static String K(Context context) throws InvocationTargetException, IllegalAccessException {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        boolean J2 = J(context);
        if (L != J2) {
            if (J2) {
                K = "";
                M = false;
            }
            L = J2;
        }
        String str = K;
        if ((str == null || "".equals(str)) && !M) {
            if (L) {
                if (c(context, ib.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                    TelephonyManager P2 = P(context);
                    if (P2 == null) {
                        return "";
                    }
                    Method a2 = ib.a(P2.getClass(), "UZ2V0U3Vic2NyaWJlcklk", new Class[0]);
                    if (a2 != null) {
                        K = (String) a2.invoke(P2, new Object[0]);
                    }
                    if (K == null) {
                        K = "";
                    }
                    M = true;
                    return K;
                }
                return K;
            }
            return "";
        }
        return K;
    }

    private static String L(Context context) {
        TelephonyManager P2;
        if (O) {
            return N;
        }
        U(context);
        if (c(context, ib.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) && (P2 = P(context)) != null) {
            String simOperatorName = P2.getSimOperatorName();
            N = simOperatorName;
            if (TextUtils.isEmpty(simOperatorName)) {
                N = P2.getNetworkOperatorName();
            }
            O = true;
            return N;
        }
        return N;
    }

    private static int M(Context context) {
        if (Q) {
            return P;
        }
        U(context);
        if (context == null || !c(context, ib.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return P;
        }
        ConnectivityManager N2 = N(context);
        if (N2 == null) {
            return P;
        }
        NetworkInfo activeNetworkInfo = N2.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            Q = true;
            return P;
        }
        int type = activeNetworkInfo.getType();
        P = type;
        Q = true;
        return type;
    }

    private static ConnectivityManager N(Context context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    private static int O(Context context) {
        TelephonyManager P2;
        if (S) {
            return R;
        }
        U(context);
        if (c(context, ib.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) && (P2 = P(context)) != null) {
            int networkType = P2.getNetworkType();
            R = networkType;
            S = true;
            return networkType;
        }
        return R;
    }

    private static TelephonyManager P(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static String Q(Context context) {
        String str;
        if (f5100c) {
            try {
                str = R(context);
            } catch (Throwable th) {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                f5100c = false;
                return "";
            }
            try {
                return new String(ht.a(ib.c("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), ht.b(str), ib.c("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8")), "UTF-8");
            } catch (Throwable th2) {
                f5100c = false;
                return "";
            }
        }
        return "";
    }

    private static String R(Context context) {
        String str;
        try {
            str = S(context);
        } catch (Throwable th) {
            str = "";
        }
        return !TextUtils.isEmpty(str) ? str : context == null ? "" : context.getSharedPreferences(ib.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(hw.b(ib.c("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    }

    private static String S(Context context) {
        RandomAccessFile randomAccessFile;
        String[] split;
        if (Build.VERSION.SDK_INT < 19 || c(context, ib.c("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ=="))) {
            String b2 = hw.b(ib.c("LYW1hcF9kZXZpY2VfYWRpdQ"));
            String T2 = T(context);
            if (TextUtils.isEmpty(T2)) {
                return "";
            }
            File file = new File(T2 + File.separator + ib.c("KYmFja3Vwcw"), ib.c("MLmFkaXU"));
            if (file.exists() && file.canRead()) {
                if (file.length() == 0) {
                    file.delete();
                    return "";
                }
                ByteArrayOutputStream byteArrayOutputStream = null;
                try {
                    randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        byte[] bArr = new byte[1024];
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                int read = randomAccessFile.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr, 0, read);
                            } catch (Throwable th) {
                                byteArrayOutputStream = byteArrayOutputStream2;
                                a(byteArrayOutputStream);
                                a(randomAccessFile);
                                return "";
                            }
                        }
                        String str = new String(byteArrayOutputStream2.toByteArray(), "UTF-8");
                        if (!TextUtils.isEmpty(str) && str.contains(ib.c("SIw")) && (split = str.split(ib.c("SIw"))) != null && split.length == 2) {
                            if (TextUtils.equals(b2, split[0])) {
                                String str2 = split[1];
                                a(byteArrayOutputStream2);
                                a(randomAccessFile);
                                return str2;
                            }
                        }
                        a(byteArrayOutputStream2);
                    } catch (Throwable th2) {
                    }
                } catch (Throwable th3) {
                    randomAccessFile = null;
                }
                a(randomAccessFile);
                return "";
            }
            return "";
        }
        return "";
    }

    private static String T(Context context) {
        if (Build.VERSION.SDK_INT < 9) {
            return null;
        }
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService(Context.STORAGE_SERVICE);
            Class<?> cls = Class.forName(ib.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(ib.c("MZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
            Method method2 = cls.getMethod(ib.c("FZ2V0UGF0aA"), new Class[0]);
            Method method3 = cls.getMethod(ib.c("DaXNSZW1vdmFibGU"), new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return null;
                }
                Object obj = Array.get(invoke, i3);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
                i2 = i3 + 1;
            }
        } catch (Throwable th) {
            return null;
        }
    }

    private static b U(Context context) {
        synchronized (hs.class) {
            try {
                if (T == null) {
                    if (context == null) {
                        return null;
                    }
                    b bVar = new b();
                    T = bVar;
                    bVar.a(context.getApplicationContext());
                }
                return T;
            } finally {
            }
        }
    }

    public static String a() {
        return k;
    }

    public static String a(final Context context) {
        try {
            if (TextUtils.isEmpty(b)) {
                if (context == null) {
                    return "";
                }
                String Q2 = Q(context);
                b = Q2;
                if (TextUtils.isEmpty(Q2)) {
                    if (c() == null || m) {
                        return "";
                    }
                    m = true;
                    lb.a().a(new lc() { // from class: com.amap.api.col.3sl.hs.1
                        @Override // com.amap.api.col.p0003sl.lc
                        public final void runTask() {
                            try {
                                Map<String, String> b2 = hs.g.b();
                                String a2 = hs.g.a(hs.h(Context.this), "", "", hs.y(Context.this));
                                if (TextUtils.isEmpty(a2)) {
                                    return;
                                }
                                ju.a();
                                String a3 = hs.g.a(Context.this, new String(ju.a(hs.g.a(a2.getBytes(), b2)).f5264a));
                                if (TextUtils.isEmpty(a3)) {
                                    return;
                                }
                                hs.b = a3;
                            } catch (Throwable th) {
                            }
                        }
                    });
                    return "";
                }
                return b;
            }
            return b;
        } catch (Throwable th) {
            return "";
        }
    }

    private static String a(Context context, int i2) {
        try {
            Intent intent = new Intent();
            if (i2 == 2) {
                intent.setAction(ib.c("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
                intent.setPackage(ib.c("UY29tLmh1YXdlaS5od2lk"));
            } else if (i2 == 4) {
                intent.setClassName(ib.c("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), ib.c("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));
            } else if (i2 != 5) {
                o = true;
                return n;
            } else {
                intent.setClassName(ib.c("YY29tLmhleXRhcC5vcGVuaWQ"), ib.c("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));
                intent.setAction(ib.c("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));
            }
            c cVar = new c(context, i2);
            if (context.bindService(intent, cVar, 1)) {
                int i3 = 0;
                while (i3 < 100 && TextUtils.isEmpty(n)) {
                    i3++;
                    Thread.sleep(15L);
                }
                context.unbindService(cVar);
            }
            return n;
        } catch (Throwable th) {
            it.a(th, "oa", String.valueOf(i2));
            o = true;
            return n;
        }
    }

    public static String a(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT < 21) {
                return "";
            }
            if (TextUtils.isEmpty(i) && !D) {
                TelephonyManager P2 = P(context);
                if (h == -1) {
                    Method a2 = ib.a(TelephonyManager.class, "UZ2V0UGhvbmVDb3VudA=", new Class[0]);
                    if (a2 != null) {
                        try {
                            h = ((Integer) a2.invoke(P2, new Object[0])).intValue();
                        } catch (Throwable th) {
                        }
                    }
                    h = 0;
                }
                Method a3 = ib.a(TelephonyManager.class, "MZ2V0SW1laQ=", Integer.TYPE);
                if (a3 == null) {
                    h = 0;
                    D = true;
                    return "";
                }
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                while (true) {
                    try {
                        int i3 = i2;
                        if (i3 >= h) {
                            break;
                        }
                        sb.append((String) a3.invoke(P2, Integer.valueOf(i3)));
                        sb.append(str);
                        i2 = i3 + 1;
                    } catch (Throwable th2) {
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() == 0) {
                    h = 0;
                    D = true;
                    return "";
                }
                String substring = sb2.substring(0, sb2.length() - 1);
                i = substring;
                D = true;
                return substring;
            }
            return i;
        } catch (Throwable th3) {
            return "";
        }
    }

    public static void a(a aVar) {
        if (g == null) {
            g = aVar;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    public static void a(String str) {
        k = str;
    }

    public static String b() {
        try {
            return !TextUtils.isEmpty(e) ? e : g == null ? "" : g.a();
        } catch (Throwable th) {
            return "";
        }
    }

    public static String b(Context context) {
        try {
            return L(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static a c() {
        return g;
    }

    public static String c(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String y2 = y(context);
            return (y2 == null || y2.length() < 5) ? "" : y2.substring(3, 5);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static int d(Context context) {
        try {
            return O(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] d() {
        return new String[]{"", ""};
    }

    public static int e(Context context) {
        try {
            return M(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static void e() {
        try {
            ir.a();
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0083 -> B:12:0x007f). Please submit an issue!!! */
    public static long f() {
        long blockCount;
        long blockCount2;
        long j2 = H;
        if (j2 != 0) {
            return j2;
        }
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                blockCount = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 1048576;
                blockCount2 = (statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / 1048576;
            } else {
                blockCount = (statFs.getBlockCount() * statFs.getBlockSize()) / 1048576;
                blockCount2 = (statFs2.getBlockCount() * statFs2.getBlockSize()) / 1048576;
            }
            H = blockCount + blockCount2;
        } catch (Throwable th) {
        }
        return H;
    }

    public static String f(Context context) {
        try {
            return K(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String g() {
        if (TextUtils.isEmpty(J)) {
            String property = System.getProperty("os.arch");
            J = property;
            return property;
        }
        return J;
    }

    public static String g(final Context context) {
        if (o) {
            return "";
        }
        if (TextUtils.isEmpty(n) && !p) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                lb.a().a(new lc() { // from class: com.amap.api.col.3sl.hs.2
                    @Override // com.amap.api.col.p0003sl.lc
                    public final void runTask() {
                        hs.G(Context.this);
                        hs.i();
                    }
                });
                return n;
            }
            p = true;
            return G(context);
        }
        return n;
    }

    public static String h(Context context) {
        if (q) {
            String str = f5099a;
            return str == null ? "" : str;
        } else if (f5099a == null || "".equals(f5099a)) {
            if (c(context, ib.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
                f5099a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
            }
            if (!TextUtils.isEmpty(f5099a)) {
                q = true;
                return f5099a;
            }
            try {
                String C2 = C(context);
                f5099a = C2;
                if (!TextUtils.isEmpty(C2)) {
                    q = true;
                    return f5099a;
                }
            } catch (Throwable th) {
            }
            try {
                f5099a = D(context);
                q = true;
            } catch (Throwable th2) {
            }
            String str2 = f5099a;
            return str2 == null ? "" : str2;
        } else {
            return f5099a;
        }
    }

    public static void h() {
        P = -1;
        Q = false;
        R = -1;
        S = false;
        N = "";
        O = false;
        x = "";
        y = false;
    }

    public static String i(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        if (TextUtils.isEmpty(s) && !t) {
            if (c(context, ib.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                if (Build.VERSION.SDK_INT >= 26) {
                    String str = (String) ib.a(Build.class, "MZ2V0U2VyaWFs", new Class[0]).invoke(Build.class, new Object[0]);
                    t = true;
                    return str;
                }
                if (Build.VERSION.SDK_INT >= 9) {
                    s = Build.SERIAL;
                    t = true;
                }
                String str2 = s;
                return str2 == null ? "" : str2;
            }
            return "";
        }
        return s;
    }

    static /* synthetic */ boolean i() {
        p = true;
        return true;
    }

    public static String j(Context context) {
        if (TextUtils.isEmpty(r) && !u) {
            try {
                String string = Settings.Secure.getString(context.getContentResolver(), ib.c(new String(ip.a(13))));
                r = string;
                u = true;
                String str = string;
                if (string == null) {
                    str = "";
                }
                return str;
            } catch (Throwable th) {
                return r;
            }
        }
        return r;
    }

    public static String k(Context context) {
        if (Build.VERSION.SDK_INT < 30 || context.getApplicationInfo().targetSdkVersion < 30) {
            try {
                if ((v == null || "".equals(v)) && !w && c(context, ib.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager == null) {
                        return "";
                    }
                    v = wifiManager.getConnectionInfo().getMacAddress();
                    if (ib.c("YMDI6MDA6MDA6MDA6MDA6MDA").equals(v) || ib.c("YMDA6MDA6MDA6MDA6MDA6MDA").equals(v)) {
                        v = H(context);
                    }
                    w = true;
                }
                return v;
            } catch (Throwable th) {
            }
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l(Context context) {
        try {
            TelephonyManager P2 = P(context);
            if (P2 == null) {
                return "";
            }
            String networkOperator = P2.getNetworkOperator();
            String str = "";
            if (!TextUtils.isEmpty(networkOperator)) {
                if (networkOperator.length() < 3) {
                    return "";
                }
                str = networkOperator.substring(0, 3);
            }
            return str;
        } catch (Throwable th) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String m(Context context) {
        TelephonyManager P2;
        if (y) {
            return x;
        }
        try {
            U(context);
            P2 = P(context);
        } catch (Throwable th) {
        }
        if (P2 == null) {
            return x;
        }
        String networkOperator = P2.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
            x = networkOperator.substring(3);
            y = true;
            return x;
        }
        y = true;
        return x;
    }

    public static int n(Context context) {
        try {
            return O(context);
        } catch (Throwable th) {
            return -1;
        }
    }

    public static int o(Context context) {
        try {
            return M(context);
        } catch (Throwable th) {
            return -1;
        }
    }

    public static NetworkInfo p(Context context) {
        ConnectivityManager N2;
        if (c(context, ib.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (N2 = N(context)) != null) {
            return N2.getActiveNetworkInfo();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String q(Context context) {
        try {
            NetworkInfo p2 = p(context);
            if (p2 == null) {
                return null;
            }
            return p2.getExtraInfo();
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String r(Context context) {
        StringBuilder sb;
        if (z == null || "".equals(z)) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            if (i3 > i2) {
                sb = new StringBuilder();
                sb.append(i2);
                sb.append(PhoneConstants.APN_TYPE_ALL);
                sb.append(i3);
            } else {
                sb = new StringBuilder();
                sb.append(i3);
                sb.append(PhoneConstants.APN_TYPE_ALL);
                sb.append(i2);
            }
            z = sb.toString();
            return z;
        }
        return z;
    }

    public static String s(Context context) {
        try {
            if (c(context, ib.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                TelephonyManager P2 = P(context);
                return P2 == null ? "" : P2.getNetworkOperatorName();
            }
            return K;
        } catch (Throwable th) {
            return "";
        }
    }

    public static String t(Context context) {
        ConnectivityManager N2;
        NetworkInfo activeNetworkInfo;
        try {
            return (!c(context, ib.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (N2 = N(context)) == null || (activeNetworkInfo = N2.getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getTypeName();
        } catch (Throwable th) {
            return "";
        }
    }

    public static String u(Context context) {
        String str;
        try {
            String v2 = v(context);
            String str2 = v2;
            String str3 = v2;
            try {
                if (TextUtils.isEmpty(v2)) {
                    str2 = a(context);
                }
                String str4 = str2;
                if (TextUtils.isEmpty(str2)) {
                    String str5 = str2;
                    str4 = h(context);
                }
                String str6 = str4;
                if (TextUtils.isEmpty(str4)) {
                    String str7 = str4;
                    str6 = g(context);
                }
                String str8 = str6;
                if (TextUtils.isEmpty(str6)) {
                    String str9 = str6;
                    str8 = j(context);
                }
                str = str8;
                if (TextUtils.isEmpty(str8)) {
                    str3 = str8;
                    return I(context);
                }
            } catch (Throwable th) {
                return str3;
            }
        } catch (Throwable th2) {
            str = "";
        }
        return str;
    }

    public static String v(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        if ((A == null || "".equals(A)) && !F && c(context, ib.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            TelephonyManager P2 = P(context);
            if (P2 == null) {
                return "";
            }
            Method a2 = ib.a(P2.getClass(), "QZ2V0RGV2aWNlSWQ", new Class[0]);
            if (Build.VERSION.SDK_INT >= 26) {
                a2 = ib.a(P2.getClass(), "QZ2V0SW1laQ==", new Class[0]);
            }
            if (a2 != null) {
                A = (String) a2.invoke(P2, new Object[0]);
            }
            if (A == null) {
                A = "";
            }
            F = true;
            return A;
        }
        return A;
    }

    public static String w(Context context) {
        return v(context) + "#" + a(context) + "#" + u(context);
    }

    public static String x(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        if ((B == null || "".equals(B)) && c(context, ib.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            TelephonyManager P2 = P(context);
            if (P2 == null) {
                return "";
            }
            if (G) {
                return B;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Method a2 = ib.a(P2.getClass(), "QZ2V0TWVpZA==", new Class[0]);
                if (a2 != null) {
                    B = (String) a2.invoke(P2, new Object[0]);
                }
                if (B == null) {
                    B = "";
                }
                G = true;
            }
            return B;
        }
        return B;
    }

    public static String y(Context context) {
        try {
            return K(context);
        } catch (Throwable th) {
            return "";
        }
    }

    public static int z(Context context) {
        BufferedReader bufferedReader;
        int i2 = I;
        if (i2 != 0) {
            return i2;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 16) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return 0;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            i3 = (int) (memoryInfo.totalMem / 1024);
        } else {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(new File("/proc/meminfo")));
                } catch (Throwable th) {
                }
                try {
                    int intValue = Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue();
                    bufferedReader.close();
                    i3 = intValue;
                } catch (Throwable th2) {
                    bufferedReader2 = bufferedReader;
                    i3 = 0;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                        i3 = 0;
                    }
                    int i4 = i3 / 1024;
                    I = i4;
                    return i4;
                }
            } catch (IOException e2) {
            }
        }
        int i42 = i3 / 1024;
        I = i42;
        return i42;
    }
}
