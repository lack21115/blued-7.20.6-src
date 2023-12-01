package com.tencent.cloud.huiyansdkface.facelight.api.result;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/api/result/WbFaceWillModeResult.class */
public class WbFaceWillModeResult {

    /* renamed from: a  reason: collision with root package name */
    private String f21837a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f21838c;
    private String d;
    private String e;

    public String getFaceCode() {
        return this.f21838c;
    }

    public String getFaceMsg() {
        return this.d;
    }

    public String getVideoPath() {
        return this.e;
    }

    public String getWillCode() {
        return this.f21837a;
    }

    public String getWillMsg() {
        return this.b;
    }

    public void setFaceCode(String str) {
        this.f21838c = str;
    }

    public void setFaceMsg(String str) {
        this.d = str;
    }

    public void setVideoPath(String str) {
        this.e = str;
    }

    public void setWillCode(String str) {
        this.f21837a = str;
    }

    public void setWillMsg(String str) {
        this.b = str;
    }

    public String toString() {
        return "WbFaceWillModeResult{willCode='" + this.f21837a + "', willMsg='" + this.b + "', faceCode='" + this.f21838c + "', faceMsg='" + this.d + "', videoPath='" + this.e + "'}";
    }
}
