package androidx.core.os;

import android.os.Build;
import android.os.PersistableBundle;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/os/PersistableBundleKt.class */
public final class PersistableBundleKt {
    public static final PersistableBundle persistableBundleOf(Pair<String, ? extends Object>... pairArr) {
        Intrinsics.e(pairArr, "pairs");
        PersistableBundle persistableBundle = new PersistableBundle(pairArr.length);
        int length = pairArr.length;
        int i = 0;
        while (i < length) {
            Pair<String, ? extends Object> pair = pairArr[i];
            i++;
            String str = (String) pair.c();
            Object d = pair.d();
            if (d == null) {
                persistableBundle.putString(str, null);
            } else if (d instanceof Boolean) {
                if (Build.VERSION.SDK_INT < 22) {
                    throw new IllegalArgumentException("Illegal value type boolean for key \"" + str + '\"');
                }
                persistableBundle.putBoolean(str, ((Boolean) d).booleanValue());
            } else if (d instanceof Double) {
                persistableBundle.putDouble(str, ((Number) d).doubleValue());
            } else if (d instanceof Integer) {
                persistableBundle.putInt(str, ((Number) d).intValue());
            } else if (d instanceof Long) {
                persistableBundle.putLong(str, ((Number) d).longValue());
            } else if (d instanceof String) {
                persistableBundle.putString(str, (String) d);
            } else if (d instanceof boolean[]) {
                if (Build.VERSION.SDK_INT < 22) {
                    throw new IllegalArgumentException("Illegal value type boolean[] for key \"" + str + '\"');
                }
                persistableBundle.putBooleanArray(str, (boolean[]) d);
            } else if (d instanceof double[]) {
                persistableBundle.putDoubleArray(str, (double[]) d);
            } else if (d instanceof int[]) {
                persistableBundle.putIntArray(str, (int[]) d);
            } else if (d instanceof long[]) {
                persistableBundle.putLongArray(str, (long[]) d);
            } else if (!(d instanceof Object[])) {
                String canonicalName = d.getClass().getCanonicalName();
                throw new IllegalArgumentException("Illegal value type " + ((Object) canonicalName) + " for key \"" + str + '\"');
            } else {
                Class<?> componentType = d.getClass().getComponentType();
                Intrinsics.a(componentType);
                if (!String.class.isAssignableFrom(componentType)) {
                    String canonicalName2 = componentType.getCanonicalName();
                    throw new IllegalArgumentException("Illegal value array type " + ((Object) canonicalName2) + " for key \"" + str + '\"');
                } else if (d == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                } else {
                    persistableBundle.putStringArray(str, (String[]) d);
                }
            }
        }
        return persistableBundle;
    }
}
