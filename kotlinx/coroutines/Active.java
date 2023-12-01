package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/Active.class */
public final class Active implements NotCompleted {
    public static final Active a = new Active();

    private Active() {
    }

    public String toString() {
        return "Active";
    }
}
