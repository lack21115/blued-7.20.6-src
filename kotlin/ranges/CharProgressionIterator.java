package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/CharProgressionIterator.class */
public final class CharProgressionIterator extends CharIterator {
    private final int a;
    private final int b;
    private boolean c;
    private int d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    public CharProgressionIterator(char c, char c2, int i) {
        this.a = i;
        this.b = c2;
        boolean z = true;
        int a = Intrinsics.a((int) c, (int) c2);
        if (i <= 0 ? a < 0 : a > 0) {
            z = false;
        }
        this.c = z;
        this.d = z ? c : this.b;
    }

    @Override // kotlin.collections.CharIterator
    public char a() {
        int i = this.d;
        if (i != this.b) {
            this.d = this.a + i;
        } else if (!this.c) {
            throw new NoSuchElementException();
        } else {
            this.c = false;
        }
        return (char) i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c;
    }
}
