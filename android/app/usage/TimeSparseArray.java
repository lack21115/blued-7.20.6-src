package android.app.usage;

import android.util.LongSparseArray;

/* loaded from: source-9557208-dex2jar.jar:android/app/usage/TimeSparseArray.class */
public class TimeSparseArray<E> extends LongSparseArray<E> {
    public TimeSparseArray() {
    }

    public TimeSparseArray(int i) {
        super(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0053, code lost:
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int closestIndexOnOrAfter(long r6) {
        /*
            r5 = this;
            r0 = r5
            int r0 = r0.size()
            r11 = r0
            r0 = 0
            r8 = r0
            r0 = r11
            r1 = 1
            int r0 = r0 - r1
            r9 = r0
            r0 = -1
            r10 = r0
            r0 = -1
            r12 = r0
        L16:
            r0 = r8
            r1 = r9
            if (r0 > r1) goto L54
            r0 = r8
            r1 = r9
            r2 = r8
            int r1 = r1 - r2
            r2 = 2
            int r1 = r1 / r2
            int r0 = r0 + r1
            r10 = r0
            r0 = r5
            r1 = r10
            long r0 = r0.keyAt(r1)
            r12 = r0
            r0 = r6
            r1 = r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L3d
            r0 = r10
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            goto L16
        L3d:
            r0 = r6
            r1 = r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L4d
            r0 = r10
            r1 = 1
            int r0 = r0 - r1
            r9 = r0
            goto L16
        L4d:
            r0 = r10
            r9 = r0
        L51:
            r0 = r9
            return r0
        L54:
            r0 = r6
            r1 = r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L5e
            r0 = r10
            return r0
        L5e:
            r0 = r6
            r1 = r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L6e
            r0 = r8
            r9 = r0
            r0 = r8
            r1 = r11
            if (r0 < r1) goto L51
        L6e:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.usage.TimeSparseArray.closestIndexOnOrAfter(long):int");
    }

    public int closestIndexOnOrBefore(long j) {
        int i;
        int closestIndexOnOrAfter = closestIndexOnOrAfter(j);
        if (closestIndexOnOrAfter < 0) {
            i = size() - 1;
        } else {
            i = closestIndexOnOrAfter;
            if (keyAt(closestIndexOnOrAfter) != j) {
                return closestIndexOnOrAfter - 1;
            }
        }
        return i;
    }
}
