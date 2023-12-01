package kotlin.text;

import kotlin.Metadata;
import kotlin.collections.AbstractList;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/MatcherMatchResult$groupValues$1.class */
public final class MatcherMatchResult$groupValues$1 extends AbstractList<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MatcherMatchResult f42727a;

    public int a(String str) {
        return super.indexOf(str);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    /* renamed from: a */
    public String get(int i) {
        java.util.regex.MatchResult b;
        b = this.f42727a.b();
        String group = b.group(i);
        String str = group;
        if (group == null) {
            str = "";
        }
        return str;
    }

    public int b(String str) {
        return super.lastIndexOf(str);
    }

    public boolean c(String str) {
        return super.contains(str);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof String) {
            return c((String) obj);
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        java.util.regex.MatchResult b;
        b = this.f42727a.b();
        return b.groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof String) {
            return a((String) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof String) {
            return b((String) obj);
        }
        return -1;
    }
}
