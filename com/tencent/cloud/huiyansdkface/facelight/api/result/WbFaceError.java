package com.tencent.cloud.huiyansdkface.facelight.api.result;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/api/result/WbFaceError.class */
public class WbFaceError {
    public static final String WBFaceErrorCodeActOutOfTime = "41008";
    public static final String WBFaceErrorCodeCameraException = "41003";
    public static final String WBFaceErrorCodeCompareNetworkError = "51100";
    public static final String WBFaceErrorCodeCompareServerError = "51200";
    public static final String WBFaceErrorCodeDataSerilizerError = "11002";
    public static final String WBFaceErrorCodeFindFaceOutOfTime = "41007";
    public static final String WBFaceErrorCodeGetInfoNetworkError = "31100";
    public static final String WBFaceErrorCodeGetInfoServerError = "31200";
    public static final String WBFaceErrorCodeInitModel = "41012";
    public static final String WBFaceErrorCodeInputModelsError = "11005";
    public static final String WBFaceErrorCodeInputParaNull = "11000";
    public static final String WBFaceErrorCodeKeyLicenceError = "11001";
    public static final String WBFaceErrorCodeLipStrError = "41001";
    public static final String WBFaceErrorCodeLocalLightError = "41009";
    public static final String WBFaceErrorCodeLoginNetworkError = "21100";
    public static final String WBFaceErrorCodeLoginServerError = "21200";
    public static final String WBFaceErrorCodeMediaFileError = "41006";
    public static final String WBFaceErrorCodeMediaRecord = "41004";
    public static final String WBFaceErrorCodeNoBestPic = "41005";
    public static final String WBFaceErrorCodeNoPermission = "41002";
    public static final String WBFaceErrorCodeNoVolumn = "41011";
    public static final String WBFaceErrorCodeOutOfControlNum = "41010";
    public static final String WBFaceErrorCodeSdkInitFail = "41013";
    public static final String WBFaceErrorCodeSimpleLocalError = "41014";
    public static final String WBFaceErrorCodeUserCancle = "41000";
    public static final String WBFaceErrorCodeWillLowPlayVolumeError = "41106";
    public static final String WBFaceErrorCodeWillNoVoiceError = "41102";
    public static final String WBFaceErrorCodeWillPlayError = "41104";
    public static final String WBFaceErrorCodeWillPrepareError = "41103";
    public static final String WBFaceErrorCodeWillRecordError = "41101";
    public static final String WBFaceErrorCodeWillVideoRecordError = "41105";
    public static final String WBFaceErrorDomainCompareNetwork = "WBFaceErrorDomainCompareNetwork";
    public static final String WBFaceErrorDomainCompareServer = "WBFaceErrorDomainCompareServer";
    public static final String WBFaceErrorDomainDevices = "WBFaceErrorDomainDevices";
    public static final String WBFaceErrorDomainGetInfoNetwork = "WBFaceErrorDomainGetInfoNetwork";
    public static final String WBFaceErrorDomainGetInfoServer = "WBFaceErrorDomainGetInfoServer";
    public static final String WBFaceErrorDomainLoginNetwork = "WBFaceErrorDomainLoginNetwork";
    public static final String WBFaceErrorDomainLoginServer = "WBFaceErrorDomainLoginServer";
    public static final String WBFaceErrorDomainNativeProcess = "WBFaceErrorDomainNativeProcess";
    public static final String WBFaceErrorDomainParams = "WBFaceErrorDomainParams";
    public static final String WBFaceErrorDomainSeverFailed = "WBFaceErrorDomainSeverFailed";

    /* renamed from: a  reason: collision with root package name */
    private String f35524a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f35525c;
    private String d;

    public WbFaceError() {
    }

    public WbFaceError(String str, String str2, String str3, String str4) {
        this.f35524a = str;
        this.b = str2;
        this.f35525c = str3;
        this.d = str4;
    }

    public String getCode() {
        return this.b;
    }

    public String getDesc() {
        return this.f35525c;
    }

    public String getDomain() {
        return this.f35524a;
    }

    public String getReason() {
        return this.d;
    }

    public void setCode(String str) {
        this.b = str;
    }

    public void setDesc(String str) {
        this.f35525c = str;
    }

    public void setDomain(String str) {
        this.f35524a = str;
    }

    public void setReason(String str) {
        this.d = str;
    }

    public String toString() {
        return "WbFaceError{domain='" + this.f35524a + "', code='" + this.b + "', desc='" + this.f35525c + "', reason='" + this.d + "'}";
    }
}
