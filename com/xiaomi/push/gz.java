package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gz.class */
public class gz {

    /* renamed from: a  reason: collision with other field name */
    private static al f531a = new al(true);

    /* renamed from: a  reason: collision with root package name */
    private static volatile int f41461a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static long f530a = System.currentTimeMillis();

    /* renamed from: a  reason: collision with other field name */
    private static final Object f533a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static List<a> f535a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private static String f534a = "";

    /* renamed from: a  reason: collision with other field name */
    private static com.xiaomi.push.providers.a f532a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gz$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f41462a;

        /* renamed from: a  reason: collision with other field name */
        public long f536a;

        /* renamed from: a  reason: collision with other field name */
        public String f537a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public long f538b;

        /* renamed from: b  reason: collision with other field name */
        public String f539b;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f537a = "";
            this.f536a = 0L;
            this.f41462a = -1;
            this.b = -1;
            this.f539b = "";
            this.f538b = 0L;
            this.f537a = str;
            this.f536a = j;
            this.f41462a = i;
            this.b = i2;
            this.f539b = str2;
            this.f538b = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f537a, this.f537a) && TextUtils.equals(aVar.f539b, this.f539b) && aVar.f41462a == this.f41462a && aVar.b == this.b && Math.abs(aVar.f536a - this.f536a) <= 5000;
        }
    }

    public static int a(Context context) {
        if (f41461a == -1) {
            f41461a = b(context);
        }
        return f41461a;
    }

    public static int a(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException e) {
            return str.getBytes().length;
        }
    }

    private static long a(int i, long j, boolean z, long j2, boolean z2) {
        if (z && z2) {
            long j3 = f530a;
            f530a = j2;
            if (j2 - j3 > 30000 && j > 1024) {
                return j * 2;
            }
        }
        return (j * (i == 0 ? 13 : 11)) / 10;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m11836a(Context context) {
        com.xiaomi.push.providers.a aVar = f532a;
        if (aVar != null) {
            return aVar;
        }
        com.xiaomi.push.providers.a aVar2 = new com.xiaomi.push.providers.a(context);
        f532a = aVar2;
        return aVar2;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m11837a(Context context) {
        synchronized (gz.class) {
            try {
                if (TextUtils.isEmpty(f534a)) {
                    return "";
                }
                return f534a;
            } finally {
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m11839a(Context context) {
        f41461a = b(context);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private static void a(Context context, String str, long j, boolean z, long j2) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }

    private static void a(a aVar) {
        for (a aVar2 : f535a) {
            if (aVar2.a(aVar)) {
                aVar2.f538b += aVar.f538b;
                return;
            }
        }
        f535a.add(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m11840a(String str) {
        synchronized (gz.class) {
            try {
                if (!j.m12053d() && !TextUtils.isEmpty(str)) {
                    f534a = str;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static int b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null) {
                return -1;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            return activeNetworkInfo.getType();
        } catch (Exception e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.providers.a.f903a) {
                SQLiteDatabase writableDatabase = m11836a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                for (a aVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("package_name", aVar.f537a);
                    contentValues.put("message_ts", Long.valueOf(aVar.f536a));
                    contentValues.put("network_type", Integer.valueOf(aVar.f41462a));
                    contentValues.put("bytes", Long.valueOf(aVar.f538b));
                    contentValues.put("rcv", Integer.valueOf(aVar.b));
                    contentValues.put("imsi", aVar.f539b);
                    writableDatabase.insert(com.umeng.analytics.pro.d.F, null, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }
}
