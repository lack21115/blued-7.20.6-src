package com.sobot.network.http.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sobot.network.apiUtils.SobotHttpGlobalContext;
import com.sobot.network.http.model.SobotProgress;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/db/SobotDBHelper.class */
class SobotDBHelper extends SQLiteOpenHelper {
    private static final String DB_CACHE_NAME = "sobot.db";
    private static final int DB_CACHE_VERSION = 1;
    static final String TABLE_FILECACHE = "fileCache";
    static final Lock lock = new ReentrantLock();
    private StTableEntity fileCacheTableEntity;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SobotDBHelper() {
        this(SobotHttpGlobalContext.getAppContext());
    }

    SobotDBHelper(Context context) {
        super(context, DB_CACHE_NAME, null, 1);
        StTableEntity stTableEntity = new StTableEntity(TABLE_FILECACHE);
        this.fileCacheTableEntity = stTableEntity;
        stTableEntity.addColumn(new StColumnEntity("tag", "VARCHAR", true, true)).addColumn(new StColumnEntity("url", "VARCHAR")).addColumn(new StColumnEntity(SobotProgress.IS_UPLOAD, "INTEGER")).addColumn(new StColumnEntity("folder", "VARCHAR")).addColumn(new StColumnEntity("filePath", "VARCHAR")).addColumn(new StColumnEntity(SobotProgress.FILE_NAME, "VARCHAR")).addColumn(new StColumnEntity(SobotProgress.FRACTION, "VARCHAR")).addColumn(new StColumnEntity(SobotProgress.TOTAL_SIZE, "INTEGER")).addColumn(new StColumnEntity(SobotProgress.CURRENT_SIZE, "INTEGER")).addColumn(new StColumnEntity("status", "INTEGER")).addColumn(new StColumnEntity("priority", "INTEGER")).addColumn(new StColumnEntity("date", "INTEGER"));
    }

    private void onFirstCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.fileCacheTableEntity.buildTableString());
    }

    private void upgradeDB(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        onFirstCreate(sQLiteDatabase);
        onUpgrade(sQLiteDatabase, 1, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.beginTransaction();
        while (i < i2) {
            try {
                try {
                    upgradeDB(sQLiteDatabase, i, i2);
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
        sQLiteDatabase.setTransactionSuccessful();
    }
}
