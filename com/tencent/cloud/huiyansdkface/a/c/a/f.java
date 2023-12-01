package com.tencent.cloud.huiyansdkface.a.c.a;

import android.hardware.Camera;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/c/a/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private Camera f35454a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private Camera.CameraInfo f35455c;
    private com.tencent.cloud.huiyansdkface.a.a.a.a d;
    private List<com.tencent.cloud.huiyansdkface.a.c.d> e = new ArrayList();

    private com.tencent.cloud.huiyansdkface.a.a.a.a a(int i) {
        return i == 0 ? com.tencent.cloud.huiyansdkface.a.a.a.a.BACK : i == 1 ? com.tencent.cloud.huiyansdkface.a.a.a.a.FRONT : com.tencent.cloud.huiyansdkface.a.a.a.a.FRONT;
    }

    private a a(Camera.CameraInfo cameraInfo, int i) {
        this.f35454a = Camera.open(i);
        this.f35455c = cameraInfo;
        this.b = i;
        return b();
    }

    public static boolean a(com.tencent.cloud.huiyansdkface.a.a.a.a aVar, int i, int i2) {
        if (i == 0 && aVar == com.tencent.cloud.huiyansdkface.a.a.a.a.BACK) {
            return true;
        }
        return (i == 1 && aVar == com.tencent.cloud.huiyansdkface.a.a.a.a.FRONT) || aVar.a() == i2;
    }

    private boolean b(int i) {
        return i == 1;
    }

    public a a(com.tencent.cloud.huiyansdkface.a.a.a.a aVar) {
        String str;
        this.d = aVar;
        com.tencent.cloud.huiyansdkface.a.d.a.a("V1Connector", "需要的摄像头:" + aVar.toString(), new Object[0]);
        int numberOfCameras = Camera.getNumberOfCameras();
        com.tencent.cloud.huiyansdkface.a.d.a.a("V1Connector", "open camera:number of cameras=%d", Integer.valueOf(numberOfCameras));
        if (numberOfCameras > 0) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            if (numberOfCameras != 1) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= numberOfCameras) {
                        str = "no camera can use:numberOfCameras is " + this.e.size() + ":" + this.e;
                        break;
                    }
                    Camera.getCameraInfo(i2, cameraInfo);
                    com.tencent.cloud.huiyansdkface.a.d.a.a("V1Connector", "camera:" + i2 + ":face=" + cameraInfo.facing, new Object[0]);
                    if (a(aVar, cameraInfo.facing, i2)) {
                        com.tencent.cloud.huiyansdkface.a.d.a.b("V1Connector", "camera open:find dest camera:face=%s,camera id=%d", aVar.toString(), Integer.valueOf(i2));
                        a a2 = a(cameraInfo, i2);
                        this.e.add(a2);
                        this.d.a(b(cameraInfo.facing));
                        return a2;
                    }
                    this.e.add(new a().a(a(cameraInfo.facing)).b(i2).a(cameraInfo).a(cameraInfo.orientation));
                    i = i2 + 1;
                }
            } else {
                Camera.getCameraInfo(0, cameraInfo);
                this.d.a(b(cameraInfo.facing));
                a a3 = a(cameraInfo, 0);
                this.e.add(a3);
                return a3;
            }
        } else {
            str = "no camera can use:numberOfCameras is 0";
        }
        com.tencent.cloud.huiyansdkface.a.b.b.a(com.tencent.cloud.huiyansdkface.a.b.c.b(11, str, null));
        return null;
    }

    public void a() {
        synchronized (this) {
            if (this.f35454a != null) {
                com.tencent.cloud.huiyansdkface.a.d.a.a("V1Connector", "close camera:" + this.f35454a, new Object[0]);
                this.f35454a.release();
                this.f35455c = null;
                this.f35454a = null;
            }
        }
    }

    public a b() {
        return new a().a(this.f35454a).a(this.f35455c.orientation).a(this.f35455c).a(this.d).b(this.b);
    }
}
