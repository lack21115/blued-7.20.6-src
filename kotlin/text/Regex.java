package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/Regex.class */
public final class Regex implements Serializable {
    public static final Companion a = new Companion(null);
    private final Pattern b;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/text/Regex$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/text/Regex$Serialized.class */
    static final class Serialized implements Serializable {
        public static final Companion a = new Companion(null);
        private static final long serialVersionUID = 0;
        private final String b;
        private final int c;

        @Metadata
        /* loaded from: source-3503164-dex2jar.jar:kotlin/text/Regex$Serialized$Companion.class */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Serialized(String pattern, int i) {
            Intrinsics.e(pattern, "pattern");
            this.b = pattern;
            this.c = i;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.b, this.c);
            Intrinsics.c(compile, "compile(pattern, flags)");
            return new Regex(compile);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(java.lang.String r4) {
        /*
            r3 = this;
            r0 = r4
            java.lang.String r1 = "pattern"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r4
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            r4 = r0
            r0 = r4
            java.lang.String r1 = "compile(pattern)"
            kotlin.jvm.internal.Intrinsics.c(r0, r1)
            r0 = r3
            r1 = r4
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }

    public Regex(Pattern nativePattern) {
        Intrinsics.e(nativePattern, "nativePattern");
        this.b = nativePattern;
    }

    private final Object writeReplace() {
        String pattern = this.b.pattern();
        Intrinsics.c(pattern, "nativePattern.pattern()");
        return new Serialized(pattern, this.b.flags());
    }

    public final MatchResult a(CharSequence input, int i) {
        MatchResult b;
        Intrinsics.e(input, "input");
        Matcher matcher = this.b.matcher(input);
        Intrinsics.c(matcher, "nativePattern.matcher(input)");
        b = RegexKt.b(matcher, i, input);
        return b;
    }

    public final boolean a(CharSequence input) {
        Intrinsics.e(input, "input");
        return this.b.matcher(input).matches();
    }

    public final List<String> b(CharSequence input, int i) {
        int end;
        Intrinsics.e(input, "input");
        StringsKt.a(i);
        Matcher matcher = this.b.matcher(input);
        if (i == 1 || !matcher.find()) {
            return CollectionsKt.a(input.toString());
        }
        int i2 = 10;
        if (i > 0) {
            i2 = RangesKt.d(i, 10);
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = i - 1;
        int i4 = 0;
        do {
            arrayList.add(input.subSequence(i4, matcher.start()).toString());
            end = matcher.end();
            if (i3 >= 0 && arrayList.size() == i3) {
                break;
            }
            i4 = end;
        } while (matcher.find());
        arrayList.add(input.subSequence(end, input.length()).toString());
        return arrayList;
    }

    public String toString() {
        String pattern = this.b.toString();
        Intrinsics.c(pattern, "nativePattern.toString()");
        return pattern;
    }
}
