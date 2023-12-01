package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/StringsKt___StringsKt$asSequence$$inlined$Sequence$1.class */
public final class StringsKt___StringsKt$asSequence$$inlined$Sequence$1 implements Sequence<Character> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CharSequence f42752a;

    @Override // kotlin.sequences.Sequence
    public Iterator<Character> iterator() {
        return StringsKt.c(this.f42752a);
    }
}
