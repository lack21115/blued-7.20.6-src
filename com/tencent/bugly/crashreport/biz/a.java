package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import com.umeng.analytics.pro.bl;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/biz/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f35115a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private int f35116c;
    private boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/biz/a$2.class */
    public final class AnonymousClass2 implements Runnable {
        /* JADX INFO: Access modifiers changed from: package-private */
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a.this.c();
            } catch (Throwable th) {
                x.a(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/biz/a$a.class */
    public final class RunnableC0900a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private boolean f35119a;
        private UserInfoBean b;

        public RunnableC0900a(UserInfoBean userInfoBean, boolean z) {
            this.b = userInfoBean;
            this.f35119a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.bugly.crashreport.common.info.a b;
            try {
                if (this.b != null) {
                    UserInfoBean userInfoBean = this.b;
                    if (userInfoBean != null && (b = com.tencent.bugly.crashreport.common.info.a.b()) != null) {
                        userInfoBean.j = b.e();
                    }
                    x.c("[UserInfo] Record user info.", new Object[0]);
                    a.a(a.this, this.b, false);
                }
                if (this.f35119a) {
                    a aVar = a.this;
                    w a2 = w.a();
                    if (a2 != null) {
                        a2.a(new AnonymousClass2());
                    }
                }
            } catch (Throwable th) {
                if (x.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/biz/a$b.class */
    public final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < a.this.b) {
                w.a().a(new b(), (a.this.b - currentTimeMillis) + 5000);
                return;
            }
            a.this.a(3, false, 0L);
            a.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/biz/a$c.class */
    public final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private long f35122a;

        public c(long j) {
            this.f35122a = com.anythink.expressad.d.a.b.aD;
            this.f35122a = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            w a2 = w.a();
            if (a2 != null) {
                a2.a(new AnonymousClass2());
            }
            a aVar2 = a.this;
            long j = this.f35122a;
            w.a().a(new c(j), j);
        }
    }

    public a(Context context, boolean z) {
        this.d = true;
        this.f35115a = context;
        this.d = z;
    }

    private static ContentValues a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (userInfoBean.f35113a > 0) {
                contentValues.put("_id", Long.valueOf(userInfoBean.f35113a));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f));
            contentValues.put(bl.e, Integer.valueOf(userInfoBean.b));
            contentValues.put("_pc", userInfoBean.f35114c);
            contentValues.put("_dt", z.a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (x.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
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
            UserInfoBean userInfoBean = (UserInfoBean) z.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f35113a = j;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (x.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    static /* synthetic */ void a(a aVar, UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> a2;
        if (userInfoBean != null) {
            if (!z && userInfoBean.b != 1 && (a2 = aVar.a(com.tencent.bugly.crashreport.common.info.a.a(aVar.f35115a).d)) != null && a2.size() >= 20) {
                x.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(a2.size()));
                return;
            }
            long a3 = p.a().a("t_ui", a(userInfoBean), (o) null, true);
            if (a3 >= 0) {
                x.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(a3));
                userInfoBean.f35113a = a3;
            }
        }
    }

    private static void a(List<UserInfoBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size() || i2 >= 50) {
                break;
            }
            sb.append(" or _id");
            sb.append(" = ");
            sb.append(list.get(i2).f35113a);
            i = i2 + 1;
        }
        String sb2 = sb.toString();
        String str = sb2;
        if (sb2.length() > 0) {
            str = sb2.substring(4);
        }
        sb.setLength(0);
        try {
            x.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(p.a().a("t_ui", str, (String[]) null, (o) null, true)));
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b3 A[Catch: all -> 0x0296, TryCatch #0 {, blocks: (B:4:0x0002, B:9:0x0010, B:14:0x001d, B:19:0x002a, B:21:0x0032, B:26:0x0044, B:28:0x0066, B:31:0x0079, B:35:0x008c, B:37:0x0097, B:39:0x00b7, B:42:0x00e9, B:44:0x0100, B:46:0x010b, B:48:0x0115, B:50:0x012d, B:52:0x0140, B:54:0x014c, B:56:0x015a, B:58:0x0163, B:60:0x016c, B:65:0x0182, B:68:0x01a9, B:70:0x01b3, B:73:0x01bc, B:76:0x01c9, B:80:0x01ee, B:82:0x01fb, B:85:0x0209, B:87:0x0215, B:90:0x0223, B:92:0x0236, B:95:0x0244, B:99:0x0273, B:102:0x0288, B:67:0x019d), top: B:117:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01fb A[Catch: all -> 0x0296, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:9:0x0010, B:14:0x001d, B:19:0x002a, B:21:0x0032, B:26:0x0044, B:28:0x0066, B:31:0x0079, B:35:0x008c, B:37:0x0097, B:39:0x00b7, B:42:0x00e9, B:44:0x0100, B:46:0x010b, B:48:0x0115, B:50:0x012d, B:52:0x0140, B:54:0x014c, B:56:0x015a, B:58:0x0163, B:60:0x016c, B:65:0x0182, B:68:0x01a9, B:70:0x01b3, B:73:0x01bc, B:76:0x01c9, B:80:0x01ee, B:82:0x01fb, B:85:0x0209, B:87:0x0215, B:90:0x0223, B:92:0x0236, B:95:0x0244, B:99:0x0273, B:102:0x0288, B:67:0x019d), top: B:117:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0209 A[Catch: all -> 0x0296, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:9:0x0010, B:14:0x001d, B:19:0x002a, B:21:0x0032, B:26:0x0044, B:28:0x0066, B:31:0x0079, B:35:0x008c, B:37:0x0097, B:39:0x00b7, B:42:0x00e9, B:44:0x0100, B:46:0x010b, B:48:0x0115, B:50:0x012d, B:52:0x0140, B:54:0x014c, B:56:0x015a, B:58:0x0163, B:60:0x016c, B:65:0x0182, B:68:0x01a9, B:70:0x01b3, B:73:0x01bc, B:76:0x01c9, B:80:0x01ee, B:82:0x01fb, B:85:0x0209, B:87:0x0215, B:90:0x0223, B:92:0x0236, B:95:0x0244, B:99:0x0273, B:102:0x0288, B:67:0x019d), top: B:117:0x0002 }] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c() {
        /*
            Method dump skipped, instructions count: 709
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.a.c():void");
    }

    /* JADX WARN: Finally extract failed */
    public final List<UserInfoBean> a(String str) {
        Cursor cursor;
        String str2;
        try {
            if (z.a(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursor = p.a().a("t_ui", null, str2, null, null, true);
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
                        sb.append(" or _id");
                        sb.append(" = ");
                        sb.append(j);
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    x.d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(p.a().a("t_ui", sb2.substring(4), (String[]) null, (o) null, true)));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!x.a(th)) {
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

    public final void a() {
        this.b = z.b() + 86400000;
        w.a().a(new b(), (this.b - System.currentTimeMillis()) + 5000);
    }

    public final void a(int i, boolean z, long j) {
        com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
        int i2 = 0;
        if (a2 != null && !a2.c().f && i != 1 && i != 3) {
            x.e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i == 1 || i == 3) {
            this.f35116c++;
        }
        com.tencent.bugly.crashreport.common.info.a a3 = com.tencent.bugly.crashreport.common.info.a.a(this.f35115a);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.b = i;
        userInfoBean.f35114c = a3.d;
        userInfoBean.d = a3.g();
        userInfoBean.e = System.currentTimeMillis();
        userInfoBean.f = -1L;
        userInfoBean.n = a3.k;
        if (i == 1) {
            i2 = 1;
        }
        userInfoBean.o = i2;
        userInfoBean.l = a3.a();
        userInfoBean.m = a3.q;
        userInfoBean.g = a3.r;
        userInfoBean.h = a3.s;
        userInfoBean.i = a3.t;
        userInfoBean.k = a3.u;
        userInfoBean.r = a3.t();
        userInfoBean.s = a3.y();
        userInfoBean.p = a3.z();
        userInfoBean.q = a3.A();
        w.a().a(new RunnableC0900a(userInfoBean, z), 0L);
    }

    public final void b() {
        w a2 = w.a();
        if (a2 != null) {
            a2.a(new AnonymousClass2());
        }
    }
}
