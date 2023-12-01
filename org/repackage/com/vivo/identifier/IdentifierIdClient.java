package org.repackage.com.vivo.identifier;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.igexin.assist.util.AssistUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: source-3503164-dex2jar.jar:org/repackage/com/vivo/identifier/IdentifierIdClient.class */
public class IdentifierIdClient {
    private static Context b;
    private final int t;

    /* renamed from: a  reason: collision with root package name */
    private static Object f44117a = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static boolean f44118c = false;
    private static int d = 13;
    private static IdentifierIdObserver e = null;
    private static IdentifierIdObserver f = null;
    private static IdentifierIdObserver g = null;
    private static IdentifierIdObserver h = null;
    private static HandlerThread i = null;
    private static Handler j = null;
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static String n = null;
    private static String o = null;
    private static String p = null;
    private static String q = null;
    private static volatile IdentifierIdClient r = null;
    private static volatile DataBaseOperation s = null;
    private static int u = 0;
    private static int v = 0;
    private static int w = 0;
    private static int x = 0;
    private static int y = 0;
    private static int z = 0;
    private static int A = 0;
    private static int B = 0;
    private static int C = 0;
    private static int D = 0;
    private static int E = 0;
    private static int F = 0;

    private IdentifierIdClient() {
        u();
        s = new DataBaseOperation(b);
        this.t = c(b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i2, int i3, int i4, int i5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i2);
        stringBuffer.append(",");
        stringBuffer.append(i3);
        stringBuffer.append(";");
        stringBuffer.append(i4);
        stringBuffer.append(",");
        stringBuffer.append(i5);
        return stringBuffer.toString();
    }

