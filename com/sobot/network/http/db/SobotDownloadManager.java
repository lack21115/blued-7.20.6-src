package com.sobot.network.http.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.sobot.network.http.model.SobotProgress;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/db/SobotDownloadManager.class */
public class SobotDownloadManager extends SobotBaseDao<SobotProgress> {
    private static SobotDownloadManager instance;

    private SobotDownloadManager() {
        super(new SobotDBHelper());
    }

    public static SobotDownloadManager getInstance() {
        if (instance == null) {
            synchronized (SobotDownloadManager.class) {
                try {
                    if (instance == null) {
                        instance = new SobotDownloadManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public boolean clear() {
        return deleteAll();
    }

    public void delete(String str) {
        delete("tag=?", new String[]{str});
    }

    public SobotProgress get(String str) {
        return queryOne("tag=?", new String[]{str});
    }

    public List<SobotProgress> getAll() {
        return query(null, null, null, null, null, "date ASC", null);
    }

    @Override // com.sobot.network.http.db.SobotBaseDao
    public ContentValues getContentValues(SobotProgress sobotProgress) {
        return SobotProgress.buildContentValues(sobotProgress);
    }

    public List<SobotProgress> getDownloading() {
        return query(null, "status not in(?) and isUpload=?", new String[]{"5", "0"}, null, null, "date ASC", null);
    }

    public List<SobotProgress> getFinished() {
        return query(null, "status=?", new String[]{"5"}, null, null, "date ASC", null);
    }

    @Override // com.sobot.network.http.db.SobotBaseDao
    public String getTableName() {
        return "fileCache";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sobot.network.http.db.SobotBaseDao
    public SobotProgress parseCursorToBean(Cursor cursor) {
        return SobotProgress.parseCursorToBean(cursor);
    }

    @Override // com.sobot.network.http.db.SobotBaseDao
    public void unInit() {
    }

    public boolean update(ContentValues contentValues, String str) {
        return update(contentValues, "tag=?", new String[]{str});
    }

    public boolean update(SobotProgress sobotProgress) {
        return update((SobotDownloadManager) sobotProgress, "tag=?", new String[]{sobotProgress.tag});
    }

    public void updateDownloading2None() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 0);
        update(contentValues, "status not in(?,?) and isUpload=?", new String[]{"5", "0", "0"});
    }
}
