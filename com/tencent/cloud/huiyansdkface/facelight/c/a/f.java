package com.tencent.cloud.huiyansdkface.facelight.c.a;

import android.hardware.Camera;
import android.text.TextUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/a/f.class */
public class f implements com.tencent.cloud.huiyansdkface.a.a.g<com.tencent.cloud.huiyansdkface.a.a.a.b> {
    public static int a(Camera.Parameters parameters, int i) {
        int i2;
        for (int[] iArr : parameters.getSupportedPreviewFpsRange()) {
            com.tencent.cloud.huiyansdkface.a.d.a.b("V1FpsSelector", "entry: " + iArr[0] + " - " + iArr[1], new Object[0]);
            if (iArr[0] == iArr[1] && iArr[0] == i) {
                parameters.setPreviewFpsRange(iArr[0], iArr[1]);
                com.tencent.cloud.huiyansdkface.a.d.a.b("V1FpsSelector", "use preview fps range: " + iArr[0] + " " + iArr[1], new Object[0]);
                return iArr[0];
            }
        }
        int[] iArr2 = new int[2];
        parameters.getPreviewFpsRange(iArr2);
        if (iArr2[0] == iArr2[1]) {
            i2 = iArr2[0];
        } else {
            int i3 = i;
            if (i > iArr2[1]) {
                i3 = iArr2[1];
            }
            i2 = i3;
            if (i3 < iArr2[0]) {
                i2 = iArr2[0];
            }
        }
        String str = parameters.get("preview-frame-rate-values");
        int i4 = i2;
        if (!TextUtils.isEmpty(str)) {
            i4 = i2;
            if (!str.contains("" + (i2 / 1000))) {
                String[] split = str.split(",");
                int length = split.length;
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 < length) {
                        int parseInt = Integer.parseInt(split[i6]) * 1000;
                        if (i2 < parseInt) {
                            parameters.setPreviewFrameRate(parseInt / 1000);
                            return parseInt;
                        }
                        i5 = i6 + 1;
                    } else {
                        i4 = i2;
                        if (split.length > 0) {
                            int parseInt2 = Integer.parseInt(split[split.length - 1]) * 1000;
                            i4 = i2;
                            if (i2 > parseInt2) {
                                i4 = parseInt2;
                            }
                        }
                    }
                }
            }
        }
        parameters.setPreviewFrameRate(i4 / 1000);
        return i4;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.a.g
    /* renamed from: a */
    public com.tencent.cloud.huiyansdkface.a.a.a.b b(List<com.tencent.cloud.huiyansdkface.a.a.a.b> list, com.tencent.cloud.huiyansdkface.a.c.d dVar) {
        Object a2 = dVar.a();
        if (a2 instanceof Camera) {
            a(((Camera) a2).getParameters(), 30000);
            return null;
        }
        throw new IllegalStateException("this fps selector only be valid for v1 camera.");
    }
}
