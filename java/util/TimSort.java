package java.util;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/util/TimSort.class */
public class TimSort<T> {
    private static final boolean DEBUG = false;
    private static final int INITIAL_TMP_STORAGE_LENGTH = 256;
    private static final int MIN_GALLOP = 7;
    private static final int MIN_MERGE = 32;

    /* renamed from: a  reason: collision with root package name */
    private final T[] f42270a;

    /* renamed from: c  reason: collision with root package name */
    private final Comparator<? super T> f42271c;
    private final int[] runBase;
    private final int[] runLen;
    private T[] tmp;
    private int minGallop = 7;
    private int stackSize = 0;

    private TimSort(T[] tArr, Comparator<? super T> comparator) {
        this.f42270a = tArr;
        this.f42271c = comparator;
        int length = tArr.length;
        this.tmp = (T[]) new Object[length < 512 ? length >>> 1 : 256];
        int i = length < 120 ? 5 : length < 1542 ? 10 : length < 119151 ? 19 : 40;
        this.runBase = new int[i];
        this.runLen = new int[i];
    }

    private static <T> void binarySort(T[] tArr, int i, int i2, int i3, Comparator<? super T> comparator) {
        int i4 = i3;
        if (i3 == i) {
            i4 = i3 + 1;
        }
        while (i4 < i2) {
            T t = tArr[i4];
            int i5 = i;
            int i6 = i4;
            while (i5 < i6) {
                int i7 = (i5 + i6) >>> 1;
                if (comparator.compare(t, tArr[i7]) < 0) {
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
                    tArr[i5 + 2] = tArr[i5 + 1];
                    break;
                default:
                    System.arraycopy(tArr, i5, tArr, i5 + 1, i8);
                    continue;
                    tArr[i5] = t;
                    i4++;
            }
            tArr[i5 + 1] = tArr[i5];
            tArr[i5] = t;
            i4++;
        }
    }

    private static <T> int countRunAndMakeAscending(T[] tArr, int i, int i2, Comparator<? super T> comparator) {
        int i3;
        int i4 = i + 1;
        if (i4 == i2) {
            return 1;
        }
        int i5 = i4 + 1;
        if (comparator.compare(tArr[i4], tArr[i]) >= 0) {
            while (true) {
                i3 = i5;
                if (i5 >= i2) {
                    break;
                }
                i3 = i5;
                if (comparator.compare(tArr[i5], tArr[i5 - 1]) < 0) {
                    break;
                }
                i5++;
            }
        } else {
            while (i5 < i2 && comparator.compare(tArr[i5], tArr[i5 - 1]) < 0) {
                i5++;
            }
            reverseRange(tArr, i, i5);
            i3 = i5;
        }
        return i3 - i;
    }

    private T[] ensureCapacity(int i) {
        if (this.tmp.length < i) {
            int i2 = i | (i >> 1);
            int i3 = i2 | (i2 >> 2);
            int i4 = i3 | (i3 >> 4);
            int i5 = i4 | (i4 >> 8);
            int i6 = (i5 | (i5 >> 16)) + 1;
            if (i6 >= 0) {
                i = Math.min(i6, this.f42270a.length >>> 1);
            }
            this.tmp = (T[]) new Object[i];
        }
        return this.tmp;
    }

    private static <T> int gallopLeft(T t, T[] tArr, int i, int i2, int i3, Comparator<? super T> comparator) {
        int i4;
        int i5;
        int i6 = 0;
        if (comparator.compare(t, tArr[i + i3]) > 0) {
            int i7 = i2 - i3;
            int i8 = 1;
            while (i8 < i7 && comparator.compare(t, tArr[i + i3 + i8]) > 0) {
                int i9 = i8;
                int i10 = (i8 * 2) + 1;
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
            while (i13 < i12 && comparator.compare(t, tArr[(i + i3) - i13]) <= 0) {
                int i15 = i13;
                int i16 = (i13 * 2) + 1;
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
            if (comparator.compare(t, tArr[i + i20]) > 0) {
                i19 = i20 + 1;
            } else {
                i5 = i20;
            }
        }
        return i5;
    }

    private static <T> int gallopRight(T t, T[] tArr, int i, int i2, int i3, Comparator<? super T> comparator) {
        int i4;
        int i5;
        int i6 = 0;
        if (comparator.compare(t, tArr[i + i3]) < 0) {
            int i7 = i3 + 1;
            int i8 = 1;
            while (i8 < i7 && comparator.compare(t, tArr[(i + i3) - i8]) < 0) {
                int i9 = i8;
                int i10 = (i8 * 2) + 1;
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
            while (i13 < i12 && comparator.compare(t, tArr[i + i3 + i13]) >= 0) {
                int i15 = i13;
                int i16 = (i13 * 2) + 1;
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
            if (comparator.compare(t, tArr[i + i20]) < 0) {
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
        int gallopRight = gallopRight(this.f42270a[i4], this.f42270a, i2, i3, 0, this.f42271c);
        int i6 = i2 + gallopRight;
        int i7 = i3 - gallopRight;
        if (i7 == 0 || (gallopLeft = gallopLeft(this.f42270a[(i6 + i7) - 1], this.f42270a, i4, i5, i5 - 1, this.f42271c)) == 0) {
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

    /* JADX WARN: Code restructure failed: missing block: B:30:0x018f, code lost:
        r20 = r21;
        r14 = r17;
        r11 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x019a, code lost:
        r0 = r14 - gallopRight(r0[r19], r0, r9, r14, r14 - 1, r0);
        r17 = r11;
        r12 = r10;
        r16 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x01be, code lost:
        if (r0 == 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x01c1, code lost:
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
    /* JADX WARN: Code restructure failed: missing block: B:34:0x01fd, code lost:
        if (r16 == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0200, code lost:
        r12 = r0;
        r17 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0208, code lost:
        r11 = r12 - 1;
        r10 = r19 - 1;
        r0[r12] = r0[r19];
        r12 = r20 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0225, code lost:
        if (r12 != 1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0228, code lost:
        r13 = r17;
        r18 = r15;
        r14 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0237, code lost:
        r0 = r12 - gallopLeft(r0[r17], r0, 0, r12, r12 - 1, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0251, code lost:
        if (r0 == 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0254, code lost:
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
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0291, code lost:
        if (r0 <= 1) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0294, code lost:
        r12 = r0;
        r10 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x029b, code lost:
        r13 = r19 - 1;
        r11 = r17 - 1;
        r0[r19] = r0[r17];
        r14 = r16 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x02b8, code lost:
        if (r14 != 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x02bb, code lost:
        r13 = r11;
        r11 = r13;
        r18 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x02ca, code lost:
        r15 = r15 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x02d4, code lost:
        if (r0 < 7) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x02d7, code lost:
        r16 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x02de, code lost:
        if (r0 < 7) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x02e1, code lost:
        r17 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x02e9, code lost:
        if ((r17 | r16) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x02ec, code lost:
        r16 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x02f2, code lost:
        if (r15 >= 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x02f5, code lost:
        r16 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0301, code lost:
        r16 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0307, code lost:
        r17 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x032d, code lost:
        r19 = r10;
        r10 = r13;
        r20 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x033a, code lost:
        r19 = r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x018f A[EDGE_INSN: B:78:0x018f->B:30:0x018f ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void mergeHi(int r9, int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 855
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.TimSort.mergeHi(int, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0165, code lost:
        r10 = r16;
        r12 = r15;
        r11 = r8;
        r8 = r17;
        r9 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0175, code lost:
        r0 = gallopRight(r0[r8], r0, r9, r12, 0, r0);
        r14 = r9;
        r17 = r11;
        r15 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0193, code lost:
        if (r0 == 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0196, code lost:
        java.lang.System.arraycopy(r0, r9, r0, r11, r0);
        r0 = r11 + r0;
        r11 = r9 + r0;
        r12 = r12 - r0;
        r14 = r11;
        r17 = r0;
        r15 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x01c5, code lost:
        if (r12 > 1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x01c8, code lost:
        r9 = r0;
        r16 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x01d2, code lost:
        r0 = r17 + 1;
        r0 = r8 + 1;
        r0[r17] = r0[r8];
        r10 = r10 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x01ea, code lost:
        if (r10 != 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x01ed, code lost:
        r11 = r14;
        r8 = r0;
        r9 = r0;
        r16 = r13;
        r12 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0205, code lost:
        r0 = gallopLeft(r0[r14], r0, r0, r10, 0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0218, code lost:
        if (r0 == 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x021b, code lost:
        java.lang.System.arraycopy(r0, r0, r0, r0, r0);
        r17 = r0 + r0;
        r0 = r0 + r0;
        r0 = r10 - r0;
        r11 = r14;
        r8 = r0;
        r9 = r17;
        r16 = r13;
        r12 = r15;
        r10 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0251, code lost:
        if (r0 == 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0254, code lost:
        r10 = r0;
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x025a, code lost:
        r11 = r17 + 1;
        r9 = r14 + 1;
        r0[r17] = r0[r14];
        r12 = r15 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0278, code lost:
        if (r12 != 1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x027b, code lost:
        r11 = r9;
        r9 = r11;
        r16 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x028c, code lost:
        r13 = r13 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0296, code lost:
        if (r0 < 7) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0299, code lost:
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x02a0, code lost:
        if (r0 < 7) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x02a3, code lost:
        r15 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x02ab, code lost:
        if ((r15 | r14) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x02ae, code lost:
        r14 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x02b4, code lost:
        if (r13 >= 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x02b7, code lost:
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x02d1, code lost:
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x02d7, code lost:
        r15 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x02fc, code lost:
        r8 = r0;
        r17 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0165 A[EDGE_INSN: B:78:0x0165->B:30:0x0165 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void mergeLo(int r8, int r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 795
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.TimSort.mergeLo(int, int, int, int):void");
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
    public static <T> void sort(T[] tArr, int i, int i2, Comparator<? super T> comparator) {
        int i3;
        if (comparator == null) {
            Arrays.sort(tArr, i, i2);
            return;
        }
        Arrays.checkStartAndEnd(tArr.length, i, i2);
        int i4 = i2 - i;
        if (i4 >= 2) {
            if (i4 < 32) {
                binarySort(tArr, i, i2, i + countRunAndMakeAscending(tArr, i, i2, comparator), comparator);
                return;
            }
            TimSort timSort = new TimSort(tArr, comparator);
            int minRunLength = minRunLength(i4);
            int i5 = i;
            int i6 = i4;
            do {
                int countRunAndMakeAscending = countRunAndMakeAscending(tArr, i5, i2, comparator);
                int i7 = countRunAndMakeAscending;
                if (countRunAndMakeAscending < minRunLength) {
                    i7 = i6 <= minRunLength ? i6 : minRunLength;
                    binarySort(tArr, i5, i5 + i7, i5 + countRunAndMakeAscending, comparator);
                }
                timSort.pushRun(i5, i7);
                timSort.mergeCollapse();
                i5 += i7;
                i3 = i6 - i7;
                i6 = i3;
            } while (i3 != 0);
            timSort.mergeForceCollapse();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void sort(T[] tArr, Comparator<? super T> comparator) {
        sort(tArr, 0, tArr.length, comparator);
    }
}
