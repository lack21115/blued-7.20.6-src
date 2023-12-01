package com.huawei.hms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.common.sqlite.HMSCursorWrapper;
import com.huawei.hms.support.log.HMSLog;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/data/DataHolder.class */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    private static final String TAG = "DataHolder";
    public static final String TYPE_BOOLEAN = "type_boolean";
    public static final String TYPE_BYTE_ARRAY = "type_byte_array";
    public static final String TYPE_DOUBLE = "type_double";
    public static final String TYPE_FLOAT = "type_float";
    public static final String TYPE_INT = "type_int";
    public static final String TYPE_LONG = "type_long";
    public static final String TYPE_STRING = "type_string";
    private String[] columns;
    private Bundle columnsBundle;
    private CursorWindow[] cursorWindows;
    private int dataCount;
    private boolean isInstance;
    private boolean mClosed;
    private Bundle metadata;
    private int[] perCursorCounts;
    private int statusCode;
    private int version;
    public static final Parcelable.Creator<DataHolder> CREATOR = new DataHolderCreator();
    private static final Builder BUILDER = new DataHolderBuilderCreator(new String[0], null);

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/data/DataHolder$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String[] f22638a;
        private final ArrayList<HashMap<String, Object>> b;

        /* renamed from: c  reason: collision with root package name */
        private final String f22639c;
        private final HashMap<Object, Integer> d;

        private Builder(String[] strArr, String str) {
            Preconditions.checkNotNull(strArr, "builderColumnsP cannot be null");
            this.f22638a = strArr;
            this.b = new ArrayList<>();
            this.f22639c = str;
            this.d = new HashMap<>();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(String[] strArr, String str, DataHolderBuilderCreator dataHolderBuilderCreator) {
            this(strArr, null);
        }

        public DataHolder build(int i) {
            return new DataHolder(this, i, (Bundle) null);
        }

        public DataHolder build(int i, Bundle bundle) {
            return new DataHolder(this, i, bundle, -1);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x006d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.huawei.hms.common.data.DataHolder.Builder setDataForContentValuesHashMap(java.util.HashMap<java.lang.String, java.lang.Object> r5) {
            /*
                r4 = this;
                r0 = r5
                java.lang.String r1 = "contentValuesHashMap cannot be null"
                java.lang.Object r0 = com.huawei.hms.common.internal.Preconditions.checkNotNull(r0, r1)
                r0 = r4
                java.lang.String r0 = r0.f22639c
                r8 = r0
                r0 = 0
                r7 = r0
                r0 = r8
                if (r0 == 0) goto L53
                r0 = r5
                r1 = r8
                java.lang.Object r0 = r0.get(r1)
                r8 = r0
                r0 = r8
                if (r0 == 0) goto L53
                r0 = r4
                java.util.HashMap<java.lang.Object, java.lang.Integer> r0 = r0.d
                r1 = r8
                java.lang.Object r0 = r0.get(r1)
                java.lang.Integer r0 = (java.lang.Integer) r0
                r9 = r0
                r0 = r9
                if (r0 == 0) goto L3f
                r0 = r9
                int r0 = r0.intValue()
                r6 = r0
                r0 = 1
                r7 = r0
                goto L55
            L3f:
                r0 = r4
                java.util.HashMap<java.lang.Object, java.lang.Integer> r0 = r0.d
                r1 = r8
                r2 = r4
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r2 = r2.b
                int r2 = r2.size()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                java.lang.Object r0 = r0.put(r1, r2)
            L53:
                r0 = 0
                r6 = r0
            L55:
                r0 = r7
                if (r0 == 0) goto L6d
                r0 = r4
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r0 = r0.b
                r1 = r6
                java.lang.Object r0 = r0.remove(r1)
                r0 = r4
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r0 = r0.b
                r1 = r6
                r2 = r5
                r0.add(r1, r2)
                r0 = r4
                return r0
            L6d:
                r0 = r4
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r0 = r0.b
                r1 = r5
                boolean r0 = r0.add(r1)
                r0 = r4
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.data.DataHolder.Builder.setDataForContentValuesHashMap(java.util.HashMap):com.huawei.hms.common.data.DataHolder$Builder");
        }

        public Builder withRow(ContentValues contentValues) {
            Preconditions.checkNotNull(contentValues, "contentValues cannot be null");
            HashMap<String, Object> hashMap = new HashMap<>(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return setDataForContentValuesHashMap(hashMap);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/data/DataHolder$DataHolderException.class */
    public static class DataHolderException extends RuntimeException {
        public DataHolderException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.isInstance = true;
        this.version = i;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i2;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    public DataHolder(Cursor cursor, int i, Bundle bundle) {
        this(new HMSCursorWrapper(cursor), i, bundle);
    }

    private DataHolder(Builder builder, int i, Bundle bundle) {
        this(builder.f22638a, getCursorWindows(builder, -1), i, (Bundle) null);
    }

    private DataHolder(Builder builder, int i, Bundle bundle, int i2) {
        this(builder.f22638a, getCursorWindows(builder, -1), i, bundle);
    }

    private DataHolder(HMSCursorWrapper hMSCursorWrapper, int i, Bundle bundle) {
        this(hMSCursorWrapper.getColumnNames(), getCursorWindows(hMSCursorWrapper), i, bundle);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        Preconditions.checkNotNull(strArr, "columnsP cannot be null");
        Preconditions.checkNotNull(cursorWindowArr, "cursorWindowP cannot be null");
        this.mClosed = false;
        this.isInstance = true;
        this.version = 1;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    public static Builder builder(String[] strArr) {
        return new Builder(strArr, (String) null);
    }

    private void checkAvailable(String str, int i) {
        String str2;
        Bundle bundle = this.columnsBundle;
        if (bundle == null || !bundle.containsKey(str)) {
            str2 = "cannot find column: " + str;
        } else if (isClosed()) {
            str2 = "buffer has been closed";
        } else if (i < 0 || i >= this.dataCount) {
            str2 = "row is out of index:" + i;
        } else {
            str2 = "";
        }
        Preconditions.checkArgument(str2.isEmpty(), str2);
    }

    public static DataHolder empty(int i) {
        return new DataHolder(BUILDER, i, (Bundle) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
        if (r7 >= r6.b.size()) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.database.CursorWindow[] getCursorWindows(com.huawei.hms.common.data.DataHolder.Builder r6, int r7) {
        /*
            r0 = r6
            java.lang.String[] r0 = com.huawei.hms.common.data.DataHolder.Builder.a(r0)
            int r0 = r0.length
            if (r0 != 0) goto Ld
            r0 = 0
            android.database.CursorWindow[] r0 = new android.database.CursorWindow[r0]
            return r0
        Ld:
            r0 = r7
            if (r0 < 0) goto L1e
            r0 = r7
            r8 = r0
            r0 = r7
            r1 = r6
            java.util.ArrayList r1 = com.huawei.hms.common.data.DataHolder.Builder.b(r1)
            int r1 = r1.size()
            if (r0 < r1) goto L26
        L1e:
            r0 = r6
            java.util.ArrayList r0 = com.huawei.hms.common.data.DataHolder.Builder.b(r0)
            int r0 = r0.size()
            r8 = r0
        L26:
            r0 = r6
            r1 = r8
            r2 = r6
            java.util.ArrayList r2 = com.huawei.hms.common.data.DataHolder.Builder.b(r2)
            r3 = 0
            r4 = r8
            java.util.List r2 = r2.subList(r3, r4)
            java.util.ArrayList r0 = iterCursorWindow(r0, r1, r2)
            r6 = r0
            r0 = r6
            r1 = r6
            int r1 = r1.size()
            android.database.CursorWindow[] r1 = new android.database.CursorWindow[r1]
            java.lang.Object[] r0 = r0.toArray(r1)
            android.database.CursorWindow[] r0 = (android.database.CursorWindow[]) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.data.DataHolder.getCursorWindows(com.huawei.hms.common.data.DataHolder$Builder, int):android.database.CursorWindow[]");
    }

    private static CursorWindow[] getCursorWindows(HMSCursorWrapper hMSCursorWrapper) {
        int i;
        ArrayList arrayList = new ArrayList();
        try {
            int count = hMSCursorWrapper.getCount();
            CursorWindow window = hMSCursorWrapper.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                i = 0;
            } else {
                window.acquireReference();
                hMSCursorWrapper.setWindow(null);
                arrayList.add(window);
                i = window.getNumRows();
            }
            arrayList.addAll(iterCursorWrapper(hMSCursorWrapper, i, count));
            return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
        } catch (Throwable th) {
            try {
                HMSLog.e(TAG, "fail to getCursorWindows: " + th.getMessage());
                hMSCursorWrapper.close();
                return new CursorWindow[0];
            } finally {
                hMSCursorWrapper.close();
            }
        }
    }

    private static ArrayList<CursorWindow> iterCursorWindow(Builder builder, int i, List list) {
        ArrayList<CursorWindow> arrayList = new ArrayList<>();
        CursorWindow cursorWindow = new CursorWindow((String) null);
        cursorWindow.setNumColumns(builder.f22638a.length);
        arrayList.add(cursorWindow);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return arrayList;
            }
            try {
                if (!cursorWindow.allocRow()) {
                    HMSLog.d(TAG, "Failed to allocate a row");
                    cursorWindow = new CursorWindow((String) null);
                    cursorWindow.setStartPosition(i3);
                    cursorWindow.setNumColumns(builder.f22638a.length);
                    if (!cursorWindow.allocRow()) {
                        HMSLog.e(TAG, "Failed to retry to allocate a row");
                        return arrayList;
                    }
                    arrayList.add(cursorWindow);
                }
                HashMap hashMap = (HashMap) list.get(i3);
                boolean z = true;
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= builder.f22638a.length) {
                        break;
                    }
                    z = putValue(cursorWindow, hashMap.get(builder.f22638a[i5]), i3, i5);
                    if (!z) {
                        break;
                    }
                    i4 = i5 + 1;
                }
                if (!z) {
                    HMSLog.d(TAG, "fail to put data for row " + i3);
                    cursorWindow.freeLastRow();
                    CursorWindow cursorWindow2 = new CursorWindow((String) null);
                    cursorWindow2.setStartPosition(i3);
                    cursorWindow2.setNumColumns(builder.f22638a.length);
                    arrayList.add(cursorWindow2);
                    return arrayList;
                }
                i2 = i3 + 1;
            } catch (RuntimeException e) {
                Iterator<CursorWindow> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().close();
                }
                throw e;
            }
        }
    }

    private static ArrayList<CursorWindow> iterCursorWrapper(HMSCursorWrapper hMSCursorWrapper, int i, int i2) {
        ArrayList<CursorWindow> arrayList = new ArrayList<>();
        while (i < i2 && hMSCursorWrapper.moveToPosition(i)) {
            CursorWindow window = hMSCursorWrapper.getWindow();
            if (window == null) {
                window = new CursorWindow((String) null);
                window.setStartPosition(i);
                hMSCursorWrapper.fillWindow(i, window);
            } else {
                window.acquireReference();
                hMSCursorWrapper.setWindow(null);
            }
            if (window.getNumRows() == 0) {
                return arrayList;
            }
            arrayList.add(window);
            i = window.getNumRows() + window.getStartPosition();
        }
        return arrayList;
    }

    private static boolean putValue(CursorWindow cursorWindow, Object obj, int i, int i2) throws IllegalArgumentException {
        if (obj == null) {
            return cursorWindow.putNull(i, i2);
        }
        if (obj instanceof Boolean) {
            return cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1L : 0L, i, i2);
        } else if (obj instanceof Integer) {
            return cursorWindow.putLong(((Integer) obj).intValue(), i, i2);
        } else {
            if (obj instanceof Long) {
                return cursorWindow.putLong(((Long) obj).longValue(), i, i2);
            }
            if (obj instanceof Float) {
                return cursorWindow.putDouble(((Float) obj).floatValue(), i, i2);
            }
            if (obj instanceof Double) {
                return cursorWindow.putDouble(((Double) obj).doubleValue(), i, i2);
            }
            if (obj instanceof String) {
                return cursorWindow.putString((String) obj, i, i2);
            }
            if (obj instanceof byte[]) {
                return cursorWindow.putBlob((byte[]) obj, i, i2);
            }
            throw new IllegalArgumentException("unsupported type for column: " + obj);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (!this.mClosed) {
                CursorWindow[] cursorWindowArr = this.cursorWindows;
                int length = cursorWindowArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    cursorWindowArr[i2].close();
                    i = i2 + 1;
                }
                this.mClosed = true;
            }
        }
    }

    public final void collectColumsAndCount() {
        this.columnsBundle = new Bundle();
        int i = 0;
        while (true) {
            int i2 = i;
            String[] strArr = this.columns;
            if (i2 >= strArr.length) {
                break;
            }
            this.columnsBundle.putInt(strArr[i2], i2);
            i = i2 + 1;
        }
        this.perCursorCounts = new int[this.cursorWindows.length];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            CursorWindow[] cursorWindowArr = this.cursorWindows;
            if (i5 >= cursorWindowArr.length) {
                this.dataCount = i3;
                return;
            }
            this.perCursorCounts[i5] = i3;
            i3 = cursorWindowArr[i5].getStartPosition() + this.cursorWindows[i5].getNumRows();
            i4 = i5 + 1;
        }
    }

    public final void copyToBuffer(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        checkAvailable(str, i);
        this.cursorWindows[i2].copyStringToBuffer(i, this.columnsBundle.getInt(str), charArrayBuffer);
    }

    protected final void finalize() throws Throwable {
        if (this.isInstance && this.cursorWindows.length > 0 && !isClosed()) {
            close();
        }
        super.finalize();
    }

    public final int getCount() {
        return this.dataCount;
    }

    public final Bundle getMetadata() {
        return this.metadata;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Object getValue(String str, int i, int i2, String str2) {
        boolean z;
        boolean z2 = true;
        switch (str2.hashCode()) {
            case -1092271849:
                if (str2.equals(TYPE_FLOAT)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -870070237:
                if (str2.equals(TYPE_BOOLEAN)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -675993238:
                if (str2.equals(TYPE_INT)) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 445002870:
                if (str2.equals(TYPE_DOUBLE)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 519136353:
                if (str2.equals(TYPE_LONG)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 878975158:
                if (str2.equals(TYPE_STRING)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1300508295:
                if (str2.equals(TYPE_BYTE_ARRAY)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                checkAvailable(str, i);
                return Integer.valueOf(this.cursorWindows[i2].getInt(i, this.columnsBundle.getInt(str)));
            case true:
                checkAvailable(str, i);
                return Long.valueOf(this.cursorWindows[i2].getLong(i, this.columnsBundle.getInt(str)));
            case true:
                checkAvailable(str, i);
                return this.cursorWindows[i2].getString(i, this.columnsBundle.getInt(str));
            case true:
                checkAvailable(str, i);
                if (this.cursorWindows[i2].getLong(i, this.columnsBundle.getInt(str)) != 1) {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            case true:
                checkAvailable(str, i);
                return Float.valueOf(this.cursorWindows[i2].getFloat(i, this.columnsBundle.getInt(str)));
            case true:
                checkAvailable(str, i);
                return Double.valueOf(this.cursorWindows[i2].getDouble(i, this.columnsBundle.getInt(str)));
            case true:
                checkAvailable(str, i);
                return this.cursorWindows[i2].getBlob(i, this.columnsBundle.getInt(str));
            default:
                return null;
        }
    }

    public final int getWindowIndex(int i) {
        int i2;
        int i3 = 0;
        Preconditions.checkArgument(i >= 0 || i < this.dataCount, "rowIndex is out of index:" + i);
        while (true) {
            int[] iArr = this.perCursorCounts;
            i2 = i3;
            if (i3 >= iArr.length) {
                break;
            } else if (i < iArr[i3]) {
                i2 = i3 - 1;
                break;
            } else {
                i3++;
            }
        }
        int i4 = i2;
        if (i2 == this.perCursorCounts.length) {
            i4 = i2 - 1;
        }
        return i4;
    }

    public final boolean hasColumn(String str) {
        return this.columnsBundle.containsKey(str);
    }

    public final boolean hasNull(String str, int i, int i2) {
        checkAvailable(str, i);
        return this.cursorWindows[i2].getType(i, this.columnsBundle.getInt(str)) == 0;
    }

    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.columns, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.cursorWindows, i, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.version);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i & 1) != 0) {
            close();
        }
    }
}
