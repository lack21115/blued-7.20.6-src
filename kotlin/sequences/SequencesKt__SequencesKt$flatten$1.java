package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt__SequencesKt$flatten$1.class */
final class SequencesKt__SequencesKt$flatten$1<T> extends Lambda implements Function1<Sequence<? extends T>, Iterator<? extends T>> {

    /* renamed from: a  reason: collision with root package name */
    public static final SequencesKt__SequencesKt$flatten$1 f42649a = new SequencesKt__SequencesKt$flatten$1();

    SequencesKt__SequencesKt$flatten$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final Iterator<T> invoke(Sequence<? extends T> it) {
        Intrinsics.e(it, "it");
        return (Iterator<? extends T>) it.iterator();
    }
}
