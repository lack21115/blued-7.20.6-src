package com.baidu.aip.face;

import androidx.core.util.Pools;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/ArgbPool.class */
public class ArgbPool {
    Pools.SynchronizedPool<int[]> pool = new Pools.SynchronizedPool<>(5);

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001a, code lost:
        if (r0.length != (r5 * r6)) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int[] acquire(int r5, int r6) {
        /*
            r4 = this;
            r0 = r4
            androidx.core.util.Pools$SynchronizedPool<int[]> r0 = r0.pool
            java.lang.Object r0 = r0.acquire()
            int[] r0 = (int[]) r0
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L1d
            r0 = r8
            r7 = r0
            r0 = r8
            int r0 = r0.length
            r1 = r5
            r2 = r6
            int r1 = r1 * r2
            if (r0 == r1) goto L23
        L1d:
            r0 = r5
            r1 = r6
            int r0 = r0 * r1
            int[] r0 = new int[r0]
            r7 = r0
        L23:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.aip.face.ArgbPool.acquire(int, int):int[]");
    }

    public void release(int[] iArr) {
        try {
            this.pool.release(iArr);
        } catch (IllegalStateException e) {
        }
    }
}
