package com.tencent.bugly.idasc.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.idasc.crashreport.biz.UserInfoBean;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.datatype.DatatypeConstants;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/r.class */
public final class r {
    private static boolean e = true;

    /* renamed from: a  reason: collision with root package name */
    private Context f35329a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private int f35330c;
    private boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/r$a.class */
    public final class a implements Runnable {
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private UserInfoBean f35334c;

        public a(UserInfoBean userInfoBean, boolean z) {
            this.f35334c = userInfoBean;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (r.this.d) {
                try {
                    if (this.f35334c != null) {
                        r.a(this.f35334c);
                        al.c("[UserInfo] Record user info.", new Object[0]);
                        r.this.a(this.f35334c, false);
                    }
                    if (this.b) {
                        r.this.b();
                    }
                } catch (Throwable th) {
                    if (al.a(th)) {
                        return;
                    }
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/r$b.class */
    public final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < r.this.b) {
                ak.a().a(new b(), (r.this.b - currentTimeMillis) + 5000);
                return;
            }
            r.this.a(3, false);
            r.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/r$c.class */
    public final class c implements Runnable {
        private long b;

        public c(long j) {
            this.b = com.anythink.expressad.d.a.b.aD;
            this.b = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            r.this.b();
            r.this.a(this.b);
        }
    }

    public r(Context context, boolean z) {
        this.d = true;
        this.f35329a = context;
        this.d = z;
    }

    private static int a(List<UserInfoBean> list) {
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        for (UserInfoBean userInfoBean : list) {
            if (userInfoBean.e > currentTimeMillis - 600000 && (userInfoBean.b == 1 || userInfoBean.b == 4 || userInfoBean.b == 3)) {
                i++;
            }
        }
        return i;
    }

    private static UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) ap.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f35192a = j;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Finally extract failed */
    public static List<UserInfoBean> a(String str) {
        Cursor cursor;
        String str2;
        try {
            if (ap.b(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursor = w.a().a("t_ui", (String[]) null, str2);
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                    return null;
                }
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    UserInfoBean a2 = a(cursor);
                    if (a2 != null) {
                        arrayList.add(a2);
                    } else {
                        long j = cursor.getLong(cursor.getColumnIndex("_id"));
                        sb.append(" or _id = ");
                        sb.append(j);
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    al.d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(w.a().a("t_ui", sb2.substring(4))));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                        return null;
                    }
                    return null;
                } catch (Throwable th2) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    static /* synthetic */ void a(UserInfoBean userInfoBean) {
        aa b2;
        if (userInfoBean == null || (b2 = aa.b()) == null) {
            return;
        }
        userInfoBean.j = b2.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> a2;
        if (userInfoBean == null) {
            return;
        }
        if (!z && userInfoBean.b != 1 && (a2 = a(aa.a(this.f35329a).d)) != null && a2.size() >= 20) {
            al.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(a2.size()));
            return;
        }
        long a3 = w.a().a("t_ui", b(userInfoBean), (v) null);
        if (a3 >= 0) {
            al.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(a3));
            userInfoBean.f35192a = a3;
        }
    }

