package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysKt$withIndex$1.class */
final class ArraysKt___ArraysKt$withIndex$1<T> extends Lambda implements Function0<Iterator<? extends T>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ T[] f42362a;

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a */
    public final Iterator<T> invoke() {
        return ArrayIteratorKt.a(this.f42362a);
    }
}
