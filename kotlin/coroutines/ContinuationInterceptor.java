package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/ContinuationInterceptor.class */
public interface ContinuationInterceptor extends CoroutineContext.Element {
    public static final Key a = Key.a;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/ContinuationInterceptor$DefaultImpls.class */
    public static final class DefaultImpls {
        public static <E extends CoroutineContext.Element> E a(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<E> key) {
            Intrinsics.e(key, "key");
            if (!(key instanceof AbstractCoroutineContextKey)) {
                ContinuationInterceptor continuationInterceptor2 = null;
                if (ContinuationInterceptor.a == key) {
                    continuationInterceptor2 = continuationInterceptor;
                }
                return continuationInterceptor2;
            }
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
            E e = null;
            if (abstractCoroutineContextKey.a(continuationInterceptor.getKey())) {
                CoroutineContext.Element a = abstractCoroutineContextKey.a(continuationInterceptor);
                e = null;
                if (a instanceof CoroutineContext.Element) {
                    e = a;
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
                if (ContinuationInterceptor.a == key) {
                    continuationInterceptor = EmptyCoroutineContext.a;
                }
                return continuationInterceptor;
            }
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
            ContinuationInterceptor continuationInterceptor2 = continuationInterceptor;
            if (abstractCoroutineContextKey.a(continuationInterceptor.getKey())) {
                continuationInterceptor2 = continuationInterceptor;
                if (abstractCoroutineContextKey.a(continuationInterceptor) != null) {
                    continuationInterceptor2 = EmptyCoroutineContext.a;
                }
            }
            return continuationInterceptor2;
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/ContinuationInterceptor$Key.class */
    public static final class Key implements CoroutineContext.Key<ContinuationInterceptor> {
        static final /* synthetic */ Key a = new Key();

        private Key() {
        }
    }

    <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation);

    void releaseInterceptedContinuation(Continuation<?> continuation);
}
