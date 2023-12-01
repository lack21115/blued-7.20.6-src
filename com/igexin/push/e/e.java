package com.igexin.push.e;

import android.database.Cursor;
import com.igexin.push.core.d;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/e.class */
public class e implements com.igexin.push.e.b.c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f10009a;
    private String b = "ReDisplayTask";

    /* renamed from: c  reason: collision with root package name */
    private volatile long f10010c = 0;

    public static e c() {
        if (f10009a == null) {
            synchronized (e.class) {
                try {
                    if (f10009a == null) {
                        f10009a = new e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10009a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f5, code lost:
        if (r13 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.PriorityQueue<com.igexin.push.core.b.j> e() {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.e.e.e():java.util.PriorityQueue");
    }

    @Override // com.igexin.push.e.b.c
    public final void a() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new d() { // from class: com.igexin.push.e.e.1
            /* JADX WARN: Removed duplicated region for block: B:35:0x00c8 A[SYNTHETIC] */
            @Override // com.igexin.push.e.d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            protected final void b() {
                /*
                    Method dump skipped, instructions count: 298
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.e.e.AnonymousClass1.b():void");
            }
        }, true);
    }

    @Override // com.igexin.push.e.b.c
    public final void a(long j) {
    }

    @Override // com.igexin.push.e.b.c
    public final boolean b() {
        boolean z = System.currentTimeMillis() / 1000 >= this.f10010c;
        com.igexin.c.a.c.a.a(this.b + " | ReDisplayTask isMatch =" + z + "， nextReDisplayTime =" + this.f10010c, new Object[0]);
        return z;
    }

    public final void d() {
        Cursor cursor = null;
        try {
            Cursor a2 = d.a.f9866a.i.a("message", new String[0], "status = '1' and notify_status = '1' and redisplay_freq != '0' and redisplay_num <= redisplay_freq  order by expect_redisplay_time asc limit 1");
            if (a2 != null && a2.getCount() == 1 && a2.moveToFirst()) {
                this.f10010c = a2.getLong(a2.getColumnIndex("expect_redisplay_time"));
            } else {
                this.f10010c = Long.MAX_VALUE;
            }
            cursor = a2;
            System.currentTimeMillis();
            if (a2 != null) {
                a2.close();
            }
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                com.igexin.c.a.c.a.b(this.b, " get next redisplay message fail" + th.toString());
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th2) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        }
    }
}
