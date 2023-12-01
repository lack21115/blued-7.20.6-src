package androidx.core.os;

import android.os.Build;
import android.os.PersistableBundle;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/os/PersistableBundleKt.class */
public final class PersistableBundleKt {
    public static final PersistableBundle persistableBundleOf(Pair<String, ? extends Object>... pairs) {
        Intrinsics.e(pairs, "pairs");
        PersistableBundle persistableBundle = new PersistableBundle(pairs.length);
        int length = pairs.length;
        int i = 0;
        while (i < length) {
            Pair<String, ? extends Object> pair = pairs[i];
            i++;
            String c2 = pair.c();
            Object d = pair.d();
            if (d == null) {
                persistableBundle.putString(c2, null);
            } else if (d instanceof Boolean) {
                if (Build.VERSION.SDK_INT < 22) {
                    throw new IllegalArgumentException("Illegal value type boolean for key \"" + c2 + '\"');
                }
                persistableBundle.putBoolean(c2, ((Boolean) d).booleanValue());
            } else if (d instanceof Double) {
                persistableBundle.putDouble(c2, ((Number) d).doubleValue());
            } else if (d instanceof Integer) {
                persistableBundle.putInt(c2, ((Number) d).intValue());
            } else if (d instanceof Long) {
                persistableBundle.putLong(c2, ((Number) d).longValue());
            } else if (d instanceof String) {
                persistableBundle.putString(c2, (String) d);
            } else if (d instanceof boolean[]) {
                if (Build.VERSION.SDK_INT < 22) {
                    throw new IllegalArgumentException("Illegal value type boolean[] for key \"" + c2 + '\"');
                }
                persistableBundle.putBooleanArray(c2, (boolean[]) d);
            } else if (d instanceof double[]) {
                persistableBundle.putDoubleArray(c2, (double[]) d);
            } else if (d instanceof int[]) {
                persistableBundle.putIntArray(c2, (int[]) d);
            } else if (d instanceof long[]) {
                persistableBundle.putLongArray(c2, (long[]) d);
            } else if (!(d instanceof Object[])) {
                String canonicalName = d.getClass().getCanonicalName();
                throw new IllegalArgumentException("Illegal value type " + ((Object) canonicalName) + " for key \"" + c2 + '\"');
            } else {
                Class<?> componentType = d.getClass().getComponentType();
                Intrinsics.a(componentType);
                if (!String.class.isAssignableFrom(componentType)) {
                    String canonicalName2 = componentType.getCanonicalName();
                    throw new IllegalArgumentException("Illegal value array type " + ((Object) canonicalName2) + " for key \"" + c2 + '\"');
                } else if (d == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                } else {
                    persistableBundle.putStringArray(c2, (String[]) d);
                }
            }
        }
        return persistableBundle;
    }
}
