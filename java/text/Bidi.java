package java.text;

import java.awt.font.NumericShaper;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/text/Bidi.class */
public final class Bidi {
    public static final int DIRECTION_DEFAULT_LEFT_TO_RIGHT = -2;
    public static final int DIRECTION_DEFAULT_RIGHT_TO_LEFT = -1;
    public static final int DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int DIRECTION_RIGHT_TO_LEFT = 1;
    private static final int UBIDI_LEVEL_OVERRIDE = 128;
    private static final int UBiDiDirection_UBIDI_LTR = 0;
    private static final int UBiDiDirection_UBIDI_MIXED = 2;
    private static final int UBiDiDirection_UBIDI_RTL = 1;
    private int baseLevel;
    private int direction;
    private int length;
    private byte[] offsetLevel;
    private Run[] runs;
    private boolean unidirectional;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/text/Bidi$Run.class */
    public static class Run {
        private final int level;
        private final int limit;
        private final int start;

        public Run(int i, int i2, int i3) {
            this.start = i;
            this.limit = i2;
            this.level = i3;
        }

        public int getLevel() {
            return this.level;
        }

        public int getLimit() {
            return this.limit;
        }

        public int getStart() {
            return this.start;
        }
    }

    private Bidi(long j) {
        readBidiInfo(j);
    }

    public Bidi(String str, int i) {
        this(str == null ? null : str.toCharArray(), 0, null, 0, str == null ? 0 : str.length(), i);
    }

    public Bidi(AttributedCharacterIterator attributedCharacterIterator) {
        byte[] bArr;
        if (attributedCharacterIterator == null) {
            throw new IllegalArgumentException("paragraph is null");
        }
        int beginIndex = attributedCharacterIterator.getBeginIndex();
        int endIndex = attributedCharacterIterator.getEndIndex() - beginIndex;
        char[] cArr = new char[endIndex + 1];
        if (endIndex != 0) {
            cArr[0] = attributedCharacterIterator.first();
        } else {
            attributedCharacterIterator.first();
        }
        Object attribute = attributedCharacterIterator.getAttribute(TextAttribute.RUN_DIRECTION);
        int i = -2;
        if (attribute != null) {
            i = -2;
            if (attribute instanceof Boolean) {
                i = attribute.equals(TextAttribute.RUN_DIRECTION_LTR) ? 0 : 1;
            }
        }
        byte[] bArr2 = null;
        int i2 = 1;
        int i3 = 1;
        while (i3 < endIndex) {
            Object attribute2 = attributedCharacterIterator.getAttribute(TextAttribute.BIDI_EMBEDDING);
            int i4 = i3;
            if (attribute2 != null) {
                i4 = i3;
                if (attribute2 instanceof Integer) {
                    int intValue = ((Integer) attribute2).intValue();
                    byte[] bArr3 = bArr2;
                    int i5 = i3;
                    if (bArr2 == null) {
                        bArr3 = new byte[endIndex];
                        i5 = i3;
                    }
                    while (true) {
                        bArr = bArr3;
                        i3 = i5;
                        if (i5 < i2) {
                            cArr[i5] = attributedCharacterIterator.next();
                            bArr3[i5 - 1] = (byte) intValue;
                            i5++;
                        }
                    }
                    i2 = (attributedCharacterIterator.getRunLimit(TextAttribute.BIDI_EMBEDDING) - beginIndex) + 1;
                    bArr2 = bArr;
                }
            }
            while (true) {
                bArr = bArr2;
                i3 = i4;
                if (i4 < i2) {
                    cArr[i4] = attributedCharacterIterator.next();
                    i4++;
                }
            }
            i2 = (attributedCharacterIterator.getRunLimit(TextAttribute.BIDI_EMBEDDING) - beginIndex) + 1;
            bArr2 = bArr;
        }
        Object attribute3 = attributedCharacterIterator.getAttribute(TextAttribute.NUMERIC_SHAPING);
        if (attribute3 != null && (attribute3 instanceof NumericShaper)) {
            ((NumericShaper) attribute3).shape(cArr, 0, endIndex);
        }
        long j = 0;
        try {
            long createUBiDi = createUBiDi(cArr, 0, bArr2, 0, endIndex, i);
            j = createUBiDi;
            readBidiInfo(createUBiDi);
            ubidi_close(createUBiDi);
        } catch (Throwable th) {
            ubidi_close(j);
            throw th;
        }
    }

    public Bidi(char[] cArr, int i, byte[] bArr, int i2, int i3, int i4) {
        if (cArr == null || cArr.length - i < i3) {
            throw new IllegalArgumentException();
        }
        if (bArr != null && bArr.length - i2 < i3) {
            throw new IllegalArgumentException();
        }
        if (i < 0) {
            throw new IllegalArgumentException("Negative textStart value " + i);
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Negative embStart value " + i2);
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("Negative paragraph length " + i3);
        }
        long j = 0;
        try {
            long createUBiDi = createUBiDi(cArr, i, bArr, i2, i3, i4);
            j = createUBiDi;
            readBidiInfo(createUBiDi);
            ubidi_close(createUBiDi);
        } catch (Throwable th) {
            ubidi_close(j);
            throw th;
        }
    }

