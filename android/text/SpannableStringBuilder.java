package android.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.GrowingArrayUtils;
import java.lang.reflect.Array;
import libcore.util.EmptyArray;

/* loaded from: source-9557208-dex2jar.jar:android/text/SpannableStringBuilder.class */
public class SpannableStringBuilder implements CharSequence, GetChars, Spannable, Editable, Appendable, GraphicsOperations {
    private static final int END_MASK = 15;
    private static final int MARK = 1;
    private static final InputFilter[] NO_FILTERS = new InputFilter[0];
    private static final int PARAGRAPH = 3;
    private static final int POINT = 2;
    private static final int SPAN_END_AT_END = 32768;
    private static final int SPAN_END_AT_START = 16384;
    private static final int SPAN_START_AT_END = 8192;
    private static final int SPAN_START_AT_START = 4096;
    private static final int SPAN_START_END_MASK = 61440;
    private static final int START_MASK = 240;
    private static final int START_SHIFT = 4;
    private static final String TAG = "SpannableStringBuilder";
    private InputFilter[] mFilters;
    private int mGapLength;
    private int mGapStart;
    private int mSpanCount;
    private int mSpanCountBeforeAdd;
    private int[] mSpanEnds;
    private int[] mSpanFlags;
    private int[] mSpanStarts;
    private Object[] mSpans;
    private char[] mText;

    public SpannableStringBuilder() {
        this("");
    }

    public SpannableStringBuilder(CharSequence charSequence) {
        this(charSequence, 0, charSequence.length());
    }

