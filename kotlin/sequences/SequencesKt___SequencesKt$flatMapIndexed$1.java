package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SequencesKt___SequencesKt$flatMapIndexed$1.class */
final /* synthetic */ class SequencesKt___SequencesKt$flatMapIndexed$1<R> extends FunctionReferenceImpl implements Function1<Iterable<? extends R>, Iterator<? extends R>> {

    /* renamed from: a  reason: collision with root package name */
    public static final SequencesKt___SequencesKt$flatMapIndexed$1 f42668a = new SequencesKt___SequencesKt$flatMapIndexed$1();

    SequencesKt___SequencesKt$flatMapIndexed$1() {
        super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final Iterator<R> invoke(Iterable<? extends R> p0) {
        Intrinsics.e(p0, "p0");
        return (Iterator<? extends R>) p0.iterator();
    }
}
