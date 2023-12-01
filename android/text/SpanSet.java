package android.text;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/text/SpanSet.class */
public class SpanSet<E> {
    private final Class<? extends E> classType;
    int numberOfSpans = 0;
    int[] spanEnds;
    int[] spanFlags;
    int[] spanStarts;
    E[] spans;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpanSet(Class<? extends E> cls) {
        this.classType = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNextTransition(int i, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.numberOfSpans) {
                return i2;
            }
            int i5 = this.spanStarts[i4];
            int i6 = this.spanEnds[i4];
            int i7 = i2;
            if (i5 > i) {
                i7 = i2;
                if (i5 < i2) {
                    i7 = i5;
                }
            }
            i2 = i7;
            if (i6 > i) {
                i2 = i7;
                if (i6 < i7) {
                    i2 = i6;
                }
            }
            i3 = i4 + 1;
        }
    }

    public boolean hasSpansIntersecting(int i, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.numberOfSpans) {
                return false;
            }
            if (this.spanStarts[i4] < i2 && this.spanEnds[i4] > i) {
                return true;
            }
            i3 = i4 + 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void init(Spanned spanned, int i, int i2) {
        Object[] spans = spanned.getSpans(i, i2, this.classType);
        int length = spans.length;
        if (length > 0 && (this.spans == null || this.spans.length < length)) {
            this.spans = (E[]) ((Object[]) Array.newInstance(this.classType, length));
            this.spanStarts = new int[length];
            this.spanEnds = new int[length];
            this.spanFlags = new int[length];
        }
        int i3 = this.numberOfSpans;
        this.numberOfSpans = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length) {
                break;
            }
            Object obj = spans[i5];
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (spanStart != spanEnd) {
                int spanFlags = spanned.getSpanFlags(obj);
                this.spans[this.numberOfSpans] = obj;
                this.spanStarts[this.numberOfSpans] = spanStart;
                this.spanEnds[this.numberOfSpans] = spanEnd;
                this.spanFlags[this.numberOfSpans] = spanFlags;
                this.numberOfSpans++;
            }
            i4 = i5 + 1;
        }
        if (this.numberOfSpans < i3) {
            Arrays.fill(this.spans, this.numberOfSpans, i3, (Object) null);
        }
    }

    public void recycle() {
        if (this.spans != null) {
            Arrays.fill(this.spans, 0, this.numberOfSpans, (Object) null);
        }
    }
}
