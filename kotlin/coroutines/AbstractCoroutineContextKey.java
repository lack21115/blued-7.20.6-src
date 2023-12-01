package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/AbstractCoroutineContextKey.class */
public abstract class AbstractCoroutineContextKey<B extends CoroutineContext.Element, E extends B> implements CoroutineContext.Key<E> {

    /* renamed from: a  reason: collision with root package name */
    private final Function1<CoroutineContext.Element, E> f42448a;
    private final CoroutineContext.Key<?> b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [kotlin.jvm.functions.Function1<? super kotlin.coroutines.CoroutineContext$Element, ? extends E extends B>, java.lang.Object, kotlin.jvm.functions.Function1<kotlin.coroutines.CoroutineContext$Element, E extends B>] */
    public AbstractCoroutineContextKey(CoroutineContext.Key<B> baseKey, Function1<? super CoroutineContext.Element, ? extends E> safeCast) {
        Intrinsics.e(baseKey, "baseKey");
        Intrinsics.e(safeCast, "safeCast");
        this.f42448a = safeCast;
        this.b = baseKey instanceof AbstractCoroutineContextKey ? ((AbstractCoroutineContextKey) baseKey).b : baseKey;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$Element;)TE; */
    public final CoroutineContext.Element a(CoroutineContext.Element element) {
        Intrinsics.e(element, "element");
        return (CoroutineContext.Element) this.f42448a.invoke(element);
    }

    public final boolean a(CoroutineContext.Key<?> key) {
        Intrinsics.e(key, "key");
        return key == this || this.b == key;
    }
}
