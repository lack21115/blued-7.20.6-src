package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KClasses.class */
public final class KClasses {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T a(KClass<T> kClass, Object obj) {
        Intrinsics.e(kClass, "<this>");
        if (kClass.a(obj)) {
            if (obj != 0) {
                return obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
        }
        throw new ClassCastException("Value cannot be cast to " + kClass.c());
    }
}
