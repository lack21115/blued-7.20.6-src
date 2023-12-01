package com.android.internal.database;

import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.DataSetObserver;
import java.lang.reflect.Array;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/database/SortCursor.class */
public class SortCursor extends AbstractCursor {
    private static final String TAG = "SortCursor";
    private int[][] mCurRowNumCache;
    private Cursor mCursor;
    private Cursor[] mCursors;
    private int[] mSortColumns;
    private final int ROWCACHESIZE = 64;
    private int[] mRowNumCache = new int[64];
    private int[] mCursorCache = new int[64];
    private int mLastCacheHit = -1;
    private DataSetObserver mObserver = new DataSetObserver() { // from class: com.android.internal.database.SortCursor.1
        @Override // android.database.DataSetObserver
        public void onChanged() {
            SortCursor.this.mPos = -1;
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            SortCursor.this.mPos = -1;
        }
    };

    public SortCursor(Cursor[] cursorArr, String str) {
        this.mCursors = cursorArr;
        int length = this.mCursors.length;
        this.mSortColumns = new int[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            if (this.mCursors[i2] != null) {
                this.mCursors[i2].registerDataSetObserver(this.mObserver);
                this.mCursors[i2].moveToFirst();
                this.mSortColumns[i2] = this.mCursors[i2].getColumnIndexOrThrow(str);
            }
            i = i2 + 1;
        }
        this.mCursor = null;
        String str2 = "";
        int i3 = 0;
        while (i3 < length) {
            String str3 = str2;
            if (this.mCursors[i3] != null) {
                if (this.mCursors[i3].isAfterLast()) {
                    str3 = str2;
                } else {
                    String string = this.mCursors[i3].getString(this.mSortColumns[i3]);
                    if (this.mCursor != null) {
                        str3 = str2;
                        if (string.compareToIgnoreCase(str2) >= 0) {
                        }
                    }
                    str3 = string;
                    this.mCursor = this.mCursors[i3];
                }
            }
            i3++;
            str2 = str3;
        }
        int length2 = this.mRowNumCache.length;
        while (true) {
            int i4 = length2 - 1;
            if (i4 < 0) {
                this.mCurRowNumCache = (int[][]) Array.newInstance(Integer.TYPE, 64, length);
                return;
            } else {
                this.mRowNumCache[i4] = -2;
                length2 = i4;
            }
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        int length = this.mCursors.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            if (this.mCursors[i2] != null) {
                this.mCursors[i2].close();
            }
            i = i2 + 1;
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public void deactivate() {
        int length = this.mCursors.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            if (this.mCursors[i2] != null) {
                this.mCursors[i2].deactivate();
            }
            i = i2 + 1;
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public byte[] getBlob(int i) {
        return this.mCursor.getBlob(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        if (this.mCursor != null) {
            return this.mCursor.getColumnNames();
        }
        int length = this.mCursors.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                throw new IllegalStateException("No cursor that can return names");
            }
            if (this.mCursors[i2] != null) {
                return this.mCursors[i2].getColumnNames();
            }
            i = i2 + 1;
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getCount() {
        int i = 0;
        int length = this.mCursors.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i;
            if (this.mCursors[i2] != null) {
                i3 = i + this.mCursors[i2].getCount();
            }
            i2++;
            i = i3;
        }
        return i;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public double getDouble(int i) {
        return this.mCursor.getDouble(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public float getFloat(int i) {
        return this.mCursor.getFloat(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getInt(int i) {
        return this.mCursor.getInt(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public long getLong(int i) {
        return this.mCursor.getLong(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public short getShort(int i) {
        return this.mCursor.getShort(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String getString(int i) {
        return this.mCursor.getString(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getType(int i) {
        return this.mCursor.getType(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public boolean isNull(int i) {
        return this.mCursor.isNull(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (r6 == (-1)) goto L76;
     */
    @Override // android.database.AbstractCursor, android.database.CrossProcessCursor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onMove(int r6, int r7) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.database.SortCursor.onMove(int, int):boolean");
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        int length = this.mCursors.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            if (this.mCursors[i2] != null) {
                this.mCursors[i2].registerDataSetObserver(dataSetObserver);
            }
            i = i2 + 1;
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public boolean requery() {
        int length = this.mCursors.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (this.mCursors[i2] != null && !this.mCursors[i2].requery()) {
                return false;
            }
            i = i2 + 1;
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        int length = this.mCursors.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            if (this.mCursors[i2] != null) {
                this.mCursors[i2].unregisterDataSetObserver(dataSetObserver);
            }
            i = i2 + 1;
        }
    }
}
