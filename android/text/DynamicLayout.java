package android.text;

import android.graphics.Paint;
import android.text.Layout;
import android.text.TextUtils;
import android.text.style.UpdateLayout;
import android.text.style.WrapTogetherSpan;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.GrowingArrayUtils;
import java.lang.ref.WeakReference;

/* loaded from: source-9557208-dex2jar.jar:android/text/DynamicLayout.class */
public class DynamicLayout extends Layout {
    private static final int BLOCK_MINIMUM_CHARACTER_LENGTH = 400;
    private static final int COLUMNS_ELLIPSIZE = 5;
    private static final int COLUMNS_NORMAL = 3;
    private static final int DESCENT = 2;
    private static final int DIR = 0;
    private static final int DIR_SHIFT = 30;
    private static final int ELLIPSIS_COUNT = 4;
    private static final int ELLIPSIS_START = 3;
    private static final int ELLIPSIS_UNDEFINED = Integer.MIN_VALUE;
    public static final int INVALID_BLOCK_INDEX = -1;
    private static final int PRIORITY = 128;
    private static final int START = 0;
    private static final int START_MASK = 536870911;
    private static final int TAB = 0;
    private static final int TAB_MASK = 536870912;
    private static final int TOP = 1;
    private CharSequence mBase;
    private int[] mBlockEndLines;
    private int[] mBlockIndices;
    private int mBottomPadding;
    private CharSequence mDisplay;
    private boolean mEllipsize;
    private TextUtils.TruncateAt mEllipsizeAt;
    private int mEllipsizedWidth;
    private boolean mIncludePad;
    private int mIndexFirstChangedBlock;
    private PackedIntVector mInts;
    private int mNumberOfBlocks;
    private PackedObjectVector<Layout.Directions> mObjects;
    private int mTopPadding;
    private ChangeWatcher mWatcher;
    private static StaticLayout sStaticLayout = new StaticLayout(null);
    private static final Object[] sLock = new Object[0];

    /* loaded from: source-9557208-dex2jar.jar:android/text/DynamicLayout$ChangeWatcher.class */
    private static class ChangeWatcher implements TextWatcher, SpanWatcher {
        private WeakReference<DynamicLayout> mLayout;

        public ChangeWatcher(DynamicLayout dynamicLayout) {
            this.mLayout = new WeakReference<>(dynamicLayout);
        }

