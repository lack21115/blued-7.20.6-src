package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/selects/SelectInstance.class */
public interface SelectInstance<R> {
    Object a(AtomicDesc atomicDesc);

    Object a(LockFreeLinkedListNode.PrepareOp prepareOp);

    Continuation<R> a();

    void a(Throwable th);

    void a(DisposableHandle disposableHandle);

    boolean f();

    boolean g();
}
