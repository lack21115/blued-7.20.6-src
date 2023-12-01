package com.tencent.cloud.huiyansdkface.facelight.api.result;

import com.tencent.cloud.huiyansdkface.facelight.net.model.result.RiskInfo;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/api/result/WbFaceVerifyResult.class */
public class WbFaceVerifyResult {

    /* renamed from: a  reason: collision with root package name */
    private boolean f35526a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f35527c;
    private String d;
    private String e;
    private String f;
    private WbFaceError g;
    private RiskInfo h;
    private WbSimpleModeResult i;
    private WbCusFaceVerifyResult j;
    private WbFaceWillModeResult k;

    public WbCusFaceVerifyResult getCusResult() {
        return this.j;
    }

    public WbFaceError getError() {
        return this.g;
    }

    public String getLiveRate() {
        return this.f35527c;
    }

    public String getOrderNo() {
        return this.f;
    }

    public RiskInfo getRiskInfo() {
        return this.h;
    }

    public String getSign() {
        return this.b;
    }

    public String getSimilarity() {
        return this.d;
    }

    public WbSimpleModeResult getSimpleModeResult() {
        return this.i;
    }

    public String getUserImageString() {
        return this.e;
    }

    public WbFaceWillModeResult getWillResult() {
        return this.k;
    }

    public boolean isSuccess() {
        return this.f35526a;
    }

    public void setCusResult(WbCusFaceVerifyResult wbCusFaceVerifyResult) {
        this.j = wbCusFaceVerifyResult;
    }

    public void setError(WbFaceError wbFaceError) {
        this.g = wbFaceError;
    }

    public void setIsSuccess(boolean z) {
        this.f35526a = z;
    }

    public void setLiveRate(String str) {
        this.f35527c = str;
    }

    public void setOrderNo(String str) {
        this.f = str;
    }

    public void setRiskInfo(RiskInfo riskInfo) {
        this.h = riskInfo;
    }

    public void setSign(String str) {
        this.b = str;
    }

    public void setSimilarity(String str) {
        this.d = str;
    }

    public void setSimpleModeResult(WbSimpleModeResult wbSimpleModeResult) {
        this.i = wbSimpleModeResult;
    }

    public void setUserImageString(String str) {
        this.e = str;
    }

    public void setWillResult(WbFaceWillModeResult wbFaceWillModeResult) {
        this.k = wbFaceWillModeResult;
    }

    public String toString() {
        WbFaceError wbFaceError = this.g;
        String wbFaceError2 = wbFaceError == null ? "" : wbFaceError.toString();
        WbFaceWillModeResult wbFaceWillModeResult = this.k;
        String wbFaceWillModeResult2 = wbFaceWillModeResult != null ? wbFaceWillModeResult.toString() : "";
        return "WbFaceVerifyResult{isSuccess=" + this.f35526a + ", sign='" + this.b + "', liveRate='" + this.f35527c + "', similarity='" + this.d + "', orderNo='" + this.f + "', riskInfo=" + this.h + ", error=" + wbFaceError2 + ", willResult=" + wbFaceWillModeResult2 + '}';
    }
}
