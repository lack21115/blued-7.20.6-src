package android.text;

import android.emoji.EmojiFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextUtils;
import android.text.style.AlignmentSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.ParagraphStyle;
import android.text.style.ReplacementSpan;
import android.text.style.TabStopSpan;
import com.android.internal.util.ArrayUtils;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/text/Layout.class */
public abstract class Layout {
    static final Directions DIRS_ALL_LEFT_TO_RIGHT;
    static final Directions DIRS_ALL_RIGHT_TO_LEFT;
    public static final int DIR_LEFT_TO_RIGHT = 1;
    static final int DIR_REQUEST_DEFAULT_LTR = 2;
    static final int DIR_REQUEST_DEFAULT_RTL = -2;
    static final int DIR_REQUEST_LTR = 1;
    static final int DIR_REQUEST_RTL = -1;
    public static final int DIR_RIGHT_TO_LEFT = -1;
    static final int MAX_EMOJI;
    static final int MIN_EMOJI;
    static final int RUN_LENGTH_MASK = 67108863;
    static final int RUN_LEVEL_MASK = 63;
    static final int RUN_LEVEL_SHIFT = 26;
    static final int RUN_RTL_FLAG = 67108864;
    private static final int TAB_INCREMENT = 20;
    private static final Rect sTempRect;
    private Alignment mAlignment;
    private SpanSet<LineBackgroundSpan> mLineBackgroundSpans;
    private TextPaint mPaint;
    private float mSpacingAdd;
    private float mSpacingMult;
    private boolean mSpannedText;
    private CharSequence mText;
    private TextDirectionHeuristic mTextDir;
    private int mWidth;
    TextPaint mWorkPaint;
    private static final ParagraphStyle[] NO_PARA_SPANS = (ParagraphStyle[]) ArrayUtils.emptyArray(ParagraphStyle.class);
    static final EmojiFactory EMOJI_FACTORY = EmojiFactory.newAvailableInstance();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.text.Layout$1  reason: invalid class name */
    /* loaded from: source-9557208-dex2jar.jar:android/text/Layout$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$text$Layout$Alignment = new int[Alignment.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0022 -> B:11:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$android$text$Layout$Alignment[Alignment.ALIGN_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Alignment.ALIGN_NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/Layout$Alignment.class */
    public enum Alignment {
        ALIGN_NORMAL,
        ALIGN_OPPOSITE,
        ALIGN_CENTER,
        ALIGN_LEFT,
        ALIGN_RIGHT
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/Layout$Directions.class */
    public static class Directions {
        int[] mDirections;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Directions(int[] iArr) {
            this.mDirections = iArr;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/Layout$Ellipsizer.class */
    static class Ellipsizer implements CharSequence, GetChars {
        Layout mLayout;
        TextUtils.TruncateAt mMethod;
        CharSequence mText;
        int mWidth;

        public Ellipsizer(CharSequence charSequence) {
            this.mText = charSequence;
        }

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            char[] obtain = TextUtils.obtain(1);
            getChars(i, i + 1, obtain, 0);
            char c2 = obtain[0];
            TextUtils.recycle(obtain);
            return c2;
        }

        @Override // android.text.GetChars
        public void getChars(int i, int i2, char[] cArr, int i3) {
            int lineForOffset = this.mLayout.getLineForOffset(i2);
            TextUtils.getChars(this.mText, i, i2, cArr, i3);
            for (int lineForOffset2 = this.mLayout.getLineForOffset(i); lineForOffset2 <= lineForOffset; lineForOffset2++) {
                this.mLayout.ellipsize(i, i2, lineForOffset2, cArr, i3, this.mMethod);
            }
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.mText.length();
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            char[] cArr = new char[i2 - i];
            getChars(i, i2, cArr, 0);
            return new String(cArr);
        }

        @Override // java.lang.CharSequence
        public String toString() {
            char[] cArr = new char[length()];
            getChars(0, length(), cArr, 0);
            return new String(cArr);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/Layout$SpannedEllipsizer.class */
    static class SpannedEllipsizer extends Ellipsizer implements Spanned {
        private Spanned mSpanned;

        public SpannedEllipsizer(CharSequence charSequence) {
            super(charSequence);
            this.mSpanned = (Spanned) charSequence;
        }

        @Override // android.text.Spanned
        public int getSpanEnd(Object obj) {
            return this.mSpanned.getSpanEnd(obj);
        }

        @Override // android.text.Spanned
        public int getSpanFlags(Object obj) {
            return this.mSpanned.getSpanFlags(obj);
        }

        @Override // android.text.Spanned
        public int getSpanStart(Object obj) {
            return this.mSpanned.getSpanStart(obj);
        }

        @Override // android.text.Spanned
        public <T> T[] getSpans(int i, int i2, Class<T> cls) {
            return (T[]) this.mSpanned.getSpans(i, i2, cls);
        }

        @Override // android.text.Spanned
        public int nextSpanTransition(int i, int i2, Class cls) {
            return this.mSpanned.nextSpanTransition(i, i2, cls);
        }

        @Override // android.text.Layout.Ellipsizer, java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            char[] cArr = new char[i2 - i];
            getChars(i, i2, cArr, 0);
            SpannableString spannableString = new SpannableString(new String(cArr));
            TextUtils.copySpansFrom(this.mSpanned, i, i2, Object.class, spannableString, 0);
            return spannableString;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/Layout$TabStops.class */
    public static class TabStops {
        private int mIncrement;
        private int mNumStops;
        private int[] mStops;

        /* JADX INFO: Access modifiers changed from: package-private */
        public TabStops(int i, Object[] objArr) {
            reset(i, objArr);
        }

        public static float nextDefaultStop(float f, int i) {
            return ((int) ((i + f) / i)) * i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float nextTab(float f) {
            int i = this.mNumStops;
            if (i > 0) {
                int[] iArr = this.mStops;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= i) {
                        break;
                    }
                    int i4 = iArr[i3];
                    if (i4 > f) {
                        return i4;
                    }
                    i2 = i3 + 1;
                }
            }
            return nextDefaultStop(f, this.mIncrement);
        }

        void reset(int i, Object[] objArr) {
            int[] iArr;
            this.mIncrement = i;
            int i2 = 0;
            if (objArr != null) {
                int[] iArr2 = this.mStops;
                int length = objArr.length;
                int i3 = 0;
                i2 = 0;
                while (i3 < length) {
                    Object obj = objArr[i3];
                    if (obj instanceof TabStopSpan) {
                        if (iArr2 == null) {
                            iArr = new int[10];
                        } else {
                            iArr = iArr2;
                            if (i2 == iArr2.length) {
                                iArr = new int[i2 * 2];
                                int i4 = 0;
                                while (true) {
                                    int i5 = i4;
                                    if (i5 >= i2) {
                                        break;
                                    }
                                    iArr[i5] = iArr2[i5];
                                    i4 = i5 + 1;
                                }
                            }
                        }
                        iArr[i2] = ((TabStopSpan) obj).getTabStop();
                        i2++;
                    } else {
                        iArr = iArr2;
                    }
                    i3++;
                    iArr2 = iArr;
                }
                if (i2 > 1) {
                    Arrays.sort(iArr2, 0, i2);
                }
                if (iArr2 != this.mStops) {
                    this.mStops = iArr2;
                }
            }
            this.mNumStops = i2;
        }
    }

    static {
        if (EMOJI_FACTORY != null) {
            EmojiFactory emojiFactory = EMOJI_FACTORY;
            throw new VerifyError("bad dex opcode");
        }
        MIN_EMOJI = -1;
        MAX_EMOJI = -1;
        sTempRect = new Rect();
        DIRS_ALL_LEFT_TO_RIGHT = new Directions(new int[]{0, RUN_LENGTH_MASK});
        DIRS_ALL_RIGHT_TO_LEFT = new Directions(new int[]{0, 134217727});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Layout(CharSequence charSequence, TextPaint textPaint, int i, Alignment alignment, float f, float f2) {
        this(charSequence, textPaint, i, alignment, TextDirectionHeuristics.FIRSTSTRONG_LTR, f, f2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Layout(CharSequence charSequence, TextPaint textPaint, int i, Alignment alignment, TextDirectionHeuristic textDirectionHeuristic, float f, float f2) {
        this.mAlignment = Alignment.ALIGN_NORMAL;
        if (i < 0) {
            throw new IllegalArgumentException("Layout: " + i + " < 0");
        }
        if (textPaint != null) {
            textPaint.bgColor = 0;
            textPaint.baselineShift = 0;
        }
        this.mText = charSequence;
        this.mPaint = textPaint;
        this.mWorkPaint = new TextPaint();
        this.mWidth = i;
        this.mAlignment = alignment;
        this.mSpacingMult = f;
        this.mSpacingAdd = f2;
        this.mSpannedText = charSequence instanceof Spanned;
        this.mTextDir = textDirectionHeuristic;
    }

    private void addSelection(int i, int i2, int i3, int i4, int i5, Path path) {
        int max;
        int min;
        int lineStart = getLineStart(i);
        int lineEnd = getLineEnd(i);
        Directions lineDirections = getLineDirections(i);
        int i6 = lineEnd;
        if (lineEnd > lineStart) {
            i6 = lineEnd;
            if (this.mText.charAt(lineEnd - 1) == '\n') {
                i6 = lineEnd - 1;
            }
        }
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= lineDirections.mDirections.length) {
                return;
            }
            int i9 = lineStart + lineDirections.mDirections[i8];
            int i10 = i9 + (lineDirections.mDirections[i8 + 1] & RUN_LENGTH_MASK);
            int i11 = i10;
            if (i10 > i6) {
                i11 = i6;
            }
            if (i2 <= i11 && i3 >= i9 && (max = Math.max(i2, i9)) != (min = Math.min(i3, i11))) {
                float horizontal = getHorizontal(max, false, i, false);
                float horizontal2 = getHorizontal(min, true, i, false);
                path.addRect(Math.min(horizontal, horizontal2), i4, Math.max(horizontal, horizontal2), i5, Path.Direction.CW);
            }
            i7 = i8 + 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ellipsize(int i, int i2, int i3, char[] cArr, int i4, TextUtils.TruncateAt truncateAt) {
        int ellipsisCount = getEllipsisCount(i3);
        if (ellipsisCount == 0) {
            return;
        }
        int ellipsisStart = getEllipsisStart(i3);
        int lineStart = getLineStart(i3);
        int i5 = ellipsisStart;
        while (true) {
            int i6 = i5;
            if (i6 >= ellipsisStart + ellipsisCount) {
                return;
            }
            char ellipsisChar = i6 == ellipsisStart ? getEllipsisChar(truncateAt) : (char) 65279;
            int i7 = i6 + lineStart;
            if (i7 >= i && i7 < i2) {
                cArr[(i4 + i7) - i] = ellipsisChar;
            }
            i5 = i6 + 1;
        }
    }

    public static float getDesiredWidth(CharSequence charSequence, int i, int i2, TextPaint textPaint) {
        float f = 0.0f;
        while (true) {
            float f2 = f;
            if (i > i2) {
                return f2;
            }
            int indexOf = TextUtils.indexOf(charSequence, '\n', i, i2);
            int i3 = indexOf;
            if (indexOf < 0) {
                i3 = i2;
            }
            float measurePara = measurePara(textPaint, charSequence, i, i3);
            float f3 = f2;
            if (measurePara > f2) {
                f3 = measurePara;
            }
            i = i3 + 1;
            f = f3;
        }
    }

    public static float getDesiredWidth(CharSequence charSequence, TextPaint textPaint) {
        return getDesiredWidth(charSequence, 0, charSequence.length(), textPaint);
    }

    private char getEllipsisChar(TextUtils.TruncateAt truncateAt) {
        return truncateAt == TextUtils.TruncateAt.END_SMALL ? TextUtils.ELLIPSIS_TWO_DOTS[0] : TextUtils.ELLIPSIS_NORMAL[0];
    }

    private float getHorizontal(int i, boolean z, int i2, boolean z2) {
        int lineStart = getLineStart(i2);
        int lineEnd = getLineEnd(i2);
        int paragraphDirection = getParagraphDirection(i2);
        boolean lineContainsTab = getLineContainsTab(i2);
        Directions lineDirections = getLineDirections(i2);
        TabStops tabStops = null;
        if (lineContainsTab) {
            tabStops = null;
            if (this.mText instanceof Spanned) {
                TabStopSpan[] tabStopSpanArr = (TabStopSpan[]) getParagraphSpans((Spanned) this.mText, lineStart, lineEnd, TabStopSpan.class);
                tabStops = null;
                if (tabStopSpanArr.length > 0) {
                    tabStops = new TabStops(20, tabStopSpanArr);
                }
            }
        }
        TextLine obtain = TextLine.obtain();
        obtain.set(this.mPaint, this.mText, lineStart, lineEnd, paragraphDirection, lineDirections, lineContainsTab, tabStops);
        float measure = obtain.measure(i - lineStart, z, null);
        TextLine.recycle(obtain);
        float f = measure;
        if (z2) {
            f = measure;
            if (measure > this.mWidth) {
                f = this.mWidth;
            }
        }
        return getLineStartPos(i2, getParagraphLeft(i2), getParagraphRight(i2)) + f;
    }

    private float getHorizontal(int i, boolean z, boolean z2) {
        return getHorizontal(i, z, getLineForOffset(i), z2);
    }

    private float getLineExtent(int i, TabStops tabStops, boolean z) {
        int lineStart = getLineStart(i);
        int lineEnd = z ? getLineEnd(i) : getLineVisibleEnd(i);
        boolean lineContainsTab = getLineContainsTab(i);
        Directions lineDirections = getLineDirections(i);
        int paragraphDirection = getParagraphDirection(i);
        TextLine obtain = TextLine.obtain();
        obtain.set(this.mPaint, this.mText, lineStart, lineEnd, paragraphDirection, lineDirections, lineContainsTab, tabStops);
        float metrics = obtain.metrics(null);
        TextLine.recycle(obtain);
        return metrics;
    }

    private float getLineExtent(int i, boolean z) {
        int lineStart = getLineStart(i);
        int lineEnd = z ? getLineEnd(i) : getLineVisibleEnd(i);
        boolean lineContainsTab = getLineContainsTab(i);
        TabStops tabStops = null;
        if (lineContainsTab) {
            tabStops = null;
            if (this.mText instanceof Spanned) {
                TabStopSpan[] tabStopSpanArr = (TabStopSpan[]) getParagraphSpans((Spanned) this.mText, lineStart, lineEnd, TabStopSpan.class);
                tabStops = null;
                if (tabStopSpanArr.length > 0) {
                    tabStops = new TabStops(20, tabStopSpanArr);
                }
            }
        }
        Directions lineDirections = getLineDirections(i);
        if (lineDirections == null) {
            return 0.0f;
        }
        int paragraphDirection = getParagraphDirection(i);
        TextLine obtain = TextLine.obtain();
        obtain.set(this.mPaint, this.mText, lineStart, lineEnd, paragraphDirection, lineDirections, lineContainsTab, tabStops);
        float metrics = obtain.metrics(null);
        TextLine.recycle(obtain);
        return metrics;
    }

    private int getLineStartPos(int i, int i2, int i3) {
        Alignment alignment;
        Alignment paragraphAlignment = getParagraphAlignment(i);
        int paragraphDirection = getParagraphDirection(i);
        if (paragraphAlignment == Alignment.ALIGN_LEFT) {
            alignment = paragraphDirection == 1 ? Alignment.ALIGN_NORMAL : Alignment.ALIGN_OPPOSITE;
        } else {
            alignment = paragraphAlignment;
            if (paragraphAlignment == Alignment.ALIGN_RIGHT) {
                alignment = paragraphDirection == 1 ? Alignment.ALIGN_OPPOSITE : Alignment.ALIGN_NORMAL;
            }
        }
        if (alignment == Alignment.ALIGN_NORMAL) {
            return paragraphDirection == 1 ? i2 : i3;
        }
        TabStops tabStops = null;
        if (this.mSpannedText) {
            tabStops = null;
            if (getLineContainsTab(i)) {
                Spanned spanned = (Spanned) this.mText;
                int lineStart = getLineStart(i);
                TabStopSpan[] tabStopSpanArr = (TabStopSpan[]) getParagraphSpans(spanned, lineStart, spanned.nextSpanTransition(lineStart, spanned.length(), TabStopSpan.class), TabStopSpan.class);
                tabStops = null;
                if (tabStopSpanArr.length > 0) {
                    tabStops = new TabStops(20, tabStopSpanArr);
                }
            }
        }
        int lineExtent = (int) getLineExtent(i, tabStops, false);
        return alignment == Alignment.ALIGN_OPPOSITE ? paragraphDirection == 1 ? i3 - lineExtent : i2 - lineExtent : ((i2 + i3) - (lineExtent & (-2))) >> 1;
    }

    private int getLineVisibleEnd(int i, int i2, int i3) {
        CharSequence charSequence = this.mText;
        int i4 = i3;
        if (i == getLineCount() - 1) {
            return i3;
        }
        while (i4 > i2) {
            char charAt = charSequence.charAt(i4 - 1);
            if (charAt != '\n') {
                if (charAt != ' ' && charAt != '\t') {
                    break;
                }
                i4--;
            } else {
                return i4 - 1;
            }
        }
        return i4;
    }

    private int getOffsetAtStartOf(int i) {
        if (i == 0) {
            return 0;
        }
        CharSequence charSequence = this.mText;
        char charAt = charSequence.charAt(i);
        int i2 = i;
        if (charAt >= 56320) {
            i2 = i;
            if (charAt <= 57343) {
                char charAt2 = charSequence.charAt(i - 1);
                i2 = i;
                if (charAt2 >= 55296) {
                    i2 = i;
                    if (charAt2 <= 56319) {
                        i2 = i - 1;
                    }
                }
            }
        }
        int i3 = i2;
        if (this.mSpannedText) {
            ReplacementSpan[] replacementSpanArr = (ReplacementSpan[]) ((Spanned) charSequence).getSpans(i2, i2, ReplacementSpan.class);
            int i4 = 0;
            while (true) {
                i3 = i2;
                if (i4 >= replacementSpanArr.length) {
                    break;
                }
                int spanStart = ((Spanned) charSequence).getSpanStart(replacementSpanArr[i4]);
                int spanEnd = ((Spanned) charSequence).getSpanEnd(replacementSpanArr[i4]);
                int i5 = i2;
                if (spanStart < i2) {
                    i5 = i2;
                    if (spanEnd > i2) {
                        i5 = spanStart;
                    }
                }
                i4++;
                i2 = i5;
            }
        }
        return i3;
    }

    private int getOffsetToLeftRightOf(int i, boolean z) {
        int i2;
        int lineForOffset = getLineForOffset(i);
        int lineStart = getLineStart(lineForOffset);
        int lineEnd = getLineEnd(lineForOffset);
        int paragraphDirection = getParagraphDirection(lineForOffset);
        boolean z2 = false;
        if (z == (paragraphDirection == -1)) {
            i2 = lineForOffset;
            if (i == lineEnd) {
                if (lineForOffset >= getLineCount() - 1) {
                    return i;
                }
                z2 = true;
                i2 = lineForOffset + 1;
            }
        } else {
            i2 = lineForOffset;
            if (i == lineStart) {
                if (lineForOffset <= 0) {
                    return i;
                }
                z2 = true;
                i2 = lineForOffset - 1;
            }
        }
        int i3 = paragraphDirection;
        boolean z3 = z;
        if (z2) {
            int lineStart2 = getLineStart(i2);
            int lineEnd2 = getLineEnd(i2);
            int paragraphDirection2 = getParagraphDirection(i2);
            lineStart = lineStart2;
            lineEnd = lineEnd2;
            i3 = paragraphDirection;
            z3 = z;
            if (paragraphDirection2 != paragraphDirection) {
                i3 = paragraphDirection2;
                z3 = !z;
                lineEnd = lineEnd2;
                lineStart = lineStart2;
            }
        }
        Directions lineDirections = getLineDirections(i2);
        TextLine obtain = TextLine.obtain();
        obtain.set(this.mPaint, this.mText, lineStart, lineEnd, i3, lineDirections, false, null);
        int offsetToLeftRightOf = obtain.getOffsetToLeftRightOf(i - lineStart, z3);
        TextLine.recycle(obtain);
        return lineStart + offsetToLeftRightOf;
    }

    private int getParagraphLeadingMargin(int i) {
        int i2;
        if (this.mSpannedText) {
            Spanned spanned = (Spanned) this.mText;
            int lineStart = getLineStart(i);
            LeadingMarginSpan[] leadingMarginSpanArr = (LeadingMarginSpan[]) getParagraphSpans(spanned, lineStart, spanned.nextSpanTransition(lineStart, getLineEnd(i), LeadingMarginSpan.class), LeadingMarginSpan.class);
            if (leadingMarginSpanArr.length != 0) {
                boolean z = lineStart == 0 || spanned.charAt(lineStart - 1) == '\n';
                int i3 = 0;
                while (i3 < leadingMarginSpanArr.length) {
                    boolean z2 = z;
                    if (leadingMarginSpanArr[i3] instanceof LeadingMarginSpan.LeadingMarginSpan2) {
                        z2 = z | (i < getLineForOffset(spanned.getSpanStart(leadingMarginSpanArr[i3])) + ((LeadingMarginSpan.LeadingMarginSpan2) leadingMarginSpanArr[i3]).getLeadingMarginLineCount());
                    }
                    i3++;
                    z = z2;
                }
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    i2 = i5;
                    if (i4 >= leadingMarginSpanArr.length) {
                        break;
                    }
                    i5 += leadingMarginSpanArr[i4].getLeadingMargin(z);
                    i4++;
                }
            } else {
                return 0;
            }
        } else {
            i2 = 0;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] getParagraphSpans(Spanned spanned, int i, int i2, Class<T> cls) {
        return (i != i2 || i <= 0) ? (T[]) spanned.getSpans(i, i2, cls) : (T[]) ArrayUtils.emptyArray(cls);
    }

    static float measurePara(TextPaint textPaint, CharSequence charSequence, int i, int i2) {
        Directions directions;
        int i3;
        boolean z;
        TabStops tabStops;
        MeasuredText obtain = MeasuredText.obtain();
        TextLine obtain2 = TextLine.obtain();
        try {
            obtain.setPara(charSequence, i, i2, TextDirectionHeuristics.LTR);
            if (obtain.mEasy) {
                directions = DIRS_ALL_LEFT_TO_RIGHT;
                i3 = 1;
            } else {
                directions = AndroidBidi.directions(obtain.mDir, obtain.mLevels, 0, obtain.mChars, 0, obtain.mLen);
                i3 = obtain.mDir;
            }
            char[] cArr = obtain.mChars;
            int i4 = obtain.mLen;
            int i5 = 0;
            int i6 = 0;
            if (charSequence instanceof Spanned) {
                LeadingMarginSpan[] leadingMarginSpanArr = (LeadingMarginSpan[]) getParagraphSpans((Spanned) charSequence, i, i2, LeadingMarginSpan.class);
                int length = leadingMarginSpanArr.length;
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    i5 = i6;
                    if (i8 >= length) {
                        break;
                    }
                    i6 += leadingMarginSpanArr[i8].getLeadingMargin(true);
                    i7 = i8 + 1;
                }
            }
            int i9 = 0;
            while (true) {
                int i10 = i9;
                z = false;
                tabStops = null;
                if (i10 >= i4) {
                    break;
                } else if (cArr[i10] == '\t') {
                    z = true;
                    tabStops = null;
                    if (charSequence instanceof Spanned) {
                        Spanned spanned = (Spanned) charSequence;
                        TabStopSpan[] tabStopSpanArr = (TabStopSpan[]) getParagraphSpans(spanned, i, spanned.nextSpanTransition(i, i2, TabStopSpan.class), TabStopSpan.class);
                        z = true;
                        tabStops = null;
                        if (tabStopSpanArr.length > 0) {
                            tabStops = new TabStops(20, tabStopSpanArr);
                            z = true;
                        }
                    }
                } else {
                    i9 = i10 + 1;
                }
            }
            obtain2.set(textPaint, charSequence, i, i2, i3, directions, z, tabStops);
            float f = i5;
            float metrics = obtain2.metrics(null);
            TextLine.recycle(obtain2);
            MeasuredText.recycle(obtain);
            return f + metrics;
        } catch (Throwable th) {
            TextLine.recycle(obtain2);
            MeasuredText.recycle(obtain);
            throw th;
        }
    }

    static float nextTab(CharSequence charSequence, int i, int i2, float f, Object[] objArr) {
        float f2;
        float f3 = Float.MAX_VALUE;
        boolean z = false;
        if (charSequence instanceof Spanned) {
            Object[] objArr2 = objArr;
            if (objArr == null) {
                objArr2 = getParagraphSpans((Spanned) charSequence, i, i2, TabStopSpan.class);
                z = true;
            }
            int i3 = 0;
            while (i3 < objArr2.length) {
                if (z || (objArr2[i3] instanceof TabStopSpan)) {
                    int tabStop = ((TabStopSpan) objArr2[i3]).getTabStop();
                    f2 = f3;
                    if (tabStop < f3) {
                        f2 = f3;
                        if (tabStop > f) {
                            f2 = tabStop;
                        }
                    }
                } else {
                    f2 = f3;
                }
                i3++;
                f3 = f2;
            }
            if (f3 != Float.MAX_VALUE) {
                return f3;
            }
        }
        return ((int) ((f + 20.0f) / 20.0f)) * 20;
    }

    private boolean primaryIsTrailingPrevious(int i) {
        int i2;
        int i3;
        boolean z = true;
        int lineForOffset = getLineForOffset(i);
        int lineStart = getLineStart(lineForOffset);
        int lineEnd = getLineEnd(lineForOffset);
        int[] iArr = getLineDirections(lineForOffset).mDirections;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            i2 = -1;
            if (i5 >= iArr.length) {
                break;
            }
            int i6 = lineStart + iArr[i5];
            int i7 = i6 + (iArr[i5 + 1] & RUN_LENGTH_MASK);
            int i8 = i7;
            if (i7 > lineEnd) {
                i8 = lineEnd;
            }
            if (i < i6 || i >= i8) {
                i4 = i5 + 2;
            } else if (i > i6) {
                return false;
            } else {
                i2 = (iArr[i5 + 1] >>> 26) & 63;
            }
        }
        int i9 = i2;
        if (i2 == -1) {
            i9 = getParagraphDirection(lineForOffset) == 1 ? 0 : 1;
        }
        if (i != lineStart) {
            int i10 = i - 1;
            int i11 = 0;
            while (true) {
                int i12 = i11;
                i3 = -1;
                if (i12 >= iArr.length) {
                    break;
                }
                int i13 = lineStart + iArr[i12];
                int i14 = i13 + (iArr[i12 + 1] & RUN_LENGTH_MASK);
                int i15 = i14;
                if (i14 > lineEnd) {
                    i15 = lineEnd;
                }
                if (i10 >= i13 && i10 < i15) {
                    i3 = (iArr[i12 + 1] >>> 26) & 63;
                    break;
                }
                i11 = i12 + 2;
            }
        } else {
            i3 = getParagraphDirection(lineForOffset) == 1 ? 0 : 1;
        }
        if (i3 >= i9) {
            z = false;
        }
        return z;
    }

    public void draw(Canvas canvas) {
        draw(canvas, null, null, 0);
    }

    public void draw(Canvas canvas, Path path, Paint paint, int i) {
        long lineRangeForDraw = getLineRangeForDraw(canvas);
        int unpackRangeStartFromLong = TextUtils.unpackRangeStartFromLong(lineRangeForDraw);
        int unpackRangeEndFromLong = TextUtils.unpackRangeEndFromLong(lineRangeForDraw);
        if (unpackRangeEndFromLong < 0) {
            return;
        }
        drawBackground(canvas, path, paint, i, unpackRangeStartFromLong, unpackRangeEndFromLong);
        drawText(canvas, unpackRangeStartFromLong, unpackRangeEndFromLong);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00d9, code lost:
        if (r0 == 0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void drawBackground(android.graphics.Canvas r14, android.graphics.Path r15, android.graphics.Paint r16, int r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.text.Layout.drawBackground(android.graphics.Canvas, android.graphics.Path, android.graphics.Paint, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00f9, code lost:
        if (r39 != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void drawText(android.graphics.Canvas r15, int r16, int r17) {
        /*
            Method dump skipped, instructions count: 974
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.text.Layout.drawText(android.graphics.Canvas, int, int):void");
    }

    public final Alignment getAlignment() {
        return this.mAlignment;
    }

    public abstract int getBottomPadding();

    /* JADX WARN: Code restructure failed: missing block: B:8:0x006f, code lost:
        if (r0 != 0) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void getCursorPath(int r6, android.graphics.Path r7, java.lang.CharSequence r8) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.text.Layout.getCursorPath(int, android.graphics.Path, java.lang.CharSequence):void");
    }

    public abstract int getEllipsisCount(int i);

    public abstract int getEllipsisStart(int i);

    public int getEllipsizedWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return getLineTop(getLineCount());
    }

    public final int getLineAscent(int i) {
        return getLineTop(i) - (getLineTop(i + 1) - getLineDescent(i));
    }

    public final int getLineBaseline(int i) {
        return getLineTop(i + 1) - getLineDescent(i);
    }

    public final int getLineBottom(int i) {
        return getLineTop(i + 1);
    }

    public int getLineBounds(int i, Rect rect) {
        if (rect != null) {
            rect.left = 0;
            rect.top = getLineTop(i);
            rect.right = this.mWidth;
            rect.bottom = getLineTop(i + 1);
        }
        return getLineBaseline(i);
    }

    public abstract boolean getLineContainsTab(int i);

    public abstract int getLineCount();

    public abstract int getLineDescent(int i);

    public abstract Directions getLineDirections(int i);

    public final int getLineEnd(int i) {
        return getLineStart(i + 1);
    }

    public int getLineForOffset(int i) {
        int lineCount = getLineCount();
        int i2 = -1;
        while (lineCount - i2 > 1) {
            int i3 = (lineCount + i2) / 2;
            if (getLineStart(i3) > i) {
                lineCount = i3;
            } else {
                i2 = i3;
            }
        }
        int i4 = i2;
        if (i2 < 0) {
            i4 = 0;
        }
        return i4;
    }

    public int getLineForVertical(int i) {
        int lineCount = getLineCount();
        int i2 = -1;
        while (lineCount - i2 > 1) {
            int i3 = (lineCount + i2) / 2;
            if (getLineTop(i3) > i) {
                lineCount = i3;
            } else {
                i2 = i3;
            }
        }
        int i4 = i2;
        if (i2 < 0) {
            i4 = 0;
        }
        return i4;
    }

    public float getLineLeft(int i) {
        int paragraphDirection = getParagraphDirection(i);
        Alignment paragraphAlignment = getParagraphAlignment(i);
        if (paragraphAlignment == Alignment.ALIGN_LEFT) {
            return 0.0f;
        }
        if (paragraphAlignment == Alignment.ALIGN_NORMAL) {
            if (paragraphDirection == -1) {
                return getParagraphRight(i) - getLineMax(i);
            }
            return 0.0f;
        } else if (paragraphAlignment == Alignment.ALIGN_RIGHT) {
            return this.mWidth - getLineMax(i);
        } else {
            if (paragraphAlignment != Alignment.ALIGN_OPPOSITE) {
                int paragraphLeft = getParagraphLeft(i);
                return (((getParagraphRight(i) - paragraphLeft) - (((int) getLineMax(i)) & (-2))) / 2) + paragraphLeft;
            } else if (paragraphDirection != -1) {
                return this.mWidth - getLineMax(i);
            } else {
                return 0.0f;
            }
        }
    }

    public float getLineMax(int i) {
        float paragraphLeadingMargin = getParagraphLeadingMargin(i);
        float lineExtent = getLineExtent(i, false);
        if (lineExtent < 0.0f) {
            lineExtent = -lineExtent;
        }
        return paragraphLeadingMargin + lineExtent;
    }

    public long getLineRangeForDraw(Canvas canvas) {
        synchronized (sTempRect) {
            if (!canvas.getClipBounds(sTempRect)) {
                return TextUtils.packRangeInLong(0, -1);
            }
            int i = sTempRect.top;
            int i2 = sTempRect.bottom;
            int max = Math.max(i, 0);
            int min = Math.min(getLineTop(getLineCount()), i2);
            return max >= min ? TextUtils.packRangeInLong(0, -1) : TextUtils.packRangeInLong(getLineForVertical(max), getLineForVertical(min));
        }
    }

    public float getLineRight(int i) {
        int paragraphDirection = getParagraphDirection(i);
        Alignment paragraphAlignment = getParagraphAlignment(i);
        if (paragraphAlignment == Alignment.ALIGN_LEFT) {
            return getParagraphLeft(i) + getLineMax(i);
        }
        if (paragraphAlignment == Alignment.ALIGN_NORMAL) {
            return paragraphDirection == -1 ? this.mWidth : getParagraphLeft(i) + getLineMax(i);
        } else if (paragraphAlignment == Alignment.ALIGN_RIGHT) {
            return this.mWidth;
        } else {
            if (paragraphAlignment == Alignment.ALIGN_OPPOSITE) {
                return paragraphDirection == -1 ? getLineMax(i) : this.mWidth;
            }
            int paragraphLeft = getParagraphLeft(i);
            int paragraphRight = getParagraphRight(i);
            return paragraphRight - (((paragraphRight - paragraphLeft) - (((int) getLineMax(i)) & (-2))) / 2);
        }
    }

    public abstract int getLineStart(int i);

    public abstract int getLineTop(int i);

    public int getLineVisibleEnd(int i) {
        return getLineVisibleEnd(i, getLineStart(i), getLineStart(i + 1));
    }

    public float getLineWidth(int i) {
        float paragraphLeadingMargin = getParagraphLeadingMargin(i);
        float lineExtent = getLineExtent(i, true);
        if (lineExtent < 0.0f) {
            lineExtent = -lineExtent;
        }
        return paragraphLeadingMargin + lineExtent;
    }

    public int getOffsetForHorizontal(int i, float f) {
        int lineEnd = getLineEnd(i) - 1;
        int lineStart = getLineStart(i);
        Directions lineDirections = getLineDirections(i);
        int i2 = lineEnd;
        if (i == getLineCount() - 1) {
            i2 = lineEnd + 1;
        }
        int i3 = lineStart;
        float abs = Math.abs(getPrimaryHorizontal(i3) - f);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= lineDirections.mDirections.length) {
                break;
            }
            int i6 = lineStart + lineDirections.mDirections[i5];
            int i7 = i6 + (lineDirections.mDirections[i5 + 1] & RUN_LENGTH_MASK);
            int i8 = (lineDirections.mDirections[i5 + 1] & 67108864) != 0 ? -1 : 1;
            int i9 = i7;
            if (i7 > i2) {
                i9 = i2;
            }
            int i10 = (i9 - 1) + 1;
            int i11 = (i6 + 1) - 1;
            while (i10 - i11 > 1) {
                int i12 = (i10 + i11) / 2;
                if (getPrimaryHorizontal(getOffsetAtStartOf(i12)) * i8 >= i8 * f) {
                    i10 = i12;
                } else {
                    i11 = i12;
                }
            }
            int i13 = i11;
            if (i11 < i6 + 1) {
                i13 = i6 + 1;
            }
            int i14 = i3;
            float f2 = abs;
            if (i13 < i9) {
                int offsetAtStartOf = getOffsetAtStartOf(i13);
                float abs2 = Math.abs(getPrimaryHorizontal(offsetAtStartOf) - f);
                int offsetAfter = TextUtils.getOffsetAfter(this.mText, offsetAtStartOf);
                float f3 = abs2;
                int i15 = offsetAtStartOf;
                if (offsetAfter < i9) {
                    float abs3 = Math.abs(getPrimaryHorizontal(offsetAfter) - f);
                    f3 = abs2;
                    i15 = offsetAtStartOf;
                    if (abs3 < abs2) {
                        f3 = abs3;
                        i15 = offsetAfter;
                    }
                }
                i14 = i3;
                f2 = abs;
                if (f3 < abs) {
                    f2 = f3;
                    i14 = i15;
                }
            }
            float abs4 = Math.abs(getPrimaryHorizontal(i6) - f);
            i3 = i14;
            abs = f2;
            if (abs4 < f2) {
                abs = abs4;
                i3 = i6;
            }
            i4 = i5 + 2;
        }
        if (Math.abs(getPrimaryHorizontal(i2) - f) <= abs) {
            i3 = i2;
        }
        return i3;
    }

    public int getOffsetToLeftOf(int i) {
        return getOffsetToLeftRightOf(i, true);
    }

    public int getOffsetToRightOf(int i) {
        return getOffsetToLeftRightOf(i, false);
    }

    public final TextPaint getPaint() {
        return this.mPaint;
    }

    public final Alignment getParagraphAlignment(int i) {
        Alignment alignment = this.mAlignment;
        Alignment alignment2 = alignment;
        if (this.mSpannedText) {
            AlignmentSpan[] alignmentSpanArr = (AlignmentSpan[]) getParagraphSpans((Spanned) this.mText, getLineStart(i), getLineEnd(i), AlignmentSpan.class);
            int length = alignmentSpanArr.length;
            alignment2 = alignment;
            if (length > 0) {
                alignment2 = alignmentSpanArr[length - 1].getAlignment();
            }
        }
        return alignment2;
    }

    public abstract int getParagraphDirection(int i);

    public final int getParagraphLeft(int i) {
        if (getParagraphDirection(i) == -1 || !this.mSpannedText) {
            return 0;
        }
        return getParagraphLeadingMargin(i);
    }

    public final int getParagraphRight(int i) {
        int i2 = this.mWidth;
        return (getParagraphDirection(i) == 1 || !this.mSpannedText) ? i2 : i2 - getParagraphLeadingMargin(i);
    }

    public float getPrimaryHorizontal(int i) {
        return getPrimaryHorizontal(i, false);
    }

    public float getPrimaryHorizontal(int i, boolean z) {
        return getHorizontal(i, primaryIsTrailingPrevious(i), z);
    }

    public float getSecondaryHorizontal(int i) {
        return getSecondaryHorizontal(i, false);
    }

    public float getSecondaryHorizontal(int i, boolean z) {
        return getHorizontal(i, !primaryIsTrailingPrevious(i), z);
    }

    public void getSelectionPath(int i, int i2, Path path) {
        path.reset();
        if (i == i2) {
            return;
        }
        int i3 = i;
        int i4 = i2;
        if (i2 < i) {
            i4 = i;
            i3 = i2;
        }
        int lineForOffset = getLineForOffset(i3);
        int lineForOffset2 = getLineForOffset(i4);
        int lineTop = getLineTop(lineForOffset);
        int lineBottom = getLineBottom(lineForOffset2);
        if (lineForOffset == lineForOffset2) {
            addSelection(lineForOffset, i3, i4, lineTop, lineBottom, path);
            return;
        }
        float f = this.mWidth;
        addSelection(lineForOffset, i3, getLineEnd(lineForOffset), lineTop, getLineBottom(lineForOffset), path);
        if (getParagraphDirection(lineForOffset) == -1) {
            path.addRect(getLineLeft(lineForOffset), lineTop, 0.0f, getLineBottom(lineForOffset), Path.Direction.CW);
        } else {
            path.addRect(getLineRight(lineForOffset), lineTop, f, getLineBottom(lineForOffset), Path.Direction.CW);
        }
        while (true) {
            lineForOffset++;
            if (lineForOffset >= lineForOffset2) {
                break;
            }
            path.addRect(0.0f, getLineTop(lineForOffset), f, getLineBottom(lineForOffset), Path.Direction.CW);
        }
        int lineTop2 = getLineTop(lineForOffset2);
        int lineBottom2 = getLineBottom(lineForOffset2);
        addSelection(lineForOffset2, getLineStart(lineForOffset2), i4, lineTop2, lineBottom2, path);
        if (getParagraphDirection(lineForOffset2) == -1) {
            path.addRect(f, lineTop2, getLineRight(lineForOffset2), lineBottom2, Path.Direction.CW);
        } else {
            path.addRect(0.0f, lineTop2, getLineLeft(lineForOffset2), lineBottom2, Path.Direction.CW);
        }
    }

    public final float getSpacingAdd() {
        return this.mSpacingAdd;
    }

    public final float getSpacingMultiplier() {
        return this.mSpacingMult;
    }

    public final CharSequence getText() {
        return this.mText;
    }

    public final TextDirectionHeuristic getTextDirectionHeuristic() {
        return this.mTextDir;
    }

    public abstract int getTopPadding();

    public final int getWidth() {
        return this.mWidth;
    }

    public final void increaseWidthTo(int i) {
        if (i < this.mWidth) {
            throw new RuntimeException("attempted to reduce Layout width");
        }
        this.mWidth = i;
    }

    public boolean isLevelBoundary(int i) {
        int lineForOffset = getLineForOffset(i);
        Directions lineDirections = getLineDirections(lineForOffset);
        if (lineDirections == DIRS_ALL_LEFT_TO_RIGHT || lineDirections == DIRS_ALL_RIGHT_TO_LEFT) {
            return false;
        }
        int[] iArr = lineDirections.mDirections;
        int lineStart = getLineStart(lineForOffset);
        int lineEnd = getLineEnd(lineForOffset);
        if (i == lineStart || i == lineEnd) {
            return ((iArr[(i == lineStart ? 0 : iArr.length - 2) + 1] >>> 26) & 63) != (getParagraphDirection(lineForOffset) == 1 ? 0 : 1);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iArr.length) {
                return false;
            }
            if (i - lineStart == iArr[i3]) {
                return true;
            }
            i2 = i3 + 2;
        }
    }

    public boolean isRtlCharAt(int i) {
        boolean z = true;
        int lineForOffset = getLineForOffset(i);
        Directions lineDirections = getLineDirections(lineForOffset);
        if (lineDirections == DIRS_ALL_LEFT_TO_RIGHT) {
            return false;
        }
        if (lineDirections == DIRS_ALL_RIGHT_TO_LEFT) {
            return true;
        }
        int[] iArr = lineDirections.mDirections;
        int lineStart = getLineStart(lineForOffset);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iArr.length) {
                return false;
            }
            int i4 = lineStart + iArr[i3];
            int i5 = iArr[i3 + 1];
            if (i >= i4 && i < i4 + (i5 & RUN_LENGTH_MASK)) {
                if (((iArr[i3 + 1] >>> 26) & 63 & 1) == 0) {
                    z = false;
                }
                return z;
            }
            i2 = i3 + 2;
        }
    }

    protected final boolean isSpanned() {
        return this.mSpannedText;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void replaceWith(CharSequence charSequence, TextPaint textPaint, int i, Alignment alignment, float f, float f2) {
        if (i < 0) {
            throw new IllegalArgumentException("Layout: " + i + " < 0");
        }
        this.mText = charSequence;
        this.mPaint = textPaint;
        this.mWidth = i;
        this.mAlignment = alignment;
        this.mSpacingMult = f;
        this.mSpacingAdd = f2;
        this.mSpannedText = charSequence instanceof Spanned;
    }

    public boolean shouldClampCursor(int i) {
        boolean z = true;
        switch (AnonymousClass1.$SwitchMap$android$text$Layout$Alignment[getParagraphAlignment(i).ordinal()]) {
            case 1:
                break;
            case 2:
                z = true;
                if (getParagraphDirection(i) <= 0) {
                    return false;
                }
                break;
            default:
                z = false;
                break;
        }
        return z;
    }
}
