package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/jvm/internal/CoroutineStackFrame.class */
public interface CoroutineStackFrame {
    CoroutineStackFrame getCallerFrame();

    StackTraceElement getStackTraceElement();
}
