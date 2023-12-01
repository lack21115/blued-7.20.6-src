package android.content;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* loaded from: source-9557208-dex2jar.jar:android/content/ContentQueryMap.class */
public class ContentQueryMap extends Observable {
    private String[] mColumnNames;
    private ContentObserver mContentObserver;
    private volatile Cursor mCursor;
    private Handler mHandlerForUpdateNotifications;
    private int mKeyColumn;
    private boolean mKeepUpdated = false;
    private Map<String, ContentValues> mValues = null;
    private boolean mDirty = false;

    public ContentQueryMap(Cursor cursor, String str, boolean z, Handler handler) {
        this.mHandlerForUpdateNotifications = null;
        this.mCursor = cursor;
        this.mColumnNames = this.mCursor.getColumnNames();
        this.mKeyColumn = this.mCursor.getColumnIndexOrThrow(str);
        this.mHandlerForUpdateNotifications = handler;
        setKeepUpdated(z);
        if (z) {
            return;
        }
        readCursorIntoCache(cursor);
    }

    private void readCursorIntoCache(Cursor cursor) {
        synchronized (this) {
            this.mValues = new HashMap(this.mValues != null ? this.mValues.size() : 0);
            while (cursor.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.mColumnNames.length) {
                        if (i2 != this.mKeyColumn) {
                            contentValues.put(this.mColumnNames[i2], cursor.getString(i2));
                        }
                        i = i2 + 1;
                    }
                }
                this.mValues.put(cursor.getString(this.mKeyColumn), contentValues);
            }
        }
    }

    public void close() {
        synchronized (this) {
            if (this.mContentObserver != null) {
                this.mCursor.unregisterContentObserver(this.mContentObserver);
                this.mContentObserver = null;
            }
            this.mCursor.close();
            this.mCursor = null;
        }
    }

    protected void finalize() throws Throwable {
        if (this.mCursor != null) {
            close();
        }
        super.finalize();
    }

    public Map<String, ContentValues> getRows() {
        Map<String, ContentValues> map;
        synchronized (this) {
            if (this.mDirty) {
                requery();
            }
            map = this.mValues;
        }
        return map;
    }

    public ContentValues getValues(String str) {
        ContentValues contentValues;
        synchronized (this) {
            if (this.mDirty) {
                requery();
            }
            contentValues = this.mValues.get(str);
        }
        return contentValues;
    }

    public void requery() {
        Cursor cursor = this.mCursor;
        if (cursor == null) {
            return;
        }
        this.mDirty = false;
        if (cursor.requery()) {
            readCursorIntoCache(cursor);
            setChanged();
            notifyObservers();
        }
    }

    public void setKeepUpdated(boolean z) {
        if (z == this.mKeepUpdated) {
            return;
        }
        this.mKeepUpdated = z;
        if (!this.mKeepUpdated) {
            this.mCursor.unregisterContentObserver(this.mContentObserver);
            this.mContentObserver = null;
            return;
        }
        if (this.mHandlerForUpdateNotifications == null) {
            this.mHandlerForUpdateNotifications = new Handler();
        }
        if (this.mContentObserver == null) {
            this.mContentObserver = new ContentObserver(this.mHandlerForUpdateNotifications) { // from class: android.content.ContentQueryMap.1
                @Override // android.database.ContentObserver
                public void onChange(boolean z2) {
                    if (ContentQueryMap.this.countObservers() != 0) {
                        ContentQueryMap.this.requery();
                    } else {
                        ContentQueryMap.this.mDirty = true;
                    }
                }
            };
        }
        this.mCursor.registerContentObserver(this.mContentObserver);
        this.mDirty = true;
    }
}
