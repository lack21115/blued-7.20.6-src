package android.database;

import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/database/CursorJoiner.class */
public final class CursorJoiner implements Iterator<Result>, Iterable<Result> {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int[] mColumnsLeft;
    private int[] mColumnsRight;
    private Result mCompareResult;
    private boolean mCompareResultIsValid;
    private Cursor mCursorLeft;
    private Cursor mCursorRight;
    private String[] mValues;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.database.CursorJoiner$1  reason: invalid class name */
    /* loaded from: source-9557208-dex2jar.jar:android/database/CursorJoiner$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$database$CursorJoiner$Result = new int[Result.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002d -> B:17:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0031 -> B:15:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$android$database$CursorJoiner$Result[Result.BOTH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$database$CursorJoiner$Result[Result.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$database$CursorJoiner$Result[Result.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/database/CursorJoiner$Result.class */
    public enum Result {
        RIGHT,
        LEFT,
        BOTH
    }

    static {
        $assertionsDisabled = !CursorJoiner.class.desiredAssertionStatus();
    }

    public CursorJoiner(Cursor cursor, String[] strArr, Cursor cursor2, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            throw new IllegalArgumentException("you must have the same number of columns on the left and right, " + strArr.length + " != " + strArr2.length);
        }
        this.mCursorLeft = cursor;
        this.mCursorRight = cursor2;
        this.mCursorLeft.moveToFirst();
        this.mCursorRight.moveToFirst();
        this.mCompareResultIsValid = false;
        this.mColumnsLeft = buildColumnIndiciesArray(cursor, strArr);
        this.mColumnsRight = buildColumnIndiciesArray(cursor2, strArr2);
        this.mValues = new String[this.mColumnsLeft.length * 2];
    }

    private int[] buildColumnIndiciesArray(Cursor cursor, String[] strArr) {
        int[] iArr = new int[strArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return iArr;
            }
            iArr[i2] = cursor.getColumnIndexOrThrow(strArr[i2]);
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int compareStrings(java.lang.String... r5) {
        /*
            r0 = -1
            r8 = r0
            r0 = r5
            int r0 = r0.length
            r1 = 2
            int r0 = r0 % r1
            if (r0 == 0) goto L13
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "you must specify an even number of values"
            r1.<init>(r2)
            throw r0
        L13:
            r0 = 0
            r6 = r0
        L15:
            r0 = r6
            r1 = r5
            int r1 = r1.length
            if (r0 >= r1) goto L59
            r0 = r5
            r1 = r6
            r0 = r0[r1]
            if (r0 != 0) goto L32
            r0 = r8
            r7 = r0
            r0 = r5
            r1 = r6
            r2 = 1
            int r1 = r1 + r2
            r0 = r0[r1]
            if (r0 != 0) goto L3c
        L2b:
            r0 = r6
            r1 = 2
            int r0 = r0 + r1
            r6 = r0
            goto L15
        L32:
            r0 = r5
            r1 = r6
            r2 = 1
            int r1 = r1 + r2
            r0 = r0[r1]
            if (r0 != 0) goto L3e
            r0 = 1
            r7 = r0
        L3c:
            r0 = r7
            return r0
        L3e:
            r0 = r5
            r1 = r6
            r0 = r0[r1]
            r1 = r5
            r2 = r6
            r3 = 1
            int r2 = r2 + r3
            r1 = r1[r2]
            int r0 = r0.compareTo(r1)
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L2b
            r0 = r8
            r7 = r0
            r0 = r9
            if (r0 < 0) goto L3c
            r0 = 1
            return r0
        L59:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.database.CursorJoiner.compareStrings(java.lang.String[]):int");
    }

    private void incrementCursors() {
        if (this.mCompareResultIsValid) {
            switch (AnonymousClass1.$SwitchMap$android$database$CursorJoiner$Result[this.mCompareResult.ordinal()]) {
                case 1:
                    this.mCursorLeft.moveToNext();
                    this.mCursorRight.moveToNext();
                    break;
                case 2:
                    this.mCursorLeft.moveToNext();
                    break;
                case 3:
                    this.mCursorRight.moveToNext();
                    break;
            }
            this.mCompareResultIsValid = false;
        }
    }

    private static void populateValues(String[] strArr, Cursor cursor, int[] iArr, int i) {
        if (!$assertionsDisabled && i != 0 && i != 1) {
            throw new AssertionError();
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iArr.length) {
                return;
            }
            strArr[(i3 * 2) + i] = cursor.getString(iArr[i3]);
            i2 = i3 + 1;
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z = false;
        if (this.mCompareResultIsValid) {
            switch (AnonymousClass1.$SwitchMap$android$database$CursorJoiner$Result[this.mCompareResult.ordinal()]) {
                case 1:
                    if (!this.mCursorLeft.isLast() || !this.mCursorRight.isLast()) {
                        z = true;
                        break;
                    }
                    break;
                case 2:
                    if (!this.mCursorLeft.isLast() || !this.mCursorRight.isAfterLast()) {
                        return true;
                    }
                    break;
                case 3:
                    if (!this.mCursorLeft.isAfterLast() || !this.mCursorRight.isLast()) {
                        return true;
                    }
                    break;
                default:
                    throw new IllegalStateException("bad value for mCompareResult, " + this.mCompareResult);
            }
        } else if (!this.mCursorLeft.isAfterLast() || !this.mCursorRight.isAfterLast()) {
            return true;
        }
        return z;
    }

    @Override // java.lang.Iterable
    public Iterator<Result> iterator() {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Result next() {
        if (hasNext()) {
            incrementCursors();
            if ($assertionsDisabled || hasNext()) {
                boolean z = !this.mCursorLeft.isAfterLast();
                boolean z2 = !this.mCursorRight.isAfterLast();
                if (z && z2) {
                    populateValues(this.mValues, this.mCursorLeft, this.mColumnsLeft, 0);
                    populateValues(this.mValues, this.mCursorRight, this.mColumnsRight, 1);
                    switch (compareStrings(this.mValues)) {
                        case -1:
                            this.mCompareResult = Result.LEFT;
                            break;
                        case 0:
                            this.mCompareResult = Result.BOTH;
                            break;
                        case 1:
                            this.mCompareResult = Result.RIGHT;
                            break;
                    }
                } else if (z) {
                    this.mCompareResult = Result.LEFT;
                } else if (!$assertionsDisabled && !z2) {
                    throw new AssertionError();
                } else {
                    this.mCompareResult = Result.RIGHT;
                }
                this.mCompareResultIsValid = true;
                return this.mCompareResult;
            }
            throw new AssertionError();
        }
        throw new IllegalStateException("you must only call next() when hasNext() is true");
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("not implemented");
    }
}
