package com.tencent.cloud.huiyansdkface.facelight.provider;

import android.Manifest;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.R;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger;
import com.tencent.cloud.huiyansdkface.facelight.common.WbSecureProviders;
import com.tencent.cloud.huiyansdkface.facelight.common.WbTimer;
import com.tencent.cloud.huiyansdkface.facelight.common.WeOkHttpProvider;
import com.tencent.cloud.huiyansdkface.facelight.net.GetFaceActiveCompareType;
import com.tencent.cloud.huiyansdkface.facelight.net.GetGradeFaceCompareResult;
import com.tencent.cloud.huiyansdkface.facelight.net.LoginRequest;
import com.tencent.cloud.huiyansdkface.facelight.net.QueryFaceResultRequest;
import com.tencent.cloud.huiyansdkface.facelight.net.model.FaceWillResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.WbFaceWillRes;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.FlashReq;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.SelectData;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.CompareResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.GetActResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.LoginResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.QueryResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.RiskInfo;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.facelight.provider.PermissionInfo;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.record.WeMediaManager;
import com.tencent.cloud.huiyansdkface.wehttp2.BaseCallback;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import java.io.IOException;
import java.util.Properties;
import java.util.TimerTask;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/provider/WbFaceLiveImpl.class */
public class WbFaceLiveImpl implements WbFaceModeInterface {

    /* renamed from: a  reason: collision with root package name */
    private Context f35642a;
    private d b;

    /* renamed from: c  reason: collision with root package name */
    private int f35643c;
    private int d;
    private int e;
    private boolean f;
    private CloudFaceCountDownTimer g;
    private ProcessCallback<FaceWillResult> i;
    private WbTimer h = new WbTimer();
    private Handler j = new Handler() { // from class: com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceLiveImpl.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                WbFaceLiveImpl.this.a("");
            }
            super.handleMessage(message);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceLiveImpl$4  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/provider/WbFaceLiveImpl$4.class */
    public class AnonymousClass4 implements WeReq.Callback<GetGradeFaceCompareResult.GetResultReflectModeResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ byte[] f35649a;
        final /* synthetic */ byte[] b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f35650c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ FlashReq f;
        final /* synthetic */ boolean g;
        final /* synthetic */ String h;
        final /* synthetic */ String i;

        AnonymousClass4(byte[] bArr, byte[] bArr2, String str, String str2, String str3, FlashReq flashReq, boolean z, String str4, String str5) {
            this.f35649a = bArr;
            this.b = bArr2;
            this.f35650c = str;
            this.d = str2;
            this.e = str3;
            this.f = flashReq;
            this.g = z;
            this.h = str4;
            this.i = str5;
        }

