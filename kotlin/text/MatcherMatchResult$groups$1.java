package kotlin.text;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/MatcherMatchResult$groups$1.class */
public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> implements MatchNamedGroupCollection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MatcherMatchResult f42728a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.f42728a = matcherMatchResult;
    }

    public MatchGroup a(int i) {
        java.util.regex.MatchResult b;
        IntRange b2;
        java.util.regex.MatchResult b3;
        b = this.f42728a.b();
        b2 = RegexKt.b(b, i);
        if (b2.getStart().intValue() >= 0) {
            b3 = this.f42728a.b();
            String group = b3.group(i);
            Intrinsics.c(group, "matchResult.group(index)");
            return new MatchGroup(group, b2);
        }
        return null;
    }

    public boolean a(MatchGroup matchGroup) {
        return super.contains(matchGroup);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof MatchGroup) {
            return a((MatchGroup) obj);
        }
        return false;
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        java.util.regex.MatchResult b;
        b = this.f42728a.b();
        return b.groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<MatchGroup> iterator() {
        return SequencesKt.c(CollectionsKt.m(CollectionsKt.a((Collection<?>) this)), new Function1<Integer, MatchGroup>() { // from class: kotlin.text.MatcherMatchResult$groups$1$iterator$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final MatchGroup a(int i) {
                return MatcherMatchResult$groups$1.this.a(i);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ MatchGroup invoke(Integer num) {
                return a(num.intValue());
            }
        }).iterator();
    }
}