    public SpannableStringBuilder(CharSequence charSequence, int i, int i2) {
        this.mFilters = NO_FILTERS;
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new StringIndexOutOfBoundsException();
        }
        this.mText = ArrayUtils.newUnpaddedCharArray(GrowingArrayUtils.growSize(i3));
        this.mGapStart = i3;
        this.mGapLength = this.mText.length - i3;
        TextUtils.getChars(charSequence, i, i2, this.mText, 0);
        this.mSpanCount = 0;
        this.mSpans = EmptyArray.OBJECT;
        this.mSpanStarts = EmptyArray.INT;
        this.mSpanEnds = EmptyArray.INT;
        this.mSpanFlags = EmptyArray.INT;
        if (!(charSequence instanceof Spanned)) {
            return;
        }
        Spanned spanned = (Spanned) charSequence;
        Object[] spans = spanned.getSpans(i, i2, Object.class);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= spans.length) {
                return;
            }
            if (!(spans[i5] instanceof NoCopySpan)) {
                int spanStart = spanned.getSpanStart(spans[i5]) - i;
                int spanEnd = spanned.getSpanEnd(spans[i5]) - i;
                int spanFlags = spanned.getSpanFlags(spans[i5]);
                int i6 = spanStart < 0 ? 0 : spanStart;
                int i7 = i6 > i2 - i ? i2 - i : i6;
                int i8 = spanEnd < 0 ? 0 : spanEnd;
                setSpan(false, spans[i5], i7, i8 > i2 - i ? i2 - i : i8, spanFlags);
            }
            i4 = i5 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0108, code lost:
        if (r0 != r17) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void change(int r11, int r12, java.lang.CharSequence r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 916
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.text.SpannableStringBuilder.change(int, int, java.lang.CharSequence, int, int):void");
    }

    private void checkRange(String str, int i, int i2) {
        if (i2 < i) {
            throw new IndexOutOfBoundsException(str + " " + region(i, i2) + " has end before start");
        }
        int length = length();
        if (i > length || i2 > length) {
            throw new IndexOutOfBoundsException(str + " " + region(i, i2) + " ends beyond length " + length);
        }
        if (i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException(str + " " + region(i, i2) + " starts before 0");
        }
    }

    private static boolean hasNonExclusiveExclusiveSpanAt(CharSequence charSequence, int i) {
        if (!(charSequence instanceof Spanned)) {
            return false;
        }
        Spanned spanned = (Spanned) charSequence;
        Object[] spans = spanned.getSpans(i, i, Object.class);
        int length = spans.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return false;
            }
            if (spanned.getSpanFlags(spans[i3]) != 33) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0100, code lost:
        if (r0 == 3) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void moveGapTo(int r7) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.text.SpannableStringBuilder.moveGapTo(int):void");
    }

    private static String region(int i, int i2) {
        return "(" + i + " ... " + i2 + ")";
    }

    private void removeSpan(int i) {
        Object obj = this.mSpans[i];
        int i2 = this.mSpanStarts[i];
        int i3 = this.mSpanEnds[i];
        int i4 = i2;
        if (i2 > this.mGapStart) {
            i4 = i2 - this.mGapLength;
        }
        int i5 = i3;
        if (i3 > this.mGapStart) {
            i5 = i3 - this.mGapLength;
        }
        int i6 = this.mSpanCount - (i + 1);
        System.arraycopy(this.mSpans, i + 1, this.mSpans, i, i6);
        System.arraycopy(this.mSpanStarts, i + 1, this.mSpanStarts, i, i6);
        System.arraycopy(this.mSpanEnds, i + 1, this.mSpanEnds, i, i6);
        System.arraycopy(this.mSpanFlags, i + 1, this.mSpanFlags, i, i6);
        this.mSpanCount--;
        this.mSpans[this.mSpanCount] = null;
        sendSpanRemoved(obj, i4, i5);
    }

    private void resizeFor(int i) {
        int length = this.mText.length;
        if (i + 1 <= length) {
            return;
        }
        char[] newUnpaddedCharArray = ArrayUtils.newUnpaddedCharArray(GrowingArrayUtils.growSize(i));
        System.arraycopy(this.mText, 0, newUnpaddedCharArray, 0, this.mGapStart);
        int length2 = newUnpaddedCharArray.length;
        int i2 = length2 - length;
        int i3 = length - (this.mGapStart + this.mGapLength);
        System.arraycopy(this.mText, length - i3, newUnpaddedCharArray, length2 - i3, i3);
        this.mText = newUnpaddedCharArray;
        this.mGapLength += i2;
        if (this.mGapLength < 1) {
            new Exception("mGapLength < 1").printStackTrace();
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.mSpanCount) {
                return;
            }
            if (this.mSpanStarts[i5] > this.mGapStart) {
                int[] iArr = this.mSpanStarts;
                iArr[i5] = iArr[i5] + i2;
            }
            if (this.mSpanEnds[i5] > this.mGapStart) {
                int[] iArr2 = this.mSpanEnds;
                iArr2[i5] = iArr2[i5] + i2;
            }
            i4 = i5 + 1;
        }
    }

    private void sendAfterTextChanged(TextWatcher[] textWatcherArr) {
        int length = textWatcherArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            textWatcherArr[i2].afterTextChanged(this);
            i = i2 + 1;
        }
    }

    private void sendBeforeTextChanged(TextWatcher[] textWatcherArr, int i, int i2, int i3) {
        int length = textWatcherArr.length;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length) {
                return;
            }
            textWatcherArr[i5].beforeTextChanged(this, i, i2, i3);
            i4 = i5 + 1;
        }
    }

    private void sendSpanAdded(Object obj, int i, int i2) {
        SpanWatcher[] spanWatcherArr = (SpanWatcher[]) getSpans(i, i2, SpanWatcher.class);
        int length = spanWatcherArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return;
            }
            spanWatcherArr[i4].onSpanAdded(this, obj, i, i2);
            i3 = i4 + 1;
        }
    }

    private void sendSpanChanged(Object obj, int i, int i2, int i3, int i4) {
        SpanWatcher[] spanWatcherArr = (SpanWatcher[]) getSpans(Math.min(i, i3), Math.min(Math.max(i2, i4), length()), SpanWatcher.class);
        int length = spanWatcherArr.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length) {
                return;
            }
            spanWatcherArr[i6].onSpanChanged(this, obj, i, i2, i3, i4);
            i5 = i6 + 1;
        }
    }

    private void sendSpanRemoved(Object obj, int i, int i2) {
        SpanWatcher[] spanWatcherArr = (SpanWatcher[]) getSpans(i, i2, SpanWatcher.class);
        int length = spanWatcherArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return;
            }
            spanWatcherArr[i4].onSpanRemoved(this, obj, i, i2);
            i3 = i4 + 1;
        }
    }

    private void sendTextChanged(TextWatcher[] textWatcherArr, int i, int i2, int i3) {
        int length = textWatcherArr.length;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length) {
                return;
            }
            textWatcherArr[i5].onTextChanged(this, i, i2, i3);
            i4 = i5 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f5, code lost:
        if ((r0 & 4096) != 4096) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0110, code lost:
        if ((r0 & 8192) != 8192) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0142, code lost:
        if ((r0 & 16384) != 16384) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x015b, code lost:
        if ((r0 & 32768) != 32768) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void sendToSpanWatchers(int r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.text.SpannableStringBuilder.sendToSpanWatchers(int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0165, code lost:
        if (r10 == length()) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x019a, code lost:
        if (r11 == length()) goto L71;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setSpan(boolean r8, java.lang.Object r9, int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 524
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.text.SpannableStringBuilder.setSpan(boolean, java.lang.Object, int, int, int):void");
    }

    private int updatedIntervalBound(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int i5;
        if (i >= i2 && i < this.mGapStart + this.mGapLength) {
            if (i4 == 2) {
                if (z2 || i > i2) {
                    i5 = this.mGapStart + this.mGapLength;
                    return i5;
                }
            } else if (i4 != 3) {
                i5 = i2;
                if (!z2) {
                    i5 = i2;
                    if (i >= this.mGapStart - i3) {
                        return this.mGapStart;
                    }
                }
                return i5;
            } else if (z) {
                return this.mGapStart + this.mGapLength;
            }
        }
        return i;
    }

    public static SpannableStringBuilder valueOf(CharSequence charSequence) {
        return charSequence instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence : new SpannableStringBuilder(charSequence);
    }

    @Override // java.lang.Appendable
    public SpannableStringBuilder append(char c2) {
        return append((CharSequence) String.valueOf(c2));
    }

    @Override // java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence) {
        int length = length();
        return replace(length, length, charSequence, 0, charSequence.length());
    }

    @Override // java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence, int i, int i2) {
        int length = length();
        return replace(length, length, charSequence, i, i2);
    }

    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i) {
        int length = length();
        append(charSequence);
        setSpan(obj, length, length(), i);
        return this;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        int length = length();
        if (i < 0) {
            throw new IndexOutOfBoundsException("charAt: " + i + " < 0");
        }
        if (i >= length) {
            throw new IndexOutOfBoundsException("charAt: " + i + " >= length " + length);
        }
        return i >= this.mGapStart ? this.mText[this.mGapLength + i] : this.mText[i];
    }

    @Override // android.text.Editable
    public void clear() {
        replace(0, length(), "", 0, 0);
    }

    @Override // android.text.Editable
    public void clearSpans() {
        int i = this.mSpanCount;
        while (true) {
            int i2 = i - 1;
            if (i2 < 0) {
                return;
            }
            Object obj = this.mSpans[i2];
            int i3 = this.mSpanStarts[i2];
            int i4 = this.mSpanEnds[i2];
            int i5 = i3;
            if (i3 > this.mGapStart) {
                i5 = i3 - this.mGapLength;
            }
            int i6 = i4;
            if (i4 > this.mGapStart) {
                i6 = i4 - this.mGapLength;
            }
            this.mSpanCount = i2;
            this.mSpans[i2] = null;
            sendSpanRemoved(obj, i5, i6);
            i = i2;
        }
    }

    @Override // android.text.Editable
    public SpannableStringBuilder delete(int i, int i2) {
        SpannableStringBuilder replace = replace(i, i2, "", 0, 0);
        if (this.mGapLength > length() * 2) {
            resizeFor(length());
        }
        return replace;
    }

    @Override // android.text.GraphicsOperations
    public void drawText(Canvas canvas, int i, int i2, float f, float f2, Paint paint) {
        checkRange("drawText", i, i2);
        if (i2 <= this.mGapStart) {
            canvas.drawText(this.mText, i, i2 - i, f, f2, paint);
        } else if (i >= this.mGapStart) {
            canvas.drawText(this.mText, i + this.mGapLength, i2 - i, f, f2, paint);
        } else {
            char[] obtain = TextUtils.obtain(i2 - i);
            getChars(i, i2, obtain, 0);
            canvas.drawText(obtain, 0, i2 - i, f, f2, paint);
            TextUtils.recycle(obtain);
        }
    }

    @Override // android.text.GraphicsOperations
    public void drawTextRun(Canvas canvas, int i, int i2, int i3, int i4, float f, float f2, boolean z, Paint paint) {
        checkRange("drawTextRun", i, i2);
        int i5 = i4 - i3;
        int i6 = i2 - i;
        if (i4 <= this.mGapStart) {
            canvas.drawTextRun(this.mText, i, i6, i3, i5, f, f2, z, paint);
        } else if (i3 >= this.mGapStart) {
            canvas.drawTextRun(this.mText, i + this.mGapLength, i6, i3 + this.mGapLength, i5, f, f2, z, paint);
        } else {
            char[] obtain = TextUtils.obtain(i5);
            getChars(i3, i4, obtain, 0);
            canvas.drawTextRun(obtain, i - i3, i6, 0, i5, f, f2, z, paint);
            TextUtils.recycle(obtain);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Spanned) || !toString().equals(obj.toString())) {
            return false;
        }
        Spanned spanned = (Spanned) obj;
        Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
        if (this.mSpanCount != spans.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mSpanCount) {
                return true;
            }
            Object obj2 = this.mSpans[i2];
            Object obj3 = spans[i2];
            if (obj2 == this) {
                if (spanned != obj3 || getSpanStart(obj2) != spanned.getSpanStart(obj3) || getSpanEnd(obj2) != spanned.getSpanEnd(obj3) || getSpanFlags(obj2) != spanned.getSpanFlags(obj3)) {
                    return false;
                }
            } else if (!obj2.equals(obj3) || getSpanStart(obj2) != spanned.getSpanStart(obj3) || getSpanEnd(obj2) != spanned.getSpanEnd(obj3) || getSpanFlags(obj2) != spanned.getSpanFlags(obj3)) {
                return false;
            }
            i = i2 + 1;
        }
    }

    @Override // android.text.GetChars
    public void getChars(int i, int i2, char[] cArr, int i3) {
        checkRange("getChars", i, i2);
        if (i2 <= this.mGapStart) {
            System.arraycopy(this.mText, i, cArr, i3, i2 - i);
        } else if (i >= this.mGapStart) {
            System.arraycopy(this.mText, this.mGapLength + i, cArr, i3, i2 - i);
        } else {
            System.arraycopy(this.mText, i, cArr, i3, this.mGapStart - i);
            System.arraycopy(this.mText, this.mGapStart + this.mGapLength, cArr, (this.mGapStart - i) + i3, i2 - this.mGapStart);
        }
    }

    @Override // android.text.Editable
    public InputFilter[] getFilters() {
        return this.mFilters;
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        int i = this.mSpanCount;
        Object[] objArr = this.mSpans;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (objArr[i] == obj) {
                int i2 = this.mSpanEnds[i];
                int i3 = i2;
                if (i2 > this.mGapStart) {
                    i3 = i2 - this.mGapLength;
                }
                return i3;
            }
        }
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        int i = this.mSpanCount;
        Object[] objArr = this.mSpans;
        while (true) {
            i--;
            if (i < 0) {
                return 0;
            }
            if (objArr[i] == obj) {
                return this.mSpanFlags[i];
            }
        }
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        int i = this.mSpanCount;
        Object[] objArr = this.mSpans;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (objArr[i] == obj) {
                int i2 = this.mSpanStarts[i];
                int i3 = i2;
                if (i2 > this.mGapStart) {
                    i3 = i2 - this.mGapLength;
                }
                return i3;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        T[] tArr;
        int i3;
        if (cls == null) {
            tArr = ArrayUtils.emptyArray(cls);
        } else {
            int i4 = this.mSpanCount;
            Object[] objArr = this.mSpans;
            int[] iArr = this.mSpanStarts;
            int[] iArr2 = this.mSpanEnds;
            int[] iArr3 = this.mSpanFlags;
            int i5 = this.mGapStart;
            int i6 = this.mGapLength;
            T[] tArr2 = null;
            Object obj = null;
            int i7 = 0;
            int i8 = 0;
            while (i7 < i4) {
                int i9 = iArr[i7];
                int i10 = i9;
                if (i9 > i5) {
                    i10 = i9 - i6;
                }
                if (i10 <= i2) {
                    int i11 = iArr2[i7];
                    int i12 = i11;
                    if (i11 > i5) {
                        i12 = i11 - i6;
                    }
                    if (i12 >= i && ((i10 == i12 || i == i2 || (i10 != i2 && i12 != i)) && cls.isInstance(objArr[i7]))) {
                        if (i8 == 0) {
                            obj = objArr[i7];
                            i8++;
                        } else {
                            tArr2 = tArr2;
                            if (i8 == 1) {
                                Object[] objArr2 = (Object[]) Array.newInstance((Class<?>) cls, (i4 - i7) + 1);
                                objArr2[0] = obj;
                                tArr2 = objArr2;
                            }
                            int i13 = iArr3[i7] & Spanned.SPAN_PRIORITY;
                            if (i13 != 0) {
                                int i14 = 0;
                                while (true) {
                                    i3 = i14;
                                    if (i3 >= i8 || i13 > (getSpanFlags(tArr2[i3]) & Spanned.SPAN_PRIORITY)) {
                                        break;
                                    }
                                    i14 = i3 + 1;
                                }
                                System.arraycopy(tArr2, i3, tArr2, i3 + 1, i8 - i3);
                                tArr2[i3] = objArr[i7];
                                i8++;
                            } else {
                                tArr2[i8] = objArr[i7];
                                i8++;
                            }
                        }
                    }
                }
                i7++;
                tArr2 = tArr2;
            }
            if (i8 == 0) {
                return (T[]) ArrayUtils.emptyArray(cls);
            }
            if (i8 == 1) {
                T[] tArr3 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, 1));
                tArr3[0] = obj;
                return tArr3;
            }
            tArr = tArr2;
            if (i8 != tArr2.length) {
                T[] tArr4 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i8));
                System.arraycopy(tArr2, 0, tArr4, 0, i8);
                return tArr4;
            }
        }
        return tArr;
    }

    @Override // android.text.GraphicsOperations
    public float getTextRunAdvances(int i, int i2, int i3, int i4, boolean z, float[] fArr, int i5, Paint paint) {
        int i6 = i4 - i3;
        int i7 = i2 - i;
        if (i2 <= this.mGapStart) {
            return paint.getTextRunAdvances(this.mText, i, i7, i3, i6, z, fArr, i5);
        }
        if (i >= this.mGapStart) {
            return paint.getTextRunAdvances(this.mText, i + this.mGapLength, i7, i3 + this.mGapLength, i6, z, fArr, i5);
        }
        char[] obtain = TextUtils.obtain(i6);
        getChars(i3, i4, obtain, 0);
        float textRunAdvances = paint.getTextRunAdvances(obtain, i - i3, i7, 0, i6, z, fArr, i5);
        TextUtils.recycle(obtain);
        return textRunAdvances;
    }

    @Override // android.text.GraphicsOperations
    @Deprecated
    public int getTextRunCursor(int i, int i2, int i3, int i4, int i5, Paint paint) {
        int i6 = i2 - i;
        if (i2 <= this.mGapStart) {
            return paint.getTextRunCursor(this.mText, i, i6, i3, i4, i5);
        }
        if (i >= this.mGapStart) {
            return paint.getTextRunCursor(this.mText, i + this.mGapLength, i6, i3, i4 + this.mGapLength, i5) - this.mGapLength;
        }
        char[] obtain = TextUtils.obtain(i6);
        getChars(i, i2, obtain, 0);
        int textRunCursor = paint.getTextRunCursor(obtain, 0, i6, i3, i4 - i, i5);
        TextUtils.recycle(obtain);
        return textRunCursor + i;
    }

    @Override // android.text.GraphicsOperations
    public int getTextWidths(int i, int i2, float[] fArr, Paint paint) {
        checkRange("getTextWidths", i, i2);
        if (i2 <= this.mGapStart) {
            return paint.getTextWidths(this.mText, i, i2 - i, fArr);
        }
        if (i >= this.mGapStart) {
            return paint.getTextWidths(this.mText, this.mGapLength + i, i2 - i, fArr);
        }
        char[] obtain = TextUtils.obtain(i2 - i);
        getChars(i, i2, obtain, 0);
        int textWidths = paint.getTextWidths(obtain, 0, i2 - i, fArr);
        TextUtils.recycle(obtain);
        return textWidths;
    }

    public int hashCode() {
        int hashCode = (toString().hashCode() * 31) + this.mSpanCount;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mSpanCount) {
                return hashCode;
            }
            Object obj = this.mSpans[i2];
            int i3 = hashCode;
            if (obj != this) {
                i3 = (hashCode * 31) + obj.hashCode();
            }
            hashCode = (((((i3 * 31) + getSpanStart(obj)) * 31) + getSpanEnd(obj)) * 31) + getSpanFlags(obj);
            i = i2 + 1;
        }
    }

    @Override // android.text.Editable
    public SpannableStringBuilder insert(int i, CharSequence charSequence) {
        return replace(i, i, charSequence, 0, charSequence.length());
    }

    @Override // android.text.Editable
    public SpannableStringBuilder insert(int i, CharSequence charSequence, int i2, int i3) {
        return replace(i, i, charSequence, i2, i3);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.mText.length - this.mGapLength;
    }

    @Override // android.text.GraphicsOperations
    public float measureText(int i, int i2, Paint paint) {
        checkRange("measureText", i, i2);
        if (i2 <= this.mGapStart) {
            return paint.measureText(this.mText, i, i2 - i);
        }
        if (i >= this.mGapStart) {
            return paint.measureText(this.mText, this.mGapLength + i, i2 - i);
        }
        char[] obtain = TextUtils.obtain(i2 - i);
        getChars(i, i2, obtain, 0);
        float measureText = paint.measureText(obtain, 0, i2 - i);
        TextUtils.recycle(obtain);
        return measureText;
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        int i3 = this.mSpanCount;
        Object[] objArr = this.mSpans;
        int[] iArr = this.mSpanStarts;
        int[] iArr2 = this.mSpanEnds;
        int i4 = this.mGapStart;
        int i5 = this.mGapLength;
        Class cls2 = cls;
        if (cls == null) {
            cls2 = Object.class;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= i3) {
                return i2;
            }
            int i8 = iArr[i7];
            int i9 = iArr2[i7];
            int i10 = i8;
            if (i8 > i4) {
                i10 = i8 - i5;
            }
            int i11 = i9;
            if (i9 > i4) {
                i11 = i9 - i5;
            }
            int i12 = i2;
            if (i10 > i) {
                i12 = i2;
                if (i10 < i2) {
                    i12 = i2;
                    if (cls2.isInstance(objArr[i7])) {
                        i12 = i10;
                    }
                }
            }
            i2 = i12;
            if (i11 > i) {
                i2 = i12;
                if (i11 < i12) {
                    i2 = i12;
                    if (cls2.isInstance(objArr[i7])) {
                        i2 = i11;
                    }
                }
            }
            i6 = i7 + 1;
        }
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        int i = this.mSpanCount;
        while (true) {
            int i2 = i - 1;
            if (i2 < 0) {
                return;
            }
            if (this.mSpans[i2] == obj) {
                removeSpan(i2);
                return;
            }
            i = i2;
        }
    }

    @Override // android.text.Editable
    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence) {
        return replace(i, i2, charSequence, 0, charSequence.length());
    }

    @Override // android.text.Editable
    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
        checkRange("replace", i, i2);
        int length = this.mFilters.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length) {
                break;
            }
            CharSequence filter = this.mFilters[i6].filter(charSequence, i3, i4, this, i, i2);
            if (filter != null) {
                charSequence = filter;
                i3 = 0;
                i4 = filter.length();
            }
            i5 = i6 + 1;
        }
        int i7 = i2 - i;
        int i8 = i4 - i3;
        if (i7 == 0 && i8 == 0 && !hasNonExclusiveExclusiveSpanAt(charSequence, i3)) {
            return this;
        }
        TextWatcher[] textWatcherArr = (TextWatcher[]) getSpans(i, i + i7, TextWatcher.class);
        sendBeforeTextChanged(textWatcherArr, i, i7, i8);
        boolean z = (i7 == 0 || i8 == 0) ? false : true;
        int i9 = 0;
        int i10 = 0;
        if (z) {
            i9 = Selection.getSelectionStart(this);
            i10 = Selection.getSelectionEnd(this);
        }
        change(i, i2, charSequence, i3, i4);
        if (z) {
            if (i9 > i && i9 < i2) {
                int i11 = i + (((i9 - i) * i8) / i7);
                setSpan(false, Selection.SELECTION_START, i11, i11, 34);
            }
            if (i10 > i && i10 < i2) {
                int i12 = i + (((i10 - i) * i8) / i7);
                setSpan(false, Selection.SELECTION_END, i12, i12, 34);
            }
        }
        sendTextChanged(textWatcherArr, i, i7, i8);
        sendAfterTextChanged(textWatcherArr);
        sendToSpanWatchers(i, i2, i8 - i7);
        return this;
    }

    @Override // android.text.Editable
    public void setFilters(InputFilter[] inputFilterArr) {
        if (inputFilterArr == null) {
            throw new IllegalArgumentException();
        }
        this.mFilters = inputFilterArr;
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        setSpan(true, obj, i, i2, i3);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return new SpannableStringBuilder(this, i, i2);
    }

    public String substring(int i, int i2) {
        char[] cArr = new char[i2 - i];
        getChars(i, i2, cArr, 0);
        return new String(cArr);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        int length = length();
        char[] cArr = new char[length];
        getChars(0, length, cArr, 0);
        return new String(cArr);
    }
}
