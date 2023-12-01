package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysJvmKt$asList$8.class */
public final class ArraysKt___ArraysJvmKt$asList$8 extends AbstractList<Character> implements RandomAccess {
    final /* synthetic */ char[] a;

    @Override // kotlin.collections.AbstractList, java.util.List
    /* renamed from: a */
    public Character get(int i) {
        return Character.valueOf(this.a[i]);
    }

    public boolean a(char c) {
        return ArraysKt.a(this.a, c);
    }

    public int b(char c) {
        return ArraysKt.b(this.a, c);
    }

    public int c(char c) {
        return ArraysKt.c(this.a, c);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Character) {
            return a(((Character) obj).charValue());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.a.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Character) {
            return b(((Character) obj).charValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.a.length == 0;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Character) {
            return c(((Character) obj).charValue());
        }
        return -1;
    }
}
