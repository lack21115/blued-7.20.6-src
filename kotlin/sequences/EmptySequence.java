package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.EmptyIterator;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/EmptySequence.class */
final class EmptySequence implements DropTakeSequence, Sequence {

    /* renamed from: a  reason: collision with root package name */
    public static final EmptySequence f42623a = new EmptySequence();

    private EmptySequence() {
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return EmptyIterator.f42378a;
    }
}
