package kotlinx.coroutines.internal;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/Symbol.class */
public final class Symbol {

    /* renamed from: a  reason: collision with root package name */
    private final String f43563a;

    public Symbol(String str) {
        this.f43563a = str;
    }

    public String toString() {
        return '<' + this.f43563a + '>';
    }
}
