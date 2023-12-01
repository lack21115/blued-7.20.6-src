package com.kwad.components.core.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.kwad.sdk.KsAdSDKImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/b/a.class */
public class a {
    private static volatile a HD;
    private final SQLiteDatabase HC;

    /* renamed from: com.kwad.components.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/b/a$a.class */
    static final class C0340a extends SQLiteOpenHelper {
        private static int HE = 1;
        private String HF;
        private String HG;

        public C0340a(Context context) {
            super(context, "ksadcache.db", null, HE);
            this.HF = "CREATE TABLE IF NOT EXISTS ksad_ad_cache (creativeId VARCHAR PRIMARY KEY NOT NULL, posId TEXT, adJson TEXT, ecpm INTEGER, playAgainJson TEXT, adSenseJson TEXT, createTime INTEGER, expireTime INTEGER)";
            this.HG = "CREATE TABLE IF NOT EXISTS ksad_ad_cache_strategy(posId VARCHAR PRIMARY KEY NOT NULL, cacheSize INTEGER, cacheSecond INTEGER, strategyCode INTEGER, enable INTEGER)";
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(this.HF);
            sQLiteDatabase.execSQL(this.HG);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    private a(Context context) {
        this.HC = new C0340a(context).getWritableDatabase();
    }

    private <T extends h> void b(List<T> list, String str) {
        try {
            try {
                this.HC.beginTransaction();
                for (T t : list) {
                    try {
                        long insertWithOnConflict = this.HC.insertWithOnConflict(str, null, t.mj(), 5);
                        com.kwad.sdk.core.d.b.d("AdCacheDBManager", "insertData: " + str + ", rowId: " + insertWithOnConflict);
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.b.printStackTrace(e);
                    }
                }
                this.HC.setTransactionSuccessful();
                SQLiteDatabase sQLiteDatabase = this.HC;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.b.printStackTrace(e2);
                    }
                }
            } catch (Exception e3) {
                com.kwad.sdk.core.d.b.printStackTrace(e3);
                SQLiteDatabase sQLiteDatabase2 = this.HC;
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Exception e4) {
                        com.kwad.sdk.core.d.b.printStackTrace(e4);
                    }
                }
            }
        } catch (Throwable th) {
            SQLiteDatabase sQLiteDatabase3 = this.HC;
            if (sQLiteDatabase3 != null) {
                try {
                    sQLiteDatabase3.endTransaction();
                } catch (Exception e5) {
                    com.kwad.sdk.core.d.b.printStackTrace(e5);
                }
            }
            throw th;
        }
    }

    public static a lW() {
        KsAdSDKImpl ksAdSDKImpl;
        if (HD == null) {
            synchronized (a.class) {
                try {
                    if (HD == null && (ksAdSDKImpl = KsAdSDKImpl.get()) != null) {
                        try {
                            HD = new a(ksAdSDKImpl.getContext());
                        } catch (SQLiteException e) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                            HD = null;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return HD;
    }

    public final void a(e eVar) {
        b(Collections.singletonList(eVar), "ksad_ad_cache_strategy");
    }

    public final e ah(String str) {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3;
        try {
            cursor2 = this.HC.rawQuery("select  * from ksad_ad_cache_strategy where posId=?", new String[]{str});
            cursor = cursor2;
        } catch (Exception e) {
            e = e;
            cursor2 = null;
        } catch (Throwable th) {
            th = th;
            cursor = null;
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            throw th;
        }
        try {
            try {
                List<e> a2 = e.a(cursor2);
                cursor3 = cursor2;
                if (a2 != null) {
                    cursor3 = cursor2;
                    if (a2.size() > 0) {
                        e eVar = a2.get(0);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor2);
                        return eVar;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = cursor2;
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            cursor3 = cursor2;
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor3);
            return null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursor3);
        return null;
    }

    public final List<g> b(String str, long j, int i) {
        Cursor cursor;
        Cursor rawQuery;
        Cursor cursor2 = null;
        try {
            rawQuery = this.HC.rawQuery("select  * from ksad_ad_cache where posId=? order by createTime desc", new String[]{str});
            cursor2 = rawQuery;
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th) {
            th = th;
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor2);
            throw th;
        }
        try {
            try {
                List<g> a2 = g.a(rawQuery);
                if (a2 == null) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(rawQuery);
                    return null;
                }
                StringBuilder sb = new StringBuilder("(posId = ");
                sb.append(str);
                sb.append(") AND (");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                for (g gVar : a2) {
                    int i3 = i2 + 1;
                    if (i3 <= i) {
                        i2 = i3;
                        if (gVar.mp() >= j) {
                            arrayList.add(gVar);
                            i2 = i3;
                        }
                    } else {
                        sb2.append(" creativeId = ");
                        sb2.append(gVar.mr());
                        sb2.append(i3 == a2.size() ? ")" : " OR");
                        i2 = i3;
                    }
                }
                if (i2 > i) {
                    this.HC.delete("ksad_ad_cache", sb2.toString(), new String[0]);
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(rawQuery);
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor2);
                throw th;
            }
        } catch (Exception e2) {
            cursor = rawQuery;
            e = e2;
            cursor2 = cursor;
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return null;
        }
    }

    public final void f(List<g> list) {
        b(list, "ksad_ad_cache");
    }

    public final void lX() {
        try {
            this.HC.delete("ksad_ad_cache", "expireTime<?", new String[]{String.valueOf(System.currentTimeMillis() / 1000)});
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
    }

    public final void m(long j) {
        try {
            int delete = this.HC.delete("ksad_ad_cache", "creativeId=?", new String[]{String.valueOf(j)});
            com.kwad.sdk.core.d.b.d("AdCacheDBManager", "deleteCachedAdByCreativeId result: " + delete);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
    }
}
