package com.tencent.cloud.huiyansdkface.a.c.a;

import android.hardware.Camera;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/c/a/l.class */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private Camera f21780a;

    public l(Camera camera) {
        this.f21780a = camera;
    }

    public void a(float f) {
        com.tencent.cloud.huiyansdkface.a.d.a.a("V1ZoomOperator", "take scale:" + f, new Object[0]);
        try {
            Camera.Parameters parameters = this.f21780a.getParameters();
            if (!parameters.isZoomSupported()) {
                com.tencent.cloud.huiyansdkface.a.d.a.a("V1ZoomOperator", "zoom unsupported", new Object[0]);
                return;
            }
            int maxZoom = parameters.getMaxZoom();
            float f2 = f;
            if (f > 1.0f) {
                f2 = 1.0f;
            }
            float f3 = f2;
            if (f2 < 0.0f) {
                f3 = 0.0f;
            }
            parameters.setZoom((int) (maxZoom * f3));
            this.f21780a.setParameters(parameters);
            com.tencent.cloud.huiyansdkface.a.d.a.a("V1ZoomOperator", "take scale success.", new Object[0]);
        } catch (Exception e) {
            com.tencent.cloud.huiyansdkface.a.b.b.a(com.tencent.cloud.huiyansdkface.a.b.c.a(63, "set zoom failed", e));
        }
    }
}
