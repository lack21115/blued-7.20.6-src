package com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/model/request/actlight/LiveStyleReq.class */
public class LiveStyleReq {
    public String app_id;
    public SelectData select_data;

    public LiveStyleReq(float f, String str) {
        this.select_data = new SelectData(f);
        this.app_id = str;
    }
}
