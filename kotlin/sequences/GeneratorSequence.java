package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/GeneratorSequence.class */
final class GeneratorSequence<T> implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Function0<T> f42632a;
    private final Function1<T, T> b;

    /* JADX WARN: Multi-variable type inference failed */
    public GeneratorSequence(Function0<? extends T> getInitialValue, Function1<? super T, ? extends T> getNextValue) {
        Intrinsics.e(getInitialValue, "getInitialValue");
        Intrinsics.e(getNextValue, "getNextValue");
        this.f42632a = getInitialValue;
        this.b = getNextValue;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new GeneratorSequence$iterator$1(this);
    }
}
