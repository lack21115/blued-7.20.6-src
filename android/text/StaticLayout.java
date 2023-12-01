package android.text;

import android.graphics.Paint;
import android.text.Layout;
import android.text.TextUtils;
import android.text.style.LineHeightSpan;
import android.util.Log;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.GrowingArrayUtils;

/* loaded from: source-9557208-dex2jar.jar:android/text/StaticLayout.class */
public class StaticLayout extends Layout {
    private static final int CHAR_FIRST_HIGH_SURROGATE = 55296;
    private static final int CHAR_LAST_LOW_SURROGATE = 57343;
    private static final char CHAR_NEW_LINE = '\n';
    private static final char CHAR_SPACE = ' ';
    private static final char CHAR_TAB = '\t';
    private static final char CHAR_ZWSP = 8203;
    private static final int COLUMNS_ELLIPSIZE = 5;
    private static final int COLUMNS_NORMAL = 3;
    private static final int DESCENT = 2;
    private static final int DIR = 0;
    private static final int DIR_SHIFT = 30;
    private static final int ELLIPSIS_COUNT = 4;
    private static final int ELLIPSIS_START = 3;
    private static final double EXTRA_ROUNDING = 0.5d;
    private static final int START = 0;
    private static final int START_MASK = 536870911;
    private static final int TAB = 0;
    private static final int TAB_INCREMENT = 20;
    private static final int TAB_MASK = 536870912;
    static final String TAG = "StaticLayout";
    private static final int TOP = 1;
    private int mBottomPadding;
    private int mColumns;
    private int mEllipsizedWidth;
    private Paint.FontMetricsInt mFontMetricsInt;
    private int mLineCount;
    private Layout.Directions[] mLineDirections;
    private int[] mLines;
    private int mMaximumVisibleLineCount;
    private MeasuredText mMeasured;
    private int mTopPadding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StaticLayout(CharSequence charSequence) {
        super(charSequence, null, 0, null, 0.0f, 0.0f);
        this.mMaximumVisibleLineCount = Integer.MAX_VALUE;
        this.mFontMetricsInt = new Paint.FontMetricsInt();
        this.mColumns = 5;
        this.mLineDirections = (Layout.Directions[]) ArrayUtils.newUnpaddedArray(Layout.Directions.class, this.mColumns * 2);
        this.mLines = new int[this.mLineDirections.length];
        this.mMeasured = MeasuredText.obtain();
    }

    public StaticLayout(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, Layout.Alignment alignment, float f, float f2, boolean z) {
        this(charSequence, i, i2, textPaint, i3, alignment, f, f2, z, null, 0);
    }

    public StaticLayout(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, Layout.Alignment alignment, float f, float f2, boolean z, TextUtils.TruncateAt truncateAt, int i4) {
        this(charSequence, i, i2, textPaint, i3, alignment, TextDirectionHeuristics.FIRSTSTRONG_LTR, f, f2, z, truncateAt, i4, Integer.MAX_VALUE);
    }

    public StaticLayout(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, Layout.Alignment alignment, TextDirectionHeuristic textDirectionHeuristic, float f, float f2, boolean z) {
        this(charSequence, i, i2, textPaint, i3, alignment, textDirectionHeuristic, f, f2, z, null, 0, Integer.MAX_VALUE);
    }

    public StaticLayout(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, Layout.Alignment alignment, TextDirectionHeuristic textDirectionHeuristic, float f, float f2, boolean z, TextUtils.TruncateAt truncateAt, int i4, int i5) {
        super(truncateAt == null ? charSequence : charSequence instanceof Spanned ? new Layout.SpannedEllipsizer(charSequence) : new Layout.Ellipsizer(charSequence), textPaint, i3, alignment, textDirectionHeuristic, f, f2);
        this.mMaximumVisibleLineCount = Integer.MAX_VALUE;
        this.mFontMetricsInt = new Paint.FontMetricsInt();
        if (truncateAt != null) {
            Layout.Ellipsizer ellipsizer = (Layout.Ellipsizer) getText();
            ellipsizer.mLayout = this;
            ellipsizer.mWidth = i4;
            ellipsizer.mMethod = truncateAt;
            this.mEllipsizedWidth = i4;
            this.mColumns = 5;
        } else {
            this.mColumns = 3;
            this.mEllipsizedWidth = i3;
        }
        this.mLineDirections = (Layout.Directions[]) ArrayUtils.newUnpaddedArray(Layout.Directions.class, this.mColumns * 2);
        this.mLines = new int[this.mLineDirections.length];
        this.mMaximumVisibleLineCount = i5;
        this.mMeasured = MeasuredText.obtain();
        generate(charSequence, i, i2, textPaint, i3, textDirectionHeuristic, f, f2, z, z, i4, truncateAt);
        this.mMeasured = MeasuredText.recycle(this.mMeasured);
        this.mFontMetricsInt = null;
    }

