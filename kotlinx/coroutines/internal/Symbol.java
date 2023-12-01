package kotlinx.coroutines.internal;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/Symbol.class */
public final class Symbol {
    private final String a;

    public Symbol(String str) {
        this.a = str;
    }

    public String toString() {
        return '<' + this.a + '>';
    }
}
