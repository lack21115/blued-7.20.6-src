package android.text;

import com.android.internal.util.ArrayUtils;
import com.android.internal.util.GrowingArrayUtils;
import java.lang.reflect.Array;
import libcore.util.EmptyArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/text/SpannableStringInternal.class */
public abstract class SpannableStringInternal {
    private static final int COLUMNS = 3;
    static final Object[] EMPTY = new Object[0];
    private static final int END = 1;
    private static final int FLAGS = 2;
    private static final int START = 0;
    private int mSpanCount;
    private int[] mSpanData;
    private Object[] mSpans;
    private String mText;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpannableStringInternal(CharSequence charSequence, int i, int i2) {
        if (i == 0 && i2 == charSequence.length()) {
            this.mText = charSequence.toString();
        } else {
            this.mText = charSequence.toString().substring(i, i2);
        }
        this.mSpans = EmptyArray.OBJECT;
        this.mSpanData = EmptyArray.INT;
        if (!(charSequence instanceof Spanned)) {
            return;
        }
        Spanned spanned = (Spanned) charSequence;
        Object[] spans = spanned.getSpans(i, i2, Object.class);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= spans.length) {
                return;
            }
            int spanStart = spanned.getSpanStart(spans[i4]);
            int spanEnd = spanned.getSpanEnd(spans[i4]);
            int spanFlags = spanned.getSpanFlags(spans[i4]);
            int i5 = spanStart < i ? i : spanStart;
            int i6 = spanEnd;
            if (spanEnd > i2) {
                i6 = i2;
            }
            setSpan(spans[i4], i5 - i, i6 - i, spanFlags);
            i3 = i4 + 1;
        }
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

    private static String region(int i, int i2) {
        return "(" + i + " ... " + i2 + ")";
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
            spanWatcherArr[i4].onSpanAdded((Spannable) this, obj, i, i2);
            i3 = i4 + 1;
        }
    }

    private void sendSpanChanged(Object obj, int i, int i2, int i3, int i4) {
        SpanWatcher[] spanWatcherArr = (SpanWatcher[]) getSpans(Math.min(i, i3), Math.max(i2, i4), SpanWatcher.class);
        int length = spanWatcherArr.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length) {
                return;
            }
            spanWatcherArr[i6].onSpanChanged((Spannable) this, obj, i, i2, i3, i4);
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
            spanWatcherArr[i4].onSpanRemoved((Spannable) this, obj, i, i2);
            i3 = i4 + 1;
        }
    }

    public final char charAt(int i) {
        return this.mText.charAt(i);
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

    public final void getChars(int i, int i2, char[] cArr, int i3) {
        this.mText.getChars(i, i2, cArr, i3);
    }

    public int getSpanEnd(Object obj) {
        int i = this.mSpanCount;
        Object[] objArr = this.mSpans;
        int[] iArr = this.mSpanData;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (objArr[i] == obj) {
                return iArr[(i * 3) + 1];
            }
        }
    }

    public int getSpanFlags(Object obj) {
        int i = this.mSpanCount;
        Object[] objArr = this.mSpans;
        int[] iArr = this.mSpanData;
        while (true) {
            i--;
            if (i < 0) {
                return 0;
            }
            if (objArr[i] == obj) {
                return iArr[(i * 3) + 2];
            }
        }
    }

    public int getSpanStart(Object obj) {
        int i = this.mSpanCount;
        Object[] objArr = this.mSpans;
        int[] iArr = this.mSpanData;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (objArr[i] == obj) {
                return iArr[(i * 3) + 0];
            }
        }
    }

    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        int i3;
        int i4 = this.mSpanCount;
        Object[] objArr = this.mSpans;
        int[] iArr = this.mSpanData;
        Object[] objArr2 = null;
        Object obj = null;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            if (cls == null || cls.isInstance(objArr[i6])) {
                int i7 = iArr[(i6 * 3) + 0];
                int i8 = iArr[(i6 * 3) + 1];
                if (i7 <= i2 && i8 >= i && (i7 == i8 || i == i2 || (i7 != i2 && i8 != i))) {
                    if (i5 == 0) {
                        obj = objArr[i6];
                        i5++;
                    } else {
                        if (i5 == 1) {
                            objArr2 = (Object[]) Array.newInstance((Class<?>) cls, (i4 - i6) + 1);
                            objArr2[0] = obj;
                        }
                        int i9 = iArr[(i6 * 3) + 2] & Spanned.SPAN_PRIORITY;
                        if (i9 != 0) {
                            int i10 = 0;
                            while (true) {
                                i3 = i10;
                                if (i3 >= i5 || i9 > (getSpanFlags(objArr2[i3]) & Spanned.SPAN_PRIORITY)) {
                                    break;
                                }
                                i10 = i3 + 1;
                            }
                            System.arraycopy(objArr2, i3, objArr2, i3 + 1, i5 - i3);
                            objArr2[i3] = objArr[i6];
                            i5++;
                        } else {
                            objArr2[i5] = objArr[i6];
                            i5++;
                        }
                    }
                }
            }
        }
        if (i5 == 0) {
            return (T[]) ArrayUtils.emptyArray(cls);
        }
        if (i5 == 1) {
            Object[] objArr3 = (Object[]) Array.newInstance((Class<?>) cls, 1);
            objArr3[0] = obj;
            return (T[]) objArr3;
        } else if (i5 == objArr2.length) {
            return (T[]) objArr2;
        } else {
            Object[] objArr4 = (Object[]) Array.newInstance((Class<?>) cls, i5);
            System.arraycopy(objArr2, 0, objArr4, 0, i5);
            return (T[]) objArr4;
        }
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

    public final int length() {
        return this.mText.length();
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        int i3 = this.mSpanCount;
        Object[] objArr = this.mSpans;
        int[] iArr = this.mSpanData;
        Class cls2 = cls;
        if (cls == null) {
            cls2 = Object.class;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i3) {
                return i2;
            }
            int i6 = iArr[(i5 * 3) + 0];
            int i7 = iArr[(i5 * 3) + 1];
            int i8 = i2;
            if (i6 > i) {
                i8 = i2;
                if (i6 < i2) {
                    i8 = i2;
                    if (cls2.isInstance(objArr[i5])) {
                        i8 = i6;
                    }
                }
            }
            i2 = i8;
            if (i7 > i) {
                i2 = i8;
                if (i7 < i8) {
                    i2 = i8;
                    if (cls2.isInstance(objArr[i5])) {
                        i2 = i7;
                    }
                }
            }
            i4 = i5 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeSpan(Object obj) {
        int i = this.mSpanCount;
        Object[] objArr = this.mSpans;
        int[] iArr = this.mSpanData;
        int i2 = i;
        while (true) {
            int i3 = i2 - 1;
            if (i3 < 0) {
                return;
            }
            if (objArr[i3] == obj) {
                int i4 = iArr[(i3 * 3) + 0];
                int i5 = iArr[(i3 * 3) + 1];
                int i6 = i - (i3 + 1);
                System.arraycopy(objArr, i3 + 1, objArr, i3, i6);
                System.arraycopy(iArr, (i3 + 1) * 3, iArr, i3 * 3, i6 * 3);
                this.mSpanCount--;
                sendSpanRemoved(obj, i4, i5);
                return;
            }
            i2 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSpan(Object obj, int i, int i2, int i3) {
        char charAt;
        char charAt2;
        checkRange("setSpan", i, i2);
        if ((i3 & 51) == 51) {
            if (i != 0 && i != length() && (charAt2 = charAt(i - 1)) != '\n') {
                throw new RuntimeException("PARAGRAPH span must start at paragraph boundary (" + i + " follows " + charAt2 + ")");
            }
            if (i2 != 0 && i2 != length() && (charAt = charAt(i2 - 1)) != '\n') {
                throw new RuntimeException("PARAGRAPH span must end at paragraph boundary (" + i2 + " follows " + charAt + ")");
            }
        }
        int i4 = this.mSpanCount;
        Object[] objArr = this.mSpans;
        int[] iArr = this.mSpanData;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= i4) {
                if (this.mSpanCount + 1 >= this.mSpans.length) {
                    Object[] newUnpaddedObjectArray = ArrayUtils.newUnpaddedObjectArray(GrowingArrayUtils.growSize(this.mSpanCount));
                    int[] iArr2 = new int[newUnpaddedObjectArray.length * 3];
                    System.arraycopy(this.mSpans, 0, newUnpaddedObjectArray, 0, this.mSpanCount);
                    System.arraycopy(this.mSpanData, 0, iArr2, 0, this.mSpanCount * 3);
                    this.mSpans = newUnpaddedObjectArray;
                    this.mSpanData = iArr2;
                }
                this.mSpans[this.mSpanCount] = obj;
                this.mSpanData[(this.mSpanCount * 3) + 0] = i;
                this.mSpanData[(this.mSpanCount * 3) + 1] = i2;
                this.mSpanData[(this.mSpanCount * 3) + 2] = i3;
                this.mSpanCount++;
                if (this instanceof Spannable) {
                    sendSpanAdded(obj, i, i2);
                    return;
                }
                return;
            } else if (objArr[i6] == obj) {
                int i7 = iArr[(i6 * 3) + 0];
                int i8 = iArr[(i6 * 3) + 1];
                iArr[(i6 * 3) + 0] = i;
                iArr[(i6 * 3) + 1] = i2;
                iArr[(i6 * 3) + 2] = i3;
                sendSpanChanged(obj, i7, i8, i, i2);
                return;
            } else {
                i5 = i6 + 1;
            }
        }
    }

    public final String toString() {
        return this.mText;
    }
}
