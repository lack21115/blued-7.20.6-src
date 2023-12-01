package androidx.core.content;

import android.content.ContentValues;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/ContentValuesKt.class */
public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(Pair<String, ? extends Object>... pairs) {
        Intrinsics.e(pairs, "pairs");
        ContentValues contentValues = new ContentValues(pairs.length);
        int length = pairs.length;
        int i = 0;
        while (i < length) {
            Pair<String, ? extends Object> pair = pairs[i];
            i++;
            String c2 = pair.c();
            Object d = pair.d();
            if (d == null) {
                contentValues.putNull(c2);
            } else if (d instanceof String) {
                contentValues.put(c2, (String) d);
            } else if (d instanceof Integer) {
                contentValues.put(c2, (Integer) d);
            } else if (d instanceof Long) {
                contentValues.put(c2, (Long) d);
            } else if (d instanceof Boolean) {
                contentValues.put(c2, (Boolean) d);
            } else if (d instanceof Float) {
                contentValues.put(c2, (Float) d);
            } else if (d instanceof Double) {
                contentValues.put(c2, (Double) d);
            } else if (d instanceof byte[]) {
                contentValues.put(c2, (byte[]) d);
            } else if (d instanceof Byte) {
                contentValues.put(c2, (Byte) d);
            } else if (!(d instanceof Short)) {
                String canonicalName = d.getClass().getCanonicalName();
                throw new IllegalArgumentException("Illegal value type " + ((Object) canonicalName) + " for key \"" + c2 + '\"');
            } else {
                contentValues.put(c2, (Short) d);
            }
        }
        return contentValues;
    }
}
