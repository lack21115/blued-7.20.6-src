package androidx.core.content;

import android.content.ContentValues;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/ContentValuesKt.class */
public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(Pair<String, ? extends Object>... pairArr) {
        Intrinsics.e(pairArr, "pairs");
        ContentValues contentValues = new ContentValues(pairArr.length);
        int length = pairArr.length;
        int i = 0;
        while (i < length) {
            Pair<String, ? extends Object> pair = pairArr[i];
            i++;
            String str = (String) pair.c();
            Object d = pair.d();
            if (d == null) {
                contentValues.putNull(str);
            } else if (d instanceof String) {
                contentValues.put(str, (String) d);
            } else if (d instanceof Integer) {
                contentValues.put(str, (Integer) d);
            } else if (d instanceof Long) {
                contentValues.put(str, (Long) d);
            } else if (d instanceof Boolean) {
                contentValues.put(str, (Boolean) d);
            } else if (d instanceof Float) {
                contentValues.put(str, (Float) d);
            } else if (d instanceof Double) {
                contentValues.put(str, (Double) d);
            } else if (d instanceof byte[]) {
                contentValues.put(str, (byte[]) d);
            } else if (d instanceof Byte) {
                contentValues.put(str, (Byte) d);
            } else if (!(d instanceof Short)) {
                String canonicalName = d.getClass().getCanonicalName();
                throw new IllegalArgumentException("Illegal value type " + ((Object) canonicalName) + " for key \"" + str + '\"');
            } else {
                contentValues.put(str, (Short) d);
            }
        }
        return contentValues;
    }
}
