package kotlinx.coroutines.debug.internal;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.Job;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/internal/DebugProbesImpl.class */
public final class DebugProbesImpl {
    private static volatile int installations;
    public static final DebugProbesImpl a = new DebugProbesImpl();
    private static final SimpleDateFormat b = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final ConcurrentWeakMap<CoroutineOwner<?>, Boolean> c = new ConcurrentWeakMap<>(false, 1, null);
    private static final /* synthetic */ SequenceNumberRefVolatile d = new Object(0) { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl.SequenceNumberRefVolatile
        volatile long sequenceNumber;

        {
            this.sequenceNumber = r5;
        }
    };
    private static final ReentrantReadWriteLock f = new ReentrantReadWriteLock();
    private static boolean g = true;
    private static boolean h = true;
    private static final Function1<Boolean, Unit> i = a.c();
    private static final ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> j = new ConcurrentWeakMap<>(true);
    private static final /* synthetic */ AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(SequenceNumberRefVolatile.class, "sequenceNumber");

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner.class */
    public static final class CoroutineOwner<T> implements Continuation<T>, CoroutineStackFrame {
        public final Continuation<T> a;
        public final DebugCoroutineInfoImpl b;
        private final CoroutineStackFrame c;

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public CoroutineStackFrame getCallerFrame() {
            CoroutineStackFrame coroutineStackFrame = this.c;
            if (coroutineStackFrame == null) {
                return null;
            }
            return coroutineStackFrame.getCallerFrame();
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.a.getContext();
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public StackTraceElement getStackTraceElement() {
            CoroutineStackFrame coroutineStackFrame = this.c;
            if (coroutineStackFrame == null) {
                return null;
            }
            return coroutineStackFrame.getStackTraceElement();
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object obj) {
            DebugProbesImpl.a.b(this);
            this.a.resumeWith(obj);
        }

        public String toString() {
            return this.a.toString();
        }
    }

    private DebugProbesImpl() {
    }

    private final CoroutineStackFrame a(CoroutineStackFrame coroutineStackFrame) {
        CoroutineStackFrame callerFrame;
        do {
            callerFrame = coroutineStackFrame.getCallerFrame();
            if (callerFrame == null) {
                return null;
            }
            coroutineStackFrame = callerFrame;
        } while (callerFrame.getStackTraceElement() == null);
        return callerFrame;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(CoroutineOwner<?> coroutineOwner) {
        CoroutineContext context = coroutineOwner.b.getContext();
        Job job = context == null ? null : (Job) context.get(Job.C_);
        if (job != null && job.g()) {
            c.remove(coroutineOwner);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(CoroutineOwner<?> coroutineOwner) {
        c.remove(coroutineOwner);
        CoroutineStackFrame b2 = coroutineOwner.b.b();
        CoroutineStackFrame a2 = b2 == null ? null : a(b2);
        if (a2 == null) {
            return;
        }
        j.remove(a2);
    }

    private final Function1<Boolean, Unit> c() {
        Object f2;
        Object newInstance;
        try {
            Result.Companion companion = Result.a;
            DebugProbesImpl debugProbesImpl = this;
            newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.a;
            f2 = Result.f(ResultKt.a(th));
        }
        if (newInstance != null) {
            f2 = Result.f((Function1) TypeIntrinsics.b(newInstance, 1));
            Object obj = f2;
            if (Result.b(f2)) {
                obj = null;
            }
            return (Function1) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
    }

    public final boolean a() {
        return h;
    }
}
