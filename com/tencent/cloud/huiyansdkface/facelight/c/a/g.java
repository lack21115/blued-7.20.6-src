package com.tencent.cloud.huiyansdkface.facelight.c.a;

import android.hardware.Camera;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/a/g.class */
public class g implements com.tencent.cloud.huiyansdkface.a.a.g<com.tencent.cloud.huiyansdkface.a.a.a.b> {
    @Override // com.tencent.cloud.huiyansdkface.a.a.g
    /* renamed from: a */
    public com.tencent.cloud.huiyansdkface.a.a.a.b b(List<com.tencent.cloud.huiyansdkface.a.a.a.b> list, com.tencent.cloud.huiyansdkface.a.c.d dVar) {
        boolean z;
        if (dVar.a() instanceof Camera) {
            Camera.Parameters parameters = ((Camera) dVar.a()).getParameters();
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes == null || supportedFocusModes.size() != 1 || supportedFocusModes.indexOf(Camera.Parameters.FOCUS_MODE_FIXED) < 0) {
                z = false;
            } else {
                com.tencent.cloud.huiyansdkface.a.d.a.b("V1PatchFpsSelector", "focus mode has only one mode : fixed", new Object[0]);
                z = true;
            }
            if (z) {
                for (int[] iArr : parameters.getSupportedPreviewFpsRange()) {
                    com.tencent.cloud.huiyansdkface.a.d.a.b("V1PatchFpsSelector", "entry: " + iArr[0] + " - " + iArr[1], new Object[0]);
                }
                int[] iArr2 = new int[2];
                parameters.getPreviewFpsRange(iArr2);
                com.tencent.cloud.huiyansdkface.a.d.a.a("V1PatchFpsSelector", "parameters getPreviewFpsRange=" + iArr2[0] + "-" + iArr2[1], new Object[0]);
                if (iArr2[0] == iArr2[1]) {
                    for (int[] iArr3 : parameters.getSupportedPreviewFpsRange()) {
                        if (iArr3[0] != iArr3[1]) {
                            com.tencent.cloud.huiyansdkface.a.d.a.a("V1PatchFpsSelector", "new choose range is " + iArr3[0] + "-" + iArr3[1], new Object[0]);
                            return new com.tencent.cloud.huiyansdkface.a.a.a.b(iArr3[0], iArr3[1]);
                        }
                    }
                }
                return new com.tencent.cloud.huiyansdkface.a.a.a.b(-1, -1);
            }
            return null;
        }
        throw new IllegalStateException("this fps selector only can be used in camera v1");
    }
}
