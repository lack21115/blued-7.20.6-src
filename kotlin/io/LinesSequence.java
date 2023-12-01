package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/io/LinesSequence.class */
final class LinesSequence implements Sequence<String> {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedReader f42505a;

    @Override // kotlin.sequences.Sequence
    public Iterator<String> iterator() {
        return new LinesSequence$iterator$1(this);
    }
}
