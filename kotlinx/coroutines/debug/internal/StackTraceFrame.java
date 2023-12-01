package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/internal/StackTraceFrame.class */
public final class StackTraceFrame implements CoroutineStackFrame {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineStackFrame f43042a;
    private final StackTraceElement b;

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        return this.f43042a;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return this.b;
    }
}
