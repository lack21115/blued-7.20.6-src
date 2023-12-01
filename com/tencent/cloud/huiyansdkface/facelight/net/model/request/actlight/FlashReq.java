package com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight;

import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectColorData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/model/request/actlight/FlashReq.class */
public class FlashReq {
    public String colorData;
    public YTImageInfo eyeImage;
    public YTImageInfo liveImage;
    public SelectData liveSelectData;
    public YTImageInfo mouthImage;
    public String platform = "2";
    public ReflectColorData reflectData;

    public String toString() {
        return "FlashReq{platform='" + this.platform + "', liveSelectData=" + this.liveSelectData + ", colorData='" + this.colorData + "', reflectData=" + this.reflectData + ", liveImage=" + this.liveImage + ", eyeImage=" + this.eyeImage + ", mouthImage=" + this.mouthImage + '}';
    }
}
