package java.util;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/util/ComparableTimSort.class */
public class ComparableTimSort {
    private static final boolean DEBUG = false;
    private static final int INITIAL_TMP_STORAGE_LENGTH = 256;
    private static final int MIN_GALLOP = 7;
    private static final int MIN_MERGE = 32;
    private final Object[] a;
    private final int[] runBase;
    private final int[] runLen;
    private Object[] tmp;
    private int minGallop = 7;
    private int stackSize = 0;

    private ComparableTimSort(Object[] objArr) {
        this.a = objArr;
        int length = objArr.length;
        this.tmp = new Object[length < 512 ? length >>> 1 : 256];
        int i = length < 120 ? 5 : length < 1542 ? 10 : length < 119151 ? 19 : 40;
        this.runBase = new int[i];
        this.runLen = new int[i];
    }

    private static void binarySort(Object[] objArr, int i, int i2, int i3) {
        int i4 = i3;
        if (i3 == i) {
            i4 = i3 + 1;
        }
        while (i4 < i2) {
            Comparable comparable = (Comparable) objArr[i4];
            int i5 = i;
            int i6 = i4;
            while (i5 < i6) {
                int i7 = (i5 + i6) >>> 1;
                if (comparable.compareTo(objArr[i7]) < 0) {
                    i6 = i7;
                } else {
                    i5 = i7 + 1;
                }
            }
            int i8 = i4 - i5;
            switch (i8) {
                case 1:
                    break;
                case 2:
                    objArr[i5 + 2] = objArr[i5 + 1];
                    break;
                default:
                    System.arraycopy(objArr, i5, objArr, i5 + 1, i8);
                    continue;
                    objArr[i5] = comparable;
                    i4++;
            }
            objArr[i5 + 1] = objArr[i5];
            objArr[i5] = comparable;
            i4++;
        }
    }

    private static int countRunAndMakeAscending(Object[] objArr, int i, int i2) {
        int i3;
        int i4 = i + 1;
        if (i4 == i2) {
            return 1;
        }
        int i5 = i4 + 1;
        if (((Comparable) objArr[i4]).compareTo(objArr[i]) >= 0) {
            while (true) {
                i3 = i5;
                if (i5 >= i2) {
                    break;
                }
                i3 = i5;
                if (((Comparable) objArr[i5]).compareTo(objArr[i5 - 1]) < 0) {
                    break;
                }
                i5++;
            }
        } else {
            while (i5 < i2 && ((Comparable) objArr[i5]).compareTo(objArr[i5 - 1]) < 0) {
                i5++;
            }
            reverseRange(objArr, i, i5);
            i3 = i5;
        }
        return i3 - i;
    }

    private Object[] ensureCapacity(int i) {
        if (this.tmp.length < i) {
            int i2 = i | (i >> 1);
            int i3 = i2 | (i2 >> 2);
            int i4 = i3 | (i3 >> 4);
            int i5 = i4 | (i4 >> 8);
            int i6 = (i5 | (i5 >> 16)) + 1;
            if (i6 >= 0) {
                i = Math.min(i6, this.a.length >>> 1);
            }
            this.tmp = new Object[i];
        }
        return this.tmp;
    }

    private static int gallopLeft(Comparable<Object> comparable, Object[] objArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = 0;
        if (comparable.compareTo(objArr[i + i3]) > 0) {
            int i7 = i2 - i3;
            int i8 = 1;
            while (i8 < i7 && comparable.compareTo(objArr[i + i3 + i8]) > 0) {
                int i9 = i8;
                int i10 = (i8 << 1) + 1;
                i6 = i9;
                i8 = i10;
                if (i10 <= 0) {
                    i8 = i7;
                    i6 = i9;
                }
            }
            int i11 = i8;
            if (i8 > i7) {
                i11 = i7;
            }
            i5 = i11 + i3;
            i4 = i6 + i3;
        } else {
            int i12 = i3 + 1;
            int i13 = 1;
            int i14 = 0;
            while (i13 < i12 && comparable.compareTo(objArr[(i + i3) - i13]) <= 0) {
                int i15 = i13;
                int i16 = (i13 << 1) + 1;
                i14 = i15;
                i13 = i16;
                if (i16 <= 0) {
                    i13 = i12;
                    i14 = i15;
                }
            }
            int i17 = i13;
            if (i13 > i12) {
                i17 = i12;
            }
            int i18 = i3 - i14;
            i4 = i3 - i17;
            i5 = i18;
        }
        int i19 = i4 + 1;
        while (i19 < i5) {
            int i20 = i19 + ((i5 - i19) >>> 1);
            if (comparable.compareTo(objArr[i + i20]) > 0) {
                i19 = i20 + 1;
            } else {
                i5 = i20;
            }
        }
        return i5;
    }

