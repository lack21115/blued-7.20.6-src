package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/RegexOption.class */
public enum RegexOption implements FlagEnum {
    IGNORE_CASE(2, 0, 2, null),
    MULTILINE(8, 0, 2, null),
    LITERAL(16, 0, 2, null),
    UNIX_LINES(1, 0, 2, null),
    COMMENTS(4, 0, 2, null),
    DOT_MATCHES_ALL(32, 0, 2, null),
    CANON_EQ(128, 0, 2, null);
    
    private final int h;
    private final int i;

    RegexOption(int i, int i2) {
        this.h = i;
        this.i = i2;
    }

    /* synthetic */ RegexOption(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? i : i2);
    }

    @Override // kotlin.text.FlagEnum
    public int a() {
        return this.h;
    }

    @Override // kotlin.text.FlagEnum
    public int b() {
        return this.i;
    }
}
