package android.text;

import android.graphics.Paint;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import com.android.internal.util.ArrayUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/text/MeasuredText.class */
public class MeasuredText {
    private static final boolean localLOGV = false;
    char[] mChars;
    int mDir;
    boolean mEasy;
    int mLen;
    byte[] mLevels;
    private int mPos;
    CharSequence mText;
    int mTextStart;
    float[] mWidths;
    private TextPaint mWorkPaint = new TextPaint();
    private static final Object[] sLock = new Object[0];
    private static final MeasuredText[] sCached = new MeasuredText[3];

    private MeasuredText() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MeasuredText obtain() {
        int i;
        synchronized (sLock) {
            int length = sCached.length;
            do {
                i = length - 1;
                if (i < 0) {
                    return new MeasuredText();
                }
                length = i;
            } while (sCached[i] == null);
            MeasuredText measuredText = sCached[i];
            sCached[i] = null;
            return measuredText;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MeasuredText recycle(MeasuredText measuredText) {
        measuredText.mText = null;
        if (measuredText.mLen < 1000) {
            synchronized (sLock) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= sCached.length) {
                        break;
                    } else if (sCached[i2] == null) {
                        sCached[i2] = measuredText;
                        measuredText.mText = null;
                        break;
                    } else {
                        i = i2 + 1;
                    }
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float addStyleRun(TextPaint textPaint, int i, Paint.FontMetricsInt fontMetricsInt) {
        float textRunAdvances;
        float f;
        int i2;
        byte b;
        if (fontMetricsInt != null) {
            textPaint.getFontMetricsInt(fontMetricsInt);
        }
        int i3 = this.mPos;
        this.mPos = i3 + i;
        if (!this.mEasy) {
            float f2 = 0.0f;
            byte b2 = this.mLevels[i3];
            int i4 = i3 + 1;
            int i5 = i3 + i;
            int i6 = i4;
            int i7 = i3;
            while (true) {
                if (i6 != i5) {
                    i2 = i7;
                    b = b2;
                    textRunAdvances = f2;
                    if (this.mLevels[i6] == b2) {
                        continue;
                        i6++;
                        i7 = i2;
                        b2 = b;
                        f2 = textRunAdvances;
                    }
                }
                textRunAdvances = f2 + textPaint.getTextRunAdvances(this.mChars, i7, i6 - i7, i7, i6 - i7, (b2 & 1) != 0, this.mWidths, i7);
                f = textRunAdvances;
                if (i6 == i5) {
                    break;
                }
                i2 = i6;
                b = this.mLevels[i6];
                i6++;
                i7 = i2;
                b2 = b;
                f2 = textRunAdvances;
            }
        } else {
            f = textPaint.getTextRunAdvances(this.mChars, i3, i, i3, i, this.mDir != 1, this.mWidths, i3);
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float addStyleRun(TextPaint textPaint, MetricAffectingSpan[] metricAffectingSpanArr, int i, Paint.FontMetricsInt fontMetricsInt) {
        float size;
        TextPaint textPaint2 = this.mWorkPaint;
        textPaint2.set(textPaint);
        textPaint2.baselineShift = 0;
        ReplacementSpan replacementSpan = null;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= metricAffectingSpanArr.length) {
                break;
            }
            MetricAffectingSpan metricAffectingSpan = metricAffectingSpanArr[i3];
            if (metricAffectingSpan instanceof ReplacementSpan) {
                replacementSpan = (ReplacementSpan) metricAffectingSpan;
            } else {
                metricAffectingSpan.updateMeasureState(textPaint2);
            }
            i2 = i3 + 1;
        }
        if (replacementSpan == null) {
            size = addStyleRun(textPaint2, i, fontMetricsInt);
        } else {
            size = replacementSpan.getSize(textPaint2, this.mText, this.mTextStart + this.mPos, this.mTextStart + this.mPos + i, fontMetricsInt);
            float[] fArr = this.mWidths;
            fArr[this.mPos] = size;
            int i4 = this.mPos;
            for (int i5 = this.mPos + 1; i5 < i4 + i; i5++) {
                fArr[i5] = 0.0f;
            }
            this.mPos += i;
        }
        if (fontMetricsInt != null) {
            if (textPaint2.baselineShift >= 0) {
                fontMetricsInt.descent += textPaint2.baselineShift;
                fontMetricsInt.bottom += textPaint2.baselineShift;
                return size;
            }
            fontMetricsInt.ascent += textPaint2.baselineShift;
            fontMetricsInt.top += textPaint2.baselineShift;
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int breakText(int i, boolean z, float f) {
        int i2;
        int i3;
        float[] fArr = this.mWidths;
        if (z) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                i3 = i5;
                if (i5 >= i) {
                    break;
                }
                f -= fArr[i5];
                if (f < 0.0f) {
                    i3 = i5;
                    break;
                }
                i4 = i5 + 1;
            }
            while (i3 > 0 && this.mChars[i3 - 1] == ' ') {
                i3--;
            }
            return i3;
        }
        int i6 = i;
        while (true) {
            int i7 = i6 - 1;
            i2 = i7;
            if (i7 < 0) {
                break;
            }
            f -= fArr[i7];
            if (f < 0.0f) {
                i2 = i7;
                break;
            }
            i6 = i7;
        }
        while (i2 < i - 1 && this.mChars[i2 + 1] == ' ') {
            i2++;
        }
        return (i - i2) - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float measure(int i, int i2) {
        float f = 0.0f;
        float[] fArr = this.mWidths;
        while (i < i2) {
            f += fArr[i];
            i++;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPara(CharSequence charSequence, int i, int i2, TextDirectionHeuristic textDirectionHeuristic) {
        this.mText = charSequence;
        this.mTextStart = i;
        int i3 = i2 - i;
        this.mLen = i3;
        this.mPos = 0;
        if (this.mWidths == null || this.mWidths.length < i3) {
            this.mWidths = ArrayUtils.newUnpaddedFloatArray(i3);
        }
        if (this.mChars == null || this.mChars.length < i3) {
            this.mChars = ArrayUtils.newUnpaddedCharArray(i3);
        }
        TextUtils.getChars(charSequence, i, i2, this.mChars, 0);
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            ReplacementSpan[] replacementSpanArr = (ReplacementSpan[]) spanned.getSpans(i, i2, ReplacementSpan.class);
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= replacementSpanArr.length) {
                    break;
                }
                int spanStart = spanned.getSpanStart(replacementSpanArr[i5]) - i;
                int spanEnd = spanned.getSpanEnd(replacementSpanArr[i5]) - i;
                int i6 = spanStart;
                if (spanStart < 0) {
                    i6 = 0;
                }
                int i7 = spanEnd;
                if (spanEnd > i3) {
                    i7 = i3;
                }
                while (i6 < i7) {
                    this.mChars[i6] = 65532;
                    i6++;
                }
                i4 = i5 + 1;
            }
        }
        if ((textDirectionHeuristic == TextDirectionHeuristics.LTR || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR || textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) && TextUtils.doesNotNeedBidi(this.mChars, 0, i3)) {
            this.mDir = 1;
            this.mEasy = true;
            return;
        }
        if (this.mLevels == null || this.mLevels.length < i3) {
            this.mLevels = ArrayUtils.newUnpaddedByteArray(i3);
        }
        this.mDir = AndroidBidi.bidi(textDirectionHeuristic == TextDirectionHeuristics.LTR ? 1 : textDirectionHeuristic == TextDirectionHeuristics.RTL ? -1 : textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR ? 2 : textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL ? -2 : textDirectionHeuristic.isRtl(this.mChars, 0, i3) ? -1 : 1, this.mChars, this.mLevels, i3, false);
        this.mEasy = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPos(int i) {
        this.mPos = i - this.mTextStart;
    }
}
