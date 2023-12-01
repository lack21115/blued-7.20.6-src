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
    private static al f484a = new al(true);

    /* renamed from: a  reason: collision with root package name */
    private static volatile int f27770a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static long f483a = System.currentTimeMillis();

    /* renamed from: a  reason: collision with other field name */
    private static final Object f486a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static List<a> f488a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private static String f487a = "";

    /* renamed from: a  reason: collision with other field name */
    private static com.xiaomi.push.providers.a f485a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gz$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f27771a;

        /* renamed from: a  reason: collision with other field name */
        public long f489a;

        /* renamed from: a  reason: collision with other field name */
        public String f490a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public long f491b;

        /* renamed from: b  reason: collision with other field name */
        public String f492b;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f490a = "";
            this.f489a = 0L;
            this.f27771a = -1;
            this.b = -1;
            this.f492b = "";
            this.f491b = 0L;
            this.f490a = str;
            this.f489a = j;
            this.f27771a = i;
            this.b = i2;
            this.f492b = str2;
            this.f491b = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f490a, this.f490a) && TextUtils.equals(aVar.f492b, this.f492b) && aVar.f27771a == this.f27771a && aVar.b == this.b && Math.abs(aVar.f489a - this.f489a) <= 5000;
        }
    }

    public static int a(Context context) {
        if (f27770a == -1) {
            f27770a = b(context);
        }
        return f27770a;
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
            long j3 = f483a;
            f483a = j2;
            if (j2 - j3 > 30000 && j > 1024) {
                return j * 2;
            }
        }
        return (j * (i == 0 ? 13 : 11)) / 10;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m8786a(Context context) {
        com.xiaomi.push.providers.a aVar = f485a;
        if (aVar != null) {
            return aVar;
        }
        com.xiaomi.push.providers.a aVar2 = new com.xiaomi.push.providers.a(context);
        f485a = aVar2;
        return aVar2;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m8787a(Context context) {
        synchronized (gz.class) {
            try {
                if (TextUtils.isEmpty(f487a)) {
                    return "";
                }
                return f487a;
            } finally {
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m8789a(Context context) {
        f27770a = b(context);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private static void a(Context context, String str, long j, boolean z, long j2) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }

    private static void a(a aVar) {
        for (a aVar2 : f488a) {
            if (aVar2.a(aVar)) {
                aVar2.f491b += aVar.f491b;
                return;
            }
        }
        f488a.add(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m8790a(String str) {
        synchronized (gz.class) {
            try {
                if (!j.m9003d() && !TextUtils.isEmpty(str)) {
                    f487a = str;
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
            synchronized (com.xiaomi.push.providers.a.f856a) {
                SQLiteDatabase writableDatabase = m8786a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                for (a aVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("package_name", aVar.f490a);
                    contentValues.put("message_ts", Long.valueOf(aVar.f489a));
                    contentValues.put("network_type", Integer.valueOf(aVar.f27771a));
                    contentValues.put("bytes", Long.valueOf(aVar.f491b));
                    contentValues.put("rcv", Integer.valueOf(aVar.b));
                    contentValues.put("imsi", aVar.f492b);
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
