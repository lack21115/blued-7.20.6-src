package kotlin.jvm.internal;

import com.igexin.push.core.b;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableIterable;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableMap;

/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/TypeIntrinsics.class */
public class TypeIntrinsics {
    public static ClassCastException a(ClassCastException classCastException) {
        throw ((ClassCastException) a(classCastException));
    }

    public static Iterable a(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableIterable)) {
            a(obj, "kotlin.collections.MutableIterable");
        }
        return b(obj);
    }

    private static <T extends Throwable> T a(T t) {
        return (T) Intrinsics.a((Throwable) t, TypeIntrinsics.class.getName());
    }

    public static void a(Object obj, String str) {
        String name = obj == null ? b.l : obj.getClass().getName();
        a(name + " cannot be cast to " + str);
    }

    public static void a(String str) {
        throw a(new ClassCastException(str));
    }

    public static boolean a(Object obj, int i) {
        return (obj instanceof Function) && k(obj) == i;
    }

    public static Iterable b(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e) {
            throw a(e);
        }
    }

    public static Object b(Object obj, int i) {
        if (obj != null && !a(obj, i)) {
            a(obj, "kotlin.jvm.functions.Function" + i);
        }
        return obj;
    }

    public static Collection c(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableCollection)) {
            a(obj, "kotlin.collections.MutableCollection");
        }
        return d(obj);
    }

    public static Collection d(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e) {
            throw a(e);
        }
    }

    public static boolean e(Object obj) {
        if (obj instanceof List) {
            return !(obj instanceof KMappedMarker) || (obj instanceof KMutableList);
        }
        return false;
    }

    public static List f(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableList)) {
            a(obj, "kotlin.collections.MutableList");
        }
        return g(obj);
    }

    public static List g(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e) {
            throw a(e);
        }
    }

    public static boolean h(Object obj) {
        if (obj instanceof Map) {
            return !(obj instanceof KMappedMarker) || (obj instanceof KMutableMap);
        }
        return false;
    }

    public static Map i(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableMap)) {
            a(obj, "kotlin.collections.MutableMap");
        }
        return j(obj);
    }

    public static Map j(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            throw a(e);
        }
    }

    public static int k(Object obj) {
        if (obj instanceof FunctionBase) {
            return ((FunctionBase) obj).getArity();
        }
        if (obj instanceof Function0) {
            return 0;
        }
        if (obj instanceof Function1) {
            return 1;
        }
        if (obj instanceof Function2) {
            return 2;
        }
        if (obj instanceof Function3) {
            return 3;
        }
        if (obj instanceof Function4) {
            return 4;
        }
        if (obj instanceof Function5) {
            return 5;
        }
        if (obj instanceof Function6) {
            return 6;
        }
        if (obj instanceof Function7) {
            return 7;
        }
        if (obj instanceof Function8) {
            return 8;
        }
        if (obj instanceof Function9) {
            return 9;
        }
        if (obj instanceof Function10) {
            return 10;
        }
        if (obj instanceof Function11) {
            return 11;
        }
        if (obj instanceof Function12) {
            return 12;
        }
        if (obj instanceof Function13) {
            return 13;
        }
        if (obj instanceof Function14) {
            return 14;
        }
        if (obj instanceof Function15) {
            return 15;
        }
        if (obj instanceof Function16) {
            return 16;
        }
        if (obj instanceof Function17) {
            return 17;
        }
        if (obj instanceof Function18) {
            return 18;
        }
        if (obj instanceof Function19) {
            return 19;
        }
        if (obj instanceof Function20) {
            return 20;
        }
        if (obj instanceof Function21) {
            return 21;
        }
        return obj instanceof Function22 ? 22 : -1;
    }
}
