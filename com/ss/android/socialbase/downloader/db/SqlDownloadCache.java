package com.ss.android.socialbase.downloader.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/db/SqlDownloadCache.class */
public class SqlDownloadCache extends ISqlDownloadCacheAidl.Stub implements ISqlDownloadCache {
    private static volatile SQLiteDatabase database;
    private volatile boolean cacheSynced;
    ISqlCacheLoadCompleteCallbackAidl callback;
    private TableStatements chunkTableStatements;
    private TableStatements downloadTableStatements;
    private TableStatements segmentTableStatements;

    public SqlDownloadCache() {
        this(false);
    }

    public SqlDownloadCache(boolean z) {
        this.callback = null;
        if (z) {
            this.cacheSynced = false;
            init();
        }
    }

    private void addDownloadInfo(final DownloadInfo downloadInfo) {
        ensureDataBaseInit();
        if (database == null || this.downloadTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.insertDownloadInfoInner(downloadInfo, SqlDownloadCache.this.downloadTableStatements.getInsertStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAntiHijackDirIfNeeded(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        try {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    DownloadUtils.clearAntiHijackDir(downloadInfo);
                }
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDataInSubThread() {
        synchronized (this) {
            safeBeginTransaction();
            database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, null, null);
            database.delete(DBDefinition.CHUNK_TABLE_NAME, null, null);
            database.setTransactionSuccessful();
            safeEndTransaction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteInner(int i, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i);
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureDataBaseInit() {
        if (database == null) {
            synchronized (SqlDownloadCache.class) {
                try {
                    if (database == null) {
                        database = DownloadDBHelper.getInstance().getWritableDatabase();
                        this.downloadTableStatements = new TableStatements(database, DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.DOWNLOAD_ALL_COLUMNS, DBDefinition.DOWNLOAD_PK_COLUMNS);
                        this.chunkTableStatements = new TableStatements(database, DBDefinition.CHUNK_TABLE_NAME, DBDefinition.CHUNK_ALL_COLUMNS, DBDefinition.CHUNK_PK_COLUMNS);
                        this.segmentTableStatements = new TableStatements(database, DBDefinition.SEGMENT_TABLE_NAME, DBDefinition.SEGMENT_ALL_COLUMNS, DBDefinition.SEGMENT_PK_COLUMNS);
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertDownloadChunkInner(DownloadChunk downloadChunk, SQLiteStatement sQLiteStatement) {
        if (downloadChunk == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadChunk.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertDownloadInfoInner(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadCacheFromDB(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<DownloadChunk>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || database == null) {
            return;
        }
        synchronized (database) {
            safeBeginTransaction();
            if (!list.isEmpty()) {
                if (DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_CLEAR_INVALID_TASK_ERROR)) {
                    String[] strArr = new String[list.size()];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            break;
                        }
                        strArr[i2] = String.valueOf(list.get(i2));
                        i = i2 + 1;
                    }
                    String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("��", "?,") + "?)";
                    database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, str, strArr);
                    database.delete(DBDefinition.CHUNK_TABLE_NAME, str, strArr);
                } else {
                    String join = TextUtils.join(", ", list2);
                    database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, "_id IN (?)", new String[]{join});
                    database.delete(DBDefinition.CHUNK_TABLE_NAME, "_id IN (?)", new String[]{join});
                }
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size) {
                    break;
                }
                int keyAt = sparseArray.keyAt(i4);
                DownloadInfo downloadInfo = sparseArray.get(keyAt);
                database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, "_id = ?", new String[]{String.valueOf(keyAt)});
                database.insert(DBDefinition.DOWNLOAD_TABLE_NAME, null, downloadInfo.toContentValues());
                if (downloadInfo.getChunkCount() > 1) {
                    List<DownloadChunk> downloadChunk = getDownloadChunk(keyAt);
                    if (downloadChunk.size() > 0) {
                        database.delete(DBDefinition.CHUNK_TABLE_NAME, "_id = ?", new String[]{String.valueOf(keyAt)});
                        for (DownloadChunk downloadChunk2 : downloadChunk) {
                            downloadChunk2.setId(downloadInfo.getId());
                            database.insert(DBDefinition.CHUNK_TABLE_NAME, null, downloadChunk2.toContentValues());
                        }
                    }
                }
                i3 = i4 + 1;
            }
            if (sparseArray2 != null && sparseArray3 != null) {
                int size2 = sparseArray2.size();
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= size2) {
                        break;
                    }
                    int id = sparseArray2.valueAt(i6).getId();
                    List<DownloadChunk> parseHostChunkList = DownloadUtils.parseHostChunkList(getDownloadChunk(id));
                    if (parseHostChunkList != null && parseHostChunkList.size() > 0) {
                        sparseArray3.put(id, parseHostChunkList);
                    }
                    i5 = i6 + 1;
                }
            }
            database.setTransactionSuccessful();
            safeEndTransaction();
        }
    }

    private void safeBeginTransaction() {
        database.beginTransaction();
    }

    private void safeEndTransaction() {
        try {
            if (database == null || !database.inTransaction()) {
                return;
            }
            database.endTransaction();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void update(final int i, final ContentValues contentValues) {
        ensureDataBaseInit();
        if (database == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.11
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.updateInner(i, contentValues);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDownloadChunkInner(int i, int i2, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBDefinition.CUR_OFFSET, Long.valueOf(j));
                database.update(DBDefinition.CHUNK_TABLE_NAME, contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDownloadInfoForCurrentThread(DownloadInfo downloadInfo) {
        synchronized (this) {
            if (downloadInfo == null) {
                return;
            }
            try {
                if (!cacheExist(downloadInfo.getId())) {
                    addDownloadInfo(downloadInfo);
                } else if (this.downloadTableStatements == null) {
                } else {
                    updateDownloadInfoInner(downloadInfo, this.downloadTableStatements.getUpdateStatement());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void updateDownloadInfoInner(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.bindLong(downloadInfo.getBindValueCount() + 1, downloadInfo.getId());
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInner(int i, ContentValues contentValues) {
        int i2 = 10;
        while (database.isDbLockedByCurrentThread()) {
            try {
                i2--;
                if (i2 < 0) {
                    break;
                }
                Thread.sleep(5L);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        database.update(DBDefinition.DOWNLOAD_TABLE_NAME, contentValues, "_id = ? ", new String[]{String.valueOf(i)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSubDownloadChunkIndexInner(int i, int i2, int i3, int i4, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBDefinition.CHUNK_INDEX, Integer.valueOf(i4));
                database.update(DBDefinition.CHUNK_TABLE_NAME, contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSubDownloadChunkInner(int i, int i2, int i3, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBDefinition.CUR_OFFSET, Long.valueOf(j));
                database.update(DBDefinition.CHUNK_TABLE_NAME, contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskCancel(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-4));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskCompleted(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-3));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j));
        contentValues.put(DBDefinition.FIRST_DOWNLOAD, (Integer) 0);
        contentValues.put(DBDefinition.FIRST_SUCCESS, (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskConnected(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 3);
        contentValues.put(DBDefinition.TOTAL_BYTES, Long.valueOf(j));
        contentValues.put(DBDefinition.ETAG, str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("name", str2);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskError(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j));
        if (j > 0) {
            contentValues.put(DBDefinition.FIRST_DOWNLOAD, (Integer) 0);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskIntercept(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-7));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskPause(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-2));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskPrepare(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskProgress(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskRetry(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 5);
        contentValues.put(DBDefinition.FIRST_DOWNLOAD, (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void addDownloadChunk(final DownloadChunk downloadChunk) {
        ensureDataBaseInit();
        if (database == null || this.chunkTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.insertDownloadChunkInner(downloadChunk, SqlDownloadCache.this.chunkTableStatements.getInsertStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void addSubDownloadChunk(DownloadChunk downloadChunk) {
        addDownloadChunk(downloadChunk);
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean cacheExist(int i) {
        boolean z = false;
        try {
            if (getDownloadInfo(i) != null) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void clearData() {
        ensureDataBaseInit();
        if (database == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.10
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.clearDataInSubThread();
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean ensureDownloadCacheSyncSuccess() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getAllDownloadInfo() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadChunk> getDownloadChunk(int i) {
        ArrayList arrayList = new ArrayList();
        ensureDataBaseInit();
        if (database == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            Cursor rawQuery = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", DBDefinition.CHUNK_TABLE_NAME, "_id"), new String[]{Integer.toString(i)});
            while (true) {
                cursor = rawQuery;
                if (!rawQuery.moveToNext()) {
                    DownloadUtils.safeClose(rawQuery);
                    return arrayList;
                }
                arrayList.add(new DownloadChunk(rawQuery));
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                DownloadUtils.safeClose(cursor);
                return arrayList;
            } catch (Throwable th2) {
                DownloadUtils.safeClose(cursor);
                throw th2;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo getDownloadInfo(int i) {
        Cursor cursor;
        ensureDataBaseInit();
        if (database == null) {
            return null;
        }
        try {
            cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", DBDefinition.DOWNLOAD_TABLE_NAME, "_id"), new String[]{Integer.toString(i)});
            try {
                if (!cursor.moveToNext()) {
                    DownloadUtils.safeClose(cursor);
                    return null;
                }
                DownloadInfo downloadInfo = new DownloadInfo(cursor);
                DownloadUtils.safeClose(cursor);
                return downloadInfo;
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    DownloadUtils.safeClose(cursor);
                    return null;
                } catch (Throwable th2) {
                    DownloadUtils.safeClose(cursor);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getDownloadInfoList(String str) {
        ensureDataBaseInit();
        ArrayList arrayList = new ArrayList();
        if (database != null) {
            Cursor cursor = null;
            try {
                Cursor rawQuery = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", DBDefinition.DOWNLOAD_TABLE_NAME, "url"), new String[]{str});
                if (rawQuery.moveToNext()) {
                    cursor = rawQuery;
                    arrayList.add(new DownloadInfo(rawQuery));
                }
                DownloadUtils.safeClose(rawQuery);
                return arrayList;
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    DownloadUtils.safeClose(cursor);
                    return arrayList;
                } catch (Throwable th2) {
                    DownloadUtils.safeClose(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int i) {
        Cursor cursor;
        Cursor rawQuery;
        ensureDataBaseInit();
        if (database == null) {
            return null;
        }
        try {
            rawQuery = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", DBDefinition.SEGMENT_TABLE_NAME, "_id"), new String[]{Integer.toString(i)});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
            if (!rawQuery.moveToNext()) {
                DownloadUtils.safeClose(rawQuery);
                return null;
            }
            int columnIndex = rawQuery.getColumnIndex("info");
            String string = columnIndex >= 0 ? rawQuery.getString(columnIndex) : null;
            HashMap hashMap = new HashMap();
            JSONArray jSONArray = new JSONArray(string);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= jSONArray.length()) {
                    DownloadUtils.safeClose(rawQuery);
                    return hashMap;
                }
                Segment segment = new Segment(jSONArray.getJSONObject(i3));
                hashMap.put(Long.valueOf(segment.getStartOffset()), segment);
                i2 = i3 + 1;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = rawQuery;
            try {
                th.printStackTrace();
                DownloadUtils.safeClose(cursor);
                return null;
            } catch (Throwable th3) {
                DownloadUtils.safeClose(cursor);
                throw th3;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public ArrayList<Segment> getSegments(int i) {
        Map<Long, Segment> segmentMap = getSegmentMap(i);
        if (segmentMap == null || segmentMap.isEmpty()) {
            return null;
        }
        return new ArrayList<>(segmentMap.values());
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void init() {
        init(new SparseArray<>(), new SparseArray<>(), null);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public void init(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<DownloadChunk>> sparseArray2, final SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback) {
        try {
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.1
                /* JADX WARN: Code restructure failed: missing block: B:129:0x02f3, code lost:
                    if (r13 != null) goto L145;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:134:0x0308, code lost:
                    if (r13 == null) goto L143;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:135:0x030b, code lost:
                    r13.callback();
                    r7.this$0.cacheSynced = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:136:0x031b, code lost:
                    r7.this$0.onInitFinish(r5, r6);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:137:0x032a, code lost:
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:177:0x0468, code lost:
                    if (r13 == null) goto L143;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:182:0x047d, code lost:
                    if (r13 == null) goto L143;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:222:0x05bb, code lost:
                    if (r13 == null) goto L246;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:227:0x05d0, code lost:
                    if (r13 == null) goto L246;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:228:0x05d3, code lost:
                    r13.callback();
                    r7.this$0.cacheSynced = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:229:0x05e3, code lost:
                    r7.this$0.onInitFinish(r5, r6);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:230:0x05f4, code lost:
                    throw r14;
                 */
                /* JADX WARN: Removed duplicated region for block: B:257:0x0195 A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:258:0x0170 A[SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 1587
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.db.SqlDownloadCache.AnonymousClass1.run():void");
                }
            };
            ExecutorService dBThreadExecutorService = DownloadComponentManager.getDBThreadExecutorService();
            if (dBThreadExecutorService != null) {
                dBThreadExecutorService.execute(runnable);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean isDownloadCacheSyncSuccess() {
        return this.cacheSynced;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo onDownloadTaskStart(int i) {
        return null;
    }

    public void onInitFinish(SparseArray<DownloadInfo> sparseArray, SparseArray<List<DownloadChunk>> sparseArray2) {
        try {
            HashMap sparseArrayToHashMap = DownloadUtils.sparseArrayToHashMap(sparseArray);
            HashMap sparseArrayToHashMap2 = DownloadUtils.sparseArrayToHashMap(sparseArray2);
            if (this.callback != null) {
                this.callback.callback(sparseArrayToHashMap, sparseArrayToHashMap2);
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void removeAllDownloadChunk(final int i) {
        ensureDataBaseInit();
        if (database == null || this.chunkTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.deleteInner(i, SqlDownloadCache.this.chunkTableStatements.getDeleteStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean removeDownloadInfo(int i) {
        TableStatements tableStatements;
        ensureDataBaseInit();
        if (database == null || (tableStatements = this.downloadTableStatements) == null) {
            return false;
        }
        try {
            deleteInner(i, tableStatements.getDeleteStatement());
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean removeDownloadTaskData(final int i) {
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.9
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.removeDownloadInfo(i);
                SqlDownloadCache.this.removeAllDownloadChunk(i);
                SqlDownloadCache.this.removeSegments(i);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int i) {
        ensureDataBaseInit();
        if (database == null) {
            return;
        }
        try {
            deleteInner(i, this.segmentTableStatements.getDeleteStatement());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl) {
        this.callback = iSqlCacheLoadCompleteCallbackAidl;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void syncDownloadChunks(int i, List<DownloadChunk> list) {
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void syncDownloadInfoFromOtherCache(int i, List<DownloadChunk> list) {
        try {
            removeAllDownloadChunk(i);
            if (list != null) {
                for (DownloadChunk downloadChunk : list) {
                    if (downloadChunk != null) {
                        addDownloadChunk(downloadChunk);
                        if (downloadChunk.hasChunkDivided()) {
                            for (DownloadChunk downloadChunk2 : downloadChunk.getSubChunkList()) {
                                addDownloadChunk(downloadChunk2);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo updateChunkCount(int i, int i2) {
        ensureDataBaseInit();
        if (database == null) {
            return null;
        }
        int i3 = 10;
        while (database.isDbLockedByCurrentThread()) {
            try {
                i3--;
                if (i3 < 0) {
                    break;
                }
                Thread.sleep(5L);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBDefinition.CHUNK_COUNT, Integer.valueOf(i2));
        database.update(DBDefinition.DOWNLOAD_TABLE_NAME, contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void updateDownloadChunk(final int i, final int i2, final long j) {
        ensureDataBaseInit();
        if (i == 0 || i2 < 0 || j < 0 || database == null || this.chunkTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.updateDownloadChunkInner(i, i2, j, SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean updateDownloadInfo(final DownloadInfo downloadInfo) {
        ensureDataBaseInit();
        if (downloadInfo == null || database == null) {
            return false;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.8
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.updateDownloadInfoForCurrentThread(downloadInfo);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int i, Map<Long, Segment> map) {
        long currentTimeMillis = System.currentTimeMillis();
        ensureDataBaseInit();
        if (database == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Long l : map.keySet()) {
                jSONArray.put(map.get(Long.valueOf(l.longValue())).toJson());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Log.d("SqlDownloadCache", "json=" + jSONArray);
        SQLiteStatement insertOrReplaceStatement = this.segmentTableStatements.getInsertOrReplaceStatement();
        synchronized (insertOrReplaceStatement) {
            insertOrReplaceStatement.clearBindings();
            insertOrReplaceStatement.bindLong(1, i);
            insertOrReplaceStatement.bindString(2, jSONArray.toString());
            insertOrReplaceStatement.execute();
        }
        Logger.d("SqlDownloadCache", "updateSegments cost=" + DownloadUtils.cost(currentTimeMillis));
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void updateSubDownloadChunk(final int i, final int i2, final int i3, final long j) {
        ensureDataBaseInit();
        if (i == 0 || i2 < 0 || i3 < 0 || j < 0 || database == null || this.chunkTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.updateSubDownloadChunkInner(i, i2, i3, j, SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void updateSubDownloadChunkIndex(final int i, final int i2, final int i3, final int i4) {
        ensureDataBaseInit();
        if (i == 0 || i3 < 0 || i4 == i2 || i4 < 0 || database == null || this.chunkTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.updateSubDownloadChunkIndexInner(i, i2, i3, i4, SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
