package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/comparisons/ComparisonsKt__ComparisonsKt.class */
public class ComparisonsKt__ComparisonsKt {
    public static final <T extends Comparable<?>> int a(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int b(T t, T t2, Function1<? super T, ? extends Comparable<?>>[] function1Arr) {
        int length = function1Arr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return 0;
            }
            Function1<? super T, ? extends Comparable<?>> function1 = function1Arr[i2];
            int a = ComparisonsKt.a(function1.invoke(t), function1.invoke(t2));
            if (a != 0) {
                return a;
            }
            i = i2 + 1;
        }
    }
}
