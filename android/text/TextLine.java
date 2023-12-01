package android.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import com.android.internal.util.ArrayUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/text/TextLine.class */
public class TextLine {
    private static final boolean DEBUG = false;
    private static final int TAB_INCREMENT = 20;
    private static final TextLine[] sCached = new TextLine[3];
    private char[] mChars;
    private boolean mCharsValid;
    private int mDir;
    private Layout.Directions mDirections;
    private boolean mHasTabs;
    private int mLen;
    private TextPaint mPaint;
    private Spanned mSpanned;
    private int mStart;
    private Layout.TabStops mTabs;
    private CharSequence mText;
    private final TextPaint mWorkPaint = new TextPaint();
    private final SpanSet<MetricAffectingSpan> mMetricAffectingSpanSpanSet = new SpanSet<>(MetricAffectingSpan.class);
    private final SpanSet<CharacterStyle> mCharacterStyleSpanSet = new SpanSet<>(CharacterStyle.class);
    private final SpanSet<ReplacementSpan> mReplacementSpanSpanSet = new SpanSet<>(ReplacementSpan.class);

    TextLine() {
    }

    private float drawRun(Canvas canvas, int i, int i2, boolean z, float f, int i3, int i4, int i5, boolean z2) {
        if ((this.mDir == 1) == z) {
            float f2 = -measureRun(i, i2, i2, z, null);
            handleRun(i, i2, i2, z, canvas, f + f2, i3, i4, i5, null, false);
            return f2;
        }
        return handleRun(i, i2, i2, z, canvas, f, i3, i4, i5, null, z2);
    }

    private void drawTextRun(Canvas canvas, TextPaint textPaint, int i, int i2, int i3, int i4, boolean z, float f, int i5) {
        if (this.mCharsValid) {
            canvas.drawTextRun(this.mChars, i, i2 - i, i3, i4 - i3, f, i5, z, textPaint);
            return;
        }
        int i6 = this.mStart;
        canvas.drawTextRun(this.mText, i6 + i, i6 + i2, i6 + i3, i6 + i4, f, i5, z, textPaint);
    }

    private static void expandMetricsFromPaint(Paint.FontMetricsInt fontMetricsInt, TextPaint textPaint) {
        int i = fontMetricsInt.top;
        int i2 = fontMetricsInt.ascent;
        int i3 = fontMetricsInt.descent;
        int i4 = fontMetricsInt.bottom;
        int i5 = fontMetricsInt.leading;
        textPaint.getFontMetricsInt(fontMetricsInt);
        updateMetrics(fontMetricsInt, i, i2, i3, i4, i5);
    }

