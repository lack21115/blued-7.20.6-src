package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt___SequencesKt$zipWithNext$1.class */
final class SequencesKt___SequencesKt$zipWithNext$1<T> extends Lambda implements Function2<T, T, Pair<? extends T, ? extends T>> {

    /* renamed from: a  reason: collision with root package name */
    public static final SequencesKt___SequencesKt$zipWithNext$1 f42692a = new SequencesKt___SequencesKt$zipWithNext$1();

    SequencesKt___SequencesKt$zipWithNext$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Pair<T, T> invoke(T t, T t2) {
        return TuplesKt.a(t, t2);
    }
}
