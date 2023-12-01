package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.selects.SelectClause2;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/SendChannel.class */
public interface SendChannel<E> {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/SendChannel$DefaultImpls.class */
    public static final class DefaultImpls {
        public static /* synthetic */ boolean a(SendChannel sendChannel, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return sendChannel.b_(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }

    Object a(E e, Continuation<? super Unit> continuation);

    void a(Function1<? super Throwable, Unit> function1);

    Object a_(E e);

    boolean b_(Throwable th);

    boolean u();

    SelectClause2<E, SendChannel<E>> v();
}
