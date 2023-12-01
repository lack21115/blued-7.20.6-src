package com.kwai.filedownloader.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.net.http.Headers;
import android.text.TextUtils;
import android.util.SparseArray;
import com.cdo.oaps.ad.OapsWrapper;
import com.kwai.filedownloader.a.a;
import com.kwai.filedownloader.e.f;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/a/d.class */
public final class d implements com.kwai.filedownloader.a.a {
    private static boolean aGE = false;
    private SQLiteDatabase aGD;

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/a/d$a.class */
    public final class a implements a.InterfaceC0414a {
        private final SparseArray<com.kwai.filedownloader.c.c> aGF;
        private b aGG;
        private final SparseArray<com.kwai.filedownloader.c.c> aGt;
        private final SparseArray<List<com.kwai.filedownloader.c.a>> aGu;

        a(d dVar) {
            this(null, null);
        }

        a(SparseArray<com.kwai.filedownloader.c.c> sparseArray, SparseArray<List<com.kwai.filedownloader.c.a>> sparseArray2) {
            this.aGF = new SparseArray<>();
            this.aGt = sparseArray;
            this.aGu = sparseArray2;
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0414a
        public final void Hy() {
            b bVar = this.aGG;
            if (bVar != null) {
                bVar.Hy();
            }
            if (d.this.aGD == null) {
                return;
            }
            int size = this.aGF.size();
            try {
                if (size < 0) {
                    return;
                }
                try {
                    d.this.aGD.beginTransaction();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= size) {
                            break;
                        }
                        int keyAt = this.aGF.keyAt(i2);
                        com.kwai.filedownloader.c.c cVar = this.aGF.get(keyAt);
                        d.this.aGD.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(keyAt)});
                        d.this.aGD.insert("ksad_file_download", null, cVar.Iz());
                        if (cVar.ID() > 1) {
                            List<com.kwai.filedownloader.c.a> cJ = d.this.cJ(keyAt);
                            if (cJ.size() > 0) {
                                d.this.aGD.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(keyAt)});
                                for (com.kwai.filedownloader.c.a aVar : cJ) {
                                    aVar.setId(cVar.getId());
                                    d.this.aGD.insert("ksad_file_download_connection", null, aVar.Iz());
                                }
                            }
                        }
                        i = i2 + 1;
                    }
                    if (this.aGt != null && this.aGu != null) {
                        synchronized (this.aGt) {
                            int size2 = this.aGt.size();
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= size2) {
                                    break;
                                }
                                int id = this.aGt.valueAt(i4).getId();
                                List<com.kwai.filedownloader.c.a> cJ2 = d.this.cJ(id);
                                if (cJ2 != null && cJ2.size() > 0) {
                                    synchronized (this.aGu) {
                                        this.aGu.put(id, cJ2);
                                    }
                                }
                                i3 = i4 + 1;
                            }
                        }
                    }
                    d.this.aGD.setTransactionSuccessful();
                    if (d.this.aGD != null) {
                        try {
                            d.this.aGD.endTransaction();
                        } catch (Exception e) {
                            d.printStackTrace(e);
                        }
                    }
                } catch (SQLiteException e2) {
                    d.this.a(e2);
                    if (d.this.aGD != null) {
                        try {
                            d.this.aGD.endTransaction();
                        } catch (Exception e3) {
                            d.printStackTrace(e3);
                        }
                    }
                } catch (Exception e4) {
                    d.printStackTrace(e4);
                    if (d.this.aGD != null) {
                        try {
                            d.this.aGD.endTransaction();
                        } catch (Exception e5) {
                            d.printStackTrace(e5);
                        }
                    }
                }
            } catch (Throwable th) {
                if (d.this.aGD != null) {
                    try {
                        d.this.aGD.endTransaction();
                    } catch (Exception e6) {
                        d.printStackTrace(e6);
                    }
                }
                throw th;
            }
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0414a
        public final void a(int i, com.kwai.filedownloader.c.c cVar) {
            this.aGF.put(i, cVar);
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0414a
        public final void c(com.kwai.filedownloader.c.c cVar) {
            SparseArray<com.kwai.filedownloader.c.c> sparseArray = this.aGt;
            if (sparseArray != null) {
                synchronized (sparseArray) {
                    this.aGt.put(cVar.getId(), cVar);
                }
            }
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwai.filedownloader.c.c> iterator() {
            b bVar = new b();
            this.aGG = bVar;
            return bVar;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/a/d$b.class */
    final class b implements Iterator<com.kwai.filedownloader.c.c> {
        private Cursor aGI;
        private final List<Integer> aGJ = new ArrayList();
        private int aGK;

        b() {
            if (d.this.aGD != null) {
                try {
                    this.aGI = d.this.aGD.rawQuery("SELECT * FROM ksad_file_download", null);
                } catch (SQLiteException e) {
                    d.this.a(e);
                } catch (Exception e2) {
                    d.printStackTrace(e2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Iterator
        /* renamed from: Hz */
        public com.kwai.filedownloader.c.c next() {
            com.kwai.filedownloader.c.c j = d.j(this.aGI);
            this.aGK = j.getId();
            return j;
        }

        final void Hy() {
            Cursor cursor;
            if (d.this.aGD == null || (cursor = this.aGI) == null) {
                return;
            }
            cursor.close();
            if (this.aGJ.isEmpty()) {
                return;
            }
            String join = TextUtils.join(", ", this.aGJ);
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "delete %s", join);
            }
            try {
                d.this.aGD.execSQL(f.j("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", "_id", join));
                d.this.aGD.execSQL(f.j("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", join));
            } catch (SQLiteException e) {
                d.this.a(e);
            } catch (Exception e2) {
                d.printStackTrace(e2);
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            boolean z = false;
            try {
                if (this.aGI != null) {
                    z = this.aGI.moveToNext();
                }
                return z;
            } catch (Throwable th) {
                d.printStackTrace(th);
                return false;
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.aGJ.add(Integer.valueOf(this.aGK));
        }
    }

    public d() {
        try {
            this.aGD = new e(com.kwai.filedownloader.e.c.IZ()).getWritableDatabase();
        } catch (SQLiteException e) {
            a(e);
        }
    }

    private void a(int i, ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabase = this.aGD;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.update("ksad_file_download", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
            } catch (SQLiteException e) {
                a(i, e);
            } catch (Exception e2) {
                printStackTrace(e2);
            }
        }
    }

    private void a(int i, SQLiteException sQLiteException) {
        if (!(sQLiteException instanceof SQLiteFullException)) {
            printStackTrace(sQLiteException);
            return;
        }
        if (i != -1) {
            cL(i);
            cK(i);
        }
        o(sQLiteException);
        aGE = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SQLiteException sQLiteException) {
        a(-1, sQLiteException);
    }

    private void d(com.kwai.filedownloader.c.c cVar) {
        SQLiteDatabase sQLiteDatabase = this.aGD;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.insert("ksad_file_download", null, cVar.Iz());
            } catch (SQLiteException e) {
                cVar.fw(e.toString());
                cVar.e((byte) -1);
                a(cVar.getId(), e);
            } catch (Exception e2) {
                printStackTrace(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.kwai.filedownloader.c.c j(Cursor cursor) {
        com.kwai.filedownloader.c.c cVar = new com.kwai.filedownloader.c.c();
        if (cursor == null) {
            return cVar;
        }
        cVar.setId(cursor.getInt(cursor.getColumnIndex("_id")));
        cVar.setUrl(cursor.getString(cursor.getColumnIndex("url")));
        String string = cursor.getString(cursor.getColumnIndex(OapsWrapper.KEY_PATH));
        boolean z = true;
        if (cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) != 1) {
            z = false;
        }
        cVar.g(string, z);
        cVar.e((byte) cursor.getShort(cursor.getColumnIndex("status")));
        cVar.ao(cursor.getLong(cursor.getColumnIndex("sofar")));
        cVar.aq(cursor.getLong(cursor.getColumnIndex("total")));
        cVar.fw(cursor.getString(cursor.getColumnIndex("errMsg")));
        cVar.fv(cursor.getString(cursor.getColumnIndex(Headers.ETAG)));
        cVar.fx(cursor.getString(cursor.getColumnIndex(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME)));
        cVar.db(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return cVar;
    }

    private static void o(Throwable th) {
        if (th != null) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printStackTrace(Throwable th) {
        o(th);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void A(int i, int i2) {
        if (this.aGD == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i2));
        try {
            this.aGD.update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final a.InterfaceC0414a Hx() {
        return new a(this);
    }

    public final a.InterfaceC0414a a(SparseArray<com.kwai.filedownloader.c.c> sparseArray, SparseArray<List<com.kwai.filedownloader.c.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, int i2, long j) {
        if (this.aGD == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j));
        try {
            this.aGD.update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 2);
        contentValues.put("total", Long.valueOf(j));
        contentValues.put(Headers.ETAG, str);
        contentValues.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME, str2);
        a(i, contentValues);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, String str, long j, long j2, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j));
        contentValues.put("total", Long.valueOf(j2));
        contentValues.put(Headers.ETAG, str);
        contentValues.put("connectionCount", Integer.valueOf(i2));
        a(i, contentValues);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) 5);
        a(i, contentValues);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, Throwable th, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) -1);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(com.kwai.filedownloader.c.a aVar) {
        SQLiteDatabase sQLiteDatabase;
        if (aVar == null || (sQLiteDatabase = this.aGD) == null) {
            return;
        }
        try {
            sQLiteDatabase.insert("ksad_file_download_connection", null, aVar.Iz());
        } catch (SQLiteException e) {
            a(aVar.getId(), e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void b(com.kwai.filedownloader.c.c cVar) {
        if (this.aGD == null) {
            return;
        }
        if (cVar == null) {
            com.kwai.filedownloader.e.d.h(this, "update but model == null!", new Object[0]);
        } else if (cI(cVar.getId()) == null) {
            d(cVar);
        } else {
            try {
                this.aGD.update("ksad_file_download", cVar.Iz(), "_id = ? ", new String[]{String.valueOf(cVar.getId())});
            } catch (SQLiteException e) {
                cVar.fw(e.toString());
                cVar.e((byte) -1);
                a(cVar.getId(), e);
            } catch (Exception e2) {
                printStackTrace(e2);
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cH(int i) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final com.kwai.filedownloader.c.c cI(int i) {
        Cursor cursor;
        Cursor cursor2;
        SQLiteDatabase sQLiteDatabase = this.aGD;
        try {
            if (sQLiteDatabase == null) {
                return null;
            }
            try {
                cursor = sQLiteDatabase.rawQuery(f.j("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", "_id"), new String[]{Integer.toString(i)});
                cursor2 = cursor;
            } catch (SQLiteException e) {
                e = e;
                cursor = null;
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                throw th;
            }
            try {
                if (cursor.moveToNext()) {
                    com.kwai.filedownloader.c.c j = j(cursor);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return j;
                }
            } catch (SQLiteException e3) {
                e = e3;
                a(i, e);
                cursor2 = cursor;
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor2);
                return null;
            } catch (Exception e4) {
                e = e4;
                printStackTrace(e);
                cursor2 = cursor;
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor2);
                return null;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor2);
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final List<com.kwai.filedownloader.c.a> cJ(int i) {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.aGD;
        if (sQLiteDatabase == null) {
            return arrayList;
        }
        Cursor cursor2 = null;
        Cursor cursor3 = null;
        Cursor cursor4 = null;
        try {
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery(f.j("SELECT * FROM %s WHERE %s = ?", "ksad_file_download_connection", "id"), new String[]{Integer.toString(i)});
                while (true) {
                    cursor4 = rawQuery;
                    cursor2 = rawQuery;
                    cursor3 = rawQuery;
                    cursor = rawQuery;
                    if (!rawQuery.moveToNext()) {
                        break;
                    }
                    com.kwai.filedownloader.c.a aVar = new com.kwai.filedownloader.c.a();
                    aVar.setId(i);
                    aVar.setIndex(rawQuery.getInt(rawQuery.getColumnIndex("connectionIndex")));
                    aVar.setStartOffset(rawQuery.getLong(rawQuery.getColumnIndex(DBDefinition.START_OFFSET)));
                    aVar.am(rawQuery.getLong(rawQuery.getColumnIndex("currentOffset")));
                    aVar.an(rawQuery.getLong(rawQuery.getColumnIndex(DBDefinition.END_OFFSET)));
                    arrayList.add(aVar);
                }
            } catch (SQLiteException e) {
                a(i, e);
                cursor = cursor3;
            } catch (Exception e2) {
                printStackTrace(e2);
                cursor = cursor2;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return arrayList;
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor4);
            throw th;
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cK(int i) {
        SQLiteDatabase sQLiteDatabase = this.aGD;
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i);
        } catch (SQLiteException e) {
            printStackTrace(e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final boolean cL(int i) {
        SQLiteDatabase sQLiteDatabase = this.aGD;
        if (sQLiteDatabase == null) {
            return false;
        }
        try {
            return sQLiteDatabase.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i)}) != 0;
        } catch (SQLiteException | Exception e) {
            printStackTrace(e);
            return false;
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cM(int i) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void clear() {
        SQLiteDatabase sQLiteDatabase = this.aGD;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.delete("ksad_file_download", null, null);
            } catch (SQLiteException e) {
                a(e);
            }
            try {
                this.aGD.delete("ksad_file_download_connection", null, null);
            } catch (SQLiteException e2) {
                a(e2);
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void e(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 3);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void f(int i, long j) {
        cL(i);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void g(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) -2);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }
}
