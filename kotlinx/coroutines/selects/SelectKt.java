package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/selects/SelectKt.class */
public final class SelectKt {
    private static final Object a = new Symbol("NOT_SELECTED");
    private static final Object b = new Symbol("ALREADY_SELECTED");
    private static final Object c = new Symbol("UNDECIDED");
    private static final Object d = new Symbol("RESUMED");
    private static final SeqNumber e = new SeqNumber();

    public static final Object a() {
        return a;
    }

    public static final Object b() {
        return b;
    }

    public static final /* synthetic */ Object c() {
        return c;
    }

    public static final /* synthetic */ Object d() {
        return d;
    }

    public static final /* synthetic */ SeqNumber e() {
        return e;
    }
}