    private static int gallopRight(Comparable<Object> comparable, Object[] objArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = 0;
        if (comparable.compareTo(objArr[i + i3]) < 0) {
            int i7 = i3 + 1;
            int i8 = 1;
            while (i8 < i7 && comparable.compareTo(objArr[(i + i3) - i8]) < 0) {
                int i9 = i8;
                int i10 = (i8 << 1) + 1;
                i6 = i9;
                i8 = i10;
                if (i10 <= 0) {
                    i8 = i7;
                    i6 = i9;
                }
            }
            int i11 = i8;
            if (i8 > i7) {
                i11 = i7;
            }
            i5 = i3 - i6;
            i4 = i3 - i11;
        } else {
            int i12 = i2 - i3;
            int i13 = 1;
            int i14 = 0;
            while (i13 < i12 && comparable.compareTo(objArr[i + i3 + i13]) >= 0) {
                int i15 = i13;
                int i16 = (i13 << 1) + 1;
                i14 = i15;
                i13 = i16;
                if (i16 <= 0) {
                    i13 = i12;
                    i14 = i15;
                }
            }
            int i17 = i13;
            if (i13 > i12) {
                i17 = i12;
            }
            int i18 = i17 + i3;
            i4 = i14 + i3;
            i5 = i18;
        }
        int i19 = i4 + 1;
        while (i19 < i5) {
            int i20 = i19 + ((i5 - i19) >>> 1);
            if (comparable.compareTo(objArr[i + i20]) < 0) {
                i5 = i20;
            } else {
                i19 = i20 + 1;
            }
        }
        return i5;
    }

    private void mergeAt(int i) {
        int gallopLeft;
        int i2 = this.runBase[i];
        int i3 = this.runLen[i];
        int i4 = this.runBase[i + 1];
        int i5 = this.runLen[i + 1];
        this.runLen[i] = i3 + i5;
        if (i == this.stackSize - 3) {
            this.runBase[i + 1] = this.runBase[i + 2];
            this.runLen[i + 1] = this.runLen[i + 2];
        }
        this.stackSize--;
        int gallopRight = gallopRight((Comparable) this.a[i4], this.a, i2, i3, 0);
        int i6 = i2 + gallopRight;
        int i7 = i3 - gallopRight;
        if (i7 == 0 || (gallopLeft = gallopLeft((Comparable) this.a[(i6 + i7) - 1], this.a, i4, i5, i5 - 1)) == 0) {
            return;
        }
        if (i7 <= gallopLeft) {
            mergeLo(i6, i7, i4, gallopLeft);
        } else {
            mergeHi(i6, i7, i4, gallopLeft);
        }
    }

    private void mergeCollapse() {
        while (this.stackSize > 1) {
            int i = this.stackSize - 2;
            if (i > 0 && this.runLen[i - 1] <= this.runLen[i] + this.runLen[i + 1]) {
                int i2 = i;
                if (this.runLen[i - 1] < this.runLen[i + 1]) {
                    i2 = i - 1;
                }
                mergeAt(i2);
            } else if (this.runLen[i] > this.runLen[i + 1]) {
                return;
            } else {
                mergeAt(i);
            }
        }
    }

