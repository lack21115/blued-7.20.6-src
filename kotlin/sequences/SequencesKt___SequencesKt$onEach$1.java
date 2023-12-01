package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt___SequencesKt$onEach$1.class */
final class SequencesKt___SequencesKt$onEach$1<T> extends Lambda implements Function1<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function1<T, Unit> f42678a;

    @Override // kotlin.jvm.functions.Function1
    public final T invoke(T t) {
        this.f42678a.invoke(t);
        return t;
    }
}
