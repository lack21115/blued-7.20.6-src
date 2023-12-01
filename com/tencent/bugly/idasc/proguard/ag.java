package com.tencent.bugly.idasc.proguard;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ag.class */
public final class ag {

    /* renamed from: a  reason: collision with root package name */
    private final SimpleDateFormat f21530a;
    private final ad b;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ag$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final ag f21532a = new ag((byte) 0);

        public static /* synthetic */ ag a() {
            return f21532a;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ag$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        String f21533a;
        public long b;

        /* renamed from: c  reason: collision with root package name */
        public String f21534c;

        public final String toString() {
            return "SLAData{uuid='" + this.f21533a + "', time=" + this.b + ", data='" + this.f21534c + "'}";
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ag$c.class */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        String f21535a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        long f21536c;
        boolean d;
        long e;
        String f;
        String g;

        public c() {
        }

        public c(String str, String str2, long j, boolean z, long j2, String str3, String str4) {
            this.f21535a = str;
            this.b = str2;
            this.f21536c = j;
            this.d = z;
            this.e = j2;
            this.f = str3;
            this.g = str4;
        }
    }

    private ag() {
        this.f21530a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);
        this.b = new ad();
    }

    /* synthetic */ ag(byte b2) {
        this();
    }

    private static String a(String str, Iterable<b> iterable) {
        Iterator<b> it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append("'");
            sb.append(it.next().f21533a);
            sb.append("'");
            if (!it.hasNext()) {
                return sb.toString();
            }
            sb.append(str);
        }
    }

    public static List<b> a() {
        Cursor a2 = w.a().a("t_sla", new String[]{"_id", "_tm", "_dt"}, (String) null, "_tm", BaseWrapper.ENTER_ID_TOOLKIT);
        if (a2 == null) {
            return null;
        }
        if (a2.getCount() <= 0) {
            a2.close();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (a2.moveToNext()) {
            try {
                b bVar = new b();
                bVar.f21533a = a2.getString(a2.getColumnIndex("_id"));
                bVar.b = a2.getLong(a2.getColumnIndex("_tm"));
                bVar.f21534c = a2.getString(a2.getColumnIndex("_dt"));
                al.c(bVar.toString(), new Object[0]);
                arrayList.add(bVar);
            } finally {
                try {
                    return arrayList;
                } finally {
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private b b(c cVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    static void c(List<b> list) {
        if (list == null || list.isEmpty()) {
            al.c("sla batch report data is empty", new Object[0]);
            return;
        }
        al.c("sla batch report list size:%s", Integer.valueOf(list.size()));
        List<b> list2 = list;
        if (list.size() > 30) {
            list2 = list.subList(0, 29);
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar : list2) {
            arrayList.add(bVar.f21534c);
        }
        Pair<Integer, String> a2 = ad.a(arrayList);
        al.c("sla batch report result, rspCode:%s rspMsg:%s", a2.first, a2.second);
        if (a2.first.intValue() == 200) {
            d(list2);
        }
    }

    public static void d(List<b> list) {
        if (list == null || list.isEmpty()) {
            al.c("sla batch delete list is null", new Object[0]);
            return;
        }
        al.c("sla batch delete list size:%s", Integer.valueOf(list.size()));
        try {
            String str = "_id in (" + a(",", list) + ")";
            al.c("sla batch delete where:%s", str);
            w.a().a("t_sla", str);
        } catch (Throwable th) {
            al.b(th);
        }
    }

    private static void e(List<b> list) {
        for (b bVar : list) {
            al.c("sla save id:%s time:%s msg:%s", bVar.f21533a, Long.valueOf(bVar.b), bVar.f21534c);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", bVar.f21533a);
                contentValues.put("_tm", Long.valueOf(bVar.b));
                contentValues.put("_dt", bVar.f21534c);
                w.a().a("t_sla", contentValues, (v) null);
            } catch (Throwable th) {
                al.b(th);
            }
        }
    }

    public final void a(c cVar) {
        if (TextUtils.isEmpty(cVar.b)) {
            al.d("sla report event is null", new Object[0]);
            return;
        }
        al.c("sla report single event", new Object[0]);
        a(Collections.singletonList(cVar));
    }

    public final void a(List<c> list) {
        if (list == null || list.isEmpty()) {
            al.d("sla batch report event is null", new Object[0]);
            return;
        }
        al.c("sla batch report event size:%s", Integer.valueOf(list.size()));
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            b b2 = b(cVar);
            if (b2 != null) {
                arrayList.add(b2);
            }
        }
        e(arrayList);
        b(arrayList);
    }

    public final void b(final List<b> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ak.a().a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.ag.1
                @Override // java.lang.Runnable
                public final void run() {
                    ag.c(list);
                }
            });
        } else {
            c(list);
        }
    }
}