    private Bidi createEmptyLineBidi(long j) {
        Bidi bidi = new Bidi(j);
        bidi.length = 0;
        bidi.offsetLevel = null;
        bidi.runs = null;
        bidi.unidirectional = true;
        return bidi;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ba, code lost:
        if (r14 < (-2)) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long createUBiDi(char[] r9, int r10, byte[] r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.text.Bidi.createUBiDi(char[], int, byte[], int, int, int):long");
    }

    private void readBidiInfo(long j) {
        this.length = ubidi_getLength(j);
        this.offsetLevel = this.length == 0 ? null : ubidi_getLevels(j);
        this.baseLevel = ubidi_getParaLevel(j);
        int ubidi_countRuns = ubidi_countRuns(j);
        if (ubidi_countRuns == 0) {
            this.unidirectional = true;
            this.runs = null;
        } else if (ubidi_countRuns < 0) {
            this.runs = null;
        } else {
            this.runs = ubidi_getRuns(j);
            if (ubidi_countRuns == 1 && this.runs[0].getLevel() == this.baseLevel) {
                this.unidirectional = true;
                this.runs = null;
            }
        }
        this.direction = ubidi_getDirection(j);
    }

    public static void reorderVisually(byte[] bArr, int i, Object[] objArr, int i2, int i3) {
        if (i3 < 0 || i < 0 || i2 < 0 || i3 > bArr.length - i || i3 > objArr.length - i2) {
            throw new IllegalArgumentException("Invalid ranges (levels=" + bArr.length + ", levelStart=" + i + ", objects=" + objArr.length + ", objectStart=" + i2 + ", count=" + i3 + ")");
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        int[] ubidi_reorderVisual = ubidi_reorderVisual(bArr2, i3);
        ArrayList arrayList = new ArrayList(i3);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i3) {
                System.arraycopy(arrayList.toArray(), 0, objArr, i2, i3);
                return;
            } else {
                arrayList.add(objArr[ubidi_reorderVisual[i5] + i2]);
                i4 = i5 + 1;
            }
        }
    }

    public static boolean requiresBidi(char[] cArr, int i, int i2) {
        boolean z = false;
        if (i2 < 0 || i < 0 || i > i2 || i2 > cArr.length) {
            throw new IllegalArgumentException();
        }
        if (!new Bidi(cArr, i, null, 0, i2 - i, 0).isLeftToRight()) {
            z = true;
        }
        return z;
    }

    private static native void ubidi_close(long j);

    private static native int ubidi_countRuns(long j);

    private static native int ubidi_getDirection(long j);

    private static native int ubidi_getLength(long j);

    private static native byte[] ubidi_getLevels(long j);

    private static native byte ubidi_getParaLevel(long j);

    private static native Run[] ubidi_getRuns(long j);

    private static native long ubidi_open();

    private static native int[] ubidi_reorderVisual(byte[] bArr, int i);

    private static native long ubidi_setLine(long j, int i, int i2);

    private static native void ubidi_setPara(long j, char[] cArr, int i, int i2, byte[] bArr);

    public boolean baseIsLeftToRight() {
        return this.baseLevel % 2 == 0;
    }

    public Bidi createLineBidi(int i, int i2) {
        if (i < 0 || i2 < 0 || i2 > this.length || i > i2) {
            throw new IllegalArgumentException("Invalid ranges (start=" + i + ", limit=" + i2 + ", length=" + this.length + ")");
        }
        char[] cArr = new char[this.length];
        Arrays.fill(cArr, 'a');
        byte[] bArr = new byte[this.length];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= bArr.length) {
                break;
            }
            bArr[i4] = (byte) (-this.offsetLevel[i4]);
            i3 = i4 + 1;
        }
        try {
            long createUBiDi = createUBiDi(cArr, 0, bArr, 0, this.length, baseIsLeftToRight() ? 0 : 1);
            if (i == i2) {
                Bidi createEmptyLineBidi = createEmptyLineBidi(createUBiDi);
                ubidi_close(createUBiDi);
                return createEmptyLineBidi;
            }
            Bidi bidi = new Bidi(ubidi_setLine(createUBiDi, i, i2));
            ubidi_close(createUBiDi);
            return bidi;
        } catch (Throwable th) {
            ubidi_close(0L);
            throw th;
        }
    }

    public int getBaseLevel() {
        return this.baseLevel;
    }

    public int getLength() {
        return this.length;
    }

    public int getLevelAt(int i) {
        try {
            return this.offsetLevel[i] & (-129);
        } catch (RuntimeException e) {
            return this.baseLevel;
        }
    }

    public int getRunCount() {
        if (this.unidirectional) {
            return 1;
        }
        return this.runs.length;
    }

    public int getRunLevel(int i) {
        return this.unidirectional ? this.baseLevel : this.runs[i].getLevel();
    }

    public int getRunLimit(int i) {
        return this.unidirectional ? this.length : this.runs[i].getLimit();
    }

    public int getRunStart(int i) {
        if (this.unidirectional) {
            return 0;
        }
        return this.runs[i].getStart();
    }

    public boolean isLeftToRight() {
        return this.direction == 0;
    }

    public boolean isMixed() {
        return this.direction == 2;
    }

    public boolean isRightToLeft() {
        return this.direction == 1;
    }

    public String toString() {
        return getClass().getName() + "[direction: " + this.direction + " baseLevel: " + this.baseLevel + " length: " + this.length + " runs: " + Arrays.toString(this.runs) + "]";
    }
}
