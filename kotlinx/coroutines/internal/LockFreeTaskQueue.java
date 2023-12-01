package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/LockFreeTaskQueue.class */
public class LockFreeTaskQueue<E> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur;

    public LockFreeTaskQueue(boolean z) {
        this._cur = new LockFreeTaskQueueCore(8, z);
    }

    public final int a() {
        return ((LockFreeTaskQueueCore) this._cur).b();
    }

    public final boolean a(E e) {
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._cur;
            int a2 = lockFreeTaskQueueCore.a((LockFreeTaskQueueCore) e);
            if (a2 == 0) {
                return true;
            }
            if (a2 == 1) {
                a.compareAndSet(this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.e());
            } else if (a2 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._cur;
            if (lockFreeTaskQueueCore.c()) {
                return;
            }
            a.compareAndSet(this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.e());
        }
    }

    public final E c() {
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._cur;
            E e = (E) lockFreeTaskQueueCore.d();
            if (e != LockFreeTaskQueueCore.b) {
                return e;
            }
            a.compareAndSet(this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.e());
        }
    }
}
