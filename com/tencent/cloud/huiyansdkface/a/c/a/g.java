package com.tencent.cloud.huiyansdkface.a.c.a;

import android.hardware.Camera;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/c/a/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private a f21765a;

    public g(a aVar) {
        this.f21765a = aVar;
    }

    public com.tencent.cloud.huiyansdkface.a.a.d a() {
        try {
            com.tencent.cloud.huiyansdkface.a.a.d dVar = new com.tencent.cloud.huiyansdkface.a.a.d();
            Camera.Parameters parameters = this.f21765a.a().getParameters();
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
            List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
            List<String> supportedFlashModes = parameters.getSupportedFlashModes();
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            dVar.a(parameters.isZoomSupported());
            dVar.e(supportedFlashModes);
            dVar.f(supportedFocusModes);
            dVar.b(com.tencent.cloud.huiyansdkface.a.a.c.a.b(supportedPreviewSizes));
            dVar.c(com.tencent.cloud.huiyansdkface.a.a.c.a.b(supportedPictureSizes));
            dVar.d(com.tencent.cloud.huiyansdkface.a.a.c.a.b(supportedVideoSizes));
            dVar.a(com.tencent.cloud.huiyansdkface.a.a.c.a.a(parameters.getPreferredPreviewSizeForVideo()));
            dVar.a(com.tencent.cloud.huiyansdkface.a.a.c.a.a(parameters.getSupportedPreviewFpsRange()));
            this.f21765a.a(dVar);
            com.tencent.cloud.huiyansdkface.a.d.a.a("V1FeatureCollector", "get camera features success", new Object[0]);
            return dVar;
        } catch (Throwable th) {
            com.tencent.cloud.huiyansdkface.a.b.b.a(com.tencent.cloud.huiyansdkface.a.b.c.b(21, "get camera feature failed.", th));
            return null;
        }
    }
}
