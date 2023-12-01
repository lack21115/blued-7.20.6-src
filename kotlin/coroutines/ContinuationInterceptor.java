package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/ContinuationInterceptor.class */
public interface ContinuationInterceptor extends CoroutineContext.Element {

    /* renamed from: a  reason: collision with root package name */
    public static final Key f42453a = Key.f42454a;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/ContinuationInterceptor$DefaultImpls.class */
    public static final class DefaultImpls {
        public static <E extends CoroutineContext.Element> E a(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<E> key) {
            Intrinsics.e(key, "key");
            if (!(key instanceof AbstractCoroutineContextKey)) {
                ContinuationInterceptor continuationInterceptor2 = null;
                if (ContinuationInterceptor.f42453a == key) {
                    continuationInterceptor2 = continuationInterceptor;
                }
                return continuationInterceptor2;
            }
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
            E e = null;
            if (abstractCoroutineContextKey.a(continuationInterceptor.getKey())) {
                CoroutineContext.Element a2 = abstractCoroutineContextKey.a(continuationInterceptor);
                e = null;
                if (a2 instanceof CoroutineContext.Element) {
                    e = a2;
                }
            }
            return e;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v17, types: [kotlin.coroutines.EmptyCoroutineContext] */
        /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.coroutines.EmptyCoroutineContext] */
        public static CoroutineContext b(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<?> key) {
            Intrinsics.e(key, "key");
            if (!(key instanceof AbstractCoroutineContextKey)) {
                if (ContinuationInterceptor.f42453a == key) {
                    continuationInterceptor = EmptyCoroutineContext.f42457a;
                }
                return continuationInterceptor;
            }
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
            ContinuationInterceptor continuationInterceptor2 = continuationInterceptor;
            if (abstractCoroutineContextKey.a(continuationInterceptor.getKey())) {
                continuationInterceptor2 = continuationInterceptor;
                if (abstractCoroutineContextKey.a(continuationInterceptor) != null) {
                    continuationInterceptor2 = EmptyCoroutineContext.f42457a;
                }
            }
            return continuationInterceptor2;
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/ContinuationInterceptor$Key.class */
    public static final class Key implements CoroutineContext.Key<ContinuationInterceptor> {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Key f42454a = new Key();

        private Key() {
        }
    }

    <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation);

    void releaseInterceptedContinuation(Continuation<?> continuation);
}
