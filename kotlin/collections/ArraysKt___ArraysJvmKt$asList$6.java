package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/ArraysKt___ArraysJvmKt$asList$6.class */
public final class ArraysKt___ArraysJvmKt$asList$6 extends AbstractList<Double> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ double[] f42341a;

    @Override // kotlin.collections.AbstractList, java.util.List
    /* renamed from: a */
    public Double get(int i) {
        return Double.valueOf(this.f42341a[i]);
    }

    public boolean a(double d) {
        double[] dArr = this.f42341a;
        int length = dArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (Double.doubleToLongBits(dArr[i2]) == Double.doubleToLongBits(d)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public int b(double d) {
        double[] dArr = this.f42341a;
        int length = dArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return -1;
            }
            if (Double.doubleToLongBits(dArr[i2]) == Double.doubleToLongBits(d)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public int c(double d) {
        double[] dArr = this.f42341a;
        int length = dArr.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i = length - 1;
            if (Double.doubleToLongBits(dArr[length]) == Double.doubleToLongBits(d)) {
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
        if (obj instanceof Double) {
            return a(((Number) obj).doubleValue());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f42341a.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Double) {
            return b(((Number) obj).doubleValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f42341a.length == 0;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Double) {
            return c(((Number) obj).doubleValue());
        }
        return -1;
    }
}