    private void mergeForceCollapse() {
        while (this.stackSize > 1) {
            int i = this.stackSize - 2;
            int i2 = i;
            if (i > 0) {
                i2 = i;
                if (this.runLen[i - 1] < this.runLen[i + 1]) {
                    i2 = i - 1;
                }
            }
            mergeAt(i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x018a, code lost:
        r20 = r21;
        r14 = r17;
        r11 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0195, code lost:
        r0 = r14 - gallopRight((java.lang.Comparable) r0[r19], r0, r9, r14, r14 - 1);
        r17 = r11;
        r12 = r10;
        r16 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x01ba, code lost:
        if (r0 == 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x01bd, code lost:
        r0 = r10 - r0;
        r0 = r11 - r0;
        r16 = r14 - r0;
        java.lang.System.arraycopy(r0, r0 + 1, r0, r0 + 1, r0);
        r13 = r0;
        r10 = r19;
        r11 = r0;
        r18 = r15;
        r14 = r16;
        r12 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x01f9, code lost:
        if (r16 == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x01fc, code lost:
        r12 = r0;
        r17 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0204, code lost:
        r11 = r12 - 1;
        r10 = r19 - 1;
        r0[r12] = r0[r19];
        r12 = r20 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0221, code lost:
        if (r12 != 1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0224, code lost:
        r13 = r17;
        r18 = r15;
        r14 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0233, code lost:
        r0 = r12 - gallopLeft((java.lang.Comparable) r0[r17], r0, 0, r12, r12 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x024e, code lost:
        if (r0 == 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0251, code lost:
        r19 = r11 - r0;
        r0 = r10 - r0;
        r0 = r12 - r0;
        java.lang.System.arraycopy(r0, r0 + 1, r0, r19 + 1, r0);
        r13 = r17;
        r10 = r0;
        r11 = r19;
        r18 = r15;
        r14 = r16;
        r12 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x028e, code lost:
        if (r0 <= 1) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0291, code lost:
        r12 = r0;
        r10 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0298, code lost:
        r13 = r19 - 1;
        r11 = r17 - 1;
        r0[r19] = r0[r17];
        r14 = r16 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x02b5, code lost:
        if (r14 != 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x02b8, code lost:
        r13 = r11;
        r11 = r13;
        r18 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x02c7, code lost:
        r15 = r15 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x02d1, code lost:
        if (r0 < 7) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x02d4, code lost:
        r16 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x02db, code lost:
        if (r0 < 7) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x02de, code lost:
        r17 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x02e6, code lost:
        if ((r17 | r16) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x02e9, code lost:
        r16 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x02ef, code lost:
        if (r15 >= 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x02f2, code lost:
        r16 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x02fe, code lost:
        r16 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0304, code lost:
        r17 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x032a, code lost:
        r19 = r10;
        r10 = r13;
        r20 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0337, code lost:
        r19 = r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x018a A[EDGE_INSN: B:78:0x018a->B:30:0x018a ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void mergeHi(int r9, int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 852
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.ComparableTimSort.mergeHi(int, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0160, code lost:
        r11 = r14;
        r8 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0167, code lost:
        r0 = gallopRight((java.lang.Comparable) r0[r16], r0, r8, r11, 0);
        r14 = r8;
        r9 = r7;
        r13 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0185, code lost:
        if (r0 == 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0188, code lost:
        java.lang.System.arraycopy(r0, r8, r0, r7, r0);
        r0 = r7 + r0;
        r0 = r8 + r0;
        r13 = r11 - r0;
        r10 = r0;
        r7 = r16;
        r8 = r0;
        r15 = r12;
        r11 = r13;
        r9 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x01be, code lost:
        if (r13 <= 1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x01c1, code lost:
        r9 = r0;
        r14 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x01c8, code lost:
        r8 = r9 + 1;
        r7 = r16 + 1;
        r0[r9] = r0[r16];
        r9 = r17 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x01e0, code lost:
        if (r9 != 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x01e3, code lost:
        r10 = r14;
        r15 = r12;
        r11 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01f2, code lost:
        r0 = gallopLeft((java.lang.Comparable) r0[r14], r0, r7, r9, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0206, code lost:
        if (r0 == 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0209, code lost:
        java.lang.System.arraycopy(r0, r7, r0, r8, r0);
        r16 = r8 + r0;
        r0 = r7 + r0;
        r0 = r9 - r0;
        r10 = r14;
        r7 = r0;
        r8 = r16;
        r15 = r12;
        r11 = r13;
        r9 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x023d, code lost:
        if (r0 == 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0240, code lost:
        r9 = r0;
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0246, code lost:
        r0 = r16 + 1;
        r8 = r14 + 1;
        r0[r16] = r0[r14];
        r11 = r13 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0264, code lost:
        if (r11 != 1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0267, code lost:
        r10 = r8;
        r8 = r0;
        r15 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0278, code lost:
        r12 = r12 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0282, code lost:
        if (r0 < 7) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0285, code lost:
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x028c, code lost:
        if (r0 < 7) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x028f, code lost:
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0297, code lost:
        if ((r14 | r13) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x029a, code lost:
        r13 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x02a0, code lost:
        if (r12 >= 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x02a3, code lost:
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x02bd, code lost:
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x02c3, code lost:
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x02e5, code lost:
        r16 = r7;
        r7 = r0;
        r17 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x02f1, code lost:
        r16 = r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0160 A[EDGE_INSN: B:78:0x0160->B:30:0x0160 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void mergeLo(int r7, int r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 781
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.ComparableTimSort.mergeLo(int, int, int, int):void");
    }

    private static int minRunLength(int i) {
        int i2 = 0;
        while (i >= 32) {
            i2 |= i & 1;
            i >>= 1;
        }
        return i + i2;
    }

    private void pushRun(int i, int i2) {
        this.runBase[this.stackSize] = i;
        this.runLen[this.stackSize] = i2;
        this.stackSize++;
    }

    private static void reverseRange(Object[] objArr, int i, int i2) {
        int i3 = i2 - 1;
        while (i < i3) {
            Object obj = objArr[i];
            objArr[i] = objArr[i3];
            objArr[i3] = obj;
            i3--;
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sort(Object[] objArr) {
        sort(objArr, 0, objArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sort(Object[] objArr, int i, int i2) {
        int i3;
        Arrays.checkStartAndEnd(objArr.length, i, i2);
        int i4 = i2 - i;
        if (i4 < 2) {
            return;
        }
        if (i4 < 32) {
            binarySort(objArr, i, i2, i + countRunAndMakeAscending(objArr, i, i2));
            return;
        }
        ComparableTimSort comparableTimSort = new ComparableTimSort(objArr);
        int minRunLength = minRunLength(i4);
        int i5 = i;
        int i6 = i4;
        do {
            int countRunAndMakeAscending = countRunAndMakeAscending(objArr, i5, i2);
            int i7 = countRunAndMakeAscending;
            if (countRunAndMakeAscending < minRunLength) {
                i7 = i6 <= minRunLength ? i6 : minRunLength;
                binarySort(objArr, i5, i5 + i7, i5 + countRunAndMakeAscending);
            }
            comparableTimSort.pushRun(i5, i7);
            comparableTimSort.mergeCollapse();
            i5 += i7;
            i3 = i6 - i7;
            i6 = i3;
        } while (i3 != 0);
        comparableTimSort.mergeForceCollapse();
    }
}
