package androidx.core.os;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/os/BundleKt.class */
public final class BundleKt {
    public static final Bundle bundleOf(Pair<String, ? extends Object>... pairs) {
        Intrinsics.e(pairs, "pairs");
        Bundle bundle = new Bundle(pairs.length);
        int length = pairs.length;
        int i = 0;
        while (i < length) {
            Pair<String, ? extends Object> pair = pairs[i];
            i++;
            String c2 = pair.c();
            Object d = pair.d();
            if (d == null) {
                bundle.putString(c2, null);
            } else if (d instanceof Boolean) {
                bundle.putBoolean(c2, ((Boolean) d).booleanValue());
            } else if (d instanceof Byte) {
                bundle.putByte(c2, ((Number) d).byteValue());
            } else if (d instanceof Character) {
                bundle.putChar(c2, ((Character) d).charValue());
            } else if (d instanceof Double) {
                bundle.putDouble(c2, ((Number) d).doubleValue());
            } else if (d instanceof Float) {
                bundle.putFloat(c2, ((Number) d).floatValue());
            } else if (d instanceof Integer) {
                bundle.putInt(c2, ((Number) d).intValue());
            } else if (d instanceof Long) {
                bundle.putLong(c2, ((Number) d).longValue());
            } else if (d instanceof Short) {
                bundle.putShort(c2, ((Number) d).shortValue());
            } else if (d instanceof Bundle) {
                bundle.putBundle(c2, (Bundle) d);
            } else if (d instanceof CharSequence) {
                bundle.putCharSequence(c2, (CharSequence) d);
            } else if (d instanceof Parcelable) {
                bundle.putParcelable(c2, (Parcelable) d);
            } else if (d instanceof boolean[]) {
                bundle.putBooleanArray(c2, (boolean[]) d);
            } else if (d instanceof byte[]) {
                bundle.putByteArray(c2, (byte[]) d);
            } else if (d instanceof char[]) {
                bundle.putCharArray(c2, (char[]) d);
            } else if (d instanceof double[]) {
                bundle.putDoubleArray(c2, (double[]) d);
            } else if (d instanceof float[]) {
                bundle.putFloatArray(c2, (float[]) d);
            } else if (d instanceof int[]) {
                bundle.putIntArray(c2, (int[]) d);
            } else if (d instanceof long[]) {
                bundle.putLongArray(c2, (long[]) d);
            } else if (d instanceof short[]) {
                bundle.putShortArray(c2, (short[]) d);
            } else if (d instanceof Object[]) {
                Class<?> componentType = d.getClass().getComponentType();
                Intrinsics.a(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    if (d == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                    }
                    bundle.putParcelableArray(c2, (Parcelable[]) d);
                } else if (String.class.isAssignableFrom(componentType)) {
                    if (d == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    }
                    bundle.putStringArray(c2, (String[]) d);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    if (d == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                    }
                    bundle.putCharSequenceArray(c2, (CharSequence[]) d);
                } else if (!Serializable.class.isAssignableFrom(componentType)) {
                    String canonicalName = componentType.getCanonicalName();
                    throw new IllegalArgumentException("Illegal value array type " + ((Object) canonicalName) + " for key \"" + c2 + '\"');
                } else {
                    bundle.putSerializable(c2, (Serializable) d);
                }
            } else if (d instanceof Serializable) {
                bundle.putSerializable(c2, (Serializable) d);
            } else if (Build.VERSION.SDK_INT >= 18 && (d instanceof IBinder)) {
                bundle.putBinder(c2, (IBinder) d);
            } else if (Build.VERSION.SDK_INT >= 21 && (d instanceof Size)) {
                bundle.putSize(c2, (Size) d);
            } else if (Build.VERSION.SDK_INT < 21 || !(d instanceof SizeF)) {
                String canonicalName2 = d.getClass().getCanonicalName();
                throw new IllegalArgumentException("Illegal value type " + ((Object) canonicalName2) + " for key \"" + c2 + '\"');
            } else {
                bundle.putSizeF(c2, (SizeF) d);
            }
        }
        return bundle;
    }
}
