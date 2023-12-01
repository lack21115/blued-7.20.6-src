package com.tencent.cloud.huiyansdkface.facelight.api.result;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/api/result/WbSimpleModeResult.class */
public class WbSimpleModeResult {

    /* renamed from: a  reason: collision with root package name */
    private String f35530a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f35531c;
    private String d;
    private String e;
    private String f;

    public String getEncryptAESKey() {
        return this.f35530a;
    }

    public String getIdentifyStr() {
        return this.b;
    }

    public String getUserEncryptKey() {
        return this.e;
    }

    public String getUserImageString() {
        return this.f35531c;
    }

    public String getUserVideoRotate() {
        return this.f;
    }

    public String getUserVideoString() {
        return this.d;
    }

    public void setEncryptAESKey(String str) {
        this.f35530a = str;
    }

    public void setIdentifyStr(String str) {
        this.b = str;
    }

    public void setUserEncryptKey(String str) {
        this.e = str;
    }

    public void setUserImageString(String str) {
        this.f35531c = str;
    }

    public void setUserVideoRotate(String str) {
        this.f = str;
    }

    public void setUserVideoString(String str) {
        this.d = str;
    }
}
