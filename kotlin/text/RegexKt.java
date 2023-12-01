package kotlin.text;

import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/RegexKt.class */
public final class RegexKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRange b(java.util.regex.MatchResult matchResult, int i) {
        return RangesKt.b(matchResult.start(i), matchResult.end(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MatchResult b(Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new MatcherMatchResult(matcher, charSequence);
        }
        return null;
    }
}
