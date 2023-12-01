package kotlinx.coroutines.debug.internal;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl.class */
public final class DebugCoroutineInfoImpl {

    /* renamed from: a  reason: collision with root package name */
    public final long f43028a;
    private final WeakReference<CoroutineContext> b;

    /* renamed from: c  reason: collision with root package name */
    private String f43029c;
    private WeakReference<CoroutineStackFrame> d;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x009c -> B:29:0x00db). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00c7 -> B:28:0x00d1). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.sequences.SequenceScope<? super java.lang.StackTraceElement> r6, kotlin.coroutines.jvm.internal.CoroutineStackFrame r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl.a(kotlin.sequences.SequenceScope, kotlin.coroutines.jvm.internal.CoroutineStackFrame, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String a() {
        return this.f43029c;
    }

    public final CoroutineStackFrame b() {
        WeakReference<CoroutineStackFrame> weakReference = this.d;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final CoroutineContext getContext() {
        return this.b.get();
    }

    public String toString() {
        return "DebugCoroutineInfo(state=" + a() + ",context=" + getContext() + ')';
    }
}
