package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/CoroutineContext.class */
public interface CoroutineContext {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/CoroutineContext$DefaultImpls.class */
    public static final class DefaultImpls {
        public static CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext context) {
            Intrinsics.e(context, "context");
            return context == EmptyCoroutineContext.f42457a ? coroutineContext : (CoroutineContext) context.fold(coroutineContext, new Function2<CoroutineContext, Element, CoroutineContext>() { // from class: kotlin.coroutines.CoroutineContext$plus$1
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a */
                public final CoroutineContext invoke(CoroutineContext acc, CoroutineContext.Element element) {
                    CombinedContext combinedContext;
                    Intrinsics.e(acc, "acc");
                    Intrinsics.e(element, "element");
                    CoroutineContext minusKey = acc.minusKey(element.getKey());
                    if (minusKey == EmptyCoroutineContext.f42457a) {
                        return element;
                    }
                    ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) minusKey.get(ContinuationInterceptor.f42453a);
                    if (continuationInterceptor == null) {
                        combinedContext = new CombinedContext(minusKey, element);
                    } else {
                        CoroutineContext minusKey2 = minusKey.minusKey(ContinuationInterceptor.f42453a);
                        combinedContext = minusKey2 == EmptyCoroutineContext.f42457a ? new CombinedContext(element, continuationInterceptor) : new CombinedContext(new CombinedContext(minusKey2, element), continuationInterceptor);
                    }
                    return combinedContext;
                }
            });
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/CoroutineContext$Element.class */
    public interface Element extends CoroutineContext {

        @Metadata
        /* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/CoroutineContext$Element$DefaultImpls.class */
        public static final class DefaultImpls {
            public static <R> R a(Element element, R r, Function2<? super R, ? super Element, ? extends R> operation) {
                Intrinsics.e(operation, "operation");
                return operation.invoke(r, element);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends Element> E a(Element element, Key<E> key) {
                Intrinsics.e(key, "key");
                if (Intrinsics.a(element.getKey(), key)) {
                    return element;
                }
                return null;
            }

            public static CoroutineContext a(Element element, CoroutineContext context) {
                Intrinsics.e(context, "context");
                return DefaultImpls.a(element, context);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v7, types: [kotlin.coroutines.EmptyCoroutineContext] */
            public static CoroutineContext b(Element element, Key<?> key) {
                Intrinsics.e(key, "key");
                Element element2 = element;
                if (Intrinsics.a(element.getKey(), key)) {
                    element2 = EmptyCoroutineContext.f42457a;
                }
                return element2;
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <E extends Element> E get(Key<E> key);

        Key<?> getKey();
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/CoroutineContext$Key.class */
    public interface Key<E extends Element> {
    }

    <R> R fold(R r, Function2<? super R, ? super Element, ? extends R> function2);

    <E extends Element> E get(Key<E> key);

    CoroutineContext minusKey(Key<?> key);

    CoroutineContext plus(CoroutineContext coroutineContext);
}
