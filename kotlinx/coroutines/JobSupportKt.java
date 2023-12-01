package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/JobSupportKt.class */
public final class JobSupportKt {
    private static final Symbol b = new Symbol("COMPLETING_ALREADY");

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f42845a = new Symbol("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c  reason: collision with root package name */
    private static final Symbol f42846c = new Symbol("COMPLETING_RETRY");
    private static final Symbol d = new Symbol("TOO_LATE_TO_CANCEL");
    private static final Symbol e = new Symbol("SEALED");
    private static final Empty f = new Empty(false);
    private static final Empty g = new Empty(true);

    public static final Object a(Object obj) {
        IncompleteStateBox incompleteStateBox = obj;
        if (obj instanceof Incomplete) {
            incompleteStateBox = new IncompleteStateBox((Incomplete) obj);
        }
        return incompleteStateBox;
    }

    public static final /* synthetic */ Empty a() {
        return g;
    }

    public static final Object b(Object obj) {
        Incomplete incomplete;
        IncompleteStateBox incompleteStateBox = obj instanceof IncompleteStateBox ? (IncompleteStateBox) obj : null;
        if (incompleteStateBox != null && (incomplete = incompleteStateBox.f42829a) != null) {
            return incomplete;
        }
        return obj;
    }

    public static final /* synthetic */ Empty b() {
        return f;
    }

    public static final /* synthetic */ Symbol c() {
        return b;
    }

    public static final /* synthetic */ Symbol d() {
        return d;
    }

    public static final /* synthetic */ Symbol e() {
        return f42846c;
    }

    public static final /* synthetic */ Symbol f() {
        return e;
    }
}
