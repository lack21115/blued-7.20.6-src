package com.tencent.cloud.huiyansdkface.facelight.c.a;

import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.ugc.UGCTransitionRules;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/a/d.class */
public class d implements com.tencent.cloud.huiyansdkface.a.a.g<com.tencent.cloud.huiyansdkface.a.a.a.d> {
    @Override // com.tencent.cloud.huiyansdkface.a.a.g
    /* renamed from: a */
    public com.tencent.cloud.huiyansdkface.a.a.a.d b(List<com.tencent.cloud.huiyansdkface.a.a.a.d> list, com.tencent.cloud.huiyansdkface.a.c.d dVar) {
        if ("GT-I9508".equals(Param.getDeviceModel())) {
            return new com.tencent.cloud.huiyansdkface.a.a.a.d(1280, UGCTransitionRules.DEFAULT_IMAGE_WIDTH);
        }
        return null;
    }
}
