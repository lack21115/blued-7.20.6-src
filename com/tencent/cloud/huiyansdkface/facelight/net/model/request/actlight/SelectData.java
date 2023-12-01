package com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight;

import com.tencent.cloud.huiyansdkface.facelivesdk.BuildConfig;
import com.tencent.youtu.liveness.YTFaceTracker;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/model/request/actlight/SelectData.class */
public class SelectData {
    public int platform = 2;
    public int protocal = 1;
    public String reflect_param = " version 2 ";
    public int change_point_num = 2;
    public String config = "actref_ux_mode=1";
    public AndroidData android_data = new AndroidData();
    public String client_version = "sdk_version:" + BuildConfig.VERSION_NAME + ";ftrack_sdk_version:" + YTFaceTracker.getVersion() + ";freflect_sdk_version:" + YTAGReflectLiveCheckJNIInterface.FRVersion() + ";faction_sdk_version:" + YTPoseDetectJNIInterface.getVersion();

    public SelectData(float f) {
        this.android_data.lux = f;
    }

    public String toString() {
        return "SeleceData{platform=" + this.platform + ", protocal=" + this.protocal + ", client_version='" + this.client_version + "', reflect_param='" + this.reflect_param + "', change_point_num=" + this.change_point_num + ", config=" + this.config + ", android_data=" + this.android_data + '}';
    }
}
