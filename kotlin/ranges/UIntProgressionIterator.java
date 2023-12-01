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

    /* renamed from: a  reason: collision with root package name */
    private final int f42588a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final int f42589c;
    private int d;

    private UIntProgressionIterator(int i, int i2, int i3) {
        this.f42588a = i2;
        boolean z = true;
        int a2 = UnsignedKt.a(i, i2);
        if (i3 <= 0 ? a2 < 0 : a2 > 0) {
            z = false;
        }
        this.b = z;
        this.f42589c = UInt.c(i3);
        this.d = this.b ? i : this.f42588a;
    }

    public /* synthetic */ UIntProgressionIterator(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    @Override // kotlin.collections.UIntIterator
    public int a() {
        int i = this.d;
        if (i != this.f42588a) {
            this.d = UInt.c(this.f42589c + i);
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
