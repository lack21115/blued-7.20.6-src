package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/jvm/internal/ModuleNameRetriever.class */
public final class ModuleNameRetriever {
    public static final ModuleNameRetriever a = new ModuleNameRetriever();
    private static final Cache b = new Cache(null, null, null);
    private static Cache c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache.class */
    public static final class Cache {
        public final Method a;
        public final Method b;
        public final Method c;

        public Cache(Method method, Method method2, Method method3) {
            this.a = method;
            this.b = method2;
            this.c = method3;
        }
    }

    private ModuleNameRetriever() {
    }

    private final Cache b(BaseContinuationImpl baseContinuationImpl) {
        try {
            Cache cache = new Cache(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            c = cache;
            return cache;
        } catch (Exception e) {
            Cache cache2 = b;
            c = cache2;
            return cache2;
        }
    }

    public final String a(BaseContinuationImpl continuation) {
        Intrinsics.e(continuation, "continuation");
        Cache cache = c;
        Cache cache2 = cache;
        if (cache == null) {
            cache2 = b(continuation);
        }
        if (cache2 == b) {
            return null;
        }
        Method method = cache2.a;
        Object invoke = method != null ? method.invoke(continuation.getClass(), new Object[0]) : null;
        if (invoke == null) {
            return null;
        }
        Method method2 = cache2.b;
        Object invoke2 = method2 != null ? method2.invoke(invoke, new Object[0]) : null;
        if (invoke2 == null) {
            return null;
        }
        Method method3 = cache2.c;
        String invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        String str = null;
        if (invoke3 instanceof String) {
            str = invoke3;
        }
        return str;
    }
}
