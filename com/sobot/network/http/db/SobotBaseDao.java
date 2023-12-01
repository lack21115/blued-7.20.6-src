package com.sobot.network.http.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/db/SobotBaseDao.class */
public abstract class SobotBaseDao<T> {
    protected static String TAG;
    private static final boolean isDebug = false;
    protected SQLiteDatabase database;
    protected SQLiteOpenHelper helper;
    protected Lock lock;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/db/SobotBaseDao$Action.class */
    public interface Action {
        void call(SQLiteDatabase sQLiteDatabase);
    }

    public SobotBaseDao(SQLiteOpenHelper sQLiteOpenHelper) {
        TAG = getClass().getSimpleName();
        this.lock = SobotDBHelper.lock;
        this.helper = sQLiteOpenHelper;
        this.database = openWriter();
    }

    protected final void closeDatabase(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        sQLiteDatabase.close();
    }

    public long delete(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        return sQLiteDatabase.delete(getTableName(), str, strArr);
    }

    public boolean delete(String str, String[] strArr) {
        if (this.database == null) {
            return false;
        }
        System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.delete(getTableName(), str, strArr);
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Exception e) {
            this.database.endTransaction();
            this.lock.unlock();
            return false;
        } catch (Throwable th) {
            this.database.endTransaction();
            this.lock.unlock();
            throw th;
        }
    }

    public long deleteAll(SQLiteDatabase sQLiteDatabase) {
        return delete(sQLiteDatabase, null, null);
    }

    public boolean deleteAll() {
        return delete(null, null);
    }

    public boolean deleteList(List<Pair<String, String[]>> list) {
        if (this.database == null) {
            return false;
        }
        System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            for (Pair<String, String[]> pair : list) {
                this.database.delete(getTableName(), pair.first, pair.second);
            }
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Exception e) {
            this.database.endTransaction();
            this.lock.unlock();
            return false;
        } catch (Throwable th) {
            this.database.endTransaction();
            this.lock.unlock();
            throw th;
        }
    }

    public abstract ContentValues getContentValues(T t);

    public abstract String getTableName();

    public long insert(SQLiteDatabase sQLiteDatabase, T t) {
        return sQLiteDatabase.insert(getTableName(), null, getContentValues(t));
    }

    public boolean insert(SQLiteDatabase sQLiteDatabase, List<T> list) {
        try {
            for (T t : list) {
                sQLiteDatabase.insert(getTableName(), null, getContentValues(t));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean insert(T t) {
        if (t == null || this.database == null) {
            return false;
        }
        System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.insert(getTableName(), null, getContentValues(t));
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Exception e) {
            this.database.endTransaction();
            this.lock.unlock();
            return false;
        } catch (Throwable th) {
            this.database.endTransaction();
            this.lock.unlock();
            throw th;
        }
    }

    public boolean insert(List<T> list) {
        if (list == null || this.database == null) {
            return false;
        }
        System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            for (T t : list) {
                this.database.insert(getTableName(), null, getContentValues(t));
            }
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Exception e) {
            this.database.endTransaction();
            this.lock.unlock();
            return false;
        } catch (Throwable th) {
            this.database.endTransaction();
            this.lock.unlock();
            throw th;
        }
    }

    public SQLiteDatabase openWriter() {
        try {
            return this.helper.getWritableDatabase();
        } catch (Exception e) {
            return null;
        }
    }

    public abstract T parseCursorToBean(Cursor cursor);

    public List<T> query(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        return query(sQLiteDatabase, null, str, strArr, null, null, null, null);
    }

    public List<T> query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        Cursor cursor;
        Cursor cursor2;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = sQLiteDatabase.query(getTableName(), strArr, str, strArr2, str2, str3, str4, str5);
            while (true) {
                cursor2 = cursor;
                try {
                    if (!cursor.isClosed()) {
                        cursor2 = cursor;
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        arrayList.add(parseCursorToBean(cursor));
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    cursor2 = cursor;
                } catch (Throwable th) {
                    th = th;
                    closeDatabase(null, cursor);
                    throw th;
                }
            }
        } catch (Exception e2) {
            cursor2 = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        closeDatabase(null, cursor2);
        return arrayList;
    }

    public List<T> query(String str, String[] strArr) {
        return query(null, str, strArr, null, null, null, null);
    }

    public List<T> query(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        Cursor cursor;
        if (this.database == null) {
            return new ArrayList();
        }
        System.currentTimeMillis();
        this.lock.lock();
        ArrayList arrayList = new ArrayList();
        try {
            this.database.beginTransaction();
            cursor = this.database.query(getTableName(), strArr, str, strArr2, str2, str3, str4, str5);
            while (!cursor.isClosed() && cursor.moveToNext()) {
                try {
                    arrayList.add(parseCursorToBean(cursor));
                } catch (Exception e) {
                } catch (Throwable th) {
                    th = th;
                    closeDatabase(null, cursor);
                    this.database.endTransaction();
                    this.lock.unlock();
                    throw th;
                }
            }
            this.database.setTransactionSuccessful();
        } catch (Exception e2) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        closeDatabase(null, cursor);
        this.database.endTransaction();
        this.lock.unlock();
        return arrayList;
    }

    public List<T> queryAll() {
        return query(null, null);
    }

    public List<T> queryAll(SQLiteDatabase sQLiteDatabase) {
        return query(sQLiteDatabase, null, null);
    }

    public T queryOne(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        List<T> query = query(sQLiteDatabase, null, str, strArr, null, null, null, "1");
        if (query.size() > 0) {
            return query.get(0);
        }
        return null;
    }

    public T queryOne(String str, String[] strArr) {
        System.currentTimeMillis();
        List<T> query = query(null, str, strArr, null, null, null, "1");
        if (query.size() > 0) {
            return query.get(0);
        }
        return null;
    }

    public long replace(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return sQLiteDatabase.replace(getTableName(), null, contentValues);
    }

    public long replace(SQLiteDatabase sQLiteDatabase, T t) {
        return sQLiteDatabase.replace(getTableName(), null, getContentValues(t));
    }

    public boolean replace(ContentValues contentValues) {
        if (this.database == null) {
            return false;
        }
        System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.replace(getTableName(), null, contentValues);
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Exception e) {
            this.database.endTransaction();
            this.lock.unlock();
            return false;
        } catch (Throwable th) {
            this.database.endTransaction();
            this.lock.unlock();
            throw th;
        }
    }

    public boolean replace(SQLiteDatabase sQLiteDatabase, List<T> list) {
        try {
            for (T t : list) {
                sQLiteDatabase.replace(getTableName(), null, getContentValues(t));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean replace(T t) {
        if (t == null || this.database == null) {
            return false;
        }
        System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.replace(getTableName(), null, getContentValues(t));
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Exception e) {
            this.database.endTransaction();
            this.lock.unlock();
            return false;
        } catch (Throwable th) {
            this.database.endTransaction();
            this.lock.unlock();
            throw th;
        }
    }

    public boolean replace(List<T> list) {
        if (list == null || this.database == null) {
            return false;
        }
        System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            for (T t : list) {
                this.database.replace(getTableName(), null, getContentValues(t));
            }
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Exception e) {
            this.database.endTransaction();
            this.lock.unlock();
            return false;
        } catch (Throwable th) {
            this.database.endTransaction();
            this.lock.unlock();
            throw th;
        }
    }

    public void startTransaction(Action action) {
        if (this.database == null) {
            return;
        }
        this.lock.lock();
        try {
            this.database.beginTransaction();
            action.call(this.database);
            this.database.setTransactionSuccessful();
        } catch (Exception e) {
        } catch (Throwable th) {
            this.database.endTransaction();
            this.lock.unlock();
            throw th;
        }
        this.database.endTransaction();
        this.lock.unlock();
    }

    public abstract void unInit();

    public long update(SQLiteDatabase sQLiteDatabase, ContentValues contentValues, String str, String[] strArr) {
        return sQLiteDatabase.update(getTableName(), contentValues, str, strArr);
    }

    public long update(SQLiteDatabase sQLiteDatabase, T t, String str, String[] strArr) {
        return sQLiteDatabase.update(getTableName(), getContentValues(t), str, strArr);
    }

    public boolean update(ContentValues contentValues, String str, String[] strArr) {
        if (this.database == null) {
            return false;
        }
        System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.update(getTableName(), contentValues, str, strArr);
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Exception e) {
            this.database.endTransaction();
            this.lock.unlock();
            return false;
        } catch (Throwable th) {
            this.database.endTransaction();
            this.lock.unlock();
            throw th;
        }
    }

    public boolean update(T t, String str, String[] strArr) {
        if (t == null || this.database == null) {
            return false;
        }
        System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.update(getTableName(), getContentValues(t), str, strArr);
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Exception e) {
            this.database.endTransaction();
            this.lock.unlock();
            return false;
        } catch (Throwable th) {
            this.database.endTransaction();
            this.lock.unlock();
            throw th;
        }
    }
}
