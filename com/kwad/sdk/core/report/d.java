package com.kwad.sdk.core.report;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/d.class */
public abstract class d implements n<f> {
    protected c aih;

    public d(c cVar) {
        a(cVar);
    }

    private void a(c cVar) {
        this.aih = cVar;
    }

    private void c(f fVar) {
        synchronized (this) {
            String tag = getTag();
            com.kwad.sdk.core.d.b.d(tag, "deleteAction action = " + fVar);
            try {
                this.aih.getReadableDatabase().delete(wU(), "actionId=?", new String[]{fVar.actionId});
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTrace(e);
            }
        }
    }

    @Override // com.kwad.sdk.core.report.n
    /* renamed from: b */
    public final void e(f fVar) {
        synchronized (this) {
            String tag = getTag();
            com.kwad.sdk.core.d.b.d(tag, "write = " + fVar);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("actionId", fVar.actionId);
                contentValues.put("aLog", fVar.toJson().toString());
                try {
                    this.aih.getReadableDatabase().insert(wU(), null, contentValues);
                } catch (Exception e) {
                    com.kwad.sdk.core.d.b.printStackTrace(e);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
    }

    protected abstract f e(Cursor cursor);

    protected abstract String getTag();

    @Override // com.kwad.sdk.core.report.n
    public final void o(List<f> list) {
        synchronized (this) {
            com.kwad.sdk.core.d.b.d(getTag(), "delete size= " + list.size());
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase readableDatabase = this.aih.getReadableDatabase();
                readableDatabase.beginTransaction();
                for (f fVar : list) {
                    c(fVar);
                }
                sQLiteDatabase = readableDatabase;
                readableDatabase.setTransactionSuccessful();
                if (readableDatabase != null) {
                    try {
                        readableDatabase.endTransaction();
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.b.printStackTrace(e);
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e3) {
                        com.kwad.sdk.core.d.b.printStackTrace(e3);
                    }
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.report.n
    public final long size() {
        long j;
        synchronized (this) {
            Cursor cursor = null;
            try {
                SQLiteDatabase readableDatabase = this.aih.getReadableDatabase();
                StringBuilder sb = new StringBuilder("select count(*) from ");
                sb.append(wU());
                Cursor rawQuery = readableDatabase.rawQuery(sb.toString(), null);
                rawQuery.moveToFirst();
                cursor = rawQuery;
                j = rawQuery.getLong(0);
                com.kwad.sdk.crash.utils.b.closeQuietly(rawQuery);
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                j = 0;
            }
        }
        return j;
    }

    protected abstract String wU();

    @Override // com.kwad.sdk.core.report.n
    public final List<f> wV() {
        synchronized (this) {
            Cursor cursor = null;
            try {
                SQLiteDatabase readableDatabase = this.aih.getReadableDatabase();
                StringBuilder sb = new StringBuilder("select  * from ");
                sb.append(wU());
                Cursor rawQuery = readableDatabase.rawQuery(sb.toString(), null);
                cursor = rawQuery;
                if (rawQuery != null) {
                    ArrayList arrayList = new ArrayList();
                    while (rawQuery.moveToNext()) {
                        try {
                            arrayList.add(e(rawQuery));
                        } catch (Exception e) {
                            com.kwad.sdk.core.d.b.printStackTrace(e);
                        }
                    }
                    String tag = getTag();
                    StringBuilder sb2 = new StringBuilder("read size= ");
                    sb2.append(arrayList.size());
                    com.kwad.sdk.core.d.b.d(tag, sb2.toString());
                    Iterator it = arrayList.iterator();
                    while (true) {
                        cursor = rawQuery;
                        if (!it.hasNext()) {
                            com.kwad.sdk.crash.utils.b.closeQuietly(rawQuery);
                            return arrayList;
                        }
                        f fVar = (f) it.next();
                        String tag2 = getTag();
                        StringBuilder sb3 = new StringBuilder("read action=");
                        sb3.append(fVar);
                        com.kwad.sdk.core.d.b.d(tag2, sb3.toString());
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return new ArrayList();
        }
    }
}
