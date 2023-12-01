package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.push.ch;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/cj.class */
class cj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f41310a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ch.a f254a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ch.a aVar, Context context) {
        this.f254a = aVar;
        this.f41310a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        SQLiteDatabase sQLiteDatabase = null;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            try {
                SQLiteDatabase a2 = this.f254a.a();
                if (a2 != null && a2.isOpen()) {
                    a2.beginTransaction();
                    this.f254a.a(this.f41310a, a2);
                    sQLiteDatabase2 = a2;
                    sQLiteDatabase = a2;
                    a2.setTransactionSuccessful();
                }
                if (a2 != null) {
                    try {
                        a2.endTransaction();
                    } catch (Exception e) {
                        e = e;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        this.f254a.a(this.f41310a);
                    }
                }
                if (this.f254a.f245a != null) {
                    this.f254a.f245a.close();
                }
            } catch (Throwable th) {
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                        this.f254a.a(this.f41310a);
                        throw th;
                    }
                }
                if (this.f254a.f245a != null) {
                    this.f254a.f245a.close();
                }
                this.f254a.a(this.f41310a);
                throw th;
            }
        } catch (Exception e3) {
            sQLiteDatabase2 = sQLiteDatabase;
            com.xiaomi.channel.commonutils.logger.b.a(e3);
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e4) {
                    e = e4;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    this.f254a.a(this.f41310a);
                }
            }
            if (this.f254a.f245a != null) {
                this.f254a.f245a.close();
            }
        }
        this.f254a.a(this.f41310a);
    }
}