    private int getOffsetBeforeAfter(int i, int i2, int i3, boolean z, int i4, boolean z2) {
        int offsetAfter;
        int i5;
        if (i >= 0) {
            if (i4 != (z2 ? this.mLen : 0)) {
                TextPaint textPaint = this.mWorkPaint;
                textPaint.set(this.mPaint);
                int i6 = i2;
                if (this.mSpanned == null) {
                    i5 = i6;
                } else {
                    int i7 = z2 ? i4 + 1 : i4;
                    int i8 = this.mStart;
                    while (true) {
                        offsetAfter = this.mSpanned.nextSpanTransition(this.mStart + i6, i8 + i3, MetricAffectingSpan.class) - this.mStart;
                        if (offsetAfter >= i7) {
                            break;
                        }
                        i6 = offsetAfter;
                    }
                    MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) TextUtils.removeEmptySpans((MetricAffectingSpan[]) this.mSpanned.getSpans(this.mStart + i6, this.mStart + offsetAfter, MetricAffectingSpan.class), this.mSpanned, MetricAffectingSpan.class);
                    i5 = i6;
                    i3 = offsetAfter;
                    if (metricAffectingSpanArr.length > 0) {
                        ReplacementSpan replacementSpan = null;
                        int i9 = 0;
                        while (true) {
                            int i10 = i9;
                            if (i10 >= metricAffectingSpanArr.length) {
                                break;
                            }
                            MetricAffectingSpan metricAffectingSpan = metricAffectingSpanArr[i10];
                            if (metricAffectingSpan instanceof ReplacementSpan) {
                                replacementSpan = (ReplacementSpan) metricAffectingSpan;
                            } else {
                                metricAffectingSpan.updateMeasureState(textPaint);
                            }
                            i9 = i10 + 1;
                        }
                        i5 = i6;
                        i3 = offsetAfter;
                        if (replacementSpan != null) {
                            if (!z2) {
                                return i6;
                            }
                            return offsetAfter;
                        }
                    }
                }
                int i11 = z ? 1 : 0;
                int i12 = z2 ? 0 : 2;
                return this.mCharsValid ? textPaint.getTextRunCursor(this.mChars, i5, i3 - i5, i11, i4, i12) : textPaint.getTextRunCursor(this.mText, this.mStart + i5, this.mStart + i3, i11, this.mStart + i4, i12) - this.mStart;
            }
        }
        if (z2) {
            offsetAfter = TextUtils.getOffsetAfter(this.mText, this.mStart + i4) - this.mStart;
            return offsetAfter;
        }
        return TextUtils.getOffsetBefore(this.mText, this.mStart + i4) - this.mStart;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0028, code lost:
        if (r16 != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float handleReplacement(android.text.style.ReplacementSpan r12, android.text.TextPaint r13, int r14, int r15, boolean r16, android.graphics.Canvas r17, float r18, int r19, int r20, int r21, android.graphics.Paint.FontMetricsInt r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.text.TextLine.handleReplacement(android.text.style.ReplacementSpan, android.text.TextPaint, int, int, boolean, android.graphics.Canvas, float, int, int, int, android.graphics.Paint$FontMetricsInt, boolean):float");
    }

    private float handleRun(int i, int i2, int i3, boolean z, Canvas canvas, float f, int i4, int i5, int i6, Paint.FontMetricsInt fontMetricsInt, boolean z2) {
        if (i == i2) {
            TextPaint textPaint = this.mWorkPaint;
            textPaint.set(this.mPaint);
            if (fontMetricsInt != null) {
                expandMetricsFromPaint(fontMetricsInt, textPaint);
                return 0.0f;
            }
            return 0.0f;
        } else if (this.mSpanned == null) {
            TextPaint textPaint2 = this.mWorkPaint;
            textPaint2.set(this.mPaint);
            return handleText(textPaint2, i, i2, i, i3, z, canvas, f, i4, i5, i6, fontMetricsInt, z2 || i2 < i2);
        } else {
            this.mMetricAffectingSpanSpanSet.init(this.mSpanned, this.mStart + i, this.mStart + i3);
            this.mCharacterStyleSpanSet.init(this.mSpanned, this.mStart + i, this.mStart + i3);
            float f2 = f;
            while (i < i2) {
                TextPaint textPaint3 = this.mWorkPaint;
                textPaint3.set(this.mPaint);
                int nextTransition = this.mMetricAffectingSpanSpanSet.getNextTransition(this.mStart + i, this.mStart + i3) - this.mStart;
                int min = Math.min(nextTransition, i2);
                ReplacementSpan replacementSpan = null;
                int i7 = 0;
                while (i7 < this.mMetricAffectingSpanSpanSet.numberOfSpans) {
                    ReplacementSpan replacementSpan2 = replacementSpan;
                    if (this.mMetricAffectingSpanSpanSet.spanStarts[i7] < this.mStart + min) {
                        if (this.mMetricAffectingSpanSpanSet.spanEnds[i7] <= this.mStart + i) {
                            replacementSpan2 = replacementSpan;
                        } else {
                            MetricAffectingSpan metricAffectingSpan = this.mMetricAffectingSpanSpanSet.spans[i7];
                            if (metricAffectingSpan instanceof ReplacementSpan) {
                                replacementSpan2 = (ReplacementSpan) metricAffectingSpan;
                            } else {
                                metricAffectingSpan.updateDrawState(textPaint3);
                                replacementSpan2 = replacementSpan;
                            }
                        }
                    }
                    i7++;
                    replacementSpan = replacementSpan2;
                }
                if (replacementSpan != null) {
                    f2 += handleReplacement(replacementSpan, textPaint3, i, min, z, canvas, f2, i4, i5, i6, fontMetricsInt, z2 || min < i2);
                } else {
                    int i8 = i;
                    float f3 = f2;
                    while (true) {
                        f2 = f3;
                        if (i8 < min) {
                            int nextTransition2 = this.mCharacterStyleSpanSet.getNextTransition(this.mStart + i8, this.mStart + min) - this.mStart;
                            textPaint3.set(this.mPaint);
                            int i9 = 0;
                            while (true) {
                                int i10 = i9;
                                if (i10 >= this.mCharacterStyleSpanSet.numberOfSpans) {
                                    break;
                                }
                                if (this.mCharacterStyleSpanSet.spanStarts[i10] < this.mStart + nextTransition2 && this.mCharacterStyleSpanSet.spanEnds[i10] > this.mStart + i8) {
                                    this.mCharacterStyleSpanSet.spans[i10].updateDrawState(textPaint3);
                                }
                                i9 = i10 + 1;
                            }
                            f3 += handleText(textPaint3, i8, nextTransition2, i, nextTransition, z, canvas, f3, i4, i5, i6, fontMetricsInt, z2 || nextTransition2 < i2);
                            i8 = nextTransition2;
                        }
                    }
                }
                i = nextTransition;
            }
            return f2 - f;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
        if (r18 != false) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0141  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float handleText(android.text.TextPaint r13, int r14, int r15, int r16, int r17, boolean r18, android.graphics.Canvas r19, float r20, int r21, int r22, int r23, android.graphics.Paint.FontMetricsInt r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.text.TextLine.handleText(android.text.TextPaint, int, int, int, int, boolean, android.graphics.Canvas, float, int, int, int, android.graphics.Paint$FontMetricsInt, boolean):float");
    }

    private float measureRun(int i, int i2, int i3, boolean z, Paint.FontMetricsInt fontMetricsInt) {
        return handleRun(i, i2, i3, z, null, 0.0f, 0, 0, 0, fontMetricsInt, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TextLine obtain() {
        int i;
        synchronized (sCached) {
            int length = sCached.length;
            do {
                i = length - 1;
                if (i < 0) {
                    return new TextLine();
                }
                length = i;
            } while (sCached[i] == null);
            TextLine textLine = sCached[i];
            sCached[i] = null;
            return textLine;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TextLine recycle(TextLine textLine) {
        textLine.mText = null;
        textLine.mPaint = null;
        textLine.mDirections = null;
        textLine.mSpanned = null;
        textLine.mTabs = null;
        textLine.mChars = null;
        textLine.mMetricAffectingSpanSpanSet.recycle();
        textLine.mCharacterStyleSpanSet.recycle();
        textLine.mReplacementSpanSpanSet.recycle();
        synchronized (sCached) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= sCached.length) {
                    break;
                } else if (sCached[i2] == null) {
                    sCached[i2] = textLine;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
        }
        return null;
    }

    static void updateMetrics(Paint.FontMetricsInt fontMetricsInt, int i, int i2, int i3, int i4, int i5) {
        fontMetricsInt.top = Math.min(fontMetricsInt.top, i);
        fontMetricsInt.ascent = Math.min(fontMetricsInt.ascent, i2);
        fontMetricsInt.descent = Math.max(fontMetricsInt.descent, i3);
        fontMetricsInt.bottom = Math.max(fontMetricsInt.bottom, i4);
        fontMetricsInt.leading = Math.max(fontMetricsInt.leading, i5);
    }

    float ascent(int i) {
        if (this.mSpanned == null) {
            return this.mPaint.ascent();
        }
        int i2 = i + this.mStart;
        MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) this.mSpanned.getSpans(i2, i2 + 1, MetricAffectingSpan.class);
        if (metricAffectingSpanArr.length == 0) {
            return this.mPaint.ascent();
        }
        TextPaint textPaint = this.mWorkPaint;
        textPaint.set(this.mPaint);
        int length = metricAffectingSpanArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return textPaint.ascent();
            }
            metricAffectingSpanArr[i4].updateMeasureState(textPaint);
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void draw(Canvas canvas, float f, int i, int i2, int i3) {
        int i4;
        RectF rectF;
        float f2;
        int i5;
        float f3;
        if (!this.mHasTabs) {
            if (this.mDirections == Layout.DIRS_ALL_LEFT_TO_RIGHT) {
                drawRun(canvas, 0, this.mLen, false, f, i, i2, i3, false);
                return;
            } else if (this.mDirections == Layout.DIRS_ALL_RIGHT_TO_LEFT) {
                drawRun(canvas, 0, this.mLen, true, f, i, i2, i3, false);
                return;
            }
        }
        float f4 = 0.0f;
        int[] iArr = this.mDirections.mDirections;
        RectF rectF2 = null;
        int length = iArr.length;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= iArr.length) {
                return;
            }
            int i8 = iArr[i7];
            int i9 = i8 + (iArr[i7 + 1] & 67108863);
            int i10 = i9;
            if (i9 > this.mLen) {
                i10 = this.mLen;
            }
            boolean z = (iArr[i7 + 1] & 67108864) != 0;
            int i11 = i8;
            if (!this.mHasTabs) {
                i8 = i10;
            }
            while (i8 <= i10) {
                Bitmap bitmap = null;
                char c2 = 0;
                if (this.mHasTabs) {
                    bitmap = null;
                    c2 = 0;
                    if (i8 < i10) {
                        char c3 = this.mChars[i8];
                        bitmap = null;
                        c2 = c3;
                        if (c3 >= 55296) {
                            bitmap = null;
                            c2 = c3;
                            if (c3 < 56320) {
                                bitmap = null;
                                c2 = c3;
                                if (i8 + 1 < i10) {
                                    int codePointAt = Character.codePointAt(this.mChars, i8);
                                    if (codePointAt < Layout.MIN_EMOJI || codePointAt > Layout.MAX_EMOJI) {
                                        bitmap = null;
                                        c2 = codePointAt;
                                        if (codePointAt > 65535) {
                                            i4 = i8 + 1;
                                            i5 = i11;
                                            rectF = rectF2;
                                            f3 = f4;
                                            i8 = i4 + 1;
                                            i11 = i5;
                                            rectF2 = rectF;
                                            f4 = f3;
                                        }
                                    } else {
                                        bitmap = Layout.EMOJI_FACTORY.getBitmapFromAndroidPua(codePointAt);
                                        c2 = codePointAt;
                                    }
                                }
                            }
                        }
                    }
                }
                if (i8 != i10 && c2 != '\t') {
                    i5 = i11;
                    i4 = i8;
                    rectF = rectF2;
                    f3 = f4;
                    if (bitmap == null) {
                        i8 = i4 + 1;
                        i11 = i5;
                        rectF2 = rectF;
                        f4 = f3;
                    }
                }
                float drawRun = f4 + drawRun(canvas, i11, i8, z, f + f4, i, i2, i3, (i7 == length - 2 && i8 == this.mLen) ? false : true);
                if (c2 == '\t') {
                    f2 = this.mDir * nextTab(this.mDir * drawRun);
                    rectF = rectF2;
                    i4 = i8;
                } else {
                    i4 = i8;
                    rectF = rectF2;
                    f2 = drawRun;
                    if (bitmap != null) {
                        float ascent = ascent(i8);
                        float width = bitmap.getWidth() * ((-ascent) / bitmap.getHeight());
                        rectF = rectF2;
                        if (rectF2 == null) {
                            rectF = new RectF();
                        }
                        rectF.set(f + drawRun, i2 + ascent, f + drawRun + width, i2);
                        canvas.drawBitmap(bitmap, (Rect) null, rectF, this.mPaint);
                        f2 = drawRun + width;
                        i4 = i8 + 1;
                    }
                }
                i5 = i4 + 1;
                f3 = f2;
                i8 = i4 + 1;
                i11 = i5;
                rectF2 = rectF;
                f4 = f3;
            }
            i6 = i7 + 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02d2, code lost:
        if (r14 != (-1)) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02d7, code lost:
        if (r12 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02da, code lost:
        r9 = r8.mLen + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02e4, code lost:
        r9 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02e9, code lost:
        r9 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02ef, code lost:
        if (r14 > r0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x02f4, code lost:
        if (r12 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02f7, code lost:
        r9 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x02fc, code lost:
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x022c, code lost:
        if (r26 != r24) goto L118;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getOffsetToLeftRightOf(int r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 769
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.text.TextLine.getOffsetToLeftRightOf(int, boolean):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float measure(int i, boolean z, Paint.FontMetricsInt fontMetricsInt) {
        float f;
        int i2;
        int i3;
        float f2;
        int i4 = z ? i - 1 : i;
        if (i4 >= 0) {
            float f3 = 0.0f;
            if (!this.mHasTabs) {
                if (this.mDirections == Layout.DIRS_ALL_LEFT_TO_RIGHT) {
                    return measureRun(0, i, this.mLen, false, fontMetricsInt);
                }
                if (this.mDirections == Layout.DIRS_ALL_RIGHT_TO_LEFT) {
                    return measureRun(0, i, this.mLen, true, fontMetricsInt);
                }
            }
            char[] cArr = this.mChars;
            int[] iArr = this.mDirections.mDirections;
            int i5 = 0;
            loop0: while (true) {
                int i6 = i5;
                f = f3;
                if (i6 >= iArr.length) {
                    break;
                }
                int i7 = iArr[i6];
                int i8 = i7 + (iArr[i6 + 1] & 67108863);
                int i9 = i8;
                if (i8 > this.mLen) {
                    i9 = this.mLen;
                }
                boolean z2 = (iArr[i6 + 1] & 67108864) != 0;
                int i10 = i7;
                if (!this.mHasTabs) {
                    i7 = i9;
                }
                while (i7 <= i9) {
                    Bitmap bitmap = null;
                    char c2 = 0;
                    if (this.mHasTabs) {
                        bitmap = null;
                        c2 = 0;
                        if (i7 < i9) {
                            char c3 = cArr[i7];
                            bitmap = null;
                            c2 = c3;
                            if (c3 >= 55296) {
                                bitmap = null;
                                c2 = c3;
                                if (c3 < 56320) {
                                    bitmap = null;
                                    c2 = c3;
                                    if (i7 + 1 < i9) {
                                        int codePointAt = Character.codePointAt(cArr, i7);
                                        if (codePointAt < Layout.MIN_EMOJI || codePointAt > Layout.MAX_EMOJI) {
                                            bitmap = null;
                                            c2 = codePointAt;
                                            if (codePointAt > 65535) {
                                                i2 = i7 + 1;
                                                f2 = f3;
                                                i3 = i10;
                                                i7 = i2 + 1;
                                                i10 = i3;
                                                f3 = f2;
                                            }
                                        } else {
                                            bitmap = Layout.EMOJI_FACTORY.getBitmapFromAndroidPua(codePointAt);
                                            c2 = codePointAt;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (i7 != i9 && c2 != '\t') {
                        i3 = i10;
                        i2 = i7;
                        f2 = f3;
                        if (bitmap == null) {
                            continue;
                            i7 = i2 + 1;
                            i10 = i3;
                            f3 = f2;
                        }
                    }
                    boolean z3 = i4 >= i10 && i4 < i7;
                    boolean z4 = (this.mDir == -1) == z2;
                    if (z3 && z4) {
                        return f3 + measureRun(i10, i, i7, z2, fontMetricsInt);
                    }
                    float measureRun = measureRun(i10, i7, i7, z2, fontMetricsInt);
                    if (!z4) {
                        measureRun = -measureRun;
                    }
                    float f4 = f3 + measureRun;
                    if (z3) {
                        return f4 + measureRun(i10, i, i7, z2, null);
                    }
                    float f5 = f4;
                    if (c2 == '\t') {
                        f = f4;
                        if (i == i7) {
                            break loop0;
                        }
                        float nextTab = this.mDir * nextTab(this.mDir * f4);
                        f = nextTab;
                        if (i4 == i7) {
                            break loop0;
                        }
                        f5 = nextTab;
                    }
                    i2 = i7;
                    float f6 = f5;
                    if (bitmap != null) {
                        f6 = f5 + (this.mDir * ((bitmap.getWidth() * (-ascent(i7))) / bitmap.getHeight()));
                        i2 = i7 + 1;
                    }
                    i3 = i2 + 1;
                    f2 = f6;
                    i7 = i2 + 1;
                    i10 = i3;
                    f3 = f2;
                }
                i5 = i6 + 2;
            }
        } else {
            f = 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float metrics(Paint.FontMetricsInt fontMetricsInt) {
        return measure(this.mLen, false, fontMetricsInt);
    }

    float nextTab(float f) {
        return this.mTabs != null ? this.mTabs.nextTab(f) : Layout.TabStops.nextDefaultStop(f, 20);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void set(TextPaint textPaint, CharSequence charSequence, int i, int i2, int i3, Layout.Directions directions, boolean z, Layout.TabStops tabStops) {
        this.mPaint = textPaint;
        this.mText = charSequence;
        this.mStart = i;
        this.mLen = i2 - i;
        this.mDir = i3;
        this.mDirections = directions;
        if (this.mDirections == null) {
            throw new IllegalArgumentException("Directions cannot be null");
        }
        this.mHasTabs = z;
        this.mSpanned = null;
        boolean z2 = false;
        if (charSequence instanceof Spanned) {
            this.mSpanned = (Spanned) charSequence;
            this.mReplacementSpanSpanSet.init(this.mSpanned, i, i2);
            z2 = this.mReplacementSpanSpanSet.numberOfSpans > 0;
        }
        this.mCharsValid = z2 || z || directions != Layout.DIRS_ALL_LEFT_TO_RIGHT;
        if (this.mCharsValid) {
            if (this.mChars == null || this.mChars.length < this.mLen) {
                this.mChars = ArrayUtils.newUnpaddedCharArray(this.mLen);
            }
            TextUtils.getChars(charSequence, i, i2, this.mChars, 0);
            if (z2) {
                char[] cArr = this.mChars;
                int i4 = i;
                while (true) {
                    int i5 = i4;
                    if (i5 >= i2) {
                        break;
                    }
                    int nextTransition = this.mReplacementSpanSpanSet.getNextTransition(i5, i2);
                    if (this.mReplacementSpanSpanSet.hasSpansIntersecting(i5, nextTransition)) {
                        cArr[i5 - i] = 65532;
                        int i6 = i5 - i;
                        while (true) {
                            int i7 = i6 + 1;
                            if (i7 < nextTransition - i) {
                                cArr[i7] = 65279;
                                i6 = i7;
                            }
                        }
                    }
                    i4 = nextTransition;
                }
            }
        }
        this.mTabs = tabStops;
    }
}
