package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/StringsKt___StringsKt$asIterable$$inlined$Iterable$1.class */
public final class StringsKt___StringsKt$asIterable$$inlined$Iterable$1 implements Iterable<Character>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CharSequence f42751a;

    @Override // java.lang.Iterable
    public Iterator<Character> iterator() {
        return StringsKt.c(this.f42751a);
    }
}
