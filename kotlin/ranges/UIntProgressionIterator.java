package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.collections.UIntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/UIntProgressionIterator.class */
final class UIntProgressionIterator extends UIntIterator {
    private final int a;
    private boolean b;
    private final int c;
    private int d;

    private UIntProgressionIterator(int i, int i2, int i3) {
        this.a = i2;
        boolean z = true;
        int a = UnsignedKt.a(i, i2);
        if (i3 <= 0 ? a < 0 : a > 0) {
            z = false;
        }
        this.b = z;
        this.c = UInt.c(i3);
        this.d = this.b ? i : this.a;
    }

    public /* synthetic */ UIntProgressionIterator(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    @Override // kotlin.collections.UIntIterator
    public int a() {
        int i = this.d;
        if (i != this.a) {
            this.d = UInt.c(this.c + i);
            return i;
        } else if (this.b) {
            this.b = false;
            return i;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b;
    }
}
