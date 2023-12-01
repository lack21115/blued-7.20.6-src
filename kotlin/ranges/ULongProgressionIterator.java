package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.collections.ULongIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/ULongProgressionIterator.class */
final class ULongProgressionIterator extends ULongIterator {

    /* renamed from: a  reason: collision with root package name */
    private final long f42593a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final long f42594c;
    private long d;

    private ULongProgressionIterator(long j, long j2, long j3) {
        this.f42593a = j2;
        boolean z = true;
        int a2 = UnsignedKt.a(j, j2);
        if (j3 <= 0 ? a2 < 0 : a2 > 0) {
            z = false;
        }
        this.b = z;
        this.f42594c = ULong.c(j3);
        this.d = this.b ? j : this.f42593a;
    }

    public /* synthetic */ ULongProgressionIterator(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    @Override // kotlin.collections.ULongIterator
    public long a() {
        long j = this.d;
        if (j != this.f42593a) {
            this.d = ULong.c(this.f42594c + j);
            return j;
        } else if (this.b) {
            this.b = false;
            return j;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b;
    }
}
