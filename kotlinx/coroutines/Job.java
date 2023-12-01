package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/Job.class */
public interface Job extends CoroutineContext.Element {
    public static final Key C_ = Key.f42835a;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/Job$DefaultImpls.class */
    public static final class DefaultImpls {
        public static <R> R a(Job job, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) CoroutineContext.Element.DefaultImpls.a(job, r, function2);
        }

        public static <E extends CoroutineContext.Element> E a(Job job, CoroutineContext.Key<E> key) {
            return (E) CoroutineContext.Element.DefaultImpls.a(job, key);
        }

        public static CoroutineContext a(Job job, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.a(job, coroutineContext);
        }

        public static /* synthetic */ DisposableHandle a(Job job, boolean z, boolean z2, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                if ((i & 2) != 0) {
                    z2 = true;
                }
                return job.a(z, z2, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static /* synthetic */ void a(Job job, CancellationException cancellationException, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                cancellationException = null;
            }
            job.a(cancellationException);
        }

        public static CoroutineContext b(Job job, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.b(job, key);
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/Job$Key.class */
    public static final class Key implements CoroutineContext.Key<Job> {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Key f42835a = new Key();

        private Key() {
        }
    }

    ChildHandle a(ChildJob childJob);

    DisposableHandle a(boolean z, boolean z2, Function1<? super Throwable, Unit> function1);

    void a(CancellationException cancellationException);

    boolean a();

    DisposableHandle a_(Function1<? super Throwable, Unit> function1);

    boolean ay_();

    Object b(Continuation<? super Unit> continuation);

    boolean g();

    boolean h();

    CancellationException i();
}