    public StaticLayout(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, float f, float f2, boolean z) {
        this(charSequence, 0, charSequence.length(), textPaint, i, alignment, f, f2, z);
    }

    public StaticLayout(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, TextDirectionHeuristic textDirectionHeuristic, float f, float f2, boolean z) {
        this(charSequence, 0, charSequence.length(), textPaint, i, alignment, textDirectionHeuristic, f, f2, z);
    }

    private void calculateEllipsis(int i, int i2, float[] fArr, int i3, float f, TextUtils.TruncateAt truncateAt, int i4, float f2, TextPaint textPaint, boolean z) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if (f2 <= f && !z) {
            this.mLines[(this.mColumns * i4) + 3] = 0;
            this.mLines[(this.mColumns * i4) + 4] = 0;
            return;
        }
        float measureText = textPaint.measureText(truncateAt == TextUtils.TruncateAt.END_SMALL ? TextUtils.ELLIPSIS_TWO_DOTS : TextUtils.ELLIPSIS_NORMAL, 0, 1);
        int i10 = i2 - i;
        if (truncateAt == TextUtils.TruncateAt.START) {
            if (this.mMaximumVisibleLineCount == 1) {
                float f3 = 0.0f;
                int i11 = i10;
                while (true) {
                    i9 = i11;
                    if (i9 <= 0) {
                        break;
                    }
                    float f4 = fArr[((i9 - 1) + i) - i3];
                    if (f4 + f3 + measureText > f) {
                        break;
                    }
                    f3 += f4;
                    i11 = i9 - 1;
                }
                i6 = i9;
                i7 = 0;
            } else {
                i6 = 0;
                i7 = 0;
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Start Ellipsis only supported with one line");
                    i6 = 0;
                    i7 = 0;
                }
            }
        } else if (truncateAt == TextUtils.TruncateAt.END || truncateAt == TextUtils.TruncateAt.MARQUEE || truncateAt == TextUtils.TruncateAt.END_SMALL) {
            float f5 = 0.0f;
            int i12 = 0;
            while (true) {
                i5 = i12;
                if (i5 >= i10) {
                    break;
                }
                float f6 = fArr[(i5 + i) - i3];
                if (f6 + f5 + measureText > f) {
                    break;
                }
                f5 += f6;
                i12 = i5 + 1;
            }
            int i13 = i10 - i5;
            i6 = i13;
            i7 = i5;
            if (z) {
                i6 = i13;
                i7 = i5;
                if (i13 == 0) {
                    i6 = i13;
                    i7 = i5;
                    if (i10 > 0) {
                        i7 = i10 - 1;
                        i6 = 1;
                    }
                }
            }
        } else if (this.mMaximumVisibleLineCount == 1) {
            float f7 = 0.0f;
            float f8 = 0.0f;
            float f9 = (f - measureText) / 2.0f;
            while (i10 > 0) {
                float f10 = fArr[((i10 - 1) + i) - i3];
                if (f10 + f8 > f9) {
                    break;
                }
                f8 += f10;
                i10--;
            }
            int i14 = 0;
            while (true) {
                i8 = i14;
                if (i8 >= i10) {
                    break;
                }
                float f11 = fArr[(i8 + i) - i3];
                if (f11 + f7 > (f - measureText) - f8) {
                    break;
                }
                f7 += f11;
                i14 = i8 + 1;
            }
            i6 = i10 - i8;
            i7 = i8;
        } else {
            i6 = 0;
            i7 = 0;
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Middle Ellipsis only supported with one line");
                i6 = 0;
                i7 = 0;
            }
        }
        this.mLines[(this.mColumns * i4) + 3] = i7;
        this.mLines[(this.mColumns * i4) + 4] = i6;
    }

    private static native int[] nLineBreakOpportunities(String str, char[] cArr, int i, int[] iArr);

    private int out(CharSequence charSequence, int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, float f2, LineHeightSpan[] lineHeightSpanArr, int[] iArr, Paint.FontMetricsInt fontMetricsInt, boolean z, boolean z2, byte[] bArr, int i8, boolean z3, int i9, boolean z4, boolean z5, char[] cArr, float[] fArr, int i10, TextUtils.TruncateAt truncateAt, float f3, float f4, TextPaint textPaint, boolean z6) {
        int i11;
        int i12 = this.mLineCount;
        int i13 = i12 * this.mColumns;
        int i14 = this.mColumns + i13 + 1;
        int[] iArr2 = this.mLines;
        int[] iArr3 = iArr2;
        if (i14 >= iArr2.length) {
            Layout.Directions[] directionsArr = (Layout.Directions[]) ArrayUtils.newUnpaddedArray(Layout.Directions.class, GrowingArrayUtils.growSize(i14));
            System.arraycopy(this.mLineDirections, 0, directionsArr, 0, this.mLineDirections.length);
            this.mLineDirections = directionsArr;
            iArr3 = new int[directionsArr.length];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            this.mLines = iArr3;
        }
        int i15 = i3;
        int i16 = i4;
        int i17 = i5;
        int i18 = i6;
        if (lineHeightSpanArr != null) {
            fontMetricsInt.ascent = i3;
            fontMetricsInt.descent = i4;
            fontMetricsInt.top = i5;
            fontMetricsInt.bottom = i6;
            int i19 = 0;
            while (true) {
                int i20 = i19;
                if (i20 >= lineHeightSpanArr.length) {
                    break;
                }
                if (lineHeightSpanArr[i20] instanceof LineHeightSpan.WithDensity) {
                    ((LineHeightSpan.WithDensity) lineHeightSpanArr[i20]).chooseHeight(charSequence, i, i2, iArr[i20], i7, fontMetricsInt, textPaint);
                } else {
                    lineHeightSpanArr[i20].chooseHeight(charSequence, i, i2, iArr[i20], i7, fontMetricsInt);
                }
                i19 = i20 + 1;
            }
            i15 = fontMetricsInt.ascent;
            i16 = fontMetricsInt.descent;
            i17 = fontMetricsInt.top;
            i18 = fontMetricsInt.bottom;
        }
        boolean z7 = i12 == 0;
        boolean z8 = i12 + 1 == this.mMaximumVisibleLineCount;
        boolean z9 = z8 || i2 == i9;
        int i21 = i15;
        if (z7) {
            if (z5) {
                this.mTopPadding = i17 - i15;
            }
            i21 = i15;
            if (z4) {
                i21 = i17;
            }
        }
        int i22 = i16;
        if (z9) {
            if (z5) {
                this.mBottomPadding = i18 - i16;
            }
            i22 = i16;
            if (z4) {
                i22 = i18;
            }
        }
        if (!z2 || z9) {
            i11 = 0;
        } else {
            double d = ((i22 - i21) * (f - 1.0f)) + f2;
            i11 = d >= 0.0d ? (int) (EXTRA_ROUNDING + d) : -((int) ((-d) + EXTRA_ROUNDING));
        }
        iArr3[i13 + 0] = i;
        iArr3[i13 + 1] = i7;
        iArr3[i13 + 2] = i22 + i11;
        int i23 = i7 + (i22 - i21) + i11;
        iArr3[this.mColumns + i13 + 0] = i2;
        iArr3[this.mColumns + i13 + 1] = i23;
        if (z) {
            int i24 = i13 + 0;
            iArr3[i24] = iArr3[i24] | 536870912;
        }
        int i25 = i13 + 0;
        iArr3[i25] = iArr3[i25] | (i8 << 30);
        Layout.Directions directions = DIRS_ALL_LEFT_TO_RIGHT;
        if (z3) {
            this.mLineDirections[i12] = directions;
        } else {
            this.mLineDirections[i12] = AndroidBidi.directions(i8, bArr, i - i10, cArr, i - i10, i2 - i);
        }
        if (truncateAt != null) {
            boolean z10 = z6 && this.mLineCount + 1 == this.mMaximumVisibleLineCount;
            if ((((this.mMaximumVisibleLineCount == 1 && z6) || (z7 && !z6)) && truncateAt != TextUtils.TruncateAt.MARQUEE) || (!z7 && ((z8 || !z6) && truncateAt == TextUtils.TruncateAt.END))) {
                calculateEllipsis(i, i2, fArr, i10, f3, truncateAt, i12, f4, textPaint, z10);
            }
        }
        this.mLineCount++;
        return i23;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void finish() {
        this.mMeasured = MeasuredText.recycle(this.mMeasured);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x08be, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x096a, code lost:
        if (r34 == r33) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0978, code lost:
        if (r32.charAt(r34 - 1) != '\n') goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0983, code lost:
        if (r31.mLineCount >= r31.mMaximumVisibleLineCount) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0986, code lost:
        r0.setPara(r32, r33, r34, r37);
        r35.getFontMetricsInt(r0);
        out(r32, r34, r34, r0.ascent, r0.descent, r0.top, r0.bottom, r53, r38, r39, null, null, r0, false, r98, r0.mLevels, r0.mDir, r0.mEasy, r34, r40, r41, null, null, r33, r43, r42, 0.0f, r35, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x09e0, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x015c, code lost:
        if (r100.length < r0.length) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void generate(java.lang.CharSequence r32, int r33, int r34, android.text.TextPaint r35, int r36, android.text.TextDirectionHeuristic r37, float r38, float r39, boolean r40, boolean r41, float r42, android.text.TextUtils.TruncateAt r43) {
        /*
            Method dump skipped, instructions count: 2550
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.text.StaticLayout.generate(java.lang.CharSequence, int, int, android.text.TextPaint, int, android.text.TextDirectionHeuristic, float, float, boolean, boolean, float, android.text.TextUtils$TruncateAt):void");
    }

    @Override // android.text.Layout
    public int getBottomPadding() {
        return this.mBottomPadding;
    }

    @Override // android.text.Layout
    public int getEllipsisCount(int i) {
        if (this.mColumns < 5) {
            return 0;
        }
        return this.mLines[(this.mColumns * i) + 4];
    }

    @Override // android.text.Layout
    public int getEllipsisStart(int i) {
        if (this.mColumns < 5) {
            return 0;
        }
        return this.mLines[(this.mColumns * i) + 3];
    }

    @Override // android.text.Layout
    public int getEllipsizedWidth() {
        return this.mEllipsizedWidth;
    }

    @Override // android.text.Layout
    public boolean getLineContainsTab(int i) {
        return (this.mLines[(this.mColumns * i) + 0] & 536870912) != 0;
    }

    @Override // android.text.Layout
    public int getLineCount() {
        return this.mLineCount;
    }

    @Override // android.text.Layout
    public int getLineDescent(int i) {
        int i2 = this.mLines[(this.mColumns * i) + 2];
        int i3 = i2;
        if (this.mMaximumVisibleLineCount > 0) {
            i3 = i2;
            if (i >= this.mMaximumVisibleLineCount - 1) {
                i3 = i2;
                if (i != this.mLineCount) {
                    i3 = i2 + getBottomPadding();
                }
            }
        }
        return i3;
    }

    @Override // android.text.Layout
    public final Layout.Directions getLineDirections(int i) {
        return this.mLineDirections[i];
    }

    @Override // android.text.Layout
    public int getLineForVertical(int i) {
        int i2 = this.mLineCount;
        int i3 = -1;
        int[] iArr = this.mLines;
        while (i2 - i3 > 1) {
            int i4 = (i2 + i3) >> 1;
            if (iArr[(this.mColumns * i4) + 1] > i) {
                i2 = i4;
            } else {
                i3 = i4;
            }
        }
        int i5 = i3;
        if (i3 < 0) {
            i5 = 0;
        }
        return i5;
    }

    @Override // android.text.Layout
    public int getLineStart(int i) {
        return this.mLines[(this.mColumns * i) + 0] & 536870911;
    }

    @Override // android.text.Layout
    public int getLineTop(int i) {
        int i2 = this.mLines[(this.mColumns * i) + 1];
        int i3 = i2;
        if (this.mMaximumVisibleLineCount > 0) {
            i3 = i2;
            if (i >= this.mMaximumVisibleLineCount) {
                i3 = i2;
                if (i != this.mLineCount) {
                    i3 = i2 + getBottomPadding();
                }
            }
        }
        return i3;
    }

    @Override // android.text.Layout
    public int getParagraphDirection(int i) {
        return this.mLines[(this.mColumns * i) + 0] >> 30;
    }

    @Override // android.text.Layout
    public int getTopPadding() {
        return this.mTopPadding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void prepare() {
        this.mMeasured = MeasuredText.obtain();
    }
}
