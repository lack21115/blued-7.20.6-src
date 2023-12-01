package net.simonvt.datepicker;

import java.lang.reflect.Array;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:net/simonvt/datepicker/CVArrays.class */
public class CVArrays {
    CVArrays() {
    }

    public static <T> T[] a(T[] tArr, int i, int i2) {
        int length = tArr.length;
        if (i <= i2) {
            if (i < 0 || i > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3));
            System.arraycopy(tArr, i, tArr2, 0, min);
            return tArr2;
        }
        throw new IllegalArgumentException();
    }
}
