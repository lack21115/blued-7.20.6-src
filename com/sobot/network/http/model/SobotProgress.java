package com.sobot.network.http.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.SystemClock;
import com.sobot.network.http.request.RequestCall;
import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/model/SobotProgress.class */
public class SobotProgress implements Serializable {
    public static final String CURRENT_SIZE = "currentSize";
    public static final String DATE = "date";
    public static final int ERROR = 4;
    public static final int FALSE = 0;
    public static final String FILE_NAME = "fileName";
    public static final String FILE_PATH = "filePath";
    public static final int FINISH = 5;
    public static final String FOLDER = "folder";
    public static final String FRACTION = "fraction";
    public static final String IS_UPLOAD = "isUpload";
    public static final int LOADING = 2;
    public static final int NONE = 0;
    public static final int PAUSE = 3;
    public static final String PRIORITY = "priority";
    private static final long REFRESH_TIME = 300;
    public static final String REQUEST = "request";
    public static final String STATUS = "status";
    public static final String TAG = "tag";
    public static final String TOTAL_SIZE = "totalSize";
    public static final int TRUE = 1;
    public static final String URL = "url";
    public static final int WAITING = 1;
    private static final long serialVersionUID = 6353658567594109891L;
    public long currentSize;
    public Throwable exception;
    public String fileName;
    public String filePath;
    public String folder;
    public float fraction;
    public boolean isUpload;
    public RequestCall request;
    public transient long speed;
    public int status;
    public String tag;
    private transient long tempSize;
    public String tmpTag;
    public String url;
    private transient long lastRefreshTime = SystemClock.elapsedRealtime();
    public long totalSize = -1;
    public int priority = 0;
    public long date = System.currentTimeMillis();

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/model/SobotProgress$Action.class */
    public interface Action {
        void call(SobotProgress sobotProgress);
    }

    public static ContentValues buildContentValues(SobotProgress sobotProgress) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("tag", sobotProgress.tag);
        contentValues.put(IS_UPLOAD, Boolean.valueOf(sobotProgress.isUpload));
        contentValues.put("url", sobotProgress.url);
        contentValues.put("folder", sobotProgress.folder);
        contentValues.put("filePath", sobotProgress.filePath);
        contentValues.put(FILE_NAME, sobotProgress.fileName);
        contentValues.put(FRACTION, Float.valueOf(sobotProgress.fraction));
        contentValues.put(TOTAL_SIZE, Long.valueOf(sobotProgress.totalSize));
        contentValues.put(CURRENT_SIZE, Long.valueOf(sobotProgress.currentSize));
        contentValues.put("status", Integer.valueOf(sobotProgress.status));
        contentValues.put("priority", Integer.valueOf(sobotProgress.priority));
        contentValues.put("date", Long.valueOf(sobotProgress.date));
        return contentValues;
    }

    public static ContentValues buildUpdateContentValues(SobotProgress sobotProgress) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FRACTION, Float.valueOf(sobotProgress.fraction));
        contentValues.put(TOTAL_SIZE, Long.valueOf(sobotProgress.totalSize));
        contentValues.put(CURRENT_SIZE, Long.valueOf(sobotProgress.currentSize));
        contentValues.put("status", Integer.valueOf(sobotProgress.status));
        contentValues.put("priority", Integer.valueOf(sobotProgress.priority));
        contentValues.put("date", Long.valueOf(sobotProgress.date));
        return contentValues;
    }

    public static SobotProgress changeProgress(SobotProgress sobotProgress, long j, long j2, Action action) {
        sobotProgress.totalSize = j2;
        sobotProgress.currentSize += j;
        sobotProgress.tempSize += j;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if ((elapsedRealtime - sobotProgress.lastRefreshTime >= 300) || sobotProgress.currentSize == j2) {
            long j3 = sobotProgress.lastRefreshTime;
            sobotProgress.fraction = (((float) sobotProgress.currentSize) * 1.0f) / ((float) j2);
            sobotProgress.lastRefreshTime = elapsedRealtime;
            sobotProgress.tempSize = 0L;
            if (action != null) {
                action.call(sobotProgress);
            }
        }
        return sobotProgress;
    }

    public static SobotProgress changeProgress(SobotProgress sobotProgress, long j, Action action) {
        return changeProgress(sobotProgress, j, sobotProgress.totalSize, action);
    }

    public static SobotProgress parseCursorToBean(Cursor cursor) {
        SobotProgress sobotProgress = new SobotProgress();
        sobotProgress.tag = cursor.getString(cursor.getColumnIndex("tag"));
        boolean z = true;
        if (1 != cursor.getInt(cursor.getColumnIndex(IS_UPLOAD))) {
            z = false;
        }
        sobotProgress.isUpload = z;
        sobotProgress.url = cursor.getString(cursor.getColumnIndex("url"));
        sobotProgress.folder = cursor.getString(cursor.getColumnIndex("folder"));
        sobotProgress.filePath = cursor.getString(cursor.getColumnIndex("filePath"));
        sobotProgress.fileName = cursor.getString(cursor.getColumnIndex(FILE_NAME));
        sobotProgress.fraction = cursor.getFloat(cursor.getColumnIndex(FRACTION));
        sobotProgress.totalSize = cursor.getLong(cursor.getColumnIndex(TOTAL_SIZE));
        sobotProgress.currentSize = cursor.getLong(cursor.getColumnIndex(CURRENT_SIZE));
        sobotProgress.status = cursor.getInt(cursor.getColumnIndex("status"));
        sobotProgress.priority = cursor.getInt(cursor.getColumnIndex("priority"));
        sobotProgress.date = cursor.getLong(cursor.getColumnIndex("date"));
        return sobotProgress;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.tag;
        String str2 = ((SobotProgress) obj).tag;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public void from(SobotProgress sobotProgress) {
        this.totalSize = sobotProgress.totalSize;
        this.currentSize = sobotProgress.currentSize;
        this.fraction = sobotProgress.fraction;
        this.speed = sobotProgress.speed;
        this.lastRefreshTime = sobotProgress.lastRefreshTime;
        this.tempSize = sobotProgress.tempSize;
    }

    public int hashCode() {
        String str = this.tag;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "Progress{fraction=" + this.fraction + ", totalSize=" + this.totalSize + ", currentSize=" + this.currentSize + ", speed=" + this.speed + ", status=" + this.status + ", priority=" + this.priority + ", folder=" + this.folder + ", filePath=" + this.filePath + ", fileName=" + this.fileName + ", tag=" + this.tag + ", url=" + this.url + '}';
    }
}
