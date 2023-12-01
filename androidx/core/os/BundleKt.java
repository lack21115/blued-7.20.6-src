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
    public static final Bundle bundleOf(Pair<String, ? extends Object>... pairArr) {
        Intrinsics.e(pairArr, "pairs");
        Bundle bundle = new Bundle(pairArr.length);
        int length = pairArr.length;
        int i = 0;
        while (i < length) {
            Pair<String, ? extends Object> pair = pairArr[i];
            i++;
            String str = (String) pair.c();
            Object d = pair.d();
            if (d == null) {
                bundle.putString(str, null);
            } else if (d instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) d).booleanValue());
            } else if (d instanceof Byte) {
                bundle.putByte(str, ((Number) d).byteValue());
            } else if (d instanceof Character) {
                bundle.putChar(str, ((Character) d).charValue());
            } else if (d instanceof Double) {
                bundle.putDouble(str, ((Number) d).doubleValue());
            } else if (d instanceof Float) {
                bundle.putFloat(str, ((Number) d).floatValue());
            } else if (d instanceof Integer) {
                bundle.putInt(str, ((Number) d).intValue());
            } else if (d instanceof Long) {
                bundle.putLong(str, ((Number) d).longValue());
            } else if (d instanceof Short) {
                bundle.putShort(str, ((Number) d).shortValue());
            } else if (d instanceof Bundle) {
                bundle.putBundle(str, (Bundle) d);
            } else if (d instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) d);
            } else if (d instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) d);
            } else if (d instanceof boolean[]) {
                bundle.putBooleanArray(str, (boolean[]) d);
            } else if (d instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) d);
            } else if (d instanceof char[]) {
                bundle.putCharArray(str, (char[]) d);
            } else if (d instanceof double[]) {
                bundle.putDoubleArray(str, (double[]) d);
            } else if (d instanceof float[]) {
                bundle.putFloatArray(str, (float[]) d);
            } else if (d instanceof int[]) {
                bundle.putIntArray(str, (int[]) d);
            } else if (d instanceof long[]) {
                bundle.putLongArray(str, (long[]) d);
            } else if (d instanceof short[]) {
                bundle.putShortArray(str, (short[]) d);
            } else if (d instanceof Object[]) {
                Class<?> componentType = d.getClass().getComponentType();
                Intrinsics.a(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    if (d == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                    }
                    bundle.putParcelableArray(str, (Parcelable[]) d);
                } else if (String.class.isAssignableFrom(componentType)) {
                    if (d == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    }
                    bundle.putStringArray(str, (String[]) d);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    if (d == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                    }
                    bundle.putCharSequenceArray(str, (CharSequence[]) d);
                } else if (!Serializable.class.isAssignableFrom(componentType)) {
                    String canonicalName = componentType.getCanonicalName();
                    throw new IllegalArgumentException("Illegal value array type " + ((Object) canonicalName) + " for key \"" + str + '\"');
                } else {
                    bundle.putSerializable(str, (Serializable) d);
                }
            } else if (d instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) d);
            } else if (Build.VERSION.SDK_INT >= 18 && (d instanceof IBinder)) {
                bundle.putBinder(str, (IBinder) d);
            } else if (Build.VERSION.SDK_INT >= 21 && (d instanceof Size)) {
                bundle.putSize(str, (Size) d);
            } else if (Build.VERSION.SDK_INT < 21 || !(d instanceof SizeF)) {
                String canonicalName2 = d.getClass().getCanonicalName();
                throw new IllegalArgumentException("Illegal value type " + ((Object) canonicalName2) + " for key \"" + str + '\"');
            } else {
                bundle.putSizeF(str, (SizeF) d);
            }
        }
        return bundle;
    }
}
