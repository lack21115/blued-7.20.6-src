package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.sequences.Sequence;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1.class */
public final class ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1<T> implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object[] f42353a;

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return ArrayIteratorKt.a(this.f42353a);
    }
}
