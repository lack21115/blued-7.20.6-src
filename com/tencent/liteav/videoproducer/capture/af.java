package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.utils.Rotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/af.class */
public final class af {
    private static Boolean e;

    /* renamed from: a  reason: collision with root package name */
    a f23168a = a.CAMERA_1;
    int b = Integer.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    boolean f23169c = false;
    boolean d = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/af$a.class */
    public enum a {
        MOCK,
        CAMERA_1,
        CAMERA_2
    }

    public static com.tencent.liteav.base.util.n a(List<com.tencent.liteav.base.util.n> list, Rotation rotation, int i, int i2) {
        com.tencent.liteav.base.util.n nVar = new com.tencent.liteav.base.util.n(i, i2);
        LiteavLog.i("CameraSupervisor", "preview wanted: " + nVar + " cameraRotation:" + rotation);
        if (list == null) {
            LiteavLog.e("CameraSupervisor", "findBestMatchedPreviewSize getPreviewSizes null");
            return nVar;
        }
        if (rotation == Rotation.ROTATION_90 || rotation == Rotation.ROTATION_270) {
            nVar.a();
        }
        double c2 = nVar.c();
        com.tencent.liteav.base.util.n nVar2 = new com.tencent.liteav.base.util.n(640, 640);
        if (nVar.f22649a <= nVar2.f22649a && nVar.b <= nVar2.b) {
            nVar2.a(nVar);
        } else if (nVar.f22649a > nVar.b) {
            nVar2.b = (nVar2.f22649a * nVar.b) / nVar.f22649a;
        } else {
            nVar2.f22649a = (nVar2.b * nVar.f22649a) / nVar.b;
        }
        ArrayList<com.tencent.liteav.base.util.n> arrayList = new ArrayList();
        long j = Long.MAX_VALUE;
        for (com.tencent.liteav.base.util.n nVar3 : list) {
            LiteavLog.d("CameraSupervisor", "support preview size ".concat(String.valueOf(nVar3)));
            long round = (nVar3.f22649a < nVar2.f22649a || nVar3.b < nVar2.b) ? Long.MAX_VALUE : Math.round(Math.abs(nVar3.c() - c2) * 10.0d);
            int i3 = (round > j ? 1 : (round == j ? 0 : -1));
            if (i3 < 0) {
                arrayList.clear();
                arrayList.add(nVar3);
                j = round;
            } else if (i3 == 0) {
                arrayList.add(nVar3);
            }
        }
        Collections.sort(arrayList, ag.a());
        com.tencent.liteav.base.util.n nVar4 = (com.tencent.liteav.base.util.n) arrayList.get(0);
        int b = nVar.b();
        double d = Double.MAX_VALUE;
        for (com.tencent.liteav.base.util.n nVar5 : arrayList) {
            LiteavLog.i("CameraSupervisor", "size in same buck ".concat(String.valueOf(nVar5)));
            double d2 = c2 > nVar5.c() ? (nVar5.f22649a * nVar5.f22649a) / c2 : nVar5.b * nVar5.b * c2;
            double d3 = b;
            if (d2 / d3 >= 0.9d) {
                double d4 = d2 - d3;
                if (Math.abs(d4) < d) {
                    d = Math.abs(d4);
                    nVar4 = nVar5;
                }
            }
        }
        LiteavLog.i("CameraSupervisor", "best match preview size ".concat(String.valueOf(nVar4)));
        return new com.tencent.liteav.base.util.n(nVar4.f22649a, nVar4.b);
    }

    private boolean b() {
        boolean z = false;
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            LiteavLog.w("CameraSupervisor", "isSupportCamera2 false, current:" + LiteavSystemInfo.getSystemOSVersionInt() + " is low to:21");
            return false;
        } else if (this.b < 21) {
            LiteavLog.w("CameraSupervisor", "isSupportCamera2 false, apiLevel:" + this.b + " is too low.");
            return false;
        } else if (LiteavSystemInfo.getSystemOSVersionInt() < this.b) {
            LiteavLog.w("CameraSupervisor", "isSupportCamera2 false, current:" + LiteavSystemInfo.getSystemOSVersionInt() + " is low to config api level:" + this.b);
            return false;
        } else {
            Boolean bool = e;
            if (bool != null) {
                return bool.booleanValue();
            }
            int a2 = com.tencent.liteav.videoproducer.capture.a.a();
            if (a2 == 1 || a2 == 3) {
                z = true;
            }
            e = Boolean.valueOf(z);
            LiteavLog.i("CameraSupervisor", "isSupportCamera2 apiLevel:" + this.b + " supportLevel:" + a2 + " result:" + e);
            return e.booleanValue();
        }
    }

    public final a a() {
        if (this.d) {
            this.f23168a = a.MOCK;
        } else if (!b() || this.f23169c) {
            this.f23168a = a.CAMERA_1;
        } else {
            this.f23168a = a.CAMERA_2;
        }
        return this.f23168a;
    }
}
