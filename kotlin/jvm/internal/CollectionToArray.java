package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/CollectionToArray.class */
public final class CollectionToArray {
    private static final Object[] a = new Object[0];

    public static final Object[] a(Collection<?> collection) {
        Object[] objArr;
        Intrinsics.e(collection, "collection");
        int size = collection.size();
        if (size != 0) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArr2 = new Object[size];
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    objArr2[i] = it.next();
                    if (i2 < objArr2.length) {
                        objArr = objArr2;
                        if (!it.hasNext()) {
                            Object[] copyOf = Arrays.copyOf(objArr2, i2);
                            Intrinsics.c(copyOf, "copyOf(result, size)");
                            return copyOf;
                        }
                    } else if (!it.hasNext()) {
                        return objArr2;
                    } else {
                        int i3 = ((i2 * 3) + 1) >>> 1;
                        int i4 = i3;
                        if (i3 <= i2) {
                            if (i2 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                            i4 = 2147483645;
                        }
                        objArr = Arrays.copyOf(objArr2, i4);
                        Intrinsics.c(objArr, "copyOf(result, newSize)");
                    }
                    i = i2;
                    objArr2 = objArr;
                }
            }
        }
        return a;
    }

    public static final Object[] a(Collection<?> collection, Object[] objArr) {
        Object[] objArr2;
        Object[] objArr3;
        Object[] copyOf;
        Intrinsics.e(collection, "collection");
        if (objArr != null) {
            int size = collection.size();
            int i = 0;
            if (size == 0) {
                copyOf = objArr;
                if (objArr.length > 0) {
                    objArr[0] = null;
                    return objArr;
                }
            } else {
                Iterator<?> it = collection.iterator();
                if (it.hasNext()) {
                    if (size <= objArr.length) {
                        objArr2 = objArr;
                    } else {
                        Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                        if (newInstance == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                        }
                        objArr2 = (Object[]) newInstance;
                    }
                    while (true) {
                        Object[] objArr4 = objArr2;
                        int i2 = i + 1;
                        objArr4[i] = it.next();
                        if (i2 < objArr4.length) {
                            objArr3 = objArr4;
                            if (!it.hasNext()) {
                                if (objArr4 == objArr) {
                                    objArr[i2] = null;
                                    return objArr;
                                }
                                copyOf = Arrays.copyOf(objArr4, i2);
                                Intrinsics.c(copyOf, "copyOf(result, size)");
                            }
                        } else if (!it.hasNext()) {
                            return objArr4;
                        } else {
                            int i3 = ((i2 * 3) + 1) >>> 1;
                            int i4 = i3;
                            if (i3 <= i2) {
                                if (i2 >= 2147483645) {
                                    throw new OutOfMemoryError();
                                }
                                i4 = 2147483645;
                            }
                            objArr3 = Arrays.copyOf(objArr4, i4);
                            Intrinsics.c(objArr3, "copyOf(result, newSize)");
                        }
                        i = i2;
                        objArr2 = objArr3;
                    }
                } else {
                    copyOf = objArr;
                    if (objArr.length > 0) {
                        objArr[0] = null;
                        return objArr;
                    }
                }
            }
            return copyOf;
        }
        throw null;
    }
}