    private static String a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "0");
            } catch (Exception e2) {
                Log.e("VMS_SDK_Client", "getProperty: invoke is error" + e2.getMessage());
                return str2;
            }
        } catch (Throwable th) {
            return str2;
        }
    }

    static IdentifierIdClient a(Context context) {
        if (b == null) {
            if (context == null) {
                return null;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            b = context;
        }
        if (r == null) {
            synchronized (IdentifierIdClient.class) {
                try {
                    if (r == null) {
                        r = new IdentifierIdClient();
                        r.t();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return r;
    }

    private static void a(Context context, int i2, String str) {
        synchronized (IdentifierIdClient.class) {
            try {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            if (g == null) {
                                g = new IdentifierIdObserver(r, 2, str);
                                ContentResolver contentResolver = context.getContentResolver();
                                contentResolver.registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + context.getPackageName()), false, g);
                            }
                        }
                    } else if (f == null) {
                        f = new IdentifierIdObserver(r, 1, str);
                        ContentResolver contentResolver2 = context.getContentResolver();
                        contentResolver2.registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, f);
                    }
                } else if (e == null) {
                    e = new IdentifierIdObserver(r, 0, null);
                    context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        if (!f44118c) {
            v();
        }
        return f44118c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IdentifierIdClient b(Context context) {
        if (a()) {
            return a(context);
        }
        return null;
    }

    private static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.vivo.vms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(int i2, String str) {
        if (i2 == 0) {
            if (str == null) {
                v++;
            } else {
                u++;
            }
        } else if (i2 == 1) {
            if (str == null) {
                x++;
            } else {
                w++;
            }
        } else if (i2 == 2) {
            if (str == null) {
                z++;
            } else {
                y++;
            }
        } else {
            switch (i2) {
                case 8:
                    if (str == null) {
                        B++;
                        return;
                    } else {
                        A++;
                        return;
                    }
                case 9:
                    if (str == null) {
                        D++;
                        return;
                    } else {
                        C++;
                        return;
                    }
                case 10:
                    if (str == null) {
                        F++;
                        return;
                    } else {
                        E++;
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private void d(int i2, String str) {
        synchronized (f44117a) {
            a(i2, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f44117a.wait(2000L);
            } catch (InterruptedException e2) {
                Log.e("VMS_SDK_Client", "queryId: lock error");
            }
            if (SystemClock.uptimeMillis() - uptimeMillis >= 2000) {
                Log.d("VMS_SDK_Client", "query timeout");
            }
        }
    }

    private void t() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new Runnable() { // from class: org.repackage.com.vivo.identifier.IdentifierIdClient.1
            @Override // java.lang.Runnable
            public void run() {
                if (IdentifierIdClient.u + IdentifierIdClient.v + IdentifierIdClient.A + IdentifierIdClient.D + IdentifierIdClient.w + IdentifierIdClient.x + IdentifierIdClient.C + IdentifierIdClient.D + IdentifierIdClient.y + IdentifierIdClient.z + IdentifierIdClient.E + IdentifierIdClient.F > 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("oaid", IdentifierIdClient.this.a(IdentifierIdClient.u, IdentifierIdClient.v, IdentifierIdClient.A, IdentifierIdClient.B));
                    contentValues.put("vaid", IdentifierIdClient.this.a(IdentifierIdClient.w, IdentifierIdClient.x, IdentifierIdClient.C, IdentifierIdClient.D));
                    contentValues.put("aaid", IdentifierIdClient.this.a(IdentifierIdClient.y, IdentifierIdClient.z, IdentifierIdClient.E, IdentifierIdClient.F));
                    IdentifierIdClient.s.a(7, AssistUtils.BRAND_VIVO, new ContentValues[]{contentValues});
                    int unused = IdentifierIdClient.u = IdentifierIdClient.v = IdentifierIdClient.w = IdentifierIdClient.x = IdentifierIdClient.y = IdentifierIdClient.z = 0;
                    int unused2 = IdentifierIdClient.A = IdentifierIdClient.B = IdentifierIdClient.C = IdentifierIdClient.D = IdentifierIdClient.E = IdentifierIdClient.F = 0;
                }
            }
        }, 600L, 600L, TimeUnit.SECONDS);
    }

    private static void u() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        i = handlerThread;
        handlerThread.start();
        j = new Handler(i.getLooper()) { // from class: org.repackage.com.vivo.identifier.IdentifierIdClient.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 11) {
                    Log.e("VMS_SDK_Client", "message type valid");
                    return;
                }
                int i2 = message.getData().getInt("type");
                try {
                    String a2 = IdentifierIdClient.s.a(i2, message.getData().getString("appid"));
                    if (i2 == 0) {
                        String unused = IdentifierIdClient.k = a2;
                        IdentifierIdClient.c(8, IdentifierIdClient.k);
                    } else if (i2 == 1) {
                        if (a2 != null) {
                            String unused2 = IdentifierIdClient.l = a2;
                        } else {
                            Log.e("VMS_SDK_Client", "get vaid failed");
                        }
                        IdentifierIdClient.c(9, IdentifierIdClient.l);
                    } else if (i2 == 2) {
                        if (a2 != null) {
                            String unused3 = IdentifierIdClient.m = a2;
                        } else {
                            Log.e("VMS_SDK_Client", "get aaid failed");
                        }
                        IdentifierIdClient.c(10, IdentifierIdClient.m);
                    } else if (i2 != 3) {
                        if (i2 == 4) {
                            String unused4 = IdentifierIdClient.o = a2;
                        } else if (i2 == 5) {
                            if (a2 != null) {
                                String unused5 = IdentifierIdClient.p = a2;
                            } else {
                                Log.e("VMS_SDK_Client", "get guid failed");
                            }
                        }
                    } else if (a2 != null) {
                        String unused6 = IdentifierIdClient.n = a2;
                    } else {
                        Log.e("VMS_SDK_Client", "get udid failed");
                    }
                } catch (Exception e2) {
                    Log.e("VMS_SDK_Client", "readException:" + e2.toString());
                }
                synchronized (IdentifierIdClient.f44117a) {
                    IdentifierIdClient.f44117a.notify();
                }
            }
        };
    }

    private static void v() {
        f44118c = "1".equals(a("persist.sys.identifierid.supported", "0")) || "1".equals(a("persist.sys.identifierid", "0"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2, String str) {
        Message obtainMessage = j.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2 || i2 == 6) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        j.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        String str = k;
        if (str != null) {
            c(0, str);
            return k;
        }
        d(0, null);
        if (e == null) {
            a(b, 0, null);
        }
        c(0, k);
        return k;
    }
}
