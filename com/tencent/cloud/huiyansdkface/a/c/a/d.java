package com.tencent.cloud.huiyansdkface.a.c.a;

import android.hardware.Camera;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/c/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.c.a f35452a;
    private a b;

    public d(com.tencent.cloud.huiyansdkface.a.c.a aVar, a aVar2) {
        this.f35452a = aVar;
        this.b = aVar2;
    }

    private com.tencent.cloud.huiyansdkface.a.a.a a(com.tencent.cloud.huiyansdkface.a.a.a aVar, Camera.Parameters parameters) {
        int[] iArr = new int[2];
        parameters.getPreviewFpsRange(iArr);
        return aVar.a(parameters.getZoom()).a(new com.tencent.cloud.huiyansdkface.a.a.a.d(parameters.getPreviewSize().width, parameters.getPreviewSize().height)).c(new com.tencent.cloud.huiyansdkface.a.a.a.d(parameters.getPictureSize().width, parameters.getPictureSize().height)).b(parameters.getFocusMode()).a(parameters.getFlashMode()).a(parameters.isZoomSupported() ? parameters.getZoom() / parameters.getMaxZoom() : -1.0f).a(new com.tencent.cloud.huiyansdkface.a.a.a.b(iArr[0], iArr[1]));
    }

    private com.tencent.cloud.huiyansdkface.a.a.a b(com.tencent.cloud.huiyansdkface.a.a.c cVar) {
        com.tencent.cloud.huiyansdkface.a.a.a a2 = new e(this.b).a(cVar);
        Camera.Parameters parameters = this.b.a().getParameters();
        if (a2 == null) {
            com.tencent.cloud.huiyansdkface.a.a.a aVar = new com.tencent.cloud.huiyansdkface.a.a.a();
            a(aVar, parameters);
            return aVar;
        }
        com.tencent.cloud.huiyansdkface.a.d.a.b("V1ConfigOperator", "start camera config.", new Object[0]);
        new h(a2, cVar).a(this.b);
        float d = a2.d();
        if (d >= 0.0f) {
            this.f35452a.a(d / parameters.getMaxZoom());
        }
        a(a2, this.b.a().getParameters());
        return a2;
    }

    public com.tencent.cloud.huiyansdkface.a.a.a a(com.tencent.cloud.huiyansdkface.a.a.c cVar) {
        try {
            return b(cVar);
        } catch (Exception e) {
            com.tencent.cloud.huiyansdkface.a.d.a.d("V1ConfigOperator", e, "update camera config error:%s", e.getMessage());
            return null;
        }
    }
}
