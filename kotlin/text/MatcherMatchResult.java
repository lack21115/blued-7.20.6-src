package kotlin.text;

import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/MatcherMatchResult.class */
public final class MatcherMatchResult implements MatchResult {

    /* renamed from: a  reason: collision with root package name */
    private final Matcher f42725a;
    private final CharSequence b;

    /* renamed from: c  reason: collision with root package name */
    private final MatchGroupCollection f42726c;

    public MatcherMatchResult(Matcher matcher, CharSequence input) {
        Intrinsics.e(matcher, "matcher");
        Intrinsics.e(input, "input");
        this.f42725a = matcher;
        this.b = input;
        this.f42726c = new MatcherMatchResult$groups$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.util.regex.MatchResult b() {
        return this.f42725a;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult a() {
        MatchResult b;
        int end = b().end() + (b().end() == b().start() ? 1 : 0);
        if (end <= this.b.length()) {
            Matcher matcher = this.f42725a.pattern().matcher(this.b);
            Intrinsics.c(matcher, "matcher.pattern().matcher(input)");
            b = RegexKt.b(matcher, end, this.b);
            return b;
        }
        return null;
    }
}