        @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
        /* renamed from: a */
        public void onSuccess(WeReq weReq, GetGradeFaceCompareResult.GetResultReflectModeResponse getResultReflectModeResponse) {
            if (WbFaceLiveImpl.this.f) {
                WLogger.d("WbFaceLiveImpl", "Already getResult,no need handle upload result!");
                return;
            }
            WLogger.d("WbFaceLiveImpl", "upload onSuccess");
            if (getResultReflectModeResponse == null) {
                WLogger.i("WbFaceLiveImpl", "Reflect Mode upload failed! baseResponse is null！");
                WbFaceLiveImpl.this.a(false, (FaceWillResult) null, WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainSeverFailed, WbFaceError.WBFaceErrorCodeCompareServerError, "报文解析异常", "Reflect Mode upload failed! baseResponse is null！"));
                KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f35642a, "facepage_upload_server_error", "51200+Reflect Mode upload failed! baseResponse is null！", null);
                return;
            }
            String str = this.g ? getResultReflectModeResponse.encryptBody : getResultReflectModeResponse.enMsg;
            if (TextUtils.isEmpty(str)) {
                WLogger.i("WbFaceLiveImpl", "upload failed,enMsg is null！" + getResultReflectModeResponse.code + "," + getResultReflectModeResponse.msg + "," + getResultReflectModeResponse.debugMsg);
                String str2 = "upload failed!enMsg is null！" + getResultReflectModeResponse.code + "," + getResultReflectModeResponse.msg + "," + getResultReflectModeResponse.debugMsg;
                WbFaceLiveImpl.this.a(false, (FaceWillResult) null, WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainSeverFailed, WbFaceError.WBFaceErrorCodeCompareServerError, "报文解析异常", str2));
                String encryptAESKey = WbCloudNetSecurityManger.encryptAESKey(this.g, this.h, "faceCompare:");
                KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f35642a, "facepage_upload_server_error", "51200+" + str2 + ";" + this.i + ";" + encryptAESKey, null);
                return;
            }
            try {
                CompareResult compareResult = (CompareResult) WbCloudNetSecurityManger.decry(this.g, str, CompareResult.class, this.h);
                if (compareResult != null) {
                    WLogger.i("WbFaceLiveImpl", "Reflect Mode upload success!" + compareResult.toString());
                    String valueOf = String.valueOf(compareResult.code);
                    String str3 = compareResult.msg;
                    String str4 = compareResult.msg;
                    String str5 = "1".equals(compareResult.retry) ? "1" : "0";
                    String str6 = compareResult.sign;
                    String str7 = compareResult.liveRate;
                    String str8 = compareResult.similarity;
                    if (str7 == null) {
                        str7 = "分数为空";
                    }
                    String str9 = str8;
                    if (str8 == null) {
                        str9 = "分数为空";
                    }
                    RiskInfo riskInfo = compareResult.riskInfo;
                    String str10 = compareResult.isRecorded;
                    if (TextUtils.isEmpty(valueOf)) {
                        WLogger.e("WbFaceLiveImpl", "Reflect Mode upload failed! faceCode is null!");
                        KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f35642a, "facepage_upload_server_error", "51200+Reflect Mode upload failed! faceCode is null!", null);
                        WbFaceLiveImpl.this.a(false, (FaceWillResult) null, WbFaceInnerError.create(WbFaceLiveImpl.this.a(WbFaceError.WBFaceErrorDomainCompareServer, str10), WbFaceError.WBFaceErrorCodeCompareServerError, "报文解析异常", "Reflect Mode upload failed! faceCode is null!"));
                    } else if ("0".equals(valueOf)) {
                        WLogger.i("WbFaceLiveImpl", "Reflect Mode verify success!");
                        KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f35642a, "facepage_upload_response", null, null);
                        WbFaceLiveImpl.this.a(true, new FaceWillResult(valueOf, str3, str9, str7, str5, riskInfo, str6, str10), (WbFaceInnerError) null);
                    } else {
                        WLogger.i("WbFaceLiveImpl", "Reflect Mode verify failed!");
                        if ("66660018".equals(valueOf)) {
                            WbFaceLiveImpl.this.a();
                            WbFaceLiveImpl.this.a(valueOf);
                            return;
                        }
                        KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f35642a, "facepage_upload_server_error", valueOf + "+" + str3, null);
                        WbFaceLiveImpl.this.a(false, (FaceWillResult) null, WbFaceInnerError.create(WbFaceLiveImpl.this.a(WbFaceError.WBFaceErrorDomainCompareServer, str10), valueOf, str4, str3, str9, str7, str5, riskInfo, str6, str10));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                WLogger.w("WbFaceLiveImpl", "Compare Result decry failed！" + e.toString());
                String str11 = "Compare Result decry failed！ " + e.toString();
                Properties properties = new Properties();
                properties.setProperty("enKey", this.i);
                KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f35642a, "faceservice_data_serialize_decry_fail", str11, properties);
                KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f35642a, "facepage_upload_server_error", str11, null);
                WbFaceLiveImpl.this.a(false, (FaceWillResult) null, WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainSeverFailed, WbFaceError.WBFaceErrorCodeDataSerilizerError, "报文解析异常", str11));
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
        public void onFailed(WeReq weReq, WeReq.ErrType errType, int i, String str, IOException iOException) {
            if (WbFaceLiveImpl.this.f) {
                WLogger.d("WbFaceLiveImpl", "Already getResult,no need handle upload result");
                return;
            }
            WLogger.e("WbFaceLiveImpl", "upload onFailed！" + errType + "," + i + "," + str);
            if (WbFaceLiveImpl.this.d == 0) {
                KycWaSDK kycWaSDK = KycWaSDK.getInstance();
                Context context = WbFaceLiveImpl.this.f35642a;
                kycWaSDK.trackIMSWarnVEvent(context, "facepage_upload_network_error", errType + "," + i + "+" + str, null);
            } else {
                KycWaSDK kycWaSDK2 = KycWaSDK.getInstance();
                Context context2 = WbFaceLiveImpl.this.f35642a;
                kycWaSDK2.trackCustomKVEvent(context2, "facepage_upload_retry", "retry=" + WbFaceLiveImpl.this.d + errType + "," + i + "+" + str, null);
            }
            if (errType == WeReq.ErrType.NETWORK) {
                WLogger.d("WbFaceLiveImpl", "check is need retry");
                int ae = WbFaceLiveImpl.this.b.e().ae();
                WLogger.d("WbFaceLiveImpl", "total=" + ae + ",cur=" + WbFaceLiveImpl.this.d);
                if (!WbFaceLiveImpl.this.f && ae > 0 && WbFaceLiveImpl.this.d < ae) {
                    if (WbFaceLiveImpl.this.i != null) {
                        WLogger.d("WbFaceLiveImpl", "need retry");
                        WbFaceLiveImpl.h(WbFaceLiveImpl.this);
                        WbFaceLiveImpl.this.i.onUiNetworkRetryTip();
                        WbFaceLiveImpl.this.a(this.f35649a, this.b, this.f35650c, this.d, this.e, this.f);
                        return;
                    }
                    return;
                }
            }
            WbFaceLiveImpl wbFaceLiveImpl = WbFaceLiveImpl.this;
            wbFaceLiveImpl.a(false, (FaceWillResult) null, WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainCompareNetwork, WbFaceError.WBFaceErrorCodeCompareNetworkError, "网络异常", "code=" + i + "msg=" + str));
        }

        @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
        public void onFinish() {
            WLogger.d("WbFaceLiveImpl", "upload onFinish!need delete video.");
            WeMediaManager.getInstance().resetVideoByte();
        }

        @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
        public void onStart(WeReq weReq) {
            if (WbFaceLiveImpl.this.d == 0) {
                WLogger.d("WbFaceLiveImpl", "first compareRequest begin");
                final long ag = WbFaceLiveImpl.this.b.e().ag();
                WbFaceLiveImpl.this.g = new CloudFaceCountDownTimer(ag, ag / 2) { // from class: com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceLiveImpl.4.1
                    @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                    public void onFinish() {
                        WLogger.d("WbFaceLiveImpl", "queryCdt finished!");
                        if (WbFaceLiveImpl.this.f) {
                            return;
                        }
                        WLogger.d("WbFaceLiveImpl", "first compareRequest didnt finished,start query");
                        TimerTask timerTask = new TimerTask() { // from class: com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceLiveImpl.4.1.1
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                Message message = new Message();
                                message.what = 1;
                                WbFaceLiveImpl.this.j.sendMessage(message);
                            }
                        };
                        long j = ag;
                        if (j <= 0) {
                            WLogger.d("WbFaceLiveImpl", "Illegal period,use default.");
                            j = 4000;
                        }
                        WbFaceLiveImpl.this.h.scheduleAtFixedRate(timerTask, 0L, j);
                    }

                    @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                    public void onTick(long j) {
                    }
                }.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2) {
        return "1".equals(str2) ? str : WbFaceError.WBFaceErrorDomainSeverFailed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.g;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.g = null;
        }
        this.h.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        if (this.f35643c == 9) {
            WLogger.d("WbFaceLiveImpl", "On finish Step,No more queryFaceResult!");
        } else if (this.f) {
            WLogger.e("WbFaceLiveImpl", "isAlreadyGetFaceResult!no more query!");
        } else {
            WLogger.d("WbFaceLiveImpl", "queryFaceResult");
            final String generateAESKey = WbCloudNetSecurityManger.generateAESKey();
            final boolean isUseGm = WbSecureProviders.isUseGm();
            final String encryptAESKey = WbCloudNetSecurityManger.encryptAESKey(isUseGm, generateAESKey, "faceCompare:");
            QueryFaceResultRequest.requestExec(this.b.a(), this.e, "none".equals(this.b.x().k()) ? "2" : "1", generateAESKey, encryptAESKey, isUseGm, new WeReq.Callback<QueryFaceResultRequest.QueryResponse>() { // from class: com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceLiveImpl.5
                @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
                /* renamed from: a */
                public void onSuccess(WeReq weReq, QueryFaceResultRequest.QueryResponse queryResponse) {
                    if (WbFaceLiveImpl.this.f) {
                        WLogger.d("WbFaceLiveImpl", "Already getResult,no need handle query result!");
                        return;
                    }
                    WLogger.d("WbFaceLiveImpl", "query onSuccess!");
                    if (queryResponse == null) {
                        WLogger.i("WbFaceLiveImpl", "Query failed! baseResponse is null！");
                        return;
                    }
                    String str2 = isUseGm ? queryResponse.encryptBody : queryResponse.enMsg;
                    if (TextUtils.isEmpty(str2)) {
                        WLogger.i("WbFaceLiveImpl", "Query failed,enMsg is null！" + queryResponse.code + "," + queryResponse.msg + "," + queryResponse.debugMsg);
                        return;
                    }
                    try {
                        QueryResult queryResult = (QueryResult) WbCloudNetSecurityManger.decry(isUseGm, str2, QueryResult.class, generateAESKey);
                        WLogger.i("WbFaceLiveImpl", "Query success!" + queryResult.toString());
                        String valueOf = String.valueOf(queryResult.code);
                        if (TextUtils.isEmpty(valueOf)) {
                            WLogger.e("WbFaceLiveImpl", "Query failed! resultCode is null!");
                        } else if ("66660011".equals(valueOf)) {
                            if (!"66660018".equals(str)) {
                                WLogger.w("WbFaceLiveImpl", "query no result;Go on RETRY!");
                                return;
                            }
                            KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f35642a, "facepage_upload_server_error", "51100+FACEID_INVALID+QUERY_NO_RESULT", null);
                            WbFaceLiveImpl.this.a(false, (FaceWillResult) null, WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainCompareNetwork, WbFaceError.WBFaceErrorCodeCompareNetworkError, "网络异常", "Query response error!"));
                        } else {
                            String str3 = "1".equals(queryResult.retry) ? "1" : "0";
                            String str4 = queryResult.liveRate;
                            String str5 = queryResult.similarity;
                            if (TextUtils.isEmpty(str4)) {
                                str4 = "分数为空";
                            }
                            if (TextUtils.isEmpty(str5)) {
                                str5 = "分数为空";
                            }
                            String str6 = queryResult.isRecorded;
                            if ("0".equals(valueOf)) {
                                WLogger.i("WbFaceLiveImpl", "verify success!");
                                KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f35642a, "facepage_upload_query_response", "0", null);
                                WbFaceLiveImpl.this.a(true, new FaceWillResult(valueOf, queryResult.msg, str5, str4, str3, queryResult.riskInfo, queryResult.sign, str6), (WbFaceInnerError) null);
                                return;
                            }
                            WLogger.i("WbFaceLiveImpl", "verify failed!");
                            KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f35642a, "facepage_upload_query_response", valueOf, null);
                            WbFaceLiveImpl.this.a(false, (FaceWillResult) null, WbFaceInnerError.create(WbFaceLiveImpl.this.a(WbFaceError.WBFaceErrorDomainCompareServer, str6), valueOf, queryResult.msg, queryResult.msg, str5, str4, str3, queryResult.riskInfo, queryResult.sign, str6));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        WLogger.w("WbFaceLiveImpl", "Query Result decry failed！" + e.toString());
                        Properties properties = new Properties();
                        properties.setProperty("enKey", encryptAESKey);
                        KycWaSDK kycWaSDK = KycWaSDK.getInstance();
                        Context context = WbFaceLiveImpl.this.f35642a;
                        kycWaSDK.trackCustomKVEvent(context, "faceservice_data_serialize_decry_fail", "Query Result decry failed！ " + e.toString(), properties);
                    }
                }

                @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
                public void onFailed(WeReq weReq, WeReq.ErrType errType, int i, String str2, IOException iOException) {
                    WLogger.e("WbFaceLiveImpl", "query failed:" + errType + ",code=" + i + ",s=" + str2);
                }

                @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
                public void onFinish() {
                }

                @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
                public void onStart(WeReq weReq) {
                }
            });
            this.e++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, FaceWillResult faceWillResult, WbFaceInnerError wbFaceInnerError) {
        if (this.f) {
            WLogger.d("WbFaceLiveImpl", "Already getResult,no more endLoading!");
            return;
        }
        WLogger.d("WbFaceLiveImpl", "endLoading:" + this.f);
        this.f = true;
        WLogger.d("WbFaceLiveImpl", "isGetFaceResult =" + this.f);
        a();
        ProcessCallback<FaceWillResult> processCallback = this.i;
        if (processCallback != null) {
            if (z) {
                processCallback.onSuccess(faceWillResult);
            } else {
                processCallback.onFailed(wbFaceInnerError);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, byte[] bArr2, String str, String str2, String str3, FlashReq flashReq) {
        if (this.d != 0 && this.f) {
            WLogger.e("WbFaceLiveImpl", "isAlreadyGetFaceResult!no more upload!");
            return;
        }
        WLogger.d("WbFaceLiveImpl", "startNetworkUpload");
        String generateAESKey = WbCloudNetSecurityManger.generateAESKey();
        boolean isUseGm = WbSecureProviders.isUseGm();
        String encryptAESKey = WbCloudNetSecurityManger.encryptAESKey(isUseGm, generateAESKey, "faceCompare:");
        GetGradeFaceCompareResult.requestExec(this.b.a(), generateAESKey, encryptAESKey, isUseGm, bArr, bArr2, str, str2, str3, flashReq, this.d, new AnonymousClass4(bArr, bArr2, str, str2, str3, flashReq, isUseGm, generateAESKey, encryptAESKey));
    }

    static /* synthetic */ int h(WbFaceLiveImpl wbFaceLiveImpl) {
        int i = wbFaceLiveImpl.d;
        wbFaceLiveImpl.d = i + 1;
        return i;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void getFaceResource(boolean z, String str, final ProcessCallback<WbFaceWillRes> processCallback) {
        SelectData selectData = new SelectData(Float.valueOf(str).floatValue());
        WLogger.d("WbFaceLiveImpl", "selectData=" + selectData.toString());
        final String generateAESKey = WbCloudNetSecurityManger.generateAESKey();
        final boolean isUseGm = WbSecureProviders.isUseGm();
        final String encryptAESKey = WbCloudNetSecurityManger.encryptAESKey(isUseGm, generateAESKey, "getActRes:");
        KycWaSDK.getInstance().trackCustomKVEvent(this.f35642a, "facepage_get_flash_res", null, null);
        GetFaceActiveCompareType.requestExec(this.b.a(), generateAESKey, encryptAESKey, isUseGm, Param.getGradeCompareType(), selectData, new BaseCallback<GetFaceActiveCompareType.GetFaceCompareTypeResponse>() { // from class: com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceLiveImpl.3
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            /* renamed from: a */
            public void onSuccess(WeReq weReq, GetFaceActiveCompareType.GetFaceCompareTypeResponse getFaceCompareTypeResponse) {
                if (getFaceCompareTypeResponse == null) {
                    WLogger.w("WbFaceLiveImpl", "baseResponse is null!");
                    KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f35642a, "facepage_get_flash_res_server_error", "baseResponse is null!", null);
                    processCallback.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainGetInfoServer, WbFaceError.WBFaceErrorCodeGetInfoServerError, WbFaceLiveImpl.this.b.f().kyc_get_error, "baseResponse is null!"));
                    return;
                }
                String str2 = isUseGm ? getFaceCompareTypeResponse.encryptBody : getFaceCompareTypeResponse.enMsg;
                if (TextUtils.isEmpty(str2)) {
                    WLogger.w("WbFaceLiveImpl", "enMsg is null!" + getFaceCompareTypeResponse.code + "," + getFaceCompareTypeResponse.msg + "," + getFaceCompareTypeResponse.debugMsg);
                    KycWaSDK kycWaSDK = KycWaSDK.getInstance();
                    Context context = WbFaceLiveImpl.this.f35642a;
                    kycWaSDK.trackCustomKVEvent(context, "facepage_get_flash_res_server_error", "enMsg is null!" + getFaceCompareTypeResponse.code + "," + getFaceCompareTypeResponse.msg + "," + getFaceCompareTypeResponse.debugMsg, null);
                    ProcessCallback processCallback2 = processCallback;
                    String str3 = WbFaceLiveImpl.this.b.f().kyc_get_error;
                    processCallback2.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainGetInfoServer, WbFaceError.WBFaceErrorCodeGetInfoServerError, str3, "enMsg is null!" + getFaceCompareTypeResponse.code + "," + getFaceCompareTypeResponse.msg + "," + getFaceCompareTypeResponse.debugMsg));
                    return;
                }
                WLogger.d("WbFaceLiveImpl", "start decry response");
                try {
                    GetActResult getActResult = (GetActResult) WbCloudNetSecurityManger.decry(isUseGm, str2, GetActResult.class, generateAESKey);
                    if (getActResult != null) {
                        WLogger.d("WbFaceLiveImpl", getActResult.toString());
                        if (TextUtils.isEmpty(getActResult.code)) {
                            WLogger.w("WbFaceLiveImpl", "code is null!");
                            KycWaSDK kycWaSDK2 = KycWaSDK.getInstance();
                            Context context2 = WbFaceLiveImpl.this.f35642a;
                            kycWaSDK2.trackCustomKVEvent(context2, "facepage_get_flash_res_server_error", "code is null!" + getActResult.msg, null);
                            ProcessCallback processCallback3 = processCallback;
                            String str4 = WbFaceLiveImpl.this.b.f().kyc_get_error;
                            processCallback3.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainGetInfoServer, WbFaceError.WBFaceErrorCodeGetInfoServerError, str4, "code is null!" + getActResult.msg));
                        } else if (!getActResult.code.equals("0")) {
                            WLogger.w("WbFaceLiveImpl", "code:" + getActResult.code + "; Msg: " + getActResult.msg);
                            KycWaSDK kycWaSDK3 = KycWaSDK.getInstance();
                            Context context3 = WbFaceLiveImpl.this.f35642a;
                            kycWaSDK3.trackCustomKVEvent(context3, "facepage_get_flash_res_server_error", "code:" + getActResult.code + "; Msg: " + getActResult.msg, null);
                            processCallback.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainGetInfoServer, getActResult.code, WbFaceLiveImpl.this.b.f().kyc_get_error, getActResult.msg));
                        } else {
                            if (WbFaceLiveImpl.this.b.x().N().contains("2")) {
                                if (TextUtils.isEmpty(getActResult.activeType)) {
                                    WLogger.w("WbFaceLiveImpl", "act mode but no activeType!");
                                    KycWaSDK kycWaSDK4 = KycWaSDK.getInstance();
                                    Context context4 = WbFaceLiveImpl.this.f35642a;
                                    kycWaSDK4.trackCustomKVEvent(context4, "facepage_get_flash_res_server_error", "act mode but no activeType!" + getActResult.msg, null);
                                    ProcessCallback processCallback4 = processCallback;
                                    String str5 = WbFaceLiveImpl.this.b.f().kyc_get_error;
                                    processCallback4.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainGetInfoServer, WbFaceError.WBFaceErrorCodeGetInfoServerError, str5, "act mode but no activeType!" + getActResult.msg));
                                    return;
                                }
                                WLogger.d("WbFaceLiveImpl", "getFlashRes result.activeType=" + getActResult.activeType);
                                WbFaceLiveImpl.this.b.x().k(getActResult.activeType);
                            }
                            if (WbFaceLiveImpl.this.b.x().N().contains("3")) {
                                if (TextUtils.isEmpty(getActResult.colorData)) {
                                    WLogger.w("WbFaceLiveImpl", "light mode but no colorData!");
                                    KycWaSDK kycWaSDK5 = KycWaSDK.getInstance();
                                    Context context5 = WbFaceLiveImpl.this.f35642a;
                                    kycWaSDK5.trackCustomKVEvent(context5, "facepage_get_flash_res_server_error", "light mode but no colorData!" + getActResult.msg, null);
                                    ProcessCallback processCallback5 = processCallback;
                                    String str6 = WbFaceLiveImpl.this.b.f().kyc_get_error;
                                    processCallback5.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainGetInfoServer, WbFaceError.WBFaceErrorCodeGetInfoServerError, str6, "light mode but no colorData!" + getActResult.msg));
                                    return;
                                }
                                WLogger.d("WbFaceLiveImpl", "getFlashRes set result.colordata");
                                WbFaceLiveImpl.this.b.x().j(getActResult.colorData);
                            }
                            KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f35642a, "facepage_get_flash_res_success", null, null);
                            processCallback.onSuccess(null);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    WLogger.w("WbFaceLiveImpl", "decry failed!" + e.toString());
                    Properties properties = new Properties();
                    properties.setProperty("enKey", encryptAESKey);
                    KycWaSDK kycWaSDK6 = KycWaSDK.getInstance();
                    Context context6 = WbFaceLiveImpl.this.f35642a;
                    kycWaSDK6.trackCustomKVEvent(context6, "faceservice_data_serialize_decry_fail", "decry GetActType failed!" + e.toString(), properties);
                    ProcessCallback processCallback6 = processCallback;
                    String str7 = WbFaceLiveImpl.this.b.f().kyc_get_error;
                    processCallback6.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainGetInfoServer, WbFaceError.WBFaceErrorCodeDataSerilizerError, str7, "decry GetActType failed!" + e.toString()));
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFailed(WeReq weReq, WeReq.ErrType errType, int i, String str2, IOException iOException) {
                WLogger.w("WbFaceLiveImpl", "getflashresourceEn onfail：" + errType + ";" + i + ";" + str2);
                KycWaSDK kycWaSDK = KycWaSDK.getInstance();
                Context context = WbFaceLiveImpl.this.f35642a;
                kycWaSDK.trackIMSWarnVEvent(context, "facepage_get_flash_res_network_error", "getflashresourceEn onfail：" + errType + ";" + i + ";" + str2, null);
                ProcessCallback processCallback2 = processCallback;
                String str3 = WbFaceLiveImpl.this.b.f().kyc_internet_check;
                processCallback2.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainGetInfoNetwork, WbFaceError.WBFaceErrorCodeGetInfoNetworkError, str3, errType + "," + i + "+" + str2));
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void getFaceResult(int i, byte[] bArr, byte[] bArr2, String str, String str2, String str3, FlashReq flashReq, String str4, String str5, String str6, String str7, String str8, ProcessCallback<FaceWillResult> processCallback) {
        this.i = processCallback;
        a(bArr, bArr2, str, str2, str3, flashReq);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public PermissionInfo getPermissionList() {
        PermissionInfo permissionInfo = new PermissionInfo();
        permissionInfo.addPermission(Manifest.permission.CAMERA, new PermissionInfo.PermissionTip(this.b.f().kyc_camera_open_ios, this.b.f().kyc_camera_setup_ios, this.b.f().kyc_camera_setup_android, "用户没有授权相机权限"));
        return permissionInfo;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public int getProtocolImgSrc() {
        return R.mipmap.wbcf_protocal_b;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void login(String str, String str2, long j, final ProcessCallback<LoginResult> processCallback) {
        String userId = Param.getUserId();
        final String generateAESKey = WbCloudNetSecurityManger.generateAESKey();
        final boolean isUseGm = WbSecureProviders.isUseGm();
        final String encryptAESKey = WbCloudNetSecurityManger.encryptAESKey(isUseGm, generateAESKey, "login:");
        WLogger.d("WbFaceLiveImpl", "start login request:" + isUseGm);
        LoginRequest.requestExec(this.b.a(), WeOkHttpProvider.getPathEnv() + WeOkHttpProvider.getLoginPath(isUseGm) + "?app_id=" + Param.getAppId() + "&version=" + Param.getVersion(isUseGm) + "&nonce=" + str + "&user_id=" + userId + "&sign=" + str2, j, generateAESKey, encryptAESKey, isUseGm, new WeReq.Callback<LoginRequest.LoginResponse>() { // from class: com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceLiveImpl.2
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            /* renamed from: a */
            public void onSuccess(WeReq weReq, LoginRequest.LoginResponse loginResponse) {
                ProcessCallback processCallback2;
                String str3;
                String str4;
                String str5;
                ProcessCallback processCallback3;
                String str6;
                WLogger.d("WbFaceLiveImpl", "login onSuccess");
                String str7 = WbFaceError.WBFaceErrorCodeLoginServerError;
                if (loginResponse != null) {
                    String str8 = isUseGm ? loginResponse.encryptBody : loginResponse.enMsg;
                    if (TextUtils.isEmpty(str8)) {
                        WLogger.w("WbFaceLiveImpl", "enMsg is null!" + loginResponse.code + "," + loginResponse.msg + "," + loginResponse.debugMsg);
                        processCallback2 = processCallback;
                        str3 = "enMsg is null!" + loginResponse.code + "," + loginResponse.msg + "," + loginResponse.debugMsg;
                    } else {
                        WLogger.d("WbFaceLiveImpl", "start decry response");
                        try {
                            LoginResult loginResult = (LoginResult) WbCloudNetSecurityManger.decry(isUseGm, str8, LoginResult.class, generateAESKey);
                            if (loginResult != null) {
                                WLogger.d("WbFaceLiveImpl", loginResult.toString());
                                if (TextUtils.isEmpty(loginResult.code)) {
                                    str4 = "code is null!";
                                } else if (!loginResult.code.equals("0")) {
                                    WLogger.w("WbFaceLiveImpl", "code:" + loginResult.code + "; Msg: " + loginResult.msg);
                                    processCallback3 = processCallback;
                                    str7 = loginResult.code;
                                    str5 = loginResult.code + "," + loginResult.msg;
                                    processCallback3.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainLoginServer, str7, "网络异常", str5));
                                    return;
                                } else if (TextUtils.isEmpty(loginResult.gradeCompareType)) {
                                    str6 = "gradeCompareType is null!";
                                } else {
                                    Param.setGradeCompareType(loginResult.gradeCompareType);
                                    KycWaSDK.getInstance().updateFiled_y("field_y_0", loginResult.gradeCompareType);
                                    if (TextUtils.isEmpty(loginResult.optimalGradeType)) {
                                        str6 = "optimalGradeType is null!";
                                    } else if (loginResult.csrfToken != null) {
                                        Param.setCsrfToken(loginResult.csrfToken);
                                        processCallback.onSuccess(loginResult);
                                        return;
                                    } else {
                                        str4 = "csrfToken is null!";
                                    }
                                }
                                WLogger.w("WbFaceLiveImpl", str4);
                                str5 = str4;
                                processCallback3 = processCallback;
                                processCallback3.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainLoginServer, str7, "网络异常", str5));
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            WLogger.w("WbFaceLiveImpl", "decry LoginResult failed!" + e.toString());
                            Properties properties = new Properties();
                            properties.setProperty("enKey", encryptAESKey);
                            KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f35642a, "faceservice_data_serialize_decry_fail", "decry LoginResult failed!" + e.toString(), properties);
                            processCallback2 = processCallback;
                            str3 = "decry LoginResult failed!" + e.toString();
                            str7 = WbFaceError.WBFaceErrorCodeDataSerilizerError;
                        }
                    }
                    processCallback2.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainLoginServer, str7, "网络异常", str3));
                }
                str6 = "baseResponse is null!";
                WLogger.w("WbFaceLiveImpl", str6);
                str3 = str6;
                processCallback2 = processCallback;
                processCallback2.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainLoginServer, str7, "网络异常", str3));
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFailed(WeReq weReq, WeReq.ErrType errType, int i, String str3, IOException iOException) {
                WLogger.e("WbFaceLiveImpl", "LoginRequest failed! type=" + errType + ",code=" + i + ",msg=" + str3);
                StringBuilder sb = new StringBuilder();
                sb.append(errType);
                sb.append(",");
                sb.append(i);
                sb.append("+");
                sb.append(str3);
                processCallback.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainLoginNetwork, WbFaceError.WBFaceErrorCodeLoginNetworkError, "网络异常", sb.toString()));
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFinish() {
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onStart(WeReq weReq) {
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void onEnterFaceLivePage(WbUiTips wbUiTips) {
        WLogger.d("WbFaceLiveImpl", "onEnterFaceLivePage:" + this.f);
        this.f = false;
        WLogger.d("WbFaceLiveImpl", "isGetFaceResult =" + this.f);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void onFaceStatusChanged(int i) {
        this.f35643c = i;
        if (i == 2) {
            this.h.reset();
        } else if (i == 9) {
            a();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void onPreviewFrame(byte[] bArr) {
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void onQuitFaceLivePage() {
        WLogger.d("WbFaceLiveImpl", "onQuitFaceLivePage:" + this.f);
        this.f = true;
        WLogger.d("WbFaceLiveImpl", "isGetFaceResult =" + this.f);
        this.i = null;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void onStartFaceVerify(Context context) {
        this.f35642a = context;
        this.b = d.z();
        this.d = 0;
        this.e = 0;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void startWill(FragmentManager fragmentManager, int i, WillParam willParam, WbWillVideoEncodeFinishCallback wbWillVideoEncodeFinishCallback, WbWillFinishCallback wbWillFinishCallback, WbWillProcessCallback wbWillProcessCallback) {
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void stopWill(FragmentManager fragmentManager) {
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void uploadFaceWillVideo(int i, String str, String str2, ProcessCallback processCallback) {
    }
}
