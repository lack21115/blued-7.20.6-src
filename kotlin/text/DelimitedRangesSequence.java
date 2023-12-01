package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/DelimitedRangesSequence.class */
public final class DelimitedRangesSequence implements Sequence<IntRange> {

    /* renamed from: a  reason: collision with root package name */
    private final CharSequence f42720a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f42721c;
    private final Function2<CharSequence, Integer, Pair<Integer, Integer>> d;

    /* JADX WARN: Multi-variable type inference failed */
    public DelimitedRangesSequence(CharSequence input, int i, int i2, Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> getNextMatch) {
        Intrinsics.e(input, "input");
        Intrinsics.e(getNextMatch, "getNextMatch");
        this.f42720a = input;
        this.b = i;
        this.f42721c = i2;
        this.d = getNextMatch;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<IntRange> iterator() {
        return new DelimitedRangesSequence$iterator$1(this);
    }
}
