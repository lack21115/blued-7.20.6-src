package kotlinx.coroutines.sync;

import com.android.internal.telephony.IccCardConstants;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/sync/MutexKt.class */
public final class MutexKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Symbol f43630a = new Symbol("LOCK_FAIL");
    private static final Symbol b = new Symbol("UNLOCK_FAIL");

    /* renamed from: c  reason: collision with root package name */
    private static final Symbol f43631c = new Symbol("SELECT_SUCCESS");
    private static final Symbol d = new Symbol(IccCardConstants.INTENT_VALUE_ICC_LOCKED);
    private static final Symbol e = new Symbol("UNLOCKED");
    private static final Empty f = new Empty(d);
    private static final Empty g = new Empty(e);

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object a(kotlinx.coroutines.sync.Mutex r4, java.lang.Object r5, kotlin.jvm.functions.Function0<? extends T> r6, kotlin.coroutines.Continuation<? super T> r7) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexKt.a(kotlinx.coroutines.sync.Mutex, java.lang.Object, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Mutex a(boolean z) {
        return new MutexImpl(z);
    }

    public static /* synthetic */ Mutex a(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return a(z);
    }
}
