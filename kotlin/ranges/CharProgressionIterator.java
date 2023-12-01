package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/CharProgressionIterator.class */
public final class CharProgressionIterator extends CharIterator {

    /* renamed from: a  reason: collision with root package name */
    private final int f42570a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f42571c;
    private int d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    public CharProgressionIterator(char c2, char c3, int i) {
        this.f42570a = i;
        this.b = c3;
        boolean z = true;
        int a2 = Intrinsics.a((int) c2, (int) c3);
        if (i <= 0 ? a2 < 0 : a2 > 0) {
            z = false;
        }
        this.f42571c = z;
        this.d = z ? c2 : this.b;
    }

    @Override // kotlin.collections.CharIterator
    public char a() {
        int i = this.d;
        if (i != this.b) {
            this.d = this.f42570a + i;
        } else if (!this.f42571c) {
            throw new NoSuchElementException();
        } else {
            this.f42571c = false;
        }
        return (char) i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f42571c;
    }
}
