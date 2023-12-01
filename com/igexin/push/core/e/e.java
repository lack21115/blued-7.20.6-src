package com.igexin.push.core.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.push.core.b.l;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/e/e.class */
public class e implements a {
    private static final String b = "RALDataManager";

    /* renamed from: c  reason: collision with root package name */
    private static final int f9897c = 318;
    private static final int d = 300;
    private static volatile e e;

    /* renamed from: a  reason: collision with root package name */
    public final List<l> f9898a = new CopyOnWriteArrayList();

    /* renamed from: com.igexin.push.core.e.e$3  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/e/e$3.class */
    public final class AnonymousClass3 extends com.igexin.push.a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f9901a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ContentValues contentValues, long j) {
            super(contentValues);
            this.f9901a = j;
        }

        @Override // com.igexin.push.a.d
        public final void a_() throws Exception {
            this.d.update(com.igexin.push.core.b.X, this.h, "id=?", new String[]{String.valueOf(this.f9901a)});
        }
    }

    private e() {
    }

    private int a(byte b2) {
        int i = 0;
        for (l lVar : this.f9898a) {
            if (lVar.f9841c == b2) {
                i++;
            }
        }
        return i;
    }

    public static ContentValues a(l lVar) {
        if (lVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(lVar.f9840a));
        contentValues.put("data", com.igexin.c.b.a.b(lVar.b.getBytes()));
        contentValues.put("type", Byte.valueOf(lVar.f9841c));
        contentValues.put("time", Long.valueOf(lVar.d));
        contentValues.put("send_times", Integer.valueOf(lVar.e));
        return contentValues;
    }

    public static e a() {
        if (e == null) {
            synchronized (e.class) {
                try {
                    if (e == null) {
                        e = new e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }

    private boolean a(long j, long j2) {
        l a2 = a(j);
        if (a2 != null) {
            a2.d = j2;
            a2.e++;
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass3(a(a2), j), true, true);
            return true;
        }
        return false;
    }

    private List<l> b() {
        return this.f9898a;
    }

    private void b(byte b2) {
        l lVar;
        try {
            Iterator<l> it = this.f9898a.iterator();
            do {
                lVar = null;
                if (!it.hasNext()) {
                    break;
                }
                lVar = it.next();
            } while (lVar.f9841c != b2);
            if (lVar != null) {
                a(lVar.f9840a, true);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final l a(long j) {
        for (l lVar : this.f9898a) {
            if (lVar.f9840a == j) {
                return lVar;
            }
        }
        return null;
    }

    public final void a(final long j, boolean z) {
        l a2 = a(j);
        if (a2 != null) {
            this.f9898a.remove(a2);
        }
        com.igexin.c.a.b.e.a().a(new com.igexin.push.a.d(a(a2)) { // from class: com.igexin.push.core.e.e.2
            @Override // com.igexin.push.a.d
            public final void a_() throws Exception {
                this.d.delete(com.igexin.push.core.b.X, "id=?", new String[]{String.valueOf(j)});
            }
        }, z, !z);
    }

    @Override // com.igexin.push.core.e.a
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.igexin.push.core.e.a
    public final void b(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                Cursor query = sQLiteDatabase.query(com.igexin.push.core.b.X, new String[]{"id", "data", "type", "time", "send_times"}, null, null, null, null, null);
                long currentTimeMillis = System.currentTimeMillis();
                if (query != null) {
                    while (true) {
                        cursor2 = query;
                        cursor = query;
                        if (!query.moveToNext()) {
                            break;
                        }
                        long j = query.getLong(0);
                        byte b2 = (byte) query.getInt(2);
                        long j2 = query.getLong(3);
                        int i = query.getInt(4);
                        if ((j2 == 0 || currentTimeMillis - j2 <= 259200000) && i < com.igexin.push.config.d.N - 1) {
                            List<l> list = this.f9898a;
                            l lVar = new l(j, new String(com.igexin.c.b.a.c(query.getBlob(1))), b2, j2);
                            lVar.e = i;
                            list.add(lVar);
                        } else {
                            a(j, true);
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Throwable th) {
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final void b(final l lVar) {
        if (this.f9898a.size() < 318 || lVar.f9841c == 2 || lVar.f9841c == 7) {
            byte b2 = lVar.f9841c;
            if (b2 != 2) {
                if (b2 != 3) {
                    if (b2 != 5) {
                        if (b2 != 6) {
                            if (b2 != 7) {
                                if (b2 == 8 && a((byte) 8) >= 3) {
                                    return;
                                }
                            }
                        } else if (a((byte) 6) >= 10) {
                            return;
                        }
                    } else if (a((byte) 5) >= 3) {
                        return;
                    }
                } else if (a((byte) 3) >= 300) {
                    return;
                }
                this.f9898a.add(lVar);
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d(a(lVar)) { // from class: com.igexin.push.core.e.e.1
                    @Override // com.igexin.push.a.d
                    public final void a_() throws Exception {
                        this.d.replace(com.igexin.push.core.b.X, null, this.h);
                    }
                }, false, true);
            }
            b(lVar.f9841c);
            this.f9898a.add(lVar);
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.a.d(a(lVar)) { // from class: com.igexin.push.core.e.e.1
                @Override // com.igexin.push.a.d
                public final void a_() throws Exception {
                    this.d.replace(com.igexin.push.core.b.X, null, this.h);
                }
            }, false, true);
        }
    }

    @Override // com.igexin.push.core.e.a
    public final void c(SQLiteDatabase sQLiteDatabase) {
    }
}
