package com.tencent.cloud.huiyansdkface.facelight.c.a;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/a/h.class */
public class h implements com.tencent.cloud.huiyansdkface.a.a.g<com.tencent.cloud.huiyansdkface.a.a.a.d> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21850a = h.class.getSimpleName();
    private CamcorderProfile b;

    /* renamed from: c  reason: collision with root package name */
    private int f21851c;
    private int d;

    private Camera.Size a(List<Camera.Size> list, int i, int i2) {
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        int max = Math.max(i, i2);
        int min = Math.min(i, i2);
        double d = max / min;
        double d2 = Double.MAX_VALUE;
        for (Camera.Size size2 : list) {
            if (Math.abs((size2.width / size2.height) - d) <= 0.001d && Math.abs(size2.height - min) < d2) {
                d2 = Math.abs(size2.height - min);
                size = size2;
            }
        }
        Camera.Size size3 = size;
        if (size == null) {
            WLogger.i(f21850a, "No preview size match the aspect ratio");
            Iterator<Camera.Size> it = list.iterator();
            double d3 = Double.MAX_VALUE;
            while (true) {
                size3 = size;
                if (!it.hasNext()) {
                    break;
                }
                Camera.Size next = it.next();
                if (Math.abs(next.height - min) < d3) {
                    d3 = Math.abs(next.height - min);
                    size = next;
                }
            }
        }
        return size3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0148, code lost:
        if (r6 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01ec, code lost:
        if (r6 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01ef, code lost:
        r5.f21851c = r6.width;
        r5.d = r6.height;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0202, code lost:
        com.tencent.cloud.huiyansdkface.normal.tools.WLogger.i(com.tencent.cloud.huiyansdkface.facelight.c.a.h.f21850a, "do not find proper preview size, use default");
        r5.f21851c = 640;
        r5.d = 480;
     */
    @Override // com.tencent.cloud.huiyansdkface.a.a.g
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tencent.cloud.huiyansdkface.a.a.a.d b(java.util.List<com.tencent.cloud.huiyansdkface.a.a.a.d> r6, com.tencent.cloud.huiyansdkface.a.c.d r7) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.c.a.h.b(java.util.List, com.tencent.cloud.huiyansdkface.a.c.d):com.tencent.cloud.huiyansdkface.a.a.a.d");
    }
}
