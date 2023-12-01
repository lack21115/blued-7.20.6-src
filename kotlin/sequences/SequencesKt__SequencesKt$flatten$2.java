package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt__SequencesKt$flatten$2.class */
final class SequencesKt__SequencesKt$flatten$2<T> extends Lambda implements Function1<Iterable<? extends T>, Iterator<? extends T>> {

    /* renamed from: a  reason: collision with root package name */
    public static final SequencesKt__SequencesKt$flatten$2 f42650a = new SequencesKt__SequencesKt$flatten$2();

    SequencesKt__SequencesKt$flatten$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final Iterator<T> invoke(Iterable<? extends T> it) {
        Intrinsics.e(it, "it");
        return (Iterator<? extends T>) it.iterator();
    }
}
