package android.database;

/* loaded from: source-9557208-dex2jar.jar:android/database/MergeCursor.class */
public class MergeCursor extends AbstractCursor {
    private Cursor mCursor;
    private Cursor[] mCursors;
    private DataSetObserver mObserver = new DataSetObserver() { // from class: android.database.MergeCursor.1
        @Override // android.database.DataSetObserver
        public void onChanged() {
            MergeCursor.this.mPos = -1;
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            MergeCursor.this.mPos = -1;
        }
    };

    public MergeCursor(Cursor[] cursorArr) {
        this.mCursors = cursorArr;
        this.mCursor = cursorArr[0];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mCursors.length) {
                return;
            }
            if (this.mCursors[i2] != null) {
                this.mCursors[i2].registerDataSetObserver(this.mObserver);
            }
            i = i2 + 1;
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        int length = this.mCursors.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                super.close();
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
                super.deactivate();
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
        return this.mCursor != null ? this.mCursor.getColumnNames() : new String[0];
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

    @Override // android.database.AbstractCursor, android.database.CrossProcessCursor
    public boolean onMove(int i, int i2) {
        this.mCursor = null;
        int i3 = 0;
        int length = this.mCursors.length;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length) {
                break;
            }
            if (this.mCursors[i5] != null) {
                if (i2 < this.mCursors[i5].getCount() + i3) {
                    this.mCursor = this.mCursors[i5];
                    break;
                }
                i3 += this.mCursors[i5].getCount();
            }
            i4 = i5 + 1;
        }
        if (this.mCursor != null) {
            return this.mCursor.moveToPosition(i2 - i3);
        }
        return false;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        int length = this.mCursors.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            if (this.mCursors[i2] != null) {
                this.mCursors[i2].registerContentObserver(contentObserver);
            }
            i = i2 + 1;
        }
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
    public void unregisterContentObserver(ContentObserver contentObserver) {
        int length = this.mCursors.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            if (this.mCursors[i2] != null) {
                this.mCursors[i2].unregisterContentObserver(contentObserver);
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
