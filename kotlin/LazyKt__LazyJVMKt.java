package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/LazyKt__LazyJVMKt.class */
public class LazyKt__LazyJVMKt {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/LazyKt__LazyJVMKt$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LazyThreadSafetyMode.values().length];
            iArr[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
            iArr[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
            iArr[LazyThreadSafetyMode.NONE.ordinal()] = 3;
            a = iArr;
        }
    }

    public static final <T> Lazy<T> a(LazyThreadSafetyMode mode, Function0<? extends T> initializer) {
        Intrinsics.e(mode, "mode");
        Intrinsics.e(initializer, "initializer");
        int i = WhenMappings.a[mode.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return new UnsafeLazyImpl(initializer);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new SafePublicationLazyImpl(initializer);
        }
        return new SynchronizedLazyImpl(initializer, null, 2, null);
    }

    public static final <T> Lazy<T> a(Function0<? extends T> initializer) {
        Intrinsics.e(initializer, "initializer");
        return new SynchronizedLazyImpl(initializer, null, 2, null);
    }
}
