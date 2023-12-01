package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.EmptyIterator;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/EmptySequence.class */
final class EmptySequence implements DropTakeSequence, Sequence {
    public static final EmptySequence a = new EmptySequence();

    private EmptySequence() {
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return EmptyIterator.a;
    }
}