        private void reflow(CharSequence charSequence, int i, int i2, int i3) {
            DynamicLayout dynamicLayout = this.mLayout.get();
            if (dynamicLayout != null) {
                dynamicLayout.reflow(charSequence, i, i2, i3);
            } else if (charSequence instanceof Spannable) {
                ((Spannable) charSequence).removeSpan(this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
            if (obj instanceof UpdateLayout) {
                reflow(spannable, i, i2 - i, i2 - i);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
            if (obj instanceof UpdateLayout) {
                reflow(spannable, i, i2 - i, i2 - i);
                reflow(spannable, i3, i4 - i3, i4 - i3);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
            if (obj instanceof UpdateLayout) {
                reflow(spannable, i, i2 - i, i2 - i);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            reflow(charSequence, i, i2, i3);
        }
    }

    public DynamicLayout(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, float f, float f2, boolean z) {
        this(charSequence, charSequence, textPaint, i, alignment, f, f2, z);
    }

    public DynamicLayout(CharSequence charSequence, CharSequence charSequence2, TextPaint textPaint, int i, Layout.Alignment alignment, float f, float f2, boolean z) {
        this(charSequence, charSequence2, textPaint, i, alignment, f, f2, z, null, 0);
    }

    public DynamicLayout(CharSequence charSequence, CharSequence charSequence2, TextPaint textPaint, int i, Layout.Alignment alignment, float f, float f2, boolean z, TextUtils.TruncateAt truncateAt, int i2) {
        this(charSequence, charSequence2, textPaint, i, alignment, TextDirectionHeuristics.FIRSTSTRONG_LTR, f, f2, z, truncateAt, i2);
    }

    public DynamicLayout(CharSequence charSequence, CharSequence charSequence2, TextPaint textPaint, int i, Layout.Alignment alignment, TextDirectionHeuristic textDirectionHeuristic, float f, float f2, boolean z, TextUtils.TruncateAt truncateAt, int i2) {
        super(truncateAt == null ? charSequence2 : charSequence2 instanceof Spanned ? new Layout.SpannedEllipsizer(charSequence2) : new Layout.Ellipsizer(charSequence2), textPaint, i, alignment, textDirectionHeuristic, f, f2);
        int[] iArr;
        this.mBase = charSequence;
        this.mDisplay = charSequence2;
        if (truncateAt != null) {
            this.mInts = new PackedIntVector(5);
            this.mEllipsizedWidth = i2;
            this.mEllipsizeAt = truncateAt;
        } else {
            this.mInts = new PackedIntVector(3);
            this.mEllipsizedWidth = i;
            this.mEllipsizeAt = null;
        }
        this.mObjects = new PackedObjectVector<>(1);
        this.mIncludePad = z;
        if (truncateAt != null) {
            Layout.Ellipsizer ellipsizer = (Layout.Ellipsizer) getText();
            ellipsizer.mLayout = this;
            ellipsizer.mWidth = i2;
            ellipsizer.mMethod = truncateAt;
            this.mEllipsize = true;
        }
        if (truncateAt != null) {
            iArr = new int[5];
            iArr[3] = Integer.MIN_VALUE;
        } else {
            iArr = new int[3];
        }
        Layout.Directions directions = DIRS_ALL_LEFT_TO_RIGHT;
        Paint.FontMetricsInt fontMetricsInt = textPaint.getFontMetricsInt();
        int i3 = fontMetricsInt.ascent;
        int i4 = fontMetricsInt.descent;
        iArr[0] = 1073741824;
        iArr[1] = 0;
        iArr[2] = i4;
        this.mInts.insertAt(0, iArr);
        iArr[1] = i4 - i3;
        this.mInts.insertAt(1, iArr);
        this.mObjects.insertAt(0, new Layout.Directions[]{directions});
        reflow(charSequence, 0, 0, charSequence.length());
        if (!(charSequence instanceof Spannable)) {
            return;
        }
        if (this.mWatcher == null) {
            this.mWatcher = new ChangeWatcher(this);
        }
        Spannable spannable = (Spannable) charSequence;
        ChangeWatcher[] changeWatcherArr = (ChangeWatcher[]) spannable.getSpans(0, spannable.length(), ChangeWatcher.class);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= changeWatcherArr.length) {
                spannable.setSpan(this.mWatcher, 0, charSequence.length(), 8388626);
                return;
            } else {
                spannable.removeSpan(changeWatcherArr[i6]);
                i5 = i6 + 1;
            }
        }
    }

    private void addBlockAtOffset(int i) {
        int lineForOffset = getLineForOffset(i);
        if (this.mBlockEndLines == null) {
            this.mBlockEndLines = ArrayUtils.newUnpaddedIntArray(1);
            this.mBlockEndLines[this.mNumberOfBlocks] = lineForOffset;
            this.mNumberOfBlocks++;
        } else if (lineForOffset > this.mBlockEndLines[this.mNumberOfBlocks - 1]) {
            this.mBlockEndLines = GrowingArrayUtils.append(this.mBlockEndLines, this.mNumberOfBlocks, lineForOffset);
            this.mNumberOfBlocks++;
        }
    }

    private void createBlocks() {
        int i = 400;
        this.mNumberOfBlocks = 0;
        CharSequence charSequence = this.mDisplay;
        while (true) {
            int indexOf = TextUtils.indexOf(charSequence, '\n', i);
            if (indexOf < 0) {
                break;
            }
            addBlockAtOffset(indexOf);
            i = indexOf + 400;
        }
        addBlockAtOffset(charSequence.length());
        this.mBlockIndices = new int[this.mBlockEndLines.length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mBlockEndLines.length) {
                return;
            }
            this.mBlockIndices[i3] = -1;
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reflow(CharSequence charSequence, int i, int i2, int i3) {
        StaticLayout staticLayout;
        int[] iArr;
        boolean z;
        int i4;
        int i5;
        int i6;
        if (charSequence != this.mBase) {
            return;
        }
        CharSequence charSequence2 = this.mDisplay;
        int length = charSequence2.length();
        int lastIndexOf = TextUtils.lastIndexOf(charSequence2, '\n', i - 1);
        int i7 = i - (lastIndexOf < 0 ? 0 : lastIndexOf + 1);
        int i8 = i3 + i7;
        int i9 = i - i7;
        int indexOf = TextUtils.indexOf(charSequence2, '\n', i9 + i8);
        int i10 = (indexOf < 0 ? length : indexOf + 1) - (i9 + i8);
        int i11 = i2 + i7 + i10;
        int i12 = i8 + i10;
        int i13 = i9;
        int i14 = i11;
        int i15 = i12;
        if (charSequence2 instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence2;
            int i16 = i11;
            int i17 = i9;
            do {
                z = false;
                Object[] spans = spanned.getSpans(i17, i17 + i12, WrapTogetherSpan.class);
                i4 = i12;
                i5 = i16;
                i6 = i17;
                int i18 = 0;
                while (i18 < spans.length) {
                    int spanStart = spanned.getSpanStart(spans[i18]);
                    int spanEnd = spanned.getSpanEnd(spans[i18]);
                    boolean z2 = z;
                    int i19 = i6;
                    int i20 = i5;
                    int i21 = i4;
                    if (spanStart < i6) {
                        z2 = true;
                        int i22 = i6 - spanStart;
                        i20 = i5 + i22;
                        i21 = i4 + i22;
                        i19 = i6 - i22;
                    }
                    i5 = i20;
                    i4 = i21;
                    if (spanEnd > i19 + i21) {
                        z2 = true;
                        int i23 = spanEnd - (i19 + i21);
                        i5 = i20 + i23;
                        i4 = i21 + i23;
                    }
                    i18++;
                    z = z2;
                    i6 = i19;
                }
                i17 = i6;
                i16 = i5;
                i12 = i4;
            } while (z);
            i15 = i4;
            i14 = i5;
            i13 = i6;
        }
        int lineForOffset = getLineForOffset(i13);
        int lineTop = getLineTop(lineForOffset);
        int lineForOffset2 = getLineForOffset(i13 + i14);
        if (i13 + i15 == length) {
            lineForOffset2 = getLineCount();
        }
        int lineTop2 = getLineTop(lineForOffset2);
        boolean z3 = lineForOffset2 == getLineCount();
        synchronized (sLock) {
            staticLayout = sStaticLayout;
            sStaticLayout = null;
        }
        if (staticLayout == null) {
            staticLayout = new StaticLayout(null);
        } else {
            staticLayout.prepare();
        }
        staticLayout.generate(charSequence2, i13, i13 + i15, getPaint(), getWidth(), getTextDirectionHeuristic(), getSpacingMultiplier(), getSpacingAdd(), false, true, this.mEllipsizedWidth, this.mEllipsizeAt);
        int lineCount = staticLayout.getLineCount();
        int i24 = lineCount;
        if (i13 + i15 != length) {
            i24 = lineCount;
            if (staticLayout.getLineStart(lineCount - 1) == i13 + i15) {
                i24 = lineCount - 1;
            }
        }
        this.mInts.deleteAt(lineForOffset, lineForOffset2 - lineForOffset);
        this.mObjects.deleteAt(lineForOffset, lineForOffset2 - lineForOffset);
        int lineTop3 = staticLayout.getLineTop(i24);
        int i25 = lineTop3;
        int i26 = 0;
        if (this.mIncludePad) {
            i25 = lineTop3;
            i26 = 0;
            if (lineForOffset == 0) {
                i26 = staticLayout.getTopPadding();
                this.mTopPadding = i26;
                i25 = lineTop3 - i26;
            }
        }
        int i27 = 0;
        int i28 = i25;
        if (this.mIncludePad) {
            i27 = 0;
            i28 = i25;
            if (z3) {
                i27 = staticLayout.getBottomPadding();
                this.mBottomPadding = i27;
                i28 = i25 + i27;
            }
        }
        this.mInts.adjustValuesBelow(lineForOffset, 0, i15 - i14);
        this.mInts.adjustValuesBelow(lineForOffset, 1, (lineTop - lineTop2) + i28);
        if (this.mEllipsize) {
            iArr = new int[5];
            iArr[3] = Integer.MIN_VALUE;
        } else {
            iArr = new int[3];
        }
        Layout.Directions[] directionsArr = new Layout.Directions[1];
        int i29 = 0;
        while (true) {
            int i30 = i29;
            if (i30 >= i24) {
                updateBlocks(lineForOffset, lineForOffset2 - 1, i24);
                synchronized (sLock) {
                    sStaticLayout = staticLayout;
                    staticLayout.finish();
                }
                return;
            }
            iArr[0] = (staticLayout.getLineContainsTab(i30) ? 536870912 : 0) | (staticLayout.getParagraphDirection(i30) << 30) | staticLayout.getLineStart(i30);
            int lineTop4 = staticLayout.getLineTop(i30) + lineTop;
            int i31 = lineTop4;
            if (i30 > 0) {
                i31 = lineTop4 - i26;
            }
            iArr[1] = i31;
            int lineDescent = staticLayout.getLineDescent(i30);
            int i32 = lineDescent;
            if (i30 == i24 - 1) {
                i32 = lineDescent + i27;
            }
            iArr[2] = i32;
            directionsArr[0] = staticLayout.getLineDirections(i30);
            if (this.mEllipsize) {
                iArr[3] = staticLayout.getEllipsisStart(i30);
                iArr[4] = staticLayout.getEllipsisCount(i30);
            }
            this.mInts.insertAt(lineForOffset + i30, iArr);
            this.mObjects.insertAt(lineForOffset + i30, directionsArr);
            i29 = i30 + 1;
        }
    }

    public int[] getBlockEndLines() {
        return this.mBlockEndLines;
    }

    public int[] getBlockIndices() {
        return this.mBlockIndices;
    }

    @Override // android.text.Layout
    public int getBottomPadding() {
        return this.mBottomPadding;
    }

    @Override // android.text.Layout
    public int getEllipsisCount(int i) {
        if (this.mEllipsizeAt == null) {
            return 0;
        }
        return this.mInts.getValue(i, 4);
    }

    @Override // android.text.Layout
    public int getEllipsisStart(int i) {
        if (this.mEllipsizeAt == null) {
            return 0;
        }
        return this.mInts.getValue(i, 3);
    }

    @Override // android.text.Layout
    public int getEllipsizedWidth() {
        return this.mEllipsizedWidth;
    }

    public int getIndexFirstChangedBlock() {
        return this.mIndexFirstChangedBlock;
    }

    @Override // android.text.Layout
    public boolean getLineContainsTab(int i) {
        boolean z = false;
        if ((this.mInts.getValue(i, 0) & 536870912) != 0) {
            z = true;
        }
        return z;
    }

    @Override // android.text.Layout
    public int getLineCount() {
        return this.mInts.size() - 1;
    }

    @Override // android.text.Layout
    public int getLineDescent(int i) {
        return this.mInts.getValue(i, 2);
    }

    @Override // android.text.Layout
    public final Layout.Directions getLineDirections(int i) {
        return this.mObjects.getValue(i, 0);
    }

    @Override // android.text.Layout
    public int getLineStart(int i) {
        return this.mInts.getValue(i, 0) & 536870911;
    }

    @Override // android.text.Layout
    public int getLineTop(int i) {
        return this.mInts.getValue(i, 1);
    }

    public int getNumberOfBlocks() {
        return this.mNumberOfBlocks;
    }

    @Override // android.text.Layout
    public int getParagraphDirection(int i) {
        return this.mInts.getValue(i, 0) >> 30;
    }

    @Override // android.text.Layout
    public int getTopPadding() {
        return this.mTopPadding;
    }

    void setBlocksDataForTest(int[] iArr, int[] iArr2, int i) {
        this.mBlockEndLines = new int[iArr.length];
        this.mBlockIndices = new int[iArr2.length];
        System.arraycopy(iArr, 0, this.mBlockEndLines, 0, iArr.length);
        System.arraycopy(iArr2, 0, this.mBlockIndices, 0, iArr2.length);
        this.mNumberOfBlocks = i;
    }

    public void setIndexFirstChangedBlock(int i) {
        this.mIndexFirstChangedBlock = i;
    }

    void updateBlocks(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        if (this.mBlockEndLines == null) {
            createBlocks();
            return;
        }
        int i7 = 0;
        while (true) {
            int i8 = i7;
            i4 = -1;
            if (i8 >= this.mNumberOfBlocks) {
                break;
            } else if (this.mBlockEndLines[i8] >= i) {
                i4 = i8;
                break;
            } else {
                i7 = i8 + 1;
            }
        }
        int i9 = i4;
        while (true) {
            int i10 = i9;
            i5 = -1;
            if (i10 >= this.mNumberOfBlocks) {
                break;
            } else if (this.mBlockEndLines[i10] >= i2) {
                i5 = i10;
                break;
            } else {
                i9 = i10 + 1;
            }
        }
        int i11 = this.mBlockEndLines[i5];
        boolean z = i > (i4 == 0 ? 0 : this.mBlockEndLines[i4 - 1] + 1);
        boolean z2 = i3 > 0;
        boolean z3 = i2 < this.mBlockEndLines[i5];
        int i12 = 0;
        if (z) {
            i12 = 0 + 1;
        }
        int i13 = i12;
        if (z2) {
            i13 = i12 + 1;
        }
        int i14 = i13;
        if (z3) {
            i14 = i13 + 1;
        }
        int i15 = (this.mNumberOfBlocks + i14) - ((i5 - i4) + 1);
        if (i15 == 0) {
            this.mBlockEndLines[0] = 0;
            this.mBlockIndices[0] = -1;
            this.mNumberOfBlocks = 1;
            return;
        }
        if (i15 > this.mBlockEndLines.length) {
            int[] newUnpaddedIntArray = ArrayUtils.newUnpaddedIntArray(Math.max(this.mBlockEndLines.length * 2, i15));
            int[] iArr = new int[newUnpaddedIntArray.length];
            System.arraycopy(this.mBlockEndLines, 0, newUnpaddedIntArray, 0, i4);
            System.arraycopy(this.mBlockIndices, 0, iArr, 0, i4);
            System.arraycopy(this.mBlockEndLines, i5 + 1, newUnpaddedIntArray, i4 + i14, (this.mNumberOfBlocks - i5) - 1);
            System.arraycopy(this.mBlockIndices, i5 + 1, iArr, i4 + i14, (this.mNumberOfBlocks - i5) - 1);
            this.mBlockEndLines = newUnpaddedIntArray;
            this.mBlockIndices = iArr;
        } else {
            System.arraycopy(this.mBlockEndLines, i5 + 1, this.mBlockEndLines, i4 + i14, (this.mNumberOfBlocks - i5) - 1);
            System.arraycopy(this.mBlockIndices, i5 + 1, this.mBlockIndices, i4 + i14, (this.mNumberOfBlocks - i5) - 1);
        }
        this.mNumberOfBlocks = i15;
        int i16 = i3 - ((i2 - i) + 1);
        if (i16 != 0) {
            int i17 = i4 + i14;
            int i18 = i17;
            while (true) {
                int i19 = i18;
                i6 = i17;
                if (i19 >= this.mNumberOfBlocks) {
                    break;
                }
                int[] iArr2 = this.mBlockEndLines;
                iArr2[i19] = iArr2[i19] + i16;
                i18 = i19 + 1;
            }
        } else {
            i6 = this.mNumberOfBlocks;
        }
        this.mIndexFirstChangedBlock = Math.min(this.mIndexFirstChangedBlock, i6);
        int i20 = i4;
        if (z) {
            this.mBlockEndLines[i4] = i - 1;
            this.mBlockIndices[i4] = -1;
            i20 = i4 + 1;
        }
        int i21 = i20;
        if (z2) {
            this.mBlockEndLines[i20] = (i + i3) - 1;
            this.mBlockIndices[i20] = -1;
            i21 = i20 + 1;
        }
        if (z3) {
            this.mBlockEndLines[i21] = i11 + i16;
            this.mBlockIndices[i21] = -1;
        }
    }
}
