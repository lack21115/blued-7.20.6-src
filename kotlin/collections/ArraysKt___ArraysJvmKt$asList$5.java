package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysJvmKt$asList$5.class */
public final class ArraysKt___ArraysJvmKt$asList$5 extends AbstractList<Float> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ float[] f42340a;

    @Override // kotlin.collections.AbstractList, java.util.List
    /* renamed from: a */
    public Float get(int i) {
        return Float.valueOf(this.f42340a[i]);
    }

    public boolean a(float f) {
        float[] fArr = this.f42340a;
        int length = fArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (Float.floatToIntBits(fArr[i2]) == Float.floatToIntBits(f)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public int b(float f) {
        float[] fArr = this.f42340a;
        int length = fArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return -1;
            }
            if (Float.floatToIntBits(fArr[i2]) == Float.floatToIntBits(f)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public int c(float f) {
        float[] fArr = this.f42340a;
        int length = fArr.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i = length - 1;
            if (Float.floatToIntBits(fArr[length]) == Float.floatToIntBits(f)) {
                return length;
            }
            if (i < 0) {
                return -1;
            }
            length = i;
        }
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Float) {
            return a(((Number) obj).floatValue());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f42340a.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Float) {
            return b(((Number) obj).floatValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f42340a.length == 0;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Float) {
            return c(((Number) obj).floatValue());
        }
        return -1;
    }
}
