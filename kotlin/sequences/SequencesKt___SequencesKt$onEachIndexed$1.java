package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt___SequencesKt$onEachIndexed$1.class */
final class SequencesKt___SequencesKt$onEachIndexed$1<T> extends Lambda implements Function2<Integer, T, T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function2<Integer, T, Unit> f42679a;

    public final T a(int i, T t) {
        this.f42679a.invoke(Integer.valueOf(i), t);
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Integer num, Object obj) {
        return a(num.intValue(), obj);
    }
}
