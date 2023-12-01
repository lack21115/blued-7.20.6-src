package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysJvmKt$asList$8.class */
public final class ArraysKt___ArraysJvmKt$asList$8 extends AbstractList<Character> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ char[] f42343a;

    @Override // kotlin.collections.AbstractList, java.util.List
    /* renamed from: a */
    public Character get(int i) {
        return Character.valueOf(this.f42343a[i]);
    }

    public boolean a(char c2) {
        return ArraysKt.a(this.f42343a, c2);
    }

    public int b(char c2) {
        return ArraysKt.b(this.f42343a, c2);
    }

    public int c(char c2) {
        return ArraysKt.c(this.f42343a, c2);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Character) {
            return a(((Character) obj).charValue());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f42343a.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Character) {
            return b(((Character) obj).charValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f42343a.length == 0;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Character) {
            return c(((Character) obj).charValue());
        }
        return -1;
    }
}
