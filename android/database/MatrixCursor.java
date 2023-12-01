package android.database;

import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/database/MatrixCursor.class */
public class MatrixCursor extends AbstractCursor {
    private final int columnCount;
    private final String[] columnNames;
    private Object[] data;
    private int rowCount;

    /* loaded from: source-9557208-dex2jar.jar:android/database/MatrixCursor$RowBuilder.class */
    public class RowBuilder {
        private final int endIndex;
        private int index;
        private final int row;

        RowBuilder(int i) {
            this.row = i;
            this.index = MatrixCursor.this.columnCount * i;
            this.endIndex = this.index + MatrixCursor.this.columnCount;
        }

        public RowBuilder add(Object obj) {
            if (this.index == this.endIndex) {
                throw new CursorIndexOutOfBoundsException("No more columns left.");
            }
            Object[] objArr = MatrixCursor.this.data;
            int i = this.index;
            this.index = i + 1;
            objArr[i] = obj;
            return this;
        }

        public RowBuilder add(String str, Object obj) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= MatrixCursor.this.columnNames.length) {
                    return this;
                }
                if (str.equals(MatrixCursor.this.columnNames[i2])) {
                    MatrixCursor.this.data[(this.row * MatrixCursor.this.columnCount) + i2] = obj;
                }
                i = i2 + 1;
            }
        }
    }

    public MatrixCursor(String[] strArr) {
        this(strArr, 16);
    }

    public MatrixCursor(String[] strArr, int i) {
        this.rowCount = 0;
        this.columnNames = strArr;
        this.columnCount = strArr.length;
        this.data = new Object[this.columnCount * (i < 1 ? 1 : i)];
    }

    private void addRow(ArrayList<?> arrayList, int i) {
        int size = arrayList.size();
        if (size != this.columnCount) {
            throw new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.size() = " + size);
        }
        this.rowCount++;
        Object[] objArr = this.data;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            objArr[i + i3] = arrayList.get(i3);
            i2 = i3 + 1;
        }
    }

    private void ensureCapacity(int i) {
        if (i > this.data.length) {
            Object[] objArr = this.data;
            int length = this.data.length * 2;
            int i2 = length;
            if (length < i) {
                i2 = i;
            }
            this.data = new Object[i2];
            System.arraycopy(objArr, 0, this.data, 0, objArr.length);
        }
    }

    private Object get(int i) {
        if (i < 0 || i >= this.columnCount) {
            throw new CursorIndexOutOfBoundsException("Requested column: " + i + ", # of columns: " + this.columnCount);
        }
        if (this.mPos < 0) {
            throw new CursorIndexOutOfBoundsException("Before first row.");
        }
        if (this.mPos >= this.rowCount) {
            throw new CursorIndexOutOfBoundsException("After last row.");
        }
        return this.data[(this.mPos * this.columnCount) + i];
    }

    public void addRow(Iterable<?> iterable) {
        int i = this.rowCount * this.columnCount;
        int i2 = i + this.columnCount;
        ensureCapacity(i2);
        if (iterable instanceof ArrayList) {
            addRow((ArrayList) iterable, i);
            return;
        }
        Object[] objArr = this.data;
        for (Object obj : iterable) {
            if (i == i2) {
                throw new IllegalArgumentException("columnValues.size() > columnNames.length");
            }
            objArr[i] = obj;
            i++;
        }
        if (i != i2) {
            throw new IllegalArgumentException("columnValues.size() < columnNames.length");
        }
        this.rowCount++;
    }

    public void addRow(Object[] objArr) {
        if (objArr.length != this.columnCount) {
            throw new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.length = " + objArr.length);
        }
        int i = this.rowCount;
        this.rowCount = i + 1;
        int i2 = i * this.columnCount;
        ensureCapacity(this.columnCount + i2);
        System.arraycopy(objArr, 0, this.data, i2, this.columnCount);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public byte[] getBlob(int i) {
        return (byte[]) get(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return this.columnNames;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getCount() {
        return this.rowCount;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public double getDouble(int i) {
        Object obj = get(i);
        if (obj == null) {
            return 0.0d;
        }
        return obj instanceof Number ? ((Number) obj).doubleValue() : Double.parseDouble(obj.toString());
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public float getFloat(int i) {
        Object obj = get(i);
        if (obj == null) {
            return 0.0f;
        }
        return obj instanceof Number ? ((Number) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getInt(int i) {
        Object obj = get(i);
        if (obj == null) {
            return 0;
        }
        return obj instanceof Number ? ((Number) obj).intValue() : Integer.parseInt(obj.toString());
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public long getLong(int i) {
        Object obj = get(i);
        if (obj == null) {
            return 0L;
        }
        return obj instanceof Number ? ((Number) obj).longValue() : Long.parseLong(obj.toString());
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public short getShort(int i) {
        Object obj = get(i);
        if (obj == null) {
            return (short) 0;
        }
        return obj instanceof Number ? ((Number) obj).shortValue() : Short.parseShort(obj.toString());
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String getString(int i) {
        Object obj = get(i);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getType(int i) {
        return DatabaseUtils.getTypeOfObject(get(i));
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public boolean isNull(int i) {
        return get(i) == null;
    }

    public RowBuilder newRow() {
        int i = this.rowCount;
        this.rowCount = i + 1;
        ensureCapacity(this.rowCount * this.columnCount);
        return new RowBuilder(i);
    }
}
