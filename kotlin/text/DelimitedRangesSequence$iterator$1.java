package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/DelimitedRangesSequence$iterator$1.class */
public final class DelimitedRangesSequence$iterator$1 implements Iterator<IntRange>, KMappedMarker {
    final /* synthetic */ DelimitedRangesSequence a;
    private int b = -1;
    private int c;
    private int d;
    private IntRange e;
    private int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DelimitedRangesSequence$iterator$1(DelimitedRangesSequence delimitedRangesSequence) {
        int i;
        CharSequence charSequence;
        this.a = delimitedRangesSequence;
        i = delimitedRangesSequence.b;
        charSequence = delimitedRangesSequence.a;
        int a = RangesKt.a(i, 0, charSequence.length());
        this.c = a;
        this.d = a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0034, code lost:
        if (r0 < r1) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b() {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.DelimitedRangesSequence$iterator$1.b():void");
    }

    @Override // java.util.Iterator
    /* renamed from: a */
    public IntRange next() {
        if (this.b == -1) {
            b();
        }
        if (this.b != 0) {
            IntRange intRange = this.e;
            if (intRange != null) {
                this.e = null;
                this.b = -1;
                return intRange;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.b == -1) {
            b();
        }
        return this.b == 1;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