    private static void a(List<UserInfoBean> list, List<UserInfoBean> list2) {
        int i;
        int size = list.size() - 20;
        if (size > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size() - 1) {
                    break;
                }
                int i4 = i3 + 1;
                int i5 = i4;
                while (true) {
                    int i6 = i5;
                    if (i6 < list.size()) {
                        if (list.get(i3).e > list.get(i6).e) {
                            list.set(i3, list.get(i6));
                            list.set(i6, list.get(i3));
                        }
                        i5 = i6 + 1;
                    }
                }
                i2 = i4;
            }
            for (i = 0; i < size; i++) {
                list2.add(list.get(i));
            }
        }
    }

    private void a(final List<UserInfoBean> list, boolean z) {
        if (!b(z)) {
            long currentTimeMillis = System.currentTimeMillis();
            for (UserInfoBean userInfoBean : list) {
                userInfoBean.f = currentTimeMillis;
                a(userInfoBean, true);
            }
            al.d("uploadCheck failed", new Object[0]);
            return;
        }
        int i = this.f35330c == 1 ? 1 : 2;
        bv bvVar = null;
        if (list != null) {
            if (list.size() == 0) {
                bvVar = null;
            } else {
                aa b2 = aa.b();
                if (b2 == null) {
                    bvVar = null;
                } else {
                    b2.o();
                    bvVar = new bv();
                    bvVar.b = b2.d;
                    bvVar.f35316c = b2.g();
                    ArrayList<bu> arrayList = new ArrayList<>();
                    for (UserInfoBean userInfoBean2 : list) {
                        bu a2 = ae.a(userInfoBean2);
                        if (a2 != null) {
                            arrayList.add(a2);
                        }
                    }
                    bvVar.d = arrayList;
                    bvVar.e = new HashMap();
                    Map<String, String> map = bvVar.e;
                    StringBuilder sb = new StringBuilder();
                    b2.getClass();
                    map.put("A7", sb.toString());
                    bvVar.e.put("A6", aa.n());
                    bvVar.e.put("A5", b2.m());
                    Map<String, String> map2 = bvVar.e;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(b2.k());
                    map2.put("A2", sb2.toString());
                    Map<String, String> map3 = bvVar.e;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(b2.k());
                    map3.put("A1", sb3.toString());
                    bvVar.e.put("A24", b2.k);
                    Map<String, String> map4 = bvVar.e;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(b2.l());
                    map4.put("A17", sb4.toString());
                    bvVar.e.put("A15", b2.q());
                    Map<String, String> map5 = bvVar.e;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(b2.r());
                    map5.put("A13", sb5.toString());
                    bvVar.e.put("F08", b2.E);
                    bvVar.e.put("F09", b2.F);
                    Map<String, String> y = b2.y();
                    if (y != null && y.size() > 0) {
                        for (Map.Entry<String, String> entry : y.entrySet()) {
                            bvVar.e.put("C04_" + entry.getKey(), entry.getValue());
                        }
                    }
                    if (i == 1) {
                        bvVar.f35315a = (byte) 1;
                    } else if (i != 2) {
                        al.e("unknown up type %d ", Integer.valueOf(i));
                        bvVar = null;
                    } else {
                        bvVar.f35315a = (byte) 2;
                    }
                }
            }
        }
        if (bvVar == null) {
            al.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
            return;
        }
        byte[] a3 = ae.a((m) bvVar);
        if (a3 == null) {
            al.d("[UserInfo] Failed to encode data.", new Object[0]);
            return;
        }
        bq a4 = ae.a(this.f35329a, DatatypeConstants.MIN_TIMEZONE_OFFSET, a3);
        if (a4 == null) {
            al.d("[UserInfo] Request package is null.", new Object[0]);
            return;
        }
        ai.a().a(1001, a4, ac.a().c().q, StrategyBean.f35196a, new ah() { // from class: com.tencent.bugly.idasc.proguard.r.1
            @Override // com.tencent.bugly.idasc.proguard.ah
            public final void a(boolean z2, String str) {
                if (z2) {
                    al.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    for (UserInfoBean userInfoBean3 : list) {
                        userInfoBean3.f = currentTimeMillis2;
                        r.this.a(userInfoBean3, true);
                    }
                }
            }
        }, this.f35330c == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047 A[Catch: all -> 0x00fd, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:24:0x0047, B:26:0x0068, B:29:0x0086, B:32:0x00ad, B:34:0x00b7, B:37:0x00c0, B:40:0x00cd, B:43:0x00ef, B:31:0x00a1, B:7:0x000c, B:10:0x0019, B:13:0x0026, B:15:0x002e), top: B:53:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7 A[Catch: all -> 0x00fd, TryCatch #0 {, blocks: (B:4:0x0002, B:24:0x0047, B:26:0x0068, B:29:0x0086, B:32:0x00ad, B:34:0x00b7, B:37:0x00c0, B:40:0x00cd, B:43:0x00ef, B:31:0x00a1, B:7:0x000c, B:10:0x0019, B:13:0x0026, B:15:0x002e), top: B:53:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r7) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.r.a(boolean):void");
    }

    private static ContentValues b(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (userInfoBean.f35192a > 0) {
                contentValues.put("_id", Long.valueOf(userInfoBean.f35192a));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f));
            contentValues.put(com.umeng.analytics.pro.bl.e, Integer.valueOf(userInfoBean.b));
            contentValues.put("_pc", userInfoBean.f35193c);
            contentValues.put("_dt", ap.a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private static void b(List<UserInfoBean> list) {
        if (list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size() || i2 >= 50) {
                break;
            }
            sb.append(" or _id = ");
            sb.append(list.get(i2).f35192a);
            i = i2 + 1;
        }
        String sb2 = sb.toString();
        String str = sb2;
        if (sb2.length() > 0) {
            str = sb2.substring(4);
        }
        sb.setLength(0);
        try {
            al.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(w.a().a("t_ui", str)));
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static void b(List<UserInfoBean> list, List<UserInfoBean> list2) {
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            UserInfoBean next = it.next();
            if (next.f != -1) {
                it.remove();
                if (next.e < ap.b()) {
                    list2.add(next);
                }
            }
        }
    }

    private boolean b(boolean z) {
        if (e) {
            File file = new File(this.f35329a.getFilesDir(), "bugly_last_us_up_tm");
            long currentTimeMillis = System.currentTimeMillis();
            if (z) {
                am.a(file, String.valueOf(currentTimeMillis), 1024L, false);
                return true;
            } else if (!file.exists()) {
                am.a(file, String.valueOf(currentTimeMillis), 1024L, false);
                return true;
            } else {
                BufferedReader a2 = ap.a(file);
                boolean z2 = true;
                if (a2 != null) {
                    try {
                        long longValue = Long.valueOf(a2.readLine().trim()).longValue();
                        if (!(currentTimeMillis >= longValue && currentTimeMillis - longValue <= 86400000) || currentTimeMillis - longValue >= 300000) {
                            am.a(file, String.valueOf(currentTimeMillis), 1024L, false);
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    }
                }
                boolean z3 = z2;
                if (a2 != null) {
                    a2.close();
                    z3 = z2;
                }
                return z3;
            }
        }
        return true;
    }

    public final void a() {
        this.b = ap.b() + 86400000;
        ak.a().a(new b(), (this.b - System.currentTimeMillis()) + 5000);
    }

    public final void a(int i, boolean z) {
        ac a2 = ac.a();
        int i2 = 0;
        if (a2 != null && !a2.c().g && i != 1 && i != 3) {
            al.e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i == 1 || i == 3) {
            this.f35330c++;
        }
        aa a3 = aa.a(this.f35329a);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.b = i;
        userInfoBean.f35193c = a3.d;
        userInfoBean.d = a3.f();
        userInfoBean.e = System.currentTimeMillis();
        userInfoBean.f = -1L;
        userInfoBean.n = a3.o;
        if (i == 1) {
            i2 = 1;
        }
        userInfoBean.o = i2;
        userInfoBean.l = a3.a();
        userInfoBean.m = a3.y;
        userInfoBean.g = a3.z;
        userInfoBean.h = a3.A;
        userInfoBean.i = a3.B;
        userInfoBean.k = a3.C;
        userInfoBean.r = a3.t();
        userInfoBean.s = a3.y();
        userInfoBean.p = a3.z();
        userInfoBean.q = a3.x;
        ak.a().a(new a(userInfoBean, z), 0L);
    }

    public final void a(long j) {
        ak.a().a(new c(j), j);
    }

    public final void b() {
        ak a2 = ak.a();
        if (a2 != null) {
            a2.a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.r.2

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ boolean f35332a = false;

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        r.this.a(this.f35332a);
                    } catch (Throwable th) {
                        al.a(th);
                    }
                }
            });
        }
    }
}
